package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MessageList implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("max_tokens")
    public int maxTokens;
    public List<MessageItem> messages;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public MessageList() {
    }
}
