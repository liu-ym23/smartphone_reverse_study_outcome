package com.obric.memorydata.aikernelcore;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.bytedance.crash.Ensure;
import com.obric.aikernel.core.data.IdlKeys;
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
@DebugMetadata(c = "com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$runImgEmbeddingByModel$2", f = "AiKernelRunModelCaller.kt", i = {0, 1, 1}, l = {359, 375}, m = "invokeSuspend", n = {"startTime", "ret", "startTime"}, s = {"J$0", "L$0", "J$0"})
final class AiKernelRunModelCaller$runImgEmbeddingByModel$2 extends SuspendLambda implements Function2<al, Continuation<? super float[]>, Object> {
    final /* synthetic */ String $foregroundCallerPkg;
    final /* synthetic */ Uri $img;
    final /* synthetic */ String $sourcePkg;
    final /* synthetic */ boolean $throwThermalStatusError;
    long J$0;
    Object L$0;
    int label;

    AiKernelRunModelCaller$runImgEmbeddingByModel$2(Uri r3, String r4, String r5, boolean r6, Continuation<? super AiKernelRunModelCaller$runImgEmbeddingByModel$2> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$img = r3;
        this.$foregroundCallerPkg = r4;
        this.$sourcePkg = r5;
        this.$throwThermalStatusError = r6;
        super(2, r8);
    }

    private static final Unit invokeSuspend$lambda$2(final JSONObject r1, RequestParams r2) {
        ParamsKt.setCustomArgs(r2, new $$Lambda$AiKernelRunModelCaller$runImgEmbeddingByModel$2$ApxOnjMFitAgUBNMWmNOSQaAHNo(r1));
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$2$lambda$1(JSONObject r3, Bundle r4) {
        r4.putAll(BundleExtKt.json2Bundle$default(r3, false, 2, null));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [T, float[]] */
    private static final Unit invokeSuspend$lambda$4(Ref.ObjectRef r0, boolean r1, Object r2, JSONObject r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.FloatArray");
        r0.element = (float[]) ZeusTransformUtils.preCheckCast(r2, float[].class, "com.obric.memorydata.plugin");
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$5(boolean r7, int r8, String r9, JSONObject r10) {
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "img embedding error: " + r8 + ", " + r9, null, 4, null);
        a.b().remove("clip_image_embedding_v2_edge");
        if (r7 == false) goto L10;
        if (a.a(a.INSTANCE, Integer.valueOf(r8)) == false) goto L10;
        throw new AIKernelRunModelException(a.a(a.INSTANCE, Integer.valueOf(r8), r10));
    L10:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$0aush_tZ_Y6-8G-5cDU3aQJ6ksY, reason: not valid java name */
    public static /* synthetic */ Unit m450lambda$0aush_tZ_Y68G5cDU3aQJ6ksY(boolean r0, int r1, String r2, JSONObject r3) {
        return invokeSuspend$lambda$5(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$61_5EUOx9ZdeNooeQ9WaAwRBzH0(Ref.ObjectRef r0, boolean r1, Object r2, JSONObject r3) {
        return invokeSuspend$lambda$4(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$AZXVMRBF21qO-mq77MQZKN1ziRk, reason: not valid java name */
    public static /* synthetic */ Unit m451lambda$AZXVMRBF21qOmq77MQZKN1ziRk(JSONObject r0, RequestParams r1) {
        return invokeSuspend$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit lambda$ApxOnjMFitAgUBNMWmNOSQaAHNo(JSONObject r0, Bundle r1) {
        return invokeSuspend$lambda$2$lambda$1(r0, r1);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$runImgEmbeddingByModel$2(this.$img, this.$foregroundCallerPkg, this.$sourcePkg, this.$throwThermalStatusError, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super float[]> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super float[]> r4) {
        return ((AiKernelRunModelCaller$runImgEmbeddingByModel$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AiKernelRunModelCaller$runImgEmbeddingByModel$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        long r2 = this.J$0;
        final Ref.ObjectRef r3 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
    L31:
        Intrinsics.checkNotNull(r12);
        Response r13 = ResponseKt.ok((Response) ZeusTransformUtils.preCheckCast(r12, Response.class, "com.obric.memorydata.plugin"), new $$Lambda$AiKernelRunModelCaller$runImgEmbeddingByModel$2$61_5EUOx9ZdeNooeQ9WaAwRBzH0(r3));
        final boolean r11 = this.$throwThermalStatusError;
        ResponseKt.fail(r13, new $$Lambda$AiKernelRunModelCaller$runImgEmbeddingByModel$2$0aush_tZ_Y68G5cDU3aQJ6ksY(r11));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "clip_image_embedding_v2_edge cost: " + (System.currentTimeMillis() - r2) + "ms", false, 4, null);
        Log.i("AiKernelRunModelCaller", "clip_image_embedding_v2_edge cost: " + (System.currentTimeMillis() - r2) + "ms");
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
        a.b(r14);
        final JSONObject r8 = new JSONObject();
        Uri r9 = this.$img;
        String r10 = this.$foregroundCallerPkg;
        r8.put(Params.FILE_PATH, r9.toString());
        r8.put(IdlKeys.ModelMethodName, "getEmbedding");
        a.INSTANCE.a(r8, r10);
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        RequestParams r16 = new RequestParams(null, new $$Lambda$AiKernelRunModelCaller$runImgEmbeddingByModel$2$AZXVMRBF21qOmq77MQZKN1ziRk(r8), 1, null);
        String r4 = this.$sourcePkg;
        Uri r17 = this.$img;
        if (r4 != null) goto L25;
    L27:
        Continuation<? super Response<Object>> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r15;
        this.J$0 = r5;
        this.label = 2;
        r12 = r14.infer(r16, r6);
        if (r12 != r0) goto L30;
        return r0;
    L30:
        r2 = r5;
        r3 = r15;
        goto L31
    L25:
        if (a.a(a.INSTANCE, r4, r17, r16) == true) goto L27;
        return null;
    L10:
        ResultKt.throwOnFailure(r12);
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L33;
        r5 = System.currentTimeMillis();
        if (a.c() != null) goto L18;
        a r18 = a.INSTANCE;
        Continuation r19 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.J$0 = r5;
        this.label = 1;
        r12 = a.a(r18, "clip_image_embedding_v2_edge", r19);
        if (r12 != r0) goto L17;
        return r0;
    L18:
        r14 = a.c();
        goto L20
    L33:
        Ensure.ensureNotReachHere("runImgEmbeddingByModel called when AIKernel not available");
        throw new RuntimeException("runImgEmbeddingByModel called when AIKernel not available");
    }
}
