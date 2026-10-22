package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class OMemorySemanticSyncItem implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("client_source_id")
    public String clientSourceId;
    public String content;
    public int operation;

    @SerializedName("product_type")
    public String productType;

    @SerializedName("semantic_type")
    public String semanticType;

    @SerializedName("source_create_time")
    public long sourceCreateTime;

    @SerializedName("source_entity_id")
    public String sourceEntityId;

    @SerializedName("source_update_time")
    public long sourceUpdateTime;

    @SerializedName("tag_path")
    public String tagPath;

    @SerializedName("user_edit")
    public boolean userEdit;
    public String uuid;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OMemorySemanticSyncItem() {
    }
}
