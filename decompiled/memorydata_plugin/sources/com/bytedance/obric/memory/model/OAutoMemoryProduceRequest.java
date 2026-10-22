package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class OAutoMemoryProduceRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("prompt_key")
    public String promptKey;

    @SerializedName("session_id")
    public String sessionId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OAutoMemoryProduceRequest() {
    }
}
