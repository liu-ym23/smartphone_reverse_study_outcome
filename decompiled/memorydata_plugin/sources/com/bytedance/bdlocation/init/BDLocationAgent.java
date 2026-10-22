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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationAgent {
    public BDLocationAgent() {
    }

    public static void addLightLocationSubmitNotification(LightLocationSubmitNotification r2) {
        LightLocationSubmitNotification r3 = (LightLocationSubmitNotification) ZeusTransformUtils.wrapperContextForParams(r2, LightLocationSubmitNotification.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        BDLocationHelper.getInstance();
        BDLocationHelper.addLightLocationSubmitNotification(r3);
    }

    public static void addNotification(LocationNotification r2, int r3) {
        BDLocationHelper.addNotification((LocationNotification) ZeusTransformUtils.wrapperContextForParams(r2, LocationNotification.class, "com.obric.memorydata.plugin"), r3);
    }

    public static void addNotification(LocationNotification r2, Object r3) {
        BDLocationHelper.addNotification((LocationNotification) ZeusTransformUtils.wrapperContextForParams(r2, LocationNotification.class, "com.obric.memorydata.plugin"), r3);
    }

    public static void addSubmitNotification(Object r2, LocationSubmitNotification r3) {
        LocationSubmitNotification r4 = (LocationSubmitNotification) ZeusTransformUtils.wrapperContextForParams(r3, LocationSubmitNotification.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        BDLocationHelper.addSubmitNotification(r2, r4);
    }

    public static BDPoint convertGCJ02(BDPoint r1) {
        return BDLocationHelper.getInstance().convertGCJ02(r1);
    }

    public static void doColdBootLocateDurationMonitor(boolean r0, boolean r1, String r2, long r3, long r5) {
        LocationMonitor.doColdBootLocateDuration(r0, r1, r2, r3, r5);
    }

    public static BDLocation geocode(double r7, double r9, int r11, Object r12) {
        return geocode(r7, r9, r11, r12, 0);
    }

    public static BDLocation geocode(double r0, double r2, int r4, Object r5, int r6) {
        BdGisResult r1 = getBdGisResult(r0, r2, r4, r5, r6);
        if (r1 != null) goto L5;
        return null;
    L5:
        return LocationUtil.geoLocationResultToBDLocation(null, r1);
    }

    public static BDLocation geocode(double r7, double r9, int r11, boolean r12) {
        return geocode(r7, r9, r11, r12, 0);
    }

    public static BDLocation geocode(double r0, double r2, int r4, boolean r5, int r6) {
        BdGisResult r1 = getBdGisResult(r0, r2, r4, r5, r6);
        if (r1 != null) goto L5;
        return null;
    L5:
        return LocationUtil.geoLocationResultToBDLocation(null, r1);
    }

    public static BdGisResult getBdGisResult(double r7, double r9, int r11, Object r12) {
        return BDLocationHelper.getInstance().geocode(r7, r9, r11, r12);
    }

    public static BdGisResult getBdGisResult(double r8, double r10, int r12, Object r13, int r14) {
        return BDLocationHelper.getInstance().geocode(r8, r10, r12, r13, r14);
    }

    public static BdGisResult getBdGisResult(double r7, double r9, int r11, boolean r12) {
        return BDLocationHelper.getInstance().geocode(r7, r9, r11, r12);
    }

    public static BdGisResult getBdGisResult(double r8, double r10, int r12, boolean r13, int r14) {
        return BDLocationHelper.getInstance().geocode(r8, r10, r12, r13, r14);
    }

    public static BDLocation getIPLocation(Object r1, int r2) {
        return BDLocationHelper.getInstance().getIPLocation(r1, r2);
    }

    public static BDLocation getLastKnownLocation(int r1, boolean r2) {
        return BDLocationHelper.getInstance().getLastKnowLocation(r1, r2);
    }

    public static BDLocation getLastKnownLocation(Object r1) {
        return BDLocationHelper.getInstance().getLastKnowLocation(r1);
    }

    public static BDLocation getLastKnownLocation(Object r1, int r2, boolean r3) {
        return BDLocationHelper.getInstance().getLastKnowLocation(r1, r2, r3);
    }

    public static void getLightLocation(Object r1, String r2, boolean r3) {
        BDLocationHelper.getInstance().getLightLocation(r1, r2, r3);
    }

    public static String getLightLocationInfoBeforeInit(Context r11, String r12, boolean r13, long r14, String r16, boolean r17, int r18, int r19) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        return BDLocationHelper.getInstance().getLightLocationInfoBeforeInit(r2, r12, r13, r14, r16, r17, r18, r19);
    }

    public static RegionBean getRegion(boolean r1) {
        return BDLocationHelper.getInstance().getRegion(r1);
    }

    public static RegionBean getRegion(boolean r1, boolean r2) {
        return BDLocationHelper.getInstance().getRegion(r1, r2);
    }

    public static ISceneStatusCallback getSceneStatusCallback() {
        return BDLocationHelper.getInstance().getSceneStatusCallback();
    }

    public static void init(LocationInitConfig r1) {
        BDLocationHelper.getInstance().init(r1);
    }

    public static boolean isInit() {
        return BDLocationHelper.getInstance().isInit();
    }

    public static void removeLightLocationSubmitNotification(LightLocationSubmitNotification r2) {
        LightLocationSubmitNotification r3 = (LightLocationSubmitNotification) ZeusTransformUtils.wrapperContextForParams(r2, LightLocationSubmitNotification.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        BDLocationHelper.getInstance();
        BDLocationHelper.removeLightLocationSubmitNotification(r3);
    }

    public static void removeNotification(LocationNotification r2, int r3) {
        BDLocationHelper.removeNotification((LocationNotification) ZeusTransformUtils.wrapperContextForParams(r2, LocationNotification.class, "com.obric.memorydata.plugin"), r3);
    }

    public static void removeSubmitNotification(LocationSubmitNotification r2) {
        LocationSubmitNotification r3 = (LocationSubmitNotification) ZeusTransformUtils.wrapperContextForParams(r2, LocationSubmitNotification.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        BDLocationHelper.removeSubmitNotification(r3);
    }

    public static void requestLightLocationUpdateBeforeInit(Context r12, boolean r13, long r14, boolean r16, boolean r17, long r18, boolean r20, long r21) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        BDLocationHelper r1 = BDLocationHelper.getInstance();
        if (r17 == false) goto L5;
        r1.requestCellUpdateBeforeInit(r2, r13, r14, r16, r18, r20, r21);
        return;
    L5:
        r1.requestWifiUpdateBeforeInit(r2, r13, r14, r16, r18, r21);
    }

    public static void requestLocationPermission(Activity r2, Object r3, int r4, RequestPermissionUtils.OnPermissionListener r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        RequestPermissionUtils.OnPermissionListener r7 = (RequestPermissionUtils.OnPermissionListener) ZeusTransformUtils.wrapperContextForParams(r5, RequestPermissionUtils.OnPermissionListener.class, "com.obric.memorydata.plugin");
        BDLocationHelper.getInstance().requestLocationPermission(r6, r3, r4, r7);
    }

    public static void setBaseUrl(String r1) {
        BDLocationHelper.getInstance().setBaseUrl(r1);
    }

    public static void updateSettings(Context r2, JSONObject r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        BDLocationHelper.getInstance().updateSettings(r4, r3);
    }

    public static boolean uploadRegionInfo() {
        return BDLocationHelper.getInstance().uploadRegionInfo();
    }

    public static void uploadRegionInfoAsync(RegionUploadCallback r2) {
        RegionUploadCallback r3 = (RegionUploadCallback) ZeusTransformUtils.wrapperContextForParams(r2, RegionUploadCallback.class, "com.obric.memorydata.plugin");
        BDLocationHelper.getInstance().uploadRegionInfoAsync(r3);
    }
}
