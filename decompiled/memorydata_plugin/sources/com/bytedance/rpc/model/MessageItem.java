package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MessageItem implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String content;
    public List<FileInfo> files;

    @SerializedName("function_call")
    public FunctionCall functionCall;
    public List<ImageInfo> images;

    @SerializedName("message_scene")
    public MessageScene messageScene;
    public String name;
    public MessageType type;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public MessageItem() {
    }
}
