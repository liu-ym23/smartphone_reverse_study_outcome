package qa;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.loc.em;
import com.loc.es;
import com.obric.cae.cloud.CloudServiceConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class k2 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static boolean f10723w = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f10726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f10727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public es f10728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public es f10729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f10730g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f10731h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e4 f10732i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public s2 f10733j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HashMap<Messenger, Long> f10734k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public w3 f10735l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f10736m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f10737n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f10738o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f10739p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public HashMap<String, Boolean> f10740q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f10741r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f10742s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f10743t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AMapLocationClientOption f10744u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AMapLocationClientOption f10745v;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k2 f10746a;

        public a(k2 r8, Looper r10) {
            this.f10746a = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r10) {
            k2 r8 = this.f10746a;
            Bundle r11 = r10.getData();     // Catch: Throwable -> L27
            Messenger r12 = r10.replyTo;     // Catch: Throwable -> L25
            if (r11 != null) goto L96;
        L30:
            int r13 = r10.what;     // Catch: Throwable -> L82
            if (r13 == 0) goto L79;
            if (r13 != 1) goto L34;
            r8.b(r11);     // Catch: Throwable -> L82
            k2.k(r8, r12, r11);     // Catch: Throwable -> L82
        L80:
            super.handleMessage(r10);     // Catch: Throwable -> L82
            return;
        L82:
            th = move-exception;
            t3.g("actionHandler", "handleMessage", th);
            return;
        L34:
            switch(r13) {
                case 9: goto L72;
                case 10: goto L71;
                case 11: goto L70;
                case 12: goto L69;
                case 13: goto L60;
                case 14: goto L48;
                case 15: goto L47;
                case 16: goto L42;
                case 17: goto L37;
                case 18: goto L36;
                default: goto L80;
            };
        L36:
            r8.b(r11);     // Catch: Throwable -> L82
            r8.d(r12, r11, "FINE_LOC", 12);     // Catch: Throwable -> L82
            goto L80
        L37:
            if (r11 == null) goto L80;
            if (r11.isEmpty() == true) goto L80;
            String r14 = r11.getString("objHash");     // Catch: Throwable -> L82
            HashMap<String, Boolean> r15 = r8.f10740q;     // Catch: Throwable -> L82
            Boolean r16 = Boolean.FALSE;     // Catch: Throwable -> L82
        L41:
            r15.put(r14, r16);     // Catch: Throwable -> L82
            r8.l();     // Catch: Throwable -> L82
            goto L80
        L42:
            if (r11 == null) goto L80;
            if (r11.isEmpty() == true) goto L80;
            r14 = r11.getString("objHash");     // Catch: Throwable -> L82
            r15 = r8.f10740q;     // Catch: Throwable -> L82
            r16 = Boolean.TRUE;     // Catch: Throwable -> L82
            goto L41
        L47:
            r8.b(r11);     // Catch: Throwable -> L82
            r8.d(r12, r11, "COARSE_LOC", 1);     // Catch: Throwable -> L82
            goto L80
        L48:
            Messenger r17 = r10.replyTo;     // Catch: Throwable -> L82
            if (r17 == null) goto L55;
            ArrayList r18 = r8.f10738o;     // Catch: Throwable -> L82
            if (r18 == null) goto L55;
            if (r18.contains(r17) == false) goto L55;
            r8.f10738o.remove(r17);     // Catch: Throwable -> L82
        L55:
            ArrayList r19 = r8.f10738o;     // Catch: Throwable -> L82
            if (r19 == null) goto L80;
            if (r19.size() != 0) goto L80;
            r8.f10733j.t();     // Catch: Throwable -> L82
            goto L80
        L60:
            Messenger r20 = r10.replyTo;     // Catch: Throwable -> L82
            if (r20 == null) goto L80;
            ArrayList r21 = r8.f10738o;     // Catch: Throwable -> L82
            if (r21 == null) goto L80;
            if (r21.contains(r20) == true) goto L80;
            r8.f10738o.add(r20);     // Catch: Throwable -> L82
            if (r8.f10738o.size() != 1) goto L80;
            r8.n();     // Catch: Throwable -> L82
            goto L80
        L69:
            r8.f10734k.remove(r12);     // Catch: Throwable -> L82
            goto L80
        L70:
            r8.m();     // Catch: Throwable -> L82
            goto L80
        L71:
            r8.b(r11);     // Catch: Throwable -> L82
            r8.d(r12, r11, "FINE_LOC", 1);     // Catch: Throwable -> L82
            goto L80
        L72:
            r8.b(r11);     // Catch: Throwable -> L82
            Context r22 = r8.f10731h;     // Catch: Throwable -> L76
            boolean r23 = s3.f11064a;     // Catch: Throwable -> L76
        L92:
            s4 r24 = t3.j();     // Catch: Throwable -> L85
            r24.f11093c = s3.f11065b ? 1 : 0;     // Catch: Throwable -> L85
            q.c(r22, r24);     // Catch: Throwable -> L85
        L76:
            th = move-exception;
            t3.g("ApsServiceCore", "doCallOtherSer", th);     // Catch: Throwable -> L82
            goto L80
        L79:
            r8.b(r11);     // Catch: Throwable -> L82
            k2.h(r8, r12, r11);     // Catch: Throwable -> L82
            goto L80
        L96:
        L11:
            Throwable th = th;
        L86:
            t3.g("ApsServiceCore", "ActionHandler handlerMessage", th);     // Catch: Throwable -> L82
            goto L30
        L7:
            if (r11.isEmpty() == true) goto L30;
            String r25 = r11.getString("c");     // Catch: Throwable -> L11
            if (TextUtils.isEmpty(r8.f10741r) == false) goto L14;
            r8.f10741r = l6.a.j(h4.f(r8.f10731h));     // Catch: Throwable -> L11
        L14:
            if (TextUtils.isEmpty(r25) == false) goto L16;
        L19:
            boolean r26 = false;
        L20:
            if (r26 == true) goto L30;
            if (r10.what != 1) goto L98;
            w3.a(2102, null);     // Catch: Throwable -> L11
            es r27 = k2.a(10, "invalid handlder scode!!!#1002");     // Catch: Throwable -> L11
            em r28 = new em();     // Catch: Throwable -> L11
            r28.f5204r = "#1002";     // Catch: Throwable -> L11
            r28.f5203q = "conitue";     // Catch: Throwable -> L11
            r8.e(r12, r27, r27.f5211f0, r28);     // Catch: Throwable -> L11
            return;
        L98:
            return;
        L16:
            if (r25.equals(r8.f10741r) == false) goto L19;
            r26 = true;
        L25:
            th = move-exception;
            r12 = null;
            th = th;
        L27:
            th = move-exception;
            r12 = null;
            th = th;
            r11 = null;
            goto L86
        }
    }

    public class b extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k2 f10747a;

        public b(k2 r8) {
            this.f10747a = r8;
            super("amapLocCoreThread");
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            k2 r8 = this.f10747a;
            r8.f10732i = new e4(r8.f10731h);     // Catch: Throwable -> L5
        L19:
            s3.g(r8.f10731h);     // Catch: Throwable -> L9
            s3.a(r8.f10731h);     // Catch: Throwable -> L9
        L11:
            r8.f10733j = new s2(false);     // Catch: Throwable -> L13
            super.onLooperPrepared();     // Catch: Throwable -> L13
            return;
        L9:
            th = move-exception;
            t3.g("APSManager$ActionThread", "init 3", th);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            t3.g("APSManager$ActionThread", "onLooperPrepared", th);
            return;
        L5:
            th = move-exception;
            t3.g("APSManager$ActionThread", "init 2", th);     // Catch: Throwable -> L13
            goto L19
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            super.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            t3.g("APSManager$ActionThread", "run", th);
        }
    }

    public k2(Context r8) {
        this.f10724a = false;
        this.f10725b = false;
        this.f10726c = null;
        this.f10727d = 0;
        this.f10728e = null;
        this.f10729f = null;
        this.f10730g = null;
        this.f10731h = null;
        this.f10732i = null;
        this.f10733j = null;
        this.f10734k = new HashMap();
        this.f10735l = null;
        this.f10736m = 0;
        this.f10737n = 0;
        this.f10739p = 0;
        this.f10740q = new HashMap();
        this.f10741r = null;
        this.f10742s = true;
        this.f10743t = "";
        this.f10744u = null;
        this.f10745v = new AMapLocationClientOption();
        this.f10731h = r8;
    }

    public static es a(int r8, String r10) {
        es r11 = new es();     // Catch: Throwable -> L4
        r11.v(r8);     // Catch: Throwable -> L4
        r11.f3648y = r10;     // Catch: Throwable -> L4
        return r11;
    L4:
        th = move-exception;
        t3.g("ApsServiceCore", "newInstanceAMapLoc", th);
        return null;
    }

    public static void c(Messenger r8, int r10, Bundle r11) {
        if (r8 == null) goto L10;
        Message r12 = Message.obtain();     // Catch: Throwable -> L5
        r12.setData(r11);     // Catch: Throwable -> L5
        r12.what = r10;     // Catch: Throwable -> L5
        r8.send(r12);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        t3.g("ApsServiceCore", "sendMessage", th);
        return;
    }

    public static void h(k2 r8, Messenger r10, Bundle r11) {
        r8.getClass();
        if (r11 == null) goto L28;
    L21:
        th = move-exception;
        t3.g("ApsServiceCore", "doInitAuth", th);
        return;
    L5:
        if (r11.isEmpty() == false) goto L8;
        return;
    L8:
        if (r8.f10725b == true) goto L30;
        r8.f10725b = true;     // Catch: Throwable -> L21
        u2 r12 = r8.f10733j.L;     // Catch: Throwable -> L18
        if (r12 == null) goto L15;
        r12.e();     // Catch: Throwable -> L18
    L15:
        if (s3.f11082s == false) goto L31;
        Bundle r13 = new Bundle();     // Catch: Throwable -> L18
        r13.putBoolean("installMockApp", true);     // Catch: Throwable -> L18
        c(r10, 9, r13);     // Catch: Throwable -> L18
    L32:
        return;
    L31:
        return;
    L18:
        th = move-exception;
        t3.g("ApsServiceCore", "initAuth", th);     // Catch: Throwable -> L21
        return;
    L30:
        return;
    }

    public static AMapLocationClientOption j(Bundle r8) {
        AMapLocationClientOption r10 = null;
        r10 = t3.b(r8.getBundle("optBundle"));     // Catch: Throwable -> L11
        String r11 = r8.getString("d");     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r11) == true) goto L14;
        k4.f10751d = r11;     // Catch: Throwable -> L8
    L14:
    L13:
        return r10;
    L8:
        th = move-exception;
        t3.g("APSManager", "doLocation setUmidToken", th);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        t3.g("APSManager", "parseBundle", th);
        goto L13
    }

    public static void k(k2 r11, Messenger r12, Bundle r13) {
        r11.getClass();
        if (r13 == null) goto L70;
    L62:
        th = move-exception;
        t3.g("ApsServiceCore", "doLocation", th);
        return;
    L5:
        if (r13.isEmpty() == true) goto L71;
        em r8 = new em();     // Catch: Throwable -> L62
        r8.f5203q = "conitue";     // Catch: Throwable -> L62
        AMapLocationClientOption r14 = j(r13);     // Catch: Throwable -> L62
        r11.g(r14);     // Catch: Throwable -> L62
        if (r11.f10734k.containsKey(r12) == true) goto L10;
    L14:
        AMapLocation r10 = null;
        if (r11.f10742s == true) goto L17;
        es r15 = a(9, "init error : " + r11.f10743t + "#0901");     // Catch: Throwable -> L62
        r11.f10728e = r15;     // Catch: Throwable -> L62
        r8.f5204r = "#0901";     // Catch: Throwable -> L62
        r11.e(r12, r15, r15.f5211f0, r8);     // Catch: Throwable -> L62
        w3.a(2091, null);     // Catch: Throwable -> L62
        return;
    L17:
        long r16 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L62
        int r17 = 3;
        if (y3.l(r11.f10728e) == true) goto L20;
    L22:
        r8.f5197a = SystemClock.elapsedRealtime();     // Catch: Throwable -> L62
        es r18 = r11.f10733j.b(r8);     // Catch: Throwable -> L38
        r11.f10728e = r18;     // Catch: Throwable -> L38
        int r19 = r18.f3649z;     // Catch: Throwable -> L38
        if (r19 != 6) goto L27;
    L35:
        r11.f10733j.i(r18, 2);     // Catch: Throwable -> L38
    L36:
        r11.f10728e = r11.f10733j.c(r11.f10728e);     // Catch: Throwable -> L38
    L42:
        if (y3.l(r11.f10728e) == false) goto L45;
        r11.f10727d = SystemClock.elapsedRealtime();     // Catch: Throwable -> L62
    L45:
        if (r11.f10728e != null) goto L47;
        r11.f10728e = a(8, "loc is null#0801");     // Catch: Throwable -> L62
        r8.f5204r = "#0801";     // Catch: Throwable -> L62
    L47:
        es r20 = r11.f10728e;     // Catch: Throwable -> L62
        if (r20 == null) goto L51;
        String r21 = r20.f5211f0;     // Catch: Throwable -> L62
        r10 = r20.t();     // Catch: Throwable -> L62
        String r22 = r21;
    L67:
    L58:
        th = move-exception;
        t3.g("ApsServiceCore", "fixLastLocation", th);     // Catch: Throwable -> L62
    L60:
        r11.e(r12, r10, r22, r8);     // Catch: Throwable -> L62
        return;
    L53:
        if (r14.f3661v == false) goto L60;
        e4 r23 = r11.f10732i;     // Catch: Throwable -> L58
        if (r23 == null) goto L60;
        r10 = r23.a(r10, r22, r14.f3665z);     // Catch: Throwable -> L58
    L51:
        r22 = null;
        goto L67
    L27:
        if (r19 == 5) goto L35;
        if (r19 == 2) goto L34;
        r17 = 4;
        if (r19 != 4) goto L36;
    L34:
        r11.f10733j.i(r18, r17);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        w3.a(2081, null);     // Catch: Throwable -> L62
        r8.f5204r = "#0801";     // Catch: Throwable -> L62
        r11.f10728e = a(8, "loc error : " + th.getMessage() + "#0801");     // Catch: Throwable -> L62
        t3.g("ApsServiceCore", "run part2", th);     // Catch: Throwable -> L62
        goto L42
    L20:
        if ((r16 - r11.f10727d) >= 600) goto L22;
        es r110 = r11.f10728e;     // Catch: Throwable -> L62
        r11.e(r12, r110, r110.f5211f0, r8);     // Catch: Throwable -> L62
        r11.f10733j.i(r11.f10728e, 3);     // Catch: Throwable -> L62
        return;
    L10:
        if (r14.f3652m == true) goto L14;
        if ((SystemClock.elapsedRealtime() - r11.f10734k.get(r12).longValue()) >= 800) goto L14;
        return;
    L71:
        return;
    }

    public final void b(Bundle r8) {
        Context r10 = this.f10731h;
    L18:
        th = move-exception;
        this.f10742s = false;
        th.printStackTrace();
        this.f10743t = th.getMessage();
        t3.g("ApsServiceCore", "init", th);
        return;
    L4:
        if (this.f10724a == false) goto L9;
        s2 r11 = this.f10733j;     // Catch: Throwable -> L18
        if (r11 == null) goto L22;
        r11.k();     // Catch: Throwable -> L18
        return;
    L22:
        return;
    L9:
        t3.c(r10);     // Catch: Throwable -> L18
        if (r8 == null) goto L12;
        this.f10745v = t3.b(r8.getBundle("optBundle"));     // Catch: Throwable -> L18
    L12:
        this.f10733j.f(r10);     // Catch: Throwable -> L18
        this.f10733j.o();     // Catch: Throwable -> L18
        g(this.f10745v);     // Catch: Throwable -> L18
        this.f10733j.q();     // Catch: Throwable -> L18
        this.f10724a = true;     // Catch: Throwable -> L18
        this.f10742s = true;     // Catch: Throwable -> L18
        this.f10743t = "";     // Catch: Throwable -> L18
        ArrayList r12 = this.f10738o;     // Catch: Throwable -> L18
        if (r12 != null) goto L15;
        return;
    L15:
        if (r12.size() <= 0) goto L24;
        n();     // Catch: Throwable -> L18
        return;
    }

    public final void d(Messenger r18, Bundle r19, String r20, int r21) {
        if (r19 == null) goto L62;
    L48:
        th = move-exception;
        t3.g("ApsServiceCore", "doLocationGeo", th);
        return;
    L5:
        if (r19.isEmpty() == true) goto L63;
        double r12 = r19.getDouble("lat");     // Catch: Throwable -> L48
        double r14 = r19.getDouble("lon");     // Catch: Throwable -> L48
        float r8 = r19.getFloat("radius");     // Catch: Throwable -> L48
        long r10 = r19.getLong("time");     // Catch: Throwable -> L48
        if ("FINE_LOC".equals(r20) == false) goto L17;
        if (r21 != 1) goto L12;
        AMapLocation r11 = new AMapLocation(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS);     // Catch: Throwable -> L48
        r11.f3649z = 1;     // Catch: Throwable -> L48
    L15:
        r11.setLatitude(r12);     // Catch: Throwable -> L48
        r11.setLongitude(r14);     // Catch: Throwable -> L48
        r11.setAccuracy(r8);     // Catch: Throwable -> L48
        r11.setTime(r10);     // Catch: Throwable -> L48
        this.f10733j.g(r11);     // Catch: Throwable -> L48
        goto L17
    L12:
        if (r21 != 12) goto L14;
        AMapLocation r13 = new AMapLocation("network");     // Catch: Throwable -> L48
        r13.f3649z = 12;     // Catch: Throwable -> L48
        r11 = r13;
        goto L15
    L14:
        r11 = null;
    L17:
        if (s3.f11077n == true) goto L19;
        return;
    L19:
        AMapLocationClientOption r15 = j(r19);     // Catch: Throwable -> L48
        if (r15 != null) goto L22;
        return;
    L22:
        if (r15.f3654o == false) goto L57;
        g(r15);     // Catch: Throwable -> L48
        es r16 = this.f10729f;     // Catch: Throwable -> L48
        if (r16 == null) goto L29;
        float r17 = y3.b(new double[]{r12, r14, r16.A, r16.B});     // Catch: Throwable -> L48
        if (r17 >= (s3.f11078o * 3)) goto L31;
        f(r18, r20, r21);     // Catch: Throwable -> L48
    L31:
        if (r17 != (-1.0f)) goto L33;
    L36:
        b(r19);     // Catch: Throwable -> L48
        s2 r22 = this.f10733j;     // Catch: Throwable -> L48
        r22.getClass();     // Catch: Throwable -> L48
        String r23 = r22.f11051p.a(r22.f11036a, r12, r14);     // Catch: Throwable -> L51
        if (r23.contains("\"status\":\"1\"") == false) goto L41;
        es r24 = r22.f11041f.a(r23);     // Catch: Throwable -> L51
        r24.A = r12;     // Catch: Throwable -> L51
        r24.B = r14;     // Catch: Throwable -> L51
    L42:
        this.f10729f = r24;     // Catch: Throwable -> L48
        this.f10739p = SystemClock.elapsedRealtime();     // Catch: Throwable -> L48
        es r25 = this.f10729f;     // Catch: Throwable -> L48
        if (r25 != null) goto L45;
        return;
    L45:
        if (TextUtils.isEmpty(r25.f3638o) == true) goto L61;
        f(r18, r20, r21);     // Catch: Throwable -> L48
        return;
    L61:
        return;
    L41:
        r24 = null;
        goto L42
    L33:
        if (r17 > s3.f11078o) goto L35;
        return;
    L35:
        if ((SystemClock.elapsedRealtime() - this.f10739p) > (s3.f11079p * 1000)) goto L36;
        return;
    L29:
        r17 = -1.0f;
        goto L31
    L57:
        return;
    L63:
        return;
    }

    public final void e(Messenger r8, AMapLocation r10, String r11, em r12) {
        Bundle r13 = new Bundle();
        r13.setClassLoader(AMapLocation.class.getClassLoader());
        r13.putParcelable("loc", r10);
        r13.putString("nb", r11);
        r13.putParcelable("statics", r12);
        this.f10734k.put(r8, Long.valueOf(SystemClock.elapsedRealtime()));
        c(r8, 1, r13);
    }

    public final void f(Messenger r8, String r10, int r11) {
        Bundle r12 = new Bundle();
        r12.setClassLoader(AMapLocation.class.getClassLoader());
        r12.putInt("I_MAX_GEO_DIS", s3.f11078o * 3);
        r12.putInt("I_MIN_GEO_DIS", s3.f11078o);
        r12.putParcelable("loc", this.f10729f);
        if ("COARSE_LOC".equals(r10) == false) goto L6;
        int r13 = 103;
    L8:
        c(r8, r13, r12);
        return;
    L6:
        if (r11 != 1) goto L11;
        r13 = 6;
        goto L8
    L11:
        if (r11 != 12) goto L14;
        c(r8, 18, r12);
        return;
    }

    public final void g(AMapLocationClientOption r8) {
        s2 r10 = this.f10733j;     // Catch: Throwable -> L23
        if (r10 == null) goto L5;
        r10.h(r8);     // Catch: Throwable -> L23
    L5:
        if (r8 == null) goto L28;
        f10723w = r8.f3658s;     // Catch: Throwable -> L23
        AMapLocationClientOption r11 = this.f10744u;     // Catch: Throwable -> L23
        if (r11 == null) goto L21;
        boolean r12 = r8.f3660u;     // Catch: Throwable -> L23
        boolean r13 = r11.f3660u;     // Catch: Throwable -> L23
        if (r12 == r13) goto L11;
    L16:
        this.f10727d = 0;     // Catch: Throwable -> L23
    L17:
        if (r12 == r13) goto L19;
    L20:
        this.f10729f = null;     // Catch: Throwable -> L23
        goto L21
    L19:
        if (r11.B == r8.B) goto L21;
    L11:
        if (r8.f3654o != r11.f3654o) goto L16;
        if (r8.f3661v != r11.f3661v) goto L16;
        if (r11.B == r8.B) goto L17;
    L21:
        this.f10744u = r8;     // Catch: Throwable -> L23
        return;
    L28:
        return;
    L23:
        th = move-exception;
        t3.g("ApsServiceCore", "setExtra", th);
    }

    public final void i() {
        this.f10735l = new w3();     // Catch: Throwable -> L4
        b r8 = new b(this);     // Catch: Throwable -> L4
        this.f10726c = r8;     // Catch: Throwable -> L4
        r8.setPriority(5);     // Catch: Throwable -> L4
        this.f10726c.start();     // Catch: Throwable -> L4
        this.f10730g = new a(this, this.f10726c.getLooper());     // Catch: Throwable -> L4
        this.f10738o = new ArrayList();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        t3.g("ApsServiceCore", "onCreate", th);
    }

    public final void l() {
        if (this.f10733j == null) goto L20;
        HashMap<String, Boolean> r8 = this.f10740q;
        if (r8 != null) goto L7;
        return;
    L7:
        if (r8.isEmpty() == true) goto L22;
        Iterator<Boolean> r10 = this.f10740q.values().iterator();
    L10:
        if (r10.hasNext() == false) goto L15;
        if (r10.next().booleanValue() == false) goto L10;
        this.f10733j.j(true);
        return;
    L15:
        this.f10733j.j(false);
        return;
    L22:
        return;
    }

    public final void m() {
        HashMap<Messenger, Long> r8 = this.f10734k;     // Catch: Throwable -> L98
        if (r8 == null) goto L116;
        r8.clear();     // Catch: Throwable -> L98
        this.f10734k = null;     // Catch: Throwable -> L98
    L116:
        ArrayList r10 = this.f10738o;     // Catch: Throwable -> L10
        if (r10 == null) goto L12;
        r10.clear();     // Catch: Throwable -> L10
    L12:
        e4 r11 = this.f10732i;     // Catch: Throwable -> L98
        int r12 = 0;
        if (r11 != null) goto L104;
    L20:
        this.f10724a = false;     // Catch: Throwable -> L98
        this.f10725b = false;     // Catch: Throwable -> L98
        this.f10733j.s();     // Catch: Throwable -> L98
        a r13 = this.f10730g;     // Catch: Throwable -> L98
        if (r13 == null) goto L23;
        r13.removeCallbacksAndMessages(null);     // Catch: Throwable -> L98
    L23:
        this.f10730g = null;     // Catch: Throwable -> L98
        b r14 = this.f10726c;     // Catch: Throwable -> L98
        if (r14 != null) goto L118;
    L28:
        this.f10726c = null;     // Catch: Throwable -> L98
        w3 r15 = this.f10735l;     // Catch: Throwable -> L98
        Context r16 = this.f10731h;
        if (r15 != null) goto L32;
    L91:
        HashMap<String, Boolean> r17 = this.f10740q;     // Catch: Throwable -> L98
        if (r17 == null) goto L94;
        r17.clear();     // Catch: Throwable -> L98
        this.f10740q = null;     // Catch: Throwable -> L98
    L94:
        w3.c(r16);     // Catch: Throwable -> L98
        q.e();     // Catch: Throwable -> L98
        if (f10723w == false) goto L121;
        Process.killProcess(Process.myPid());     // Catch: Throwable -> L98
        return;
    L121:
        return;
    L32:
        if (this.f10736m == 0) goto L91;
        if (this.f10737n == 0) goto L91;
        long r18 = SystemClock.elapsedRealtime() - this.f10736m;     // Catch: Throwable -> L98
        String[] r19 = this.f10735l.f11189d;     // Catch: Throwable -> L98
        long r110 = x3.b(r16, "pref1", r19[2], 0);     // Catch: Throwable -> L102
        long r111 = x3.b(r16, "pref1", r19[0], 0);     // Catch: Throwable -> L102
        long r112 = x3.b(r16, "pref1", r19[1], 0);     // Catch: Throwable -> L102
        if (r110 == 0) goto L41;
    L45:
        long r113 = r111 - r110;
        long r114 = r112 - r110;
        if (r110 <= r113) goto L51;
        if (r110 <= r114) goto L53;
        int r115 = 2;
    L55:
        String[] r20 = this.f10735l.f11189d;     // Catch: Throwable -> L98
        long r116 = x3.b(r16, "pref1", r20[3], 0);     // Catch: Throwable -> L101
        long r117 = x3.b(r16, "pref1", r20[4], 0);     // Catch: Throwable -> L101
        long r21 = x3.b(r16, "pref1", r20[5], 0);     // Catch: Throwable -> L101
        if (r116 != 0) goto L66;
        if (r117 != 0) goto L66;
        if (r21 == 0) goto L74;
    L66:
        if (r116 <= r117) goto L71;
        if (r116 <= r21) goto L73;
        int r118 = 3;
    L75:
        Context r119 = this.f10731h;     // Catch: Throwable -> L98
        long r120 = this.f10737n;     // Catch: Throwable -> L98
        if (r115 == (-1)) goto L85;
        if (r118 == (-1)) goto L85;
        w3.e(r119, r115, r118, r120, r18);     // Catch: Throwable -> L82
    L82:
        th = move-exception;
        t3.g("ReportUtil", "reportServiceAliveTime", th);     // Catch: Throwable -> L98
    L85:
        w3 r22 = this.f10735l;     // Catch: Throwable -> L98
        r22.getClass();     // Catch: Throwable -> L98
        SharedPreferences.Editor r23 = r16.getSharedPreferences("pref1", 0).edit();     // Catch: Throwable -> L103
    L87:
        String[] r24 = r22.f11189d;     // Catch: Throwable -> L103
        if (r12 >= r24.length) goto L90;
        x3.g(r23, r24[r12], 0);     // Catch: Throwable -> L103
        r12 = r12 + 1;     // Catch: Throwable -> L103
        goto L87
    L90:
        x3.e(r23);     // Catch: Throwable -> L103
    L73:
        r118 = 5;
        goto L75
    L71:
        if (r117 <= r21) goto L73;
        r118 = 4;
    L74:
        r118 = -1;
    L53:
        r115 = 1;
        goto L55
    L51:
        if (r113 <= r114) goto L53;
        r115 = 0;
        goto L55
    L41:
        if (r111 != 0) goto L45;
        if (r112 != 0) goto L45;
    L54:
        r115 = -1;
        goto L55
    L118:
        l6.a.f(r14, HandlerThread.class, "quitSafely", new Object[0]);     // Catch: Throwable -> L27
    L27:
        this.f10726c.quit();     // Catch: Throwable -> L98
        goto L28
    L104:
        r11.d();     // Catch: Throwable -> L17
        r11.f10384e = 0;     // Catch: Throwable -> L17
        r11.f10385f = false;     // Catch: Throwable -> L17
        r11.f10382c = null;     // Catch: Throwable -> L17
        r11.f10383d = null;     // Catch: Throwable -> L17
    L19:
        this.f10732i = null;     // Catch: Throwable -> L98
        goto L20
    L17:
        th = move-exception;
        t3.g("LastLocationManager", "destroy", th);     // Catch: Throwable -> L98
    L10:
        th = move-exception;
        t3.g("apm", "des1", th);     // Catch: Throwable -> L98
    L98:
        th = move-exception;
        t3.g("apm", "tdest", th);
    }

    public final void n() {
        if (y3.F(this.f10731h) == false) goto L29;
        return;
    L29:
        s2 r8 = this.f10733j;     // Catch: Throwable -> L24
        if (r8 == null) goto L31;
        if (r8 == null) goto L32;
        r8.F = this.f10730g;     // Catch: Throwable -> L24
        r8.getClass();     // Catch: Throwable -> L24
        Context r10 = r8.f11036a;     // Catch: Throwable -> L21
        if (r10 != null) goto L13;
        return;
    L13:
        if (r8.L != null) goto L15;
        r8.L = new u2(r10);     // Catch: Throwable -> L21
    L15:
        c3 r11 = r8.f11039d;     // Catch: Throwable -> L21
        if (r11 == null) goto L34;
        g3 r12 = r8.f11038c;     // Catch: Throwable -> L21
        if (r12 == null) goto L35;
        r8.L.c(r11, r12, r8.F);     // Catch: Throwable -> L21
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L21:
        th = move-exception;
        q.f("as", "stc", th);     // Catch: Throwable -> L24
        return;
    L32:
        return;
    L31:
        return;
    L24:
        th = move-exception;
        t3.g("ApsServiceCore", "startColl", th);
    }
}
