package com.bytedance.rpc.model;

import com.bytedance.crash.constants.Constants;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class PreQueryPayload implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName(Constants.EVENT_TYPE)
    public ChatEvent eventType;

    @SerializedName("max_new_tokens")
    public long maxNewTokens;

    @SerializedName("p_session_id")
    public long pSessionId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public PreQueryPayload() {
    }
}
