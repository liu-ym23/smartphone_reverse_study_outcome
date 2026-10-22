package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class LoadSpellSkillRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("device_platform")
    public String devicePlatform;

    @SerializedName("skill_identifier")
    public String skillIdentifier;
    public int version;

    @SerializedName("with_package")
    public boolean withPackage;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public LoadSpellSkillRequest() {
    }
}
