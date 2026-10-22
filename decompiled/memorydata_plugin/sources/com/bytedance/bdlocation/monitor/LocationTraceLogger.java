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

    private JSONObject getSuccessCategory(BDLocation r3, LocationOption r4) {
        JSONObject r0 = new JSONObject();
        dumpCategoriesTo(r0);
        JsonUtil.safePutString(r0, LocationMonitorConst.LOCATION_NAME, r3.getLocationSDKName());
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_CODE, BDLocationException.SUCCESS);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, "success");
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_SUCCESS, true);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_TIMEOUT, false);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_CACHE, r3.isCache());
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_CN, r4.isChineseRegion());
        JsonUtil.safePutInt(r0, LocationMonitorConst.LOCATE_TYPE, r3.getLocationType());
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_WIFI_OPEN, LocationUtil.isWifiOpen());
        JsonUtil.safePutString(r0, "upload_source", r4.getUploadSource());
        return r0;
    }

    private JSONObject getSuccessExtra(BDLocation r5, LocationOption r6) {
        JSONObject r4 = new JSONObject();
        JsonUtil.safePutDouble(r4, LocationMonitorConst.ACCURACY, r5.getAccuracy());
        JsonUtil.safePutLong(r4, "cache_time", r6.getMaxCacheTime());
        JsonUtil.safePutLong(r4, LocationMonitorConst.TIMEOUT, r6.getLocationTimeOutMs());
        JsonUtil.safePutString(r4, "upload_source", r6.getUploadSource());
        JsonUtil.safePutLong(r4, LocationMonitorConst.INTEL_UPLOAD_INTERVAL, r6.getUploadInterval());
        if (r5.isCache() == false) goto L5;
        JsonUtil.safePutLong(r4, LocationMonitorConst.CACHE_TIMESTAMP, r5.getLocationMs());
        JsonUtil.safePutLong(r4, "cache_duration", System.currentTimeMillis() - r5.getLocationMs());
    L6:
        JsonUtil.safePutLong(r4, "timestamp", System.currentTimeMillis());
        return r4;
    L5:
        JsonUtil.safePutLong(r4, LocationMonitorConst.CACHE_TIMESTAMP, 0);
        JsonUtil.safePutLong(r4, "cache_duration", 0);
        goto L6
    }

    private JSONObject getSuccessMetric() {
        JSONObject r0 = new JSONObject();
        dumpMetricsTo(r0);
        return r0;
    }

    public void locationErrorReport(BDLocationException r5) {
        JSONObject r4 = new JSONObject();
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutBoolean(r4, LocationMonitorConst.IS_SUCCESS, false);
        if (r5 == null) goto L5;
        JsonUtil.safePutString(r4, LocationMonitorConst.ERR_CODE, r5.getCode());
        JsonUtil.safePutString(r4, LocationMonitorConst.ERR_MSG, r5.getMessage());
        JsonUtil.safePutString(r0, LocationMonitorConst.DETAIL_ERR_MSG, r5.getDetailMessage());
    L6:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BD_LOCATION_TRACE_LOG, r4, null, r0);
        return;
    L5:
        JsonUtil.safePutString(r4, LocationMonitorConst.ERR_CODE, "-1002");
        JsonUtil.safePutString(r4, LocationMonitorConst.ERR_MSG, "exception is null");
        goto L6
    }

    public void locationSuccessReport(BDLocation r3, LocationOption r4) {
        if (r3 == null) goto L7;
        if (r4 == null) goto L8;
        JSONObject r0 = getSuccessCategory(r3, r4);
        JSONObject r1 = getSuccessMetric();
        JSONObject r2 = getSuccessExtra(r3, r4);
        Logger.i("LocationTraceLogger category:" + r0.toString());
        Logger.i("LocationTraceLogger   metric:" + r1.toString());
        Logger.i("LocationTraceLogger    extra:" + r2.toString());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BD_LOCATION_TRACE_LOG, r0, r1, r2);
        return;
    L8:
        return;
    }
}
