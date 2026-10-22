package com.obric.memorydata.aikernelcore;

import android.os.Bundle;
import android.util.Log;
import com.bytedance.crash.Ensure;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.aikernel.sdk.ext.ParamsKt;
import com.obric.aikernel.sdk.response.Response;
import com.obric.aikernel.sdk.response.ResponseKt;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0014\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$textEmbeddingToVectorByModel$2", f = "AiKernelRunModelCaller.kt", i = {0, 1, 1}, l = {237, 251}, m = "invokeSuspend", n = {"startTime", "result", "startTime"}, s = {"J$0", "L$0", "J$0"})
final class AiKernelRunModelCaller$textEmbeddingToVectorByModel$2 extends SuspendLambda implements Function2<al, Continuation<? super float[]>, Object> {
    final /* synthetic */ String $foregroundCallerPkg;
    final /* synthetic */ String $sentence;
    final /* synthetic */ boolean $throwThermalStatusError;
    long J$0;
    Object L$0;
    int label;

    AiKernelRunModelCaller$textEmbeddingToVectorByModel$2(String r3, String r4, boolean r5, Continuation<? super AiKernelRunModelCaller$textEmbeddingToVectorByModel$2> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$sentence = r3;
        this.$foregroundCallerPkg = r4;
        this.$throwThermalStatusError = r5;
        super(2, r7);
    }

    private static final Unit invokeSuspend$lambda$1(final JSONObject r1, RequestParams r2) {
        ParamsKt.setCustomArgs(r2, new $$Lambda$AiKernelRunModelCaller$textEmbeddingToVectorByModel$2$xnF6rIqb7G7nad8YugvA284QwdA(r1));
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$1$lambda$0(JSONObject r3, Bundle r4) {
        r4.putAll(BundleExtKt.json2Bundle$default(r3, false, 2, null));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r9v4, types: [T, float[]] */
    private static final Unit invokeSuspend$lambda$2(Ref.ObjectRef r6, long r7, boolean r9, Object r10, JSONObject r11) {
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.FloatArray");
        r6.element = (float[]) ZeusTransformUtils.preCheckCast(r10, float[].class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "memory_text_embedding_v2 cost: " + (System.currentTimeMillis() - r7) + "ms", false, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$3(boolean r7, int r8, String r9, JSONObject r10) {
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "text embedding error: " + r8 + ", " + r9, null, 4, null);
        a.b().remove("memory_text_embedding_v2");
        if (r7 == false) goto L10;
        if (a.a(a.INSTANCE, Integer.valueOf(r8)) == false) goto L10;
        throw new AIKernelRunModelException(a.a(a.INSTANCE, Integer.valueOf(r8), r10));
    L10:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$Jnf3nBNVqKFCTPega1shdVVErM0(JSONObject r0, RequestParams r1) {
        return invokeSuspend$lambda$1(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$wk-Zjlh2PQNpxr0PQNk8HwaOk6E, reason: not valid java name */
    public static /* synthetic */ Unit m452lambda$wkZjlh2PQNpxr0PQNk8HwaOk6E(boolean r0, int r1, String r2, JSONObject r3) {
        return invokeSuspend$lambda$3(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$wrk9ZAOsdrEKFmNckvHL6_MEnaQ(Ref.ObjectRef r0, long r1, boolean r3, Object r4, JSONObject r5) {
        return invokeSuspend$lambda$2(r0, r1, r3, r4, r5);
    }

    public static /* synthetic */ Unit lambda$xnF6rIqb7G7nad8YugvA284QwdA(JSONObject r0, Bundle r1) {
        return invokeSuspend$lambda$1$lambda$0(r0, r1);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$textEmbeddingToVectorByModel$2(this.$sentence, this.$foregroundCallerPkg, this.$throwThermalStatusError, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super float[]> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super float[]> r4) {
        return ((AiKernelRunModelCaller$textEmbeddingToVectorByModel$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AiKernelRunModelCaller$textEmbeddingToVectorByModel$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        final long r2 = this.J$0;
        final Ref.ObjectRef r3 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
    L26:
        Intrinsics.checkNotNull(r12);
        Response r13 = ResponseKt.ok((Response) ZeusTransformUtils.preCheckCast(r12, Response.class, "com.obric.memorydata.plugin"), new $$Lambda$AiKernelRunModelCaller$textEmbeddingToVectorByModel$2$wrk9ZAOsdrEKFmNckvHL6_MEnaQ(r3, r2));
        final boolean r11 = this.$throwThermalStatusError;
        ResponseKt.fail(r13, new $$Lambda$AiKernelRunModelCaller$textEmbeddingToVectorByModel$2$wkZjlh2PQNpxr0PQNk8HwaOk6E(r11));
        Log.i("AiKernelRunModelCaller", "memory_text_embedding_v2 cost: " + (System.currentTimeMillis() - r2) + "ms");
        return r3.element;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        long r5 = this.J$0;
        ResultKt.throwOnFailure(r12);
    L17:
        IBaseModel r14 = (IBaseModel) ZeusTransformUtils.preCheckCast(r12, IBaseModel.class, "com.obric.memorydata.plugin");
    L20:
        if (r14 != null) goto L22;
        return null;
    L22:
        a r7 = a.INSTANCE;
        a.a(r14);
        final JSONObject r8 = new JSONObject();
        r8.put(Params.CONTENT, this.$sentence);
        a.INSTANCE.a(r8, this.$foregroundCallerPkg);
        Ref.ObjectRef r9 = new Ref.ObjectRef();
        RequestParams r10 = new RequestParams(null, new $$Lambda$AiKernelRunModelCaller$textEmbeddingToVectorByModel$2$Jnf3nBNVqKFCTPega1shdVVErM0(r8), 1, null);
        Continuation<? super Response<Object>> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r9;
        this.J$0 = r5;
        this.label = 2;
        r12 = r14.infer(r10, r4);
        if (r12 != r0) goto L25;
        return r0;
    L25:
        r2 = r5;
        r3 = r9;
        goto L26
    L10:
        ResultKt.throwOnFailure(r12);
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L28;
        r5 = System.currentTimeMillis();
        if (a.a() != null) goto L18;
        a r15 = a.INSTANCE;
        Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.J$0 = r5;
        this.label = 1;
        r12 = a.a(r15, "memory_text_embedding_v2", r6);
        if (r12 != r0) goto L17;
        return r0;
    L18:
        r14 = a.a();
        goto L20
    L28:
        Ensure.ensureNotReachHere("textEmbeddingToVectorByModel called when AIKernel not available or not support VLM");
        throw new RuntimeException("textEmbeddingToVectorByModel called when AIKernel not available or not support VLM");
    }
}
