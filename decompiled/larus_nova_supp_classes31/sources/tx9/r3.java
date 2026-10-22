package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class r3 {
    public static void b(String r5, String r6, Integer r7, String r8, String r9, String r10, Integer r11) {
        JSONObject r2 = new JSONObject();
        Intrinsics.checkNotNullParameter(r9, "presentationId");
        Intrinsics.checkNotNullParameter(r10, "resourceId");
        Intrinsics.checkNotNullParameter(r2, "params");
        r2.put("current_page", "aippt_permission_setting");     // Catch: JSONException -> L23
        Intrinsics.checkNotNullParameter("aippt_permission_setting", "<set-?>");     // Catch: JSONException -> L23
        a1.a = "aippt_permission_setting";     // Catch: JSONException -> L23
        r2.put("previous_page", "aippt_new_detail");     // Catch: JSONException -> L23
        Intrinsics.checkNotNullParameter("aippt_new_detail", "<set-?>");     // Catch: JSONException -> L23
        a1.b = "aippt_new_detail";     // Catch: JSONException -> L23
        if (r6 == null) goto L6;
        r2.put("artifact_meta_id", r6);     // Catch: JSONException -> L23
    L6:
        if (r7 == null) goto L9;
        r2.put("artifact_type", r7.toString());     // Catch: JSONException -> L23
    L9:
        if (com.larus.utils.o0.d(r8) == false) goto L12;
        r2.put("aippt_task_id", r8);     // Catch: JSONException -> L23
    L12:
        if (com.larus.utils.o0.d(r9) == false) goto L15;
        r2.put("presentation_id", r9);     // Catch: JSONException -> L23
    L15:
        if (com.larus.utils.o0.d(r10) == false) goto L17;
        r2.put("resource_id", r10);     // Catch: JSONException -> L23
    L17:
        if (r11 == null) goto L20;
        r2.put("resource_type", r11.toString());     // Catch: JSONException -> L23
    L20:
        if (com.larus.utils.o0.d(r5) == false) goto L25;
        r2.put("click_from", r5);     // Catch: JSONException -> L23
    L25:
        TrackParams r12 = new TrackParams().merge(r2);
        by7.a r13 = new by7.a("aippt_permission_setting_click");
        r13.a.merge(r12);
        r13.b();
        return;
    L23:
        e = move-exception;
        FLogger.a.e("SlidesShareTraceHelper", "error in SlidesShareTraceHelper enterPage " + e.getLocalizedMessage());
        goto L25
    }

    public static void a(String r16, String r17, String r18, String r19, Integer r20, String r21, String r22, String r23, Integer r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, JSONObject r33) {
        Intrinsics.checkNotNullParameter(r22, "presentationId");
        Intrinsics.checkNotNullParameter(r23, "resourceId");
        Intrinsics.checkNotNullParameter(r25, "canvasType");
        Intrinsics.checkNotNullParameter(r26, "contentSecType");
        Intrinsics.checkNotNullParameter(r27, "userType");
        Intrinsics.checkNotNullParameter(r28, "messageId");
        Intrinsics.checkNotNullParameter(r29, "conversationId");
        Intrinsics.checkNotNullParameter(r30, "botId");
        Intrinsics.checkNotNullParameter(r31, "sectionId");
        Intrinsics.checkNotNullParameter(r33, "params");
        if (r16 != null) goto L54;
    L7:
        if (r17 == null) goto L9;
        r33.put("previous_page", r17);     // Catch: JSONException -> L5
        Intrinsics.checkNotNullParameter(r17, "<set-?>");     // Catch: JSONException -> L5
        a1.b = r17;     // Catch: JSONException -> L5
    L9:
        if (r18 == null) goto L11;
        r33.put("artifact_meta_id", r18);     // Catch: JSONException -> L5
    L11:
        if (r19 == null) goto L13;
        r33.put("slides_cs_version_id", r19);     // Catch: JSONException -> L5
    L13:
        if (r20 == null) goto L16;
        r33.put("artifact_type", r20.toString());     // Catch: JSONException -> L5
    L16:
        if (com.larus.utils.o0.d(r21) == false) goto L19;
        r33.put("aippt_task_id", r21);     // Catch: JSONException -> L5
    L19:
        if (com.larus.utils.o0.d(r22) == false) goto L22;
        r33.put("presentation_id", r22);     // Catch: JSONException -> L5
    L22:
        if (com.larus.utils.o0.d(r23) == false) goto L24;
        r33.put("resource_id", r23);     // Catch: JSONException -> L5
    L24:
        if (r24 == null) goto L27;
        r33.put("resource_type", r24.toString());     // Catch: JSONException -> L5
    L27:
        if (com.larus.utils.o0.d(r25) == false) goto L30;
        r33.put("canvas_type", r25);     // Catch: JSONException -> L5
    L30:
        if (com.larus.utils.o0.d(r26) == false) goto L33;
        r33.put("content_sec_type", r26);     // Catch: JSONException -> L5
    L33:
        if (com.larus.utils.o0.d(r27) == false) goto L36;
        r33.put("user_type", r27);     // Catch: JSONException -> L5
    L36:
        if (com.larus.utils.o0.d(r28) == false) goto L39;
        r33.put("message_id", r28);     // Catch: JSONException -> L5
    L39:
        if (com.larus.utils.o0.d(r29) == false) goto L42;
        r33.put("conversation_id", r29);     // Catch: JSONException -> L5
    L42:
        if (com.larus.utils.o0.d(r30) == false) goto L45;
        r33.put("bot_id", r30);     // Catch: JSONException -> L5
    L45:
        if (com.larus.utils.o0.d(r31) == false) goto L48;
        r33.put("section_id", r31);     // Catch: JSONException -> L5
    L48:
        if (com.larus.utils.o0.d(r32) == false) goto L52;
        r33.put("artifact_create_method", r32);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("SlidesShareTraceHelper", "error in SlidesShareTraceHelper enterPage " + e.getLocalizedMessage());
    L52:
        TrackParams r0 = new TrackParams().merge(r33);
        by7.a r1 = new by7.a("aippt_download");
        r1.a.merge(r0);
        r1.b();
        return;
    L54:
        r33.put("current_page", r16);     // Catch: JSONException -> L5
        Intrinsics.checkNotNullParameter(r16, "<set-?>");     // Catch: JSONException -> L5
        a1.a = r16;     // Catch: JSONException -> L5
        goto L7
    }
}
