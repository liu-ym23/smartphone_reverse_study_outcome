package com.ss.android.lark.keyboard.inputstate;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import cya.h;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.inputstate.InputStateController$pushAsync$1", f = "InputStateController.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
final class InputStateController$pushAsync$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ CompletableDeferred<Boolean> $result;
    final /* synthetic */ h $state;
    Object L$0;
    int label;
    final /* synthetic */ InputStateController this$0;

    public InputStateController$pushAsync$1(InputStateController r1, CompletableDeferred<Boolean> r2, h r3, Continuation<? super InputStateController$pushAsync$1> r4) {
        this.this$0 = r1;
        this.$result = r2;
        this.$state = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new InputStateController$pushAsync$1(this.this$0, this.$result, this.$state, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CompletableDeferred<Boolean> r2 = (CompletableDeferred) this.L$0;
        ResultKt.throwOnFailure(r5);
    L16:
        r2.complete(r5);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        InputStateController r6 = this.this$0;
        if (r6.j == true) goto L12;
        this.$result.complete(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    L12:
        CompletableDeferred<Boolean> r3 = this.$result;
        h r4 = this.$state;
        this.L$0 = r3;
        this.label = 1;
        r5 = r6.k(r4, true);
        if (r5 != r0) goto L15;
        return r0;
    L15:
        r2 = r3;
        goto L16
    }
}
