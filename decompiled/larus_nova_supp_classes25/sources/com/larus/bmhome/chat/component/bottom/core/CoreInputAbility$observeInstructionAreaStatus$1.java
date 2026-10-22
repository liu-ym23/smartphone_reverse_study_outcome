package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputAbility$observeInstructionAreaStatus$1", f = "CoreInputAbility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CoreInputAbility$observeInstructionAreaStatus$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ CoreInputAbility<ComponentFeature> this$0;

    public CoreInputAbility$observeInstructionAreaStatus$1(CoreInputAbility<ComponentFeature> r1, Continuation<? super CoreInputAbility$observeInstructionAreaStatus$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CoreInputAbility$observeInstructionAreaStatus$1 r0 = new CoreInputAbility$observeInstructionAreaStatus$1(this.this$0, r4);
        r0.I$0 = ((Number) r3).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r5);
        int r6 = this.I$0;
        a9 r0 = this.this$0.f;
        boolean r1 = false;
        if (r6 != 0) goto L7;
        boolean r3 = true;
    L8:
        r0.Sq(r3, true);
        if (this.this$0.F().getInputStatus() != 2) goto L15;
        CoreInputAbility<ComponentFeature> r2 = this.this$0;
        if (r6 != 0) goto L13;
        r1 = true;
    L13:
        r2.O0(r1);
    L15:
        return Unit.INSTANCE;
    L7:
        r3 = false;
        goto L8
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
