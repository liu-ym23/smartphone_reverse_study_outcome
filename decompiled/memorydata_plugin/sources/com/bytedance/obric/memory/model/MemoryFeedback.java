package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryFeedback implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("create_time")
    public long createTime;
    public String description;
    public String env;
    public long id;

    @SerializedName("log_id")
    public String logId;
    public String reason;
    public long uid;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public MemoryFeedback() {
    }
}
