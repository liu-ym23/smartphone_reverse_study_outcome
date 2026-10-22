package com.bytedance.bdlocation.bytelocation;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Keep;
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
import java.util.concurrent.CopyOnWriteArrayList;
import z1.a;
import z1.b;
import z1.c;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ByteLocationImpl extends BaseLocate {
    private ByteListener mByteListener;
    private Handler mHandler;
    private volatile boolean mIsFirstLocation;
    private volatile long mLastContinuousLocationStartTime;
    private a mLocationClient;

    public class ByteListener implements c {
        private BDLocationCallback mCallback;
        private Handler mHandler;
        private long mLocationStartTime;
        private LocationOption mOption;
        final /* synthetic */ ByteLocationImpl this$0;

        public ByteListener(ByteLocationImpl r8, Handler r10, BDLocationCallback r11, LocationOption r12) {
            this.this$0 = r8;
            this.mHandler = r10;
            this.mCallback = r11;
            this.mOption = r12;
            this.mLocationStartTime = SystemClock.elapsedRealtime();
            LocationMonitor.locationTraceLogBegin(this.mOption.getLocationTraceLogger(), LocationMonitorConst.CORE_LOCATE_DURATION);
        }

        public static /* synthetic */ BDLocationCallback access$200(ByteListener r8) {
            return r8.mCallback;
        }

        public static /* synthetic */ LocationOption access$300(ByteListener r8) {
            return r8.mOption;
        }

        public static /* synthetic */ long access$400(ByteListener r8) {
            return r8.mLocationStartTime;
        }

        @Override // z1.c
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

        @Override // z1.c
        public void onLocationChanged(final BDLocation r18) {
            Logger.i("ByteLocationImpl: ByteListener onLocationChanged() is executed ");
            Handler r8 = this.mHandler;
            if (r8 == null) goto L8;
            if (r18 == null) goto L8;
            r8.post(new AnonymousClass1(this, r18));
            return;
        L8:
            BDLocationException r10 = new BDLocationException(BDLocationExceptionMessage.BYTE_LOCATION_ERROR, LocationInfoConst.BYTE, BDLocationException.ERROR_BYTE_FAIL);
            if (this.mOption.isOnceLocation() == false) goto L11;
            LocationMonitor.locationTraceLogEnd(this.mOption.getLocationTraceLogger(), LocationMonitorConst.CORE_LOCATE_DURATION);
            LocationMonitor.doDesiredLocationDuration(this.this$0.getLocateName(), SystemClock.elapsedRealtime() - this.mLocationStartTime, BDLocationException.ERROR_BYTE_FAIL, BDLocationExceptionMessage.BYTE_LOCATION_ERROR, null, this.mOption.isChineseRegion(), 0, this.mOption.isBackground());
        L12:
            this.mCallback.onError(r10);
            return;
        L11:
            long r12 = SystemClock.elapsedRealtime() - ByteLocationImpl.access$000(this.this$0);
            LocationMonitor.doContinueLocation(this.this$0.getLocateName(), r10.getCode(), r10.getDetailMessage(), this.mOption.isChineseRegion(), 0, "", r12, ByteLocationImpl.access$100(this.this$0), this.mOption.getUploadSource(), null);
            ByteLocationImpl.access$002(this.this$0, SystemClock.elapsedRealtime());
            ByteLocationImpl.access$102(this.this$0, false);
            goto L12
        }
    }

    @Keep
    public ByteLocationImpl(Context r8) {
        super(r8);
        this.mLocationClient = null;
        this.mByteListener = null;
        this.mIsFirstLocation = true;
    }

    public static /* synthetic */ long access$000(ByteLocationImpl r8) {
        return r8.mLastContinuousLocationStartTime;
    }

    public static /* synthetic */ long access$002(ByteLocationImpl r8, long r10) {
        r8.mLastContinuousLocationStartTime = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$100(ByteLocationImpl r8) {
        return r8.mIsFirstLocation;
    }

    public static /* synthetic */ boolean access$102(ByteLocationImpl r8, boolean r10) {
        r8.mIsFirstLocation = r10;
        return r10;
    }

    private a buildClient(LocationOption r8) {
        b r10 = new b(r8);
        if (r8 == null) goto L5;
        int r11 = r8.getGeocodeMode();
    L6:
        if (r11 != 0) goto L9;
        int r12 = 0;
    L8:
        r10.f14177d = r12;
        long r13 = r8.getInterval();
        long r14 = 0;
        if (r13 <= 0) goto L15;
        r14 = 1000;
        if (r13 < 1000) goto L15;
        r10.f14174a = r13;
    L17:
        r10.f14178e = transLocationModel(r8);
        r10.f14180g = r8.getUploadInterval();
        r10.f14181h = r8.getUploadSource();
        r10.f14184k = r8.getTriggerType();
        r10.f14179f = r8.getLocationTimeOutMs();
        r10.f14185l = r8.isOnceLocation();
        r10.f14186m = r8.isLatestAdminVersion();
        r10.f14187n = r8.getBpeaCert();
        r10.f14188o = r8.getStartLocationTime();
        r10.f14182i = r8.getLocationExtraBean();
        r10.f14183j = r8.getExtra();
        r10.f14189p = r8.getLocationTraceLogger();
        r10.f14190q = r8.getLocateId();
        r10.f14191r = r8.getLocationExtraDataServer();
        a r15 = new a(BDLocationConfig.getContext());
        r15.f14172a = r10;
        return r15;
    L15:
        r10.f14174a = r14;
        goto L17
    L9:
        r12 = 1;
        goto L8
    L5:
        r11 = -1;
        goto L6
    }

    private void startContinuousLocation(BDLocationCallback r8, LocationOption r10, Looper r11) {
        if (this.mLocationClient == null) goto L5;
        stopLocation();
    L5:
        Logger.i("ByteLocationImpl: startContinuousLocation() is executed and the interval is " + r10.getInterval());
        this.mLastContinuousLocationStartTime = SystemClock.elapsedRealtime();
        this.mIsFirstLocation = true;
        this.mHandler = new Handler(r11);
        this.mLocationClient = buildClient(r10);
        ByteListener r12 = new ByteListener(this, this.mHandler, r8, r10);
        this.mByteListener = r12;
        CopyOnWriteArrayList r13 = this.mLocationClient.f14173b.f30b.f28b;
        if (r13.contains(r12) == true) goto L8;
        r13.add(r12);
    L8:
        this.mLocationClient.a();
        onLocateStart(LocationInfoConst.BYTE);
    }

    private void startOnceLocation(BDLocationCallback r8, LocationOption r10, Looper r11) {
        Logger.i("ByteLocationImpl: startOnceLocation() is executed.");
        Handler r12 = new Handler(r11);
        a r13 = buildClient(r10);
        ByteListener r14 = new ByteListener(this, r12, r8, r10);
        CopyOnWriteArrayList r15 = r13.f14173b.f30b.f28b;
        if (r15.contains(r14) == true) goto L5;
        r15.add(r14);
    L5:
        r13.a();
        onLocateStart(LocationInfoConst.BYTE);
    }

    private b.a transLocationModel(LocationOption r8) {
        int r10 = r8.getMode();
        if (r10 != 0) goto L7;
        return b.a.f14192a;
    L7:
        if (r10 != 1) goto L11;
        return b.a.f14193b;
    L11:
        return b.a.f14194m;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public float calculateLineDistance(BDPoint r8, BDPoint r10) {
        return -1.0f;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public BDPoint convertGCJ02(BDPoint r8) {
        return null;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public String getLocateName() {
        return LocationInfoConst.BYTE;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public boolean isAMapDataAvailable(double r8, double r10) {
        return true;
    }

    @Override // com.bytedance.bdlocation.BaseLocate, com.bytedance.bdlocation.api.ILocate
    public void startLocation(BDLocationCallback r8, LocationOption r10, Looper r11) {
        super.startLocation(r8, r10, r11);
        Logger.i("location-trace-core ByteLocationImpl: startLocation() is executed.");
        if (r10.isOnceLocation() == true) goto L5;
        startContinuousLocation(r8, r10, r11);
        return;
    L5:
        startOnceLocation(r8, r10, r11);
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public void stopLocation() {
        Logger.i("ByteLocationImpl: stopLocation() is executed.");
        this.mHandler = null;
        a r8 = this.mLocationClient;
        if (r8 == null) goto L14;
        ByteListener r10 = this.mByteListener;
        if (r10 == null) goto L13;
        r8.f14173b.f30b.f28b.remove(r10);
        a r11 = this.mLocationClient;
        r11.getClass();
        Logger.i("ByteLocationClient: release() is executed.");
        a2.b r12 = r11.f14173b;     // Catch: Exception -> L9
        r12.d();     // Catch: Exception -> L9
        r12.f30b.f28b.clear();     // Catch: Exception -> L9
    L11:
        this.mByteListener = null;
        this.mLocationClient = null;
    L9:
        e = move-exception;
        Logger.i("ByteLocationClient: release() has an error and the message: %s", e.getLocalizedMessage());
        e.printStackTrace();
        goto L11
    L13:
        throw new NullPointerException("listener should not null");
    L14:
        onLocateStop(LocationInfoConst.BYTE);
    }
}
