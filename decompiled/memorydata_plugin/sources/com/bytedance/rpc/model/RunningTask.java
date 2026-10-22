package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class RunningTask implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("msg_id")
    public String msgId;

    @SerializedName("start_timestamp")
    public long startTimestamp;

    @SerializedName("task_id")
    public String taskId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public RunningTask() {
    }
}
