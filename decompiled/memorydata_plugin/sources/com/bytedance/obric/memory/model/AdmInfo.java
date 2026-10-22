package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class AdmInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String code;

    @SerializedName("geo_name_id")
    public String geoNameId;
    public String name;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public AdmInfo() {
    }
}
