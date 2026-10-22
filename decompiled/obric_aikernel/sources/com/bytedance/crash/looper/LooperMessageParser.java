package com.bytedance.crash.looper;

import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.work.WorkRequest;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.util.JSONUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LooperMessageParser {
    public LooperMessageParser() {
    }

    public static void addBlockStack(JSONArray r10, JSONObject r11, long r12, boolean r13) {
        if (r13 == false) goto L5;
        String r14 = "currentMessageCost";
    L11:
        String r15 = getBlockStack(r10, r12, r11.optLong(r14));     // Catch: Throwable -> L10
        if (r15 == null) goto L13;
        JSONUtils.put(r11, "block_stack", r15);     // Catch: Throwable -> L10
        return;
    L13:
        return;
    L14:
        return;
    L5:
        r14 = "duration";
        goto L11
    }

    private static String getBlockStack(JSONArray r10, long r11, long r12) {
        if (r10 != null) goto L5;
        return null;
    L5:
        long r13 = r12 + r11;
        int r14 = 0;
    L7:
        if (r14 >= r10.length()) goto L15;
        JSONObject r15 = r10.optJSONObject(r14);
        long r16 = r15.optLong(OaidModel.KEY_TIME);
        if (r16 < r11) goto L14;
        if (r16 > r13) goto L14;
        return r15.optString("trace");
    L14:
        r14 = r14 + 1;
        goto L7
    L15:
        return null;
    }

    private static boolean isTraceEvil(@NonNull JSONObject r10, @NonNull JSONObject r11) {
        long r12 = r10.optLong("main_thread_cpu_tick") * ((long) r10.optInt(Constants.KEY_HW_JIFFIES));
        long r13 = r11.optLong("longestMsgStartCpuTime");
        long r14 = r11.optLong("longestMsgEndCpuTime");
        if (r12 != 0) goto L5;
        return false;
    L5:
        if (r13 == 0) goto L16;
        long r15 = (r14 / 10) * 10;
        if (r12 >= ((r13 / 10) * 10)) goto L10;
        return false;
    L10:
        if (r12 >= r15) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public static void pushToCrashBody(@NonNull JSONObject r29) {
        JSONArray r10 = r29.optJSONArray("history_message");
        JSONObject r11 = r29.optJSONObject("current_message");
        JSONObject r12 = r29.optJSONObject("history_details");
        String r13 = "block_stack";
        JSONArray r14 = r29.optJSONArray("block_stack");
        if (r12 != null) goto L6;
        JSONObject r15 = new JSONObject();
        JSONUtils.put(r15, "longestMsgType", "no_details");
        JSONUtils.put(r15, "longestMsg", "no_details");
        JSONUtils.put(r29, "history_details", r15);
        return;
    L6:
        if (r10 != null) goto L8;
    L60:
        JSONUtils.put(r12, "longestMsgType", "no_history");
        JSONUtils.put(r12, "longestMsg", "no_history");
        return;
    L8:
        if (r10.length() == 0) goto L60;
        long r16 = r29.optLong("crash_time");
        long r17 = r12.optLong("last_wall_time");
        long r18 = r12.optLong("last_cpu_time");
        long r19 = 0;
        if (r16 != 0) goto L13;
    L58:
        JSONUtils.put(r12, "longestMsgType", "no_last_times");
        JSONUtils.put(r12, "longestMsg", "no_last_times");
        return;
    L13:
        if (r17 == 0) goto L58;
        if (r18 == 0) goto L58;
        JSONUtils.put(r12, "longestMsgType", "not_found");
        JSONUtils.put(r12, "longestMsg", "not_found");
        if (r16 <= r17) goto L25;
        if (r11 == null) goto L25;
        r19 = r11.optLong("currentMessageCost");
        long r110 = r16 - r17;
        if (r110 >= r19) goto L23;
        r19 = r110;
    L23:
        addBlockStack(r14, r11, r17, true);
    L25:
        if (r19 >= 5000) goto L40;
        long r111 = r16 - r17;
        int r20 = r10.length() - 1;
        long r21 = r19;
        int r22 = -1;
    L27:
        if (r20 < 0) goto L39;
        if (r111 >= WorkRequest.MIN_BACKOFF_MILLIS) goto L39;
        long r23 = r17;
        JSONObject r112 = r10.optJSONObject(r20);
        if (r112 != null) goto L33;
        long r27 = r18;
    L38:
        r20 = r20 - 1;
        r17 = r23;
        r18 = r27;
        goto L27
    L33:
        long r25 = r112.optLong("duration");
        r111 = r111 + r25;
        r27 = r18;
        addBlockStack(r14, r112, r16 - r111, false);
        if (r111 <= 2500) goto L38;
        if (r25 <= r21) goto L38;
        r22 = r20;
        r21 = r25;
    L39:
        long r24 = r17;
        long r28 = r18;
        int r26 = r22;
    L41:
        long r113 = r19;
        if (r26 < 0) goto L53;
        int r30 = r10.length() - 1;
    L44:
        String r114 = r13;
        if (r30 < r26) goto L50;
        JSONObject r31 = r10.optJSONObject(r30);
        if (r31 == null) goto L49;
        r24 = r24 - r31.optLong("duration");
        r28 = r28 - r31.optLong("cpuDuration");
    L49:
        r30 = r30 - 1;
        r13 = r114;
        goto L44
    L50:
        JSONObject r32 = r10.optJSONObject(r26);
        if (r32 == null) goto L71;
        long r33 = r32.optLong("duration");
        long r34 = r32.optLong("cpuDuration");
        JSONUtils.put(r12, "longestMsgWallDuration", Long.valueOf(r33));
        JSONUtils.put(r12, "longestMessageCpuDuration", Long.valueOf(r34));
        JSONUtils.put(r12, "longestMsgStartCpuTime", Long.valueOf(r28));
        JSONUtils.put(r12, "longestMsgEndCpuTime", Long.valueOf(r28 + r34));
        JSONUtils.put(r12, "longestMsgStartWallTime", Long.valueOf(r24));
        JSONUtils.put(r12, "longestMsgEndWallTime", Long.valueOf(r24 + r33));
        JSONUtils.put(r12, "longestMsgType", typeName(r32.optInt(WsConstants.KEY_CONNECTION_TYPE), r34, r33));
        JSONUtils.put(r12, "longestMsg", r32.optString("message"));
        String r35 = r32.optString(r114);
        String r36 = "longestMsgBlockStack";
    L56:
        JSONUtils.put(r12, r36, r35);
        return;
    L71:
        return;
    L53:
        r36 = "longestMsgBlockStack";
        if (r11 == null) goto L72;
        JSONUtils.put(r12, "longestMsgWallDuration", Long.valueOf(r113));
        JSONUtils.put(r12, "longestMessageCpuDuration", -1);
        JSONUtils.put(r12, "longestMsgStartCpuTime", Long.valueOf(r28));
        JSONUtils.put(r12, "longestMsgEndCpuTime", -1);
        JSONUtils.put(r12, "longestMsgStartWallTime", Long.valueOf(r24));
        JSONUtils.put(r12, "longestMsgEndWallTime", Long.valueOf(r24 + r113));
        JSONUtils.put(r12, "longestMsgType", "current");
        JSONUtils.put(r12, "longestMsg", r11.optString("message"));
        r35 = r11.optString("block_stack");
        goto L56
    L72:
        return;
    L40:
        r24 = r17;
        r28 = r18;
        r26 = -1;
        goto L41
    }

    public static void pushToFilters(@NonNull JSONObject r10, @NonNull JSONObject r11) {
        JSONArray r12 = r10.optJSONArray("history_message");
        if (r12 != null) goto L5;
    L7:
        String r13 = "false";
    L8:
        JSONUtils.put(r11, "has_history_message", r13);
        JSONArray r14 = r10.optJSONArray("pending_messages");
        if (r14 != null) goto L11;
    L15:
        JSONObject r15 = r10.optJSONObject("history_details");
        if (r15 == null) goto L19;
        JSONUtils.put(r11, "npth_message_longest_msg", r15.optString("longestMsg"));
        JSONUtils.put(r11, "npth_message_longest_msg_type", r15.optString("longestMsgType"));
        JSONUtils.put(r11, "npth_message_trace_is_evil", String.valueOf(isTraceEvil(r10, r15)));
        JSONUtils.put(r11, "npth_message_has_block_stack", String.valueOf(!"".equals(r15.optString("longestMsgBlockStack"))));
        return;
    L19:
        return;
    L11:
        if (r14.length() <= 0) goto L15;
        JSONObject r16 = r14.optJSONObject(0);
        if (r16 == null) goto L15;
        JSONUtils.put(r11, "npth_message_anr_with_barrier_new", String.valueOf(r16.optString(TypedValues.AttributesType.S_TARGET).isEmpty()));
        goto L15
    L5:
        if (r12.length() <= 0) goto L7;
        r13 = "true";
        goto L8
    }

    private static String typeName(int r10, long r11, long r12) {
        if (r10 != 1) goto L15;
        if (r11 > 1) goto L8;
        return "idle";
    L8:
        if ((2 * r11) <= r12) goto L11;
        return "native_busy";
    L11:
        if ((r11 * 10) >= r12) goto L13;
        return "native_lock";
    L13:
        return "native_unknown";
    L15:
        if (r10 == 8) goto L17;
        return "normal";
    L17:
        if ((2 * r11) <= r12) goto L20;
        return "java_busy";
    L20:
        if ((r11 * 10) >= r12) goto L22;
        return "java_lock";
    L22:
        return "java_unknown";
    }
}
