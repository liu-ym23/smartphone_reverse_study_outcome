package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class OmniSkillBrief implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String description;
    public boolean enabled;

    @SerializedName("skill_id")
    public String skillId;

    @SerializedName("skill_name")
    public String skillName;
    public OmniSkillSource source;
    public String version;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OmniSkillBrief() {
    }
}
