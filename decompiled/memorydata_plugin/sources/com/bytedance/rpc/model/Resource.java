package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class Resource implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Map<String, String> metadata;
    public String name;

    @SerializedName("resource_id")
    public long resourceId;

    @SerializedName("resource_type")
    public ResourceType resourceType;
    public String uri;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Resource() {
    }
}
