package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TaskVariables implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("message_variables")
    public Map<String, TaskMessageList> messageVariables;

    @SerializedName("string_variables")
    public Map<String, String> stringVariables;

    @SerializedName("struct_variables")
    public String structVariables;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public TaskVariables() {
    }
}
