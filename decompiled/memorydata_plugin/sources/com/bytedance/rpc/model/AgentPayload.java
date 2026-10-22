package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AgentPayload implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ab_params")
    public AbParams abParams;

    @SerializedName("context_messages")
    public List<Message> contextMessages;

    @SerializedName("control_messages")
    public List<Message> controlMessages;
    public Map<String, String> ext;

    @SerializedName("intention_info")
    public IntentionInfo intentionInfo;

    @SerializedName("pre_query_payload")
    public PreQueryPayload preQueryPayload;
    public Message query;

    @SerializedName("session_messages")
    public List<Message> sessionMessages;

    @SerializedName("session_meta")
    public SessionMeta sessionMeta;

    @SerializedName("skill_info")
    public SkillInfo skillInfo;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public AgentPayload() {
    }
}
