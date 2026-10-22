package com.larus.bmhome.chat.component.title;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.bot.SpeakerVoice;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e0 implements Function2 {
    public /* synthetic */ e0() {
    }

    public final Object invoke(Object r4, Object r5) {
        BotModel r6 = (BotModel) r4;
        BotModel r7 = (BotModel) r5;
        int r0 = ChatTitleComponent.P1;
        Map r1 = null;
        if (r6 == null) goto L5;
        String r2 = r6.getBotId();
    L6:
        if (r7 == null) goto L8;
        String r3 = r7.getBotId();
    L10:
        if (Intrinsics.areEqual(r2, r3) == false) goto L67;
        if (r6 == null) goto L13;
        Integer r8 = r6.getBotStatus();
    L14:
        if (r7 == null) goto L16;
        Integer r9 = r7.getBotStatus();
    L18:
        if (Intrinsics.areEqual(r8, r9) == false) goto L67;
        if (r6 == null) goto L21;
        String r10 = r6.getEditPos();
    L22:
        if (r7 == null) goto L24;
        String r11 = r7.getEditPos();
    L26:
        if (Intrinsics.areEqual(r10, r11) == false) goto L67;
        if (r6 == null) goto L29;
        Boolean r12 = Boolean.valueOf(r6.getMuted());
    L30:
        if (r7 == null) goto L32;
        Boolean r13 = Boolean.valueOf(r7.getMuted());
    L34:
        if (Intrinsics.areEqual(r12, r13) == false) goto L67;
        if (r6 == null) goto L39;
        SpeakerVoice r14 = r6.getVoiceType();
        if (r14 == null) goto L39;
        String r15 = r14.getLanguageCode();
    L40:
        if (r7 == null) goto L44;
        SpeakerVoice r16 = r7.getVoiceType();
        if (r16 == null) goto L44;
        String r17 = r16.getLanguageCode();
    L46:
        if (Intrinsics.areEqual(r15, r17) == false) goto L67;
        if (r6 == null) goto L51;
        ConversationPage r18 = r6.getConversationPage();
        if (r18 == null) goto L51;
        Boolean r19 = r18.getShowActionBar();
    L52:
        if (r7 == null) goto L56;
        ConversationPage r20 = r7.getConversationPage();
        if (r20 == null) goto L56;
        Boolean r21 = r20.getShowActionBar();
    L58:
        if (Intrinsics.areEqual(r19, r21) == false) goto L67;
        if (r6 == null) goto L61;
        Map r22 = r6.getExtra();
    L62:
        if (r7 == null) goto L65;
        r1 = r7.getExtra();
    L65:
        if (Intrinsics.areEqual(r22, r1) == false) goto L67;
        boolean r23 = true;
    L69:
        return Boolean.valueOf(r23);
    L61:
        r22 = null;
    L56:
        r21 = null;
    L51:
        r19 = null;
    L44:
        r17 = null;
    L39:
        r15 = null;
        goto L40
    L32:
        r13 = null;
        goto L34
    L29:
        r12 = null;
        goto L30
    L24:
        r11 = null;
        goto L26
    L21:
        r10 = null;
        goto L22
    L16:
        r9 = null;
        goto L18
    L13:
        r8 = null;
    L67:
        r23 = false;
        goto L69
    L8:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
