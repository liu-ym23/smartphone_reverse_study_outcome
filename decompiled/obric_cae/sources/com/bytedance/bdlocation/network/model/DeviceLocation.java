package com.bytedance.bdlocation.network.model;

import com.bytedance.bdlocation.sensor.LightInfo;
import ha.m;
import ia.b;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DeviceLocation {

    @b("amap_location")
    public LocationInfo aMapLocation;

    @b("base_station")
    public BaseStation baseLocation;

    @b("light_info_list")
    public List<LightInfo> lightInfoList;

    @b("location_strategy")
    public String locationMode;

    @b("sys_location")
    public LocationInfo sysLocation;

    @b("wifi_info_list")
    public m wifiInfo;

    public DeviceLocation() {
    }
}
