package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ChatMsg implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("AgentId")
    public String agentId;

    @SerializedName("Content")
    public String content;
    public List<FileInfo> files;
    public List<ImageInfo> images;

    @SerializedName("Role")
    public CopilotRole role;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ChatMsg() {
    }
}
