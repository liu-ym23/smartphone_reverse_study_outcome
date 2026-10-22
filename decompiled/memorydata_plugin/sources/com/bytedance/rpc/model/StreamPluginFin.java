package com.bytedance.rpc.model;

import com.bytedance.bdinstall.Api;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class StreamPluginFin implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("tool_output_content")
    public String toolOutputContent;

    @SerializedName(Api.KEY_UUID)
    public String uUID;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public StreamPluginFin() {
    }
}
