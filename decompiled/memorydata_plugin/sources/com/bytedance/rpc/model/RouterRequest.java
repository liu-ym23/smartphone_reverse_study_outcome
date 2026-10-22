package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class RouterRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("pass_through")
    public String passThrough;
    public String scene;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public RouterRequest() {
    }
}
