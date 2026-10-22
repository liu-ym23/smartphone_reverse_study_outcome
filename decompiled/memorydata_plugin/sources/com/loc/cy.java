package com.loc;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class cy {
    static boolean g = false;
    private String A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f5417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    b f5418b;
    AMapLocation c;
    a d;
    Context e;
    dl f;
    HashMap<Messenger, Long> h;
    fb i;
    long j;
    long k;
    String l;
    AMapLocationClientOption m;
    AMapLocationClientOption n;
    private boolean o;
    private boolean p;
    private long q;
    private long r;
    private es s;
    private long t;
    private int u;
    private fk v;
    private List<Messenger> w;
    private long x;
    private HashMap<String, Boolean> y;
    private boolean z;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ cy f5419a;

        public a(cy r1, Looper r2) {
            this.f5419a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r9) {
            Bundle r2 = r9.getData();     // Catch: Throwable -> L18
            Messenger r3 = r9.replyTo;     // Catch: Throwable -> L16
            if (r2 != null) goto L72;
        L21:
            int r0 = r9.what;     // Catch: Throwable -> L67
            if (r0 == 0) goto L64;
            if (r0 != 1) goto L25;
            cy.a(this.f5419a, r2);     // Catch: Throwable -> L67
            cy.b(this.f5419a, r3, r2);     // Catch: Throwable -> L67
        L65:
            super.handleMessage(r9);     // Catch: Throwable -> L67
            return;
        L67:
            th = move-exception;
            ev.a(th, "actionHandler", "handleMessage");
            return;
        L25:
            switch(r0) {
                case 9: goto L62;
                case 10: goto L61;
                case 11: goto L60;
                case 12: goto L59;
                case 13: goto L50;
                case 14: goto L38;
                case 15: goto L37;
                case 16: goto L33;
                case 17: goto L28;
                case 18: goto L27;
                default: goto L65;
            };
        L27:
            cy.a(this.f5419a, r2);     // Catch: Throwable -> L67
            this.f5419a.a(r3, r2, "FINE_LOC", 12);     // Catch: Throwable -> L67
            goto L65
        L28:
            if (r2 == null) goto L65;
            if (r2.isEmpty() == true) goto L65;
            cy.b(this.f5419a).put(r2.getString("objHash"), Boolean.FALSE);     // Catch: Throwable -> L67
            cy r1 = this.f5419a;     // Catch: Throwable -> L67
        L32:
            r1.c();     // Catch: Throwable -> L67
            goto L65
        L33:
            if (r2 == null) goto L65;
            if (r2.isEmpty() == true) goto L65;
            cy.b(this.f5419a).put(r2.getString("objHash"), Boolean.TRUE);     // Catch: Throwable -> L67
            r1 = this.f5419a;     // Catch: Throwable -> L67
            goto L32
        L37:
            cy.a(this.f5419a, r2);     // Catch: Throwable -> L67
            this.f5419a.a(r3, r2, "COARSE_LOC", 1);     // Catch: Throwable -> L67
            goto L65
        L38:
            Messenger r4 = r9.replyTo;     // Catch: Throwable -> L67
            if (r4 == null) goto L46;
            if (cy.c(this.f5419a) == null) goto L46;
            if (cy.c(this.f5419a).contains(r4) == false) goto L46;
            cy.c(this.f5419a).remove(r4);     // Catch: Throwable -> L67
        L46:
            if (cy.c(this.f5419a) == null) goto L65;
            if (cy.c(this.f5419a).size() != 0) goto L65;
            this.f5419a.f.h();     // Catch: Throwable -> L67
            goto L65
        L50:
            Messenger r5 = r9.replyTo;     // Catch: Throwable -> L67
            if (r5 == null) goto L65;
            if (cy.c(this.f5419a) == null) goto L65;
            if (cy.c(this.f5419a).contains(r5) == true) goto L65;
            cy.c(this.f5419a).add(r5);     // Catch: Throwable -> L67
            if (cy.c(this.f5419a).size() != 1) goto L65;
            cy.d(this.f5419a);     // Catch: Throwable -> L67
            goto L65
        L59:
            cy.a(this.f5419a, r3);     // Catch: Throwable -> L67
            goto L65
        L60:
            this.f5419a.d();     // Catch: Throwable -> L67
            goto L65
        L61:
            cy.a(this.f5419a, r2);     // Catch: Throwable -> L67
            this.f5419a.a(r3, r2, "FINE_LOC", 1);     // Catch: Throwable -> L67
            goto L65
        L62:
            cy.a(this.f5419a, r2);     // Catch: Throwable -> L67
            cy.a(this.f5419a);     // Catch: Throwable -> L67
            goto L65
        L64:
            cy.a(this.f5419a, r2);     // Catch: Throwable -> L67
            cy.a(this.f5419a, r3, r2);     // Catch: Throwable -> L67
            goto L65
        L72:
        L14:
            Throwable th = th;
        L70:
            ev.a(th, "ApsServiceCore", "ActionHandler handlerMessage");     // Catch: Throwable -> L67
            goto L21
        L7:
            if (r2.isEmpty() == true) goto L21;
            if (this.f5419a.a(r2.getString("c")) == true) goto L21;
            if (r9.what != 1) goto L78;
            fb.a(null, 2102);     // Catch: Throwable -> L14
            es r6 = cy.b("invalid handlder scode!!!#1002");     // Catch: Throwable -> L14
            em r7 = new em();     // Catch: Throwable -> L14
            r7.f("#1002");     // Catch: Throwable -> L14
            r7.e("conitue");     // Catch: Throwable -> L14
            cy.a(this.f5419a, r3, r6, r6.k(), r7);     // Catch: Throwable -> L14
            return;
        L78:
            return;
        L16:
            th = move-exception;
            r3 = null;
            th = th;
        L18:
            th = move-exception;
            r3 = null;
            th = th;
            r2 = null;
            goto L70
        }
    }

    class b extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ cy f5420a;

        public b(cy r1, String r2) {
            this.f5420a = r1;
            super(r2);
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            cy.a(this.f5420a, new fk(this.f5420a.e));     // Catch: Throwable -> L5
        L18:
            eu.b(this.f5420a.e);     // Catch: Throwable -> L9
            eu.a(this.f5420a.e);     // Catch: Throwable -> L9
        L11:
            cy r1 = this.f5420a;     // Catch: Throwable -> L13
            r1.f = new dl(false);     // Catch: Throwable -> L13
            super.onLooperPrepared();     // Catch: Throwable -> L13
            return;
        L9:
            th = move-exception;
            ev.a(th, "APSManager$ActionThread", "init 3");     // Catch: Throwable -> L13
        L5:
            th = move-exception;
            ev.a(th, "APSManager$ActionThread", "init 2");     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            ev.a(th, "APSManager$ActionThread", "onLooperPrepared");
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            super.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            ev.a(th, "APSManager$ActionThread", "run");
        }
    }

    static {
    }

    public cy(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        this.o = false;
        this.p = false;
        this.f5417a = null;
        this.f5418b = null;
        this.q = 0;
        this.r = 0;
        this.s = null;
        this.c = null;
        this.t = 0;
        this.u = 0;
        this.d = null;
        this.e = ZeusTransformUtils.wrapperContext(null, "com.obric.memorydata.plugin");
        this.v = null;
        this.f = null;
        this.h = new HashMap();
        this.i = null;
        this.j = 0;
        this.k = 0;
        this.x = 0;
        this.y = new HashMap();
        this.l = null;
        this.z = true;
        this.A = "";
        this.m = null;
        this.n = new AMapLocationClientOption();
        this.e = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
    }

    private static es a(int r2, String r3) {
        es r0 = new es("");     // Catch: Throwable -> L4
        r0.setErrorCode(r2);     // Catch: Throwable -> L4
        r0.setLocationDetail(r3);     // Catch: Throwable -> L4
        return r0;
    L4:
        th = move-exception;
        ev.a(th, "ApsServiceCore", "newInstanceAMapLoc");
        return null;
    }

    static /* synthetic */ fk a(cy r0, fk r1) {
        r0.v = r1;
        return r1;
    }

    private void a(Bundle r2) {
    L17:
        th = move-exception;
        this.z = false;
        th.printStackTrace();
        this.A = th.getMessage();
        ev.a(th, "ApsServiceCore", CommonConsts.APM_INNER_EVENT_COST_INIT);
        return;
    L3:
        if (this.o == false) goto L8;
        dl r3 = this.f;     // Catch: Throwable -> L17
        if (r3 == null) goto L21;
        r3.a();     // Catch: Throwable -> L17
        return;
    L21:
        return;
    L8:
        ev.a(this.e);     // Catch: Throwable -> L17
        if (r2 == null) goto L11;
        this.n = ev.a(r2.getBundle("optBundle"));     // Catch: Throwable -> L17
    L11:
        this.f.a(this.e);     // Catch: Throwable -> L17
        this.f.b();     // Catch: Throwable -> L17
        a(this.n);     // Catch: Throwable -> L17
        this.f.c();     // Catch: Throwable -> L17
        this.o = true;     // Catch: Throwable -> L17
        this.z = true;     // Catch: Throwable -> L17
        this.A = "";     // Catch: Throwable -> L17
        List<Messenger> r4 = this.w;     // Catch: Throwable -> L17
        if (r4 != null) goto L14;
        return;
    L14:
        if (r4.size() <= 0) goto L23;
        f();     // Catch: Throwable -> L17
        return;
    }

    private void a(Messenger r1) {
        this.h.remove(r1);
    }

    private static void a(Messenger r1, int r2, Bundle r3) {
        if (r1 == null) goto L10;
        Message r0 = Message.obtain();     // Catch: Throwable -> L5
        r0.setData(r3);     // Catch: Throwable -> L5
        r0.what = r2;     // Catch: Throwable -> L5
        r1.send(r0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ev.a(th, "ApsServiceCore", "sendMessage");
        return;
    }

    private void a(Messenger r1, Bundle r2) {
        if (r2 == null) goto L16;
    L11:
        th = move-exception;
        ev.a(th, "ApsServiceCore", "doInitAuth");
        return;
    L4:
        if (r2.isEmpty() == false) goto L7;
        return;
    L7:
        if (this.p == false) goto L9;
        return;
    L9:
        this.p = true;     // Catch: Throwable -> L11
        b(r1);     // Catch: Throwable -> L11
        return;
    }

    private void a(Messenger r3, AMapLocation r4, String r5, em r6) {
        Bundle r0 = new Bundle();
        r0.setClassLoader(AMapLocation.class.getClassLoader());
        r0.putParcelable("loc", r4);
        r0.putString("nb", r5);
        r0.putParcelable("statics", r6);
        this.h.put(r3, Long.valueOf(fd.b()));
        a(r3, 1, r0);
    }

    private void a(Messenger r4, String r5, int r6) {
        Bundle r0 = new Bundle();
        r0.setClassLoader(AMapLocation.class.getClassLoader());
        r0.putInt("I_MAX_GEO_DIS", eu.i() * 3);
        r0.putInt("I_MIN_GEO_DIS", eu.i());
        r0.putParcelable("loc", this.c);
        if ("COARSE_LOC".equals(r5) == false) goto L8;
        int r3 = 103;
    L5:
        a(r4, r3, r0);
        return;
    L8:
        if (r6 != 1) goto L11;
        r3 = 6;
        goto L5
    L11:
        if (r6 != 12) goto L14;
        a(r4, 18, r0);
        return;
    }

    private void a(AMapLocationClientOption r3) {
        dl r0 = this.f;     // Catch: Throwable -> L24
        if (r0 == null) goto L5;
        r0.a(r3);     // Catch: Throwable -> L24
    L5:
        if (r3 == null) goto L29;
        g = r3.isKillProcess();     // Catch: Throwable -> L24
        if (this.m != null) goto L9;
    L22:
        this.m = r3;     // Catch: Throwable -> L24
        return;
    L9:
        if (r3.isOffset() == this.m.isOffset()) goto L11;
    L16:
        this.r = 0;     // Catch: Throwable -> L24
    L18:
        if (r3.isOffset() == this.m.isOffset()) goto L20;
    L21:
        this.c = null;     // Catch: Throwable -> L24
        goto L22
    L20:
        if (this.m.getGeoLanguage() == r3.getGeoLanguage()) goto L22;
    L11:
        if (r3.isNeedAddress() != this.m.isNeedAddress()) goto L16;
        if (r3.isLocationCacheEnable() != this.m.isLocationCacheEnable()) goto L16;
        if (this.m.getGeoLanguage() == r3.getGeoLanguage()) goto L18;
    L29:
        return;
    L24:
        th = move-exception;
        ev.a(th, "ApsServiceCore", "setExtra");
    }

    static /* synthetic */ void a(cy r0) {
        r0.g();
    }

    static /* synthetic */ void a(cy r0, Bundle r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(cy r0, Messenger r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(cy r0, Messenger r1, Bundle r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(cy r0, Messenger r1, AMapLocation r2, String r3, em r4) {
        r0.a(r1, r2, r3, r4);
    }

    private static AMapLocationClientOption b(Bundle r3) {
        AMapLocationClientOption r1 = null;
        r1 = ev.a(r3.getBundle("optBundle"));     // Catch: Throwable -> L11
        String r4 = r3.getString("d");     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r4) == true) goto L14;
        fp.a(r4);     // Catch: Throwable -> L8
    L14:
    L13:
        return r1;
    L8:
        th = move-exception;
        ev.a(th, "APSManager", "doLocation setUmidToken");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        ev.a(th, "APSManager", "parseBundle");
        goto L13
    }

    static /* synthetic */ es b(String r1) {
        return a(10, r1);
    }

    static /* synthetic */ HashMap b(cy r0) {
        return r0.y;
    }

    private void b(Messenger r3) {
        this.f.f();     // Catch: Throwable -> L6
        if (eu.l() == false) goto L11;
        Bundle r2 = new Bundle();     // Catch: Throwable -> L6
        r2.putBoolean("installMockApp", true);     // Catch: Throwable -> L6
        a(r3, 9, r2);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        ev.a(th, "ApsServiceCore", "initAuth");
    }

    private void b(Messenger r12, Bundle r13) {
        if (r13 == null) goto L72;
    L64:
        th = move-exception;
        ev.a(th, "ApsServiceCore", "doLocation");
        return;
    L5:
        if (r13.isEmpty() == true) goto L73;
        em r3 = new em();     // Catch: Throwable -> L64
        r3.e("conitue");     // Catch: Throwable -> L64
        AMapLocationClientOption r14 = b(r13);     // Catch: Throwable -> L64
        a(r14);     // Catch: Throwable -> L64
        if (this.h.containsKey(r12) == true) goto L10;
    L14:
        AMapLocation r5 = null;
        if (this.z == true) goto L18;
        this.s = a(9, "init error : " + this.A + "#0901");     // Catch: Throwable -> L64
        r3.f("#0901");     // Catch: Throwable -> L64
        es r15 = this.s;     // Catch: Throwable -> L64
        a(r12, r15, r15.k(), r3);     // Catch: Throwable -> L64
        fb.a(null, 2091);     // Catch: Throwable -> L64
        return;
    L18:
        long r6 = fd.b();     // Catch: Throwable -> L64
        if (fd.a(this.s) == true) goto L21;
    L24:
        r3.c(fd.b());     // Catch: Throwable -> L64
        es r7 = this.f.a(r3);     // Catch: Throwable -> L40
        this.s = r7;     // Catch: Throwable -> L40
        if (r7.getLocationType() != 6) goto L29;
    L37:
        this.f.a(this.s, 2);     // Catch: Throwable -> L40
    L38:
        String[] r8 = new String[0];     // Catch: Throwable -> L40
        this.s = this.f.a(this.s);     // Catch: Throwable -> L40
    L44:
        if (fd.a(this.s) == false) goto L47;
        this.r = fd.b();     // Catch: Throwable -> L64
    L47:
        if (this.s != null) goto L49;
        this.s = a(8, "loc is null#0801");     // Catch: Throwable -> L64
        r3.f("#0801");     // Catch: Throwable -> L64
    L49:
        es r0 = this.s;     // Catch: Throwable -> L64
        if (r0 == null) goto L53;
        String r9 = r0.k();     // Catch: Throwable -> L64
        r5 = this.s.clone();     // Catch: Throwable -> L64
        String r1 = r9;
    L67:
    L60:
        th = move-exception;
        ev.a(th, "ApsServiceCore", "fixLastLocation");     // Catch: Throwable -> L64
    L62:
        a(r12, r5, r1, r3);     // Catch: Throwable -> L64
        return;
    L55:
        if (r14.isLocationCacheEnable() == false) goto L62;
        fk r2 = this.v;     // Catch: Throwable -> L60
        if (r2 == null) goto L62;
        r5 = r2.a(r5, r1, r14.getLastLocationLifeCycle());     // Catch: Throwable -> L60
        goto L62
    L53:
        r1 = null;
        goto L67
    L29:
        if (this.s.getLocationType() == 5) goto L37;
        if (this.s.getLocationType() != 2) goto L35;
        this.f.a(this.s, 3);     // Catch: Throwable -> L40
        goto L38
    L35:
        if (this.s.getLocationType() != 4) goto L38;
        this.f.a(this.s, 4);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        fb.a(null, 2081);     // Catch: Throwable -> L64
        r3.f("#0801");     // Catch: Throwable -> L64
        this.s = a(8, "loc error : " + th.getMessage() + "#0801");     // Catch: Throwable -> L64
        ev.a(th, "ApsServiceCore", "run part2");     // Catch: Throwable -> L64
        goto L44
    L21:
        if ((r6 - this.r) >= 600) goto L24;
        es r16 = this.s;     // Catch: Throwable -> L64
        a(r12, r16, r16.k(), r3);     // Catch: Throwable -> L64
        this.f.a(this.s, 3);     // Catch: Throwable -> L64
        return;
    L10:
        if (r14.isOnceLocation() == true) goto L14;
        if ((fd.b() - ((Long) ZeusTransformUtils.preCheckCast(this.h.get(r12), Long.class, "com.obric.memorydata.plugin")).longValue()) >= 800) goto L14;
        return;
    L73:
        return;
    }

    static /* synthetic */ void b(cy r0, Messenger r1, Bundle r2) {
        r0.b(r1, r2);
    }

    static /* synthetic */ List c(cy r0) {
        return r0.w;
    }

    static /* synthetic */ void d(cy r0) {
        r0.f();
    }

    public static void e() {
        g = false;
    }

    private void f() {
        if (fd.m(this.e) == false) goto L14;
        Object[] r2 = new Object[1];
        ex.a();
        return;
    L14:
        dl r0 = this.f;     // Catch: Throwable -> L11
        if (r0 == null) goto L16;
        if (r0 == null) goto L17;
        r0.a(this.d);     // Catch: Throwable -> L11
        this.f.g();     // Catch: Throwable -> L11
        return;
    L17:
        return;
    L16:
        return;
    L11:
        th = move-exception;
        ev.a(th, "ApsServiceCore", "startColl");
    }

    private void g() {
        eu.c(this.e);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        ev.a(th, "ApsServiceCore", "doCallOtherSer");
    }

    public final void a() {
        this.i = new fb();     // Catch: Throwable -> L4
        b r0 = new b(this, "amapLocCoreThread");     // Catch: Throwable -> L4
        this.f5418b = r0;     // Catch: Throwable -> L4
        r0.setPriority(5);     // Catch: Throwable -> L4
        this.f5418b.start();     // Catch: Throwable -> L4
        this.d = new a(this, this.f5418b.getLooper());     // Catch: Throwable -> L4
        this.w = new ArrayList();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        ev.a(th, "ApsServiceCore", "onCreate");
    }

    public final void a(Intent r3) {
        if ("true".equals(r3.getStringExtra("as")) == false) goto L8;
        a r2 = this.d;
        if (r2 == null) goto L9;
        r2.sendEmptyMessageDelayed(9, 100);
        return;
    L9:
        return;
    }

    final void a(Messenger r12, Bundle r13, String r14, int r15) {
        if (r13 == null) goto L52;
    L41:
        th = move-exception;
        ev.a(th, "ApsServiceCore", "doLocationGeo");
        return;
    L4:
        if (r13.isEmpty() == true) goto L53;
        double r0 = r13.getDouble("lat");     // Catch: Throwable -> L41
        double r2 = r13.getDouble("lon");     // Catch: Throwable -> L41
        float r4 = r13.getFloat("radius");     // Catch: Throwable -> L41
        long r5 = r13.getLong(OaidModel.KEY_TIME);     // Catch: Throwable -> L41
        if ("FINE_LOC".equals(r14) == false) goto L16;
        AMapLocation r7 = null;
        if (r15 != 1) goto L12;
        r7 = new AMapLocation("gps");     // Catch: Throwable -> L41
        r7.setLocationType(1);     // Catch: Throwable -> L41
    L14:
        r7.setLatitude(r0);     // Catch: Throwable -> L41
        r7.setLongitude(r2);     // Catch: Throwable -> L41
        r7.setAccuracy(r4);     // Catch: Throwable -> L41
        r7.setTime(r5);     // Catch: Throwable -> L41
        this.f.a(r7);     // Catch: Throwable -> L41
        goto L16
    L12:
        if (r15 != 12) goto L14;
        r7 = new AMapLocation("network");     // Catch: Throwable -> L41
        r7.setLocationType(12);     // Catch: Throwable -> L41
    L16:
        if (eu.h() == true) goto L18;
        return;
    L18:
        AMapLocationClientOption r6 = b(r13);     // Catch: Throwable -> L41
        if (r6 != null) goto L21;
        return;
    L21:
        if (r6.isNeedAddress() == false) goto L47;
        a(r6);     // Catch: Throwable -> L41
        AMapLocation r8 = this.c;     // Catch: Throwable -> L41
        if (r8 == null) goto L28;
        float r9 = fd.a(new double[]{r0, r2, r8.getLatitude(), this.c.getLongitude()});     // Catch: Throwable -> L41
        if (r9 >= (eu.i() * 3)) goto L30;
        a(r12, r14, r15);     // Catch: Throwable -> L41
    L30:
        if (r9 != (-1.0f)) goto L32;
    L35:
        a(r13);     // Catch: Throwable -> L41
        this.c = this.f.a(r0, r2);     // Catch: Throwable -> L41
        this.x = fd.b();     // Catch: Throwable -> L41
        AMapLocation r16 = this.c;     // Catch: Throwable -> L41
        if (r16 != null) goto L38;
        return;
    L38:
        if (TextUtils.isEmpty(r16.getAdCode()) == true) goto L51;
        a(r12, r14, r15);     // Catch: Throwable -> L41
        return;
    L51:
        return;
    L32:
        if (r9 > eu.i()) goto L34;
        return;
    L34:
        if ((fd.b() - this.x) > (eu.j() * 1000)) goto L35;
        return;
    L28:
        r9 = -1.0f;
        goto L30
    L47:
        return;
    L53:
        return;
    }

    public final boolean a(String r2) {
        if (TextUtils.isEmpty(this.l) == false) goto L6;
        this.l = ev.b(this.e);
    L6:
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return false;
    L8:
        if (r2.equals(this.l) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public final Handler b() {
        return this.d;
    }

    public final void b(Intent r3) {
        String r0 = r3.getStringExtra("a");
        if (TextUtils.isEmpty(r0) == true) goto L5;
        fn.a(this.e, r0);
    L5:
        String r1 = r3.getStringExtra("b");
        this.f5417a = r1;
        fm.a(r1);
        String r2 = r3.getStringExtra("d");
        if (TextUtils.isEmpty(r2) == true) goto L9;
        fp.a(r2);
        return;
    }

    public final void c() {
        if (this.f == null) goto L20;
        HashMap<String, Boolean> r0 = this.y;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isEmpty() == true) goto L22;
        Iterator<Boolean> r1 = this.y.values().iterator();
    L10:
        if (r1.hasNext() == false) goto L15;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r1.next(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L10;
        this.f.a(true);
        return;
    L15:
        this.f.a(false);
        return;
    L22:
        return;
    }

    public final void d() {
        HashMap<Messenger, Long> r1 = this.h;     // Catch: Throwable -> L42
        if (r1 == null) goto L45;
        r1.clear();     // Catch: Throwable -> L42
        this.h = null;     // Catch: Throwable -> L42
    L45:
        List<Messenger> r2 = this.w;     // Catch: Throwable -> L10
        if (r2 == null) goto L12;
        r2.clear();     // Catch: Throwable -> L10
    L12:
        fk r3 = this.v;     // Catch: Throwable -> L42
        if (r3 == null) goto L15;
        r3.c();     // Catch: Throwable -> L42
        this.v = null;     // Catch: Throwable -> L42
    L15:
        this.o = false;     // Catch: Throwable -> L42
        this.p = false;     // Catch: Throwable -> L42
        this.f.e();     // Catch: Throwable -> L42
        a r4 = this.d;     // Catch: Throwable -> L42
        if (r4 == null) goto L18;
        r4.removeCallbacksAndMessages(null);     // Catch: Throwable -> L42
    L18:
        this.d = null;     // Catch: Throwable -> L42
        if (this.f5418b != null) goto L22;
    L28:
        this.f5418b = null;     // Catch: Throwable -> L42
        if (this.i != null) goto L31;
    L35:
        HashMap<String, Boolean> r5 = this.y;     // Catch: Throwable -> L42
        if (r5 == null) goto L38;
        r5.clear();     // Catch: Throwable -> L42
        this.y = null;     // Catch: Throwable -> L42
    L38:
        fb.a(this.e);     // Catch: Throwable -> L42
        q.b();     // Catch: Throwable -> L42
        if (g == false) goto L51;
        Process.killProcess(Process.myPid());     // Catch: Throwable -> L42
        return;
    L51:
        return;
    L31:
        if (this.j == 0) goto L35;
        if (this.k == 0) goto L35;
        long r12 = fd.b() - this.j;     // Catch: Throwable -> L42
        int r8 = this.i.c(this.e);     // Catch: Throwable -> L42
        int r9 = this.i.d(this.e);     // Catch: Throwable -> L42
        fb.a(this.e, r8, r9, this.k, r12);     // Catch: Throwable -> L42
        this.i.e(this.e);     // Catch: Throwable -> L42
        goto L35
    L22:
        if (Build.VERSION.SDK_INT >= 18) goto L47;
        b r6 = this.f5418b;     // Catch: Throwable -> L42
    L26:
        r6.quit();     // Catch: Throwable -> L42
        goto L28
    L47:
        ez.a(this.f5418b, HandlerThread.class, "quitSafely", new Object[0]);     // Catch: Throwable -> L25
    L25:
        r6 = this.f5418b;     // Catch: Throwable -> L42
    L10:
        th = move-exception;
        ev.a(th, "apm", "des1");     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        ev.a(th, "apm", "tdest");
    }
}
