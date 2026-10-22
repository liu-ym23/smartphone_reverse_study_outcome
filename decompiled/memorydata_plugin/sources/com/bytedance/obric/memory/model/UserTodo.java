package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class UserTodo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("created_at")
    public long createdAt;

    @SerializedName("event_datetime_text")
    public String eventDatetimeText;

    @SerializedName("event_description")
    public String eventDescription;

    @SerializedName("event_time")
    public long eventTime;

    @SerializedName("extra_info")
    public String extraInfo;
    public long id;
    public String logid;
    public String possibility;

    @SerializedName("possibility_type")
    public int possibilityType;

    @SerializedName("related_memory_snapshot_ids")
    public String relatedMemorySnapshotIds;
    public int status;

    @SerializedName("updated_at")
    public long updatedAt;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public UserTodo() {
    }
}
