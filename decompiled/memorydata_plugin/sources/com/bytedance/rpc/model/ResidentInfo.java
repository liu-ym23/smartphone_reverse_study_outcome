package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ResidentInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("city_id")
    public long cityId;
    public double latitude;
    public double longitude;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ResidentInfo() {
    }
}
