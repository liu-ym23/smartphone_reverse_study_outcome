package qa;

import android.app.Application;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ServiceInfo;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.service.SystemBaseLocationImpl;
import com.loc.em;
import com.loc.es;
import com.obric.cae.cloud.CloudServiceConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class x1 {
    public static boolean H = true;
    public static volatile boolean I = false;
    public static final AtomicBoolean J = null;
    public a A;
    public com.amap.api.location.a B;
    public boolean C;
    public volatile boolean D;
    public c E;
    public String F;
    public boolean G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public es f11194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f11195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AMapLocationClientOption f11196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f11197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d4 f11198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f4 f11199f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public z3 f11200g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f11201h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f11202i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList<w1.b> f11203j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f11204k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f11205l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f11206m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e4 f11207n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Messenger f11208o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Messenger f11209p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Intent f11210q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public d f11211r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f11212s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public AMapLocationClientOption.b f11213t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f11214u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public w3 f11215v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f11216w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f11217x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public AMapLocationClientOption f11218y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f11219z;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x1 f11220a;

        public a(x1 r8) {
            this.f11220a = r8;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r8, IBinder r10) {
            x1 r11 = this.f11220a;
            r11.f11208o = new Messenger(r10);     // Catch: Throwable -> L5
            r11.f11201h = true;     // Catch: Throwable -> L5
            r11.f11216w = true;     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            t3.g("ALManager", "onServiceConnected", th);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r8) {
            x1 r10 = this.f11220a;
            r10.f11208o = null;
            r10.f11201h = false;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11221a = null;

        static {
            int[] r8 = new int[AMapLocationClientOption.b.values().length];
            f11221a = r8;
            AMapLocationClientOption.b r10 = AMapLocationClientOption.b.f3666a;     // Catch: NoSuchFieldError -> L8
            r8[0] = 1;     // Catch: NoSuchFieldError -> L8
        L15:
            int[] r11 = f11221a;     // Catch: NoSuchFieldError -> L9
            AMapLocationClientOption.b r12 = AMapLocationClientOption.b.f3666a;     // Catch: NoSuchFieldError -> L9
            r11[1] = 2;     // Catch: NoSuchFieldError -> L9
        L11:
            int[] r13 = f11221a;     // Catch: NoSuchFieldError -> L10
            AMapLocationClientOption.b r14 = AMapLocationClientOption.b.f3666a;     // Catch: NoSuchFieldError -> L10
            r13[2] = 3;     // Catch: NoSuchFieldError -> L10
            return;
        }
    }

    public class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x1 f11222a;

        public c(x1 r8, Looper r10) {
            this.f11222a = r8;
            super(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public final void handleMessage(Message r14) {
            String r8 = null;
            super.handleMessage(r14);     // Catch: Throwable -> L134
            if (s3.G == false) goto L7;
            Log.e("AMapLocationClient", "SERVICE_NOT_AVAILABLE");     // Catch: Throwable -> L134
            return;
        L7:
            int r10 = r14.what;     // Catch: Throwable -> L134
            x1 r11 = this.f11222a;
            if (r10 != 11) goto L11;
            r11.e(r14.getData());     // Catch: Throwable -> L134
            return;
        L11:
            if (r10 != 12) goto L13;
            x1.g(r11, r14);     // Catch: Throwable -> L134
            return;
        L13:
            if (r10 != 16) goto L15;
            x1.i(r11, r14);     // Catch: Throwable -> L134
            return;
        L15:
            if (r10 != 1011) goto L140;
            r11.b(14, null);     // Catch: Throwable -> L134
            r11.o();     // Catch: Throwable -> L134
            return;
        L140:
            switch(r10) {
                case 1002: goto L39;
                case 1003: goto L35;
                case 1004: goto L32;
                case 1005: goto L22;
                default: goto L18;
            };
        L22:
            w1.b r13 = (w1.b) r14.obj;     // Catch: Throwable -> L134
            if (r11.f11203j.isEmpty() == true) goto L28;
            if (r11.f11203j.contains(r13) == false) goto L28;
            r11.f11203j.remove(r13);     // Catch: Throwable -> L134
        L28:
            if (r11.f11203j.isEmpty() == false) goto L144;
            r11.w();     // Catch: Throwable -> L134
            return;
        L144:
            return;
        L39:
            w1.b r15 = (w1.b) r14.obj;     // Catch: Throwable -> L134
            if (r15 != null) goto L42;
            r11.getClass();     // Catch: Throwable -> L134
            throw new IllegalArgumentException("listener参数不能为null");     // Catch: Throwable -> L134
        L42:
            if (r11.f11203j != null) goto L45;
            r11.f11203j = new ArrayList();     // Catch: Throwable -> L134
        L45:
            if (r11.f11203j.contains(r15) == true) goto L145;
            r11.f11203j.add(r15);     // Catch: Throwable -> L134
            return;
        L145:
            return;
        L18:
            switch(r10) {
                case 1014: goto L69;
                case 1015: goto L67;
                case 1016: goto L57;
                case 1017: goto L53;
                case 1018: goto L50;
                default: goto L19;
            };
        L19:
            boolean r12 = false;
            switch(r10) {
                case 1023: goto L124;
                case 1024: goto L115;
                case 1025: goto L103;
                case 1026: goto L100;
                case 1027: goto L98;
                case 1028: goto L96;
                case 1029: goto L94;
                case 1030: goto L92;
                case 1031: goto L88;
                case 1032: goto L85;
                case 1033: goto L73;
                case 1034: goto L71;
                default: goto L152;
            };
        L71:
            Bundle r16 = r14.getData();     // Catch: Throwable -> L134
            AMapLocation r17 = (AMapLocation) r16.getParcelable("mapLoc");     // Catch: Throwable -> L134
            em r18 = (em) r16.getParcelable("entity");     // Catch: Throwable -> L134
            r16.getSerializable("ex");     // Catch: Throwable -> L134
            r11.f(r17, r18);     // Catch: Throwable -> L134
            return;
        L85:
            r11.f11199f.b();     // Catch: Throwable -> L134
            r11.a(1033);     // Catch: Throwable -> L134
            return;
        L92:
            Bundle r19 = new Bundle();     // Catch: Throwable -> L134
            r19.putString("objHash", Integer.toString(System.identityHashCode(this)));     // Catch: Throwable -> L134
            r11.b(17, r19);     // Catch: Throwable -> L134
            return;
        L94:
            Bundle r110 = new Bundle();     // Catch: Throwable -> L134
            r110.putString("objHash", Integer.toString(System.identityHashCode(this)));     // Catch: Throwable -> L134
            r11.b(16, r110);     // Catch: Throwable -> L134
            return;
        L96:
            r11.p((AMapLocation) r14.obj);     // Catch: Throwable -> L134
            return;
        L98:
            r11.f11200g.a();     // Catch: Throwable -> L134
            return;
        L100:
            r11.f11200g.d(r11.f11196c);     // Catch: Throwable -> L134
            return;
        L115:
            r8 = "handleMessage ACTION_DISABLE_BACKGROUND";
            r11.getClass();     // Catch: Throwable -> L134
            Bundle r111 = r14.getData();     // Catch: Throwable -> L121
            if (r111 == null) goto L146;
            boolean r112 = r111.getBoolean("j", true);     // Catch: Throwable -> L121
            Intent r20 = r11.A();     // Catch: Throwable -> L121
            r20.putExtra("j", r112);     // Catch: Throwable -> L121
            r20.putExtra("g", 2);     // Catch: Throwable -> L121
            r11.d(r20, false);     // Catch: Throwable -> L121
        L147:
            return;
        L146:
            return;
        L121:
            th = move-exception;
            t3.g("ALManager", "doDisableBackgroundLocation", th);     // Catch: Throwable -> L134
            return;
        L124:
            x1.m(r11, r14);     // Catch: Throwable -> L134
            return;
        L152:
            return;
        L73:
            f4 r113 = r11.f11199f;     // Catch: Throwable -> L37
            AMapLocationClientOption r21 = r113.f10423d;     // Catch: Throwable -> L37
            if (r21 != null) goto L76;
        L81:
            if (r12 == false) goto L83;
            r11.f11199f.b();     // Catch: Throwable -> L37
            r11.f11199f.e(r11.f11196c);     // Catch: Throwable -> L37
        L83:
            r11.c(1033, null, 300000);     // Catch: Throwable -> L37
            return;
        L76:
            if (r21.f3652m == true) goto L81;
            if ((SystemClock.elapsedRealtime() - r113.f10428i) <= 300000) goto L81;
            r12 = true;
            goto L81
        L88:
            AMapLocationClientOption r114 = r11.f11196c;     // Catch: Throwable -> L37
            if (r114.I == false) goto L151;
            r11.f11199f.e(r114);     // Catch: Throwable -> L37
            r11.c(1033, null, 300000);     // Catch: Throwable -> L37
            return;
        L151:
            return;
        L103:
            d4 r115 = r11.f11198e;     // Catch: Throwable -> L37
            AMapLocationClientOption r22 = r115.f10310d;     // Catch: Throwable -> L37
            if (r22 != null) goto L106;
        L111:
            if (r12 == false) goto L113;
            r11.f11198e.g();     // Catch: Throwable -> L37
            r11.f11198e.d(r11.f11196c);     // Catch: Throwable -> L37
        L113:
            r11.c(1025, null, 300000);     // Catch: Throwable -> L37
            return;
        L106:
            if (r22.f3652m == true) goto L111;
            if ((SystemClock.elapsedRealtime() - r115.f10312f) <= 300000) goto L111;
            r12 = true;
            goto L111
        L50:
            AMapLocationClientOption r116 = (AMapLocationClientOption) r14.obj;     // Catch: Throwable -> L134
            r11.f11196c = r116;     // Catch: Throwable -> L134
            if (r116 == null) goto L148;
            x1.u(r11);     // Catch: Throwable -> L134
            return;
        L148:
            return;
        L53:
            r11.f11198e.g();     // Catch: Throwable -> L134
            r11.a(1025);     // Catch: Throwable -> L134
            return;
        L69:
            x1.k(r11, r14);     // Catch: Throwable -> L134
            return;
        L57:
            if (y3.F(r11.f11195b) == false) goto L61;
            x1.q(r11);     // Catch: Throwable -> L37
            return;
        L61:
            if (r11.f11198e.i() == false) goto L64;
            r11.c(1016, null, 1000);     // Catch: Throwable -> L37
            return;
        L64:
            x1.r(r11);     // Catch: Throwable -> L37
            return;
        L67:
            r11.f11198e.d(r11.f11196c);     // Catch: Throwable -> L37
            r11.c(1025, null, 300000);     // Catch: Throwable -> L37
            return;
        L32:
            r11.w();     // Catch: Throwable -> L37
            r11.b(14, null);     // Catch: Throwable -> L37
            return;
        L35:
            r11.t();     // Catch: Throwable -> L37
            r11.b(13, null);     // Catch: Throwable -> L37
            return;
        L37:
            Throwable th = th;
        L136:
            if (this != 0) goto L138;
            String this = "handleMessage";
        L138:
            t3.g("AMapLocationManage$MHandlerr", this, th);
            return;
        L134:
            th = move-exception;
            th = th;
            this = r8;
            goto L136
        }
    }

    public static class d extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x1 f11223a;

        public d(x1 r8) {
            super("amapLocManagerThread");
            this.f11223a = null;
            this.f11223a = r8;
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            x1 r8 = this.f11223a;
            r8.f11207n.b();     // Catch: Throwable -> L10
            v3.a(r8.f11195b);     // Catch: Throwable -> L10
            r8.z();     // Catch: Throwable -> L10
            if (r8 == null) goto L8;
            Context r10 = r8.f11195b;     // Catch: Throwable -> L10
            if (r10 == null) goto L8;
            s3.g(r10);     // Catch: Throwable -> L10
            s3.a(r8.f11195b);     // Catch: Throwable -> L10
        L8:
            super.onLooperPrepared();     // Catch: Throwable -> L10
            return;
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            super.run();     // Catch: Throwable -> L4
            return;
        }
    }

    public class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x1 f11224a;

        public e(x1 r8) {
            this.f11224a = r8;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r8) {
            x1 r10 = this.f11224a;
            String r11 = null;
            super.handleMessage(r8);     // Catch: Throwable -> L72
            if (r10.f11212s == false) goto L6;
            return;
        L6:
            int r12 = r8.what;     // Catch: Throwable -> L72
            if (r12 != 1) goto L10;
            Message r13 = r10.E.obtainMessage();     // Catch: Throwable -> L72
            r13.what = 11;     // Catch: Throwable -> L72
            r13.setData(r8.getData());     // Catch: Throwable -> L72
            r10.E.sendMessage(r13);     // Catch: Throwable -> L72
            return;
        L10:
            if (r12 != 2) goto L12;
        L62:
            Message r14 = Message.obtain();     // Catch: Throwable -> L72
            r14.what = 12;     // Catch: Throwable -> L72
            r14.obj = r8.obj;     // Catch: Throwable -> L72
            r10.E.sendMessage(r14);     // Catch: Throwable -> L72
            AMapLocationClientOption r15 = r10.f11218y;     // Catch: Throwable -> L72
            if (r15 != null) goto L65;
            return;
        L65:
            if (r15.C == false) goto L86;
            e r16 = r10.f11197d;     // Catch: Throwable -> L72
            if (r16 == null) goto L87;
            r16.removeMessages(13);     // Catch: Throwable -> L72
            return;
        L87:
            return;
        L86:
            return;
        L12:
            if (r12 != 17) goto L14;
            w3.a(2131, null);     // Catch: Throwable -> L72
        L60:
            Message r17 = Message.obtain();     // Catch: Throwable -> L72
            r17.what = 16;     // Catch: Throwable -> L72
            r17.obj = r8.obj;     // Catch: Throwable -> L72
            r10.E.sendMessage(r17);     // Catch: Throwable -> L72
            return;
        L14:
            if (r12 != 18) goto L16;
            Bundle r18 = r8.getData();     // Catch: Throwable -> L72
            f4 r19 = r10.f11199f;     // Catch: Throwable -> L72
            if (r19 == null) goto L84;
            r19.d(r18);     // Catch: Throwable -> L72
            return;
        L84:
            return;
        L16:
            switch(r12) {
                case 5: goto L30;
                case 6: goto L26;
                case 7: goto L24;
                case 8: goto L23;
                case 9: goto L22;
                case 10: goto L20;
                default: goto L17;
            };
        L17:
            switch(r12) {
                case 13: goto L34;
                case 14: goto L32;
                case 15: goto L60;
                default: goto L18;
            };
        L18:
            switch(r12) {
                case 100: goto L46;
                case 101: goto L47;
                case 102: goto L44;
                case 103: goto L40;
                default: goto L88;
            };
        L40:
            Bundle r20 = r8.getData();     // Catch: Throwable -> L72
            z3 r21 = r10.f11200g;     // Catch: Throwable -> L72
            if (r21 == null) goto L80;
            r21.c(r20);     // Catch: Throwable -> L72
            return;
        L80:
            return;
        L44:
            Bundle r22 = r8.getData();     // Catch: Throwable -> L72
            r22.putBundle("optBundle", t3.a(r10.f11196c));     // Catch: Throwable -> L72
            r10.b(15, r22);     // Catch: Throwable -> L72
            return;
        L46:
            w3.a(2155, null);     // Catch: Throwable -> L72
        L47:
            Message r23 = Message.obtain();     // Catch: Throwable -> L72
            r23.what = 1028;     // Catch: Throwable -> L72
            r23.obj = r8.obj;     // Catch: Throwable -> L72
            r10.E.sendMessage(r23);     // Catch: Throwable -> L72
            AMapLocationClientOption r24 = r10.f11218y;     // Catch: Throwable -> L72
            if (r24 != null) goto L50;
            return;
        L50:
            if (r24.C == false) goto L82;
            e r25 = r10.f11197d;     // Catch: Throwable -> L72
            if (r25 == null) goto L83;
            r25.removeMessages(13);     // Catch: Throwable -> L72
            return;
        L83:
            return;
        L82:
            return;
        L88:
            return;
        L32:
            Bundle r26 = r8.getData();     // Catch: Throwable -> L72
            r26.putBundle("optBundle", t3.a(r10.f11196c));     // Catch: Throwable -> L72
            r10.b(18, r26);     // Catch: Throwable -> L72
            return;
        L34:
            es r27 = r10.f11194a;     // Catch: Throwable -> L72
            if (r27 == null) goto L38;
            x1.h(r10, r27);     // Catch: Throwable -> L72
            return;
        L38:
            AMapLocation r28 = new AMapLocation(SystemBaseLocationImpl.LBS_GEOCODE_NAME);     // Catch: Throwable -> L72
            r28.v(33);     // Catch: Throwable -> L72
            x1.h(r10, r28);     // Catch: Throwable -> L72
            return;
        L20:
            x1.h(r10, (AMapLocation) r8.obj);     // Catch: Throwable -> L72
            return;
        L22:
            r8.getData().getBoolean("installMockApp");     // Catch: Throwable -> L72
            boolean r29 = x1.H;     // Catch: Throwable -> L72
            return;
        L23:
            w3.a(2141, null);     // Catch: Throwable -> L72
            goto L62
        L24:
            r8.getData().getBoolean("ngpsAble");     // Catch: Throwable -> L72
            r10.getClass();     // Catch: Throwable -> L72
            return;
        L26:
            Bundle r30 = r8.getData();     // Catch: Throwable -> L72
            d4 r31 = r10.f11198e;     // Catch: Throwable -> L72
            if (r31 == null) goto L79;
            r31.c(r30);     // Catch: Throwable -> L72
            return;
        L79:
            return;
        L30:
            Bundle r32 = r8.getData();     // Catch: Throwable -> L72
            r32.putBundle("optBundle", t3.a(r10.f11196c));     // Catch: Throwable -> L72
            r10.b(10, r32);     // Catch: Throwable -> L72
            return;
        L72:
            th = move-exception;
            if (0 != 0) goto L75;
            r11 = "handleMessage";
        L75:
            t3.g("AmapLocationManager$MainHandler", r11, th);
        }

        public e(x1 r8, Looper r10) {
            this.f11224a = r8;
            super(r10);
        }
    }

    static {
        J = new AtomicBoolean(false);
    }

    public x1(Context r8) {
        this.f11196c = new AMapLocationClientOption();
        this.f11198e = null;
        this.f11199f = null;
        this.f11201h = false;
        this.f11202i = false;
        this.f11203j = new ArrayList();
        this.f11204k = true;
        this.f11205l = true;
        this.f11206m = true;
        this.f11208o = null;
        this.f11209p = null;
        this.f11210q = null;
        this.f11211r = null;
        this.f11212s = false;
        this.f11213t = AMapLocationClientOption.b.f3668m;
        this.f11214u = new Object();
        this.f11215v = null;
        this.f11216w = false;
        this.f11217x = false;
        this.f11218y = new AMapLocationClientOption();
        this.f11219z = null;
        this.A = new a(this);
        this.B = null;
        this.C = false;
        this.D = false;
        this.E = null;
        this.F = null;
        this.G = false;
        this.f11195b = r8;
        this.f11210q = null;
    L9:
        th = move-exception;
        t3.g("ALManager", "init 1", th);
    L39:
        this.f11207n = new e4(this.f11195b);     // Catch: Throwable -> L13
    L15:
        d r10 = new d(this);     // Catch: Throwable -> L24
        this.f11211r = r10;     // Catch: Throwable -> L24
        r10.setPriority(5);     // Catch: Throwable -> L24
        this.f11211r.start();     // Catch: Throwable -> L24
        Looper r11 = this.f11211r.getLooper();     // Catch: Throwable -> L24
        Object r12 = this.f11214u;     // Catch: Throwable -> L24
        monitor-enter(r12);     // Catch: Throwable -> L24
        c r13 = new c(this, r11);     // Catch: Throwable -> L21
        monitor-exit(r12);     // Catch: Throwable -> L21
        this.E = r13;     // Catch: Throwable -> L24
    L43:
        this.f11198e = new d4(this.f11195b, this.f11197d);     // Catch: Throwable -> L28
        this.f11199f = new f4(this.f11195b, this.f11197d);     // Catch: Throwable -> L28
        this.f11200g = new z3(this.f11195b, this.f11197d);     // Catch: Throwable -> L28
    L31:
        if (this.f11215v != null) goto L33;
        this.f11215v = new w3();
    L33:
        Context r14 = this.f11195b;
        if (J.compareAndSet(false, true) == false) goto L45;
        l1.f10784d.a(new w1(r14));
        return;
    L45:
        return;
    L28:
        th = move-exception;
        t3.g("ALManager", "init 3", th);
        goto L31
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        t3.g("ALManager", "init 5", th);
    L13:
        th = move-exception;
        t3.g("ALManager", "init 2", th);     // Catch: Throwable -> L24
        goto L15
    L4:
        if (Looper.myLooper() != null) goto L6;
        e r15 = new e(this, r8.getMainLooper());     // Catch: Throwable -> L9
    L7:
        this.f11197d = r15;     // Catch: Throwable -> L9
        goto L39
    L6:
        r15 = new e(this);     // Catch: Throwable -> L9
        goto L7
    }

    public static void g(x1 r8, Message r10) {
        r8.getClass();
        AMapLocation r11 = (AMapLocation) r10.obj;     // Catch: Throwable -> L13
        r11.getLongitude();     // Catch: Throwable -> L13
        r11.getLatitude();     // Catch: Throwable -> L13
        if (r8.f11204k == true) goto L6;
    L11:
        r8.f(r11, null);     // Catch: Throwable -> L13
        r8.a(1025);     // Catch: Throwable -> L13
        r8.c(1025, null, 300000);     // Catch: Throwable -> L13
        return;
    L6:
        if (r8.f11208o == null) goto L11;
        Bundle r12 = new Bundle();     // Catch: Throwable -> L13
        r12.putBundle("optBundle", t3.a(r8.f11196c));     // Catch: Throwable -> L13
        r8.b(0, r12);     // Catch: Throwable -> L13
        if (r8.f11202i == false) goto L10;
        r8.b(13, null);     // Catch: Throwable -> L13
    L10:
        r8.f11204k = false;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        t3.g("ALManager", "resultGpsLocationSuccess", th);
    }

    public static void h(x1 r8, AMapLocation r10) {
        r8.getClass();
        boolean r11 = false;
        if (r10.f3646w == 0) goto L7;
        r10.x(0);     // Catch: Throwable -> L49
    L7:
        if (r10.f3646w != 0) goto L22;
        double r12 = r10.getLatitude();     // Catch: Throwable -> L49
        double r13 = r10.getLongitude();     // Catch: Throwable -> L49
        if (r12 != 0.0d) goto L13;
        if (r13 != 0.0d) goto L13;
    L20:
        w3.l("errorLatLng", r10.z());     // Catch: Throwable -> L49
        r10.x(0);     // Catch: Throwable -> L49
        r10.v(8);     // Catch: Throwable -> L49
        r10.f3648y = "LatLng is error#0802";     // Catch: Throwable -> L49
    L13:
        if (r12 < (-90.0d)) goto L20;
        if (r12 > 90.0d) goto L20;
        if (r13 < (-180.0d)) goto L20;
        if (r13 > 180.0d) goto L20;
    L22:
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equalsIgnoreCase(r10.getProvider()) == false) goto L24;
    L32:
        r10.setAltitude(((long) (r10.getAltitude() * 100.0d)) / 100.0d);     // Catch: Throwable -> L49
        r10.setBearing((float) (((long) (((double) r10.getBearing()) * 100.0d)) / 100.0d));     // Catch: Throwable -> L49
        r10.setSpeed((float) (((long) (((double) r10.getSpeed()) * 100.0d)) / 100.0d));     // Catch: Throwable -> L49
        r8.j(r10);     // Catch: Throwable -> L49
        int r14 = r10.f3649z;     // Catch: Throwable -> L47
        if (2 != r14) goto L36;
    L37:
        long r15 = r10.getTime();     // Catch: Throwable -> L47
        long r16 = System.currentTimeMillis();     // Catch: Throwable -> L47
        if (r16 <= r15) goto L40;
        r10.setTime(r16);     // Catch: Throwable -> L47
        goto L40
    L36:
        if (4 == r14) goto L37;
    L40:
        r10.getProvider();     // Catch: Throwable -> L49
        r10.getLongitude();     // Catch: Throwable -> L49
        r10.getLatitude();     // Catch: Throwable -> L49
        Iterator<w1.b> r17 = r8.f11203j.iterator();     // Catch: Throwable -> L49
    L41:
        if (r17.hasNext() == false) goto L60;
        r17.next().onLocationChanged(r10);     // Catch: Throwable -> L48
        goto L41
    L60:
        return;
    L24:
        if (r8.f11198e.i() == false) goto L32;
        if ("network".equalsIgnoreCase(r10.getProvider()) == true) goto L32;
        f4 r18 = r8.f11199f;     // Catch: Throwable -> L49
        r18.getClass();     // Catch: Throwable -> L49
        if ((SystemClock.elapsedRealtime() - r18.f10428i) > 2800) goto L31;
        r11 = true;
    L31:
        if (r11 == false) goto L32;
        return;
    }

    public static void i(x1 r8, Message r10) {
        r8.getClass();
        AMapLocation r11 = (AMapLocation) r10.obj;     // Catch: Throwable -> L16
        r11.getLongitude();     // Catch: Throwable -> L16
        r11.getLatitude();     // Catch: Throwable -> L16
        if (r8.f11206m == false) goto L12;
        if (r8.f11208o == null) goto L12;
        Bundle r12 = new Bundle();     // Catch: Throwable -> L16
        r12.putBundle("optBundle", t3.a(r8.f11196c));     // Catch: Throwable -> L16
        r8.b(0, r12);     // Catch: Throwable -> L16
        if (r8.f11202i == false) goto L10;
        r8.b(13, null);     // Catch: Throwable -> L16
    L10:
        r8.f11206m = false;     // Catch: Throwable -> L16
    L12:
        if (r8.f11217x == false) goto L14;
        r8.a(1034);     // Catch: Throwable -> L16
        r8.f(r11, null);     // Catch: Throwable -> L16
    L14:
        r8.a(1033);     // Catch: Throwable -> L16
        r8.c(1033, null, 300000);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        t3.g("ALManager", "resultNetworkLocationSuccess", th);
    }

    public static void k(x1 r8, Message r10) {
        r8.getClass();
        Bundle r11 = r10.getData();     // Catch: Throwable -> L24
        AMapLocation r12 = (AMapLocation) r11.getParcelable("loc");     // Catch: Throwable -> L24
        String r13 = r11.getString("lastLocNb");     // Catch: Throwable -> L24
        if (r12 == null) goto L21;
        j3 r14 = e4.f10377g;     // Catch: Throwable -> L27
        if (r14 != null) goto L18;
        e4 r15 = r8.f11207n;     // Catch: Throwable -> L27
        if (r15 == null) goto L17;
        r15.e();     // Catch: Throwable -> L27
        j3 r16 = e4.f10377g;     // Catch: Throwable -> L27
        if (r16 == null) goto L17;
        if (y3.k(r16.f10631d) == false) goto L17;
        AMapLocation r17 = e4.f10377g.f10631d;     // Catch: Throwable -> L27
    L19:
        w3.k(r17, r12);     // Catch: Throwable -> L27
    L17:
        r17 = null;
        goto L19
    L18:
        r17 = r14.f10631d;     // Catch: Throwable -> L27
    L21:
        if (r8.f11207n.c(r12, r13) == false) goto L32;
        r8.f11207n.d();     // Catch: Throwable -> L24
        return;
    L32:
        return;
    L24:
        th = move-exception;
        t3.g("ALManager", "doSaveLastLocation", th);
    }

    public static void m(x1 r8, Message r10) {
        r8.getClass();
        if (r10 == null) goto L16;
        Bundle r11 = r10.getData();     // Catch: Throwable -> L10
        if (r11 == null) goto L15;
        int r12 = r11.getInt("i", 0);     // Catch: Throwable -> L10
        Notification r13 = (Notification) r11.getParcelable("h");     // Catch: Throwable -> L10
        Intent r14 = r8.A();     // Catch: Throwable -> L10
        r14.putExtra("i", r12);     // Catch: Throwable -> L10
        r14.putExtra("h", r13);     // Catch: Throwable -> L10
        r14.putExtra("g", 1);     // Catch: Throwable -> L10
        r8.d(r14, true);     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        t3.g("ALManager", "doEnableBackgroundLocation", th);
        return;
    }

    public static void q(x1 r8) {
        r8.getClass();
        new em().f5204r = "#2001";     // Catch: Throwable -> L5
        w3.a(2153, null);     // Catch: Throwable -> L5
        es r10 = new es();     // Catch: Throwable -> L5
        r10.v(20);     // Catch: Throwable -> L5
        r10.f3648y = "模糊权限下不支持低功耗定位#2001";     // Catch: Throwable -> L5
        r8.p(r10);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        t3.g("ALManager", "apsLocation:callback", th);
    }

    public static void r(x1 r8) {
        r8.getClass();
    L29:
        th = move-exception;
        t3.g("ALManager", "doLBSLocation", th);     // Catch: Throwable -> L35
        if (r8.f11196c.f3652m == true) goto L51;
    L33:
        r8.y();     // Catch: Throwable -> L40
        return;
    L51:
        return;
    L35:
        th = move-exception;
        if (r8.f11196c.f3652m == true) goto L39;
        r8.y();     // Catch: Throwable -> L41
    L39:
        throw th;
    L4:
        if (H == false) goto L6;
    L25:
        H = false;     // Catch: Throwable -> L29
        r8.D = true;     // Catch: Throwable -> L29
        r8.x();     // Catch: Throwable -> L29
    L27:
        if (r8.f11196c.f3652m == false) goto L33;
        return;
    L6:
        if (r8.f11216w == false) goto L8;
    L44:
    L18:
        th = move-exception;
        r8.C = true;     // Catch: Throwable -> L29
        t3.g("ALManager", "doLBSLocation reStartService", th);     // Catch: Throwable -> L29
    L21:
        if (r8.s() == false) goto L27;
        r8.C = false;     // Catch: Throwable -> L29
        Bundle r10 = new Bundle();     // Catch: Throwable -> L29
        r10.putBundle("optBundle", t3.a(r8.f11196c));     // Catch: Throwable -> L29
        int r11 = w1.e.f12964a;     // Catch: Throwable -> L29
        r10.putString("d", null);     // Catch: Throwable -> L29
        if (r8.f11198e.i() == true) goto L27;
        r8.b(1, r10);     // Catch: Throwable -> L29
        goto L27
    L11:
        if (r8.f11216w == false) goto L21;
        if (r8.f11201h == true) goto L21;
        if (r8.C == true) goto L21;
        r8.C = true;     // Catch: Throwable -> L18
        r8.z();     // Catch: Throwable -> L18
        goto L52
    L8:
        if (r8.D == true) goto L44;
    }

    public static void u(x1 r10) {
        d4 r8 = r10.f11198e;
        AMapLocationClientOption r11 = r10.f11196c;
        if (r11 != null) goto L5;
        r8.getClass();
        r11 = new AMapLocationClientOption();
    L5:
        r8.f10310d = r11;
        if (r11.f3657r == AMapLocationClientOption.b.f3667b) goto L11;
        Handler r12 = r8.f10307a;
        if (r12 == null) goto L11;
        r12.removeMessages(8);
    L11:
        if (r8.f10325s == r8.f10310d.B) goto L20;
        Object r13 = r8.f10321o;
        monitor-enter(r13);
        d4.G = null;     // Catch: Throwable -> L17
        monitor-exit(r13);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L20:
        r8.f10325s = r8.f10310d.B;
        z3 r14 = r10.f11200g;
        AMapLocationClientOption r15 = r10.f11196c;
        if (r15 != null) goto L23;
        r14.getClass();
        r15 = new AMapLocationClientOption();
    L23:
        r14.f11283l = r15;
        r14.f11283l.toString();
        r14.f11278g.removeMessages(100);
        if (r14.f11285n == r14.f11283l.B) goto L33;
        Object r16 = r14.f11284m;
        monitor-enter(r16);
        z3.f11271u = null;     // Catch: Throwable -> L30
        monitor-exit(r16);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    L33:
        r14.f11285n = r14.f11283l.B;
        if (r10.f11202i == true) goto L36;
    L38:
        AMapLocationClientOption r17 = r10.f11196c;
        r10.f11213t = r17.f3657r;
        w3 r18 = r10.f11215v;
        if (r18 != null) goto L41;
        return;
    L41:
        if (r17.f3652m == false) goto L43;
        r18.d(r10.f11195b, 0);
    L44:
        w3 r19 = r10.f11215v;
        Context r20 = r10.f11195b;
        AMapLocationClientOption r110 = r10.f11196c;
        r19.getClass();
        int r111 = w3.a.f11192a[r110.f3657r.ordinal()];     // Catch: Throwable -> L65
        if (r111 != 1) goto L48;
        int r21 = 4;
    L54:
        int r112 = r19.f11190e;     // Catch: Throwable -> L65
        if (r112 != r21) goto L58;
        return;
    L58:
        if (r112 == (-1)) goto L63;
        if (r112 == r21) goto L63;
        long r22 = SystemClock.elapsedRealtime() - r19.f11191f;
        SparseArray<Long> r113 = r19.f11186a;
        r113.append(r19.f11190e, Long.valueOf(r22 + r113.get(r19.f11190e, 0L).longValue()));     // Catch: Throwable -> L65
    L63:
        r19.f11191f = SystemClock.elapsedRealtime() - x3.b(r20, "pref1", r19.f11189d[r21], 0);     // Catch: Throwable -> L65
        r19.f11190e = r21;     // Catch: Throwable -> L65
        return;
    L48:
        if (r111 == 2) goto L52;
        r21 = 3;
        if (r111 == 3) goto L54;
        r21 = -1;
        goto L54
    L52:
        r21 = 5;
    L65:
        th = move-exception;
        t3.g("ReportUtil", "setLocationMode", th);
        return;
    L43:
        r18.d(r10.f11195b, 1);
        goto L44
    L36:
        if (r10.f11196c.f3657r.equals(r10.f11213t) == true) goto L38;
        r10.w();
        r10.t();
        goto L38
    }

    public final Intent A() {
        Intent r8 = this.f11210q;
        Context r10 = this.f11195b;
        if (r8 != null) goto L14;
        this.f11210q = new Intent(r10, w1.c.class);
    L14:
        String r11 = AMapLocationClientOption.M;     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r11) == false) goto L12;
        r11 = h4.g(r10);     // Catch: Throwable -> L10
    L12:
        this.f11210q.putExtra("a", r11);
        this.f11210q.putExtra("b", h4.d(r10));
        Intent r12 = this.f11210q;
        int r13 = w1.e.f12964a;
        r12.putExtra("d", null);
        return this.f11210q;
    L10:
        th = move-exception;
        t3.g("ALManager", "startServiceImpl p2", th);
        r11 = "";
        goto L12
    }

    public final void a(int r8) {
        Object r10 = this.f11214u;
        monitor-enter(r10);
        c r11 = this.E;     // Catch: Throwable -> L9
        if (r11 == null) goto L7;
        r11.removeMessages(r8);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void b(int r8, Bundle r10) {
        if (r10 != null) goto L5;
        r10 = new Bundle();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if ((th instanceof IllegalStateException) == true) goto L15;
    L17:
        boolean r11 = false;
    L19:
        if ((th instanceof RemoteException) == true) goto L21;
        if (r11 == true) goto L21;
    L22:
        t3.g("ALManager", "sendLocMessage", th);
        return;
    L21:
        this.f11208o = null;
        this.f11201h = false;
        goto L22
    L15:
        if (th.getMessage().contains("sending message to a Handler on a dead thread") == false) goto L17;
        r11 = true;
    L5:
        if (TextUtils.isEmpty(this.f11219z) == false) goto L7;
        this.f11219z = l6.a.j(h4.f(this.f11195b));     // Catch: Throwable -> L11
    L7:
        r10.putString("c", this.f11219z);     // Catch: Throwable -> L11
        Message r12 = Message.obtain();     // Catch: Throwable -> L11
        r12.what = r8;     // Catch: Throwable -> L11
        r12.setData(r10);     // Catch: Throwable -> L11
        r12.replyTo = this.f11209p;     // Catch: Throwable -> L11
        Messenger r13 = this.f11208o;     // Catch: Throwable -> L11
        if (r13 == null) goto L26;
        r13.send(r12);     // Catch: Throwable -> L11
        return;
    }

    public final void c(int r8, Object r10, long r11) {
        Object r12 = this.f11214u;
        monitor-enter(r12);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.E == null) goto L11;
        Message r13 = Message.obtain();     // Catch: Throwable -> L13
        r13.what = r8;     // Catch: Throwable -> L13
        if ((r10 instanceof Bundle) == false) goto L9;
        r13.setData((Bundle) r10);     // Catch: Throwable -> L13
    L10:
        this.E.sendMessageDelayed(r13, r11);     // Catch: Throwable -> L13
        goto L11
    L9:
        r13.obj = r10;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r12);     // Catch: Throwable -> L13
    }

    public final void d(Intent r8, boolean r10) {
        Context r11 = this.f11195b;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r10 == true) goto L7;
    L22:
        r11.startService(r8);
    L23:
        this.G = true;
        return;
    L7:
        if (r11.getApplicationInfo().targetSdkVersion < 28) goto L9;
        boolean r12 = true;
    L10:
        if (r12 == true) goto L26;
    L16:
        boolean r13 = true;
    L17:
        if (r13 == true) goto L28;
        Log.e("amapapi", "-------------调用后台定位服务，缺少权限：android.permission.FOREGROUND_SERVICE--------------");
        return;
    L28:
        r11.getClass().getMethod("startForegroundService", new Class[]{Intent.class}).invoke(r11, new Object[]{r8});     // Catch: Throwable -> L25
    L26:
        int r14 = ((Integer) l6.a.g(((Application) r11.getApplicationContext()).getBaseContext(), "checkSelfPermission", new Object[]{"android.permission.FOREGROUND_SERVICE"})).intValue();     // Catch: Throwable -> L13
    L14:
        if (r14 == 0) goto L16;
        r13 = false;
    L13:
        r14 = -1;
        goto L14
    L9:
        r12 = false;
        goto L10
    }

    public final void e(Bundle r8) {
        AMapLocation r10 = null;
        if (r8 != null) goto L36;
        em r11 = null;
        AMapLocation r12 = null;
    L15:
        d4 r13 = this.f11198e;     // Catch: Throwable -> L28
        if (r13 == null) goto L19;
        r12 = r13.a(r12, this.F);     // Catch: Throwable -> L28
    L19:
        if (this.f11199f != null) goto L21;
    L27:
        AMapLocation r14 = r12;
        th = null;
        r10 = r14;
    L31:
        if (y3.k(r10) == false) goto L34;
        this.f11217x = false;
        f(r10, r11);
        return;
    L34:
        this.f11217x = true;
        Bundle r15 = new Bundle();
        r15.putParcelable("mapLoc", r10);
        r15.putParcelable("entity", r11);
        r15.putSerializable("ex", th);
        c(1034, r15, 10000);
        return;
    L21:
        if (y3.k(r12) == true) goto L23;
    L26:
        r12 = this.f11199f.a(r12, this.F);     // Catch: Throwable -> L28
    L28:
        th = th;
    L29:
        t3.g("AmapLocationManager", "resultLbsLocationSuccess", th);
        goto L31
    L23:
        if (this.f11196c.f3654o == false) goto L27;
        if (TextUtils.isEmpty(r12.f3638o) == false) goto L27;
    L36:
        r8.setClassLoader(AMapLocation.class.getClassLoader());     // Catch: Throwable -> L12
        r12 = (AMapLocation) r8.getParcelable("loc");     // Catch: Throwable -> L12
        r12.getLongitude();     // Catch: Throwable -> L12
        r12.getLatitude();     // Catch: Throwable -> L12
        r12.setProvider("lbs");     // Catch: Throwable -> L12
        this.F = r8.getString("nb");     // Catch: Throwable -> L12
        r11 = (em) r8.getParcelable("statics");     // Catch: Throwable -> L12
        if (r12.f3646w != 0) goto L15;
        d4 r16 = this.f11198e;     // Catch: Throwable -> L28
        if (r16 == null) goto L15;
        r16.f10327u = 0;     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r12.f3638o) == true) goto L15;
        d4.G = r12;     // Catch: Throwable -> L28
        f4.B = r12;     // Catch: Throwable -> L28
    L12:
        th = th;
        r11 = null;
        goto L29
    }

    public final synchronized void f(AMapLocation r8, em r10) {
        monitor-enter(this);
        if (r8 != null) goto L6;
        r8 = new AMapLocation("");     // Catch: Throwable -> L46
        r8.v(8);     // Catch: Throwable -> L46
        r8.f3648y = "amapLocation is null#0801";     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        t3.g("ALManager", "handlerLocation part3", th);     // Catch: Throwable -> L50
        return;
    L50:
        th = move-exception;
        throw th;
    L6:
        if (this.B != null) goto L8;
        this.B = new com.amap.api.location.a();     // Catch: Throwable -> L46
    L8:
        com.amap.api.location.a r11 = this.B;     // Catch: Throwable -> L46
        AMapLocationClientOption.b r12 = this.f11196c.f3657r;     // Catch: Throwable -> L46
        r11.getClass();     // Catch: Throwable -> L46
        d4 r13 = this.f11198e;     // Catch: Throwable -> L46
        if (r13 == null) goto L20;
        LocationManager r14 = r13.f10309c;     // Catch: Throwable -> L46
        if (r14 == null) goto L20;
        if (d4.f(r14) == false) goto L20;
        if (Settings.Secure.getInt(r13.f10308b.getContentResolver(), LocationMonitorConst.LOCATION_MODE, 0) == 0) goto L20;
    L20:
        y3.C(this.f11195b);     // Catch: Throwable -> L46
        this.B.getClass();     // Catch: Throwable -> L46
        y3.D(this.f11195b);     // Catch: Throwable -> L46
        if (r8.f3649z != 1) goto L23;
    L24:
        this.B.getClass();     // Catch: Throwable -> L46
    L25:
        if (r10 == null) goto L27;
        this.B.getClass();     // Catch: Throwable -> L46
    L27:
        com.amap.api.location.a r15 = this.B;     // Catch: Throwable -> L46
        r15.getClass();     // Catch: Throwable -> L46
        r8.P = r15;     // Catch: Throwable -> L46
    L35:
        th = move-exception;
        t3.g("ALManager", "handlerLocation part2", th);     // Catch: Throwable -> L46
    L38:
        if (this.f11212s == false) goto L42;
        monitor-exit(this);
        return;
    L42:
        if (this.f11196c.f3652m == false) goto L44;
        w();     // Catch: Throwable -> L46
        b(14, null);     // Catch: Throwable -> L46
    L44:
        monitor-exit(this);
        return;
    L29:
        if (this.f11202i == false) goto L38;
        String r16 = this.F;     // Catch: Throwable -> L35
        Bundle r17 = new Bundle();     // Catch: Throwable -> L35
        r17.putParcelable("loc", r8);     // Catch: Throwable -> L35
        r17.putString("lastLocNb", r16);     // Catch: Throwable -> L35
        c(1014, r17, 0);     // Catch: Throwable -> L35
        if (r10 == null) goto L33;
        r10.f5198b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L35
    L33:
        w3.h(this.f11195b, r8, r10);     // Catch: Throwable -> L35
        w3.g(this.f11195b, r8);     // Catch: Throwable -> L35
        l(r8.t());     // Catch: Throwable -> L35
        v3.a(this.f11195b).b(r8);     // Catch: Throwable -> L35
        v3.a(this.f11195b).c();     // Catch: Throwable -> L35
    L23:
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equalsIgnoreCase(r8.getProvider()) == false) goto L25;
        goto L24
    }

    public final void j(AMapLocation r8) {
        Context r10 = this.f11195b;
        if (r8 == null) goto L38;
        String r11 = r8.f3648y;     // Catch: Throwable -> L35
        if (TextUtils.isEmpty(r11) == false) goto L7;
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L35
    L8:
        boolean r13 = y3.y(r10, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF");     // Catch: Throwable -> L35
        boolean r14 = y3.y(r10, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF");     // Catch: Throwable -> L35
        boolean r15 = y3.y(r10, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==");     // Catch: Throwable -> L35
        boolean r16 = y3.y(r10, "EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=");     // Catch: Throwable -> L35
        boolean r17 = y3.y(r10, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O");     // Catch: Throwable -> L35
        boolean r18 = y3.y(r10, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=");     // Catch: Throwable -> L35
        if (r13 == false) goto L11;
        String r19 = "#pm1";
    L12:
        r12.append(r19);     // Catch: Throwable -> L35
        String r20 = "1";
        if (r14 == false) goto L16;
        String r21 = "1";
    L17:
        r12.append(r21);     // Catch: Throwable -> L35
        if (r15 == false) goto L20;
        String r22 = "1";
    L21:
        r12.append(r22);     // Catch: Throwable -> L35
        if (r16 == false) goto L24;
        String r23 = "1";
    L25:
        r12.append(r23);     // Catch: Throwable -> L35
        if (r17 == false) goto L28;
        String r24 = "1";
    L29:
        r12.append(r24);     // Catch: Throwable -> L35
        if (r18 == true) goto L33;
        r20 = "0";
    L33:
        r12.append(r20);     // Catch: Throwable -> L35
        r8.f3648y = r12.toString();     // Catch: Throwable -> L35
        return;
    L28:
        r24 = "0";
        goto L29
    L24:
        r23 = "0";
        goto L25
    L20:
        r22 = "0";
        goto L21
    L16:
        r21 = "0";
        goto L17
    L11:
        r19 = "#pm0";
        goto L12
    L7:
        r12 = new StringBuilder(r11);     // Catch: Throwable -> L35
    L39:
        return;
    }

    public final void l(AMapLocation r8) {
        Message r10 = this.f11197d.obtainMessage();
        r10.what = 10;
        r10.obj = r8;
        this.f11197d.sendMessage(r10);
    }

    public final synchronized void n(AMapLocation r8) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            monitor-enter(r3)
            if (r4 != 0) goto L13
            com.amap.api.location.AMapLocation r4 = new com.amap.api.location.AMapLocation     // Catch: java.lang.Throwable -> L9e
            java.lang.String r0 = ""
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L9e
            r0 = 8
            r4.v(r0)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r0 = "coarse amapLocation is null#2005"
            r4.f3648y = r0     // Catch: java.lang.Throwable -> L9e
        L13:
            com.amap.api.location.a r0 = r3.B     // Catch: java.lang.Throwable -> L9e
            if (r0 != 0) goto L1e
            com.amap.api.location.a r0 = new com.amap.api.location.a     // Catch: java.lang.Throwable -> L9e
            r0.<init>()     // Catch: java.lang.Throwable -> L9e
            r3.B = r0     // Catch: java.lang.Throwable -> L9e
        L1e:
            com.amap.api.location.a r0 = r3.B     // Catch: java.lang.Throwable -> L9e
            com.amap.api.location.AMapLocationClientOption r1 = r3.f11196c     // Catch: java.lang.Throwable -> L9e
            com.amap.api.location.AMapLocationClientOption$b r1 = r1.f3657r     // Catch: java.lang.Throwable -> L9e
            r0.getClass()     // Catch: java.lang.Throwable -> L9e
            qa.z3 r0 = r3.f11200g     // Catch: java.lang.Throwable -> L9e
            if (r0 == 0) goto L48
            android.location.LocationManager r1 = r0.f11282k     // Catch: java.lang.Throwable -> L9e
            if (r1 != 0) goto L30
            goto L48
        L30:
            boolean r1 = qa.z3.f(r1)     // Catch: java.lang.Throwable -> L9e
            if (r1 != 0) goto L37
            goto L48
        L37:
            android.content.Context r0 = r0.f11279h     // Catch: java.lang.Throwable -> L9e
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L9e
            java.lang.String r1 = "location_mode"
            r2 = 0
            int r0 = android.provider.Settings.Secure.getInt(r0, r1, r2)     // Catch: java.lang.Throwable -> L9e
            if (r0 != 0) goto L47
            goto L48
        L47:
            r1 = 2
        L48:
            android.content.Context r0 = r3.f11195b     // Catch: java.lang.Throwable -> L9e
            qa.y3.C(r0)     // Catch: java.lang.Throwable -> L9e
            com.amap.api.location.a r0 = r3.B     // Catch: java.lang.Throwable -> L9e
            r0.getClass()     // Catch: java.lang.Throwable -> L9e
            android.content.Context r0 = r3.f11195b     // Catch: java.lang.Throwable -> L9e
            qa.y3.D(r0)     // Catch: java.lang.Throwable -> L9e
            com.amap.api.location.a r0 = r3.B     // Catch: java.lang.Throwable -> L9e
            r0.getClass()     // Catch: java.lang.Throwable -> L9e
            r4.P = r0     // Catch: java.lang.Throwable -> L9e
            boolean r0 = r3.f11202i     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto L89
            android.content.Context r0 = r3.f11195b     // Catch: java.lang.Throwable -> L81
            qa.w3.g(r0, r4)     // Catch: java.lang.Throwable -> L81
            com.amap.api.location.AMapLocation r0 = r4.t()     // Catch: java.lang.Throwable -> L81
            r3.l(r0)     // Catch: java.lang.Throwable -> L81
            android.content.Context r0 = r3.f11195b     // Catch: java.lang.Throwable -> L81
            qa.v3 r0 = qa.v3.a(r0)     // Catch: java.lang.Throwable -> L81
            r0.b(r4)     // Catch: java.lang.Throwable -> L81
            android.content.Context r4 = r3.f11195b     // Catch: java.lang.Throwable -> L81
            qa.v3 r4 = qa.v3.a(r4)     // Catch: java.lang.Throwable -> L81
            r4.c()     // Catch: java.lang.Throwable -> L81
            goto L89
        L81:
            r4 = move-exception
            java.lang.String r0 = "ALManager"
            java.lang.String r1 = "handlerCoarseLocation part"
            qa.t3.g(r0, r1, r4)     // Catch: java.lang.Throwable -> L9e
        L89:
            boolean r4 = r3.f11212s     // Catch: java.lang.Throwable -> L9e
            if (r4 == 0) goto L8f
            monitor-exit(r3)
            return
        L8f:
            qa.z3 r4 = r3.f11200g     // Catch: java.lang.Throwable -> L9e
            if (r4 == 0) goto L96
            r3.w()     // Catch: java.lang.Throwable -> L9e
        L96:
            r4 = 14
            r0 = 0
            r3.b(r4, r0)     // Catch: java.lang.Throwable -> L9e
            monitor-exit(r3)
            return
        L9e:
            r4 = move-exception
            java.lang.String r0 = "ALManager"
            java.lang.String r1 = "handlerCoarseLocation part2"
            qa.t3.g(r0, r1, r4)     // Catch: java.lang.Throwable -> La8
            monitor-exit(r3)
            return
        La8:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: qa.x1.n(com.amap.api.location.AMapLocation):void");
    }

    public final void o() {
        b(12, null);
        this.f11204k = true;
        this.f11206m = true;
        this.f11205l = true;
        this.f11201h = false;
        this.f11216w = false;
        w();
        w3 r8 = this.f11215v;
        if (r8 == null) goto L25;
        Context r10 = this.f11195b;
        String[] r11 = r8.f11189d;
        long r12 = SystemClock.elapsedRealtime() - r8.f11188c;     // Catch: Throwable -> L23
        int r13 = r8.f11187b;     // Catch: Throwable -> L23
        SparseArray<Long> r14 = r8.f11186a;
        if (r13 == (-1)) goto L9;
        r14.append(r8.f11187b, Long.valueOf(r12 + r14.get(r13, 0L).longValue()));     // Catch: Throwable -> L23
    L9:
        long r15 = SystemClock.elapsedRealtime() - r8.f11191f;     // Catch: Throwable -> L23
        int r16 = r8.f11190e;     // Catch: Throwable -> L23
        if (r16 == (-1)) goto L12;
        r14.append(r8.f11190e, Long.valueOf(r15 + r14.get(r16, 0L).longValue()));     // Catch: Throwable -> L23
    L12:
        SharedPreferences.Editor r17 = r10.getSharedPreferences("pref1", 0).edit();     // Catch: Throwable -> L23
        int r18 = 0;
    L14:
        if (r18 >= r11.length) goto L21;
        long r19 = r14.get(r18, 0L).longValue();     // Catch: Throwable -> L23
        if (r19 <= 0) goto L20;
        if (r19 <= x3.b(r10, "pref1", r11[r18], 0)) goto L20;
        x3.g(r17, r11[r18], r19);     // Catch: Throwable -> L23
    L20:
        r18 = r18 + 1;     // Catch: Throwable -> L23
        goto L14
    L21:
        x3.e(r17);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        t3.g("ReportUtil", "saveLocationTypeAndMode", th);
    L25:
        v3 r20 = v3.a(this.f11195b);
        monitor-enter(r20);
    L66:
        th = move-exception;
        throw th;
    L28:
        if (r20.f11169e == false) goto L30;
        r20.e();     // Catch: Throwable -> L66
        r20.f11169e = false;     // Catch: Throwable -> L66
    L30:
        monitor-exit(r20);
        w3.c(this.f11195b);
        a r21 = this.A;
        if (r21 == null) goto L80;
        this.f11195b.unbindService(r21);
    L80:
        if (this.G == false) goto L37;
        this.f11195b.stopService(A());     // Catch: Throwable -> L69
    L37:
        this.G = false;
        ArrayList<w1.b> r22 = this.f11203j;
        if (r22 == null) goto L40;
        r22.clear();
        this.f11203j = null;
    L40:
        this.A = null;
        Object r23 = this.f11214u;
        monitor-enter(r23);
        c r24 = this.E;     // Catch: Throwable -> L63
        if (r24 == null) goto L45;
        r24.removeCallbacksAndMessages(null);     // Catch: Throwable -> L63
    L45:
        this.E = null;     // Catch: Throwable -> L63
        monitor-exit(r23);     // Catch: Throwable -> L63
        d r25 = this.f11211r;
        if (r25 != null) goto L76;
    L52:
        this.f11211r = null;
        e r26 = this.f11197d;
        if (r26 == null) goto L55;
        r26.removeCallbacksAndMessages(null);
    L55:
        e4 r27 = this.f11207n;
        if (r27 == null) goto L86;
        r27.d();     // Catch: Throwable -> L59
        r27.f10384e = 0;     // Catch: Throwable -> L59
        r27.f10385f = false;     // Catch: Throwable -> L59
        r27.f10382c = null;     // Catch: Throwable -> L59
        r27.f10383d = null;     // Catch: Throwable -> L59
    L61:
        this.f11207n = null;
        return;
    L59:
        th = move-exception;
        t3.g("LastLocationManager", "destroy", th);
        goto L61
    L86:
        return;
    L76:
        l6.a.f(r25, HandlerThread.class, "quitSafely", new Object[0]);     // Catch: Throwable -> L51
    L51:
        this.f11211r.quit();
    L63:
        th = move-exception;
        throw th;
    }

    public final void p(AMapLocation r8) {
    L12:
        th = move-exception;
        t3.g("ALManager", "resultGpsLocationSuccess", th);
        return;
    L3:
        if (this.f11205l == true) goto L5;
    L10:
        n(r8);     // Catch: Throwable -> L12
        return;
    L5:
        if (this.f11208o == null) goto L10;
        Bundle r10 = new Bundle();     // Catch: Throwable -> L12
        r10.putBundle("optBundle", t3.a(this.f11196c));     // Catch: Throwable -> L12
        b(0, r10);     // Catch: Throwable -> L12
        if (this.f11202i == false) goto L9;
        b(13, null);     // Catch: Throwable -> L12
    L9:
        this.f11205l = false;     // Catch: Throwable -> L12
        goto L10
    }

    public final boolean s() {
        Context r8 = this.f11195b;
        boolean r10 = false;
        int r11 = 0;
    L43:
    L23:
        th = move-exception;
        t3.g("ALManager", "checkAPSManager", th);
    L25:
        boolean r12 = false;
    L26:
        if (r12 == true) goto L38;
        Context r13 = r8.getApplicationContext();
        ServiceInfo r14 = r13.getPackageManager().getServiceInfo(new ComponentName(r13, "com.amap.api.location.APSService"), 128);     // Catch: Throwable -> L30
    L31:
        if (r14 == null) goto L34;
        r10 = true;
    L34:
        if (r10 == true) goto L36;
        int r15 = 2103;
    L37:
        w3.a(r15, null);
        goto L38
    L36:
        r15 = 2101;
    L30:
        r14 = null;
    L38:
        return r12;
    L5:
        if (this.f11208o != null) goto L9;
        Thread.sleep(100);     // Catch: Throwable -> L23
        r11 = r11 + 1;     // Catch: Throwable -> L23
        if (r11 < 50) goto L43;
    L9:
        if (this.f11208o != null) goto L22;
        Message r16 = Message.obtain();     // Catch: Throwable -> L23
        Bundle r17 = new Bundle();     // Catch: Throwable -> L23
        AMapLocation r18 = new AMapLocation("");     // Catch: Throwable -> L23
        r18.v(10);     // Catch: Throwable -> L23
        Context r19 = r8.getApplicationContext();     // Catch: Throwable -> L23
        ServiceInfo r20 = r19.getPackageManager().getServiceInfo(new ComponentName(r19, "com.amap.api.location.APSService"), 128);     // Catch: Throwable -> L13
    L14:
        if (r20 != null) goto L16;
        boolean r21 = false;
    L17:
        if (r21 == true) goto L19;
        String r22 = "请检查配置文件是否配置服务，并且manifest中service标签是否配置在application标签内#1003";
    L20:
        r18.f3648y = r22;     // Catch: Throwable -> L23
        r17.putParcelable("loc", r18);     // Catch: Throwable -> L23
        r16.setData(r17);     // Catch: Throwable -> L23
        r16.what = 1;     // Catch: Throwable -> L23
        this.f11197d.sendMessage(r16);     // Catch: Throwable -> L23
        goto L25
    L19:
        r22 = "启动ApsServcie失败#1001";
        goto L20
    L16:
        r21 = true;
    L13:
        r20 = null;
        goto L14
    L22:
        r12 = true;
        goto L26
    }

    public final synchronized void t() {
        monitor-enter(this);
    L49:
        th = move-exception;
        throw th;
    L4:
        if (y3.y(this.f11195b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") == true) goto L11;
        if (y3.y(this.f11195b, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O") == true) goto L11;
        v();     // Catch: Throwable -> L49
        monitor-exit(this);
        return;
    L11:
        if (this.f11196c != null) goto L14;
        this.f11196c = new AMapLocationClientOption();     // Catch: Throwable -> L49
    L14:
        if (this.f11202i == false) goto L18;
        monitor-exit(this);
        return;
    L18:
        this.f11202i = true;     // Catch: Throwable -> L49
        long r8 = 0;
        c(1029, null, 0);     // Catch: Throwable -> L49
        int r10 = b.f11221a[this.f11196c.f3657r.ordinal()];     // Catch: Throwable -> L49
        if (r10 != 1) goto L21;
        c(1027, null, 0);     // Catch: Throwable -> L49
        c(1017, null, 0);     // Catch: Throwable -> L49
        c(1016, null, 0);     // Catch: Throwable -> L49
        c(1031, null, 0);     // Catch: Throwable -> L49
        monitor-exit(this);
        return;
    L21:
        if (r10 == 2) goto L39;
        if (r10 == 3) goto L26;
    L36:
        monitor-exit(this);
        return;
    L26:
        if (y3.F(this.f11195b) == false) goto L30;
        a(1016);     // Catch: Throwable -> L49
        c(1017, null, 0);     // Catch: Throwable -> L49
        c(1032, null, 0);     // Catch: Throwable -> L49
        c(1026, null, 0);     // Catch: Throwable -> L49
        monitor-exit(this);
        return;
    L30:
        c(1027, null, 0);     // Catch: Throwable -> L49
        c(1015, null, 0);     // Catch: Throwable -> L49
        AMapLocationClientOption r11 = this.f11196c;     // Catch: Throwable -> L49
        if (r11.f3659t == true) goto L33;
    L35:
        c(1016, null, r8);     // Catch: Throwable -> L49
        c(1031, null, r8);     // Catch: Throwable -> L49
        goto L36
    L33:
        if (r11.f3652m == false) goto L35;
        r8 = r11.A;     // Catch: Throwable -> L49
        goto L35
    L39:
        if (y3.F(this.f11195b) == false) goto L43;
        a(1016);     // Catch: Throwable -> L49
        c(1017, null, 0);     // Catch: Throwable -> L49
        c(1032, null, 0);     // Catch: Throwable -> L49
        c(1026, null, 0);     // Catch: Throwable -> L49
        monitor-exit(this);
        return;
    L43:
        a(1016);     // Catch: Throwable -> L49
        c(1027, null, 0);     // Catch: Throwable -> L49
        c(1032, null, 0);     // Catch: Throwable -> L49
        c(1015, null, 0);     // Catch: Throwable -> L49
        monitor-exit(this);
    }

    public final void v() {
        AMapLocation r8 = new AMapLocation("");
        r8.v(12);
        r8.f3648y = "定位权限被禁用,请授予应用定位权限 #1201";
        if (this.B != null) goto L5;
        this.B = new com.amap.api.location.a();
    L5:
        this.B = new com.amap.api.location.a();
        AMapLocationClientOption.b r10 = this.f11196c.f3657r;
        Context r11 = this.f11195b;
        y3.C(r11);
        com.amap.api.location.a r12 = this.B;
        y3.D(r11);
        r12.getClass();
        com.amap.api.location.a r13 = this.B;
        r13.getClass();
        r8.P = r13;
        w3.a(2121, null);
        l(r8);
    }

    public final void w() {
        a(1025);     // Catch: Throwable -> L14
        a(1033);     // Catch: Throwable -> L14
        d4 r8 = this.f11198e;     // Catch: Throwable -> L14
        if (r8 == null) goto L6;
        r8.g();     // Catch: Throwable -> L14
    L6:
        f4 r10 = this.f11199f;     // Catch: Throwable -> L14
        if (r10 == null) goto L9;
        r10.b();     // Catch: Throwable -> L14
    L9:
        z3 r11 = this.f11200g;     // Catch: Throwable -> L14
        if (r11 == null) goto L12;
        r11.a();     // Catch: Throwable -> L14
    L12:
        a(1016);     // Catch: Throwable -> L14
        c(1030, null, 0);     // Catch: Throwable -> L14
        this.f11202i = false;     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        t3.g("ALManager", "stopLocation", th);
    }

    public final void x() {
        s2 r8 = new s2(true);
        this.f11194a = null;
        em r10 = new em();
        r10.f5197a = SystemClock.elapsedRealtime();     // Catch: Throwable -> L138
        String r11 = AMapLocationClientOption.M;     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r11) == true) goto L180;
        Context r12 = this.f11195b;     // Catch: Throwable -> L13
        int r13 = i4.f10541a;     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r11) == true) goto L180;
        h4.f10509d = r11;     // Catch: Throwable -> L13
        if (r12 == null) goto L180;
        l1.f10784d.a(new h4.a(r12, r11));     // Catch: Throwable -> L13
    L180:
        int r14 = w1.e.f12964a;     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(null) == true) goto L169;
        k4.f10751d = null;     // Catch: Throwable -> L19
    L169:
        r8.f(this.f11195b);     // Catch: Throwable -> L23
        r8.h(this.f11196c);     // Catch: Throwable -> L23
        r8.n(r10);     // Catch: Throwable -> L23
    L25:
        boolean r15 = s3.f11083t;     // Catch: Throwable -> L138
        boolean r16 = this.f11218y.C;     // Catch: Throwable -> L36
        if (r16 == false) goto L51;
        if (this.f11196c.f3661v == true) goto L202;
    L38:
        es r17 = null;
    L39:
        if (r17 != null) goto L41;
    L60:
        es r18 = null;
    L61:
        if (r18 == null) goto L172;
        boolean r19 = false;
        es r110 = r18;
        boolean r111 = false;
    L74:
        if (r110 != null) goto L163;
        String r20 = null;
        AMapLocation r112 = null;
    L200:
        AMapLocationClientOption r113 = this.f11196c;     // Catch: Throwable -> L90
        if (r113.f3661v == false) goto L89;
        e4 r114 = this.f11207n;     // Catch: Throwable -> L90
        if (r114 == null) goto L89;
        boolean r115 = r15;
        r112 = r114.a(r112, r20, r113.f3665z);     // Catch: Throwable -> L87
    L187:
        if (this.f11218y.C == false) goto L196;
        e r21 = this.f11197d;     // Catch: Throwable -> L159
        if (r21 == null) goto L196;
        r21.removeMessages(13);     // Catch: Throwable -> L159
    L196:
        Bundle r22 = new Bundle();     // Catch: Throwable -> L121
        if (r112 == null) goto L101;
        r22.putParcelable("loc", r112);     // Catch: Throwable -> L121
        r22.putString("nb", r110.f5211f0);     // Catch: Throwable -> L121
        r22.putParcelable("statics", r10);     // Catch: Throwable -> L121
    L101:
        e(r22);     // Catch: Throwable -> L121
        if (r111 == false) goto L120;
        if (r110 == null) goto L120;
    L114:
        th = th;
        r18 = r110;
    L192:
        t3.g("ALManager", "apsLocation:doFirstAddCache", th);     // Catch: Throwable -> L118
    L124:
        if (r19 == false) goto L174;
        if (r115 == false) goto L174;
        if (I == true) goto L174;
        I = true;     // Catch: Throwable -> L71
        r8.r();     // Catch: Throwable -> L131
        AMapLocationClientOption r23 = new AMapLocationClientOption();     // Catch: Throwable -> L131
        r23.f3654o = false;     // Catch: Throwable -> L131
        r8.h(r23);     // Catch: Throwable -> L131
        r8.d(true, new em());     // Catch: Throwable -> L131
    L131:
        th = move-exception;
        t3.g("ALManager", "apsLocation:doFirstNetLocate 2", th);     // Catch: Throwable -> L71
    L71:
        th = th;
    L135:
        r110 = r18;
    L185:
        t3.g("ALManager", "apsLocation", th);     // Catch: Throwable -> L156
        r8.s();     // Catch: Throwable -> L161
    L143:
        if (s() == false) goto L206;
        Bundle r24 = new Bundle();
        if (r110 == null) goto L151;
        int r25 = r110.f3649z;
        if (r25 != 2) goto L149;
    L150:
        String r26 = "1";
    L152:
        r24.putBundle("optBundle", t3.a(this.f11196c));
        r24.putString("isCacheLoc", r26);
        b(0, r24);
        if (this.f11202i == false) goto L207;
        b(13, null);
        return;
    L207:
        return;
    L149:
        if (r25 == 4) goto L150;
    L151:
        r26 = "0";
        goto L152
    L206:
        return;
    L156:
        th = move-exception;
        r8.s();     // Catch: Throwable -> L162
    L158:
        throw th;
    L174:
        r8.s();     // Catch: Throwable -> L160
    L134:
        r110 = r18;
    L118:
        th = th;
    L123:
        t3.g("ALManager", "apsLocation:callback", th);     // Catch: Throwable -> L71
        goto L124
    L105:
        if (r110.f3646w != 0) goto L120;
        if (y3.l(r110) == false) goto L120;
        r18 = r110;
        r8.f11040e.h(r8.f11058w, r8.f11059x, r110, r8.f11036a, true);     // Catch: Throwable -> L112
    L112:
        th = th;
    L120:
        r18 = r110;
    L121:
        th = th;
        r18 = r110;
    L87:
        th = th;
    L182:
        t3.g("ALManager", "fixLastLocation", th);     // Catch: Throwable -> L136
    L136:
        th = th;
        r18 = r110;
    L89:
        r115 = r15;
    L90:
        th = th;
        r115 = r15;
        goto L182
    L163:
        r20 = r110.f5211f0;     // Catch: Throwable -> L77
        r112 = r110.t();     // Catch: Throwable -> L77
    L77:
        th = th;
        goto L185
    L172:
        r18 = r8.d(!r15, r10);     // Catch: Throwable -> L68
        if (r18.f3646w != 0) goto L66;
        boolean r27 = true;
    L67:
        r19 = true;
        r110 = r18;
        r111 = r27;
        goto L74
    L66:
        r27 = false;
        goto L67
    L68:
        th = move-exception;
        t3.g("ALManager", "apsLocation:doFirstNetLocate", th);     // Catch: Throwable -> L71
        r19 = true;
        r110 = r18;
        r111 = false;
        goto L74
    L41:
        if (s3.e(r17.getTime()) == true) goto L58;
        AMapLocationClientOption r116 = this.f11218y;     // Catch: Throwable -> L36
        if (r116.C == false) goto L60;
        int r117 = r116.E;     // Catch: Throwable -> L36
        long r118 = System.currentTimeMillis() - r17.getTime();     // Catch: Throwable -> L36
        if (r118 <= 0) goto L60;
        if (r118 >= r117) goto L60;
        this.f11194a = r17;     // Catch: Throwable -> L36
        r17.x(10);     // Catch: Throwable -> L36
    L58:
        r18 = r17;
        goto L61
    L202:
        r17 = r8.l(r16);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        t3.g("ALManager", "doFirstCacheLoc", th);     // Catch: Throwable -> L36
        goto L38
    L51:
        if (this.f11196c.f3661v == true) goto L165;
    L57:
        r17 = null;
        goto L58
    L165:
        r17 = r8.l(false);     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        t3.g("ALManager", "doFirstCacheLoc", th);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        t3.g("ALManager", "apscach", th);     // Catch: Throwable -> L138
        goto L60
    L23:
        th = move-exception;
        t3.g("ALManager", "initApsBase", th);     // Catch: Throwable -> L138
    L19:
        th = move-exception;
        t3.g("ALManager", "apsLocation setUmidToken", th);     // Catch: Throwable -> L138
    L13:
        th = move-exception;
        t3.g("ALManager", "apsLocation setAuthKey", th);     // Catch: Throwable -> L138
    L138:
        th = th;
        r110 = null;
        goto L185
    }

    public final void y() {
        AMapLocationClientOption r8 = this.f11196c;
        if (r8.f3657r == AMapLocationClientOption.b.f3667b) goto L9;
        long r10 = r8.f3650a;
        if (r10 >= 1000) goto L7;
        r10 = 1000;
    L7:
        c(1016, null, r10);
        return;
    }

    public final void z() {
        if (this.f11209p != null) goto L5;
        this.f11209p = new Messenger(this.f11197d);     // Catch: Throwable -> L11
    L5:
        Intent r8 = A();     // Catch: Throwable -> L11
        this.f11195b.bindService(r8, this.A, 1);     // Catch: Throwable -> L8
        goto L16
    L15:
        return;
    L8:
        th = move-exception;
        t3.g("ALManager", "startServiceImpl", th);     // Catch: Throwable -> L11
        return;
    }
}
