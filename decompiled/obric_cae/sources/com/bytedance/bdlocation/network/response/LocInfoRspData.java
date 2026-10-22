package com.bytedance.bdlocation.network.response;

import android.aimedia.a;
import com.bytedance.bdlocation.monitor.LocationExtraDataTraceLogger;
import com.bytedance.bdlocation.network.model.LocationResult;
import com.bytedance.bdlocation.network.model.RegionCountry;
import ia.b;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LocInfoRspData {

    @b("disable_polling_upload")
    public int disablePollingUpload;

    @b("disabled_uuid_list")
    public List<String> disableUuidList;

    @b("in_outdoor_confidence")
    public float inOutDoorConfidence;

    @b("in_outdoor_status")
    public int inOutDoorStatus;

    @b("is_indoor")
    public int isIndoor;

    @b("is_locate")
    public boolean isLocate;

    @b("is_wifi_rescan")
    public int isWifiRescan;

    @b("Location")
    public LocationResult location;

    @b("disable_locate_on_moving_only")
    public int movingSceneWithAoiStatus;

    @b("next_ble_scan_interval")
    public long nextBleScanInterval;

    @b("next_gps_scan_interval")
    public long nextGPSScanInterval;

    @b("next_polling_upload_interval")
    public long nextPollingUploadInterval;

    @b("Country")
    public RegionCountry regionCountry;

    @b(LocationExtraDataTraceLogger.SUBMIT_BLE_NOW)
    public boolean submitBleNow;
    public String submitLogId;

    public LocInfoRspData(LocInfoRspData r8) {
        this.isIndoor = r8.isIndoor;
        this.isLocate = r8.isLocate;
        this.submitLogId = r8.submitLogId;
        this.location = r8.location;
        this.nextBleScanInterval = r8.nextBleScanInterval;
        this.submitBleNow = r8.submitBleNow;
        this.nextPollingUploadInterval = r8.nextPollingUploadInterval;
        this.regionCountry = r8.regionCountry;
        this.nextGPSScanInterval = r8.nextGPSScanInterval;
        this.disableUuidList = r8.disableUuidList;
        this.disablePollingUpload = r8.disablePollingUpload;
        this.isWifiRescan = r8.isWifiRescan;
        this.inOutDoorStatus = r8.inOutDoorStatus;
        this.inOutDoorConfidence = r8.inOutDoorConfidence;
        this.movingSceneWithAoiStatus = r8.movingSceneWithAoiStatus;
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("LocInfoRspData{isIndoor=");
        r8.append(this.isIndoor);
        r8.append(", isLocate=");
        r8.append(this.isLocate);
        r8.append(", submitLogId='");
        r8.append(this.submitLogId);
        r8.append("', nextBleScanInterval=");
        r8.append(this.nextBleScanInterval);
        r8.append(", submitBleNow=");
        r8.append(this.submitBleNow);
        r8.append(", nextPollingUploadInterval=");
        r8.append(this.nextPollingUploadInterval);
        r8.append(", location=");
        r8.append(this.location);
        r8.append(", regionCountry=");
        r8.append(this.regionCountry);
        r8.append(", nextGPSScanInterval=");
        r8.append(this.nextGPSScanInterval);
        r8.append(", disableUuidList=");
        r8.append(this.disableUuidList);
        r8.append(", disablePollingUpload=");
        r8.append(this.disablePollingUpload);
        r8.append(", isRescanWifi=");
        r8.append(this.isWifiRescan);
        r8.append(", inOutDoorStatus=");
        r8.append(this.inOutDoorStatus);
        r8.append(", inOutDoorConfidence=");
        r8.append(this.inOutDoorConfidence);
        r8.append(", movingSceneWithAoiStatus=");
        return a.f(r8, this.movingSceneWithAoiStatus, '}');
    }
}
