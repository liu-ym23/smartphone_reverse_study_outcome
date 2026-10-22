package com.larus.bmhome.chat.layout.holder.answeraction;

import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.im.bean.bot.MsgRegenMode;
import com.skydoves.balloon.Balloon;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class RegenInstructionPanel$show$commonMenu$1 extends FunctionReferenceImpl implements Function1<ot8.a, Unit> {
    public RegenInstructionPanel$show$commonMenu$1(Object r8) {
        super(1, r8, RegenInstructionPanel.class, "handleItemClick", "handleItemClick(Lcom/larus/bmhome/view/screenmenu/abs/IMenuItem;)V", 0);
    }

    public final void invoke(ot8.a r7) {
        Intrinsics.checkNotNullParameter(r7, "p0");
        RegenInstructionPanel r0 = (RegenInstructionPanel) ((CallableReference) this).receiver;
        int r1 = RegenInstructionPanel.i;
        r0.getClass();
        int r2 = r7.getId();
        if (r2 != 2131380351) goto L13;
        if ((r7 instanceof l0) == false) goto L24;
        Object r8 = ((l0) r7).l;
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.larus.im.bean.bot.MsgRegenMode");
        r0.h = new b((MsgRegenMode) r8);
        q0.a r9 = r0.d;
        if (r9 == null) goto L19;
        maa.e r10 = r9.C9();
        if (r10 == null) goto L19;
        maa.e.a.a(r10, null, null, false, 7);
    L19:
        Balloon r11 = r0.f;
        if (r11 == null) goto L23;
        r11.h();
        return;
    L23:
        return;
    L24:
        return;
    L13:
        if (r2 != 2131908739) goto L19;
        r0.h = a.a;
        q0.a r12 = r0.d;
        if (r12 == null) goto L19;
        maa.e r13 = r12.C9();
        if (r13 == null) goto L19;
        maa.e.a.a(r13, null, null, false, 7);
        goto L19
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ot8.a) r1);
        return Unit.INSTANCE;
    }
}
