package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateModelMetaRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("Capability")
    public Capability capability;

    @SerializedName("Config")
    public ModelConf config;

    @SerializedName("Desc")
    public String desc;

    @SerializedName("Family")
    public ModelFamily family;

    @SerializedName("IconURL")
    public String iconURL;

    @SerializedName("LegacyFields")
    public LegacyFields legacyFields;

    @SerializedName("ModelID")
    public long modelID;

    @SerializedName("ModelName")
    public String modelName;

    @SerializedName("OpEmployee")
    public String opEmployee;

    @SerializedName("Parameters")
    public List<ModelParameter> parameters;

    @SerializedName("PromptConf")
    public PromptConf promptConf;

    @SerializedName("Quota")
    public ModelQuota quota;

    @SerializedName("ShowName")
    public String showName;

    @SerializedName("Version")
    public ModelVersion version;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public UpdateModelMetaRequest() {
    }
}
