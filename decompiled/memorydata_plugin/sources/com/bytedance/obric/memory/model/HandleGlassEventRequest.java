package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class HandleGlassEventRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String data;

    @SerializedName("source_type")
    public int sourceType;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public HandleGlassEventRequest() {
    }
}
