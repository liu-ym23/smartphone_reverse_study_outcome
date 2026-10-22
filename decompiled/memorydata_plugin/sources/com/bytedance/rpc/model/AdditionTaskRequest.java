package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AdditionTaskRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String content;
    public Map<String, String> extra;

    @SerializedName("msg_id")
    public long msgId;

    @SerializedName("task_id")
    public String taskId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public AdditionTaskRequest() {
    }
}
