package com.larksuite.rucket.job;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.callback.Entity.ErrorResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$error$1$1", f = "RucketJobImpl.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
public final class RucketJobImpl$error$1$1 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<ErrorResult, Continuation<? super Unit>, Object> $h;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public RucketJobImpl$error$1$1(Function2<? super ErrorResult, ? super Continuation<? super Unit>, ? extends Object> r1, Continuation<? super RucketJobImpl$error$1$1> r2) {
        this.$h = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        RucketJobImpl$error$1$1 r0 = new RucketJobImpl$error$1$1(this.$h, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(ErrorResult r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ErrorResult) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        ErrorResult r5 = (ErrorResult) this.L$0;
        Function2<ErrorResult, Continuation<? super Unit>, Object> r2 = this.$h;
        this.label = 1;
        if (r2.invoke(r5, this) != r0) goto L12;
        return r0;
    }
}
