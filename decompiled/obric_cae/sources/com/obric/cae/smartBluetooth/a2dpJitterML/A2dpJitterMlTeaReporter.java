package com.obric.cae.smartBluetooth.a2dpJitterML;

import android.bluetooth.BluetoothDevice;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.cloud.applog.ByteIOUtils;
import com.obric.cae.log.CaeLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class A2dpJitterMlTeaReporter {
    private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
    private static final String EVENT_A2DP_JITTER = "a2dp_jitter_event";
    private static final String EVENT_A2DP_JITTER_POLICY = "a2dp_jitter_policy_event";
    private static final String EVENT_A2DP_START = "a2dp_start_event";
    private static final String TAG = "A2dpJitterMlTeaReporter";

    private A2dpJitterMlTeaReporter() {
    }

    private static String getCurrentDateTimeString() {
        return new SimpleDateFormat(DATE_FORMAT_PATTERN, Locale.CHINA).format(new Date());
    }

    public static void reportA2dpJitterEvent(A2dpJitterMlFeatureExtractor.ExtractResult r8, float r10) {
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L5
        r11.put("timestamps", getCurrentDateTimeString());     // Catch: Throwable -> L5
        r11.put("delta_retrans_sum", r8.mDeltaRetransSum);     // Catch: Throwable -> L5
        r11.put("label", 1);     // Catch: Throwable -> L5
        r11.put("prob", r10);     // Catch: Throwable -> L5
        r11.put("tx_power_level", r8.mTxPowerLevel);     // Catch: Throwable -> L5
        r11.put("packet_type", r8.mPacketType);     // Catch: Throwable -> L5
        r11.put("overflow_count", r8.mOverflowCount);     // Catch: Throwable -> L5
        r11.put("no_rx_count", r8.mNoRxCount);     // Catch: Throwable -> L5
        r11.put("nak_count", r8.mNakCount);     // Catch: Throwable -> L5
        r11.put("glitch_count", r8.mGlitchCount);     // Catch: Throwable -> L5
        r11.put("acl_tx_queue_length", r8.mAclTxQueueLength);     // Catch: Throwable -> L5
        r11.put("host_buffer_margin", r8.mHostBufferMargin);     // Catch: Throwable -> L5
        r11.put("silence_duration", r8.mSilenceDuration);     // Catch: Throwable -> L5
        r11.put("norx_ratio", r8.mNoRxRatio);     // Catch: Throwable -> L5
        ByteIOUtils.trackEvent(EVENT_A2DP_JITTER, r11);     // Catch: Throwable -> L5
        CaeLog.d(TAG, "reported a2dp jitter event: " + r11);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        android.aimedia.a.s(th, new StringBuilder("report a2dp jitter event failed: "), TAG);
    }

    public static void reportA2dpJitterPolicyEvent(int r8, String r10, int r11, int r12, String r13) {
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L5
        r14.put("timestamps", getCurrentDateTimeString());     // Catch: Throwable -> L5
        r14.put("policy_action_undo", r12);     // Catch: Throwable -> L5
        r14.put("policy_action_do", r11);     // Catch: Throwable -> L5
        r14.put("policy_action", r8);     // Catch: Throwable -> L5
        r14.put("optimize_action", safeString(r10));     // Catch: Throwable -> L5
        r14.put(LocationMonitorConst.LOCATION, safeString(r13));     // Catch: Throwable -> L5
        ByteIOUtils.trackEvent(EVENT_A2DP_JITTER_POLICY, r14);     // Catch: Throwable -> L5
        CaeLog.d(TAG, "reported a2dp jitter policy event: " + r14);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        android.aimedia.a.s(th, new StringBuilder("report a2dp jitter policy event failed: "), TAG);
    }

    public static void reportA2dpStartEvent(BluetoothDevice r8, String r10) {
        if (r8 != null) goto L10;
        return;
    L10:
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L7
        r11.put("timestamps", getCurrentDateTimeString());     // Catch: Throwable -> L7
        r11.put(LocationMonitorConst.LOCATION, safeString(r10));     // Catch: Throwable -> L7
        r11.put("device_name", safeString(r8.getName()));     // Catch: Throwable -> L7
        r11.put("device_address", safeString(r8.getAddress()));     // Catch: Throwable -> L7
        ByteIOUtils.trackEvent(EVENT_A2DP_START, r11);     // Catch: Throwable -> L7
        CaeLog.d(TAG, "reported a2dp start event: " + r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        android.aimedia.a.s(th, new StringBuilder("report a2dp start event failed: "), TAG);
    }

    private static String safeString(String r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        return r8;
    }
}
