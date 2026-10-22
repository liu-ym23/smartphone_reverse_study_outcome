package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class PluginAPILite implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ApiID")
    public long apiID;

    @SerializedName("ApiName")
    public String apiName;

    @SerializedName("PluginID")
    public long pluginID;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public PluginAPILite() {
    }
}
