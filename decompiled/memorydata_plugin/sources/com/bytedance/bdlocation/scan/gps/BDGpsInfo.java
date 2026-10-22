package com.bytedance.bdlocation.scan.gps;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BDGpsInfo {

    @SerializedName(LocationMonitorConst.ACCURACY)
    public float accuracy;

    @SerializedName("altitude")
    public double altitude;

    @SerializedName("bearing_accuracy")
    public float bearingAccuracyDegrees;

    @SerializedName("callback_clock")
    public long callbackClock;

    @SerializedName("coordinate_system")
    public String coordinateSystem;

    @SerializedName("elapsed_realtime")
    public long elapsedRealtimeNanos;

    @SerializedName("elapsed_realtime_uncertainty")
    public double elapsedRealtimeUncertaintyNanos;

    @SerializedName("gps_mode")
    public int gpsMode;

    @SerializedName("latitude")
    public double latitude;

    @SerializedName("latitude_wgs84")
    public double latitudeWgs84;

    @SerializedName("log_id")
    public String logId;

    @SerializedName("longitude")
    public double longitude;

    @SerializedName("longitude_wgs84")
    public double longitudeWgs84;

    @SerializedName("orientation")
    public float orientation;

    @SerializedName("provider")
    public String provider;

    @SerializedName("real_timestamp")
    public long realTimestamp;

    @SerializedName("satellite_info")
    public List<BDSatelliteInfo> satelliteInfos;

    @SerializedName("satellite_num")
    public Integer satelliteNum;

    @SerializedName("snr")
    public List<Float> snr;

    @SerializedName("speed")
    public float speed;

    @SerializedName("speed_accuracy")
    public float speedAccuracyMetersPerSecond;

    @SerializedName("sys_extra")
    public String sysExtras;

    @SerializedName("timestamp")
    public long timestamp;

    @SerializedName("altitude_accuracy")
    public float verticalAccuracyMeters;

    public BDGpsInfo() {
    }

    public BDGpsInfo(BDGpsInfo r3, BDGnssInfo r4) {
        this.logId = r3.logId;
        this.longitude = r3.longitude;
        this.latitude = r3.latitude;
        this.accuracy = r3.accuracy;
        this.coordinateSystem = r3.coordinateSystem;
        this.provider = r3.provider;
        this.speed = r3.speed;
        this.orientation = r3.orientation;
        this.altitude = r3.altitude;
        this.timestamp = r3.timestamp;
        this.gpsMode = r3.gpsMode;
        this.realTimestamp = r3.realTimestamp;
        this.elapsedRealtimeNanos = r3.elapsedRealtimeNanos;
        this.elapsedRealtimeUncertaintyNanos = r3.elapsedRealtimeUncertaintyNanos;
        this.verticalAccuracyMeters = r3.verticalAccuracyMeters;
        this.bearingAccuracyDegrees = r3.bearingAccuracyDegrees;
        this.speedAccuracyMetersPerSecond = r3.speedAccuracyMetersPerSecond;
        this.sysExtras = r3.sysExtras;
        this.callbackClock = r3.callbackClock;
        this.latitudeWgs84 = r3.latitudeWgs84;
        this.longitudeWgs84 = r3.longitudeWgs84;
        this.satelliteNum = Integer.valueOf(r4.satelliteNum);
        this.snr = r4.snr;
        this.satelliteInfos = r4.satelliteInfos;
    }
}
