package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UserTasks implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("queued_tasks")
    public Map<String, QueuedTask> queuedTasks;

    @SerializedName("running_tasks")
    public Map<String, RunningTask> runningTasks;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public UserTasks() {
    }
}
