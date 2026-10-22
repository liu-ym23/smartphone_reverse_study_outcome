package tx9;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class u2 {
    public static final void b(Integer r3, JSONObject r4, by7.e r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        if (r3 != null) goto L13;
    L8:
        TrackParams r6 = new TrackParams().merge(r4);
        by7.a r7 = new by7.a("finish_album_choose");
        if (r5 == null) goto L11;
        r7.b = r5;
    L11:
        r7.a.merge(r6);
        r7.b();
        return;
    L13:
        r4.put("choose_cnt", r3.intValue());     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        FLogger.a.e("PictureEventHelper", "error in PictureEventHelper mobFinishAlbumChoose " + e.getLocalizedMessage());
        goto L8
    }

    public static void a(String r30, String r31, Boolean r32, Long r33, String r34, String r35, String r36, String r37, String r38, Boolean r39, int r40) {
        Boolean r2 = null;
        if ((r40 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r40 & 2) == 0) goto L9;
        String r16 = null;
    L11:
        if ((r40 & 4) == 0) goto L13;
        Boolean r17 = null;
    L15:
        if ((r40 & 8) == 0) goto L17;
        Long r18 = null;
    L19:
        if ((r40 & 16) == 0) goto L21;
        String r19 = null;
    L23:
        if ((r40 & 32) == 0) goto L25;
        JSONObject r15 = new JSONObject();
    L27:
        if ((r40 & 512) == 0) goto L29;
        String r22 = null;
    L31:
        if ((r40 & 1024) == 0) goto L33;
        String r23 = null;
    L35:
        if ((r40 & 2048) == 0) goto L37;
        String r24 = null;
    L39:
        if ((r40 & 4096) == 0) goto L41;
        String r14 = "download_btn";
    L43:
        if ((r40 & 8192) != 0) goto L46;
        r2 = r39;
    L46:
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "source");
        JSONObject r0 = new JSONObject(r15.toString());     // Catch: JSONException -> L49
    L50:
        JSONObject r10 = r0;
        String r4 = r1;
        String r310 = r14;
        String r29 = r1;
        JSONObject r3 = r15;
        e(r15, r4, r16, r17, r18, r19, null, null, r22, r23, r24, r14, r2);     // Catch: JSONException -> L53
        String r110 = "PictureEventHelper";
    L55:
        TrackParams r5 = new TrackParams().merge(r3);
        by7.a r6 = new by7.a("ai_creation_download_status");
        r6.a.merge(r5);
        r6.b();
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r310, "source");
        String r7 = r110;
        e(r10, r29, r16, r17, r18, r19, null, null, r22, r23, r24, r310, r2);     // Catch: JSONException -> L58
    L60:
        TrackParams r8 = new TrackParams().merge(r10);
        by7.a r9 = new by7.a("ai_creation_download_complete");
        r9.a.merge(r8);
        r9.b();
        return;
    L58:
        e = move-exception;
        FLogger.a.e(r7, "error in PictureEventHelper mobAICreationDownloadComplete " + e.getLocalizedMessage());
    L53:
        e = move-exception;
        r110 = "PictureEventHelper";
        FLogger.a.e(r110, "error in PictureEventHelper mobAICreationDownloadStatus " + e.getLocalizedMessage());
    L49:
        r0 = new JSONObject();
        goto L50
    L41:
        r14 = r38;
        goto L43
    L37:
        r24 = r37;
        goto L39
    L33:
        r23 = r36;
        goto L35
    L29:
        r22 = r35;
        goto L31
    L25:
        r15 = null;
        goto L27
    L21:
        r19 = r34;
        goto L23
    L17:
        r18 = r33;
        goto L19
    L13:
        r17 = r32;
        goto L15
    L9:
        r16 = r31;
        goto L11
    L5:
        r1 = r30;
        goto L7
    }

    public static final void e(JSONObject r12, String r13, String r14, Boolean r15, Long r16, String r17, Long r18, String r19, String r20, String r21, String r22, String r23, Boolean r24) {
        boolean r6 = true;
        String r7 = null;
        if (r20 != null) goto L5;
    L20:
        y0 r9 = null;
    L21:
        if (r13 == null) goto L23;
        r12.put("message_id", r13);
    L23:
        if (r14 == null) goto L25;
        r12.put("creation_id", r14);
    L25:
        if (r15 == null) goto L27;
        r12.put("success", r15.booleanValue() ? 1 : 0);
    L27:
        if (r16 == null) goto L29;
        r12.put("duration", r16.longValue());
    L29:
        if (r17 == null) goto L31;
        r12.put("type", r17);
    L31:
        if (r18 != null) goto L35;
        if (r9 == null) goto L34;
        Long r1 = Long.valueOf(r9.a);
    L36:
        if (r1 == null) goto L38;
        r12.put("file_size", r1.longValue());
    L38:
        if (r19 != null) goto L59;
        if (r9 == null) goto L41;
        String r2 = r9.b;
    L42:
        if (r2 != null) goto L60;
        if (r20 != null) goto L45;
    L58:
        r2 = null;
        goto L60
    L45:
        if ((!StringsKt.isBlank(r20)) == false) goto L47;
        String r3 = r20;
    L48:
        if (r3 == null) goto L58;
        String r4 = StringsKt.substringBefore$default(r3, '?', null, 2, null);
        if (r4 == null) goto L58;
        String r5 = StringsKt.substringBefore$default(r4, '#', null, 2, null);
        if (r5 == null) goto L58;
        String r8 = StringsKt.substringAfterLast$default(r5, '/', null, 2, null);
        if (r8 == null) goto L58;
        r2 = StringsKt.substringAfterLast(r8, '.', "");
        if ((!StringsKt.isBlank(r2)) == false) goto L58;
    L47:
        r3 = null;
    L60:
        if (r2 == null) goto L62;
        r12.put("file_format", r2);
    L62:
        if (r21 == null) goto L64;
        r12.put("error_code", r21);
    L64:
        if (r22 != null) goto L70;
        if (r21 != null) goto L68;
        r6 = false;
    L68:
        if (r6 == false) goto L71;
        r7 = "download failed";
    L71:
        if (r7 == null) goto L73;
        r12.put("error_msg", r7);
    L73:
        if (r23 == null) goto L75;
        r12.put("source", r23);
    L75:
        if (r24 == null) goto L78;
        r12.put("mdl_cache_hit", r24.booleanValue() ? 1 : 0);
        return;
    L78:
        return;
    L70:
        r7 = r22;
        goto L71
    L41:
        r2 = null;
        goto L42
    L59:
        r2 = r19;
        goto L60
    L34:
        r1 = null;
        goto L36
    L35:
        r1 = r18;
        goto L36
    L5:
        if ((!StringsKt.isBlank(r20)) == false) goto L7;
        String r10 = r20;
    L8:
        if (r10 == null) goto L20;
        PolarisFileWrapper r11 = new PolarisFileWrapper(r10);
        if (r11.exists() == false) goto L20;
        if (r11.isFile() == false) goto L20;
        long r110 = r11.length();
        String r25 = FilesKt.getExtension(r11);
        if ((!StringsKt.isBlank(r25)) == true) goto L19;
        r25 = null;
    L19:
        r9 = new y0(r110, r25);
        goto L21
    L7:
        r10 = null;
        goto L8
    }

    public static void c(String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, Boolean r26, Boolean r27, Boolean r28, String r29, JSONObject r30, String r31, int r32) {
        if ((r32 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r32 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r32 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r32 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r32 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r32 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r32 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r32 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r32 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r32 & 512) == 0) goto L41;
        Boolean r11 = null;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        Boolean r12 = null;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        Boolean r13 = null;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r32 & 16384) == 0) goto L57;
        JSONObject r15 = new JSONObject();
    L59:
        if ((r32 & 32768) == 0) goto L61;
        String r0 = null;
    L62:
        Intrinsics.checkNotNullParameter(r15, "params");
        if (r13 != null) goto L104;
    L67:
        String r16 = "0";
    L68:
        r15.putOpt("is_deep_thinking", r16);     // Catch: JSONException -> L100
        r15.putOpt("ai_create_show_mode", r14);     // Catch: JSONException -> L100
        if (r12 == null) goto L71;
        Integer r110 = Integer.valueOf(r12.booleanValue() ? 1 : 0);     // Catch: JSONException -> L100
    L72:
        r15.put("is_image_edit", r110);     // Catch: JSONException -> L100
        if (r1 == null) goto L75;
        r15.put("bot_id", r1);     // Catch: JSONException -> L100
    L75:
        if (r3 == null) goto L77;
        r15.put("conversation_id", r3);     // Catch: JSONException -> L100
    L77:
        if (r4 == null) goto L79;
        r15.put("is_onboarding", r4);     // Catch: JSONException -> L100
    L79:
        if (r5 == null) goto L81;
        r15.put("log_id", r5);     // Catch: JSONException -> L100
    L81:
        if (r6 == null) goto L83;
        r15.put("message_id", r6);     // Catch: JSONException -> L100
    L83:
        if (r7 == null) goto L85;
        r15.put("original_content_source", r7);     // Catch: JSONException -> L100
    L85:
        if (r8 == null) goto L87;
        r15.put("pic_id", r8);     // Catch: JSONException -> L100
    L87:
        if (r9 == null) goto L89;
        r15.put("request_id", r9);     // Catch: JSONException -> L100
    L89:
        if (r10 == null) goto L91;
        r15.put("user_type", r10);     // Catch: JSONException -> L100
    L91:
        if (r0 == null) goto L93;
        r15.put("show_from", r0);     // Catch: JSONException -> L100
    L93:
        if (r11 != null) goto L95;
    L102:
        TrackParams r2 = new TrackParams().merge(r15);
        by7.a r33 = new by7.a("picture_message_show");
        r33.a.merge(r2);
        r33.b();
        return;
    L95:
        if (r11.booleanValue() == false) goto L97;
        int r34 = 1;
    L98:
        r15.put("is_replica_gen", r34);     // Catch: JSONException -> L100
    L100:
        e = move-exception;
        FLogger.a.e("PictureEventHelper", "error in PictureEventHelper pictureMessageShow " + e.getLocalizedMessage());
        goto L102
    L97:
        r34 = 0;
        goto L98
    L71:
        r110 = null;
        goto L72
    L104:
        r16 = l3.f(r13);     // Catch: JSONException -> L100
        if (r16 != null) goto L68;
    L61:
        r0 = r31;
        goto L62
    L57:
        r15 = r30;
        goto L59
    L53:
        r14 = r29;
        goto L55
    L49:
        r13 = r28;
        goto L51
    L45:
        r12 = r27;
        goto L47
    L41:
        r11 = r26;
        goto L43
    L37:
        r10 = r25;
        goto L39
    L33:
        r9 = r24;
        goto L35
    L29:
        r8 = r23;
        goto L31
    L25:
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r1 = r17;
        goto L7
    }

    public static void d(String r16, Integer r17, Long r18, String r19, String r20, String r21, String r22, Boolean r23, Boolean r24, Boolean r25, String r26, Boolean r27, Float r28, String r29, JSONObject r30, int r31) {
        if ((r31 & 1) == 0) goto L5;
        Object r1 = null;
    L7:
        if ((r31 & 2) == 0) goto L9;
        Integer r3 = null;
    L11:
        if ((r31 & 4) == 0) goto L13;
        Long r4 = null;
    L15:
        if ((r31 & 8) == 0) goto L17;
        Object r5 = null;
    L19:
        if ((r31 & 16) == 0) goto L21;
        Object r6 = null;
    L23:
        if ((r31 & 32) == 0) goto L25;
        Object r7 = null;
    L27:
        if ((r31 & 64) == 0) goto L29;
        Object r8 = null;
    L31:
        if ((r31 & 128) == 0) goto L33;
        Boolean r9 = null;
    L35:
        if ((r31 & 256) == 0) goto L37;
        Boolean r10 = null;
    L39:
        if ((r31 & 512) == 0) goto L41;
        Boolean r11 = null;
    L43:
        if ((r31 & 1024) == 0) goto L45;
        Object r12 = null;
    L47:
        if ((r31 & 2048) == 0) goto L49;
        Boolean r13 = null;
    L51:
        if ((r31 & 4096) == 0) goto L53;
        Object r14 = null;
    L55:
        if ((r31 & 8192) == 0) goto L57;
        Object r15 = null;
    L59:
        if ((r31 & 16384) == 0) goto L61;
        JSONObject r2 = new JSONObject();
    L62:
        Intrinsics.checkNotNullParameter(r2, "params");
        if (r11 != null) goto L105;
        String r110 = null;
    L67:
        r2.putOpt("is_deep_thinking", r110);     // Catch: JSONException -> L101
        r2.putOpt("ai_create_show_mode", r12);     // Catch: JSONException -> L101
        if (r10 == null) goto L70;
        Integer r111 = Integer.valueOf(r10.booleanValue() ? 1 : 0);     // Catch: JSONException -> L101
    L71:
        r2.putOpt("is_image_edit", r111);     // Catch: JSONException -> L101
        if (r13 == null) goto L74;
        Integer r112 = Integer.valueOf(r13.booleanValue() ? 1 : 0);     // Catch: JSONException -> L101
    L75:
        r2.putOpt("success", r112);     // Catch: JSONException -> L101
        if (r1 == null) goto L78;
        r2.put("original_content_source", r1);     // Catch: JSONException -> L101
    L78:
        if (r3 == null) goto L80;
        r2.put("position", r3.intValue());     // Catch: JSONException -> L101
    L80:
        if (r4 == null) goto L82;
        r2.put("from_pic_template_id", r4.longValue());     // Catch: JSONException -> L101
    L82:
        if (r5 == null) goto L84;
        r2.put("bot_id", r5);     // Catch: JSONException -> L101
    L84:
        if (r6 == null) goto L86;
        r2.put("message_id", r6);     // Catch: JSONException -> L101
    L86:
        if (r7 == null) goto L88;
        r2.put("request_id", r7);     // Catch: JSONException -> L101
    L88:
        if (r8 == null) goto L90;
        r2.put("pic_id", r8);     // Catch: JSONException -> L101
    L90:
        if (r14 == null) goto L92;
        r2.put("show_pct", r14);     // Catch: JSONException -> L101
    L92:
        if (r15 == null) goto L94;
        r2.put("creation_task_id", r15);     // Catch: JSONException -> L101
    L94:
        if (r9 != null) goto L96;
    L103:
        TrackParams r0 = new TrackParams().merge(r2);
        by7.a r32 = new by7.a("picture_message_show_single");
        r32.a.merge(r0);
        r32.b();
        return;
    L96:
        if (r9.booleanValue() == false) goto L98;
        int r33 = 1;
    L99:
        r2.put("is_replica_gen", r33);     // Catch: JSONException -> L101
    L101:
        e = move-exception;
        FLogger.a.e("PictureEventHelper", "error in PictureEventHelper mobScrollPictureSingleShow " + e.getLocalizedMessage());
        goto L103
    L98:
        r33 = 0;
        goto L99
    L74:
        r112 = null;
        goto L75
    L70:
        r111 = null;
        goto L71
    L105:
        r110 = l3.f(r11);     // Catch: JSONException -> L101
        goto L67
    L61:
        r2 = r30;
        goto L62
    L57:
        r15 = r29;
        goto L59
    L53:
        r14 = r28;
        goto L55
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }
}
