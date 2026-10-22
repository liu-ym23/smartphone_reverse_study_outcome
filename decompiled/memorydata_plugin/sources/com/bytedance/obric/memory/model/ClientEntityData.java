package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ClientEntityData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String content;

    @SerializedName("created_time")
    public long createdTime;

    @SerializedName("entity_id")
    public String entityId;

    @SerializedName("log_id")
    public String logId;
    public String observation;

    @SerializedName("profile_type")
    public int profileType;
    public int status;
    public String tag;

    @SerializedName("tag_other")
    public String tagOther;

    @SerializedName("update_time")
    public long updateTime;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ClientEntityData() {
    }
}
