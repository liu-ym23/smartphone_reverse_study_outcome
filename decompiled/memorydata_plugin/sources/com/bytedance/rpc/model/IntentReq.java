package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class IntentReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("BotId")
    public String botId;
    public List<AgentInfo> candidates;

    @SerializedName("ConnectorId")
    public String connectorId;

    @SerializedName("ConnectorUId")
    public String connectorUId;

    @SerializedName("Context")
    public List<ChatMsg> context;

    @SerializedName("Query")
    public ChatMsg query;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public IntentReq() {
    }
}
