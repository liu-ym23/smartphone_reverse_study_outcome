package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class OmniModelConfig implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("display_model")
    public String displayModel;

    @SerializedName("is_supported_model")
    public boolean isSupportedModel;
    public String model;

    @SerializedName("model_item_index")
    public OmniModelItemIndex modelItemIndex;

    @SerializedName("old_item_key")
    public long oldItemKey;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OmniModelConfig() {
    }
}
