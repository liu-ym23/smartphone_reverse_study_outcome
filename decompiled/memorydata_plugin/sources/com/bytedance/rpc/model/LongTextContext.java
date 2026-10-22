package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class LongTextContext implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("has_more")
    public boolean hasMore;

    @SerializedName("search_key")
    public String searchKey;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public LongTextContext() {
    }
}
