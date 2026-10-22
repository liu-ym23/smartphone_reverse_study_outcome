package com.bytedance.android.live.profit.taskcenter.panel.trace;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.trace.api.ProductId;
import com.bytedance.android.livesdk.revenue.service.room.b;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.kmp.util.e;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l01.d;
import org.json.JSONObject;
import r27.a;
import vh6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LiveTaskPanelTraceMonitor {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/profit/taskcenter/panel/trace/LiveTaskPanelTraceMonitor$EventName;", "", "", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "TTLIVE_TASK_PANEL_MANAGE", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum EventName extends Enum<EventName> {
        public static final EventName TTLIVE_TASK_PANEL_MANAGE = null;
        public static final /* synthetic */ EventName[] a = null;
        private final String eventName;

        static {
            EventName r1 = new EventName();
            TTLIVE_TASK_PANEL_MANAGE = r1;
            a = new EventName[]{r1};
        }

        public static EventName valueOf(String r1) {
            return (EventName) a.a(EventName.class, r1);
        }

        public static EventName[] values() {
            return (EventName[]) a.clone();
        }

        public EventName() {
            super("TTLIVE_TASK_PANEL_MANAGE", 0);
            this.eventName = "ttlive_task_panel_manage";
        }

        public final String getEventName() {
            return this.eventName;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/profit/taskcenter/panel/trace/LiveTaskPanelTraceMonitor$Step;", "", "", "step", "Ljava/lang/String;", "getStep", "()Ljava/lang/String;", "HANDLE_POPUP_SCHEMA", "CHECK_FREQUENCY_DAILY", "CHECK_FREQUENCY_LIFETIME", "CREATE_PANEL_INFO", "OBSERVE_PANEL_STATE", "PANEL_SHOW_HYBRID_SUCCESS", "PANEL_SHOW_HYBRID_FAIL", "TASK_PANEL_MANAGER_RESET", "HYBRID_DISMISS", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Step extends Enum<Step> {
        public static final Step CHECK_FREQUENCY_DAILY = null;
        public static final Step CHECK_FREQUENCY_LIFETIME = null;
        public static final Step CREATE_PANEL_INFO = null;
        public static final Step HANDLE_POPUP_SCHEMA = null;
        public static final Step HYBRID_DISMISS = null;
        public static final Step OBSERVE_PANEL_STATE = null;
        public static final Step PANEL_SHOW_HYBRID_FAIL = null;
        public static final Step PANEL_SHOW_HYBRID_SUCCESS = null;
        public static final Step TASK_PANEL_MANAGER_RESET = null;
        public static final /* synthetic */ Step[] a = null;
        private final String step;

        public static Step valueOf(String r1) {
            return (Step) a.a(Step.class, r1);
        }

        public static Step[] values() {
            return (Step[]) a.clone();
        }

        static {
            Step r1 = new Step("HANDLE_POPUP_SCHEMA", 0, "handle_popup_schema");
            HANDLE_POPUP_SCHEMA = r1;
            Step r2 = new Step("CHECK_FREQUENCY_DAILY", 1, "check_frequency_daily");
            CHECK_FREQUENCY_DAILY = r2;
            Step r3 = new Step("CHECK_FREQUENCY_LIFETIME", 2, "check_frequency_lifetime");
            CHECK_FREQUENCY_LIFETIME = r3;
            Step r4 = new Step("CREATE_PANEL_INFO", 3, "create_panel_info");
            CREATE_PANEL_INFO = r4;
            Step r5 = new Step("OBSERVE_PANEL_STATE", 4, "observe_panel_state");
            OBSERVE_PANEL_STATE = r5;
            Step r6 = new Step("PANEL_SHOW_HYBRID_SUCCESS", 5, "panel_show_hybrid_success");
            PANEL_SHOW_HYBRID_SUCCESS = r6;
            Step r7 = new Step("PANEL_SHOW_HYBRID_FAIL", 6, "panel_show_hybrid_fail");
            PANEL_SHOW_HYBRID_FAIL = r7;
            Step r8 = new Step("TASK_PANEL_MANAGER_RESET", 7, "task_panel_manager_reset");
            TASK_PANEL_MANAGER_RESET = r8;
            Step r9 = new Step("HYBRID_DISMISS", 8, "hybrid_dismiss");
            HYBRID_DISMISS = r9;
            a = new Step[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
        }

        public final String getStep() {
            return this.step;
        }

        public Step(String r1, int r2, String r3) {
            super(r1, r2);
            this.step = r3;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v7, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    public static void a(String r12, String r13, Map r14) {
        Intrinsics.checkNotNullParameter(r12, "eventName");
        Intrinsics.checkNotNullParameter(r13, "step");
        Intrinsics.checkNotNullParameter(r14, "extra");
        LinkedHashMap r3 = new LinkedHashMap();
        b r4 = c.b(b.class);
        d r5 = (d) f.a(d.class);
        LinkedHashMap r6 = new LinkedHashMap();
        IRoom r7 = r4.getRoom();
        String r8 = DataType.FALSE;
        if (r7 == null) goto L6;
        String r9 = r7.getOwnerUserIdString();
        if (r9 == null) goto L6;
    L7:
        r6.put("anchor_id", r9);
        r6.put("user_id", r5.getCurrentUserId());
        IRoom r10 = r4.getRoom();
        if (r10 == null) goto L13;
        String r15 = String.valueOf(r10.getId());
        if (r15 == null) goto L13;
        r8 = r15;
    L13:
        r6.put("room_id", r8);
        r6.putAll(r3);
        LinkedHashMap r16 = new LinkedHashMap();
        LinkedHashMap r17 = new LinkedHashMap();
        r17.put("consume_time", Long.valueOf(e.b()));
        String r18 = (String) r16.get("to_user_id");
        if (r18 == null) goto L16;
        r17.put("to_user_id", r18);
    L16:
        Intrinsics.checkNotNullParameter(r12, "eventName");
        Intrinsics.checkNotNullParameter(r13, "step");
        Intrinsics.checkNotNullParameter(r6, "traceMetaData");
        Intrinsics.checkNotNullParameter(r17, "traceIndexData");
        j01.e r0 = new j01.e(r12, "task_center");
        JSONObject r19 = new JSONObject();
        JSONObject r1 = new JSONObject();
        JSONObject r20 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "metaBuilder");
        Intrinsics.checkNotNullParameter(r1, "category");
        Intrinsics.checkNotNullParameter(r20, "metric");
        Intrinsics.checkNotNullParameter(r19, "extra");
        String r2 = (String) r6.get("anchor_id");
        if (r2 == null) goto L19;
        r0.a(r2);
    L19:
        String r22 = (String) r6.get("user_id");
        if (r22 == null) goto L22;
        r0.i(r22);
    L22:
        String r23 = (String) r6.get("room_id");
        if (r23 == null) goto L25;
        r0.e(r23);
    L25:
        String r24 = (String) r6.get("trace_id");
        if (r24 == null) goto L28;
        r0.h(r24);
    L28:
        String r25 = (String) r6.get("log_id");
        if (r25 == null) goto L31;
        r0.c(r25);
    L31:
        r0.b(r17);
        r0.d(ProductId.TASK_CENTER);
        r0.g(r13);
        Intrinsics.checkNotNullParameter(r19, "json");
        Iterator r110 = r14.entrySet().iterator();
    L33:
        if (r110.hasNext() == false) goto L45;
        Map.Entry r111 = (Map.Entry) r110.next();
        String r26 = (String) r111.getKey();
        ?? r112 = r111.getValue();
        if ((r112 instanceof Map) == true) goto L37;
        ?? r27 = 0;
    L38:
        Map r28 = (Map) r27;
        if (r28 == null) goto L44;
        r112 = new JSONObject();
        Iterator r29 = r28.entrySet().iterator();
    L42:
        if (r29.hasNext() == false) goto L44;
        Map.Entry r30 = (Map.Entry) r29.next();
        Object r32 = r30.getKey();
        Object r33 = r30.getValue();
        j01.d.b(r112, String.valueOf(r32), r33);
    L44:
        Intrinsics.checkNotNullParameter(r26, "key");
        Intrinsics.checkNotNullParameter(r112, "value");
        j01.d.b(r19, r26, r112);
        goto L33
    L37:
        r27 = r112;
        goto L38
    L45:
        ((j01.b) f.a(j01.b.class)).R4(r0.a, r1, r20, r19);
        return;
    L6:
        r9 = DataType.FALSE;
        goto L7
    }
}
