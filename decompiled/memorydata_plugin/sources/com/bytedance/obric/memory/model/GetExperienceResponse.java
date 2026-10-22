package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class GetExperienceResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int code;
    public boolean data;

    @SerializedName("image_status")
    public boolean imageStatus;
    public String msg;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetExperienceResponse() {
    }
}
