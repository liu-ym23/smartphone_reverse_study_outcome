package com.larus.bmhome.chat.list.cell.prompt;

import com.larus.bmhome.chat.bean.CardCandidateConf;
import com.larus.bmhome.chat.bean.NexPulseCandidate;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tx9.u3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class t1 implements Function4 {
    public final /* synthetic */ WelcomeBackCell a;
    public final /* synthetic */ g2 b;

    public /* synthetic */ t1(WelcomeBackCell r1, g2 r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invoke(Object r84, Object r85, Object r86, Object r87) {
        WelcomeBackCell r1 = this.a;
        g2 r2 = this.b;
        NexPulseCandidate r3 = (NexPulseCandidate) r84;
        CardCandidateConf r4 = (CardCandidateConf) r85;
        int r5 = ((Integer) r86).intValue();
        int r6 = ((Integer) r87).intValue();
        int r7 = WelcomeBackCell.s;
        Intrinsics.checkNotNullParameter(r3, "candidate");
        Intrinsics.checkNotNullParameter(r4, "cardConf");
        r1.getClass();
        CardCandidateConf r8 = r3.getCardConf();
        if (r8 == null) goto L7;
        if (r6 != 2) goto L6;
        Long r9 = r8.getLabelSugItemType();
    L8:
        int r11 = e1.l;
        int r10 = r5 + 1;
        Intrinsics.checkNotNullParameter(r3, "candidate");
        e1 r12 = new e1(PromptBizType.WELCOME_BACK, r3.getGid(), r3.getLogId(), r10, "pics", r3.getPromptFrom(), r3.getTemplateSubType(), r3.getTagCode(), r3.getActionBarTemplateId(), r3.getVisualSize(), null, 1024);
        String r13 = String.valueOf(r9);
        PromptContent.SuggestItemType r14 = PromptContent.SuggestItemType.WcbCreation;
        if (Intrinsics.areEqual(r13, r14.getValue()) == false) goto L11;
    L84:
        String r88 = "new_topic";
        String r15 = null;
        d1 r0 = r1.q;
        if (r0 == null) goto L87;
        r0.d(r3.getGid(), Intrinsics.areEqual(String.valueOf(r9), PromptContent.SuggestItemType.WcbCreationSameStyle.getValue()), r12);
    L87:
        fx9.a r16 = (fx9.a) r1.k.getValue();
        if (r16 == null) goto L94;
        Message r17 = r2.a;
        String r18 = r3.getGid();
        String r19 = r3.getActivityId();
        Long r20 = r3.getExpireTime();
        if (r20 == null) goto L92;
        long r110 = r20.longValue();
    L93:
        r16.k30(r17, r18, r19, r110);
        goto L94
    L92:
        r110 = 0;
    L94:
        p1 r21 = r1.p;
        if (r21 == null) goto L148;
        Message r22 = r2.a;
        Intrinsics.checkNotNullParameter(r22, "data");
        Intrinsics.checkNotNullParameter(r3, "candidate");
        if (r3.isWorldCupCard() == false) goto L99;
        String r111 = "function_card";
    L101:
        if (r3.isWorldCupCard() == false) goto L103;
        String r24 = "function_card";
    L105:
        if (r6 != 2) goto L111;
        CardCandidateConf r23 = r3.getCardConf();
        if (r23 == null) goto L109;
        Object r25 = r23.getLabelSugItemType();
    L110:
        String r26 = String.valueOf(r25);
    L116:
        int r27 = gx9.o.a;
        String r112 = r22.getMessageId();
        String r28 = com.larus.bmhome.chat.bean.d.E(r22);
        long r29 = de8.d.a(r21.a);
        String r210 = r3.getLogId();
        String r30 = r3.getGid();
        String r32 = r22.getSectionId();
        String r41 = r3.getLotteryStatus();
        de8.c r31 = r21.a;
        if (r31 == null) goto L119;
        String r34 = r31.r();
    L120:
        String r36 = r3.getPromptFrom();
        String r37 = r3.getActionBarTemplateId();
        String r38 = r3.getVisualSize();
        if (r6 != 2) goto L123;
        String r33 = "label";
    L124:
        String r35 = r26;
        gx9.o.e(r112, null, null, r111, "", r28, r29, r24, null, null, null, 0, r210, r30, r35, r32, null, r34, null, r36, r37, r38, r33, r3.getTagCode(), r41, null, null, null, 403177504);
        String r51 = r3.getTemplateSubType();
        if (r51 == null) goto L148;
        if (Intrinsics.areEqual(r26, r14.getValue()) == true) goto L148;
        if (Intrinsics.areEqual(r26, PromptContent.SuggestItemType.WcbCreationSameStyle.getValue()) == true) goto L148;
        String r50 = y0.e(r51);
        com.larus.bmhome.chat.component.cvs.y r39 = r21.b;
        if (r39 == null) goto L134;
        String r46 = r39.getBotId();
    L135:
        String r47 = r3.getGid();
        String r49 = gx9.o.d(de8.d.a(r21.a));
        String r56 = r3.getLogId();
        String r40 = r3.getActionBarTemplateId();
        if (r40 == null) goto L138;
        Integer r57 = StringsKt.toIntOrNull(r40);
    L139:
        de8.c r42 = r21.a;
        if (r42 == null) goto L142;
        String r63 = r42.p();
    L143:
        com.larus.bmhome.chat.component.cvs.y r43 = r21.b;
        if (r43 == null) goto L146;
        r15 = r43.Y1();
    L146:
        String r77 = r3.getPromptFrom();
        String r78 = r3.getVisualSize();
        Integer r54 = Integer.valueOf(r10);
        u3.l(r46, r47, "new_topic", r49, r50, r51, null, null, r54, null, r56, r57, null, null, null, "new_topic", "chat", r63, null, r15, null, null, null, null, null, "new_topic", null, null, null, null, "pics", r77, r78, null, null, -137245760, 24);
        goto L148
    L142:
        r63 = r15;
        goto L143
    L138:
        r57 = r15;
        goto L139
    L134:
        r46 = r15;
        goto L135
    L123:
        r33 = "cover";
        goto L124
    L119:
        r34 = r15;
        goto L120
    L109:
        r25 = r15;
        goto L110
    L111:
        CardCandidateConf r44 = r3.getCardConf();
        if (r44 == null) goto L114;
        Object r45 = r44.getSuggestedItemType();
    L115:
        r26 = String.valueOf(r45);
        goto L116
    L114:
        r45 = r15;
        goto L115
    L103:
        r24 = "pics";
        goto L105
    L99:
        r111 = r88;
    L148:
        return Unit.INSTANCE;
    L11:
        if (Intrinsics.areEqual(r13, PromptContent.SuggestItemType.WcbCreationSameStyle.getValue()) == true) goto L84;
        if (Intrinsics.areEqual(r13, PromptContent.SuggestItemType.WcbCreationAlbum.getValue()) == false) goto L16;
    L80:
        r88 = "new_topic";
        d1 r48 = r1.q;
        if (r48 == null) goto L83;
        String r52 = r4.getSendMessageText();
        boolean r53 = Intrinsics.areEqual(String.valueOf(r9), PromptContent.SuggestItemType.WcbCreationAlbumMulti.getValue());
        int r55 = d1.l;
        r15 = null;
        r48.f(r52, r53, r12, null);
    L83:
        r15 = null;
        goto L87
    L16:
        if (Intrinsics.areEqual(r13, PromptContent.SuggestItemType.WcbCreationAlbumMulti.getValue()) == true) goto L80;
        if (Intrinsics.areEqual(r13, PromptContent.SuggestItemType.Text.getValue()) == false) goto L56;
        LinkedHashMap r58 = new LinkedHashMap();
        r58.put("enter_method", "new_topic");
        r58.put("prompt_type", "pics");
        String r113 = r3.getGid();
        if (r113 == null) goto L23;
        String r114 = (String) r58.put("item_id", r113);
    L23:
        String r115 = r3.getPromptFrom();
        if (r115 == null) goto L26;
        String r116 = (String) r58.put("prompt_from", r115);
    L26:
        String r117 = r3.getVisualSize();
        if (r117 == null) goto L29;
        String r118 = (String) r58.put("visual_size", r117);
    L29:
        String r119 = r3.getTagCode();
        if (r119 == null) goto L32;
        String r120 = (String) r58.put("tag_code", r119);
    L32:
        String r121 = r3.getTemplateSubType();
        if (r121 == null) goto L41;
        r58.put("from_template_id", String.valueOf(r3.getGid()));
        r58.put("from_template_sub_type", r121);
        String r59 = r3.getLogId();
        if (r59 != null) goto L37;
        r59 = "";
    L37:
        r58.put("template_rec_req_id", r59);
        String r60 = r3.getTemplateRecExtra();
        if (r60 != null) goto L40;
        r60 = "";
    L40:
        r58.put("template_rec_extra", r60);
        r58.put("ai_creation_recommend_from", "new_topic");
    L41:
        r58.put("original_content_source_wcb", r12.b());
        String r61 = r3.getActionBarTemplateId();
        if (r61 != null) goto L44;
        r61 = "";
    L44:
        r58.put("action_bar_template_id", r61);
        d1 r62 = r1.q;
        if (r62 == null) goto L69;
        Message r122 = r2.a;
        com.larus.bmhome.chat.component.cvs.y r123 = (com.larus.bmhome.chat.component.cvs.y) r1.f.getValue();
        if (r123 == null) goto L49;
        wc9.e r211 = r123.h();
    L50:
        String r64 = r4.getSendMessageText();
        if (r64 != null) goto L53;
        String r212 = "";
    L54:
        int r65 = d1.l;
        r62.g(r122, null, null, r211, r212, true, null, "", null, r58, null, r12);
        goto L69
    L53:
        r212 = r64;
        goto L54
    L49:
        r211 = null;
    L69:
        r88 = "new_topic";
        goto L83
    L56:
        if (Intrinsics.areEqual(r13, PromptContent.SuggestItemType.JumpSchema.getValue()) == false) goto L65;
        if (r6 != 2) goto L60;
        String r66 = r4.getLabelSchema();
    L61:
        d1 r67 = r1.q;
        if (r67 == null) goto L69;
        r67.b(r66, r12);
        goto L69
    L60:
        r66 = r4.getSchema();
        goto L61
    L65:
        if (Intrinsics.areEqual(r13, PromptContent.SuggestItemType.FillInput.getValue()) == false) goto L71;
        d1 r68 = r1.q;
        if (r68 == null) goto L69;
        String r124 = r4.getSendMessageText();
        Pair<Integer, Integer> r213 = r3.getSelectionPos();
        int r69 = d1.l;
        r68.a(r124, r213, r12, null, null, null, null);
        goto L69
    L71:
        if (Intrinsics.areEqual(r13, PromptContent.SuggestItemType.CameraNew.getValue()) == false) goto L75;
        d1 r70 = r1.q;
        if (r70 == null) goto L69;
        r88 = "new_topic";
        r70.c(r4.getSendMessageText(), de8.d.a((de8.c) r1.e.getValue()), r12);
        goto L83
    L75:
        r88 = "new_topic";
        FLogger r71 = FLogger.a;
        StringBuilder r72 = new StringBuilder("invalid item type ");
        CardCandidateConf r73 = r3.getCardConf();
        if (r73 == null) goto L78;
        Long r74 = r73.getSuggestedItemType();
    L79:
        r72.append(r74);
        r71.e("WcbCell", r72.toString());
        goto L83
    L78:
        r74 = null;
        goto L79
    L6:
        r9 = r8.getSuggestedItemType();
        goto L8
    L7:
        r9 = null;
        goto L8
    }
}
