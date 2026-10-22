package com.obric.memorydata.aikernelcore;

import android.net.Uri;
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
import com.obric.memorydata.utils.at;
import com.ss.bduploader.BDNetworkSpeedTest;
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
@DebugMetadata(c = "com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$runImgEmbeddingByLora$2", f = "AiKernelRunModelCaller.kt", i = {0, 1, 1, 2, 2}, l = {415, BDNetworkSpeedTest.KeyIsIntelligentTestResult, BDNetworkSpeedTest.KeyIsIntelligentTestResult}, m = "invokeSuspend", n = {"startTime", "result", "startTime", "result", "startTime"}, s = {"J$0", "L$0", "J$0", "L$0", "J$0"})
final class AiKernelRunModelCaller$runImgEmbeddingByLora$2 extends SuspendLambda implements Function2<al, Continuation<? super float[]>, Object> {
    final /* synthetic */ String $foregroundCallerPkg;
    final /* synthetic */ Uri $img;
    final /* synthetic */ String $sourcePkg;
    final /* synthetic */ boolean $throwThermalStatusError;
    long J$0;
    Object L$0;
    int label;

    /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$runImgEmbeddingByLora$2$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass1<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<float[]> f8433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f8434b;

        AnonymousClass1(Ref.ObjectRef<float[]> r1, boolean r2) {
            this.f8433a = r1;
            this.f8434b = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static final Unit a(Ref.ObjectRef r6, boolean r7, Object r8, JSONObject r9) {
            Intrinsics.checkNotNullParameter(r9, "<unused var>");
            if (r7 == false) goto L6;
            Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.FloatArray");
            r6.element = (T) ((float[]) ZeusTransformUtils.preCheckCast(r8, float[].class, "com.obric.memorydata.plugin"));
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "vlmLocal lora img embedding success", false, 4, null);
        L6:
            return Unit.INSTANCE;
        }

