package com.obric.cae.location.geofence;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Location;
import android.net.Uri;
import android.os.UserHandle;
import android.os.UserManager;
import androidx.activity.d;
import androidx.activity.k;
import com.obric.cae.libs.location.geofence.IStarGeofenceManager;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.utils.EncryptUtil;
import com.obric.cae.location.database.StarLocationDbManager;
import com.obric.cae.location.geofence.vendor.IVendorGeoManager;
import com.obric.cae.location.geofence.vendor.VendorGeoManager;
import com.obric.cae.location.report.StarLocationReportBase;
import com.obric.cae.location.report.StarLocationReportFactory;
import com.obric.cae.location.report.StarLocationTeaReporter;
import com.obric.cae.location.util.LocationUtil;
import com.obric.cae.log.CommSenseLog;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class StarGeofenceManager {
    private static final String PACKAGE_NAME_DATA_CENTER = "datacenterservice";
    public static final int STAR_GEOFENCE_OPERATION_ADD = 1;
    public static final int STAR_GEOFENCE_OPERATION_DELETE = 2;
    public static final int STAR_GEOFENCE_OPERATION_RECOVER = 4;
    public static final int STAR_GEOFENCE_OPERATION_UPDATE = 3;
    private static final String STR_GEOFENCE_FILE = "star_geofence";
    private static final String STR_GEOFENCE_FILE_SUFFIX = ".txt";
    private static final String TAG = "StarLocation-geoManager";
    private static final ConcurrentHashMap<Integer, StarGeofenceManager> sInstances = null;
    private final StarLocationDbManager dbManager;
    private final IStarGeofenceManager.Stub iBinder;
    private final Context mContext;
    private File mGeofenceLogFile;
    private final Set<String> mUnknownStateGeofenceIds;
    private final int mUserId;
    private final PackageManager packageManager;
    private volatile boolean recoverFinishFlag;
    private final IVendorGeoManager vendorGeoManager;

    public class PackageUninstallReceiver extends BroadcastReceiver {
        private final String TAG;
        final /* synthetic */ StarGeofenceManager this$0;

        private PackageUninstallReceiver(StarGeofenceManager r8) {
            this.this$0 = r8;
            this.TAG = "StarGeofenceManager".concat(PackageUninstallReceiver.class.getSimpleName());
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r8, Intent r10) {
            if (r10 != null) goto L7;
            String r11 = this.TAG;
            String r12 = "invalid intent.";
        L4:
            CommSenseLog.e(r11, r12);
            return;
        L7:
            if ("android.intent.action.PACKAGE_FULLY_REMOVED".equalsIgnoreCase(r10.getAction()) == false) goto L29;
            Uri r13 = r10.getData();
            if (r13 != null) goto L11;
            r11 = this.TAG;
            r12 = "fail to get Uri.";
            goto L4
        L11:
            String r14 = r13.getSchemeSpecificPart();
            if (r14 != null) goto L14;
            r11 = this.TAG;
            r12 = "fail to get packageName.";
            goto L4
        L14:
            int r15 = r10.getIntExtra("android.intent.extra.UID", -1);
            if (r15 == (-1)) goto L17;
            int r16 = UserHandle.getUserId(r15);
        L19:
            if (r16 == StarGeofenceManager.access$1500(this.this$0)) goto L21;
            return;
        L21:
            List<StarGeofence> r17 = StarGeofenceManager.access$400(this.this$0).queryGeofencesByPkgName(r14);
            if (r17.isEmpty() == false) goto L24;
            return;
        L24:
            if (StarGeofenceManager.access$1600(this.this$0).contains(r14) == true) goto L32;
            CommSenseLog.dumpD(this.TAG, "receiver broadcast of package uninstall : ".concat(r14), StarGeofenceManager.access$300(this.this$0));
            Iterator<StarGeofence> r18 = r17.iterator();
        L27:
            if (r18.hasNext() == false) goto L33;
            StarGeofence r19 = r18.next();
            StarGeofenceManager.access$200(this.this$0).deleteStarGeofence(r19);
            CommSenseLog.dumpD(this.TAG, "deleteStarGeofence, id is: " + r19.getGeofenceId(), StarGeofenceManager.access$300(this.this$0));
            StarGeofenceManager.access$400(this.this$0).deleteGeofence(r14, r19.getGeofenceId());
            this.this$0.removeUnknownStateGeofence(r19.getGeofenceId());
            StarGeofenceManager.access$400(this.this$0).unregisterGeofenceCallback(r14);
            goto L27
        L33:
            return;
        L32:
            return;
        L17:
            r16 = 0;
            goto L19
        }

        public /* synthetic */ PackageUninstallReceiver(StarGeofenceManager r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StarGeofenceOperation {
    }

    static {
        sInstances = new ConcurrentHashMap();
    }

    private StarGeofenceManager(Context r8, int r10) {
        this.recoverFinishFlag = false;
        this.mUnknownStateGeofenceIds = Collections.synchronizedSet(new HashSet());
        this.iBinder = new AnonymousClass1(this);
        Context r11 = r8.getApplicationContext();
        this.mContext = r11;
        this.mUserId = r10;
        initDumpLogFile();
        CommSenseLog.dumpD(TAG, "init.", this.mGeofenceLogFile);
        this.packageManager = r11.getPackageManager();
        this.dbManager = StarLocationDbManager.getInstance(r11, r10);
        IVendorGeoManager r12 = VendorGeoManager.getInstance(r11).getManager();
        this.vendorGeoManager = r12;
        if (r12 == null) goto L7;
        startUninstallReceiver();
        return;
    L7:
        throw new UnsupportedOperationException("vendorGeoManager is null");
    }

    public static /* synthetic */ String a(String r8, boolean r10) {
        return lambda$dump$2(r10, r8);
    }

    public static /* synthetic */ void access$100(StarGeofenceManager r8) {
        r8.checkGeofenceSupport();
    }

    public static /* synthetic */ void access$1000(StarGeofenceManager r8, String r10) {
        r8.addUnknownStateGeofenceId(r10);
    }

    public static /* synthetic */ Context access$1100(StarGeofenceManager r8) {
        return r8.mContext;
    }

    public static /* synthetic */ File access$1200(StarGeofenceManager r8, int r10) {
        return r8.getStorageLogFile(r10);
    }

    public static /* synthetic */ boolean access$1300(StarGeofenceManager r8) {
        return r8.recoverFinishFlag;
    }

    public static /* synthetic */ List access$1400(StarGeofenceManager r8, String r10, boolean r11) {
        return r8.queryVisibleGeofences(r10, r11);
    }

    public static /* synthetic */ int access$1500(StarGeofenceManager r8) {
        return r8.mUserId;
    }

    public static /* synthetic */ List access$1600(StarGeofenceManager r8) {
        return r8.getAllPackageName();
    }

    public static /* synthetic */ IVendorGeoManager access$200(StarGeofenceManager r8) {
        return r8.vendorGeoManager;
    }

    public static /* synthetic */ File access$300(StarGeofenceManager r8) {
        return r8.mGeofenceLogFile;
    }

    public static /* synthetic */ StarLocationDbManager access$400(StarGeofenceManager r8) {
        return r8.dbManager;
    }

    public static /* synthetic */ boolean access$500(StarGeofenceManager r8, String r10, int r11, int r12) {
        return r8.checkPackagePidUid(r10, r11, r12);
    }

    public static /* synthetic */ StarGeofence access$600(StarGeofenceManager r8, String r10) {
        return r8.queryVisibleGeofenceById(r10);
    }

    public static /* synthetic */ void access$700(StarGeofenceManager r8, StarGeofence r10) {
        r8.setGeofenceAddress(r10);
    }

    public static /* synthetic */ int access$800(StarGeofenceManager r8, StarGeofence r10) {
        return r8.resolveGeofenceUserId(r10);
    }

    public static /* synthetic */ StarLocationDbManager access$900(StarGeofenceManager r8, int r10) {
        return r8.getStorageDbManager(r10);
    }

    private void addUnknownStateGeofenceId(String r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.isEmpty() == true) goto L9;
        this.mUnknownStateGeofenceIds.add(r8);
        return;
    }

    public static /* synthetic */ void b(StarGeofenceManager r8) {
        r8.lambda$retryGeofenceAddress$1();
    }

    public static /* synthetic */ void c(StarGeofenceManager r8) {
        lambda$getInstance$0(r8);
    }

    private void checkGeofenceSupport() {
        if (this.vendorGeoManager == null) goto L5;
        return;
    L5:
        CommSenseLog.dumpD(TAG, "vendor does not support geofence", this.mGeofenceLogFile);
        throw new UnsupportedOperationException("vendor does not support geofence");
    }

    private boolean checkPackagePidUid(String r8, int r10, int r11) {
        return true;
    }

    private boolean containsGeofenceId(List<StarGeofence> r8, String r10) {
        if (r10 == null) goto L23;
        if (r8 != null) goto L6;
        return false;
    L6:
        if (r8.isEmpty() == true) goto L25;
        Iterator<StarGeofence> r11 = r8.iterator();
    L10:
        if (r11.hasNext() == false) goto L26;
        StarGeofence r12 = r11.next();
        if (r12 == null) goto L10;
        if (r10.equals(r12.getGeofenceId()) == false) goto L10;
        return true;
    L26:
        return false;
    L25:
        return false;
    L23:
        return false;
    }

    private String encryptLog(String r8) {
        return EncryptUtil.encrypt(CommSenseLog.LOG_TAG, r8, CommSenseLog.LOG_TAG, true);
    }

    public static int findUserIdByGeofence(Context r8, String r10) {
        if (r8 == null) goto L18;
        if (r10 == null) goto L18;
        if (r10.isEmpty() == true) goto L18;
        UserManager r11 = (UserManager) r8.getSystemService("user");
        if (r11 == null) goto L17;
        Iterator<UserHandle> r12 = r11.getUserProfiles().iterator();
    L12:
        if (r12.hasNext() == false) goto L17;
        UserHandle r13 = r12.next();
        if (StarLocationDbManager.getInstance(r8, r13.getIdentifier()).queryGeofenceById(r10) == null) goto L12;
        return r13.getIdentifier();
    L17:
        StarLocationDbManager.getInstance(r8, 0).queryGeofenceById(r10);
    L18:
        return 0;
    }

    private String formatDumpGeofence(StarGeofence r8) {
        int r10 = this.dbManager.queryGeofenceUserIdById(r8.getGeofenceId());
        String r11 = r8.toString();
        return r11.substring(0, r11.length() - 1) + ", userId: " + r10 + "]";
    }

    public static ConcurrentHashMap<Integer, StarGeofenceManager> getAllInstances() {
        return sInstances;
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    private List<String> getAllPackageName() {
        ArrayList r8 = new ArrayList();
        Iterator<PackageInfo> r10 = this.packageManager.getInstalledPackages(0).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r8.add(r10.next().packageName);
        goto L4
    L6:
        return r8;
    }

    public static File getGeofenceLogFile(int r8) {
        StarGeofenceManager r10 = sInstances.get(Integer.valueOf(r8));
        if (r10 == null) goto L8;
        File r11 = r10.mGeofenceLogFile;
        if (r11 == null) goto L8;
        return r11;
    L8:
        return CommSenseLog.getRecordFile("geofence", r8);
    }

    public static synchronized StarGeofenceManager getInstance(Context r8, int r10) {
        monitor-enter(StarGeofenceManager.class);
        ConcurrentHashMap<Integer, StarGeofenceManager> r11 = sInstances;     // Catch: Throwable -> L9
        StarGeofenceManager r12 = r11.get(Integer.valueOf(r10));     // Catch: Throwable -> L9
        if (r12 != null) goto L7;
        r12 = new StarGeofenceManager(r8, r10);     // Catch: Throwable -> L9
        r11.put(Integer.valueOf(r10), r12);     // Catch: Throwable -> L9
        new Thread(new d(r12, 20), "recoverStarGeofence-" + r10).start();     // Catch: Throwable -> L9
    L7:
        monitor-exit(StarGeofenceManager.class);
        return r12;
    L9:
        th = move-exception;
        throw th;
    }

    private StarLocationDbManager getStorageDbManager(int r8) {
        if (isGlobalGeofence(r8) == false) goto L6;
        return getSystemDbManager();
    L6:
        return this.dbManager;
    }

    private File getStorageLogFile(int r8) {
        if (isGlobalGeofence(r8) == false) goto L6;
        return getGeofenceLogFile(0);
    L6:
        return this.mGeofenceLogFile;
    }

    private StarLocationDbManager getSystemDbManager() {
        if (this.mUserId != 0) goto L6;
        return this.dbManager;
    L6:
        return StarLocationDbManager.getInstance(this.mContext, 0);
    }

    private void initDumpLogFile() {
        if (this.mUserId != 0) goto L5;
        String r8 = "star_geofence.txt";
    L6:
        File r10 = new File(LocationUtil.getInstance().getStarDir(this.mContext), r8);
        r10.delete();
        r10.createNewFile();     // Catch: IOException -> L9
    L10:
        this.mGeofenceLogFile = r10;
        CommSenseLog.d(TAG, "initDumpLogFile, file: " + this.mGeofenceLogFile);
        CommSenseLog.recordFileWithKey("geofence", this.mUserId, this.mGeofenceLogFile);
        return;
    L9:
        CommSenseLog.e(TAG, "IO error occurred!");
        goto L10
    L5:
        r8 = android.aimedia.a.h(new StringBuilder("star_geofence_"), this.mUserId, STR_GEOFENCE_FILE_SUFFIX);
        goto L6
    }

    private boolean isGlobalGeofence(int r8) {
        if (r8 != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ String lambda$dump$2(boolean r8, String r10) {
        if (r8 == true) goto L4;
        return r10;
    L4:
        return CommSenseLog.decryptCaeLog(r10);
    }

    private static /* synthetic */ void lambda$getInstance$0(StarGeofenceManager r8) {
        r8.recoverStarGeofence();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CommSenseLog.e(TAG, "recoverStarGeofence: ", th);
    }

    private /* synthetic */ void lambda$retryGeofenceAddress$1() {
        List<StarGeofence> r8 = this.dbManager.queryAllGeofences();
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.isEmpty() == true) goto L35;
        Iterator<StarGeofence> r10 = r8.iterator();
    L9:
        if (r10.hasNext() == false) goto L36;
        StarGeofence r11 = r10.next();
        if (r11 == null) goto L9;
        if (r11.getAddress() == null) goto L17;
        if (r11.getAddress().isEmpty() == false) goto L9;
    L17:
        setGeofenceAddress(r11);
        if (r11.getAddress() == null) goto L9;
        if (r11.getAddress().isEmpty() == true) goto L9;
        int r12 = findUserIdByGeofence(this.mContext, r11.getGeofenceId());
        getStorageDbManager(r12).updateGeofence(r11, r12);
        CommSenseLog.dumpD(TAG, "retryGeofenceAddress update db: " + r11.getGeofenceId(), this.mGeofenceLogFile);
        goto L9
    L36:
        return;
    }

    private StarGeofence queryVisibleGeofenceById(String r8) {
        StarGeofence r10 = this.dbManager.queryGeofenceById(r8);
        if (r10 == null) goto L6;
        return r10;
    L6:
        if (this.mUserId != 0) goto L8;
        return null;
    L8:
        StarGeofence r11 = getSystemDbManager().queryGeofenceById(r8);
        if (r11 != null) goto L11;
    L13:
        return null;
    L11:
        if (getSystemDbManager().queryGeofenceUserIdById(r8) != (-1)) goto L13;
        return r11;
    }

    private List<StarGeofence> queryVisibleGeofences(String r8, boolean r10) {
        ArrayList r11 = new ArrayList();
        StarLocationDbManager r12 = this.dbManager;
        if (r10 == false) goto L5;
        List<StarGeofence> r13 = r12.queryAllGeofences();
    L6:
        if (r13 == null) goto L11;
        if (r13.isEmpty() == true) goto L11;
        r11.addAll(r13);
    L11:
        if (this.mUserId != 0) goto L13;
        return r11;
    L13:
        if (r10 == false) goto L15;
        List<StarGeofence> r14 = getSystemDbManager().queryAllGeofences();
    L16:
        if (r14 != null) goto L18;
    L31:
        return r11;
    L18:
        if (r14.isEmpty() == true) goto L31;
        Iterator<StarGeofence> r15 = r14.iterator();
    L22:
        if (r15.hasNext() == false) goto L31;
        StarGeofence r16 = r15.next();
        if (r16 == null) goto L22;
        if (getSystemDbManager().queryGeofenceUserIdById(r16.getGeofenceId()) != (-1)) goto L22;
        if (containsGeofenceId(r11, r16.getGeofenceId()) == true) goto L22;
        r11.add(r16);
        goto L22
    L15:
        r14 = getSystemDbManager().queryGeofencesByPkgName(r8);
        goto L16
    L5:
        r13 = r12.queryGeofencesByPkgName(r8);
        goto L6
    }

    @SuppressLint({"InlinedApi"})
    private void recoverStarGeofence() {
        IStarGeofenceManager.Stub r8 = this.iBinder;
        monitor-enter(r8);
    L52:
        th = move-exception;
        throw th;
    L5:
        if (this.recoverFinishFlag == false) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L52
        return;
    L8:
        CommSenseLog.dumpD(TAG, "recover StarGeofence", this.mGeofenceLogFile);     // Catch: Throwable -> L52
        List<StarGeofence> r10 = this.dbManager.queryAllGeofences();     // Catch: Throwable -> L52
        if (r10 != null) goto L11;
    L49:
        this.recoverFinishFlag = true;     // Catch: Throwable -> L52
        monitor-exit(r8);     // Catch: Throwable -> L52
        return;
    L11:
        if (r10.isEmpty() == true) goto L49;
        List<String> r11 = getAllPackageName();     // Catch: Throwable -> L52
        Iterator<StarGeofence> r12 = r10.iterator();     // Catch: Throwable -> L52
        this.mUnknownStateGeofenceIds.clear();     // Catch: Throwable -> L52
    L15:
        if (r12.hasNext() == false) goto L19;
        StarGeofence r13 = r12.next();     // Catch: Throwable -> L52
        if (r11.contains(r13.getPackageName()) == true) goto L15;
        r12.remove();     // Catch: Throwable -> L52
        this.dbManager.deleteGeofence(r13.getPackageName(), r13.getGeofenceId());     // Catch: Throwable -> L52
        goto L15
    L19:
        long r14 = System.currentTimeMillis();     // Catch: Throwable -> L52
        Iterator<StarGeofence> r15 = r10.iterator();     // Catch: Throwable -> L52
    L21:
        if (r15.hasNext() == false) goto L42;
        StarGeofence r16 = r15.next();     // Catch: Throwable -> L52
        if (r16 == null) goto L21;
        if (r16.getGeoState() != StarGeofence.GeoState.UNKNOWN) goto L28;
        addUnknownStateGeofenceId(r16.getGeofenceId());     // Catch: Throwable -> L52
    L28:
        int r17 = resolveGeofenceUserId(r16);     // Catch: Throwable -> L52
        if (r16.getAddress() != null) goto L31;
    L32:
        setGeofenceAddress(r16);     // Catch: Throwable -> L52
        if (r16.getAddress() != null) goto L35;
    L37:
        StarLocationReportBase r18 = StarLocationReportFactory.getReportInstance();     // Catch: Throwable -> L52
        if (r18 == null) goto L40;
        r18.recordStarGeofenceEvent(r14, r16, 4);     // Catch: Throwable -> L52
    L40:
        StarLocationTeaReporter.reportGeofenceEvent(r14, r16, 4);     // Catch: Throwable -> L52
        goto L21
    L35:
        if (r16.getAddress().isEmpty() == true) goto L37;
        getStorageDbManager(r17).updateGeofence(r16, r17);     // Catch: Throwable -> L52
        goto L37
    L31:
        if (r16.getAddress().isEmpty() == false) goto L37;
    L42:
        if (this.vendorGeoManager.syncStarGeofence(r10) == 0) goto L46;
        CommSenseLog.e(TAG, "vendorGeoManager syncStarGeofence failed.");     // Catch: Throwable -> L52
        monitor-exit(r8);     // Catch: Throwable -> L52
        return;
    L46:
        this.recoverFinishFlag = true;     // Catch: Throwable -> L52
        CommSenseLog.dumpD(TAG, "sync " + r10.size() + " starGeofence to vendor", this.mGeofenceLogFile);     // Catch: Throwable -> L52
        LocationUtil.getInstance().getCurLocation("network", true, CommSenseLog.getMethodName());     // Catch: Throwable -> L52
        monitor-exit(r8);     // Catch: Throwable -> L52
    }

    private void removeUnknownStateGeofenceId(String r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.isEmpty() == true) goto L9;
        this.mUnknownStateGeofenceIds.remove(r8);
        return;
    }

    private int resolveGeofenceUserId(StarGeofence r8) {
        if (r8 != null) goto L6;
        return 0;
    L6:
        if (r8.getGeoType() != StarGeofence.GeoType.TRAFFIC) goto L8;
        int r10 = -1;
    L9:
        CommSenseLog.vWithMethodName(TAG, "geofenceIvd=" + r8.getGeofenceId() + ", resolvedUserId=" + r10 + ", geoType=" + r8.getGeoType() + ", userId=" + r10);
        return r10;
    L8:
        r10 = this.mUserId;
        goto L9
    }

    private void setGeofenceAddress(StarGeofence r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.getAddress() == null) goto L10;
        if (r8.getAddress().isEmpty() == true) goto L10;
        return;
    L10:
        if (LocationUtil.getInstance().isNetworkValid() == true) goto L12;
        return;
    L12:
        Location r10 = new Location("network");
        r10.setLatitude(r8.getLatitude());
        r10.setLongitude(r8.getLongitude());
        r10.setAccuracy(r8.getRadius());
        List<Address> r11 = LocationUtil.getInstance().resolveAddressByLocation(r10, false);
        if (r11 != null) goto L15;
        return;
    L15:
        if (r11.isEmpty() == true) goto L19;
        r8.setAddress(r11.get(0).getAddressLine(0));
        return;
    }

    private boolean shouldDumpGeofence(StarGeofence r8) {
        int r10 = this.dbManager.queryGeofenceUserIdById(r8.getGeofenceId());
        int r11 = this.mUserId;
        if (r11 != 0) goto L10;
        if (r10 != 0) goto L6;
        return true;
    L6:
        if (r10 != (-1)) goto L9;
        return true;
    L9:
        return false;
    L10:
        if (r10 != r11) goto L13;
        return true;
    L13:
        return false;
    }

    private void startUninstallReceiver() {
        PackageUninstallReceiver r8 = new PackageUninstallReceiver(this, null);
        IntentFilter r10 = new IntentFilter();
        r10.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");
        r10.addDataScheme("package");
        this.mContext.registerReceiver(r8, r10);
    }

    public void dump(PrintWriter r8, String[] r10) {
        final boolean r11 = false;
        if (r10.length > 0) goto L5;
    L7:
        String r12 = "Saved Geofence:";
        if (r11 == true) goto L11;
        r12 = CommSenseLog.encryptCaeLog("Saved Geofence:");
    L11:
        r8.println(r12);
        List<StarGeofence> r13 = this.dbManager.queryAllGeofences();
        LinkedHashSet r14 = new LinkedHashSet();
        Iterator<StarGeofence> r15 = r13.iterator();
    L13:
        if (r15.hasNext() == false) goto L28;
        StarGeofence r16 = r15.next();
        if (r16 == null) goto L13;
        if (shouldDumpGeofence(r16) == false) goto L13;
        String r17 = formatDumpGeofence(r16);
        if (r11 == true) goto L23;
        r17 = CommSenseLog.encryptCaeLog(r17);
    L23:
        r8.println(r17);
        if (r16.getPoiId() == null) goto L13;
        if (r16.getPoiId().isEmpty() == true) goto L13;
        r14.add(r16.getPoiId());
        goto L13
    L28:
        r8.println("Geofence Log:");
        CommSenseLog.dumpFileContent(this.mGeofenceLogFile, r8, new b(r11));
        return;
    L5:
        if ("--NeedDecrypt".equalsIgnoreCase(r10[0]) == false) goto L7;
        r11 = true;
        goto L7
    }

    public IStarGeofenceManager getBinder() {
        return this.iBinder;
    }

    public boolean hasUnknownStateGeofence(int r8) {
        if (r8 >= 0) goto L6;
        r8 = 0;
    L6:
        ConcurrentHashMap<Integer, StarGeofenceManager> r10 = sInstances;
        StarGeofenceManager r11 = r10.get(Integer.valueOf(r8));
        if (r11 != null) goto L9;
    L11:
        if (r8 != 0) goto L13;
        return false;
    L13:
        StarGeofenceManager r12 = r10.get(0);
        if (r12 != null) goto L16;
        return false;
    L16:
        if (r12.mUnknownStateGeofenceIds.isEmpty() == false) goto L18;
        return false;
    L18:
        return true;
    L9:
        if (r11.mUnknownStateGeofenceIds.isEmpty() == true) goto L11;
        return true;
    }

    public void removeUnknownStateGeofence(String r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.isEmpty() == true) goto L18;
        Iterator<StarGeofenceManager> r10 = sInstances.values().iterator();
    L8:
        if (r10.hasNext() == false) goto L19;
        StarGeofenceManager r11 = r10.next();
        if (r11 == null) goto L8;
        r11.removeUnknownStateGeofenceId(r8);
        goto L8
    L19:
        return;
    }

    public void retryGeofenceAddress() {
        IStarGeofenceManager.Stub r8 = this.iBinder;
        monitor-enter(r8);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.recoverFinishFlag == true) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L8:
        monitor-exit(r8);     // Catch: Throwable -> L11
        LocationUtil.getInstance().getExecutor().execute(new k(this, 16));
    }
}
