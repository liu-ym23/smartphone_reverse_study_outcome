package com.bytedance.bdlocation.service;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.entity.LastLocationEntity;
import com.bytedance.bdlocation.entity.LocationExtraBean;
import com.bytedance.bdlocation.entity.LogIdCacheEntity;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationExtraDataTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.network.ServerApi;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.network.response.LocationResp;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.scan.bluetooth.BDBleInfo;
import com.bytedance.bdlocation.scan.bluetooth.BLECacheEntity;
import com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager;
import com.bytedance.bdlocation.scan.bluetooth.BluetoothUtil;
import com.bytedance.bdlocation.scan.gps.BDGpsInfo;
import com.bytedance.bdlocation.scan.gps.BDScanLocationInfo;
import com.bytedance.bdlocation.scan.gps.GpsInfoManager;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.bytedance.bdlocation.utils.CollectionUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationExtraDataServer {
    public static final String TAG = "BDLocationExtraDataServer:";
    private volatile List<BDBleInfo> mBleInfoList;
    private volatile int mBleInfoListStatus;
    private BluetoothInfoManager mBluetoothInfoManager;
    private volatile GpsInfoManager mGpsInfoManager;
    private volatile int mGpsInfoStatus;
    private volatile ArrayList<BDLocationExtraDataServer> mLocationExtraDataServerList;
    private volatile Handler mLocationHandler;
    private final AtomicInteger uploadGpsAndBleNum;

    private class BluetoothScanCallback implements BluetoothInfoManager.BluetoothScanCallback {
        private LocationExtraDataTraceLogger extraDataTraceLogger;
        private LocationOption mOption;
        final /* synthetic */ BDLocationExtraDataServer this$0;

        public BluetoothScanCallback(BDLocationExtraDataServer r1, LocationOption r2) {
            this.this$0 = r1;
            this.mOption = r2;
            if (r2 == null) goto L6;
            this.extraDataTraceLogger = r2.getLocationExtraDataTraceLogger();
            return;
        }

        @Override // com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager.BluetoothScanCallback
        public void onError() {
            Logger.i("BDLocationExtraDataServer:scanBlueToothData error");
            BDLocationExtraDataServer.access$402(this.this$0, 2);
            LocationMonitor.locationExtraDataTracePutCategoryData(this.extraDataTraceLogger, LocationExtraDataTraceLogger.SCAN_BLE_SUCCESS, false);
            LocationMonitor.locationExtraDataTraceLogEnd(this.extraDataTraceLogger, LocationExtraDataTraceLogger.BLE_SCAN_DURATION);
            BDLocationExtraDataServer.access$100(this.this$0, this.mOption);
        }

        @Override // com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager.BluetoothScanCallback
        public void onScan(BDBleInfo r1) {
        }

        @Override // com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager.BluetoothScanCallback
        public void onSuccess(List<BDBleInfo> r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            Logger.i("BDLocationExtraDataServer:scanBlueToothData success");
            boolean r1 = true;
            LocationMonitor.locationExtraDataTracePutCategoryData(this.extraDataTraceLogger, LocationExtraDataTraceLogger.SCAN_BLE_SUCCESS, true);
            LocationExtraDataTraceLogger r0 = this.extraDataTraceLogger;
            if (r6 != null) goto L5;
        L7:
            r1 = false;
        L8:
            LocationMonitor.locationExtraDataTracePutCategoryData(r0, LocationExtraDataTraceLogger.COLLECT_HAS_BLE_INFO, Boolean.valueOf(r1));
            LocationMonitor.locationExtraDataTraceLogEnd(this.extraDataTraceLogger, LocationExtraDataTraceLogger.BLE_SCAN_DURATION);
            List r7 = BDLocationExtraDataServer.access$200(this.this$0, r6);
            if (BDLocationConfig.isUploadBleImmediately() == false) goto L12;
            BDLocationExtraDataServer.access$300(this.this$0, r7, this.mOption);
            return;
        L12:
            BDLocationExtraDataServer.access$402(this.this$0, 2);
            BDLocationExtraDataServer.access$100(this.this$0, this.mOption);
            BDLocationExtraDataServer.access$500(this.this$0, r7, this.mOption.getStartLocationTime());
            return;
        L5:
            if (r6.isEmpty() == true) goto L7;
            goto L7
        }
    }

    public BDLocationExtraDataServer() {
        this.mGpsInfoStatus = 0;
        this.mBleInfoListStatus = 0;
        this.uploadGpsAndBleNum = new AtomicInteger(0);
        this.mBluetoothInfoManager = new BluetoothInfoManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ int access$002(BDLocationExtraDataServer r0, int r1) {
        r0.mGpsInfoStatus = r1;
        return r1;
    }

    static /* synthetic */ void access$100(BDLocationExtraDataServer r0, LocationOption r1) {
        r0.uploadGpsAndBleInfos(r1);
    }

    static /* synthetic */ List access$200(BDLocationExtraDataServer r2, List r3) {
        return r2.getNewBleInfos((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void access$300(BDLocationExtraDataServer r2, List r3, LocationOption r4) {
        r2.uploadBleCacheEntity((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    static /* synthetic */ int access$402(BDLocationExtraDataServer r0, int r1) {
        r0.mBleInfoListStatus = r1;
        return r1;
    }

    static /* synthetic */ void access$500(BDLocationExtraDataServer r2, List r3, long r4) {
        r2.setBleCacheEntity((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    static /* synthetic */ ArrayList access$600(BDLocationExtraDataServer r0) {
        return r0.mLocationExtraDataServerList;
    }

    static /* synthetic */ void access$700(BDLocationExtraDataServer r0, LocationUploadExtra r1, LocationOption r2, LocationExtraDataTraceLogger r3) {
        r0.upLoadServerApi(r1, r2, r3);
    }

    private void collectGpsInfo(final LocationOption r9) {
        this.mGpsInfoStatus = 0;
        this.mBleInfoListStatus = 0;
        this.mBleInfoList = null;
        if (r9 != null) goto L6;
        Logger.i("BDLocationExtraDataServer:collectGpsInfo option is null");
        this.mGpsInfoStatus = 1;
        uploadGpsAndBleInfos(r9);
        return;
    L6:
        final LocationExtraDataTraceLogger r3 = r9.getLocationExtraDataTraceLogger();
        LocationMonitor.locationExtraDataTracePutCategoryData(r3, "upload_source", r9.getUploadSource());
        this.mGpsInfoManager = new GpsInfoManager();
        final long r4 = System.currentTimeMillis();
        this.mGpsInfoManager.startGpsCollect(new AnonymousClass1(this, r3, r4, r9), r9);
    }

    private void extraDataTraceLoggerAddLastLocationInfo(LocationExtraDataTraceLogger r27, LocationUploadExtra r28, LocationOption r29) {
        if (r27 == null) goto L35;
        if (r28 == null) goto L35;
        if (r29 == null) goto L35;
        BDGpsInfo r1 = r28.getGpsInfo(BDScanLocationInfo.TakeStrategy.lastResult);
        if (r1 != null) goto L10;
    L33:
        Logger.i("extraDataTraceLoggerAddLastLocationInfo extra.getGpsInfo() == null || option.getLightLocation() == null || option.getLastLocationEntity() == null || option.getLightLocationWifiGap() < 0");
        return;
    L10:
        if (r29.getLightLocation() == null) goto L33;
        if (r29.getLastLocationEntity() == null) goto L33;
        if (r29.getLightLocationWifiGap() < 0) goto L33;
        if ("gps".equals(r1.provider) == true) goto L20;
        Logger.i("extraDataTraceLoggerAddLastLocationInfo !LocationManager.GPS_PROVIDER.equals(extra.getGpsInfo().provider)");
        return;
    L20:
        LastLocationEntity r2 = r29.getLastLocationEntity();
        if (r2.coordinateSystemSuccess == true) goto L24;
        Logger.i("extraDataTraceLoggerAddLastLocationInfo!lastLocationEntity.coordinateSystemSuccess");
        return;
    L24:
        BDLocation r3 = r29.getLightLocation();
        long r4 = r2.gpsLocationDuration;
        long r6 = r2.networkLocationDuration;
        long r8 = r2.totalLocationDuration;
        long r10 = r29.getLightLocationWifiGap();
        long r12 = r2.gpsLocationGap;
        long r14 = r2.networkLocationGap;
        long r9 = r12 - r10;
        long r11 = r14 - r10;
        Location r13 = r2.gpsLocation;
        Location r5 = r2.networkLocation;
        float r7 = LocationUtil.calculateLineDistance(new BDPoint(r1.latitude, r1.longitude), new BDPoint(r3.getLatitude(), r3.getLongitude()));
        if (r13 == null) goto L27;
        float r15 = LocationUtil.calculateLineDistance(new BDPoint(r1.latitude, r1.longitude), new BDPoint(r13.getLatitude(), r13.getLongitude()));
        boolean r16 = true;
    L28:
        if (r5 == null) goto L30;
        float r17 = LocationUtil.calculateLineDistance(new BDPoint(r1.latitude, r1.longitude), new BDPoint(r5.getLatitude(), r5.getLongitude()));
        boolean r18 = true;
    L31:
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_GPS_LOCATION_DURATION, r4);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_NETWORK_LOCATION_DURATION, r6);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_TOTAL_LOCATION_DURATION, r8);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LIGHT_LOCATION_WIFI_GAP, r10);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_GPS_LOCATION_GAP, r12);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_NETWORK_LOCATION_GAP, r14);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_GPS_AND_LIGHT_LOCATION_GAP, r9);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_NETWORK_AND_LIGHT_LOCATION_GAP, r11);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_GPS_AND_LIGHT_LOCATION_DISTANCE_GAP, (long) ((r15 - r7) * 100.0f));
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_NETWORK_AND_LIGHT_LOCATION_DISTANCE_GAP, (long) ((r17 - r7) * 100.0f));
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LIGHT_LOCATION_DISTANCE, (long) (r7 * 100.0f));
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_GPS_DISTANCE, (long) (r15 * 100.0f));
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_NETWORK_DISTANCE, (long) (100.0f * r17));
        LocationMonitor.locationExtraDataTracePutCategoryData(r27, LocationExtraDataTraceLogger.HAS_LAST_GPS_LOCATION, Boolean.valueOf(r16));
        LocationMonitor.locationExtraDataTracePutCategoryData(r27, LocationExtraDataTraceLogger.HAS_LAST_NETWORK_LOCATION, Boolean.valueOf(r18));
        Logger.i("LOCATION_INFO", "lastGpsLocationDuration:" + r4 + ", lastNetworkLocationDuration:" + r6 + ", lastTotalLocationDuration:" + r8 + ", lightLocationWifiGap:" + r10 + ", lastGpsLocationGap:" + r12 + ", lastNetworkLocationGap:" + r14 + ", lastGpsAndLightLocationGap:" + r9 + ", lastNetworkAndLightLocationGap:" + r11 + ", lightLocationDistance:" + r7 + ", lastGpsDistance:" + r15 + ", lastNetworkDistance:" + r17 + ", hasLastGpsLocation:" + r16 + ", hasLastNetworkLocation:" + r18);
        return;
    L30:
        r18 = false;
        r17 = -1.0f;
        goto L31
    L27:
        r15 = -1.0f;
        r16 = false;
    L35:
        Logger.i("extraDataTraceLoggerAddLastLocationInfo extraDataTraceLogger == null || extra == null || option == null");
    }

    private List<BDBleInfo> getNewBleInfos(List<BDBleInfo> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
    L23:
        Logger.i("BDLocationExtraDataServer:getNewBleInfos bleInfos is null");
        return null;
    L5:
        if (r6.size() < 1) goto L23;
        List<String> r8 = BDLocationConfig.getDisableUuidList();
        if (r8 != null) goto L10;
    L21:
        Logger.i("BDLocationExtraDataServer:getNewBleInfos disableUuidList is null");
        return new ArrayList(r6);
    L10:
        if (r8.size() <= 0) goto L21;
        Logger.i("BDLocationExtraDataServer:getNewBleInfos disableUuidList is not null");
        ArrayList r1 = new ArrayList();
        long r2 = System.currentTimeMillis();
        Iterator r9 = r6.iterator();
    L13:
        if (r9.hasNext() == false) goto L20;
        BDBleInfo r4 = (BDBleInfo) ZeusTransformUtils.preCheckCast(r9.next(), BDBleInfo.class, "com.obric.memorydata.plugin");
        if (r4.isBeacon == false) goto L19;
        if (CollectionUtil.containsIgnoreCase(r8, r4.beaconUuid) == false) goto L19;
        Logger.i("BDLocationExtraDataServer:getNewBleInfos and ignore the beacon");
    L19:
        r1.add(r4);
        goto L13
    L20:
        Logger.i(TAG, "getNewBleInfos and filter beacon duration(ms) is " + (System.currentTimeMillis() - r2));
        return r1;
    }

    private void scanBlueToothData(long r10, long r12, LocationOption r14) {
        Logger.i("BDLocationExtraDataServer:scanBlueToothData");
        LocationExtraDataTraceLogger r0 = r14.getLocationExtraDataTraceLogger();
        int r1 = LocationUtil.getTargetSdkVersion();
        LocationMonitor.locationExtraDataTracePutCategoryData(r0, "target_sdk_version", Integer.valueOf(r1));
        LocationMonitor.locationExtraDataTracePutCategoryData(r0, LocationExtraDataTraceLogger.SDK_INT, Integer.valueOf(Build.VERSION.SDK_INT));
        if (r1 >= 31) goto L5;
    L10:
        Logger.i(BluetoothUtil.BLE_SCAN_TRACE, "scanBlueToothData run:");
        LocationMonitor.locationExtraDataTraceLogBegin(r0, LocationExtraDataTraceLogger.BLE_SCAN_DURATION);
        this.mBluetoothInfoManager.startScan(new BluetoothScanCallback(this, r14), r10, r12, r14.getBpeaCert());
        return;
    L5:
        if (Build.VERSION.SDK_INT < 31) goto L10;
        if (PermissionManager.hasBluetoothPermissions((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L10;
        Logger.i("BDLocationExtraDataServer: scanBlueToothData and has no permission");
        this.mBleInfoListStatus = 1;
        uploadGpsAndBleInfos(r14);
    }

    private void setBleCacheEntity(List<BDBleInfo> r3, long r4) {
        List<BDBleInfo> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.size() < 1) goto L13;
        Logger.i("BDLocationExtraDataServer:setBleCacheEntity size:" + r2.size());
        Collections.sort(r2);
        if (r2.size() <= BDLocationConfig.getUploadBleNum()) goto L10;
        r2 = r2.subList(0, BDLocationConfig.getUploadBleNum());
    L10:
        BLECacheEntity r5 = new BLECacheEntity();
        r5.setBleInfoList(r2);
        r5.setTimeStamp(r4);
        Logger.i("BDLocationExtraDataServer:setBleCacheEntity size:" + r2.size() + "--startLocationTime：" + r4);
        BDLocationConfig.setBleCacheEntity(r5);
        return;
    }

    private void setExtraData(LocationOption r4) {
        Logger.i("BDLocationExtraDataServer:setExtraData startLocationTime:" + r4.getStartLocationTime());
        LocationExtraBean r0 = new LocationExtraBean();
        r0.setBleInfoList(getBleEntryList());
        if (BDLocationConfig.getLogIdCacheEntity() == null) goto L5;
        LogIdCacheEntity r3 = BDLocationConfig.getLogIdCacheEntity();
    L6:
        r0.setLogIdCacheEntity(r3);
        r4.setLocationExtraBean(r0);
        return;
    L5:
        r3 = new LogIdCacheEntity();
        goto L6
    }

    private void upLoadServerApi(LocationUploadExtra r3, LocationOption r4, LocationExtraDataTraceLogger r5) {
        LocationResp r0 = ServerApi.uploadGpsAndBleInfos(r3);
        if (BDLocationConfig.enableUploadLastLocationInfo() == false) goto L5;
        extraDataTraceLoggerAddLastLocationInfo(r5, r3, r4);
    L5:
        LocationMonitor.locationExtraDataTraceLogEnd(r5, LocationExtraDataTraceLogger.COLLECT_EXTRA_DATA_DURATION);
        if (r0 != null) goto L8;
    L10:
        StringBuilder r6 = new StringBuilder().append("server error:");
        String r7 = "";
        if (r0 != null) goto L13;
        String r1 = "";
    L14:
        String r8 = r6.append(r1).toString();
        if (r0 == null) goto L18;
        r7 = r0.resultCode + "";
    L18:
        LocationMonitor.locationExtraDataTraceLogErrorReport(r4, new BDLocationException(r8, LocationInfoConst.BDLOCATION, r7));
        return;
    L13:
        r1 = r0.resultMsg;
        goto L14
    L8:
        if (r0.resultCode != 0) goto L10;
        LocationMonitor.locationExtraDataTraceLogSuccessReport(r4);
    }

    private void uploadBleCacheEntity(List<BDBleInfo> r4, LocationOption r5) {
        List<BDBleInfo> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L8;
        String r7 = "BDLocationExtraDataServer:uploadBleCacheEntity option is null";
    L5:
        Logger.i(r7);
        this.mBleInfoListStatus = 2;
    L6:
        uploadGpsAndBleInfos(r5);
        return;
    L8:
        if (r6 != null) goto L10;
    L16:
        r7 = "BDLocationExtraDataServer:uploadBleCacheEntity bleInfos is null";
        goto L5
    L10:
        if (r6.size() < 1) goto L16;
        Logger.i("BDLocationExtraDataServer:setBleCacheEntity size:" + r6.size());
        Collections.sort(r6);
        if (r6.size() <= BDLocationConfig.getUploadBleNum()) goto L15;
        r6 = r6.subList(0, BDLocationConfig.getUploadBleNum());
    L15:
        this.mBleInfoListStatus = 3;
        this.mBleInfoList = r6;
        goto L6
    }

    private void uploadGpsAndBleInfos(LocationOption r2) {
        uploadGpsAndBleInfosAndRemove(r2);
        if (this.mLocationHandler == null) goto L6;
        this.mLocationHandler.post(new AnonymousClass2(this));
        return;
    }

    private void uploadGpsAndBleInfos(final LocationUploadExtra r3, final LocationOption r4, final LocationExtraDataTraceLogger r5) {
        if (LocationUtil.isMainThread() == false) goto L5;
        AppExecutors.getInstance().networkIO().execute(new AnonymousClass3(this, r3, r4, r5));
        return;
    L5:
        upLoadServerApi(r3, r4, r5);
    }

    private void uploadGpsAndBleInfosAndRemove(LocationOption r13) {
        Logger.i("BDLocationExtraDataServer: uploadGpsAndBleInfos and mGpsInfoStatus:" + this.mGpsInfoStatus + ", mBleInfoListStatus:" + this.mBleInfoListStatus);
        if (BDLocationConfig.isEnableGpsScan() == false) goto L7;
        if (this.mGpsInfoStatus != 0) goto L7;
        return;
    L7:
        if (this.mBleInfoListStatus == 0) goto L105;
        StringBuilder r0 = new StringBuilder().append("BDLocationExtraDataServer: uploadGpsAndBleInfos and gpsinfo:");
        if (this.mGpsInfoStatus == 3) goto L11;
        boolean r1 = true;
    L12:
        StringBuilder r2 = r0.append(r1).append(", bleinfos:");
        if (this.mBleInfoList == null) goto L15;
        boolean r3 = true;
    L16:
        Logger.i(r2.append(r3).toString());
        LocationExtraDataTraceLogger r4 = r13.getLocationExtraDataTraceLogger();
        LocationMonitor.locationExtraDataTracePutCategoryData(r4, LocationExtraDataTraceLogger.UPLOAD_GPS_AND_BLE_NUM, Integer.valueOf(this.uploadGpsAndBleNum.incrementAndGet()));
        LocationMonitor.locationExtraDataTracePutCategoryData(r4, LocationExtraDataTraceLogger.GPS_INFO_STATUS, Integer.valueOf(this.mGpsInfoStatus));
        LocationMonitor.locationExtraDataTracePutCategoryData(r4, LocationExtraDataTraceLogger.BLE_INFO_LIST_STATUS, Integer.valueOf(this.mBleInfoListStatus));
        if (this.mGpsInfoStatus != 3) goto L19;
    L22:
        LocationUploadExtra r5 = new LocationUploadExtra();
        r5.locationOption = r13;
        LogIdCacheEntity r6 = null;
        if (BDLocationConfig.enableCheckLastLogId() == false) goto L26;
        r6 = BDLocationConfig.getLogIdCacheEntity();
    L33:
        Logger.i("BDLocationExtraDataServer: enableCheckLastLogId:" + BDLocationConfig.enableCheckLastLogId());
        if (r6 != null) goto L36;
        boolean r7 = true;
    L37:
        LocationMonitor.locationExtraDataTracePutCategoryData(r4, LocationExtraDataTraceLogger.LOG_ID_CACHE_ENTITY_IS_NULL, Boolean.valueOf(r7));
        if (r6 != null) goto L40;
    L42:
        boolean r8 = false;
    L43:
        LocationMonitor.locationExtraDataTracePutCategoryData(r4, LocationExtraDataTraceLogger.LOG_ID_CACHE_ENTITY_TIME_CHECK, Boolean.valueOf(r8));
        LocationMonitor.locationExtraDataTracePutCategoryData(r4, LocationExtraDataTraceLogger.ENABLE_CHECK_LAST_LOG_ID, Boolean.valueOf(BDLocationConfig.enableCheckLastLogId()));
        LocationMonitor.locationExtraDataTracePutCategoryData(r4, LocationExtraDataTraceLogger.ENABLE_CHECK_UPLOAD_COMPLIANCE, Boolean.valueOf(BDLocationConfig.enableCheckUploadCompliance()));
        if (r6 != null) goto L46;
        long r9 = 0;
    L47:
        LocationMonitor.locationExtraDataTracePutExtraData(r4, LocationExtraDataTraceLogger.LOCATION_LOG_ID_CACHE_TIME, Long.valueOf(r9));
        LocationMonitor.locationExtraDataTracePutExtraData(r4, LocationExtraDataTraceLogger.START_LOCATION_TIME, Long.valueOf(r13.getStartLocationTime()));
        if (r6 != null) goto L50;
        String r10 = "";
    L51:
        LocationMonitor.locationExtraDataTracePutExtraData(r4, LocationExtraDataTraceLogger.LOCATION_LOG_ID, r10);
        StringBuilder r11 = new StringBuilder().append("BDLocationExtraDataServer: gpsCacheEntity:");
        if (r6 != null) goto L55;
        Object r12 = "null";
    L59:
        Logger.i(r11.append(r12).toString());
        if (BDLocationConfig.enableUploadLastLogId() == true) goto L62;
    L70:
        Logger.i("BDLocationExtraDataServer: uploadGpsAndBleInfos and gpsCacheEntity != null");
        if (BDLocationConfig.enableUploadLastLogId() == false) goto L73;
        r5.setLogIdCache(r6);
    L73:
        r5.setLocationExtraDataServer(this);
        if (r5.getGpsInfo(BDScanLocationInfo.TakeStrategy.firstResult) == null) goto L76;
        boolean r14 = true;
    L77:
        LocationMonitor.locationExtraDataTracePutCategoryData(r4, LocationExtraDataTraceLogger.UPLOAD_HAS_GPS_INFO, Boolean.valueOf(r14));
        if (r5.getSysLocation() == null) goto L80;
        boolean r15 = true;
    L81:
        LocationMonitor.locationExtraDataTracePutCategoryData(r4, LocationExtraDataTraceLogger.UPLOAD_HAS_SYS_LOCATION_INFO, Boolean.valueOf(r15));
        if (r5.getAMapLocation() == null) goto L84;
        boolean r16 = true;
    L85:
        LocationMonitor.locationExtraDataTracePutCategoryData(r4, LocationExtraDataTraceLogger.UPLOAD_HAS_AMAP_LOCATION_INFO, Boolean.valueOf(r16));
        r5.setLocateId(r13.getLocateId());
        if (this.mBleInfoList != null) goto L88;
    L90:
        boolean r17 = false;
    L91:
        LocationMonitor.locationExtraDataTracePutCategoryData(r4, LocationExtraDataTraceLogger.UPLOAD_HAS_BLE_INFO_LIST, Boolean.valueOf(r17));
        r5.setBleList(this.mBleInfoList);
        if (this.mGpsInfoStatus != 0) goto L94;
    L100:
        String r18 = "ble";
    L101:
        r5.setGpsAndBleMark(r18);
        r5.setTriggerType(r13.getTriggerType());
        r5.setUploadSource(r13.getUploadSource());
        LocationMonitor.locationExtraDataTracePutCategoryData(r4, LocationExtraDataTraceLogger.EXTRA_DATA_MARK, r5.getGpsAndBleMark());
        uploadGpsAndBleInfos(r5, r13, r4);
    L102:
        this.mGpsInfoStatus = 0;
        this.mBleInfoListStatus = 0;
        return;
    L94:
        if (this.mGpsInfoStatus == 1) goto L100;
        if (this.mBleInfoListStatus == 3) goto L99;
        r18 = "gps";
        goto L101
    L99:
        r18 = "ble_gps";
        goto L101
    L88:
        if (this.mBleInfoList.isEmpty() == true) goto L90;
        r17 = true;
        goto L91
    L84:
        r16 = false;
        goto L85
    L80:
        r15 = false;
        goto L81
    L76:
        r14 = false;
        goto L77
    L62:
        if (BDLocationConfig.enableCheckLastLogId() == false) goto L70;
        if (r6 != null) goto L65;
    L69:
        Logger.i("BDLocationExtraDataServer: uploadGpsAndBleInfos and gpsCacheEntity is null");
        LocationMonitor.locationExtraDataTraceLogEnd(r4, LocationExtraDataTraceLogger.COLLECT_EXTRA_DATA_DURATION);
        LocationMonitor.locationExtraDataTraceLogErrorReport(r13, new BDLocationException("logId Cache Entity Error", LocationInfoConst.BDLOCATION, BDLocationException.ERROR_LOG_ID_CACHE_ENTITY));
        goto L102
    L65:
        if (r6.timestamp != r13.getStartLocationTime()) goto L69;
        if (TextUtils.isEmpty(r6.logId) == true) goto L69;
    L55:
        if (r6.timestamp != r13.getStartLocationTime()) goto L57;
        boolean r19 = true;
    L58:
        r12 = Boolean.valueOf(r19);
        goto L59
    L57:
        r19 = false;
        goto L58
    L50:
        r10 = r6.logId;
        goto L51
    L46:
        r9 = r6.timestamp;
        goto L47
    L40:
        if (r6.timestamp != r13.getStartLocationTime()) goto L42;
        r8 = true;
        goto L43
    L36:
        r7 = false;
        goto L37
    L26:
        if (r13.getLocationExtraBean() == null) goto L28;
        r6 = r13.getLocationExtraBean().getLogIdCacheEntity();
    L28:
        StringBuilder r20 = new StringBuilder().append("uploadGpsAndBleInfosAndRemove ");
        if (r6 != null) goto L31;
        String r21 = "logIdCacheEntity = null";
    L32:
        Logger.i(r20.append(r21).toString());
        goto L33
    L31:
        r21 = "logIdCacheEntity.logId: " + r6.logId + ", logIdCacheEntity.timestamp: " + r6.timestamp;
        goto L32
    L19:
        if (this.mBleInfoList != null) goto L22;
        Logger.i("BDLocationExtraDataServer: extra data scan failed");
        this.mGpsInfoStatus = 0;
        this.mBleInfoListStatus = 0;
        LocationMonitor.locationExtraDataTraceLogErrorReport(r13, new BDLocationException("extra data scan failed", LocationInfoConst.BDLOCATION, BDLocationException.ERROR_EXTRA_DATA_SCAN_FAILED));
        return;
    L15:
        r3 = false;
        goto L16
    L11:
        r1 = false;
        goto L12
    }

    public void clearExtraData() {
        Logger.i("BDLocationExtraDataServer:clearExtraData");
        BDLocationConfig.setBleCacheEntity(null);
        BDLocationConfig.setLogIdCacheEntity(null);
    }

    public List<BDBleInfo> getBleEntryList() {
        LogIdCacheEntity r6 = BDLocationConfig.getLogIdCacheEntity();
        if (r6 != null) goto L7;
        String r7 = "BDLocationExtraDataServer:getLogIdCache cache is null";
    L5:
        Logger.i(r7);
        return null;
    L7:
        BLECacheEntity r1 = BDLocationConfig.getBleCacheEntity();
        if (r1 != null) goto L10;
    L15:
        r7 = "BDLocationExtraDataServer:getBleEntryList error";
        goto L5
    L10:
        if (r1.getTimeStamp() != r6.timestamp) goto L15;
        if (TextUtils.isEmpty(r6.logId) == true) goto L15;
        Logger.i("BDLocationExtraDataServer:getBleEntryList success");
        return r1.getBleInfoList();
    }

    public GpsInfoManager getGpsInfoManager() {
        return this.mGpsInfoManager;
    }

    public void startCollectBluetoothData(LocationOption r9) {
        this.mBleInfoListStatus = 0;
        this.mBleInfoList = null;
        if (r9 != null) goto L5;
    L30:
        Logger.i("BDLocationExtraDataServer:startCollectBluetoothData option is null");
        this.mBleInfoListStatus = 1;
        uploadGpsAndBleInfos(r9);
        return;
    L5:
        if (r9.isOnceLocation() == false) goto L30;
        if (r9.scanBle() == false) goto L30;
        LocationExtraDataTraceLogger r1 = r9.getLocationExtraDataTraceLogger();
        LocationMonitor.locationExtraDataTracePutCategoryData(r1, LocationExtraDataTraceLogger.ENABLE_SCAN_BLE, Boolean.valueOf(BDLocationConfig.enableScanBle()));
        LocationMonitor.locationExtraDataTracePutCategoryData(r1, LocationExtraDataTraceLogger.FIRST_REQUEST_LOCATION, Boolean.valueOf(BDLocationConfig.firstRequestLocation()));
        LocationMonitor.locationExtraDataTracePutCategoryData(r1, "enable_collect_ble_in_battery_saving_mode", Boolean.valueOf(BDLocationConfig.enableCollectBleInBatterySavingMode()));
        if (BDLocationConfig.enableCollectBleInBatterySavingMode() == true) goto L16;
        if (r9.getMode() != 0) goto L16;
        Logger.i("BDLocationExtraDataServer:startCollectBluetoothData Battery_Saving mode");
        this.mBleInfoListStatus = 1;
        uploadGpsAndBleInfos(r9);
        return;
    L16:
        if (BDLocationConfig.isUploadBleImmediately() == true) goto L22;
        if (BDLocationConfig.firstRequestLocation() == false) goto L22;
        Logger.i("BDLocationExtraDataServer:startCollectBluetoothData firstRequestLocation");
        this.mBleInfoListStatus = 1;
        uploadGpsAndBleInfos(r9);
        return;
    L22:
        if (BDLocationConfig.enableScanBle() == true) goto L24;
    L28:
        Logger.i("BDLocationExtraDataServer:startCollectBluetoothData not enable scan ble");
        this.mBleInfoListStatus = 1;
        uploadGpsAndBleInfos(r9);
        return;
    L24:
        if (BDLocationConfig.getScanBleInterval() <= 0) goto L28;
        scanBlueToothData(0, BDLocationConfig.getScanBleInterval(), r9);
    }

    public void startCollectGpsData(LocationOption r3, Handler r4, ArrayList<BDLocationExtraDataServer> r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isOnceLocation() == false) goto L9;
        this.mLocationHandler = r4;
        this.mLocationExtraDataServerList = r5;
        long r6 = System.currentTimeMillis();
        r3.setStartLocationTime(r6);
        Logger.i("BDLocationExtraDataServer:startCollectGpsData");
        setExtraData(r3);
        clearExtraData();
        collectGpsInfo(r3);
        Logger.i("location-trace-core startCollectGpsData duration:" + (System.currentTimeMillis() - r6));
        return;
    }

    public void stopCollectExtraData() {
        BluetoothInfoManager r0 = this.mBluetoothInfoManager;
        if (r0 == null) goto L6;
        r0.stopScan();
    L6:
        if (this.mGpsInfoManager == null) goto L9;
        this.mGpsInfoManager.stopGpsCollect();
        return;
    }
}
