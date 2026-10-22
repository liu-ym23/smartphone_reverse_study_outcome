package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class Portrait implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("info_key")
    public String infoKey;

    @SerializedName("info_value")
    public String infoValue;

    @SerializedName("op_type")
    public String opType;
    public String uuid;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Portrait() {
    }
}
