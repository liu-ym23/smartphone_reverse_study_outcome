package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class DecorateHighlightRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String content;

    @SerializedName("highlight_type")
    public HighLightType highlightType;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public DecorateHighlightRequest() {
    }
}
