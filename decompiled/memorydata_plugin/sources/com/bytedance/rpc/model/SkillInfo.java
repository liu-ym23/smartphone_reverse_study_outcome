package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class SkillInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String payload;

    @SerializedName("skill_type")
    public long skillType;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public SkillInfo() {
    }
}
