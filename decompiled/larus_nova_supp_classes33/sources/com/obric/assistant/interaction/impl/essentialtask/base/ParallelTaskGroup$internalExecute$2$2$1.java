package com.obric.assistant.interaction.impl.essentialtask.base;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.base.ParallelTaskGroup$internalExecute$2$2$1", f = "ParallelTaskGroup.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
public final class ParallelTaskGroup$internalExecute$2$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EssentialTask $subTask;
    int label;

    public ParallelTaskGroup$internalExecute$2$2$1(EssentialTask r1, Continuation<? super ParallelTaskGroup$internalExecute$2$2$1> r2) {
        this.$subTask = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ParallelTaskGroup$internalExecute$2$2$1(this.$subTask, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L12:
        if (((ExecuteResult) r4).isSuccess() == true) goto L14;
        FLogger.a.w("EssentialTaskParallelTaskGroup", "task " + this.$subTask + " execute failed. cancel all other task");
        throw new CancellationException();
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        EssentialTask r5 = this.$subTask;
        this.label = 1;
        r4 = r5.execute(this);
        if (r4 != r0) goto L12;
        return r0;
    }
}
