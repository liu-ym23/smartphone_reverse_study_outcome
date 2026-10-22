package com.bytedance.crash.looper;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.util.JSONUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class LooperMessageParser {
    public LooperMessageParser() {
    }

    public static void addBlockStack(JSONArray r2, JSONObject r3, long r4, boolean r6) {
        if (r6 == false) goto L5;
        String r7 = "currentMessageCost";
    L11:
        String r5 = getBlockStack(r2, r4, r3.optLong(r7));     // Catch: Throwable -> L10
        if (r5 == null) goto L13;
        JSONUtils.put(r3, "block_stack", r5);     // Catch: Throwable -> L10
        return;
    L13:
        return;
    L14:
        return;
    L5:
        r7 = "duration";
        goto L11
    }

    private static String getBlockStack(JSONArray r6, long r7, long r9) {
        if (r6 != null) goto L5;
        return null;
    L5:
        long r10 = r9 + r7;
        int r1 = 0;
    L7:
        if (r1 >= r6.length()) goto L15;
        JSONObject r2 = r6.optJSONObject(r1);
        long r3 = r2.optLong(OaidModel.KEY_TIME);
        if (r3 < r7) goto L14;
        if (r3 > r10) goto L14;
        return r2.optString("trace");
    L14:
        r1 = r1 + 1;
        goto L7
    L15:
        return null;
    }

    private static boolean isTraceEvil(JSONObject r8, JSONObject r9) {
        long r0 = r8.optLong("main_thread_cpu_tick") * ((long) r8.optInt(Constants.KEY_HW_JIFFIES));
        long r2 = r9.optLong("longestMsgStartCpuTime");
        long r10 = r9.optLong("longestMsgEndCpuTime");
        if (r0 != 0) goto L5;
        return false;
    L5:
        if (r2 == 0) goto L16;
        long r11 = (r10 / 10) * 10;
        if (r0 >= ((r2 / 10) * 10)) goto L10;
        return false;
    L10:
        if (r0 >= r11) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public static void pushToCrashBody(JSONObject r29) {
        JSONArray r1 = r29.optJSONArray("history_message");
        JSONObject r2 = r29.optJSONObject("current_message");
        JSONObject r4 = r29.optJSONObject("history_details");
        String r5 = "block_stack";
        JSONArray r6 = r29.optJSONArray("block_stack");
        if (r4 != null) goto L6;
        JSONObject r3 = new JSONObject();
        JSONUtils.put(r3, "longestMsgType", "no_details");
        JSONUtils.put(r3, "longestMsg", "no_details");
        JSONUtils.put(r29, "history_details", r3);
        return;
    L6:
        if (r1 != null) goto L8;
    L60:
        JSONUtils.put(r4, "longestMsgType", "no_history");
        JSONUtils.put(r4, "longestMsg", "no_history");
        return;
    L8:
        if (r1.length() == 0) goto L60;
        long r9 = r29.optLong("crash_time");
        long r11 = r4.optLong("last_wall_time");
        long r13 = r4.optLong("last_cpu_time");
        long r15 = 0;
        if (r9 != 0) goto L13;
    L58:
        JSONUtils.put(r4, "longestMsgType", "no_last_times");
        JSONUtils.put(r4, "longestMsg", "no_last_times");
        return;
    L13:
        if (r11 == 0) goto L58;
        if (r13 == 0) goto L58;
        JSONUtils.put(r4, "longestMsgType", "not_found");
        JSONUtils.put(r4, "longestMsg", "not_found");
        if (r9 <= r11) goto L25;
        if (r2 == null) goto L25;
        r15 = r2.optLong("currentMessageCost");
        long r17 = r9 - r11;
        if (r17 >= r15) goto L23;
        r15 = r17;
    L23:
        addBlockStack(r6, r2, r11, true);
    L25:
        if (r15 >= 5000) goto L40;
        long r18 = r9 - r11;
        int r0 = r1.length() - 1;
        long r21 = r15;
        int r20 = -1;
    L27:
        if (r0 < 0) goto L39;
        if (r18 >= 10000) goto L39;
        long r23 = r11;
        JSONObject r12 = r1.optJSONObject(r0);
        if (r12 != null) goto L33;
        long r27 = r13;
    L38:
        r0 = r0 - 1;
        r11 = r23;
        r13 = r27;
        goto L27
    L33:
        long r25 = r12.optLong("duration");
        r18 = r18 + r25;
        r27 = r13;
        addBlockStack(r6, r12, r9 - r18, false);
        if (r18 <= 2500) goto L38;
        if (r25 <= r21) goto L38;
        r20 = r0;
        r21 = r25;
    L39:
        long r24 = r11;
        long r28 = r13;
        int r7 = r20;
    L41:
        long r19 = r15;
        if (r7 < 0) goto L53;
        int r8 = r1.length() - 1;
    L44:
        String r16 = r5;
        if (r8 < r7) goto L50;
        JSONObject r10 = r1.optJSONObject(r8);
        if (r10 == null) goto L49;
        r24 = r24 - r10.optLong("duration");
        r28 = r28 - r10.optLong("cpuDuration");
    L49:
        r8 = r8 - 1;
        r5 = r16;
        goto L44
    L50:
        JSONObject r14 = r1.optJSONObject(r7);
        if (r14 == null) goto L71;
        long r22 = r14.optLong("duration");
        long r26 = r14.optLong("cpuDuration");
        JSONUtils.put(r4, "longestMsgWallDuration", Long.valueOf(r22));
        JSONUtils.put(r4, "longestMessageCpuDuration", Long.valueOf(r26));
        JSONUtils.put(r4, "longestMsgStartCpuTime", Long.valueOf(r28));
        JSONUtils.put(r4, "longestMsgEndCpuTime", Long.valueOf(r28 + r26));
        JSONUtils.put(r4, "longestMsgStartWallTime", Long.valueOf(r24));
        JSONUtils.put(r4, "longestMsgEndWallTime", Long.valueOf(r24 + r22));
        JSONUtils.put(r4, "longestMsgType", typeName(r14.optInt("type"), r26, r22));
        JSONUtils.put(r4, "longestMsg", r14.optString("message"));
        String r30 = r14.optString(r16);
        String r31 = "longestMsgBlockStack";
    L56:
        JSONUtils.put(r4, r31, r30);
        return;
    L71:
        return;
    L53:
        r31 = "longestMsgBlockStack";
        if (r2 == null) goto L72;
        JSONUtils.put(r4, "longestMsgWallDuration", Long.valueOf(r19));
        JSONUtils.put(r4, "longestMessageCpuDuration", -1);
        JSONUtils.put(r4, "longestMsgStartCpuTime", Long.valueOf(r28));
        JSONUtils.put(r4, "longestMsgEndCpuTime", -1);
        JSONUtils.put(r4, "longestMsgStartWallTime", Long.valueOf(r24));
        JSONUtils.put(r4, "longestMsgEndWallTime", Long.valueOf(r24 + r19));
        JSONUtils.put(r4, "longestMsgType", "current");
        JSONUtils.put(r4, "longestMsg", r2.optString("message"));
        r30 = r2.optString("block_stack");
        goto L56
    L72:
        return;
    L40:
        r24 = r11;
        r28 = r13;
        r7 = -1;
        goto L41
    }

    public static void pushToFilters(JSONObject r3, JSONObject r4) {
        JSONArray r0 = r3.optJSONArray("history_message");
        if (r0 != null) goto L5;
    L7:
        String r1 = "false";
    L8:
        JSONUtils.put(r4, "has_history_message", r1);
        JSONArray r2 = r3.optJSONArray("pending_messages");
        if (r2 != null) goto L11;
    L15:
        JSONObject r5 = r3.optJSONObject("history_details");
        if (r5 == null) goto L19;
        JSONUtils.put(r4, "npth_message_longest_msg", r5.optString("longestMsg"));
        JSONUtils.put(r4, "npth_message_longest_msg_type", r5.optString("longestMsgType"));
        JSONUtils.put(r4, "npth_message_trace_is_evil", String.valueOf(isTraceEvil(r3, r5)));
        JSONUtils.put(r4, "npth_message_has_block_stack", String.valueOf(!"".equals(r5.optString("longestMsgBlockStack"))));
        return;
    L19:
        return;
    L11:
        if (r2.length() <= 0) goto L15;
        JSONObject r6 = r2.optJSONObject(0);
        if (r6 == null) goto L15;
        JSONUtils.put(r4, "npth_message_anr_with_barrier_new", String.valueOf(r6.optString(TypedValues.AttributesType.S_TARGET).isEmpty()));
        goto L15
    L5:
        if (r0.length() <= 0) goto L7;
        r1 = "true";
        goto L8
    }

    private static String typeName(int r6, long r7, long r9) {
        if (r6 != 1) goto L15;
        if (r7 > 1) goto L8;
        return "idle";
    L8:
        if ((2 * r7) <= r9) goto L11;
        return "native_busy";
    L11:
        if ((r7 * 10) >= r9) goto L13;
        return "native_lock";
    L13:
        return "native_unknown";
    L15:
        if (r6 == 8) goto L17;
        return "normal";
    L17:
        if ((2 * r7) <= r9) goto L20;
        return "java_busy";
    L20:
        if ((r7 * 10) >= r9) goto L22;
        return "java_lock";
    L22:
        return "java_unknown";
    }
}
