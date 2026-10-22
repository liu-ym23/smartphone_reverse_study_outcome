package com.obric.memorydata.aikernelcore;

import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.Ensure;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.aikernel.sdk.response.Response;
import com.obric.aikernel.sdk.response.ResponseKt;
import com.obric.memorydata.aikernelcore.utils.DataConvert;
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
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0014\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$textEmbeddingToVectorByLora$2", f = "AiKernelRunModelCaller.kt", i = {0, 1, 1, 2, 2}, l = {285, 294, 294}, m = "invokeSuspend", n = {"startTime", "result", "startTime", "result", "startTime"}, s = {"J$0", "L$0", "J$0", "L$0", "J$0"})
final class AiKernelRunModelCaller$textEmbeddingToVectorByLora$2 extends SuspendLambda implements Function2<al, Continuation<? super float[]>, Object> {
    final /* synthetic */ String $foregroundCallerPkg;
    final /* synthetic */ String $sentence;
    final /* synthetic */ boolean $throwThermalStatusError;
    long J$0;
    Object L$0;
    int label;

    /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$textEmbeddingToVectorByLora$2$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass1<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<float[]> f8441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f8442b;
        final /* synthetic */ boolean c;

        AnonymousClass1(Ref.ObjectRef<float[]> r1, String r2, boolean r3) {
            this.f8441a = r1;
            this.f8442b = r2;
            this.c = r3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static final Unit a(Ref.ObjectRef r6, String r7, boolean r8, Object r9, JSONObject r10) {
            Intrinsics.checkNotNullParameter(r10, "<unused var>");
            if (r8 == false) goto L6;
            Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.FloatArray");
            r6.element = (T) ((float[]) ZeusTransformUtils.preCheckCast(r9, float[].class, "com.obric.memorydata.plugin"));
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "vlmLocal lora text embedding success", false, 4, null);
            RunLog.INSTANCE.debug("AiKernelRunModelCaller", "vlmLocal lora text embedding success " + r7);
        L6:
            return Unit.INSTANCE;
        }

        private static final Unit a(boolean r7, int r8, String r9, JSONObject r10) {
            Intrinsics.checkNotNullParameter(r9, "errInfo");
            Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_EXTRA);
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "vlmLocal lora text embedding error: " + r8 + ", " + r9 + " ," + r10, null, 4, null);
            if (r7 == false) goto L12;
            if (a.a(a.INSTANCE, Integer.valueOf(r8)) == true) goto L10;
            if (a.b(a.INSTANCE, Integer.valueOf(r8)) == false) goto L12;
        L10:
            throw new AIKernelRunModelException(a.a(a.INSTANCE, Integer.valueOf(r8), r10));
        L12:
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit lambda$ZBrc19ifrI3rqHBat6DXM_QVqiU(Ref.ObjectRef r0, String r1, boolean r2, Object r3, JSONObject r4) {
            return a(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ Unit lambda$oUk5tFZ9udNzN5SFZdhpRHCNoe0(boolean r0, int r1, String r2, JSONObject r3) {
            return a(r0, r1, r2, r3);
        }

        public final Object a(Response<Object> r3, Continuation<? super Unit> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            final Ref.ObjectRef<float[]> r6 = this.f8441a;
            final String r0 = this.f8442b;
            Response r7 = ResponseKt.ok(r3, new $$Lambda$AiKernelRunModelCaller$textEmbeddingToVectorByLora$2$1$ZBrc19ifrI3rqHBat6DXM_QVqiU(r6, r0));
            final boolean r2 = this.c;
            ResponseKt.fail(r7, new $$Lambda$AiKernelRunModelCaller$textEmbeddingToVectorByLora$2$1$oUk5tFZ9udNzN5SFZdhpRHCNoe0(r2));
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.j
        public /* synthetic */ Object emit(Object r3, Continuation r4) {
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return a((Response) ZeusTransformUtils.preCheckCast(r3, Response.class, "com.obric.memorydata.plugin"), r5);
        }
    }

    AiKernelRunModelCaller$textEmbeddingToVectorByLora$2(String r3, String r4, boolean r5, Continuation<? super AiKernelRunModelCaller$textEmbeddingToVectorByLora$2> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$sentence = r3;
        this.$foregroundCallerPkg = r4;
        this.$throwThermalStatusError = r5;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$textEmbeddingToVectorByLora$2(this.$sentence, this.$foregroundCallerPkg, this.$throwThermalStatusError, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super float[]> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super float[]> r4) {
        return ((AiKernelRunModelCaller$textEmbeddingToVectorByLora$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AiKernelRunModelCaller$textEmbeddingToVectorByLora$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        long r3 = this.J$0;
        Ref.ObjectRef r0 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
    L31:
        Ref.ObjectRef r4 = r0;
        long r7 = r3;
    L32:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "vlmLocal lora text embedding cost: " + (System.currentTimeMillis() - r7) + "ms", false, 4, null);
        Log.i("AiKernelRunModelCaller", "vlmLocal lora text embedding cost: " + (System.currentTimeMillis() - r7) + "ms");
        return r4.element;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        long r5 = this.J$0;
        Ref.ObjectRef r6 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
        r7 = r5;
        r4 = r6;
        Object r8 = r17;
    L25:
        i r9 = (i) ZeusTransformUtils.preCheckCast(r8, i.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L32;
        j r10 = (j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4, this.$sentence, this.$throwThermalStatusError), j.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r4;
        this.J$0 = r7;
        this.label = 3;
        if (r9.collect(r10, r11) != r1) goto L30;
        return r1;
    L30:
        r0 = r4;
        r3 = r7;
        goto L31
    L11:
        r7 = this.J$0;
        ResultKt.throwOnFailure(r17);
        Object r12 = r17;
    L19:
        IBaseModel r13 = (IBaseModel) ZeusTransformUtils.preCheckCast(r12, IBaseModel.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L22;
        return null;
    L22:
        JSONObject r14 = new JSONObject();
        String r15 = this.$sentence;
        String r16 = this.$foregroundCallerPkg;
        r14.put("useCloud", false);
        r14.put(Params.LORA_TYPE, "embedding");
        r14.put(Params.CONTENT, r15);
        a.a(a.INSTANCE, r14, r16);
        RequestParams r18 = new RequestParams(DataConvert.INSTANCE.jobj2Bundle(r14), null, 2, null);
        r4 = new Ref.ObjectRef();
        Continuation<? super i<Response<Object>>> r19 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r4;
        this.J$0 = r7;
        this.label = 2;
        r8 = r13.inferAsFlow(r18, r19);
        if (r8 != r1) goto L25;
        return r1;
    L12:
        ResultKt.throwOnFailure(r17);
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == true) goto L15;
    L34:
        Ensure.ensureNotReachHere("textEmbeddingToVectorByLora called when AIKernel not available");
        throw new RuntimeException("textEmbeddingToVectorByLora called when AIKernel not available");
    L15:
        if (DeviceInfoState.INSTANCE.isSupportVLM() == false) goto L34;
        r7 = System.currentTimeMillis();
        a r20 = a.INSTANCE;
        Continuation r110 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.J$0 = r7;
        this.label = 1;
        r12 = a.a(r20, "embedding", null, null, r110, 6, null);
        if (r12 != r1) goto L19;
        return r1;
    }
}
