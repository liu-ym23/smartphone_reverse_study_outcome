package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DouyinUserLocation implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("activity_region")
    public List<ActivityRegion> activityRegion;

    @SerializedName("activity_region_unauthorized")
    public List<ActivityRegion> activityRegionUnauthorized;

    @SerializedName("city_code")
    public String cityCode;

    @SerializedName("device_id")
    public long deviceId;

    @SerializedName("home_city_code")
    public String homeCityCode;

    @SerializedName("home_latitude")
    public double homeLatitude;

    @SerializedName("home_longitude")
    public double homeLongitude;

    @SerializedName("hometown_city_code")
    public String hometownCityCode;

    @SerializedName("interested_city")
    public List<InterestedCity> interestedCity;

    @SerializedName("main_city_code")
    public String mainCityCode;

    @SerializedName("main_latitude")
    public double mainLatitude;

    @SerializedName("main_longitude")
    public double mainLongitude;

    @SerializedName("resident_general")
    public ResidentGeneral residentGeneral;

    @SerializedName("resident_list")
    public List<ResidentInfo> residentList;
    public int rural;

    @SerializedName("work_city_code")
    public String workCityCode;

    @SerializedName("work_latitude")
    public double workLatitude;

    @SerializedName("work_longitude")
    public double workLongitude;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public DouyinUserLocation() {
    }
}
