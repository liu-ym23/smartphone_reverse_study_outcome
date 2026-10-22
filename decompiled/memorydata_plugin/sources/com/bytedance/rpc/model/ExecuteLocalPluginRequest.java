package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ExecuteLocalPluginRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("action_parameters")
    public ActionParameters actionParameters;

    @SerializedName("agent_payload")
    public AgentPayload agentPayload;

    @SerializedName("api_name")
    public String apiName;
    public Map<String, String> ext;

    @SerializedName("message_id")
    public long messageId;

    @SerializedName("middle_messages")
    public List<MiddleMessage> middleMessages;

    @SerializedName("plugin_id")
    public long pluginId;

    @SerializedName("plugin_name")
    public String pluginName;

    @SerializedName("request_source")
    public RequestSource requestSource;
    public long timeout;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ExecuteLocalPluginRequest() {
    }
}
