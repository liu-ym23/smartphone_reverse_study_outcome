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
import com.obric.cae.libs.useraware.RssiDropThreshold;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.WifiAwareInfoManager;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.cae.userAware.utils.UserAwareUtil;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
import s1.x;

/* JADX INFO: loaded from: classes2.dex */
public class AwareStateListener {
    private static final String CHANNEL_ID = "UserAwareChannel";
    private static final String DEFAULT_AWARE_STATE = "null";
    public static final int DEFAULT_ENABLE_POI_DETECT_FUNCTION = 0;
    public static final int DEFAULT_ENABLE_WIFI_SCAN_FUNCTION = 0;
    private static final int DEFAULT_HAR_COLLECT_LOCAL = 0;
    public static final int DEFAULT_HAR_NOTIFICATION_DISABLED = 0;
    public static final int DEFAULT_HAR_RAW_DATA_REPORT = 0;
    public static final int DEFAULT_HAR_STATE = -1;
    public static final int DEFAULT_HAR_WAKELOCK_TIME = 0;
    public static final float DEFAULT_POI_CONFIDENCE_THRESHOLD = 0.67f;
    public static final int DEFAULT_POI_STATIONARY_DELAY_SECONDS = 20;
    public static final long DEFAULT_POI_STATIONARY_STEP_CHECK_INTERVAL_MS = 60000;
    public static final int DEFAULT_POI_STATIONARY_STEP_DELTA_THRESHOLD = 10;
    public static final int DEFAULT_POI_WALK_STEP_THRESHOLD = 150;
    public static final int DEFAULT_SUBWAY_STATE = -1;
    public static final int DEFAULT_WIFI_SCAN_DAILY_CAP = 500;
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
    public static final String SETTINGS_GLOBAL_ENABLE_HAR = "cae_user_aware_enable_har";
    public static final String SETTINGS_GLOBAL_ENABLE_HAR_NOTIFICATION = "cae_user_aware_enable_har_notification";
    public static final String SETTINGS_GLOBAL_ENABLE_POI_DETECT_FUNCTION = "cae_user_aware_enable_poi_detect_function";
    public static final String SETTINGS_GLOBAL_ENABLE_WIFI_SCAN_FUNCTION = "cae_user_aware_enable_wifi_scan_function";
    public static final String SETTINGS_GLOBAL_HAR_COLLECT_LOCAL = "cae_user_har_collect_local";
    public static final String SETTINGS_GLOBAL_HAR_EVENT_TEST_TOOL_ENABLE = "cae_har_event_test_tool_enable";
    public static final String SETTINGS_GLOBAL_HAR_RAW_DATA_REPORT = "cae_user_har_raw_data_report";
    public static final String SETTINGS_GLOBAL_HAR_STATE = "cae_user_har_state";
    public static final String SETTINGS_GLOBAL_NORMAL_RSSI_DROP_LIST = "cae_user_aware_normal_rssi_drop_thresholds";
    public static final String SETTINGS_GLOBAL_NORMAL_SCAN_PARAMS = "cae_user_aware_normal_scan_params";
    public static final String SETTINGS_GLOBAL_POI_CONFIDENCE_THRESHOLD = "cae_user_aware_poi_confidence_threshold";
    public static final String SETTINGS_GLOBAL_POI_STATIONARY_DELAY_SECONDS = "cae_user_aware_poi_stationary_delay_seconds";
    public static final String SETTINGS_GLOBAL_POI_STATIONARY_STEP_CHECK_INTERVAL_MS = "cae_user_aware_poi_stationary_step_check_interval_ms";
    public static final String SETTINGS_GLOBAL_POI_STATIONARY_STEP_DELTA_THRESHOLD = "cae_user_aware_poi_stationary_step_delta_threshold";
    public static final String SETTINGS_GLOBAL_POI_WALK_STEP_THRESHOLD = "cae_user_aware_poi_walk_step_threshold";
    public static final String SETTINGS_GLOBAL_SUBWAY_FEEDBACK_SWITCH = "cae_subway_feedback_switch";
    public static final String SETTINGS_GLOBAL_SUBWAY_STATE = "cae_subway_state";
    public static final String SETTINGS_GLOBAL_SUBWAY_TEST_TOOL_ENABLE = "cae_subway_test_tool_enable";
    public static final String SETTINGS_GLOBAL_TRAINING_SCAN_PARAMS = "cae_user_aware_training_scan_params";
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
    private WifiScanStateMachine mWifiScanStateMachine;
    private SettingsObserver settingsObserver;

