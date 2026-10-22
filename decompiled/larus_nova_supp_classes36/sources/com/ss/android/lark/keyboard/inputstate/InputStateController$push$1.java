package com.ss.android.lark.keyboard.inputstate;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import cya.h;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.inputstate.InputStateController$push$1", f = "InputStateController.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
public final class InputStateController$push$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ h $state;
    int label;
    final /* synthetic */ InputStateController this$0;

    public InputStateController$push$1(InputStateController r1, h r2, Continuation<? super InputStateController$push$1> r3) {
        this.this$0 = r1;
        this.$state = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new InputStateController$push$1(this.this$0, this.$state, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        InputStateController r5 = this.this$0;
        if (r5.j == false) goto L11;
        h r2 = this.$state;
        this.label = 1;
        if (r5.k(r2, true) != r0) goto L16;
        return r0;
    L11:
        return Unit.INSTANCE;
    }
}
