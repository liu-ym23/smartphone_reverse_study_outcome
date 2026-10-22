package com.bytedance.obric.memory.model;

import com.bytedance.crash.entity.Header;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class Observation implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("device_id")
    public String deviceId;

    @SerializedName("device_time")
    public long deviceTime;
    public String id;
    public String meta;
    public String payload;

    @SerializedName("server_time")
    public long serverTime;

    @SerializedName("source_id")
    public String sourceId;

    @SerializedName("source_type")
    public int sourceType;

    @SerializedName("span_end")
    public long spanEnd;

    @SerializedName("span_start")
    public long spanStart;
    public int state;

    @SerializedName(Header.KEY_USER_ID)
    public String userId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Observation() {
    }
}
