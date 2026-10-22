package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class UserEvent implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String context;

    @SerializedName("create_time")
    public String createTime;
    public long did;

    @SerializedName("end_time")
    public String endTime;
    public long id;

    @SerializedName("push_log_id")
    public String pushLogId;

    @SerializedName("run_log_id")
    public String runLogId;

    @SerializedName("start_time")
    public String startTime;
    public int status;
    public int type;
    public long uid;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public UserEvent() {
    }
}
