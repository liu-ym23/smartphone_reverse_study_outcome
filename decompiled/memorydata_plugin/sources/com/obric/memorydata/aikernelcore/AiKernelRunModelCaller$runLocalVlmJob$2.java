package com.obric.memorydata.aikernelcore;

import android.net.Uri;
import android.util.Log;
import com.bytedance.crash.Ensure;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.aikernelcore.utils.DataConvert;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bp;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$runLocalVlmJob$2", f = "AiKernelRunModelCaller.kt", i = {0, 1, 1, 1}, l = {552, 1434}, m = "invokeSuspend", n = {"startTime", "model", "requestParams", "startTime"}, s = {"J$0", "L$0", "L$1", "J$0"})
final class AiKernelRunModelCaller$runLocalVlmJob$2 extends SuspendLambda implements Function2<al, Continuation<? super String>, Object> {
    final /* synthetic */ String $foregroundCallerPkg;
    final /* synthetic */ Uri $img;
    final /* synthetic */ String $lora;
    final /* synthetic */ String $packageName;
    final /* synthetic */ boolean $throwThermalStatusError;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    AiKernelRunModelCaller$runLocalVlmJob$2(String r3, String r4, Uri r5, boolean r6, String r7, Continuation<? super AiKernelRunModelCaller$runLocalVlmJob$2> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.$lora = r3;
        this.$packageName = r4;
        this.$img = r5;
        this.$throwThermalStatusError = r6;
        this.$foregroundCallerPkg = r7;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$runLocalVlmJob$2(this.$lora, this.$packageName, this.$img, this.$throwThermalStatusError, this.$foregroundCallerPkg, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super String> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super String> r4) {
        return ((AiKernelRunModelCaller$runLocalVlmJob$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AiKernelRunModelCaller$runLocalVlmJob$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r27) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L11;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        long r3 = this.J$0;
        Uri r4 = (Uri) ZeusTransformUtils.preCheckCast(this.L$3, Uri.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(this.L$2, String.class, "com.obric.memorydata.plugin");
        RequestParams r6 = (RequestParams) ZeusTransformUtils.preCheckCast(this.L$1, RequestParams.class, "com.obric.memorydata.plugin");
        IBaseModel r7 = (IBaseModel) ZeusTransformUtils.preCheckCast(this.L$0, IBaseModel.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r27);
        long r24 = r3;
        Object r8 = r27;
    L33:
        a.C0425a r9 = (a.C0425a) ZeusTransformUtils.preCheckCast(r8, a.C0425a.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "runLocalVlmJob(" + this.$lora + ") cost: " + (System.currentTimeMillis() - r24) + "ms", false, 4, null);
        Log.i("AiKernelRunModelCaller", "runLocalVlmJob(" + this.$lora + ") cost: " + (System.currentTimeMillis() - r24) + "ms");
        if (a.a(a.INSTANCE, r9.c()) == true) goto L38;
        if (a.b(a.INSTANCE, r9.c()) == true) goto L38;
    L40:
        if (r9.a() == false) goto L46;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r9.b(), String.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L45;
        return "";
    L45:
        return r0;
    L46:
        return null;
    L38:
        if (this.$throwThermalStatusError == false) goto L40;
        throw new AIKernelRunModelException(a.a(a.INSTANCE, r9.c(), r9.d()));
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        long r10 = this.J$0;
        ResultKt.throwOnFailure(r27);
        Object r11 = r27;
    L10:
        long r14 = r10;
        IBaseModel r12 = (IBaseModel) ZeusTransformUtils.preCheckCast(r11, IBaseModel.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L21;
        return null;
    L21:
        JSONObject r13 = new JSONObject();
        String r15 = this.$lora;
        Uri r16 = this.$img;
        String r17 = this.$foregroundCallerPkg;
        boolean r18 = false;
        r13.put("useCloud", false);
        r13.put(Params.LORA_TYPE, r15);
        r13.put(Params.FILE_PATH, r16.toString());
        a.a(a.INSTANCE, r13, r17);
        RequestParams r19 = new RequestParams(DataConvert.INSTANCE.jobj2Bundle(r13), null, 2, null);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.$packageName, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L24;
        r18 = true;
    L24:
        if (r18 == true) goto L26;
    L28:
        String r110 = this.$lora;
        Uri r111 = this.$img;
        this.L$0 = r12;
        this.L$1 = r19;
        this.L$2 = r110;
        this.L$3 = r111;
        this.J$0 = r14;
        this.label = 2;
        o r20 = new o(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin")), 1);
        r20.e();
        n r112 = (n) ZeusTransformUtils.preCheckCast(r20, n.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r113 = new Ref.ObjectRef();
        r113.element = "";
        r24 = r14;
        i.a((al) ZeusTransformUtils.preCheckCast(bp.f17245a, al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$runLocalVlmJob$2$result$1$1(r12, r19, r113, r110, r111, r14, new Ref.BooleanRef(), r112, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        r8 = r20.h();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L31;
        DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    L31:
        if (r8 != r1) goto L33;
        return r1;
    L26:
        if (a.a(a.INSTANCE, this.$packageName, this.$img, r19) == true) goto L28;
        return null;
    L11:
        ResultKt.throwOnFailure(r27);
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == true) goto L14;
    L49:
        Ensure.ensureNotReachHere("runLocalVlmJob called when AIKernel not available or not support VLM");
        throw new RuntimeException("runLocalVlmJob called when AIKernel not available or not support VLM");
    L14:
        if (DeviceInfoState.INSTANCE.isSupportVLM() == false) goto L49;
        r10 = System.currentTimeMillis();
        a r114 = a.INSTANCE;
        String r115 = this.$lora;
        Continuation r116 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.J$0 = r10;
        this.label = 1;
        r11 = a.a(r114, r115, null, null, r116, 6, null);
        if (r11 != r1) goto L10;
        return r1;
    }
}
