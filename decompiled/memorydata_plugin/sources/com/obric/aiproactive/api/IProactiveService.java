package com.obric.aiproactive.api;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.news.common.service.manager.IService;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.entity.ChatMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011H&J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0013H&J\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0018H&J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H&J\u001c\u0010\u001b\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u001eH&J\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H&J\u0010\u0010$\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#H&J\u0010\u0010%\u001a\u00020\t2\u0006\u0010\"\u001a\u00020&H&J\u0010\u0010'\u001a\u00020\t2\u0006\u0010\"\u001a\u00020&H&J\u0010\u0010(\u001a\u00020\t2\u0006\u0010\"\u001a\u00020)H&J\u0010\u0010*\u001a\u00020\t2\u0006\u0010\"\u001a\u00020)H&J\u0010\u0010+\u001a\u00020\t2\u0006\u0010\"\u001a\u00020,H&J\u0010\u0010-\u001a\u00020\t2\u0006\u0010\"\u001a\u00020,H&J\n\u0010.\u001a\u0004\u0018\u00010/H&J\u0012\u00100\u001a\u0004\u0018\u00010/2\u0006\u00101\u001a\u00020\u0003H&J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020/H&J\u0010\u00105\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0003H&J\u0010\u00106\u001a\u00020\t2\u0006\u0010\"\u001a\u000207H&J\u0010\u00108\u001a\u00020\t2\u0006\u0010\"\u001a\u000207H&J\u0018\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H&J\u001a\u0010>\u001a\u00020\t2\u0006\u0010:\u001a\u00020;2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010?\u001a\u00020\t2\u0006\u0010:\u001a\u00020;H&J \u0010@\u001a\u00020\t2\u0006\u0010:\u001a\u00020;2\u0006\u0010A\u001a\u00020!2\u0006\u0010<\u001a\u00020=H&J\u0010\u0010B\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020CH&J\b\u0010D\u001a\u00020EH&J\b\u0010F\u001a\u00020GH&J\u0018\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020;2\u0006\u0010J\u001a\u00020;H&J\u0010\u0010K\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020LH&J\u0010\u0010M\u001a\u00020N2\u0006\u0010\u000b\u001a\u00020OH&J\u0016\u0010P\u001a\u00020\t2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00030RH&J*\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020;2\b\u0010V\u001a\u0004\u0018\u00010\u00032\u0006\u0010W\u001a\u00020!2\u0006\u0010 \u001a\u00020!H&J0\u0010X\u001a\u00020T2\u0006\u0010U\u001a\u00020;2\u0006\u0010I\u001a\u00020;2\u0006\u0010J\u001a\u00020;2\u0006\u0010W\u001a\u00020!2\u0006\u0010 \u001a\u00020!H&J\b\u0010Y\u001a\u00020\tH&J\u0010\u0010Z\u001a\u00020\u00072\u0006\u0010[\u001a\u00020;H&J\b\u0010\\\u001a\u00020\u0007H&J\b\u0010]\u001a\u00020\u0007H&J\u0010\u0010^\u001a\u00020\t2\u0006\u0010_\u001a\u00020\u0007H&J\u0018\u0010`\u001a\u00020\t2\u0006\u0010a\u001a\u00020\u00032\u0006\u0010b\u001a\u00020\u0003H&J\b\u0010c\u001a\u00020\u0007H&J\u0010\u0010d\u001a\u00020\u00072\u0006\u0010e\u001a\u00020\u0003H&J\u000e\u0010f\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010gJ\u0012\u0010h\u001a\u00020i2\b\u0010j\u001a\u0004\u0018\u00010\u0003H&J\b\u0010k\u001a\u00020iH&J\u000e\u0010l\u001a\b\u0012\u0004\u0012\u00020m0RH&J\u000e\u0010n\u001a\b\u0012\u0004\u0012\u00020o0RH&J\b\u0010p\u001a\u00020qH&J\u0012\u0010r\u001a\u0004\u0018\u00010o2\u0006\u0010s\u001a\u00020\u0003H&J\u001c\u0010t\u001a\b\u0012\u0004\u0012\u00020o0R2\f\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00030RH&J\u001c\u0010v\u001a\b\u0012\u0004\u0012\u00020o0R2\f\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00030RH&J\"\u0010w\u001a\u0004\u0018\u00010o2\u0006\u0010x\u001a\u00020\u00032\u0006\u0010s\u001a\u00020\u00032\u0006\u0010y\u001a\u00020zH&J\u0010\u0010{\u001a\u00020\u00072\u0006\u0010x\u001a\u00020\u0003H&J\b\u0010|\u001a\u00020;H&¨\u0006}"}, d2 = {"Lcom/obric/aiproactive/api/IProactiveService;", "Lcom/bytedance/news/common/service/manager/IService;", "prepareArtifactOpenLocator", "", "artifact", "Lcom/obric/aiproactive/api/AiProactiveArtifact;", "ensureAgreePrivacyAndLogin", "", "initDefaultSubscriptions", "", "toggleUserSubscription", Ext.KEY_REQUEST, "Lcom/obric/aiproactive/api/ToggleUserSubscriptionRequest;", "upsertUserSubscription", "dto", "Lcom/obric/aiproactive/api/ProactiveUserSubscriptionDto;", "listUserSubscriptions", "", "upsertSubscriptionTask", "Lcom/obric/aiproactive/api/ProactiveSubscriptionTaskDto;", "listSubscriptionTasks", "subscriptionId", "taskState", "upsertRecommendation", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "findLatestDebugLogIdByRecommendId", "recommendId", "updateRecommendationActionExecuteInstruction", "actionExecuteInstruction", "updateInspiration", "Lcom/obric/aiproactive/api/ProactiveInspirationDto;", "registerNowRecommendationsListener", "limit", "", "listener", "Lcom/obric/aiproactive/api/IProactiveNowRecommendationsListener;", "unregisterNowRecommendationsListener", "registerAllRecommendationsListener", "Lcom/obric/aiproactive/api/IProactiveAllRecommendationsListener;", "unregisterAllRecommendationsListener", "registerTodayEventRecordsListener", "Lcom/obric/aiproactive/api/AiProactiveTodayEventRecordsListener;", "unregisterTodayEventRecordsListener", "registerAgentRunListener", "Lcom/obric/aiproactive/api/AiProactiveAgentRunListener;", "unregisterAgentRunListener", "getLatestAgentRun", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;", "getAgentRun", "executionId", "getLocalAgentRunControlState", "Lcom/obric/aiproactive/api/AiProactiveAgentRunControlState;", "run", "cancelLocalAgentRun", "registerAiProactiveRecommendationsListener", "Lcom/obric/aiproactive/api/AiProactiveRecommendationsListener;", "unregisterAiProactiveRecommendationsListener", "updateAiProactiveRecommendationCardStatus", "recommendationId", "", "cardStatus", "Lcom/obric/aiproactive/api/AiProactiveCardStatus;", "updateAiProactiveRecommendationActionExecuteInstruction", "markAiProactiveRecommendationCurrentActionExecuted", "markAiProactiveRecommendationActionExecuted", "actionIndex", "updateAiProactiveRecommendationFeedback", "Lcom/obric/aiproactive/api/AiProactiveRecommendationFeedbackRequest;", "getAiProactiveLabelingFeedbackConfig", "Lcom/obric/aiproactive/api/AiProactiveLabelingFeedbackConfigDto;", "loadAllRecommendationsSnapshot", "Lcom/obric/aiproactive/api/ProactiveAllPageSnapshot;", "loadRecommendationsSnapshot", "earliestTimeMillis", "latestTimeMillis", "submitAiProactiveDirectFeedback", "Lcom/obric/aiproactive/api/AiProactiveDirectFeedbackRequest;", "submitAiProactiveUserRequirement", "Lcom/obric/aiproactive/api/AiProactiveUserRequirementResult;", "Lcom/obric/aiproactive/api/AiProactiveUserRequirementRequest;", "refreshAiProactive", "refreshTypes", "", "loadDayRecommendationsPage", "Lcom/obric/aiproactive/api/ProactiveDayPageResult;", "batchId", "dayKey", TypedValues.CycleType.S_WAVE_OFFSET, "loadRecommendationsPage", "ensureAiProactiveDbReady", "awaitAiProactiveDbReady", "timeoutMs", "isAiProactiveEntryReady", "isAiProactiveWakeUpEnabled", "updateAiProactiveWakeUpEnabled", "enabled", "notifyDoubaoGlassesState", "key", EventBody.KEY_VALUE, "tryActiveAiProactiveAssistantVoiceEntry", "tryActiveAiProactiveAssistantQuery", ChatMessage.TYPE_QUERY, "isAssistantSessionIdle", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeAlgorithmTask", "Lcom/obric/aiproactive/api/AlgorithmTaskInvokeResult;", "jsonString", "triggerHiddenProactiveEntryFromAvatarFiveTap", "getProactivePreferenceExamples", "Lcom/obric/aiproactive/api/AiProactivePreferenceExampleDto;", "getAiRules", "Lcom/obric/aiproactive/api/AiRuleItemDto;", "getAiRuleFollowupCounts", "Lcom/obric/aiproactive/api/AiRuleFollowupCountDto;", "addAiRule", Params.CONTENT, "addAiGeneratedRules", "contents", "addInterviewGeneratedRules", "updateAiRule", "ruleId", "type", "Lcom/obric/aiproactive/api/AiRuleItemDto$RuleType;", "deleteAiRule", "getLatestAiRuleUpdateTimestamp", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IProactiveService extends IService {
    List<AiRuleItemDto> addAiGeneratedRules(List<String> r1);

    AiRuleItemDto addAiRule(String r1);

    List<AiRuleItemDto> addInterviewGeneratedRules(List<String> r1);

    boolean awaitAiProactiveDbReady(long r1);

    boolean cancelLocalAgentRun(String r1);

    boolean deleteAiRule(String r1);

    boolean ensureAgreePrivacyAndLogin();

    void ensureAiProactiveDbReady();

    String findLatestDebugLogIdByRecommendId(String r1);

    g getAgentRun(String r1);

    s getAiProactiveLabelingFeedbackConfig();

    aa getAiRuleFollowupCounts();

    List<AiRuleItemDto> getAiRules();

    g getLatestAgentRun();

    long getLatestAiRuleUpdateTimestamp();

    e getLocalAgentRunControlState(g r1);

    List<AiProactivePreferenceExampleDto> getProactivePreferenceExamples();

    void initDefaultSubscriptions();

    AlgorithmTaskInvokeResult invokeAlgorithmTask(String r1);

    boolean isAiProactiveEntryReady();

    boolean isAiProactiveWakeUpEnabled();

    Object isAssistantSessionIdle(Continuation<? super Boolean> r1);

    List<ProactiveSubscriptionTaskDto> listSubscriptionTasks(String r1, String r2);

    List<ProactiveUserSubscriptionDto> listUserSubscriptions();

    ProactiveAllPageSnapshot loadAllRecommendationsSnapshot();

    ProactiveDayPageResult loadDayRecommendationsPage(long r1, String r3, int r4, int r5);

    ProactiveDayPageResult loadRecommendationsPage(long r1, long r3, long r5, int r7, int r8);

    ProactiveAllPageSnapshot loadRecommendationsSnapshot(long r1, long r3);

    void markAiProactiveRecommendationActionExecuted(long r1, int r3, AiProactiveCardStatus r4);

    void markAiProactiveRecommendationCurrentActionExecuted(long r1);

    void notifyDoubaoGlassesState(String r1, String r2);

    String prepareArtifactOpenLocator(j r1);

    void refreshAiProactive(List<String> r1);

    void registerAgentRunListener(h r1);

    void registerAiProactiveRecommendationsListener(v r1);

    void registerAllRecommendationsListener(ac r1);

    void registerNowRecommendationsListener(int r1, ad r2);

    void registerTodayEventRecordsListener(w r1);

    void submitAiProactiveDirectFeedback(o r1);

    z submitAiProactiveUserRequirement(x r1);

    void toggleUserSubscription(ToggleUserSubscriptionRequest r1);

    AlgorithmTaskInvokeResult triggerHiddenProactiveEntryFromAvatarFiveTap();

    boolean tryActiveAiProactiveAssistantQuery(String r1);

    boolean tryActiveAiProactiveAssistantVoiceEntry();

    void unregisterAgentRunListener(h r1);

    void unregisterAiProactiveRecommendationsListener(v r1);

    void unregisterAllRecommendationsListener(ac r1);

    void unregisterNowRecommendationsListener(ad r1);

    void unregisterTodayEventRecordsListener(w r1);

    void updateAiProactiveRecommendationActionExecuteInstruction(long r1, String r3);

    void updateAiProactiveRecommendationCardStatus(long r1, AiProactiveCardStatus r3);

    void updateAiProactiveRecommendationFeedback(u r1);

    void updateAiProactiveWakeUpEnabled(boolean r1);

    AiRuleItemDto updateAiRule(String r1, String r2, AiRuleItemDto.RuleType r3);

    void updateInspiration(ProactiveInspirationDto r1);

    void updateRecommendationActionExecuteInstruction(String r1, String r2);

    void upsertRecommendation(ProactiveRecommendationDto r1);

    void upsertSubscriptionTask(ProactiveSubscriptionTaskDto r1);

    void upsertUserSubscription(ProactiveUserSubscriptionDto r1);
}
