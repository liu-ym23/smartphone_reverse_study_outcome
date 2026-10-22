package com.larus.asr;

import com.larus.asr.handsfree.AsrInputMode;
import com.larus.asr.session.QuicInterpretAsrSessionV2;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class f1 implements Function2 {
    public final /* synthetic */ ChatBottomSpeakerComponent a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ String c;

    public /* synthetic */ f1(ChatBottomSpeakerComponent r1, Message r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r9, Object r10) {
        ChatBottomSpeakerComponent r0 = this.a;
        Message r1 = this.b;
        String r2 = this.c;
        boolean r11 = ((Boolean) r9).booleanValue();
        Set r3 = ChatBottomSpeakerComponent.F2;
        Intrinsics.checkNotNullParameter((VoiceInputType) r10, "voiceInputType");
        AsrInputMode r12 = r0.L1;
        AsrInputMode r4 = AsrInputMode.HANDSFREE;
        boolean r5 = false;
        if (r12 != r4) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == true) goto L11;
    L14:
        com.larus.asr.session.o r14 = r0.s;
        if ((r14 instanceof com.larus.asr.session.i1) == false) goto L17;
    L22:
        r0.G1 = null;
        if (r11 == false) goto L25;
    L28:
        r5 = true;
    L29:
        com.larus.asr.session.o r15 = r0.s;
        if (r15 == null) goto L33;
        r15.ma(r2, r1, r5);
    L33:
        return Unit.INSTANCE;
    L25:
        if (r0.L1 == r4) goto L28;
        if (r0.V1 == false) goto L29;
    L17:
        if ((r14 instanceof QuicInterpretAsrSessionV2) == true) goto L22;
        if (r1 == null) goto L20;
        String r16 = r1.getLocalMessageId();
    L21:
        r0.Q3(r16, r0.B);
        goto L22
    L20:
        r16 = null;
        goto L21
    L11:
        if (r0.P1 == false) goto L13;
        FLogger.a.i("ChatBottomSpeakerComponent", "[HF] onSubmit funnel: duplicate handsfree submit dropped (fromHandsFree=" + r11 + ')');
        return Unit.INSTANCE;
    L13:
        r0.P1 = true;
        goto L14
    L5:
        if (r0.V1 == true) goto L8;
        r13 = false;
        goto L9
    }
}
