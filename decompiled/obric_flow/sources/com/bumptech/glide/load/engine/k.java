package com.bumptech.glide.load.engine;

import ai.j0;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class k implements e, Runnable, Comparable, r0.e {
    public com.bumptech.glide.load.data.e A;
    public volatile f B;
    public volatile boolean C;
    public volatile boolean D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f1520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f1521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.lynx.tasm.base.f f1522c;
    public final r d;
    public final r0.d e;
    public final com.google.common.reflect.w f;
    public final j g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bumptech.glide.c f1523h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public z.c f1524i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Priority f1525j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public x f1526k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1527l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1528m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public m f1529n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public z.f f1530o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public w f1531p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1532q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DecodeJob$Stage f1533r;
    public DecodeJob$RunReason s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f1534t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Object f1535u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Thread f1536v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public z.c f1537w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public z.c f1538x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f1539y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public DataSource f1540z;

    public k(r r5, r0.d r10) {
        this.f1520a = new g();
        this.f1521b = new ArrayList();
        this.f1522c = new com.lynx.tasm.base.f();
        this.f = new com.google.common.reflect.w(3, false);
        this.g = new j();
        this.d = r5;
        this.e = r10;
    }

    @Override // com.bumptech.glide.load.engine.e
    public final void a(z.c r5, Exception r10, com.bumptech.glide.load.data.e r11, DataSource r12) {
        r11.b();
        GlideException r13 = new GlideException("Fetching data failed", r10);
        r13.setLoggingDetails(r5, r12, r11.c());
        this.f1521b.add(r13);
        if (Thread.currentThread() == this.f1536v) goto L9;
        this.s = DecodeJob$RunReason.SWITCH_TO_SOURCE_SERVICE;
        w r14 = this.f1531p;
        if (r14.f1577m == false) goto L7;
        c0.b r15 = r14.f1573i;
    L8:
        r15.execute(this);
        return;
    L7:
        r15 = r14.f1572h;
        goto L8
    L9:
        o();
    }

    @Override // r0.e
    public final com.lynx.tasm.base.f b() {
        return this.f1522c;
    }

    @Override // com.bumptech.glide.load.engine.e
    public final void c(z.c r5, Object r10, com.bumptech.glide.load.data.e r11, DataSource r12, z.c r13) {
        this.f1537w = r5;
        this.f1539y = r10;
        this.A = r11;
        this.f1540z = r12;
        this.f1538x = r13;
        if (Thread.currentThread() == this.f1536v) goto L9;
        this.s = DecodeJob$RunReason.DECODE_DATA;
        w r14 = this.f1531p;
        if (r14.f1577m == false) goto L7;
        c0.b r15 = r14.f1573i;
    L8:
        r15.execute(this);
        return;
    L7:
        r15 = r14.f1572h;
        goto L8
    L9:
        f();
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r5) {
        k r10 = (k) r5;
        int r11 = this.f1525j.ordinal() - r10.f1525j.ordinal();
        if (r11 == 0) goto L5;
        return r11;
    L5:
        return this.f1532q - r10.f1532q;
    }

    public final d0 d(com.bumptech.glide.load.data.e r10, Object r11, DataSource r12) {
        if (r11 != null) goto L16;
        r10.b();
        return null;
    L16:
        int r5 = q0.f.f21454b;     // Catch: Throwable -> L10
        long r13 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L10
        d0 r14 = e(r11, r12);     // Catch: Throwable -> L10
        if (Log.isLoggable("DecodeJob", 2) == false) goto L12;
        i(r13, "Decoded result " + r14, null);     // Catch: Throwable -> L10
    L12:
        r10.b();
        return r14;
    L10:
        th = move-exception;
        r10.b();
        throw th;
    }

    public final d0 e(Object r10, DataSource r11) {
        b0 r5 = this.f1520a.c(r10.getClass());
        z.f r12 = this.f1530o;
        if (r11 != DataSource.RESOURCE_DISK_CACHE) goto L5;
    L8:
        boolean r13 = true;
    L9:
        z.e r14 = com.bumptech.glide.load.resource.bitmap.l.f1616i;
        Boolean r15 = (Boolean) r12.c(r14);
        if (r15 != null) goto L12;
    L15:
        r12 = new z.f();
        z.f r16 = this.f1530o;
        r12.f23357b.putAll(r16.f23357b);
        Boolean r17 = Boolean.valueOf(r13);
        r12.f23357b.put(r14, r17);
    L14:
        z.f r18 = r12;
        com.bumptech.glide.load.data.i r19 = this.f1523h.f1388b.e;
        monitor-enter(r19);
        com.bumptech.glide.load.data.f r20 = (com.bumptech.glide.load.data.f) ((HashMap) r19.f1428b).get(r10.getClass());     // Catch: Throwable -> L26
        if (r20 != null) goto L28;
        Iterator r21 = ((HashMap) r19.f1428b).values().iterator();     // Catch: Throwable -> L26
    L22:
        if (r21.hasNext() == false) goto L28;
        com.bumptech.glide.load.data.f r22 = (com.bumptech.glide.load.data.f) r21.next();     // Catch: Throwable -> L26
        if (r22.c().isAssignableFrom(r10.getClass()) == false) goto L22;
        r20 = r22;
    L28:
        if (r20 != null) goto L30;
        r20 = com.bumptech.glide.load.data.i.f1426c;     // Catch: Throwable -> L26
    L30:
        com.bumptech.glide.load.data.g r23 = r20.a(r10);     // Catch: Throwable -> L26
        monitor-exit(r19);
        d0 r24 = r5.a(this.f1527l, this.f1528m, r23, new i(this, r11), r18);     // Catch: Throwable -> L35
        r23.b();
        return r24;
    L35:
        th = move-exception;
        r23.b();
        throw th;
    L26:
        th = move-exception;
        throw th;
    L12:
        if (r15.booleanValue() == false) goto L14;
        if (r13 == false) goto L15;
    L5:
        if (this.f1520a.f1505r == true) goto L8;
        r13 = false;
        goto L9
    }

    public final void f() {
        if (Log.isLoggable("DecodeJob", 2) == false) goto L5;
        i(this.f1534t, "Retrieved data", "data: " + this.f1539y + ", cache key: " + this.f1537w + ", fetcher: " + this.A);
    L5:
        c0 r5 = null;
        d0 r10 = d(this.A, this.f1539y, this.f1540z);     // Catch: GlideException -> L8
    L10:
        if (r10 == null) goto L76;
        DataSource r11 = this.f1540z;
        if ((r10 instanceof a0) == false) goto L14;
        ((a0) r10).initialize();
    L14:
        boolean r12 = false;
        if (((c0) this.f.d) == null) goto L17;
        r5 = (c0) c0.e.acquire();
        r5.d = false;
        r5.f1478c = true;
        r5.f1477b = r10;
        r10 = r5;
    L17:
        s();
        w r13 = this.f1531p;
        monitor-enter(r13);
        r13.f1578n = r10;     // Catch: Throwable -> L73
        r13.f1579o = r11;     // Catch: Throwable -> L73
        monitor-exit(r13);     // Catch: Throwable -> L73
        monitor-enter(r13);
        r13.f1570b.b();     // Catch: Throwable -> L27
        if (r13.f1584u == false) goto L30;
        r13.f1578n.recycle();     // Catch: Throwable -> L27
        r13.g();     // Catch: Throwable -> L27
        monitor-exit(r13);     // Catch: Throwable -> L27
    L40:
        this.f1533r = DecodeJob$Stage.ENCODE;
        com.google.common.reflect.w r14 = this.f;     // Catch: Throwable -> L51
        if (((c0) r14.d) == null) goto L44;
        r12 = true;
    L44:
        if (r12 == false) goto L53;
        r r15 = this.d;     // Catch: Throwable -> L51
        z.f r16 = this.f1530o;     // Catch: Throwable -> L51
        r14.getClass();     // Catch: Throwable -> L51
        r15.a().c((z.c) r14.f9377c, new com.google.common.reflect.w((z.h) r14.f9376b, 2, (c0) r14.d, r16));     // Catch: Throwable -> L48
        ((c0) r14.d).d();     // Catch: Throwable -> L51
        goto L53
    L48:
        th = move-exception;
        ((c0) r14.d).d();     // Catch: Throwable -> L51
        throw th;     // Catch: Throwable -> L51
    L53:
        if (r5 == null) goto L55;
        r5.d();
    L55:
        j r17 = this.g;
        monitor-enter(r17);
        r17.f1518b = true;     // Catch: Throwable -> L61
        boolean r18 = r17.b();     // Catch: Throwable -> L61
        monitor-exit(r17);
        if (r18 == false) goto L89;
        k();
        return;
    L89:
        return;
    L61:
        th = move-exception;
        throw th;
    L51:
        th = move-exception;
        if (r5 == null) goto L66;
        r5.d();
    L66:
        throw th;
    L30:
        if (((ArrayList) r13.f1569a.f1567b).isEmpty() == true) goto L70;
        if (r13.f1580p == true) goto L68;
        r9.c r19 = r13.e;     // Catch: Throwable -> L27
        d0 r20 = r13.f1578n;     // Catch: Throwable -> L27
        boolean r21 = r13.f1576l;     // Catch: Throwable -> L27
        x r110 = r13.f1575k;     // Catch: Throwable -> L27
        s r111 = r13.f1571c;     // Catch: Throwable -> L27
        r19.getClass();     // Catch: Throwable -> L27
        r13.s = new y(r20, r21, true, r110, r111);     // Catch: Throwable -> L27
        r13.f1580p = true;     // Catch: Throwable -> L27
        v r22 = r13.f1569a;     // Catch: Throwable -> L27
        r22.getClass();     // Catch: Throwable -> L27
        ArrayList r23 = new ArrayList((ArrayList) r22.f1567b);     // Catch: Throwable -> L27
        r13.e(r23.size() + 1);     // Catch: Throwable -> L27
        x r24 = r13.f1575k;     // Catch: Throwable -> L27
        y r25 = r13.s;     // Catch: Throwable -> L27
        monitor-exit(r13);     // Catch: Throwable -> L27
        r13.f.d(r13, r24, r25);
        Iterator r26 = r23.iterator();
    L37:
        if (r26.hasNext() == false) goto L39;
        u r27 = (u) r26.next();
        r27.f1565b.execute(new t(r13, r27.f1564a, 1));
        goto L37
    L39:
        r13.d();
        goto L40
    L68:
        throw new IllegalStateException("Already have resource");     // Catch: Throwable -> L27
    L70:
        throw new IllegalStateException("Received a resource without any callbacks to notify");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    L73:
        th = move-exception;
        throw th;
    L76:
        o();
        return;
    L8:
        e = move-exception;
        e.setLoggingDetails(this.f1538x, this.f1540z);
        this.f1521b.add(e);
        r10 = null;
        goto L10
    }

    public final f g() {
        int r5 = h.f1507b[this.f1533r.ordinal()];
        g r10 = this.f1520a;
        if (r5 == 1) goto L19;
        if (r5 == 2) goto L17;
        if (r5 == 3) goto L15;
        if (r5 != 4) goto L13;
        return null;
    L13:
        throw new IllegalStateException("Unrecognized stage: " + this.f1533r);
    L15:
        return new i0(r10, this);
    L17:
        return new c(r10.a(), r10, this);
    L19:
        return new e0(r10, this);
    }

    public final DecodeJob$Stage h(DecodeJob$Stage r5) {
        int r10 = h.f1507b[r5.ordinal()];
        if (r10 == 1) goto L27;
        if (r10 == 2) goto L25;
        if (r10 == 3) goto L23;
        if (r10 == 4) goto L23;
        if (r10 != 5) goto L21;
        switch(this.f1529n.f1546a) {
            case 0: goto L15;
            case 1: goto L15;
            default: goto L14;
        };
    L14:
        boolean r11 = true;
    L16:
        if (r11 == false) goto L19;
        return DecodeJob$Stage.RESOURCE_CACHE;
    L19:
        return h(DecodeJob$Stage.RESOURCE_CACHE);
    L15:
        r11 = false;
        goto L16
    L21:
        throw new IllegalArgumentException("Unrecognized stage: " + r5);
    L23:
        return DecodeJob$Stage.FINISHED;
    L25:
        return DecodeJob$Stage.SOURCE;
    L27:
        switch(this.f1529n.f1546a) {
            case 0: goto L29;
            case 1: goto L28;
            default: goto L28;
        };
    L28:
        boolean r12 = true;
    L30:
        if (r12 == false) goto L33;
        return DecodeJob$Stage.DATA_CACHE;
    L33:
        return h(DecodeJob$Stage.DATA_CACHE);
    L29:
        r12 = false;
        goto L30
    }

    public final void i(long r5, String r10, String r11) {
        StringBuilder r12 = j0.w(r10, " in ");
        r12.append(q0.f.a(r5));
        r12.append(", load key: ");
        r12.append(this.f1526k);
        if (r11 == null) goto L5;
        String r13 = ", ".concat(r11);
    L6:
        r12.append(r13);
        r12.append(", thread: ");
        r12.append(Thread.currentThread().getName());
        Log.v("DecodeJob", r12.toString());
        return;
    L5:
        r13 = "";
        goto L6
    }

    public final void j() {
        s();
        GlideException r5 = new GlideException("Failed to load resource", new ArrayList(this.f1521b));
        w r10 = this.f1531p;
        monitor-enter(r10);
        r10.f1581q = r5;     // Catch: Throwable -> L41
        monitor-exit(r10);     // Catch: Throwable -> L41
        monitor-enter(r10);
        r10.f1570b.b();     // Catch: Throwable -> L12
        if (r10.f1584u == false) goto L15;
        r10.g();     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
    L25:
        j r11 = this.g;
        monitor-enter(r11);
        r11.f1519c = true;     // Catch: Throwable -> L32
        boolean r12 = r11.b();     // Catch: Throwable -> L32
        monitor-exit(r11);
        if (r12 == false) goto L50;
        k();
        return;
    L50:
        return;
    L32:
        th = move-exception;
        throw th;
    L15:
        if (((ArrayList) r10.f1569a.f1567b).isEmpty() == true) goto L38;
        if (r10.f1582r == true) goto L36;
        r10.f1582r = true;     // Catch: Throwable -> L12
        x r13 = r10.f1575k;     // Catch: Throwable -> L12
        v r14 = r10.f1569a;     // Catch: Throwable -> L12
        r14.getClass();     // Catch: Throwable -> L12
        ArrayList r15 = new ArrayList((ArrayList) r14.f1567b);     // Catch: Throwable -> L12
        r10.e(r15.size() + 1);     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        r10.f.d(r10, r13, null);
        Iterator r16 = r15.iterator();
    L22:
        if (r16.hasNext() == false) goto L24;
        u r17 = (u) r16.next();
        r17.f1565b.execute(new t(r10, r17.f1564a, 0));
        goto L22
    L24:
        r10.d();
        goto L25
    L36:
        throw new IllegalStateException("Already failed once");     // Catch: Throwable -> L12
    L38:
        throw new IllegalStateException("Received an exception without any callbacks to notify");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L41:
        th = move-exception;
        throw th;
    }

    public final void k() {
        j r5 = this.g;
        monitor-enter(r5);
        r5.f1518b = false;     // Catch: Throwable -> L9
        r5.f1517a = false;     // Catch: Throwable -> L9
        r5.f1519c = false;     // Catch: Throwable -> L9
        monitor-exit(r5);
        com.google.common.reflect.w r10 = this.f;
        r10.f9377c = null;
        r10.f9376b = null;
        r10.d = null;
        g r11 = this.f1520a;
        r11.f1494c = null;
        r11.d = null;
        r11.f1501n = null;
        r11.g = null;
        r11.f1498k = null;
        r11.f1496i = null;
        r11.f1502o = null;
        r11.f1497j = null;
        r11.f1503p = null;
        r11.f1492a.clear();
        r11.f1499l = false;
        r11.f1493b.clear();
        r11.f1500m = false;
        this.C = false;
        this.f1523h = null;
        this.f1524i = null;
        this.f1530o = null;
        this.f1525j = null;
        this.f1526k = null;
        this.f1531p = null;
        this.f1533r = null;
        this.B = null;
        this.f1536v = null;
        this.f1537w = null;
        this.f1539y = null;
        this.f1540z = null;
        this.A = null;
        this.f1534t = 0;
        this.D = false;
        this.f1521b.clear();
        this.e.release(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void l() {
        this.s = DecodeJob$RunReason.SWITCH_TO_SOURCE_SERVICE;
        w r5 = this.f1531p;
        if (r5.f1577m == false) goto L5;
        c0.b r10 = r5.f1573i;
    L6:
        r10.execute(this);
        return;
    L5:
        r10 = r5.f1572h;
        goto L6
    }

    public final void o() {
        this.f1536v = Thread.currentThread();
        int r5 = q0.f.f21454b;
        this.f1534t = SystemClock.elapsedRealtimeNanos();
        boolean r10 = false;
    L4:
        if (this.D == true) goto L14;
        if (this.B == null) goto L14;
        r10 = this.B.b();
        if (r10 == true) goto L14;
        this.f1533r = h(this.f1533r);
        this.B = g();
        if (this.f1533r != DecodeJob$Stage.SOURCE) goto L4;
        l();
        return;
    L14:
        if (this.f1533r != DecodeJob$Stage.FINISHED) goto L16;
    L17:
        if (r10 == true) goto L26;
        j();
        return;
    L26:
        return;
    L16:
        if (this.D == true) goto L17;
    }

    public final void r() {
        int r5 = h.f1506a[this.s.ordinal()];
        if (r5 != 1) goto L5;
        this.f1533r = h(DecodeJob$Stage.INITIALIZE);
        this.B = g();
        o();
        return;
    L5:
        if (r5 != 2) goto L7;
        o();
        return;
    L7:
        if (r5 != 3) goto L10;
        f();
        return;
    L10:
        throw new IllegalStateException("Unrecognized run reason: " + this.s);
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bumptech.glide.load.data.e r5 = this.A;
    L21:
        th = move-exception;
        if (r5 == null) goto L33;
        r5.b();
    L33:
        throw th;
    L9:
        th = move-exception;
        if (Log.isLoggable("DecodeJob", 3) == false) goto L24;
        Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.D + ", stage: " + this.f1533r, th);     // Catch: Throwable -> L21
    L24:
        if (this.f1533r == DecodeJob$Stage.ENCODE) goto L27;
        this.f1521b.add(th);     // Catch: Throwable -> L21
        j();     // Catch: Throwable -> L21
    L27:
        if (this.D == true) goto L29;
        throw th;     // Catch: Throwable -> L21
    L29:
        throw th;     // Catch: Throwable -> L21
    L11:
        e = move-exception;
        throw e;     // Catch: Throwable -> L21
    L4:
        if (this.D == false) goto L13;
        j();     // Catch: Throwable -> L9 CallbackException -> L11
        if (r5 == null) goto L35;
        r5.b();
        return;
    L35:
        return;
    L13:
        r();     // Catch: Throwable -> L9 CallbackException -> L11
        if (r5 == null) goto L36;
        r5.b();
        return;
    }

    public final void s() {
        this.f1522c.b();
        if (this.C == true) goto L5;
        this.C = true;
        return;
    L5:
        if (this.f1521b.isEmpty() == false) goto L7;
        Throwable r5 = null;
    L9:
        throw new IllegalStateException("Already notified", r5);
    L7:
        r5 = (Throwable) androidx.constraintlayout.motion.widget.a.h(this.f1521b, 1);
        goto L9
    }
}
