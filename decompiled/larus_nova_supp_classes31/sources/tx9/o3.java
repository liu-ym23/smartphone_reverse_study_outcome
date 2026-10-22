package tx9;

import android.text.TextUtils;
import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o3 {
    public static boolean a;
    public static final ArrayList<by7.a> b = null;

    static {
        b = new ArrayList();
    }

    public static void b(String r2) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Result.constructor-impl(r0.put("current_page", r2));     // Catch: Throwable -> L5
    L7:
        TrackParams r3 = new TrackParams().merge(r0);
        by7.a r4 = new by7.a("search_create_bot_show");
        r4.a.merge(r3);
        r4.b();
        return;
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static void d(String r2, String r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L15;
    L7:
        if (r3 == null) goto L9;
        r0.put("current_page", r3);     // Catch: JSONException -> L5
    L9:
        if (r4 == null) goto L13;
        r0.put("schema_name", r4);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("ShowEventHelper", "error in ShowEventHelper mobShowCreatePanelCell " + e.getLocalizedMessage());
    L13:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("show_create_panel_cell");
        r6.a.merge(r5);
        r6.b();
        return;
    L15:
        r0.put("position", r2);     // Catch: JSONException -> L5
        goto L7
    }

    public static void h(String r2, String r3, String r4, Boolean r5, Boolean r6, Integer r7, String r8, int r9) {
        JSONObject r1 = null;
        if ((r9 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r9 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r9 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r9 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r9 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r9 & 128) == 0) goto L26;
        JSONObject r10 = new JSONObject();
    L27:
        Intrinsics.checkNotNullParameter(r10, "params");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L54
        if (r2 == null) goto L31;
        r10.put("button_name", r2);     // Catch: Throwable -> L54
    L31:
        if (r3 == null) goto L33;
        r10.put("creation_id", r3);     // Catch: Throwable -> L54
    L33:
        if (r4 == null) goto L35;
        r10.put("create_way", r4);     // Catch: Throwable -> L54
    L35:
        String r11 = "1";
        if (r5 != null) goto L38;
    L42:
        if (r6 != null) goto L44;
    L48:
        if (r7 == null) goto L50;
        r10.put("polish_cnt", String.valueOf(r7.intValue()));     // Catch: Throwable -> L54
    L50:
        if (r8 == null) goto L52;
        r1 = r10.put("current_page", r8);     // Catch: Throwable -> L54
    L52:
        Result.constructor-impl(r1);     // Catch: Throwable -> L54
    L56:
        TrackParams r12 = new TrackParams().merge(r10);
        by7.a r13 = new by7.a("sp_polish_show");
        r13.a.merge(r12);
        r13.b();
        return;
    L44:
        if (r6.booleanValue() == true) goto L47;
        r11 = "0";
    L47:
        r10.put("if_polish", r11);     // Catch: Throwable -> L54
        goto L48
    L38:
        if (r5.booleanValue() == false) goto L40;
        Object r14 = "1";
    L41:
        r10.put("if_auto_filled", r14);     // Catch: Throwable -> L54
        goto L42
    L40:
        r14 = "0";
    L54:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L56
    L26:
        r10 = null;
        goto L27
    }

    public static void a(String r2, String r3, String r4, String r5, String r6, String r7, String r8, by7.e r9, int r10) {
        if ((r10 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r10 & 4) == 0) goto L9;
        r3 = null;
    L9:
        if ((r10 & 8) == 0) goto L12;
        r4 = null;
    L12:
        if ((r10 & 16) == 0) goto L15;
        r5 = null;
    L15:
        if ((r10 & 32) == 0) goto L18;
        r6 = null;
    L18:
        if ((r10 & 64) == 0) goto L21;
        r7 = null;
    L21:
        if ((r10 & 128) == 0) goto L24;
        r8 = null;
    L24:
        if ((r10 & 256) == 0) goto L26;
        JSONObject r0 = new JSONObject();
    L28:
        if ((r10 & 512) == 0) goto L30;
        r9 = null;
    L30:
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L54;
    L35:
        if (r4 == null) goto L37;
        r0.put("previous_page", r4);     // Catch: JSONException -> L33
    L37:
        if (r3 == null) goto L39;
        r0.put("creation_id", r3);     // Catch: JSONException -> L33
    L39:
        if (r5 == null) goto L41;
        r0.put("create_way", r5);     // Catch: JSONException -> L33
    L41:
        if (r6 == null) goto L43;
        r0.put("type", r6);     // Catch: JSONException -> L33
    L43:
        if (r7 == null) goto L45;
        r0.put("from_activity_name", r7);     // Catch: JSONException -> L33
    L45:
        if (r8 == null) goto L49;
        r0.put("from_activity_module", r8);     // Catch: JSONException -> L33
    L33:
        e = move-exception;
        FLogger.a.e("ShowEventHelper", "error in ShowEventHelper createBotBlockWindowShow " + e.getLocalizedMessage());
    L49:
        TrackParams r11 = new TrackParams().merge(r0);
        by7.a r12 = new by7.a("create_bot_block_window_show");
        if (r9 == null) goto L52;
        r12.b = r9;
    L52:
        r12.a.merge(r11);
        r12.b();
        return;
    L54:
        r0.put("enter_method", r2);     // Catch: JSONException -> L33
        goto L35
    L26:
        r0 = null;
        goto L28
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public static void e(Long r18, String r19, Long r20, String r21, String r22, String r23, String r24, String r25, String r26, Long r27, Long r28, String r29, String r30, String r31, String r32, int r33) {
        if ((r33 & 2) == 0) goto L5;
        Long r1 = null;
    L7:
        if ((r33 & 4) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r33 & 8) == 0) goto L13;
        Long r4 = null;
    L15:
        if ((r33 & 16) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r33 & 128) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r33 & 256) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r33 & 512) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r33 & 1024) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r33 & 2048) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r33 & 4096) == 0) goto L41;
        Long r11 = null;
    L43:
        if ((r33 & 8192) == 0) goto L45;
        Long r12 = null;
    L47:
        if ((r33 & 16384) == 0) goto L49;
        String r13 = null;
    L51:
        if ((32768 & r33) == 0) goto L53;
        String r14 = null;
    L55:
        if ((65536 & r33) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r33 & 131072) == 0) goto L61;
        String r2 = null;
    L63:
        if ((r33 & 262144) == 0) goto L65;
        JSONObject r16 = new JSONObject();
    L66:
        Intrinsics.checkNotNullParameter(r16, "params");
        String r110 = r2;
        if (r1 != null) goto L69;
        String r210 = "ShowEventHelper";
    L74:
        if (r3 == null) goto L78;
        r16.put("chat_type", r3);     // Catch: JSONException -> L76
    L78:
        if (r4 == null) goto L80;
        r16.put("conversation_id", r4.longValue());     // Catch: JSONException -> L76
    L80:
        if (r5 == null) goto L82;
        r16.put("current_page", r5);     // Catch: JSONException -> L76
    L82:
        if (r6 == null) goto L84;
        r16.put("message_id", r6);     // Catch: JSONException -> L76
    L84:
        if (r7 == null) goto L86;
        r16.put("onboarding_content_source", r7);     // Catch: JSONException -> L76
    L86:
        if (r8 == null) goto L88;
        r16.put("onboarding_question", r8);     // Catch: JSONException -> L76
    L88:
        if (r9 == null) goto L90;
        r16.put("onboarding_type", r9);     // Catch: JSONException -> L76
    L90:
        if (r10 == null) goto L92;
        r16.put("previous_page", r10);     // Catch: JSONException -> L76
    L92:
        if (r11 == null) goto L94;
        r16.put("prompt_cnt", r11.longValue());     // Catch: JSONException -> L76
    L94:
        if (r12 == null) goto L96;
        r16.put("show_rank", r12.longValue());     // Catch: JSONException -> L76
    L96:
        if (r13 == null) goto L98;
        r16.put("show_way", r13);     // Catch: JSONException -> L76
    L98:
        if (r14 == null) goto L100;
        r16.put("use_nickname", r14);     // Catch: JSONException -> L76
    L100:
        if (r110 == null) goto L102;
        r16.put("prompt_type", r110);     // Catch: JSONException -> L76
    L102:
        if (r15 == 0) goto L106;
        r16.put("reco_request_id", r15);     // Catch: JSONException -> L76
    L76:
        e = move-exception;
        String r17 = r210;
        FLogger.a.e(r17, "error in ShowEventHelper showOnboardingCard " + e.getLocalizedMessage());
    L107:
        TrackParams r0 = new TrackParams().merge(r16);
        by7.a r34 = new by7.a("show_onboarding_card");
        r34.a.merge(r0);
        r34.b();
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L110
        com.larus.platform.service.g.a.monitorEventForSlardar("show_onboarding_card", r16, null, null);     // Catch: Throwable -> L110
        Object r36 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L110
    L112:
        Throwable r37 = Result.exceptionOrNull-impl(r36);
        if (r37 == null) goto L121;
        FLogger.a.e(r17, "slardar report error, showOnboardingCard " + r37.getLocalizedMessage());
        return;
    L121:
        return;
    L110:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r36 = Result.constructor-impl(ResultKt.createFailure(th));
    L106:
        r17 = r210;
        goto L107
    L69:
        r210 = "ShowEventHelper";
        r16.put("bot_id", r1.longValue());     // Catch: JSONException -> L76
        goto L74
    L65:
        r16 = null;
        goto L66
    L61:
        r2 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L59
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r1 = r18;
        goto L7
    }

    public static void c(String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, Integer r41, JSONObject r42, by7.e r43, int r44) {
        if ((r44 & 2) == 0) goto L5;
        Object r1 = null;
    L7:
        if ((r44 & 4) == 0) goto L9;
        Object r3 = null;
    L11:
        if ((r44 & 8) == 0) goto L13;
        Object r4 = null;
    L15:
        if ((r44 & 16) == 0) goto L17;
        Object r5 = null;
    L19:
        if ((r44 & 32) == 0) goto L21;
        Object r6 = null;
    L23:
        if ((r44 & 64) == 0) goto L25;
        Object r7 = null;
    L27:
        if ((r44 & 128) == 0) goto L29;
        Object r8 = null;
    L31:
        if ((r44 & 256) == 0) goto L33;
        Object r9 = null;
    L35:
        if ((r44 & 512) == 0) goto L37;
        Object r10 = null;
    L39:
        if ((r44 & 1024) == 0) goto L41;
        Object r11 = null;
    L43:
        if ((r44 & 2048) == 0) goto L45;
        Object r12 = null;
    L47:
        if ((r44 & 8192) == 0) goto L49;
        Object r13 = null;
    L51:
        if ((r44 & 16384) == 0) goto L53;
        Object r14 = null;
    L55:
        if ((32768 & r44) == 0) goto L57;
        Object r15 = null;
    L59:
        if ((r44 & 65536) == 0) goto L61;
        Object r2 = null;
    L63:
        if ((r44 & 131072) == 0) goto L65;
        Object r18 = null;
    L67:
        if ((r44 & 262144) == 0) goto L69;
        Object r19 = null;
    L71:
        if ((r44 & 524288) == 0) goto L73;
        Object r20 = null;
    L75:
        if ((r44 & 1048576) == 0) goto L77;
        Integer r17 = null;
    L79:
        if ((r44 & 2097152) == 0) goto L81;
        JSONObject r16 = new JSONObject();
    L83:
        if ((r44 & 4194304) == 0) goto L85;
        by7.e r22 = null;
    L86:
        Intrinsics.checkNotNullParameter(r16, "params");
        Object r210 = r15;
        if (r1 != null) goto L142;
    L91:
        if (r3 == null) goto L93;
        r16.put("chat_type", r3);     // Catch: JSONException -> L89
    L93:
        if (r4 == null) goto L95;
        r16.put("current_page", r4);     // Catch: JSONException -> L89
    L95:
        if (r5 == null) goto L97;
        r16.put("enter_method", r5);     // Catch: JSONException -> L89
    L97:
        if (r6 == null) goto L99;
        r16.put("is_immersive_background", r6);     // Catch: JSONException -> L89
    L99:
        if (r7 == null) goto L101;
        r16.put("previous_page", r7);     // Catch: JSONException -> L89
    L101:
        if (r8 == null) goto L103;
        r16.put("query", r8);     // Catch: JSONException -> L89
    L103:
        if (r9 == null) goto L105;
        r16.put("query_id", r9);     // Catch: JSONException -> L89
    L105:
        if (r10 == null) goto L107;
        r16.put("rank", r10);     // Catch: JSONException -> L89
    L107:
        if (r11 == null) goto L109;
        r16.put("recommend_from", r11);     // Catch: JSONException -> L89
    L109:
        if (r12 == null) goto L111;
        r16.put("req_id", r12);     // Catch: JSONException -> L89
    L111:
        if (r13 == null) goto L113;
        r16.put("search_id", r13);     // Catch: JSONException -> L89
    L113:
        if (r14 == null) goto L115;
        r16.put("search_request_id", r14);     // Catch: JSONException -> L89
    L115:
        if (r210 == null) goto L117;
        r16.put("search_result_id", r210);     // Catch: JSONException -> L89
    L117:
        if (r2 == 0) goto L119;
        r16.put("user_id", r2);     // Catch: JSONException -> L89
    L119:
        Object r0 = r18;
        if (r0 == null) goto L122;
        r16.put("group_type", r0);     // Catch: JSONException -> L89
    L122:
        Object r21 = r19;
        if (r21 == null) goto L125;
        r16.put("item_id", r21);     // Catch: JSONException -> L89
    L125:
        Object r45 = r20;
        if (r45 == null) goto L128;
        r16.put("is_call_bot", r45);     // Catch: JSONException -> L89
    L128:
        if (r17 == null) goto L132;
        r16.put("bot_type", r17.intValue());     // Catch: JSONException -> L89
    L89:
        e = move-exception;
        FLogger.a.e("ShowEventHelper", "error in ShowEventHelper showBotChat " + e.getLocalizedMessage());
    L132:
        TrackParams r46 = new TrackParams().merge(r16);
        by7.a r47 = new by7.a("show_bot_chat");
        by7.e r48 = r22;
        if (r48 == null) goto L136;
        r47.b = r48;
    L136:
        if (a == false) goto L140;
        FLogger r49 = FLogger.a;
        StringBuilder r50 = new StringBuilder("addShowBotEventWhenReturnToMain ");
        ArrayList<by7.a> r51 = b;
        r50.append(r51.size());
        r49.i("ShowEventHelper", r50.toString());
        if (r51.size() >= 100) goto L144;
        r47.a.merge(r46);
        r51.add(r47);
        return;
    L144:
        return;
    L140:
        r47.a.merge(r46);
        r47.b();
        return;
    L142:
        r16.put("bot_id", r1);     // Catch: JSONException -> L89
        goto L91
    L85:
        r22 = r43;
        goto L86
    L81:
        r16 = r42;
        goto L83
    L77:
        r17 = r41;
        goto L79
    L73:
        r20 = r40;
        goto L75
    L69:
        r19 = r39;
        goto L71
    L65:
        r18 = r38;
        goto L67
    L61:
        r2 = r37;
        goto L63
    L57:
        r15 = r36;
        goto L59
    L53:
        r14 = r35;
        goto L55
    L49:
        r13 = r34;
        goto L51
    L45:
        r12 = r33;
        goto L47
    L41:
        r11 = r32;
        goto L43
    L37:
        r10 = r31;
        goto L39
    L33:
        r9 = r30;
        goto L35
    L29:
        r8 = r29;
        goto L31
    L25:
        r7 = r28;
        goto L27
    L21:
        r6 = r27;
        goto L23
    L17:
        r5 = r26;
        goto L19
    L13:
        r4 = r25;
        goto L15
    L9:
        r3 = r24;
        goto L11
    L5:
        r1 = r23;
        goto L7
    }

    public static void g(Long r16, String r17, Long r18, String r19, String r20, String r21, String r22, Long r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, Boolean r41) {
        JSONObject r15 = new JSONObject();
        Intrinsics.checkNotNullParameter(r15, "params");
        if (r35 != null) goto L69;
    L7:
        if (r37 == null) goto L9;
        r15.put("action_bar_item_id", r37);     // Catch: JSONException -> L5
    L9:
        if (r36 == null) goto L11;
        r15.put("action_bar_template_id", r36);     // Catch: JSONException -> L5
    L11:
        if (r38 == null) goto L13;
        r15.put("action_bar_key", r38);     // Catch: JSONException -> L5
    L13:
        if (r16 == null) goto L15;
        r15.put("bot_id", r16.longValue());     // Catch: JSONException -> L5
    L15:
        if (r17 == null) goto L17;
        r15.put("chat_type", r17);     // Catch: JSONException -> L5
    L17:
        if (r18 == null) goto L19;
        r15.put("conversation_id", r18.longValue());     // Catch: JSONException -> L5
    L19:
        if (r19 == null) goto L21;
        r15.put("current_page", r19);     // Catch: JSONException -> L5
    L21:
        r15.put("enter_chat_method", r20);     // Catch: JSONException -> L5
        r15.put("group_type", "private");     // Catch: JSONException -> L5
        if (r21 == null) goto L24;
        r15.put("message_id", r21);     // Catch: JSONException -> L5
    L24:
        if (r22 == null) goto L26;
        r15.put("previous_page", r22);     // Catch: JSONException -> L5
    L26:
        if (r23 == null) goto L28;
        r15.put("prompt_position", r23.longValue());     // Catch: JSONException -> L5
    L28:
        if (r24 == null) goto L31;
        r15.put("suggested_type", r24);     // Catch: JSONException -> L5
    L31:
        if (TextUtils.isEmpty(r25) == true) goto L34;
        r15.put("request_id", r25);     // Catch: JSONException -> L5
    L34:
        if (TextUtils.isEmpty(r26) == true) goto L37;
        r15.put("rs_request_id", r26);     // Catch: JSONException -> L5
    L37:
        if (TextUtils.isEmpty(r27) == true) goto L40;
        r15.put("recommend_botid", r27);     // Catch: JSONException -> L5
    L40:
        if (TextUtils.isEmpty(r28) == true) goto L43;
        r15.put("recommend_bot_1sttype", r28);     // Catch: JSONException -> L5
    L43:
        if (TextUtils.isEmpty(r29) == true) goto L46;
        r15.put("recommend_bot_2ndtype", r29);     // Catch: JSONException -> L5
    L46:
        if (TextUtils.isEmpty(r30) == true) goto L48;
        r15.put("recommend_bot_3rdtype", r30);     // Catch: JSONException -> L5
    L48:
        if (r31 == null) goto L50;
        r15.put("show_from", r31);     // Catch: JSONException -> L5
    L50:
        if (r32 == null) goto L52;
        r15.put("action_name", r32);     // Catch: JSONException -> L5
    L52:
        r15.put("section_id", r33);     // Catch: JSONException -> L5
        if (r34 == null) goto L55;
        r15.put("item_id", r34);     // Catch: JSONException -> L5
    L55:
        if (r39 == null) goto L58;
        r15.put("item_type", r39);     // Catch: JSONException -> L5
    L58:
        if (r40 == null) goto L61;
        r15.put("agent_id", r40);     // Catch: JSONException -> L5
    L61:
        if (Intrinsics.areEqual(r41, Boolean.TRUE) == false) goto L63;
        String r1 = "1";
    L64:
        r15.put("is_stream", r1);     // Catch: JSONException -> L5
    L67:
        TrackParams r0 = new TrackParams().merge(r15);
        by7.a r2 = new by7.a("show_suggested_prompt_single_question");
        r2.a.merge(r0);
        r2.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("ShowEventHelper", "error in ShowEventHelper showSuggestedPromptSingleQuestion " + e.getLocalizedMessage());
        goto L67
    L63:
        r1 = "0";
        goto L64
    L69:
        r15.put("suggest_action_type", r35);     // Catch: JSONException -> L5
        goto L7
    }

    public static void f(Long r31, String r32, Long r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, Long r41, Long r42, String r43, String r44, String r45, String r46, Integer r47, String r48, String r49, String r50, String r51, Integer r52, String r53, String r54, String r55, String r56, String r57, String r58, int r59, String r60, String r61, JSONObject r62, int r63, int r64) {
        if ((r63 & 2) == 0) goto L5;
        Long r1 = null;
    L7:
        if ((r63 & 4) == 0) goto L9;
        Object r3 = null;
    L11:
        if ((r63 & 8) == 0) goto L13;
        Long r4 = null;
    L15:
        if ((r63 & 16) == 0) goto L17;
        Object r5 = null;
    L19:
        if ((r63 & 128) == 0) goto L21;
        Object r6 = null;
    L23:
        if ((r63 & 256) == 0) goto L25;
        Object r7 = null;
    L27:
        if ((r63 & 512) == 0) goto L29;
        Object r8 = null;
    L31:
        if ((r63 & 1024) == 0) goto L33;
        Object r9 = null;
    L35:
        if ((r63 & 2048) == 0) goto L37;
        Object r10 = null;
    L39:
        if ((r63 & 4096) == 0) goto L41;
        Object r11 = null;
    L43:
        if ((r63 & 16384) == 0) goto L45;
        Long r12 = null;
    L47:
        if ((32768 & r63) == 0) goto L49;
        Long r13 = null;
    L51:
        if ((65536 & r63) == 0) goto L53;
        Object r14 = null;
    L55:
        if ((131072 & r63) == 0) goto L57;
        Object r15 = null;
    L59:
        if ((r63 & 262144) == 0) goto L61;
        Object r2 = null;
    L63:
        if ((r63 & 524288) == 0) goto L65;
        Object r18 = null;
    L67:
        if ((r63 & 1048576) == 0) goto L69;
        Integer r17 = null;
    L71:
        if ((r63 & 2097152) == 0) goto L73;
        Object r20 = null;
    L75:
        if ((r63 & 8388608) == 0) goto L77;
        Object r21 = null;
    L79:
        if ((r63 & 16777216) == 0) goto L81;
        Object r22 = null;
    L83:
        if ((r63 & 33554432) == 0) goto L85;
        Object r23 = null;
    L87:
        if ((r63 & 67108864) == 0) goto L89;
        Integer r19 = null;
    L90:
        Object r310 = r2;
        if ((r63 & 134217728) == 0) goto L93;
        Object r16 = null;
    L94:
        Object r311 = r16;
        if ((r63 & 268435456) == 0) goto L97;
        Object r24 = null;
    L99:
        if ((r63 & 536870912) == 0) goto L101;
        Object r25 = null;
    L103:
        if ((r63 & 1073741824) == 0) goto L105;
        Object r26 = null;
    L107:
        if ((r63 & Integer.MIN_VALUE) == 0) goto L109;
        Object r0 = null;
    L111:
        if ((r64 & 1) == 0) goto L113;
        Object r27 = null;
    L115:
        if ((r64 & 2) == 0) goto L117;
        int r28 = 0;
    L119:
        if ((r64 & 4) == 0) goto L121;
        Object r29 = null;
    L123:
        if ((r64 & 8) == 0) goto L125;
        Object r30 = null;
    L127:
        if ((r64 & 16) == 0) goto L129;
        JSONObject r65 = new JSONObject();
    L130:
        Object r312 = r0;
        Intrinsics.checkNotNullParameter(r65, "params");
        if (r10 != null) goto L209;
    L135:
        if (r1 == null) goto L138;
        r65.put("bot_id", r1.longValue());     // Catch: JSONException -> L133
    L138:
        if (r3 == null) goto L140;
        r65.put("chat_type", r3);     // Catch: JSONException -> L133
    L140:
        if (r4 == null) goto L142;
        r65.put("conversation_id", r4.longValue());     // Catch: JSONException -> L133
    L142:
        if (r5 == null) goto L144;
        r65.put("current_page", r5);     // Catch: JSONException -> L133
    L144:
        if (r6 == null) goto L146;
        r65.put("message_id", r6);     // Catch: JSONException -> L133
    L146:
        if (r7 == null) goto L148;
        r65.put("onboarding_content_source", r7);     // Catch: JSONException -> L133
    L148:
        if (r8 == null) goto L150;
        r65.put("onboarding_question", r8);     // Catch: JSONException -> L133
    L150:
        if (r9 == null) goto L152;
        r65.put("onboarding_type", r9);     // Catch: JSONException -> L133
    L152:
        if (r11 == null) goto L154;
        r65.put("previous_page", r11);     // Catch: JSONException -> L133
    L154:
        if (r12 == null) goto L156;
        r65.put("prompt_position", r12.longValue());     // Catch: JSONException -> L133
    L156:
        if (r13 == null) goto L158;
        r65.put("prompt_position_row", r13.longValue());     // Catch: JSONException -> L133
    L158:
        if (r14 == 0) goto L160;
        r65.put("prompt_type", r14);     // Catch: JSONException -> L133
    L160:
        if (r15 == 0) goto L162;
        r65.put("prompt_subtype", r15);     // Catch: JSONException -> L133
    L162:
        if (r24 == 0) goto L164;
        r65.put("prompt_from", r24);     // Catch: JSONException -> L133
    L164:
        if (r311 == null) goto L166;
        r65.put("scheme", r311);     // Catch: JSONException -> L133
    L166:
        if (r310 == null) goto L168;
        r65.put("url", r310);     // Catch: JSONException -> L133
    L168:
        Object r66 = r18;
        if (r66 == null) goto L171;
        r65.put("title", r66);     // Catch: JSONException -> L133
    L171:
        if (r17 == null) goto L173;
        r65.put("is_new_fuction", r17.intValue());     // Catch: JSONException -> L133
    L173:
        Object r67 = r20;
        if (r67 == null) goto L176;
        r65.put("reco_request_id", r67);     // Catch: JSONException -> L133
    L176:
        Object r68 = r21;
        if (r68 == null) goto L179;
        r65.put("item_id", r68);     // Catch: JSONException -> L133
    L179:
        Object r69 = r25;
        if (r69 == null) goto L182;
        r65.put("template_id", r69);     // Catch: JSONException -> L133
    L182:
        Object r70 = r22;
        if (r70 == null) goto L185;
        r65.put("item_type", r70);     // Catch: JSONException -> L133
    L185:
        Object r71 = r23;
        if (r71 == null) goto L188;
        r65.put("section_id", r71);     // Catch: JSONException -> L133
    L188:
        Object r72 = r26;
        if (r72 == null) goto L191;
        r65.put("visual_size", r72);     // Catch: JSONException -> L133
    L191:
        if (r312 == null) goto L193;
        r65.put("action_bar_template_id", r312);     // Catch: JSONException -> L133
    L193:
        Object r73 = r27;
        if (r73 == null) goto L196;
        r65.put("tag_code", r73);     // Catch: JSONException -> L133
    L196:
        if (r19 == null) goto L198;
        r65.put("type", r19.intValue());     // Catch: JSONException -> L133
    L198:
        Object r74 = r29;
        if (r74 == null) goto L201;
        r65.put("template_version", r74);     // Catch: JSONException -> L133
    L201:
        Object r75 = r30;
        if (r75 == null) goto L204;
        r65.put("lottery_status", r75);     // Catch: JSONException -> L133
    L204:
        r65.put("is_from_api", r28);     // Catch: JSONException -> L133
    L207:
        TrackParams r76 = new TrackParams().merge(r65);
        by7.a r77 = new by7.a("show_onboarding_card_single_question");
        r77.a.merge(r76);
        r77.b();
        return;
    L133:
        e = move-exception;
        FLogger.a.e("ShowEventHelper", "error in ShowEventHelper showOnboardingCardSingleQuestion " + e.getLocalizedMessage());
        goto L207
    L209:
        r65.put("onboarding_action_type", r10);     // Catch: JSONException -> L133
        goto L135
    L129:
        r65 = r62;
        goto L130
    L125:
        r30 = r61;
        goto L127
    L121:
        r29 = r60;
        goto L123
    L117:
        r28 = r59;
        goto L119
    L113:
        r27 = r58;
        goto L115
    L109:
        r0 = r57;
        goto L111
    L105:
        r26 = r56;
        goto L107
    L101:
        r25 = r55;
        goto L103
    L97:
        r24 = r54;
        goto L99
    L93:
        r16 = r53;
        goto L94
    L89:
        r19 = r52;
        goto L90
    L85:
        r23 = r51;
        goto L87
    L81:
        r22 = r50;
        goto L83
    L77:
        r21 = r49;
        goto L79
    L73:
        r20 = r48;
        goto L75
    L69:
        r17 = r47;
        goto L71
    L65:
        r18 = r46;
        goto L67
    L61:
        r2 = r45;
        goto L63
    L57:
        r15 = r44;
        goto L59
    L53:
        r14 = r43;
        goto L55
    L49:
        r13 = r42;
        goto L51
    L45:
        r12 = r41;
        goto L47
    L41:
        r11 = r40;
        goto L43
    L37:
        r10 = r39;
        goto L39
    L33:
        r9 = r38;
        goto L35
    L29:
        r8 = r37;
        goto L31
    L25:
        r7 = r36;
        goto L27
    L21:
        r6 = r35;
        goto L23
    L17:
        r5 = r34;
        goto L19
    L13:
        r4 = r33;
        goto L15
    L9:
        r3 = r32;
        goto L11
    L5:
        r1 = r31;
        goto L7
    }
}
