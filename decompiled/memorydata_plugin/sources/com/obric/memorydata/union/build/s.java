package com.obric.memorydata.union.build;

import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\u000e\u0010\u0014\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/union/build/UnionUserInsightTriggerManager;", "", "<init>", "()V", "TAG", "", "TASK_NAME", "isRunning", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pendingTasks", "Ljava/util/concurrent/atomic/AtomicInteger;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "trigger", "", "onSemanticMemoryDeleted", "deletedItems", "", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "tryExecuteNext", "executeTask", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryUnprocessedL2UserInsightCount", "", "stage", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f13110a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f13111b = null;
    private static final AtomicInteger c = null;
    private static final al d = null;

    static {
        f13110a = new s();
        f13111b = new AtomicBoolean(false);
        c = new AtomicInteger(0);
        d = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    private s() {
    }

    private final int a(String r8) {
        return MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryProcessUserInsightDao().countUnprocessedForUnion();
    L4:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionUserInsightTriggerManager", "Query unprocessed L2 user insight count " + r8 + " error: " + e.getMessage(), null, 4, null);
        return 0;
    }

    public static final /* synthetic */ Object a(s r2, Continuation r3) {
        return r2.a((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(Continuation<? super Unit> r20) {
        s r1 = this;
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, UnionUserInsightTriggerManager$executeTask$1.class) == false) goto L7;
        UnionUserInsightTriggerManager$executeTask$1 r3 = (UnionUserInsightTriggerManager$executeTask$1) ZeusTransformUtils.preCheckCast(r0, UnionUserInsightTriggerManager$executeTask$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        int r6 = r3.I$0;
        s r7 = (s) ZeusTransformUtils.preCheckCast(r3.L$0, s.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        int r9 = r6;
        r1 = r7;
    L30:
        f13111b.set(false);
        int r8 = c.get();
        if (r9 == 0) goto L35;
        if (r8 <= 0) goto L34;
        IRunLog r10 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        boolean r11 = false;
        int r12 = 4;
        Object r13 = null;
        String r14 = "UnionUserInsightTriggerManager";
        String r15 = "Has unprocessed L2 user insight and pending tasks, try execute next";
    L37:
        IRunLog.a.a(r10, r14, r15, r11, r12, r13);
        r1.d();
    L40:
        return Unit.INSTANCE;
    L34:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionUserInsightTriggerManager", "Has unprocessed L2 user insight but no pending task, trigger next run", false, 4, null);
        r1.a();
        goto L40
    L35:
        if (r8 <= 0) goto L38;
        r10 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r11 = false;
        r12 = 4;
        r13 = null;
        r14 = "UnionUserInsightTriggerManager";
        r15 = "No unprocessed L2 user insight but has pending tasks, try execute next";
        goto L37
    L38:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionUserInsightTriggerManager", "No unprocessed L2 user insight and no pending tasks, all done", false, 4, null);
        goto L40
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        int r16 = r1.a("before");
        TaskResult r17 = ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("union_user_insight_build").setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();     // Catch: Exception -> L19
        int r18 = r17.getCode();     // Catch: Exception -> L19
        if (r17.getCode() != 1004) goto L21;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionUserInsightTriggerManager", "package not ready", null, 4, null);     // Catch: Exception -> L19
    L21:
        int r19 = r1.a("after");
        if (r19 <= 0) goto L24;
        r9 = 1;
    L25:
        long r110 = r.f13109a.a(r18, r16, r19);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionUserInsightTriggerManager", "union_user_insight_build execution finished, responseCode=" + r18 + ", unprocessedL2Before=" + r16 + ", unprocessedL2After=" + r19 + ", retryDelayMs=" + r110, false, 4, null);
        if (r110 <= 0) goto L30;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionUserInsightTriggerManager", "Unprocessed L2 user insight not advanced, delay " + r110 + "ms before retry", false, 4, null);
        r3.L$0 = r1;
        r3.I$0 = r9;
        r3.label = 1;
        if (au.a(r110, r3) != r4) goto L30;
        return r4;
    L24:
        r9 = 0;
    L19:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionUserInsightTriggerManager", "Task execution failed: " + e.getMessage(), null, 4, null);
        r18 = TaskResult.EXCEPTION;
    L7:
        r3 = new UnionUserInsightTriggerManager$executeTask$1(r1, r0);
        goto L8
    }

    public static final /* synthetic */ AtomicBoolean b() {
        return f13111b;
    }

    public static final /* synthetic */ AtomicInteger c() {
        return c;
    }

    private final void d() {
        kotlinx.coroutines.i.a(d, null, null, (Function2) ZeusTransformUtils.preCheckCast(new UnionUserInsightTriggerManager$tryExecuteNext$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void a() {
        AtomicInteger r0 = c;
        if (r0.get() <= 0) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionUserInsightTriggerManager", "Already have a pending task, skip this trigger", false, 4, null);
        return;
    L6:
        r0.incrementAndGet();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionUserInsightTriggerManager", "Added task to pending queue, current pending: " + r0.get(), false, 4, null);
        d();
    }

    public final void a(List<ip> r8) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "deletedItems");
        if (r7.isEmpty() == false) goto L5;
        return;
    L5:
        kotlinx.coroutines.i.a(d, null, null, (Function2) ZeusTransformUtils.preCheckCast(new UnionUserInsightTriggerManager$onSemanticMemoryDeleted$1(r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
