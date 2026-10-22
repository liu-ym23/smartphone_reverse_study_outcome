package com.obric.aiproactive.api;

import com.bytedance.obric.memory.model.ProactiveAgentUserFeedbackReq;
import com.bytedance.obric.memory.model.ProactiveAgentUserFeedbackResp;
import com.bytedance.rpc.RpcException;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.api.AiProactiveFeedbackEventUploader$appendEventAsync$1", f = "AiProactiveFeedbackEventUploader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AiProactiveFeedbackEventUploader$appendEventAsync$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $feedbackReason;
    final /* synthetic */ String $feedbackSource;
    final /* synthetic */ String $feedbackText;
    final /* synthetic */ Integer $feedbackType;
    final /* synthetic */ Integer $feedbackValue;
    final /* synthetic */ String $logId;
    final /* synthetic */ Function1<Boolean, Unit> $onResult;
    final /* synthetic */ String $relatedInfo;
    final /* synthetic */ int $relatedType;
    final /* synthetic */ Function1<String, Boolean> $shouldUploadFeedback;
    int label;

    AiProactiveFeedbackEventUploader$appendEventAsync$1(Integer r3, Function1<? super String, Boolean> r4, Function1<? super Boolean, Unit> r5, String r6, int r7, String r8, Integer r9, String r10, String r11, String r12, Continuation<? super AiProactiveFeedbackEventUploader$appendEventAsync$1> r13) {
        Function1<String, Boolean> r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Function1<Boolean, Unit> r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        this.$feedbackValue = r3;
        this.$shouldUploadFeedback = r14;
        this.$onResult = r15;
        this.$logId = r6;
        this.$relatedType = r7;
        this.$relatedInfo = r8;
        this.$feedbackType = r9;
        this.$feedbackReason = r10;
        this.$feedbackText = r11;
        this.$feedbackSource = r12;
        super(2, r16);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AiProactiveFeedbackEventUploader$appendEventAsync$1(this.$feedbackValue, this.$shouldUploadFeedback, this.$onResult, this.$logId, this.$relatedType, this.$relatedInfo, this.$feedbackType, this.$feedbackReason, this.$feedbackText, this.$feedbackSource, r12), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((AiProactiveFeedbackEventUploader$appendEventAsync$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AiProactiveFeedbackEventUploader$appendEventAsync$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L42;
        ResultKt.throwOnFailure(r12);
        Integer r13 = r.f6271a.a(this.$feedbackValue);
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r1 = new StringBuilder().append("Feedback event request start(async), hasValue=");
        boolean r2 = true;
        if (r13 == null) goto L7;
        boolean r4 = true;
    L8:
        StringBuilder r3 = r1.append(r4).append(" outOfRange=");
        if (this.$feedbackValue == null) goto L12;
        if (r13 != null) goto L12;
        boolean r14 = true;
    L13:
        r0.debug("AiProactiveFeedbackEventUploader", r3.append(r14).toString());
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.$shouldUploadFeedback.invoke(AppContext.INSTANCE.getUserId()), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L20;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveFeedbackEventUploader", "skip append feedback event enabled=false", false, 4, null);
        Function1<Boolean, Unit> r11 = this.$onResult;
        if (r11 == null) goto L19;
        r11.invoke(Boxing.boxBoolean(true));
    L19:
        return Unit.INSTANCE;
    L20:
        ProactiveAgentUserFeedbackReq r15 = new ProactiveAgentUserFeedbackReq();
        String r5 = this.$logId;
        int r6 = this.$relatedType;
        String r7 = this.$relatedInfo;
        Integer r8 = this.$feedbackType;
        String r9 = this.$feedbackReason;
        String r10 = this.$feedbackText;
        String r16 = this.$feedbackSource;
        Integer r17 = this.$feedbackValue;
        r15.logId = r5;
        r15.relatedType = r6;
        r15.relatedInfo = r7;
        if (r8 == null) goto L23;
        r15.feedbackType = ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue();
    L23:
        r15.feedbackReason = r9;
        r15.feedbackText = r10;
        r15.feedbackSource = r16;
        r15.amount = r.f6271a.b(r17);
        ProactiveAgentUserFeedbackResp r18 = com.bytedance.obric.memory.a.a.a(r15);     // Catch: RpcException -> L36
        IRunLog r19 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: RpcException -> L36
        StringBuilder r20 = new StringBuilder().append("append feedback event code=").append(r18.code).append(" success=");     // Catch: RpcException -> L36
        if (r18.code != 0) goto L27;
        boolean r21 = true;
    L28:
        IRunLog.a.a(r19, "AiProactiveFeedbackEventUploader", r20.append(r21).toString(), false, 4, null);     // Catch: RpcException -> L36
        Function1<Boolean, Unit> r22 = this.$onResult;     // Catch: RpcException -> L36
        if (r22 == null) goto L40;
        if (r18.code == 0) goto L34;
        r2 = false;
    L34:
        r22.invoke(Boxing.boxBoolean(r2));     // Catch: RpcException -> L36
    L40:
        return Unit.INSTANCE;
    L27:
        r21 = false;
    L36:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveFeedbackEventUploader", "append feedback event failed rpcException=true", null, 4, null);
        Function1<Boolean, Unit> r110 = this.$onResult;
        if (r110 == null) goto L40;
        r110.invoke(Boxing.boxBoolean(false));
    L12:
        r14 = false;
        goto L13
    L7:
        r4 = false;
        goto L8
    L42:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
