package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class OmniRLToolExecutePostprocessRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("agent_payload")
    public AgentPayload agentPayload;
    public Map<String, String> ext;

    @SerializedName("message_id")
    public long messageId;

    @SerializedName("middle_messages")
    public List<MiddleMessage> middleMessages;

    @SerializedName("request_source")
    public RequestSource requestSource;

    @SerializedName("tool_execute_result")
    public OmniRLToolExecuteResult toolExecuteResult;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OmniRLToolExecutePostprocessRequest() {
    }
}
