package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class r0 {
    public static void f(String r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r3, "currentPage");
        Intrinsics.checkNotNullParameter(r4, "clickFrom");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.putOpt("click_from", r4);     // Catch: JSONException -> L5
        r0.putOpt("current_page", r3);     // Catch: JSONException -> L5
    L7:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("replica_management_function_click");
        r6.a.merge(r5);
        r6.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("mobReplicaManagementFunctionClick", "error is " + e.getLocalizedMessage());
        goto L7
    }

    public static void h(String r3, String r4, String r5, String r6) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r3, "replicaCreateId");
        Intrinsics.checkNotNullParameter(r4, "clickFrom");
        Intrinsics.checkNotNullParameter(r5, "scene");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.putOpt("replica_create_id", r3);     // Catch: JSONException -> L7
        r0.putOpt("click_from", r4);     // Catch: JSONException -> L7
        r0.putOpt("scene", r5);     // Catch: JSONException -> L7
        if (r6 == null) goto L9;
        r0.putOpt("enter_method", r6);     // Catch: JSONException -> L7
    L9:
        TrackParams r7 = new TrackParams().merge(r0);
        by7.a r8 = new by7.a("upload_replica_pic");
        r8.a.merge(r7);
        r8.b();
        return;
    L7:
        e = move-exception;
        FLogger.a.e("mobUploadReplicaPic", "error is " + e.getLocalizedMessage());
        goto L9
    }

    public static void e(String r3, String r4, String r5, long r6, String r8) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "leaveReason");
        Intrinsics.checkNotNullParameter(r5, "replicaCreateId");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.putOpt("scene", r3);     // Catch: JSONException -> L5
        r0.putOpt("replica_create_id", r5);     // Catch: JSONException -> L5
        r0.putOpt("leave_reason", r4);     // Catch: JSONException -> L5
        r0.putOpt("stay_duration", Long.valueOf(r6));     // Catch: JSONException -> L5
        r0.putOpt("enter_method", r8);     // Catch: JSONException -> L5
    L7:
        TrackParams r7 = new TrackParams().merge(r0);
        by7.a r9 = new by7.a("leave_create_replica_page");
        r9.a.merge(r7);
        r9.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("mobLeaveCreateReplicaPage", "error is " + e.getLocalizedMessage());
        goto L7
    }

    public static void g(TraceFragment r3, String r4, String r5, boolean r6, int r7) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter("replica_video_record_page", "currentPage");
        Intrinsics.checkNotNullParameter(r4, "recordingStep");
        Intrinsics.checkNotNullParameter(r5, "replicaCreateId");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.putOpt("current_page", "replica_video_record_page");     // Catch: JSONException -> L9
        r0.putOpt("replica_create_id", r5);     // Catch: JSONException -> L9
        if (r6 == false) goto L6;
        int r8 = 1;
    L7:
        r0.putOpt("is_has_replica", Integer.valueOf(r8));     // Catch: JSONException -> L9
        r0.putOpt("beauty_filter_level", Integer.valueOf(r7));     // Catch: JSONException -> L9
        r0.putOpt("recording_step", r4);     // Catch: JSONException -> L9
    L11:
        TrackParams r9 = new TrackParams().merge(r0);
        by7.a r10 = new by7.a("replica_video_record_step");
        if (r3 == null) goto L14;
        r10.b = r3;
    L14:
        r10.a.merge(r9);
        r10.b();
        return;
    L6:
        r8 = 0;
    L9:
        e = move-exception;
        FLogger.a.e("mobReplicaVideoRecordStep", "error is " + e.getLocalizedMessage());
        goto L11
    }

    public static void i(String r2, String r3, boolean r4, long r5, String r7, String r8, int r9) {
        JSONObject r1 = null;
        if ((r9 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r9 & 16) == 0) goto L9;
        r7 = null;
    L9:
        if ((r9 & 32) == 0) goto L12;
        r8 = null;
    L12:
        if ((r9 & 64) == 0) goto L14;
        r1 = new JSONObject();
    L14:
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.putOpt("scene", r2);     // Catch: JSONException -> L25
        r1.putOpt("duration", Long.valueOf(r5));     // Catch: JSONException -> L25
        r1.putOpt("replica_create_id", r3);     // Catch: JSONException -> L25
        if (r4 == false) goto L18;
        int r6 = 1;
    L19:
        r1.putOpt("success", Integer.valueOf(r6));     // Catch: JSONException -> L25
        r1.putOpt("pic_id", "");     // Catch: JSONException -> L25
        if (r7 == null) goto L22;
        r1.putOpt("error_info", r7);     // Catch: JSONException -> L25
    L22:
        if (r8 == null) goto L27;
        r1.putOpt("enter_method", r8);     // Catch: JSONException -> L25
    L27:
        TrackParams r10 = new TrackParams().merge(r1);
        by7.a r11 = new by7.a("upload_replica_pic_result");
        r11.a.merge(r10);
        r11.b();
        return;
    L18:
        r6 = 0;
    L25:
        e = move-exception;
        FLogger.a.e("mobUploadReplicaPicResult", "error is " + e.getLocalizedMessage());
        goto L27
    }

    public static final void c(String r2, int r3, int r4, Boolean r5, String r6, JSONObject r7, String r8, by7.e r9) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r7, "params");
        r7.putOpt("pic_cnt", Integer.valueOf(r3));     // Catch: JSONException -> L12
        r7.putOpt("video_cnt", Integer.valueOf(r4));     // Catch: JSONException -> L12
        if (r5 == null) goto L10;
        r5.booleanValue();     // Catch: JSONException -> L12
        if (r5.booleanValue() == false) goto L8;
        int r10 = 1;
    L9:
        r7.putOpt("is_replica_same_person", Integer.valueOf(r10));     // Catch: JSONException -> L12
        goto L10
    L8:
        r10 = 0;
    L10:
        r7.putOpt("scene", r2);     // Catch: JSONException -> L12
        r7.putOpt("replica_create_id", r6);     // Catch: JSONException -> L12
        r7.putOpt("enter_method", r8);     // Catch: JSONException -> L12
    L14:
        TrackParams r11 = new TrackParams().merge(r7);
        by7.a r12 = new by7.a("complete_create_replica");
        if (r9 == null) goto L17;
        r12.b = r9;
    L17:
        r12.a.merge(r11);
        r12.b();
        return;
    L12:
        e = move-exception;
        FLogger.a.e("mobClickCompleteCreateReplica", "error is " + e.getLocalizedMessage());
        goto L14
    }

    public static void a(String r3, int r4, int r5, String r6, String r7, String r8, String r9, Integer r10, String r11, TraceFragment r12, int r13) {
        if ((r13 & 8) == 0) goto L6;
        r6 = null;
    L6:
        if ((r13 & 16) == 0) goto L9;
        r7 = null;
    L9:
        if ((r13 & 32) == 0) goto L12;
        r8 = null;
    L12:
        if ((r13 & 64) == 0) goto L15;
        r9 = null;
    L15:
        if ((r13 & 128) == 0) goto L18;
        r10 = null;
    L18:
        if ((r13 & 256) == 0) goto L20;
        JSONObject r0 = new JSONObject();
    L22:
        if ((r13 & 512) == 0) goto L25;
        r11 = "";
    L25:
        if ((r13 & 1024) == 0) goto L27;
        r12 = null;
    L27:
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.putOpt("ai_generate_tab_id", r7);     // Catch: JSONException -> L30
        r0.putOpt("ai_generate_tab_name", r9);     // Catch: JSONException -> L30
        r0.putOpt("ai_generate_tab_type", r8);     // Catch: JSONException -> L30
        r0.putOpt("scene", r3);     // Catch: JSONException -> L30
        r0.putOpt("replica_create_id", r6);     // Catch: JSONException -> L30
        r0.putOpt("pic_cnt", Integer.valueOf(r4));     // Catch: JSONException -> L30
        r0.putOpt("video_cnt", Integer.valueOf(r5));     // Catch: JSONException -> L30
        r0.putOpt("enter_method", r11);     // Catch: JSONException -> L30
        r0.putOpt("beauty_filter_level", r10);     // Catch: JSONException -> L30
    L32:
        TrackParams r14 = new TrackParams().merge(r0);
        by7.a r15 = new by7.a("click_complete_create_replica");
        if (r12 == null) goto L35;
        r15.b = r12;
    L35:
        r15.a.merge(r14);
        r15.b();
        return;
    L30:
        e = move-exception;
        FLogger.a.e("mobClickCompleteCreateReplica", "error is " + e.getLocalizedMessage());
        goto L32
    L20:
        r0 = null;
        goto L22
    }

    public static void b(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, Boolean r12, int r13) {
        JSONObject r1 = null;
        if ((r13 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r13 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r13 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r13 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r13 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r13 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r13 & 256) == 0) goto L30;
        r10 = null;
    L30:
        if ((r13 & 512) == 0) goto L33;
        r11 = null;
    L33:
        if ((r13 & 1024) == 0) goto L36;
        r12 = null;
    L36:
        if ((r13 & 2048) == 0) goto L38;
        r1 = new JSONObject();
    L38:
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.putOpt("ai_generate_tab_id", r6);     // Catch: JSONException -> L45
        r1.putOpt("ai_generate_tab_name", r8);     // Catch: JSONException -> L45
        r1.putOpt("ai_generate_tab_type", r7);     // Catch: JSONException -> L45
        r1.putOpt("replica_create_id", r2);     // Catch: JSONException -> L45
        r1.putOpt("enter_method", r3);     // Catch: JSONException -> L45
        r1.putOpt("is_from_template", r4);     // Catch: JSONException -> L45
        r1.putOpt("template_id", r5);     // Catch: JSONException -> L45
        r1.putOpt("current_page", r9);     // Catch: JSONException -> L45
        r1.putOpt("from_template_type", r10);     // Catch: JSONException -> L45
        r1.putOpt("click_from", r11);     // Catch: JSONException -> L45
        if (Intrinsics.areEqual(r12, Boolean.TRUE) == false) goto L42;
        int r14 = 1;
    L43:
        r1.putOpt("is_has_replica", Integer.valueOf(r14));     // Catch: JSONException -> L45
    L47:
        TrackParams r15 = new TrackParams().merge(r1);
        by7.a r16 = new by7.a("click_create_replica");
        r16.a.merge(r15);
        r16.b();
        return;
    L42:
        r14 = 0;
    L45:
        e = move-exception;
        FLogger.a.e("mobClickCreateReplica", "error in click_create_replica " + e.getLocalizedMessage());
        goto L47
    }

    public static void d(String r18, int r19, int r20, String r21, boolean r22, long r23, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, Boolean r37, int r38) {
        JSONObject r3 = null;
        if ((r38 & 8) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r38 & 64) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r38 & 128) == 0) goto L13;
        String r5 = "";
    L15:
        if ((r38 & 256) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r38 & 512) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r38 & 1024) == 0) goto L25;
        String r8 = null;
    L27:
        if ((r38 & 2048) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r38 & 4096) == 0) goto L33;
        String r10 = null;
    L35:
        if ((r38 & 8192) == 0) goto L37;
        String r11 = null;
    L39:
        if ((r38 & 16384) == 0) goto L41;
        String r12 = null;
    L43:
        if ((32768 & r38) == 0) goto L45;
        String r13 = null;
    L47:
        if ((65536 & r38) == 0) goto L49;
        String r14 = null;
    L51:
        if ((131072 & r38) == 0) goto L53;
        String r15 = null;
    L55:
        if ((r38 & 262144) == 0) goto L57;
        Boolean r16 = null;
    L59:
        if ((r38 & 524288) == 0) goto L61;
        r3 = new JSONObject();
    L61:
        Intrinsics.checkNotNullParameter(r18, "scene");
        String r24 = r15;
        Intrinsics.checkNotNullParameter(r3, "params");
        r3.putOpt("ai_generate_tab_id", r8);     // Catch: JSONException -> L82
        r3.putOpt("ai_generate_tab_name", r10);     // Catch: JSONException -> L82
        r3.putOpt("ai_generate_tab_type", r9);     // Catch: JSONException -> L82
        r3.putOpt("is_from_template", r6);     // Catch: JSONException -> L82
        r3.putOpt("template_id", r7);     // Catch: JSONException -> L82
        r3.putOpt("scene", r18);     // Catch: JSONException -> L82
        r3.putOpt("duration", Long.valueOf(r23));     // Catch: JSONException -> L82
        r3.putOpt("replica_create_id", r2);     // Catch: JSONException -> L82
        r3.putOpt("pic_cnt", Integer.valueOf(r19));     // Catch: JSONException -> L82
        r3.putOpt("video_cnt", Integer.valueOf(r20));     // Catch: JSONException -> L82
        r3.putOpt("enter_method", r5);     // Catch: JSONException -> L82
        if (r22 == false) goto L65;
        int r1 = 1;
    L66:
        r3.putOpt("success", Integer.valueOf(r1));     // Catch: JSONException -> L82
        if (r16 == null) goto L69;
        r16.booleanValue();     // Catch: JSONException -> L82
        r3.putOpt("is_replica_same_person", Integer.valueOf(r16.booleanValue() ? 1 : 0));     // Catch: JSONException -> L82
    L69:
        if (r4 == null) goto L71;
        r3.putOpt("error_info", r4);     // Catch: JSONException -> L82
    L71:
        if (r11 == null) goto L73;
        r3.put("ai_creation_recommend_from", r11);     // Catch: JSONException -> L82
    L73:
        if (r12 == null) goto L75;
        r3.put("previous_page", r12);     // Catch: JSONException -> L82
    L75:
        if (r13 == null) goto L77;
        r3.put("current_page", r13);     // Catch: JSONException -> L82
    L77:
        if (r14 == null) goto L79;
        r3.put("chat_type", r14);     // Catch: JSONException -> L82
    L79:
        if (r24 == null) goto L84;
        r3.put("bot_id", r24);     // Catch: JSONException -> L82
    L84:
        TrackParams r0 = new TrackParams().merge(r3);
        by7.a r17 = new by7.a("create_replica_result");
        r17.a.merge(r0);
        r17.b();
        return;
    L65:
        r1 = 0;
    L82:
        e = move-exception;
        FLogger.a.e("mobClickCompleteCreateReplica", "error is " + e.getLocalizedMessage());
        goto L84
    L57:
        r16 = r37;
        goto L59
    L53:
        r15 = r36;
        goto L55
    L49:
        r14 = r35;
        goto L51
    L45:
        r13 = r34;
        goto L47
    L41:
        r12 = r33;
        goto L43
    L37:
        r11 = r32;
        goto L39
    L33:
        r10 = r31;
        goto L35
    L29:
        r9 = r30;
        goto L31
    L25:
        r8 = r29;
        goto L27
    L21:
        r7 = r28;
        goto L23
    L17:
        r6 = r27;
        goto L19
    L13:
        r5 = r26;
        goto L15
    L9:
        r4 = r25;
        goto L11
    L5:
        r2 = r21;
        goto L7
    }
}
