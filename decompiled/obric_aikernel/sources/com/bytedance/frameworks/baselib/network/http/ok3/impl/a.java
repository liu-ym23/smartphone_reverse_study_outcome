package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.content.Context;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowUseNetworkException;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.q;
import okhttp3.u;
import okhttp3.w;
import okhttp3.x;
import okhttp3.y;
import okhttp3.z;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.bytedance.frameworks.baselib.network.http.impl.a implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    w f1673l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    x f1674m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    z f1675n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    okhttp3.e f1676o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    volatile i f1677p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final WeakHandler f1678q;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.ok3.impl.a$a, reason: collision with other inner class name */
    class RunnableC0057a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f1679c;

        RunnableC0057a(a r10) {
            this.f1679c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            a r10 = this.f1679c;
            a.U(r10, r10.f1677p.q());
        }
    }

    class b extends y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f1680b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ r4.f f1681c;

        b(u r10, r4.f r11) {
            this.f1680b = r10;
            this.f1681c = r11;
        }

        @Override // okhttp3.y
        public long a() {
            return this.f1681c.length();
        }

        @Override // okhttp3.y
        public u b() {
            return this.f1680b;
        }

        @Override // okhttp3.y
        public void g(okio.e r10) {
            this.f1681c.writeTo(r10.Y());
        }
    }

    public a(n4.c r10) {
        super(r10);
        this.f1673l = null;
        this.f1677p = null;
        o2.b r11 = this.f1631g;     // Catch: Exception -> L5
        r11.f11417x = 1;     // Catch: Exception -> L5
        r11.B.put("hc", "SsOkHttp3Client");     // Catch: Exception -> L5
        this.f1631g.B.put("hcv", n.q());     // Catch: Exception -> L5
    L7:
        o2.b r12 = this.f1631g;
        r12.f11418y = n.l();
        o2.b r13 = this.f1631g;
        r13.f11419z = n.k();
        o2.b r14 = this.f1631g;
        RetrofitMetrics r15 = r14.O;
        if (r15 == null) goto L10;
        r15.f2435f = r14.f11418y;
        r15.f2437g = r14.f11419z;
    L10:
        this.f1678q = new WeakHandler(com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.b.q().k().getLooper(), this);
        String r16 = this.f1630c.G();
        this.f1677p = new i();
        this.f1677p.E(r16, this.f1630c.y());
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    static /* synthetic */ void U(a r10, boolean r11) {
        r10.V(r11);
    }

    private void V(boolean r10) {
        if (r10 == false) goto L4;
        com.bytedance.frameworks.baselib.network.http.impl.a.A(this.f1631g, this);
    L5:
        T r11 = this.f1631g.f11398e;
        if (r11 != 0) goto L8;
    L9:
        o2.f.C(this.f1630c.G(), this.f1631g);
        return;
    L8:
        if (r11.f11442w == true) goto L9;
        return;
    L4:
        com.bytedance.frameworks.baselib.network.http.impl.a.A(this.f1631g, null);
        goto L5
    }

    private void W(n4.c r10, o2.b r11, Map<String, String> r12) {
        w.a r13 = this.f1673l.z();
        T r14 = r11.f11398e;
        if (r14 == 0) goto L5;
        r13.l(r14.f11440u);
    L5:
        long r15 = o2.f.j();
        TimeUnit r16 = TimeUnit.MILLISECONDS;
        r13.d(r15, r16);
        r13.U(o2.f.p(), r16);
        r13.Z(o2.f.p(), r16);
        r13.T(n.r());
        r13.j(com.bytedance.frameworks.baselib.network.http.util.c.g());
        o2.c r17 = r11.f11398e;
        if (r17 == null) goto L23;
        long r18 = r17.f11422c;
        if (r18 <= 0) goto L10;
        r13.d(r18, r16);
    L10:
        long r19 = r17.f11424e;
        if (r19 <= 0) goto L13;
        r13.Z(r19, r16);
    L13:
        long r20 = r17.f11423d;
        if (r20 <= 0) goto L17;
        r13.U(r20, r16);
    L17:
        if (r17.f11445z == false) goto L19;
        r13.T(Proxy.NO_PROXY);
    L19:
        o2.c.a r21 = r17.A;
        if (r21 == null) goto L22;
        r21.a(r13);
    L22:
        this.f1677p.G(r17);
    L23:
        String r22 = r10.G();
        String r23 = null;
        if (this.f1673l.r() == null) goto L26;
        q r24 = this.f1673l.r().a(this.f1673l.A(new x.a().k(r22).b()));
    L27:
        r13.k(new g(r24, this.f1677p));
        this.f1673l = r13.c();
        ArrayList r25 = new ArrayList();
        if (r10.K() == false) goto L93;
    L33:
        List<n4.b> r26 = new ArrayList();
        long r27 = SystemClock.uptimeMillis();
        x2.b r28 = new x2.b();
        String r29 = x2.c.b().a(r22, r10, r28, r26);
        r28.f13489e = SystemClock.uptimeMillis() - r27;
        this.f1677p.s(r28);
        if (r26.isEmpty() == false) goto L36;
        r26 = r10.v();
    L36:
        x.a r30 = new x.a().k(com.bytedance.frameworks.baselib.network.http.util.c.n(n.i(), r29, r26));
        Iterator<n4.b> r31 = r25.iterator();
    L38:
        if (r31.hasNext() == false) goto L41;
        n4.b r32 = r31.next();
        r30.a(r32.a(), r32.b());
        goto L38
    L41:
        if (Logger.debug() == false) goto L44;
        r30.a("fallback-reason", n.m(r10));
    L44:
        if (kc.f.a(r10.y()) == true) goto L46;
        x.a r33 = r30.f(r10.y(), null);
    L48:
        if (r10.s() != null) goto L50;
    L54:
        r33.a(NetConst.KEY_ACCEPT_ENCODING, NetConst.GZIP);
        Iterator<n4.b> r110 = r26.iterator();
    L56:
        if (r110.hasNext() == false) goto L67;
        n4.b r34 = r110.next();
        if (com.bytedance.common.utility.g.b(r34.a()) == true) goto L56;
        if (com.bytedance.common.utility.g.b(r34.b()) == true) goto L56;
        if ("User-Agent".equals(r34.a()) == false) goto L65;
        r23 = r34.b();
    L65:
        r33.d(r34.a(), r34.b());
        goto L56
    L67:
        if (com.bytedance.common.utility.g.b(r23) == false) goto L72;
        r23 = o2.f.s();
        if (com.bytedance.common.utility.g.b(r23) == true) goto L72;
        r23 = r23 + " " + n.q();
        r33.d("User-Agent", r23);
    L72:
        if (com.bytedance.common.utility.g.b(r23) == false) goto L95;
        r23 = n.j();
        if (TextUtils.isEmpty(r23) == true) goto L95;
        r33.d("User-Agent", r23);
    L95:
        r11.B.put("ua", r23);     // Catch: Exception -> L78
    L80:
        if (r12 != null) goto L82;
    L91:
        x r111 = r33.b();
        this.f1674m = r111;
        this.f1676o = this.f1673l.A(r111);
        return;
    L82:
        if (r12.isEmpty() == true) goto L91;
        Iterator<Map.Entry<String, String>> r112 = r12.entrySet().iterator();
    L85:
        if (r112.hasNext() == false) goto L91;
        Map.Entry<String, String> r113 = r112.next();
        String r114 = r113.getKey();
        String r115 = r113.getValue();
        if (TextUtils.isEmpty(r114) == true) goto L85;
        if (TextUtils.isEmpty(r115) == true) goto L85;
        r33.a(r114, r115);
    L78:
        e = move-exception;
        e.printStackTrace();
        goto L80
    L50:
        if (r10.L() == true) goto L54;
        String r116 = r10.s().d();
        if (r116 == null) goto L54;
        r33.a("X-SS-STUB", r116);
        goto L54
    L46:
        r33 = r30.f(r10.y(), Y(r10.s(), r10.D()));
        goto L48
    L93:
        r22 = Z(r22, r10.y(), r25);     // Catch: Exception -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L33
    L26:
        r24 = null;
        goto L27
    }

    private void X() {
        this.f1673l = n.h();
    }

    private static y Y(r4.f r10, y r11) {
        if (r11 == null) goto L4;
        return r11;
    L4:
        if (r10 != null) goto L8;
        return y.c(null, "body=null");
    L8:
        return new b(u.g(r10.a()), r10);
    }

    private String Z(String r12, String r13, List<n4.b> r14) {
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.h.l().m() == true) goto L22;
        long r10 = System.currentTimeMillis();
        y2.b r15 = com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.h.l().d(new y2.c(r12, r13, r14));
        long r11 = System.currentTimeMillis();
        if (r15 == null) goto L30;
        this.f1677p.r(this.f1630c.y(), r15.f13666a, r11 - r10, false, r15.f13668c);
        if (r12.equals(r15.f13666a) == false) goto L9;
        return r12;
    L9:
        if (r15.f13666a.isEmpty() == false) goto L19;
        if (r15.f13667b.isEmpty() == true) goto L19;
        this.f1677p.D(r15.f13669d);
        StringBuilder r16 = new StringBuilder();
        r16.append("ERR_TTNET_TRAFFIC_CONTROL_DROP");
        if (r15.f13669d != (-555)) goto L15;
        String r17 = "";
    L16:
        r16.append(r17);
        r16.append(", ");
        r16.append(r15.f13669d);
        throw new Exception(r16.toString());
    L15:
        r17 = "_" + (-r15.f13669d);
    L19:
        if (com.bytedance.frameworks.baselib.network.http.util.k.f(r15.f13666a) == true) goto L33;
        return r12;
    L33:
        return r15.f13666a;
    L30:
        return r12;
    L22:
        if (Logger.debug() == false) goto L24;
        Logger.d("Ok3SsCall", "fallback to host replace map");
    L24:
        long r18 = System.currentTimeMillis();
        String r19 = com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.h.l().k(r12);
        long r20 = System.currentTimeMillis();
        if (r12.equals(r19) == false) goto L27;
        return r12;
    L27:
        if (com.bytedance.frameworks.baselib.network.http.util.k.f(r19) == false) goto L35;
        this.f1677p.r(this.f1630c.y(), r19, r20 - r18, true, null);
        return r19;
    L35:
        return r12;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    protected int B(IOException r10) {
        return sc.c.c(r10);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    protected void E() {
        if (n.n() == true) goto L6;
        return;
    L6:
        throw new NotAllowUseNetworkException("request is not allowed using network");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    protected void F(o2.b r10, com.bytedance.frameworks.baselib.network.http.impl.g r11) {
        super.F(r10, r11);
        if (n.o() == null) goto L6;
        n.o().a(this.f1674m, this.f1675n);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    protected void G(Exception r10) {
        if (n.o() == null) goto L6;
        n.o().c(this.f1674m, r10);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    protected void H(r4.e r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.f1630c.N() == false) goto L6;
        return;
    L6:
        if ((r10 instanceof com.bytedance.retrofit2.mime.c) == false) goto L14;
        c3.b.m().t(this.f1675n, this.f1630c.G(), ((com.bytedance.retrofit2.mime.c) r10).j());     // Catch: Throwable -> L9
        return;
    L15:
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    protected void I(String r10, n4.c r11, o2.b r12, Map<String, String> r13) {
        X();     // Catch: Exception -> L4
        W(r11, r12, r13);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.frameworks.baselib.network.http.impl.a.T(r11.G(), r12, this, this, e);
        if ((e instanceof TTNetExceptionStorage) == true) goto L8;
        TTNetExceptionStorage r14 = new TTNetExceptionStorage(e.getMessage(), e.getCause());
        r14.setInfo(true, false, true, r11.G(), r12.P, r12);
        throw r14;
    L8:
        throw ((IOException) e);
    }

    @Override // s4.c
    public void a(Throwable r10, boolean r11) {
        okhttp3.e r12 = this.f1676o;
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.isCanceled() == true) goto L15;
        this.f1676o.cancel();
        this.f1633i = true;
        o2.b r13 = this.f1631g;
        r13.f11405l = System.currentTimeMillis();
        o2.b r14 = this.f1631g;
        T r15 = r14.f11398e;
        if (r15 != 0) goto L10;
    L11:
        o2.f.F(this.f1630c, r14, r10, Boolean.valueOf(r11));
        return;
    L10:
        if (r15.f11442w == true) goto L11;
        return;
    }

    @Override // n4.e
    public boolean c(long r10) {
        return false;
    }

    @Override // n4.e
    public void cancel() {
        okhttp3.e r10 = this.f1676o;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isCanceled() == true) goto L17;
        this.f1676o.cancel();
        this.f1633i = true;
        if (this.f1630c.N() == false) goto L15;
        o2.b r11 = this.f1631g;
        r11.f11405l = System.currentTimeMillis();
        if (this.f1677p.q() == true) goto L12;
        this.f1678q.postDelayed(new RunnableC0057a(this), 500);
        return;
    L12:
        V(true);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.g
    public InputStream d() {
        z r10 = this.f1675n;
        if (r10 != null) goto L5;
    L7:
        return null;
    L5:
        if (r10.a() == null) goto L7;
        return this.f1675n.a().a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.g
    public int e() {
        z r10 = this.f1675n;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.k();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.g
    public String f(String r10) {
        z r11 = this.f1675n;
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.p(r10);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.g
    public InputStream g() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.g
    public String h() {
        z r10 = this.f1675n;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.a() == null) goto L12;
        u r11 = this.f1675n.a().i();
        if (r11 != null) goto L10;
        return null;
    L10:
        return r11.toString();
    L12:
        return null;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.g
    public boolean i() {
        return NetConst.GZIP.equalsIgnoreCase(this.f1675n.p(NetConst.KEY_CONTENT_ENCODING));
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.i
    public void j(o2.b r10) {
        if (this.f1677p == null) goto L6;
        this.f1677p.F(r10, n.i());
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.g
    public long k() {
        z r10 = this.f1675n;
        if (r10 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r10.a() == null) goto L7;
        return this.f1675n.a().f();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.g
    public String l() {
        z r10 = this.f1675n;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.C();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.g
    public boolean m() {
        z r10 = this.f1675n;
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.f() != null) goto L9;
        return false;
    L9:
        if (this.f1675n.D() != null) goto L11;
        return true;
    L11:
        if (this.f1675n.k() == 304) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.g
    public void n() {
        z r10 = this.f1675n;
        if (r10 != null) goto L5;
    L7:
        okhttp3.e r11 = this.f1676o;
        if (r11 == null) goto L11;
        r11.cancel();
        return;
    L11:
        return;
    L5:
        if (r10.a() == null) goto L7;
        z2.d.l(this.f1675n.a());
        goto L7
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.g
    public Map<String, List<String>> o() {
        z r10 = this.f1675n;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.v().h();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    protected boolean p() {
        return this.f1632h;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    protected IOException s(Exception r18) {
        if ((r18 instanceof TTNetExceptionStorage) == false) goto L6;
        TTNetExceptionStorage r10 = (TTNetExceptionStorage) r18;
        String r11 = this.f1630c.G();
        o2.b r12 = this.f1631g;
        r10.setInfo(true, false, true, r11, r12.P, r12);
        return r10;
    L6:
        TTNetExceptionStorage r13 = new TTNetExceptionStorage(r18.getMessage(), r18.getCause());
        String r14 = this.f1630c.G();
        o2.b r15 = this.f1631g;
        r13.setInfo(true, false, true, r14, r15.P, r15);
        return r13;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    protected void v() {
        okhttp3.e r10 = this.f1676o;
        if (r10 == null) goto L6;
        this.f1675n = r10.execute();
        this.f1677p.H(this.f1675n);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    protected Context x() {
        return n.i();
    }
}
