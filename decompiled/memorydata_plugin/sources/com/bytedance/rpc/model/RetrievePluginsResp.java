package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RetrievePluginsResp implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("IsChat")
    public boolean isChat;

    @SerializedName("Prompt")
    public String prompt;

    @SerializedName("Tools")
    public List<PluginAPI> tools;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public RetrievePluginsResp() {
    }
}
