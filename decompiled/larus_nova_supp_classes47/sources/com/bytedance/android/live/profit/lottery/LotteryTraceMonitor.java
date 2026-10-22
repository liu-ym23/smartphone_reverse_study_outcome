package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.core.log.ALogger;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LotteryTraceMonitor {
    public static final LinkedHashMap<String, String> a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b$\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/LotteryTraceMonitor$EventName;", "", "lottery_init_im", "lottery_init_api", "lottery_init_api_success", "lottery_init_api_fail", "lottery_init_api_backend", "lottery_action_change", "lottery_state_change", "lottery_countdown_time", "lottery_start_draw", "lottery_old_draw_interaction", "lottery_old_draw_interaction_success", "lottery_draw_compensate_start", "lottery_draw_compensate_timeend", "lottery_draw_compensate_request", "lottery_draw_compensate_message", "lottery_update_curcandidatestate", "lottery_draw_compensate_request_success", "lottery_draw_compensate_request_fail", "lottery_anchor_draw_refresh", "lottery_draw_finish", "lottery_local_participated", "lottery_draw_finish_open_scheme", "lottery_draw_finish_1", "lottery_draw_finish_2", "lottery_is_terminalState", "lottery_lottery_state_null", "lottery_draw_open_schema", "lottery_draw_open_cancel_last", "lottery_old_draw_interaction_error", "lottery_draw_open_error_1", "lottery_draw_open_error_2", "lottery_draw_open_error_3", "lottery_draw_open_schema_final", "lottery_candidate_success_msg", "lottery_draw_result_msg", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum EventName extends Enum<EventName> {
        public static final /* synthetic */ EventName[] a = null;
        public static final EventName lottery_action_change = null;
        public static final EventName lottery_anchor_draw_refresh = null;
        public static final EventName lottery_candidate_success_msg = null;
        public static final EventName lottery_countdown_time = null;
        public static final EventName lottery_draw_compensate_message = null;
        public static final EventName lottery_draw_compensate_request = null;
        public static final EventName lottery_draw_compensate_request_fail = null;
        public static final EventName lottery_draw_compensate_request_success = null;
        public static final EventName lottery_draw_compensate_start = null;
        public static final EventName lottery_draw_compensate_timeend = null;
        public static final EventName lottery_draw_finish = null;
        public static final EventName lottery_draw_finish_1 = null;
        public static final EventName lottery_draw_finish_2 = null;
        public static final EventName lottery_draw_finish_open_scheme = null;
        public static final EventName lottery_draw_open_cancel_last = null;
        public static final EventName lottery_draw_open_error_1 = null;
        public static final EventName lottery_draw_open_error_2 = null;
        public static final EventName lottery_draw_open_error_3 = null;
        public static final EventName lottery_draw_open_schema = null;
        public static final EventName lottery_draw_open_schema_final = null;
        public static final EventName lottery_draw_result_msg = null;
        public static final EventName lottery_init_api = null;
        public static final EventName lottery_init_api_backend = null;
        public static final EventName lottery_init_api_fail = null;
        public static final EventName lottery_init_api_success = null;
        public static final EventName lottery_init_im = null;
        public static final EventName lottery_is_terminalState = null;
        public static final EventName lottery_local_participated = null;
        public static final EventName lottery_lottery_state_null = null;
        public static final EventName lottery_old_draw_interaction = null;
        public static final EventName lottery_old_draw_interaction_error = null;
        public static final EventName lottery_old_draw_interaction_success = null;
        public static final EventName lottery_start_draw = null;
        public static final EventName lottery_state_change = null;
        public static final EventName lottery_update_curcandidatestate = null;

        static {
            EventName r1 = new EventName("lottery_init_im", 0);
            lottery_init_im = r1;
            EventName r2 = new EventName("lottery_init_api", 1);
            lottery_init_api = r2;
            EventName r3 = new EventName("lottery_init_api_success", 2);
            lottery_init_api_success = r3;
            EventName r4 = new EventName("lottery_init_api_fail", 3);
            lottery_init_api_fail = r4;
            EventName r5 = new EventName("lottery_init_api_backend", 4);
            lottery_init_api_backend = r5;
            EventName r6 = new EventName("lottery_action_change", 5);
            lottery_action_change = r6;
            EventName r7 = new EventName("lottery_state_change", 6);
            lottery_state_change = r7;
            EventName r8 = new EventName("lottery_countdown_time", 7);
            lottery_countdown_time = r8;
            EventName r9 = new EventName("lottery_start_draw", 8);
            lottery_start_draw = r9;
            EventName r10 = new EventName("lottery_old_draw_interaction", 9);
            lottery_old_draw_interaction = r10;
            EventName r12 = new EventName("lottery_old_draw_interaction_success", 10);
            lottery_old_draw_interaction_success = r12;
            EventName r13 = new EventName("lottery_draw_compensate_start", 11);
            lottery_draw_compensate_start = r13;
            EventName r14 = new EventName("lottery_draw_compensate_timeend", 12);
            lottery_draw_compensate_timeend = r14;
            EventName r15 = new EventName("lottery_draw_compensate_request", 13);
            lottery_draw_compensate_request = r15;
            EventName r16 = new EventName("lottery_draw_compensate_message", 14);
            lottery_draw_compensate_message = r16;
            EventName r17 = new EventName("lottery_update_curcandidatestate", 15);
            lottery_update_curcandidatestate = r17;
            EventName r18 = new EventName("lottery_draw_compensate_request_success", 16);
            lottery_draw_compensate_request_success = r18;
            EventName r19 = new EventName("lottery_draw_compensate_request_fail", 17);
            lottery_draw_compensate_request_fail = r19;
            EventName r20 = new EventName("lottery_anchor_draw_refresh", 18);
            lottery_anchor_draw_refresh = r20;
            EventName r22 = new EventName("lottery_draw_finish", 19);
            lottery_draw_finish = r22;
            EventName r23 = new EventName("lottery_local_participated", 20);
            lottery_local_participated = r23;
            EventName r24 = new EventName("lottery_draw_finish_open_scheme", 21);
            lottery_draw_finish_open_scheme = r24;
            EventName r25 = new EventName("lottery_draw_finish_1", 22);
            lottery_draw_finish_1 = r25;
            EventName r26 = new EventName("lottery_draw_finish_2", 23);
            lottery_draw_finish_2 = r26;
            EventName r27 = new EventName("lottery_is_terminalState", 24);
            lottery_is_terminalState = r27;
            EventName r28 = new EventName("lottery_lottery_state_null", 25);
            lottery_lottery_state_null = r28;
            EventName r29 = new EventName("lottery_draw_open_schema", 26);
            lottery_draw_open_schema = r29;
            EventName r30 = new EventName("lottery_draw_open_cancel_last", 27);
            lottery_draw_open_cancel_last = r30;
            EventName r32 = new EventName("lottery_old_draw_interaction_error", 28);
            lottery_old_draw_interaction_error = r32;
            EventName r33 = new EventName("lottery_draw_open_error_1", 29);
            lottery_draw_open_error_1 = r33;
            EventName r34 = new EventName("lottery_draw_open_error_2", 30);
            lottery_draw_open_error_2 = r34;
            EventName r35 = new EventName("lottery_draw_open_error_3", 31);
            lottery_draw_open_error_3 = r35;
            EventName r36 = new EventName("lottery_draw_open_schema_final", 32);
            lottery_draw_open_schema_final = r36;
            EventName r37 = new EventName("lottery_candidate_success_msg", 33);
            lottery_candidate_success_msg = r37;
            EventName r38 = new EventName("lottery_draw_result_msg", 34);
            lottery_draw_result_msg = r38;
            a = new EventName[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r32, r33, r34, r35, r36, r37, r38};
        }

        public static EventName valueOf(String r1) {
            return (EventName) r27.a.a(EventName.class, r1);
        }

        public static EventName[] values() {
            return (EventName[]) a.clone();
        }

        public EventName(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
        a = new LinkedHashMap();
    }

    public static void a(EventName r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        LinkedHashMap<String, String> r0 = a;
        if (r0 == null) goto L8;
        String r1 = r2.name();
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        String r4 = r0.put(r1, r3);
    L8:
        r2.name();
    }

    public static void b(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        LinkedHashMap<String, String> r0 = a;
        if (r0 == null) goto L8;
        String r6 = r4 + System.currentTimeMillis();
        if (r5 != null) goto L7;
        r5 = "";
    L7:
        String r7 = r0.put(r6, r5);
    L8:
        System.currentTimeMillis();
    }

    public static void c(JSONObject r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$safePut");
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
    L7:
        e = move-exception;
        ALogger.e("LotteryTraceMonitor", e);
        return;
    L4:
        if (r1.has(r2) == true) goto L12;
        r1.put(r2, r3);     // Catch: Exception -> L7
        return;
    }
}
