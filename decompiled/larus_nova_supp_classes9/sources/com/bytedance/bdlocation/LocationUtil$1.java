package com.bytedance.bdlocation;

import com.bytedance.bdlocation.callback.LocationUploadCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.network.model.BaseStation;
import com.bytedance.bdlocation.network.model.DeviceLocation;
import com.bytedance.bdlocation.network.model.DeviceStatus;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.network.model.RefreshBaseStationInfo;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.scan.wifi.WifiUtil;
import com.bytedance.bdlocation.sensor.SensorInfoManager;
import com.google.gson.JsonArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class LocationUtil$1 implements WifiUtil.WifiInfoJsonCallback {
    final /* synthetic */ long val$WifiScanStartTime;
    final /* synthetic */ LocationUploadCallback val$callback;
    final /* synthetic */ DeviceLocation val$deviceLocation;
    final /* synthetic */ DeviceStatus val$deviceStatus;
    final /* synthetic */ LocationUploadExtra val$extra;
    final /* synthetic */ Object val$finalBpeaCert;
    final /* synthetic */ boolean val$finalIsOnceLocation;
    final /* synthetic */ LocationOption val$finalLocationOption;
    final /* synthetic */ RefreshBaseStationInfo val$finalRefreshBaseStationInfo;
    final /* synthetic */ LocationTraceLogger val$finalTraceLogger;

    public void onFailed(BDLocationException r11) {
        if (this.val$finalIsOnceLocation == true) goto L5;
    L7:
        Logger.i("LocationUtil.getLocationInfoMustInNetworkIOThreadPool.onFailed: skip light info.");
    L9:
        if (LocationUtil.access$000(this.val$finalBpeaCert, this.val$deviceLocation, this.val$finalTraceLogger, this.val$finalRefreshBaseStationInfo, this.val$finalLocationOption) == false) goto L11;
        LocationUtil.access$100(this.val$deviceLocation, this.val$finalBpeaCert, null, false, this.val$finalRefreshBaseStationInfo, this.val$finalLocationOption);
    L11:
        BaseStation r13 = this.val$deviceLocation.baseLocation;
        if (r13 == null) goto L14;
        LocationMonitor.locationTracePutMetricData(this.val$finalTraceLogger, "upload_base_station_info_gap", r13.baseStationGap);
    L14:
        LocationUtil.access$200(this.val$deviceLocation, this.val$deviceStatus, this.val$extra, this.val$callback, false, null);
        return;
    L5:
        if (BDLocationConfig.isCollectLightInfo() == false) goto L7;
        SensorInfoManager.getInstance().unregisterListener(5);
        DeviceLocation r14 = this.val$deviceLocation;
        r14.lightInfoList = SensorInfoManager.getInstance().getLightInfoList();
        goto L9
    }

    public void onWifiInfoJson(JsonArray r10, boolean r11, boolean r13, WifiInfo r14) {
        Logger.i("LocationUtil scan wifi intervalTime:" + (System.currentTimeMillis() - this.val$WifiScanStartTime));
        this.val$deviceLocation.wifiInfo = r10;
        if (this.val$finalIsOnceLocation == true) goto L5;
    L7:
        Logger.i("LocationUtil.getLocationInfoMustInNetworkIOThreadPool: skip light info.");
    L8:
        if (r11 == false) goto L10;
        this.val$deviceStatus.isWifiCache = "true";
    L12:
        if (LocationUtil.access$000(this.val$finalBpeaCert, this.val$deviceLocation, this.val$finalTraceLogger, this.val$finalRefreshBaseStationInfo, this.val$finalLocationOption) == false) goto L14;
        LocationUtil.access$100(this.val$deviceLocation, this.val$finalBpeaCert, null, false, this.val$finalRefreshBaseStationInfo, this.val$finalLocationOption);
    L14:
        BaseStation r15 = this.val$deviceLocation.baseLocation;
        if (r15 == null) goto L17;
        LocationMonitor.locationTracePutMetricData(this.val$finalTraceLogger, "upload_base_station_info_gap", r15.baseStationGap);
    L17:
        LocationUtil.access$200(this.val$deviceLocation, this.val$deviceStatus, this.val$extra, this.val$callback, r13, r14);
        return;
    L10:
        this.val$deviceStatus.isWifiCache = "false";
        goto L12
    L5:
        if (BDLocationConfig.isCollectLightInfo() == false) goto L7;
        SensorInfoManager.getInstance().unregisterListener(5);
        this.val$deviceLocation.lightInfoList = SensorInfoManager.getInstance().getLightInfoList();
        goto L8
    }

    public LocationUtil$1(long r1, DeviceLocation r3, boolean r4, DeviceStatus r5, Object r6, LocationTraceLogger r7, RefreshBaseStationInfo r8, LocationOption r9, LocationUploadExtra r10, LocationUploadCallback r11) {
        this.val$WifiScanStartTime = r1;
        this.val$deviceLocation = r3;
        this.val$finalIsOnceLocation = r4;
        this.val$deviceStatus = r5;
        this.val$finalBpeaCert = r6;
        this.val$finalTraceLogger = r7;
        this.val$finalRefreshBaseStationInfo = r8;
        this.val$finalLocationOption = r9;
        this.val$extra = r10;
        this.val$callback = r11;
    }
}
