package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class PromptConf implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("close_react")
    public boolean closeReact;

    @SerializedName("is_sc")
    public boolean isSc;

    @SerializedName("is_up_required")
    public boolean isUpRequired;
    public String prefix;
    public String sequence;
    public String suffix;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public PromptConf() {
    }
}
