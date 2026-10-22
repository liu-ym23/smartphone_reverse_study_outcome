package com.obric.assistant.state.multitask;

import com.obric.assistant.state.multitask.core.TaskDispatchResult;
import com.obric.assistant.state.multitask.core.TaskFlowDispatchStrategy;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.multitask.TaskFlowManager$startWorker$1", f = "TaskFlowManager.kt", i = {0, 0, 1, 1, 1}, l = {244, 248}, m = "invokeSuspend", n = {"terminalResult", "callerContext", "terminalResult", "command", "callerContext"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0"})
public final class TaskFlowManager$startWorker$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TaskFlowManager$b<Object> $entry;
    int I$0;
    Object L$0;
    Object L$1;
    int label;

    public TaskFlowManager$startWorker$1(TaskFlowManager$b<Object> r1, Continuation<? super TaskFlowManager$startWorker$1> r2) {
        this.$entry = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new TaskFlowManager$startWorker$1(this.$entry, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r15v0, types: [com.obric.assistant.state.multitask.e, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00bc -> B:96:0x00c1). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r18) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        TaskFlowManager$a r5 = null;
        if (r0 == 0) goto L20;
        if (r0 == 1) goto L15;
        if (r0 != 2) goto L14;
        int r9 = this.I$0;
        TaskFlowManager$a r10 = (TaskFlowManager$a) this.L$1;
        TaskDispatchResult r11 = (TaskDispatchResult) this.L$0;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L9 CancellationException -> L11
        Object r1 = r18;
        TaskDispatchResult r12 = r11;
        TaskFlowManager$startWorker$1 r13 = this;
    L96:
        TaskDispatchResult r3 = (TaskDispatchResult) r1;     // Catch: Throwable -> L45 CancellationException -> L47
        TaskFlowManager$startWorker$1 r16 = r13;
        final TaskFlowManager$a r14 = r10;
        TaskFlowManager$startWorker$1 r15 = r16;
    L60:
        if (r3 == null) goto L71;
        r5 = r14;
    L62:
        if (r5 == null) goto L64;
        TaskFlowManager r4 = TaskFlowManager.a;
        TaskFlowManager.a(r15.$entry);
        Boxing.boxBoolean(r5.c.complete(r3));
    L70:
        return Unit.INSTANCE;
    L64:
        if (r9 == 0) goto L68;
        r15.$entry.h.set(false);
        if (r15.$entry.f.get() <= 0) goto L70;
        TaskFlowManager r6 = TaskFlowManager.a;
        TaskFlowManager.f(r15.$entry);
        goto L70
    L68:
        TaskFlowManager r7 = TaskFlowManager.a;
        TaskFlowManager.a(r15.$entry);
        goto L70
    L71:
        r3 = r12;
    L25:
        if (r9 == 0) goto L30;
        TaskFlowManager$a r17 = (TaskFlowManager$a) g.b(r15.$entry.d.tryReceive-PtdJZtk());     // Catch: Throwable -> L76
        if (r17 == null) goto L62;
        r12 = r3;
    L38:
        r15.$entry.f.decrementAndGet();     // Catch: Throwable -> L76
        TaskFlowManager r8 = TaskFlowManager.a;     // Catch: Throwable -> L49 CancellationException -> L72
        TaskFlowManager$b<Object> r19 = r15.$entry;     // Catch: Throwable -> L49 CancellationException -> L72
        r15.L$0 = r12;     // Catch: Throwable -> L49 CancellationException -> L72
        r15.L$1 = r17;     // Catch: Throwable -> L49 CancellationException -> L72
        r15.I$0 = r9;     // Catch: Throwable -> L49 CancellationException -> L72
        r15.label = 2;     // Catch: Throwable -> L49 CancellationException -> L72
        r1 = TaskFlowManager.b(r8, r19, r17, r15);     // Catch: Throwable -> L49 CancellationException -> L72
        if (r1 != r2) goto L42;
        return r2;
    L42:
        TaskFlowManager$a r110 = r17;
        r13 = r15;
        r10 = r110;
        goto L96
    L72:
        CancellationException e = e;
        r10 = r17;
    L74:
        r10.c.cancel(e);     // Catch: Throwable -> L78
        throw e;     // Catch: Throwable -> L78
    L49:
        final Throwable th = th;
        TaskFlowManager$a r111 = r17;
        r13 = r15;
        r10 = r111;
    L51:
        TaskFlowManager$startWorker$1 r112 = r13;
        r14 = r10;
        r15 = r112;
    L89:
        TaskFlowManager r113 = TaskFlowManager.a;     // Catch: Throwable -> L76
        final TaskFlowManager$b<Object> r114 = r15.$entry;     // Catch: Throwable -> L76
        b$a r115 = b.a;     // Catch: Throwable -> L76
        ?? r116 = new e(th, r114, r14);     // Catch: Throwable -> L76
        r115.getClass();     // Catch: Throwable -> L76
        Intrinsics.checkNotNullParameter(r116, "eventBuilder");     // Catch: Throwable -> L76
        b r20 = c.a;     // Catch: Throwable -> L76
        b r21 = c.a;     // Catch: Throwable -> L76
        if (r21.isEnabled() == false) goto L55;
        r21.b((a) r116.invoke());     // Catch: Throwable -> L76
    L55:
        CompletableDeferred<TaskDispatchResult> r22 = r14.c;     // Catch: Throwable -> L76
        TaskDispatchResult r117 = TaskDispatchResult.FAILED;     // Catch: Throwable -> L76
        r22.complete(r117);     // Catch: Throwable -> L76
        if (TaskFlowManager.e(r14.b) == false) goto L59;
        r3 = r117;
        goto L60
    L59:
        r3 = null;
    L76:
        th = th;
        TaskFlowManager$startWorker$1 r118 = r15;
    L81:
        if (r9 == 0) goto L85;
        r118.$entry.h.set(false);
        if (r118.$entry.f.get() <= 0) goto L86;
        TaskFlowManager r23 = TaskFlowManager.a;
        TaskFlowManager.f(r118.$entry);
    L86:
        throw th;
    L85:
        TaskFlowManager r24 = TaskFlowManager.a;
        TaskFlowManager.a(r118.$entry);
        goto L86
    L30:
        Channel<TaskFlowManager$a<S>> r119 = r15.$entry.d;     // Catch: Throwable -> L76
        r15.L$0 = r3;     // Catch: Throwable -> L76
        r15.L$1 = null;     // Catch: Throwable -> L76
        r15.I$0 = r9;     // Catch: Throwable -> L76
        r15.label = 1;     // Catch: Throwable -> L76
        Object r120 = r119.receiveCatching-JP2dKIU(r15);     // Catch: Throwable -> L76
        if (r120 != r2) goto L33;
        return r2;
    L33:
        TaskFlowManager$startWorker$1 r121 = r15;
        Object r122 = r120;
    L34:
        TaskFlowManager$a r123 = (TaskFlowManager$a) g.b(r122);     // Catch: Throwable -> L78
        if (r123 != null) goto L37;
        r15 = r121;
        goto L62
    L37:
        r12 = r3;
        TaskFlowManager$startWorker$1 r124 = r121;
        r17 = r123;
        r15 = r124;
        goto L38
    L47:
        e = e;
    L45:
        th = th;
        goto L51
    L11:
        e = e;
    L9:
        th = th;
        r12 = r11;
        r14 = r10;
        r15 = this;
        goto L89
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r9 = this.I$0;
        r3 = (TaskDispatchResult) this.L$0;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L18
        r122 = ((g) r18).a;     // Catch: Throwable -> L18
        r121 = this;
    L18:
        th = th;
        r118 = this;
        goto L81
    L20:
        ResultKt.throwOnFailure(r18);
        r3 = TaskDispatchResult.CONSUMED;
        if (this.$entry.c.a != TaskFlowDispatchStrategy.CALLER_CONTEXT) goto L23;
        r9 = 1;
    L24:
        r15 = this;
        goto L25
    L23:
        r9 = 0;
    L78:
        th = th;
        goto L81
    }
}
