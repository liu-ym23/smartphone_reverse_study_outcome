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
@DebugMetadata(c = "com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$runCLIP4ClipEmbeddingByModel$2", f = "AiKernelRunModelCaller.kt", i = {0, 1, 1}, l = {683, 699}, m = "invokeSuspend", n = {"startTime", "ret", "startTime"}, s = {"J$0", "L$0", "J$0"})
final class AiKernelRunModelCaller$runCLIP4ClipEmbeddingByModel$2 extends SuspendLambda implements Function2<al, Continuation<? super float[]>, Object> {
    final /* synthetic */ String $foregroundCallerPkg;
    final /* synthetic */ Uri $img;
    final /* synthetic */ String $packageName;
    final /* synthetic */ boolean $throwThermalStatusError;
    long J$0;
    Object L$0;
    int label;

    AiKernelRunModelCaller$runCLIP4ClipEmbeddingByModel$2(Uri r3, String r4, String r5, boolean r6, Continuation<? super AiKernelRunModelCaller$runCLIP4ClipEmbeddingByModel$2> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$img = r3;
        this.$foregroundCallerPkg = r4;
        this.$packageName = r5;
        this.$throwThermalStatusError = r6;
        super(2, r8);
    }

    private static final Unit invokeSuspend$lambda$2(final JSONObject r1, RequestParams r2) {
        ParamsKt.setCustomArgs(r2, new $$Lambda$AiKernelRunModelCaller$runCLIP4ClipEmbeddingByModel$2$ne4LU1IPzdZ6Y39SnkmfBbfSzKk(r1));
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
        a.b().remove("video_clip");
        if (r7 == false) goto L10;
        if (a.a(a.INSTANCE, Integer.valueOf(r8)) == false) goto L10;
        throw new AIKernelRunModelException(a.a(a.INSTANCE, Integer.valueOf(r8), r10));
    L10:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$1iqojXBRbfVcM0ovk-UupTtNU40, reason: not valid java name */
    public static /* synthetic */ Unit m447lambda$1iqojXBRbfVcM0ovkUupTtNU40(JSONObject r0, RequestParams r1) {
        return invokeSuspend$lambda$2(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$egDYmjm4nFQhgG49VMsR9F-NvHc, reason: not valid java name */
    public static /* synthetic */ Unit m448lambda$egDYmjm4nFQhgG49VMsR9FNvHc(boolean r0, int r1, String r2, JSONObject r3) {
        return invokeSuspend$lambda$5(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$iDWqaAnW1V30vWWiRCM_RzTHnqU(Ref.ObjectRef r0, boolean r1, Object r2, JSONObject r3) {
        return invokeSuspend$lambda$4(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$ne4LU1IPzdZ6Y39SnkmfBbfSzKk(JSONObject r0, Bundle r1) {
        return invokeSuspend$lambda$2$lambda$1(r0, r1);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$runCLIP4ClipEmbeddingByModel$2(this.$img, this.$foregroundCallerPkg, this.$packageName, this.$throwThermalStatusError, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super float[]> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super float[]> r4) {
        return ((AiKernelRunModelCaller$runCLIP4ClipEmbeddingByModel$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AiKernelRunModelCaller$runCLIP4ClipEmbeddingByModel$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        long r2 = this.J$0;
        final Ref.ObjectRef r4 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);
    L34:
        Intrinsics.checkNotNull(r13);
        Response r14 = ResponseKt.ok((Response) ZeusTransformUtils.preCheckCast(r13, Response.class, "com.obric.memorydata.plugin"), new $$Lambda$AiKernelRunModelCaller$runCLIP4ClipEmbeddingByModel$2$iDWqaAnW1V30vWWiRCM_RzTHnqU(r4));
        final boolean r12 = this.$throwThermalStatusError;
        ResponseKt.fail(r14, new $$Lambda$AiKernelRunModelCaller$runCLIP4ClipEmbeddingByModel$2$egDYmjm4nFQhgG49VMsR9FNvHc(r12));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "video_clip cost: " + (System.currentTimeMillis() - r2) + "ms", false, 4, null);
        Log.i("AiKernelRunModelCaller", "video_clip cost: " + (System.currentTimeMillis() - r2) + "ms");
        return r4.element;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        long r5 = this.J$0;
        ResultKt.throwOnFailure(r13);
    L17:
        IBaseModel r15 = (IBaseModel) ZeusTransformUtils.preCheckCast(r13, IBaseModel.class, "com.obric.memorydata.plugin");
    L20:
        if (r15 != null) goto L22;
        return null;
    L22:
        a r7 = a.INSTANCE;
        a.c(r15);
        final JSONObject r8 = new JSONObject();
        Uri r9 = this.$img;
        String r10 = this.$foregroundCallerPkg;
        r8.put(Params.FILE_PATH, r9.toString());
        r8.put(IdlKeys.ModelMethodName, "getEmbedding");
        a.INSTANCE.a(r8, r10);
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        RequestParams r16 = new RequestParams(null, new $$Lambda$AiKernelRunModelCaller$runCLIP4ClipEmbeddingByModel$2$1iqojXBRbfVcM0ovkUupTtNU40(r8), 1, null);
        String r17 = this.$packageName;
        Uri r18 = this.$img;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L26;
        r3 = false;
    L26:
        if (r3 == true) goto L28;
    L30:
        Continuation<? super Response<Object>> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r11;
        this.J$0 = r5;
        this.label = 2;
        r13 = r15.infer(r16, r6);
        if (r13 != r0) goto L33;
        return r0;
    L33:
        r2 = r5;
        r4 = r11;
        goto L34
    L28:
        if (a.a(a.INSTANCE, r17, r18, r16) == true) goto L30;
        return null;
    L10:
        ResultKt.throwOnFailure(r13);
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L36;
        r5 = System.currentTimeMillis();
        if (a.d() != null) goto L18;
        a r19 = a.INSTANCE;
        Continuation r20 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.J$0 = r5;
        this.label = 1;
        r13 = a.a(r19, "video_clip", r20);
        if (r13 != r0) goto L17;
        return r0;
    L18:
        r15 = a.d();
        goto L20
    L36:
        Ensure.ensureNotReachHere("runCLIP4ClipEmbeddingByModel called when AIKernel not available");
        throw new RuntimeException("runCLIP4ClipEmbeddingByModel called when AIKernel not available");
    }
}
