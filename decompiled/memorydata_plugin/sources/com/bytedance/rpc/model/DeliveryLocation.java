package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class DeliveryLocation implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("address_display_name")
    public String addressDisplayName;
    public String city;

    @SerializedName("city_code")
    public String cityCode;
    public String country;

    @SerializedName("delivery_latitude")
    public double deliveryLatitude;

    @SerializedName("delivery_longitude")
    public double deliveryLongitude;
    public String district;

    @SerializedName("district_code")
    public String districtCode;
    public String province;
    public String region;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public DeliveryLocation() {
    }
}
