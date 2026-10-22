package com.obric.assistant.state.multitask;

import com.obric.assistant.state.multitask.core.TaskDispatchResult;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.multitask.TaskFlowManager$tryDispatchTaskEvent$2$1", f = "TaskFlowManager.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {})
final class TaskFlowManager$tryDispatchTaskEvent$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TaskFlowManager$a<Object> $command;
    final /* synthetic */ TaskFlowManager$b<Object> $entry;
    final /* synthetic */ CompletableDeferred<TaskDispatchResult> $result;
    int label;

    public TaskFlowManager$tryDispatchTaskEvent$2$1(TaskFlowManager$b<Object> r1, TaskFlowManager$a<Object> r2, CompletableDeferred<TaskDispatchResult> r3, Continuation<? super TaskFlowManager$tryDispatchTaskEvent$2$1> r4) {
        this.$entry = r1;
        this.$command = r2;
        this.$result = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new TaskFlowManager$tryDispatchTaskEvent$2$1(this.$entry, this.$command, this.$result, r5);
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
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r4);     // Catch: CancellationException -> L15 Throwable -> L17
    L13:
        TaskFlowManager r5 = TaskFlowManager.a;     // Catch: CancellationException -> L15 Throwable -> L17
        TaskFlowManager.f(this.$entry);     // Catch: CancellationException -> L15 Throwable -> L17
    L19:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r4);
        Channel<TaskFlowManager$a<S>> r6 = this.$entry.d;     // Catch: CancellationException -> L15 Throwable -> L17
        TaskFlowManager$a<Object> r2 = this.$command;     // Catch: CancellationException -> L15 Throwable -> L17
        this.label = 1;     // Catch: CancellationException -> L15 Throwable -> L17
        if (r6.send(r2, this) != r0) goto L13;
        return r0;
    L15:
        e = move-exception;
        this.$entry.f.decrementAndGet();
        this.$result.cancel(e);
        throw e;
    L17:
        this.$entry.f.decrementAndGet();
        this.$result.complete(TaskDispatchResult.CLOSED);
        goto L19
    }
}
