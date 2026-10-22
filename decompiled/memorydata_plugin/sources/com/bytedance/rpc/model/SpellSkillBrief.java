package com.bytedance.rpc.model;

import com.bytedance.bdinstall.Api;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SpellSkillBrief implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String description;

    @SerializedName(Api.KEY_DISPLAY_NAME)
    public String displayName;

    @SerializedName("latest_version")
    public int latestVersion;

    @SerializedName("skill_name")
    public String skillName;
    public List<String> tags;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public SpellSkillBrief() {
    }
}
