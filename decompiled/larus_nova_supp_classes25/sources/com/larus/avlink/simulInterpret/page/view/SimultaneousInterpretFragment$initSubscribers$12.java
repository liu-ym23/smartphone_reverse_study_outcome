package com.larus.avlink.simulInterpret.page.view;

import com.larus.avlink.impl.databinding.LayoutFragmentBinding;
import com.larus.avlink.simulInterpret.page.ui.BottomControlView;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.simulInterpret.page.view.SimultaneousInterpretFragment$initSubscribers$12", f = "SimultaneousInterpretFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SimultaneousInterpretFragment$initSubscribers$12 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ SimultaneousInterpretFragment this$0;

    public SimultaneousInterpretFragment$initSubscribers$12(SimultaneousInterpretFragment r1, Continuation<? super SimultaneousInterpretFragment$initSubscribers$12> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        SimultaneousInterpretFragment$initSubscribers$12 r0 = new SimultaneousInterpretFragment$initSubscribers$12(this.this$0, r4);
        r0.Z$0 = ((Boolean) r3).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r2);
        boolean r3 = this.Z$0;
        LayoutFragmentBinding r0 = this.this$0.l;
        if (r0 == null) goto L10;
        BottomControlView r1 = r0.c;
        if (r1 == null) goto L10;
        r1.setMuteState(r3);
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
