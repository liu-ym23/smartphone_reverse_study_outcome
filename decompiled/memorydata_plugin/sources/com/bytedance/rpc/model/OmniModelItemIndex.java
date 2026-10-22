package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class OmniModelItemIndex implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("item_id")
    public long itemId;

    @SerializedName("model_item_key")
    public String modelItemKey;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OmniModelItemIndex() {
    }
}
