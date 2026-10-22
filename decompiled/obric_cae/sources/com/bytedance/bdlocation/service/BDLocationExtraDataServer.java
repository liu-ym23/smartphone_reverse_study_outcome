package com.bytedance.bdlocation.service;

import android.aimedia.a;
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
import com.obric.cae.cloud.CloudServiceConstants;
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

    public class BluetoothScanCallback implements BluetoothInfoManager.BluetoothScanCallback {
        private LocationExtraDataTraceLogger extraDataTraceLogger;
        private LocationOption mOption;
        final /* synthetic */ BDLocationExtraDataServer this$0;

        public BluetoothScanCallback(BDLocationExtraDataServer r8, LocationOption r10) {
            this.this$0 = r8;
            this.mOption = r10;
            if (r10 == null) goto L6;
            this.extraDataTraceLogger = r10.getLocationExtraDataTraceLogger();
            return;
        }

        @Override // com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager.BluetoothScanCallback
        public void onError() {
            Logger.i("BDLocationExtraDataServer:scanBlueToothData error");
            BDLocationExtraDataServer.access$402(this.this$0, 2);
            LocationMonitor.locationExtraDataTracePutCategoryData(this.extraDataTraceLogger, LocationExtraDataTraceLogger.SCAN_BLE_SUCCESS, Boolean.FALSE);
            LocationMonitor.locationExtraDataTraceLogEnd(this.extraDataTraceLogger, LocationExtraDataTraceLogger.BLE_SCAN_DURATION);
            BDLocationExtraDataServer.access$100(this.this$0, this.mOption);
        }

        @Override // com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager.BluetoothScanCallback
        public void onScan(BDBleInfo r8) {
        }

        @Override // com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager.BluetoothScanCallback
        public void onSuccess(List<BDBleInfo> r8) {
            Logger.i("BDLocationExtraDataServer:scanBlueToothData success");
            LocationMonitor.locationExtraDataTracePutCategoryData(this.extraDataTraceLogger, LocationExtraDataTraceLogger.SCAN_BLE_SUCCESS, Boolean.TRUE);
            LocationExtraDataTraceLogger r10 = this.extraDataTraceLogger;
            if (r8 != null) goto L5;
        L7:
            boolean r11 = false;
        L8:
            LocationMonitor.locationExtraDataTracePutCategoryData(r10, LocationExtraDataTraceLogger.COLLECT_HAS_BLE_INFO, Boolean.valueOf(r11));
            LocationMonitor.locationExtraDataTraceLogEnd(this.extraDataTraceLogger, LocationExtraDataTraceLogger.BLE_SCAN_DURATION);
            List r12 = BDLocationExtraDataServer.access$200(this.this$0, r8);
            if (BDLocationConfig.isUploadBleImmediately() == false) goto L12;
            BDLocationExtraDataServer.access$300(this.this$0, r12, this.mOption);
            return;
        L12:
            BDLocationExtraDataServer.access$402(this.this$0, 2);
            BDLocationExtraDataServer.access$100(this.this$0, this.mOption);
            BDLocationExtraDataServer.access$500(this.this$0, r12, this.mOption.getStartLocationTime());
            return;
        L5:
            if (r8.isEmpty() == true) goto L7;
            r11 = true;
            goto L8
        }
    }

    public BDLocationExtraDataServer() {
        this.mGpsInfoStatus = 0;
        this.mBleInfoListStatus = 0;
        this.uploadGpsAndBleNum = new AtomicInteger(0);
        this.mBluetoothInfoManager = new BluetoothInfoManager(BDLocationConfig.getContext());
    }

    public static /* synthetic */ int access$002(BDLocationExtraDataServer r8, int r10) {
        r8.mGpsInfoStatus = r10;
        return r10;
    }

    public static /* synthetic */ void access$100(BDLocationExtraDataServer r8, LocationOption r10) {
        r8.uploadGpsAndBleInfos(r10);
    }

    public static /* synthetic */ List access$200(BDLocationExtraDataServer r8, List r10) {
        return r8.getNewBleInfos(r10);
    }

    public static /* synthetic */ void access$300(BDLocationExtraDataServer r8, List r10, LocationOption r11) {
        r8.uploadBleCacheEntity(r10, r11);
    }

    public static /* synthetic */ int access$402(BDLocationExtraDataServer r8, int r10) {
        r8.mBleInfoListStatus = r10;
        return r10;
    }

    public static /* synthetic */ void access$500(BDLocationExtraDataServer r8, List r10, long r11) {
        r8.setBleCacheEntity(r10, r11);
    }

    public static /* synthetic */ ArrayList access$600(BDLocationExtraDataServer r8) {
        return r8.mLocationExtraDataServerList;
    }

    public static /* synthetic */ void access$700(BDLocationExtraDataServer r8, LocationUploadExtra r10, LocationOption r11, LocationExtraDataTraceLogger r12) {
        r8.upLoadServerApi(r10, r11, r12);
    }

    private void collectGpsInfo(final LocationOption r10) {
        this.mGpsInfoStatus = 0;
        this.mBleInfoListStatus = 0;
        this.mBleInfoList = null;
        if (r10 != null) goto L6;
        Logger.i("BDLocationExtraDataServer:collectGpsInfo option is null");
        this.mGpsInfoStatus = 1;
        uploadGpsAndBleInfos(r10);
        return;
    L6:
        final LocationExtraDataTraceLogger r8 = r10.getLocationExtraDataTraceLogger();
        LocationMonitor.locationExtraDataTracePutCategoryData(r8, "upload_source", r10.getUploadSource());
        this.mGpsInfoManager = new GpsInfoManager();
        final long r11 = System.currentTimeMillis();
        this.mGpsInfoManager.startGpsCollect(new AnonymousClass1(this, r8, r11, r10), r10);
    }

    private void extraDataTraceLoggerAddLastLocationInfo(LocationExtraDataTraceLogger r27, LocationUploadExtra r28, LocationOption r29) {
        if (r27 == null) goto L35;
        if (r28 == null) goto L35;
        if (r29 == null) goto L35;
        BDGpsInfo r8 = r28.getGpsInfo(BDScanLocationInfo.TakeStrategy.lastResult);
        if (r8 != null) goto L10;
    L33:
        Logger.i("extraDataTraceLoggerAddLastLocationInfo extra.getGpsInfo() == null || option.getLightLocation() == null || option.getLastLocationEntity() == null || option.getLightLocationWifiGap() < 0");
        return;
    L10:
        if (r29.getLightLocation() == null) goto L33;
        if (r29.getLastLocationEntity() == null) goto L33;
        if (r29.getLightLocationWifiGap() < 0) goto L33;
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equals(r8.provider) == true) goto L20;
        Logger.i("extraDataTraceLoggerAddLastLocationInfo !LocationManager.GPS_PROVIDER.equals(extra.getGpsInfo().provider)");
        return;
    L20:
        LastLocationEntity r10 = r29.getLastLocationEntity();
        if (r10.coordinateSystemSuccess == true) goto L24;
        Logger.i("extraDataTraceLoggerAddLastLocationInfo!lastLocationEntity.coordinateSystemSuccess");
        return;
    L24:
        BDLocation r11 = r29.getLightLocation();
        long r12 = r10.gpsLocationDuration;
        long r13 = r10.networkLocationDuration;
        long r14 = r10.totalLocationDuration;
        long r15 = r29.getLightLocationWifiGap();
        long r16 = r10.gpsLocationGap;
        long r17 = r10.networkLocationGap;
        long r18 = r16 - r15;
        long r19 = r17 - r15;
        Location r20 = r10.gpsLocation;
        Location r21 = r10.networkLocation;
        float r22 = LocationUtil.calculateLineDistance(new BDPoint(r8.latitude, r8.longitude), new BDPoint(r11.getLatitude(), r11.getLongitude()));
        if (r20 == null) goto L27;
        float r23 = LocationUtil.calculateLineDistance(new BDPoint(r8.latitude, r8.longitude), new BDPoint(r20.getLatitude(), r20.getLongitude()));
        boolean r24 = true;
    L28:
        if (r21 == null) goto L30;
        float r110 = LocationUtil.calculateLineDistance(new BDPoint(r8.latitude, r8.longitude), new BDPoint(r21.getLatitude(), r21.getLongitude()));
        boolean r25 = true;
    L31:
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_GPS_LOCATION_DURATION, r12);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_NETWORK_LOCATION_DURATION, r13);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_TOTAL_LOCATION_DURATION, r14);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LIGHT_LOCATION_WIFI_GAP, r15);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_GPS_LOCATION_GAP, r16);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_NETWORK_LOCATION_GAP, r17);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_GPS_AND_LIGHT_LOCATION_GAP, r18);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_NETWORK_AND_LIGHT_LOCATION_GAP, r19);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_GPS_AND_LIGHT_LOCATION_DISTANCE_GAP, (long) ((r23 - r22) * 100.0f));
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_NETWORK_AND_LIGHT_LOCATION_DISTANCE_GAP, (long) ((r110 - r22) * 100.0f));
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LIGHT_LOCATION_DISTANCE, (long) (r22 * 100.0f));
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_GPS_DISTANCE, (long) (r23 * 100.0f));
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_NETWORK_DISTANCE, (long) (100.0f * r110));
        LocationMonitor.locationExtraDataTracePutCategoryData(r27, LocationExtraDataTraceLogger.HAS_LAST_GPS_LOCATION, Boolean.valueOf(r24));
        LocationMonitor.locationExtraDataTracePutCategoryData(r27, LocationExtraDataTraceLogger.HAS_LAST_NETWORK_LOCATION, Boolean.valueOf(r25));
        Logger.i("LOCATION_INFO", "lastGpsLocationDuration:" + r12 + ", lastNetworkLocationDuration:" + r13 + ", lastTotalLocationDuration:" + r14 + ", lightLocationWifiGap:" + r15 + ", lastGpsLocationGap:" + r16 + ", lastNetworkLocationGap:" + r17 + ", lastGpsAndLightLocationGap:" + r18 + ", lastNetworkAndLightLocationGap:" + r19 + ", lightLocationDistance:" + r22 + ", lastGpsDistance:" + r23 + ", lastNetworkDistance:" + r110 + ", hasLastGpsLocation:" + r24 + ", hasLastNetworkLocation:" + r25);
        return;
    L30:
        r25 = false;
        r110 = -1.0f;
        goto L31
    L27:
        r23 = -1.0f;
        r24 = false;
    L35:
        Logger.i("extraDataTraceLoggerAddLastLocationInfo extraDataTraceLogger == null || extra == null || option == null");
    }

    private List<BDBleInfo> getNewBleInfos(List<BDBleInfo> r8) {
        if (r8 != null) goto L4;
    L22:
        Logger.i("BDLocationExtraDataServer:getNewBleInfos bleInfos is null");
        return null;
    L4:
        if (r8.size() < 1) goto L22;
        List<String> r10 = BDLocationConfig.getDisableUuidList();
        if (r10 != null) goto L9;
    L20:
        Logger.i("BDLocationExtraDataServer:getNewBleInfos disableUuidList is null");
        return new ArrayList(r8);
    L9:
        if (r10.size() <= 0) goto L20;
        Logger.i("BDLocationExtraDataServer:getNewBleInfos disableUuidList is not null");
        ArrayList r11 = new ArrayList();
        long r12 = System.currentTimeMillis();
        Iterator<BDBleInfo> r13 = r8.iterator();
    L12:
        if (r13.hasNext() == false) goto L19;
        BDBleInfo r14 = r13.next();
        if (r14.isBeacon == false) goto L18;
        if (CollectionUtil.containsIgnoreCase(r10, r14.beaconUuid) == false) goto L18;
        Logger.i("BDLocationExtraDataServer:getNewBleInfos and ignore the beacon");
    L18:
        r11.add(r14);
        goto L12
    L19:
        Logger.i(TAG, "getNewBleInfos and filter beacon duration(ms) is " + (System.currentTimeMillis() - r12));
        return r11;
    }

    private void scanBlueToothData(long r10, long r12, LocationOption r14) {
        Logger.i("BDLocationExtraDataServer:scanBlueToothData");
        LocationExtraDataTraceLogger r8 = r14.getLocationExtraDataTraceLogger();
        int r11 = LocationUtil.getTargetSdkVersion();
        LocationMonitor.locationExtraDataTracePutCategoryData(r8, "target_sdk_version", Integer.valueOf(r11));
        LocationMonitor.locationExtraDataTracePutCategoryData(r8, LocationExtraDataTraceLogger.SDK_INT, Integer.valueOf(Build.VERSION.SDK_INT));
        if (r11 >= 31) goto L5;
    L8:
        Logger.i(BluetoothUtil.BLE_SCAN_TRACE, "scanBlueToothData run:");
        LocationMonitor.locationExtraDataTraceLogBegin(r8, LocationExtraDataTraceLogger.BLE_SCAN_DURATION);
        this.mBluetoothInfoManager.startScan(new BluetoothScanCallback(this, r14), r10, r12, r14.getBpeaCert());
        return;
    L5:
        if (PermissionManager.hasBluetoothPermissions(BDLocationConfig.getContext()) == true) goto L8;
        Logger.i("BDLocationExtraDataServer: scanBlueToothData and has no permission");
        this.mBleInfoListStatus = 1;
        uploadGpsAndBleInfos(r14);
    }

    private void setBleCacheEntity(List<BDBleInfo> r8, long r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.size() < 1) goto L12;
        Logger.i("BDLocationExtraDataServer:setBleCacheEntity size:" + r8.size());
        Collections.sort(r8);
        if (r8.size() <= BDLocationConfig.getUploadBleNum()) goto L9;
        r8 = r8.subList(0, BDLocationConfig.getUploadBleNum());
    L9:
        BLECacheEntity r11 = new BLECacheEntity();
        r11.setBleInfoList(r8);
        r11.setTimeStamp(r10);
        Logger.i("BDLocationExtraDataServer:setBleCacheEntity size:" + r8.size() + "--startLocationTime：" + r10);
        BDLocationConfig.setBleCacheEntity(r11);
        return;
    }

    private void setExtraData(LocationOption r8) {
        Logger.i("BDLocationExtraDataServer:setExtraData startLocationTime:" + r8.getStartLocationTime());
        LocationExtraBean r10 = new LocationExtraBean();
        r10.setBleInfoList(getBleEntryList());
        if (BDLocationConfig.getLogIdCacheEntity() == null) goto L5;
        LogIdCacheEntity r11 = BDLocationConfig.getLogIdCacheEntity();
    L6:
        r10.setLogIdCacheEntity(r11);
        r8.setLocationExtraBean(r10);
        return;
    L5:
        r11 = new LogIdCacheEntity();
        goto L6
    }

    private void upLoadServerApi(LocationUploadExtra r8, LocationOption r10, LocationExtraDataTraceLogger r11) {
        LocationResp r12 = ServerApi.uploadGpsAndBleInfos(r8);
        if (BDLocationConfig.enableUploadLastLocationInfo() == false) goto L5;
        extraDataTraceLoggerAddLastLocationInfo(r11, r8, r10);
    L5:
        LocationMonitor.locationExtraDataTraceLogEnd(r11, LocationExtraDataTraceLogger.COLLECT_EXTRA_DATA_DURATION);
        if (r12 != null) goto L8;
    L10:
        StringBuilder r13 = new StringBuilder("server error:");
        String r14 = "";
        if (r12 != null) goto L13;
        String r15 = "";
    L14:
        r13.append(r15);
        String r16 = r13.toString();
        if (r12 == null) goto L18;
        r14 = a.h(new StringBuilder(), r12.resultCode, "");
    L18:
        LocationMonitor.locationExtraDataTraceLogErrorReport(r10, new BDLocationException(r16, LocationInfoConst.BDLOCATION, r14));
        return;
    L13:
        r15 = r12.resultMsg;
        goto L14
    L8:
        if (r12.resultCode != 0) goto L10;
        LocationMonitor.locationExtraDataTraceLogSuccessReport(r10);
    }

    private void uploadBleCacheEntity(List<BDBleInfo> r8, LocationOption r10) {
        if (r10 != null) goto L8;
        String r11 = "BDLocationExtraDataServer:uploadBleCacheEntity option is null";
    L5:
        Logger.i(r11);
        this.mBleInfoListStatus = 2;
    L6:
        uploadGpsAndBleInfos(r10);
        return;
    L8:
        if (r8 != null) goto L10;
    L16:
        r11 = "BDLocationExtraDataServer:uploadBleCacheEntity bleInfos is null";
        goto L5
    L10:
        if (r8.size() < 1) goto L16;
        Logger.i("BDLocationExtraDataServer:setBleCacheEntity size:" + r8.size());
        Collections.sort(r8);
        if (r8.size() <= BDLocationConfig.getUploadBleNum()) goto L15;
        r8 = r8.subList(0, BDLocationConfig.getUploadBleNum());
    L15:
        this.mBleInfoListStatus = 3;
        this.mBleInfoList = r8;
        goto L6
    }

    private void uploadGpsAndBleInfos(LocationOption r8) {
        uploadGpsAndBleInfosAndRemove(r8);
        if (this.mLocationHandler == null) goto L6;
        this.mLocationHandler.post(new AnonymousClass2(this));
        return;
    }

    private void uploadGpsAndBleInfosAndRemove(LocationOption r13) {
        Logger.i("BDLocationExtraDataServer: uploadGpsAndBleInfos and mGpsInfoStatus:" + this.mGpsInfoStatus + ", mBleInfoListStatus:" + this.mBleInfoListStatus);
        if (BDLocationConfig.isEnableGpsScan() == false) goto L7;
        if (this.mGpsInfoStatus != 0) goto L7;
        return;
    L7:
        if (this.mBleInfoListStatus == 0) goto L106;
        StringBuilder r8 = new StringBuilder("BDLocationExtraDataServer: uploadGpsAndBleInfos and gpsinfo:");
        if (this.mGpsInfoStatus == 3) goto L11;
        boolean r10 = true;
    L12:
        r8.append(r10);
        r8.append(", bleinfos:");
        if (this.mBleInfoList == null) goto L15;
        boolean r11 = true;
    L16:
        r8.append(r11);
        Logger.i(r8.toString());
        LocationExtraDataTraceLogger r12 = r13.getLocationExtraDataTraceLogger();
        LocationMonitor.locationExtraDataTracePutCategoryData(r12, LocationExtraDataTraceLogger.UPLOAD_GPS_AND_BLE_NUM, Integer.valueOf(this.uploadGpsAndBleNum.incrementAndGet()));
        LocationMonitor.locationExtraDataTracePutCategoryData(r12, LocationExtraDataTraceLogger.GPS_INFO_STATUS, Integer.valueOf(this.mGpsInfoStatus));
        LocationMonitor.locationExtraDataTracePutCategoryData(r12, LocationExtraDataTraceLogger.BLE_INFO_LIST_STATUS, Integer.valueOf(this.mBleInfoListStatus));
        if (this.mGpsInfoStatus != 3) goto L19;
    L22:
        LocationUploadExtra r14 = new LocationUploadExtra();
        r14.locationOption = r13;
        if (BDLocationConfig.enableCheckLastLogId() == false) goto L26;
        LogIdCacheEntity r15 = BDLocationConfig.getLogIdCacheEntity();
    L34:
        Logger.i("BDLocationExtraDataServer: enableCheckLastLogId:" + BDLocationConfig.enableCheckLastLogId());
        if (r15 != null) goto L37;
        boolean r16 = true;
    L38:
        LocationMonitor.locationExtraDataTracePutCategoryData(r12, LocationExtraDataTraceLogger.LOG_ID_CACHE_ENTITY_IS_NULL, Boolean.valueOf(r16));
        if (r15 != null) goto L41;
    L43:
        boolean r17 = false;
    L44:
        LocationMonitor.locationExtraDataTracePutCategoryData(r12, LocationExtraDataTraceLogger.LOG_ID_CACHE_ENTITY_TIME_CHECK, Boolean.valueOf(r17));
        LocationMonitor.locationExtraDataTracePutCategoryData(r12, LocationExtraDataTraceLogger.ENABLE_CHECK_LAST_LOG_ID, Boolean.valueOf(BDLocationConfig.enableCheckLastLogId()));
        LocationMonitor.locationExtraDataTracePutCategoryData(r12, LocationExtraDataTraceLogger.ENABLE_CHECK_UPLOAD_COMPLIANCE, Boolean.valueOf(BDLocationConfig.enableCheckUploadCompliance()));
        if (r15 != null) goto L47;
        long r18 = 0;
    L48:
        LocationMonitor.locationExtraDataTracePutExtraData(r12, LocationExtraDataTraceLogger.LOCATION_LOG_ID_CACHE_TIME, Long.valueOf(r18));
        LocationMonitor.locationExtraDataTracePutExtraData(r12, LocationExtraDataTraceLogger.START_LOCATION_TIME, Long.valueOf(r13.getStartLocationTime()));
        if (r15 != null) goto L51;
        String r19 = "";
    L52:
        LocationMonitor.locationExtraDataTracePutExtraData(r12, LocationExtraDataTraceLogger.LOCATION_LOG_ID, r19);
        StringBuilder r20 = new StringBuilder("BDLocationExtraDataServer: gpsCacheEntity:");
        if (r15 != null) goto L56;
        Object r21 = "null";
    L60:
        r20.append(r21);
        Logger.i(r20.toString());
        if (BDLocationConfig.enableUploadLastLogId() == true) goto L63;
    L71:
        Logger.i("BDLocationExtraDataServer: uploadGpsAndBleInfos and gpsCacheEntity != null");
        if (BDLocationConfig.enableUploadLastLogId() == false) goto L74;
        r14.setLogIdCache(r15);
    L74:
        r14.setLocationExtraDataServer(this);
        if (r14.getGpsInfo(BDScanLocationInfo.TakeStrategy.firstResult) == null) goto L77;
        boolean r22 = true;
    L78:
        LocationMonitor.locationExtraDataTracePutCategoryData(r12, LocationExtraDataTraceLogger.UPLOAD_HAS_GPS_INFO, Boolean.valueOf(r22));
        if (r14.getSysLocation() == null) goto L81;
        boolean r23 = true;
    L82:
        LocationMonitor.locationExtraDataTracePutCategoryData(r12, LocationExtraDataTraceLogger.UPLOAD_HAS_SYS_LOCATION_INFO, Boolean.valueOf(r23));
        if (r14.getAMapLocation() == null) goto L85;
        boolean r24 = true;
    L86:
        LocationMonitor.locationExtraDataTracePutCategoryData(r12, LocationExtraDataTraceLogger.UPLOAD_HAS_AMAP_LOCATION_INFO, Boolean.valueOf(r24));
        r14.setLocateId(r13.getLocateId());
        if (this.mBleInfoList != null) goto L89;
    L91:
        boolean r25 = false;
    L92:
        LocationMonitor.locationExtraDataTracePutCategoryData(r12, LocationExtraDataTraceLogger.UPLOAD_HAS_BLE_INFO_LIST, Boolean.valueOf(r25));
        r14.setBleList(this.mBleInfoList);
        if (this.mGpsInfoStatus != 0) goto L95;
    L101:
        String r26 = CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_LE;
    L102:
        r14.setGpsAndBleMark(r26);
        r14.setTriggerType(r13.getTriggerType());
        r14.setUploadSource(r13.getUploadSource());
        LocationMonitor.locationExtraDataTracePutCategoryData(r12, LocationExtraDataTraceLogger.EXTRA_DATA_MARK, r14.getGpsAndBleMark());
        uploadGpsAndBleInfos(r14, r13, r12);
    L103:
        this.mGpsInfoStatus = 0;
        this.mBleInfoListStatus = 0;
        return;
    L95:
        if (this.mGpsInfoStatus == 1) goto L101;
        if (this.mBleInfoListStatus == 3) goto L100;
        r26 = CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS;
        goto L102
    L100:
        r26 = "ble_gps";
        goto L102
    L89:
        if (this.mBleInfoList.isEmpty() == true) goto L91;
        r25 = true;
        goto L92
    L85:
        r24 = false;
        goto L86
    L81:
        r23 = false;
        goto L82
    L77:
        r22 = false;
        goto L78
    L63:
        if (BDLocationConfig.enableCheckLastLogId() == false) goto L71;
        if (r15 != null) goto L66;
    L70:
        Logger.i("BDLocationExtraDataServer: uploadGpsAndBleInfos and gpsCacheEntity is null");
        LocationMonitor.locationExtraDataTraceLogEnd(r12, LocationExtraDataTraceLogger.COLLECT_EXTRA_DATA_DURATION);
        LocationMonitor.locationExtraDataTraceLogErrorReport(r13, new BDLocationException("logId Cache Entity Error", LocationInfoConst.BDLOCATION, BDLocationException.ERROR_LOG_ID_CACHE_ENTITY));
        goto L103
    L66:
        if (r15.timestamp != r13.getStartLocationTime()) goto L70;
        if (TextUtils.isEmpty(r15.logId) == true) goto L70;
    L56:
        if (r15.timestamp != r13.getStartLocationTime()) goto L58;
        boolean r27 = true;
    L59:
        r21 = Boolean.valueOf(r27);
        goto L60
    L58:
        r27 = false;
        goto L59
    L51:
        r19 = r15.logId;
        goto L52
    L47:
        r18 = r15.timestamp;
        goto L48
    L41:
        if (r15.timestamp != r13.getStartLocationTime()) goto L43;
        r17 = true;
        goto L44
    L37:
        r16 = false;
        goto L38
    L26:
        if (r13.getLocationExtraBean() == null) goto L28;
        r15 = r13.getLocationExtraBean().getLogIdCacheEntity();
    L29:
        StringBuilder r28 = new StringBuilder("uploadGpsAndBleInfosAndRemove ");
        if (r15 != null) goto L32;
        String r29 = "logIdCacheEntity = null";
    L33:
        r28.append(r29);
        Logger.i(r28.toString());
        goto L34
    L32:
        r29 = "logIdCacheEntity.logId: " + r15.logId + ", logIdCacheEntity.timestamp: " + r15.timestamp;
        goto L33
    L28:
        r15 = null;
        goto L29
    L19:
        if (this.mBleInfoList != null) goto L22;
        Logger.i("BDLocationExtraDataServer: extra data scan failed");
        this.mGpsInfoStatus = 0;
        this.mBleInfoListStatus = 0;
        LocationMonitor.locationExtraDataTraceLogErrorReport(r13, new BDLocationException("extra data scan failed", LocationInfoConst.BDLOCATION, BDLocationException.ERROR_EXTRA_DATA_SCAN_FAILED));
        return;
    L15:
        r11 = false;
        goto L16
    L11:
        r10 = false;
        goto L12
    }

    public void clearExtraData() {
        Logger.i("BDLocationExtraDataServer:clearExtraData");
        BDLocationConfig.setBleCacheEntity(null);
        BDLocationConfig.setLogIdCacheEntity(null);
    }

    public List<BDBleInfo> getBleEntryList() {
        LogIdCacheEntity r8 = BDLocationConfig.getLogIdCacheEntity();
        if (r8 != null) goto L7;
        String r10 = "BDLocationExtraDataServer:getLogIdCache cache is null";
    L5:
        Logger.i(r10);
        return null;
    L7:
        BLECacheEntity r11 = BDLocationConfig.getBleCacheEntity();
        if (r11 != null) goto L10;
    L15:
        r10 = "BDLocationExtraDataServer:getBleEntryList error";
        goto L5
    L10:
        if (r11.getTimeStamp() != r8.timestamp) goto L15;
        if (TextUtils.isEmpty(r8.logId) == true) goto L15;
        Logger.i("BDLocationExtraDataServer:getBleEntryList success");
        return r11.getBleInfoList();
    }

    public GpsInfoManager getGpsInfoManager() {
        return this.mGpsInfoManager;
    }

    public void startCollectBluetoothData(LocationOption r10) {
        this.mBleInfoListStatus = 0;
        this.mBleInfoList = null;
        if (r10 != null) goto L5;
    L30:
        Logger.i("BDLocationExtraDataServer:startCollectBluetoothData option is null");
        this.mBleInfoListStatus = 1;
        uploadGpsAndBleInfos(r10);
        return;
    L5:
        if (r10.isOnceLocation() == false) goto L30;
        if (r10.scanBle() == false) goto L30;
        LocationExtraDataTraceLogger r8 = r10.getLocationExtraDataTraceLogger();
        LocationMonitor.locationExtraDataTracePutCategoryData(r8, LocationExtraDataTraceLogger.ENABLE_SCAN_BLE, Boolean.valueOf(BDLocationConfig.enableScanBle()));
        LocationMonitor.locationExtraDataTracePutCategoryData(r8, LocationExtraDataTraceLogger.FIRST_REQUEST_LOCATION, Boolean.valueOf(BDLocationConfig.firstRequestLocation()));
        LocationMonitor.locationExtraDataTracePutCategoryData(r8, "enable_collect_ble_in_battery_saving_mode", Boolean.valueOf(BDLocationConfig.enableCollectBleInBatterySavingMode()));
        if (BDLocationConfig.enableCollectBleInBatterySavingMode() == true) goto L16;
        if (r10.getMode() != 0) goto L16;
        Logger.i("BDLocationExtraDataServer:startCollectBluetoothData Battery_Saving mode");
        this.mBleInfoListStatus = 1;
        uploadGpsAndBleInfos(r10);
        return;
    L16:
        if (BDLocationConfig.isUploadBleImmediately() == true) goto L22;
        if (BDLocationConfig.firstRequestLocation() == false) goto L22;
        Logger.i("BDLocationExtraDataServer:startCollectBluetoothData firstRequestLocation");
        this.mBleInfoListStatus = 1;
        uploadGpsAndBleInfos(r10);
        return;
    L22:
        if (BDLocationConfig.enableScanBle() == true) goto L24;
    L28:
        Logger.i("BDLocationExtraDataServer:startCollectBluetoothData not enable scan ble");
        this.mBleInfoListStatus = 1;
        uploadGpsAndBleInfos(r10);
        return;
    L24:
        if (BDLocationConfig.getScanBleInterval() <= 0) goto L28;
        scanBlueToothData(0, BDLocationConfig.getScanBleInterval(), r10);
    }

    public void startCollectGpsData(LocationOption r8, Handler r10, ArrayList<BDLocationExtraDataServer> r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.isOnceLocation() == false) goto L9;
        this.mLocationHandler = r10;
        this.mLocationExtraDataServerList = r11;
        long r12 = System.currentTimeMillis();
        r8.setStartLocationTime(r12);
        Logger.i("BDLocationExtraDataServer:startCollectGpsData");
        setExtraData(r8);
        clearExtraData();
        collectGpsInfo(r8);
        Logger.i("location-trace-core startCollectGpsData duration:" + (System.currentTimeMillis() - r12));
        return;
    }

    public void stopCollectExtraData() {
        BluetoothInfoManager r8 = this.mBluetoothInfoManager;
        if (r8 == null) goto L6;
        r8.stopScan();
    L6:
        if (this.mGpsInfoManager == null) goto L9;
        this.mGpsInfoManager.stopGpsCollect();
        return;
    }

    private void uploadGpsAndBleInfos(final LocationUploadExtra r8, final LocationOption r10, final LocationExtraDataTraceLogger r11) {
        if (LocationUtil.isMainThread() == false) goto L5;
        AppExecutors.getInstance().networkIO().execute(new AnonymousClass3(this, r8, r10, r11));
        return;
    L5:
        upLoadServerApi(r8, r10, r11);
    }
}
