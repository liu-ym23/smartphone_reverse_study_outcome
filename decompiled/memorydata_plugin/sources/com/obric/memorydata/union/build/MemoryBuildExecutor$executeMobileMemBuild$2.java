package com.obric.memorydata.union.build;

import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.logging.u;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/task/impl/TaskResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.union.build.MemoryBuildExecutor$executeMobileMemBuild$2", f = "MemoryBuildExecutor.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
final class MemoryBuildExecutor$executeMobileMemBuild$2 extends SuspendLambda implements Function2<al, Continuation<? super TaskResult>, Object> {
    final /* synthetic */ String $contextJson;
    final /* synthetic */ com.obric.memorydata.middleware.api.logging.e $logContext;
    final /* synthetic */ String $productType;
    final /* synthetic */ Function1<JSONObject, Unit> $progressCallback;
    final /* synthetic */ Function1<AbsTaskRequest, Unit> $taskCreatedCallback;
    final /* synthetic */ com.obric.memorydata.task.scheduler.c $taskInfoCallback;
    final /* synthetic */ long $timeoutMs;
    int label;

    /* JADX INFO: renamed from: com.obric.memorydata.union.build.MemoryBuildExecutor$executeMobileMemBuild$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/task/impl/TaskResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.union.build.MemoryBuildExecutor$executeMobileMemBuild$2$1", f = "MemoryBuildExecutor.kt", i = {0}, l = {140}, m = "invokeSuspend", n = {"$this$withPermit$iv"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super TaskResult>, Object> {
        final /* synthetic */ String $contextJson;
        final /* synthetic */ com.obric.memorydata.middleware.api.logging.e $logContext;
        final /* synthetic */ String $productType;
        final /* synthetic */ Function1<JSONObject, Unit> $progressCallback;
        final /* synthetic */ Function1<AbsTaskRequest, Unit> $taskCreatedCallback;
        final /* synthetic */ com.obric.memorydata.task.scheduler.c $taskInfoCallback;
        final /* synthetic */ long $timeoutMs;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        AnonymousClass1(com.obric.memorydata.middleware.api.logging.e r3, String r4, String r5, long r6, Function1<? super JSONObject, Unit> r8, com.obric.memorydata.task.scheduler.c r9, Function1<? super AbsTaskRequest, Unit> r10, Continuation<? super AnonymousClass1> r11) {
            Function1<JSONObject, Unit> r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
            com.obric.memorydata.task.scheduler.c r13 = (com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin");
            Function1<AbsTaskRequest, Unit> r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
            Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
            this.$logContext = r3;
            this.$contextJson = r4;
            this.$productType = r5;
            this.$timeoutMs = r6;
            this.$progressCallback = r12;
            this.$taskInfoCallback = r13;
            this.$taskCreatedCallback = r14;
            super(2, r15);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$logContext, this.$contextJson, this.$productType, this.$timeoutMs, this.$progressCallback, this.$taskInfoCallback, this.$taskCreatedCallback, r10), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super TaskResult> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super TaskResult> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r16) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            long r3 = this.J$0;
            Function1<AbsTaskRequest, Unit> r5 = (Function1) ZeusTransformUtils.preCheckCast(this.L$6, Function1.class, "com.obric.memorydata.plugin");
            com.obric.memorydata.task.scheduler.c r6 = (com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(this.L$5, com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin");
            Function1<JSONObject, Unit> r7 = (Function1) ZeusTransformUtils.preCheckCast(this.L$4, Function1.class, "com.obric.memorydata.plugin");
            String r8 = (String) ZeusTransformUtils.preCheckCast(this.L$3, String.class, "com.obric.memorydata.plugin");
            String r9 = (String) ZeusTransformUtils.preCheckCast(this.L$2, String.class, "com.obric.memorydata.plugin");
            com.obric.memorydata.middleware.api.logging.e r10 = (com.obric.memorydata.middleware.api.logging.e) ZeusTransformUtils.preCheckCast(this.L$1, com.obric.memorydata.middleware.api.logging.e.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.sync.d r0 = (kotlinx.coroutines.sync.d) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.sync.d.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r16);
            Function1<AbsTaskRequest, Unit> r12 = r5;
            com.obric.memorydata.task.scheduler.c r11 = r6;
            long r13 = r3;
            kotlinx.coroutines.sync.d r4 = r0;
        L30:
            com.obric.memorydata.middleware.api.logging.o r14 = (com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(u.f11636a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
            if (AppContext.INSTANCE.isDebug() == false) goto L14;
            com.obric.memorydata.middleware.api.logging.g r15 = new com.obric.memorydata.middleware.api.logging.g();     // Catch: Throwable -> L27
            Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L27
            r14.a("开始执行 mobile_mem_build 任务", r10, r15.a());     // Catch: Throwable -> L27
        L14:
            TaskRequest.Builder r18 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("mobile_mem_build").setForegroundCallerPkg(AppInfo.OAssistant.getPackageName()), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
            JSONObject r19 = new JSONObject().put("contextJson", r9).put("productType", r8).put("enableMemoryTraceReport", com.obric.memorydata.database.c.b.f8850a.a());     // Catch: Throwable -> L27
            Intrinsics.checkNotNullExpressionValue(r19, "put(...)");     // Catch: Throwable -> L27
            TaskRequest.Builder r20 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r18.setInputParam(r19), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setPriority(10), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTimeout(new com.obric.memorydata.task.impl.g(r13, TimeUnit.MILLISECONDS)), TaskRequest.Builder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
            if (r7 == null) goto L17;
            TaskRequest.Builder r21 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r20.setProgressCallback(r7), TaskRequest.Builder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        L17:
            if (r11 == null) goto L19;
            TaskRequest.Builder r22 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r20.setTaskInfoCallback(r11), TaskRequest.Builder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        L19:
            TaskRequest r23 = (TaskRequest) ZeusTransformUtils.preCheckCast(r20.build(), TaskRequest.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
            if (r12 == null) goto L22;
            r12.invoke(r23);     // Catch: Throwable -> L27
        L22:
            TaskResult r24 = r23.execute();     // Catch: Throwable -> L27
            com.obric.memorydata.middleware.api.logging.o r25 = (com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(u.f11636a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
            if (AppContext.INSTANCE.isDebug() == false) goto L25;
            com.obric.memorydata.middleware.api.logging.g r26 = new com.obric.memorydata.middleware.api.logging.g();     // Catch: Throwable -> L27
            r26.a("result_code", Boxing.boxInt(r24.getCode()));     // Catch: Throwable -> L27
            Unit r27 = Unit.INSTANCE;     // Catch: Throwable -> L27
            r25.a("mobile_mem_build 任务执行结束", r10, r26.a());     // Catch: Throwable -> L27
        L25:
            r4.c();
            return r24;
        L27:
            th = move-exception;
            r4.c();
            throw th;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r16);
            r4 = e.b();
            r10 = this.$logContext;
            r9 = this.$contextJson;
            r8 = this.$productType;
            r13 = this.$timeoutMs;
            r7 = this.$progressCallback;
            r11 = this.$taskInfoCallback;
            r12 = this.$taskCreatedCallback;
            Continuation<? super Unit> r110 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r4;
            this.L$1 = r10;
            this.L$2 = r9;
            this.L$3 = r8;
            this.L$4 = r7;
            this.L$5 = r11;
            this.L$6 = r12;
            this.J$0 = r13;
            this.label = 1;
            if (r4.a(r110) != r1) goto L30;
            return r1;
        }
    }

    MemoryBuildExecutor$executeMobileMemBuild$2(com.obric.memorydata.middleware.api.logging.e r3, String r4, String r5, long r6, Function1<? super JSONObject, Unit> r8, com.obric.memorydata.task.scheduler.c r9, Function1<? super AbsTaskRequest, Unit> r10, Continuation<? super MemoryBuildExecutor$executeMobileMemBuild$2> r11) {
        Function1<JSONObject, Unit> r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.task.scheduler.c r13 = (com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin");
        Function1<AbsTaskRequest, Unit> r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        this.$logContext = r3;
        this.$contextJson = r4;
        this.$productType = r5;
        this.$timeoutMs = r6;
        this.$progressCallback = r12;
        this.$taskInfoCallback = r13;
        this.$taskCreatedCallback = r14;
        super(2, r15);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryBuildExecutor$executeMobileMemBuild$2(this.$logContext, this.$contextJson, this.$productType, this.$timeoutMs, this.$progressCallback, this.$taskInfoCallback, this.$taskCreatedCallback, r10), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super TaskResult> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super TaskResult> r4) {
        return ((MemoryBuildExecutor$executeMobileMemBuild$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryBuildExecutor$executeMobileMemBuild$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L11:
        return r15;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        CoroutineContext r16 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$logContext, this.$contextJson, this.$productType, this.$timeoutMs, this.$progressCallback, this.$taskInfoCallback, this.$taskCreatedCallback, null), Function2.class, "com.obric.memorydata.plugin");
        Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r15 = kotlinx.coroutines.i.a(r16, r2, r3);
        if (r15 != r0) goto L11;
        return r0;
    }
}
