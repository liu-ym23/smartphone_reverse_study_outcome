package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ResidentGeneral implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("city_code")
    public String cityCode;

    @SerializedName("city_name")
    public String cityName;

    @SerializedName("district_code")
    public String districtCode;

    @SerializedName("district_name")
    public String districtName;
    public String geohash6;
    public String lat;
    public String lng;

    @SerializedName("province_code")
    public String provinceCode;

    @SerializedName("province_name")
    public String provinceName;

    @SerializedName("town_code")
    public String townCode;

    @SerializedName("town_name")
    public String townName;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ResidentGeneral() {
    }
}
