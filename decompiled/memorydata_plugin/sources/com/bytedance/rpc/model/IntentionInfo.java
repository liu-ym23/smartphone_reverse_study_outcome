package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import com.obric.security.agentmanager.AgentManagerConst;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class IntentionInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName(AgentManagerConst.AGENT_NAME)
    public String agentName;

    @SerializedName("passthrough_params")
    public String passthroughParams;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public IntentionInfo() {
    }
}
