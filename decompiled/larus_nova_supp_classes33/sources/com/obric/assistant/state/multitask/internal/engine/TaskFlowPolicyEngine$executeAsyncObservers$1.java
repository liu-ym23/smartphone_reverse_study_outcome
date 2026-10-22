package com.obric.assistant.state.multitask.internal.engine;

import com.obric.assistant.state.multitask.core.TaskFlowAsyncObserver;
import com.obric.capabilitykit.common.ErrorCode;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import jha.g;
import jha.q;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.multitask.internal.engine.TaskFlowPolicyEngine$executeAsyncObservers$1", f = "TaskFlowPolicyEngine.kt", i = {0}, l = {ErrorCode.DEVICE_LOCK_ERROR}, m = "invokeSuspend", n = {"observer"}, s = {"L$4"})
public final class TaskFlowPolicyEngine$executeAsyncObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ q<?> $event;
    final /* synthetic */ g<?> $id;
    final /* synthetic */ long $sequenceId;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ TaskFlowPolicyEngine this$0;

    public TaskFlowPolicyEngine$executeAsyncObservers$1(TaskFlowPolicyEngine r1, g<?> r2, q<?> r3, long r4, Continuation<? super TaskFlowPolicyEngine$executeAsyncObservers$1> r6) {
        this.this$0 = r1;
        this.$id = r2;
        this.$event = r3;
        this.$sequenceId = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new TaskFlowPolicyEngine$executeAsyncObservers$1(this.this$0, this.$id, this.$event, this.$sequenceId, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0076 -> B:29:0x0079). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r22) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L13;
        long r4 = this.J$0;
        TaskFlowAsyncObserver r6 = (TaskFlowAsyncObserver) this.L$4;
        Iterator r7 = (Iterator) this.L$3;
        TaskFlowPolicyEngine r8 = (TaskFlowPolicyEngine) this.L$2;
        q<?> r9 = (q) this.L$1;
        g<?> r10 = (g) this.L$0;
        ResultKt.throwOnFailure(r22);     // Catch: Throwable -> L8 CancellationException -> L10
        TaskFlowAsyncObserver r11 = r6;
        TaskFlowPolicyEngine$executeAsyncObservers$1 r12 = this;
    L29:
        Result.Companion r1 = Result.Companion;     // Catch: CancellationException -> L10 Throwable -> L23
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: CancellationException -> L10 Throwable -> L23
    L25:
        Object r14 = r3;
        TaskFlowAsyncObserver r13 = r11;
        Intrinsics.checkNotNull(r13);
        int r5 = TaskFlowPolicyEngine.e;
        r8.getClass();
        TaskFlowPolicyEngine.c("async_observer", r13, r14, null, r9, r4);
    L16:
        if (r7.hasNext() == false) goto L28;
        r11 = (TaskFlowAsyncObserver) r7.next();
        r12.L$0 = r10;     // Catch: CancellationException -> L10 Throwable -> L23
        r12.L$1 = r9;     // Catch: CancellationException -> L10 Throwable -> L23
        r12.L$2 = r8;     // Catch: CancellationException -> L10 Throwable -> L23
        r12.L$3 = r7;     // Catch: CancellationException -> L10 Throwable -> L23
        r12.L$4 = r11;     // Catch: CancellationException -> L10 Throwable -> L23
        r12.J$0 = r4;     // Catch: CancellationException -> L10 Throwable -> L23
        r12.label = 1;     // Catch: CancellationException -> L10 Throwable -> L23
        if (r11.a(r9) != r2) goto L29;
        return r2;
    L28:
        return Unit.INSTANCE;
    L23:
        Throwable th = th;
    L24:
        Result.Companion r15 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
    L10:
        e = move-exception;
        throw e;
    L8:
        th = th;
        r11 = r6;
        r12 = this;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r22);
        TaskFlowPolicyEngine r16 = this.this$0;
        CopyOnWriteArrayList r17 = r16.c;
        g<?> r18 = this.$id;
        q<?> r19 = this.$event;
        long r20 = this.$sequenceId;
        r10 = r18;
        r9 = r19;
        r12 = this;
        r8 = r16;
        r7 = r17.iterator();
        r4 = r20;
        goto L16
    }
}
