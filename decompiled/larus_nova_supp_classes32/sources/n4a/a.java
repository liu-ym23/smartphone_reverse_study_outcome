package n4a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.GeoFenceListener;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.DPoint;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AutoEndConversationTime;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static boolean z;
    public h4 a;
    public final Context b;
    public PendingIntent c;
    public String d;
    public GeoFenceListener e;
    public final Object f;
    public volatile int g;
    public ArrayList<GeoFence> h;
    public d i;
    public final Object j;
    public final Object k;
    public b l;
    public c m;
    public volatile boolean n;
    public volatile boolean o;
    public volatile boolean p;
    public a0 q;
    public w0 r;
    public AMapLocationClient s;
    public volatile AMapLocation t;
    public long u;
    public AMapLocationClientOption v;
    public int w;
    public final C0101a x;
    public volatile boolean y;

    /* JADX INFO: renamed from: n4a.a$a, reason: collision with other inner class name */
    public class C0101a implements AMapLocationListener {
        public final /* synthetic */ a a;

        public C0101a(a r1) {
            this.a = r1;
        }

        public final void onLocationChanged(AMapLocation r22) {
            ArrayList r10 = new ArrayList();
            Object[] r12 = {r22};
            f06.b r14 = new f06.b();
            g06.a r0 = (g06.a) ApiHookConfig.b.get(101329);
            if (r0 == null) goto L5;
            f06.a[] r1 = r0.i;
        L6:
            f06.a[] r7 = r1;
            int r6 = r7.length;
            int r5 = 0;
        L8:
            if (r5 >= r6) goto L15;
            f06.a r3 = r7[r5];
            int r18 = r5;
            int r19 = r6;
            f06.a[] r20 = r7;
            f06.d r2 = r3.preInvoke(101329, "com/loc/a$1", "onLocationChanged", this, r12, "void", r14);     // Catch: Exception -> L44
            if (r2.a == true) goto L12;
            r10.add(r3);     // Catch: Exception -> L44
            goto L14
        L12:
            Bundle r4 = null;
        L17:
            if (r2.a == false) goto L47;
            return;
        L47:
            if (this.a.y == false) goto L23;
            return;
        L23:
            if (this.a.p == true) goto L25;
            return;
        L25:
            this.a.t = r22;     // Catch: Throwable -> L43
            if (r22 == null) goto L31;
            int r8 = r22.getErrorCode();     // Catch: Throwable -> L43
            if (r22.getErrorCode() != 0) goto L30;
            this.a.u = SystemClock.elapsedRealtime();     // Catch: Throwable -> L43
            this.a.h(5, r4, 0);     // Catch: Throwable -> L43
            boolean r11 = true;
        L33:
            if (r11 == false) goto L36;
            a r9 = this.a;     // Catch: Throwable -> L43
            r9.w = 0;     // Catch: Throwable -> L43
            r9.h(6, r4, 0);     // Catch: Throwable -> L43
            return;
        L36:
            Bundle r13 = new Bundle();     // Catch: Throwable -> L43
            if (this.a.n == true) goto L39;
            this.a.r(7);     // Catch: Throwable -> L43
            r13.putLong("interval", 2000);     // Catch: Throwable -> L43
            this.a.h(8, r13, 2000);     // Catch: Throwable -> L43
        L39:
            a r15 = this.a;     // Catch: Throwable -> L43
            int r16 = r15.w + 1;     // Catch: Throwable -> L43
            r15.w = r16;     // Catch: Throwable -> L43
            if (r16 < 3) goto L51;
            r13.putInt("location_errorcode", r8);     // Catch: Throwable -> L43
            this.a.g(1002, r13);     // Catch: Throwable -> L43
            return;
        L51:
            return;
        L30:
            a.k("定位失败", r22.getErrorCode(), r22.getErrorInfo(), new String[]{"locationDetail:" + r22.getLocationDetail()});     // Catch: Throwable -> L43
        L32:
            r11 = false;
            goto L33
        L31:
            r8 = 8;
            goto L32
        L52:
            return;
        L14:
            r5 = r18 + 1;
            r6 = r19;
            r7 = r20;
            goto L8
        L15:
            r4 = null;
            r2 = new f06.d(false, null);
            goto L17
        L5:
            r1 = ApiHookConfig.d;
            goto L6
        }
    }

    public class b extends Handler {
        public final /* synthetic */ a a;

        public b(a r1, Looper r2) {
            this.a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r3) {
            switch(r3.what) {
                case 0: goto L39;
                case 1: goto L37;
                case 2: goto L35;
                case 3: goto L33;
                case 4: goto L31;
                case 5: goto L29;
                case 6: goto L27;
                case 7: goto L25;
                case 8: goto L23;
                case 9: goto L21;
                case 10: goto L19;
                case 11: goto L8;
                case 12: goto L6;
                case 13: goto L5;
                default: goto L48;
            };     // Catch: Throwable -> L42
        L5:
            this.a.C();     // Catch: Throwable -> L42
            return;
        L6:
            this.a.D(r3.getData());     // Catch: Throwable -> L42
            return;
        L8:
            a r0 = this.a;     // Catch: Throwable -> L42
            Bundle r4 = r3.getData();     // Catch: Throwable -> L42
            r0.getClass();     // Catch: Throwable -> L42
            if (r0.h == null) goto L45;
            GeoFence r5 = r4.getParcelable("fc");     // Catch: Throwable -> L41
            if (r0.h.contains(r5) == false) goto L15;
            r0.h.remove(r5);     // Catch: Throwable -> L41
        L15:
            if (r0.h.size() > 0) goto L17;
            r0.x();     // Catch: Throwable -> L41
            return;
        L17:
            r0.J();     // Catch: Throwable -> L41
            return;
        L45:
            return;
        L47:
            return;
        L19:
            this.a.x();     // Catch: Throwable -> L42
            return;
        L21:
            this.a.i(r3.getData());     // Catch: Throwable -> L42
            return;
        L23:
            this.a.G(r3.getData());     // Catch: Throwable -> L42
            return;
        L25:
            this.a.A();     // Catch: Throwable -> L42
            return;
        L27:
            a r6 = this.a;     // Catch: Throwable -> L42
            r6.j(r6.t);     // Catch: Throwable -> L42
            return;
        L29:
            this.a.B();     // Catch: Throwable -> L42
            return;
        L31:
            this.a.s(3, r3.getData());     // Catch: Throwable -> L42
            return;
        L33:
            this.a.s(2, r3.getData());     // Catch: Throwable -> L42
            return;
        L35:
            this.a.s(1, r3.getData());     // Catch: Throwable -> L42
            return;
        L37:
            this.a.z(r3.getData());     // Catch: Throwable -> L42
            return;
        L39:
            this.a.t(r3.getData());     // Catch: Throwable -> L42
            return;
        L48:
            return;
        }
    }

    public static class c extends PthreadHandlerThreadV2 {
        public c() {
            super("fenceActionThread");
        }

        public final void run() {
            super.run();     // Catch: Throwable -> L4
            return;
        }
    }

    public class d extends Handler {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        public d(a r1, Looper r2) {
            this.a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r2) {
            Bundle r0 = r2.getData();     // Catch: Throwable -> L17
            switch(r2.what) {
                case 1000: goto L15;
                case 1001: goto L21;
                case 1002: goto L19;
                default: goto L23;
            };
        L15:
            this.a.E(r0);     // Catch: Throwable -> L17
            return;
        L19:
            int r3 = r0.getInt("location_errorcode");     // Catch: Throwable -> L7
            this.a.y(r3);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L17
            return;
        L21:
            GeoFence r4 = r0.getParcelable("geoFence");     // Catch: Throwable -> L12
            this.a.u(r4);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L17
            return;
        L23:
            return;
        }
    }

    public a(Context r5) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = new Object();
        this.g = 1;
        this.h = new ArrayList();
        this.i = null;
        this.j = new Object();
        this.k = new Object();
        this.l = null;
        this.m = null;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = 0;
        this.v = null;
        this.w = 0;
        this.x = new C0101a(this);
        this.y = false;
        this.b = r5.getApplicationContext();     // Catch: Throwable -> L5
        F();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        c4.g(th, "GeoFenceManger", "<init>");
    }

    public static float a(AMapLocation r6, List<GeoFence> r7) {
        float r0 = Float.MAX_VALUE;
        if (r6 != null) goto L5;
    L26:
        return r0;
    L5:
        if (r6.getErrorCode() != 0) goto L26;
        if (r7 == null) goto L26;
        ArrayList r8 = (ArrayList) r7;
        if (r8.isEmpty() == true) goto L26;
        DPoint r1 = new DPoint(r6.getLatitude(), r6.getLongitude());
        Iterator r9 = r8.iterator();
    L11:
        if (r9.hasNext() == false) goto L26;
        GeoFence r10 = (GeoFence) r9.next();
        if (r10.isAble() == false) goto L11;
        float r2 = j4.b(r1, r10.getCenter());
        if (r2 <= r10.getMinDis2Center()) goto L21;
        if (r2 >= r10.getMaxDis2Center()) goto L21;
        return 0.0f;
    L21:
        if (r2 <= r10.getMaxDis2Center()) goto L24;
        r0 = Math.min(r0, r2 - r10.getMaxDis2Center());
    L24:
        if (r2 >= r10.getMinDis2Center()) goto L11;
        r0 = Math.min(r0, r10.getMinDis2Center() - r2);
        goto L11
    }

    public static float b(DPoint r2, List<DPoint> r3) {
        float r0 = Float.MAX_VALUE;
        if (r3 != null) goto L5;
    L10:
        return r0;
    L5:
        if (r3.isEmpty() == true) goto L10;
        Iterator<DPoint> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r0 = Math.min(r0, j4.b(r2, r4.next()));
        goto L8
    }

    public static Bundle e(GeoFence r2, String r3, String r4, int r5, int r6) {
        Bundle r0 = new Bundle();
        if (r3 != null) goto L5;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L5:
        r0.putString("fenceid", r3);
        r0.putString("customId", r4);
        r0.putInt("event", r5);
        r0.putInt("location_errorcode", r6);
        r0.putParcelable("fence", r2);
        return r0;
    }

    public static void k(String r4, int r5, String r6, String... r7) {
        StringBuffer r0 = new StringBuffer("===========================================\n");
        r0.append("              " + r4 + "                ");
        r0.append("\n-------------------------------------------\n");
        r0.append("errorCode:".concat(String.valueOf(r5)));
        r0.append("\n");
        r0.append("错误信息:".concat(String.valueOf(r6)));
        r0.append("\n");
        if (r7.length <= 0) goto L7;
        int r8 = r7.length;
        int r9 = 0;
    L5:
        if (r9 >= r8) goto L7;
        r0.append(r7[r9]);
        r0.append("\n");
        r9 = r9 + 1;
    L7:
        r0.append("===========================================\n");
    }

    public static boolean n(int r5, String r6, String r7, DPoint r8) {
        if (TextUtils.isEmpty(r6) == false) goto L6;
        return false;
    L6:
        if (r5 == 1) goto L22;
        if (r5 != 2) goto L24;
        if (r8 != null) goto L13;
        return false;
    L13:
        if (r8.getLatitude() <= 90.0d) goto L15;
    L20:
        k("添加围栏失败", 0, "经纬度错误，传入的纬度：" + r8.getLatitude() + "传入的经度:" + r8.getLongitude(), new String[0]);
        return false;
    L15:
        if (r8.getLatitude() < (-90.0d)) goto L20;
        if (r8.getLongitude() > 180.0d) goto L20;
        if (r8.getLongitude() < (-180.0d)) goto L20;
    L24:
        return true;
    L22:
        if (TextUtils.isEmpty(r7) == false) goto L24;
        return false;
    }

    public static float q(DPoint r2, List<DPoint> r3) {
        float r0 = Float.MIN_VALUE;
        if (r3 != null) goto L5;
    L10:
        return r0;
    L5:
        if (r3.isEmpty() == true) goto L10;
        Iterator<DPoint> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r0 = Math.max(r0, j4.b(r2, r4.next()));
        goto L8
    }

    public final void A() {
    L6:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "doStartOnceLocation");
        return;
    L3:
        if (this.s == null) goto L11;
        K();     // Catch: Throwable -> L6
        this.v.setLocationCacheEnable(true);     // Catch: Throwable -> L6
        this.v.setNeedAddress(false);     // Catch: Throwable -> L6
        this.v.setOnceLocation(true);     // Catch: Throwable -> L6
        this.s.setLocationOption(this.v);     // Catch: Throwable -> L6
        this.s.startLocation();     // Catch: Throwable -> L6
        return;
    }

    public final void B() {
    L21:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "doCheckLocationPolicy");
        return;
    L3:
        if (this.y == false) goto L6;
        return;
    L6:
        if (j4.l(this.t) == true) goto L8;
        return;
    L8:
        float r0 = a(this.t, this.h);     // Catch: Throwable -> L21
        if (r0 != Float.MAX_VALUE) goto L12;
        return;
    L12:
        if (r0 >= 1000.0f) goto L16;
        r(7);     // Catch: Throwable -> L21
        Bundle r1 = new Bundle();     // Catch: Throwable -> L21
        r1.putLong("interval", 2000);     // Catch: Throwable -> L21
        h(8, r1, 500);     // Catch: Throwable -> L21
        return;
    L16:
        if (r0 >= 5000.0f) goto L19;
        K();     // Catch: Throwable -> L21
        r(7);     // Catch: Throwable -> L21
        h(7, null, AutoEndConversationTime.AFTER_10_SECONDS);     // Catch: Throwable -> L21
        return;
    L19:
        K();     // Catch: Throwable -> L21
        r(7);     // Catch: Throwable -> L21
        h(7, null, (long) (((r0 - 4000.0f) / 100.0f) * 1000.0f));     // Catch: Throwable -> L21
    }

    public final void C() {
        r(7);     // Catch: Throwable -> L8
        r(8);     // Catch: Throwable -> L8
        AMapLocationClient r0 = this.s;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.stopLocation();     // Catch: Throwable -> L8
    L6:
        this.n = false;     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "doPauseGeoFence");
    }

    public final void E(Bundle r4) {
        if (r4 == null) goto L22;
    L17:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "resultAddGeoFenceFinished");
        return;
    L4:
        if (r4.isEmpty() == true) goto L23;
        int r0 = r4.getInt("errorCode");     // Catch: Throwable -> L17
        ArrayList r1 = r4.getParcelableArrayList("resultList");     // Catch: Throwable -> L17
        if (r1 != null) goto L8;
        r1 = new ArrayList();     // Catch: Throwable -> L17
    L8:
        String r5 = r4.getString("customId");     // Catch: Throwable -> L17
        if (r5 != null) goto L11;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L11:
        GeoFenceListener r2 = this.e;     // Catch: Throwable -> L17
        if (r2 == null) goto L14;
        r2.onGeoFenceCreateFinished((ArrayList) r1.clone(), r0, r5);     // Catch: Throwable -> L17
    L14:
        if (r0 != 0) goto L24;
        J();     // Catch: Throwable -> L17
        return;
    L24:
        return;
    L23:
        return;
    }

    /* JADX WARN: Type inference failed for: r1v14, types: [java.lang.Thread, n4a.a$c] */
    public final void F() {
        if (this.p == true) goto L6;
        this.p = true;
    L6:
        if (this.o == false) goto L43;
        return;
    L43:
    L14:
        th = move-exception;
        c4.g(th, "GeoFenceManger", "init 1");
    L45:
        ?? r1 = new c();     // Catch: Throwable -> L18
        this.m = r1;     // Catch: Throwable -> L18
        ThreadMethodProxy.setPriority(r1, 5);     // Catch: Throwable -> L18
        ThreadMethodProxy.start(this.m);     // Catch: Throwable -> L18
        this.l = new b(this, this.m.getLooper());     // Catch: Throwable -> L18
    L39:
        this.q = new a0(this.b);     // Catch: Throwable -> L24
        this.r = new w0();     // Catch: Throwable -> L24
        this.v = new AMapLocationClientOption();     // Catch: Throwable -> L24
        AMapLocationClient r2 = new AMapLocationClient(this.b);     // Catch: Throwable -> L24
        this.s = r2;     // Catch: Throwable -> L24
        r2.setLocationListener(this.x);     // Catch: Throwable -> L24
        if (this.a != null) goto L26;
        this.a = new h4();     // Catch: Throwable -> L24
    L26:
        this.o = true;
        String r3 = this.d;     // Catch: Throwable -> L33
        if (r3 == null) goto L36;
        if (this.c != null) goto L36;
        d(r3);     // Catch: Throwable -> L33
    L36:
        if (z == true) goto L47;
        z = true;
        h4.i(this.b, "O020", null);
        return;
    L47:
        return;
    L33:
        th = move-exception;
        c4.g(th, "GeoFenceManger", "init 4");
    L24:
        th = move-exception;
        c4.g(th, "GeoFenceManger", "initBase");
    L18:
        th = move-exception;
        c4.g(th, "GeoFenceManger", "init 2");
        goto L39
    L9:
        if (Looper.myLooper() != null) goto L11;
        d r4 = new d(this, this.b.getMainLooper());     // Catch: Throwable -> L14
    L12:
        this.i = r4;     // Catch: Throwable -> L14
        goto L45
    L11:
        r4 = new d(this);     // Catch: Throwable -> L14
        goto L12
    }

    public final void G(Bundle r4) {
    L13:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "doStartContinueLocation");
        return;
    L3:
        if (this.s == null) goto L18;
        long r0 = 2000;
        if (r4 != null) goto L7;
    L9:
        this.v.setOnceLocation(false);     // Catch: Throwable -> L13
        this.v.setInterval(r0);     // Catch: Throwable -> L13
        this.v.setLocationCacheEnable(true);     // Catch: Throwable -> L13
        this.v.setNeedAddress(false);     // Catch: Throwable -> L13
        this.s.setLocationOption(this.v);     // Catch: Throwable -> L13
        if (this.n == true) goto L19;
        this.s.stopLocation();     // Catch: Throwable -> L13
        this.s.startLocation();     // Catch: Throwable -> L13
        this.n = true;     // Catch: Throwable -> L13
        return;
    L19:
        return;
    L7:
        if (r4.isEmpty() == true) goto L9;
        r0 = r4.getLong("interval", 2000);     // Catch: Throwable -> L13
        goto L9
    }

    public final void H() {
        Object r0 = this.k;     // Catch: Throwable -> L13
        monitor-enter(r0);     // Catch: Throwable -> L13
        d r1 = this.i;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        r1.removeCallbacksAndMessages(null);     // Catch: Throwable -> L10
    L7:
        this.i = null;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "destroyResultHandler");
    }

    public final void I() {
        Object r0 = this.j;     // Catch: Throwable -> L13
        monitor-enter(r0);     // Catch: Throwable -> L13
        b r1 = this.l;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        r1.removeCallbacksAndMessages(null);     // Catch: Throwable -> L10
    L7:
        this.l = null;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "destroyActionHandler");
    }

    public final void K() {
        if (this.n == false) goto L5;
        r(8);     // Catch: Throwable -> L10
    L5:
        AMapLocationClient r0 = this.s;     // Catch: Throwable -> L10
        if (r0 == null) goto L8;
        r0.stopLocation();     // Catch: Throwable -> L10
    L8:
        this.n = false;     // Catch: Throwable -> L10
        return;
    }

    public final int c(List<GeoFence> r4) {
    L11:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "addGeoFenceList");
        k("添加围栏失败", 8, th.getMessage(), new String[0]);
        return 8;
    L4:
        if (this.h != null) goto L6;
        this.h = new ArrayList();     // Catch: Throwable -> L11
    L6:
        Iterator r5 = ((ArrayList) r4).iterator();     // Catch: Throwable -> L11
    L7:
        if (r5.hasNext() == false) goto L17;
        w((GeoFence) r5.next());     // Catch: Throwable -> L11
        goto L7
    L17:
        return 0;
    }

    public final PendingIntent d(String r6) {
        Object r0 = this.f;
        monitor-enter(r0);
        Intent r1 = new Intent(r6);     // Catch: Throwable -> L20
        r1.setPackage(v4.d(this.b));     // Catch: Throwable -> L20
        if (Build.VERSION.SDK_INT >= 31) goto L7;
    L10:
        PendingIntent r2 = PendingIntent.getBroadcast(this.b, 0, r1, 0);     // Catch: Throwable -> L20
    L9:
        this.c = r2;     // Catch: Throwable -> L20
        this.d = r6;     // Catch: Throwable -> L20
        ArrayList<GeoFence> r7 = this.h;     // Catch: Throwable -> L20
        if (r7 != null) goto L14;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L25
        return this.c;
    L14:
        if (r7.isEmpty() == true) goto L22;
        Iterator<GeoFence> r8 = this.h.iterator();     // Catch: Throwable -> L20
    L16:
        if (r8.hasNext() == false) goto L22;
        GeoFence r3 = r8.next();     // Catch: Throwable -> L20
        r3.setPendingIntent(this.c);     // Catch: Throwable -> L20
        r3.setPendingIntentAction(this.d);     // Catch: Throwable -> L20
        goto L16
    L7:
        if (this.b.getApplicationInfo().targetSdkVersion < 31) goto L10;
        r2 = PendingIntent.getBroadcast(this.b, 0, r1, 33554432);     // Catch: Throwable -> L20
    L25:
        th = move-exception;
        throw th;
    L20:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "createPendingIntent");     // Catch: Throwable -> L25
        goto L22
    }

    public final void g(int r3, Bundle r4) {
        Object r0 = this.k;     // Catch: Throwable -> L12
        monitor-enter(r0);     // Catch: Throwable -> L12
        d r1 = this.i;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        Message r2 = r1.obtainMessage();     // Catch: Throwable -> L9
        r2.what = r3;     // Catch: Throwable -> L9
        r2.setData(r4);     // Catch: Throwable -> L9
        this.i.sendMessage(r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "sendResultHandlerMessage");
    }

    public final void h(int r3, Bundle r4, long r5) {
        Object r0 = this.j;     // Catch: Throwable -> L12
        monitor-enter(r0);     // Catch: Throwable -> L12
        b r1 = this.l;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        Message r2 = r1.obtainMessage();     // Catch: Throwable -> L9
        r2.what = r3;     // Catch: Throwable -> L9
        r2.setData(r4);     // Catch: Throwable -> L9
        this.l.sendMessageDelayed(r2, r5);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "sendActionHandlerMessage");
    }

    public final void i(Bundle r5) {
        int r0 = 1;
        if (r5 == null) goto L6;
        r0 = r5.getInt("activatesAction", 1);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "doSetActivatesAction");
        return;
    L6:
        if (this.g == r0) goto L16;
        ArrayList<GeoFence> r6 = this.h;     // Catch: Throwable -> L18
        if (r6 != null) goto L10;
    L15:
        J();     // Catch: Throwable -> L18
        goto L16
    L10:
        if (r6.isEmpty() == true) goto L15;
        Iterator<GeoFence> r7 = this.h.iterator();     // Catch: Throwable -> L18
    L13:
        if (r7.hasNext() == false) goto L15;
        GeoFence r1 = r7.next();     // Catch: Throwable -> L18
        r1.setStatus(0);     // Catch: Throwable -> L18
        r1.setEnterTime(-1);     // Catch: Throwable -> L18
    L16:
        this.g = r0;     // Catch: Throwable -> L18
    }

    public final void l(String r3, String r4, DPoint r5, float r6, int r7, String r8) {
        F();     // Catch: Throwable -> L14
        if (r6 > 0.0f) goto L5;
    L6:
        r6 = 3000.0f;
    L7:
        if (r7 > 0) goto L10;
        r7 = 10;
    L10:
        if (r7 <= 25) goto L12;
        r7 = 25;
    L12:
        Bundle r0 = new Bundle();     // Catch: Throwable -> L14
        r0.putString("keyWords", r3);     // Catch: Throwable -> L14
        r0.putString("poiType", r4);     // Catch: Throwable -> L14
        r0.putParcelable("centerPoint", r5);     // Catch: Throwable -> L14
        r0.putFloat("aroundRadius", r6);     // Catch: Throwable -> L14
        r0.putInt("searchSize", r7);     // Catch: Throwable -> L14
        r0.putString("customId", r8);     // Catch: Throwable -> L14
        h(3, r0, 0);     // Catch: Throwable -> L14
        return;
    L5:
        if (r6 <= 50000.0f) goto L7;
    L14:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "addNearbyGeoFence");
    }

    public final void m(String r3, String r4, String r5, int r6, String r7) {
        F();     // Catch: Throwable -> L10
        if (r6 > 0) goto L6;
        r6 = 10;
    L6:
        if (r6 <= 25) goto L8;
        r6 = 25;
    L8:
        Bundle r0 = new Bundle();     // Catch: Throwable -> L10
        r0.putString("keyWords", r3);     // Catch: Throwable -> L10
        r0.putString("poiType", r4);     // Catch: Throwable -> L10
        r0.putString("city", r5);     // Catch: Throwable -> L10
        r0.putInt("searchSize", r6);     // Catch: Throwable -> L10
        r0.putString("customId", r7);     // Catch: Throwable -> L10
        h(2, r0, 0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "addKeywordGeoFence");
    }

    public final boolean o(GeoFence r7) {
        ArrayList<GeoFence> r1 = this.h;     // Catch: Throwable -> L18
        if (r1 != null) goto L6;
    L16:
        this.p = false;     // Catch: Throwable -> L18
        h(10, null, 0);     // Catch: Throwable -> L18
        return true;
    L6:
        if (r1.isEmpty() == true) goto L16;
        if (this.h.contains(r7) == true) goto L11;
        return false;
    L11:
        if (this.h.size() != 1) goto L13;
        this.p = false;     // Catch: Throwable -> L18
    L13:
        Bundle r2 = new Bundle();     // Catch: Throwable -> L18
        r2.putParcelable("fc", r7);     // Catch: Throwable -> L18
        h(11, r2, 0);     // Catch: Throwable -> L18
        return true;
    L18:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "removeGeoFence(GeoFence)");
        return false;
    }

    public final void r(int r3) {
        Object r0 = this.j;     // Catch: Throwable -> L12
        monitor-enter(r0);     // Catch: Throwable -> L12
        b r1 = this.l;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.removeMessages(r3);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "removeActionHandlerMessage");
    }

    public final void t(Bundle r12) {
        ArrayList<? extends Parcelable> r0 = new ArrayList();     // Catch: Throwable -> L26
        String r1 = NameKeys.UnloadStrategy_No_Strategy;
        int r3 = 1;
        if (r12 != null) goto L6;
    L23:
        String r4 = r1;
    L24:
        Bundle r13 = new Bundle();     // Catch: Throwable -> L26
        r13.putInt("errorCode", r3);     // Catch: Throwable -> L26
        r13.putParcelableArrayList("resultList", r0);     // Catch: Throwable -> L26
        r13.putString("customId", r4);     // Catch: Throwable -> L26
        g(1000, r13);     // Catch: Throwable -> L26
        return;
    L6:
        if (r12.isEmpty() == true) goto L23;
        DPoint r2 = r12.getParcelable("centerPoint");     // Catch: Throwable -> L26
        r4 = r12.getString("customId");     // Catch: Throwable -> L26
        if (r2 != null) goto L10;
        r1 = r4;
        goto L23
    L10:
        if (r2.getLatitude() <= 90.0d) goto L12;
    L21:
        k("添加围栏失败", 1, "经纬度错误，传入的纬度：" + r2.getLatitude() + "传入的经度:" + r2.getLongitude(), new String[0]);     // Catch: Throwable -> L26
        goto L24
    L12:
        if (r2.getLatitude() < (-90.0d)) goto L21;
        if (r2.getLongitude() > 180.0d) goto L21;
        if (r2.getLongitude() < (-180.0d)) goto L21;
        GeoFence r14 = f(r12, false);     // Catch: Throwable -> L26
        r3 = w(r14);     // Catch: Throwable -> L26
        if (r3 != 0) goto L24;
        r0.add(r14);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "doAddGeoFenceRound");
    }

    public final void u(GeoFence r7) {
        Object r0 = this.f;     // Catch: Throwable -> L25
        monitor-enter(r0);     // Catch: Throwable -> L25
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L5:
        if (this.b != null) goto L7;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L7:
        if (this.c == null) goto L9;
    L12:
        Intent r1 = new Intent();     // Catch: Throwable -> L22
        r1.putExtras(e(r7, r7.getFenceId(), r7.getCustomId(), r7.getStatus(), 0));     // Catch: Throwable -> L22
        String r2 = this.d;     // Catch: Throwable -> L22
        if (r2 == null) goto L15;
        r1.setAction(r2);     // Catch: Throwable -> L22
    L15:
        r1.setPackage(v4.d(this.b));     // Catch: Throwable -> L22
        if (r7.getPendingIntent() == null) goto L19;
        PendingIntent r8 = r7.getPendingIntent();     // Catch: Throwable -> L22
        Context r3 = this.b;     // Catch: Throwable -> L22
    L18:
        r8.send(r3, 0, r1);     // Catch: Throwable -> L22
        goto L20
    L19:
        r8 = this.c;     // Catch: Throwable -> L22
        r3 = this.b;     // Catch: Throwable -> L22
        goto L18
    L9:
        if (r7.getPendingIntent() != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L25:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "resultTriggerGeoFence");
    }

    public final int w(GeoFence r4) {
    L11:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "addGeoFence2List");
        k("添加围栏失败", 8, th.getMessage(), new String[0]);
        return 8;
    L4:
        if (this.h != null) goto L7;
        this.h = new ArrayList();     // Catch: Throwable -> L11
    L7:
        if (this.h.contains(r4) == true) goto L10;
        this.h.add(r4);     // Catch: Throwable -> L11
        return 0;
    L10:
        return 17;
    }

    public final void x() {
        if (this.o == true) goto L5;
        return;
    L5:
        ArrayList<GeoFence> r0 = this.h;     // Catch: Throwable -> L33
        if (r0 == null) goto L9;
        r0.clear();     // Catch: Throwable -> L33
        this.h = null;     // Catch: Throwable -> L33
    L9:
        if (this.p == false) goto L11;
        return;
    L11:
        I();     // Catch: Throwable -> L33
        AMapLocationClient r1 = this.s;     // Catch: Throwable -> L33
        if (r1 == null) goto L14;
        r1.stopLocation();     // Catch: Throwable -> L33
        this.s.onDestroy();     // Catch: Throwable -> L33
    L14:
        this.s = null;     // Catch: Throwable -> L33
        c r2 = this.m;     // Catch: Throwable -> L33
        if (r2 == null) goto L17;
        r2.quitSafely();     // Catch: Throwable -> L33
    L17:
        this.m = null;     // Catch: Throwable -> L33
        this.q = null;     // Catch: Throwable -> L33
        Object r3 = this.f;     // Catch: Throwable -> L33
        monitor-enter(r3);     // Catch: Throwable -> L33
        PendingIntent r4 = this.c;     // Catch: Throwable -> L28
        if (r4 == null) goto L22;
        r4.cancel();     // Catch: Throwable -> L28
    L22:
        this.c = null;     // Catch: Throwable -> L28
        monitor-exit(r3);     // Catch: Throwable -> L28
        H();     // Catch: Throwable -> L33
        h4 r5 = this.a;     // Catch: Throwable -> L33
        if (r5 == null) goto L31;
        r5.m(this.b);     // Catch: Throwable -> L33
        goto L31
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L31:
        this.n = false;
        this.o = false;
    }

    public final void y(int r5) {
    L17:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "resultRemindLocationError");
        return;
    L3:
        if (this.b == null) goto L16;
        Object r0 = this.f;     // Catch: Throwable -> L17
        monitor-enter(r0);     // Catch: Throwable -> L17
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L7:
        if (this.c != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L10:
        Intent r1 = new Intent();     // Catch: Throwable -> L13
        r1.putExtras(e(null, null, null, 4, r5));     // Catch: Throwable -> L13
        this.c.send(this.b, 0, r1);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    }

    public final void z(Bundle r7) {
        ArrayList<? extends Parcelable> r0 = new ArrayList();     // Catch: Throwable -> L19
        String r1 = NameKeys.UnloadStrategy_No_Strategy;
        int r3 = 1;
        if (r7 != null) goto L6;
    L17:
        Bundle r8 = new Bundle();     // Catch: Throwable -> L19
        r8.putString("customId", r1);     // Catch: Throwable -> L19
        r8.putInt("errorCode", r3);     // Catch: Throwable -> L19
        r8.putParcelableArrayList("resultList", r0);     // Catch: Throwable -> L19
        g(1000, r8);     // Catch: Throwable -> L19
        return;
    L6:
        if (r7.isEmpty() == true) goto L17;
        ArrayList r2 = r7.getParcelableArrayList("pointList");     // Catch: Throwable -> L19
        String r4 = r7.getString("customId");     // Catch: Throwable -> L19
        if (r2 != null) goto L10;
    L16:
        r1 = r4;
        goto L17
    L10:
        if (r2.size() <= 2) goto L16;
        GeoFence r9 = f(r7, true);     // Catch: Throwable -> L19
        int r5 = w(r9);     // Catch: Throwable -> L19
        if (r5 != 0) goto L15;
        r0.add(r9);     // Catch: Throwable -> L19
    L15:
        r3 = r5;
    L19:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "doAddGeoFencePolygon");
    }

    public final void J() {
        if (this.y == false) goto L6;
        return;
    L6:
        if (this.l != null) goto L8;
        return;
    L8:
        if (this.t != null) goto L10;
    L14:
        boolean r0 = false;
    L16:
        if (r0 == false) goto L19;
        h(6, null, 0);
        h(5, null, 0);
        return;
    L19:
        r(7);
        h(7, null, 0);
        return;
    L10:
        if (j4.l(this.t) == false) goto L14;
        if ((SystemClock.elapsedRealtime() - this.u) >= AutoEndConversationTime.AFTER_10_SECONDS) goto L14;
        r0 = true;
        goto L16
    }

    public final void D(Bundle r6) {
        if (r6 == null) goto L47;
    L36:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "doSetGeoFenceAble");
        return;
    L4:
        if (r6.isEmpty() == true) goto L48;
        String r0 = r6.getString("fid");     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r0) == false) goto L9;
        return;
    L9:
        boolean r2 = true;
        boolean r7 = r6.getBoolean("ab", true);     // Catch: Throwable -> L36
        ArrayList<GeoFence> r1 = this.h;     // Catch: Throwable -> L36
        if (r1 != null) goto L12;
    L19:
        if (r7 == true) goto L34;
        ArrayList<GeoFence> r8 = this.h;     // Catch: Throwable -> L36
        if (r8 != null) goto L23;
    L31:
        if (r2 == false) goto L46;
        C();     // Catch: Throwable -> L36
        return;
    L46:
        return;
    L23:
        if (r8.isEmpty() == true) goto L31;
        Iterator<GeoFence> r9 = this.h.iterator();     // Catch: Throwable -> L36
    L27:
        if (r9.hasNext() == false) goto L31;
        if (r9.next().isAble() == false) goto L27;
        r2 = false;
        goto L31
    L34:
        J();     // Catch: Throwable -> L36
        return;
    L12:
        if (r1.isEmpty() == true) goto L19;
        Iterator<GeoFence> r3 = this.h.iterator();     // Catch: Throwable -> L36
    L15:
        if (r3.hasNext() == false) goto L19;
        GeoFence r4 = r3.next();     // Catch: Throwable -> L36
        if (r4.getFenceId().equals(r0) == false) goto L15;
        r4.setAble(r7);     // Catch: Throwable -> L36
        goto L19
    L48:
        return;
    }

    public final void j(AMapLocation r8) {
    L46:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "doCheckFence");
        return;
    L3:
        if (this.y == false) goto L5;
        return;
    L5:
        ArrayList<GeoFence> r0 = this.h;     // Catch: Throwable -> L46
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isEmpty() == true) goto L62;
        if (r8 != null) goto L12;
        return;
    L12:
        if (r8.getErrorCode() != 0) goto L64;
        Iterator<GeoFence> r1 = this.h.iterator();     // Catch: Throwable -> L46
    L14:
        if (r1.hasNext() == false) goto L65;
        GeoFence r2 = r1.next();     // Catch: Throwable -> L46
        if (r2.isAble() == false) goto L14;
        if (v(r8, r2) == false) goto L14;
        int r3 = this.g;     // Catch: Throwable -> L46
        boolean r4 = true;
        boolean r5 = false;
        if ((r3 & 1) != 1) goto L29;
        if (r2.getStatus() != 1) goto L29;
        r5 = true;
        goto L29
    L26:
        th = move-exception;
        c4.g(th, "Utils", "remindStatus");     // Catch: Throwable -> L46
    L42:
        if (r5 == false) goto L14;
        r2.setCurrentLocation(r8);     // Catch: Throwable -> L46
        Bundle r6 = new Bundle();     // Catch: Throwable -> L46
        r6.putParcelable("geoFence", r2);     // Catch: Throwable -> L46
        g(1001, r6);     // Catch: Throwable -> L46
    L29:
        if ((r3 & 2) != 2) goto L34;
        if (r2.getStatus() != 2) goto L34;
        r5 = true;
    L34:
        if ((r3 & 4) == 4) goto L37;
    L40:
        r4 = r5;
    L41:
        r5 = r4;
        goto L42
    L37:
        if (r2.getStatus() != 3) goto L40;
    L65:
        return;
    L64:
        return;
    }

    public static boolean p(AMapLocation r10, GeoFence r11) {
        boolean r0 = false;
    L35:
        th = th;
    L36:
        c4.g(th, "Utils", "isInGeoFence");
    L38:
        return r0;
    L4:
        if (j4.l(r10) == true) goto L6;
    L39:
        goto L38
    L6:
        if (r11.getPointList() == null) goto L39;
        if (r11.getPointList().isEmpty() == true) goto L39;
        int r1 = r11.getType();     // Catch: Throwable -> L35
        if (r1 == 0) goto L28;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L28;
        if (r1 != 3) goto L39;
    L15:
        Iterator r12 = r11.getPointList().iterator();     // Catch: Throwable -> L35
        boolean r2 = false;
    L42:
    L26:
        th = th;
        r0 = r2;
        goto L36
    L18:
        if (r12.hasNext() == false) goto L25;
        List r3 = (List) r12.next();     // Catch: Throwable -> L26
        if (r3.size() >= 3) goto L22;
        boolean r4 = false;
    L23:
        if (r4 == false) goto L42;
        r2 = true;
        goto L42
    L22:
        r4 = c4.j(new DPoint(r10.getLatitude(), r10.getLongitude()), r3);     // Catch: Throwable -> L26
        goto L23
    L25:
        r0 = r2;
    L28:
        DPoint r5 = r11.getCenter();     // Catch: Throwable -> L35
        if (j4.c(new double[]{r5.getLatitude(), r5.getLongitude(), r10.getLatitude(), r10.getLongitude()}) > r11.getRadius()) goto L32;
        boolean r13 = true;
    L33:
        if (r13 == false) goto L39;
        return true;
    L32:
        r13 = false;
        goto L33
    }

    public static boolean v(AMapLocation r7, GeoFence r8) {
        boolean r0 = false;
    L22:
        th = th;
    L23:
        c4.g(th, "Utils", "isFenceStatusChanged");
    L25:
        return r0;
    L4:
        if (p(r7, r8) == false) goto L17;
        if (r8.getEnterTime() != (-1)) goto L11;
        if (r8.getStatus() == 1) goto L25;
        r8.setEnterTime(SystemClock.elapsedRealtime());     // Catch: Throwable -> L22
        r8.setStatus(1);     // Catch: Throwable -> L22
        return true;
    L11:
        if (r8.getStatus() == 3) goto L25;
        if ((SystemClock.elapsedRealtime() - r8.getEnterTime()) <= 600000) goto L25;
        r8.setStatus(3);     // Catch: Throwable -> L22
        return true;
    L17:
        if (r8.getStatus() == 2) goto L25;
        r8.setStatus(2);     // Catch: Throwable -> L20
        r8.setEnterTime(-1);     // Catch: Throwable -> L20
        r0 = true;
    L20:
        th = th;
        r0 = true;
        goto L23
    }

    public final GeoFence f(Bundle r11, boolean r12) {
        GeoFence r0 = new GeoFence();
        ArrayList r1 = new ArrayList();
        DPoint r2 = new DPoint();
        if (r12 == false) goto L16;
        r0.setType(1);
        r1 = r11.getParcelableArrayList("pointList");
        if (r1 == null) goto L15;
        DPoint r13 = new DPoint();
        Iterator r3 = r1.iterator();     // Catch: Throwable -> L13
        double r4 = 0.0d;
        double r5 = 0.0d;
    L9:
        if (r3.hasNext() == false) goto L11;
        DPoint r7 = (DPoint) r3.next();     // Catch: Throwable -> L13
        r4 = r4 + r7.getLatitude();     // Catch: Throwable -> L13
        r5 = r5 + r7.getLongitude();     // Catch: Throwable -> L13
        goto L9
    L11:
        r2 = new DPoint(j4.s(r4 / ((double) r1.size())), j4.s(r5 / ((double) r1.size())));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        c4.g(th, "GeoFenceUtil", "getPolygonCenter");
        r2 = r13;
    L15:
        r0.setMaxDis2Center(q(r2, r1));
        r0.setMinDis2Center(b(r2, r1));
    L24:
        r0.setActivatesAction(this.g);
        r0.setCustomId(r11.getString("customId"));
        ArrayList r14 = new ArrayList();
        r14.add(r1);
        r0.setPointList(r14);
        r0.setCenter(r2);
        r0.setPendingIntentAction(this.d);
        r0.setExpiration(-1);
        r0.setPendingIntent(this.c);
        StringBuilder r15 = new StringBuilder();
        r15.append(w0.b());
        r0.setFenceId(r15.toString());
        h4 r16 = this.a;
        if (r16 == null) goto L27;
        r16.c(this.b, 2);
    L27:
        return r0;
    L16:
        r0.setType(0);
        r2 = (DPoint) r11.getParcelable("centerPoint");
        if (r2 == null) goto L19;
        r1.add(r2);
    L19:
        float r6 = 1000.0f;
        float r17 = r11.getFloat("fenceRadius", 1000.0f);
        if (r17 <= 0.0f) goto L23;
        r6 = r17;
    L23:
        r0.setRadius(r6);
        r0.setMinDis2Center(r6);
        r0.setMaxDis2Center(r6);
        goto L24
    }

    public final void s(int r28, Bundle r29) {
        Bundle r5 = new Bundle();
        ArrayList<? extends Parcelable> r9 = new ArrayList();     // Catch: Throwable -> L95
        if (r29 != null) goto L111;
    L92:
        Bundle r4 = r5;
        String r2 = "errorCode";
        int r10 = 1;
    L93:
        r4.putInt(r2, r10);
    L100:
        g(1000, r4);
        return;
    L111:
    L90:
        th = th;
        r4 = r5;
        String r3 = "errorCode";
    L97:
        int r8 = 0;
    L107:
        c4.g(th, "GeoFenceManager", "doAddGeoFenceNearby");     // Catch: Throwable -> L102
        r4.putInt(r3, 8);
    L102:
        th = move-exception;
        r4.putInt(r3, r8);
        g(1000, r4);
        throw th;
    L6:
        if (r29.isEmpty() == true) goto L92;
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L90
        String r12 = r29.getString("customId");     // Catch: Throwable -> L90
        String r15 = r29.getString("keyWords");     // Catch: Throwable -> L90
        String r17 = r29.getString("city");     // Catch: Throwable -> L90
        String r13 = r29.getString("poiType");     // Catch: Throwable -> L90
        DPoint r14 = r29.getParcelable("centerPoint");     // Catch: Throwable -> L90
        int r6 = r29.getInt("searchSize", 10);     // Catch: Throwable -> L90
        float r7 = r29.getFloat("aroundRadius", 3000.0f);     // Catch: Throwable -> L90
        if (n(r28, r15, r13, r14) == true) goto L115;
        String r24 = "customId";
        String r22 = "errorCode";
        Bundle r23 = r5;
        ArrayList<? extends Parcelable> r0 = r9;
        String r25 = r12;
        r8 = 1;
    L85:
        r4 = r23;
        r4.putString(r24, r25);     // Catch: Throwable -> L88
        r4.putParcelableArrayList("resultList", r0);     // Catch: Throwable -> L88
        r10 = r8;
        r2 = r22;
    L88:
        th = th;
        r3 = r22;
        goto L107
    L115:
        Bundle r16 = new Bundle();     // Catch: Throwable -> L79
        r16.putString("customId", r12);     // Catch: Throwable -> L79
        r16.putString("pendingIntentAction", this.d);     // Catch: Throwable -> L79
        r22 = "errorCode";
        r16.putLong("expiration", -1);     // Catch: Throwable -> L77
        r16.putInt("activatesAction", this.g);     // Catch: Throwable -> L77
        r23 = r5;
        r24 = "customId";
        r25 = r12;
        if (r28 != 1) goto L15;
        r16.putFloat("fenceRadius", 1000.0f);     // Catch: Throwable -> L21
        a0 r18 = this.q;     // Catch: Throwable -> L21
        Context r19 = this.b;     // Catch: Throwable -> L21
        String r110 = String.valueOf(r6);     // Catch: Throwable -> L21
        r18.getClass();     // Catch: Throwable -> L21
        Map<String, String> r20 = a0.b(r19, r15, r13, r17, r110, null, null, null);     // Catch: Throwable -> L21
        HashMap r21 = (HashMap) r20;     // Catch: Throwable -> L21
        r21.put("children", "1");     // Catch: Throwable -> L21
        r21.put("page", "1");     // Catch: Throwable -> L21
        r21.put("extensions", "base");     // Catch: Throwable -> L21
        String r26 = a0.a(r19, "http://restsdk.amap.com/v3/place/text?", r20);     // Catch: Throwable -> L21
    L24:
        int r27 = 4;
        if (r26 != null) goto L27;
        r0 = r9;
    L76:
        r8 = r27;
        goto L85
    L27:
        if (1 != r28) goto L29;
        int r30 = w0.a(r26, r11, r16);     // Catch: Throwable -> L21
    L31:
        if (2 != r28) goto L34;
        r30 = w0.a(r26, r11, r16);     // Catch: Throwable -> L21
    L34:
        if (3 != r28) goto L37;
        this.r.getClass();     // Catch: Throwable -> L21
        r30 = w0.d(r26, r11, r16);     // Catch: Throwable -> L21
    L37:
        if (r30 == 10000) goto L39;
        r0 = r9;
        if (r30 != 1) goto L52;
    L66:
        int r111 = r30;
    L67:
        if (r111 != 0) goto L105;
    L74:
        r8 = r111;
        goto L85
    L105:
        k("添加围栏失败", r111, "searchErrCode is ".concat(String.valueOf(r111)), new String[0]);     // Catch: Throwable -> L72
    L72:
        th = th;
    L83:
        r3 = r22;
        r4 = r23;
        goto L97
    L52:
        if (r30 == 7) goto L66;
        if (r30 == 4) goto L66;
        if (r30 == 5) goto L66;
        if (r30 == 16) goto L66;
        if (r30 == 17) goto L66;
        switch(r30) {
            case 10000: goto L64;
            case 10001: goto L63;
            case 10002: goto L63;
            case 10003: goto L62;
            case 10004: goto L62;
            case 10005: goto L62;
            case 10006: goto L62;
            case 10007: goto L63;
            case 10008: goto L63;
            case 10009: goto L63;
            case 10010: goto L62;
            case 10011: goto L62;
            case 10012: goto L63;
            case 10013: goto L63;
            case 10014: goto L62;
            case 10015: goto L62;
            case 10016: goto L62;
            case 10017: goto L62;
            default: goto L60;
        };
    L60:
        switch(r30) {
            case 20000: goto L65;
            case 20001: goto L65;
            case 20002: goto L65;
            default: goto L61;
        };
    L61:
        r111 = 8;
        goto L67
    L65:
        r111 = 1;
        goto L67
    L62:
        r111 = 4;
        goto L67
    L63:
        r111 = 7;
        goto L67
    L64:
        r111 = 0;
        goto L67
    L39:
        if (r11.isEmpty() == false) goto L41;
        r0 = r9;
        r8 = 16;
        goto L85
    L41:
        r8 = c(r11);     // Catch: Throwable -> L21
        r0 = r9;
        if (r8 == 0) goto L119;
        r27 = r8;
        goto L76
    L119:
        r0.addAll(r11);     // Catch: Throwable -> L46
    L46:
        th = th;
        r3 = r22;
        r4 = r23;
        goto L107
    L29:
        r30 = 0;
        goto L31
    L15:
        if (r28 != 2) goto L17;
        double r112 = j4.s(r14.getLatitude());     // Catch: Throwable -> L21
        double r113 = j4.s(r14.getLongitude());     // Catch: Throwable -> L21
        int r31 = Float.valueOf(r7).intValue();     // Catch: Throwable -> L21
        r16.putFloat("fenceRadius", 200.0f);     // Catch: Throwable -> L21
        a0 r32 = this.q;     // Catch: Throwable -> L21
        Context r114 = this.b;     // Catch: Throwable -> L21
        String r33 = String.valueOf(r6);     // Catch: Throwable -> L21
        String r210 = String.valueOf(r112);     // Catch: Throwable -> L21
        String r211 = String.valueOf(r113);     // Catch: Throwable -> L21
        String r34 = String.valueOf(r31);     // Catch: Throwable -> L21
        r32.getClass();     // Catch: Throwable -> L21
        Map<String, String> r35 = a0.b(r114, r15, r13, null, r33, r210, r211, r34);     // Catch: Throwable -> L21
        HashMap r36 = (HashMap) r35;     // Catch: Throwable -> L21
        r36.put("children", "1");     // Catch: Throwable -> L21
        r36.put("page", "1");     // Catch: Throwable -> L21
        r36.put("extensions", "base");     // Catch: Throwable -> L21
        r26 = a0.a(r114, "http://restsdk.amap.com/v3/place/around?", r35);     // Catch: Throwable -> L21
        goto L24
    L17:
        if (r28 == 3) goto L19;
        r26 = null;
        goto L24
    L19:
        a0 r37 = this.q;     // Catch: Throwable -> L21
        Context r38 = this.b;     // Catch: Throwable -> L21
        r37.getClass();     // Catch: Throwable -> L21
        Map<String, String> r39 = a0.b(r38, r15, null, null, null, null, null, null);     // Catch: Throwable -> L21
        HashMap r40 = (HashMap) r39;     // Catch: Throwable -> L21
        r40.put("extensions", "all");     // Catch: Throwable -> L21
        r40.put("subdistrict", "0");     // Catch: Throwable -> L21
        r26 = a0.a(r38, "http://restsdk.amap.com/v3/config/district?", r39);     // Catch: Throwable -> L21
    L21:
        th = th;
    L77:
        th = th;
    L81:
        r23 = r5;
    L79:
        th = th;
        r22 = "errorCode";
    L95:
        th = th;
        r3 = "errorCode";
        r4 = r5;
        goto L97
    }
}
