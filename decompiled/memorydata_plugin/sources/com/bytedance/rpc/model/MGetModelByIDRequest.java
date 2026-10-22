package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MGetModelByIDRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("IDs")
    public List<Long> iDs;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public MGetModelByIDRequest() {
    }
}
