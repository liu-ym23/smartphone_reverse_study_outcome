package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class VoiceType implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public long id;
    public String language;

    @SerializedName("model_name")
    public String modelName;
    public String name;

    @SerializedName("style_id")
    public String styleId;

    @SerializedName("style_name")
    public String styleName;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public VoiceType() {
    }
}
