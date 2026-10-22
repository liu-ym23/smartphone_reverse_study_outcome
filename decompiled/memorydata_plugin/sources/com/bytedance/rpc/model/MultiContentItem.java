package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class MultiContentItem implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("content_for_model")
    public String contentForModel;

    @SerializedName("content_type")
    public PacketContentType contentType;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public MultiContentItem() {
    }
}
