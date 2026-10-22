package com.bytedance.rpc.model.rpc;

import com.bytedance.rpc.RpcService;
import com.bytedance.rpc.annotation.RpcOperation;
import com.bytedance.rpc.annotation.RpcParams;
import com.bytedance.rpc.annotation.RpcSerializer;
import com.bytedance.rpc.callback.RpcCallback;
import com.bytedance.rpc.model.AdditionTaskRequest;
import com.bytedance.rpc.model.AdditionTaskResponse;
import com.bytedance.rpc.model.AskUserRequest;
import com.bytedance.rpc.model.AskUserResponse;
import com.bytedance.rpc.model.CheckAssistantVersionRequest;
import com.bytedance.rpc.model.CheckAssistantVersionResponse;
import com.bytedance.rpc.model.ClearTaskRequest;
import com.bytedance.rpc.model.ClearTaskResponse;
import com.bytedance.rpc.model.ConditionalTaskCreateRequest;
import com.bytedance.rpc.model.ConditionalTaskCreateResponse;
import com.bytedance.rpc.model.ConditionalTaskDeleteRequest;
import com.bytedance.rpc.model.ConditionalTaskDeleteResponse;
import com.bytedance.rpc.model.ConditionalTaskSweepRequest;
import com.bytedance.rpc.model.ConditionalTaskSweepResponse;
import com.bytedance.rpc.model.ExecuteLocalPluginRequest;
import com.bytedance.rpc.model.ExecuteLocalPluginResponse;
import com.bytedance.rpc.model.GetInfoRequest;
import com.bytedance.rpc.model.GetInfoResponse;
import com.bytedance.rpc.model.GetOmniModelConfigRequest;
import com.bytedance.rpc.model.GetOmniModelConfigResponse;
import com.bytedance.rpc.model.GetOperationInstructionRequest;
import com.bytedance.rpc.model.GetOperationInstructionResponse;
import com.bytedance.rpc.model.ListOMNISkillRequest;
import com.bytedance.rpc.model.ListOMNISkillResponse;
import com.bytedance.rpc.model.ListSpellSkillRequest;
import com.bytedance.rpc.model.ListSpellSkillResponse;
import com.bytedance.rpc.model.LoadOMNISkillRequest;
import com.bytedance.rpc.model.LoadOMNISkillResponse;
import com.bytedance.rpc.model.LoadSpellSkillRequest;
import com.bytedance.rpc.model.LoadSpellSkillResponse;
import com.bytedance.rpc.model.MockFunctionCallRequest;
import com.bytedance.rpc.model.MockFunctionCallResponse;
import com.bytedance.rpc.model.OmniRLToolExecutePostprocessRequest;
import com.bytedance.rpc.model.OperateQueueRequest;
import com.bytedance.rpc.model.OperateQueueResponse;
import com.bytedance.rpc.model.QueryQueueRequest;
import com.bytedance.rpc.model.QueryQueueResponse;
import com.bytedance.rpc.model.RelevanceJudgmentRequest;
import com.bytedance.rpc.model.RelevanceJudgmentResponse;
import com.bytedance.rpc.model.RouterRequest;
import com.bytedance.rpc.model.RouterResponse;
import com.bytedance.rpc.model.StopTaskRequest;
import com.bytedance.rpc.model.StopTaskResponse;
import com.bytedance.rpc.model.TakeOverRequest;
import com.bytedance.rpc.model.TakeOverResponse;
import com.bytedance.rpc.model.ToolCallReq;
import com.bytedance.rpc.model.ToolCallResp;
import com.bytedance.rpc.model.ToolListReq;
import com.bytedance.rpc.model.ToolListResp;
import com.bytedance.rpc.model.UploadScreenShotFeedbackRequest;
import com.bytedance.rpc.model.UploadScreenShotFeedbackResponse;
import com.bytedance.rpc.model.UploadUserPortraitRequest;
import com.bytedance.rpc.model.UploadUserPortraitResponse;
import com.bytedance.rpc.serialize.SerializeType;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class AssistantGatewayService {

    private interface AssistantGatewayServiceApi {
        public static final Class clazz = null;

        static {
            clazz = SerializeType.class;
        }

        @RpcOperation("$POST /assistant/multi_agent/addition_task")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void additionTaskAsync(AdditionTaskRequest r1, RpcCallback<AdditionTaskResponse> r2);

        @RpcOperation("$POST /assistant/multi_agent/addition_task")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        AdditionTaskResponse additionTaskSync(AdditionTaskRequest r1);

        @RpcOperation("$POST /assistant/multi_agent/ask_user")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void askUserAsync(AskUserRequest r1, RpcCallback<AskUserResponse> r2);

        @RpcOperation("$POST /assistant/multi_agent/ask_user")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        AskUserResponse askUserSync(AskUserRequest r1);

        @RpcOperation("$POST /assistant/normal/check_assistant_version")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void checkAssistantVersionAsync(CheckAssistantVersionRequest r1, RpcCallback<CheckAssistantVersionResponse> r2);

        @RpcOperation("$POST /assistant/normal/check_assistant_version")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        CheckAssistantVersionResponse checkAssistantVersionSync(CheckAssistantVersionRequest r1);

        @RpcOperation("$POST /assistant/multi_agent/clear_task")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void clearTaskAsync(ClearTaskRequest r1, RpcCallback<ClearTaskResponse> r2);

        @RpcOperation("$POST /assistant/multi_agent/clear_task")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        ClearTaskResponse clearTaskSync(ClearTaskRequest r1);

        @RpcOperation("$POST /assistant/multi_agent/create_conditional_task")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void conditionalTaskCreateAsync(ConditionalTaskCreateRequest r1, RpcCallback<ConditionalTaskCreateResponse> r2);

        @RpcOperation("$POST /assistant/multi_agent/create_conditional_task")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        ConditionalTaskCreateResponse conditionalTaskCreateSync(ConditionalTaskCreateRequest r1);

        @RpcOperation("$POST /assistant/multi_agent/delete_conditional_task")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void conditionalTaskDeleteAsync(ConditionalTaskDeleteRequest r1, RpcCallback<ConditionalTaskDeleteResponse> r2);

        @RpcOperation("$POST /assistant/multi_agent/delete_conditional_task")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        ConditionalTaskDeleteResponse conditionalTaskDeleteSync(ConditionalTaskDeleteRequest r1);

        @RpcOperation("$POST /assistant/multi_agent/sweep_conditional_task")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void conditionalTaskSweepAsync(ConditionalTaskSweepRequest r1, RpcCallback<ConditionalTaskSweepResponse> r2);

        @RpcOperation("$POST /assistant/multi_agent/sweep_conditional_task")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        ConditionalTaskSweepResponse conditionalTaskSweepSync(ConditionalTaskSweepRequest r1);

        @RpcOperation("$POST /assistant/multi_agent/get_info")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void getInfoAsync(GetInfoRequest r1, RpcCallback<GetInfoResponse> r2);

        @RpcOperation("$POST /assistant/multi_agent/get_info")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        GetInfoResponse getInfoSync(GetInfoRequest r1);

        @RpcOperation("$GET /assistant/multi_agent/omni_model_config")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void getOmniModelConfigAsync(GetOmniModelConfigRequest r1, RpcCallback<GetOmniModelConfigResponse> r2);

        @RpcOperation("$GET /assistant/multi_agent/omni_model_config")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        GetOmniModelConfigResponse getOmniModelConfigSync(GetOmniModelConfigRequest r1);

        @RpcOperation("$GET /assistant/multi_agent/operation_instruction")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void getOperationInstructionAsync(GetOperationInstructionRequest r1, RpcCallback<GetOperationInstructionResponse> r2);

        @RpcOperation("$GET /assistant/multi_agent/operation_instruction")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        GetOperationInstructionResponse getOperationInstructionSync(GetOperationInstructionRequest r1);

        @RpcOperation("$POST /assistant/normal/mock_function_call")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void mockFunctionCallAsync(MockFunctionCallRequest r1, RpcCallback<MockFunctionCallResponse> r2);

        @RpcOperation("$POST /assistant/normal/mock_function_call")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        MockFunctionCallResponse mockFunctionCallSync(MockFunctionCallRequest r1);

        @RpcOperation("$POST /assistant/tool_service/omni/list_skill")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void oMNISkillListAsync(ListOMNISkillRequest r1, RpcCallback<ListOMNISkillResponse> r2);

        @RpcOperation("$POST /assistant/tool_service/omni/list_skill")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        ListOMNISkillResponse oMNISkillListSync(ListOMNISkillRequest r1);

        @RpcOperation("$POST /assistant/tool_service/omni/load_skill")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void oMNISkillLoadAsync(LoadOMNISkillRequest r1, RpcCallback<LoadOMNISkillResponse> r2);

        @RpcOperation("$POST /assistant/tool_service/omni/load_skill")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        LoadOMNISkillResponse oMNISkillLoadSync(LoadOMNISkillRequest r1);

        @RpcOperation("$POST /assistant/multi_agent/operate_queue")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void operateQueueAsync(OperateQueueRequest r1, RpcCallback<OperateQueueResponse> r2);

        @RpcOperation("$POST /assistant/multi_agent/operate_queue")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        OperateQueueResponse operateQueueSync(OperateQueueRequest r1);

        @RpcOperation("$POST /assistant/multi_agent/query_queue")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void queryQueueAsync(QueryQueueRequest r1, RpcCallback<QueryQueueResponse> r2);

        @RpcOperation("$POST /assistant/multi_agent/query_queue")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        QueryQueueResponse queryQueueSync(QueryQueueRequest r1);

        @RpcOperation("$POST /assistant/normal/relevance_judgment")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void relevanceJudgmentAsync(RelevanceJudgmentRequest r1, RpcCallback<RelevanceJudgmentResponse> r2);

        @RpcOperation("$POST /assistant/normal/relevance_judgment")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        RelevanceJudgmentResponse relevanceJudgmentSync(RelevanceJudgmentRequest r1);

        @RpcOperation("$POST /assistant/normal/router")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void routerAsync(RouterRequest r1, RpcCallback<RouterResponse> r2);

        @RpcOperation("$POST /assistant/normal/router")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        RouterResponse routerSync(RouterRequest r1);

        @RpcOperation("$POST /assistant/tool_service/spell/list_skill")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void spellSkillListAsync(ListSpellSkillRequest r1, RpcCallback<ListSpellSkillResponse> r2);

        @RpcOperation("$POST /assistant/tool_service/spell/list_skill")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        ListSpellSkillResponse spellSkillListSync(ListSpellSkillRequest r1);

        @RpcOperation("$POST /assistant/tool_service/spell/load_skill")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void spellSkillLoadAsync(LoadSpellSkillRequest r1, RpcCallback<LoadSpellSkillResponse> r2);

        @RpcOperation("$POST /assistant/tool_service/spell/load_skill")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        LoadSpellSkillResponse spellSkillLoadSync(LoadSpellSkillRequest r1);

        @RpcOperation("$POST /assistant/multi_agent/stop_task")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void stopTaskAsync(StopTaskRequest r1, RpcCallback<StopTaskResponse> r2);

        @RpcOperation("$POST /assistant/multi_agent/stop_task")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        StopTaskResponse stopTaskSync(StopTaskRequest r1);

        @RpcOperation("$POST /assistant/multi_agent/take_over")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void takeOverAsync(TakeOverRequest r1, RpcCallback<TakeOverResponse> r2);

        @RpcOperation("$POST /assistant/multi_agent/take_over")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        TakeOverResponse takeOverSync(TakeOverRequest r1);

        @RpcOperation("$POST /assistant/tool_service/mcp/tool_call")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void toolServiceMCPToolCallAsync(ToolCallReq r1, RpcCallback<ToolCallResp> r2);

        @RpcOperation("$POST /assistant/tool_service/mcp/tool_call")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        ToolCallResp toolServiceMCPToolCallSync(ToolCallReq r1);

        @RpcOperation("$POST /assistant/tool_service/mcp/tool_list")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void toolServiceMCPToolListAsync(ToolListReq r1, RpcCallback<ToolListResp> r2);

        @RpcOperation("$POST /assistant/tool_service/mcp/tool_list")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        ToolListResp toolServiceMCPToolListSync(ToolListReq r1);

        @RpcOperation("$POST /assistant/tool_service/post_process")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void toolServicePostProcessAsync(OmniRLToolExecutePostprocessRequest r1, RpcCallback<ExecuteLocalPluginResponse> r2);

        @RpcOperation("$POST /assistant/tool_service/post_process")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        ExecuteLocalPluginResponse toolServicePostProcessSync(OmniRLToolExecutePostprocessRequest r1);

        @RpcOperation("$POST /assistant/tool_service/pre_process")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void toolServicePreProcessAsync(ExecuteLocalPluginRequest r1, RpcCallback<ExecuteLocalPluginResponse> r2);

        @RpcOperation("$POST /assistant/tool_service/pre_process")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        ExecuteLocalPluginResponse toolServicePreProcessSync(ExecuteLocalPluginRequest r1);

        @RpcOperation("$POST /assistant/normal/upload_screen_shot_feedback")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void uploadScreenShotFeedbackAsync(UploadScreenShotFeedbackRequest r1, RpcCallback<UploadScreenShotFeedbackResponse> r2);

        @RpcOperation("$POST /assistant/normal/upload_screen_shot_feedback")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        UploadScreenShotFeedbackResponse uploadScreenShotFeedbackSync(UploadScreenShotFeedbackRequest r1);

        @RpcOperation("$POST /assistant/qa_search/upload_user_portrait")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        void uploadUserPortraitAsync(UploadUserPortraitRequest r1, RpcCallback<UploadUserPortraitResponse> r2);

        @RpcOperation("$POST /assistant/qa_search/upload_user_portrait")
        @RpcParams(true)
        @RpcSerializer(SerializeType.JSON)
        UploadUserPortraitResponse uploadUserPortraitSync(UploadUserPortraitRequest r1);
    }

    public AssistantGatewayService() {
    }

    public static void additionTaskAsync(AdditionTaskRequest r2, RpcCallback<AdditionTaskResponse> r3) {
        RpcCallback<AdditionTaskResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().additionTaskAsync(r2, r4);
    }

    public static AdditionTaskResponse additionTaskSync(AdditionTaskRequest r1) {
        return getApi().additionTaskSync(r1);
    }

    public static void askUserAsync(AskUserRequest r2, RpcCallback<AskUserResponse> r3) {
        RpcCallback<AskUserResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().askUserAsync(r2, r4);
    }

    public static AskUserResponse askUserSync(AskUserRequest r1) {
        return getApi().askUserSync(r1);
    }

    public static void checkAssistantVersionAsync(CheckAssistantVersionRequest r2, RpcCallback<CheckAssistantVersionResponse> r3) {
        RpcCallback<CheckAssistantVersionResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().checkAssistantVersionAsync(r2, r4);
    }

    public static CheckAssistantVersionResponse checkAssistantVersionSync(CheckAssistantVersionRequest r1) {
        return getApi().checkAssistantVersionSync(r1);
    }

    public static void clearTaskAsync(ClearTaskRequest r2, RpcCallback<ClearTaskResponse> r3) {
        RpcCallback<ClearTaskResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().clearTaskAsync(r2, r4);
    }

    public static ClearTaskResponse clearTaskSync(ClearTaskRequest r1) {
        return getApi().clearTaskSync(r1);
    }

    public static void conditionalTaskCreateAsync(ConditionalTaskCreateRequest r2, RpcCallback<ConditionalTaskCreateResponse> r3) {
        RpcCallback<ConditionalTaskCreateResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().conditionalTaskCreateAsync(r2, r4);
    }

    public static ConditionalTaskCreateResponse conditionalTaskCreateSync(ConditionalTaskCreateRequest r1) {
        return getApi().conditionalTaskCreateSync(r1);
    }

    public static void conditionalTaskDeleteAsync(ConditionalTaskDeleteRequest r2, RpcCallback<ConditionalTaskDeleteResponse> r3) {
        RpcCallback<ConditionalTaskDeleteResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().conditionalTaskDeleteAsync(r2, r4);
    }

    public static ConditionalTaskDeleteResponse conditionalTaskDeleteSync(ConditionalTaskDeleteRequest r1) {
        return getApi().conditionalTaskDeleteSync(r1);
    }

    public static void conditionalTaskSweepAsync(ConditionalTaskSweepRequest r2, RpcCallback<ConditionalTaskSweepResponse> r3) {
        RpcCallback<ConditionalTaskSweepResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().conditionalTaskSweepAsync(r2, r4);
    }

    public static ConditionalTaskSweepResponse conditionalTaskSweepSync(ConditionalTaskSweepRequest r1) {
        return getApi().conditionalTaskSweepSync(r1);
    }

    private static AssistantGatewayServiceApi getApi() {
        return (AssistantGatewayServiceApi) ZeusTransformUtils.preCheckCast(RpcService.getProxy(AssistantGatewayServiceApi.class), AssistantGatewayServiceApi.class, "com.obric.memorydata.plugin");
    }

    public static Class<?> getApiClass() {
        return AssistantGatewayServiceApi.class;
    }

    public static void getInfoAsync(GetInfoRequest r2, RpcCallback<GetInfoResponse> r3) {
        RpcCallback<GetInfoResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().getInfoAsync(r2, r4);
    }

    public static GetInfoResponse getInfoSync(GetInfoRequest r1) {
        return getApi().getInfoSync(r1);
    }

    public static void getOmniModelConfigAsync(GetOmniModelConfigRequest r2, RpcCallback<GetOmniModelConfigResponse> r3) {
        RpcCallback<GetOmniModelConfigResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().getOmniModelConfigAsync(r2, r4);
    }

    public static GetOmniModelConfigResponse getOmniModelConfigSync(GetOmniModelConfigRequest r1) {
        return getApi().getOmniModelConfigSync(r1);
    }

    public static void getOperationInstructionAsync(GetOperationInstructionRequest r2, RpcCallback<GetOperationInstructionResponse> r3) {
        RpcCallback<GetOperationInstructionResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().getOperationInstructionAsync(r2, r4);
    }

    public static GetOperationInstructionResponse getOperationInstructionSync(GetOperationInstructionRequest r1) {
        return getApi().getOperationInstructionSync(r1);
    }

    public static void mockFunctionCallAsync(MockFunctionCallRequest r2, RpcCallback<MockFunctionCallResponse> r3) {
        RpcCallback<MockFunctionCallResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().mockFunctionCallAsync(r2, r4);
    }

    public static MockFunctionCallResponse mockFunctionCallSync(MockFunctionCallRequest r1) {
        return getApi().mockFunctionCallSync(r1);
    }

    public static void oMNISkillListAsync(ListOMNISkillRequest r2, RpcCallback<ListOMNISkillResponse> r3) {
        RpcCallback<ListOMNISkillResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().oMNISkillListAsync(r2, r4);
    }

    public static ListOMNISkillResponse oMNISkillListSync(ListOMNISkillRequest r1) {
        return getApi().oMNISkillListSync(r1);
    }

    public static void oMNISkillLoadAsync(LoadOMNISkillRequest r2, RpcCallback<LoadOMNISkillResponse> r3) {
        RpcCallback<LoadOMNISkillResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().oMNISkillLoadAsync(r2, r4);
    }

    public static LoadOMNISkillResponse oMNISkillLoadSync(LoadOMNISkillRequest r1) {
        return getApi().oMNISkillLoadSync(r1);
    }

    public static void operateQueueAsync(OperateQueueRequest r2, RpcCallback<OperateQueueResponse> r3) {
        RpcCallback<OperateQueueResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().operateQueueAsync(r2, r4);
    }

    public static OperateQueueResponse operateQueueSync(OperateQueueRequest r1) {
        return getApi().operateQueueSync(r1);
    }

    public static void queryQueueAsync(QueryQueueRequest r2, RpcCallback<QueryQueueResponse> r3) {
        RpcCallback<QueryQueueResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().queryQueueAsync(r2, r4);
    }

    public static QueryQueueResponse queryQueueSync(QueryQueueRequest r1) {
        return getApi().queryQueueSync(r1);
    }

    public static void relevanceJudgmentAsync(RelevanceJudgmentRequest r2, RpcCallback<RelevanceJudgmentResponse> r3) {
        RpcCallback<RelevanceJudgmentResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().relevanceJudgmentAsync(r2, r4);
    }

    public static RelevanceJudgmentResponse relevanceJudgmentSync(RelevanceJudgmentRequest r1) {
        return getApi().relevanceJudgmentSync(r1);
    }

    public static void routerAsync(RouterRequest r2, RpcCallback<RouterResponse> r3) {
        RpcCallback<RouterResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().routerAsync(r2, r4);
    }

    public static RouterResponse routerSync(RouterRequest r1) {
        return getApi().routerSync(r1);
    }

    public static void spellSkillListAsync(ListSpellSkillRequest r2, RpcCallback<ListSpellSkillResponse> r3) {
        RpcCallback<ListSpellSkillResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().spellSkillListAsync(r2, r4);
    }

    public static ListSpellSkillResponse spellSkillListSync(ListSpellSkillRequest r1) {
        return getApi().spellSkillListSync(r1);
    }

    public static void spellSkillLoadAsync(LoadSpellSkillRequest r2, RpcCallback<LoadSpellSkillResponse> r3) {
        RpcCallback<LoadSpellSkillResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().spellSkillLoadAsync(r2, r4);
    }

    public static LoadSpellSkillResponse spellSkillLoadSync(LoadSpellSkillRequest r1) {
        return getApi().spellSkillLoadSync(r1);
    }

    public static void stopTaskAsync(StopTaskRequest r2, RpcCallback<StopTaskResponse> r3) {
        RpcCallback<StopTaskResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().stopTaskAsync(r2, r4);
    }

    public static StopTaskResponse stopTaskSync(StopTaskRequest r1) {
        return getApi().stopTaskSync(r1);
    }

    public static void takeOverAsync(TakeOverRequest r2, RpcCallback<TakeOverResponse> r3) {
        RpcCallback<TakeOverResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().takeOverAsync(r2, r4);
    }

    public static TakeOverResponse takeOverSync(TakeOverRequest r1) {
        return getApi().takeOverSync(r1);
    }

    public static void toolServiceMCPToolCallAsync(ToolCallReq r2, RpcCallback<ToolCallResp> r3) {
        RpcCallback<ToolCallResp> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().toolServiceMCPToolCallAsync(r2, r4);
    }

    public static ToolCallResp toolServiceMCPToolCallSync(ToolCallReq r1) {
        return getApi().toolServiceMCPToolCallSync(r1);
    }

    public static void toolServiceMCPToolListAsync(ToolListReq r2, RpcCallback<ToolListResp> r3) {
        RpcCallback<ToolListResp> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().toolServiceMCPToolListAsync(r2, r4);
    }

    public static ToolListResp toolServiceMCPToolListSync(ToolListReq r1) {
        return getApi().toolServiceMCPToolListSync(r1);
    }

    public static void toolServicePostProcessAsync(OmniRLToolExecutePostprocessRequest r2, RpcCallback<ExecuteLocalPluginResponse> r3) {
        RpcCallback<ExecuteLocalPluginResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().toolServicePostProcessAsync(r2, r4);
    }

    public static ExecuteLocalPluginResponse toolServicePostProcessSync(OmniRLToolExecutePostprocessRequest r1) {
        return getApi().toolServicePostProcessSync(r1);
    }

    public static void toolServicePreProcessAsync(ExecuteLocalPluginRequest r2, RpcCallback<ExecuteLocalPluginResponse> r3) {
        RpcCallback<ExecuteLocalPluginResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().toolServicePreProcessAsync(r2, r4);
    }

    public static ExecuteLocalPluginResponse toolServicePreProcessSync(ExecuteLocalPluginRequest r1) {
        return getApi().toolServicePreProcessSync(r1);
    }

    public static void uploadScreenShotFeedbackAsync(UploadScreenShotFeedbackRequest r2, RpcCallback<UploadScreenShotFeedbackResponse> r3) {
        RpcCallback<UploadScreenShotFeedbackResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().uploadScreenShotFeedbackAsync(r2, r4);
    }

    public static UploadScreenShotFeedbackResponse uploadScreenShotFeedbackSync(UploadScreenShotFeedbackRequest r1) {
        return getApi().uploadScreenShotFeedbackSync(r1);
    }

    public static void uploadUserPortraitAsync(UploadUserPortraitRequest r2, RpcCallback<UploadUserPortraitResponse> r3) {
        RpcCallback<UploadUserPortraitResponse> r4 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r3, RpcCallback.class, "com.obric.memorydata.plugin");
        getApi().uploadUserPortraitAsync(r2, r4);
    }

    public static UploadUserPortraitResponse uploadUserPortraitSync(UploadUserPortraitRequest r1) {
        return getApi().uploadUserPortraitSync(r1);
    }
}
