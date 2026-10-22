package com.bytedance.bdlocation.service;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class SystemBaseLocationImpl extends BaseLocate {
    public static final String LBS_GEOCODE_NAME = "LBS";
    private final Handler mHandler;
    private LocationManager mManager;

    private class SystemLocationListener implements LocationListener {
        private BDLocationCallback mCallback;
        private boolean mGpsDisabled;
        private long mLocationStartTime;
        private boolean mNetworkDisabled;
        private LocationOption mOption;
        private TimeOutRunnable mTimeOutRunnable;
        final /* synthetic */ SystemBaseLocationImpl this$0;

        public SystemLocationListener(SystemBaseLocationImpl r3, LocationOption r4, BDLocationCallback r5) {
            BDLocationCallback r6 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r5, BDLocationCallback.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.mOption = r4;
            this.mCallback = r6;
            this.mTimeOutRunnable = new TimeOutRunnable(r3, this, r4, this.mCallback);
            SystemBaseLocationImpl.access$000(r3).postDelayed(this.mTimeOutRunnable, r4.getLocationTimeOutMs());
            this.mLocationStartTime = SystemClock.elapsedRealtime();
            LocationMonitor.locationTraceLogBegin(r4.getLocationTraceLogger(), LocationMonitorConst.CORE_LOCATE_DURATION);
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location r11) {
            this.this$0.removeListener(this);     // Catch: Exception -> L17
            if (this.mTimeOutRunnable == null) goto L6;
            SystemBaseLocationImpl.access$000(this.this$0).removeCallbacks(this.mTimeOutRunnable);     // Catch: Exception -> L17
        L6:
            if (this.mOption.isLocationChanged() == false) goto L9;
            Logger.i("Network Location Changed!");     // Catch: Exception -> L17
            return;
        L9:
            this.mOption.setLocationChanged(true);     // Catch: Exception -> L17
            String r0 = r11.getProvider();     // Catch: Exception -> L17
            Logger.i("SystemBaseLocationImpl onLocationChanged provider:" + r0);     // Catch: Exception -> L17
            BDLocation r2 = null;
            if (r0.equals("gps") == false) goto L13;
            r2 = SystemBaseLocationImpl.access$100(this.this$0, r11, 1);     // Catch: Exception -> L17
        L15:
            BDLocation r12 = r2;
            LocationMonitor.locationTraceLogEnd(this.mOption.getLocationTraceLogger(), LocationMonitorConst.CORE_LOCATE_DURATION);     // Catch: Exception -> L17
            SystemBaseLocationImpl.access$200(this.this$0, r12, this.mOption, this.mCallback, this.mLocationStartTime);     // Catch: Exception -> L17
            LocationMonitor.doDesiredLocationDuration(this.this$0.getLocateName(), SystemClock.elapsedRealtime() - this.mLocationStartTime, BDLocationException.SUCCESS, "success", null, this.mOption.isChineseRegion(), SystemBaseLocationImpl.access$300(this.this$0, r12), this.mOption.isBackground());     // Catch: Exception -> L17
            return;
        L13:
            if (r0.equals("network") == false) goto L15;
            r2 = SystemBaseLocationImpl.access$100(this.this$0, r11, 4);     // Catch: Exception -> L17
        L17:
            e = move-exception;
            Logger.e("SystemBaseLocationImpl:network listener error", e);
            SystemBaseLocationImpl.access$400(this.this$0, this, e.getMessage(), BDLocationException.ERROR_UNKNOWN, this.mCallback, this.mLocationStartTime, this.mOption);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String r10) {
            Logger.i("SystemBaseLocationImpl:onProviderDisabled:" + r10);
            if ("gps".equals(r10) == false) goto L5;
            this.mGpsDisabled = true;
        L7:
            if (SystemBaseLocationImpl.access$500(this.this$0, this.mOption.getMode(), this.mGpsDisabled, this.mNetworkDisabled) == true) goto L9;
            return;
        L9:
            if (this.mTimeOutRunnable == null) goto L11;
            SystemBaseLocationImpl.access$000(this.this$0).removeCallbacks(this.mTimeOutRunnable);
        L11:
            SystemBaseLocationImpl.access$400(this.this$0, this, "provider disabled", BDLocationException.ERROR_PROVIDER_DISABLED, this.mCallback, this.mLocationStartTime, this.mOption);
            return;
        L5:
            this.mNetworkDisabled = true;
            goto L7
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String r3) {
            Logger.i("SystemBaseLocationImpl:onProviderEnabled:" + r3);
            this.mNetworkDisabled = false;
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String r1, int r2, Bundle r3) {
        }
    }

    private class TimeOutRunnable implements Runnable {
        private BDLocationCallback mCallback;
        private LocationListener mListener;
        private LocationOption mOption;
        private long mTimeoutStartTime;
        final /* synthetic */ SystemBaseLocationImpl this$0;

        public TimeOutRunnable(SystemBaseLocationImpl r3, LocationListener r4, LocationOption r5, BDLocationCallback r6) {
            LocationListener r7 = (LocationListener) ZeusTransformUtils.wrapperContextForParams(r4, LocationListener.class, "com.obric.memorydata.plugin");
            BDLocationCallback r8 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r6, BDLocationCallback.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.mListener = r7;
            this.mCallback = r8;
            this.mOption = r5;
            this.mTimeoutStartTime = SystemClock.elapsedRealtime();
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemBaseLocationImpl.access$400(this.this$0, this.mListener, LocationMonitorConst.TIMEOUT, "0", this.mCallback, this.mTimeoutStartTime, this.mOption);
        }
    }

    public SystemBaseLocationImpl(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        super(r5);
        this.mHandler = new Handler(ThreadLooperManager.getLocationWorker());
        this.mManager = (LocationManager) ZeusTransformUtils.preCheckCast(r5.getSystemService("location"), LocationManager.class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ Handler access$000(SystemBaseLocationImpl r0) {
        return r0.mHandler;
    }

    static /* synthetic */ BDLocation access$100(SystemBaseLocationImpl r0, Location r1, int r2) {
        return r0.transform(r1, r2);
    }

    static /* synthetic */ void access$200(SystemBaseLocationImpl r6, BDLocation r7, LocationOption r8, BDLocationCallback r9, long r10) {
        r6.geocodeAndCallback(r7, r8, (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r9, BDLocationCallback.class, "com.obric.memorydata.plugin"), r10);
    }

    static /* synthetic */ int access$300(SystemBaseLocationImpl r0, BDLocation r1) {
        return r0.getLocationType(r1);
    }

    static /* synthetic */ void access$400(SystemBaseLocationImpl r10, LocationListener r11, String r12, String r13, BDLocationCallback r14, long r15, LocationOption r17) {
        r10.onError((LocationListener) ZeusTransformUtils.wrapperContextForParams(r11, LocationListener.class, "com.obric.memorydata.plugin"), r12, r13, (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r14, BDLocationCallback.class, "com.obric.memorydata.plugin"), r15, r17);
    }

    static /* synthetic */ boolean access$500(SystemBaseLocationImpl r0, int r1, boolean r2, boolean r3) {
        return r0.checkProviderDisabled(r1, r2, r3);
    }

    private boolean checkProviderDisabled(int r1, boolean r2, boolean r3) {
        if (r1 != 2) goto L9;
        if (r2 == false) goto L7;
        if (r3 == false) goto L7;
        return true;
    L7:
        return false;
    L9:
        if (r1 != 0) goto L11;
        return r3;
    L11:
        return r2;
    }

    private void geocodeAndCallback(BDLocation r9, LocationOption r10, BDLocationCallback r11, long r12) {
        BDLocationCallback r13 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r11, BDLocationCallback.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L5;
        onError(null, "location is null", BDLocationException.ERROR_UNKNOWN, r13, r12, r10);
    L5:
        BDLocation r14 = null;
        if (LocationUtil.isNeedAddress(r10) == false) goto L8;
        r14 = geocode(new BDPoint(r9.getLatitude(), r9.getLongitude(), r9.getProvider()));
    L8:
        if (r14 == null) goto L10;
        r9 = LocationUtil.composeGeocodeLocation(r9, r14);
    L10:
        r13.onLocationChanged(r9);
    }

    public static Location getLastKnownLocation(LocationManager r3, String r4, LocationOption r5) {
        if (r3 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L8;
        return null;
    L8:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}) == true) goto L10;
        return null;
    L10:
        return BDLocationExtrasService.getBPEAManager().getLastKnownLocation(r3, r4, r5.getBpeaCert());
    }

    private int getLocationType(BDLocation r1) {
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.getLocationType();
    }

    private void onError(LocationListener r15, String r16, String r17, BDLocationCallback r18, long r19, LocationOption r21) {
        LocationListener r12 = (LocationListener) ZeusTransformUtils.wrapperContextForParams(r15, LocationListener.class, "com.obric.memorydata.plugin");
        BDLocationCallback r13 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r18, BDLocationCallback.class, "com.obric.memorydata.plugin");
        Logger.e("SystemBaseLocationImpl location errorCode:" + r17 + "--message:" + r16 + "--isBackground:" + r21.isBackground() + "--backgroundLocationPermissionStatus:" + LocationUtil.getBackgroundLocationPermissionStatus());
        LocationMonitor.doDesiredLocationDuration(getLocateName(), SystemClock.elapsedRealtime() - r19, r17, r16, null, r21.isChineseRegion(), 0, "", r21.isBackground());
        removeListener(r12);
        if (r13 == null) goto L6;
        r13.onError(new BDLocationException(r16, LocationInfoConst.SYSTEM, r17));
        return;
    }

    private void singleLocation(LocationOption r9, Looper r10, BDLocationCallback r11) {
        SystemLocationListener r6 = new SystemLocationListener(this, r9, (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r11, BDLocationCallback.class, "com.obric.memorydata.plugin"));
        int r12 = r9.getMode();
        Logger.i("SystemBaseLocationImpl singleLocation mode:" + r12);
        if (r12 != 0) goto L9;
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}) == false) goto L23;
        IBPEALocal r0 = BDLocationExtrasService.getBPEAManager();
        LocationManager r1 = this.mManager;
        Object r5 = r9.getBpeaCert();
        String r2 = "network";
    L7:
        r0.requestSingleUpdate(r1, r2, r6, r10, r5);
        return;
    L23:
        return;
    L9:
        if (r12 != 1) goto L14;
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == false) goto L25;
    L12:
        r0 = BDLocationExtrasService.getBPEAManager();
        r1 = this.mManager;
        r5 = r9.getBpeaCert();
        r2 = "gps";
        goto L7
    L25:
        return;
    L14:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}) == false) goto L17;
        BDLocationExtrasService.getBPEAManager().requestSingleUpdate(this.mManager, "network", r6, r10, r9.getBpeaCert());
    L17:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L19;
        return;
    L19:
        if (BDLocationConfig.isRevertToSystemLocation() == false) goto L12;
        Logger.i("SystemBaseLocationImpl.singleLocation: skip gps location.");
    }

    private BDLocation transform(Location r2, int r3) {
        if (r2 == null) goto L5;
        BDLocation r0 = new BDLocation(r2, getLocateName());
        r0.setLocationType(r3);
        r0.setLocationMs(System.currentTimeMillis());
        return r0;
    L5:
        return null;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public float calculateLineDistance(BDPoint r1, BDPoint r2) {
        return -1.0f;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public BDPoint convertGCJ02(BDPoint r1) {
        return null;
    }

    public BDLocation geocode(BDPoint r4) {
        BDLocation r0 = new BDLocation(r4.getProvider(), getLocateName());
        r0.setLatitude(r4.getLatitude());
        r0.setLongitude(r4.getLongitude());
        return LocationUtil.geocode(this.mContext, r0);
    L5:
        e = move-exception;
        Logger.e("SystemBaseLocationImpl:geocode error", e);
        return null;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public String getLocateName() {
        return LocationInfoConst.SYSTEM;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public boolean isAMapDataAvailable(double r1, double r3) {
        return false;
    }

    public void removeListener(LocationListener r3) {
        LocationListener r4 = (LocationListener) ZeusTransformUtils.wrapperContextForParams(r3, LocationListener.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L10;
    L5:
        Logger.i("SystemBaseLocationImpl:Android stopLocation");     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        Logger.e("SystemBaseLocationImpl:android stop location error", e);
        return;
    L10:
        this.mManager.removeUpdates(r4);     // Catch: Exception -> L7
        goto L5
    }

    @Override // com.bytedance.bdlocation.BaseLocate, com.bytedance.bdlocation.api.ILocate
    public void startLocation(BDLocationCallback r9, LocationOption r10, Looper r11) {
        BDLocationCallback r12 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r9, BDLocationCallback.class, "com.obric.memorydata.plugin");
        super.startLocation(r12, r10, r11);
        long r6 = SystemClock.elapsedRealtime();
        if (LocationUtil.isLocationEnabled() == true) goto L7;
        r12.onError(new BDLocationException("定位服务没有开启，请在设置中打开定位服务开关", getLocateName(), BDLocationException.ERROR_DEVICE_LOCATION_DISABLE));
        return;
    L7:
        if (LocationUtil.checkBackground() == false) goto L32;
        return;
    L32:
    L29:
        e = move-exception;
        Logger.i("start location error");
        onError(null, e.getMessage(), BDLocationException.ERROR_UNKNOWN, r12, r6, r10);
        return;
    L10:
        if (BDLocationConfig.isRevertToSystemLocation() == true) goto L26;
        Location r0 = getLastKnownLocation(this.mManager, "gps", r10);     // Catch: Exception -> L29
        Location r1 = getLastKnownLocation(this.mManager, "network", r10);     // Catch: Exception -> L29
        if (r1 != null) goto L14;
    L19:
        if (r0 != null) goto L21;
    L27:
        singleLocation(r10, r11, r12);     // Catch: Exception -> L29
        onLocateStart(getLocateName());     // Catch: Exception -> L29
        Logger.i("SystemBaseLocationImpl:Android startLocation");     // Catch: Exception -> L29
        return;
    L21:
        if (LocationUtil.checkCacheTime(r0.getTime(), r10.getMaxCacheTime()) == false) goto L27;
        if (LocationUtil.isEmpty(r0) == true) goto L27;
        geocodeAndCallback(transform(r0, 1), r10, r12, r6);     // Catch: Exception -> L29
        return;
    L14:
        if (LocationUtil.checkCacheTime(r1.getTime(), r10.getMaxCacheTime()) == false) goto L19;
        if (LocationUtil.isEmpty(r1) == true) goto L19;
        geocodeAndCallback(transform(r1, 4), r10, r12, r6);     // Catch: Exception -> L29
        return;
    L26:
        Logger.i("SystemBaseLocationImpl.startLocation: skip getLastKnownLocation opt.");     // Catch: Exception -> L29
        goto L27
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public void stopLocation() {
    }
}
