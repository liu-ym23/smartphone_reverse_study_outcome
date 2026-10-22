package n4a;

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
import com.larus.apm.impl.protector.RunnableProtector;
import com.loc.em;
import com.loc.es;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s2 {
    public static boolean w;
    public boolean a;
    public boolean b;
    public b c;
    public long d;
    public es e;
    public es f;
    public a g;
    public final Context h;
    public t4 i;
    public b3 j;
    public HashMap<Messenger, Long> k;
    public h4 l;
    public long m;
    public long n;
    public List<Messenger> o;
    public long p;
    public HashMap<String, Boolean> q;
    public String r;
    public boolean s;
    public String t;
    public AMapLocationClientOption u;
    public AMapLocationClientOption v;

    public class a extends Handler {
        public final /* synthetic */ s2 a;

        public a(s2 r1, Looper r2) {
            this.a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r11) {
            Bundle r3 = r11.getData();     // Catch: Throwable -> L27
            Messenger r4 = r11.replyTo;     // Catch: Throwable -> L25
            if (r3 != null) goto L86;
        L30:
            int r2 = r11.what;     // Catch: Throwable -> L82
            if (r2 == 0) goto L79;
            if (r2 != 1) goto L34;
            this.a.b(r3);     // Catch: Throwable -> L82
            s2.k(this.a, r4, r3);     // Catch: Throwable -> L82
        L80:
            super.handleMessage(r11);     // Catch: Throwable -> L82
            return;
        L82:
            th = move-exception;
            c4.g(th, "actionHandler", "handleMessage");
            return;
        L34:
            switch(r2) {
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
            this.a.b(r3);     // Catch: Throwable -> L82
            this.a.d(r4, r3, "FINE_LOC", 12);     // Catch: Throwable -> L82
            goto L80
        L37:
            if (r3 == null) goto L80;
            if (r3.isEmpty() == true) goto L80;
            this.a.q.put(r3.getString("objHash"), Boolean.FALSE);     // Catch: Throwable -> L82
        L46:
            this.a.l();     // Catch: Throwable -> L82
            goto L80
        L42:
            if (r3 == null) goto L80;
            if (r3.isEmpty() == true) goto L80;
            this.a.q.put(r3.getString("objHash"), Boolean.TRUE);     // Catch: Throwable -> L82
            goto L46
        L47:
            this.a.b(r3);     // Catch: Throwable -> L82
            this.a.d(r4, r3, "COARSE_LOC", 1);     // Catch: Throwable -> L82
            goto L80
        L48:
            Messenger r0 = r11.replyTo;     // Catch: Throwable -> L82
            if (r0 == null) goto L55;
            List<Messenger> r1 = this.a.o;     // Catch: Throwable -> L82
            if (r1 == null) goto L55;
            if (((ArrayList) r1).contains(r0) == false) goto L55;
            ((ArrayList) this.a.o).remove(r0);     // Catch: Throwable -> L82
        L55:
            List<Messenger> r5 = this.a.o;     // Catch: Throwable -> L82
            if (r5 == null) goto L80;
            if (((ArrayList) r5).size() != 0) goto L80;
            this.a.j.u();     // Catch: Throwable -> L82
            goto L80
        L60:
            Messenger r6 = r11.replyTo;     // Catch: Throwable -> L82
            if (r6 == null) goto L80;
            List<Messenger> r7 = this.a.o;     // Catch: Throwable -> L82
            if (r7 == null) goto L80;
            if (((ArrayList) r7).contains(r6) == true) goto L80;
            ((ArrayList) this.a.o).add(r6);     // Catch: Throwable -> L82
            if (((ArrayList) this.a.o).size() != 1) goto L80;
            this.a.n();     // Catch: Throwable -> L82
            goto L80
        L69:
            this.a.k.remove(r4);     // Catch: Throwable -> L82
            goto L80
        L70:
            this.a.m();     // Catch: Throwable -> L82
            goto L80
        L71:
            this.a.b(r3);     // Catch: Throwable -> L82
            this.a.d(r4, r3, "FINE_LOC", 1);     // Catch: Throwable -> L82
            goto L80
        L72:
            this.a.b(r3);     // Catch: Throwable -> L82
            s2 r8 = this.a;     // Catch: Throwable -> L82
            r8.getClass();     // Catch: Throwable -> L82
            Context r9 = r8.h;     // Catch: Throwable -> L76
            boolean r10 = com.loc.h.a;     // Catch: Throwable -> L76
            e5 r12 = c4.k();     // Catch: Throwable -> L85
            r12.c = com.loc.h.b ? 1 : 0;     // Catch: Throwable -> L85
            r.b(r9, r12);     // Catch: Throwable -> L85
            goto L80
        L76:
            th = move-exception;
            c4.g(th, "ApsServiceCore", "doCallOtherSer");     // Catch: Throwable -> L82
            goto L80
        L79:
            this.a.b(r3);     // Catch: Throwable -> L82
            s2.h(this.a, r4, r3);     // Catch: Throwable -> L82
            goto L80
        L86:
        L11:
            Throwable th = th;
        L94:
            c4.g(th, "ApsServiceCore", "ActionHandler handlerMessage");     // Catch: Throwable -> L82
            goto L30
        L7:
            if (r3.isEmpty() == true) goto L30;
            String r13 = r3.getString("c");     // Catch: Throwable -> L11
            s2 r14 = this.a;     // Catch: Throwable -> L11
            if (TextUtils.isEmpty(r14.r) == false) goto L14;
            Context r15 = r14.h;     // Catch: Throwable -> L11
            String r16 = c4.a;     // Catch: Throwable -> L11
            r14.r = b5.a(v4.f(r15));     // Catch: Throwable -> L11
        L14:
            if (TextUtils.isEmpty(r13) == false) goto L16;
        L19:
            boolean r17 = false;
        L20:
            if (r17 == true) goto L30;
            if (r11.what != 1) goto L98;
            h4.k(null, 2102);     // Catch: Throwable -> L11
            es r18 = s2.a(10, "invalid handlder scode!!!#1002");     // Catch: Throwable -> L11
            em r19 = new em();     // Catch: Throwable -> L11
            r19.h = "#1002";     // Catch: Throwable -> L11
            r19.g = "conitue";     // Catch: Throwable -> L11
            this.a.e(r4, r18, r18.V, r19);     // Catch: Throwable -> L11
            return;
        L98:
            return;
        L16:
            if (r13.equals(r14.r) == false) goto L19;
            r17 = true;
        L25:
            th = move-exception;
            r4 = null;
            th = th;
        L27:
            th = move-exception;
            r4 = null;
            th = th;
            r3 = null;
            goto L94
        }
    }

    public class b extends PthreadHandlerThreadV2 {
        public final /* synthetic */ s2 c;

        public b(s2 r1) {
            this.c = r1;
            super("amapLocCoreThread");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void onLooperPrepared() {
            s2 r1 = this.c;     // Catch: Throwable -> L5
            r1.i = new t4(r1.h);     // Catch: Throwable -> L5
        L16:
            com.loc.h.g(this.c.h);     // Catch: Throwable -> L9
            com.loc.h.a(this.c.h);     // Catch: Throwable -> L9
        L11:
            s2 r2 = this.c;     // Catch: Throwable -> L13
            r2.j = new b3(false);     // Catch: Throwable -> L13
            super/*android.os.HandlerThread*/.onLooperPrepared();     // Catch: Throwable -> L13
            return;
        L9:
            th = move-exception;
            c4.g(th, "APSManager$ActionThread", "init 3");     // Catch: Throwable -> L13
            goto L11
        L13:
            th = move-exception;
            c4.g(th, "APSManager$ActionThread", "onLooperPrepared");
            return;
        L5:
            th = move-exception;
            c4.g(th, "APSManager$ActionThread", "init 2");     // Catch: Throwable -> L13
            goto L16
        }

        public final void run() {
            super.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            c4.g(th, "APSManager$ActionThread", "run");     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public s2(Context r5) {
        this.a = false;
        this.b = false;
        this.c = null;
        this.d = 0;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = new HashMap();
        this.l = null;
        this.m = 0;
        this.n = 0;
        this.p = 0;
        this.q = new HashMap();
        this.r = null;
        this.s = true;
        this.t = NameKeys.UnloadStrategy_No_Strategy;
        this.u = null;
        this.v = new AMapLocationClientOption();
        this.h = r5;
    }

    public static es a(int r1, String r2) {
        es r0 = new es();     // Catch: Throwable -> L4
        r0.setErrorCode(r1);     // Catch: Throwable -> L4
        r0.setLocationDetail(r2);     // Catch: Throwable -> L4
        return r0;
    L4:
        th = move-exception;
        c4.g(th, "ApsServiceCore", "newInstanceAMapLoc");
        return null;
    }

    public static void c(Messenger r1, int r2, Bundle r3) {
        if (r1 == null) goto L10;
        Message r0 = Message.obtain();     // Catch: Throwable -> L5
        r0.setData(r3);     // Catch: Throwable -> L5
        r0.what = r2;     // Catch: Throwable -> L5
        r1.send(r0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        c4.g(th, "ApsServiceCore", "sendMessage");
        return;
    }

    public final void b(Bundle r3) {
    L17:
        th = move-exception;
        this.s = false;
        th.printStackTrace();
        this.t = th.getMessage();
        c4.g(th, "ApsServiceCore", "init");
        return;
    L3:
        if (this.a == false) goto L8;
        b3 r4 = this.j;     // Catch: Throwable -> L17
        if (r4 == null) goto L21;
        r4.l();     // Catch: Throwable -> L17
        return;
    L21:
        return;
    L8:
        c4.c(this.h);     // Catch: Throwable -> L17
        if (r3 == null) goto L11;
        this.v = c4.b(r3.getBundle("optBundle"));     // Catch: Throwable -> L17
    L11:
        this.j.g(this.h);     // Catch: Throwable -> L17
        this.j.p();     // Catch: Throwable -> L17
        g(this.v);     // Catch: Throwable -> L17
        this.j.r();     // Catch: Throwable -> L17
        this.a = true;     // Catch: Throwable -> L17
        this.s = true;     // Catch: Throwable -> L17
        this.t = NameKeys.UnloadStrategy_No_Strategy;     // Catch: Throwable -> L17
        List<Messenger> r5 = this.o;     // Catch: Throwable -> L17
        if (r5 != null) goto L14;
        return;
    L14:
        if (((ArrayList) r5).size() <= 0) goto L23;
        n();     // Catch: Throwable -> L17
        return;
    }

    public final void g(AMapLocationClientOption r3) {
        b3 r0 = this.j;     // Catch: Throwable -> L24
        if (r0 == null) goto L5;
        r0.i(r3);     // Catch: Throwable -> L24
    L5:
        if (r3 == null) goto L29;
        w = r3.isKillProcess();     // Catch: Throwable -> L24
        if (this.u != null) goto L9;
    L22:
        this.u = r3;     // Catch: Throwable -> L24
        return;
    L9:
        if (r3.isOffset() == this.u.isOffset()) goto L11;
    L16:
        this.d = 0;     // Catch: Throwable -> L24
    L18:
        if (r3.isOffset() == this.u.isOffset()) goto L20;
    L21:
        this.f = null;     // Catch: Throwable -> L24
        goto L22
    L20:
        if (this.u.getGeoLanguage() == r3.getGeoLanguage()) goto L22;
    L11:
        if (r3.isNeedAddress() != this.u.isNeedAddress()) goto L16;
        if (r3.isLocationCacheEnable() != this.u.isLocationCacheEnable()) goto L16;
        if (this.u.getGeoLanguage() == r3.getGeoLanguage()) goto L18;
    L29:
        return;
    L24:
        th = move-exception;
        c4.g(th, "ApsServiceCore", "setExtra");
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Thread, n4a.s2$b] */
    public final void i() {
        this.l = new h4();     // Catch: Throwable -> L4
        ?? r0 = new b(this);     // Catch: Throwable -> L4
        this.c = r0;     // Catch: Throwable -> L4
        ThreadMethodProxy.setPriority(r0, 5);     // Catch: Throwable -> L4
        ThreadMethodProxy.start(this.c);     // Catch: Throwable -> L4
        this.g = new a(this, this.c.getLooper());     // Catch: Throwable -> L4
        this.o = new ArrayList();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c4.g(th, "ApsServiceCore", "onCreate");
    }

    public final void l() {
        if (this.j == null) goto L20;
        HashMap<String, Boolean> r0 = this.q;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isEmpty() == true) goto L22;
        Iterator<Boolean> r1 = this.q.values().iterator();
    L10:
        if (r1.hasNext() == false) goto L15;
        if (r1.next().booleanValue() == false) goto L10;
        this.j.k(true);
        return;
    L15:
        this.j.k(false);
        return;
    L22:
        return;
    }

    public final void m() {
        HashMap<Messenger, Long> r0 = this.k;     // Catch: Throwable -> L96
        if (r0 == null) goto L114;
        r0.clear();     // Catch: Throwable -> L96
        this.k = null;     // Catch: Throwable -> L96
    L114:
        List<Messenger> r1 = this.o;     // Catch: Throwable -> L10
        if (r1 == null) goto L12;
        ((ArrayList) r1).clear();     // Catch: Throwable -> L10
    L12:
        t4 r2 = this.i;     // Catch: Throwable -> L96
        int r7 = 0;
        if (r2 != null) goto L108;
    L20:
        this.a = false;     // Catch: Throwable -> L96
        this.b = false;     // Catch: Throwable -> L96
        this.j.t();     // Catch: Throwable -> L96
        a r3 = this.g;     // Catch: Throwable -> L96
        if (r3 == null) goto L23;
        r3.removeCallbacksAndMessages(null);     // Catch: Throwable -> L96
    L23:
        this.g = null;     // Catch: Throwable -> L96
        b r4 = this.c;     // Catch: Throwable -> L96
        if (r4 != null) goto L116;
    L28:
        this.c = null;     // Catch: Throwable -> L96
        if (this.l != null) goto L31;
    L89:
        HashMap<String, Boolean> r5 = this.q;     // Catch: Throwable -> L96
        if (r5 == null) goto L92;
        r5.clear();     // Catch: Throwable -> L96
        this.q = null;     // Catch: Throwable -> L96
    L92:
        h4.b(this.h);     // Catch: Throwable -> L96
        r.e();     // Catch: Throwable -> L96
        if (w == false) goto L119;
        Process.killProcess(Process.myPid());     // Catch: Throwable -> L96
        return;
    L119:
        return;
    L31:
        if (this.m == 0) goto L89;
        if (this.n == 0) goto L89;
        long r17 = SystemClock.elapsedRealtime() - this.m;     // Catch: Throwable -> L96
        h4 r6 = this.l;     // Catch: Throwable -> L96
        Context r8 = this.h;     // Catch: Throwable -> L96
        r6.getClass();     // Catch: Throwable -> L96
        long r12 = i4.b(r8, "pref1", r6.d[2], 0);     // Catch: Throwable -> L100
        long r14 = i4.b(r8, "pref1", r6.d[0], 0);     // Catch: Throwable -> L100
        long r19 = i4.b(r8, "pref1", r6.d[1], 0);     // Catch: Throwable -> L100
        if (r12 == 0) goto L40;
    L44:
        long r15 = r14 - r12;
        long r110 = r19 - r12;
        if (r12 <= r15) goto L50;
        if (r12 <= r110) goto L52;
        int r13 = 2;
    L54:
        h4 r9 = this.l;     // Catch: Throwable -> L96
        Context r10 = this.h;     // Catch: Throwable -> L96
        r9.getClass();     // Catch: Throwable -> L96
        long r16 = i4.b(r10, "pref1", r9.d[3], 0);     // Catch: Throwable -> L99
        long r111 = i4.b(r10, "pref1", r9.d[4], 0);     // Catch: Throwable -> L99
        long r21 = i4.b(r10, "pref1", r9.d[5], 0);     // Catch: Throwable -> L99
        if (r16 != 0) goto L64;
        if (r111 != 0) goto L64;
        if (r21 == 0) goto L72;
    L64:
        if (r16 <= r111) goto L69;
        if (r16 <= r21) goto L71;
        int r18 = 3;
    L73:
        Context r112 = this.h;     // Catch: Throwable -> L96
        long r11 = this.n;     // Catch: Throwable -> L96
        if (r13 == (-1)) goto L83;
        if (r18 == (-1)) goto L83;
        h4.d(r112, r13, r18, r11, r17);     // Catch: Throwable -> L80
    L80:
        th = move-exception;
        c4.g(th, "ReportUtil", "reportServiceAliveTime");     // Catch: Throwable -> L96
    L83:
        h4 r20 = this.l;     // Catch: Throwable -> L96
        Context r22 = this.h;     // Catch: Throwable -> L96
        r20.getClass();     // Catch: Throwable -> L96
        SharedPreferences.Editor r23 = r22.getSharedPreferences("pref1", 0).edit();     // Catch: Throwable -> L101
    L85:
        String[] r24 = r20.d;     // Catch: Throwable -> L101
        if (r7 >= r24.length) goto L88;
        i4.g(r23, r24[r7], 0);     // Catch: Throwable -> L101
        r7 = r7 + 1;     // Catch: Throwable -> L101
        goto L85
    L88:
        i4.e(r23);     // Catch: Throwable -> L101
    L71:
        r18 = 5;
        goto L73
    L69:
        if (r111 <= r21) goto L71;
        r18 = 4;
    L72:
        r18 = -1;
    L52:
        r13 = 1;
        goto L54
    L50:
        if (r15 <= r110) goto L52;
        r13 = 0;
        goto L54
    L40:
        if (r14 != 0) goto L44;
        if (r19 != 0) goto L44;
    L53:
        r13 = -1;
        goto L54
    L116:
        f4.b(r4, HandlerThread.class, "quitSafely", new Object[0]);     // Catch: Throwable -> L27
    L27:
        this.c.quit();     // Catch: Throwable -> L96
        goto L28
    L108:
        r2.d();     // Catch: Throwable -> L17
        r2.e = 0;     // Catch: Throwable -> L17
        r2.f = false;     // Catch: Throwable -> L17
        r2.c = null;     // Catch: Throwable -> L17
        r2.d = null;     // Catch: Throwable -> L17
    L19:
        this.i = null;     // Catch: Throwable -> L96
        goto L20
    L17:
        th = move-exception;
        c4.g(th, "LastLocationManager", "destroy");     // Catch: Throwable -> L96
    L10:
        th = move-exception;
        c4.g(th, "apm", "des1");     // Catch: Throwable -> L96
    L96:
        th = move-exception;
        c4.g(th, "apm", "tdest");
    }

    public final void n() {
        if (j4.J(this.h) == false) goto L27;
        return;
    L27:
        b3 r0 = this.j;     // Catch: Throwable -> L24
        if (r0 == null) goto L30;
        if (r0 == null) goto L31;
        r0.F = this.g;     // Catch: Throwable -> L24
        r0.getClass();     // Catch: Throwable -> L24
        Context r1 = r0.a;     // Catch: Throwable -> L21
        if (r1 != null) goto L13;
        return;
    L13:
        if (r0.L != null) goto L15;
        r0.L = new d3(r1);     // Catch: Throwable -> L21
    L15:
        l3 r2 = r0.d;     // Catch: Throwable -> L21
        if (r2 == null) goto L33;
        s3 r3 = r0.c;     // Catch: Throwable -> L21
        if (r3 == null) goto L34;
        r0.L.b(r2, r3, r0.F);     // Catch: Throwable -> L21
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L21:
        th = move-exception;
        r.f(th, "as", "stc");     // Catch: Throwable -> L24
        return;
    L31:
        return;
    L30:
        return;
    L24:
        th = move-exception;
        c4.g(th, "ApsServiceCore", "startColl");
    }

    public static AMapLocationClientOption j(Bundle r3) {
        AMapLocationClientOption r1 = null;
        r1 = c4.b(r3.getBundle("optBundle"));     // Catch: Throwable -> L11
        String r4 = r3.getString("d");     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r4) == true) goto L14;
        x4.d = r4;     // Catch: Throwable -> L8
    L14:
    L13:
        return r1;
    L8:
        th = move-exception;
        c4.g(th, "APSManager", "doLocation setUmidToken");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        c4.g(th, "APSManager", "parseBundle");
        goto L13
    }

    public static void h(s2 r2, Messenger r3, Bundle r4) {
        r2.getClass();
        if (r4 == null) goto L28;
    L21:
        th = move-exception;
        c4.g(th, "ApsServiceCore", "doInitAuth");
        return;
    L5:
        if (r4.isEmpty() == false) goto L8;
        return;
    L8:
        if (r2.b == true) goto L30;
        r2.b = true;     // Catch: Throwable -> L21
        d3 r5 = r2.j.L;     // Catch: Throwable -> L18
        if (r5 == null) goto L15;
        r5.d();     // Catch: Throwable -> L18
    L15:
        if (com.loc.h.s == false) goto L31;
        Bundle r6 = new Bundle();     // Catch: Throwable -> L18
        r6.putBoolean("installMockApp", true);     // Catch: Throwable -> L18
        c(r3, 9, r6);     // Catch: Throwable -> L18
    L32:
        return;
    L31:
        return;
    L18:
        th = move-exception;
        c4.g(th, "ApsServiceCore", "initAuth");     // Catch: Throwable -> L21
        return;
    L30:
        return;
    }

    public static void k(s2 r11, Messenger r12, Bundle r13) {
        r11.getClass();
        if (r13 == null) goto L70;
    L62:
        th = move-exception;
        c4.g(th, "ApsServiceCore", "doLocation");
        return;
    L5:
        if (r13.isEmpty() == true) goto L71;
        em r3 = new em();     // Catch: Throwable -> L62
        r3.g = "conitue";     // Catch: Throwable -> L62
        AMapLocationClientOption r14 = j(r13);     // Catch: Throwable -> L62
        r11.g(r14);     // Catch: Throwable -> L62
        if (r11.k.containsKey(r12) == true) goto L10;
    L14:
        AMapLocation r5 = null;
        if (r11.s == true) goto L17;
        es r15 = a(9, "init error : " + r11.t + "#0901");     // Catch: Throwable -> L62
        r11.e = r15;     // Catch: Throwable -> L62
        r3.h = "#0901";     // Catch: Throwable -> L62
        r11.e(r12, r15, r15.V, r3);     // Catch: Throwable -> L62
        h4.k(null, 2091);     // Catch: Throwable -> L62
        return;
    L17:
        long r6 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L62
        if (j4.m(r11.e) == true) goto L20;
    L22:
        r3.a = SystemClock.elapsedRealtime();     // Catch: Throwable -> L62
        es r7 = r11.j.c(r3);     // Catch: Throwable -> L38
        r11.e = r7;     // Catch: Throwable -> L38
        if (r7.getLocationType() != 6) goto L27;
    L35:
        r11.j.j(r11.e, 2);     // Catch: Throwable -> L38
    L36:
        r11.e = r11.j.d(r11.e);     // Catch: Throwable -> L38
    L42:
        if (j4.m(r11.e) == false) goto L45;
        r11.d = SystemClock.elapsedRealtime();     // Catch: Throwable -> L62
    L45:
        if (r11.e != null) goto L47;
        r11.e = a(8, "loc is null#0801");     // Catch: Throwable -> L62
        r3.h = "#0801";     // Catch: Throwable -> L62
    L47:
        es r0 = r11.e;     // Catch: Throwable -> L62
        if (r0 == null) goto L51;
        String r8 = r0.V;     // Catch: Throwable -> L62
        r5 = r0.clone();     // Catch: Throwable -> L62
        String r1 = r8;
    L68:
    L58:
        th = move-exception;
        c4.g(th, "ApsServiceCore", "fixLastLocation");     // Catch: Throwable -> L62
    L60:
        r11.e(r12, r5, r1, r3);     // Catch: Throwable -> L62
        return;
    L53:
        if (r14.isLocationCacheEnable() == false) goto L60;
        t4 r2 = r11.i;     // Catch: Throwable -> L58
        if (r2 == null) goto L60;
        r5 = r2.a(r5, r1, r14.getLastLocationLifeCycle());     // Catch: Throwable -> L58
    L51:
        r1 = null;
        goto L68
    L27:
        if (r11.e.getLocationType() == 5) goto L35;
        if (r11.e.getLocationType() != 2) goto L33;
        r11.j.j(r11.e, 3);     // Catch: Throwable -> L38
        goto L36
    L33:
        if (r11.e.getLocationType() != 4) goto L36;
        r11.j.j(r11.e, 4);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        h4.k(null, 2081);     // Catch: Throwable -> L62
        r3.h = "#0801";     // Catch: Throwable -> L62
        r11.e = a(8, "loc error : " + th.getMessage() + "#0801");     // Catch: Throwable -> L62
        c4.g(th, "ApsServiceCore", "run part2");     // Catch: Throwable -> L62
        goto L42
    L20:
        if ((r6 - r11.d) >= 600) goto L22;
        es r16 = r11.e;     // Catch: Throwable -> L62
        r11.e(r12, r16, r16.V, r3);     // Catch: Throwable -> L62
        r11.j.j(r11.e, 3);     // Catch: Throwable -> L62
        return;
    L10:
        if (r14.isOnceLocation() == true) goto L14;
        if ((SystemClock.elapsedRealtime() - r11.k.get(r12).longValue()) >= 800) goto L14;
        return;
    L71:
        return;
    }

    public final void f(Messenger r4, String r5, int r6) {
        Bundle r0 = new Bundle();
        r0.setClassLoader(AMapLocation.class.getClassLoader());
        r0.putInt("I_MAX_GEO_DIS", com.loc.h.o * 3);
        r0.putInt("I_MIN_GEO_DIS", com.loc.h.o);
        r0.putParcelable("loc", this.f);
        if ("COARSE_LOC".equals(r5) == false) goto L6;
        int r7 = 103;
    L8:
        c(r4, r7, r0);
        return;
    L6:
        if (r6 != 1) goto L11;
        r7 = 6;
        goto L8
    L11:
        if (r6 != 12) goto L14;
        c(r4, 18, r0);
        return;
    }

    public final void d(Messenger r18, Bundle r19, String r20, int r21) {
        if (r19 == null) goto L62;
    L48:
        th = move-exception;
        c4.g(th, "ApsServiceCore", "doLocationGeo");
        return;
    L5:
        if (r19.isEmpty() == true) goto L63;
        double r12 = r19.getDouble("lat");     // Catch: Throwable -> L48
        double r14 = r19.getDouble("lon");     // Catch: Throwable -> L48
        float r5 = r19.getFloat("radius");     // Catch: Throwable -> L48
        long r6 = r19.getLong("time");     // Catch: Throwable -> L48
        if ("FINE_LOC".equals(r20) == false) goto L17;
        if (r21 != 1) goto L12;
        AMapLocation r8 = new AMapLocation("gps");     // Catch: Throwable -> L48
        r8.setLocationType(1);     // Catch: Throwable -> L48
    L15:
        r8.setLatitude(r12);     // Catch: Throwable -> L48
        r8.setLongitude(r14);     // Catch: Throwable -> L48
        r8.setAccuracy(r5);     // Catch: Throwable -> L48
        r8.setTime(r6);     // Catch: Throwable -> L48
        this.j.h(r8);     // Catch: Throwable -> L48
        goto L17
    L12:
        if (r21 != 12) goto L14;
        AMapLocation r10 = new AMapLocation(CloudControlInf.NETWORK);     // Catch: Throwable -> L48
        r10.setLocationType(12);     // Catch: Throwable -> L48
        r8 = r10;
        goto L15
    L14:
        r8 = null;
    L17:
        if (com.loc.h.n == true) goto L19;
        return;
    L19:
        AMapLocationClientOption r7 = j(r19);     // Catch: Throwable -> L48
        if (r7 != null) goto L22;
        return;
    L22:
        if (r7.isNeedAddress() == false) goto L57;
        g(r7);     // Catch: Throwable -> L48
        es r9 = this.f;     // Catch: Throwable -> L48
        if (r9 == null) goto L29;
        float r11 = j4.c(new double[]{r12, r14, r9.getLatitude(), this.f.getLongitude()});     // Catch: Throwable -> L48
        if (r11 >= (com.loc.h.o * 3)) goto L31;
        f(r18, r20, r21);     // Catch: Throwable -> L48
    L31:
        if (r11 != (-1.0f)) goto L33;
    L36:
        b(r19);     // Catch: Throwable -> L48
        b3 r2 = this.j;     // Catch: Throwable -> L48
        r2.getClass();     // Catch: Throwable -> L48
        String r13 = r2.p.a(r2.a, r12, r14);     // Catch: Throwable -> L51
        if (r13.contains("\"status\":\"1\"") == false) goto L41;
        es r3 = r2.f.a(r13);     // Catch: Throwable -> L51
        r3.setLatitude(r12);     // Catch: Throwable -> L51
        r3.setLongitude(r14);     // Catch: Throwable -> L51
    L42:
        this.f = r3;     // Catch: Throwable -> L48
        this.p = SystemClock.elapsedRealtime();     // Catch: Throwable -> L48
        es r4 = this.f;     // Catch: Throwable -> L48
        if (r4 != null) goto L45;
        return;
    L45:
        if (TextUtils.isEmpty(r4.getAdCode()) == true) goto L61;
        f(r18, r20, r21);     // Catch: Throwable -> L48
        return;
    L61:
        return;
    L41:
        r3 = null;
        goto L42
    L33:
        if (r11 > com.loc.h.o) goto L35;
        return;
    L35:
        if ((SystemClock.elapsedRealtime() - this.p) > (com.loc.h.p * 1000)) goto L36;
        return;
    L29:
        r11 = -1.0f;
        goto L31
    L57:
        return;
    L63:
        return;
    }

    public final void e(Messenger r3, AMapLocation r4, String r5, em r6) {
        Bundle r0 = new Bundle();
        r0.setClassLoader(AMapLocation.class.getClassLoader());
        r0.putParcelable("loc", r4);
        r0.putString("nb", r5);
        r0.putParcelable("statics", r6);
        this.k.put(r3, Long.valueOf(SystemClock.elapsedRealtime()));
        c(r3, 1, r0);
    }
}
