package com.obric.aiproactive.impl.livecard;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusProviderTransform;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.livecard.ProactiveLiveCardManager$syncToLockScreen$1$1$4$config$2$1", f = "ProactiveLiveCardManager.kt", i = {0}, l = {623}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class ProactiveLiveCardManager$syncToLockScreen$1$1$4$config$2$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $hasExecuteInstruction;
    final /* synthetic */ ProactiveRecommendationDto $recommendation;
    private /* synthetic */ Object L$0;
    int label;

    ProactiveLiveCardManager$syncToLockScreen$1$1$4$config$2$1(ProactiveRecommendationDto r3, boolean r4, Context r5, Continuation<? super ProactiveLiveCardManager$syncToLockScreen$1$1$4$config$2$1> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$recommendation = r3;
        this.$hasExecuteInstruction = r4;
        this.$context = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        ProactiveLiveCardManager$syncToLockScreen$1$1$4$config$2$1 r0 = new ProactiveLiveCardManager$syncToLockScreen$1$1$4$config$2$1(this.$recommendation, this.$hasExecuteInstruction, this.$context, r7);
        r0.L$0 = r5;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ProactiveLiveCardManager$syncToLockScreen$1$1$4$config$2$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ProactiveLiveCardManager$syncToLockScreen$1$1$4$config$2$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        al r2 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L11:
        IslandSession r12 = (IslandSession) ZeusTransformUtils.preCheckCast(r11, IslandSession.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L14;
        ProactiveLiveCardDisplayTool.INSTANCE.destroySession(r12);
    L14:
        n r13 = n.f6478a;
        ProactiveRecommendationDto r3 = this.$recommendation;
        if (this.$hasExecuteInstruction == false) goto L17;
        String r4 = "execute_now";
    L18:
        n.a(r13, r3, r4);
        String r14 = this.$recommendation.getActionExecuteInstruction();
        if (r14 != null) goto L21;
    L23:
        r14 = null;
    L24:
        if (r14 == null) goto L37;
        n.a(n.f6478a, this.$context);
        ProactiveRecommendationDto r5 = this.$recommendation;
        Context r6 = this.$context;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L31
        Uri r8 = Uri.parse("content://com.obric.assistantaiagent.AgentOpenApiProvider");     // Catch: Throwable -> L31
        JSONObject r9 = new JSONObject();     // Catch: Throwable -> L31
        String r10 = r5.getActionContext();     // Catch: Throwable -> L31
        if (r10 != null) goto L29;
        r10 = "";
    L29:
        r9.put("o_pc_recommend_reason", r10);     // Catch: Throwable -> L31
        Bundle r15 = new Bundle();     // Catch: Throwable -> L31
        r15.putString(ChatMessage.TYPE_QUERY, r14);     // Catch: Throwable -> L31
        r15.putString("o_omni_instruction_type", "manual_normal");     // Catch: Throwable -> L31
        r15.putString("o_instruction_entry", "app_query");     // Catch: Throwable -> L31
        r15.putString("expand_state", "half");     // Catch: Throwable -> L31
        r15.putString(WsConstants.KEY_EXTRA, r9.toString());     // Catch: Throwable -> L31
        ZeusProviderTransform.call(r6.getContentResolver(), r8, "try_send_omni_query", null, r15, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Executed actionExecuteInstruction via Assistant AI Agent for recommendId: " + r5.getRecommendId(), false, 4, null);     // Catch: Throwable -> L31
        Object r16 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        ProactiveRecommendationDto r17 = this.$recommendation;
        Throwable r18 = Result.m1424exceptionOrNullimpl(r16);
        if (r18 == null) goto L37;
        RunLog.INSTANCE.warn("ProactiveLiveCardManager", "Failed to execute actionExecuteInstruction via Assistant AI Agent for recommendId: " + r17.getRecommendId(), r18);
    L31:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L37:
        return Unit.INSTANCE;
    L21:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L23;
    L17:
        r4 = "get";
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        al r110 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        n r20 = n.f6478a;
        String r21 = this.$recommendation.getRecommendId();
        Continuation r22 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r110;
        this.label = 1;
        r11 = n.a(r20, r21, r22);
        if (r11 != r0) goto L11;
        return r0;
    }
}
