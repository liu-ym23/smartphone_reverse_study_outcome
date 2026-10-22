package com.bumptech.glide.request;

import ai.j0;
import ai.y;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.s;
import com.google.common.reflect.w;
import com.lynx.tasm.base.f;
import java.util.ArrayList;
import java.util.Iterator;
import q0.i;

/* JADX INFO: loaded from: classes.dex */
public final class d implements b, n0.c {
    public static final boolean A = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f1686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1687c;
    public final Context d;
    public final com.bumptech.glide.c e;
    public final Object f;
    public final Class g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f1688h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f1689i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f1690j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Priority f1691k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final n0.d f1692l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f1693m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final o0.a f1694n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final y f1695o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.bumptech.glide.load.engine.y f1696p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public w f1697q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f1698r;
    public volatile s s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public SingleRequest$Status f1699t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Drawable f1700u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Drawable f1701v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Drawable f1702w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1703x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f1704y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f1705z;

    static {
        A = Log.isLoggable("Request", 2);
    }

    public d(Context r5, com.bumptech.glide.c r10, Object r11, Object r12, Class r13, a r14, int r15, int r16, Priority r17, n0.d r18, ArrayList r19, s r110, o0.a r111, y r112) {
        if (A == false) goto L5;
        String r20 = String.valueOf(hashCode());
    L6:
        this.f1685a = r20;
        this.f1686b = new f();
        this.f1687c = r11;
        this.d = r5;
        this.e = r10;
        this.f = r12;
        this.g = r13;
        this.f1688h = r14;
        this.f1689i = r15;
        this.f1690j = r16;
        this.f1691k = r17;
        this.f1692l = r18;
        this.f1693m = r19;
        this.s = r110;
        this.f1694n = r111;
        this.f1695o = r112;
        this.f1699t = SingleRequest$Status.PENDING;
        r10.getClass();
        return;
    L5:
        r20 = null;
        goto L6
    }

