package n5;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.LocationSubmitNotification;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
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
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static void a(LocInfoRspData r8, LocationOption r10) {
        if (r8 == null) goto L10;
        long r11 = r8.nextBleScanInterval;
        BDLocationConfig.setUploadBleImmediately(r8.submitBleNow);
        BDLocationConfig.setDisableUuidList(r8.disableUuidList);
        if (r11 <= 0) goto L8;
    L6:
        BDLocationConfig.setScanBleInterval(r11);
        goto L10
    L8:
        if (LocationSettingUtil.getLocationConfig() == null) goto L10;
        r11 = LocationSettingUtil.getLocationConfig().scanBleInterval;
    L10:
        Logger.i("collectBleExtraData BLE_SCAN_INTERVAL：" + BDLocationConfig.getScanBleInterval() + "SUBMIT_BLE_NOW:" + BDLocationConfig.isUploadBleImmediately());
        if (r10 == null) goto L20;
        LocationExtraDataTraceLogger r12 = r10.getLocationExtraDataTraceLogger();
        if (BDLocationConfig.getScanBleInterval() <= 0) goto L15;
        boolean r13 = true;
    L16:
        LocationMonitor.locationExtraDataTracePutCategoryData(r12, LocationExtraDataTraceLogger.HAS_BLE_SCAN_INTERVAL, Boolean.valueOf(r13));
        LocationMonitor.locationExtraDataTracePutCategoryData(r12, LocationExtraDataTraceLogger.BLE_SCAN_INTERVAL, Long.valueOf(BDLocationConfig.getScanBleInterval()));
        LocationMonitor.locationExtraDataTracePutCategoryData(r12, LocationExtraDataTraceLogger.SUBMIT_BLE_NOW, Boolean.valueOf(BDLocationConfig.isUploadBleImmediately()));
        BDLocationExtraDataServer r14 = r10.getLocationExtraDataServer();
        if (r14 == null) goto L21;
        r14.startCollectBluetoothData(r10);
        return;
    L21:
        return;
    L15:
        r13 = false;
        goto L16
    }

    public static void b(LocInfoRspData r8, BDLocation r10, LocationOption r11) {
        if (r8 != null) goto L18;
    L13:
        e(r8, r10);     // Catch: Exception -> L15
        a(r8, r11);     // Catch: Exception -> L15
        BDLocationConfig.setFirstRequestLocation(false);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        Logger.e("The exception was occurred when the response data was convert to LocInfoRspData ");
        return;
    L18:
        m5.a.f9271f = System.currentTimeMillis();     // Catch: Exception -> L15
        long r12 = r8.nextPollingUploadInterval * 1000;     // Catch: Exception -> L15
        if (r12 != 0) goto L6;
        r12 = BDLocationConfig.getUploadInterval();     // Catch: Exception -> L15
    L6:
        m5.a r13 = m5.a.a();     // Catch: Exception -> L15
        if (r13.f9272a == false) goto L13;
        Logger.i("BDLocation_UploadScheduleController_pollupload resetPollUploadSchedule:" + r13.b());     // Catch: Exception -> L15
        r13.c(r12, LocationInfoConst.POLL_CERT);     // Catch: Exception -> L15
        if (r12 < 0) goto L13;
        r13.f9275d = r12;     // Catch: Exception -> L15
        goto L13
    }

    public static void c(LocInfoRspData r8, BDLocation r10, LocationOption r11) {
        if (r11 == null) goto L4;
        LocationTraceLogger r12 = r11.getLocationTraceLogger();
    L5:
        int r13 = 0;
        if (BDLocationConfig.enableStationaryScenePolicy() == true) goto L10;
        int r14 = 0;
    L8:
        LocationMonitor.locationTracePutCategoryData(r12, LocationMonitorConst.CHECK_STATIONARY_SCENE_POLICY_AFTER_LOCATION, r14);
        return;
    L10:
        if (r11 == null) goto L15;
        if (r8 == null) goto L15;
        StationarySceneCacheInfo r15 = r11.getStationarySceneCacheInfo();
        if (r15 == null) goto L15;
        r15.setLocationResult(r8.location);
        LocationCache.getInstance().setStationarySceneCacheInfo(r15);
    L15:
        if (r8 == null) goto L17;
        r13 = r8.movingSceneWithAoiStatus;
    L17:
        r14 = Integer.valueOf(LocationUtil.checkStationaryScenePolicyAfterLocation(r10, LocationCache.getInstance().fastGetLocationCacheUnsafe().getLatestLocation(), r13, r12));
        goto L8
    L4:
        r12 = null;
        goto L5
    }

    public static void d(LocInfoRspData r8) {
        if (r8 != null) goto L6;
        long r10 = BDLocationConfig.getDefaultGpsScanInterval();
    L4:
        BDLocationConfig.setGpsScanInterval(r10);
        return;
    L6:
        Logger.i("ResponseExecutor: setNextGpsScanInterval and interval:" + r8.nextGPSScanInterval);
        r10 = r8.nextGPSScanInterval;
        goto L4
    }

    public static void e(LocInfoRspData r8, BDLocation r10) {
        if (r8 != null) goto L19;
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
        if (r10 == null) goto L28;
        BDLocation r11 = new BDLocation(r10);     // Catch: Exception -> L16
        r11.setSubmitLogId(r8.submitLogId);     // Catch: Exception -> L16
        Iterator<LocationSubmitNotification> r12 = BDLocationConfig.getSubmitNotification().iterator();     // Catch: Exception -> L16
    L11:
        if (r12.hasNext() == false) goto L29;
        LocationSubmitNotification r13 = r12.next();     // Catch: Exception -> L16
        if (r13 == null) goto L11;
        r13.onSubmitListener(r11);     // Catch: Exception -> L16
        goto L11
    L29:
        return;
    L28:
        return;
    }
}
