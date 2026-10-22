package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class GetMemoryPatchResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("cursor_version")
    public long cursorVersion;

    @SerializedName("favorite_batch")
    public OMemoryFavoriteBatch favoriteBatch;
    public OMemorySemanticPatch semantic;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetMemoryPatchResponse() {
    }
}
