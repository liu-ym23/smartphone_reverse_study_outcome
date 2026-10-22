package a2;

import android.content.Context;
import android.location.GnssStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.LocationUploadCallback;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.entity.LocationExtraBean;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.bytedance.bdlocation.network.response.LocationResp;
import com.bytedance.bdlocation.thread.AppExecutors;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f29a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a2.a f30b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LocationManager f31c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f32d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile z1.b f33e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f34f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f35g;

    public abstract class a implements LocationListener {
        @Override // android.location.LocationListener
        public final void onProviderDisabled(String r8) {
            Logger.i("ByteLocationManagerImpl: BaseLocationListener onProviderDisabled() provider is " + r8);
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String r8) {
            Logger.i("ByteLocationManagerImpl: BaseLocationListener onProviderEnabled() provider is " + r8);
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String r8, int r10, Bundle r11) {
            Logger.i("ByteLocationManagerImpl: BaseLocationListener onStatusChanged() status is " + r10);
        }
    }

    /* JADX INFO: renamed from: a2.b$b, reason: collision with other inner class name */
    public class C0002b implements LocationUploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z1.b f36a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BDLocation f37b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f38c;

        public C0002b(b r8, z1.b r10, BDLocation r11) {
            this.f38c = r8;
            this.f36a = r10;
            this.f37b = r11;
        }

        @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
        public final void onError(String r8) {
            Logger.i("ByteLocationManagerImpl: BatterySavingLocationCallback onError! The message is " + r8);
            b r10 = this.f38c;
            r10.getClass();
            r10.f30b.d(new BDLocationException(r8, LocationInfoConst.BYTE, BDLocationException.ERROR_NETWORK_REQUEST));
        }

        @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
        public final void onSuccess(LocationResp r8, boolean r10, WifiInfo r11) {
            b r12 = this.f38c;
            if (r8 != null) goto L6;
            Logger.i("ByteLocationManagerImpl: BatterySavingLocationCallback onError");
            r12.getClass();
            r12.f30b.d(new BDLocationException("analysis locInfoRsp error:resp is null", LocationInfoConst.BYTE, BDLocationException.ERROR_NETWORK_REQUEST));
            return;
        L6:
            Logger.i("BatterySavingLocationCallback onSuccess");
            LocInfoRspData r13 = LocationUtil.parseLocInfoRsp(r8);
            if (r13 == null) goto L11;
            Logger.i("ByteLocationManagerImpl BatterySavingLocationCallback inOutDoorStatus:" + r13.inOutDoorStatus);
            BDLocation r14 = LocationUtil.locationResultToBDLocation(this.f37b, r13.location, r13.inOutDoorStatus, r13.inOutDoorConfidence);
            if (r14 == null) goto L12;
            r14.setLocInfoRsp(r13);
            r14.setRecommendWifiResults(r10);
            r14.setConnectedWifiInfo(r11);
        L12:
            Logger.i("ByteLocationManagerImpl: BatterySavingLocationCallback onSuccess.");
            r12.f30b.c(r14);
            z1.b r15 = this.f36a;
            if (r15.f14185l == true) goto L16;
            Logger.i("ByteLocationManagerImpl: BatterySavingLocationCallback is continuous location. The interval is " + r15.f14174a);
            r12.f32d.sendMessageDelayed(Message.obtain(r12.f32d, 1, r15), r15.f14174a);
            Logger.i("performNextLocationIfNecessary interval:" + r15.f14174a);
            return;
        L16:
            return;
        L11:
            r14 = null;
            goto L12
        }
    }

    public class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f39a;

        public c(b r8) {
            this.f39a = r8;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location r8) {
            Logger.i("ByteLocationManagerImpl: DeviceSensorsLocationListener onLocationChanged() and the location is " + r8);
            b r10 = this.f39a;
            r10.getClass();
            d r11 = r10.f35g;
            if (r11 == null) goto L7;
            int r12 = d.f40f;
            if (r11.f41a == null) goto L7;
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener stopCountDownTimer() is executed.");
            r11.f41a.cancel();
        L7:
            a2.a r13 = r10.f30b;
            if (r8 == null) goto L10;
            BDLocation r14 = b.e(r8);
            r13.c(r14);
            r14.setRecommendWifiResults(true);
            return;
        L10:
            r13.d(new BDLocationException(BDLocationExceptionMessage.BYTE_DEVICE_LOCATION_NULL, LocationInfoConst.BYTE, BDLocationException.ERROR_LOCATION_IS_NULL));
        }
    }

    public class d extends GnssStatus.Callback {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int f40f = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a2.c f41a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f42b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f43c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f44d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ b f45e;

        public d(b r8, boolean r10) {
            this.f45e = r8;
            this.f44d = r10;
        }

        @Override // android.location.GnssStatus.Callback
        public final void onSatelliteStatusChanged(GnssStatus r8) {
            this.f42b = r8.getSatelliteCount();
            int r10 = 0;
            int r11 = 0;
        L4:
            if (r10 >= this.f42b) goto L9;
            if (r8.getCn0DbHz(r10) <= 25.0f) goto L8;
            r11 = r11 + 1;
        L8:
            r10 = r10 + 1;
            goto L4
        L9:
            this.f43c = r11;
            Logger.i("ByteLocationManagerImpl: LocationGnssStatusCallback onSatelliteStatusChanged()" + r11);
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStarted() {
            if (this.f44d == true) goto L5;
            return;
        L5:
            if (this.f45e.f33e == null) goto L7;
            long r8 = this.f45e.f33e.f14179f;
        L8:
            Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener startCountDownTimer() is executed.");
            a2.c r10 = new a2.c(this, r8);
            this.f41a = r10;
            r10.start();
            return;
        L7:
            r8 = 30000;
            goto L8
        }
    }

    public static class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<b> f46a;

        public e(b r8) {
            super(Looper.getMainLooper());
            this.f46a = new WeakReference(r8);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r8) {
            super.handleMessage(r8);
            b r10 = this.f46a.get();
            if (r10 != null) goto L6;
            Logger.i("ByteLocationManagerImpl: ByteLocationManagerImpl reference is null.");
            return;
        L6:
            int r11 = r8.what;
            if (r11 != 1) goto L9;
            removeMessages(1);
            z1.b r12 = (z1.b) r8.obj;
            Logger.i("ByteLocationManagerImpl: startLocationInternalForBatterySaving() is executed.");
            r12.f14176c = 1;
            b.b(r12, new C0002b(r10, r12, b.e(null)));
            return;
        L9:
            if (r11 != 2) goto L11;
            removeMessages(2);
            z1.b r13 = (z1.b) r8.obj;
            r13.f14176c = 1;
            b.b(r13, new f(r10, r13));
            Logger.i("ByteLocationManagerImpl TimerHandler2");
            return;
        L11:
            if (r11 != 3) goto L19;
            removeMessages(3);
            r10.c();
            return;
        }
    }

    public class f implements LocationUploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z1.b f47a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f48b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f49c;

        public f(b r8, z1.b r10) {
            this.f49c = r8;
            this.f48b = 0;
            this.f47a = r10;
            this.f48b = System.currentTimeMillis();
        }

        @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
        public final void onError(String r8) {
            int r10 = this.f47a.f14176c;
            Logger.i("ByteLocationManagerImpl WifiCellLocationCallback onError status:" + r10 + "--errorMsg:" + r8);
            if (r10 != 3) goto L5;
        L8:
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onError! The status is：" + this.f47a.a() + "--the message is：" + r8);
            this.f49c.getClass();
            this.f49c.f30b.d(new BDLocationException(r8, LocationInfoConst.BYTE, BDLocationException.ERROR_NETWORK_REQUEST));
            b.a(this.f49c, this.f47a);
            return;
        L5:
            if (r10 == 1) goto L8;
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onError! The status is %s ", this.f47a.a());
        }

        @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
        public final void onSuccess(LocationResp r8, boolean r10, WifiInfo r11) {
            if (r8 != null) goto L6;
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onError");
            this.f49c.getClass();
            this.f49c.f30b.d(new BDLocationException("analysis locInfoRsp error:resp is null", LocationInfoConst.BYTE, BDLocationException.ERROR_NETWORK_REQUEST));
            return;
        L6:
            Logger.i("ByteLocationManagerImpl getLocation intervalTime:" + (System.currentTimeMillis() - this.f48b));
            int r12 = this.f47a.f14176c;
            Logger.i("ByteLocationManagerImpl WifiCellLocationCallback onSuccess:" + r12);
            if (r12 != 3) goto L9;
        L14:
            this.f47a.f14176c = 6;
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onSuccess. The status is %s ", this.f47a.a());
            LocInfoRspData r13 = LocationUtil.parseLocInfoRsp(r8);
            if (r13 == null) goto L19;
            Logger.i("ByteLocationManagerImpl WifiCellLocationCallback inOutDoorStatus:" + r13.inOutDoorStatus);
            this.f49c.getClass();
            BDLocation r14 = LocationUtil.locationResultToBDLocation(new BDLocation("network", LocationInfoConst.BYTE), r13.location, r13.inOutDoorStatus, r13.inOutDoorConfidence);
            if (r14 == null) goto L20;
            r14.setLocInfoRsp(r13);
            r14.setRecommendWifiResults(r10);
            r14.setConnectedWifiInfo(r11);
        L20:
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onSuccess.");
            if (r14 == null) goto L23;
            this.f49c.f30b.c(r14);
        L24:
            b.a(this.f49c, this.f47a);
            return;
        L23:
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onError:" + r8.toString());
            String r15 = "analysis locInfoRsp error:" + r8.toString();
            this.f49c.getClass();
            this.f49c.f30b.d(new BDLocationException(r15, LocationInfoConst.BYTE, BDLocationException.ERROR_NETWORK_REQUEST));
            goto L24
        L19:
            r14 = null;
            goto L20
        L9:
            if (r12 == 1) goto L14;
            if (r12 == 2) goto L14;
            Logger.i("ByteLocationManagerImpl: WifiCellLocationCallback onSuccess. The status is %s ", this.f47a.a());
        }
    }

    public b(Context r8) {
        this.f29a = r8;
        this.f30b = new a2.a(AppExecutors.getInstance());
        this.f31c = (LocationManager) r8.getSystemService(LocationMonitorConst.LOCATION);
        this.f32d = new e(this);
    }

    public static void a(b r8, z1.b r10) {
        r8.getClass();
        if (r10.f14185l == true) goto L6;
        e r11 = r8.f32d;
        r11.sendMessageDelayed(Message.obtain(r11, 2, r10), r10.f14174a);
        Logger.i("ByteLocationManagerImpl performNextLocationIfNecessary2 interval:" + r10.f14174a);
        return;
    }

    public static void b(z1.b r8, LocationUploadCallback r10) {
        Logger.i("ByteLocationManagerImpl: doLocationUpload() is executed.");
        LocationUploadExtra r11 = new LocationUploadExtra();
        r11.locationOption = r8.f14175b;
        r11.setUploadInterval(r8.f14180g);
        r11.setUploadSource(r8.f14181h);
        r11.setTriggerType(r8.f14184k);
        r11.setStartLocationTime(r8.f14188o);
        LocationExtraBean r12 = r8.f14182i;
        if (r12 == null) goto L5;
        r11.setLogIdCache(r12.getLogIdCacheEntity());
        r11.setBleList(r8.f14182i.getBleInfoList());
    L5:
        r11.setLatestAdminVersion(r8.f14186m);
        r11.setBpeaCert(r8.f14187n);
        r11.setExtra(r8.f14183j);
        r11.setLocationTraceLogger(r8.f14189p);
        r11.setLocateId(r8.f14190q);
        r11.setLocationExtraDataServer(r8.f14191r);
        LocationUtil.startGetLocate(r11, r10);
    }

    public static BDLocation e(Location r8) {
        if (r8 == null) goto L5;
        BDLocation r10 = new BDLocation(r8, LocationInfoConst.BYTE);
        int r11 = 1;
    L6:
        r10.setLocationType(r11);
        r10.setGeocodeSDKName(LocationInfoConst.BYTE);
        Logger.i("ByteLocationManagerImpl: transform() is executed and the result is " + r10);
        return r10;
    L5:
        r10 = new BDLocation("network", LocationInfoConst.BYTE);
        r11 = 2;
        goto L6
    }

    public final void c() {
        LocationManager r8 = this.f31c;
        if (r8 == null) goto L16;
        c r10 = this.f34f;     // Catch: Exception -> L11
        if (r10 == null) goto L7;
        r8.removeUpdates(r10);     // Catch: Exception -> L11
        this.f34f = null;     // Catch: Exception -> L11
    L7:
        d r11 = this.f35g;     // Catch: Exception -> L11
        if (r11 == null) goto L17;
        this.f31c.unregisterGnssStatusCallback(r11);     // Catch: Exception -> L11
        this.f35g = null;     // Catch: Exception -> L11
        return;
    L17:
        return;
    L11:
        e = move-exception;
        Logger.i("ByteLocationManagerImpl: removeGPSLocationListener() throw an exception! The message is " + e.getMessage());
        return;
    }

    public final void d() {
        Logger.i("ByteLocationManagerImpl: stopLocation() is executed.");     // Catch: Exception -> L6
        this.f32d.removeCallbacksAndMessages(null);     // Catch: Exception -> L6
        if (this.f33e == null) goto L11;
        c();     // Catch: Exception -> L6
        this.f33e.f14176c = 6;     // Catch: Exception -> L6
        this.f33e = null;     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Logger.i("ByteLocationManagerImpl: stopLocation() throw an exception! The message is " + e.getMessage());
    }
}
