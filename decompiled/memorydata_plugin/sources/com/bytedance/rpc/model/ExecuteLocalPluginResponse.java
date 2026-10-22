package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ExecuteLocalPluginResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int code;

    @SerializedName("content_list")
    public List<McpContent> contentList;
    public String data;

    @SerializedName("entity_data")
    public String entityData;
    public Map<String, String> ext;

    @SerializedName("packet_blocks")
    public String packetBlocks;

    @SerializedName("structured_content")
    public String structuredContent;

    @SerializedName("type_for_model")
    public int typeForModel;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ExecuteLocalPluginResponse() {
    }
}
