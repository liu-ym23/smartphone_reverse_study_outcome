package com.bytedance.bdlocation.scan.gps;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.location.database.StarCellDbManager;
import ia.b;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BDGpsInfo {

    @b(LocationMonitorConst.ACCURACY)
    public float accuracy;

    @b("altitude")
    public double altitude;

    @b("bearing_accuracy")
    public float bearingAccuracyDegrees;

    @b("callback_clock")
    public long callbackClock;

    @b("coordinate_system")
    public String coordinateSystem;

    @b("elapsed_realtime")
    public long elapsedRealtimeNanos;

    @b("elapsed_realtime_uncertainty")
    public double elapsedRealtimeUncertaintyNanos;

    @b("gps_mode")
    public int gpsMode;

    @b("latitude")
    public double latitude;

    @b("latitude_wgs84")
    public double latitudeWgs84;

    @b("log_id")
    public String logId;

    @b(StarCellDbManager.CellInfoEntry.LONGITUDE)
    public double longitude;

    @b("longitude_wgs84")
    public double longitudeWgs84;

    @b("orientation")
    public float orientation;

    @b("provider")
    public String provider;

    @b("real_timestamp")
    public long realTimestamp;

    @b("satellite_info")
    public List<BDSatelliteInfo> satelliteInfos;

    @b("satellite_num")
    public Integer satelliteNum;

    @b("snr")
    public List<Float> snr;

    @b("speed")
    public float speed;

    @b("speed_accuracy")
    public float speedAccuracyMetersPerSecond;

    @b("sys_extra")
    public String sysExtras;

    @b("timestamp")
    public long timestamp;

    @b("altitude_accuracy")
    public float verticalAccuracyMeters;

    public BDGpsInfo() {
    }

    public BDGpsInfo(BDGpsInfo r8, BDGnssInfo r10) {
        this.logId = r8.logId;
        this.longitude = r8.longitude;
        this.latitude = r8.latitude;
        this.accuracy = r8.accuracy;
        this.coordinateSystem = r8.coordinateSystem;
        this.provider = r8.provider;
        this.speed = r8.speed;
        this.orientation = r8.orientation;
        this.altitude = r8.altitude;
        this.timestamp = r8.timestamp;
        this.gpsMode = r8.gpsMode;
        this.realTimestamp = r8.realTimestamp;
        this.elapsedRealtimeNanos = r8.elapsedRealtimeNanos;
        this.elapsedRealtimeUncertaintyNanos = r8.elapsedRealtimeUncertaintyNanos;
        this.verticalAccuracyMeters = r8.verticalAccuracyMeters;
        this.bearingAccuracyDegrees = r8.bearingAccuracyDegrees;
        this.speedAccuracyMetersPerSecond = r8.speedAccuracyMetersPerSecond;
        this.sysExtras = r8.sysExtras;
        this.callbackClock = r8.callbackClock;
        this.latitudeWgs84 = r8.latitudeWgs84;
        this.longitudeWgs84 = r8.longitudeWgs84;
        this.satelliteNum = Integer.valueOf(r10.satelliteNum);
        this.snr = r10.snr;
        this.satelliteInfos = r10.satelliteInfos;
    }
}
