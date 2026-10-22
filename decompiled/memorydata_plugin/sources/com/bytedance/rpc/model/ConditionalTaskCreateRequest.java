package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ConditionalTaskCreateRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("automatic_fields")
    public String automaticFields;

    @SerializedName("create_time")
    public String createTime;

    @SerializedName("create_type")
    public String createType;

    @SerializedName("discover_id")
    public String discoverId;

    @SerializedName("discover_query")
    public String discoverQuery;
    public Map<String, String> extra;
    public String instruction;
    public String knowledge;

    @SerializedName("o_omni_instruction_type")
    public String oOmniInstructionType;

    @SerializedName("operate_type")
    public String operateType;

    @SerializedName("origin_query")
    public String originQuery;

    @SerializedName("short_query")
    public String shortQuery;

    @SerializedName("task_id")
    public String taskId;

    @SerializedName("update_time")
    public String updateTime;

    @SerializedName("user_select_model")
    public String userSelectModel;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ConditionalTaskCreateRequest() {
    }
}
