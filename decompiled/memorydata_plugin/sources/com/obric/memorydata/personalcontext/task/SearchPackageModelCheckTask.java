package com.obric.memorydata.personalcontext.task;

import com.obric.memorydata.aikernelcore.h;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.q;
import com.obric.memorydata.personalcontext.util.EmbeddingState;
import com.obric.memorydata.personalcontext.util.c;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.impl.NativeTask;
import com.obric.memorydata.task.impl.TaskResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0002¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/personalcontext/task/SearchPackageModelCheckTask;", "Lcom/obric/memorydata/task/impl/NativeTask;", "taskRequest", "Lcom/obric/memorydata/task/AbsTaskRequest;", "<init>", "(Lcom/obric/memorydata/task/AbsTaskRequest;)V", "run", "Lcom/obric/memorydata/task/impl/TaskResult;", "checkPackageModelReady", "", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SearchPackageModelCheckTask extends NativeTask {
    public static final a Companion = null;
    public static final String NAME = "SearchPackageModelCheckTask";
    public static final String TAG = "SearchPackageModelCheckTask";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/personalcontext/task/SearchPackageModelCheckTask$Companion;", "", "<init>", "()V", "NAME", "", "TAG", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.task.SearchPackageModelCheckTask$checkPackageModelReady$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.personalcontext.task.SearchPackageModelCheckTask$checkPackageModelReady$1", f = "SearchPackageModelCheckTask.kt", i = {}, l = {35, 41, 45, 48}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
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
        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r5 = true;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 != 4) goto L10;
            ResultKt.throwOnFailure(r15);
        L42:
            Unit r14 = Unit.INSTANCE;
        L44:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r15);
            goto L44
        L12:
            Iterator r2 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$0, Iterator.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r15);
        L24:
            if (r2.hasNext() == false) goto L29;
            String r8 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
            h r7 = h.f8481a;
            this.L$0 = r2;
            this.label = 2;
            if (h.a(r7, r8, true, null, this, 4, null) != r0) goto L24;
            return r0;
        L29:
            if (c.f12363a.b() == EmbeddingState.USE_VLM) goto L33;
            r5 = false;
        L33:
            if (r5 == true) goto L38;
            com.obric.memorydata.aikernelcore.a r9 = com.obric.memorydata.aikernelcore.a.INSTANCE;
            Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(q.f12255a.o(), Collection.class, "com.obric.memorydata.plugin");
            Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.label = 3;
            if (com.obric.memorydata.aikernelcore.a.a(r9, r10, null, r11, 2, null) != r0) goto L44;
            return r0;
        L38:
            if (DeviceInfoState.INSTANCE.isSupportVLM() == false) goto L42;
            com.obric.memorydata.aikernelcore.a r12 = com.obric.memorydata.aikernelcore.a.INSTANCE;
            Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(q.f12255a.p(), Collection.class, "com.obric.memorydata.plugin");
            Continuation r16 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.label = 4;
            if (com.obric.memorydata.aikernelcore.a.b(r12, r13, null, r16, 2, null) != r0) goto L42;
            return r0;
        L13:
            Iterator r3 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$0, Iterator.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r15);
        L16:
            if (r3.hasNext() == false) goto L21;
            String r17 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
            h r18 = h.f8481a;
            this.L$0 = r3;
            this.label = 1;
            if (h.a(r18, r17, false, null, this, 4, null) != r0) goto L16;
            return r0;
        L21:
            if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L44;
            r2 = ((Iterable) ZeusTransformUtils.preCheckCast(q.f12255a.q(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
            goto L24
        L14:
            ResultKt.throwOnFailure(r15);
            r3 = ((Iterable) ZeusTransformUtils.preCheckCast(q.f12255a.n(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
            goto L16
        }
    }

    static {
        Companion = new a(null);
    }

    public SearchPackageModelCheckTask(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "taskRequest");
        super(r2);
    }

    private final void checkPackageModelReady() {
        RunLog.INSTANCE.debug("SearchPackageModelCheckTask", "checkPackageModelReady");
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    @Override // com.obric.memorydata.task.AbsTask
    public TaskResult run() {
        checkPackageModelReady();
        return new TaskResult(0, null, null, null, 14, null);
    }
}
