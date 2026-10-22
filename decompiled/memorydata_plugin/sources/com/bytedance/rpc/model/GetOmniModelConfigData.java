package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GetOmniModelConfigData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("default_model")
    public OmniModelItemIndex defaultModel;
    public List<OmniModelConfig> models;

    @SerializedName("support_models")
    public List<OmniModelItemIndex> supportModels;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetOmniModelConfigData() {
    }
}
