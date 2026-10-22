package com.obric.memorydata.aikernelcore;

import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.flow.k;
import kotlinx.coroutines.n;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$loadAiKernelPackage$2$1", f = "AiKernelRunModelCaller.kt", i = {}, l = {835}, m = "invokeSuspend", n = {}, s = {})
final class AiKernelRunModelCaller$loadAiKernelPackage$2$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ n<IBaseModel> $continuation;
    final /* synthetic */ String $name;
    final /* synthetic */ RequestParams $params;
    final /* synthetic */ long $timeoutMs;
    final /* synthetic */ boolean $useCloud;
    int label;

    /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$loadAiKernelPackage$2$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/obric/aikernel/phx/sdk/api/IBaseModel;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$loadAiKernelPackage$2$1$1", f = "AiKernelRunModelCaller.kt", i = {0, 2}, l = {803, 809, 814, 819, 825}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<j<? super IBaseModel>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $name;
        final /* synthetic */ RequestParams $params;
        final /* synthetic */ boolean $useCloud;
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(String r3, RequestParams r4, boolean r5, Continuation<? super AnonymousClass1> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$name = r3;
            this.$params = r4;
            this.$useCloud = r5;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r0 = new AnonymousClass1(this.$name, this.$params, this.$useCloud, r7);
            r0.L$0 = r5;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(j<? super IBaseModel> r3, Continuation<? super Unit> r4) {
            return invoke2((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(j<? super IBaseModel> r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r18) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L16;
            if (r2 == 1) goto L15;
            if (r2 == 2) goto L14;
            if (r2 == 3) goto L13;
            if (r2 == 4) goto L12;
            if (r2 == 5) goto L12;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r18);
        L41:
            return Unit.INSTANCE;
        L13:
            j r3 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r18);
            Object r4 = r18;
        L34:
            IBaseModel r5 = (IBaseModel) ZeusTransformUtils.preCheckCast(r4, IBaseModel.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.label = 4;
            if (r3.emit(r5, r6) != r1) goto L41;
            return r1;
        L14:
            ResultKt.throwOnFailure(r18);
        L28:
            return Unit.INSTANCE;
        L15:
            r3 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r18);
            Object r7 = ((Result) ZeusTransformUtils.preCheckCast(r18, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
        L20:
            if (Result.m1427isFailureimpl(r7) == false) goto L22;
            r7 = null;
        L22:
            PackageResource r8 = (PackageResource) ZeusTransformUtils.preCheckCast(r7, PackageResource.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L30;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "loadAiKernelPackage getPackage is null, package: " + this.$name + ", params: " + this.$params, null, 4, null);
            Continuation<? super Unit> r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.label = 2;
            if (r3.emit(null, r9) != r1) goto L28;
            return r1;
        L30:
            if (r8.isAvailable() == false) goto L37;
            AIKernelManager r10 = AIKernelManager.INSTANCE;
            String r11 = this.$name;
            boolean r12 = this.$useCloud;
            RequestParams r13 = this.$params;
            Continuation<? super IBaseModel> r14 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r3;
            this.label = 3;
            r4 = r10.loadPackage(r11, r12, r13, r14);
            if (r4 != r1) goto L34;
            return r1;
        L37:
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "loadAiKernelPackage is not available, package: " + this.$name + ", params: " + this.$params, null, 4, null);
            Continuation<? super Unit> r15 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.label = 5;
            if (r3.emit(null, r15) != r1) goto L41;
            return r1;
        L16:
            ResultKt.throwOnFailure(r18);
            r3 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
            AIKernelManager r16 = AIKernelManager.INSTANCE;
            String r17 = this.$name;
            RequestParams r19 = this.$params;
            Continuation<? super Result<PackageResource>> r110 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r3;
            this.label = 1;
            r7 = r16.mo188getPackage0E7RQCE(r17, r19, r110);
            if (r7 != r1) goto L20;
            return r1;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$loadAiKernelPackage$2$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/obric/aikernel/phx/sdk/api/IBaseModel;", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$loadAiKernelPackage$2$1$2", f = "AiKernelRunModelCaller.kt", i = {}, l = {832}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function3<j<? super IBaseModel>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> r3) {
            super(3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.jvm.functions.Function3
        public /* synthetic */ Object invoke(j<? super IBaseModel> r3, Throwable r4, Continuation<? super Unit> r5) {
            return invoke2((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(j<? super IBaseModel> r2, Throwable r3, Continuation<? super Unit> r4) {
            j r1 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.memorydata.plugin");
            AnonymousClass2 r5 = new AnonymousClass2((Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
            r5.L$0 = r1;
            r5.L$1 = r3;
            return r5.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            j r13 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
            Throwable r2 = (Throwable) ZeusTransformUtils.preCheckCast(this.L$1, Throwable.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r2, TimeoutCancellationException.class) == false) goto L14;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "loadAiKernelPackage setupEnvWithTimeOut exception: " + r2, null, 4, null);
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.label = 1;
            if (r13.emit(null, r3) != r0) goto L14;
            return r0;
        }
    }

    AiKernelRunModelCaller$loadAiKernelPackage$2$1(long r3, String r5, RequestParams r6, boolean r7, n<? super IBaseModel> r8, Continuation<? super AiKernelRunModelCaller$loadAiKernelPackage$2$1> r9) {
        n<IBaseModel> r10 = (n) ZeusTransformUtils.wrapperContextForParams(r8, n.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.$timeoutMs = r3;
        this.$name = r5;
        this.$params = r6;
        this.$useCloud = r7;
        this.$continuation = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$loadAiKernelPackage$2$1(this.$timeoutMs, this.$name, this.$params, this.$useCloud, this.$continuation, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((AiKernelRunModelCaller$loadAiKernelPackage$2$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AiKernelRunModelCaller$loadAiKernelPackage$2$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        i r10 = k.a((Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$name, this.$params, this.$useCloud, null), Function2.class, "com.obric.memorydata.plugin"));
        Duration.Companion r2 = Duration.Companion;
        i r11 = k.b(k.c(r10, DurationKt.toDuration(this.$timeoutMs, DurationUnit.MILLISECONDS)), (Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass2(null), Function3.class, "com.obric.memorydata.plugin"));
        final n<IBaseModel> r4 = this.$continuation;
        j r3 = (j) ZeusTransformUtils.preCheckCast(new AnonymousClass3(r4), j.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r11.collect(r3, r5) != r0) goto L12;
        return r0;
    }
}
