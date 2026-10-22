package com.bytedance.bdlocation.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Keep;
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
import com.obric.cae.cloud.CloudServiceConstants;
import defpackage.b;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class SystemBaseLocationImpl extends BaseLocate {
    public static final String LBS_GEOCODE_NAME = "LBS";
    private final Handler mHandler;
    private LocationManager mManager;

    public class SystemLocationListener implements LocationListener {
        private BDLocationCallback mCallback;
        private boolean mGpsDisabled;
        private long mLocationStartTime;
        private boolean mNetworkDisabled;
        private LocationOption mOption;
        private TimeOutRunnable mTimeOutRunnable;
        final /* synthetic */ SystemBaseLocationImpl this$0;

        public SystemLocationListener(SystemBaseLocationImpl r8, LocationOption r10, BDLocationCallback r11) {
            this.this$0 = r8;
            this.mOption = r10;
            this.mCallback = r11;
            this.mTimeOutRunnable = new TimeOutRunnable(r8, this, r10, r11);
            SystemBaseLocationImpl.access$000(r8).postDelayed(this.mTimeOutRunnable, r10.getLocationTimeOutMs());
            this.mLocationStartTime = SystemClock.elapsedRealtime();
            LocationMonitor.locationTraceLogBegin(r10.getLocationTraceLogger(), LocationMonitorConst.CORE_LOCATE_DURATION);
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location r11) {
            this.this$0.removeListener(this);     // Catch: Exception -> L19
            if (this.mTimeOutRunnable == null) goto L7;
            SystemBaseLocationImpl.access$000(this.this$0).removeCallbacks(this.mTimeOutRunnable);     // Catch: Exception -> L19
        L7:
            if (this.mOption.isLocationChanged() == false) goto L10;
            Logger.i("Network Location Changed!");     // Catch: Exception -> L19
            return;
        L10:
            this.mOption.setLocationChanged(true);     // Catch: Exception -> L19
            String r8 = r11.getProvider();     // Catch: Exception -> L19
            Logger.i("SystemBaseLocationImpl onLocationChanged provider:" + r8);     // Catch: Exception -> L19
            if (r8.equals(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS) == false) goto L14;
            BDLocation r12 = SystemBaseLocationImpl.access$100(this.this$0, r11, 1);     // Catch: Exception -> L19
        L17:
            LocationMonitor.locationTraceLogEnd(this.mOption.getLocationTraceLogger(), LocationMonitorConst.CORE_LOCATE_DURATION);     // Catch: Exception -> L19
            SystemBaseLocationImpl.access$200(this.this$0, r12, this.mOption, this.mCallback, this.mLocationStartTime);     // Catch: Exception -> L19
            LocationMonitor.doDesiredLocationDuration(this.this$0.getLocateName(), SystemClock.elapsedRealtime() - this.mLocationStartTime, BDLocationException.SUCCESS, "success", null, this.mOption.isChineseRegion(), SystemBaseLocationImpl.access$300(this.this$0, r12), this.mOption.isBackground());     // Catch: Exception -> L19
            return;
        L14:
            if (r8.equals("network") == false) goto L16;
            r12 = SystemBaseLocationImpl.access$100(this.this$0, r11, 4);     // Catch: Exception -> L19
            goto L17
        L16:
            r12 = null;
        L19:
            e = move-exception;
            Logger.e("SystemBaseLocationImpl:network listener error", e);
            SystemBaseLocationImpl.access$400(this.this$0, this, e.getMessage(), BDLocationException.ERROR_UNKNOWN, this.mCallback, this.mLocationStartTime, this.mOption);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String r10) {
            Logger.i("SystemBaseLocationImpl:onProviderDisabled:" + r10);
            if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equals(r10) == false) goto L5;
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
        public void onProviderEnabled(String r8) {
            Logger.i("SystemBaseLocationImpl:onProviderEnabled:" + r8);
            this.mNetworkDisabled = false;
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String r8, int r10, Bundle r11) {
        }
    }

    public class TimeOutRunnable implements Runnable {
        private BDLocationCallback mCallback;
        private LocationListener mListener;
        private LocationOption mOption;
        private long mTimeoutStartTime;
        final /* synthetic */ SystemBaseLocationImpl this$0;

        public TimeOutRunnable(SystemBaseLocationImpl r8, LocationListener r10, LocationOption r11, BDLocationCallback r12) {
            this.this$0 = r8;
            this.mListener = r10;
            this.mCallback = r12;
            this.mOption = r11;
            this.mTimeoutStartTime = SystemClock.elapsedRealtime();
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemBaseLocationImpl.access$400(this.this$0, this.mListener, "timeout", "0", this.mCallback, this.mTimeoutStartTime, this.mOption);
        }
    }

    @Keep
    public SystemBaseLocationImpl(Context r8) {
        super(r8);
        this.mHandler = new Handler(ThreadLooperManager.getLocationWorker());
        this.mManager = (LocationManager) r8.getSystemService(LocationMonitorConst.LOCATION);
    }

    public static /* synthetic */ Handler access$000(SystemBaseLocationImpl r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ BDLocation access$100(SystemBaseLocationImpl r8, Location r10, int r11) {
        return r8.transform(r10, r11);
    }

    public static /* synthetic */ void access$200(SystemBaseLocationImpl r8, BDLocation r10, LocationOption r11, BDLocationCallback r12, long r13) {
        r8.geocodeAndCallback(r10, r11, r12, r13);
    }

    public static /* synthetic */ int access$300(SystemBaseLocationImpl r8, BDLocation r10) {
        return r8.getLocationType(r10);
    }

    public static /* synthetic */ void access$400(SystemBaseLocationImpl r8, LocationListener r10, String r11, String r12, BDLocationCallback r13, long r14, LocationOption r15) {
        r8.onError(r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ boolean access$500(SystemBaseLocationImpl r8, int r10, boolean r11, boolean r12) {
        return r8.checkProviderDisabled(r10, r11, r12);
    }

    private boolean checkProviderDisabled(int r8, boolean r10, boolean r11) {
        if (r8 != 2) goto L9;
        if (r10 == false) goto L7;
        if (r11 == false) goto L7;
        return true;
    L7:
        return false;
    L9:
        if (r8 != 0) goto L11;
        return r11;
    L11:
        return r10;
    }

    private void geocodeAndCallback(BDLocation r10, LocationOption r11, BDLocationCallback r12, long r13) {
        if (r10 != null) goto L5;
        onError(null, "location is null", BDLocationException.ERROR_UNKNOWN, r12, r13, r11);
    L5:
        if (LocationUtil.isNeedAddress(r11) == false) goto L7;
        BDLocation r8 = geocode(new BDPoint(r10.getLatitude(), r10.getLongitude(), r10.getProvider()));
    L8:
        if (r8 == null) goto L10;
        r10 = LocationUtil.composeGeocodeLocation(r10, r8);
    L10:
        r12.onLocationChanged(r10);
        return;
    L7:
        r8 = null;
        goto L8
    }

    @SuppressLint({"MissingPermission"})
    public static Location getLastKnownLocation(LocationManager r8, String r10, LocationOption r11) {
        if (r8 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return null;
    L8:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}) == true) goto L10;
        return null;
    L10:
        return BDLocationExtrasService.getBPEAManager().getLastKnownLocation(r8, r10, r11.getBpeaCert());
    }

    private int getLocationType(BDLocation r8) {
        if (r8 != null) goto L6;
        return 0;
    L6:
        return r8.getLocationType();
    }

    private void onError(LocationListener r14, String r15, String r16, BDLocationCallback r17, long r18, LocationOption r20) {
        StringBuilder r8 = b.i("SystemBaseLocationImpl location errorCode:", r16, "--message:", r15, "--isBackground:");
        r8.append(r20.isBackground());
        r8.append("--backgroundLocationPermissionStatus:");
        r8.append(LocationUtil.getBackgroundLocationPermissionStatus());
        Logger.e(r8.toString());
        LocationMonitor.doDesiredLocationDuration(getLocateName(), SystemClock.elapsedRealtime() - r18, r16, r15, null, r20.isChineseRegion(), 0, "", r20.isBackground());
        removeListener(r14);
        if (r17 == null) goto L6;
        r17.onError(new BDLocationException(r15, LocationInfoConst.SYSTEM, r16));
        return;
    }

    @SuppressLint({"MissingPermission"})
    private void singleLocation(LocationOption r10, Looper r11, BDLocationCallback r12) {
        SystemLocationListener r8 = new SystemLocationListener(this, r10, r12);
        int r13 = r10.getMode();
        Logger.i("SystemBaseLocationImpl singleLocation mode:" + r13);
        if (r13 != 0) goto L9;
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}) == false) goto L23;
        IBPEALocal r14 = BDLocationExtrasService.getBPEAManager();
        LocationManager r15 = this.mManager;
        String r16 = "network";
    L7:
        r14.requestSingleUpdate(r15, r16, r8, r11, r10.getBpeaCert());
        return;
    L23:
        return;
    L9:
        if (r13 != 1) goto L14;
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == false) goto L25;
    L12:
        r14 = BDLocationExtrasService.getBPEAManager();
        r15 = this.mManager;
        r16 = CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS;
        goto L7
    L25:
        return;
    L14:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}) == false) goto L17;
        BDLocationExtrasService.getBPEAManager().requestSingleUpdate(this.mManager, "network", r8, r11, r10.getBpeaCert());
    L17:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L19;
        return;
    L19:
        if (BDLocationConfig.isRevertToSystemLocation() == false) goto L12;
        Logger.i("SystemBaseLocationImpl.singleLocation: skip gps location.");
    }

    private BDLocation transform(Location r8, int r10) {
        if (r8 == null) goto L5;
        BDLocation r11 = new BDLocation(r8, getLocateName());
        r11.setLocationType(r10);
        r11.setLocationMs(System.currentTimeMillis());
        return r11;
    L5:
        return null;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public float calculateLineDistance(BDPoint r8, BDPoint r10) {
        return -1.0f;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public BDPoint convertGCJ02(BDPoint r8) {
        return null;
    }

    public BDLocation geocode(BDPoint r8) {
        BDLocation r10 = new BDLocation(r8.getProvider(), getLocateName());
        r10.setLatitude(r8.getLatitude());
        r10.setLongitude(r8.getLongitude());
        return LocationUtil.geocode(this.mContext, r10);
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
    public boolean isAMapDataAvailable(double r8, double r10) {
        return false;
    }

    public void removeListener(LocationListener r8) {
        if (r8 != null) goto L9;
    L4:
        Logger.i("SystemBaseLocationImpl:Android stopLocation");     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Logger.e("SystemBaseLocationImpl:android stop location error", e);
        return;
    L9:
        this.mManager.removeUpdates(r8);     // Catch: Exception -> L6
        goto L4
    }

    @Override // com.bytedance.bdlocation.BaseLocate, com.bytedance.bdlocation.api.ILocate
    @SuppressLint({"MissingPermission"})
    public void startLocation(BDLocationCallback r10, LocationOption r11, Looper r12) {
        super.startLocation(r10, r11, r12);
        long r8 = SystemClock.elapsedRealtime();
        if (LocationUtil.isLocationEnabled() == true) goto L7;
        r10.onError(new BDLocationException("定位服务没有开启，请在设置中打开定位服务开关", getLocateName(), BDLocationException.ERROR_DEVICE_LOCATION_DISABLE));
        return;
    L7:
        if (LocationUtil.checkBackground() == false) goto L32;
        return;
    L32:
    L29:
        e = move-exception;
        Logger.i("start location error");
        onError(null, e.getMessage(), BDLocationException.ERROR_UNKNOWN, r10, r8, r11);
        return;
    L10:
        if (BDLocationConfig.isRevertToSystemLocation() == true) goto L26;
        Location r13 = getLastKnownLocation(this.mManager, CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS, r11);     // Catch: Exception -> L29
        Location r14 = getLastKnownLocation(this.mManager, "network", r11);     // Catch: Exception -> L29
        if (r14 != null) goto L14;
    L19:
        if (r13 != null) goto L21;
    L27:
        singleLocation(r11, r12, r10);     // Catch: Exception -> L29
        onLocateStart(getLocateName());     // Catch: Exception -> L29
        Logger.i("SystemBaseLocationImpl:Android startLocation");     // Catch: Exception -> L29
        return;
    L21:
        if (LocationUtil.checkCacheTime(r13.getTime(), r11.getMaxCacheTime()) == false) goto L27;
        if (LocationUtil.isEmpty(r13) == true) goto L27;
        geocodeAndCallback(transform(r13, 1), r11, r10, r8);     // Catch: Exception -> L29
        return;
    L14:
        if (LocationUtil.checkCacheTime(r14.getTime(), r11.getMaxCacheTime()) == false) goto L19;
        if (LocationUtil.isEmpty(r14) == true) goto L19;
        geocodeAndCallback(transform(r14, 4), r11, r10, r8);     // Catch: Exception -> L29
        return;
    L26:
        Logger.i("SystemBaseLocationImpl.startLocation: skip getLastKnownLocation opt.");     // Catch: Exception -> L29
        goto L27
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public void stopLocation() {
    }
}
