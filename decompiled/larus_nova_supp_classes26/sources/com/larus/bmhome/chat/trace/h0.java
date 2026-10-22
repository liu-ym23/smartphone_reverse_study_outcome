package com.larus.bmhome.chat.trace;

import com.ixigua.lib.track.TrackParams;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.showcase.Case;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;
import tx9.o3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(wh8.a r38, int r39, String r40, String r41, String r42) {
        if (r38 != null) goto L6;
        FLogger.a.d("ConversationItemShowTrace", "report: data is null, index=" + r39);
        return;
    L6:
        wc9.e r4 = r38.a;
        int r5 = 0;
        if (r4 == null) goto L14;
        Integer r6 = r4.j;
        if (r6 == null) goto L14;
        if (r6.intValue() != 3) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L21;
        if (r38.b != null) goto L21;
        FLogger.a.d("ConversationItemShowTrace", "report: skip empty single_chat_bot, index=" + r39);
        return;
    L21:
        if (r38.k == null) goto L40;
        FLogger r8 = FLogger.a;
        StringBuilder r9 = new StringBuilder("report: case cell, index=");
        r9.append(r39);
        r9.append(" caseId=");
        Case r10 = r38.k;
        if (r10 == null) goto L25;
        String r11 = r10.getCaseId();
    L26:
        r9.append(r11);
        r8.i("ConversationItemShowTrace", r9.toString());
        if (r42 != null) goto L29;
        String r12 = r40;
    L30:
        int r13 = r39 + 1;
        Case r1 = r38.k;
        if (r1 == null) goto L33;
        String r14 = r1.getRequestId();
    L34:
        Case r0 = r38.k;
        if (r0 == null) goto L37;
        String r15 = r0.getCaseId();
    L38:
        tx9.w.d(r40, r12, false, r13, r14, r15);
        return;
    L37:
        r15 = null;
        goto L38
    L33:
        r14 = null;
        goto L34
    L29:
        r12 = r42;
        goto L30
    L25:
        r11 = null;
        goto L26
    L40:
        wc9.e r16 = r38.a;
        if (r16 == null) goto L45;
        Integer r17 = r16.l;
        if (r17 == null) goto L45;
        int r18 = r17.intValue();
    L46:
        wc9.e r19 = r38.a;
        if (r19 == null) goto L51;
        Integer r20 = r19.m;
        if (r20 == null) goto L51;
        int r21 = r20.intValue();
    L52:
        int r22 = RangesKt.coerceAtLeast(r18 - r21, 0);
        if (ic8.n.q(r38.a) == false) goto L70;
        FLogger r2 = FLogger.a;
        StringBuilder r23 = new StringBuilder("report: not_bot cell, index=");
        r23.append(r39);
        r23.append(" conversationId=");
        wc9.e r110 = r38.a;
        if (r110 == null) goto L57;
        String r24 = r110.a;
    L58:
        r23.append(r24);
        r2.i("ConversationItemShowTrace", r23.toString());
        JSONObject r3 = new JSONObject();
        r3.put("index", r39);
        if (ic8.n.w(r38.a) == false) goto L61;
        String r25 = "doubao_pc_history";
    L62:
        r3.put("cell_type", r25);
        r3.put("red_dot_cnt", r22);
        String r26 = r38.h;
        if (r26 != null) goto L65;
    L66:
        r5 = 1;
    L67:
        r3.put("if_list_empty", r5);
        boolean r27 = o3.a;
        Intrinsics.checkNotNullParameter(r3, "params");
        TrackParams r28 = new TrackParams().merge(r3);
        by7.a r29 = new by7.a("chat_list_not_bot_cell_show");
        r29.a.merge(r28);
        r29.b();
        return;
    L65:
        if (r26.length() != 0) goto L67;
    L61:
        r25 = "unadded_bot_list";
        goto L62
    L57:
        r24 = null;
        goto L58
    L70:
        if (AudioServiceDelegate.a.getAudioConfig().n(r38.b) == false) goto L72;
        String r30 = "1";
    L73:
        FLogger r111 = FLogger.a;
        StringBuilder r112 = new StringBuilder("report: bot cell, index=");
        r112.append(r39);
        r112.append(" conversationId=");
        wc9.e r31 = r38.a;
        if (r31 == null) goto L76;
        String r32 = r31.a;
    L77:
        r112.append(r32);
        r112.append(" isCallBot=");
        r112.append(r30);
        r111.i("ConversationItemShowTrace", r112.toString());
        BotModel r33 = r38.b;
        if (r33 == null) goto L80;
        Integer r34 = r33.getBotType();
    L81:
        JSONObject r35 = new JSONObject();
        wc9.e r113 = r38.a;
        if (r113 == null) goto L84;
        String r114 = r113.a;
    L85:
        r35.put(MusicAppletPage.KEY_CONVERSATION_ID, r114);
        wc9.e r115 = r38.a;
        if (r115 == null) goto L88;
        Integer r116 = r115.j;
    L90:
        if (r116 == null) goto L96;
        if (r116.intValue() != 1) goto L96;
        r35.put("chat_type", "real_people");
        r35.put("group_type", "private");
    L175:
        r35.put("red_dot_cnt", r22);
        r35.put("current_page", r40);
        r35.put("previous_page", r41);
        r35.put("recommend_from", r42);
        r35.put("is_navigation_sidebar", TriggerSendLoading.NO_LOADING);
        String r36 = r38.e;
        if (r36 == null) goto L178;
        r35.put("req_id", r36);
    L178:
        r35.put("index", r39);
        Unit r37 = Unit.INSTANCE;
        o3.c(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r30, r34, r35, null, 4718591);
        return;
    L96:
        if (r116 != null) goto L99;
    L132:
        BotModel r43 = r38.b;
        if (r43 == null) goto L137;
        String r44 = r43.getBotId();
        if (r44 == null) goto L137;
        r35.put("bot_id", r44);
        r35.put("item_id", r44);
    L137:
        ChatControlTrace r45 = ChatControlTrace.b;
        wc9.e r117 = r38.a;
        if (r117 == null) goto L140;
        Integer r118 = r117.v;
    L141:
        BotModel r119 = r38.b;
        if (r119 == null) goto L144;
        Integer r120 = r119.getBotType();
    L145:
        BotModel r121 = r38.b;
        if (r121 == null) goto L150;
        BotCreatorInfo r122 = r121.getBotCreatorInfo();
        if (r122 == null) goto L150;
        String r123 = r122.getId();
    L151:
        r35.put("chat_type", r45.g(r118, r120, Intrinsics.areEqual(r123, AccountService.a.getUserId())));
        r35.put("group_type", "private");
        com.larus.bmhome.chat.immerse.i0 r46 = com.larus.bmhome.chat.immerse.i0.a;
        BotModel r47 = r38.b;
        if (r47 == null) goto L156;
        boolean r124 = true;
        if (true != r47.getBgImgOpen()) goto L157;
        boolean r48 = true;
    L158:
        if (r48 == false) goto L170;
        if (r47 == null) goto L161;
        String r49 = r47.getBgImgUrl();
    L163:
        if (com.larus.utils.o0.d(r49) == false) goto L170;
        if (r47 == null) goto L166;
        String r50 = r47.getBgImgColor();
    L168:
        if (com.larus.utils.o0.d(r50) == false) goto L170;
    L171:
        if (r124 == false) goto L173;
        Object r125 = "1";
    L174:
        r35.put("is_immersive_background", r125);
        goto L175
    L173:
        r125 = TriggerSendLoading.NO_LOADING;
        goto L174
    L166:
        r50 = null;
        goto L168
    L161:
        r49 = null;
    L170:
        r124 = false;
    L157:
        r48 = false;
        goto L158
    L156:
        r124 = true;
    L150:
        r123 = null;
        goto L151
    L144:
        r120 = null;
        goto L145
    L140:
        r118 = null;
        goto L141
    L99:
        if (r116.intValue() != 2) goto L132;
        wc9.e r51 = r38.a;
        if (r51 != null) goto L103;
    L105:
        boolean r126 = false;
    L107:
        if (r126 == false) goto L109;
        Lazy r127 = com.larus.im.j.a;
        String r52 = com.larus.im.j.b(r51.a);
    L117:
        if (r52 == null) goto L119;
        r35.put("item_id", r52);
    L119:
        wc9.e r53 = r38.a;
        if (r53 == null) goto L127;
        String r54 = r53.r;
        if (r54 == null) goto L127;
        String r55 = new JSONObject(r54).optString("original_template_id");     // Catch: Exception -> L126
    L128:
        if (r55 == null) goto L130;
        r35.put("from_group_template_id", r55);
    L130:
        r35.put("chat_type", "group");
        r35.put("group_type", "group");
    L126:
        FLogger.a.e("ConversationExt", "Call Conversation.getOriginTemplateId error, parse ext error, ext = ".concat(r54));
    L127:
        r55 = null;
        goto L128
    L109:
        if (r51 == null) goto L116;
        String r56 = r51.r;
        if (r56 == null) goto L116;
        r52 = new JSONObject(r56).optString("template_id");     // Catch: Exception -> L115
    L115:
        FLogger.a.e("ConversationExt", "Call Conversation.getTemplateId error, parse ext error, ext = ".concat(r56));
    L116:
        r52 = null;
        goto L117
    L103:
        if (ic8.n.r(r51) != true) goto L105;
        r126 = true;
        goto L107
    L88:
        r116 = null;
        goto L90
    L84:
        r114 = null;
        goto L85
    L80:
        r34 = null;
        goto L81
    L76:
        r32 = null;
        goto L77
    L72:
        r30 = TriggerSendLoading.NO_LOADING;
    L51:
        r21 = 0;
    L45:
        r18 = 0;
    L14:
        r7 = false;
        goto L15
    }
}
