package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class LocationInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String address;
    public String city;
    public String country;

    @SerializedName("country_code")
    public String countryCode;
    public String district;
    public double latitude;
    public double longitude;
    public String province;
    public String town;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public LocationInfo() {
    }
}
