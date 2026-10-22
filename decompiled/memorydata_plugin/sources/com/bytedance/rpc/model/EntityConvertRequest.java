package com.bytedance.rpc.model;

import com.bytedance.crash.entity.Header;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.EntityProvider;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class EntityConvertRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("agent_payload")
    public AgentPayload agentPayload;

    @SerializedName("device_id")
    public long deviceId;
    public String entities;

    @SerializedName(EntityProvider.KEY_ENTITY_TYPE)
    public long entityType;
    public Map<String, String> ext;

    @SerializedName("message_id")
    public long messageId;

    @SerializedName("request_source")
    public RequestSource requestSource;

    @SerializedName(Header.KEY_USER_ID)
    public long userId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public EntityConvertRequest() {
    }
}
