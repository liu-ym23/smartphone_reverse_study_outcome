package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ToolAuth implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("auth_type")
    public ToolAuthType authType;

    @SerializedName("plugin_id")
    public long pluginId;

    @SerializedName("plugin_name")
    public String pluginName;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ToolAuth() {
    }
}
