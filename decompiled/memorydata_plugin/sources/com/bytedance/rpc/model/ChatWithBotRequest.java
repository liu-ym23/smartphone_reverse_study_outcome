package com.bytedance.rpc.model;

import com.bytedance.crash.entity.Header;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ChatWithBotRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ab_bot_engine")
    public Map<String, String> abBotEngine;

    @SerializedName("ab_gpt_engine")
    public Map<String, String> abGptEngine;

    @SerializedName("ab_model_id")
    public long abModelId;

    @SerializedName("ab_model_type")
    public ModelType abModelType;

    @SerializedName("ab_test")
    public Map<String, String> abTest;

    @SerializedName("applet_payload")
    public Map<String, String> appletPayload;

    @SerializedName("bot_id")
    public long botId;

    @SerializedName("bot_mapping_config")
    public BotMapptingConfig botMappingConfig;

    @SerializedName("bot_version")
    public String botVersion;

    @SerializedName("chat_context")
    public ChatContext chatContext;

    @SerializedName("connector_id")
    public long connectorId;

    @SerializedName("connector_uid")
    public String connectorUid;

    @SerializedName("custom_bot_info")
    public CustomBotInfo customBotInfo;

    @SerializedName("disable_chat_cache")
    public boolean disableChatCache;
    public Map<String, String> ext;

    @SerializedName("gpt_engine_ab")
    public String gptEngineAb;
    public Message message;

    @SerializedName("need_reference")
    public boolean needReference;

    @SerializedName("need_reference_content")
    public boolean needReferenceContent;

    @SerializedName("pre_define_retriever_result")
    public List<PreDefineRetrieverResult> preDefineRetrieverResult;

    @SerializedName("pregen_req")
    public PreGenReq pregenReq;

    @SerializedName("recommend_status")
    public RecommendStatus recommendStatus;

    @SerializedName("reference_files")
    public List<FileInfo> referenceFiles;
    public boolean resend;

    @SerializedName("resume_info")
    public ResumeInfo resumeInfo;
    public LLMScene scene;
    public SourceType source;

    @SerializedName("task_id")
    public long taskId;

    @SerializedName("tools_auth_info")
    public ToolsAuthInfo toolsAuthInfo;

    @SerializedName(Header.KEY_USER_ID)
    public long userId;

    @SerializedName("user_nickname")
    public String userNickname;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ChatWithBotRequest() {
    }
}
