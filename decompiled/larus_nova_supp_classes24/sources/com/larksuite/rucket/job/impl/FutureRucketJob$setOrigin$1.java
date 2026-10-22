package com.larksuite.rucket.job.impl;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.dora.CommandStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", "T", "it"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.rucket.job.impl.FutureRucketJob$setOrigin$1", f = "FutureRucketJob.kt", i = {}, l = {CommandStatus.COMMAND_VUI_END_SILENCE}, m = "invokeSuspend", n = {}, s = {})
public final class FutureRucketJob$setOrigin$1<T> extends SuspendLambda implements Function2<T, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FutureRucketJob<T> this$0;

    public FutureRucketJob$setOrigin$1(FutureRucketJob<T> r1, Continuation<? super FutureRucketJob$setOrigin$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        FutureRucketJob$setOrigin$1 r0 = new FutureRucketJob$setOrigin$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(r1, (Continuation) r2);
    }

    public final Object invoke(T r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
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
        Object r5 = this.L$0;
        FutureRucketJob<T> r2 = this.this$0;
        this.label = 1;
        if (r2.setResult((T) r5, (Continuation<? super Unit>) this) != r0) goto L12;
        return r0;
    }
}
