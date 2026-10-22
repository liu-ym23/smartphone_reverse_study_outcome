package com.bytedance.rpc.model;

import com.bytedance.crash.entity.Header;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class Metadata implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("device_id")
    public String deviceId;

    @SerializedName("message_id")
    public String messageId;

    @SerializedName("section_id")
    public String sectionId;

    @SerializedName("session_id")
    public String sessionId;

    @SerializedName("system_time")
    public String systemTime;

    @SerializedName(Header.KEY_USER_ID)
    public String userId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Metadata() {
    }
}
