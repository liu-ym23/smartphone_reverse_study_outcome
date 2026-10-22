package com.bytedance.api.location.a;

import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.api.location.ByteLocationClientOption;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.LocationUploadCallback;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.bytedance.bdlocation.network.response.LocationResp;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.bytedance.api.location.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.api.location.a.a f1030b;
    private LocationManager c;
    private f d;
    private volatile ByteLocationClientOption e;
    private LocationListener f;
    private e g;
    private d h;

    /* JADX INFO: renamed from: com.bytedance.api.location.a.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1031a = null;

        static {
            int[] r0 = new int[ByteLocationClientOption.LocationMode.values().length];
            f1031a = r0;
            r0[ByteLocationClientOption.LocationMode.Battery_Saving.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f1031a[ByteLocationClientOption.LocationMode.Device_Sensors.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f1031a[ByteLocationClientOption.LocationMode.Hight_Accuracy.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private abstract class a implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected String f1032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f1033b;

        private a(b r1) {
            this.f1033b = r1;
            this.f1032a = "BaseLocationListener";
        }

        /* synthetic */ a(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String r2) {
            Logger.i("ByteLocationManagerImpl: BaseLocationListener onProviderDisabled() provider is " + r2);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String r2) {
            Logger.i("ByteLocationManagerImpl: BaseLocationListener onProviderEnabled() provider is " + r2);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String r1, int r2, Bundle r3) {
            Logger.i("ByteLocationManagerImpl: BaseLocationListener onStatusChanged() status is " + r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.api.location.a.b$b, reason: collision with other inner class name */
    private class C0078b implements LocationUploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f1034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ByteLocationClientOption f1035b;
        private BDLocation c;

        public C0078b(b r1, ByteLocationClientOption r2, BDLocation r3) {
            this.f1034a = r1;
            this.f1035b = r2;
            this.c = r3;
        }

        private void a() {
            if (this.f1035b.j() == true) goto L6;
            Logger.i("ByteLocationManagerImpl: BatterySavingLocationCallback is continuous location. The interval is " + this.f1035b.a());
            b.b(this.f1034a).sendMessageDelayed(Message.obtain(b.b(this.f1034a), 1, this.f1035b), this.f1035b.a());
            Logger.i("performNextLocationIfNecessary interval:" + this.f1035b.a());
            return;
        }

        @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
        public void onError(String r4) {
            Logger.i("ByteLocationManagerImpl: BatterySavingLocationCallback onError! The message is " + r4);
            b.a(this.f1034a).a(new BDLocationException(r4, this.f1034a.a(), BDLocationException.ERROR_NETWORK_REQUEST));
        }

        @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
        public void onSuccess(LocationResp r5, boolean r6, WifiInfo r7) {
            if (r5 != null) goto L5;
            Logger.i("ByteLocationManagerImpl: BatterySavingLocationCallback onError");
            b.a(this.f1034a).a(new BDLocationException("analysis locInfoRsp error:resp is null", this.f1034a.a(), BDLocationException.ERROR_NETWORK_REQUEST));
            return;
        L5:
            Logger.i("BatterySavingLocationCallback onSuccess");
            LocInfoRspData r8 = LocationUtil.parseLocInfoRsp(r5);
            BDLocation r0 = null;
            if (r8 == null) goto L10;
            Logger.i("ByteLocationManagerImpl BatterySavingLocationCallback inOutDoorStatus:" + r8.inOutDoorStatus);
            r0 = LocationUtil.locationResultToBDLocation(this.c, r8.location, r8.inOutDoorStatus, r8.inOutDoorConfidence);
            if (r0 == null) goto L10;
            r0.setLocInfoRsp(r8);
            r0.setRecommendWifiResults(r6);
            r0.setConnectedWifiInfo(r7);
        L10:
            Logger.i("ByteLocationManagerImpl: BatterySavingLocationCallback onSuccess.");
            b.a(this.f1034a).a(r0);
            a();
        }
    }

    private class c extends a {
        final /* synthetic */ b c;
        private ByteLocationClientOption d;

        public c(b r2, ByteLocationClientOption r3) {
            this.c = r2;
            super(r2, null);
            this.d = r3;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location r4) {
            Logger.i("ByteLocationManagerImpl: DeviceSensorsLocationListener onLocationChanged() and the location is " + r4);
            if (b.c(this.c) == null) goto L6;
            e.a(b.c(this.c));
        L6:
            if (Build.VERSION.SDK_INT >= 24) goto L8;
        L10:
            if (r4 == null) goto L12;
            BDLocation r5 = b.a(this.c, r4);
            b.a(this.c).a(r5);
            r5.setRecommendWifiResults(true);
            return;
        L12:
            b.a(this.c).a(new BDLocationException(BDLocationExceptionMessage.BYTE_DEVICE_LOCATION_NULL, this.c.a(), BDLocationException.ERROR_LOCATION_IS_NULL));
            return;
        L8:
            if (b.d(this.c) == null) goto L10;
            d.a(b.d(this.c));
            goto L10
        }
    }

    private class d extends GnssStatus.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f1036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CountDownTimer f1037b;
        private int c;
        private int d;
        private boolean e;

        public d(b r1, boolean r2) {
            this.f1036a = r1;
            this.e = r2;
        }

        private void a() {
            if (b.f(this.f1036a) == null) goto L5;
            long r0 = b.f(this.f1036a).h();
        L6:
            final long r4 = r0;
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener startCountDownTimer() is executed.");
            final long r6 = 1000;
            CountDownTimer r1 = new AnonymousClass1(this, r4, r6);
            this.f1037b = r1;
            r1.start();
            return;
        L5:
            r0 = 30000;
            goto L6
        }

        static /* synthetic */ void a(d r0) {
            r0.b();
        }

        static /* synthetic */ void a(d r0, String r1, String r2) {
            r0.a(r1, r2);
        }

        private void a(String r3, String r4) {
            b();
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener notifyLocationFailed() and the message is " + r3);
            b.a(this.f1036a).a(new BDLocationException(r3, this.f1036a.a(), r4));
            if (this.e == false) goto L6;
            this.f1036a.b();
            return;
        }

        static /* synthetic */ int b(d r0) {
            return r0.d;
        }

        private void b() {
            if (this.f1037b == null) goto L6;
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener stopCountDownTimer() is executed.");
            this.f1037b.cancel();
            return;
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus r5) {
            this.c = r5.getSatelliteCount();
            int r0 = 0;
            int r1 = 0;
        L4:
            if (r0 >= this.c) goto L9;
            if (r5.getCn0DbHz(r0) <= 25.0f) goto L8;
            r1 = r1 + 1;
        L8:
            r0 = r0 + 1;
            goto L4
        L9:
            this.d = r1;
            Logger.i("ByteLocationManagerImpl: LocationGnssStatusCallback onSatelliteStatusChanged()" + r1);
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            if (this.e == false) goto L6;
            a();
            return;
        }
    }

    private class e implements GpsStatus.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f1039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CountDownTimer f1040b;
        private int c;
        private int d;
        private boolean e;

        public e(b r1, boolean r2) {
            this.f1039a = r1;
            this.e = r2;
        }

        private void a() {
            if (b.f(this.f1039a) == null) goto L5;
            long r0 = b.f(this.f1039a).h();
        L6:
            final long r4 = r0;
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener startCountDownTimer() is executed.");
            final long r6 = 1000;
            CountDownTimer r1 = new AnonymousClass1(this, r4, r6);
            this.f1040b = r1;
            r1.start();
            return;
        L5:
            r0 = 30000;
            goto L6
        }

        static /* synthetic */ void a(e r0) {
            r0.b();
        }

        static /* synthetic */ void a(e r0, String r1, String r2) {
            r0.a(r1, r2);
        }

        private void a(String r3, String r4) {
            b();
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener notifyLocationFailed() and the message is " + r3);
            b.a(this.f1039a).a(new BDLocationException(r3, this.f1039a.a(), r4));
            if (this.e == false) goto L6;
            this.f1039a.b();
            return;
        }

        static /* synthetic */ int b(e r0) {
            return r0.d;
        }

        private void b() {
            if (this.f1040b == null) goto L6;
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener stopCountDownTimer() is executed.");
            this.f1040b.cancel();
            return;
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int r7) {
            LocationManager r0 = b.e(this.f1039a);
            if (r0 != null) goto L6;
            return;
        L6:
            if (r7 != 1) goto L8;
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener onLocationChanged() and receive GPS_EVENT_STARTED");
            if (this.e == false) goto L35;
            a();
            return;
        L35:
            return;
        L8:
            if (r7 != 2) goto L10;
            String r6 = "ByteLocationManagerImpl: LocationGpsStatusListener onLocationChanged() and receive GPS_EVENT_STOPPED";
        L25:
            Logger.i(r6);
            return;
        L10:
            if (r7 != 3) goto L12;
            r6 = "ByteLocationManagerImpl: LocationGpsStatusListener onLocationChanged() and receive GPS_EVENT_FIRST_FIX";
            goto L25
        L12:
            if (r7 != 4) goto L36;
            GpsStatus r8 = r0.getGpsStatus(null);
            int r1 = r8.getMaxSatellites();
            Iterator<GpsSatellite> r9 = r8.getSatellites().iterator();
            int r2 = 0;
            int r3 = 0;
        L16:
            if (r9.hasNext() == false) goto L22;
            if (r2 >= r1) goto L22;
            if (((GpsSatellite) ZeusTransformUtils.preCheckCast(r9.next(), GpsSatellite.class, "com.obric.memorydata.plugin")).getSnr() <= 25.0f) goto L21;
            r3 = r3 + 1;
        L21:
            r2 = r2 + 1;
        L22:
            this.c = Math.max(r2, this.c);
            this.d = r3;
            r6 = "ByteLocationManagerImpl: LocationGpsStatusListener onLocationChanged() and receive GPS_EVENT_SATELLITE_STATUS, satellite count:" + r2;
            goto L25
        }
    }

    public static class f extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<b> f1042a;

        public f(b r2) {
            super(Looper.getMainLooper());
            this.f1042a = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r5) {
            super.handleMessage(r5);
            b r0 = (b) ZeusTransformUtils.preCheckCast(this.f1042a.get(), b.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L6;
            Logger.i("ByteLocationManagerImpl: ByteLocationManagerImpl reference is null.");
            return;
        L6:
            int r1 = r5.what;
            if (r1 != 1) goto L9;
            removeMessages(1);
            b.a(r0, (ByteLocationClientOption) ZeusTransformUtils.preCheckCast(r5.obj, ByteLocationClientOption.class, "com.obric.memorydata.plugin"));
            return;
        L9:
            if (r1 != 2) goto L11;
            removeMessages(2);
            b.b(r0, (ByteLocationClientOption) ZeusTransformUtils.preCheckCast(r5.obj, ByteLocationClientOption.class, "com.obric.memorydata.plugin"));
            Logger.i("ByteLocationManagerImpl TimerHandler2");
            return;
        L11:
            if (r1 != 3) goto L19;
            removeMessages(3);
            r0.c();
            return;
        }
    }

    private class g implements LocationUploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f1043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ByteLocationClientOption f1044b;
        private long c;

        public g(b r3, ByteLocationClientOption r4) {
            this.f1043a = r3;
            this.c = 0;
            this.f1044b = r4;
            this.c = System.currentTimeMillis();
        }

        @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
        public void onError(String r4) {
            int r0 = this.f1044b.i();
            Logger.i("ByteLocationManagerImpl WifiCellLocationCallback onError status:" + r0 + "--errorMsg:" + r4);
            if (r0 != 3) goto L5;
        L8:
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onError! The status is：" + this.f1044b.k() + "--the message is：" + r4);
            b.a(this.f1043a).a(new BDLocationException(r4, this.f1043a.a(), BDLocationException.ERROR_NETWORK_REQUEST));
            b.c(this.f1043a, this.f1044b);
            return;
        L5:
            if (r0 == 1) goto L8;
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onError! The status is %s ", this.f1044b.k());
        }

        @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
        public void onSuccess(LocationResp r7, boolean r8, WifiInfo r9) {
            if (r7 != null) goto L6;
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onError");
            b.a(this.f1043a).a(new BDLocationException("analysis locInfoRsp error:resp is null", this.f1043a.a(), BDLocationException.ERROR_NETWORK_REQUEST));
            return;
        L6:
            Logger.i("ByteLocationManagerImpl getLocation intervalTime:" + (System.currentTimeMillis() - this.c));
            int r1 = this.f1044b.i();
            Logger.i("ByteLocationManagerImpl WifiCellLocationCallback onSuccess:" + r1);
            if (r1 != 3) goto L9;
        L14:
            this.f1044b.c(6);
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onSuccess. The status is %s ", this.f1044b.k());
            LocInfoRspData r2 = LocationUtil.parseLocInfoRsp(r7);
            BDLocation r3 = null;
            if (r2 == null) goto L19;
            Logger.i("ByteLocationManagerImpl WifiCellLocationCallback inOutDoorStatus:" + r2.inOutDoorStatus);
            r3 = LocationUtil.locationResultToBDLocation(new BDLocation("network", this.f1043a.a()), r2.location, r2.inOutDoorStatus, r2.inOutDoorConfidence);
            if (r3 == null) goto L19;
            r3.setLocInfoRsp(r2);
            r3.setRecommendWifiResults(r8);
            r3.setConnectedWifiInfo(r9);
        L19:
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onSuccess.");
            if (r3 == null) goto L22;
            b.a(this.f1043a).a(r3);
        L23:
            b.c(this.f1043a, this.f1044b);
            return;
        L22:
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onError:" + r7.toString());
            b.a(this.f1043a).a(new BDLocationException("analysis locInfoRsp error:" + r7.toString(), this.f1043a.a(), BDLocationException.ERROR_NETWORK_REQUEST));
            goto L23
        L9:
            if (r1 == 1) goto L14;
            if (r1 == 2) goto L14;
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onSuccess. The status is %s ", this.f1044b.k());
        }
    }

    public b(Context r3) {
        this.f1029a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f1030b = new com.bytedance.api.location.a.a(AppExecutors.getInstance());
        this.c = (LocationManager) ZeusTransformUtils.preCheckCast(this.f1029a.getSystemService("location"), LocationManager.class, "com.obric.memorydata.plugin");
        this.d = new f(this);
    }

    static /* synthetic */ com.bytedance.api.location.a.a a(b r0) {
        return r0.f1030b;
    }

    private BDLocation a(Location r3) {
        if (r3 == null) goto L5;
        BDLocation r0 = new BDLocation(r3, a());
        int r4 = 1;
    L6:
        r0.setLocationType(r4);
        r0.setGeocodeSDKName(a());
        Logger.i("ByteLocationManagerImpl: transform() is executed and the result is " + r0);
        return r0;
    L5:
        r0 = new BDLocation("network", a());
        r4 = 2;
        goto L6
    }

    static /* synthetic */ BDLocation a(b r0, Location r1) {
        return r0.a(r1);
    }

    private void a(ByteLocationClientOption r3, LocationUploadCallback r4) {
        LocationUploadCallback r2 = (LocationUploadCallback) ZeusTransformUtils.wrapperContextForParams(r4, LocationUploadCallback.class, "com.obric.memorydata.plugin");
        Logger.i("ByteLocationManagerImpl: doLocationUpload() is executed.");
        LocationUploadExtra r5 = new LocationUploadExtra();
        r5.locationOption = r3.f1012a;
        r5.setUploadInterval(r3.e());
        r5.setUploadSource(r3.f());
        r5.setTriggerType(r3.g());
        r5.setStartLocationTime(r3.m());
        if (r3.n() == null) goto L5;
        r5.setLogIdCache(r3.n().getLogIdCacheEntity());
        r5.setBleList(r3.n().getBleInfoList());
    L5:
        r5.setLatestAdminVersion(r3.l());
        r5.setBpeaCert(r3.b());
        r5.setExtra(r3.o());
        r5.setLocationTraceLogger(r3.p());
        r5.setLocateId(r3.q());
        r5.setLocationExtraDataServer(r3.r());
        LocationUtil.startGetLocate(r5, r2);
    }

    static /* synthetic */ void a(b r0, ByteLocationClientOption r1) {
        r0.b(r1);
    }

    private boolean a(Context r2, ByteLocationClientOption.LocationMode r3) {
        if (LocationUtil.isEnableLocationService((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return false;
    L5:
        int r1 = AnonymousClass1.f1031a[r3.ordinal()];
        if (r1 == 1) goto L14;
        if (r1 != 2) goto L10;
    L12:
        return true;
    L10:
        if (r1 == 3) goto L12;
        return false;
    L14:
        if (Build.VERSION.SDK_INT >= 26) goto L16;
        return false;
    L16:
        return true;
    }

    static /* synthetic */ f b(b r0) {
        return r0.d;
    }

    private void b(ByteLocationClientOption r3) {
        Logger.i("ByteLocationManagerImpl: startLocationInternalForBatterySaving() is executed.");
        r3.c(1);
        a(r3, new C0078b(this, r3, a(null)));
    }

    static /* synthetic */ void b(b r0, ByteLocationClientOption r1) {
        r0.d(r1);
    }

    static /* synthetic */ e c(b r0) {
        return r0.g;
    }

    private void c(ByteLocationClientOption r10) {
        if (PermissionManager.hasAnyPermission(this.f1029a, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L8;
        Logger.i("ByteLocationManagerImpl: startLocationInternalForDeviceSensors() but has no location permission!");
        BDLocationException r11 = new BDLocationException("No Location Permission", a(), BDLocationException.ERROR_SDK_NO_PERMISSION);
    L5:
        this.f1030b.a(r11);
        return;
    L8:
        if (LocationUtil.isGpsProviderEnabled(this.f1029a) == true) goto L10;
        Logger.i("ByteLocationManagerImpl: startLocationInternalForDeviceSensors() but need GPS location service!");
        r11 = new BDLocationException("定位服务没有开启，请在设置中打开定位服务开关", a(), BDLocationException.ERROR_DEVICE_LOCATION_DISABLE);
        goto L5
    L10:
        r10.c(2);
        this.c = (LocationManager) ZeusTransformUtils.preCheckCast(this.f1029a.getSystemService("location"), LocationManager.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 24) goto L13;
        this.h = new d(this, r10.j());
        BDLocationExtrasService.getBPEAManager().registerGnssStatusCallback(this.c, this.h, r10.b());
    L14:
        this.f = new c(this, r10);
        if (PermissionManager.hasAnyPermission(this.f1029a, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == false) goto L29;
        Logger.i("ByteLocationManagerImpl: startLocationInternalForDeviceSensors() is executed.");
    L22:
        e = move-exception;
        Logger.i("ByteLocationManagerImpl startLocationInternalForDeviceSensors requestUpdate exception" + e.toString() + r10.j());
        return;
    L18:
        if (r10.j() == false) goto L20;
        BDLocationExtrasService.getBPEAManager().requestSingleUpdate(this.c, "gps", this.f, null, r10.b());     // Catch: Exception -> L22
    L25:
        return;
    L20:
        BDLocationExtrasService.getBPEAManager().requestLocationUpdates(this.c, "gps", Math.max(r10.a(), 1000), 0.0f, this.f, null, r10.b());     // Catch: Exception -> L22
        goto L25
    L29:
        return;
    L13:
        this.g = new e(this, r10.j());
        BDLocationExtrasService.getBPEAManager().addGpsStatusListener(this.c, this.g, r10.b());
        goto L14
    }

    static /* synthetic */ void c(b r0, ByteLocationClientOption r1) {
        r0.e(r1);
    }

    static /* synthetic */ d d(b r0) {
        return r0.h;
    }

    private void d(ByteLocationClientOption r2) {
        r2.c(1);
        a(r2, new g(this, r2));
    }

    static /* synthetic */ LocationManager e(b r0) {
        return r0.c;
    }

    private void e(ByteLocationClientOption r4) {
        if (r4.j() == true) goto L6;
        this.d.sendMessageDelayed(Message.obtain(this.d, 2, r4), r4.a());
        Logger.i("ByteLocationManagerImpl performNextLocationIfNecessary2 interval:" + r4.a());
        return;
    }

    static /* synthetic */ ByteLocationClientOption f(b r0) {
        return r0.e;
    }

    public String a() {
        return LocationInfoConst.BYTE;
    }

    @Override // com.bytedance.api.location.a.c
    public void a(ByteLocationClientOption r4) {
        if (PermissionManager.hasLocationPermissions(this.f1029a) == true) goto L8;
        Logger.i("ByteLocationManagerImpl: startLocation() but has no location permission!");
        BDLocationException r5 = new BDLocationException("No Location Permission", a(), BDLocationException.ERROR_SDK_NO_PERMISSION);
    L5:
        this.f1030b.a(r5);
        return;
    L8:
        if (a(this.f1029a, r4.c()) == false) goto L10;
        Logger.i("ByteLocationManagerImpl: startLocation() but need GPS location service!");
        r5 = new BDLocationException("定位服务没有开启，请在设置中打开定位服务开关", a(), BDLocationException.ERROR_DEVICE_LOCATION_DISABLE);
        goto L5
    L10:
        if (r4 != null) goto L12;
        Logger.i("ByteLocationManagerImpl: startLocation() but option is null!");
        r5 = new BDLocationException("option is null", a(), BDLocationException.ERROR_BYTE_OPTION_NULL);
        goto L5
    L12:
        this.e = r4;
        Logger.i("ByteLocationManagerImpl: startLocation() and locationMode:" + r4.c() + "geocodeMode:" + r4.d() + "intervalMs:" + r4.a());
        int r0 = AnonymousClass1.f1031a[r4.c().ordinal()];
        if (r0 != 1) goto L15;
        b(r4);
        return;
    L15:
        if (r0 != 2) goto L17;
        c(r4);
        return;
    L17:
        if (r0 != 3) goto L25;
        d(r4);
        return;
    }

    @Override // com.bytedance.api.location.a.c
    public void a(com.bytedance.api.location.b r3) {
        com.bytedance.api.location.b r4 = (com.bytedance.api.location.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.api.location.b.class, "com.obric.memorydata.plugin");
        this.f1030b.a(r4);
    }

    public void b() {
        Logger.i("ByteLocationManagerImpl: stopLocation() is executed.");     // Catch: Exception -> L6
        this.d.removeCallbacksAndMessages(null);     // Catch: Exception -> L6
        if (this.e == null) goto L11;
        c();     // Catch: Exception -> L6
        this.e.c(6);     // Catch: Exception -> L6
        this.e = null;     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Logger.i("ByteLocationManagerImpl: stopLocation() throw an exception! The message is " + e.getMessage());
    }

    @Override // com.bytedance.api.location.a.c
    public void b(com.bytedance.api.location.b r3) {
        com.bytedance.api.location.b r4 = (com.bytedance.api.location.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.api.location.b.class, "com.obric.memorydata.plugin");
        this.f1030b.b(r4);
    }

    public void c() {
        LocationManager r0 = this.c;
        if (r0 == null) goto L21;
        LocationListener r1 = this.f;     // Catch: Exception -> L16
        if (r1 == null) goto L7;
        r0.removeUpdates(r1);     // Catch: Exception -> L16
        this.f = null;     // Catch: Exception -> L16
    L7:
        e r2 = this.g;     // Catch: Exception -> L16
        if (r2 == null) goto L11;
        this.c.removeGpsStatusListener(r2);     // Catch: Exception -> L16
        this.g = null;     // Catch: Exception -> L16
    L11:
        if (Build.VERSION.SDK_INT < 24) goto L22;
        d r3 = this.h;     // Catch: Exception -> L16
        if (r3 == null) goto L23;
        this.c.unregisterGnssStatusCallback(r3);     // Catch: Exception -> L16
        this.h = null;     // Catch: Exception -> L16
        return;
    L23:
        return;
    L22:
        return;
    L16:
        e = move-exception;
        Logger.i("ByteLocationManagerImpl: removeGPSLocationListener() throw an exception! The message is " + e.getMessage());
        return;
    }

    @Override // com.bytedance.api.location.a.c
    public void d() {
        b();
        this.f1030b.a();
    }
}
