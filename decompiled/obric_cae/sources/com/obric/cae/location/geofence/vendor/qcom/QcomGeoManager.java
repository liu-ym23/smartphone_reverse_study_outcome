package com.obric.cae.location.geofence.vendor.qcom;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.location.geofence.StarGeofenceManager;
import com.obric.cae.location.geofence.vendor.IVendorGeoManager;
import com.obric.cae.location.geofence.vendor.VendorGeoCallbackBroadcast;
import com.obric.cae.location.geosdk.poi.StarAoiBoardManager;
import com.obric.cae.log.CommSenseLog;
import com.qti.location.sdk.IZatGeofenceService;
import com.qti.location.sdk.IZatIllegalArgumentException;
import com.qti.location.sdk.IZatManager;
import defpackage.b;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class QcomGeoManager implements IVendorGeoManager {
    private static final int RECONNECT_GEOFENCE_MAX_NUM = 3;
    public static final String TAG = "StarLocation-qcomGeo";
    private static final int WAIT_FOR_CALLBACK_TIMEOUT_MS = 200;
    private static QcomGeoManager sInstance;
    private boolean hasQcomGeoManagerInit;
    private final Context mContext;
    private final IZatGeofenceService.IZatGeofenceCallback mIZatGeofenceCallback;
    private IZatGeofenceService mIZatGeofenceService;
    private IZatManager mIZatManager;
    private CountDownLatch onAddGeofenceLatch;
    private final AtomicBoolean onAddGeofenceResult;
    private CountDownLatch onRemoveGeofenceLatch;
    private final AtomicBoolean onRemoveGeofenceResult;
    private CountDownLatch onUpdateGeofenceLatch;
    private final AtomicBoolean onUpdateGeofenceResult;

    /* JADX INFO: renamed from: com.obric.cae.location.geofence.vendor.qcom.QcomGeoManager$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoConfidence = null;
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoTransitionType = null;

        static {
            int[] r8 = new int[StarGeofence.GeoConfidence.values().length];
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoConfidence = r8;
            r8[StarGeofence.GeoConfidence.MEDIUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoConfidence[StarGeofence.GeoConfidence.LOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L23:
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoConfidence[StarGeofence.GeoConfidence.HIGH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L8:
            int[] r10 = new int[StarGeofence.GeoTransitionType.values().length];
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoTransitionType = r10;
            r10[StarGeofence.GeoTransitionType.ENTERED_ONLY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L29:
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoTransitionType[StarGeofence.GeoTransitionType.EXITED_ONLY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L19:
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoTransitionType[StarGeofence.GeoTransitionType.ENTERED_AND_EXITED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
            return;
        }
    }

    private QcomGeoManager(Context r8) {
        this.hasQcomGeoManagerInit = false;
        this.onAddGeofenceLatch = null;
        this.onRemoveGeofenceLatch = null;
        this.onUpdateGeofenceLatch = null;
        this.onAddGeofenceResult = new AtomicBoolean(false);
        this.onRemoveGeofenceResult = new AtomicBoolean(false);
        this.onUpdateGeofenceResult = new AtomicBoolean(false);
        this.mIZatGeofenceCallback = new AnonymousClass1(this);
        this.mContext = r8.getApplicationContext();
        this.hasQcomGeoManagerInit = initQcomGeoManager();
    }

    public static /* synthetic */ AtomicBoolean access$000(QcomGeoManager r8) {
        return r8.onAddGeofenceResult;
    }

    public static /* synthetic */ CountDownLatch access$100(QcomGeoManager r8) {
        return r8.onAddGeofenceLatch;
    }

    public static /* synthetic */ AtomicBoolean access$200(QcomGeoManager r8) {
        return r8.onRemoveGeofenceResult;
    }

    public static /* synthetic */ CountDownLatch access$300(QcomGeoManager r8) {
        return r8.onRemoveGeofenceLatch;
    }

    public static /* synthetic */ AtomicBoolean access$400(QcomGeoManager r8) {
        return r8.onUpdateGeofenceResult;
    }

    public static /* synthetic */ CountDownLatch access$500(QcomGeoManager r8) {
        return r8.onUpdateGeofenceLatch;
    }

    public static /* synthetic */ Context access$600(QcomGeoManager r8) {
        return r8.mContext;
    }

    private byte addStarGeofenceInternal(StarGeofence r8, boolean r10) {
        if (checkManagerInit() == true) goto L7;
        return 3;
    L7:
        if (checkServiceConnect() == true) goto L10;
        return 4;
    L10:
        CommSenseLog.dumpI(TAG, "addStarGeofence: " + r8.toString() + ", recover: " + r10, getGeofenceLogFile(r8));
        this.mIZatGeofenceService.addGeofence(r8.getGeofenceId(), toIZatGeofence(r8));
        if (waitForQcomGeofenceCallback(1) == true) goto L14;
        return 6;
    L14:
        return 0;
    }

    private boolean checkManagerInit() {
        if (this.mIZatManager != null) goto L6;
        CommSenseLog.dumpI(TAG, "qcom geo manager never init", getDefaultGeofenceLogFile());
        return false;
    L6:
        return true;
    }

    private boolean checkServiceConnect() {
        if (this.mIZatGeofenceService != null) goto L6;
        CommSenseLog.dumpI(TAG, "qcom geo service never connect", getDefaultGeofenceLogFile());
        return false;
    L6:
        return true;
    }

    private File getDefaultGeofenceLogFile() {
        return StarGeofenceManager.getGeofenceLogFile(0);
    }

    private File getGeofenceLogFile(StarGeofence r8) {
        if (r8 != null) goto L6;
        return getDefaultGeofenceLogFile();
    L6:
        return getGeofenceLogFile(r8.getGeofenceId());
    }

    public static synchronized QcomGeoManager getInstance(Context r8) {
        monitor-enter(QcomGeoManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new QcomGeoManager(r8);     // Catch: Throwable -> L10
    L7:
        QcomGeoManager r10 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(QcomGeoManager.class);
        return r10;
    }

    private boolean initQcomGeoManager() {
        File r8 = getDefaultGeofenceLogFile();
        IZatManager r10 = IZatManager.getInstance(this.mContext);
        this.mIZatManager = r10;
        this.mIZatGeofenceService = r10.connectGeofenceService();     // Catch: Exception -> L14
        CommSenseLog.dumpI(TAG, "qcom izat connect success", r8);
        this.mIZatGeofenceService.registerForGeofenceCallbacks(this.mIZatGeofenceCallback);
        CommSenseLog.dumpI(TAG, "qcom izat register geofence callback success", r8);
        if ("com.larus.nova".equals(this.mContext.getPackageName()) == true) goto L16;
        Intent r11 = new Intent(this.mContext, VendorGeoCallbackBroadcast.class);
    L12:
        PendingIntent r12 = PendingIntent.getBroadcast(this.mContext, 0, r11, 33554432);
        this.mIZatGeofenceService.registerPendingIntent(r12);
        return true;
    L16:
        Class<?> r13 = Class.forName("com.obric.memorydata.plugin_api.stub.receiver.VendorGeoCallbackBroadcast");     // Catch: ClassNotFoundException -> L8
        r11 = new Intent(this.mContext, r13);
    L8:
        e = move-exception;
        CommSenseLog.e(TAG, "qcom geo callback broadcast class not found", e);
        return false;
    L14:
        CommSenseLog.dumpI(TAG, "Geofence Service is not available!", r8);
        return false;
    }

    private boolean matchGeofence(StarGeofence r8, IZatGeofenceService.IzatGeofence r10) {
        if (r8 == null) goto L11;
        if (r10 == null) goto L11;
        if (r8.getLatitude() != r10.getLatitude()) goto L11;
        if (r8.getLongitude() != r10.getLongitude()) goto L11;
        if (r8.getRadius() != r10.getRadius()) goto L11;
        return true;
    L11:
        return false;
    }

    private String queryAoiBoardString(StarGeofence r8) {
        return StarAoiBoardManager.queryBoundAoiBoardString(this.mContext, r8, true);
    }

    private IZatGeofenceService.IzatGeofenceConfidence toIZatConfidence(StarGeofence.GeoConfidence r8) {
        int r10 = AnonymousClass2.$SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoConfidence[r8.ordinal()];
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L9;
        return IZatGeofenceService.IzatGeofenceConfidence.HIGH;
    L9:
        return IZatGeofenceService.IzatGeofenceConfidence.LOW;
    L11:
        return IZatGeofenceService.IzatGeofenceConfidence.MEDIUM;
    }

    private IZatGeofenceService.IzatGeofence toIZatGeofence(StarGeofence r10) {
        IZatGeofenceService.IzatGeofence r8 = new IZatGeofenceService.IzatGeofence(r10.getLatitude(), r10.getLongitude(), r10.getRadius());
        r8.setConfidence(toIZatConfidence(r10.getConfidence()));
        r8.setTransitionTypes(toIZatTransitionType(r10.getTransitionType()));
        r8.setDwellNotify(new IZatGeofenceService.IzatDwellNotify(10, 3));
        r8.setNotifyResponsiveness(1000);
        return r8;
    }

    private IZatGeofenceService.IzatGeofenceTransitionTypes toIZatTransitionType(StarGeofence.GeoTransitionType r8) {
        int r10 = AnonymousClass2.$SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoTransitionType[r8.ordinal()];
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L9;
        return IZatGeofenceService.IzatGeofenceTransitionTypes.ENTERED_AND_EXITED;
    L9:
        return IZatGeofenceService.IzatGeofenceTransitionTypes.EXITED_ONLY;
    L11:
        return IZatGeofenceService.IzatGeofenceTransitionTypes.ENTERED_ONLY;
    }

    private boolean waitForQcomGeofenceCallback(int r10) {
        CommSenseLog.dWithMethodName(TAG, "requestType:" + r10);
        monitor-enter(this);
        boolean r8 = true;
        CountDownLatch r11 = new CountDownLatch(1);     // Catch: Throwable -> L32
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L10;
        if (r10 != 5) goto L35;
        this.onUpdateGeofenceLatch = r11;     // Catch: Throwable -> L32
    L35:
    L29:
        CommSenseLog.eWithMethodName(TAG, "interrupted");     // Catch: Throwable -> L32
        return true;
    L13:
        if (r11.await(200, TimeUnit.MILLISECONDS) == true) goto L18;
        CommSenseLog.vWithMethodName(TAG, "timeout");     // Catch: InterruptedException -> L29 Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        return true;
    L18:
        if (r10 == 1) goto L25;
        if (r10 == 2) goto L24;
        if (r10 != 5) goto L26;
        this.onUpdateGeofenceLatch = null;     // Catch: Throwable -> L32
        r8 = this.onUpdateGeofenceResult.get();     // Catch: Throwable -> L32
        AtomicBoolean r12 = this.onUpdateGeofenceResult;     // Catch: Throwable -> L32
    L23:
        r12.set(false);     // Catch: Throwable -> L32
    L26:
        CommSenseLog.eWithMethodName(TAG, "result:" + r8);     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        return r8;
    L24:
        this.onRemoveGeofenceLatch = null;     // Catch: Throwable -> L32
        r8 = this.onRemoveGeofenceResult.get();     // Catch: Throwable -> L32
        r12 = this.onRemoveGeofenceResult;     // Catch: Throwable -> L32
        goto L23
    L25:
        this.onAddGeofenceLatch = null;     // Catch: Throwable -> L32
        r8 = this.onAddGeofenceResult.get();     // Catch: Throwable -> L32
        r12 = this.onAddGeofenceResult;     // Catch: Throwable -> L32
        goto L23
    L10:
        this.onRemoveGeofenceLatch = r11;     // Catch: Throwable -> L32
        goto L35
    L11:
        this.onAddGeofenceLatch = r11;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.cae.location.geofence.vendor.IVendorGeoManager
    public byte addStarGeofence(StarGeofence r8) {
        return addStarGeofenceInternal(r8, false);
    }

    @Override // com.obric.cae.location.geofence.vendor.IVendorGeoManager
    public byte deleteStarGeofence(StarGeofence r8) {
        return deleteStarGeofenceById(r8.getGeofenceId());
    }

    @Override // com.obric.cae.location.geofence.vendor.IVendorGeoManager
    public byte deleteStarGeofenceById(String r8) {
        if (r8 != null) goto L5;
    L42:
        CommSenseLog.eWithMethodName(TAG, "starGeofenceId is null or empty");
        return 5;
    L5:
        if (r8.isEmpty() == true) goto L42;
        if (checkManagerInit() == true) goto L12;
        return 3;
    L12:
        if (checkServiceConnect() == true) goto L15;
        return 4;
    L15:
        Map r10 = this.mIZatGeofenceService.recoverGeofences();
        if (r10 != null) goto L18;
    L40:
        CommSenseLog.d(TAG, "no geofence found.");
        return 5;
    L18:
        if (r10.isEmpty() == true) goto L40;
        CommSenseLog.dumpI(TAG, "delete StarGeofence id : ".concat(r8), getGeofenceLogFile(r8));     // Catch: IZatIllegalArgumentException -> L37
        Iterator r11 = r10.keySet().iterator();     // Catch: IZatIllegalArgumentException -> L37
    L23:
        if (r11.hasNext() == false) goto L35;
        IZatGeofenceService.IZatGeofenceHandle r12 = (IZatGeofenceService.IZatGeofenceHandle) r11.next();     // Catch: IZatIllegalArgumentException -> L37
        if (r12.getContext() == null) goto L23;
        if (r8.equals(r12.getContext().toString()) == true) goto L29;
        CommSenseLog.v(TAG, "delete StarGeofence id for each : " + r12.getContext());     // Catch: IZatIllegalArgumentException -> L37
        goto L23
    L29:
        this.mIZatGeofenceService.removeGeofence(r12);     // Catch: IZatIllegalArgumentException -> L37
        if (waitForQcomGeofenceCallback(2) == true) goto L32;
        return 7;
    L32:
        CommSenseLog.v(TAG, "delete StarGeofence finish");     // Catch: IZatIllegalArgumentException -> L37
        return 0;
    L35:
        CommSenseLog.dumpI(TAG, "can not find the IZatGeofenceHandle with starGeofenceId: " + r8, getGeofenceLogFile(r8));     // Catch: IZatIllegalArgumentException -> L37
        return 5;
    L37:
        e = move-exception;
        CommSenseLog.dumpI(TAG, "IZatGeofenceService Error when delete StarGeofence: " + e.getMessage(), getGeofenceLogFile(r8));
        return 7;
    }

    @Override // com.obric.cae.location.geofence.vendor.IVendorGeoManager
    public String getSource() {
        return "Qcom-Izat";
    }

    @Override // com.obric.cae.location.geofence.vendor.IVendorGeoManager
    public String getVersion() {
        if (checkManagerInit() == false) goto L5;
        return "";
    L5:
        return this.mIZatManager.getVersion();
    }

    @Override // com.obric.cae.location.geofence.vendor.IVendorGeoManager
    public byte syncStarGeofence(List<StarGeofence> r10) {
        if (checkManagerInit() == true) goto L6;
        return 3;
    L6:
        if (checkServiceConnect() == true) goto L9;
        return 4;
    L9:
        int r8 = 0;
    L10:
        boolean r11 = this.hasQcomGeoManagerInit;
        if (r11 == true) goto L19;
        if (r8 >= 3) goto L19;
        this.hasQcomGeoManagerInit = initQcomGeoManager();
        r8 = r8 + 1;
        StringBuilder r12 = b.f("reInit QcomGeoManager:", r8, "times , init:");
        r12.append(this.hasQcomGeoManagerInit);
        CommSenseLog.d(TAG, r12.toString());
        Thread.sleep(100);     // Catch: InterruptedException -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
    L19:
        if (r11 == true) goto L22;
        CommSenseLog.dumpI(TAG, "QcomGeoManager Init failed...", getDefaultGeofenceLogFile());
        return 1;
    L22:
        Map r13 = this.mIZatGeofenceService.recoverGeofences();
        if (r13 != null) goto L25;
        CommSenseLog.d(TAG, "iZatGeofenceService.recoverGeofences() get null return");
        r13 = new HashMap();
    L25:
        ConcurrentHashMap r14 = new ConcurrentHashMap();
        Iterator r15 = r13.keySet().iterator();
    L27:
        if (r15.hasNext() == false) goto L32;
        IZatGeofenceService.IZatGeofenceHandle r16 = (IZatGeofenceService.IZatGeofenceHandle) r15.next();
        if (r16.getContext() == null) goto L27;
        r14.put(r16.getContext().toString(), r16);
        goto L27
    L32:
        Iterator<StarGeofence> r17 = r10.iterator();
    L34:
        if (r17.hasNext() == false) goto L44;
        StarGeofence r18 = r17.next();
        IZatGeofenceService.IZatGeofenceHandle r19 = (IZatGeofenceService.IZatGeofenceHandle) r14.get(r18.getGeofenceId());
        if (r19 != null) goto L39;
        CommSenseLog.i(TAG, " SYNC " + r18.getGeofenceId() + ", create");
        addStarGeofenceInternal(r18, true);
    L42:
        r14.remove(r18.getGeofenceId());
        goto L34
    L39:
        if (matchGeofence(r18, (IZatGeofenceService.IzatGeofence) r13.get(r19)) == true) goto L41;
        CommSenseLog.d(TAG, " SYNC " + r18.getGeofenceId() + ", update");
        r19.update(toIZatGeofence(r18));
        goto L42
    L41:
        CommSenseLog.d(TAG, " SYNC " + r18.getGeofenceId() + ", don't need to sync");
        goto L42
    L44:
        if (r14.isEmpty() == true) goto L49;
        Iterator r110 = r14.keySet().iterator();
    L47:
        if (r110.hasNext() == false) goto L49;
        String r20 = (String) r110.next();
        CommSenseLog.d(TAG, " SYNC " + r20 + ", remove");
        this.mIZatGeofenceService.removeGeofence((IZatGeofenceService.IZatGeofenceHandle) r14.get(r20));
    L49:
        return 0;
    }

    @Override // com.obric.cae.location.geofence.vendor.IVendorGeoManager
    public byte updateStarGeofence(StarGeofence r8) {
        if (r8 != null) goto L7;
        CommSenseLog.e(TAG, "updateStarGeofence, starGeofence is null");
        return 2;
    L7:
        if (checkManagerInit() == true) goto L11;
        return 3;
    L11:
        if (checkServiceConnect() == true) goto L14;
        return 4;
    L14:
        Map r10 = this.mIZatGeofenceService.recoverGeofences();
        if (r10 != null) goto L17;
    L39:
        CommSenseLog.d(TAG, "no geofence found.");
        return 5;
    L17:
        if (r10.isEmpty() == true) goto L39;
        CommSenseLog.dumpI(TAG, "updateStarGeofence: " + r8, getGeofenceLogFile(r8));     // Catch: IZatIllegalArgumentException -> L36
        Iterator r11 = r10.keySet().iterator();     // Catch: IZatIllegalArgumentException -> L36
    L22:
        if (r11.hasNext() == false) goto L34;
        IZatGeofenceService.IZatGeofenceHandle r12 = (IZatGeofenceService.IZatGeofenceHandle) r11.next();     // Catch: IZatIllegalArgumentException -> L36
        if (r12.getContext() == null) goto L22;
        if (r8.getGeofenceId().equals(r12.getContext().toString()) == true) goto L28;
        CommSenseLog.d(TAG, "updateStarGeofence id for each : " + r12.getContext());     // Catch: IZatIllegalArgumentException -> L36
        goto L22
    L28:
        r12.update(toIZatGeofence(r8));     // Catch: IZatIllegalArgumentException -> L36
        if (waitForQcomGeofenceCallback(5) == true) goto L31;
        return 8;
    L31:
        CommSenseLog.d(TAG, "update starGeofence finish");     // Catch: IZatIllegalArgumentException -> L36
        return 0;
    L34:
        CommSenseLog.dumpI(TAG, "can not find the IZatGeofenceHandle with starGeofenceId: " + r8.getGeofenceId(), getGeofenceLogFile(r8));     // Catch: IZatIllegalArgumentException -> L36
        return 5;
    L36:
        e = move-exception;
        CommSenseLog.dumpI(TAG, "IZatGeofenceService Error when update StarGeofence: " + e.getMessage(), getGeofenceLogFile(r8));
        return 8;
    }

    private File getGeofenceLogFile(String r8) {
        if (r8 != null) goto L6;
        return getDefaultGeofenceLogFile();
    L6:
        return StarGeofenceManager.getGeofenceLogFile(StarGeofenceManager.findUserIdByGeofence(this.mContext, r8));
    }
}
