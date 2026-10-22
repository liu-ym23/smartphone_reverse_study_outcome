package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class FunctionScreenAuthResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String message;

    @SerializedName("pass_status")
    public String passStatus;
    public String style;

    @SerializedName("vui_content")
    public String vuiContent;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public FunctionScreenAuthResponse() {
    }
}
