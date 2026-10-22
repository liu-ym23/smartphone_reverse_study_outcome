package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ToolCall implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("function")
    public Function functionType;
    public String id;
    public String type;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ToolCall() {
    }
}
