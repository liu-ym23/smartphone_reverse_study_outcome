package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class OMemorySemanticPatch implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public List<OMemorySemanticPatchItem> items;

    @SerializedName("sp_variable")
    public String spVariable;

    @SerializedName("total_count")
    public int totalCount;
    public boolean truncated;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OMemorySemanticPatch() {
    }
}
