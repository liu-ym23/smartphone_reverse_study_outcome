package com.larus.avlink.simulInterpret.page.view;

import com.larus.avlink.impl.databinding.LayoutFragmentBinding;
import com.larus.avlink.simulInterpret.page.ui.TopTranslatePanelView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.simulInterpret.page.view.SimultaneousInterpretFragment$initSubscribers$14", f = "SimultaneousInterpretFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SimultaneousInterpretFragment$initSubscribers$14 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SimultaneousInterpretFragment this$0;

    public SimultaneousInterpretFragment$initSubscribers$14(SimultaneousInterpretFragment r1, Continuation<? super SimultaneousInterpretFragment$initSubscribers$14> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        SimultaneousInterpretFragment$initSubscribers$14 r0 = new SimultaneousInterpretFragment$initSubscribers$14(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(Boolean r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Boolean) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r2);
        Boolean r3 = (Boolean) this.L$0;
        if (r3 == null) goto L19;
        SimultaneousInterpretFragment r0 = this.this$0;
        if (r3.booleanValue() == false) goto L13;
        LayoutFragmentBinding r4 = r0.l;
        if (r4 == null) goto L19;
        TopTranslatePanelView r5 = r4.m;
        if (r5 == null) goto L19;
        r5.R5(true);
        goto L19
    L13:
        LayoutFragmentBinding r6 = r0.l;
        if (r6 == null) goto L19;
        TopTranslatePanelView r7 = r6.m;
        if (r7 == null) goto L19;
        r7.R5(false);
    L19:
        return Unit.INSTANCE;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
