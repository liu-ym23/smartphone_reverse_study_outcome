package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class CustomBotInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("description_for_human")
    public String descriptionForHuman;

    @SerializedName("description_for_model")
    public String descriptionForModel;

    @SerializedName("model_config")
    public CustomModelConfig modelConfig;
    public String name;
    public String prompt;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public CustomBotInfo() {
    }
}
