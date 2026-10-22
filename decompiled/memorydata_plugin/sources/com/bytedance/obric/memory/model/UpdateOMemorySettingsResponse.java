package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateOMemorySettingsResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int code;

    @SerializedName("collection_memory")
    public boolean collectionMemory;

    @SerializedName("delete_task_ids")
    public List<String> deleteTaskIds;

    @SerializedName("global_memory")
    public boolean globalMemory;
    public String msg;

    @SerializedName("personal_info_memory")
    public boolean personalInfoMemory;

    @SerializedName("updated_at")
    public long updatedAt;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public UpdateOMemorySettingsResponse() {
    }
}
