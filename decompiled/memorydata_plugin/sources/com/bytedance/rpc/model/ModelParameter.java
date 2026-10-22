package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ModelParameter implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("auto_fix")
    public boolean autoFix;

    @SerializedName("default_value")
    public Map<String, String> defaultValue;

    @SerializedName("is_required")
    public boolean isRequired;
    public String max;
    public String min;
    public String name;
    public List<String> options;
    public int precision;
    public ModelParamType type;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ModelParameter() {
    }
}
