package com.bytedance.bdlocation.network.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;

/* JADX INFO: loaded from: classes.dex */
public class LocationInfo {

    @SerializedName(LocationMonitorConst.ACCURACY)
    public double accuracy;

    @SerializedName(MemoryKeyInfoEntity.KEY_ADDRESS)
    public String address;

    @SerializedName("altitude")
    public double altitude;

    @SerializedName("altitude_accuracy")
    public double altitudeAccuracy;

    @SerializedName("bearing_accuracy")
    public float bearingAccuracyDegrees;

    @SerializedName("building_id")
    public String buildingId;

    @SerializedName("city")
    public String city;

    @SerializedName("coordinate_system")
    public String coordinateSystem;

    @SerializedName("country")
    public String country;

    @SerializedName("district")
    public String district;

    @SerializedName("elapsed_realtime")
    public long elapsedRealtimeNanos;

    @SerializedName("elapsed_realtime_uncertainty")
    public double elapsedRealtimeUncertaintyNanos;

    @SerializedName(WsConstants.KEY_EXTRA)
    public String extra;

    @SerializedName("floor")
    public String floor;

    @SerializedName("is_mock")
    public boolean isMock;

    @SerializedName("latitude")
    public double latitude;

    @SerializedName("latitude_wgs84")
    public double latitudeWgs84;

    @SerializedName(LocationMonitorConst.LOCATE_TYPE)
    public int locateType;

    @SerializedName("longitude")
    public double longitude;

    @SerializedName("longitude_wgs84")
    public double longitudeWgs84;

    @SerializedName("provider")
    public String provider;

    @SerializedName("province")
    public String province;

    @SerializedName("speed_accuracy")
    public float speedAccuracyMetersPerSecond;

    @SerializedName("street")
    public String street;

    @SerializedName("street_num")
    public String streetNum;

    @SerializedName("sys_extra")
    public String sysExtras;

    @SerializedName("timestamp")
    public long timestamp;

    public LocationInfo() {
    }
}
