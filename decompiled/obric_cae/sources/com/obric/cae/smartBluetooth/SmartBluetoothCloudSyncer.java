package com.obric.cae.smartBluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.obric.cae.libs.bluetooth.CaeBluetoothEvent;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.dbam.DbamEventHandler;
import com.obric.cae.smartBluetooth.lowlatency.LowLatencyHandler;
import com.obric.cae.utils.CaeUtil;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SmartBluetoothCloudSyncer {
    private static final String ACTION_ADD = "add";
    private static final int ACTION_POST = 1;
    private static final String ACTION_REMOVE = "remove";
    private static final String BUNDLE_KEY_ADDRESS = "address";
    private static final String BUNDLE_KEY_DETAIL_MESSAGE = "detail_message";
    private static final String BUNDLE_KEY_POST_RESPONSE_CODE = "post_response_code";
    private static final String MAC_AUTO_FILL_SUFFIX = ":00:00:00";
    private static final int MSG_DOWNLOAD_CONFIG = 1;
    private static final int MSG_POST_RESPONSE = 2;
    private static final int NO_ACTION = 0;
    private static final String PROP_BQR_CHOPPY_THRESHOLD = "persist.bluetooth.bqr.choppy_threshold";
    private static final String PROP_BQR_EVENT_MASK = "persist.bluetooth.bqr.event_mask";
    private static final String PROP_BQR_MIN_INTERVAL_MS = "persist.bluetooth.bqr.min_interval_ms";
    private static final String TAG = "SmartBluetoothCloudSyncer";
    private static final String TAG_A2DP_JITTER_ML_HISTORY_SEVERE_JITTER_OPTIMIZE_TRIGGER_THRESHOLD = "a2dp_jitter_ml_history_severe_jitter_optimize_trigger_threshold";
    private static final String TAG_A2DP_JITTER_ML_PROB_HEAVY = "a2dp_jitter_ml_prob_heavy";
    private static final String TAG_A2DP_JITTER_ML_SEVERE_JITTER_TRIGGER_THRESHOLD = "a2dp_jitter_ml_severe_jitter_trigger_threshold";
    private static final String TAG_BQR_CHOPPY_THRESHOLD = "bqr_choppy_threshold";
    private static final String TAG_BQR_EVENT_MASK = "bqr_event_mask";
    private static final String TAG_BQR_MIN_INTERVAL_MS = "bqr_min_interval_ms";
    private static final String TAG_DBAM_ANTENNA_ISOLATION = "dbam_antenna_isolation";
    private static final String TAG_DBAM_BT_LOW_RSSI_THRESHOLD = "dbam_bt_low_rssi_threshold";
    private static final String TAG_DBAM_CONFIG = "dbam_config";
    private static final String TAG_DBAM_MAX_TX_POWER_FOR_BTC = "dbam_max_tx_power_for_btc";
    private static final String TAG_DBAM_MODE = "dbam_mode";
    private static final String TAG_DBAM_WIFI_LOW_RSSI_THRESHOLD = "dbam_wifi_low_rssi_threshold";
    private static final String TAG_DYNAMIC_INTEROP_DATABASE_SOLUTION = "dynamic_solution";
    private static final String TAG_LOW_LATENCY = "low_latency_game_packages";
    private static final String TAG_MODULE = "module";
    private static final String TAG_STATIC_EXT_INTEROP_DATABASE_SOLUTION = "static_ext_solution";
    private static final String TAG_THRESHOLD = "threshold";
    private static final String TAG_TYPE = "type";
    private static final String TAG_VERSION = "version";
    private Context mContext;
    private Pair<Integer, CaeBluetoothEvent> mPendingAction;
    private Queue<Pair<Integer, CaeBluetoothEvent>> mQueuedActions;
    private HandlerThread mSolutionThread;
    private SolutionUpdateHandler mUpdateHandler;

    public class SolutionUpdateHandler extends Handler {
        final /* synthetic */ SmartBluetoothCloudSyncer this$0;

        public SolutionUpdateHandler(SmartBluetoothCloudSyncer r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            String r10 = SmartBluetoothCloudSyncer.access$000();
            defpackage.a.j(new StringBuilder("handleMessage: "), r8.what, r10);
            int r11 = r8.what;
            if (r11 != 1) goto L5;
            SmartBluetoothCloudSyncer.access$100(this.this$0, (String) r8.obj);
            return;
        L5:
            if (r11 != 2) goto L11;
            SmartBluetoothCloudSyncer.access$200(this.this$0, r8.getData());
            return;
        }
    }

    public SmartBluetoothCloudSyncer(Context r8) {
        this.mContext = r8;
        this.mQueuedActions = new LinkedList();
        clearPendingAction();
        HandlerThread r10 = new HandlerThread("solution update thread");
        this.mSolutionThread = r10;
        r10.start();
        this.mUpdateHandler = new SolutionUpdateHandler(this, this.mSolutionThread.getLooper());
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ void access$100(SmartBluetoothCloudSyncer r8, String r10) {
        r8.parseCloudData(r10);
    }

    public static /* synthetic */ void access$200(SmartBluetoothCloudSyncer r8, Bundle r10) {
        r8.handlePostResponse(r10);
    }

    private void addQueuedAction(int r8, CaeBluetoothEvent r10) {
        this.mQueuedActions.add(new Pair(Integer.valueOf(r8), r10));
    }

    private void clearPendingAction() {
        this.mPendingAction = new Pair(0, null);
    }

    private void handlePostResponse(Bundle r8) {
        int r10 = r8.getInt(BUNDLE_KEY_POST_RESPONSE_CODE);
        String r11 = r8.getString("address");
        String r12 = r8.getString(BUNDLE_KEY_DETAIL_MESSAGE);
        Pair<Integer, CaeBluetoothEvent> r13 = this.mQueuedActions.poll();
        if (r13 != null) goto L5;
    L25:
        clearPendingAction();
        return;
    L5:
        if (((Integer) r13.first).intValue() == 0) goto L25;
        if (((Integer) r13.first).intValue() == 1) goto L10;
        CaeLog.w(TAG, "unhandled action: " + r13.first);
        return;
    L10:
        CaeBluetoothEvent r14 = (CaeBluetoothEvent) r13.second;
        BluetoothDevice r15 = r14.getBluetoothDevice();
        if (r15 == null) goto L13;
        String r16 = r15.getAddress();
    L14:
        if (r11 == null) goto L28;
        if (r16 == null) goto L29;
        if (r12 != null) goto L18;
        return;
    L18:
        if (r11.equals(r16) == true) goto L20;
        return;
    L20:
        if (r12.equals(r14.getDetailMessage()) == true) goto L22;
        return;
    L22:
        if (r10 != 200) goto L33;
        CaeLog.d(TAG, "post successful.");
        updatePostOKInfoToDB(r14);
        return;
    L33:
        return;
    L29:
        return;
    L28:
        return;
    L13:
        r16 = null;
        goto L14
    }

    private void parseA2dpJitterMlConfig(JSONObject r8) {
        if (r8.has("a2dp_jitter_ml_prob_heavy") == false) goto L11;
        float r10 = (float) r8.getDouble("a2dp_jitter_ml_prob_heavy");
        if (r10 >= 0.0f) goto L7;
    L9:
        CaeLog.w(TAG, "invalid a2dp jitter ml prob heavy: " + r10);
        goto L11
    L7:
        if (r10 > 1.0f) goto L9;
        CaeUtil.setA2dpJitterMlProbHeavy(this.mContext, r10);
    L11:
        if (r8.has("a2dp_jitter_ml_severe_jitter_trigger_threshold") == false) goto L17;
        int r11 = r8.getInt("a2dp_jitter_ml_severe_jitter_trigger_threshold");
        if (r11 <= 0) goto L15;
        CaeUtil.setA2dpJitterMlSevereJitterTriggerThreshold(this.mContext, r11);
        goto L17
    L15:
        CaeLog.w(TAG, "invalid a2dp jitter ml severe jitter trigger threshold: " + r11);
    L17:
        if (r8.has("a2dp_jitter_ml_history_severe_jitter_optimize_trigger_threshold") == false) goto L23;
        int r12 = r8.getInt("a2dp_jitter_ml_history_severe_jitter_optimize_trigger_threshold");
        if (r12 <= 0) goto L21;
        CaeUtil.setA2dpJitterMlHistorySevereJitterOptimizeTriggerThreshold(this.mContext, r12);
        return;
    L21:
        CaeLog.w(TAG, "invalid a2dp jitter ml history severe jitter optimize trigger threshold: " + r12);
        return;
    }

    private void parseCloudData(String r20) {
        String r8 = TAG_LOW_LATENCY;
        String r10 = TAG_DBAM_CONFIG;
        String r11 = TAG;
        defpackage.b.o("parseCloudData: ", r20, r11);
        JSONObject r12 = new JSONObject(r20);     // Catch: JSONException -> L66
        if (r12.has("module") == true) goto L8;
        CaeLog.w(r11, "tag module does not exist, return.");     // Catch: JSONException -> L66
        return;
    L8:
        if (r12.has("threshold") == false) goto L11;
        CaeUtil.setIssueCheckingThreshold(this.mContext, r12.getInt("threshold"));     // Catch: JSONException -> L66
    L11:
        if (r12.has("version") == false) goto L15;
        CaeUtil.setLatestIssueVersion(this.mContext, r12.getString("version"));     // Catch: JSONException -> L66
    L15:
        if (r12.has(TAG_DYNAMIC_INTEROP_DATABASE_SOLUTION) == false) goto L31;
        JSONArray r13 = r12.getJSONArray(TAG_DYNAMIC_INTEROP_DATABASE_SOLUTION);     // Catch: JSONException -> L66
        SmartBluetoothBinderClient r14 = SmartBluetoothManager.getInstance(this.mContext).getBluetoothBinderClient();     // Catch: JSONException -> L66
        int r15 = 0;
    L18:
        if (r15 >= r13.length()) goto L31;
        String r16 = r13.getString(r15);     // Catch: JSONException -> L66
        JSONArray r21 = r13;
        String r17 = r16.split(";")[0];     // Catch: JSONException -> L66
        String r18 = r8;
        String r19 = r16.split(";")[1];     // Catch: JSONException -> L66
        String r110 = r10;
        BluetoothDevice r22 = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(CaeUtil.convertMacToUpperIfNeed(r16.split(";")[3] + MAC_AUTO_FILL_SUFFIX));     // Catch: IllegalArgumentException -> L28 JSONException -> L66
        if (ACTION_ADD.equals(r17) == false) goto L25;
        r14.addDeviceToDatabase(r19, r22);     // Catch: IllegalArgumentException -> L28 JSONException -> L66
    L30:
        r15 = r15 + 1;     // Catch: JSONException -> L66
        r13 = r21;
        r10 = r110;
        r8 = r18;
        goto L18
    L25:
        if (ACTION_REMOVE.equals(r17) == false) goto L30;
        r14.removeDeviceFromDatabase(r19, r22);     // Catch: IllegalArgumentException -> L28 JSONException -> L66
        goto L30
    L28:
        e = move-exception;
        CaeLog.w(TAG, "dynamic solution: the mac address of solution is invalid !" + e);     // Catch: JSONException -> L66
    L31:
        String r111 = r8;
        String r112 = r10;
        if (r12.has(TAG_STATIC_EXT_INTEROP_DATABASE_SOLUTION) == false) goto L48;
        JSONArray r23 = r12.getJSONArray(TAG_STATIC_EXT_INTEROP_DATABASE_SOLUTION);     // Catch: JSONException -> L66
        SmartBluetoothBinderClient r24 = SmartBluetoothManager.getInstance(this.mContext).getBluetoothBinderClient();     // Catch: JSONException -> L66
        int r25 = 0;
    L35:
        if (r25 >= r23.length()) goto L48;
        String r26 = r23.getString(r25);     // Catch: JSONException -> L66
        String r27 = r26.split(";")[0];     // Catch: JSONException -> L66
        String r113 = r26.split(";")[1];     // Catch: JSONException -> L66
        BluetoothDevice r28 = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(CaeUtil.convertMacToUpperIfNeed(r26.split(";")[3] + MAC_AUTO_FILL_SUFFIX));     // Catch: Throwable -> L44 JSONException -> L66
        if (ACTION_ADD.equals(r27) == false) goto L41;
        r24.addDeviceToStaticExtDatabase(r113, r28);     // Catch: Throwable -> L44 JSONException -> L66
    L46:
        r25 = r25 + 1;     // Catch: JSONException -> L66
        goto L35
    L41:
        if (ACTION_REMOVE.equals(r27) == false) goto L46;
        r24.removeDeviceFromStaticExtDatabase(r113, r28);     // Catch: Throwable -> L44 JSONException -> L66
        goto L46
    L44:
        e = move-exception;
        CaeLog.w(TAG, "static ext solution: the mac address of solution is invalid !" + e);     // Catch: JSONException -> L66
    L48:
        if (r12.has(TAG_BQR_EVENT_MASK) == false) goto L51;
        CaeUtil.setProperty(PROP_BQR_EVENT_MASK, r12.getString(TAG_BQR_EVENT_MASK));     // Catch: JSONException -> L66
    L51:
        if (r12.has(TAG_BQR_MIN_INTERVAL_MS) == false) goto L54;
        CaeUtil.setProperty(PROP_BQR_MIN_INTERVAL_MS, r12.getString(TAG_BQR_MIN_INTERVAL_MS));     // Catch: JSONException -> L66
    L54:
        if (r12.has(TAG_BQR_CHOPPY_THRESHOLD) == false) goto L57;
        CaeUtil.setProperty(PROP_BQR_CHOPPY_THRESHOLD, r12.getString(TAG_BQR_CHOPPY_THRESHOLD));     // Catch: JSONException -> L66
    L57:
        if (r12.has(r112) == false) goto L60;
        parseDbamConfig(r12.getJSONObject(r112));     // Catch: JSONException -> L66
    L60:
        if (r12.has(r111) == false) goto L64;
        String r29 = r12.getString(r111);     // Catch: JSONException -> L66
        LowLatencyHandler r30 = SmartBluetoothManager.getInstance(this.mContext).getLowLatencyHandler();     // Catch: JSONException -> L66
        if (r30 == null) goto L64;
        r30.updateGamePackageNames(parseLowLatencyPackageNames(r29));     // Catch: JSONException -> L66
    L64:
        parseA2dpJitterMlConfig(r12);     // Catch: JSONException -> L66
        return;
    L66:
        e = move-exception;
        CaeLog.e(TAG, "" + e);
    }

    private void parseDbamConfig(JSONObject r8) {
        CaeLog.d(TAG, "parseDbamConfig: " + r8);
        if (r8.has("dbam_mode") == false) goto L10;
        int r10 = r8.getInt("dbam_mode");
        if (r10 < 0) goto L10;
        if (r10 > 2) goto L10;
        CaeUtil.setDbamConfigPrefs(this.mContext, "dbam_mode", r10);
    L10:
        if (r8.has(TAG_DBAM_ANTENNA_ISOLATION) == false) goto L13;
        CaeUtil.setDbamConfigPrefs(this.mContext, "antenna_isolation", r8.getInt(TAG_DBAM_ANTENNA_ISOLATION));
    L13:
        if (r8.has(TAG_DBAM_MAX_TX_POWER_FOR_BTC) == false) goto L20;
        int r11 = r8.getInt(TAG_DBAM_MAX_TX_POWER_FOR_BTC);
        if (r11 <= 0) goto L20;
        if (r11 > 100) goto L20;
        CaeUtil.setDbamConfigPrefs(this.mContext, "max_tx_power_for_btc", r11);
    L20:
        if (r8.has(TAG_DBAM_BT_LOW_RSSI_THRESHOLD) == false) goto L25;
        int r12 = r8.getInt(TAG_DBAM_BT_LOW_RSSI_THRESHOLD);
        if (r12 >= 0) goto L25;
        CaeUtil.setDbamConfigPrefs(this.mContext, "bt_low_rssi_threshold", r12);
    L25:
        if (r8.has(TAG_DBAM_WIFI_LOW_RSSI_THRESHOLD) == false) goto L29;
        int r13 = r8.getInt(TAG_DBAM_WIFI_LOW_RSSI_THRESHOLD);
        if (r13 >= 0) goto L29;
        CaeUtil.setDbamConfigPrefs(this.mContext, "wifi_low_rssi_threshold", r13);
    L29:
        updateRssiThreshold();
    }

    private List<String> parseLowLatencyPackageNames(String r8) {
        if (r8 != null) goto L5;
        CaeLog.w(TAG, "lowLatencyPackageNames is null, parse packages name failed.");
        return null;
    L5:
        CaeUtil.setLowLatencyPackageNamesPrefs(this.mContext, "low_latency_package_names", r8);
        List<String> r10 = Arrays.asList(r8.split(","));
        CaeLog.d(TAG, "game packages name: " + r10);
        return r10;
    }

    private void updatePostOKInfoToDB(CaeBluetoothEvent r8) {
        SmartBluetoothManager.getInstance(this.mContext).getDatabase().updatePostResponseOKInfoToDB(r8);
    }

    private boolean updateRssiThreshold() {
        DbamEventHandler r8 = SmartBluetoothManager.getInstance(this.mContext).getDbamEventHandler();
        if (r8 != null) goto L5;
        return false;
    L5:
        return r8.setDbamParams(this.mContext);
    }

    public void cleanup() {
        CaeLog.d(TAG, "cleanup");
        HandlerThread r8 = this.mSolutionThread;
        if (r8 == null) goto L5;
        r8.quitSafely();
    L5:
        Queue<Pair<Integer, CaeBluetoothEvent>> r10 = this.mQueuedActions;
        if (r10 == null) goto L9;
        r10.clear();
        return;
    }

    public void onCloudDataChange(String r8) {
        CaeUtil.sendMessageWithParam(this.mUpdateHandler, 1, r8);
    }

    public void onPostStateChange(int r8, String r10, String r11) {
        Bundle r12 = new Bundle();
        r12.putInt(BUNDLE_KEY_POST_RESPONSE_CODE, r8);
        r12.putString("address", r10);
        r12.putString(BUNDLE_KEY_DETAIL_MESSAGE, r11);
        CaeUtil.sendMessageWithBundle(this.mUpdateHandler, 2, r12);
    }

    public void postCaeEventToCloud(CaeBluetoothEvent r8) {
        String r10 = SmartBluetoothManager.getInstance(this.mContext).getDatabase().buildPostCaeInfo(r8);
        if (r10 != null) goto L6;
        CaeLog.e(TAG, "postCaeEventToCloud: post info is null, return.");
        return;
    L6:
        CaeLog.d(TAG, "postCaeEventToCloud: ".concat(r10));
        SmartBluetoothManager.getInstance(this.mContext).getCloudBinderClient().postCaeEventToCloud(r10);
        addQueuedAction(1, r8);
    }
}
