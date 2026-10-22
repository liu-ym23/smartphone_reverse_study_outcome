package com.obric.memorydata.aikernelcore;

import android.os.Bundle;
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
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/aikernelcore/ScriptModelResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.aikernelcore.AiKernelRunModelCaller$callBizAsFlowWithLogId$2", f = "AiKernelRunModelCaller.kt", i = {0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {936, 952, 955}, m = "invokeSuspend", n = {"startTime", "resultCode", "resultMsg", "logId", "outputResult", TrackerImpl.PARAMS, "startTime", "resultCode", "resultMsg", "logId", "outputResult", "startTime"}, s = {"J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0"})
final class AiKernelRunModelCaller$callBizAsFlowWithLogId$2 extends SuspendLambda implements Function2<al, Continuation<? super ScriptModelResult>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ String $foregroundCallerPkg;
    final /* synthetic */ String $modelName;
    final /* synthetic */ long $timeout;
    final /* synthetic */ boolean $useCloud;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    AiKernelRunModelCaller$callBizAsFlowWithLogId$2(String r3, String r4, boolean r5, String r6, long r7, Continuation<? super AiKernelRunModelCaller$callBizAsFlowWithLogId$2> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.$modelName = r3;
        this.$content = r4;
        this.$useCloud = r5;
        this.$foregroundCallerPkg = r6;
        this.$timeout = r7;
        super(2, r10);
    }

    private static final Unit invokeSuspend$lambda$1(final JSONObject r1, RequestParams r2) {
        ParamsKt.setCustomArgs(r2, new $$Lambda$AiKernelRunModelCaller$callBizAsFlowWithLogId$2$BP3WFMkYYu72p0CfuNyaYZDvRak(r1));
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$1$lambda$0(JSONObject r3, Bundle r4) {
        r4.putAll(BundleExtKt.json2Bundle$default(r3, false, 2, null));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$BP3WFMkYYu72p0CfuNyaYZDvRak(JSONObject r0, Bundle r1) {
        return invokeSuspend$lambda$1$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$F2S-OCIw3gix5AXxfwXkNavfUPU, reason: not valid java name */
    public static /* synthetic */ Unit m445lambda$F2SOCIw3gix5AXxfwXkNavfUPU(JSONObject r0, RequestParams r1) {
        return invokeSuspend$lambda$1(r0, r1);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$callBizAsFlowWithLogId$2(this.$modelName, this.$content, this.$useCloud, this.$foregroundCallerPkg, this.$timeout, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super ScriptModelResult> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super ScriptModelResult> r4) {
        return ((AiKernelRunModelCaller$callBizAsFlowWithLogId$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AiKernelRunModelCaller$callBizAsFlowWithLogId$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r26) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L14;
        if (r2 != 3) goto L13;
        long r3 = this.J$0;
        Ref.ObjectRef r4 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$3, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r6 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$2, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r7 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$1, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.IntRef r9 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.IntRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r26);     // Catch: Throwable -> L10
        Ref.IntRef r12 = r9;
        long r10 = r3;
        Object r5 = r26;
    L45:
        Result.m1421constructorimpl((Unit) ZeusTransformUtils.preCheckCast(r5, Unit.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L35
    L41:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "call " + this.$modelName + " cost: " + (System.currentTimeMillis() - r10) + "ms", false, 4, null);
        return new ScriptModelResult((String) ZeusTransformUtils.preCheckCast(r4.element, String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r6.element, String.class, "com.obric.memorydata.plugin"), r12.element, (String) ZeusTransformUtils.preCheckCast(r7.element, String.class, "com.obric.memorydata.plugin"));
    L35:
        th = th;
        r3 = r10;
    L39:
        r9 = r12;
    L40:
        Result.Companion r11 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        r12 = r9;
        r10 = r3;
    L10:
        th = th;
        goto L40
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        r10 = this.J$0;
        RequestParams r8 = (RequestParams) ZeusTransformUtils.preCheckCast(this.L$4, RequestParams.class, "com.obric.memorydata.plugin");
        r4 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$3, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        r6 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$2, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r13 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$1, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        r12 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.IntRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r26);
        RequestParams r15 = r8;
        Object r14 = r26;
    L28:
        i r18 = (i) ZeusTransformUtils.preCheckCast(r14, i.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "call " + this.$modelName + " traceId: " + r15.getTraceIdStr(), false, 4, null);
        long r16 = this.$timeout;
        String r17 = this.$modelName;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L37
        Function2 r110 = (Function2) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$callBizAsFlowWithLogId$2$1$1(r18, r4, r17, r12, r13, r6, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        this.L$0 = r12;     // Catch: Throwable -> L37
        this.L$1 = r13;     // Catch: Throwable -> L37
        this.L$2 = r6;     // Catch: Throwable -> L37
        this.L$3 = r4;     // Catch: Throwable -> L37
        this.L$4 = null;     // Catch: Throwable -> L37
        this.J$0 = r10;     // Catch: Throwable -> L37
        this.label = 3;     // Catch: Throwable -> L37
        r5 = da.a(r16, r110, this);     // Catch: Throwable -> L37
        if (r5 != r0) goto L32;
        return r0;
    L32:
        r7 = r13;
    L37:
        th = th;
        r3 = r10;
        r7 = r13;
        goto L39
    L15:
        r10 = this.J$0;
        ResultKt.throwOnFailure(r26);
        Object r20 = r26;
    L21:
        IBaseModel r21 = (IBaseModel) ZeusTransformUtils.preCheckCast(r20, IBaseModel.class, "com.obric.memorydata.plugin");
        if (r21 != null) goto L24;
        return null;
    L24:
        final JSONObject r111 = new JSONObject();
        r111.put(Params.CONTENT, this.$content);
        r111.put("useCloud", this.$useCloud);
        a.INSTANCE.a(r111, this.$foregroundCallerPkg);
        r12 = new Ref.IntRef();
        r12.element = -1;
        Ref.ObjectRef r112 = new Ref.ObjectRef();
        r112.element = "TIMEOUT_OR_EXCEPTION";
        Ref.ObjectRef r113 = new Ref.ObjectRef();
        r113.element = "";
        Ref.ObjectRef r22 = new Ref.ObjectRef();
        r22.element = "";
        r15 = new RequestParams(null, new $$Lambda$AiKernelRunModelCaller$callBizAsFlowWithLogId$2$F2SOCIw3gix5AXxfwXkNavfUPU(r111), 1, null);
        Continuation<? super i<Response<Object>>> r23 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r12;
        this.L$1 = r112;
        this.L$2 = r113;
        this.L$3 = r22;
        this.L$4 = r15;
        this.J$0 = r10;
        this.label = 2;
        r14 = r21.inferAsFlow(r15, r23);
        if (r14 != r0) goto L27;
        return r0;
    L27:
        r4 = r22;
        r13 = r112;
        r6 = r113;
        goto L28
    L16:
        ResultKt.throwOnFailure(r26);
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L43;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiKernelRunModelCaller", "call " + this.$modelName + " begin", false, 4, null);
        r10 = System.currentTimeMillis();
        a r24 = a.INSTANCE;
        String r114 = this.$modelName;
        Continuation r115 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.J$0 = r10;
        this.label = 1;
        r20 = a.a(r24, r114, r115);
        if (r20 != r0) goto L21;
        return r0;
    L43:
        Ensure.ensureNotReachHere("callBizAsFlowWithLogId called when AIKernel not available");
        throw new RuntimeException("callBizAsFlowWithLogId called when AIKernel not available");
    }
}
