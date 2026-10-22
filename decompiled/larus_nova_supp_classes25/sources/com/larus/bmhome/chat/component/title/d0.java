package com.larus.bmhome.chat.component.title;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d0 implements Function2 {
    public /* synthetic */ d0() {
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
        Boolean r10 = Boolean.valueOf(r6.getMuted());
    L22:
        if (r7 == null) goto L24;
        Boolean r11 = Boolean.valueOf(r7.getMuted());
    L26:
        if (Intrinsics.areEqual(r10, r11) == false) goto L67;
        if (r6 == null) goto L31;
        SpeakerVoice r12 = r6.getVoiceType();
        if (r12 == null) goto L31;
        String r13 = r12.getId();
    L32:
        if (r7 == null) goto L36;
        SpeakerVoice r14 = r7.getVoiceType();
        if (r14 == null) goto L36;
        String r15 = r14.getId();
    L38:
        if (Intrinsics.areEqual(r13, r15) == false) goto L67;
        if (r6 == null) goto L41;
        List r16 = r6.getTagList();
    L42:
        if (r7 == null) goto L44;
        List r17 = r7.getTagList();
    L46:
        if (Intrinsics.areEqual(r16, r17) == false) goto L67;
        if (r6 == null) goto L51;
        SpeakerVoice r18 = r6.getVoiceType();
        if (r18 == null) goto L51;
        String r19 = r18.getStyleId();
    L52:
        if (r7 == null) goto L56;
        SpeakerVoice r20 = r7.getVoiceType();
        if (r20 == null) goto L56;
        String r21 = r20.getStyleId();
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
        goto L52
    L44:
        r17 = null;
        goto L46
    L41:
        r16 = null;
    L36:
        r15 = null;
    L31:
        r13 = null;
        goto L32
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
