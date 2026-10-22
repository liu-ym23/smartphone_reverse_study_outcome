package com.obric.memorydata.memory.ui.automemory.create;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.ss.bduploader.BDNetworkSpeedTest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCollectionAiTaskQueue$runAlgoTask$3", f = "AutoMemoryCollectionAiTaskQueue.kt", i = {}, l = {BDNetworkSpeedTest.KeyIsIntelligentTestResult}, m = "invokeSuspend", n = {}, s = {})
final class AutoMemoryCollectionAiTaskQueue$runAlgoTask$3 extends SuspendLambda implements Function2<al, Continuation<? super JSONObject>, Object> {
    final /* synthetic */ Function1<TaskRequest.Builder, TaskRequest.Builder> $configure;
    final /* synthetic */ JSONObject $input;
    final /* synthetic */ String $name;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class a implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TaskRequest f10621a;

        a(TaskRequest r1) {
            this.f10621a = r1;
        }

        public final void a(Throwable r1) {
            this.f10621a.cancel();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/ui/automemory/create/AutoMemoryCollectionAiTaskQueue$runAlgoTask$3$1$builder$1", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.task.scheduler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f10622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ n<JSONObject> f10623b;
        final /* synthetic */ String c;
        final /* synthetic */ JSONObject d;

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f10624a = null;

            static {
                int[] r0 = new int[TaskInfo.State.values().length];
                r0[TaskInfo.State.SUCCEEDED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[TaskInfo.State.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[TaskInfo.State.TIMEOUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[TaskInfo.State.CANCELLED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                f10624a = r0;
            }
        }

        b(AtomicBoolean r3, n<? super JSONObject> r4, String r5, JSONObject r6) {
            n<JSONObject> r7 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin");
            this.f10622a = r3;
            this.f10623b = r7;
            this.c = r5;
            this.d = r6;
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r12) {
            Intrinsics.checkNotNullParameter(r12, "taskInfo");
            int r0 = a.f10624a[r12.c().ordinal()];
            if (r0 == 1) goto L17;
            if (r0 == 2) goto L12;
            if (r0 == 3) goto L12;
            if (r0 == 4) goto L12;
            return;
        L12:
            if (this.f10622a.compareAndSet(false, true) == true) goto L14;
            return;
        L14:
            if (this.f10623b.a() == false) goto L23;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryCollectionAiTaskQueue", "algoTask fail,algo_name:" + this.c + ",params:" + this.d, false, 4, null);
            Continuation r1 = (Continuation) ZeusTransformUtils.preCheckCast(this.f10623b, Continuation.class, "com.obric.memorydata.plugin");
            Result.Companion r2 = Result.Companion;
            r1.resumeWith(Result.m1421constructorimpl(ResultKt.createFailure((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException("task " + this.c + ' ' + r12.c()), Throwable.class, "com.obric.memorydata.plugin"))));
            return;
        L23:
            return;
        L17:
            if (this.f10622a.compareAndSet(false, true) == true) goto L19;
            return;
        L19:
            if (this.f10623b.a() == false) goto L26;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryCollectionAiTaskQueue", "algoTask success,algo_name:" + this.c + ",data:" + r12.d() + ",params:" + this.d, false, 4, null);
            Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(this.f10623b, Continuation.class, "com.obric.memorydata.plugin");
            Result.Companion r3 = Result.Companion;
            r11.resumeWith(Result.m1421constructorimpl(r12.d()));
            return;
        }
    }

    AutoMemoryCollectionAiTaskQueue$runAlgoTask$3(String r3, JSONObject r4, Function1<? super TaskRequest.Builder, ? extends TaskRequest.Builder> r5, Continuation<? super AutoMemoryCollectionAiTaskQueue$runAlgoTask$3> r6) {
        Function1<TaskRequest.Builder, TaskRequest.Builder> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$name = r3;
        this.$input = r4;
        this.$configure = r7;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionAiTaskQueue$runAlgoTask$3(this.$name, this.$input, this.$configure, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super JSONObject> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super JSONObject> r4) {
        return ((AutoMemoryCollectionAiTaskQueue$runAlgoTask$3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AutoMemoryCollectionAiTaskQueue$runAlgoTask$3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Function1 r2 = (Function1) ZeusTransformUtils.preCheckCast(this.L$2, Function1.class, "com.obric.memorydata.plugin");
        JSONObject r3 = (JSONObject) ZeusTransformUtils.preCheckCast(this.L$1, JSONObject.class, "com.obric.memorydata.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);
    L13:
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        String r14 = this.$name;
        JSONObject r4 = this.$input;
        Function1<TaskRequest.Builder, TaskRequest.Builder> r5 = this.$configure;
        this.L$0 = r14;
        this.L$1 = r4;
        this.L$2 = r5;
        this.label = 1;
        o r6 = new o(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin")), 1);
        r6.e();
        n r7 = (n) ZeusTransformUtils.preCheckCast(r6, n.class, "com.obric.memorydata.plugin");
        AtomicBoolean r8 = new AtomicBoolean(false);
        TaskRequest r15 = (TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r5.invoke((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(r14).setInputParam(r4), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTimeout(new com.obric.memorydata.task.impl.g(10, TimeUnit.SECONDS)), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new b(r8, r7, r14, r4), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin");
        r7.a((Function1) ZeusTransformUtils.preCheckCast(new a(r15), Function1.class, "com.obric.memorydata.plugin"));
        r15.enqueue();
        r13 = r6.h();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    L11:
        if (r13 != r0) goto L13;
        return r0;
    }
}
