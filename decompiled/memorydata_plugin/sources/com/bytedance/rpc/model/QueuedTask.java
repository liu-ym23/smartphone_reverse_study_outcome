package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class QueuedTask implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("in_queue_timestamp")
    public long inQueueTimestamp;

    @SerializedName("msg_id")
    public String msgId;

    @SerializedName("task_id")
    public String taskId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public QueuedTask() {
    }
}
