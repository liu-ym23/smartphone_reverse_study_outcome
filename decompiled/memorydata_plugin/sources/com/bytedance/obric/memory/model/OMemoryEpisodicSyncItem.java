package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class OMemoryEpisodicSyncItem implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("client_source_id")
    public String clientSourceId;

    @SerializedName("event_time")
    public long eventTime;
    public int operation;

    @SerializedName("product_type")
    public String productType;

    @SerializedName("source_app_name")
    public String sourceAppName;

    @SerializedName("source_entity_id")
    public String sourceEntityId;

    @SerializedName("source_image")
    public String sourceImage;

    @SerializedName("source_text")
    public String sourceText;
    public List<String> tags;
    public String title;
    public String uuid;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OMemoryEpisodicSyncItem() {
    }
}
