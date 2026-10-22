package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class PluginIntent implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("api_name")
    public String apiName;
    public String arguments;

    @SerializedName("plugin_id")
    public long pluginId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public PluginIntent() {
    }
}
