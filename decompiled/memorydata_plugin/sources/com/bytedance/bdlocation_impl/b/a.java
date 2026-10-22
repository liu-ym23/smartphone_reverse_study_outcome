package com.bytedance.bdlocation_impl.b;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.LocationSubmitNotification;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationExtraDataTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.network.model.StationarySceneCacheInfo;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.bytedance.bdlocation.service.BDLocationExtraDataServer;
import com.bytedance.bdlocation.settings.LocationSettingUtil;
import com.bytedance.bdlocation.store.LocationCache;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static void a() {
        BDLocationConfig.setFirstRequestLocation(false);
    }

    public static void a(LocInfoRspData r3) {
        if (r3 != null) goto L6;
        long r0 = BDLocationConfig.getDefaultGpsScanInterval();
    L4:
        BDLocationConfig.setGpsScanInterval(r0);
        return;
    L6:
        Logger.i("ResponseExecutor: setNextGpsScanInterval and interval:" + r3.nextGPSScanInterval);
        r0 = r3.nextGPSScanInterval;
        goto L4
    }

    private static void a(LocInfoRspData r3, BDLocation r4) {
        if (r3 != null) goto L19;
        return;
    L19:
    L16:
        e = move-exception;
        Logger.i("submitCallback error:" + e.toString());
        return;
    L5:
        if (BDLocationConfig.getSubmitNotification() != null) goto L7;
        return;
    L7:
        if (BDLocationConfig.getSubmitNotification().size() <= 0) goto L27;
        if (r4 == null) goto L28;
        BDLocation r0 = new BDLocation(r4);     // Catch: Exception -> L16
        r0.setSubmitLogId(r3.submitLogId);     // Catch: Exception -> L16
        Iterator<LocationSubmitNotification> r5 = BDLocationConfig.getSubmitNotification().iterator();     // Catch: Exception -> L16
    L11:
        if (r5.hasNext() == false) goto L29;
        LocationSubmitNotification r6 = (LocationSubmitNotification) ZeusTransformUtils.preCheckCast(r5.next(), LocationSubmitNotification.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L16
        if (r6 == null) goto L11;
        r6.onSubmitListener(r0);     // Catch: Exception -> L16
        goto L11
    L29:
        return;
    L28:
        return;
    }

    private static void a(LocInfoRspData r5, LocationOption r6) {
        if (r5 == null) goto L10;
        long r2 = r5.nextBleScanInterval;
        BDLocationConfig.setUploadBleImmediately(r5.submitBleNow);
        BDLocationConfig.setDisableUuidList(r5.disableUuidList);
        if (r2 <= 0) goto L8;
    L6:
        BDLocationConfig.setScanBleInterval(r2);
        goto L10
    L8:
        if (LocationSettingUtil.getLocationConfig() == null) goto L10;
        r2 = LocationSettingUtil.getLocationConfig().scanBleInterval;
    L10:
        Logger.i("collectBleExtraData BLE_SCAN_INTERVAL：" + BDLocationConfig.getScanBleInterval() + "SUBMIT_BLE_NOW:" + BDLocationConfig.isUploadBleImmediately());
        if (r6 == null) goto L20;
        LocationExtraDataTraceLogger r7 = r6.getLocationExtraDataTraceLogger();
        if (BDLocationConfig.getScanBleInterval() <= 0) goto L15;
        boolean r0 = true;
    L16:
        LocationMonitor.locationExtraDataTracePutCategoryData(r7, LocationExtraDataTraceLogger.HAS_BLE_SCAN_INTERVAL, Boolean.valueOf(r0));
        LocationMonitor.locationExtraDataTracePutCategoryData(r7, LocationExtraDataTraceLogger.BLE_SCAN_INTERVAL, Long.valueOf(BDLocationConfig.getScanBleInterval()));
        LocationMonitor.locationExtraDataTracePutCategoryData(r7, LocationExtraDataTraceLogger.SUBMIT_BLE_NOW, Boolean.valueOf(BDLocationConfig.isUploadBleImmediately()));
        BDLocationExtraDataServer r8 = r6.getLocationExtraDataServer();
        if (r8 == null) goto L21;
        r8.startCollectBluetoothData(r6);
        return;
    L21:
        return;
    L15:
        r0 = false;
        goto L16
    }

    public static boolean a(LocInfoRspData r0, BDLocation r1, LocationOption r2) {
        if (r0 != null) goto L10;
    L4:
        a(r0, r1);     // Catch: Exception -> L7
        a(r0, r2);     // Catch: Exception -> L7
        a();     // Catch: Exception -> L7
        return true;
    L7:
        e = move-exception;
        e.printStackTrace();
        Logger.e("The exception was occurred when the response data was convert to LocInfoRspData ");
        return false;
    L10:
        b(r0);     // Catch: Exception -> L7
        goto L4
    }

    private static void b(LocInfoRspData r4) {
        if (r4 == null) goto L7;
        com.bytedance.bdlocation_impl.a.a.f1899a = System.currentTimeMillis();
        long r0 = r4.nextPollingUploadInterval * 1000;
        if (r0 != 0) goto L6;
        r0 = BDLocationConfig.getUploadInterval();
    L6:
        com.bytedance.bdlocation_impl.a.a r5 = com.bytedance.bdlocation_impl.a.a.a();
    L8:
        r5.b(r0);
        return;
    L7:
        r5 = com.bytedance.bdlocation_impl.a.a.a();
        r0 = BDLocationConfig.getUploadInterval();
        goto L8
    }

    public static void b(LocInfoRspData r4, BDLocation r5, LocationOption r6) {
        if (r6 == null) goto L4;
        LocationTraceLogger r0 = r6.getLocationTraceLogger();
    L5:
        int r3 = 0;
        if (BDLocationConfig.enableStationaryScenePolicy() == true) goto L10;
        int r7 = 0;
    L8:
        LocationMonitor.locationTracePutCategoryData(r0, LocationMonitorConst.CHECK_STATIONARY_SCENE_POLICY_AFTER_LOCATION, r7);
        return;
    L10:
        if (r6 == null) goto L15;
        if (r4 == null) goto L15;
        StationarySceneCacheInfo r8 = r6.getStationarySceneCacheInfo();
        if (r8 == null) goto L15;
        r8.setLocationResult(r4.location);
        LocationCache.getInstance().setStationarySceneCacheInfo(r8);
    L15:
        if (r4 == null) goto L17;
        r3 = r4.movingSceneWithAoiStatus;
    L17:
        r7 = Integer.valueOf(LocationUtil.checkStationaryScenePolicyAfterLocation(r5, LocationCache.getInstance().fastGetLocationCacheUnsafe().getLatestLocation(), r3, r0));
        goto L8
    L4:
        r0 = null;
        goto L5
    }
}
