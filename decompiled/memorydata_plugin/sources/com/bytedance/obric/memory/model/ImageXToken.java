package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ImageXToken implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("access_key_id")
    public String accessKeyId;

    @SerializedName("current_time")
    public long currentTime;

    @SerializedName("expired_time")
    public long expiredTime;

    @SerializedName("secret_access_key")
    public String secretAccessKey;

    @SerializedName("service_id")
    public String serviceId;

    @SerializedName("session_token")
    public String sessionToken;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ImageXToken() {
    }
}
