package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ListSpellSkillRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("category_id")
    public String categoryId;

    @SerializedName("device_platform")
    public String devicePlatform;
    public String keyword;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ListSpellSkillRequest() {
    }
}
