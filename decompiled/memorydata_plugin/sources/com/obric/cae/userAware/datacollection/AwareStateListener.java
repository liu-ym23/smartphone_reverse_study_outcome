package com.obric.cae.userAware.datacollection;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.provider.Settings;
import android.widget.Toast;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.cae.log.a;
import com.obric.cae.userAware.WifiAwareInfoManager;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class AwareStateListener {
    private static final String CHANNEL_ID = "UserAwareChannel";
    private static final String DEFAULT_AWARE_STATE = "null";
    public static final int DEFAULT_ENABLE_POI_ACC_QUALIFIED_CHECK = 1;
    public static final int DEFAULT_ENABLE_POI_DETECT_FUNCTION = 0;
    public static final int DEFAULT_ENABLE_WIFI_SCAN_FUNCTION = 0;
    private static final int DEFAULT_HAR_COLLECT_LOCAL = 0;
    public static final int DEFAULT_HAR_NOTIFICATION_DISABLED = 0;
    public static final int DEFAULT_HAR_RAW_DATA_REPORT = 0;
    public static final int DEFAULT_HAR_STATE = -1;
    public static final int DEFAULT_HAR_WAKELOCK_TIME = 0;
    public static final float DEFAULT_POI_CONFIDENCE_THRESHOLD = 0.6f;
    public static final int DEFAULT_POI_STATIONARY_DELAY_SECONDS = 20;
    public static final long DEFAULT_POI_STATIONARY_STEP_CHECK_INTERVAL_MS = 60000;
    public static final int DEFAULT_POI_STATIONARY_STEP_DELTA_THRESHOLD = 10;
    public static final int DEFAULT_POI_TRIGGER_MODE = 0;
    public static final int DEFAULT_POI_WALK_STEP_THRESHOLD = 150;
    public static final int DEFAULT_SUBWAY_STATE = -1;
    public static final int DEFAULT_WIFI_SCAN_DAILY_CAP = 300;
    public static final int ENABLE_POI_ACC_QUALIFIED_CHECK_CLOSE = 0;
    public static final int ENABLE_POI_ACC_QUALIFIED_CHECK_OPEN = 1;
    public static final int ENABLE_POI_DETECT_FUNCTION_CLOSE = 0;
    public static final int ENABLE_POI_DETECT_FUNCTION_OPEN = 1;
    public static final int ENABLE_WIFI_SCAN_FUNCTION_CLOSE = 0;
    public static final int ENABLE_WIFI_SCAN_FUNCTION_OPEN = 1;
    public static final String HAR_EVENT_TEST_TOOL_ENABLE_CLOSE = "0";
    public static final String HAR_EVENT_TEST_TOOL_ENABLE_OPEN = "1";
    public static final int HAR_FUNCTION_CLOSE = 0;
    public static final int HAR_FUNCTION_OPEN = 1;
    public static final int HAR_NOTIFICATION_CLOSE = 0;
    public static final int HAR_NOTIFICATION_OPEN = 1;
    public static final int HAR_RAW_DATA_REPORT_DISABLE = 0;
    public static final int HAR_RAW_DATA_REPORT_ENABLE = 1;
    private static AwareStateListener INSTANCE = null;
    private static final int NOTIFICATION_ID = 1;
    public static final int POI_TRIGGER_MODE_ADSP_ONLY = 1;
    public static final int POI_TRIGGER_MODE_AP_ONLY = 0;
    public static final int POI_TRIGGER_MODE_DUAL_COMPARE = 2;
    public static final String SETTINGS_GLOBAL_ENABLE_HAR = "cae_user_aware_enable_har";
    public static final String SETTINGS_GLOBAL_ENABLE_HAR_NOTIFICATION = "cae_user_aware_enable_har_notification";
    public static final String SETTINGS_GLOBAL_ENABLE_POI_ACC_QUALIFIED_CHECK = "cae_user_aware_enable_poi_acc_qualified_check";
    public static final String SETTINGS_GLOBAL_ENABLE_POI_DETECT_FUNCTION = "cae_user_aware_enable_poi_detect_function";
    public static final String SETTINGS_GLOBAL_ENABLE_WIFI_SCAN_FUNCTION = "cae_user_aware_enable_wifi_scan_function";
    public static final String SETTINGS_GLOBAL_HAR_COLLECT_LOCAL = "cae_user_har_collect_local";
    public static final String SETTINGS_GLOBAL_HAR_EVENT_TEST_TOOL_ENABLE = "cae_har_event_test_tool_enable";
    public static final String SETTINGS_GLOBAL_HAR_RAW_DATA_REPORT = "cae_user_har_raw_data_report";
    public static final String SETTINGS_GLOBAL_HAR_STATE = "cae_user_har_state";
    public static final String SETTINGS_GLOBAL_POI_ADSP_TRACE_ENABLED = "cae_user_aware_poi_adsp_trace_enabled";
    public static final String SETTINGS_GLOBAL_POI_CONFIDENCE_THRESHOLD = "cae_user_aware_poi_confidence_threshold";
    public static final String SETTINGS_GLOBAL_POI_STATIONARY_DELAY_SECONDS = "cae_user_aware_poi_stationary_delay_seconds";
    public static final String SETTINGS_GLOBAL_POI_STATIONARY_STEP_CHECK_INTERVAL_MS = "cae_user_aware_poi_stationary_step_check_interval_ms";
    public static final String SETTINGS_GLOBAL_POI_STATIONARY_STEP_DELTA_THRESHOLD = "cae_user_aware_poi_stationary_step_delta_threshold";
    public static final String SETTINGS_GLOBAL_POI_TRIGGER_MODE = "cae_user_aware_poi_trigger_mode";
    public static final String SETTINGS_GLOBAL_POI_WALK_STEP_THRESHOLD = "cae_user_aware_poi_walk_step_threshold";
    public static final String SETTINGS_GLOBAL_SUBWAY_FEEDBACK_SWITCH = "cae_subway_feedback_switch";
    public static final String SETTINGS_GLOBAL_SUBWAY_STATE = "cae_subway_state";
    public static final String SETTINGS_GLOBAL_SUBWAY_TEST_TOOL_ENABLE = "cae_subway_test_tool_enable";
    public static final String SETTINGS_GLOBAL_USER_FEEDBACK_PREDICT_SWITCH = "cae_user_feedback_predict_switch";
    public static final String SETTINGS_GLOBAL_USER_LEARNING_PROGRESS = "user_home_company_learning_progress";
    public static final String SETTINGS_GLOBAL_USER_LOCATION_CHANGE = "user_location_state_change";
    public static final String SETTINGS_GLOBAL_USER_LOCATION_STATE = "user_location_state";
    public static final String SETTINGS_GLOBAL_USER_PERIODIC_UPLOAD_MODE = "cae_user_periodic_upload_mode";
    public static final String SETTINGS_GLOBAL_WIFI_SCAN_DAILY_CAP = "cae_user_aware_wifi_scan_daily_cap";
    public static final String SUBWAY_FEEDBACK_SWITCH_CLOSE = "0";
    public static final String SUBWAY_FEEDBACK_SWITCH_OPEN = "1";
    public static final int SUBWAY_STATE_IN = 1;
    public static final int SUBWAY_STATE_OUT = 0;
    public static final String SUBWAY_TEST_TOOL_ENABLE_CLOSE = "0";
    public static final String SUBWAY_TEST_TOOL_ENABLE_OPEN = "1";
    private static final String TAG = "AwareStateListener";
    public static final String USER_AWARE_REPORT_CLOSE = "0";
    public static final String USER_AWARE_REPORT_OPEN = "1";
    public static final String USER_FEEDBACK_CLOSE = "0";
    public static final String USER_FEEDBACK_OPEN = "1";
    public static final String USER_FEEDBACK_PREDICT_SWITCH_CLOSE = "0";
    public static final String USER_FEEDBACK_PREDICT_SWITCH_OPEN = "1";
    public static final String USER_INFO_FILE_BOTH_REMOTE_MODE = "3";
    public static final String USER_INFO_FILE_DEBUG_CLOSE = "0";
    public static final String USER_INFO_FILE_LOCAL_MODE = "1";
    public static final String USER_INFO_FILE_REMOTE_MODE = "2";
    public static final int USER_PERIODIC_UPLOAD_MODE_CLOSE = 0;
    public static final int USER_PERIODIC_UPLOAD_MODE_OPEN = 1;
    private static final AtomicBoolean mHarCollectLocal = null;
    private ContentResolver contentResolver;
    private Context mContext;
    private Messenger mMessenger;
    private WifiAwareInfoManager mWifiAwareInfoManager;
    private SettingsObserver settingsObserver;

    public class SettingsObserver extends ContentObserver {
        final /* synthetic */ AwareStateListener this$0;

        public SettingsObserver(AwareStateListener r1, Handler r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r4, Uri r5) {
            super.onChange(r4, r5);
            if (r5 == null) goto L48;
            a.c(AwareStateListener.access$000(), "Settings changed: " + r5);     // Catch: Exception -> L41
            if (r5.equals(Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_USER_FEEDBACK_PREDICT_SWITCH)) == false) goto L8;
            AwareStateListener.access$100(this.this$0);     // Catch: Exception -> L41
        L45:
            return;
        L8:
            if (r5.equals(Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_SUBWAY_TEST_TOOL_ENABLE)) == false) goto L11;
            AwareStateListener.access$200(this.this$0);     // Catch: Exception -> L41
            goto L45
        L11:
            if (r5.equals(Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_HAR_EVENT_TEST_TOOL_ENABLE)) == false) goto L14;
            AwareStateListener.access$300(this.this$0);     // Catch: Exception -> L41
            goto L45
        L14:
            if (r5.equals(Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_SUBWAY_FEEDBACK_SWITCH)) == false) goto L17;
            AwareStateListener.access$400(this.this$0);     // Catch: Exception -> L41
            goto L45
        L17:
            if (r5.equals(UserAwareUtil.getHostSettingsUri((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AwareStateListener.access$500(this.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), AwareStateListener.SETTINGS_GLOBAL_USER_LOCATION_CHANGE)) == false) goto L20;
            AwareStateListener.access$600(this.this$0);     // Catch: Exception -> L41
            goto L45
        L20:
            if (r5.equals(AwareStateListener.getEnableWifiScanFunctionUri((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AwareStateListener.access$500(this.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"))) == false) goto L23;
            AwareStateListener.access$700(this.this$0);     // Catch: Exception -> L41
            goto L45
        L23:
            if (r5.equals(Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR_NOTIFICATION)) == false) goto L26;
            AwareStateListener.access$800(this.this$0);     // Catch: Exception -> L41
            goto L45
        L26:
            if (r5.equals(Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR)) == false) goto L29;
            AwareStateListener.access$900(this.this$0);     // Catch: Exception -> L41
            goto L45
        L29:
            if (r5.equals(UserAwareUtil.getHostSettingsUri((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AwareStateListener.access$500(this.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), AwareStateListener.SETTINGS_GLOBAL_HAR_COLLECT_LOCAL)) == false) goto L32;
            AwareStateListener.access$1000(this.this$0);     // Catch: Exception -> L41
            goto L45
        L32:
            if (r5.equals(Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_HAR_RAW_DATA_REPORT)) == false) goto L35;
            AwareStateListener.access$1100(this.this$0);     // Catch: Exception -> L41
            goto L45
        L35:
            if (r5.equals(Settings.Global.getUriFor("device_provisioned")) == false) goto L38;
            AwareStateListener.access$1200(this.this$0);     // Catch: Exception -> L41
            goto L45
        L38:
            if (r5.equals(Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_USER_PERIODIC_UPLOAD_MODE)) == false) goto L45;
            AwareStateListener.access$1300(this.this$0);     // Catch: Exception -> L41
        L41:
            e = move-exception;
            throw new RuntimeException(e);
        }
    }

    static {
        mHarCollectLocal = new AtomicBoolean(false);
    }

    public AwareStateListener() {
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ void access$100(AwareStateListener r0) {
        r0.handleFeedbackPredictSwitch();
    }

    public static /* synthetic */ void access$1000(AwareStateListener r0) {
        r0.handleHarCollectLocal();
    }

    public static /* synthetic */ void access$1100(AwareStateListener r0) {
        r0.handleHarRawDataReport();
    }

    public static /* synthetic */ void access$1200(AwareStateListener r0) {
        r0.handleDeviceProvisioned();
    }

    public static /* synthetic */ void access$1300(AwareStateListener r0) {
        r0.handlePeriodicUploadMode();
    }

    public static /* synthetic */ void access$200(AwareStateListener r0) {
        r0.handleSubwayTestToolEnable();
    }

    public static /* synthetic */ void access$300(AwareStateListener r0) {
        r0.handleHarEventTestToolEnable();
    }

    public static /* synthetic */ void access$400(AwareStateListener r0) {
        r0.handleSubwayFeedbackSwitch();
    }

    public static /* synthetic */ Context access$500(AwareStateListener r0) {
        return r0.mContext;
    }

    public static /* synthetic */ void access$600(AwareStateListener r0) {
        r0.handleUserLocationStateChange();
    }

    public static /* synthetic */ void access$700(AwareStateListener r0) {
        r0.handleEnableWifiScanFunction();
    }

    public static /* synthetic */ void access$800(AwareStateListener r0) {
        r0.handleEnableHarNotification();
    }

    public static /* synthetic */ void access$900(AwareStateListener r0) {
        r0.handleHarEnable();
    }

    private ContentResolver getContentResolverSafe() {
        ContentResolver r0 = this.contentResolver;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Context r1 = this.mContext;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getContentResolver();
    }

    public static int getEnableWifiScanFunction(Context r2, ContentResolver r3) {
        return UserAwareUtil.getHostSettingsInt((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, SETTINGS_GLOBAL_ENABLE_WIFI_SCAN_FUNCTION, 0);
    }

    private static String getEnableWifiScanFunctionSettingsScope(Context r2) {
        return UserAwareUtil.getHostSettingsScope((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    public static Uri getEnableWifiScanFunctionUri(Context r2) {
        return UserAwareUtil.getHostSettingsUri((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), SETTINGS_GLOBAL_ENABLE_WIFI_SCAN_FUNCTION);
    }

    private String getHostSettingsString(String r3) {
        ContentResolver r0 = getContentResolverSafe();
        if (r0 != null) goto L5;
        return "";
    L5:
        String r2 = UserAwareUtil.getHostSettingsString(this.mContext, r0, r3);
        if (r2 != null) goto L8;
        return "";
    L8:
        return r2;
    }

    public static synchronized AwareStateListener getInstance() {
        monitor-enter(AwareStateListener.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (INSTANCE != null) goto L7;
        INSTANCE = new AwareStateListener();     // Catch: Throwable -> L10
    L7:
        AwareStateListener r1 = INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(AwareStateListener.class);
        return r1;
    }

    private String getSettingsGlobal(String r2) {
        ContentResolver r1 = getContentResolverSafe();
        if (r1 != null) goto L5;
        return "";
    L5:
        String r3 = Settings.Global.getString(r1, r2);
        if (r3 != null) goto L8;
        return "";
    L8:
        return r3;
    }

    private void handleDeviceProvisioned() {
        Message r1 = Message.obtain(null, 9);
        a.c(TAG, "handleDeviceProvisioned: " + r1);     // Catch: RemoteException -> L5
        this.mMessenger.send(r1);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        a.i(TAG, "handleDeviceProvisioned: " + e);
    }

    private void handleEnableHarNotification() {
        Message r1 = Message.obtain(null, 6);
        a.c(TAG, "handleEnableHarNotification: " + r1);     // Catch: RemoteException -> L5
        this.mMessenger.send(r1);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        a.i(TAG, "handleEnableHarNotification: " + e);
        throw new RuntimeException(e);
    }

    private void handleEnableWifiScanFunction() {
        if (this.mWifiAwareInfoManager != null) goto L5;
        return;
    L5:
        ContentResolver r1 = getContentResolverSafe();
        if (r1 != null) goto L20;
        return;
    L20:
        int r2 = getEnableWifiScanFunction(this.mContext, r1);     // Catch: Exception -> L17
        boolean r3 = false;
        if (r2 != 1) goto L11;
        this.mWifiAwareInfoManager.setEnableWifiScanFunction(true);     // Catch: Exception -> L17
    L12:
        String r4 = TAG;     // Catch: Exception -> L17
        StringBuilder r6 = new StringBuilder("Updated enable wifi scan function from Settings.").append(getEnableWifiScanFunctionSettingsScope(this.mContext)).append(", enable=");     // Catch: Exception -> L17
        if (r2 != 1) goto L15;
        r3 = true;
    L15:
        a.c(r4, r6.append(r3).toString());     // Catch: Exception -> L17
        return;
    L11:
        this.mWifiAwareInfoManager.setEnableWifiScanFunction(false);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        a.i(TAG, "Failed to parse enable_wifi_scan_function: " + e);
    }

    private void handleFeedbackPredictSwitch() {
        String r1 = getSettingsGlobal(SETTINGS_GLOBAL_USER_FEEDBACK_PREDICT_SWITCH);
        String r2 = TAG;
        a.c(r2, "onChange: mFeedbackPredictSwitchValue = " + r1);
        Message r3 = Message.obtain(null, 11);
        if (r1.equals("0") == false) goto L5;
    L6:
        r3.arg1 = Integer.parseInt(r1);
        a.c(r2, "handleFeedbackPredictSwitch: " + r3.obj);     // Catch: RemoteException -> L9
        this.mMessenger.send(r3);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        a.i(TAG, "handleNotifyLocationStateChange: " + e);
        return;
    L5:
        if (r1.equals("1") == true) goto L6;
    }

    private void handleHarCollectLocal() {
        ContentResolver r0 = getContentResolverSafe();
        boolean r1 = false;
        if (r0 != null) goto L6;
        mHarCollectLocal.set(false);
        return;
    L6:
        int r3 = UserAwareUtil.getHostSettingsInt(this.mContext, r0, SETTINGS_GLOBAL_HAR_COLLECT_LOCAL, 0);
        AtomicBoolean r2 = mHarCollectLocal;
        if (r3 == 0) goto L9;
        r1 = true;
    L9:
        r2.set(r1);
        a.e(TAG, "Updated mHarCollectLocal to " + r2.get());
    }

    private void handleHarEnable() {
        Message r1 = Message.obtain(null, 7);
        a.c(TAG, "handleHarEnable: " + r1);     // Catch: RemoteException -> L5
        this.mMessenger.send(r1);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        a.i(TAG, "handleHarEnable: " + e);
        throw new RuntimeException(e);
    }

    private void handleHarEventTestToolEnable() {
        String r1 = getSettingsGlobal(SETTINGS_GLOBAL_HAR_EVENT_TEST_TOOL_ENABLE);
        String r2 = TAG;
        a.c(r2, "onChange: harEventTestToolEnableValue = " + r1);
        Message r3 = Message.obtain(null, 14);
        if (r1.equals("0") == false) goto L5;
    L6:
        r3.arg1 = Integer.parseInt(r1);
        a.c(r2, "handleHarEventTestToolEnable: " + r3.arg1);     // Catch: RemoteException -> L9
        this.mMessenger.send(r3);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        a.i(TAG, "handleHarEventTestToolEnable: " + e);
        return;
    L5:
        if (r1.equals("1") == true) goto L6;
    }

    private void handleHarRawDataReport() {
        Message r1 = Message.obtain(null, 8);
        a.c(TAG, "handleHarWakeLockTime: " + r1);     // Catch: RemoteException -> L5
        this.mMessenger.send(r1);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        a.i(TAG, "handleHarWakeLockTime: " + e);
    }

    private void handlePeriodicUploadMode() {
        Message r1 = Message.obtain(null, 2);
        a.c(TAG, "handlePeriodicUploadMode: " + r1);     // Catch: RemoteException -> L5
        this.mMessenger.send(r1);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        a.i(TAG, "handlePeriodicUploadMode: " + e);
    }

    private void handleSubwayFeedbackSwitch() {
        String r1 = getSettingsGlobal(SETTINGS_GLOBAL_SUBWAY_FEEDBACK_SWITCH);
        String r2 = TAG;
        a.c(r2, "onChange: subwayFeedbackSwitchValue = " + r1);
        Message r3 = Message.obtain(null, 13);
        if (r1.equals("0") == false) goto L5;
    L6:
        r3.arg1 = Integer.parseInt(r1);
        a.c(r2, "handleSubwayFeedbackSwitch: " + r3.arg1);     // Catch: RemoteException -> L9
        this.mMessenger.send(r3);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        a.i(TAG, "handleSubwayFeedbackSwitch: " + e);
        return;
    L5:
        if (r1.equals("1") == true) goto L6;
    }

    private void handleSubwayTestToolEnable() {
        String r1 = getSettingsGlobal(SETTINGS_GLOBAL_SUBWAY_TEST_TOOL_ENABLE);
        String r2 = TAG;
        a.c(r2, "onChange: subwayTestToolEnableValue = " + r1);
        Message r3 = Message.obtain(null, 12);
        if (r1.equals("0") == false) goto L5;
    L6:
        r3.arg1 = Integer.parseInt(r1);
        a.c(r2, "handleSubwayTestToolEnable: " + r3.arg1);     // Catch: RemoteException -> L9
        this.mMessenger.send(r3);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        a.i(TAG, "handleSubwayTestToolEnable: " + e);
        return;
    L5:
        if (r1.equals("1") == true) goto L6;
    }

    private void handleUserLocationStateChange() {
        final String r1 = getLocationChangeStateValue();
        String r2 = TAG;
        a.c(r2, "onChange: mLocationStateChangeValue = " + r1);
        if (r1 != null) goto L5;
        return;
    L5:
        if (UserAwareUtil.getStateChangeString(this.mContext, r1).isEmpty() == false) goto L8;
        return;
    L8:
        if (r1.equals(DEFAULT_AWARE_STATE) == true) goto L15;
        Message r3 = Message.obtain(null, 5);
        r3.obj = r1;
        a.c(r2, "handleNotifyLocationStateChange: " + r3.obj);     // Catch: RemoteException -> L12
        this.mMessenger.send(r3);     // Catch: RemoteException -> L12
    L12:
        e = move-exception;
        a.i(TAG, "handleNotifyLocationStateChange: " + e);
    L15:
        if ("1".equals(getSettingsGlobal(SETTINGS_GLOBAL_USER_FEEDBACK_PREDICT_SWITCH)) == false) goto L21;
        new Handler(Looper.getMainLooper()).post(new $$Lambda$AwareStateListener$yHVVVcl2FcGYbuMrAwbkJkJ07E(this, r1));
        return;
    }

    public static boolean isHarCollectLocal() {
        return mHarCollectLocal.get();
    }

    private void registerUserDebugObserver() {
        String r0 = TAG;
        a.c(r0, "registerSettingsObserver");
        if (this.contentResolver != null) goto L5;
    L44:
        a.i(r0, "registerSettingsObserver skipped: contentResolver or settingsObserver is null");
        return;
    L5:
        if (this.settingsObserver == null) goto L44;
        Uri r1 = Settings.Global.getUriFor(SETTINGS_GLOBAL_USER_FEEDBACK_PREDICT_SWITCH);
        if (r1 == null) goto L10;
        ZeusProviderTransform.registerContentObserver(this.contentResolver, r1, false, this.settingsObserver, "com.obric.memorydata.plugin");
    L10:
        Uri r2 = Settings.Global.getUriFor(SETTINGS_GLOBAL_SUBWAY_TEST_TOOL_ENABLE);
        if (r2 == null) goto L13;
        ZeusProviderTransform.registerContentObserver(this.contentResolver, r2, false, this.settingsObserver, "com.obric.memorydata.plugin");
    L13:
        Uri r3 = Settings.Global.getUriFor(SETTINGS_GLOBAL_HAR_EVENT_TEST_TOOL_ENABLE);
        if (r3 == null) goto L16;
        ZeusProviderTransform.registerContentObserver(this.contentResolver, r3, false, this.settingsObserver, "com.obric.memorydata.plugin");
    L16:
        Uri r4 = Settings.Global.getUriFor(SETTINGS_GLOBAL_SUBWAY_FEEDBACK_SWITCH);
        if (r4 == null) goto L19;
        ZeusProviderTransform.registerContentObserver(this.contentResolver, r4, false, this.settingsObserver, "com.obric.memorydata.plugin");
    L19:
        Uri r5 = UserAwareUtil.getHostSettingsUri(this.mContext, SETTINGS_GLOBAL_USER_LOCATION_CHANGE);
        if (r5 == null) goto L22;
        ZeusProviderTransform.registerContentObserver(this.contentResolver, r5, false, this.settingsObserver, "com.obric.memorydata.plugin");
    L22:
        Uri r6 = getEnableWifiScanFunctionUri(this.mContext);
        if (r6 == null) goto L25;
        ZeusProviderTransform.registerContentObserver(this.contentResolver, r6, false, this.settingsObserver, "com.obric.memorydata.plugin");
    L25:
        Uri r7 = Settings.Global.getUriFor(SETTINGS_GLOBAL_ENABLE_HAR_NOTIFICATION);
        if (r7 == null) goto L28;
        ZeusProviderTransform.registerContentObserver(this.contentResolver, r7, false, this.settingsObserver, "com.obric.memorydata.plugin");
    L28:
        Uri r8 = Settings.Global.getUriFor(SETTINGS_GLOBAL_ENABLE_HAR);
        if (r8 == null) goto L31;
        ZeusProviderTransform.registerContentObserver(this.contentResolver, r8, false, this.settingsObserver, "com.obric.memorydata.plugin");
    L31:
        handleHarCollectLocal();
        Uri r9 = UserAwareUtil.getHostSettingsUri(this.mContext, SETTINGS_GLOBAL_HAR_COLLECT_LOCAL);
        if (r9 == null) goto L34;
        ZeusProviderTransform.registerContentObserver(this.contentResolver, r9, false, this.settingsObserver, "com.obric.memorydata.plugin");
    L34:
        Uri r10 = Settings.Global.getUriFor(SETTINGS_GLOBAL_HAR_RAW_DATA_REPORT);
        if (r10 == null) goto L37;
        ZeusProviderTransform.registerContentObserver(this.contentResolver, r10, false, this.settingsObserver, "com.obric.memorydata.plugin");
    L37:
        Uri r11 = Settings.Global.getUriFor("device_provisioned");
        if (r11 == null) goto L40;
        ZeusProviderTransform.registerContentObserver(this.contentResolver, r11, false, this.settingsObserver, "com.obric.memorydata.plugin");
    L40:
        Uri r12 = Settings.Global.getUriFor(SETTINGS_GLOBAL_USER_PERIODIC_UPLOAD_MODE);
        if (r12 == null) goto L46;
        ZeusProviderTransform.registerContentObserver(this.contentResolver, r12, false, this.settingsObserver, "com.obric.memorydata.plugin");
        return;
    }

    public int getHAREnableValue() {
        ContentResolver r2 = getContentResolverSafe();
        if (r2 != null) goto L6;
        return 0;
    L6:
        return Settings.Global.getInt(r2, SETTINGS_GLOBAL_ENABLE_HAR, 0);
    }

    public String getLearningProgressValue() {
        return getHostSettingsString(SETTINGS_GLOBAL_USER_LEARNING_PROGRESS);
    }

    public String getLocationChangeStateValue() {
        return getHostSettingsString(SETTINGS_GLOBAL_USER_LOCATION_CHANGE);
    }

    public String getLocationStateValueDesc() {
        Context r0 = this.mContext;
        if (r0 != null) goto L7;
        return "";
    L7:
        return UserAwareUtil.getCurrentLocationString(r0, getHostSettingsString(SETTINGS_GLOBAL_USER_LOCATION_STATE));
    }

    public void initOnce(Context r4, Messenger r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        a.c(TAG, CommonConsts.APM_INNER_EVENT_COST_START);
        this.mContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.mMessenger = r5;
        if (r6 == null) goto L5;
        ContentResolver r7 = r6.getContentResolver();
    L6:
        this.contentResolver = r7;
        this.settingsObserver = new SettingsObserver(this, new Handler(Looper.getMainLooper()));
        registerUserDebugObserver();
        return;
    L5:
        r7 = null;
        goto L6
    }

    public /* synthetic */ void lambda$handleUserLocationStateChange$0$AwareStateListener(String r2) {
        String r3 = UserAwareUtil.getStateChangeString(this.mContext, r2);
        Toast.makeText(this.mContext, r3, 0).show();
    }

    public void loadSaveWifiScanParams() {
    }

    public void setWifiScanStateMachine(WifiAwareInfoManager r1) {
        this.mWifiAwareInfoManager = r1;
    }

    public void unregisterSettingsObserver() {
        ContentResolver r0 = this.contentResolver;
        if (r0 == null) goto L9;
        SettingsObserver r2 = this.settingsObserver;
        if (r2 == null) goto L10;
        ZeusProviderTransform.unregisterContentObserver(r0, r2, "com.obric.memorydata.plugin");
        return;
    L10:
        return;
    }
}
