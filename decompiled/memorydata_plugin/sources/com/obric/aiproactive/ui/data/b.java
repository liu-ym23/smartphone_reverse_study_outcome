package com.obric.aiproactive.ui.data;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.aiproactive.api.AiProactiveCardStatus;
import com.obric.aiproactive.api.AlgorithmTaskInvokeResult;
import com.obric.aiproactive.api.ProactiveAllPageSnapshot;
import com.obric.aiproactive.api.ProactiveDayPageResult;
import com.obric.aiproactive.api.ProactiveInspirationDto;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.aiproactive.api.g;
import com.obric.aiproactive.api.o;
import com.obric.aiproactive.api.p;
import com.obric.aiproactive.api.u;
import com.obric.aiproactive.api.x;
import com.obric.aiproactive.api.z;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H&J.\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H¦@¢\u0006\u0002\u0010\u0018J \u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011H¦@¢\u0006\u0002\u0010\u001cJ \u0010\u001d\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00040\u001e0\u0003H&J\u0010\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u0003H&J\u0018\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u00032\u0006\u0010#\u001a\u00020\u0011H&J\n\u0010$\u001a\u0004\u0018\u00010!H&J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020!H&J\u0016\u0010(\u001a\u00020)2\u0006\u0010#\u001a\u00020\u0011H¦@¢\u0006\u0002\u0010*J\u0014\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u001e\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020/H¦@¢\u0006\u0002\u00100J \u00101\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011H¦@¢\u0006\u0002\u00102J\u0016\u00103\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u000fH¦@¢\u0006\u0002\u00104J&\u00105\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u000f2\u0006\u00106\u001a\u00020\u00072\u0006\u0010.\u001a\u00020/H¦@¢\u0006\u0002\u00107J\u0016\u00108\u001a\u00020\u00152\u0006\u00109\u001a\u00020:H¦@¢\u0006\u0002\u0010;J\u0016\u0010<\u001a\u00020\u00152\u0006\u00109\u001a\u00020=H¦@¢\u0006\u0002\u0010>J\u0016\u0010?\u001a\u00020@2\u0006\u00109\u001a\u00020AH¦@¢\u0006\u0002\u0010BJ\u0016\u0010C\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020DH¦@¢\u0006\u0002\u0010EJ\u000e\u0010F\u001a\u00020)H¦@¢\u0006\u0002\u0010GJ\u000e\u0010H\u001a\u00020\u0015H¦@¢\u0006\u0002\u0010GJ\u0018\u0010I\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001a\u001a\u00020\u0011H¦@¢\u0006\u0002\u0010*J\u0016\u0010J\u001a\u00020\u00152\u0006\u00109\u001a\u00020KH¦@¢\u0006\u0002\u0010LJ\u0014\u0010M\u001a\b\u0012\u0004\u0012\u00020D0\u0004H¦@¢\u0006\u0002\u0010GJ\u000e\u0010N\u001a\u00020\u0015H¦@¢\u0006\u0002\u0010GJ\u0018\u0010O\u001a\u00020)2\b\b\u0002\u0010P\u001a\u00020\u000fH¦@¢\u0006\u0002\u00104J\b\u0010Q\u001a\u00020)H&J\u000e\u0010R\u001a\u00020)H¦@¢\u0006\u0002\u0010GJ\u000e\u0010S\u001a\u00020)H¦@¢\u0006\u0002\u0010GJ\b\u0010T\u001a\u00020)H&J\u0010\u0010U\u001a\u00020\u00152\u0006\u0010V\u001a\u00020)H&J\u0016\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u0011H¦@¢\u0006\u0002\u0010*J\u000e\u0010Z\u001a\u00020XH¦@¢\u0006\u0002\u0010G¨\u0006["}, d2 = {"Lcom/obric/aiproactive/ui/data/ProactiveRepository;", "", "observeNowPage", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "limit", "", "observeNowPageSnapshot", "Lcom/obric/aiproactive/api/ProactiveNowPageSnapshot;", "observeAllPage", "Lcom/obric/aiproactive/api/ProactiveAllPageSnapshot;", "loadDayRecommendationsPage", "Lcom/obric/aiproactive/api/ProactiveDayPageResult;", "batchId", "", "dayKey", "", TypedValues.CycleType.S_WAVE_OFFSET, "(JLjava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateInspiration", "", "dto", "Lcom/obric/aiproactive/api/ProactiveInspirationDto;", "(Lcom/obric/aiproactive/api/ProactiveInspirationDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRecommendationActionExecuteInstruction", "recommendId", "actionExecuteInstruction", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeTodayEventRecords", "Lkotlin/Pair;", "Lcom/obric/aiproactive/api/AiProactiveEventRecordDto;", "observeLatestAgentRun", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;", "observeAgentRun", "executionId", "getLatestAgentRun", "getLocalAgentRunControlState", "Lcom/obric/aiproactive/api/AiProactiveAgentRunControlState;", "run", "cancelLocalAgentRun", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeAiProactiveRecommendations", "updateAiProactiveRecommendationCardStatus", "recommendationId", "cardStatus", "Lcom/obric/aiproactive/api/AiProactiveCardStatus;", "(JLcom/obric/aiproactive/api/AiProactiveCardStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAiProactiveRecommendationActionExecuteInstruction", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAiProactiveRecommendationCurrentActionExecuted", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAiProactiveRecommendationActionExecuted", "actionIndex", "(JILcom/obric/aiproactive/api/AiProactiveCardStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAiProactiveRecommendationFeedback", Ext.KEY_REQUEST, "Lcom/obric/aiproactive/api/AiProactiveRecommendationFeedbackRequest;", "(Lcom/obric/aiproactive/api/AiProactiveRecommendationFeedbackRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitAiProactiveDirectFeedback", "Lcom/obric/aiproactive/api/AiProactiveDirectFeedbackRequest;", "(Lcom/obric/aiproactive/api/AiProactiveDirectFeedbackRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitAiProactiveUserRequirement", "Lcom/obric/aiproactive/api/AiProactiveUserRequirementResult;", "Lcom/obric/aiproactive/api/AiProactiveUserRequirementRequest;", "(Lcom/obric/aiproactive/api/AiProactiveUserRequirementRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertUserSubscription", "Lcom/obric/aiproactive/api/ProactiveUserSubscriptionDto;", "(Lcom/obric/aiproactive/api/ProactiveUserSubscriptionDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureAgreePrivacyAndLogin", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initDefaultSubscriptions", "findLatestDebugLogIdByRecommendId", "toggleUserSubscription", "Lcom/obric/aiproactive/api/ToggleUserSubscriptionRequest;", "(Lcom/obric/aiproactive/api/ToggleUserSubscriptionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listUserSubscriptions", "ensureAiProactiveDbReady", "awaitAiProactiveDbReady", "timeoutMs", "isAiProactiveEntryReady", "tryActiveAiProactiveAssistantVoiceEntry", "isAssistantSessionIdle", "isAiProactiveWakeUpEnabled", "updateAiProactiveWakeUpEnabled", "enabled", "invokeAlgorithmTask", "Lcom/obric/aiproactive/api/AlgorithmTaskInvokeResult;", "jsonString", "triggerHiddenProactiveEntryFromAvatarFiveTap", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface b {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ Object a(b r2, long r3, Continuation r5, int r6, Object r7) {
            b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
            Continuation<? super Boolean> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 1) == 0) goto L8;
            r3 = 5000;
        L8:
            return r4.b(r3, r8);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitAiProactiveDbReady");
        }
    }

    Object a(long r1, int r3, AiProactiveCardStatus r4, Continuation<? super Unit> r5);

    Object a(long r1, AiProactiveCardStatus r3, Continuation<? super Unit> r4);

    Object a(long r1, String r3, int r4, int r5, Continuation<? super ProactiveDayPageResult> r6);

    Object a(long r1, String r3, Continuation<? super Unit> r4);

    Object a(long r1, Continuation<? super Unit> r3);

    Object a(ProactiveInspirationDto r1, Continuation<? super Unit> r2);

    Object a(o r1, Continuation<? super Unit> r2);

    Object a(u r1, Continuation<? super Unit> r2);

    Object a(x r1, Continuation<? super z> r2);

    Object a(String r1, String r2, Continuation<? super Unit> r3);

    Object a(Continuation<? super Boolean> r1);

    i<ProactiveAllPageSnapshot> a();

    void a(boolean r1);

    Object b(long r1, Continuation<? super Boolean> r3);

    Object b(String r1, Continuation<? super String> r2);

    Object b(Continuation<? super Unit> r1);

    i<Pair<Integer, List<p>>> b();

    i<g> c();

    g d();

    Object d(Continuation<? super AlgorithmTaskInvokeResult> r1);

    i<List<ProactiveRecommendationDto>> e();

    boolean f();

    boolean g();
}
