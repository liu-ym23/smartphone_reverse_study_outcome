package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ClientMemoryData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("backup_log_id")
    public String backupLogId;
    public String content;

    @SerializedName("create_time")
    public long createTime;
    public long did;

    @SerializedName("entity_id")
    public String entityId;
    public String env;
    public long id;

    @SerializedName("log_id")
    public String logId;

    @SerializedName("memory_id")
    public long memoryId;
    public String observation;

    @SerializedName("push_log_id")
    public String pushLogId;
    public int status;
    public long uid;

    @SerializedName("update_time")
    public long updateTime;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ClientMemoryData() {
    }
}