    public final void a() {
        Object r5 = this.f1687c;
        monitor-enter(r5);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f1705z == true) goto L46;
        this.f1686b.b();     // Catch: Throwable -> L11
        int r10 = q0.f.f21454b;     // Catch: Throwable -> L11
        this.f1698r = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L11
        if (this.f == null) goto L9;
        SingleRequest$Status r11 = this.f1699t;     // Catch: Throwable -> L11
        SingleRequest$Status r12 = SingleRequest$Status.RUNNING;     // Catch: Throwable -> L11
        if (r11 == r12) goto L44;
        if (r11 != SingleRequest$Status.COMPLETE) goto L30;
        j(this.f1696p, DataSource.MEMORY_CACHE);     // Catch: Throwable -> L11
        monitor-exit(r5);     // Catch: Throwable -> L11
        return;
    L30:
        SingleRequest$Status r13 = SingleRequest$Status.WAITING_FOR_SIZE;     // Catch: Throwable -> L11
        this.f1699t = r13;     // Catch: Throwable -> L11
        if (i.g(this.f1689i, this.f1690j) == false) goto L33;
        l(this.f1689i, this.f1690j);     // Catch: Throwable -> L11
    L34:
        SingleRequest$Status r14 = this.f1699t;     // Catch: Throwable -> L11
        if (r14 == r12) goto L37;
        if (r14 == r13) goto L37;
    L39:
        if (A == false) goto L41;
        h("finished run method in " + q0.f.a(this.f1698r));     // Catch: Throwable -> L11
    L41:
        monitor-exit(r5);     // Catch: Throwable -> L11
        return;
    L37:
        this.f1692l.d(d());     // Catch: Throwable -> L11
        goto L39
    L33:
        this.f1692l.c(this);     // Catch: Throwable -> L11
        goto L34
    L44:
        throw new IllegalArgumentException("Cannot restart a running request");     // Catch: Throwable -> L11
    L9:
        if (i.g(this.f1689i, this.f1690j) == false) goto L14;
        this.f1703x = this.f1689i;     // Catch: Throwable -> L11
        this.f1704y = this.f1690j;     // Catch: Throwable -> L11
    L14:
        if (this.f1702w != null) goto L17;
        this.f1688h.getClass();     // Catch: Throwable -> L11
        this.f1702w = null;     // Catch: Throwable -> L11
    L17:
        if (this.f1702w != null) goto L19;
        int r15 = 5;
    L20:
        i(new GlideException("Received null model"), r15);     // Catch: Throwable -> L11
        monitor-exit(r5);     // Catch: Throwable -> L11
        return;
    L19:
        r15 = 3;
        goto L20
    L46:
        throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");     // Catch: Throwable -> L11
    }

    public final void b() {
        if (this.f1705z == true) goto L16;
        this.f1686b.b();
        this.f1692l.a(this);
        w r5 = this.f1697q;
        if (r5 == null) goto L14;
        s r10 = (s) r5.d;
        monitor-enter(r10);
        ((com.bumptech.glide.load.engine.w) r5.f9377c).h((d) r5.f9376b);     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        this.f1697q = null;
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        return;
    L16:
        throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
    }

    public final void c() {
        Object r5 = this.f1687c;
        monitor-enter(r5);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f1705z == true) goto L22;
        this.f1686b.b();     // Catch: Throwable -> L10
        SingleRequest$Status r10 = this.f1699t;     // Catch: Throwable -> L10
        SingleRequest$Status r11 = SingleRequest$Status.CLEARED;     // Catch: Throwable -> L10
        if (r10 != r11) goto L12;
        monitor-exit(r5);     // Catch: Throwable -> L10
        return;
    L12:
        b();     // Catch: Throwable -> L10
        com.bumptech.glide.load.engine.y r12 = this.f1696p;     // Catch: Throwable -> L10
        if (r12 == null) goto L15;
        this.f1696p = null;     // Catch: Throwable -> L10
    L16:
        this.f1692l.f(d());     // Catch: Throwable -> L10
        this.f1699t = r11;     // Catch: Throwable -> L10
        monitor-exit(r5);     // Catch: Throwable -> L10
        if (r12 == null) goto L26;
        this.s.getClass();
        s.f(r12);
        return;
    L26:
        return;
    L15:
        r12 = null;
        goto L16
    L22:
        throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");     // Catch: Throwable -> L10
    }

    public final Drawable d() {
        if (this.f1701v != null) goto L8;
        a r5 = this.f1688h;
        r5.getClass();
        this.f1701v = null;
        int r10 = r5.d;
        if (r10 <= 0) goto L8;
        this.f1688h.getClass();
        Resources.Theme r11 = this.d.getTheme();
        com.bumptech.glide.c r12 = this.e;
        this.f1701v = td.c.h(r12, r12, r10, r11);
    L8:
        return this.f1701v;
    }

    public final boolean e() {
        Object r5 = this.f1687c;
        monitor-enter(r5);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f1699t != SingleRequest$Status.CLEARED) goto L7;
        boolean r10 = true;
    L8:
        monitor-exit(r5);     // Catch: Throwable -> L10
        return r10;
    L7:
        r10 = false;
        goto L8
    }

    public final boolean f() {
        Object r5 = this.f1687c;
        monitor-enter(r5);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f1699t != SingleRequest$Status.COMPLETE) goto L7;
        boolean r10 = true;
    L8:
        monitor-exit(r5);     // Catch: Throwable -> L10
        return r10;
    L7:
        r10 = false;
        goto L8
    }

    public final boolean g() {
        Object r5 = this.f1687c;
        monitor-enter(r5);
        SingleRequest$Status r10 = this.f1699t;     // Catch: Throwable -> L10
        if (r10 != SingleRequest$Status.RUNNING) goto L7;
    L12:
        boolean r11 = true;
    L13:
        monitor-exit(r5);     // Catch: Throwable -> L10
        return r11;
    L7:
        if (r10 == SingleRequest$Status.WAITING_FOR_SIZE) goto L12;
        r11 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public final void h(String r5) {
        StringBuilder r10 = j0.w(r5, " this: ");
        r10.append(this.f1685a);
        Log.v("Request", r10.toString());
    }

    public final void i(GlideException r5, int r10) {
        this.f1686b.b();
        Object r11 = this.f1687c;
        monitor-enter(r11);
        r5.setOrigin(null);     // Catch: Throwable -> L10
        int r12 = this.e.f1390h;     // Catch: Throwable -> L10
        if (r12 > r10) goto L12;
        Log.w("Glide", "Load failed for " + this.f + " with size [" + this.f1703x + "x" + this.f1704y + "]", r5);     // Catch: Throwable -> L10
        if (r12 > 4) goto L12;
        r5.logRootCauses("Glide");     // Catch: Throwable -> L10
    L12:
        this.f1697q = null;     // Catch: Throwable -> L10
        this.f1699t = SingleRequest$Status.FAILED;     // Catch: Throwable -> L10
        this.f1705z = true;     // Catch: Throwable -> L10
        ArrayList r13 = this.f1693m;     // Catch: Throwable -> L22
        if (r13 == null) goto L27;
        Iterator r14 = r13.iterator();     // Catch: Throwable -> L22
        if (r14.hasNext() == false) goto L27;
        if (r14.next() != null) goto L25;
        throw null;     // Catch: Throwable -> L22
    L25:
        throw new ClassCastException();     // Catch: Throwable -> L22
    L27:
        if (this.f == null) goto L29;
        Drawable r15 = null;
    L33:
        if (r15 == null) goto L35;
    L38:
        if (r15 != null) goto L40;
        r15 = d();     // Catch: Throwable -> L22
    L40:
        this.f1692l.h(r15);     // Catch: Throwable -> L22
        this.f1705z = false;     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L35:
        if (this.f1700u != null) goto L37;
        this.f1688h.getClass();     // Catch: Throwable -> L22
        this.f1700u = null;     // Catch: Throwable -> L22
    L37:
        r15 = this.f1700u;     // Catch: Throwable -> L22
        goto L38
    L29:
        if (this.f1702w != null) goto L31;
        this.f1688h.getClass();     // Catch: Throwable -> L22
        this.f1702w = null;     // Catch: Throwable -> L22
    L31:
        r15 = this.f1702w;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        this.f1705z = false;     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public final void j(com.bumptech.glide.load.engine.y r10, DataSource r11) {
        this.f1686b.b();
        com.bumptech.glide.load.engine.y r5 = null;
        Object r12 = this.f1687c;     // Catch: Throwable -> L36
        monitor-enter(r12);     // Catch: Throwable -> L36
        this.f1697q = null;     // Catch: Throwable -> L10
        if (r10 != null) goto L12;
        i(new GlideException("Expected to receive a Resource<R> with an object of " + this.g + " inside, but instead got null."), 5);     // Catch: Throwable -> L10
        monitor-exit(r12);     // Catch: Throwable -> L10
        return;
    L12:
        Object r13 = r10.f1592c.get();     // Catch: Throwable -> L10
        if (r13 != null) goto L15;
    L40:
        this.f1696p = null;     // Catch: Throwable -> L23
        StringBuilder r14 = new StringBuilder("Expected to receive an object of ");     // Catch: Throwable -> L23
        r14.append(this.g);     // Catch: Throwable -> L23
        r14.append(" but instead got ");     // Catch: Throwable -> L23
        if (r13 == null) goto L25;
        Object r15 = r13.getClass();     // Catch: Throwable -> L23
    L26:
        r14.append(r15);     // Catch: Throwable -> L23
        r14.append("{");     // Catch: Throwable -> L23
        r14.append(r13);     // Catch: Throwable -> L23
        r14.append("} inside Resource{");     // Catch: Throwable -> L23
        r14.append(r10);     // Catch: Throwable -> L23
        r14.append("}.");     // Catch: Throwable -> L23
        if (r13 == null) goto L29;
        String r16 = "";
    L30:
        r14.append(r16);     // Catch: Throwable -> L23
        i(new GlideException(r14.toString()), 5);     // Catch: Throwable -> L23
        monitor-exit(r12);     // Catch: Throwable -> L23
        this.s.getClass();
        s.f(r10);
        return;
    L29:
        r16 = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
        goto L30
    L25:
        r15 = "";
    L23:
        th = move-exception;
        r5 = r10;
        th = th;
    L34:
        monitor-exit(r12);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L36
    L15:
        if (this.g.isAssignableFrom(r13.getClass()) == false) goto L40;
        k(r10, r13, r11);     // Catch: Throwable -> L10
        monitor-exit(r12);     // Catch: Throwable -> L10
        return;
    L10:
        th = th;
    L36:
        th = move-exception;
        if (r5 == null) goto L39;
        this.s.getClass();
        s.f(r5);
    L39:
        throw th;
    }

    public final void k(com.bumptech.glide.load.engine.y r5, Object r10, DataSource r11) {
        this.f1699t = SingleRequest$Status.COMPLETE;
        this.f1696p = r5;
        if (this.e.f1390h > 3) goto L5;
        Log.d("Glide", "Finished loading " + r10.getClass().getSimpleName() + " from " + r11 + " for " + this.f + " with size [" + this.f1703x + "x" + this.f1704y + "] in " + q0.f.a(this.f1698r) + " ms");
    L5:
        this.f1705z = true;
        ArrayList r12 = this.f1693m;     // Catch: Throwable -> L15
        if (r12 == null) goto L19;
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L15
        if (r13.hasNext() == false) goto L19;
        if (r13.next() != null) goto L18;
        throw null;     // Catch: Throwable -> L15
    L18:
        throw new ClassCastException();     // Catch: Throwable -> L15
    L19:
        this.f1694n.getClass();     // Catch: Throwable -> L15
        this.f1692l.b(r10);     // Catch: Throwable -> L15
        this.f1705z = false;
        return;
    L15:
        th = move-exception;
        this.f1705z = false;
        throw th;
    }

    public final void l(int r25, int r26) {
        int r5 = r25;
        this.f1686b.b();
        Object r14 = this.f1687c;
        monitor-enter(r14);
        boolean r19 = A;     // Catch: Throwable -> L7
        if (r19 == false) goto L10;
        h("Got onSizeReady in " + q0.f.a(this.f1698r));     // Catch: Throwable -> L7
    L10:
        if (this.f1699t == SingleRequest$Status.WAITING_FOR_SIZE) goto L13;
        monitor-exit(r14);     // Catch: Throwable -> L7
        return;
    L13:
        SingleRequest$Status r13 = SingleRequest$Status.RUNNING;     // Catch: Throwable -> L7
        this.f1699t = r13;     // Catch: Throwable -> L7
        this.f1688h.getClass();     // Catch: Throwable -> L7
        if (r5 == Integer.MIN_VALUE) goto L17;
        r5 = Math.round(r5 * 1.0f);     // Catch: Throwable -> L7
    L17:
        this.f1703x = r5;     // Catch: Throwable -> L7
        if (r26 != Integer.MIN_VALUE) goto L20;
        int r10 = r26;
    L21:
        this.f1704y = r10;     // Catch: Throwable -> L7
        if (r19 == false) goto L24;
        h("finished setup for calling load in " + q0.f.a(this.f1698r));     // Catch: Throwable -> L7
    L24:
        s r11 = this.s;     // Catch: Throwable -> L7
        com.bumptech.glide.c r12 = this.e;     // Catch: Throwable -> L7
        Object r15 = this.f;     // Catch: Throwable -> L7
        a r16 = this.f1688h;     // Catch: Throwable -> L7
        this.f1697q = r11.a(r12, r15, r16.f1676h, this.f1703x, this.f1704y, r16.f1680l, this.g, this.f1691k, r16.f1674b, r16.f1679k, r16.f1677i, r16.f1683o, r16.f1678j, r16.e, r16.f1684p, this, this.f1695o);     // Catch: Throwable -> L29
        if (this.f1699t == r13) goto L31;
        this.f1697q = null;     // Catch: Throwable -> L29
    L31:
        if (r19 == false) goto L33;
        h("finished onSizeReady in " + q0.f.a(this.f1698r));     // Catch: Throwable -> L29
    L33:
        monitor-exit(r14);     // Catch: Throwable -> L29
        return;
    L20:
        r10 = Math.round(1.0f * r26);     // Catch: Throwable -> L7
    L29:
        th = th;
    L35:
        monitor-exit(r14);     // Catch: Throwable -> L29
        throw th;
    L7:
        th = th;
        goto L35
    }
}
