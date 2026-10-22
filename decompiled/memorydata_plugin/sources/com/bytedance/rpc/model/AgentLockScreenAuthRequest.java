package com.bytedance.rpc.model;

import com.bytedance.crash.entity.Header;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import com.obric.security.agentmanager.AgentManagerConst;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AgentLockScreenAuthRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("agent_id")
    public String agentId;

    @SerializedName(AgentManagerConst.AGENT_NAME)
    public String agentName;

    @SerializedName("device_id")
    public long deviceId;
    public Map<String, String> ext;

    @SerializedName("message_id")
    public long messageId;
    public String scene;

    @SerializedName(Header.KEY_USER_ID)
    public long userId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public AgentLockScreenAuthRequest() {
    }
}
