package com.obric.cae.location.util;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.location.Address;
import android.location.Geocoder;
import android.location.GnssStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crypto.bridge.IEnvBridge;
import com.bytedance.crypto.cloudtrans.CloudTransCryptoManager;
import com.bytedance.privacy.PrivacySdk;
import com.bytedance.privacy.attestation.AttestationConfig;
import com.bytedance.privacy.exception.BdPrivacyException;
import com.google.android.material.timepicker.TimeModel;
import com.obric.cae.libs.location.CoordinateTransformUtils;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.location.geofence.StarGeofenceManager;
import com.obric.cae.location.warm.StarWarmModeManager;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.LocationAwareInfoManager;
import com.obric.cae.userAware.UserAwareManager;
import com.obric.cae.userAware.utils.MatrixDidUtils;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7298a = "star_location_sp";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f7299b = "";
    public static volatile d c;
    public static final Object d = null;
    public static final long e = 0;
    public static final long f = 0;
    public static final long g = 0;
    public static final long h = 0;
    public static final long i = 0;
    public static volatile boolean j;
    public static volatile boolean k;
    public static final AtomicReference<CountDownLatch> l = null;
    public static final Object m = null;
    public final AtomicBoolean A;
    public final AtomicBoolean B;
    public final AtomicBoolean C;
    public final AtomicBoolean D;
    public final AtomicInteger E;
    public final AtomicInteger F;
    public final AtomicBoolean G;
    public final AtomicBoolean H;
    public final AtomicBoolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final AtomicBoolean f7300J;
    public final AtomicBoolean K;
    public final AtomicBoolean L;
    public volatile long M;
    public volatile boolean N;
    public volatile String O;
    public volatile long P;
    public final Object Q;
    public final AtomicReference<Location> R;
    public final AtomicLong S;
    public final AtomicLong T;
    public final AtomicBoolean U;
    public final AtomicReference<Location> V;
    public final Object W;
    public HandlerThread X;
    public final AtomicBoolean Y;
    public final AtomicInteger Z;
    public final AtomicInteger aa;
    public final AtomicInteger ab;
    public final Object ac;
    public final AtomicBoolean ad;
    public final AtomicInteger ae;
    public final AtomicInteger af;
    public final e ag;
    public final f ah;
    public final g ai;
    public final h aj;
    public final i ak;
    public final j al;
    public final C0362d am;
    public boolean n;
    public Context o;
    public LocationManager p;
    public ConnectivityManager q;
    public TelephonyManager r;
    public WifiManager s;
    public final AtomicReference<Location> t;
    public final AtomicReference<List<Address>> u;
    public final AtomicReference<Location> v;
    public final AtomicReference<CountDownLatch> w;
    public StarWarmModeManager x;
    public final ConcurrentHashMap y;
    public final ExecutorService z;

    public class a implements com.bytedance.privacy.a.b {
        public a() {
        }

        @Override // com.bytedance.privacy.a.b
        public final boolean a() {
            return false;
        }
    }

    public class b implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f7301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7302b;
        public final /* synthetic */ AtomicReference c;
        public final /* synthetic */ CountDownLatch d;
        public final /* synthetic */ d e;

        public b(d r1, AtomicBoolean r2, String r3, AtomicReference r4, CountDownLatch r5) {
            this.e = r1;
            this.f7301a = r2;
            this.f7302b = r3;
            this.c = r4;
            this.d = r5;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location r5) {
            if (this.f7301a.compareAndSet(false, true) == true) goto L14;
            return;
        L14:
            com.obric.cae.log.a.e("StarLocation-util", "requestSingleUpdate success: " + this.f7302b);     // Catch: Throwable -> L11
            if (this.e.U.get() == false) goto L8;
            this.e.V.set(new Location(r5));     // Catch: Throwable -> L11
        L8:
            this.e.a(4, r5);     // Catch: Throwable -> L11
            this.c.set(r5);     // Catch: Throwable -> L11
            this.d.countDown();
            return;
        L11:
            th = move-exception;
            this.d.countDown();
            throw th;
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String r5) {
            if (this.f7301a.compareAndSet(false, true) == true) goto L11;
            return;
        L11:
            com.obric.cae.log.a.i("StarLocation-util", "requestSingleUpdate provider disabled: " + r5 + ", source: " + this.f7302b);     // Catch: Throwable -> L8
            this.e.V.set(null);     // Catch: Throwable -> L8
            this.e.U.set(false);     // Catch: Throwable -> L8
            this.e.b(this.f7302b, this);     // Catch: Throwable -> L8
            this.d.countDown();
            return;
        L8:
            th = move-exception;
            this.d.countDown();
            throw th;
        }
    }

    public class c implements Geocoder.GeocodeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f7303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f7304b;
        public final /* synthetic */ d c;

        public c(d r1, AtomicReference r2, CountDownLatch r3) {
            this.c = r1;
            this.f7303a = r2;
            this.f7304b = r3;
        }

        @Override // android.location.Geocoder.GeocodeListener
        public final void onError(String r3) {
            com.obric.cae.log.a.j("StarLocation-util", "error: " + r3);
            this.f7304b.countDown();
        }

        @Override // android.location.Geocoder.GeocodeListener
        public final void onGeocode(List<Address> r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            Iterator r0 = r6.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            com.obric.cae.log.a.d("StarLocation-util", ((Address) ZeusTransformUtils.preCheckCast(r0.next(), Address.class, "com.obric.memorydata.plugin")).toString());
            goto L4
        L6:
            this.c.u.set(Collections.unmodifiableList(r6));
            this.f7303a.set(r6);
            this.f7304b.countDown();
        }
    }

    /* JADX INFO: renamed from: com.obric.cae.location.util.d$d, reason: collision with other inner class name */
    public class C0362d extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f7305a;

        public C0362d(d r1) {
            this.f7305a = r1;
        }

        public final void onReceive(Context r3, Intent r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L5;
            return;
        L5:
            String r6 = r4.getAction();
            if (r6 != null) goto L8;
            return;
        L8:
            com.obric.cae.log.a.a("StarLocation-util", "Received action: ".concat(r6));
            if ("android.net.wifi.SCAN_RESULTS".equals(r6) == true) goto L11;
            return;
        L11:
            if (this.f7305a.o.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) goto L17;
            if (this.f7305a.o.checkSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) goto L17;
            com.obric.cae.log.a.i("StarLocation-util", "missing permissions to get scan results");
            return;
        L17:
            if (r4.getBooleanExtra("resultsUpdated", false) == true) goto L20;
            com.obric.cae.log.a.a("StarLocation-util", "scan result no update");
            return;
        L20:
            List<ScanResult> r7 = this.f7305a.s.getScanResults();
            this.f7305a.getClass();
            d.a(r7);
        }
    }

    public class e implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f7306a;

        public e(d r1) {
            this.f7306a = r1;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location r4) {
            if (this.f7306a.U.get() == true) goto L5;
        L10:
            this.f7306a.a(1, r4);
            return;
        L5:
            if (r4.equals(this.f7306a.V.get()) == false) goto L10;
            if (this.f7306a.U.compareAndSet(true, false) == false) goto L10;
            this.f7306a.V.set(null);
            com.obric.cae.log.a.d("StarLocation-util", "skip same single request location");
        }
    }

    public class f extends GnssStatus.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f7307a;

        public f(d r1) {
            this.f7307a = r1;
        }

        @Override // android.location.GnssStatus.Callback
        public final void onSatelliteStatusChanged(GnssStatus r3) {
            com.obric.cae.log.a.b("StarLocation-util", "");
            LocationAwareInfoManager.getInstance(this.f7307a.o).handleGnssSvUpdate(r3);
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStarted() {
            com.obric.cae.log.a.c("StarLocation-util", "Gnss Engine onStarted");
            this.f7307a.Y.set(true);
            com.obric.cae.location.a.a().a(true);
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStopped() {
            com.obric.cae.log.a.c("StarLocation-util", "Gnss Engine onStopped");
            this.f7307a.Y.set(false);
            com.obric.cae.location.a.a().a(false);
        }
    }

    public class g extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f7308a;

        public g(d r1) {
            this.f7308a = r1;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network r1) {
            d r0 = this.f7308a;
            String r2 = d.f7298a;
            r0.c(r0.w());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onCapabilitiesChanged(Network r5, NetworkCapabilities r6) {
            super.onCapabilitiesChanged(r5, r6);
            d r7 = this.f7308a;
            String r8 = d.f7298a;
            boolean r9 = r7.w();
            this.f7308a.c(r9);
            if (this.f7308a.F.get() == this.f7308a.E.get()) goto L13;
            int r10 = this.f7308a.E.get();
            d r0 = this.f7308a;
            r0.E.set(r0.F.get());
            d r1 = this.f7308a;
            if ((r1.F.get() & 2) != 2) goto L7;
            boolean r2 = true;
        L8:
            d.a(r1, r2);
            if (r9 == false) goto L14;
            if (r10 <= 0) goto L15;
            this.f7308a.b("network", true, "Network Transport Changed");
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r2 = false;
            goto L8
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network r2) {
            this.f7308a.E.set(-1);
            this.f7308a.c(false);
            d.a(this.f7308a, false);
        }
    }

    public class h extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f7309a;

        public h(d r1) {
            this.f7309a = r1;
        }

        private /* synthetic */ void a(Intent r8, Context r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
            String r0 = r8.getAction();
            boolean r3 = true;
            if ("android.intent.action.SCREEN_ON".equals(r0) == false) goto L7;
            this.f7309a.B.set(true);
            com.obric.cae.log.a.c("StarLocation-util", "screen on", com.obric.cae.log.a.b("geofence"));
            return;
        L7:
            if ("android.intent.action.SCREEN_OFF".equals(r0) == false) goto L11;
            this.f7309a.B.set(false);
            com.obric.cae.log.a.c("StarLocation-util", "screen off", com.obric.cae.log.a.b("geofence"));
            return;
        L11:
            if ("android.os.action.DEVICE_IDLE_MODE_CHANGED".equals(r0) == false) goto L20;
            PowerManager r11 = (PowerManager) ZeusTransformUtils.preCheckCast(r10.getSystemService("power"), PowerManager.class, "com.obric.memorydata.plugin");
            AtomicBoolean r12 = this.f7309a.C;
            if (r11 != null) goto L15;
        L17:
            r3 = false;
        L18:
            r12.set(r3);
            com.obric.cae.log.a.c("StarLocation-util", "deep doze changed: " + this.f7309a.C.get(), com.obric.cae.log.a.b("geofence"));
            return;
        L15:
            if (r11.isDeviceIdleMode() == false) goto L17;
        L20:
            int r13 = r8.getIntExtra("android.intent.extra.user_handle", 0);
            if ("android.intent.action.USER_SWITCHED".equals(r0) == false) goto L24;
            com.obric.cae.log.a.c("StarLocation-util", "user switched: " + r13, com.obric.cae.log.a.b("geofence"));
            d r7 = this.f7309a;
            String r14 = d.f7298a;
            r7.a(true, r13, "user_switched");
            return;
        L24:
            if ("android.intent.action.USER_UNLOCKED".equals(r0) == false) goto L28;
            d r15 = this.f7309a;
            String r16 = d.f7298a;
            r15.a(false, r13, "user_unlocked");
            return;
        }

        public static /* synthetic */ void lambda$Twd6PlCzh0lsci2PUKGl6W64H2c(h r0, Intent r1, Context r2) {
            r0.a(r1, r2);
        }

        public final void onReceive(Context r3, final Intent r4) {
            final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.getAction() == null) goto L10;
            this.f7309a.r().execute(new $$Lambda$d$h$Twd6PlCzh0lsci2PUKGl6W64H2c(this, r4, r5));
            return;
        }
    }

    public class i extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f7310a;

        public i(d r1) {
            this.f7310a = r1;
            super(null);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r1, Uri r2) {
            d r0 = this.f7310a;
            String r3 = d.f7298a;
            r0.a(r2);
        }
    }

    public class j extends InnerAwareInfoCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f7311a;

        public j(d r1) {
            this.f7311a = r1;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public final void onHARStatusChanged(int r1, long r2) {
            d r0 = this.f7311a;
            r0.ab.set(r1);
            if (r1 != 5) goto L5;
        L12:
            boolean r3 = true;
        L13:
            if (r3 == false) goto L15;
            r0.L.set(true);
        L15:
            r0.a("har");
            return;
        L5:
            if (r1 == 6) goto L12;
            if (r1 == 7) goto L12;
            if (r1 == 8) goto L12;
            r3 = false;
            goto L13
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public final void onStepsCounterChanged(int r5) {
            d r4 = this.f7311a;
            if (r5 >= 0) goto L5;
            String r6 = d.f7298a;
            r4.getClass();
            return;
        L5:
            int r0 = r4.Z.getAndSet(r5);
            if (r0 < 0) goto L10;
            if (r5 >= r0) goto L10;
            com.obric.cae.log.a.h("StarLocation-util", "reset, old=" + r0 + ", new=" + r5);
            r4.aa.set(r5);
            return;
        L10:
            if (r4.aa.compareAndSet(-1, r5) == false) goto L12;
            com.obric.cae.log.a.d("StarLocation-util", "init step baseline: " + r5);
            return;
        L12:
            r4.a("steps");
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public final void onflightModeChanged(int r3) {
            if (r3 != 0) goto L5;
            com.obric.cae.log.a.d("StarLocation-util", "flightModeChanged: " + r3);
            this.f7311a.a(true);
            this.f7311a.b("fused", true, "flight_mode_ground");
            return;
        }
    }

    public class k extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f7312a;

        public k(d r1) {
            this.f7312a = r1;
            super(null);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r6) {
            d r7 = this.f7312a;
            AtomicBoolean r0 = r7.A;
            boolean r2 = false;
            if (Settings.Secure.getInt(r7.o.getContentResolver(), LocationMonitorConst.LOCATION_MODE, 0) == 0) goto L5;
            boolean r8 = true;
        L6:
            r0.set(r8);
            boolean r9 = this.f7312a.A.get();
            d r1 = this.f7312a;
            if (r9 == false) goto L9;
            r1.s();
        L10:
            com.obric.cae.log.a.a("StarLocation-util", "setWarmMode success: " + this.f7312a.x.setWarmMode(r9));
            UserAwareManager.getInstance().notifyInnerCallbacks($$Lambda$NV5RJL1NVY_buEAZemTf0YTDynA.INSTANCE, Boolean.valueOf(this.f7312a.A.get()));
            d r5 = this.f7312a;
            AtomicBoolean r10 = r5.H;
            if (Settings.Global.getInt(r5.o.getContentResolver(), "forbid_mock_location", 1) != 1) goto L13;
            r2 = true;
        L13:
            r10.set(r2);
            com.obric.cae.log.a.e("StarLocation-util", "mForbidMockLocation: " + r5.H.get());
            return;
        L9:
            r1.t();
            goto L10
        L5:
            r8 = false;
            goto L6
        }
    }

    public class l implements IEnvBridge {
        public l() {
        }

        @Override // com.bytedance.crypto.bridge.IEnvBridge
        public final boolean onIsBoeEnv() {
            return false;
        }
    }

    public class m implements com.bytedance.privacy.a.a {
        public m() {
        }

        @Override // com.bytedance.privacy.a.a
        public final String a() {
            return "";
        }

        @Override // com.bytedance.privacy.a.a
        public final boolean b() {
            return false;
        }

        @Override // com.bytedance.privacy.a.a
        public final Map<String, String> c() {
            return Collections.emptyMap();
        }

        @Override // com.bytedance.privacy.a.a
        public final String d() {
            String r0 = MatrixDidUtils.getDid();
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0;
        }

        @Override // com.bytedance.privacy.a.a
        public final String e() {
            return "";
        }
    }

    static {
        d = new Object();
        e = TimeUnit.HOURS.toMillis(24);
        TimeUnit r0 = TimeUnit.SECONDS;
        f = r0.toMillis(5);
        g = r0.toMillis(10);
        h = r0.toMillis(5);
        i = r0.toMillis(15);
        j = false;
        k = false;
        l = new AtomicReference(null);
        m = new Object();
    }

    public d() {
        this.t = new AtomicReference(null);
        this.u = new AtomicReference(Collections.emptyList());
        this.v = new AtomicReference(null);
        this.w = new AtomicReference(null);
        this.y = new ConcurrentHashMap();
        this.z = Executors.newCachedThreadPool();
        this.A = new AtomicBoolean(true);
        this.B = new AtomicBoolean(false);
        this.C = new AtomicBoolean(false);
        this.D = new AtomicBoolean(false);
        this.E = new AtomicInteger(0);
        this.F = new AtomicInteger(0);
        this.G = new AtomicBoolean(false);
        this.H = new AtomicBoolean(true);
        this.I = new AtomicBoolean(false);
        this.f7300J = new AtomicBoolean(false);
        this.K = new AtomicBoolean(false);
        this.L = new AtomicBoolean(false);
        this.M = 0;
        this.N = false;
        this.P = 0;
        this.Q = new Object();
        this.R = new AtomicReference(null);
        new AtomicReference(null);
        this.S = new AtomicLong(0);
        this.T = new AtomicLong(0);
        this.U = new AtomicBoolean(false);
        this.V = new AtomicReference(null);
        this.W = new Object();
        this.Y = new AtomicBoolean(false);
        this.Z = new AtomicInteger(-1);
        this.aa = new AtomicInteger(-1);
        this.ab = new AtomicInteger(4);
        this.ac = new Object();
        this.ad = new AtomicBoolean(false);
        this.ae = new AtomicInteger(0);
        this.af = new AtomicInteger(0);
        this.ag = new e(this);
        this.ah = new f(this);
        this.ai = new g(this);
        this.aj = new h(this);
        this.ak = new i(this);
        this.al = new j(this);
        this.am = new C0362d(this);
    }

    public static d a() {
        d r0 = c;
        if (r0 != null) goto L14;
        Object r1 = d;
        monitor-enter(r1);
        r0 = c;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        r0 = new d();     // Catch: Throwable -> L11
        c = r0;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L14:
        return r0;
    }

    public static String a(int r4) {
        return "last" + String.format(Locale.US, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r4)});
    }

    private /* synthetic */ void a(long r3, AtomicBoolean r5, LocationListener r6, String r7) {
        LocationListener r8 = (LocationListener) ZeusTransformUtils.wrapperContextForParams(r6, LocationListener.class, "com.obric.memorydata.plugin");
        Thread.sleep(r3);     // Catch: InterruptedException -> L9
        if (r5.compareAndSet(false, true) == true) goto L7;
        return;
    L7:
        this.V.set(null);
        this.U.set(false);
        b(r7, r8);
        com.obric.cae.log.a.i("StarLocation-util", "requestSingleUpdate timeout: " + r3 + ", source: " + r7);
        return;
    L9:
        Thread.currentThread().interrupt();
    }

    public static void a(d r4, boolean r5) {
        if (r4.G.get() == r5) goto L23;
        r4.G.set(r5);
        String r0 = null;
        if (r5 == false) goto L10;
        WifiManager r1 = r4.s;
        if (r1 == null) goto L10;
        r0 = r1.getConnectionInfo().getSSID();
    L10:
        UserManager r6 = (UserManager) ZeusTransformUtils.preCheckCast(r4.o.getSystemService("user"), UserManager.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L16;
        Iterator<UserHandle> r7 = r6.getUserProfiles().iterator();
    L14:
        if (r7.hasNext() == false) goto L16;
        UserHandle r2 = (UserHandle) ZeusTransformUtils.preCheckCast(r7.next(), UserHandle.class, "com.obric.memorydata.plugin");
    L16:
        StringBuilder r8 = new StringBuilder("setWifiConnected: ").append(r5);
        if (r0 == null) goto L19;
        String r9 = ", ssid: ".concat(r0);
    L20:
        com.obric.cae.log.a.c("StarLocation-util", r8.append(r9).toString(), com.obric.cae.log.a.b("geofence"));
        return;
    L19:
        r9 = "";
        goto L20
    }

    public static void a(File r11, File r12) {
        File r3 = new File(r11, a(10));
        if (r3.exists() == true) goto L5;
    L7:
        int r4 = 9;
    L9:
        if (r4 < 1) goto L25;
        File r7 = new File(r11, a(r4));
        if (r7.exists() == false) goto L24;
        File r8 = new File(r11, a(r4 + 1));
        if (r8.exists() == false) goto L19;
        String r9 = "rotate skipped, target exists: " + r8.getName();     // Catch: RuntimeException -> L22
    L17:
        com.obric.cae.log.a.g("StarLocation-util", r9);     // Catch: RuntimeException -> L22
        goto L24
    L19:
        if (r7.renameTo(r8) == true) goto L24;
        r9 = "rotate failed: " + r7.getName() + " -> " + r8.getName();     // Catch: RuntimeException -> L22
    L22:
        e = move-exception;
        com.obric.cae.log.a.g("StarLocation-util", "rotate failed: " + r7.getName() + " -> " + r8.getName() + ", error=" + e.getMessage());
    L24:
        r4 = r4 - 1;
        goto L9
    L25:
        File r1 = new File(r11, a(1));
        if (r12.exists() == true) goto L69;
    L37:
        File[] r13 = r11.listFiles();
        if (r13 != null) goto L40;
        com.obric.cae.log.a.g("StarLocation-util", "list star directory failed");
        return;
    L40:
        int r14 = r13.length;
        int r2 = 0;
    L41:
        if (r2 >= r14) goto L84;
        File r5 = r13[r2];
        String r10 = r5.getName();
        boolean r15 = "cur".equals(r10);
        int r16 = 1;
    L43:
        if (r15 == true) goto L46;
        if (r16 > 10) goto L46;
        r15 = a(r16).equals(r10);
        r16 = r16 + 1;
    L46:
        if (r15 == true) goto L63;
    L61:
        e = move-exception;
        com.obric.cae.log.a.g("StarLocation-util", com.obric.cae.location.city.f.a("move legacy entry failed: ", r10, ", error=").append(e.getMessage()).toString());
        goto L63
    L49:
        if (r1.exists() == false) goto L51;
    L53:
        File r17 = new File(r1, r10);     // Catch: RuntimeException -> L61
        if (r17.exists() == false) goto L58;
        String r6 = "move legacy entry skipped, target exists: " + r10;     // Catch: RuntimeException -> L61
    L56:
        com.obric.cae.log.a.g("StarLocation-util", r6);     // Catch: RuntimeException -> L61
        goto L63
    L58:
        if (r5.renameTo(r17) == true) goto L63;
        r6 = "move legacy entry failed: " + r10;     // Catch: RuntimeException -> L61
        goto L56
    L51:
        if (r1.mkdirs() == true) goto L53;
        com.obric.cae.log.a.g("StarLocation-util", "create legacy history directory failed");     // Catch: RuntimeException -> L61
        return;
    L63:
        r2 = r2 + 1;
        goto L41
    L84:
        return;
    L69:
    L35:
        e = move-exception;
        com.obric.cae.log.a.g("StarLocation-util", "rotate current star directory failed: " + e.getMessage());
        goto L37
    L28:
        if (r1.exists() == false) goto L32;
        String r18 = "rotate current skipped, target exists";
    L30:
        com.obric.cae.log.a.g("StarLocation-util", r18);     // Catch: RuntimeException -> L35
        goto L37
    L32:
        if (r12.renameTo(r1) == true) goto L37;
        r18 = "rotate current star directory failed";
        goto L30
    L5:
        if (a(r3) == true) goto L7;
        com.obric.cae.log.a.g("StarLocation-util", "delete " + r3.getName() + " failed");
        goto L7
    }

    private /* synthetic */ void a(String r4, CountDownLatch r5, AtomicReference r6, Location r7) {
        if (r7 != null) goto L5;
        com.obric.cae.log.a.i("StarLocation-util", "getCurrentLocation is null: " + r4);
    L6:
        r5.countDown();
        return;
    L5:
        com.obric.cae.log.a.e("StarLocation-util", "getCurrentLocation success: " + r4);
        a(3, r7);
        r6.set(r7);
        goto L6
    }

    public static void a(List r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        com.obric.cae.log.a.b("StarLocation-util", "" + r12.size());
        ArrayList r0 = new ArrayList();
        ArrayList r2 = new ArrayList();
        Iterator r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L13;
        ScanResult r3 = (ScanResult) ZeusTransformUtils.preCheckCast(r13.next(), ScanResult.class, "com.obric.memorydata.plugin");
        if (com.obric.cae.libs.utils.a.a(r3.frequency) == false) goto L9;
        int r4 = 1;
    L12:
        r0.add(new WifiStandardData.a().a(System.currentTimeMillis()).b(r3.SSID).a(r3.BSSID).c(r3.frequency).d(r4).b(r3.level).a(WifiManager.calculateSignalLevel(r3.level, 5)).e(com.obric.cae.libs.utils.a.a(r3)).f(0).g(r3.getWifiStandard()).a());
        r2.add(new WifiStandardData.a().a(System.currentTimeMillis()).b(r3.SSID).a(r3.BSSID).c(r3.frequency).d(r4).b(r3.level).a(WifiManager.calculateSignalLevel(r3.level, 5)).e(com.obric.cae.libs.utils.a.a(r3)).f(0).g(-1).a());
        goto L4
    L9:
        if (com.obric.cae.libs.utils.a.b(r3.frequency) == false) goto L11;
        r4 = 2;
        goto L12
    L11:
        r4 = 0;
        goto L12
    L13:
        UserAwareManager.getInstance().notifyInnerCallbacks($$Lambda$8drtI3cQoh3Uxx7kk6gzOA0H3Pg.INSTANCE, r0);
        UserAwareManager.getInstance().notifyCallbacks($$Lambda$yJ339x7P1J1wkEHFcvWb7zkpZl0.INSTANCE, r2);
    }

    public static boolean a(File r7) {
    L20:
        e = move-exception;
        com.obric.cae.log.a.g("StarLocation-util", "delete " + r7.getName() + " failed: " + e.getMessage());
        return false;
    L4:
        if (r7.exists() == true) goto L7;
        return true;
    L7:
        if (r7.isDirectory() == false) goto L14;
        File[] r1 = r7.listFiles();     // Catch: RuntimeException -> L20
        if (r1 != null) goto L11;
        boolean r5 = false;
    L15:
        if (r7.delete() == false) goto L26;
        if (r5 == true) goto L19;
        return false;
    L19:
        return true;
    L26:
        return false;
    L11:
        int r3 = r1.length;     // Catch: RuntimeException -> L20
        int r4 = 0;
        r5 = true;
    L12:
        if (r4 >= r3) goto L15;
        r5 = r5 & a(r1[r4]);     // Catch: RuntimeException -> L20
        r4 = r4 + 1;     // Catch: RuntimeException -> L20
        goto L12
    L14:
        r5 = true;
        goto L15
    }

    public static String b() {
        return "CommSenseLog";
    }

    public static String c() {
        return "CommSenseLog";
    }

    public static void d() {
        if (PrivacySdk.isInitialized() == false) goto L5;
    L23:
        k = true;
        return;
    L5:
        if (k == true) goto L23;
        Object r0 = m;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L10:
        if (PrivacySdk.isInitialized() == false) goto L12;
    L17:
        k = true;     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L12:
        if (k == true) goto L17;
        PrivacySdk.init(new m(), new a());     // Catch: Throwable -> L20
        k = true;     // Catch: Throwable -> L20
        com.obric.cae.log.a.f("StarLocation-util", "Privacy SDK initialized successfully.");     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
    }

    public static /* synthetic */ void lambda$Gj2aNU9BPhW9x68XBKZ6mEv1rkc(d r0) {
        r0.x();
    }

    public static /* synthetic */ void lambda$Nl10Ikfu4ax8faDsxnOyFhx6C1I(d r0, String r1, CountDownLatch r2, AtomicReference r3, Location r4) {
        r0.a(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$PIRofWIQAiInAsEtq9Z5-NKFcJU, reason: not valid java name */
    public static /* synthetic */ void m396lambda$PIRofWIQAiInAsEtq9Z5NKFcJU(d r0, long r1, AtomicBoolean r3, LocationListener r4, String r5) {
        r0.a(r1, r3, r4, r5);
    }

    private void x() {
        UserManager r0 = (UserManager) ZeusTransformUtils.preCheckCast(this.o.getSystemService("user"), UserManager.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        Iterator<UserHandle> r1 = r0.getUserProfiles().iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        UserHandle r2 = (UserHandle) ZeusTransformUtils.preCheckCast(r1.next(), UserHandle.class, "com.obric.memorydata.plugin");
        StarGeofenceManager.getInstance(this.o, r2.getIdentifier()).retryGeofenceAddress();
    L9:
        g();
        if (this.N == true) goto L13;
        com.obric.cae.location.geosdk.bytedance.a.a().a(this.o);
        this.N = true;
    L13:
        a("network", true, "Network Available");
        return;
    L8:
        StarGeofenceManager.getInstance(this.o, 0).retryGeofenceAddress();
        goto L9
    }

    public double a(double r38, double r40, double r42, double r44) {
        double r0 = Math.toRadians(r38);
        double r2 = Math.toRadians(r42);
        double r4 = Math.toRadians(r44 - r40);
        double r1 = Math.atan(Math.tan(r0) * 0.996647189328169d);
        double r3 = Math.atan(Math.tan(r2) * 0.996647189328169d);
        double r6 = Math.sin(r1);
        double r5 = Math.cos(r1);
        double r8 = Math.sin(r3);
        double r7 = Math.cos(r3);
        int r12 = 0;
        double r13 = r4;
        double r15 = 0.0d;
        double r17 = 0.0d;
        double r19 = 0.0d;
        double r21 = 0.0d;
        double r23 = 0.0d;
    L4:
        if (r12 >= 20) goto L17;
        double r10 = Math.sin(r13);
        double r16 = Math.cos(r13);
        int r39 = r12;
        double r41 = r13;
        double r43 = r4;
        double r9 = Math.hypot(r7 * r10, (r5 * r8) - ((r6 * r7) * r16));
        double r18 = r5 * r7;
        double r14 = (r6 * r8) + (r16 * r18);
        r23 = Math.atan2(r9, r14);
        double r110 = r18 * r10;
        if (r9 != 0.0d) goto L8;
        double r111 = 1.0d;
    L9:
        double r112 = r110 / r111;
        r15 = 1.0d - (r112 * r112);
        double r113 = (r6 * 2.0d) * r8;
        if (r15 != 0.0d) goto L12;
        double r22 = 1.0d;
    L13:
        double r114 = r14 - (r113 / r22);
        double r33 = (((4.0d - (3.0d * r15)) * 0.0033528106718309896d) + 4.0d) * (2.0955066698943685E-4d * r15);
        double r35 = ((((((((r114 * 2.0d) * r114) - 1.0d) * (r33 * r14)) + r114) * (r33 * r9)) + r23) * (((1.0d - r33) * 0.0033528106718309896d) * r112)) + r43;
        if (Math.abs(r35 - r41) < 1.0E-12d) goto L15;
        r21 = r14;
        r12 = r39 + 1;
        r17 = r114;
        r13 = r35;
        r19 = r9;
        r4 = r43;
        goto L4
    L15:
        r21 = r14;
        r17 = r114;
        r19 = r9;
        goto L17
    L12:
        r22 = r15;
        goto L13
    L8:
        r111 = r9;
    L17:
        double r115 = (r15 * 2.723316066819453E11d) / 4.0408299984087055E13d;
        double r11 = (((((74.0d - (47.0d * r115)) * r115) - 128.0d) * r115) + 256.0d) * (r115 / 1024.0d);
        double r29 = ((4.0d * r17) * r17) - 3.0d;
        return (r23 - ((((((((2.0d * r17) * r17) - 1.0d) * r21) - (r29 * ((((r19 * 4.0d) * r19) - 3.0d) * ((r11 / 6.0d) * r17)))) * (r11 / 4.0d)) + r17) * (r11 * r19))) * ((((((((320.0d - (175.0d * r115)) * r115) - 768.0d) * r115) + 4096.0d) * (r115 / 16384.0d)) + 1.0d) * 6356752.3142d);
    }

    public Location a(double r3, double r5, byte r7, byte r8) {
        if (a().a(r3, r5) == true) goto L6;
        com.obric.cae.log.a.j("StarLocation-util", "invalid coordinate");
        return null;
    L6:
        Location r2 = new Location("network");
        r2.setLatitude(r3);
        r2.setLongitude(r5);
        if (r7 != r8) goto L10;
        return r2;
    L10:
        if (r7 != 0) goto L12;
        CoordinateTransformUtils.CoordinateSystem r4 = CoordinateTransformUtils.CoordinateSystem.WGS84;
    L15:
        if (r8 != 0) goto L17;
        CoordinateTransformUtils.CoordinateSystem r6 = CoordinateTransformUtils.CoordinateSystem.WGS84;
    L20:
        Location r9 = CoordinateTransformUtils.a(r4, r6, r2);
        if (r9 != null) goto L23;
        com.obric.cae.log.a.j("StarLocation-util", "coordinate transform failed");
    L23:
        return r9;
    L17:
        if (r8 != 1) goto L19;
        r6 = CoordinateTransformUtils.CoordinateSystem.GCJ02;
        goto L20
    L19:
        r6 = CoordinateTransformUtils.CoordinateSystem.BD09;
        goto L20
    L12:
        if (r7 != 1) goto L14;
        r4 = CoordinateTransformUtils.CoordinateSystem.GCJ02;
        goto L15
    L14:
        r4 = CoordinateTransformUtils.CoordinateSystem.BD09;
        goto L15
    }

    public Location a(BDLocation r4) {
        if (r4 != null) goto L6;
        return null;
    L6:
        if (r4.getLocationType() != 1) goto L8;
        String r3 = "gps";
    L9:
        Location r0 = new Location(r3);
        r0.setLatitude(r4.getLatitude());
        r0.setLongitude(r4.getLongitude());
        r0.setTime(r4.getLocationMs());
        r0.setElapsedRealtimeNanos(r4.getElapsedRealtimeNanos());
        r0.setMock(r4.isMock());
        float r5 = r4.getAccuracy();
        if (r5 != 0.0f) goto L12;
        r5 = 50.0f;
    L12:
        r0.setAccuracy(r5);
        if (LocationInfoConst.GCJ_O2.equalsIgnoreCase(r4.getCoordinateSystem()) == true) goto L15;
        return r0;
    L15:
        return CoordinateTransformUtils.a(CoordinateTransformUtils.CoordinateSystem.GCJ02, CoordinateTransformUtils.CoordinateSystem.WGS84, r0);
    L8:
        r3 = "network";
        goto L9
    }

    public Location a(String r12, boolean r13, String r14) {
        LocationManager r0 = this.p;
        if (r0 != null) goto L5;
    L42:
        com.obric.cae.log.a.j("StarLocation-util", "mLocationManager is null or provider is disabled");
        return null;
    L5:
        if (r0.isProviderEnabled(r12) == false) goto L42;
        if ("network".equalsIgnoreCase(r12) == true) goto L10;
    L13:
        long r3 = System.currentTimeMillis();
        final String r15 = r14 + "_" + r3;
        if (r13 == false) goto L20;
    L15:
        long r5 = this.S.get();
        if ((r3 - r5) < g) goto L17;
        if (this.S.compareAndSet(r5, r3) == false) goto L15;
    L17:
        return null;
    L20:
        com.obric.cae.log.a.d("StarLocation-util", r12 + ", source: " + r15 + ", async=" + r13);
        final AtomicReference r1 = new AtomicReference(null);
        final CountDownLatch r4 = new CountDownLatch(1);
        if (this.o.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) goto L23;
    L26:
        this.p.getCurrentLocation(r12, null, this.z, new $$Lambda$d$Nl10Ikfu4ax8faDsxnOyFhx6C1I(this, r15, r4, r1));
        if (r13 == false) goto L29;
        return null;
    L29:
        int r11 = 5000;
    L39:
        e = move-exception;
        com.obric.cae.log.a.j("StarLocation-util", "interrupted exception: " + e.getMessage());
        return null;
    L31:
        if ("gps".equalsIgnoreCase(r12) == false) goto L34;
        r11 = 15000;
    L34:
        if (r4.await(r11, TimeUnit.SECONDS) == true) goto L38;
        com.obric.cae.log.a.j("StarLocation-util", "timeout: " + r11);     // Catch: InterruptedException -> L39
        return null;
    L38:
        return (Location) ZeusTransformUtils.preCheckCast(r1.get(), Location.class, "com.obric.memorydata.plugin");
    L23:
        if (this.o.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) goto L26;
        com.obric.cae.log.a.j("StarLocation-util", "location permission not granted");
        return null;
    L10:
        if (this.D.get() == true) goto L13;
        com.obric.cae.log.a.d("StarLocation-util", "getNetworkLocation: network is invalid");
        return null;
    }

    public List<Address> a(Location r18, boolean r19) {
        if (r18 != null) goto L5;
    L55:
        com.obric.cae.log.a.j("StarLocation-util", "invalid Location or invalid network");
        return Collections.emptyList();
    L5:
        if (this.D.get() == false) goto L55;
        CountDownLatch r0 = (CountDownLatch) ZeusTransformUtils.preCheckCast(this.w.get(), CountDownLatch.class, "com.obric.memorydata.plugin");
        Location r5 = (Location) ZeusTransformUtils.preCheckCast(this.v.get(), Location.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
    L22:
        Location r1 = (Location) ZeusTransformUtils.preCheckCast(this.t.getAndSet(new Location(r18)), Location.class, "com.obric.memorydata.plugin");
        List<Address> r6 = (List) ZeusTransformUtils.preCheckCast(this.u.get(), List.class, "com.obric.memorydata.plugin");
        if (r18.equals(r1) == false) goto L29;
        if (r6 == null) goto L29;
        if (r6.isEmpty() == true) goto L29;
        com.obric.cae.log.a.d("StarLocation-util", "location is same as last location");
        return r6;
    L29:
        com.obric.cae.log.a.c("StarLocation-util", c(), com.obric.cae.log.a.a() + " " + r18, b());
        Geocoder r10 = new Geocoder(this.o);
        AtomicReference r7 = new AtomicReference(Collections.emptyList());
        CountDownLatch r9 = new CountDownLatch(1);
        this.v.set(new Location(r18));
        this.w.set(r9);
        r10.getFromLocation(r18.getLatitude(), r18.getLongitude(), 1, new c(this, r7, r9));
    L40:
        e = move-exception;
        com.obric.cae.log.a.j("StarLocation-util", "interrupted: " + e.getMessage());     // Catch: Throwable -> L38
        CountDownLatch r2 = (CountDownLatch) ZeusTransformUtils.preCheckCast(this.w.get(), CountDownLatch.class, "com.obric.memorydata.plugin");
        Location r3 = (Location) ZeusTransformUtils.preCheckCast(this.v.get(), Location.class, "com.obric.memorydata.plugin");
        if (r2 == r9) goto L45;
    L48:
        return (List) ZeusTransformUtils.preCheckCast(r7.get(), List.class, "com.obric.memorydata.plugin");
    L45:
        if (r18.equals(r3) == false) goto L48;
    L46:
        this.w.compareAndSet(r2, null);
        this.v.compareAndSet(r3, null);
    L38:
        th = move-exception;
        CountDownLatch r4 = (CountDownLatch) ZeusTransformUtils.preCheckCast(this.w.get(), CountDownLatch.class, "com.obric.memorydata.plugin");
        Location r8 = (Location) ZeusTransformUtils.preCheckCast(this.v.get(), Location.class, "com.obric.memorydata.plugin");
        if (r4 == r9) goto L52;
    L54:
        throw th;
    L52:
        if (r18.equals(r8) == false) goto L54;
        this.w.compareAndSet(r4, null);
        this.v.compareAndSet(r8, null);
        goto L54
    L31:
        if (r9.await(1, TimeUnit.SECONDS) == true) goto L33;
        com.obric.cae.log.a.j("StarLocation-util", LocationMonitorConst.TIMEOUT);     // Catch: Throwable -> L38 InterruptedException -> L40
    L33:
        r2 = (CountDownLatch) ZeusTransformUtils.preCheckCast(this.w.get(), CountDownLatch.class, "com.obric.memorydata.plugin");
        r3 = (Location) ZeusTransformUtils.preCheckCast(this.v.get(), Location.class, "com.obric.memorydata.plugin");
        if (r2 != r9) goto L48;
        if (r18.equals(r3) == false) goto L48;
    L10:
        if (r18.equals(r5) == false) goto L22;
    L15:
        e = move-exception;
        com.obric.cae.log.a.j("StarLocation-util", "coalesce interrupted: " + e.getMessage());
    L17:
        List<Address> r11 = (List) ZeusTransformUtils.preCheckCast(this.u.get(), List.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L21;
        return r11;
    L21:
        return Collections.emptyList();
    L12:
        if (r0.await(1, TimeUnit.SECONDS) == true) goto L17;
        com.obric.cae.log.a.j("StarLocation-util", "coalesce await timeout");     // Catch: InterruptedException -> L15
        goto L17
    }

    public final void a(int r6, Location r7) {
        com.obric.cae.log.a.b("StarLocation-util", CommonConsts.APM_INNER_EVENT_COST_START);
        if (r7 != null) goto L7;
        com.obric.cae.log.a.j("StarLocation-util", "location is null");
        return;
    L7:
        if (this.H.get() == false) goto L13;
        if (r7.isMock() == false) goto L13;
        com.obric.cae.log.a.b("StarLocation-util", "skip mock location");
        return;
    L13:
        if (a(r7) == true) goto L17;
        com.obric.cae.log.a.b("StarLocation-util", "skip gpo location");
        return;
    L17:
        if (a(r7.getLatitude(), r7.getLongitude()) == true) goto L20;
        com.obric.cae.log.a.j("StarLocation-util", "skip invalid coordinate");
        return;
    L20:
        Location r8 = com.obric.cae.location.a.a().b(r7);
        LocationAwareInfoManager.getInstance(this.o).handleLocationUpdate(r8);
        if ("network".equals(r8.getProvider()) == false) goto L42;
        int r1 = this.Z.get();
        if (r1 < 0) goto L25;
        this.aa.set(r1);
    L25:
        int r2 = this.ab.get();
        if (r2 != 5) goto L28;
    L35:
        boolean r3 = true;
    L36:
        if (r3 == false) goto L38;
        com.obric.cae.log.a.d("StarLocation-util", "skip resume nlp wifi cache, harStatus still indicates large movement: " + this.ab.get());
        goto L42
    L38:
        this.L.set(false);
        if (this.K.compareAndSet(true, false) == false) goto L42;
        com.obric.cae.log.a.d("StarLocation-util", "received fresh network location, resume nlp wifi cache");
        a(false);
        goto L42
    L28:
        if (r2 == 6) goto L35;
        if (r2 == 7) goto L35;
        if (r2 == 8) goto L35;
        r3 = false;
    L42:
        com.obric.cae.location.a.a().b(r6, r8, this.af.get());
    }

    public final void a(int r8, boolean r9) {
        if (this.o != null) goto L6;
        return;
    L6:
        if (r8 >= 0) goto L9;
        r8 = 0;
    L9:
        if (r9 == false) goto L11;
    L15:
        Object r4 = this.ac;
        monitor-enter(r4);
        if (r9 == false) goto L40;
    L24:
        LocationManager r5 = this.p;     // Catch: Throwable -> L35
        if (r5 == null) goto L28;
        if (r9 == false) goto L28;
        r5.removeUpdates(this.ag);     // Catch: Throwable -> L35
        r5.unregisterGnssStatusCallback(this.ah);     // Catch: Throwable -> L35
    L28:
        Context r10 = this.o;     // Catch: Throwable -> L35
        r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.createContextAsUser(UserHandle.of(r8), 0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L31 Throwable -> L35
    L32:
        this.p = (LocationManager) ZeusTransformUtils.preCheckCast(r10.getSystemService("location"), LocationManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        this.ae.set(r8);     // Catch: Throwable -> L35
        com.obric.cae.log.a.d("StarLocation-util", "success, userId: " + r8 + ", locationContextUserBound: true");     // Catch: Throwable -> L35
        monitor-exit(r4);     // Catch: Throwable -> L35
        return;
    L31:
        com.obric.cae.log.a.h("StarLocation-util", "fallback to app context, userId: " + r8);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;
    L40:
        if (r8 != this.ae.get()) goto L24;
        if (this.p == null) goto L24;
        monitor-exit(r4);     // Catch: Throwable -> L35
        return;
    L11:
        if (r8 != this.ae.get()) goto L15;
        if (this.p == null) goto L15;
    }

    public final void a(long r8) {
        if (this.o != null) goto L7;
        String r9 = "mContext is null";
    L5:
        com.obric.cae.log.a.j("StarLocation-util", r9);
        v();
        return;
    L7:
        String r2 = MatrixDidUtils.getDid();
        if (r2 != null) goto L10;
    L26:
        r9 = "did is null or empty";
        goto L5
    L10:
        if (r2.isEmpty() == true) goto L26;
        d();     // Catch: Throwable -> L20 BdPrivacyException -> L22
        String r1 = com.bytedance.privacy.attestation.b.a().a(this.o, "ocean_location", "ocean_location_attestation", new AttestationConfig.a().a("{\"did\":\"" + r2 + "\"}").a());     // Catch: Throwable -> L20 BdPrivacyException -> L22
        if (r1 != null) goto L15;
    L18:
        com.obric.cae.log.a.j("StarLocation-util", "cert is null or empty");     // Catch: Throwable -> L20 BdPrivacyException -> L22
        v();     // Catch: Throwable -> L20 BdPrivacyException -> L22
        return;
    L15:
        if (r1.isEmpty() == true) goto L18;
        this.O = r1;     // Catch: Throwable -> L20 BdPrivacyException -> L22
        this.P = r8;     // Catch: Throwable -> L20 BdPrivacyException -> L22
        com.obric.cae.log.a.f("StarLocation-util", "success, certLength=" + r1.length());     // Catch: Throwable -> L20 BdPrivacyException -> L22
        return;
    L22:
        e = e;
        v();
        String r7 = "failed, errorCode=" + e.getErrorCode();
    L24:
        com.obric.cae.log.a.b("StarLocation-util", r7, e);
        return;
    L20:
        e = th;
        v();
        r7 = "failed";
        goto L24
    }

    public final void a(final long r10, final AtomicBoolean r12, final b r13, final String r14) {
        this.z.execute(new $$Lambda$d$PIRofWIQAiInAsEtq9Z5NKFcJU(this, r10, r12, r13, r14));
    }

    public void a(Context r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        this.o = ZeusTransformUtils.wrapperContext(r12, "com.obric.memorydata.plugin");
        f7299b = SystemProperties.get("ro.product.product.device", "");
        r().execute(new $$Lambda$Op5LeBOXLdsbAK2tVAISs4l4EXM(this));
        boolean r5 = false;
        Object r6 = ActivityManager.class.getMethod("getCurrentUser", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L9
        if (ZeusTransformUtils.instanceOf(r6, Integer.class) == true) goto L6;
    L10:
        int r7 = 0;
    L11:
        a(r7, false);
        this.x = StarWarmModeManager.getInstance(this.o);
        if (this.o != null) goto L14;
    L17:
        PowerManager r1 = (PowerManager) ZeusTransformUtils.preCheckCast(this.o.getSystemService("power"), PowerManager.class, "com.obric.memorydata.plugin");
        AtomicBoolean r8 = this.C;
        if (r1 != null) goto L20;
    L22:
        boolean r2 = false;
    L23:
        r8.set(r2);
        com.obric.cae.log.a.c("StarLocation-util", "current deep doze: " + this.C.get(), com.obric.cae.log.a.b("geofence"));
        a(false, r7, CommonConsts.APM_INNER_EVENT_COST_INIT);
        Uri r3 = Settings.Secure.getUriFor(LocationMonitorConst.LOCATION_MODE);
        if (r3 == null) goto L26;
        ZeusProviderTransform.registerContentObserver(this.o.getContentResolver(), r3, false, new k(this), "com.obric.memorydata.plugin");
    L26:
        Uri r4 = Settings.Global.getUriFor("disable_nlp_wifi_cache");
        if (r4 == null) goto L29;
        ZeusProviderTransform.registerContentObserver(this.o.getContentResolver(), r4, false, this.ak, "com.obric.memorydata.plugin");
    L29:
        Uri r9 = Settings.Global.getUriFor("disable_nlp_wifi_cache_always");
        if (r9 == null) goto L32;
        ZeusProviderTransform.registerContentObserver(this.o.getContentResolver(), r9, false, this.ak, "com.obric.memorydata.plugin");
    L32:
        boolean r10 = this.p.isLocationEnabled();
        this.A.set(r10);
        if (r10 == false) goto L35;
        s();
    L35:
        com.obric.cae.log.a.a("StarLocation-util", "setWarmMode success: " + this.x.setWarmMode(r10));
        ConnectivityManager r13 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(this.o.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");
        this.q = r13;
        r13.registerDefaultNetworkCallback(this.ai);
        c(w());
        this.r = (TelephonyManager) ZeusTransformUtils.preCheckCast(r12.getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin");
        this.s = (WifiManager) ZeusTransformUtils.preCheckCast(r12.getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin");
        com.obric.cae.log.a.d("StarLocation-util", "");
        ZeusTransformUtils.registerReceiver(this.o, this.am, new IntentFilter("android.net.wifi.SCAN_RESULTS"), "com.obric.memorydata.plugin");
        UserAwareManager.getInstance().registerInnerCallback(this.al);
        a(null);
        AtomicBoolean r14 = this.H;
        if (Settings.Global.getInt(this.o.getContentResolver(), "forbid_mock_location", 1) != 1) goto L38;
        r5 = true;
    L38:
        r14.set(r5);
        com.obric.cae.log.a.e("StarLocation-util", "mForbidMockLocation: " + this.H.get());
        return;
    L20:
        if (r1.isDeviceIdleMode() == false) goto L22;
        r2 = true;
        goto L23
    L14:
        if (this.ad.compareAndSet(false, true) == false) goto L17;
        IntentFilter r15 = new IntentFilter();
        r15.addAction("android.intent.action.USER_SWITCHED");
        r15.addAction("android.intent.action.USER_UNLOCKED");
        r15.addAction("android.intent.action.SCREEN_ON");
        r15.addAction("android.intent.action.SCREEN_OFF");
        r15.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        ZeusTransformUtils.registerReceiver(this.o, this.aj, r15, "com.obric.memorydata.plugin");
        goto L17
    L6:
        if (((Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L10;
        r7 = ((Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L9
        com.obric.cae.log.a.d("StarLocation-util", "success, userId: " + r7);     // Catch: Throwable -> L9
    L9:
        com.obric.cae.log.a.h("StarLocation-util", "fallback to system user");
        goto L10
    }

    public void a(LocationListener r7) {
        LocationListener r8 = (LocationListener) ZeusTransformUtils.wrapperContextForParams(r7, LocationListener.class, "com.obric.memorydata.plugin");
        com.obric.cae.log.a.d("StarLocation-util", "hashCode: " + System.identityHashCode(r8));
        Iterator r0 = this.y.keySet().iterator();
        boolean r2 = false;
    L4:
        if (r0.hasNext() == false) goto L11;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (r3.startsWith(System.identityHashCode(r8) + "_") == false) goto L4;
        this.y.remove(r3);
        if (r2 == true) goto L10;
        this.p.removeUpdates(r8);
    L10:
        r2 = true;
        goto L4
    }

    public final void a(Uri r5) {
        Uri r1 = Settings.Global.getUriFor("disable_nlp_wifi_cache_always");
        boolean r2 = false;
        if (r5 == null) goto L7;
        if (r1 != null) goto L6;
    L12:
        boolean r6 = this.f7300J.get();
        int r0 = Settings.Global.getInt(this.o.getContentResolver(), "disable_nlp_wifi_cache", 0);
        if (r6 == false) goto L16;
        if (r0 == 1) goto L16;
        Settings.Global.putInt(this.o.getContentResolver(), "disable_nlp_wifi_cache", 1);
        r0 = 1;
    L16:
        if (r0 != 1) goto L18;
        r2 = true;
    L18:
        this.I.set(r2);
        com.obric.cae.log.a.f("StarLocation-util", "mDisableNlpWifiCache: " + this.I.get() + ", always=" + r6);
        return;
    L6:
        if (r1.equals(r5) == false) goto L12;
    L7:
        AtomicBoolean r7 = this.f7300J;
        if (Settings.Global.getInt(this.o.getContentResolver(), "disable_nlp_wifi_cache_always", 0) != 1) goto L10;
        boolean r3 = true;
    L11:
        r7.set(r3);
        goto L12
    L10:
        r3 = false;
        goto L11
    }

    public final void a(String r4) {
        if (n() == true) goto L6;
        return;
    L6:
        if (this.K.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        com.obric.cae.log.a.f("StarLocation-util", com.obric.cae.location.city.f.a("detected large movement by ", r4, ", moveSteps=").append(this.Z.get() - this.aa.get()).append(", harStatus=").append(this.ab.get()).toString());
        a(true);
    }

    public void a(String r8, LocationListener r9) {
        LocationListener r6 = (LocationListener) ZeusTransformUtils.wrapperContextForParams(r9, LocationListener.class, "com.obric.memorydata.plugin");
        LocationManager r10 = this.p;
        if (r10 != null) goto L5;
    L18:
        String r7 = "mLocationManager is null or provider is disabled";
    L12:
        com.obric.cae.log.a.j("StarLocation-util", r7);
        return;
    L5:
        if (r10.isProviderEnabled(r8) == false) goto L18;
        if (this.o.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) goto L10;
    L14:
        com.obric.cae.log.a.d("StarLocation-util", "hashCode: " + System.identityHashCode(r6));
        if (this.y.putIfAbsent(System.identityHashCode(r6) + "_" + r8, r6) != null) goto L19;
        this.p.requestLocationUpdates(r8, 1000, 0.0f, this.z, r6);
        return;
    L19:
        return;
    L10:
        if (this.o.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) goto L14;
        r7 = "location permission not satisfied";
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v5 */
    public void a(boolean r7) {
        if (this.o != null) goto L6;
        com.obric.cae.log.a.j("StarLocation-util", "mContext is null");
        return;
    L6:
        boolean r0 = this.f7300J.get();
        if (r7 == true) goto L11;
        if (r0 == true) goto L11;
        ?? r8 = 0;
    L13:
        if (this.I.get() != r8) goto L16;
        com.obric.cae.log.a.d("StarLocation-util", "value=" + r8 + ", always=" + r0 + ", changed=false");
        return;
    L16:
        boolean r2 = Settings.Global.putInt(this.o.getContentResolver(), "disable_nlp_wifi_cache", r8);
        if (r2 == false) goto L19;
        this.I.set(r8);
    L19:
        com.obric.cae.log.a.f("StarLocation-util", "value=" + r8 + ", always=" + r0 + ", success=" + r2);
        return;
    L11:
        r8 = 1;
        goto L13
    }

    public final void a(boolean r7, int r8, String r9) {
        com.obric.cae.log.a.d("StarLocation-util", "reason: " + r9 + ", userId: " + r8);
        if (r8 < 0) goto L5;
        int r3 = r8;
    L6:
        int r4 = this.af.getAndSet(r3);
        if (r4 == r3) goto L9;
        com.obric.cae.log.a.d("StarLocation-util", "reason: " + r9 + ", from: " + r4 + ", to: " + r3);
    L9:
        a(r8, r7);
        Context r10 = this.o;
        if (r10 == null) goto L20;
        UserManager r11 = (UserManager) ZeusTransformUtils.preCheckCast(r10.getSystemService("user"), UserManager.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L18;
        Iterator<UserHandle> r12 = r11.getUserProfiles().iterator();
    L16:
        if (r12.hasNext() == false) goto L20;
        StarGeofenceManager.getInstance(this.o, ((UserHandle) ZeusTransformUtils.preCheckCast(r12.next(), UserHandle.class, "com.obric.memorydata.plugin")).getIdentifier());
        goto L16
    L18:
        StarGeofenceManager.getInstance(this.o, 0);
    L20:
        if (this.A.get() == false) goto L24;
        s();
        return;
    L24:
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public boolean a(double r3, double r5) {
        if (Double.isNaN(r3) == false) goto L5;
    L15:
        return false;
    L5:
        if (Double.isNaN(r5) == true) goto L15;
        if (r3 < (-90.0d)) goto L15;
        if (r3 > 90.0d) goto L15;
        if (r5 < (-180.0d)) goto L15;
        if (r5 > 180.0d) goto L15;
        return true;
    }

    public boolean a(Location r3) {
        if ("gps".equals(r3.getProvider()) == true) goto L6;
        return true;
    L6:
        if (Build.VERSION.SDK_INT < 34) goto L15;
        if (r3.hasVerticalAccuracy() == false) goto L10;
    L13:
        return true;
    L10:
        if (r3.hasMslAltitudeAccuracy() == true) goto L13;
        if (r3.hasSpeedAccuracy() == true) goto L13;
        return false;
    L15:
        if (r3.hasVerticalAccuracy() == false) goto L17;
    L21:
        return true;
    L17:
        if (r3.hasSpeedAccuracy() == true) goto L21;
        return false;
    }

    public boolean a(Location r5, Location r6) {
        if (r5 == null) goto L18;
        if (r6 != null) goto L7;
        return false;
    L7:
        if (Double.compare(r5.getLatitude(), r6.getLatitude()) == 0) goto L9;
        return false;
    L9:
        if (Double.compare(r5.getLongitude(), r6.getLongitude()) == 0) goto L11;
        return false;
    L11:
        if (r5.hasAccuracy() == r6.hasAccuracy()) goto L13;
        return false;
    L13:
        if (r5.hasAccuracy() == true) goto L15;
    L16:
        return true;
    L15:
        if (Float.compare(r5.getAccuracy(), r6.getAccuracy()) == 0) goto L16;
        return false;
    L18:
        return false;
    }

    public Location b(String r20, boolean r21, String r22) {
        if (r20 != null) goto L5;
    L96:
        com.obric.cae.log.a.j("StarLocation-util", "provider is null or empty");
        return null;
    L5:
        if (r20.isEmpty() == true) goto L96;
        if (this.o == null) goto L94;
        LocationManager r2 = this.p;
        if (r2 == null) goto L94;
    L91:
        e = move-exception;
        com.obric.cae.log.a.j("StarLocation-util", com.obric.cae.location.city.f.a("invalid provider: ", r20, ", ").append(e.getMessage()).toString());
        return null;
    L13:
        if (r2.isProviderEnabled(r20) == true) goto L17;
        com.obric.cae.log.a.j("StarLocation-util", "provider is disabled: ".concat(r20));     // Catch: IllegalArgumentException -> L91
        return null;
    L17:
        if ("network".equalsIgnoreCase(r20) == true) goto L19;
    L22:
        long r1 = SystemClock.elapsedRealtime();
        String r10 = r22 + "_" + r1;
        if ("gps".equalsIgnoreCase(r20) == false) goto L25;
        long r3 = i;
    L26:
        long r11 = r3;
        com.obric.cae.log.a.d("StarLocation-util", r20 + ", source: " + r10 + ", async=" + r21);
        if (this.o.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) goto L33;
        if (this.o.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) goto L33;
        com.obric.cae.log.a.j("StarLocation-util", "location permission not granted");
        return null;
    L33:
        if (r21 == false) goto L42;
    L34:
        long r4 = this.T.get();
        if ((r1 - r4) < r11) goto L36;
        if (this.T.compareAndSet(r4, r1) == false) goto L34;
        boolean r5 = true;
    L40:
        if (r5 == true) goto L42;
        return null;
    L36:
        r5 = false;
    L42:
        Object r6 = this.W;
        monitor-enter(r6);
        HandlerThread r7 = this.X;     // Catch: Throwable -> L88
        if (r7 != null) goto L47;
    L48:
        HandlerThread r8 = new HandlerThread("LocationUtil-SingleLocation");     // Catch: Throwable -> L88
        r8.start();     // Catch: Throwable -> L88
        this.X = r8;     // Catch: Throwable -> L88
    L49:
        Looper r15 = this.X.getLooper();     // Catch: Throwable -> L88
        monitor-exit(r6);     // Catch: Throwable -> L88
        if (r15 != null) goto L53;
    L86:
        com.obric.cae.log.a.j("StarLocation-util", "single location callback looper is invalid");
        return null;
    L53:
        if (r15 == Looper.getMainLooper()) goto L86;
        AtomicReference r9 = new AtomicReference(null);
        CountDownLatch r12 = new CountDownLatch(1);
        AtomicBoolean r13 = new AtomicBoolean(false);
        b r14 = new b(this, r13, r10, r9, r12);
        this.V.set(null);
        this.U.set(true);
        this.p.requestSingleUpdate(r20, r14, r15);     // Catch: RuntimeException -> L83
        if (r21 == false) goto L98;
        a(r11, r13, r14, r10);
        return null;
    L98:
        if (r12.await(r11, TimeUnit.MILLISECONDS) == true) goto L74;
        AtomicBoolean r16 = r13;
        boolean r17 = false;
    L71:
        e = e;
    L79:
        if (r16.compareAndSet(r17, true) == false) goto L81;
        this.V.set(null);
        this.U.set(r17);
        b(r10, r14);
    L81:
        Thread.currentThread().interrupt();
        com.obric.cae.log.a.j("StarLocation-util", "interrupted exception: " + e.getMessage());
        return null;
    L64:
        if (r16.compareAndSet(false, true) == false) goto L67;
        this.V.set(null);     // Catch: InterruptedException -> L71
        this.U.set(false);     // Catch: InterruptedException -> L71
        b(r10, r14);     // Catch: InterruptedException -> L69
    L69:
        e = e;
    L77:
        r17 = false;
    L67:
        com.obric.cae.log.a.j("StarLocation-util", "timeout: " + r11);     // Catch: InterruptedException -> L69
        return null;
    L74:
        return (Location) ZeusTransformUtils.preCheckCast(r9.get(), Location.class, "com.obric.memorydata.plugin");
    L75:
        e = e;
        r16 = r13;
    L83:
        e = move-exception;
        this.V.set(null);
        this.U.set(false);
        com.obric.cae.log.a.j("StarLocation-util", "requestSingleUpdate failed: " + e.getMessage());
        return null;
    L47:
        if (r7.isAlive() == true) goto L49;
    L88:
        th = move-exception;
        throw th;
    L25:
        r3 = h;
        goto L26
    L19:
        if (this.D.get() == true) goto L22;
        com.obric.cae.log.a.j("StarLocation-util", "network is invalid");
        return null;
    L94:
        com.obric.cae.log.a.j("StarLocation-util", "mContext or mLocationManager is null");
        return null;
    }

    public File b(Context r3) {
        File r4 = new File(new File(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "star"), "cur");
        if (r4.exists() == true) goto L5;
        r4.mkdirs();
    L5:
        return r4;
    }

    public String b(double r2, double r4) {
        return String.format(Locale.US, "%.6f,%.6f", new Object[]{Double.valueOf(r2), Double.valueOf(r4)});
    }

    public void b(Location r11) {
        long r0 = System.currentTimeMillis();
        boolean r3 = false;
        com.obric.cae.location.database.c.b r2 = com.obric.cae.location.database.c.a(this.o, 0).b();
        if (r2 == null) goto L21;
        String r5 = r2.f7077a;
        if (r5 != null) goto L7;
    L8:
        String r6 = r2.f7078b;
        if (r6 != null) goto L11;
    L12:
        String r7 = r2.c;
        if (r7 != null) goto L15;
    L16:
        String r4 = r2.d;
        if (r4 == null) goto L21;
        if (r4.isEmpty() == true) goto L21;
    L20:
        boolean r8 = true;
    L23:
        if (r8 == true) goto L25;
    L34:
        List<Address> r12 = a(r11, false);
        if (r12 != null) goto L37;
        return;
    L37:
        if (r12.isEmpty() == true) goto L58;
        Address r13 = (Address) ZeusTransformUtils.preCheckCast(r12.get(0), Address.class, "com.obric.memorydata.plugin");
        String r9 = r13.getAdminArea();
        String r10 = r13.getSubAdminArea();
        String r14 = r13.getLocality();
        String r15 = r13.getSubLocality();
        if (r9 != null) goto L42;
    L43:
        if (r10 != null) goto L45;
    L46:
        if (r14 != null) goto L48;
    L49:
        if (r15 != null) goto L51;
    L53:
        if (r3 == true) goto L55;
        return;
    L55:
        com.obric.cae.location.city.c.a(this.o).a(r13);
        com.obric.cae.location.city.c.a(this.o).a(r13, r0);
        this.M = r0;
        return;
    L51:
        if (r15.isEmpty() == true) goto L53;
    L52:
        r3 = true;
        goto L53
    L48:
        if (r14.isEmpty() == false) goto L52;
    L45:
        if (r10.isEmpty() == false) goto L52;
    L42:
        if (r9.isEmpty() == false) goto L52;
    L58:
        return;
    L25:
        if ((r0 - this.M) > TimeUnit.HOURS.toMillis(1)) goto L34;
        Location r16 = (Location) ZeusTransformUtils.preCheckCast(this.t.get(), Location.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L29;
    L31:
        boolean r17 = false;
    L32:
        if (r17 == true) goto L34;
        return;
    L29:
        if (r11.distanceTo(r16) <= 10000.0f) goto L31;
        r17 = true;
        goto L32
    L15:
        if (r7.isEmpty() == false) goto L20;
    L11:
        if (r6.isEmpty() == false) goto L20;
    L7:
        if (r5.isEmpty() == false) goto L20;
    L21:
        r8 = false;
        goto L23
    }

    public final void b(String r3, LocationListener r4) {
        LocationListener r5 = (LocationListener) ZeusTransformUtils.wrapperContextForParams(r4, LocationListener.class, "com.obric.memorydata.plugin");
        LocationManager r2 = this.p;
        if (r2 != null) goto L10;
        return;
    L10:
        r2.removeUpdates(r5);     // Catch: RuntimeException -> L7
        return;
    L7:
        e = move-exception;
        com.obric.cae.log.a.i("StarLocation-util", com.obric.cae.location.city.f.a("remove requestSingleUpdate listener failed: ", r3, ", ").append(e.getMessage()).toString());
    }

    public boolean b(boolean r5) {
        Context r4 = this.o;
        if (r4 != null) goto L15;
        com.obric.cae.log.a.c("StarLocation-util", "set location UI enabled failed because service is not ready");
        return false;
    L15:
        ContentResolver r6 = r4.getContentResolver();     // Catch: RuntimeException -> L12
        if (r5 == false) goto L9;
        int r3 = 3;
    L10:
        return Settings.Secure.putInt(r6, LocationMonitorConst.LOCATION_MODE, r3);
    L9:
        r3 = 0;
    L12:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-util", "set location UI enabled=" + r5 + " failed", e);
        return false;
    }

    public int c(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        TelephonyManager r0 = this.r;
        if (r0 == null) goto L7;
        return r0.getSimState();
    L7:
        if (this.o != null) goto L14;
        com.obric.cae.log.a.j("StarLocation-util", "mContext is null");
        if (r6 != null) goto L11;
        return 0;
    L11:
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        this.o = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        if (r7 != null) goto L14;
        return 0;
    L14:
        TelephonyManager r8 = (TelephonyManager) ZeusTransformUtils.preCheckCast(this.o.getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin");
        this.r = r8;
        if (r8 != null) goto L19;
        com.obric.cae.log.a.j("StarLocation-util", "TelephonyManager is null");
        return 0;
    L19:
        return r8.getSimState();
    }

    public final void c(boolean r4) {
        AtomicBoolean r0 = this.D;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.D.get() != r4) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L8:
        this.D.set(r4);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        com.obric.cae.log.a.c("StarLocation-util", "setIsNetworkValid: " + r4, com.obric.cae.log.a.b("geofence"));
        UserAwareManager.getInstance().notifyInnerCallbacks($$Lambda$NLRilpyQt7CaZ_fWNTsOevlXwEM.INSTANCE, Boolean.valueOf(r4));
        if (r4 == false) goto L18;
        r().execute(new $$Lambda$d$Gj2aNU9BPhW9x68XBKZ6mEv1rkc(this));
        return;
    }

    public synchronized boolean d(Context r5) {
        monitor-enter(this);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        if (this.n == false) goto L37;
        monitor-exit(this);
        return true;
    L37:
        File r2 = new File(r6.getFilesDir(), "star");     // Catch: RuntimeException -> L30 Throwable -> L34
        if (r2.isDirectory() == false) goto L12;
    L18:
        File r7 = new File(r2, "cur");     // Catch: RuntimeException -> L30 Throwable -> L34
        a(r2, r7);     // Catch: RuntimeException -> L30 Throwable -> L34
        if (r7.isDirectory() == false) goto L21;
    L27:
        this.n = true;     // Catch: RuntimeException -> L30 Throwable -> L34
        monitor-exit(this);
        return true;
    L21:
        if (r7.mkdirs() == true) goto L27;
        if (r7.isDirectory() == true) goto L27;
        com.obric.cae.log.a.g("StarLocation-util", "create current star directory failed");     // Catch: RuntimeException -> L30 Throwable -> L34
        monitor-exit(this);
        return false;
    L12:
        if (r2.mkdirs() == true) goto L18;
        if (r2.isDirectory() == true) goto L18;
        com.obric.cae.log.a.g("StarLocation-util", "create star directory failed");     // Catch: RuntimeException -> L30 Throwable -> L34
        monitor-exit(this);
        return false;
    L30:
        e = move-exception;
        com.obric.cae.log.a.g("StarLocation-util", "prepare star directory failed: " + e.getMessage());     // Catch: Throwable -> L34
        return false;
    L34:
        th = move-exception;
        throw th;
    }

    public boolean e() {
        return this.D.get();
    }

    public boolean f() {
        return this.G.get();
    }

    public void g() {
        if (this.o != null) goto L6;
        return;
    L6:
        if (j == true) goto L33;
        com.obric.cae.log.a.d("StarLocation-util", CommonConsts.APM_INNER_EVENT_COST_START);
        if (e() == true) goto L10;
        return;
    L10:
        CountDownLatch r4 = new CountDownLatch(1);
        AtomicReference<CountDownLatch> r6 = l;
        if (r6.compareAndSet(null, r4) == true) goto L14;
        com.obric.cae.log.a.d("StarLocation-util", "Crypto SDK init in progress");
        return;
    L14:
        long r8 = SystemClock.elapsedRealtime();
    L27:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-util", "Crypto SDK init failed, costMs=" + (SystemClock.elapsedRealtime() - r8), th);     // Catch: Throwable -> L30
        r4.countDown();
        l.compareAndSet(r4, null);
    L30:
        th = move-exception;
        r4.countDown();
        l.compareAndSet(r4, null);
        throw th;
    L16:
        if (j == true) goto L26;
        String r10 = MatrixDidUtils.getDid();     // Catch: Throwable -> L27
        if (r10 != null) goto L20;
    L23:
        com.obric.cae.log.a.j("StarLocation-util", "did is null or empty");     // Catch: Throwable -> L27
        r4.countDown();
        r6.compareAndSet(r4, null);
        return;
    L20:
        if (r10.isEmpty() == true) goto L23;
        CloudTransCryptoManager.getInstance().init(this.o, "ocean_location", r10, new l());     // Catch: Throwable -> L27
        j = true;     // Catch: Throwable -> L27
        com.obric.cae.log.a.f("StarLocation-util", "Crypto SDK initialized successfully, costMs=" + (SystemClock.elapsedRealtime() - r8));     // Catch: Throwable -> L27
        com.obric.cae.log.a.c("StarLocation-util", "device_id: ".concat(r10), com.obric.cae.log.a.b("geofence"));     // Catch: Throwable -> L27
    L26:
        r4.countDown();
        r6.compareAndSet(r4, null);
    L33:
        j();
    }

    public boolean h() {
        if (j == false) goto L6;
        return true;
    L6:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        com.obric.cae.log.a.h("StarLocation-util", "skip waiting on main thread");
        r().execute(new $$Lambda$Op5LeBOXLdsbAK2tVAISs4l4EXM(this));
        return false;
    L9:
        g();
        if (j == false) goto L12;
        return true;
    L12:
        CountDownLatch r8 = (CountDownLatch) ZeusTransformUtils.preCheckCast(l.get(), CountDownLatch.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L15;
        return false;
    L15:
        long r1 = SystemClock.elapsedRealtime();
    L22:
        e = move-exception;
        Thread.currentThread().interrupt();
        com.obric.cae.log.a.b("StarLocation-util", "Crypto SDK init wait interrupted", e);
        return false;
    L17:
        if (r8.await(f, TimeUnit.MILLISECONDS) == true) goto L21;
        com.obric.cae.log.a.j("StarLocation-util", "Crypto SDK init wait timeout, costMs=" + (SystemClock.elapsedRealtime() - r1));     // Catch: InterruptedException -> L22
        return false;
    L21:
        return j;
    }

    public String i() {
        j();
        return this.O;
    }

    public void j() {
        long r0 = SystemClock.elapsedRealtime();
        String r2 = this.O;
        long r1 = r0 - this.P;
        boolean r3 = true;
        if (r2 != null) goto L5;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == false) goto L16;
        return;
    L16:
        Object r5 = this.Q;
        monitor-enter(r5);
        long r6 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L36
        String r7 = this.O;     // Catch: Throwable -> L36
        long r8 = r6 - this.P;     // Catch: Throwable -> L36
        if (r7 != null) goto L21;
    L29:
        r3 = false;
    L30:
        if (r3 == false) goto L33;
        monitor-exit(r5);     // Catch: Throwable -> L36
        return;
    L33:
        a(r6);     // Catch: Throwable -> L36
        monitor-exit(r5);     // Catch: Throwable -> L36
        return;
    L21:
        if (r7.isEmpty() == true) goto L29;
        if (this.P <= 0) goto L29;
        if (r8 < 0) goto L29;
        if (r8 >= e) goto L29;
    L36:
        th = move-exception;
        throw th;
    L5:
        if (r2.isEmpty() == true) goto L13;
        if (this.P <= 0) goto L13;
        if (r1 < 0) goto L13;
        if (r1 >= e) goto L13;
        r4 = true;
        goto L14
    }

    public void k() {
        Object r0 = this.Q;
        monitor-enter(r0);
        v();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean l() {
        return this.H.get();
    }

    public boolean m() {
        return this.I.get();
    }

    public boolean n() {
        int r0 = this.aa.get();
        int r1 = this.Z.get();
        if (r0 < 0) goto L8;
        if (r1 < r0) goto L8;
        if ((r1 - r0) < 80) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return true;
    L11:
        if (this.L.get() == false) goto L14;
        return true;
    L14:
        return false;
    L8:
        r2 = false;
        goto L9
    }

    public boolean o() {
        return this.A.get();
    }

    public boolean p() {
        return this.B.get();
    }

    public boolean q() {
        return this.C.get();
    }

    public ExecutorService r() {
        return this.z;
    }

    public void s() {
        if (this.A.get() == true) goto L7;
        com.obric.cae.log.a.d("StarLocation-util", "mLocationUiEnabled is false");
        return;
    L7:
        if (this.p != null) goto L10;
        com.obric.cae.log.a.j("StarLocation-util", "locationManager is null");
        return;
    L10:
        Object r2 = this.ac;
        monitor-enter(r2);
    L26:
        th = move-exception;
        throw th;
    L13:
        if (this.o.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) goto L15;
    L20:
        this.p.requestLocationUpdates("passive", 0, 0.0f, this.z, this.ag);     // Catch: Throwable -> L26
        com.obric.cae.log.a.d("StarLocation-util", "register passive location listener success, userId: " + this.ae.get());     // Catch: Throwable -> L26
        if (this.o.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) goto L23;
        this.p.registerGnssStatusCallback(this.z, this.ah);     // Catch: Throwable -> L26
        com.obric.cae.log.a.d("StarLocation-util", "register gnss status callback success, userId: " + this.ae.get());     // Catch: Throwable -> L26
    L24:
        monitor-exit(r2);     // Catch: Throwable -> L26
        return;
    L23:
        com.obric.cae.log.a.j("StarLocation-util", "fine location permission not satisfied");     // Catch: Throwable -> L26
        goto L24
    L15:
        if (this.o.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) goto L20;
        com.obric.cae.log.a.j("StarLocation-util", "coarse location permission not satisfied");     // Catch: Throwable -> L26
        monitor-exit(r2);     // Catch: Throwable -> L26
    }

    public void t() {
        Object r0 = this.ac;
        monitor-enter(r0);
        com.obric.cae.log.a.d("StarLocation-util", "");     // Catch: Throwable -> L9
        LocationManager r1 = this.p;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.removeUpdates(this.ag);     // Catch: Throwable -> L9
        this.p.unregisterGnssStatusCallback(this.ah);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean u() {
        if (c(this.o) != 5) goto L5;
        return true;
    L5:
        return false;
    }

    public final void v() {
        this.O = null;
        this.P = 0;
    }

    public final boolean w() {
        if (this.q != null) goto L8;
        com.obric.cae.log.a.j("StarLocation-util", "ConnectivityManager is null, network is invalid.");
        ConnectivityManager r0 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(this.o.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");
        this.q = r0;
        if (r0 != null) goto L8;
        com.obric.cae.log.a.j("StarLocation-util", "ConnectivityManager is still null after re-initialization.");
        return false;
    L8:
        Network r1 = this.q.getActiveNetwork();
        if (r1 != null) goto L12;
        com.obric.cae.log.a.f("StarLocation-util", "No active network found.");
        return false;
    L12:
        NetworkCapabilities r2 = this.q.getNetworkCapabilities(r1);
        if (r2 != null) goto L16;
        com.obric.cae.log.a.f("StarLocation-util", "NetworkCapabilities is null.");
        return false;
    L16:
        AtomicInteger r5 = this.F;
        if (r2.hasTransport(1) == false) goto L19;
        int r3 = 2;
    L20:
        r5.set((r2.hasTransport(0) ? 1 : 0) + r3);
        if (r2.hasCapability(12) == true) goto L23;
        return false;
    L23:
        if (r2.hasCapability(16) == true) goto L25;
        return false;
    L25:
        return true;
    L19:
        r3 = 0;
        goto L20
    }
}
