package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class POIInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("awe_poi_id")
    public String awePoiId;
    public GEOLocation geo;

    @SerializedName("location_id")
    public String locationId;
    public String name;

    @SerializedName("new_type_code")
    public String newTypeCode;

    @SerializedName("new_type_name")
    public String newTypeName;

    @SerializedName("type_code")
    public String typeCode;

    @SerializedName("type_name")
    public String typeName;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public POIInfo() {
    }
}
