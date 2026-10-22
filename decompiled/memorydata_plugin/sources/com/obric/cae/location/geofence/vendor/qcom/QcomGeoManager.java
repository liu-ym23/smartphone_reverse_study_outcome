package com.obric.cae.location.geofence.vendor.qcom;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.statemachine.d;
import com.obric.cae.location.geofence.StarGeofenceManager;
import com.obric.cae.location.geofence.vendor.IVendorGeoManager;
import com.obric.cae.location.geofence.vendor.VendorGeoCallbackBroadcast;
import com.obric.cae.log.a;
import com.qti.location.sdk.IZatGeofenceService;
import com.qti.location.sdk.IZatIllegalArgumentException;
import com.qti.location.sdk.IZatManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
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
            int[] r0 = new int[StarGeofence.GeoConfidence.values().length];
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoConfidence = r0;
            r0[StarGeofence.GeoConfidence.MEDIUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoConfidence[StarGeofence.GeoConfidence.LOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L23:
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoConfidence[StarGeofence.GeoConfidence.HIGH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L8:
            int[] r3 = new int[StarGeofence.GeoTransitionType.values().length];
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoTransitionType = r3;
            r3[StarGeofence.GeoTransitionType.ENTERED_ONLY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L29:
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoTransitionType[StarGeofence.GeoTransitionType.EXITED_ONLY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L19:
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoTransitionType[StarGeofence.GeoTransitionType.ENTERED_AND_EXITED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
            return;
        }
    }

    private QcomGeoManager(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.hasQcomGeoManagerInit = false;
        this.onAddGeofenceLatch = null;
        this.onRemoveGeofenceLatch = null;
        this.onUpdateGeofenceLatch = null;
        this.onAddGeofenceResult = new AtomicBoolean(false);
        this.onRemoveGeofenceResult = new AtomicBoolean(false);
        this.onUpdateGeofenceResult = new AtomicBoolean(false);
        this.mIZatGeofenceCallback = new AnonymousClass1(this);
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.hasQcomGeoManagerInit = initQcomGeoManager();
    }

    public static /* synthetic */ AtomicBoolean access$000(QcomGeoManager r0) {
        return r0.onAddGeofenceResult;
    }

    public static /* synthetic */ CountDownLatch access$100(QcomGeoManager r0) {
        return r0.onAddGeofenceLatch;
    }

    public static /* synthetic */ AtomicBoolean access$200(QcomGeoManager r0) {
        return r0.onRemoveGeofenceResult;
    }

    public static /* synthetic */ CountDownLatch access$300(QcomGeoManager r0) {
        return r0.onRemoveGeofenceLatch;
    }

    public static /* synthetic */ AtomicBoolean access$400(QcomGeoManager r0) {
        return r0.onUpdateGeofenceResult;
    }

    public static /* synthetic */ CountDownLatch access$500(QcomGeoManager r0) {
        return r0.onUpdateGeofenceLatch;
    }

    public static /* synthetic */ Context access$600(QcomGeoManager r0) {
        return r0.mContext;
    }

    private byte addStarGeofenceInternal(StarGeofence r4, boolean r5) {
        if (checkManagerInit() == true) goto L7;
        return 3;
    L7:
        if (checkServiceConnect() == true) goto L10;
        return 4;
    L10:
        a.c(TAG, "addStarGeofence: " + r4.toString() + ", recover: " + r5, getGeofenceLogFile(r4));
        this.mIZatGeofenceService.addGeofence(r4.getGeofenceId(), toIZatGeofence(r4));
        if (waitForQcomGeofenceCallback(1) == true) goto L14;
        return 6;
    L14:
        return 0;
    }

    private boolean checkManagerInit() {
        if (this.mIZatManager != null) goto L6;
        a.c(TAG, "qcom geo manager never init", getDefaultGeofenceLogFile());
        return false;
    L6:
        return true;
    }

    private boolean checkServiceConnect() {
        if (this.mIZatGeofenceService != null) goto L6;
        a.c(TAG, "qcom geo service never connect", getDefaultGeofenceLogFile());
        return false;
    L6:
        return true;
    }

    private File getDefaultGeofenceLogFile() {
        return StarGeofenceManager.getGeofenceLogFile(0);
    }

    private File getGeofenceLogFile(StarGeofence r1) {
        if (r1 != null) goto L6;
        return getDefaultGeofenceLogFile();
    L6:
        return getGeofenceLogFile(r1.getGeofenceId());
    }

    private File getGeofenceLogFile(String r1) {
        if (r1 != null) goto L6;
        return getDefaultGeofenceLogFile();
    L6:
        return StarGeofenceManager.getGeofenceLogFile(StarGeofenceManager.findUserIdByGeofence(this.mContext, r1));
    }

    public static synchronized QcomGeoManager getInstance(Context r3) {
        monitor-enter(QcomGeoManager.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (sInstance != null) goto L7;
        sInstance = new QcomGeoManager(r4);     // Catch: Throwable -> L10
    L7:
        QcomGeoManager r5 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(QcomGeoManager.class);
        return r5;
    L10:
        th = move-exception;
        throw th;
    }

    private boolean initQcomGeoManager() {
        File r1 = getDefaultGeofenceLogFile();
        IZatManager r2 = IZatManager.getInstance(this.mContext);
        this.mIZatManager = r2;
        this.mIZatGeofenceService = r2.connectGeofenceService();     // Catch: Exception -> L14
        a.c(TAG, "qcom izat connect success", r1);
        this.mIZatGeofenceService.registerForGeofenceCallbacks(this.mIZatGeofenceCallback);
        a.c(TAG, "qcom izat register geofence callback success", r1);
        if ("com.larus.nova".equals(this.mContext.getPackageName()) == true) goto L16;
        Intent r3 = new Intent(this.mContext, VendorGeoCallbackBroadcast.class);
    L12:
        PendingIntent r0 = PendingIntent.getBroadcast(this.mContext, 0, r3, 33554432);
        this.mIZatGeofenceService.registerPendingIntent(r0);
        return true;
    L16:
        Class r4 = ZeusTransformUtils.forName("com.obric.memorydata.plugin_api.stub.receiver.VendorGeoCallbackBroadcast", "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L8
        r3 = new Intent(this.mContext, r4);
    L8:
        e = move-exception;
        a.a(TAG, "qcom geo callback broadcast class not found", e);
        return false;
    L14:
        a.c(TAG, "Geofence Service is not available!", r1);
        return false;
    }

    private boolean matchGeofence(StarGeofence r5, IZatGeofenceService.IzatGeofence r6) {
        IZatGeofenceService.IzatGeofence r4 = (IZatGeofenceService.IzatGeofence) ZeusTransformUtils.wrapperContextForParams(r6, IZatGeofenceService.IzatGeofence.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L12;
        if (r4 == null) goto L12;
        if (r5.getLatitude() != r4.getLatitude()) goto L12;
        if (r5.getLongitude() != r4.getLongitude()) goto L12;
        if (r5.getRadius() != r4.getRadius()) goto L12;
        return true;
    L12:
        return false;
    }

    private String queryAoiBoardString(StarGeofence r2) {
        return com.obric.cae.location.geosdk.poi.a.a(this.mContext, r2, true);
    }

    private IZatGeofenceService.IzatGeofenceConfidence toIZatConfidence(StarGeofence.GeoConfidence r1) {
        int r0 = AnonymousClass2.$SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoConfidence[r1.ordinal()];
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L9;
        return IZatGeofenceService.IzatGeofenceConfidence.HIGH;
    L9:
        return IZatGeofenceService.IzatGeofenceConfidence.LOW;
    L11:
        return IZatGeofenceService.IzatGeofenceConfidence.MEDIUM;
    }

    private IZatGeofenceService.IzatGeofence toIZatGeofence(StarGeofence r9) {
        IZatGeofenceService.IzatGeofence r7 = new IZatGeofenceService.IzatGeofence(r9.getLatitude(), r9.getLongitude(), r9.getRadius());
        r7.setConfidence(toIZatConfidence(r9.getConfidence()));
        r7.setTransitionTypes(toIZatTransitionType(r9.getTransitionType()));
        r7.setDwellNotify(new IZatGeofenceService.IzatDwellNotify(10, 3));
        r7.setNotifyResponsiveness(1000);
        return r7;
    }

    private IZatGeofenceService.IzatGeofenceTransitionTypes toIZatTransitionType(StarGeofence.GeoTransitionType r1) {
        int r0 = AnonymousClass2.$SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoTransitionType[r1.ordinal()];
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L9;
        return IZatGeofenceService.IzatGeofenceTransitionTypes.ENTERED_AND_EXITED;
    L9:
        return IZatGeofenceService.IzatGeofenceTransitionTypes.EXITED_ONLY;
    L11:
        return IZatGeofenceService.IzatGeofenceTransitionTypes.ENTERED_ONLY;
    }

    private boolean waitForQcomGeofenceCallback(int r9) {
        a.d(TAG, "requestType:" + r9);
        monitor-enter(this);
        boolean r2 = true;
        CountDownLatch r1 = new CountDownLatch(1);     // Catch: Throwable -> L33
        if (r9 == 1) goto L11;
        if (r9 == 2) goto L10;
        if (r9 != 5) goto L36;
        this.onUpdateGeofenceLatch = r1;     // Catch: Throwable -> L33
    L36:
    L30:
        a.j(TAG, "interrupted");     // Catch: Throwable -> L33
        return true;
    L14:
        if (r1.await(200, TimeUnit.MILLISECONDS) == true) goto L19;
        a.b(TAG, LocationMonitorConst.TIMEOUT);     // Catch: InterruptedException -> L30 Throwable -> L33
        monitor-exit(this);     // Catch: Throwable -> L33
        return true;
    L19:
        if (r9 == 1) goto L26;
        if (r9 == 2) goto L25;
        if (r9 != 5) goto L27;
        this.onUpdateGeofenceLatch = null;     // Catch: Throwable -> L33
        r2 = this.onUpdateGeofenceResult.get();     // Catch: Throwable -> L33
        AtomicBoolean r10 = this.onUpdateGeofenceResult;     // Catch: Throwable -> L33
    L24:
        r10.set(false);     // Catch: Throwable -> L33
    L27:
        a.j(TAG, "result:" + r2);     // Catch: Throwable -> L33
        monitor-exit(this);     // Catch: Throwable -> L33
        return r2;
    L25:
        this.onRemoveGeofenceLatch = null;     // Catch: Throwable -> L33
        r2 = this.onRemoveGeofenceResult.get();     // Catch: Throwable -> L33
        r10 = this.onRemoveGeofenceResult;     // Catch: Throwable -> L33
        goto L24
    L26:
        this.onAddGeofenceLatch = null;     // Catch: Throwable -> L33
        r2 = this.onAddGeofenceResult.get();     // Catch: Throwable -> L33
        r10 = this.onAddGeofenceResult;     // Catch: Throwable -> L33
        goto L24
    L10:
        this.onRemoveGeofenceLatch = r1;     // Catch: Throwable -> L33
        goto L36
    L11:
        this.onAddGeofenceLatch = r1;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.cae.location.geofence.vendor.IVendorGeoManager
    public byte addStarGeofence(StarGeofence r2) {
        return addStarGeofenceInternal(r2, false);
    }

    @Override // com.obric.cae.location.geofence.vendor.IVendorGeoManager
    public byte deleteStarGeofence(StarGeofence r1) {
        return deleteStarGeofenceById(r1.getGeofenceId());
    }

    @Override // com.obric.cae.location.geofence.vendor.IVendorGeoManager
    public byte deleteStarGeofenceById(String r8) {
        if (r8 != null) goto L5;
    L42:
        a.j(TAG, "starGeofenceId is null or empty");
        return 5;
    L5:
        if (r8.isEmpty() == true) goto L42;
        if (checkManagerInit() == true) goto L12;
        return 3;
    L12:
        if (checkServiceConnect() == true) goto L15;
        return 4;
    L15:
        Map r3 = this.mIZatGeofenceService.recoverGeofences();
        if (r3 != null) goto L18;
    L40:
        a.c(TAG, "no geofence found.");
        return 5;
    L18:
        if (r3.isEmpty() == true) goto L40;
        a.c(TAG, "delete StarGeofence id : ".concat(r8), getGeofenceLogFile(r8));     // Catch: IZatIllegalArgumentException -> L37
        Iterator r0 = r3.keySet().iterator();     // Catch: IZatIllegalArgumentException -> L37
    L23:
        if (r0.hasNext() == false) goto L35;
        IZatGeofenceService.IZatGeofenceHandle r4 = (IZatGeofenceService.IZatGeofenceHandle) ZeusTransformUtils.preCheckCast(r0.next(), IZatGeofenceService.IZatGeofenceHandle.class, "com.obric.memorydata.plugin");     // Catch: IZatIllegalArgumentException -> L37
        if (r4.getContext() == null) goto L23;
        if (r8.equals(r4.getContext().toString()) == true) goto L29;
        a.a(TAG, "delete StarGeofence id for each : " + r4.getContext());     // Catch: IZatIllegalArgumentException -> L37
        goto L23
    L29:
        this.mIZatGeofenceService.removeGeofence(r4);     // Catch: IZatIllegalArgumentException -> L37
        if (waitForQcomGeofenceCallback(2) == true) goto L32;
        return 7;
    L32:
        a.a(TAG, "delete StarGeofence finish");     // Catch: IZatIllegalArgumentException -> L37
        return 0;
    L35:
        a.c(TAG, "can not find the IZatGeofenceHandle with starGeofenceId: " + r8, getGeofenceLogFile(r8));     // Catch: IZatIllegalArgumentException -> L37
        return 5;
    L37:
        e = move-exception;
        a.c(TAG, "IZatGeofenceService Error when delete StarGeofence: " + e.getMessage(), getGeofenceLogFile(r8));
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
    public byte syncStarGeofence(List<StarGeofence> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        if (checkManagerInit() == true) goto L6;
        return 3;
    L6:
        if (checkServiceConnect() == true) goto L9;
        return 4;
    L9:
        int r3 = 0;
    L10:
        boolean r4 = this.hasQcomGeoManagerInit;
        if (r4 == true) goto L19;
        if (r3 >= 3) goto L19;
        this.hasQcomGeoManagerInit = initQcomGeoManager();
        r3 = r3 + 1;
        a.c(TAG, d.a("reInit QcomGeoManager:", r3, "times , init:").append(this.hasQcomGeoManagerInit).toString());
        Thread.sleep(100);     // Catch: InterruptedException -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
    L19:
        if (r4 == true) goto L22;
        a.c(TAG, "QcomGeoManager Init failed...", getDefaultGeofenceLogFile());
        return 1;
    L22:
        Map r5 = this.mIZatGeofenceService.recoverGeofences();
        if (r5 != null) goto L25;
        a.c(TAG, "iZatGeofenceService.recoverGeofences() get null return");
        r5 = new HashMap();
    L25:
        ConcurrentHashMap r6 = new ConcurrentHashMap();
        Iterator r7 = r5.keySet().iterator();
    L27:
        if (r7.hasNext() == false) goto L32;
        IZatGeofenceService.IZatGeofenceHandle r8 = (IZatGeofenceService.IZatGeofenceHandle) ZeusTransformUtils.preCheckCast(r7.next(), IZatGeofenceService.IZatGeofenceHandle.class, "com.obric.memorydata.plugin");
        if (r8.getContext() == null) goto L27;
        r6.put(r8.getContext().toString(), r8);
        goto L27
    L32:
        Iterator r14 = r13.iterator();
    L34:
        if (r14.hasNext() == false) goto L44;
        StarGeofence r9 = (StarGeofence) ZeusTransformUtils.preCheckCast(r14.next(), StarGeofence.class, "com.obric.memorydata.plugin");
        IZatGeofenceService.IZatGeofenceHandle r10 = (IZatGeofenceService.IZatGeofenceHandle) ZeusTransformUtils.preCheckCast(r6.get(r9.getGeofenceId()), IZatGeofenceService.IZatGeofenceHandle.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L39;
        a.e(TAG, " SYNC " + r9.getGeofenceId() + ", create");
        addStarGeofenceInternal(r9, true);
    L42:
        r6.remove(r9.getGeofenceId());
        goto L34
    L39:
        if (matchGeofence(r9, (IZatGeofenceService.IzatGeofence) ZeusTransformUtils.preCheckCast(r5.get(r10), IZatGeofenceService.IzatGeofence.class, "com.obric.memorydata.plugin")) == true) goto L41;
        a.c(TAG, " SYNC " + r9.getGeofenceId() + ", update");
        r10.update(toIZatGeofence(r9));
        goto L42
    L41:
        a.c(TAG, " SYNC " + r9.getGeofenceId() + ", don't need to sync");
        goto L42
    L44:
        if (r6.isEmpty() == true) goto L49;
        Iterator r15 = r6.keySet().iterator();
    L47:
        if (r15.hasNext() == false) goto L49;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin");
        a.c(TAG, " SYNC " + r2 + ", remove");
        this.mIZatGeofenceService.removeGeofence((IZatGeofenceService.IZatGeofenceHandle) ZeusTransformUtils.preCheckCast(r6.get(r2), IZatGeofenceService.IZatGeofenceHandle.class, "com.obric.memorydata.plugin"));
    L49:
        return 0;
    }

    @Override // com.obric.cae.location.geofence.vendor.IVendorGeoManager
    public byte updateStarGeofence(StarGeofence r8) {
        if (r8 != null) goto L7;
        a.i(TAG, "updateStarGeofence, starGeofence is null");
        return 2;
    L7:
        if (checkManagerInit() == true) goto L11;
        return 3;
    L11:
        if (checkServiceConnect() == true) goto L14;
        return 4;
    L14:
        Map r2 = this.mIZatGeofenceService.recoverGeofences();
        if (r2 != null) goto L17;
    L39:
        a.c(TAG, "no geofence found.");
        return 5;
    L17:
        if (r2.isEmpty() == true) goto L39;
        a.c(TAG, "updateStarGeofence: " + r8, getGeofenceLogFile(r8));     // Catch: IZatIllegalArgumentException -> L36
        Iterator r0 = r2.keySet().iterator();     // Catch: IZatIllegalArgumentException -> L36
    L22:
        if (r0.hasNext() == false) goto L34;
        IZatGeofenceService.IZatGeofenceHandle r3 = (IZatGeofenceService.IZatGeofenceHandle) ZeusTransformUtils.preCheckCast(r0.next(), IZatGeofenceService.IZatGeofenceHandle.class, "com.obric.memorydata.plugin");     // Catch: IZatIllegalArgumentException -> L36
        if (r3.getContext() == null) goto L22;
        if (r8.getGeofenceId().equals(r3.getContext().toString()) == true) goto L28;
        a.c(TAG, "updateStarGeofence id for each : " + r3.getContext());     // Catch: IZatIllegalArgumentException -> L36
        goto L22
    L28:
        r3.update(toIZatGeofence(r8));     // Catch: IZatIllegalArgumentException -> L36
        if (waitForQcomGeofenceCallback(5) == true) goto L31;
        return 8;
    L31:
        a.c(TAG, "update starGeofence finish");     // Catch: IZatIllegalArgumentException -> L36
        return 0;
    L34:
        a.c(TAG, "can not find the IZatGeofenceHandle with starGeofenceId: " + r8.getGeofenceId(), getGeofenceLogFile(r8));     // Catch: IZatIllegalArgumentException -> L36
        return 5;
    L36:
        e = move-exception;
        a.c(TAG, "IZatGeofenceService Error when update StarGeofence: " + e.getMessage(), getGeofenceLogFile(r8));
        return 8;
    }
}
