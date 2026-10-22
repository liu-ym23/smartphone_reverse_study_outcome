package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CopilotContent implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String content;

    @SerializedName("content_type")
    public CopilotContentType contentType;

    @SerializedName("delta_meta_info")
    public List<MetaInfo> deltaMetaInfo;

    @SerializedName("empty_response")
    public boolean emptyResponse;
    public Map<String, String> ext;

    @SerializedName("finish_content")
    public String finishContent;

    @SerializedName("message_title")
    public String messageTitle;

    @SerializedName("original_content")
    public String originalContent;

    @SerializedName("response_for_model")
    public String responseForModel;

    @SerializedName("stream_id")
    public String streamId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public CopilotContent() {
    }
}
