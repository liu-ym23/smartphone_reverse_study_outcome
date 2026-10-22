package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class PluginInterruptInfoResp implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("plugin_async_resp")
    public String pluginAsyncResp;

    @SerializedName("plugin_unauthorized_info")
    public String pluginUnauthorizedInfo;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public PluginInterruptInfoResp() {
    }
}
