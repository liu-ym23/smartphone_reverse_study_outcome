package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ChainInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("model_config")
    public ModelConfig modelConfig;
    public String name;
    public Prompt prompt;
    public int version;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ChainInfo() {
    }
}
