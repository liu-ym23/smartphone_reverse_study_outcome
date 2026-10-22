package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateOMemorySettingsRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("Head")
    public Head head;

    @SerializedName("request_id")
    public String requestId;
    public OMemorySettingsPatch settings;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public UpdateOMemorySettingsRequest() {
    }
}
