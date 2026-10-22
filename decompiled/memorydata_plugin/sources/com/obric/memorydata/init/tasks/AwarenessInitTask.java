package com.obric.memorydata.init.tasks;

import android.content.Context;
import com.bytedance.lego.init.model.IInitTask;
import com.obric.memorydata.awareness.cae.f;
import com.obric.memorydata.awareness.har.HarPredict;
import com.obric.memorydata.awareness.impl.h;
import com.obric.memorydata.awareness.impl.i;
import com.obric.memorydata.awareness.impl.j;
import com.obric.memorydata.awareness.persistent.g;
import com.obric.memorydata.awareness.task.RegisterFenceTask;
import com.obric.memorydata.awareness.task.UpdateHomeCompanyAddressTask;
import com.obric.memorydata.datatransport.api.DataTransportManagerApi;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.task.TaskRegister;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.cron.CronJobRunnerTask;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.obric.memorydata.utils.af;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/init/tasks/AwarenessInitTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "run", "", "initLocationReporting", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AwarenessInitTask extends IInitTask {

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u000e\u0010\u0004\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"com/obric/memorydata/init/tasks/AwarenessInitTask$run$2", "Lcom/obric/memorydata/datatransport/api/DataTransportExtension;", "getExportPath", "", "cleanData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.memorydata.datatransport.api.b {
        a() {
        }

        @Override // com.obric.memorydata.datatransport.api.b
        public Object a(Continuation<? super Boolean> r2) {
            Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin");
            return Boxing.boxBoolean(true);
        }

        @Override // com.obric.memorydata.datatransport.api.b
        public String a() {
            return new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "context_awareness_data").getAbsolutePath();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.init.tasks.AwarenessInitTask$run$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.init.tasks.AwarenessInitTask$run$1", f = "AwarenessInitTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AwarenessInitTask this$0;

        AnonymousClass1(AwarenessInitTask r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r5);
            com.obric.memorydata.awareness.ohr.b.f8759a.b();
            f.f8574a.a().d();
            HarPredict.f8604a.a().b();
            com.obric.memorydata.awareness.location.a.f8753a.b();
            h.f8691a.a();
            j.f8700a.a();
            ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(UpdateHomeCompanyAddressTask.NAME).setExistingTaskPolicy(ExistingTaskPolicy.KEEP_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setConditions(new Condition[]{Condition.NETWORK_AVAILABLE}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
            AwarenessInitTask.a(this.this$0);
            if (com.obric.memorydata.datatransport.api.c.a() != null) goto L8;
            FilesKt.deleteRecursively(new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "context_awareness_data"));
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AwarenessInitTask() {
    }

    private final void a() {
        if (DeviceInfoState.INSTANCE.isObricOsDevice() == false) goto L6;
        i.f8695a.a();
        return;
    }

    public static final /* synthetic */ void a(AwarenessInitTask r0) {
        r0.a();
    }

    @Override // java.lang.Runnable
    public void run() {
        af.f13160a.c();
        com.obric.memorydata.awareness.impl.a.f8618a.c();
        TaskRegister.f12863a.c(CronJobRunnerTask.TASK_NAME_PREFIX, CronJobRunnerTask.class);
        TaskRegister.f12863a.a("RegisterFenceTask", RegisterFenceTask.class);
        TaskRegister.f12863a.a(UpdateHomeCompanyAddressTask.NAME, UpdateHomeCompanyAddressTask.class);
        com.obric.memorydata.awareness.impl.cron.d.f8657a.a();
        g.f8772a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        DataTransportManagerApi r9 = com.obric.memorydata.datatransport.api.c.a();
        if (r9 == null) goto L6;
        r9.register((com.obric.memorydata.datatransport.api.b) ZeusTransformUtils.preCheckCast(new a(), com.obric.memorydata.datatransport.api.b.class, "com.obric.memorydata.plugin"));
        return;
    }
}
