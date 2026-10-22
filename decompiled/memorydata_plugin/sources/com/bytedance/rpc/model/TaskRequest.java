package com.bytedance.rpc.model;

import com.bytedance.bdinstall.Api;
import com.bytedance.crash.entity.Header;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TaskRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName(Api.KEY_APP_NAME)
    public String appName;

    @SerializedName("chain_app_id")
    public long chainAppId;

    @SerializedName("connector_id")
    public long connectorId;

    @SerializedName("custom_model_config")
    public CustomModelConfig customModelConfig;
    public Map<String, String> ext;

    @SerializedName("model_config")
    public ModelConfig modelConfig;
    public TaskPrompt prompt;

    @SerializedName("prompt_template_format")
    public PromptTemplateFormat promptTemplateFormat;
    public LLMScene scene;
    public SourceType source;

    @SerializedName("task_name")
    public String taskName;

    @SerializedName("task_version")
    public int taskVersion;

    @SerializedName(Header.KEY_USER_ID)
    public String userId;
    public TaskVariables variables;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public TaskRequest() {
    }
}
