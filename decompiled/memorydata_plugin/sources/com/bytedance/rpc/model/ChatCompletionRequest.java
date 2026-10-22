package com.bytedance.rpc.model;

import com.bytedance.crash.entity.Header;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ChatCompletionRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Map<String, String> ext;

    @SerializedName("highlight_type")
    public HighLightType highlightType;

    @SerializedName("model_type")
    public ModelType modelType;
    public String question;

    @SerializedName("search_engine_type")
    public SearchEngineType searchEngineType;

    @SerializedName("short_memory")
    public List<ChatMessage> shortMemory;
    public boolean streaming;

    @SerializedName("sys_description")
    public String sysDescription;
    public double temperature;

    @SerializedName("top_k")
    public long topK;

    @SerializedName("top_p")
    public double topP;

    @SerializedName(Header.KEY_USER_ID)
    public long userId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ChatCompletionRequest() {
    }
}
