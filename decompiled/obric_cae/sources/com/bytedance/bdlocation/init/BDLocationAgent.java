package com.bytedance.bdlocation.init;

import android.app.Activity;
import android.content.Context;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.ISceneStatusCallback;
import com.bytedance.bdlocation.callback.LightLocationSubmitNotification;
import com.bytedance.bdlocation.callback.LocationNotification;
import com.bytedance.bdlocation.callback.LocationSubmitNotification;
import com.bytedance.bdlocation.callback.RegionUploadCallback;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.entity.gis.BdGisResult;
import com.bytedance.bdlocation.entity.region.RegionBean;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.permission.request.RequestPermissionUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationAgent {
    public BDLocationAgent() {
    }

    public static void addLightLocationSubmitNotification(LightLocationSubmitNotification r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        BDLocationHelper.getInstance();
        BDLocationHelper.addLightLocationSubmitNotification(r8);
    }

    public static void addNotification(LocationNotification r8, int r10) {
        BDLocationHelper.addNotification(r8, r10);
    }

    public static void addSubmitNotification(Object r8, LocationSubmitNotification r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        BDLocationHelper.addSubmitNotification(r8, r10);
    }

    public static BDPoint convertGCJ02(BDPoint r8) {
        return BDLocationHelper.getInstance().convertGCJ02(r8);
    }

    public static void doColdBootLocateDurationMonitor(boolean r8, boolean r10, String r11, long r12, long r13) {
        LocationMonitor.doColdBootLocateDuration(r8, r10, r11, r12, r13);
    }

    public static BDLocation geocode(double r8, double r10, int r11, Object r12) {
        return geocode(r8, r10, r11, r12, 0);
    }

    public static BdGisResult getBdGisResult(double r8, double r10, int r11, Object r12) {
        return BDLocationHelper.getInstance().geocode(r8, r10, r11, r12);
    }

    public static BDLocation getIPLocation(Object r8, int r10) {
        return BDLocationHelper.getInstance().getIPLocation(r8, r10);
    }

    public static BDLocation getLastKnownLocation(int r8, boolean r10) {
        return BDLocationHelper.getInstance().getLastKnowLocation(r8, r10);
    }

    public static void getLightLocation(Object r8, String r10, boolean r11) {
        BDLocationHelper.getInstance().getLightLocation(r8, r10, r11);
    }

    public static String getLightLocationInfoBeforeInit(Context r10, String r11, boolean r12, long r13, String r15, boolean r16, int r17, int r18) {
        return BDLocationHelper.getInstance().getLightLocationInfoBeforeInit(r10, r11, r12, r13, r15, r16, r17, r18);
    }

    public static RegionBean getRegion(boolean r8) {
        return BDLocationHelper.getInstance().getRegion(r8);
    }

    public static ISceneStatusCallback getSceneStatusCallback() {
        return BDLocationHelper.getInstance().getSceneStatusCallback();
    }

    public static void init(LocationInitConfig r8) {
        BDLocationHelper.getInstance().init(r8);
    }

    public static boolean isInit() {
        return BDLocationHelper.getInstance().isInit();
    }

    public static void removeLightLocationSubmitNotification(LightLocationSubmitNotification r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        BDLocationHelper.getInstance();
        BDLocationHelper.removeLightLocationSubmitNotification(r8);
    }

    public static void removeNotification(LocationNotification r8, int r10) {
        BDLocationHelper.removeNotification(r8, r10);
    }

    public static void removeSubmitNotification(LocationSubmitNotification r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        BDLocationHelper.removeSubmitNotification(r8);
    }

    public static void requestLightLocationUpdateBeforeInit(Context r11, boolean r12, long r13, boolean r15, boolean r16, long r17, boolean r19, long r20) {
        if (r16 == false) goto L4;
        BDLocationHelper.getInstance().requestCellUpdateBeforeInit(r11, r12, r13, r15, r17, r19, r20);
        return;
    L4:
        BDLocationHelper.getInstance().requestWifiUpdateBeforeInit(r11, r12, r13, r15, r17, r20);
    }

    public static void requestLocationPermission(Activity r8, Object r10, int r11, RequestPermissionUtils.OnPermissionListener r12) {
        BDLocationHelper.getInstance().requestLocationPermission(r8, r10, r11, r12);
    }

    public static void setBaseUrl(String r8) {
        BDLocationHelper.getInstance().setBaseUrl(r8);
    }

    public static void updateSettings(Context r8, JSONObject r10) {
        BDLocationHelper.getInstance().updateSettings(r8, r10);
    }

    public static boolean uploadRegionInfo() {
        return BDLocationHelper.getInstance().uploadRegionInfo();
    }

    public static void uploadRegionInfoAsync(RegionUploadCallback r8) {
        BDLocationHelper.getInstance().uploadRegionInfoAsync(r8);
    }

    public static void addNotification(LocationNotification r8, Object r10) {
        BDLocationHelper.addNotification(r8, r10);
    }

    public static BDLocation geocode(double r8, double r10, int r11, Object r12, int r13) {
        BdGisResult r14 = getBdGisResult(r8, r10, r11, r12, r13);
        if (r14 != null) goto L5;
        return null;
    L5:
        return LocationUtil.geoLocationResultToBDLocation(null, r14);
    }

    public static BdGisResult getBdGisResult(double r8, double r10, int r12, Object r13, int r14) {
        return BDLocationHelper.getInstance().geocode(r8, r10, r12, r13, r14);
    }

    public static BDLocation getLastKnownLocation(Object r8) {
        return BDLocationHelper.getInstance().getLastKnowLocation(r8);
    }

    public static RegionBean getRegion(boolean r8, boolean r10) {
        return BDLocationHelper.getInstance().getRegion(r8, r10);
    }

    public static BDLocation geocode(double r8, double r10, int r11, boolean r12) {
        return geocode(r8, r10, r11, r12, 0);
    }

    public static BdGisResult getBdGisResult(double r8, double r10, int r11, boolean r12) {
        return BDLocationHelper.getInstance().geocode(r8, r10, r11, r12);
    }

    public static BDLocation getLastKnownLocation(Object r8, int r10, boolean r11) {
        return BDLocationHelper.getInstance().getLastKnowLocation(r8, r10, r11);
    }

    public static BDLocation geocode(double r8, double r10, int r11, boolean r12, int r13) {
        BdGisResult r14 = getBdGisResult(r8, r10, r11, r12, r13);
        if (r14 != null) goto L5;
        return null;
    L5:
        return LocationUtil.geoLocationResultToBDLocation(null, r14);
    }

    public static BdGisResult getBdGisResult(double r8, double r10, int r12, boolean r13, int r14) {
        return BDLocationHelper.getInstance().geocode(r8, r10, r12, r13, r14);
    }
}
