package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ChatMessage implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("Content")
    public String content;
    public Map<String, String> ext;
    public List<FileInfo> files;
    public List<ImageInfo> images;

    @SerializedName("OriginalRole")
    public CopilotRole originalRole;

    @SerializedName("Role")
    public CopilotRole role;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ChatMessage() {
    }
}
