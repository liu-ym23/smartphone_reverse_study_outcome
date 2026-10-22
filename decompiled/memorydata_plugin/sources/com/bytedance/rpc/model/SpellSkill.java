package com.bytedance.rpc.model;

import com.bytedance.bdinstall.Api;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SpellSkill implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String description;

    @SerializedName(Api.KEY_DISPLAY_NAME)
    public String displayName;

    @SerializedName("manifest_id")
    public String manifestId;

    @SerializedName("skill_md_content")
    public String skillMdContent;

    @SerializedName("skill_name")
    public String skillName;
    public String source;
    public List<String> tags;

    @SerializedName("updated_at")
    public String updatedAt;

    @SerializedName("usage_examples")
    public List<String> usageExamples;
    public int version;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public SpellSkill() {
    }
}
