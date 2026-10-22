package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ModelDesc implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Capability capability;
    public ModelConf config;

    @SerializedName("creat_time")
    public long creatTime;

    @SerializedName("creator_email")
    public String creatorEmail;
    public String description;
    public ModelFamily family;
    public String icon;

    @SerializedName("legacy_fields")
    public LegacyFields legacyFields;

    @SerializedName("model_id")
    public long modelId;

    @SerializedName("model_name")
    public String modelName;

    @SerializedName("nick_name")
    public String nickName;
    public List<ModelParameter> parameters;
    public PromptConf prompt;
    public ModelQuota quota;
    public int ranking;

    @SerializedName("show_name")
    public String showName;
    public int status;

    @SerializedName("update_email")
    public String updateEmail;

    @SerializedName("update_time")
    public long updateTime;
    public ModelVersion version;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ModelDesc() {
    }
}
