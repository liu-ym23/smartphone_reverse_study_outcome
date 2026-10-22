package com.obric.cae.userAware;

import android.content.Context;
import android.provider.Settings;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.SmartBluetoothBinderClient;
import com.obric.cae.smartBluetooth.SmartBluetoothManager;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.cae.userAware.datacollection.FileController;
import com.obric.cae.userAware.datacollection.HARFeedbackInfo;
import com.obric.cae.userAware.datacollection.HARNotification;
import com.obric.cae.userAware.datacollection.SubwayFeedbackInfo;
import com.obric.cae.userAware.db.HARRecordDatabase;
import com.obric.cae.userAware.db.SubwayRecordDatabase;
import com.obric.cae.userAware.notification.HomeStatusManager;
import com.obric.cae.userAware.notification.SubwayStatusManager;
import com.obric.cae.userAware.report.CaeUserAwareReportFactory;
import com.obric.cae.userAware.report.CaeUserAwareReportProto;
import com.obric.cae.userAware.report.SubwayEvaluationManager;

/* JADX INFO: loaded from: classes2.dex */
public class RecordNearbyManager {
    private static final String TAG = "RecordNearbyManager";
    private static volatile RecordNearbyManager sInstance;
    private Context mContext;
    private FileController mFileController;
    private int mFileControllerMode;
    private HARRecordDatabase mHARRecordDatabase;
    private HomeStatusManager mHomeStatusManager;
    private OemHarInfoManager mOemHarInfoManager;
    private SubwayRecordDatabase mSubwayRecordDatabase;
    private SubwayStatusManager mSubwayStatusManager;
    private volatile UserAwareService mUserAwareService;

    /* JADX INFO: renamed from: com.obric.cae.userAware.RecordNearbyManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class OemHarCallback extends InnerAwareInfoCallback {
        final /* synthetic */ RecordNearbyManager this$0;

