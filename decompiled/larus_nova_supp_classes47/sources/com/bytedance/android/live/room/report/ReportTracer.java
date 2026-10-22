package com.bytedance.android.live.room.report;

import am2.x;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant$BusinessSource;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ReportTracer {
    public static Map<String, String> a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/room/report/ReportTracer$CallFunction;", "", "reportWithUserProfileEvent", "report", "reportWithReportAnchorEvent", "screenShotReport", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum CallFunction extends Enum<CallFunction> {
        public static final /* synthetic */ CallFunction[] a = null;
        public static final CallFunction report = null;
        public static final CallFunction reportWithReportAnchorEvent = null;
        public static final CallFunction reportWithUserProfileEvent = null;
        public static final CallFunction screenShotReport = null;

        static {
            CallFunction r1 = new CallFunction("reportWithUserProfileEvent", 0);
            reportWithUserProfileEvent = r1;
            CallFunction r2 = new CallFunction("report", 1);
            report = r2;
            CallFunction r3 = new CallFunction("reportWithReportAnchorEvent", 2);
            reportWithReportAnchorEvent = r3;
            CallFunction r4 = new CallFunction("screenShotReport", 3);
            screenShotReport = r4;
            a = new CallFunction[]{r1, r2, r3, r4};
        }

        public static CallFunction valueOf(String r1) {
            return (CallFunction) r27.a.a(CallFunction.class, r1);
        }

        public static CallFunction[] values() {
            return (CallFunction[]) a.clone();
        }

        public CallFunction(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b!\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/room/report/ReportTracer$EventName;", "", "call_start", "call_end", "call_function", "params_check", "result", "failed_reason", "generate_report_params", "report_full_link", "direct_report_anchor", "get_report_object", "report_object", "report_DHXT_link", "report_DHXT_pk", "report_pk_liveroomid", "report_anchor_report_type", "report_anchor_request_page", "report_anchor_report_scene", "report_anchor_for_anchor", "report_anchor_for_audience", "generate_report_anchor_url_builder", "generate_report_anchor_dialog", "report_anchor_dialog_show", "report_anchor_url", "switch_to_portrait", "on_report_configuration_changed", "generate_report_comment_url", "open_report_comment_page", "open_report_hotsoon_page", "set_room_mute", "open_report_user_page", "generate_screen_shot_report_url", "open_screen_shot_report_page", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum EventName extends Enum<EventName> {
        public static final /* synthetic */ EventName[] a = null;
        public static final EventName call_end = null;
        public static final EventName call_function = null;
        public static final EventName call_start = null;
        public static final EventName direct_report_anchor = null;
        public static final EventName failed_reason = null;
        public static final EventName generate_report_anchor_dialog = null;
        public static final EventName generate_report_anchor_url_builder = null;
        public static final EventName generate_report_comment_url = null;
        public static final EventName generate_report_params = null;
        public static final EventName generate_screen_shot_report_url = null;
        public static final EventName get_report_object = null;
        public static final EventName on_report_configuration_changed = null;
        public static final EventName open_report_comment_page = null;
        public static final EventName open_report_hotsoon_page = null;
        public static final EventName open_report_user_page = null;
        public static final EventName open_screen_shot_report_page = null;
        public static final EventName params_check = null;
        public static final EventName report_DHXT_link = null;
        public static final EventName report_DHXT_pk = null;
        public static final EventName report_anchor_dialog_show = null;
        public static final EventName report_anchor_for_anchor = null;
        public static final EventName report_anchor_for_audience = null;
        public static final EventName report_anchor_report_scene = null;
        public static final EventName report_anchor_report_type = null;
        public static final EventName report_anchor_request_page = null;
        public static final EventName report_anchor_url = null;
        public static final EventName report_full_link = null;
        public static final EventName report_object = null;
        public static final EventName report_pk_liveroomid = null;
        public static final EventName result = null;
        public static final EventName set_room_mute = null;
        public static final EventName switch_to_portrait = null;

        static {
            EventName r1 = new EventName("call_start", 0);
            call_start = r1;
            EventName r2 = new EventName("call_end", 1);
            call_end = r2;
            EventName r3 = new EventName("call_function", 2);
            call_function = r3;
            EventName r4 = new EventName("params_check", 3);
            params_check = r4;
            EventName r5 = new EventName("result", 4);
            result = r5;
            EventName r6 = new EventName("failed_reason", 5);
            failed_reason = r6;
            EventName r7 = new EventName("generate_report_params", 6);
            generate_report_params = r7;
            EventName r8 = new EventName("report_full_link", 7);
            report_full_link = r8;
            EventName r9 = new EventName("direct_report_anchor", 8);
            direct_report_anchor = r9;
            EventName r10 = new EventName("get_report_object", 9);
            get_report_object = r10;
            EventName r12 = new EventName("report_object", 10);
            report_object = r12;
            EventName r13 = new EventName("report_DHXT_link", 11);
            report_DHXT_link = r13;
            EventName r14 = new EventName("report_DHXT_pk", 12);
            report_DHXT_pk = r14;
            EventName r15 = new EventName("report_pk_liveroomid", 13);
            report_pk_liveroomid = r15;
            EventName r16 = new EventName("report_anchor_report_type", 14);
            report_anchor_report_type = r16;
            EventName r17 = new EventName("report_anchor_request_page", 15);
            report_anchor_request_page = r17;
            EventName r18 = new EventName("report_anchor_report_scene", 16);
            report_anchor_report_scene = r18;
            EventName r19 = new EventName("report_anchor_for_anchor", 17);
            report_anchor_for_anchor = r19;
            EventName r20 = new EventName("report_anchor_for_audience", 18);
            report_anchor_for_audience = r20;
            EventName r22 = new EventName("generate_report_anchor_url_builder", 19);
            generate_report_anchor_url_builder = r22;
            EventName r23 = new EventName("generate_report_anchor_dialog", 20);
            generate_report_anchor_dialog = r23;
            EventName r24 = new EventName("report_anchor_dialog_show", 21);
            report_anchor_dialog_show = r24;
            EventName r25 = new EventName("report_anchor_url", 22);
            report_anchor_url = r25;
            EventName r26 = new EventName("switch_to_portrait", 23);
            switch_to_portrait = r26;
            EventName r27 = new EventName("on_report_configuration_changed", 24);
            on_report_configuration_changed = r27;
            EventName r28 = new EventName("generate_report_comment_url", 25);
            generate_report_comment_url = r28;
            EventName r29 = new EventName("open_report_comment_page", 26);
            open_report_comment_page = r29;
            EventName r30 = new EventName("open_report_hotsoon_page", 27);
            open_report_hotsoon_page = r30;
            EventName r32 = new EventName("set_room_mute", 28);
            set_room_mute = r32;
            EventName r33 = new EventName("open_report_user_page", 29);
            open_report_user_page = r33;
            EventName r34 = new EventName("generate_screen_shot_report_url", 30);
            generate_screen_shot_report_url = r34;
            EventName r35 = new EventName("open_screen_shot_report_page", 31);
            open_screen_shot_report_page = r35;
            a = new EventName[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r32, r33, r34, r35};
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

    public static void g() {
        d(EventName.result, DataType.TRUE);
        b(EventName.call_end);
        e();
    }

    public static void e() {
        u.l().sendLog("livesdk_experience_link_report", a, new Object[0]);
        Map<String, String> r0 = a;
        Room r1 = ((IRoomService) k.n(IRoomService.class)).getCurrentRoomFromRoomContext();
        int r2 = com.bytedance.android.live.core.monitor.trace.e.m;
        com.bytedance.android.live.core.monitor.trace.e.a r3 = com.bytedance.android.live.core.monitor.trace.e.b.a("livesdk_experience_link_report", "live_report");
        r3.c = "webcast_client_community";
        com.bytedance.android.livesdk.user.f r4 = k.n(IUserService.class).user();
        String r5 = null;
        if (r4 == null) goto L5;
        String r6 = r4.n();
    L6:
        r3.g = r6;
        if (r1 == null) goto L9;
        String r7 = r1.getOwnerUserIdString();
    L10:
        r3.f = r7;
        if (r1 == null) goto L13;
        String r8 = r1.getIdStr();
    L14:
        r3.e = r8;
        com.bytedance.android.livesdk.user.f r9 = k.n(IUserService.class).user();
        if (r9 == null) goto L17;
        r5 = r9.n();
    L17:
        r3.a = r5;
        com.bytedance.android.live.core.monitor.trace.e r10 = r3.a();
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L20
        BaseMonitor.add(r12, "message", String.valueOf(r0));     // Catch: Exception -> L20
        com.bytedance.android.live.core.monitor.trace.c.b(r10, r12);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        ALogger.e("livesdk_experience_link_report", "IllegalArgumentException error: " + e.toString());
        return;
    L13:
        r8 = null;
        goto L14
    L9:
        r7 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    static {
    }

    public static void b(EventName r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        d(r2, String.valueOf(System.currentTimeMillis()));
    }

    public static void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        d(EventName.result, DataType.FALSE);
        d(EventName.failed_reason, r2);
        b(EventName.call_end);
        e();
    }

    public static void c(EventName r1, CallFunction r2) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
        Intrinsics.checkNotNullParameter(r2, "value");
        d(r1, r2.name());
    }

    public static void d(EventName r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
        Intrinsics.checkNotNullParameter(r2, "value");
        Map<String, String> r0 = a;
        if (r0 == null) goto L6;
        String r3 = r0.put(r1.name(), r2);
        return;
    }

    public static void h(ReportConstant$BusinessSource r4, IBaseUser r5, IRoom r6) {
        Intrinsics.checkNotNullParameter(r4, "businessSource");
        Map<String, String> r0 = a;
        if (r0 == null) goto L5;
        ((LinkedHashMap) r0).clear();
    L5:
        String r1 = null;
        a = null;
        LinkedHashMap r2 = new LinkedHashMap();
        a = r2;
        String r7 = (String) r2.put("business_source", r4.getBusinessType());
        Map<String, String> r8 = a;
        if (r8 == null) goto L16;
        IUserService r3 = k.f(IUserService.class);
        if (r3 == null) goto L14;
        com.bytedance.android.livesdk.user.f r9 = r3.user();
        if (r9 == null) goto L14;
        IUser r10 = r9.b();
        if (r10 == null) goto L14;
        String r12 = r10.getIdString();
    L15:
        String r13 = r8.put("current_user_id", String.valueOf(r12));
    L14:
        r12 = null;
    L16:
        Map<String, String> r14 = a;
        if (r14 == null) goto L27;
        IUserService r15 = k.f(IUserService.class);
        if (r15 == null) goto L25;
        com.bytedance.android.livesdk.user.f r16 = r15.user();
        if (r16 == null) goto L25;
        IUser r17 = r16.b();
        if (r17 == null) goto L25;
        Intrinsics.checkNotNullParameter(r17, "$this$secUidExt");
        String r18 = r17.getCastSecUid();
    L26:
        String r19 = r14.put("sec_current_user_id", String.valueOf(r18));
    L25:
        r18 = null;
    L27:
        Map<String, String> r20 = a;
        if (r20 == null) goto L33;
        if (r5 == null) goto L31;
        String r22 = r5.getIdString();
    L32:
        String r23 = r20.put("target_user_id", String.valueOf(r22));
        goto L33
    L31:
        r22 = null;
    L33:
        Map<String, String> r24 = a;
        if (r24 == null) goto L39;
        if (r5 == null) goto L37;
        Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
        String r25 = r5.getCastSecUid();
    L38:
        String r26 = r24.put("sec_target_user_id", String.valueOf(r25));
        goto L39
    L37:
        r25 = null;
    L39:
        Map<String, String> r27 = a;
        if (r27 == null) goto L45;
        if (r6 == null) goto L43;
        Long r28 = Long.valueOf(r6.getId());
    L44:
        String r29 = r27.put("room_id", String.valueOf(r28));
        goto L45
    L43:
        r28 = null;
    L45:
        Map<String, String> r30 = a;
        if (r30 == null) goto L51;
        if (r6 == null) goto L49;
        String r32 = r6.getOwnerUserIdString();
    L50:
        String r33 = r30.put("anchor_id", String.valueOf(r32));
        goto L51
    L49:
        r32 = null;
    L51:
        Map<String, String> r34 = a;
        if (r34 == null) goto L58;
        if (r6 == null) goto L57;
        IBaseUser r35 = r6.getOwner();
        if (r35 == null) goto L57;
        Intrinsics.checkNotNullParameter(r35, "$this$secUidExt");
        r1 = r35.getCastSecUid();
    L57:
        String r36 = r34.put("sec_anchor_id", String.valueOf(r1));
    L58:
        Map<String, String> r37 = a;
        if (r37 == null) goto L65;
        o r38 = u.l().c(x.class);
        o r39 = u.l().c(Room.class);
        if (r38 == null) goto L63;
        r38.a(r37);
    L63:
        if (r39 == null) goto L65;
        r39.a(r37);
    L65:
        b(EventName.call_start);
    }

    public static void a(String r2, String r3, String r4, zg1.u r5) {
        Map<String, String> r0 = a;
        if (r0 == null) goto L5;
        String r6 = r0.put("from_source", String.valueOf(r2));
    L5:
        Map<String, String> r7 = a;
        if (r7 == null) goto L8;
        String r8 = r7.put("report_source", String.valueOf(r3));
    L8:
        Map<String, String> r9 = a;
        if (r9 == null) goto L11;
        String r10 = r9.put("report_type_for_log", String.valueOf(r4));
    L11:
        if (r5 == null) goto L25;
        Map<String, String> r12 = a;
        if (r12 == null) goto L15;
        String r13 = r12.put("comment_msgId", String.valueOf(r5.a()));
    L15:
        Map<String, String> r14 = a;
        if (r14 == null) goto L18;
        String r15 = r14.put("comment_type", String.valueOf(r5.getType()));
    L18:
        Map<String, String> r16 = a;
        if (r16 == null) goto L26;
        String r17 = r5.b();
        if (r17 != null) goto L23;
        r17 = "";
    L23:
        String r18 = r16.put("reported_comment", r17);
        return;
    L26:
        return;
    }
}
