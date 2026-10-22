package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class OMemorySettingsPatch implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("collection_memory")
    public boolean collectionMemory;

    @SerializedName("global_memory")
    public boolean globalMemory;

    @SerializedName("personal_info_memory")
    public boolean personalInfoMemory;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OMemorySettingsPatch() {
    }
}