        private OemHarCallback(RecordNearbyManager r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onDeviceProvisionedChanged(int r8) {
            defpackage.b.m("onDeviceProvisionedChanged", r8, RecordNearbyManager.access$100());
            RecordNearbyManager r10 = this.this$0;
            if (r8 != 0) goto L5;
            r10.cleanupFileController();
            return;
        L5:
            r10.initFileController();
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onHAREnableValueChange(int r8) {
            super.onHAREnableValueChange(r8);
            defpackage.b.m("onHAREnableValueChange, value: ", r8, RecordNearbyManager.access$100());
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onHARStatusChanged(int r8, long r10) {
            super.onHARStatusChanged(r8, r10);
            defpackage.b.m("onHARStatusChanged, status: ", r8, RecordNearbyManager.access$100());
            RecordNearbyManager.access$200(this.this$0, r8, r10);
            if (RecordNearbyManager.access$300(this.this$0) != null) goto L5;
        L7:
            SmartBluetoothBinderClient r11 = SmartBluetoothManager.getInstance(RecordNearbyManager.access$400(this.this$0)).getBluetoothBinderClient();
            if (r11 == null) goto L11;
            r11.setHARStatusChanged(r8);
            return;
        L11:
            return;
        L5:
            if (RecordNearbyManager.access$300(this.this$0).isHarEnableNotification() == false) goto L7;
            HARNotification.getInstance(RecordNearbyManager.access$400(this.this$0)).updateNotification(r8);
            goto L7
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onInSubWayChange(int r8, String r10) {
            CaeLog.d(RecordNearbyManager.access$100(), "onInSubWayChange, isInSubWay: " + r8 + ", stationName: " + r10);
            this.this$0.saveSubwayRecord(r8, r10);
            if (RecordNearbyManager.access$600(this.this$0) == null) goto L6;
            RecordNearbyManager.access$600(this.this$0).showNotification(r8, r10);
            return;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onLocationStateValueChange(String r8) {
            defpackage.b.o("Location state changed: ", r8, RecordNearbyManager.access$100());
            if (RecordNearbyManager.access$500(this.this$0) == null) goto L6;
            RecordNearbyManager.access$500(this.this$0).showNotification(r8);
            return;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onSubwayEvaluationEvent(boolean r17, float r18, String r19, long r20, int r22, int r23, float r24, float r25, int r26, boolean r27, String r28) {
            CaeLog.d(RecordNearbyManager.access$100(), "onSubwayEvaluationEvent: isEnter=" + r17);
            SubwayEvaluationManager.getInstance();
            if (SubwayEvaluationManager.isInitialized() == true) goto L5;
            SubwayEvaluationManager.getInstance().init(RecordNearbyManager.access$400(this.this$0), null);
        L5:
            SubwayEvaluationManager.getInstance().onSubwayEvaluationEvent(r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28);
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onSubwayFeedbackSwitchValueChange(int r8) {
            super.onSubwayFeedbackSwitchValueChange(r8);
            defpackage.b.m("onSubwayFeedbackSwitchValueChange, subwayFeedbackSwitch: ", r8, RecordNearbyManager.access$100());
            if (RecordNearbyManager.access$600(this.this$0) == null) goto L7;
            if (r8 != 0) goto L7;
            RecordNearbyManager.access$600(this.this$0).destroy();
            RecordNearbyManager r10 = this.this$0;
            SubwayStatusManager r11 = null;
        L9:
            RecordNearbyManager.access$602(r10, r11);
            return;
        L7:
            if (r8 != 1) goto L11;
            r10 = this.this$0;
            r11 = SubwayStatusManager.getInstance(RecordNearbyManager.access$400(r10));
            goto L9
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onUploadModeChanged(int r8) {
            defpackage.b.m("onUploadModeChanged, mode: ", r8, RecordNearbyManager.access$100());
            RecordNearbyManager.access$700(this.this$0, r8);
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onUserFeedbackPredictSwitchValueChange(int r8) {
            super.onUserFeedbackPredictSwitchValueChange(r8);
            defpackage.b.m("onUserFeedbackPredictSwitchValueChange, predictSwitch: ", r8, RecordNearbyManager.access$100());
            if (RecordNearbyManager.access$500(this.this$0) == null) goto L7;
            if (r8 != 0) goto L7;
            RecordNearbyManager.access$500(this.this$0).destroy();
            RecordNearbyManager r10 = this.this$0;
            HomeStatusManager r11 = null;
        L9:
            RecordNearbyManager.access$502(r10, r11);
            return;
        L7:
            if (r8 != 1) goto L11;
            r10 = this.this$0;
            r11 = HomeStatusManager.getInstance(RecordNearbyManager.access$400(r10));
            goto L9
        }

        public /* synthetic */ OemHarCallback(RecordNearbyManager r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    private RecordNearbyManager() {
        this.mFileControllerMode = -1;
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ void access$200(RecordNearbyManager r8, int r10, long r11) {
        r8.saveHarRecord(r10, r11);
    }

    public static /* synthetic */ OemHarInfoManager access$300(RecordNearbyManager r8) {
        return r8.mOemHarInfoManager;
    }

    public static /* synthetic */ Context access$400(RecordNearbyManager r8) {
        return r8.mContext;
    }

    public static /* synthetic */ HomeStatusManager access$500(RecordNearbyManager r8) {
        return r8.mHomeStatusManager;
    }

    public static /* synthetic */ HomeStatusManager access$502(RecordNearbyManager r8, HomeStatusManager r10) {
        r8.mHomeStatusManager = r10;
        return r10;
    }

    public static /* synthetic */ SubwayStatusManager access$600(RecordNearbyManager r8) {
        return r8.mSubwayStatusManager;
    }

    public static /* synthetic */ SubwayStatusManager access$602(RecordNearbyManager r8, SubwayStatusManager r10) {
        r8.mSubwayStatusManager = r10;
        return r10;
    }

    public static /* synthetic */ void access$700(RecordNearbyManager r8, int r10) {
        r8.setFileController(r10);
    }

    public static synchronized RecordNearbyManager getInstance() {
        monitor-enter(RecordNearbyManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new RecordNearbyManager();     // Catch: Throwable -> L10
    L7:
        RecordNearbyManager r8 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(RecordNearbyManager.class);
        return r8;
    }

    private void initDatabases() {
        this.mHARRecordDatabase = new HARRecordDatabase(this.mContext);     // Catch: Exception -> L4
        this.mSubwayRecordDatabase = new SubwayRecordDatabase(this.mContext);     // Catch: Exception -> L4
        CaeLog.d(TAG, "Databases initialized successfully");     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        CaeLog.e(TAG, "Failed to initialize databases", e);
    }

    private void initHarNotification() {
        boolean r8 = false;
        int r10 = Settings.Global.getInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR_NOTIFICATION, 0);
        if (this.mOemHarInfoManager != null) goto L6;
        CaeLog.e(TAG, "initHarNotification: mOemHarInfoManager is null");
        return;
    L6:
        defpackage.b.m("initHarNotification: enable: ", r10, TAG);
        OemHarInfoManager r11 = this.mOemHarInfoManager;
        if (r10 == 0) goto L9;
        r8 = true;
    L9:
        r11.setHarEnableNotification(r8);
    }

    private void initManager() {
        this.mOemHarInfoManager = UserAwareManager.getInstance().getOemHarInfoManager();
        CaeUserAwareReportFactory.createReportInstance(CaeUserAwareReportProto.getInstance(this.mContext));
        String r8 = Settings.Global.getString(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_USER_FEEDBACK_PREDICT_SWITCH);
        if ("1".equals(r8) == false) goto L5;
        this.mHomeStatusManager = HomeStatusManager.getInstance(this.mContext);
        CaeLog.d(TAG, "initManager: HomeStatusManager initialized");
    L6:
        String r10 = Settings.Global.getString(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_SUBWAY_FEEDBACK_SWITCH);
        if ("1".equals(r10) == false) goto L9;
        this.mSubwayStatusManager = SubwayStatusManager.getInstance(this.mContext);
        String r11 = TAG;
        String r12 = "initManager: SubwayStatusManager initialized";
    L10:
        CaeLog.d(r11, r12);
        return;
    L9:
        r11 = TAG;
        r12 = defpackage.b.c("initManager: SubwayStatusManager not initialized ", r10);
        goto L10
    L5:
        defpackage.b.o("initManager: HomeStatusManager not initialized ", r8, TAG);
        goto L6
    }

    private void registerCallback() {
        OemHarCallback r8 = new OemHarCallback(this, null);
        if (this.mUserAwareService == null) goto L6;
        CaeLog.d(TAG, "registerCallback");
        UserAwareManager.getInstance().registerInnerCallback(r8);
        return;
    }

    private synchronized void saveHarRecord(int r8, long r10) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mHARRecordDatabase != null) goto L19;
        CaeLog.w(TAG, "HAR database not initialized, skipping save");     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L19:
        HARFeedbackInfo r11 = new HARFeedbackInfo();     // Catch: Exception -> L11 Throwable -> L15
        r11.setTimeStamp(r10);     // Catch: Exception -> L11 Throwable -> L15
        r11.setStateCode(r8);     // Catch: Exception -> L11 Throwable -> L15
        r11.setHasFeedback(false);     // Catch: Exception -> L11 Throwable -> L15
        r11.setUserChoice(-1);     // Catch: Exception -> L11 Throwable -> L15
        this.mHARRecordDatabase.insertRecord(r11);     // Catch: Exception -> L11 Throwable -> L15
        CaeLog.d(TAG, "HAR record saved successfully: status=" + r8);     // Catch: Exception -> L11 Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L11:
        e = move-exception;
        CaeLog.e(TAG, "Failed to save HAR record", e);     // Catch: Throwable -> L15
        goto L13
    }

    private void setFileController(int r8) {
        defpackage.b.m("enter setFileController and mode is ", r8, TAG);
        FileController r10 = this.mFileController;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r8 == 1) goto L10;
        if (r8 == 0) goto L10;
        return;
    L10:
        r10.setRunMode(r8);
    }

    public void cleanup() {
        String r8 = TAG;
        CaeLog.d(r8, "cleanup RecordNearbyManager");
        cleanupFileController();
        SubwayEvaluationManager.getInstance().release();
        CaeLog.d(r8, "SubwayEvaluationManager released");
        HomeStatusManager r10 = this.mHomeStatusManager;
        if (r10 == null) goto L5;
        r10.destroy();
        this.mHomeStatusManager = null;
    L5:
        SubwayStatusManager r11 = this.mSubwayStatusManager;
        if (r11 == null) goto L8;
        r11.destroy();
        this.mSubwayStatusManager = null;
    L8:
        this.mHARRecordDatabase = null;
        this.mSubwayRecordDatabase = null;
    }

    public void cleanupFileController() {
        CaeLog.d(TAG, "cleanupFileController");
        FileController r8 = this.mFileController;
        if (r8 == null) goto L6;
        r8.cleanup();
        this.mFileController = null;
        return;
    }

    public void initFileController() {
        int r8 = Settings.Global.getInt(this.mContext.getContentResolver(), "device_provisioned", 0);
        String r10 = TAG;
        defpackage.b.m("initFileController, enable: ", r8, r10);
        if (r8 != 0) goto L6;
        CaeLog.w(r10, "device not provisioned, return");
        return;
    L6:
        int r11 = Settings.Global.getInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_USER_PERIODIC_UPLOAD_MODE, -1);
        defpackage.b.m("initFileController periodicUploadMode: ", r11, r10);
        if (r11 <= 0) goto L9;
        this.mFileController = FileController.getInstance(this.mContext);
        setFileController(r11);
        defpackage.a.i("File controller initialized with mode: ", r11, r10);
        return;
    L9:
        CaeLog.w(r10, "Invalid mode, skipping file controller initialization: " + r11);
    }

    public void initOnce(Context r8, UserAwareService r10) {
        this.mContext = r8.getApplicationContext();
        this.mUserAwareService = r10;
        initManager();
        initDatabases();
        registerCallback();
        initHarNotification();
        initFileController();
    }

    public synchronized void saveSubwayRecord(int r8, String r10) {
        monitor-enter(this);
        String r11 = TAG;     // Catch: Throwable -> L15
        CaeLog.d(r11, "saveSubwayRecord called - subwayStatus=" + r8 + ", stationName=" + r10);     // Catch: Throwable -> L15
        if (this.mSubwayRecordDatabase != null) goto L18;
        CaeLog.w(r11, "Subway database not initialized, skipping save");     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L18:
        SubwayFeedbackInfo r12 = new SubwayFeedbackInfo();     // Catch: Exception -> L11 Throwable -> L15
        r12.setTimeStamp(System.currentTimeMillis());     // Catch: Exception -> L11 Throwable -> L15
        r12.setSubwayStatus(r8);     // Catch: Exception -> L11 Throwable -> L15
        r12.setStationName(r10);     // Catch: Exception -> L11 Throwable -> L15
        r12.setHasFeedback(false);     // Catch: Exception -> L11 Throwable -> L15
        r12.setUserChoice(-1);     // Catch: Exception -> L11 Throwable -> L15
        this.mSubwayRecordDatabase.insertRecord(r12);     // Catch: Exception -> L11 Throwable -> L15
        CaeLog.d(r11, "Subway record saved successfully: subwayStatus=" + r8 + ", stationName=" + r10);     // Catch: Exception -> L11 Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L11:
        e = move-exception;
        CaeLog.e(TAG, "Failed to save subway record", e);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }
}
