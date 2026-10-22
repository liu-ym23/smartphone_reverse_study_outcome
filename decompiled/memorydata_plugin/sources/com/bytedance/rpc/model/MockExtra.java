package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class MockExtra implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("is_mock")
    public boolean isMock;

    @SerializedName("source_type")
    public String sourceType;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public MockExtra() {
    }
}
