package com.bytedance.rpc.model;

import com.bytedance.crash.entity.Header;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AsyncCallRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String biz;

    @SerializedName("bot_id")
    public long botId;
    public String cluster;

    @SerializedName("connector_id")
    public long connectorId;

    @SerializedName("connector_uid")
    public String connectorUid;

    @SerializedName("conversation_id")
    public String conversationId;
    public Map<String, String> extra;
    public String method;

    @SerializedName("model_id")
    public long modelId;

    @SerializedName("notify_psm")
    public String notifyPsm;
    public ByteBuffer request;
    public LLMScene scene;

    @SerializedName(Header.KEY_USER_ID)
    public long userId;
    public String uuid;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public AsyncCallRequest() {
    }
}
