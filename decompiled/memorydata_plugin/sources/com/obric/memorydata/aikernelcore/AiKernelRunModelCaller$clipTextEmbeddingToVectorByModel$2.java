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
@DebugMetadata(c = "com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$clipTextEmbeddingToVectorByModel$2", f = "AiKernelRunModelCaller.kt", i = {0, 1, 1}, l = {758, 772}, m = "invokeSuspend", n = {"startTime", "result", "startTime"}, s = {"J$0", "L$0", "J$0"})
final class AiKernelRunModelCaller$clipTextEmbeddingToVectorByModel$2 extends SuspendLambda implements Function2<al, Continuation<? super float[]>, Object> {
    final /* synthetic */ String $foregroundCallerPkg;
    final /* synthetic */ String $sentence;
    long J$0;
    Object L$0;
    int label;

    AiKernelRunModelCaller$clipTextEmbeddingToVectorByModel$2(String r3, String r4, Continuation<? super AiKernelRunModelCaller$clipTextEmbeddingToVectorByModel$2> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$sentence = r3;
        this.$foregroundCallerPkg = r4;
        super(2, r6);
    }

    private static final Unit invokeSuspend$lambda$1(final JSONObject r1, RequestParams r2) {
        ParamsKt.setCustomArgs(r2, new $$Lambda$AiKernelRunModelCaller$clipTextEmbeddingToVectorByModel$2$kDkykZWaTDnr3W6gsqtDnnmPvEM(r1));
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
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "clip_text_embedding_v2_edge cost: " + (System.currentTimeMillis() - r7) + "ms", false, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$3(int r6, String r7, JSONObject r8) {
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "clip text embedding error: " + r6 + ", " + r7, null, 4, null);
        a.b().remove("clip_text_embedding_v2_edge");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$IGK0JaxnDexFVv77y3DZyd3cSV8(JSONObject r0, RequestParams r1) {
        return invokeSuspend$lambda$1(r0, r1);
    }

    public static /* synthetic */ Unit lambda$dakjKT4Gip8kIQwzbA8vhtnG7nQ(Ref.ObjectRef r0, long r1, boolean r3, Object r4, JSONObject r5) {
        return invokeSuspend$lambda$2(r0, r1, r3, r4, r5);
    }

    public static /* synthetic */ Unit lambda$kDkykZWaTDnr3W6gsqtDnnmPvEM(JSONObject r0, Bundle r1) {
        return invokeSuspend$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit lambda$yrRObLz9DogSj8g9y6H4iN7v4Tg(int r0, String r1, JSONObject r2) {
        return invokeSuspend$lambda$3(r0, r1, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$clipTextEmbeddingToVectorByModel$2(this.$sentence, this.$foregroundCallerPkg, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super float[]> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super float[]> r4) {
        return ((AiKernelRunModelCaller$clipTextEmbeddingToVectorByModel$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AiKernelRunModelCaller$clipTextEmbeddingToVectorByModel$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        final long r2 = this.J$0;
        final Ref.ObjectRef r11 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
    L26:
        Intrinsics.checkNotNull(r12);
        ResponseKt.fail(ResponseKt.ok((Response) ZeusTransformUtils.preCheckCast(r12, Response.class, "com.obric.memorydata.plugin"), new $$Lambda$AiKernelRunModelCaller$clipTextEmbeddingToVectorByModel$2$dakjKT4Gip8kIQwzbA8vhtnG7nQ(r11, r2)), $$Lambda$AiKernelRunModelCaller$clipTextEmbeddingToVectorByModel$2$yrRObLz9DogSj8g9y6H4iN7v4Tg.INSTANCE);
        Log.i("AiKernelRunModelCaller", "clip_text_embedding_v2_edge cost: " + (System.currentTimeMillis() - r2) + "ms");
        return r11.element;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        long r5 = this.J$0;
        ResultKt.throwOnFailure(r12);
    L17:
        IBaseModel r13 = (IBaseModel) ZeusTransformUtils.preCheckCast(r12, IBaseModel.class, "com.obric.memorydata.plugin");
    L20:
        if (r13 != null) goto L22;
        return null;
    L22:
        a r7 = a.INSTANCE;
        a.d(r13);
        final JSONObject r8 = new JSONObject();
        r8.put(Params.CONTENT, this.$sentence);
        a.INSTANCE.a(r8, this.$foregroundCallerPkg);
        Ref.ObjectRef r9 = new Ref.ObjectRef();
        RequestParams r10 = new RequestParams(null, new $$Lambda$AiKernelRunModelCaller$clipTextEmbeddingToVectorByModel$2$IGK0JaxnDexFVv77y3DZyd3cSV8(r8), 1, null);
        Continuation<? super Response<Object>> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r9;
        this.J$0 = r5;
        this.label = 2;
        r12 = r13.infer(r10, r3);
        if (r12 != r0) goto L25;
        return r0;
    L25:
        r2 = r5;
        r11 = r9;
        goto L26
    L10:
        ResultKt.throwOnFailure(r12);
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L28;
        r5 = System.currentTimeMillis();
        if (a.e() != null) goto L18;
        a r14 = a.INSTANCE;
        Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.J$0 = r5;
        this.label = 1;
        r12 = a.a(r14, "clip_text_embedding_v2_edge", r4);
        if (r12 != r0) goto L17;
        return r0;
    L18:
        r13 = a.e();
        goto L20
    L28:
        Ensure.ensureNotReachHere("clipTextEmbeddingToVector called when AIKernel not available");
        throw new RuntimeException("clipTextEmbeddingToVector called when AIKernel not available");
    }
}
