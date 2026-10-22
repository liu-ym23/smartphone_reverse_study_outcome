package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class RetrievePluginsReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ABTest")
    public Map<String, String> aBTest;

    @SerializedName("AgentBotID")
    public long agentBotID;

    @SerializedName("AgentID")
    public long agentID;

    @SerializedName("AgentTools")
    public List<PluginAPI> agentTools;

    @SerializedName("BotID")
    public long botID;

    @SerializedName("CandidateTools")
    public List<PluginAPILite> candidateTools;

    @SerializedName("ChatContext")
    public ChatContext chatContext;

    @SerializedName("ConnectorID")
    public long connectorID;

    @SerializedName("ConnectorUID")
    public String connectorUID;

    @SerializedName("Message")
    public Message message;

    @SerializedName("SkipIfChat")
    public boolean skipIfChat;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public RetrievePluginsReq() {
    }
}
