package com.larus.bmhome.chat.list.cell.prompt;

import com.larus.bmhome.chat.bean.CardCandidateConf;
import com.larus.bmhome.chat.bean.NexPulseCandidate;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class x1 implements Function3 {
    public final /* synthetic */ WelcomeBackCell a;

    public /* synthetic */ x1(WelcomeBackCell r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5, Object r6, Object r7) {
        final WelcomeBackCell r0 = this.a;
        final NexPulseCandidate r8 = (NexPulseCandidate) r5;
        final int r9 = ((Integer) r7).intValue();
        int r1 = WelcomeBackCell.s;
        Intrinsics.checkNotNullParameter(r8, "candidate");
        Intrinsics.checkNotNullParameter((CardCandidateConf) r6, "<unused var>");
        g2 r10 = (g2) ((BaseMessageListCell) r0).d;
        if (r10 == null) goto L9;
        final Message r11 = r10.a;
        if (r11 == null) goto L9;
        com.larus.bmhome.chat.trace.k0.a(r11.getLocalMessageId() + ',' + r8.getGid() + ',' + r9, new w1(r0, r8, r11, r9));
    L9:
        return Unit.INSTANCE;
    }
}