        private static final Unit a(boolean r7, int r8, String r9, JSONObject r10) {
            Intrinsics.checkNotNullParameter(r9, "errInfo");
            Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_EXTRA);
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "vlmLocal lora img embedding error: " + r8 + ", " + r9 + " ," + r10, null, 4, null);
            if (r7 == false) goto L12;
            if (a.a(a.INSTANCE, Integer.valueOf(r8)) == true) goto L10;
            if (a.b(a.INSTANCE, Integer.valueOf(r8)) == false) goto L12;
        L10:
            throw new AIKernelRunModelException(a.a(a.INSTANCE, Integer.valueOf(r8), r10));
        L12:
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: lambda$ZlRroZk-ZJ4EHcSmrRasIWwTe5I, reason: not valid java name */
        public static /* synthetic */ Unit m449lambda$ZlRroZkZJ4EHcSmrRasIWwTe5I(boolean r0, int r1, String r2, JSONObject r3) {
            return a(r0, r1, r2, r3);
        }

        public static /* synthetic */ Unit lambda$rp8cDfkA6CEbrX7ZLQ0QtBXBgRc(Ref.ObjectRef r0, boolean r1, Object r2, JSONObject r3) {
            return a(r0, r1, r2, r3);
        }

        public final Object a(Response<Object> r3, Continuation<? super Unit> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            final Ref.ObjectRef<float[]> r6 = this.f8433a;
            Response r7 = ResponseKt.ok(r3, new $$Lambda$AiKernelRunModelCaller$runImgEmbeddingByLora$2$1$rp8cDfkA6CEbrX7ZLQ0QtBXBgRc(r6));
            final boolean r2 = this.f8434b;
            ResponseKt.fail(r7, new $$Lambda$AiKernelRunModelCaller$runImgEmbeddingByLora$2$1$ZlRroZkZJ4EHcSmrRasIWwTe5I(r2));
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.j
        public /* synthetic */ Object emit(Object r3, Continuation r4) {
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return a((Response) ZeusTransformUtils.preCheckCast(r3, Response.class, "com.obric.memorydata.plugin"), r5);
        }
    }

    AiKernelRunModelCaller$runImgEmbeddingByLora$2(String r3, Uri r4, String r5, boolean r6, Continuation<? super AiKernelRunModelCaller$runImgEmbeddingByLora$2> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$sourcePkg = r3;
        this.$img = r4;
        this.$foregroundCallerPkg = r5;
        this.$throwThermalStatusError = r6;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$runImgEmbeddingByLora$2(this.$sourcePkg, this.$img, this.$foregroundCallerPkg, this.$throwThermalStatusError, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super float[]> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super float[]> r4) {
        return ((AiKernelRunModelCaller$runImgEmbeddingByLora$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AiKernelRunModelCaller$runImgEmbeddingByLora$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r5 = true;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        long r3 = this.J$0;
        Ref.ObjectRef r0 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);
    L42:
        Ref.ObjectRef r10 = r0;
        long r4 = r3;
    L43:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "vlmLocal lora img embedding cost: " + (System.currentTimeMillis() - r4) + "ms", false, 4, null);
        Log.i("AiKernelRunModelCaller", "vlmLocal lora img embedding cost: " + (System.currentTimeMillis() - r4) + "ms");
        return r10.element;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r4 = this.J$0;
        Ref.ObjectRef r6 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);
        r10 = r6;
        Object r7 = r18;
    L36:
        i r8 = (i) ZeusTransformUtils.preCheckCast(r7, i.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L43;
        j r9 = (j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r10, this.$throwThermalStatusError), j.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r10;
        this.J$0 = r4;
        this.label = 3;
        if (r8.collect(r9, r11) != r1) goto L41;
        return r1;
    L41:
        r3 = r4;
        r0 = r10;
        goto L42
    L11:
        long r12 = this.J$0;
        ResultKt.throwOnFailure(r18);
        Object r13 = r18;
    L19:
        IBaseModel r14 = (IBaseModel) ZeusTransformUtils.preCheckCast(r13, IBaseModel.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L22;
        return null;
    L22:
        JSONObject r15 = new JSONObject();
        Uri r16 = this.$img;
        String r17 = this.$foregroundCallerPkg;
        r15.put("useCloud", false);
        r15.put(Params.LORA_TYPE, "embedding");
        r15.put(Params.FILE_PATH, r16.toString());
        r15.put("max_pixel", 896);
        r15.put("padding", false);
        a.a(a.INSTANCE, r15, r17);
        RequestParams r19 = new RequestParams(DataConvert.INSTANCE.jobj2Bundle(r15), null, 2, null);
        r10 = new Ref.ObjectRef();
        String r110 = this.$sourcePkg;
        if (r110 != null) goto L25;
    L27:
        r5 = false;
    L28:
        if (r5 == true) goto L30;
    L32:
        Continuation<? super i<Response<Object>>> r20 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r10;
        this.J$0 = r12;
        this.label = 2;
        r7 = r14.inferAsFlow(r19, r20);
        if (r7 != r1) goto L35;
        return r1;
    L35:
        r4 = r12;
        goto L36
    L30:
        if (a.a(a.INSTANCE, this.$sourcePkg, this.$img, r19) == true) goto L32;
        return null;
    L25:
        if (at.a(r110) != true) goto L27;
    L12:
        ResultKt.throwOnFailure(r18);
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == true) goto L15;
    L45:
        Ensure.ensureNotReachHere("runImgEmbeddingByLora called when AIKernel not available");
        throw new RuntimeException("runImgEmbeddingByLora called when AIKernel not available");
    L15:
        if (DeviceInfoState.INSTANCE.isSupportVLM() == false) goto L45;
        r12 = System.currentTimeMillis();
        a r21 = a.INSTANCE;
        Continuation r111 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.J$0 = r12;
        this.label = 1;
        r13 = a.a(r21, "embedding", null, null, r111, 6, null);
        if (r13 != r1) goto L19;
        return r1;
    }
}
