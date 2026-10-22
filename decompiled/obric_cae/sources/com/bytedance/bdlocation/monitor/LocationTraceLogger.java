package com.bytedance.bdlocation.monitor;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LocationTraceLogger extends AbstractTraceLogger {
    public LocationTraceLogger() {
    }

    private JSONObject getSuccessCategory(BDLocation r8, LocationOption r10) {
        JSONObject r11 = new JSONObject();
        dumpCategoriesTo(r11);
        JsonUtil.safePutString(r11, LocationMonitorConst.LOCATION_NAME, r8.getLocationSDKName());
        JsonUtil.safePutString(r11, LocationMonitorConst.ERR_CODE, BDLocationException.SUCCESS);
        JsonUtil.safePutString(r11, LocationMonitorConst.ERR_MSG, "success");
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.IS_SUCCESS, true);
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.IS_TIMEOUT, false);
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.IS_CACHE, r8.isCache());
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.IS_CN, r10.isChineseRegion());
        JsonUtil.safePutInt(r11, LocationMonitorConst.LOCATE_TYPE, r8.getLocationType());
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.IS_WIFI_OPEN, LocationUtil.isWifiOpen());
        JsonUtil.safePutString(r11, "upload_source", r10.getUploadSource());
        return r11;
    }

    private JSONObject getSuccessExtra(BDLocation r8, LocationOption r10) {
        JSONObject r11 = new JSONObject();
        JsonUtil.safePutDouble(r11, LocationMonitorConst.ACCURACY, r8.getAccuracy());
        JsonUtil.safePutLong(r11, "cache_time", r10.getMaxCacheTime());
        JsonUtil.safePutLong(r11, "timeout", r10.getLocationTimeOutMs());
        JsonUtil.safePutString(r11, "upload_source", r10.getUploadSource());
        JsonUtil.safePutLong(r11, LocationMonitorConst.INTEL_UPLOAD_INTERVAL, r10.getUploadInterval());
        if (r8.isCache() == false) goto L5;
        JsonUtil.safePutLong(r11, LocationMonitorConst.CACHE_TIMESTAMP, r8.getLocationMs());
        JsonUtil.safePutLong(r11, "cache_duration", System.currentTimeMillis() - r8.getLocationMs());
    L6:
        JsonUtil.safePutLong(r11, "timestamp", System.currentTimeMillis());
        return r11;
    L5:
        JsonUtil.safePutLong(r11, LocationMonitorConst.CACHE_TIMESTAMP, 0);
        JsonUtil.safePutLong(r11, "cache_duration", 0);
        goto L6
    }

    private JSONObject getSuccessMetric() {
        JSONObject r8 = new JSONObject();
        dumpMetricsTo(r8);
        return r8;
    }

    public void locationErrorReport(BDLocationException r8) {
        JSONObject r10 = new JSONObject();
        JSONObject r11 = new JSONObject();
        JsonUtil.safePutBoolean(r10, LocationMonitorConst.IS_SUCCESS, false);
        if (r8 == null) goto L5;
        JsonUtil.safePutString(r10, LocationMonitorConst.ERR_CODE, r8.getCode());
        JsonUtil.safePutString(r10, LocationMonitorConst.ERR_MSG, r8.getMessage());
        JsonUtil.safePutString(r11, LocationMonitorConst.DETAIL_ERR_MSG, r8.getDetailMessage());
    L6:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BD_LOCATION_TRACE_LOG, r10, null, r11);
        return;
    L5:
        JsonUtil.safePutString(r10, LocationMonitorConst.ERR_CODE, "-1002");
        JsonUtil.safePutString(r10, LocationMonitorConst.ERR_MSG, "exception is null");
        goto L6
    }

    public void locationSuccessReport(BDLocation r8, LocationOption r10) {
        if (r8 == null) goto L7;
        if (r10 == null) goto L8;
        JSONObject r11 = getSuccessCategory(r8, r10);
        JSONObject r12 = getSuccessMetric();
        JSONObject r13 = getSuccessExtra(r8, r10);
        Logger.i("LocationTraceLogger category:" + r11.toString());
        Logger.i("LocationTraceLogger   metric:" + r12.toString());
        Logger.i("LocationTraceLogger    extra:" + r13.toString());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BD_LOCATION_TRACE_LOG, r11, r12, r13);
        return;
    L8:
        return;
    }
}
