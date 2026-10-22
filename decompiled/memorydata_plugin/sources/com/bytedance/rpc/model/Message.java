package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Message implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String content;
    public String name;
    public String role;

    @SerializedName("tool_call_id")
    public String toolCallId;

    @SerializedName("tool_calls")
    public List<ToolCall> toolCalls;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Message() {
    }
}
