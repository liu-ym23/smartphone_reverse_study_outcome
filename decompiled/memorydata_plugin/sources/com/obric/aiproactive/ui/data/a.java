package com.obric.aiproactive.ui.data;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.news.common.service.manager.d;
import com.obric.aiproactive.api.AiProactiveCardStatus;
import com.obric.aiproactive.api.AlgorithmTaskInvokeResult;
import com.obric.aiproactive.api.IProactiveService;
import com.obric.aiproactive.api.PageType;
import com.obric.aiproactive.api.ProactiveAllPageSnapshot;
import com.obric.aiproactive.api.ProactiveDayPageResult;
import com.obric.aiproactive.api.ProactiveInspirationDto;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.aiproactive.api.e;
import com.obric.aiproactive.api.g;
import com.obric.aiproactive.api.o;
import com.obric.aiproactive.api.p;
import com.obric.aiproactive.api.u;
import com.obric.aiproactive.api.x;
import com.obric.aiproactive.api.z;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.k;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 a2\u00020\u0001:\u0001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\tH\u0016J.\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ \u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\u0017H\u0096@¢\u0006\u0002\u0010\"J \u0010#\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\n0$0\tH\u0016J\u0010\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0\tH\u0016J\n\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020'H\u0016J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010/J\u0018\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0\t2\u0006\u0010.\u001a\u00020\u0017H\u0016J\u0014\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0016J\u001e\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u000205H\u0096@¢\u0006\u0002\u00106J \u00107\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\u0017H\u0096@¢\u0006\u0002\u00108J\u0016\u00109\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010:J&\u0010;\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u00152\u0006\u0010<\u001a\u00020\r2\u0006\u00104\u001a\u000205H\u0096@¢\u0006\u0002\u0010=J\u0016\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020@H\u0096@¢\u0006\u0002\u0010AJ\u0016\u0010B\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020CH\u0096@¢\u0006\u0002\u0010DJ\u0016\u0010E\u001a\u00020F2\u0006\u0010?\u001a\u00020GH\u0096@¢\u0006\u0002\u0010HJ\u0016\u0010I\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020JH\u0096@¢\u0006\u0002\u0010KJ\u000e\u0010L\u001a\u00020-H\u0096@¢\u0006\u0002\u0010MJ\u000e\u0010N\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010MJ\u0018\u0010O\u001a\u0004\u0018\u00010\u00172\u0006\u0010 \u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010/J\u0016\u0010P\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020QH\u0096@¢\u0006\u0002\u0010RJ\u0014\u0010S\u001a\b\u0012\u0004\u0012\u00020J0\nH\u0096@¢\u0006\u0002\u0010MJ\u000e\u0010T\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010MJ\u0016\u0010U\u001a\u00020-2\u0006\u0010V\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010:J\b\u0010W\u001a\u00020-H\u0016J\u000e\u0010X\u001a\u00020-H\u0096@¢\u0006\u0002\u0010MJ\u000e\u0010Y\u001a\u00020-H\u0096@¢\u0006\u0002\u0010MJ\b\u0010Z\u001a\u00020-H\u0016J\u0010\u0010[\u001a\u00020\u001b2\u0006\u0010\\\u001a\u00020-H\u0016J\u0016\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010/J\u000e\u0010`\u001a\u00020^H\u0096@¢\u0006\u0002\u0010MR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006b"}, d2 = {"Lcom/obric/aiproactive/ui/data/DefaultProactiveRepository;", "Lcom/obric/aiproactive/ui/data/ProactiveRepository;", "<init>", "()V", "service", "Lcom/obric/aiproactive/api/IProactiveService;", "getService", "()Lcom/obric/aiproactive/api/IProactiveService;", "observeNowPage", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "limit", "", "observeNowPageSnapshot", "Lcom/obric/aiproactive/api/ProactiveNowPageSnapshot;", "observeAllPage", "Lcom/obric/aiproactive/api/ProactiveAllPageSnapshot;", "loadDayRecommendationsPage", "Lcom/obric/aiproactive/api/ProactiveDayPageResult;", "batchId", "", "dayKey", "", TypedValues.CycleType.S_WAVE_OFFSET, "(JLjava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateInspiration", "", "dto", "Lcom/obric/aiproactive/api/ProactiveInspirationDto;", "(Lcom/obric/aiproactive/api/ProactiveInspirationDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRecommendationActionExecuteInstruction", "recommendId", "actionExecuteInstruction", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeTodayEventRecords", "Lkotlin/Pair;", "Lcom/obric/aiproactive/api/AiProactiveEventRecordDto;", "observeLatestAgentRun", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;", "getLatestAgentRun", "getLocalAgentRunControlState", "Lcom/obric/aiproactive/api/AiProactiveAgentRunControlState;", "run", "cancelLocalAgentRun", "", "executionId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeAgentRun", "observeAiProactiveRecommendations", "updateAiProactiveRecommendationCardStatus", "recommendationId", "cardStatus", "Lcom/obric/aiproactive/api/AiProactiveCardStatus;", "(JLcom/obric/aiproactive/api/AiProactiveCardStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAiProactiveRecommendationActionExecuteInstruction", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAiProactiveRecommendationCurrentActionExecuted", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAiProactiveRecommendationActionExecuted", "actionIndex", "(JILcom/obric/aiproactive/api/AiProactiveCardStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAiProactiveRecommendationFeedback", Ext.KEY_REQUEST, "Lcom/obric/aiproactive/api/AiProactiveRecommendationFeedbackRequest;", "(Lcom/obric/aiproactive/api/AiProactiveRecommendationFeedbackRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitAiProactiveDirectFeedback", "Lcom/obric/aiproactive/api/AiProactiveDirectFeedbackRequest;", "(Lcom/obric/aiproactive/api/AiProactiveDirectFeedbackRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitAiProactiveUserRequirement", "Lcom/obric/aiproactive/api/AiProactiveUserRequirementResult;", "Lcom/obric/aiproactive/api/AiProactiveUserRequirementRequest;", "(Lcom/obric/aiproactive/api/AiProactiveUserRequirementRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertUserSubscription", "Lcom/obric/aiproactive/api/ProactiveUserSubscriptionDto;", "(Lcom/obric/aiproactive/api/ProactiveUserSubscriptionDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureAgreePrivacyAndLogin", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initDefaultSubscriptions", "findLatestDebugLogIdByRecommendId", "toggleUserSubscription", "Lcom/obric/aiproactive/api/ToggleUserSubscriptionRequest;", "(Lcom/obric/aiproactive/api/ToggleUserSubscriptionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listUserSubscriptions", "ensureAiProactiveDbReady", "awaitAiProactiveDbReady", "timeoutMs", "isAiProactiveEntryReady", "tryActiveAiProactiveAssistantVoiceEntry", "isAssistantSessionIdle", "isAiProactiveWakeUpEnabled", "updateAiProactiveWakeUpEnabled", "enabled", "invokeAlgorithmTask", "Lcom/obric/aiproactive/api/AlgorithmTaskInvokeResult;", "jsonString", "triggerHiddenProactiveEntryFromAvatarFiveTap", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0292a f6556a = null;

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.data.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/ui/data/DefaultProactiveRepository$Companion;", "", "<init>", "()V", "TAG", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0292a {
        private C0292a() {
        }

        public /* synthetic */ C0292a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f6556a = new C0292a(null);
    }

    public a() {
    }

    public static final /* synthetic */ IProactiveService a(a r0) {
        return r0.h();
    }

    private final IProactiveService h() {
        return (IProactiveService) ZeusTransformUtils.preCheckCast(d.a(IProactiveService.class), IProactiveService.class, "com.obric.memorydata.plugin");
    }

    public e a(g r3) {
        Intrinsics.checkNotNullParameter(r3, "run");
        IProactiveService r2 = h();
        if (r2 == null) goto L7;
        e r4 = r2.getLocalAgentRunControlState(r3);
        if (r4 == null) goto L7;
        return r4;
    L7:
        return new e(null, false, 3, null);
    }

    @Override // com.obric.aiproactive.ui.data.b
    public Object a(long r11, int r13, AiProactiveCardStatus r14, Continuation<? super Unit> r15) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$markAiProactiveRecommendationActionExecuted$2(r11, r13, r14, this, null), Function2.class, "com.obric.memorydata.plugin"), r16);
    }

    @Override // com.obric.aiproactive.ui.data.b
    public Object a(long r10, AiProactiveCardStatus r12, Continuation<? super Unit> r13) {
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$updateAiProactiveRecommendationCardStatus$2(r10, r12, this, null), Function2.class, "com.obric.memorydata.plugin"), r14);
    }

    @Override // com.obric.aiproactive.ui.data.b
    public Object a(long r13, String r15, int r16, int r17, Continuation<? super ProactiveDayPageResult> r18) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r18, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$loadDayRecommendationsPage$2(r13, r15, r16, r17, this, null), Function2.class, "com.obric.memorydata.plugin"), r0);
    }

    @Override // com.obric.aiproactive.ui.data.b
    public Object a(long r10, String r12, Continuation<? super Unit> r13) {
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$updateAiProactiveRecommendationActionExecuteInstruction$2(r10, r12, this, null), Function2.class, "com.obric.memorydata.plugin"), r14);
    }

    @Override // com.obric.aiproactive.ui.data.b
    public Object a(long r5, Continuation<? super Unit> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$markAiProactiveRecommendationCurrentActionExecuted$2(r5, this, null), Function2.class, "com.obric.memorydata.plugin"), r8);
    }

    @Override // com.obric.aiproactive.ui.data.b
    public Object a(ProactiveInspirationDto r5, Continuation<? super Unit> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$updateInspiration$2(r5, this, null), Function2.class, "com.obric.memorydata.plugin"), r7);
    }

    @Override // com.obric.aiproactive.ui.data.b
    public Object a(o r5, Continuation<? super Unit> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$submitAiProactiveDirectFeedback$2(r5, this, null), Function2.class, "com.obric.memorydata.plugin"), r7);
    }

    @Override // com.obric.aiproactive.ui.data.b
    public Object a(u r5, Continuation<? super Unit> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$updateAiProactiveRecommendationFeedback$2(r5, this, null), Function2.class, "com.obric.memorydata.plugin"), r7);
    }

    @Override // com.obric.aiproactive.ui.data.b
    public Object a(x r5, Continuation<? super z> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$submitAiProactiveUserRequirement$2(this, r5, null), Function2.class, "com.obric.memorydata.plugin"), r7);
    }

    @Override // com.obric.aiproactive.ui.data.b
    public Object a(String r5, String r6, Continuation<? super Unit> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$updateRecommendationActionExecuteInstruction$2(r5, r6, this, null), Function2.class, "com.obric.memorydata.plugin"), r8);
    }

    public Object a(String r5, Continuation<? super Boolean> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$cancelLocalAgentRun$2(this, r5, null), Function2.class, "com.obric.memorydata.plugin"), r7);
    }

    @Override // com.obric.aiproactive.ui.data.b
    public Object a(Continuation<? super Boolean> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$ensureAgreePrivacyAndLogin$2(this, null), Function2.class, "com.obric.memorydata.plugin"), r6);
    }

    @Override // com.obric.aiproactive.ui.data.b
    public kotlinx.coroutines.flow.i<ProactiveAllPageSnapshot> a() {
        PageType r0 = PageType.ALL;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[Repo] observeAllPage subscribe listenerType=" + r0.getListenerType(), false, 4, null);
        return k.a(k.f(k.b((Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$observeAllPage$1(this, null), Function2.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$observeAllPage$2(r0, null), Function2.class, "com.obric.memorydata.plugin")), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    public kotlinx.coroutines.flow.i<g> a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "executionId");
        return c.a(h(), r2);
    }

    @Override // com.obric.aiproactive.ui.data.b
    public void a(boolean r8) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[Repo] updateAiProactiveWakeUpEnabled enabled=" + r8, false, 4, null);
        IProactiveService r7 = h();
        if (r7 == null) goto L6;
        r7.updateAiProactiveWakeUpEnabled(r8);
        return;
    }

    @Override // com.obric.aiproactive.ui.data.b
    public Object b(long r5, Continuation<? super Boolean> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$awaitAiProactiveDbReady$2(r5, this, null), Function2.class, "com.obric.memorydata.plugin"), r8);
    }

    @Override // com.obric.aiproactive.ui.data.b
    public Object b(String r5, Continuation<? super String> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$findLatestDebugLogIdByRecommendId$2(this, r5, null), Function2.class, "com.obric.memorydata.plugin"), r7);
    }

    @Override // com.obric.aiproactive.ui.data.b
    public Object b(Continuation<? super Unit> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$initDefaultSubscriptions$2(this, null), Function2.class, "com.obric.memorydata.plugin"), r6);
    }

    @Override // com.obric.aiproactive.ui.data.b
    public kotlinx.coroutines.flow.i<Pair<Integer, List<p>>> b() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[Repo] observeTodayEventRecords subscribe", false, 4, null);
        return k.a(k.f(k.b((Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$observeTodayEventRecords$1(this, null), Function2.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$observeTodayEventRecords$2(null), Function2.class, "com.obric.memorydata.plugin")), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    public Object c(Continuation<? super Boolean> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, DefaultProactiveRepository$isAssistantSessionIdle$1.class) == false) goto L7;
        DefaultProactiveRepository$isAssistantSessionIdle$1 r0 = (DefaultProactiveRepository$isAssistantSessionIdle$1) ZeusTransformUtils.preCheckCast(r8, DefaultProactiveRepository$isAssistantSessionIdle$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L17:
        boolean r6 = ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[Repo] isAssistantSessionIdle result=" + r6, false, 4, null);
        return Boxing.boxBoolean(r6);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        CoroutineContext r10 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r11 = (Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$isAssistantSessionIdle$result$1(this, null), Function2.class, "com.obric.memorydata.plugin");
        r0.label = 1;
        r9 = i.a(r10, r11, r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new DefaultProactiveRepository$isAssistantSessionIdle$1(this, r8);
        goto L8
    }

    @Override // com.obric.aiproactive.ui.data.b
    public kotlinx.coroutines.flow.i<g> c() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[Repo] observeLatestAgentRun subscribe", false, 4, null);
        return k.a(k.f(k.b((Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$observeLatestAgentRun$1(this, null), Function2.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$observeLatestAgentRun$2(null), Function2.class, "com.obric.memorydata.plugin")), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiproactive.ui.data.b
    public g d() {
        IProactiveService r0 = h();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLatestAgentRun();
    }

    @Override // com.obric.aiproactive.ui.data.b
    public Object d(Continuation<? super AlgorithmTaskInvokeResult> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$triggerHiddenProactiveEntryFromAvatarFiveTap$2(this, null), Function2.class, "com.obric.memorydata.plugin"), r6);
    }

    @Override // com.obric.aiproactive.ui.data.b
    public kotlinx.coroutines.flow.i<List<ProactiveRecommendationDto>> e() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[Repo] observeAiProactiveRecommendations subscribe", false, 4, null);
        return k.a(k.f(k.b((Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$observeAiProactiveRecommendations$1(this, null), Function2.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$observeAiProactiveRecommendations$2(null), Function2.class, "com.obric.memorydata.plugin")), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiproactive.ui.data.b
    public boolean f() {
        IProactiveService r7 = h();
        if (r7 == null) goto L5;
        boolean r8 = r7.isAiProactiveEntryReady();
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[Repo] isAiProactiveEntryReady result=" + r8, false, 4, null);
        return r8;
    L5:
        r8 = false;
        goto L6
    }

    @Override // com.obric.aiproactive.ui.data.b
    public boolean g() {
        IProactiveService r7 = h();
        if (r7 == null) goto L5;
        boolean r8 = r7.isAiProactiveWakeUpEnabled();
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[Repo] isAiProactiveWakeUpEnabled result=" + r8, false, 4, null);
        return r8;
    L5:
        r8 = false;
        goto L6
    }
}
