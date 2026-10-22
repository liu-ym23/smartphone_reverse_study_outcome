package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ChatCompletionStreamRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("Head")
    public Head head;

    @SerializedName("prompt_key")
    public String promptKey;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ChatCompletionStreamRequest() {
    }
}
