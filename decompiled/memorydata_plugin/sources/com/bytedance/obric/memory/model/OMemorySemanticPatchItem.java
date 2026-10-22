package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class OMemorySemanticPatchItem implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String content;

    @SerializedName("content_subtype")
    public String contentSubtype;

    @SerializedName("content_type")
    public String contentType;

    @SerializedName("source_update_time")
    public long sourceUpdateTime;

    @SerializedName("source_version")
    public long sourceVersion;
    public String uuid;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OMemorySemanticPatchItem() {
    }
}
