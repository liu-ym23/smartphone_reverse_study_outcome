package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class FunctionScreenAuthRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Map<String, String> ext;

    @SerializedName("function_name")
    public String functionName;
    public String scene;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public FunctionScreenAuthRequest() {
    }
}
