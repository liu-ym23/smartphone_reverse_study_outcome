package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class PushExperienceRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("Head")
    public Head head;

    @SerializedName("image_status")
    public boolean imageStatus;
    public boolean status;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public PushExperienceRequest() {
    }
}
