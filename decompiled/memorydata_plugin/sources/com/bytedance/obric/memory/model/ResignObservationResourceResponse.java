package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ResignObservationResourceResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int code;

    @SerializedName("expire_at_ts")
    public long expireAtTs;

    @SerializedName("media_ref")
    public String mediaRef;
    public String message;

    @SerializedName("signed_url")
    public String signedUrl;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ResignObservationResourceResponse() {
    }
}
