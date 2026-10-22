package com.larksuite.rucket.job;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.rucket.job.base.b;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.i;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "T", "it", "Lcom/larksuite/rucket/job/base/RucketResult;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$awaitGet$2$2", f = "RucketJobImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RucketJobImpl$awaitGet$2$2<T> extends SuspendLambda implements Function2<b<? extends T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ i<b<? extends T>> $cont;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public RucketJobImpl$awaitGet$2$2(i<? super b<? extends T>> r1, Continuation<? super RucketJobImpl$awaitGet$2$2> r2) {
        this.$cont = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        RucketJobImpl$awaitGet$2$2 r0 = new RucketJobImpl$awaitGet$2$2(this.$cont, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(b<? extends T> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((b) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        b r3 = (b) this.L$0;
        this.$cont.resumeWith(Result.constructor-impl(r3));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
