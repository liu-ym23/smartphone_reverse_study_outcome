package com.bytedance.bdlocation.bytelocation;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.api.location.ByteLocationClientOption;
import com.bytedance.api.location.a;
import com.bytedance.api.location.b;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ByteLocationImpl extends BaseLocate {
    private ByteListener mByteListener;
    private Handler mHandler;
    private volatile boolean mIsFirstLocation;
    private volatile long mLastContinuousLocationStartTime;
    private a mLocationClient;

    private class ByteListener implements b {
        private BDLocationCallback mCallback;
        private Handler mHandler;
        private long mLocationStartTime;
        private LocationOption mOption;
        final /* synthetic */ ByteLocationImpl this$0;

        public ByteListener(ByteLocationImpl r3, Handler r4, BDLocationCallback r5, LocationOption r6) {
            BDLocationCallback r7 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r5, BDLocationCallback.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.mHandler = r4;
            this.mCallback = r7;
            this.mOption = r6;
            this.mLocationStartTime = SystemClock.elapsedRealtime();
            LocationMonitor.locationTraceLogBegin(this.mOption.getLocationTraceLogger(), LocationMonitorConst.CORE_LOCATE_DURATION);
        }

        static /* synthetic */ BDLocationCallback access$200(ByteListener r0) {
            return r0.mCallback;
        }

        static /* synthetic */ LocationOption access$300(ByteListener r0) {
            return r0.mOption;
        }

        static /* synthetic */ long access$400(ByteListener r2) {
            return r2.mLocationStartTime;
        }

        @Override // com.bytedance.api.location.b
        public void onError(BDLocationException r17) {
            if (this.mOption.isOnceLocation() == false) goto L5;
            LocationMonitor.doDesiredLocationDuration(this.this$0.getLocateName(), SystemClock.elapsedRealtime() - this.mLocationStartTime, r17.getCode(), r17.getDetailMessage(), null, this.mOption.isChineseRegion(), 0, this.mOption.isBackground());
        L6:
            Logger.i("ByteLocationImpl: ByteListener onError() and the message is " + r17.getMessage());
            this.mCallback.onError(r17);
            return;
        L5:
            LocationMonitor.doContinueLocation(this.this$0.getLocateName(), r17.getCode(), r17.getDetailMessage(), this.mOption.isChineseRegion(), 0, "", SystemClock.elapsedRealtime() - ByteLocationImpl.access$000(this.this$0), ByteLocationImpl.access$100(this.this$0), this.mOption.getUploadSource(), null);
            ByteLocationImpl.access$002(this.this$0, SystemClock.elapsedRealtime());
            ByteLocationImpl.access$102(this.this$0, false);
            goto L6
        }

        @Override // com.bytedance.api.location.b
        public void onLocationChanged(final BDLocation r18) {
            Logger.i("ByteLocationImpl: ByteListener onLocationChanged() is executed ");
            Handler r2 = this.mHandler;
            if (r2 == null) goto L8;
            if (r18 == null) goto L8;
            r2.post(new AnonymousClass1(this, r18));
            return;
        L8:
            BDLocationException r1 = new BDLocationException(BDLocationExceptionMessage.BYTE_LOCATION_ERROR, LocationInfoConst.BYTE, "42");
            if (this.mOption.isOnceLocation() == false) goto L11;
            LocationMonitor.locationTraceLogEnd(this.mOption.getLocationTraceLogger(), LocationMonitorConst.CORE_LOCATE_DURATION);
            LocationMonitor.doDesiredLocationDuration(this.this$0.getLocateName(), SystemClock.elapsedRealtime() - this.mLocationStartTime, "42", BDLocationExceptionMessage.BYTE_LOCATION_ERROR, null, this.mOption.isChineseRegion(), 0, this.mOption.isBackground());
        L12:
            this.mCallback.onError(r1);
            return;
        L11:
            long r12 = SystemClock.elapsedRealtime() - ByteLocationImpl.access$000(this.this$0);
            LocationMonitor.doContinueLocation(this.this$0.getLocateName(), r1.getCode(), r1.getDetailMessage(), this.mOption.isChineseRegion(), 0, "", r12, ByteLocationImpl.access$100(this.this$0), this.mOption.getUploadSource(), null);
            ByteLocationImpl.access$002(this.this$0, SystemClock.elapsedRealtime());
            ByteLocationImpl.access$102(this.this$0, false);
            goto L12
        }
    }

    public ByteLocationImpl(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        this.mLocationClient = null;
        this.mByteListener = null;
        this.mIsFirstLocation = true;
    }

    static /* synthetic */ long access$000(ByteLocationImpl r2) {
        return r2.mLastContinuousLocationStartTime;
    }

    static /* synthetic */ long access$002(ByteLocationImpl r0, long r1) {
        r0.mLastContinuousLocationStartTime = r1;
        return r1;
    }

    static /* synthetic */ boolean access$100(ByteLocationImpl r0) {
        return r0.mIsFirstLocation;
    }

    static /* synthetic */ boolean access$102(ByteLocationImpl r0, boolean r1) {
        r0.mIsFirstLocation = r1;
        return r1;
    }

    private a buildClient(LocationOption r4) {
        ByteLocationClientOption r0 = new ByteLocationClientOption(r4);
        if (r4 == null) goto L5;
        int r1 = r4.getGeocodeMode();
    L6:
        if (r1 != 0) goto L8;
        int r2 = 0;
    L9:
        r0.a(r2);
        r0.a(r4.getInterval());
        r0.a(transLocationModel(r4));
        r0.b(r4.getUploadInterval());
        r0.a(r4.getUploadSource());
        r0.b(r4.getTriggerType());
        r0.c(r4.getLocationTimeOutMs());
        r0.a(r4.isOnceLocation());
        r0.b(r4.isLatestAdminVersion());
        r0.a(r4.getBpeaCert());
        r0.d(r4.getStartLocationTime());
        r0.a(r4.getLocationExtraBean());
        r0.b(r4.getExtra());
        r0.a(r4.getLocationTraceLogger());
        r0.c(r4.getLocateId());
        r0.a(r4.getLocationExtraDataServer());
        a r3 = new a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r3.a(r0);
        return r3;
    L8:
        r2 = 1;
        goto L9
    L5:
        r1 = -1;
        goto L6
    }

    private void startContinuousLocation(BDLocationCallback r4, LocationOption r5, Looper r6) {
        BDLocationCallback r7 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r4, BDLocationCallback.class, "com.obric.memorydata.plugin");
        if (this.mLocationClient == null) goto L5;
        stopLocation();
    L5:
        Logger.i("ByteLocationImpl: startContinuousLocation() is executed and the interval is " + r5.getInterval());
        this.mLastContinuousLocationStartTime = SystemClock.elapsedRealtime();
        this.mIsFirstLocation = true;
        this.mHandler = new Handler(r6);
        this.mLocationClient = buildClient(r5);
        ByteListener r8 = new ByteListener(this, this.mHandler, r7, r5);
        this.mByteListener = r8;
        this.mLocationClient.a(r8);
        this.mLocationClient.a();
        onLocateStart(LocationInfoConst.BYTE);
    }

    private void startOnceLocation(BDLocationCallback r3, LocationOption r4, Looper r5) {
        BDLocationCallback r6 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r3, BDLocationCallback.class, "com.obric.memorydata.plugin");
        Logger.i("ByteLocationImpl: startOnceLocation() is executed.");
        Handler r0 = new Handler(r5);
        a r7 = buildClient(r4);
        r7.a(new ByteListener(this, r0, r6, r4));
        r7.a();
        onLocateStart(LocationInfoConst.BYTE);
    }

    private ByteLocationClientOption.LocationMode transLocationModel(LocationOption r1) {
        int r0 = r1.getMode();
        if (r0 != 0) goto L7;
        return ByteLocationClientOption.LocationMode.Battery_Saving;
    L7:
        if (r0 != 1) goto L11;
        return ByteLocationClientOption.LocationMode.Device_Sensors;
    L11:
        return ByteLocationClientOption.LocationMode.Hight_Accuracy;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public float calculateLineDistance(BDPoint r1, BDPoint r2) {
        return -1.0f;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public BDPoint convertGCJ02(BDPoint r1) {
        return null;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public String getLocateName() {
        return LocationInfoConst.BYTE;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public boolean isAMapDataAvailable(double r1, double r3) {
        return true;
    }

    @Override // com.bytedance.bdlocation.BaseLocate, com.bytedance.bdlocation.api.ILocate
    public void startLocation(BDLocationCallback r3, LocationOption r4, Looper r5) {
        BDLocationCallback r6 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r3, BDLocationCallback.class, "com.obric.memorydata.plugin");
        super.startLocation(r6, r4, r5);
        Logger.i("location-trace-core ByteLocationImpl: startLocation() is executed.");
        if (r4.isOnceLocation() == true) goto L5;
        startContinuousLocation(r6, r4, r5);
        return;
    L5:
        startOnceLocation(r6, r4, r5);
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public void stopLocation() {
        Logger.i("ByteLocationImpl: stopLocation() is executed.");
        this.mHandler = null;
        a r1 = this.mLocationClient;
        if (r1 == null) goto L5;
        r1.b(this.mByteListener);
        this.mLocationClient.b();
        this.mByteListener = null;
        this.mLocationClient = null;
    L5:
        onLocateStop(LocationInfoConst.BYTE);
    }
}
