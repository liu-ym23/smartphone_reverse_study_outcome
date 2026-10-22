package com.larus.share.impl;

import android.os.Build;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.panel.b;
import com.larus.bmhome.share.panel.h;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.g;
import com.larus.platform.spi.IAIChatService;
import com.larus.trace.CopyContentTypeString;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.l;
import tx9.l3;
import v19.e6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static e a;

    /* JADX INFO: renamed from: com.larus.share.impl.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0027a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareScene.values().length];
            r0[ShareScene.SHARE_APP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L81:
            r0[ShareScene.COMMON_BOT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L95:
            r0[ShareScene.COMMON_BOT_WITH_SAVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L59:
            r0[ShareScene.NOTICE_LIST.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L63:
            r0[ShareScene.WEBVIEW.ordinal()] = 5;     // Catch: NoSuchFieldError -> L32
        L75:
            r0[ShareScene.MESSAGES_LINK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L33
        L89:
            r0[ShareScene.MESSAGES_LINK_SUB_CONV.ordinal()] = 7;     // Catch: NoSuchFieldError -> L34
        L67:
            r0[ShareScene.MESSAGES_LINK_IMAGE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L35
        L83:
            r0[ShareScene.MUSIC_VIDEO.ordinal()] = 9;     // Catch: NoSuchFieldError -> L36
        L85:
            r0[ShareScene.CONVERSATION_GROUP.ordinal()] = 10;     // Catch: NoSuchFieldError -> L37
        L53:
            r0[ShareScene.CONVERSATION_GROUP_WITH_SAVE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L38
        L79:
            r0[ShareScene.IMAGE_VIEWER_REPORT.ordinal()] = 12;     // Catch: NoSuchFieldError -> L39
        L93:
            r0[ShareScene.SINGLE_IMAGE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L40
        L51:
            r0[ShareScene.MUSIC_VIDEO_REPORT.ordinal()] = 14;     // Catch: NoSuchFieldError -> L41
        L65:
            r0[ShareScene.SHOW_LONG_IMAGE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L42
        L91:
            r0[ShareScene.VIDEO_VIEWER.ordinal()] = 16;     // Catch: NoSuchFieldError -> L43
        L57:
            r0[ShareScene.SHOW_LONG_ALBUM.ordinal()] = 17;     // Catch: NoSuchFieldError -> L44
        L61:
            r0[ShareScene.VIDEO_COMPREHEND.ordinal()] = 18;     // Catch: NoSuchFieldError -> L45
        L77:
            r0[ShareScene.CASE.ordinal()] = 19;     // Catch: NoSuchFieldError -> L46
        L55:
            r0[ShareScene.MINI_ARTIFACT.ordinal()] = 20;     // Catch: NoSuchFieldError -> L47
        L71:
            r0[ShareScene.SLIDES.ordinal()] = 21;     // Catch: NoSuchFieldError -> L48
        L73:
            r0[ShareScene.SHARE_LINK.ordinal()] = 22;     // Catch: NoSuchFieldError -> L49
        L87:
            r0[ShareScene.Z_SHARE_LINK_PLANB.ordinal()] = 23;     // Catch: NoSuchFieldError -> L50
        L26:
            a = r0;
        }
    }

    static {
    }

    public a() {
    }

    public static Map a(h r4) {
        if (r4 == null) goto L6;
        Message r1 = r4.O;
        if (r1 == null) goto L6;
    L25:
        if (r1 != null) goto L27;
        return null;
    L27:
        return r1.getExt();
    L6:
        if (r4 == null) goto L24;
        List r5 = r4.P;
        if (r5 == null) goto L24;
        Iterator r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L22;
        Object r2 = r6.next();
        Map r3 = ((Message) r2).getExt();
        if (r3 == null) goto L15;
        String r7 = (String) r3.get("feishu_record_generated_type");
    L17:
        if (l.a(r7) == null) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L11;
    L23:
        r1 = (Message) r2;
        goto L25
    L19:
        r8 = false;
        goto L20
    L15:
        r7 = null;
        goto L17
    L22:
        r2 = null;
    L24:
        r1 = null;
        goto L25
    }

    public static String b(h r5) {
        boolean r0 = false;
        String r2 = null;
        if (r5 == null) goto L14;
        String r3 = r5.t0;
        if (r3 == null) goto L14;
        if (r3.length() <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L14;
        return r3;
    L9:
        r4 = false;
    L14:
        if (r5 == null) goto L24;
        JSONObject r6 = r5.i;
        if (r6 == null) goto L24;
        String r7 = r6.optString("record_scene");
        if (r7 == null) goto L24;
        if (r7.length() <= 0) goto L22;
        r0 = true;
    L22:
        if (r0 == false) goto L24;
    L25:
        if (r7 != null) goto L32;
        Map r8 = a(r5);
        if (r8 == null) goto L30;
        r2 = (String) r8.get("feishu_record_generated_type");
    L30:
        return l.a(r2);
    L32:
        return r7;
    L24:
        r7 = null;
        goto L25
    }

    public static String d(b r1) {
        if (r1 == null) goto L6;
        String r0 = r1.c;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (r1 == null) goto L10;
        String r2 = r1.a;
        if (r2 == null) goto L10;
        return r2;
    L10:
        if (r1 == null) goto L14;
        String r3 = r1.e;
        if (r3 == null) goto L16;
        return r3;
    L16:
        return "";
    L14:
        return "";
    }

    public static int e(BotModel r1) {
        if (r1.getBgImgOpen() == true) goto L5;
    L9:
        return 0;
    L5:
        if (o0.d(r1.getBgImgUrl()) == false) goto L9;
        if (o0.d(r1.getBgImgColor()) == false) goto L9;
        return 1;
    }

    public static String c(wc9.e r3, BotModel r4) {
        IAIChatService.Companion r0 = IAIChatService.a;
        String r1 = null;
        if (r3 == null) goto L5;
        Integer r5 = r3.v;
    L6:
        if (r4 == null) goto L8;
        Integer r2 = r4.getBotType();
    L9:
        if (r4 == null) goto L14;
        BotCreatorInfo r6 = r4.getBotCreatorInfo();
        if (r6 == null) goto L14;
        r1 = r6.getId();
    L14:
        return r0.g(r5, r2, Intrinsics.areEqual(r1, AccountService.a.getUserId()));
    L8:
        r2 = null;
        goto L9
    L5:
        r5 = null;
        goto L6
    }

    public static void f(TrackParams r2, h r3) {
        String r4 = b(r3);
        if (r4 == null) goto L6;
        JSONObject r0 = new JSONObject();
        r0.put("record_scene", r4);
        r0.put("current_page", "aippt_new_detail");
        r0.put("share_scene", "aippt_new");
        r2.merge(r0);
        return;
    }

    public static void g(TrackParams r4, h r5) {
        JSONObject r0 = new JSONObject();
        String r1 = null;
        if (r5 == null) goto L5;
        String r2 = r5.s;
    L6:
        i(r0, "from_template_id", r2);
        if (r5 == null) goto L9;
        String r3 = r5.q;
    L10:
        i(r0, "template_rec_req_id", r3);
        if (r5 == null) goto L13;
        String r6 = r5.r;
    L14:
        i(r0, "template_rec_extra", r6);
        if (r5 == null) goto L17;
        r1 = r5.t;
    L17:
        i(r0, "recommend_from", r1);
        if (r0.length() <= 0) goto L21;
        r4.merge(r0);
        return;
    L21:
        return;
    L13:
        r6 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public static void h(JSONObject r9, h r10) {
        Map r0 = a(r10);
        boolean r1 = false;
        Object r4 = null;
        if (r10 == null) goto L14;
        String r5 = r10.l0;
        if (r5 == null) goto L14;
        if (r5.length() <= 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == true) goto L13;
        r5 = null;
    L13:
        if (r5 == null) goto L14;
    L31:
        if (r10 == null) goto L42;
        String r7 = r10.m0;
        if (r7 == null) goto L42;
        if (r7.length() <= 0) goto L37;
        boolean r8 = true;
    L38:
        if (r8 == true) goto L41;
        r7 = null;
    L41:
        if (r7 == null) goto L42;
    L58:
        Object r2 = b(r10);
        if (r5 == null) goto L61;
        r9.put("feishu_record_id", r5);
    L61:
        if (r7 == null) goto L63;
        r9.put("feishu_record_generated_type", r7);
    L63:
        if (r2 == null) goto L65;
        r9.put("record_scene", r2);
    L65:
        if (r10 == null) goto L75;
        String r3 = r10.n0;
        if (r3 == null) goto L75;
        if (r3.length() <= 0) goto L71;
        r1 = true;
    L71:
        if (r1 == true) goto L74;
        r3 = null;
    L74:
        if (r3 == null) goto L75;
    L76:
        r9.put("is_general_agent", r3);
        if (r10 == null) goto L79;
        r4 = r10.o0;
    L79:
        if (r4 != null) goto L81;
        r4 = "";
    L81:
        r9.put("chat_id", r4);
        return;
    L75:
        r3 = "0";
        goto L76
    L37:
        r8 = false;
    L42:
        if (r10 == null) goto L53;
        JSONObject r11 = r10.i;
        if (r11 == null) goto L53;
        r7 = r11.optString("feishu_record_generated_type");
        if (r7 == null) goto L53;
        if (r7.length() <= 0) goto L50;
        boolean r12 = true;
    L51:
        if (r12 == false) goto L53;
    L54:
        if (r7 != null) goto L58;
        if (r0 == null) goto L57;
        r7 = (String) r0.get("feishu_record_generated_type");
        goto L58
    L57:
        r7 = null;
        goto L58
    L50:
        r12 = false;
    L53:
        r7 = null;
        goto L54
    L9:
        r6 = false;
    L14:
        if (r10 == null) goto L25;
        JSONObject r13 = r10.i;
        if (r13 == null) goto L25;
        r5 = r13.optString("feishu_record_id");
        if (r5 == null) goto L25;
        if (r5.length() <= 0) goto L22;
        boolean r14 = true;
    L23:
        if (r14 == false) goto L25;
    L26:
        if (r5 != null) goto L31;
        if (r0 == null) goto L29;
        r5 = (String) r0.get("feishu_record_id");
        goto L31
    L29:
        r5 = null;
        goto L31
    L22:
        r14 = false;
    L25:
        r5 = null;
        goto L26
    }

    public static String s(ShareScene r1, h r2) {
        if (r2 == null) goto L6;
        String r3 = r2.N;
        if (r3 == null) goto L6;
        return r3;
    L6:
        switch(C0027a.a[r1.ordinal()]) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L22;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L20;
            case 9: goto L18;
            case 10: goto L17;
            case 11: goto L17;
            case 12: goto L16;
            case 13: goto L16;
            case 14: goto L18;
            case 15: goto L15;
            case 16: goto L14;
            case 17: goto L13;
            case 18: goto L12;
            case 19: goto L11;
            case 20: goto L10;
            case 21: goto L9;
            case 22: goto L8;
            case 23: goto L8;
            default: goto L7;
        };
    L7:
        String r4 = r1.getScene();
    L25:
        return r4;
    L8:
        r4 = CopyContentTypeString.LINK;
        goto L25
    L9:
        r4 = "aippt_new";
        goto L25
    L10:
        r4 = "ai_code";
        goto L25
    L11:
        r4 = "user_case";
        goto L25
    L12:
        r4 = "share_video";
        goto L25
    L13:
        r4 = "show_long_album";
        goto L25
    L14:
        r4 = "ai_video";
        goto L25
    L15:
        r4 = "show_long_image";
        goto L25
    L16:
        r4 = "image_viewer";
        goto L25
    L17:
        r4 = "group_chat_invitation";
        goto L25
    L18:
        return "ai_music";
    L19:
        r4 = "new_dialogue";
        goto L25
    L20:
        return "chat_history";
    L21:
        r4 = "webview";
        goto L25
    L22:
        return "bot";
    L23:
        r4 = "app_share";
        goto L25
    }

    public static void i(JSONObject r2, String r3, String r4) {
        if (r4 == null) goto L11;
        boolean r1 = true;
        if ((!StringsKt.isBlank(r4)) == true) goto L6;
    L8:
        r1 = false;
    L9:
        if (r1 == false) goto L11;
    L12:
        if (r4 == null) goto L15;
        r2.put(r3, r4);
        return;
    L15:
        return;
    L6:
        if (Intrinsics.areEqual(r4, "null") == true) goto L8;
    L11:
        r4 = null;
        goto L12
    }

    public static void p(String r11, String r12, String r13) {
        e r0 = a;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r11 != null) goto L8;
    L11:
        e r1 = a;
        if (r1 == null) goto L16;
        WeakReference<by7.e> r2 = r1.d;
        if (r2 == null) goto L16;
        by7.e r3 = r2.get();
    L17:
        e r4 = a;
        if (r4 == null) goto L20;
        h r5 = r4.c;
    L21:
        by7.a r6 = new by7.a("share_panel_click_result");
        TrackParams r7 = new TrackParams();
        JSONObject r8 = new JSONObject();
        if (r5 == null) goto L26;
        BotModel r9 = r5.b;
        if (r9 == null) goto L26;
        r8.put("bot_id", r9.getBotId());
        r8.put("is_immersive_background", e(r9));
        r8.put("chat_type", c(r5.a, r5.b));
    L30:
        r8.put("share_panel_style", "sdk");
        e r10 = a;
        if (r10 == null) goto L35;
        ShareScene r14 = r10.a;
        if (r14 == null) goto L35;
        r8.put("share_scene", s(r14, r5));
    L35:
        r8.put("success", r13);
        if (r5 == null) goto L41;
        Map r15 = r5.q0;
        if (r15 == null) goto L41;
        String r16 = (String) r15.get(r11);
        if (r16 == null) goto L41;
    L42:
        r8.put("click_from", r11);
        r8.put("show_from", r16);
        if (r5 == null) goto L45;
        Integer r17 = r5.F;
    L46:
        r8.putOpt("position", r17);
        if (r5 == null) goto L49;
        String r18 = r5.E;
    L50:
        r8.putOpt("creation_task_id", r18);
        if (r5 == null) goto L55;
        Message r19 = r5.O;
        if (r19 == null) goto L55;
        String r110 = r19.getReplyId();
    L56:
        r8.putOpt("reply_id", r110);
        if (r12 == null) goto L60;
        r8.put("share_id", r12);
    L60:
        if (r8.has("bot_id") == true) goto L66;
        if (r5 == null) goto L63;
        String r111 = r5.g;
    L64:
        r8.put("bot_id", r111);
        goto L66
    L63:
        r111 = null;
    L66:
        if (r8.has("user_type") == true) goto L76;
        if (r5 == null) goto L71;
        Message r112 = r5.O;
        if (r112 == null) goto L71;
        String r113 = r112.getReplyId();
    L73:
        if (o0.d(r113) == false) goto L76;
        r8.putOpt("user_type", "bot");
    L71:
        r113 = null;
    L76:
        if (r8.has("chat_type") == true) goto L82;
        if (r5 == null) goto L79;
        String r114 = r5.f;
    L80:
        r8.put("chat_type", r114);
        goto L82
    L79:
        r114 = null;
    L82:
        if (r8.has("previous_page") == true) goto L88;
        if (r5 == null) goto L85;
        String r20 = r5.d;
    L86:
        r8.put("previous_page", r20);
        goto L88
    L85:
        r20 = null;
    L88:
        if (r8.has("current_page") == true) goto L94;
        if (r5 == null) goto L91;
        String r21 = r5.e;
    L92:
        r8.put("current_page", r21);
        goto L94
    L91:
        r21 = null;
    L94:
        if (r8.has("message_id") == true) goto L99;
        if (r5 == null) goto L97;
        String r22 = r5.h;
    L98:
        r8.put("message_id", r22);
        goto L99
    L97:
        r22 = null;
    L99:
        int r115 = 0;
        if (r5 != null) goto L102;
    L104:
        boolean r23 = false;
    L105:
        String r24 = "1";
        if (r23 == false) goto L108;
        Object r25 = "1";
    L109:
        r8.put("is_replica_gen", r25);
        if (r5 == null) goto L117;
        Integer r26 = r5.m;
        if (r26 == null) goto L117;
        if (r26.intValue() != 4) goto L117;
        r115 = 1;
    L117:
        r8.put("is_image_edit", r115);
        if (r5 == null) goto L126;
        Boolean r116 = r5.u;
        if (r116 == null) goto L126;
        if (r116.booleanValue() == true) goto L125;
        r24 = "0";
    L125:
        r8.put("is_search_card", r24);
    L126:
        if (r5 == null) goto L130;
        String r117 = r5.n;
        if (r117 == null) goto L130;
        r8.put("template_id", r117);
    L130:
        if (r5 == null) goto L134;
        String r118 = r5.o;
        if (r118 == null) goto L134;
        r8.put("template_type", r118);
    L134:
        if (r5 == null) goto L138;
        String r119 = r5.p;
        if (r119 == null) goto L138;
        r8.put("template_source", r119);
    L138:
        if (r5 == null) goto L142;
        String r120 = r5.q;
        if (r120 == null) goto L142;
        r8.put("template_rec_req_id", r120);
    L142:
        if (r5 == null) goto L146;
        String r121 = r5.t;
        if (r121 == null) goto L146;
        r8.put("recommend_from", r121);
    L146:
        if (r5 == null) goto L150;
        String r122 = r5.v;
        if (r122 == null) goto L150;
        r8.put("ai_generate_tab_id", r122);
    L150:
        if (r5 == null) goto L154;
        String r123 = r5.w;
        if (r123 == null) goto L154;
        r8.put("ai_generate_tab_name", r123);
    L154:
        if (r5 == null) goto L158;
        String r124 = r5.x;
        if (r124 == null) goto L158;
        r8.put("ai_generate_tab_type", r124);
    L158:
        if (r5 == null) goto L162;
        Integer r125 = r5.z;
        if (r125 == null) goto L162;
        r8.put("use_template_uv", r125.intValue());
    L162:
        if (r5 == null) goto L166;
        Integer r126 = r5.y;
        if (r126 == null) goto L166;
        r8.put("page_index", r126.intValue());
    L166:
        if (r5 == null) goto L170;
        String r127 = r5.A;
        if (r127 == null) goto L170;
        r8.put("creator_id", r127);
    L170:
        if (r5 == null) goto L174;
        String r128 = r5.B;
        if (r128 == null) goto L174;
        r8.put("conversation_id", r128);
    L174:
        if (r5 == null) goto L178;
        String r129 = r5.D;
        if (r129 == null) goto L178;
        r8.put("user_case_reco_request_id", r129);
    L178:
        if (r5 == null) goto L182;
        String r130 = r5.C;
        if (r130 == null) goto L182;
        r8.put("user_case_item_id", r130);
    L182:
        if (r5 == null) goto L186;
        String r131 = r5.Q;
        if (r131 == null) goto L186;
        r8.put("template_show_enter_method", r131);
    L186:
        if (r5 == null) goto L190;
        Boolean r132 = r5.H;
        if (r132 == null) goto L190;
        String r133 = l3.f(r132);
    L191:
        r8.putOpt("is_deep_thinking", r133);
        if (r5 == null) goto L194;
        String r134 = r5.E;
    L195:
        r8.putOpt("creation_task_id", r134);
        if (r5 == null) goto L198;
        String r135 = r5.G;
    L199:
        r8.putOpt("ai_create_show_mode", r135);
        if (r5 == null) goto L204;
        Boolean r136 = r5.I;
        if (r136 == null) goto L204;
        r8.put("is_ai_creation_puzzle", r136.booleanValue() ? 1 : 0);
    L204:
        if (r5 == null) goto L208;
        String r137 = r5.J;
        if (r137 == null) goto L208;
        r8.put("show_method", r137);
    L208:
        if (r5 == null) goto L212;
        String r138 = r5.K;
        if (r138 == null) goto L212;
        r8.put("page_token", r138);
    L212:
        if (r5 == null) goto L216;
        String r139 = r5.L;
        if (r139 == null) goto L216;
        r8.put("artifact_meta_id", r139);
    L216:
        if (r5 == null) goto L220;
        Integer r140 = r5.M;
        if (r140 == null) goto L220;
        r8.put("resource_type", String.valueOf(r140.intValue()));
    L220:
        if (r5 == null) goto L224;
        String r141 = r5.Z;
        if (r141 == null) goto L224;
        r8.put("aippt_task_id", r141);
    L224:
        if (r5 == null) goto L228;
        String r142 = r5.a0;
        if (r142 == null) goto L228;
        r8.put("presentation_id", r142);
    L228:
        if (r5 == null) goto L232;
        String r143 = r5.b0;
        if (r143 == null) goto L232;
        r8.put("spreadsheet_id", r143);
    L232:
        if (r5 == null) goto L236;
        String r144 = r5.s0;
        if (r144 == null) goto L236;
        r8.put("base_id", r144);
    L236:
        if (r5 == null) goto L240;
        String r145 = r5.c0;
        if (r145 == null) goto L240;
        r8.put("resource_id", r145);
    L240:
        if (r5 == null) goto L244;
        Integer r146 = r5.M;
        if (r146 == null) goto L244;
        r8.put("artifact_type", String.valueOf(r146.intValue()));
    L244:
        if (r5 == null) goto L248;
        String r147 = r5.e0;
        if (r147 == null) goto L248;
        r8.put("canvas_type", r147);
    L248:
        if (r5 == null) goto L252;
        String r148 = r5.T;
        if (r148 == null) goto L252;
        r8.put("click_method", r148);
    L252:
        if (r5 == null) goto L256;
        String r149 = r5.U;
        if (r149 == null) goto L256;
        r8.put("enter_picture_method", r149);
    L256:
        if (r5 == null) goto L260;
        Integer r150 = r5.W;
        if (r150 == null) goto L260;
        r8.put("is_image_edit", r150.intValue());
    L260:
        if (r5 == null) goto L264;
        String r151 = r5.X;
        if (r151 == null) goto L264;
        r8.put("user_type", r151);
    L264:
        if (r5 == null) goto L268;
        String r152 = r5.Y;
        if (r152 == null) goto L268;
        r8.put("image_edit_function_id", r152);
    L268:
        if (r5 == null) goto L272;
        String r153 = r5.V;
        if (r153 == null) goto L272;
        r8.put("enter_method", r153);
    L272:
        h(r8, r5);
        TrackParams r154 = r7.merge(r8);
        if (r5 == null) goto L277;
        JSONObject r155 = r5.i;
        if (r155 == null) goto L277;
        r154.merge(r155);
    L277:
        if (r5 == null) goto L283;
        Function0 r156 = r5.j;
        if (r156 == null) goto L283;
        JSONObject r157 = (JSONObject) r156.invoke();
        if (r157 == null) goto L283;
        r154.merge(r157);
    L283:
        g(r154, r5);
        f(r154, r5);
        if (r3 == null) goto L286;
        r6.b = r3;
    L286:
        r6.a.merge(r154);
        r6.b();
        a = null;
        return;
    L198:
        r135 = null;
        goto L199
    L194:
        r134 = null;
    L190:
        r133 = null;
        goto L191
    L108:
        r25 = "0";
        goto L109
    L102:
        if (r5.l != true) goto L104;
        r23 = true;
    L55:
        r110 = null;
        goto L56
    L49:
        r18 = null;
        goto L50
    L45:
        r17 = null;
    L41:
        r16 = r11;
    L26:
        if (r5 == null) goto L28;
        String r27 = r5.c;
    L29:
        r8.put("chat_type", r27);
        goto L30
    L28:
        r27 = null;
        goto L29
    L20:
        r5 = null;
    L16:
        r3 = null;
        goto L17
    L8:
        if (Intrinsics.areEqual(r11, r0.b) == true) goto L11;
        a = null;
    }

    public static void r(ShareScene r9, h r10, by7.e r11) {
        Intrinsics.checkNotNullParameter(r9, "shareScene");
        by7.a r0 = new by7.a("share_panel_show");
        TrackParams r1 = new TrackParams();
        JSONObject r2 = new JSONObject();
        String r5 = null;
        if (r10 == null) goto L7;
        BotModel r6 = r10.b;
        if (r6 == null) goto L7;
        r2.put("bot_id", r6.getBotId());
        r2.put("is_immersive_background", e(r6));
        r2.put("chat_type", c(r10.a, r10.b));
    L11:
        r2.put("share_panel_style", "sdk");
        int r7 = 0;
        if (r10 != null) goto L14;
    L16:
        boolean r8 = false;
    L17:
        if (r8 == true) goto L19;
    L21:
        String r12 = s(r9, r10);
    L22:
        r2.put("share_scene", r12);
        if (r10 == null) goto L33;
        String r13 = r10.v0;
        if (r13 == null) goto L33;
        if ((!StringsKt.isBlank(r13)) == true) goto L30;
        r13 = null;
    L30:
        if (r13 == null) goto L33;
        r2.put("share_content", r13);
    L33:
        if (r2.has("bot_id") == true) goto L38;
        if (r10 == null) goto L36;
        String r14 = r10.g;
    L37:
        r2.put("bot_id", r14);
        goto L38
    L36:
        r14 = null;
    L38:
        if (r10 == null) goto L42;
        Message r15 = r10.O;
        if (r15 == null) goto L42;
        String r16 = r15.getReplyId();
    L43:
        r2.putOpt("reply_id", r16);
        if (r2.has("message_id") == true) goto L50;
        if (r10 == null) goto L47;
        String r3 = r10.h;
    L48:
        r2.put("message_id", r3);
        goto L50
    L47:
        r3 = null;
    L50:
        if (r2.has("chat_type") == true) goto L56;
        if (r10 == null) goto L53;
        String r17 = r10.f;
    L54:
        r2.put("chat_type", r17);
        goto L56
    L53:
        r17 = null;
    L56:
        if (r2.has("previous_page") == true) goto L62;
        if (r10 == null) goto L59;
        String r4 = r10.d;
    L60:
        r2.put("previous_page", r4);
        goto L62
    L59:
        r4 = null;
    L62:
        if (r2.has("current_page") == true) goto L67;
        if (r10 == null) goto L65;
        String r18 = r10.e;
    L66:
        r2.put("current_page", r18);
        goto L67
    L65:
        r18 = null;
    L67:
        if (r10 == null) goto L76;
        String r19 = r10.u0;
        if (r19 == null) goto L76;
        if ((!StringsKt.isBlank(r19)) == true) goto L74;
        r19 = null;
    L74:
        if (r19 == null) goto L76;
        r2.put("file_type", r19);
    L76:
        if (r10 != null) goto L78;
    L80:
        boolean r20 = false;
    L81:
        String r21 = "1";
        if (r20 == false) goto L84;
        Object r22 = "1";
    L85:
        r2.put("is_replica_gen", r22);
        if (r10 == null) goto L93;
        Integer r23 = r10.m;
        if (r23 == null) goto L93;
        if (r23.intValue() != 4) goto L93;
        r7 = 1;
    L93:
        r2.put("is_image_edit", r7);
        if (r10 == null) goto L102;
        Boolean r24 = r10.u;
        if (r24 == null) goto L102;
        if (r24.booleanValue() == true) goto L101;
        r21 = "0";
    L101:
        r2.put("is_search_card", r21);
    L102:
        if (r10 == null) goto L106;
        String r25 = r10.n;
        if (r25 == null) goto L106;
        r2.put("template_id", r25);
    L106:
        if (r10 == null) goto L110;
        String r26 = r10.o;
        if (r26 == null) goto L110;
        r2.put("template_type", r26);
    L110:
        if (r10 == null) goto L114;
        String r27 = r10.p;
        if (r27 == null) goto L114;
        r2.put("template_source", r27);
    L114:
        if (r10 == null) goto L118;
        String r28 = r10.q;
        if (r28 == null) goto L118;
        r2.put("template_rec_req_id", r28);
    L118:
        if (r10 == null) goto L122;
        String r29 = r10.t;
        if (r29 == null) goto L122;
        r2.put("recommend_from", r29);
    L122:
        if (r10 == null) goto L126;
        String r30 = r10.v;
        if (r30 == null) goto L126;
        r2.put("ai_generate_tab_id", r30);
    L126:
        if (r10 == null) goto L130;
        String r31 = r10.w;
        if (r31 == null) goto L130;
        r2.put("ai_generate_tab_name", r31);
    L130:
        if (r10 == null) goto L134;
        String r32 = r10.x;
        if (r32 == null) goto L134;
        r2.put("ai_generate_tab_type", r32);
    L134:
        if (r10 == null) goto L138;
        Integer r33 = r10.z;
        if (r33 == null) goto L138;
        r2.put("use_template_uv", r33.intValue());
    L138:
        if (r10 == null) goto L142;
        Integer r34 = r10.y;
        if (r34 == null) goto L142;
        r2.put("page_index", r34.intValue());
    L142:
        if (r10 == null) goto L146;
        String r35 = r10.A;
        if (r35 == null) goto L146;
        r2.put("creator_id", r35);
    L146:
        if (r10 == null) goto L150;
        String r36 = r10.B;
        if (r36 == null) goto L150;
        r2.put("conversation_id", r36);
    L150:
        if (r10 == null) goto L154;
        String r37 = r10.D;
        if (r37 == null) goto L154;
        r2.put("user_case_reco_request_id", r37);
    L154:
        if (r10 == null) goto L158;
        String r38 = r10.C;
        if (r38 == null) goto L158;
        r2.put("user_case_item_id", r38);
    L158:
        if (r10 == null) goto L162;
        String r39 = r10.J;
        if (r39 == null) goto L162;
        r2.put("show_method", r39);
    L162:
        if (r10 == null) goto L166;
        Boolean r40 = r10.H;
        if (r40 == null) goto L166;
        String r41 = l3.f(r40);
    L167:
        r2.putOpt("is_deep_thinking", r41);
        if (r10 == null) goto L170;
        String r42 = r10.E;
    L171:
        r2.putOpt("creation_task_id", r42);
        if (r10 == null) goto L174;
        r5 = r10.G;
    L174:
        r2.putOpt("ai_create_show_mode", r5);
        if (r10 == null) goto L179;
        String r43 = r10.K;
        if (r43 == null) goto L179;
        r2.put("page_token", r43);
    L179:
        if (r10 == null) goto L183;
        String r44 = r10.L;
        if (r44 == null) goto L183;
        r2.put("artifact_meta_id", r44);
    L183:
        if (r10 == null) goto L187;
        Integer r45 = r10.M;
        if (r45 == null) goto L187;
        r2.put("resource_type", String.valueOf(r45.intValue()));
    L187:
        if (r10 == null) goto L191;
        String r46 = r10.Z;
        if (r46 == null) goto L191;
        r2.put("aippt_task_id", r46);
    L191:
        if (r10 == null) goto L195;
        String r47 = r10.a0;
        if (r47 == null) goto L195;
        r2.put("presentation_id", r47);
    L195:
        if (r10 == null) goto L199;
        String r48 = r10.b0;
        if (r48 == null) goto L199;
        r2.put("spreadsheet_id", r48);
    L199:
        if (r10 == null) goto L203;
        String r49 = r10.c0;
        if (r49 == null) goto L203;
        r2.put("resource_id", r49);
    L203:
        if (r10 == null) goto L207;
        Integer r50 = r10.M;
        if (r50 == null) goto L207;
        r2.put("artifact_type", String.valueOf(r50.intValue()));
    L207:
        if (r10 == null) goto L211;
        String r51 = r10.e0;
        if (r51 == null) goto L211;
        r2.put("canvas_type", r51);
    L211:
        if (r10 == null) goto L215;
        String r52 = r10.T;
        if (r52 == null) goto L215;
        r2.put("click_method", r52);
    L215:
        if (r10 == null) goto L219;
        String r53 = r10.U;
        if (r53 == null) goto L219;
        r2.put("enter_picture_method", r53);
    L219:
        if (r10 == null) goto L223;
        Integer r54 = r10.W;
        if (r54 == null) goto L223;
        r2.put("is_image_edit", r54.intValue());
    L223:
        if (r10 == null) goto L227;
        String r55 = r10.X;
        if (r55 == null) goto L227;
        r2.put("user_type", r55);
    L227:
        if (r10 == null) goto L231;
        String r56 = r10.Y;
        if (r56 == null) goto L231;
        r2.put("image_edit_function_id", r56);
    L231:
        if (r10 == null) goto L235;
        String r57 = r10.f0;
        if (r57 == null) goto L235;
        r2.put("collection_id", r57);
    L235:
        if (r10 == null) goto L239;
        String r58 = r10.g0;
        if (r58 == null) goto L239;
        r2.put("collection_name", r58);
    L239:
        if (r10 == null) goto L243;
        String r59 = r10.h0;
        if (r59 == null) goto L243;
        r2.put("content_type", r59);
    L243:
        if (r10 == null) goto L247;
        String r60 = r10.i0;
        if (r60 == null) goto L247;
        r2.put("content_sec_type", r60);
    L247:
        h(r2, r10);
        TrackParams r61 = r1.merge(r2);
        if (r10 == null) goto L252;
        JSONObject r62 = r10.i;
        if (r62 == null) goto L252;
        r61.merge(r62);
    L252:
        if (r10 == null) goto L258;
        Function0 r63 = r10.j;
        if (r63 == null) goto L258;
        JSONObject r64 = (JSONObject) r63.invoke();
        if (r64 == null) goto L258;
        r61.merge(r64);
    L258:
        g(r61, r10);
        f(r61, r10);
        if (r11 == null) goto L261;
        r0.b = r11;
    L261:
        r0.a.merge(r61);
        r0.b();
        return;
    L170:
        r42 = null;
    L166:
        r41 = null;
        goto L167
    L84:
        r22 = "0";
        goto L85
    L78:
        if (r10.l != true) goto L80;
        r20 = true;
    L42:
        r16 = null;
        goto L43
    L19:
        if (r9 != ShareScene.OFFICE_SHARE_CHAT) goto L21;
        r12 = "chat_history";
        goto L22
    L14:
        if (r10.r0 != true) goto L16;
        r8 = true;
    L7:
        if (r10 == null) goto L9;
        String r65 = r10.c;
    L10:
        r2.put("chat_type", r65);
        goto L11
    L9:
        r65 = null;
        goto L10
    }

    public static void j(ShareScene r5, String r6, b r7, by7.e r8) {
        Intrinsics.checkNotNullParameter(r5, "shareScene");
        Intrinsics.checkNotNullParameter("custom", "panelStyle");
        by7.a r0 = new by7.a("rd_share_panel_click");
        JSONObject r3 = new JSONObject();
        r3.put("share_scene", r5.getScene());
        r3.put("share_panel_style", "custom");
        r3.put("share_url", d(r7));
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r3.put("click_from", r6);
        TrackParams r9 = new TrackParams().merge(r3);
        if (r8 == null) goto L8;
        r0.b = r8;
    L8:
        r0.a.merge(r9);
        r0.b();
        g.a.monitorEventForSlardar("rd_share_panel_click", r3, null, null);
    }

    public static /* synthetic */ void l(ShareScene r1, b r2, String r3, by7.e r4) {
        k(r1, r2, r3, r4, "custom");
    }

    public static void m(ShareScene r4, b r5, by7.e r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "shareScene");
        Intrinsics.checkNotNullParameter(r7, "panelStyle");
        by7.a r0 = new by7.a("rd_share_panel_will_show");
        JSONObject r2 = new JSONObject();
        r2.put("share_scene", r4.getScene());
        r2.put("share_panel_style", r7);
        r2.put("share_url", d(r5));
        TrackParams r8 = new TrackParams().merge(r2);
        if (r6 == null) goto L5;
        r0.b = r6;
    L5:
        r0.a.merge(r8);
        r0.b();
        g.a.monitorEventForSlardar("rd_share_panel_will_show", r2, null, null);
    }

    public static void n(ShareScene r4, b r5, by7.e r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "shareScene");
        Intrinsics.checkNotNullParameter(r7, "panelStyle");
        by7.a r0 = new by7.a("rd_share_panel_did_show");
        JSONObject r2 = new JSONObject();
        r2.put("share_scene", r4.getScene());
        r2.put("share_panel_style", r7);
        r2.put("share_url", d(r5));
        TrackParams r8 = new TrackParams().merge(r2);
        if (r6 == null) goto L5;
        r0.b = r6;
    L5:
        r0.a.merge(r8);
        r0.b();
        g.a.monitorEventForSlardar("rd_share_panel_did_show", r2, null, null);
    }

    public static void o(ShareScene r12, String r13, h r14, by7.e r15) {
        Intrinsics.checkNotNullParameter(r12, "shareScene");
        Object r1 = null;
        if (r15 == null) goto L5;
        WeakReference r2 = new WeakReference(r15);
    L6:
        a = new e(r12, r13, r14, r2);
        by7.a r0 = new by7.a("share_panel_click");
        int r3 = 0;
        if (r14 != null) goto L9;
    L11:
        boolean r4 = false;
    L13:
        if (r4 == true) goto L15;
    L17:
        boolean r5 = false;
    L18:
        TrackParams r6 = new TrackParams();
        JSONObject r7 = new JSONObject();
        if (r14 == null) goto L23;
        BotModel r10 = r14.b;
        if (r10 == null) goto L23;
        r7.put("bot_id", r10.getBotId());
        r7.put("is_immersive_background", e(r10));
        r7.put("chat_type", c(r14.a, r14.b));
    L27:
        r7.put("share_panel_style", "sdk");
        if (r14 != null) goto L30;
    L32:
        boolean r11 = false;
    L33:
        if (r11 == true) goto L35;
    L37:
        boolean r8 = false;
    L38:
        Object r16 = "message_forward";
        if (r8 == false) goto L41;
        Object r17 = "message_forward";
    L42:
        r7.put("share_scene", r17);
        if (r14 == null) goto L50;
        Map r18 = r14.q0;
        if (r18 == null) goto L50;
        Object r19 = (String) r18.get(r13);
        if (r19 == null) goto L50;
        r16 = r19;
    L53:
        r7.put("click_from", r16);
        r7.put("show_from", r16);
        if (Intrinsics.areEqual(r13, "save_image") == false) goto L73;
        e6 r9 = e6.a;
        r9.getClass();
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L66
        if (Build.VERSION.SDK_INT > 29) goto L59;
        String r21 = "android.permission.WRITE_EXTERNAL_STORAGE";
    L60:
        if (r21 == null) goto L63;
        String r22 = e6.d(r9, r21, null, null, 14);     // Catch: Throwable -> L66
        if (r22 == null) goto L63;
    L64:
        Object r23 = Result.constructor-impl(r22);     // Catch: Throwable -> L66
    L68:
        Throwable r24 = Result.exceptionOrNull-impl(r23);
        if (r24 == null) goto L72;
        FLogger.a.e("PermissionStatusHelper", "getAlbumWriteStatus error", r24);
        r23 = "disable";
    L72:
        r7.put("album_status", (String) r23);
    L63:
        r22 = "open";
        goto L64
    L59:
        r21 = null;
    L66:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
    L73:
        if (r14 == null) goto L75;
        Object r26 = r14.F;
    L76:
        r7.putOpt("position", r26);
        if (r14 == null) goto L79;
        Object r27 = r14.E;
    L80:
        r7.putOpt("creation_task_id", r27);
        if (r14 == null) goto L85;
        Message r28 = r14.O;
        if (r28 == null) goto L85;
        Object r29 = r28.getReplyId();
    L86:
        r7.putOpt("reply_id", r29);
        if (r14 == null) goto L93;
        Message r30 = r14.O;
        if (r30 == null) goto L93;
        Map r31 = r30.getExt();
        if (r31 == null) goto L93;
        Object r32 = (String) r31.get("gen_music_create_way");
    L94:
        r7.putOpt("create_source", r32);
        if (r7.has("bot_id") == true) goto L101;
        if (r14 == null) goto L98;
        Object r33 = r14.g;
    L99:
        r7.put("bot_id", r33);
        goto L101
    L98:
        r33 = null;
    L101:
        if (r7.has("user_type") == true) goto L111;
        if (r14 == null) goto L106;
        Message r34 = r14.O;
        if (r34 == null) goto L106;
        String r35 = r34.getReplyId();
    L108:
        if (o0.d(r35) == false) goto L111;
        r7.putOpt("user_type", "bot");
    L106:
        r35 = null;
    L111:
        if (r7.has("chat_type") == true) goto L117;
        if (r14 == null) goto L114;
        Object r36 = r14.f;
    L115:
        r7.put("chat_type", r36);
        goto L117
    L114:
        r36 = null;
    L117:
        if (r7.has("previous_page") == true) goto L123;
        if (r14 == null) goto L120;
        Object r37 = r14.d;
    L121:
        r7.put("previous_page", r37);
        goto L123
    L120:
        r37 = null;
    L123:
        if (r7.has("current_page") == true) goto L128;
        if (r14 == null) goto L126;
        Object r38 = r14.e;
    L127:
        r7.put("current_page", r38);
        goto L128
    L126:
        r38 = null;
    L128:
        if (r14 == null) goto L138;
        String r39 = r14.u0;
        if (r39 == null) goto L138;
        if ((!StringsKt.isBlank(r39)) == true) goto L135;
        r39 = null;
    L135:
        if (r39 == null) goto L138;
        r7.put("file_type", r39);
    L138:
        if (r7.has("message_id") == true) goto L143;
        if (r14 == null) goto L141;
        Object r40 = r14.h;
    L142:
        r7.put("message_id", r40);
        goto L143
    L141:
        r40 = null;
    L143:
        if (r14 != null) goto L145;
    L147:
        boolean r41 = false;
    L148:
        Object r42 = "1";
        if (r41 == false) goto L151;
        Object r43 = "1";
    L152:
        r7.put("is_replica_gen", r43);
        if (r14 == null) goto L160;
        Integer r44 = r14.m;
        if (r44 == null) goto L160;
        if (r44.intValue() != 4) goto L160;
        r3 = 1;
    L160:
        r7.put("is_image_edit", r3);
        if (r14 == null) goto L169;
        Boolean r45 = r14.u;
        if (r45 == null) goto L169;
        if (r45.booleanValue() == true) goto L168;
        r42 = "0";
    L168:
        r7.put("is_search_card", r42);
    L169:
        if (r14 == null) goto L173;
        Object r46 = r14.n;
        if (r46 == null) goto L173;
        r7.put("template_id", r46);
    L173:
        if (r14 == null) goto L177;
        Object r47 = r14.o;
        if (r47 == null) goto L177;
        r7.put("template_type", r47);
    L177:
        if (r14 == null) goto L181;
        Object r48 = r14.p;
        if (r48 == null) goto L181;
        r7.put("template_source", r48);
    L181:
        if (r14 == null) goto L185;
        Object r49 = r14.q;
        if (r49 == null) goto L185;
        r7.put("template_rec_req_id", r49);
    L185:
        if (r14 == null) goto L189;
        Object r50 = r14.t;
        if (r50 == null) goto L189;
        r7.put("recommend_from", r50);
    L189:
        if (r14 == null) goto L193;
        Object r51 = r14.v;
        if (r51 == null) goto L193;
        r7.put("ai_generate_tab_id", r51);
    L193:
        if (r14 == null) goto L197;
        Object r52 = r14.w;
        if (r52 == null) goto L197;
        r7.put("ai_generate_tab_name", r52);
    L197:
        if (r14 == null) goto L201;
        Object r53 = r14.x;
        if (r53 == null) goto L201;
        r7.put("ai_generate_tab_type", r53);
    L201:
        if (r14 == null) goto L205;
        Integer r54 = r14.z;
        if (r54 == null) goto L205;
        r7.put("use_template_uv", r54.intValue());
    L205:
        if (r14 == null) goto L209;
        Integer r55 = r14.y;
        if (r55 == null) goto L209;
        r7.put("page_index", r55.intValue());
    L209:
        if (r14 == null) goto L213;
        Object r56 = r14.A;
        if (r56 == null) goto L213;
        r7.put("creator_id", r56);
    L213:
        if (r14 == null) goto L217;
        Object r57 = r14.B;
        if (r57 == null) goto L217;
        r7.put("conversation_id", r57);
    L217:
        if (r14 == null) goto L221;
        Object r58 = r14.D;
        if (r58 == null) goto L221;
        r7.put("user_case_reco_request_id", r58);
    L221:
        if (r14 == null) goto L225;
        Object r59 = r14.C;
        if (r59 == null) goto L225;
        r7.put("user_case_item_id", r59);
    L225:
        if (r14 == null) goto L229;
        Object r60 = r14.Q;
        if (r60 == null) goto L229;
        r7.put("template_show_enter_method", r60);
    L229:
        if (r14 == null) goto L233;
        Boolean r61 = r14.H;
        if (r61 == null) goto L233;
        Object r62 = l3.f(r61);
    L234:
        r7.putOpt("is_deep_thinking", r62);
        if (r14 == null) goto L237;
        Object r63 = r14.E;
    L238:
        r7.putOpt("creation_task_id", r63);
        if (r14 == null) goto L241;
        r1 = r14.G;
    L241:
        r7.putOpt("ai_create_show_mode", r1);
        if (r14 == null) goto L246;
        Boolean r64 = r14.I;
        if (r64 == null) goto L246;
        r7.put("is_ai_creation_puzzle", r64.booleanValue() ? 1 : 0);
    L246:
        if (r14 == null) goto L250;
        Object r65 = r14.J;
        if (r65 == null) goto L250;
        r7.put("show_method", r65);
    L250:
        if (r14 == null) goto L254;
        Object r66 = r14.K;
        if (r66 == null) goto L254;
        r7.put("page_token", r66);
    L254:
        if (r14 == null) goto L258;
        Object r67 = r14.L;
        if (r67 == null) goto L258;
        r7.put("artifact_meta_id", r67);
    L258:
        if (r14 == null) goto L262;
        Integer r68 = r14.M;
        if (r68 == null) goto L262;
        r7.put("resource_type", String.valueOf(r68.intValue()));
    L262:
        if (r14 == null) goto L266;
        Object r69 = r14.Z;
        if (r69 == null) goto L266;
        r7.put("aippt_task_id", r69);
    L266:
        if (r14 == null) goto L270;
        Object r70 = r14.a0;
        if (r70 == null) goto L270;
        r7.put("presentation_id", r70);
    L270:
        if (r14 == null) goto L274;
        Object r71 = r14.b0;
        if (r71 == null) goto L274;
        r7.put("spreadsheet_id", r71);
    L274:
        if (r14 == null) goto L278;
        Object r72 = r14.s0;
        if (r72 == null) goto L278;
        r7.put("base_id", r72);
    L278:
        if (r14 == null) goto L282;
        Object r73 = r14.c0;
        if (r73 == null) goto L282;
        r7.put("resource_id", r73);
    L282:
        if (r14 == null) goto L286;
        Integer r74 = r14.M;
        if (r74 == null) goto L286;
        r7.put("artifact_type", String.valueOf(r74.intValue()));
    L286:
        if (r14 == null) goto L290;
        Object r75 = r14.e0;
        if (r75 == null) goto L290;
        r7.put("canvas_type", r75);
    L290:
        if (r14 == null) goto L294;
        Object r76 = r14.T;
        if (r76 == null) goto L294;
        r7.put("click_method", r76);
    L294:
        if (r14 == null) goto L298;
        Object r77 = r14.U;
        if (r77 == null) goto L298;
        r7.put("enter_picture_method", r77);
    L298:
        if (r14 == null) goto L302;
        Integer r78 = r14.W;
        if (r78 == null) goto L302;
        r7.put("is_image_edit", r78.intValue());
    L302:
        if (r14 == null) goto L306;
        Object r79 = r14.X;
        if (r79 == null) goto L306;
        r7.put("user_type", r79);
    L306:
        if (r14 == null) goto L310;
        Object r80 = r14.Y;
        if (r80 == null) goto L310;
        r7.put("image_edit_function_id", r80);
    L310:
        if (r14 == null) goto L314;
        Object r81 = r14.V;
        if (r81 == null) goto L314;
        r7.put("enter_method", r81);
    L314:
        if (r14 == null) goto L318;
        Object r82 = r14.f0;
        if (r82 == null) goto L318;
        r7.put("collection_id", r82);
    L318:
        if (r14 == null) goto L322;
        Object r83 = r14.g0;
        if (r83 == null) goto L322;
        r7.put("collection_name", r83);
    L322:
        if (r14 == null) goto L326;
        Object r84 = r14.h0;
        if (r84 == null) goto L326;
        r7.put("content_type", r84);
    L326:
        if (r14 == null) goto L330;
        Object r85 = r14.i0;
        if (r85 == null) goto L330;
        r7.put("content_sec_type", r85);
    L330:
        if (r14 == null) goto L334;
        Object r86 = r14.j0;
        if (r86 == null) goto L334;
        r7.put("artifact_create_method", r86);
    L334:
        if (r14 == null) goto L338;
        Object r87 = r14.S;
        if (r87 == null) goto L338;
        r7.put("creation_id", r87);
    L338:
        h(r7, r14);
        TrackParams r88 = r6.merge(r7);
        if (r14 == null) goto L343;
        JSONObject r89 = r14.i;
        if (r89 == null) goto L343;
        r88.merge(r89);
    L343:
        if (r14 == null) goto L349;
        Function0 r90 = r14.j;
        if (r90 == null) goto L349;
        JSONObject r91 = (JSONObject) r90.invoke();
        if (r91 == null) goto L349;
        r88.merge(r91);
    L349:
        g(r88, r14);
        f(r88, r14);
        if (r15 == null) goto L352;
        r0.b = r15;
    L352:
        r0.a.merge(r88);
        r0.b();
        if (Intrinsics.areEqual(r13, "save_image") == false) goto L361;
        if (r14 == null) goto L362;
        by7.a r110 = r14.k;
        if (r110 == null) goto L363;
        r110.b();
        Unit r111 = Unit.INSTANCE;
        return;
    L363:
        return;
    L362:
        return;
    L361:
        return;
    L237:
        r63 = null;
    L233:
        r62 = null;
        goto L234
    L151:
        r43 = "0";
        goto L152
    L145:
        if (r14.l != true) goto L147;
        r41 = true;
    L93:
        r32 = null;
    L85:
        r29 = null;
        goto L86
    L79:
        r27 = null;
        goto L80
    L75:
        r26 = null;
    L50:
        if (r5 == true) goto L53;
        r16 = r13;
        goto L53
    L41:
        r17 = s(r12, r14);
        goto L42
    L35:
        if (Intrinsics.areEqual(r13, "forward") == false) goto L37;
        r8 = true;
        goto L38
    L30:
        if (r14.r0 != true) goto L32;
        r11 = true;
    L23:
        if (r14 == null) goto L25;
        Object r112 = r14.c;
    L26:
        r7.put("chat_type", r112);
        goto L27
    L25:
        r112 = null;
        goto L26
    L15:
        if (Intrinsics.areEqual(r13, "forward") == false) goto L17;
        r5 = true;
        goto L18
    L9:
        if (r14.r0 != true) goto L11;
        r4 = true;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    public static void q(ShareScene r8, String r9, h r10, by7.e r11) {
        Intrinsics.checkNotNullParameter(r8, "shareScene");
        by7.a r0 = new by7.a("share_panel_element_show");
        TrackParams r1 = new TrackParams();
        JSONObject r2 = new JSONObject();
        String r5 = null;
        if (r10 == null) goto L7;
        BotModel r6 = r10.b;
        if (r6 == null) goto L7;
        r2.put("bot_id", r6.getBotId());
        r2.put("is_immersive_background", e(r6));
        r2.put("chat_type", c(r10.a, r10.b));
    L11:
        r2.put("share_panel_style", "sdk");
        r2.put("share_scene", s(r8, r10));
        int r12 = 1;
        if (r10 == null) goto L21;
        String r7 = r10.v0;
        if (r7 == null) goto L21;
        if ((!StringsKt.isBlank(r7)) == true) goto L19;
        r7 = null;
    L19:
        if (r7 == null) goto L21;
        r2.put("share_content", r7);
    L21:
        if (r10 == null) goto L28;
        Map r13 = r10.q0;
        if (r13 == null) goto L28;
        String r14 = (String) r13.get(r9);
        if (r14 == null) goto L28;
        r9 = r14;
    L28:
        r2.put("show_from", r9);
        if (r2.has("bot_id") == true) goto L35;
        if (r10 == null) goto L32;
        String r15 = r10.g;
    L33:
        r2.put("bot_id", r15);
        goto L35
    L32:
        r15 = null;
    L35:
        if (r2.has("chat_type") == true) goto L41;
        if (r10 == null) goto L38;
        String r16 = r10.f;
    L39:
        r2.put("chat_type", r16);
        goto L41
    L38:
        r16 = null;
    L41:
        if (r2.has("previous_page") == true) goto L47;
        if (r10 == null) goto L44;
        String r3 = r10.d;
    L45:
        r2.put("previous_page", r3);
        goto L47
    L44:
        r3 = null;
    L47:
        if (r2.has("current_page") == true) goto L52;
        if (r10 == null) goto L50;
        String r4 = r10.e;
    L51:
        r2.put("current_page", r4);
        goto L52
    L50:
        r4 = null;
    L52:
        if (r10 == null) goto L62;
        String r17 = r10.u0;
        if (r17 == null) goto L62;
        if ((!StringsKt.isBlank(r17)) == true) goto L59;
        r17 = null;
    L59:
        if (r17 == null) goto L62;
        r2.put("file_type", r17);
    L62:
        if (r10 != null) goto L64;
    L66:
        boolean r18 = false;
    L67:
        String r19 = "1";
        if (r18 == false) goto L70;
        Object r20 = "1";
    L71:
        r2.put("is_replica_gen", r20);
        if (r10 == null) goto L79;
        Integer r21 = r10.m;
        if (r21 == null) goto L79;
        if (r21.intValue() != 4) goto L79;
    L80:
        r2.put("is_image_edit", r12);
        if (r10 == null) goto L89;
        Boolean r22 = r10.u;
        if (r22 == null) goto L89;
        if (r22.booleanValue() == true) goto L88;
        r19 = "0";
    L88:
        r2.put("is_search_card", r19);
    L89:
        if (r10 == null) goto L93;
        String r23 = r10.n;
        if (r23 == null) goto L93;
        r2.put("template_id", r23);
    L93:
        if (r10 == null) goto L97;
        String r24 = r10.o;
        if (r24 == null) goto L97;
        r2.put("template_type", r24);
    L97:
        if (r10 == null) goto L101;
        String r25 = r10.p;
        if (r25 == null) goto L101;
        r2.put("template_source", r25);
    L101:
        if (r10 == null) goto L105;
        String r26 = r10.q;
        if (r26 == null) goto L105;
        r2.put("template_rec_req_id", r26);
    L105:
        if (r10 == null) goto L109;
        String r27 = r10.t;
        if (r27 == null) goto L109;
        r2.put("recommend_from", r27);
    L109:
        if (r10 == null) goto L113;
        String r28 = r10.v;
        if (r28 == null) goto L113;
        r2.put("ai_generate_tab_id", r28);
    L113:
        if (r10 == null) goto L117;
        String r29 = r10.w;
        if (r29 == null) goto L117;
        r2.put("ai_generate_tab_name", r29);
    L117:
        if (r10 == null) goto L121;
        String r30 = r10.x;
        if (r30 == null) goto L121;
        r2.put("ai_generate_tab_type", r30);
    L121:
        if (r10 == null) goto L125;
        Integer r31 = r10.z;
        if (r31 == null) goto L125;
        r2.put("use_template_uv", r31.intValue());
    L125:
        if (r10 == null) goto L129;
        Integer r32 = r10.y;
        if (r32 == null) goto L129;
        r2.put("page_index", r32.intValue());
    L129:
        if (r10 == null) goto L133;
        String r33 = r10.A;
        if (r33 == null) goto L133;
        r2.put("creator_id", r33);
    L133:
        if (r10 == null) goto L137;
        String r34 = r10.B;
        if (r34 == null) goto L137;
        r2.put("conversation_id", r34);
    L137:
        if (r10 == null) goto L141;
        String r35 = r10.D;
        if (r35 == null) goto L141;
        r2.put("user_case_reco_request_id", r35);
    L141:
        if (r10 == null) goto L145;
        String r36 = r10.C;
        if (r36 == null) goto L145;
        r2.put("user_case_item_id", r36);
    L145:
        if (r10 == null) goto L149;
        String r37 = r10.J;
        if (r37 == null) goto L149;
        r2.put("show_method", r37);
    L149:
        if (r10 == null) goto L153;
        Boolean r38 = r10.H;
        if (r38 == null) goto L153;
        String r39 = l3.f(r38);
    L154:
        r2.putOpt("is_deep_thinking", r39);
        if (r10 == null) goto L157;
        String r40 = r10.E;
    L158:
        r2.putOpt("creation_task_id", r40);
        if (r10 == null) goto L161;
        String r41 = r10.G;
    L162:
        r2.putOpt("ai_create_show_mode", r41);
        if (r10 == null) goto L167;
        Message r42 = r10.O;
        if (r42 == null) goto L167;
        String r43 = r42.getReplyId();
    L168:
        r2.putOpt("reply_id", r43);
        if (r10 == null) goto L173;
        String r44 = r10.K;
        if (r44 == null) goto L173;
        r2.put("page_token", r44);
    L173:
        if (r10 == null) goto L177;
        String r45 = r10.L;
        if (r45 == null) goto L177;
        r2.put("artifact_meta_id", r45);
    L177:
        if (r10 == null) goto L181;
        Integer r46 = r10.M;
        if (r46 == null) goto L181;
        r2.put("resource_type", String.valueOf(r46.intValue()));
    L181:
        if (r10 == null) goto L185;
        String r47 = r10.Z;
        if (r47 == null) goto L185;
        r2.put("aippt_task_id", r47);
    L185:
        if (r10 == null) goto L189;
        String r48 = r10.a0;
        if (r48 == null) goto L189;
        r2.put("presentation_id", r48);
    L189:
        if (r10 == null) goto L193;
        String r49 = r10.b0;
        if (r49 == null) goto L193;
        r2.put("spreadsheet_id", r49);
    L193:
        if (r10 == null) goto L197;
        String r50 = r10.s0;
        if (r50 == null) goto L197;
        r2.put("base_id", r50);
    L197:
        if (r10 == null) goto L201;
        String r51 = r10.c0;
        if (r51 == null) goto L201;
        r2.put("resource_id", r51);
    L201:
        if (r10 == null) goto L205;
        Integer r52 = r10.M;
        if (r52 == null) goto L205;
        r2.put("artifact_type", String.valueOf(r52.intValue()));
    L205:
        if (r10 == null) goto L210;
        String r53 = r10.e0;
        if (r53 == null) goto L210;
        r2.put("canvas_type", r53);
    L210:
        if (r2.has("message_id") == true) goto L214;
        if (r10 == null) goto L213;
        r5 = r10.h;
    L213:
        r2.put("message_id", r5);
    L214:
        if (r10 == null) goto L218;
        String r54 = r10.T;
        if (r54 == null) goto L218;
        r2.put("click_method", r54);
    L218:
        if (r10 == null) goto L222;
        String r55 = r10.U;
        if (r55 == null) goto L222;
        r2.put("enter_picture_method", r55);
    L222:
        if (r10 == null) goto L226;
        Integer r56 = r10.W;
        if (r56 == null) goto L226;
        r2.put("is_image_edit", r56.intValue());
    L226:
        if (r10 == null) goto L230;
        String r57 = r10.X;
        if (r57 == null) goto L230;
        r2.put("user_type", r57);
    L230:
        if (r10 == null) goto L234;
        String r58 = r10.Y;
        if (r58 == null) goto L234;
        r2.put("image_edit_function_id", r58);
    L234:
        if (r10 == null) goto L238;
        String r59 = r10.h;
        if (r59 == null) goto L238;
        r2.put("message_id", r59);
    L238:
        if (r10 == null) goto L242;
        String r60 = r10.V;
        if (r60 == null) goto L242;
        r2.put("enter_method", r60);
    L242:
        if (r10 == null) goto L246;
        String r61 = r10.f0;
        if (r61 == null) goto L246;
        r2.put("collection_id", r61);
    L246:
        if (r10 == null) goto L250;
        String r62 = r10.g0;
        if (r62 == null) goto L250;
        r2.put("collection_name", r62);
    L250:
        if (r10 == null) goto L254;
        String r63 = r10.h0;
        if (r63 == null) goto L254;
        r2.put("content_type", r63);
    L254:
        if (r10 == null) goto L258;
        String r64 = r10.i0;
        if (r64 == null) goto L258;
        r2.put("content_sec_type", r64);
    L258:
        h(r2, r10);
        TrackParams r65 = r1.merge(r2);
        if (r10 == null) goto L263;
        JSONObject r66 = r10.i;
        if (r66 == null) goto L263;
        r65.merge(r66);
    L263:
        if (r10 == null) goto L269;
        Function0 r67 = r10.j;
        if (r67 == null) goto L269;
        JSONObject r68 = (JSONObject) r67.invoke();
        if (r68 == null) goto L269;
        r65.merge(r68);
    L269:
        g(r65, r10);
        f(r65, r10);
        if (r11 == null) goto L272;
        r0.b = r11;
    L272:
        r0.a.merge(r65);
        r0.b();
        return;
    L167:
        r43 = null;
        goto L168
    L161:
        r41 = null;
        goto L162
    L157:
        r40 = null;
    L153:
        r39 = null;
    L79:
        r12 = 0;
        goto L80
    L70:
        r20 = "0";
        goto L71
    L64:
        if (r10.l != true) goto L66;
        r18 = true;
    L7:
        if (r10 == null) goto L9;
        String r69 = r10.c;
    L10:
        r2.put("chat_type", r69);
        goto L11
    L9:
        r69 = null;
        goto L10
    }

    public static void k(ShareScene r4, b r5, String r6, by7.e r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, "shareScene");
        Intrinsics.checkNotNullParameter(r8, "panelStyle");
        by7.a r0 = new by7.a("rd_share_panel_show_fail");
        JSONObject r2 = new JSONObject();
        r2.put("share_scene", r4.getScene());
        r2.put("share_panel_style", r8);
        r2.put("share_url", d(r5));
        r2.put("fail_reason", r6);
        TrackParams r9 = new TrackParams().merge(r2);
        if (r7 == null) goto L5;
        r0.b = r7;
    L5:
        r0.a.merge(r9);
        r0.b();
        g.a.monitorEventForSlardar("rd_share_panel_show_fail", r2, null, null);
    }
}
