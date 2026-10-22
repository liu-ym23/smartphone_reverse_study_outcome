package com.obric.cae.location.geofence;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Location;
import android.net.Uri;
import android.os.UserHandle;
import android.os.UserManager;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.location.geofence.b;
import com.obric.cae.location.database.c;
import com.obric.cae.location.geofence.vendor.IVendorGeoManager;
import com.obric.cae.location.geofence.vendor.VendorGeoManager;
import com.obric.cae.location.util.d;
import com.obric.cae.log.a;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class StarGeofenceManager {
    public static final String DYNAMIC_GEOFENCE_ID_PREFIX = "dynamic_geofence_id_";
    private static final String KEY_DELETE_DYNAMIC_GEOFENCE = "delete_dynamic_geofence";
    private static final String PACKAGE_NAME_DATA_CENTER = "datacenterservice";
    private static final long RECENT_APPLIED_LOCATION_MAX_AGE_MS = 0;
    public static final int STAR_GEOFENCE_OPERATION_ADD = 1;
    public static final int STAR_GEOFENCE_OPERATION_DELETE = 2;
    public static final int STAR_GEOFENCE_OPERATION_RECOVER = 4;
    public static final int STAR_GEOFENCE_OPERATION_UPDATE = 3;
    private static final String STR_GEOFENCE_FILE = "star_geofence";
    private static final String STR_GEOFENCE_FILE_SUFFIX = ".txt";
    private static final String TAG = "StarLocation-geoManager";
    private static final ConcurrentHashMap<Integer, StarGeofenceManager> sInstances = null;
    private final c dbManager;
    private final b.a iBinder;
    private final Context mContext;
    private File mGeofenceLogFile;
    private final Set<String> mUnknownStateGeofenceIds;
    private final int mUserId;
    private final PackageManager packageManager;
    private volatile boolean recoverFinishFlag;
    private final IVendorGeoManager vendorGeoManager;

    public class PackageUninstallReceiver extends PluginBroadcastReceiver {
        private final String TAG;
        final /* synthetic */ StarGeofenceManager this$0;

        private PackageUninstallReceiver(StarGeofenceManager r2) {
            this.this$0 = r2;
            this.TAG = "StarGeofenceManager".concat(PackageUninstallReceiver.class.getSimpleName());
        }

        public /* synthetic */ PackageUninstallReceiver(StarGeofenceManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void onReceive(Context r6, Intent r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L8;
            String r5 = this.TAG;
            String r9 = "invalid intent.";
        L5:
            a.i(r5, r9);
            return;
        L8:
            if ("android.intent.action.PACKAGE_FULLY_REMOVED".equalsIgnoreCase(r7.getAction()) == false) goto L30;
            Uri r10 = r7.getData();
            if (r10 != null) goto L12;
            r5 = this.TAG;
            r9 = "fail to get Uri.";
            goto L5
        L12:
            String r11 = r10.getSchemeSpecificPart();
            if (r11 != null) goto L15;
            r5 = this.TAG;
            r9 = "fail to get packageName.";
            goto L5
        L15:
            int r12 = r7.getIntExtra("android.intent.extra.UID", -1);
            if (r12 == (-1)) goto L18;
            int r13 = UserHandle.getUserId(r12);
        L20:
            if (r13 == StarGeofenceManager.access$1600(this.this$0)) goto L22;
            return;
        L22:
            List<StarGeofence> r14 = StarGeofenceManager.access$400(this.this$0).f(r11);
            if (r14.isEmpty() == false) goto L25;
            return;
        L25:
            if (StarGeofenceManager.access$1700(this.this$0).contains(r11) == true) goto L33;
            a.b(this.TAG, "receiver broadcast of package uninstall : ".concat(r11), StarGeofenceManager.access$300(this.this$0));
            Iterator<StarGeofence> r15 = r14.iterator();
        L28:
            if (r15.hasNext() == false) goto L34;
            StarGeofence r0 = (StarGeofence) ZeusTransformUtils.preCheckCast(r15.next(), StarGeofence.class, "com.obric.memorydata.plugin");
            StarGeofenceManager.access$200(this.this$0).deleteStarGeofence(r0);
            a.b(this.TAG, "deleteStarGeofence, id is: " + r0.getGeofenceId(), StarGeofenceManager.access$300(this.this$0));
            StarGeofenceManager.access$400(this.this$0).b(r11, r0.getGeofenceId());
            this.this$0.removeUnknownStateGeofence(r0.getGeofenceId());
            StarGeofenceManager.access$400(this.this$0).b(r11);
            goto L28
        L34:
            return;
        L33:
            return;
        L18:
            r13 = 0;
            goto L20
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StarGeofenceOperation {
    }

    static {
        RECENT_APPLIED_LOCATION_MAX_AGE_MS = TimeUnit.SECONDS.toMillis(30);
        sInstances = new ConcurrentHashMap();
    }

    private StarGeofenceManager(Context r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.recoverFinishFlag = false;
        this.mUnknownStateGeofenceIds = Collections.synchronizedSet(new HashSet());
        this.iBinder = new AnonymousClass1(this);
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        this.mContext = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.mUserId = r5;
        initDumpLogFile();
        a.b(TAG, "init.", this.mGeofenceLogFile);
        this.packageManager = r7.getPackageManager();
        this.dbManager = c.a(r7, r5);
        IVendorGeoManager r8 = VendorGeoManager.getInstance(r7).getManager();
        this.vendorGeoManager = r8;
        if (r8 == null) goto L7;
        startUninstallReceiver();
        return;
    L7:
        throw new UnsupportedOperationException("vendorGeoManager is null");
    }

    public static /* synthetic */ void access$100(StarGeofenceManager r0) {
        r0.checkGeofenceSupport();
    }

    public static /* synthetic */ void access$1000(StarGeofenceManager r0, String r1) {
        r0.addUnknownStateGeofenceId(r1);
    }

    public static /* synthetic */ void access$1100(StarGeofenceManager r0, String r1) {
        r0.refreshGeofenceEventsByLocation(r1);
    }

    public static /* synthetic */ Context access$1200(StarGeofenceManager r0) {
        return r0.mContext;
    }

    public static /* synthetic */ File access$1300(StarGeofenceManager r0, int r1) {
        return r0.getStorageLogFile(r1);
    }

    public static /* synthetic */ boolean access$1400(StarGeofenceManager r0) {
        return r0.recoverFinishFlag;
    }

    public static /* synthetic */ List access$1500(StarGeofenceManager r0, String r1, boolean r2) {
        return r0.queryVisibleGeofences(r1, r2);
    }

    public static /* synthetic */ int access$1600(StarGeofenceManager r0) {
        return r0.mUserId;
    }

    public static /* synthetic */ List access$1700(StarGeofenceManager r0) {
        return r0.getAllPackageName();
    }

    public static /* synthetic */ IVendorGeoManager access$200(StarGeofenceManager r0) {
        return r0.vendorGeoManager;
    }

    public static /* synthetic */ File access$300(StarGeofenceManager r0) {
        return r0.mGeofenceLogFile;
    }

    public static /* synthetic */ c access$400(StarGeofenceManager r0) {
        return r0.dbManager;
    }

    public static /* synthetic */ boolean access$500(StarGeofenceManager r0, String r1, int r2, int r3) {
        return r0.checkPackagePidUid(r1, r2, r3);
    }

    public static /* synthetic */ StarGeofence access$600(StarGeofenceManager r0, String r1) {
        return r0.queryVisibleGeofenceById(r1);
    }

    public static /* synthetic */ void access$700(StarGeofenceManager r0, StarGeofence r1) {
        r0.setGeofenceAddress(r1);
    }

    public static /* synthetic */ int access$800(StarGeofenceManager r0, StarGeofence r1) {
        return r0.resolveGeofenceUserId(r1);
    }

    public static /* synthetic */ c access$900(StarGeofenceManager r0, int r1) {
        return r0.getStorageDbManager(r1);
    }

    private void addUnknownStateGeofenceId(String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isEmpty() == true) goto L9;
        this.mUnknownStateGeofenceIds.add(r2);
        return;
    }

    private void checkGeofenceSupport() {
        if (this.vendorGeoManager == null) goto L5;
        return;
    L5:
        a.b(TAG, "vendor does not support geofence", this.mGeofenceLogFile);
        throw new UnsupportedOperationException("vendor does not support geofence");
    }

    private boolean checkPackagePidUid(String r1, int r2, int r3) {
        return true;
    }

    private boolean containsGeofenceId(List<StarGeofence> r4, String r5) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L17;
        if (r3 == null) goto L17;
        if (r3.isEmpty() == true) goto L17;
        Iterator r6 = r3.iterator();
    L10:
        if (r6.hasNext() == false) goto L17;
        StarGeofence r1 = (StarGeofence) ZeusTransformUtils.preCheckCast(r6.next(), StarGeofence.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L10;
        if (r5.equals(r1.getGeofenceId()) == false) goto L10;
        return true;
    L17:
        return false;
    }

    private void deleteDynamicGeofencesIfNeeded() {
        int r2 = 0;
        SharedPreferences r0 = this.mContext.getSharedPreferences("star_location_sp", 0);
        if (r0.getInt(KEY_DELETE_DYNAMIC_GEOFENCE, 0) == 0) goto L5;
        return;
    L5:
        LinkedHashSet r3 = new LinkedHashSet();
        r3.add(0);
        r3.add(Integer.valueOf(this.mUserId));
        UserManager r4 = (UserManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService("user"), UserManager.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L11;
        Iterator<UserHandle> r5 = r4.getUserProfiles().iterator();
    L9:
        if (r5.hasNext() == false) goto L11;
        r3.add(Integer.valueOf(((UserHandle) ZeusTransformUtils.preCheckCast(r5.next(), UserHandle.class, "com.obric.memorydata.plugin")).getIdentifier()));
    L11:
        Iterator r6 = r3.iterator();
    L13:
        if (r6.hasNext() == false) goto L25;
        c r7 = c.a(this.mContext, ((Integer) ZeusTransformUtils.preCheckCast(r6.next(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        Iterator<StarGeofence> r8 = r7.a().iterator();
    L16:
        if (r8.hasNext() == false) goto L13;
        StarGeofence r9 = (StarGeofence) ZeusTransformUtils.preCheckCast(r8.next(), StarGeofence.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L16;
        String r10 = r9.getGeofenceId();
        if (r10 == null) goto L16;
        if (r10.startsWith(DYNAMIC_GEOFENCE_ID_PREFIX) == false) goto L16;
        r7.b(r9.getPackageName(), r10);
        r2 = r2 + 1;
        goto L16
    L25:
        a.c(TAG, "delete dynamic geofence finished, deletedCount=" + r2 + ", saved=" + r0.edit().putInt(KEY_DELETE_DYNAMIC_GEOFENCE, 1).commit());
    }

    private String encryptLog(String r2) {
        return com.obric.cae.libs.utils.c.a("CommSenseLog", r2, "CommSenseLog", true);
    }

    public static int findUserIdByGeofence(Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L18;
        if (r6 == null) goto L18;
        if (r6.isEmpty() == true) goto L18;
        UserManager r2 = (UserManager) ZeusTransformUtils.preCheckCast(r7.getSystemService("user"), UserManager.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L17;
        Iterator<UserHandle> r3 = r2.getUserProfiles().iterator();
    L12:
        if (r3.hasNext() == false) goto L17;
        UserHandle r4 = (UserHandle) ZeusTransformUtils.preCheckCast(r3.next(), UserHandle.class, "com.obric.memorydata.plugin");
        if (c.a(r7, r4.getIdentifier()).d(r6) == null) goto L12;
        return r4.getIdentifier();
    L17:
        c.a(r7, 0).d(r6);
    L18:
        return 0;
    }

    private String formatDumpGeofence(StarGeofence r4) {
        int r3 = this.dbManager.e(r4.getGeofenceId());
        String r5 = r4.toString();
        return r5.substring(0, r5.length() - 1) + ", userId: " + r3 + "]";
    }

    public static ConcurrentHashMap<Integer, StarGeofenceManager> getAllInstances() {
        return sInstances;
    }

    private List<String> getAllPackageName() {
        ArrayList r0 = new ArrayList();
        Iterator<PackageInfo> r4 = this.packageManager.getInstalledPackages(0).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(((PackageInfo) ZeusTransformUtils.preCheckCast(r4.next(), PackageInfo.class, "com.obric.memorydata.plugin")).packageName);
        goto L4
    L6:
        return r0;
    }

    public static File getGeofenceLogFile(int r3) {
        StarGeofenceManager r0 = (StarGeofenceManager) ZeusTransformUtils.preCheckCast(sInstances.get(Integer.valueOf(r3)), StarGeofenceManager.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        File r1 = r0.mGeofenceLogFile;
        if (r1 == null) goto L8;
        return r1;
    L8:
        return a.a("geofence", r3);
    }

    public static synchronized StarGeofenceManager getInstance(Context r5, int r6) {
        monitor-enter(StarGeofenceManager.class);
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        ConcurrentHashMap<Integer, StarGeofenceManager> r1 = sInstances;     // Catch: Throwable -> L9
        final StarGeofenceManager r2 = (StarGeofenceManager) ZeusTransformUtils.preCheckCast(r1.get(Integer.valueOf(r6)), StarGeofenceManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r2 != null) goto L7;
        r2 = new StarGeofenceManager(r7, r6);     // Catch: Throwable -> L9
        r1.put(Integer.valueOf(r6), r2);     // Catch: Throwable -> L9
        new Thread(new $$Lambda$StarGeofenceManager$nW6GaEe5EjUxy_pUdrIhtu9Z5o(r2), "recoverStarGeofence-" + r6).start();     // Catch: Throwable -> L9
    L7:
        monitor-exit(StarGeofenceManager.class);
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    private c getStorageDbManager(int r1) {
        if (isGlobalGeofence(r1) == false) goto L6;
        return getSystemDbManager();
    L6:
        return this.dbManager;
    }

    private File getStorageLogFile(int r1) {
        if (isGlobalGeofence(r1) == false) goto L6;
        return getGeofenceLogFile(0);
    L6:
        return this.mGeofenceLogFile;
    }

    private c getSystemDbManager() {
        if (this.mUserId != 0) goto L6;
        return this.dbManager;
    L6:
        return c.a(this.mContext, 0);
    }

    private void initDumpLogFile() {
        if (this.mUserId != 0) goto L5;
        String r1 = "star_geofence.txt";
    L6:
        File r2 = new File(d.a().b(this.mContext), r1);
        r2.delete();
        r2.createNewFile();     // Catch: IOException -> L9
    L10:
        this.mGeofenceLogFile = r2;
        a.c(TAG, "initDumpLogFile, file: " + this.mGeofenceLogFile);
        a.a("geofence", this.mUserId, this.mGeofenceLogFile);
        return;
    L9:
        a.i(TAG, "IO error occurred!");
        goto L10
    L5:
        r1 = "star_geofence_" + this.mUserId + STR_GEOFENCE_FILE_SUFFIX;
        goto L6
    }

    private boolean isGlobalGeofence(int r1) {
        if (r1 != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ String lambda$dump$3(boolean r0, String r1) {
        if (r0 == true) goto L4;
        return r1;
    L4:
        return a.d(r1);
    }

    static /* synthetic */ void lambda$getInstance$0(StarGeofenceManager r2) {
        r2.recoverStarGeofence();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        a.a(TAG, "recoverStarGeofence: ", th);
    }

    private StarGeofence queryVisibleGeofenceById(String r3) {
        StarGeofence r0 = this.dbManager.d(r3);
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.mUserId != 0) goto L8;
        return null;
    L8:
        StarGeofence r1 = getSystemDbManager().d(r3);
        if (r1 != null) goto L11;
    L13:
        return null;
    L11:
        if (getSystemDbManager().e(r3) != (-1)) goto L13;
        return r1;
    }

    private List<StarGeofence> queryVisibleGeofences(String r4, boolean r5) {
        ArrayList r0 = new ArrayList();
        c r1 = this.dbManager;
        if (r5 == false) goto L5;
        List<StarGeofence> r2 = r1.a();
    L6:
        if (r2 == null) goto L11;
        if (r2.isEmpty() == true) goto L11;
        r0.addAll(r2);
    L11:
        if (this.mUserId != 0) goto L13;
        return r0;
    L13:
        if (r5 == false) goto L15;
        List<StarGeofence> r6 = getSystemDbManager().a();
    L16:
        if (r6 != null) goto L18;
    L31:
        return r0;
    L18:
        if (r6.isEmpty() == true) goto L31;
        Iterator<StarGeofence> r7 = r6.iterator();
    L22:
        if (r7.hasNext() == false) goto L31;
        StarGeofence r8 = (StarGeofence) ZeusTransformUtils.preCheckCast(r7.next(), StarGeofence.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L22;
        if (getSystemDbManager().e(r8.getGeofenceId()) != (-1)) goto L22;
        if (containsGeofenceId(r0, r8.getGeofenceId()) == true) goto L22;
        r0.add(r8);
        goto L22
    L15:
        r6 = getSystemDbManager().f(r4);
        goto L16
    L5:
        r2 = r1.f(r4);
        goto L6
    }

    private void recoverStarGeofence() {
        b.a r0 = this.iBinder;
        monitor-enter(r0);
    L52:
        th = move-exception;
        throw th;
    L5:
        if (this.recoverFinishFlag == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L52
        return;
    L8:
        a.b(TAG, "recover StarGeofence", this.mGeofenceLogFile);     // Catch: Throwable -> L52
        deleteDynamicGeofencesIfNeeded();     // Catch: Throwable -> L52
        List<StarGeofence> r1 = this.dbManager.a();     // Catch: Throwable -> L52
        if (r1 != null) goto L11;
    L49:
        this.recoverFinishFlag = true;     // Catch: Throwable -> L52
        monitor-exit(r0);     // Catch: Throwable -> L52
        return;
    L11:
        if (r1.isEmpty() == true) goto L49;
        List<String> r3 = getAllPackageName();     // Catch: Throwable -> L52
        Iterator<StarGeofence> r4 = r1.iterator();     // Catch: Throwable -> L52
        this.mUnknownStateGeofenceIds.clear();     // Catch: Throwable -> L52
    L15:
        if (r4.hasNext() == false) goto L19;
        StarGeofence r5 = (StarGeofence) ZeusTransformUtils.preCheckCast(r4.next(), StarGeofence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L52
        if (r3.contains(r5.getPackageName()) == true) goto L15;
        r4.remove();     // Catch: Throwable -> L52
        this.dbManager.b(r5.getPackageName(), r5.getGeofenceId());     // Catch: Throwable -> L52
        goto L15
    L19:
        long r6 = System.currentTimeMillis();     // Catch: Throwable -> L52
        Iterator<StarGeofence> r7 = r1.iterator();     // Catch: Throwable -> L52
    L21:
        if (r7.hasNext() == false) goto L42;
        StarGeofence r8 = (StarGeofence) ZeusTransformUtils.preCheckCast(r7.next(), StarGeofence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L52
        if (r8 == null) goto L21;
        if (r8.getGeoState() != StarGeofence.GeoState.UNKNOWN) goto L28;
        addUnknownStateGeofenceId(r8.getGeofenceId());     // Catch: Throwable -> L52
    L28:
        int r9 = resolveGeofenceUserId(r8);     // Catch: Throwable -> L52
        if (r8.getAddress() != null) goto L31;
    L32:
        setGeofenceAddress(r8);     // Catch: Throwable -> L52
        if (r8.getAddress() != null) goto L35;
    L37:
        com.obric.cae.location.report.a r10 = com.obric.cae.location.report.b.a();     // Catch: Throwable -> L52
        if (r10 == null) goto L40;
        r10.a(r6, r8, 4);     // Catch: Throwable -> L52
    L40:
        com.obric.cae.location.report.d.a(r6, r8, 4);     // Catch: Throwable -> L52
        goto L21
    L35:
        if (r8.getAddress().isEmpty() == true) goto L37;
        getStorageDbManager(r9).b(r8, r9);     // Catch: Throwable -> L52
        goto L37
    L31:
        if (r8.getAddress().isEmpty() == false) goto L37;
    L42:
        if (this.vendorGeoManager.syncStarGeofence(r1) == 0) goto L46;
        a.i(TAG, "vendorGeoManager syncStarGeofence failed.");     // Catch: Throwable -> L52
        monitor-exit(r0);     // Catch: Throwable -> L52
        return;
    L46:
        this.recoverFinishFlag = true;     // Catch: Throwable -> L52
        a.b(TAG, "sync " + r1.size() + " starGeofence to vendor", this.mGeofenceLogFile);     // Catch: Throwable -> L52
        refreshGeofenceEventsByLocation("network");     // Catch: Throwable -> L52
        monitor-exit(r0);     // Catch: Throwable -> L52
    }

    private void refreshGeofenceEventsByLocation(String r5) {
        final com.obric.cae.location.a r0 = com.obric.cae.location.a.a();
        final com.obric.cae.location.a.C0349a r1 = r0.a(RECENT_APPLIED_LOCATION_MAX_AGE_MS);
        if (r1 != null) goto L6;
        d.a().a(r5, true, a.a());
        return;
    L6:
        final Location r6 = r0.e(r1);
        d.a().r().execute(new $$Lambda$StarGeofenceManager$K8feb9CGPBcwtSPm0Jvjzs5vDg(this, r0, r6, r1));
    }

    private void removeUnknownStateGeofenceId(String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isEmpty() == true) goto L9;
        this.mUnknownStateGeofenceIds.remove(r2);
        return;
    }

    private int resolveGeofenceUserId(StarGeofence r3) {
        if (r3 != null) goto L6;
        return 0;
    L6:
        if (r3.getGeoType() != StarGeofence.GeoType.TRAFFIC) goto L8;
        int r2 = -1;
    L9:
        a.b(TAG, "geofenceIvd=" + r3.getGeofenceId() + ", resolvedUserId=" + r2 + ", geoType=" + r3.getGeoType() + ", userId=" + r2);
        return r2;
    L8:
        r2 = this.mUserId;
        goto L9
    }

    private void setGeofenceAddress(StarGeofence r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.getAddress() == null) goto L10;
        if (r4.getAddress().isEmpty() == true) goto L10;
        return;
    L10:
        if (d.a().e() == true) goto L12;
        return;
    L12:
        Location r3 = new Location("network");
        r3.setLatitude(r4.getLatitude());
        r3.setLongitude(r4.getLongitude());
        r3.setAccuracy(r4.getRadius());
        List<Address> r5 = d.a().a(r3, false);
        if (r5 != null) goto L15;
        return;
    L15:
        if (r5.isEmpty() == true) goto L19;
        r4.setAddress(((Address) ZeusTransformUtils.preCheckCast(r5.get(0), Address.class, "com.obric.memorydata.plugin")).getAddressLine(0));
        return;
    }

    private boolean shouldDumpGeofence(StarGeofence r3) {
        int r4 = this.dbManager.e(r3.getGeofenceId());
        int r2 = this.mUserId;
        if (r2 != 0) goto L10;
        if (r4 != 0) goto L6;
        return true;
    L6:
        if (r4 != (-1)) goto L9;
        return true;
    L9:
        return false;
    L10:
        if (r4 != r2) goto L13;
        return true;
    L13:
        return false;
    }

    private void startUninstallReceiver() {
        PackageUninstallReceiver r0 = new PackageUninstallReceiver(this, null);
        IntentFilter r1 = new IntentFilter();
        r1.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");
        r1.addDataScheme("package");
        ZeusTransformUtils.registerReceiver(this.mContext, r0, r1, "com.obric.memorydata.plugin");
    }

    public void dump(PrintWriter r6, String[] r7) {
        final boolean r1 = false;
        if (r7.length > 0) goto L5;
    L7:
        String r8 = "Saved Geofence:";
        if (r1 == true) goto L11;
        r8 = a.c("Saved Geofence:");
    L11:
        r6.println(r8);
        List<StarGeofence> r9 = this.dbManager.a();
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator<StarGeofence> r10 = r9.iterator();
    L13:
        if (r10.hasNext() == false) goto L28;
        StarGeofence r2 = (StarGeofence) ZeusTransformUtils.preCheckCast(r10.next(), StarGeofence.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L13;
        if (shouldDumpGeofence(r2) == false) goto L13;
        String r3 = formatDumpGeofence(r2);
        if (r1 == true) goto L23;
        r3 = a.c(r3);
    L23:
        r6.println(r3);
        if (r2.getPoiId() == null) goto L13;
        if (r2.getPoiId().isEmpty() == true) goto L13;
        r0.add(r2.getPoiId());
        goto L13
    L28:
        r6.println("Geofence Log:");
        a.a(this.mGeofenceLogFile, r6, new $$Lambda$StarGeofenceManager$rEb8cu5fAnQbFHO_dJhT3fyM5pM(r1));
        return;
    L5:
        if ("--NeedDecrypt".equalsIgnoreCase(r7[0]) == false) goto L7;
        r1 = true;
        goto L7
    }

    public b getBinder() {
        return this.iBinder;
    }

    public boolean hasUnknownStateGeofence(int r6) {
        if (r6 >= 0) goto L6;
        r6 = 0;
    L6:
        ConcurrentHashMap<Integer, StarGeofenceManager> r1 = sInstances;
        StarGeofenceManager r2 = (StarGeofenceManager) ZeusTransformUtils.preCheckCast(r1.get(Integer.valueOf(r6)), StarGeofenceManager.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L9;
    L11:
        if (r6 != 0) goto L13;
        return false;
    L13:
        StarGeofenceManager r5 = (StarGeofenceManager) ZeusTransformUtils.preCheckCast(r1.get(0), StarGeofenceManager.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L16;
        return false;
    L16:
        if (r5.mUnknownStateGeofenceIds.isEmpty() == false) goto L18;
        return false;
    L18:
        return true;
    L9:
        if (r2.mUnknownStateGeofenceIds.isEmpty() == true) goto L11;
        return true;
    }

    public /* synthetic */ void lambda$refreshGeofenceEventsByLocation$1$StarGeofenceManager(com.obric.cae.location.a r1, Location r2, com.obric.cae.location.a.C0349a r3) {
        r1.a(r2, this.mUserId, r3.b());
    }

    public /* synthetic */ void lambda$retryGeofenceAddress$2$StarGeofenceManager() {
        List<StarGeofence> r0 = this.dbManager.a();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L35;
        Iterator<StarGeofence> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L36;
        StarGeofence r2 = (StarGeofence) ZeusTransformUtils.preCheckCast(r1.next(), StarGeofence.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        if (r2.getAddress() == null) goto L17;
        if (r2.getAddress().isEmpty() == false) goto L9;
    L17:
        setGeofenceAddress(r2);
        if (r2.getAddress() == null) goto L9;
        if (r2.getAddress().isEmpty() == true) goto L9;
        int r3 = findUserIdByGeofence(this.mContext, r2.getGeofenceId());
        getStorageDbManager(r3).b(r2, r3);
        a.b(TAG, "retryGeofenceAddress update db: " + r2.getGeofenceId(), this.mGeofenceLogFile);
        goto L9
    L36:
        return;
    }

    public void removeUnknownStateGeofence(String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.isEmpty() == true) goto L18;
        Iterator<StarGeofenceManager> r3 = sInstances.values().iterator();
    L8:
        if (r3.hasNext() == false) goto L19;
        StarGeofenceManager r0 = (StarGeofenceManager) ZeusTransformUtils.preCheckCast(r3.next(), StarGeofenceManager.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        r0.removeUnknownStateGeofenceId(r4);
        goto L8
    L19:
        return;
    }

    public void retryGeofenceAddress() {
        b.a r0 = this.iBinder;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.recoverFinishFlag == true) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L11
        d.a().r().execute(new $$Lambda$StarGeofenceManager$pf25hZf7i6rDt5aczaOExK_Ik1U(this));
    }
}
