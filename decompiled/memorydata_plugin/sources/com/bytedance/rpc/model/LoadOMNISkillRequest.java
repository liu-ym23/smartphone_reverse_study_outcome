package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class LoadOMNISkillRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("device_id")
    public String deviceId;
    public Map<String, String> ext;
    public List<OmniSkillLoadItem> items;

    @SerializedName("task_id")
    public String taskId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public LoadOMNISkillRequest() {
    }
}
