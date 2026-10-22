package com.bytedance.bdlocation.network.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.cae.location.database.StarCellDbManager;
import com.obric.cae.location.database.StarLocationDbManager;
import ia.b;

/* JADX INFO: loaded from: classes.dex */
public class LocationInfo {

    @b(LocationMonitorConst.ACCURACY)
    public double accuracy;

    @b(StarLocationDbManager.GeofenceEntry.ADDRESS)
    public String address;

    @b("altitude")
    public double altitude;

    @b("altitude_accuracy")
    public double altitudeAccuracy;

    @b("bearing_accuracy")
    public float bearingAccuracyDegrees;

    @b("building_id")
    public String buildingId;

    @b("city")
    public String city;

    @b("coordinate_system")
    public String coordinateSystem;

    @b("country")
    public String country;

    @b("district")
    public String district;

    @b("elapsed_realtime")
    public long elapsedRealtimeNanos;

    @b("elapsed_realtime_uncertainty")
    public double elapsedRealtimeUncertaintyNanos;

    @b(WsConstants.KEY_EXTRA)
    public String extra;

    @b("floor")
    public String floor;

    @b("is_mock")
    public boolean isMock;

    @b("latitude")
    public double latitude;

    @b("latitude_wgs84")
    public double latitudeWgs84;

    @b(LocationMonitorConst.LOCATE_TYPE)
    public int locateType;

    @b(StarCellDbManager.CellInfoEntry.LONGITUDE)
    public double longitude;

    @b("longitude_wgs84")
    public double longitudeWgs84;

    @b("provider")
    public String provider;

    @b("province")
    public String province;

    @b("speed_accuracy")
    public float speedAccuracyMetersPerSecond;

    @b("street")
    public String street;

    @b("street_num")
    public String streetNum;

    @b("sys_extra")
    public String sysExtras;

    @b("timestamp")
    public long timestamp;

    public LocationInfo() {
    }
}