    public class SettingsObserver extends ContentObserver {
        final /* synthetic */ AwareStateListener this$0;

        public SettingsObserver(AwareStateListener r8, Handler r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r8, Uri r10) {
            super.onChange(r8, r10);
            if (r10 == null) goto L57;
            CommSenseLog.d(AwareStateListener.access$000(), "Settings changed: " + r10);     // Catch: Exception -> L50
            if (r10.equals(Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_USER_FEEDBACK_PREDICT_SWITCH)) == false) goto L8;
            AwareStateListener.access$100(this.this$0);     // Catch: Exception -> L50
        L54:
            return;
        L8:
            if (r10.equals(Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_SUBWAY_TEST_TOOL_ENABLE)) == false) goto L11;
            AwareStateListener.access$200(this.this$0);     // Catch: Exception -> L50
            goto L54
        L11:
            if (r10.equals(Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_HAR_EVENT_TEST_TOOL_ENABLE)) == false) goto L14;
            AwareStateListener.access$300(this.this$0);     // Catch: Exception -> L50
            goto L54
        L14:
            if (r10.equals(Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_SUBWAY_FEEDBACK_SWITCH)) == false) goto L17;
            AwareStateListener.access$400(this.this$0);     // Catch: Exception -> L50
            goto L54
        L17:
            if (r10.equals(Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_USER_LOCATION_CHANGE)) == false) goto L20;
            AwareStateListener.access$500(this.this$0);     // Catch: Exception -> L50
            goto L54
        L20:
            if (r10.equals(Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_NORMAL_SCAN_PARAMS)) == false) goto L23;
            AwareStateListener.access$600(this.this$0);     // Catch: Exception -> L50
            goto L54
        L23:
            if (r10.equals(Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_TRAINING_SCAN_PARAMS)) == false) goto L26;
            AwareStateListener.access$700(this.this$0);     // Catch: Exception -> L50
            goto L54
        L26:
            if (r10.equals(Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_NORMAL_RSSI_DROP_LIST)) == false) goto L29;
            AwareStateListener.access$800(this.this$0);     // Catch: Exception -> L50
            goto L54
        L29:
            if (r10.equals(Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_ENABLE_WIFI_SCAN_FUNCTION)) == false) goto L32;
            AwareStateListener.access$900(this.this$0);     // Catch: Exception -> L50
            goto L54
        L32:
            if (r10.equals(Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR_NOTIFICATION)) == false) goto L35;
            AwareStateListener.access$1000(this.this$0);     // Catch: Exception -> L50
            goto L54
        L35:
            if (r10.equals(Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR)) == false) goto L38;
            AwareStateListener.access$1100(this.this$0);     // Catch: Exception -> L50
            goto L54
        L38:
            if (r10.equals(Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_HAR_COLLECT_LOCAL)) == false) goto L41;
            AwareStateListener.access$1200(this.this$0);     // Catch: Exception -> L50
            goto L54
        L41:
            if (r10.equals(Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_HAR_RAW_DATA_REPORT)) == false) goto L44;
            AwareStateListener.access$1300(this.this$0);     // Catch: Exception -> L50
            goto L54
        L44:
            if (r10.equals(Settings.Global.getUriFor("device_provisioned")) == false) goto L47;
            AwareStateListener.access$1400(this.this$0);     // Catch: Exception -> L50
            goto L54
        L47:
            if (r10.equals(Settings.Global.getUriFor(AwareStateListener.SETTINGS_GLOBAL_USER_PERIODIC_UPLOAD_MODE)) == false) goto L54;
            AwareStateListener.access$1500(this.this$0);     // Catch: Exception -> L50
        L50:
            e = move-exception;
            throw new RuntimeException(e);
        }
    }

    static {
        mHarCollectLocal = new AtomicBoolean(false);
    }

    public AwareStateListener() {
    }

    public static /* synthetic */ void a(AwareStateListener r8, String r10) {
        r8.lambda$handleUserLocationStateChange$0(r10);
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ void access$100(AwareStateListener r8) {
        r8.handleFeedbackPredictSwitch();
    }

    public static /* synthetic */ void access$1000(AwareStateListener r8) {
        r8.handleEnableHarNotification();
    }

    public static /* synthetic */ void access$1100(AwareStateListener r8) {
        r8.handleHarEnable();
    }

    public static /* synthetic */ void access$1200(AwareStateListener r8) {
        r8.handleHarCollectLocal();
    }

    public static /* synthetic */ void access$1300(AwareStateListener r8) {
        r8.handleHarRawDataReport();
    }

    public static /* synthetic */ void access$1400(AwareStateListener r8) {
        r8.handleDeviceProvisioned();
    }

    public static /* synthetic */ void access$1500(AwareStateListener r8) {
        r8.handlePeriodicUploadMode();
    }

    public static /* synthetic */ void access$200(AwareStateListener r8) {
        r8.handleSubwayTestToolEnable();
    }

    public static /* synthetic */ void access$300(AwareStateListener r8) {
        r8.handleHarEventTestToolEnable();
    }

    public static /* synthetic */ void access$400(AwareStateListener r8) {
        r8.handleSubwayFeedbackSwitch();
    }

    public static /* synthetic */ void access$500(AwareStateListener r8) {
        r8.handleUserLocationStateChange();
    }

    public static /* synthetic */ void access$600(AwareStateListener r8) {
        r8.handleNormalScanParams();
    }

    public static /* synthetic */ void access$700(AwareStateListener r8) {
        r8.handleTrainingScanParams();
    }

    public static /* synthetic */ void access$800(AwareStateListener r8) {
        r8.handleNormalRssiDropList();
    }

    public static /* synthetic */ void access$900(AwareStateListener r8) {
        r8.handleEnableWifiScanFunction();
    }

    private ContentResolver getContentResolverSafe() {
        ContentResolver r8 = this.contentResolver;
        if (r8 == null) goto L5;
        return r8;
    L5:
        Context r10 = this.mContext;
        if (r10 != null) goto L8;
        return null;
    L8:
        return r10.getContentResolver();
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
        AwareStateListener r8 = INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(AwareStateListener.class);
        return r8;
    }

    private String getSettingsGlobal(String r8) {
        ContentResolver r10 = getContentResolverSafe();
        if (r10 != null) goto L5;
        return "";
    L5:
        String r11 = Settings.Global.getString(r10, r8);
        if (r11 != null) goto L8;
        return "";
    L8:
        return r11;
    }

    private void handleDeviceProvisioned() {
        Message r8 = Message.obtain(null, 9);
        CommSenseLog.d(TAG, "handleDeviceProvisioned: " + r8);     // Catch: RemoteException -> L5
        this.mMessenger.send(r8);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        CommSenseLog.e(TAG, "handleDeviceProvisioned: " + e);
    }

    private void handleEnableHarNotification() {
        Message r8 = Message.obtain(null, 6);
        CommSenseLog.d(TAG, "handleEnableHarNotification: " + r8);     // Catch: RemoteException -> L5
        this.mMessenger.send(r8);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        CommSenseLog.e(TAG, "handleEnableHarNotification: " + e);
        throw new RuntimeException(e);
    }

    private void handleEnableWifiScanFunction() {
        if (this.mWifiAwareInfoManager != null) goto L5;
        return;
    L5:
        ContentResolver r8 = getContentResolverSafe();
        if (r8 != null) goto L17;
        return;
    L17:
        int r10 = Settings.Global.getInt(r8, SETTINGS_GLOBAL_ENABLE_WIFI_SCAN_FUNCTION, 0);     // Catch: Exception -> L14
        if (r10 != 1) goto L11;
        this.mWifiAwareInfoManager.setEnableWifiScanFunction(true);     // Catch: Exception -> L14
    L12:
        CommSenseLog.d(TAG, "Updated enable wifi scan function from Settings.Global, enable=" + r10);     // Catch: Exception -> L14
        return;
    L11:
        this.mWifiAwareInfoManager.setEnableWifiScanFunction(false);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to parse enable_wifi_scan_function: " + e);
    }

    private void handleFeedbackPredictSwitch() {
        String r8 = getSettingsGlobal(SETTINGS_GLOBAL_USER_FEEDBACK_PREDICT_SWITCH);
        String r10 = TAG;
        CommSenseLog.d(r10, "onChange: mFeedbackPredictSwitchValue = " + r8);
        Message r11 = Message.obtain(null, 11);
        if (r8.equals("0") == false) goto L5;
    L6:
        r11.arg1 = Integer.parseInt(r8);
        CommSenseLog.d(r10, "handleFeedbackPredictSwitch: " + r11.obj);     // Catch: RemoteException -> L9
        this.mMessenger.send(r11);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        CommSenseLog.e(TAG, "handleNotifyLocationStateChange: " + e);
        return;
    L5:
        if (r8.equals("1") == true) goto L6;
    }

    private void handleHarCollectLocal() {
        ContentResolver r8 = getContentResolverSafe();
        boolean r10 = false;
        if (r8 != null) goto L6;
        mHarCollectLocal.set(false);
        return;
    L6:
        int r11 = Settings.Global.getInt(r8, SETTINGS_GLOBAL_HAR_COLLECT_LOCAL, 0);
        AtomicBoolean r12 = mHarCollectLocal;
        if (r11 == 0) goto L9;
        r10 = true;
    L9:
        r12.set(r10);
        CommSenseLog.i(TAG, "Updated mHarCollectLocal to " + r12.get());
    }

    private void handleHarEnable() {
        Message r8 = Message.obtain(null, 7);
        CommSenseLog.d(TAG, "handleHarEnable: " + r8);     // Catch: RemoteException -> L5
        this.mMessenger.send(r8);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        CommSenseLog.e(TAG, "handleHarEnable: " + e);
        throw new RuntimeException(e);
    }

    private void handleHarEventTestToolEnable() {
        String r8 = getSettingsGlobal(SETTINGS_GLOBAL_HAR_EVENT_TEST_TOOL_ENABLE);
        String r10 = TAG;
        CommSenseLog.d(r10, "onChange: harEventTestToolEnableValue = " + r8);
        Message r11 = Message.obtain(null, 14);
        if (r8.equals("0") == false) goto L5;
    L6:
        r11.arg1 = Integer.parseInt(r8);
        CommSenseLog.d(r10, "handleHarEventTestToolEnable: " + r11.arg1);     // Catch: RemoteException -> L9
        this.mMessenger.send(r11);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        CommSenseLog.e(TAG, "handleHarEventTestToolEnable: " + e);
        return;
    L5:
        if (r8.equals("1") == true) goto L6;
    }

    private void handleHarRawDataReport() {
        Message r8 = Message.obtain(null, 8);
        CommSenseLog.d(TAG, "handleHarWakeLockTime: " + r8);     // Catch: RemoteException -> L5
        this.mMessenger.send(r8);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        CommSenseLog.e(TAG, "handleHarWakeLockTime: " + e);
    }

    private void handleNormalRssiDropList() {
        if (this.mWifiScanStateMachine != null) goto L25;
        return;
    L25:
        String r8 = getSettingsGlobal(SETTINGS_GLOBAL_NORMAL_RSSI_DROP_LIST);     // Catch: Exception -> L22
        if (r8.isEmpty() == true) goto L32;
        JSONArray r10 = new JSONArray(r8);     // Catch: Exception -> L22
        ArrayList r11 = new ArrayList();     // Catch: Exception -> L22
        int r12 = 0;
    L9:
        if (r12 >= r10.length()) goto L19;
        JSONObject r13 = r10.optJSONObject(r12);     // Catch: Exception -> L22
        if (r13 == null) goto L17;
        int r14 = r13.optInt("durationSec", -1);     // Catch: Exception -> L22
        int r15 = r13.optInt("dropDb", -1);     // Catch: Exception -> L22
        if (r14 <= 0) goto L17;
        if (r15 <= 0) goto L17;
        r11.add(new RssiDropThreshold(r14, r15));     // Catch: Exception -> L22
    L17:
        r12 = r12 + 1;     // Catch: Exception -> L22
        goto L9
    L19:
        if (r11.isEmpty() == true) goto L33;
        this.mWifiScanStateMachine.setRssiDropThresholdList(r11);     // Catch: Exception -> L22
        CommSenseLog.d(TAG, "Updated normal RSSI drop thresholds from Settings.Global, size=" + r11.size());     // Catch: Exception -> L22
        return;
    L33:
        return;
    L32:
        return;
    L22:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to parse normal_rssi_drop_thresholds: " + e);
    }

    private void handleNormalScanParams() {
        if (this.mWifiScanStateMachine != null) goto L12;
        return;
    L12:
        String r8 = getSettingsGlobal(SETTINGS_GLOBAL_NORMAL_SCAN_PARAMS);     // Catch: Exception -> L9
        if (r8.isEmpty() == true) goto L14;
        JSONObject r10 = new JSONObject(r8);     // Catch: Exception -> L9
        long r11 = r10.optLong("geoInterval", 5000);     // Catch: Exception -> L9
        long r13 = r10.optLong("geoDuration", 600000);     // Catch: Exception -> L9
        long r12 = r10.optLong("wifiDuration", 300000);     // Catch: Exception -> L9
        long r14 = r10.optLong("indoorDuration", 20000);     // Catch: Exception -> L9
        this.mWifiScanStateMachine.setNormalScanParams(r11, r13, r12, r14);     // Catch: Exception -> L9
        CommSenseLog.d(TAG, "Updated normal scan params from Settings.Global geoInterval=" + r11 + " geoDuration=" + r13 + " wifiDuration=" + r12 + " indoorDuration=" + r14);     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to parse normal_scan_params: " + e);
    }

    private void handlePeriodicUploadMode() {
        Message r8 = Message.obtain(null, 2);
        CommSenseLog.d(TAG, "handlePeriodicUploadMode: " + r8);     // Catch: RemoteException -> L5
        this.mMessenger.send(r8);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        CommSenseLog.e(TAG, "handlePeriodicUploadMode: " + e);
    }

    private void handleSubwayFeedbackSwitch() {
        String r8 = getSettingsGlobal(SETTINGS_GLOBAL_SUBWAY_FEEDBACK_SWITCH);
        String r10 = TAG;
        CommSenseLog.d(r10, "onChange: subwayFeedbackSwitchValue = " + r8);
        Message r11 = Message.obtain(null, 13);
        if (r8.equals("0") == false) goto L5;
    L6:
        r11.arg1 = Integer.parseInt(r8);
        CommSenseLog.d(r10, "handleSubwayFeedbackSwitch: " + r11.arg1);     // Catch: RemoteException -> L9
        this.mMessenger.send(r11);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        CommSenseLog.e(TAG, "handleSubwayFeedbackSwitch: " + e);
        return;
    L5:
        if (r8.equals("1") == true) goto L6;
    }

    private void handleSubwayTestToolEnable() {
        String r8 = getSettingsGlobal(SETTINGS_GLOBAL_SUBWAY_TEST_TOOL_ENABLE);
        String r10 = TAG;
        CommSenseLog.d(r10, "onChange: subwayTestToolEnableValue = " + r8);
        Message r11 = Message.obtain(null, 12);
        if (r8.equals("0") == false) goto L5;
    L6:
        r11.arg1 = Integer.parseInt(r8);
        CommSenseLog.d(r10, "handleSubwayTestToolEnable: " + r11.arg1);     // Catch: RemoteException -> L9
        this.mMessenger.send(r11);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        CommSenseLog.e(TAG, "handleSubwayTestToolEnable: " + e);
        return;
    L5:
        if (r8.equals("1") == true) goto L6;
    }

    private void handleTrainingScanParams() {
        if (this.mWifiScanStateMachine != null) goto L12;
        return;
    L12:
        String r8 = getSettingsGlobal(SETTINGS_GLOBAL_TRAINING_SCAN_PARAMS);     // Catch: Exception -> L9
        if (r8.isEmpty() == true) goto L14;
        JSONObject r10 = new JSONObject(r8);     // Catch: Exception -> L9
        long r11 = r10.optLong("geoInterval", 2000);     // Catch: Exception -> L9
        long r13 = r10.optLong("geoDuration", WifiScanStateMachine.DEFAULT_GEO_SCANNING_DURATION_TRAINING);     // Catch: Exception -> L9
        long r12 = r10.optLong("wifiDuration", 600000);     // Catch: Exception -> L9
        long r14 = r10.optLong("indoorDuration", 120000);     // Catch: Exception -> L9
        this.mWifiScanStateMachine.setTrainingScanParams(r11, r13, r12, r14);     // Catch: Exception -> L9
        CommSenseLog.d(TAG, "Updated training scan params from Settings.Global geoInterval=" + r11 + " geoDuration=" + r13 + " wifiDuration=" + r12 + " indoorDuration=" + r14);     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to parse training_scan_params: " + e);
    }

    private void handleUserLocationStateChange() {
        String r8 = getLocationChangeStateValue();
        String r10 = TAG;
        CommSenseLog.d(r10, "onChange: mLocationStateChangeValue = " + r8);
        if (r8 != null) goto L5;
        return;
    L5:
        if (UserAwareUtil.getStateChangeString(this.mContext, r8).isEmpty() == false) goto L8;
        return;
    L8:
        if (r8.equals(DEFAULT_AWARE_STATE) == true) goto L15;
        Message r11 = Message.obtain(null, 5);
        r11.obj = r8;
        CommSenseLog.d(r10, "handleNotifyLocationStateChange: " + r11.obj);     // Catch: RemoteException -> L12
        this.mMessenger.send(r11);     // Catch: RemoteException -> L12
    L12:
        e = move-exception;
        CommSenseLog.e(TAG, "handleNotifyLocationStateChange: " + e);
    L15:
        if ("1".equals(getSettingsGlobal(SETTINGS_GLOBAL_USER_FEEDBACK_PREDICT_SWITCH)) == false) goto L21;
        new Handler(Looper.getMainLooper()).post(new x(9, this, r8));
        return;
    }

    public static boolean isHarCollectLocal() {
        return mHarCollectLocal.get();
    }

    private /* synthetic */ void lambda$handleUserLocationStateChange$0(String r8) {
        String r10 = UserAwareUtil.getStateChangeString(this.mContext, r8);
        Toast.makeText(this.mContext, r10, 0).show();
    }

    private void registerUserDebugObserver() {
        String r8 = TAG;
        CommSenseLog.d(r8, "registerSettingsObserver");
        if (this.contentResolver != null) goto L5;
    L53:
        CommSenseLog.e(r8, "registerSettingsObserver skipped: contentResolver or settingsObserver is null");
        return;
    L5:
        if (this.settingsObserver == null) goto L53;
        Uri r10 = Settings.Global.getUriFor(SETTINGS_GLOBAL_USER_FEEDBACK_PREDICT_SWITCH);
        if (r10 == null) goto L10;
        this.contentResolver.registerContentObserver(r10, false, this.settingsObserver);
    L10:
        Uri r11 = Settings.Global.getUriFor(SETTINGS_GLOBAL_SUBWAY_TEST_TOOL_ENABLE);
        if (r11 == null) goto L13;
        this.contentResolver.registerContentObserver(r11, false, this.settingsObserver);
    L13:
        Uri r12 = Settings.Global.getUriFor(SETTINGS_GLOBAL_HAR_EVENT_TEST_TOOL_ENABLE);
        if (r12 == null) goto L16;
        this.contentResolver.registerContentObserver(r12, false, this.settingsObserver);
    L16:
        Uri r13 = Settings.Global.getUriFor(SETTINGS_GLOBAL_SUBWAY_FEEDBACK_SWITCH);
        if (r13 == null) goto L19;
        this.contentResolver.registerContentObserver(r13, false, this.settingsObserver);
    L19:
        Uri r14 = Settings.Global.getUriFor(SETTINGS_GLOBAL_USER_LOCATION_CHANGE);
        if (r14 == null) goto L22;
        this.contentResolver.registerContentObserver(r14, false, this.settingsObserver);
    L22:
        Uri r15 = Settings.Global.getUriFor(SETTINGS_GLOBAL_NORMAL_SCAN_PARAMS);
        if (r15 == null) goto L25;
        this.contentResolver.registerContentObserver(r15, false, this.settingsObserver);
    L25:
        Uri r16 = Settings.Global.getUriFor(SETTINGS_GLOBAL_TRAINING_SCAN_PARAMS);
        if (r16 == null) goto L28;
        this.contentResolver.registerContentObserver(r16, false, this.settingsObserver);
    L28:
        Uri r17 = Settings.Global.getUriFor(SETTINGS_GLOBAL_NORMAL_RSSI_DROP_LIST);
        if (r17 == null) goto L31;
        this.contentResolver.registerContentObserver(r17, false, this.settingsObserver);
    L31:
        Uri r18 = Settings.Global.getUriFor(SETTINGS_GLOBAL_ENABLE_WIFI_SCAN_FUNCTION);
        if (r18 == null) goto L34;
        this.contentResolver.registerContentObserver(r18, false, this.settingsObserver);
    L34:
        Uri r19 = Settings.Global.getUriFor(SETTINGS_GLOBAL_ENABLE_HAR_NOTIFICATION);
        if (r19 == null) goto L37;
        this.contentResolver.registerContentObserver(r19, false, this.settingsObserver);
    L37:
        Uri r20 = Settings.Global.getUriFor(SETTINGS_GLOBAL_ENABLE_HAR);
        if (r20 == null) goto L40;
        this.contentResolver.registerContentObserver(r20, false, this.settingsObserver);
    L40:
        handleHarCollectLocal();
        Uri r21 = Settings.Global.getUriFor(SETTINGS_GLOBAL_HAR_COLLECT_LOCAL);
        if (r21 == null) goto L43;
        this.contentResolver.registerContentObserver(r21, false, this.settingsObserver);
    L43:
        Uri r22 = Settings.Global.getUriFor(SETTINGS_GLOBAL_HAR_RAW_DATA_REPORT);
        if (r22 == null) goto L46;
        this.contentResolver.registerContentObserver(r22, false, this.settingsObserver);
    L46:
        Uri r23 = Settings.Global.getUriFor("device_provisioned");
        if (r23 == null) goto L49;
        this.contentResolver.registerContentObserver(r23, false, this.settingsObserver);
    L49:
        Uri r24 = Settings.Global.getUriFor(SETTINGS_GLOBAL_USER_PERIODIC_UPLOAD_MODE);
        if (r24 == null) goto L55;
        this.contentResolver.registerContentObserver(r24, false, this.settingsObserver);
        return;
    }

    public int getHAREnableValue() {
        ContentResolver r8 = getContentResolverSafe();
        if (r8 != null) goto L6;
        return 0;
    L6:
        return Settings.Global.getInt(r8, SETTINGS_GLOBAL_ENABLE_HAR, 0);
    }

    public String getLearningProgressValue() {
        return getSettingsGlobal(SETTINGS_GLOBAL_USER_LEARNING_PROGRESS);
    }

    public String getLocationChangeStateValue() {
        return getSettingsGlobal(SETTINGS_GLOBAL_USER_LOCATION_CHANGE);
    }

    public String getLocationStateValueDesc() {
        Context r8 = this.mContext;
        if (r8 != null) goto L7;
        return "";
    L7:
        return UserAwareUtil.getCurrentLocationString(r8, getSettingsGlobal("user_location_state"));
    }

    public void initOnce(Context r8, Messenger r10) {
        CommSenseLog.d(TAG, "start");
        this.mContext = r8;
        this.mMessenger = r10;
        if (r8 == null) goto L5;
        ContentResolver r11 = r8.getContentResolver();
    L6:
        this.contentResolver = r11;
        this.settingsObserver = new SettingsObserver(this, new Handler(Looper.getMainLooper()));
        registerUserDebugObserver();
        return;
    L5:
        r11 = null;
        goto L6
    }

    public void loadSaveWifiScanParams() {
        handleNormalScanParams();
        handleTrainingScanParams();
        handleNormalRssiDropList();
    }

    public void setWifiScanStateMachine(WifiAwareInfoManager r8) {
        this.mWifiAwareInfoManager = r8;
        this.mWifiScanStateMachine = r8.getWifiScanStateMachine();
    }

    public void unregisterSettingsObserver() {
        ContentResolver r8 = this.contentResolver;
        if (r8 == null) goto L9;
        SettingsObserver r10 = this.settingsObserver;
        if (r10 == null) goto L10;
        r8.unregisterContentObserver(r10);
        return;
    L10:
        return;
    }
}
