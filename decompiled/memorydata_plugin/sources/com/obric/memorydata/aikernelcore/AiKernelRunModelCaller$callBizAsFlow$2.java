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
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.da;
import kotlinx.coroutines.flow.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$callBizAsFlow$2", f = "AiKernelRunModelCaller.kt", i = {0, 1, 1, 2, 2}, l = {876, 885, 891}, m = "invokeSuspend", n = {"startTime", "outputResult", "startTime", "outputResult", "startTime"}, s = {"J$0", "L$0", "J$0", "L$0", "J$0"})
final class AiKernelRunModelCaller$callBizAsFlow$2 extends SuspendLambda implements Function2<al, Continuation<? super String>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ String $foregroundCallerPkg;
    final /* synthetic */ String $modelName;
    final /* synthetic */ long $timeout;
    final /* synthetic */ boolean $useCloud;
    long J$0;
    Object L$0;
    int label;

    AiKernelRunModelCaller$callBizAsFlow$2(String r3, String r4, boolean r5, String r6, long r7, Continuation<? super AiKernelRunModelCaller$callBizAsFlow$2> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.$modelName = r3;
        this.$content = r4;
        this.$useCloud = r5;
        this.$foregroundCallerPkg = r6;
        this.$timeout = r7;
        super(2, r10);
    }

    private static final Unit invokeSuspend$lambda$1(final JSONObject r1, RequestParams r2) {
        ParamsKt.setCustomArgs(r2, new $$Lambda$AiKernelRunModelCaller$callBizAsFlow$2$R_NAijygywkrUsScJShs_mB05s(r1));
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$1$lambda$0(JSONObject r3, Bundle r4) {
        r4.putAll(BundleExtKt.json2Bundle$default(r3, false, 2, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$R_NAijygyw-krUsScJShs_mB05s, reason: not valid java name */
    public static /* synthetic */ Unit m443lambda$R_NAijygywkrUsScJShs_mB05s(JSONObject r0, Bundle r1) {
        return invokeSuspend$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit lambda$vHqinrl7gVD5QeN01GUPvSciTSk(JSONObject r0, RequestParams r1) {
        return invokeSuspend$lambda$1(r0, r1);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$callBizAsFlow$2(this.$modelName, this.$content, this.$useCloud, this.$foregroundCallerPkg, this.$timeout, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super String> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super String> r4) {
        return ((AiKernelRunModelCaller$callBizAsFlow$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AiKernelRunModelCaller$callBizAsFlow$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L16;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L14;
        if (r1 != 3) goto L13;
        long r2 = this.J$0;
        Ref.ObjectRef r3 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L10
    L33:
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L38:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", this.$modelName + " cost: " + (System.currentTimeMillis() - r2) + "ms", false, 4, null);
        Log.i("AiKernelRunModelCaller", this.$modelName + " cost: " + (System.currentTimeMillis() - r2) + "ms");
        return r3.element;
    L10:
        th = th;
    L37:
        Result.Companion r4 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L38
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        long r5 = this.J$0;
        Ref.ObjectRef r6 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);
    L28:
        i r14 = (i) ZeusTransformUtils.preCheckCast(r13, i.class, "com.obric.memorydata.plugin");
        long r7 = this.$timeout;
        String r9 = this.$modelName;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L35
        Function2 r15 = (Function2) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$callBizAsFlow$2$1$1(r14, r6, r9, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        this.L$0 = r6;     // Catch: Throwable -> L35
        this.J$0 = r5;     // Catch: Throwable -> L35
        this.label = 3;     // Catch: Throwable -> L35
        if (da.a(r7, r15, this) != r0) goto L32;
        return r0;
    L32:
        r3 = r6;
        r2 = r5;
    L35:
        th = th;
        r3 = r6;
        r2 = r5;
        goto L37
    L15:
        long r8 = this.J$0;
        ResultKt.throwOnFailure(r13);
    L21:
        IBaseModel r16 = (IBaseModel) ZeusTransformUtils.preCheckCast(r13, IBaseModel.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L24;
        return null;
    L24:
        final JSONObject r11 = new JSONObject();
        r11.put(Params.CONTENT, this.$content);
        r11.put("useCloud", this.$useCloud);
        a.INSTANCE.a(r11, this.$foregroundCallerPkg);
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        r12.element = "";
        RequestParams r17 = new RequestParams(null, new $$Lambda$AiKernelRunModelCaller$callBizAsFlow$2$vHqinrl7gVD5QeN01GUPvSciTSk(r11), 1, null);
        Continuation<? super i<Response<Object>>> r18 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r12;
        this.J$0 = r8;
        this.label = 2;
        r13 = r16.inferAsFlow(r17, r18);
        if (r13 != r0) goto L27;
        return r0;
    L27:
        r5 = r8;
        r6 = r12;
        goto L28
    L16:
        ResultKt.throwOnFailure(r13);
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L40;
        r8 = System.currentTimeMillis();
        a r19 = a.INSTANCE;
        String r20 = this.$modelName;
        Continuation r21 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.J$0 = r8;
        this.label = 1;
        r13 = a.a(r19, r20, r21);
        if (r13 != r0) goto L21;
        return r0;
    L40:
        Ensure.ensureNotReachHere("callBizAsFlow called when AIKernel not available");
        throw new RuntimeException("callBizAsFlow called when AIKernel not available");
    }
}
