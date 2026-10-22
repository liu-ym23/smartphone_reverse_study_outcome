package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class EntityConvertResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public long code;
    public String entities;

    @SerializedName("expanded_entities")
    public String expandedEntities;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public EntityConvertResponse() {
    }
}
