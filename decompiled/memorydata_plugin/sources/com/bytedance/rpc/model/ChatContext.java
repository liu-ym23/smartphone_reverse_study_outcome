package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ChatContext implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("long_text_context")
    public LongTextContext longTextContext;

    @SerializedName("message_context")
    public List<Message> messageContext;

    @SerializedName("scene_context")
    public Map<String, String> sceneContext;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ChatContext() {
    }
}
