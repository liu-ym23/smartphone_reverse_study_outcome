package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class UserCommonParam implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("geo_location")
    public GEOLocation geoLocation;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public UserCommonParam() {
    }
}
