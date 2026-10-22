package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class LocaleInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public double altitude;
    public String city;

    @SerializedName("city_code")
    public String cityCode;
    public String country;

    @SerializedName("delivery_location")
    public DeliveryLocation deliveryLocation;
    public String district;

    @SerializedName("douyin_user_location")
    public DouyinUserLocation douyinUserLocation;
    public long flags;

    @SerializedName("geo_name_id")
    public String geoNameId;
    public String ip;
    public String lang;
    public double latitude;

    @SerializedName("location_v2")
    public Location locationV2;
    public double longitude;
    public String province;
    public String region;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public LocaleInfo() {
    }
}
