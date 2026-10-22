package com.obric.memorydata.aikernelcore;

import android.net.Uri;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.response.Response;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.n;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$runLocalVlmJob$2$result$1$1", f = "AiKernelRunModelCaller.kt", i = {}, l = {570, 570}, m = "invokeSuspend", n = {}, s = {})
final class AiKernelRunModelCaller$runLocalVlmJob$2$result$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ n<a.C0425a<String>> $continuation;
    final /* synthetic */ Uri $img;
    final /* synthetic */ String $lora;
    final /* synthetic */ IBaseModel $model;
    final /* synthetic */ RequestParams $requestParams;
    final /* synthetic */ Ref.BooleanRef $resumed;
    final /* synthetic */ Ref.ObjectRef<String> $ret;
    final /* synthetic */ long $startTime;
    int label;

    AiKernelRunModelCaller$runLocalVlmJob$2$result$1$1(IBaseModel r3, RequestParams r4, Ref.ObjectRef<String> r5, String r6, Uri r7, long r8, Ref.BooleanRef r10, n<? super a.C0425a<String>> r11, Continuation<? super AiKernelRunModelCaller$runLocalVlmJob$2$result$1$1> r12) {
        IBaseModel r9 = (IBaseModel) ZeusTransformUtils.wrapperContextForParams(r3, IBaseModel.class, "com.obric.memorydata.plugin");
        n<a.C0425a<String>> r13 = (n) ZeusTransformUtils.wrapperContextForParams(r11, n.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        this.$model = r9;
        this.$requestParams = r4;
        this.$ret = r5;
        this.$lora = r6;
        this.$img = r7;
        this.$startTime = r8;
        this.$resumed = r10;
        this.$continuation = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$runLocalVlmJob$2$result$1$1(this.$model, this.$requestParams, this.$ret, this.$lora, this.$img, this.$startTime, this.$resumed, this.$continuation, r11), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((AiKernelRunModelCaller$runLocalVlmJob$2$result$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AiKernelRunModelCaller$runLocalVlmJob$2$result$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L19:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
    L13:
        i r15 = (i) ZeusTransformUtils.preCheckCast(r14, i.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L19;
        final Ref.ObjectRef<String> r6 = this.$ret;
        final String r7 = this.$lora;
        final Uri r8 = this.$img;
        final long r9 = this.$startTime;
        final Ref.BooleanRef r11 = this.$resumed;
        final n<a.C0425a<String>> r12 = this.$continuation;
        j r2 = (j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, r7, r8, r9, r11, r12), j.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 2;
        if (r15.collect(r2, r3) != r0) goto L19;
        return r0;
    L10:
        ResultKt.throwOnFailure(r14);
        IBaseModel r16 = this.$model;
        RequestParams r4 = this.$requestParams;
        Continuation<? super i<Response<Object>>> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r14 = r16.inferAsFlow(r4, r5);
        if (r14 != r0) goto L13;
        return r0;
    }
}
