package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x2 {
    public static void g(String r3, Long r4, Long r5, Long r6, by7.e r7) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r3 != null) goto L20;
    L7:
        if (r4 == null) goto L9;
        r0.put("if_name_changed", r4.longValue());     // Catch: JSONException -> L5
    L9:
        if (r5 == null) goto L11;
        r0.put("if_name_id_changed", r5.longValue());     // Catch: JSONException -> L5
    L11:
        if (r6 == null) goto L15;
        r0.put("if_photo_changed", r6.longValue());     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("ProfileEventHelper", "error in ProfileEventHelper profileSettingComplete " + e.getLocalizedMessage());
    L15:
        TrackParams r8 = new TrackParams().merge(r0);
        by7.a r9 = new by7.a("profile_setting_complete");
        if (r7 == null) goto L18;
        r9.b = r7;
    L18:
        r9.a.merge(r8);
        r9.b();
        return;
    L20:
        r0.put("enter_from", r3);     // Catch: JSONException -> L5
        goto L7
    }

    public static final void b(String r4, String r5, String r6, int r7, int r8, String r9, String r10) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        if (com.larus.utils.o0.d("creation_detail") == false) goto L6;
        r1.put("current_page", "creation_detail");
    L6:
        if (com.larus.utils.o0.d(r4) == false) goto L9;
        r1.put("previous_page", r4);
    L9:
        if (com.larus.utils.o0.d("creation_detail") == false) goto L11;
        r1.put("status", r5);
    L11:
        r1.put("is_creation", 1);
        if (com.larus.utils.o0.d(r6) == false) goto L14;
        r1.put("creation_public_status", r6);
    L14:
        r1.put("position", r7);
        r1.put("index", r8);
        if (com.larus.utils.o0.d(r9) == false) goto L17;
        r1.put("content_type", r9);
    L17:
        r1.put("creation_id", r10);
        Unit r11 = Unit.INSTANCE;
        r0.reportEvent("slide", r1);
    }

    public static /* synthetic */ void f(String r9, String r10, String r11, String r12, String r13, String r14, String r15, Long r16) {
        e(r9, r10, r11, r12, r13, r14, r15, null, r16);
    }

    public static final void e(String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, Long r11) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.putOpt("enter_method", r3);
        r1.putOpt("recommend_from", r5);
        r1.putOpt("tab_type", r6);
        r1.putOpt("tab_name", r7);
        r1.putOpt("tab_id", r8);
        r1.putOpt("current_page", r9);
        r1.putOpt("template_page_type", r10);
        r1.putOpt("leave_method", r4);
        r1.putOpt("duration", r11);
        Unit r12 = Unit.INSTANCE;
        r0.reportEvent("leave_ai_generate_page", r1);
    }

    public static final void c(String r4, int r5, String r6, String r7, String r8, int r9, int r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r4, "slideStatus");
        Intrinsics.checkNotNullParameter(r8, "creationId");
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        if (r13 != null) goto L5;
    L12:
        r13 = "click";
    L14:
        if (r5 == (-1)) goto L17;
        r13 = "slide";
    L17:
        r1.put("enter_method", r13);
        if (r5 == (-1)) goto L20;
        r1.put("slide_status", r4);
    L20:
        r1.put("enter_from", r6);
        r1.put("video_id", r7);
        r1.put("creation_id", r8);
        r1.put("position", r9);
        r1.put("index", r10);
        r1.put("current_page", "creation_detail");
        r1.put("previous_page", r12);
        r1.put("is_template", "1");
        r1.put("is_creation", "1");
        if (com.larus.utils.o0.d(r11) == false) goto L23;
        r1.put("creation_public_status", r11);
    L23:
        Unit r14 = Unit.INSTANCE;
        r0.reportEvent("enter_music_detail", r1);
        return;
    L5:
        if (r13.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r13 = null;
    L11:
        if (r13 != null) goto L14;
    L7:
        r2 = false;
        goto L8
    }

    public static final void d(String r4, int r5, String r6, String r7, int r8, int r9, String r10, String r11, boolean r12, boolean r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r4, "slideStatus");
        Intrinsics.checkNotNullParameter(r7, "creationId");
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        if (r14 != null) goto L5;
    L12:
        r14 = "click";
    L14:
        if (r5 == (-1)) goto L17;
        r14 = "slide";
    L17:
        r1.put("enter_method", r14);
        if (r5 == (-1)) goto L20;
        r1.put("slide_status", r4);
    L20:
        r1.put("enter_from", r6);
        r1.putOpt("conversation_id", r15);
        r1.put("creation_id", r7);
        r1.put("position", r8);
        r1.put("index", r9);
        r1.put("current_page", "creation_detail");
        r1.put("previous_page", r10);
        r1.put("is_template", "1");
        r1.put("is_creation", "1");
        r1.put("is_replica_gen", r12 ? 1 : 0);
        if (com.larus.utils.o0.d(r11) == false) goto L23;
        r1.put("creation_public_status", r11);
    L23:
        r1.putOpt("is_image_edit", Integer.valueOf(r13 ? 1 : 0));
        Unit r16 = Unit.INSTANCE;
        r0.reportEvent("enter_picture_detail", r1);
        return;
    L5:
        if (r14.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r14 = null;
    L11:
        if (r14 != null) goto L14;
    L7:
        r2 = false;
        goto L8
    }

    public static void a(String r22, String r23, String r24, String r25, String r26, Integer r27, Integer r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, Integer r36, String r37, String r38, String r39, String r40, Long r41, int r42) {
        if ((r42 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r42 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r42 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r42 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r42 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r42 & 32) == 0) goto L25;
        Integer r7 = null;
    L27:
        if ((r42 & 64) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r42 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r42 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r42 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r42 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r42 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r42 & 4096) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r42 & 8192) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r42 & 16384) == 0) goto L61;
        Integer r2 = null;
    L63:
        if ((r42 & 32768) == 0) goto L65;
        String r18 = null;
    L67:
        if ((r42 & 65536) == 0) goto L69;
        String r19 = null;
    L71:
        if ((r42 & 131072) == 0) goto L73;
        String r16 = null;
    L74:
        String r17 = r14;
        if ((r42 & 262144) == 0) goto L77;
        String r110 = null;
    L79:
        if ((r42 & 524288) == 0) goto L81;
        Long r0 = 0L;
    L82:
        String r20 = r9;
        com.larus.platform.service.o r21 = com.larus.platform.service.o.a;
        JSONObject r43 = new JSONObject();
        r43.putOpt("bot_id", r13);
        r43.putOpt("ai_generate_tab_id", r10);
        r43.putOpt("ai_generate_tab_name", r12);
        r43.putOpt("ai_generate_tab_type", r11);
        r43.putOpt("leave_method", r16);
        r43.putOpt("duration", r0);
        r43.putOpt("enter_method", r110);
        r43.put("recommend_from", r1);
        r43.put("template_id", r3);
        r43.put("template_type", r4);
        r43.put("template_source", r5);
        r43.put("current_page", r15);
        r43.put("creator_id", r6);
        r43.put("position", r7);
        r43.put("page_index", r8);
        r43.put("template_rec_req_id", r20);
        r43.put("previous_page", r17);
        r43.put("use_template_uv", r2);
        r43.put("chat_type", r18);
        r43.put("conversation_id", r19);
        Unit r44 = Unit.INSTANCE;
        r21.reportEvent("click_close_template_detail", r43);
        return;
    L81:
        r0 = r41;
        goto L82
    L77:
        r110 = r40;
        goto L79
    L73:
        r16 = r39;
        goto L74
    L69:
        r19 = r38;
        goto L71
    L65:
        r18 = r37;
        goto L67
    L61:
        r2 = r36;
        goto L63
    L57:
        r15 = r35;
        goto L59
    L53:
        r14 = r34;
        goto L55
    L49:
        r13 = r33;
        goto L51
    L45:
        r12 = r32;
        goto L47
    L41:
        r11 = r31;
        goto L43
    L37:
        r10 = r30;
        goto L39
    L33:
        r9 = r29;
        goto L35
    L29:
        r8 = r28;
        goto L31
    L25:
        r7 = r27;
        goto L27
    L21:
        r6 = r26;
        goto L23
    L17:
        r5 = r25;
        goto L19
    L13:
        r4 = r24;
        goto L15
    L9:
        r3 = r23;
        goto L11
    L5:
        r1 = r22;
        goto L7
    }
}
