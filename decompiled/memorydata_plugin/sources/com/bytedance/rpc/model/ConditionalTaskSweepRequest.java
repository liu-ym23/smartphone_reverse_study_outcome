package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ConditionalTaskSweepRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Map<String, String> extra;

    @SerializedName("task_list")
    public List<ConditionalTaskCreateRequest> taskList;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ConditionalTaskSweepRequest() {
    }
}
