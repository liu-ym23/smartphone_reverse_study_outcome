package com.bumptech.glide;

import ai.y;
import android.content.Context;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.m;
import io.reactivex.internal.observers.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import q0.i;

/* JADX INFO: loaded from: classes.dex */
public final class f extends com.bumptech.glide.request.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Context f1400q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final g f1401r;
    public final Class s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final c f1402t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public a f1403u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f1404v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1405w;

    static {
        com.bumptech.glide.request.c r5 = (com.bumptech.glide.request.c) ((com.bumptech.glide.request.c) ((com.bumptech.glide.request.c) new com.bumptech.glide.request.c().e(m.f1545c)).j(Priority.LOW)).n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(b r5, g r10, Class r11, Context r12) {
        this.f1401r = r10;
        this.s = r11;
        this.f1400q = r12;
        ArrayMap r13 = r10.f1407a.f1384c.f;
        a r14 = (a) r13.get(r11);
        if (r14 != null) goto L10;
        Iterator r15 = r13.entrySet().iterator();
    L6:
        if (r15.hasNext() == false) goto L10;
        Map.Entry r16 = (Map.Entry) r15.next();
        if (((Class) r16.getKey()).isAssignableFrom(r11) == false) goto L6;
        r14 = (a) r16.getValue();
    L10:
        if (r14 != null) goto L12;
        r14 = c.f1386j;
    L12:
        this.f1403u = r14;
        this.f1402t = r5.f1384c;
        Iterator r17 = r10.f1412j.iterator();
    L14:
        if (r17.hasNext() == false) goto L20;
        if (r17.next() == null) goto L14;
        throw new ClassCastException();
    L20:
        monitor-enter(r10);
        com.bumptech.glide.request.c r18 = r10.f1413k;     // Catch: Throwable -> L25
        monitor-exit(r10);
        r(r18);
        return;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.a
    public final /* bridge */ /* synthetic */ com.bumptech.glide.request.a a(com.bumptech.glide.request.a r5) {
        return r(r5);
    }

    @Override // com.bumptech.glide.request.a
    public final /* bridge */ /* synthetic */ com.bumptech.glide.request.a b() {
        return s();
    }

    @Override // com.bumptech.glide.request.a
    public final /* bridge */ /* synthetic */ Object clone() {
        return s();
    }

    public final f r(com.bumptech.glide.request.a r5) {
        h.g(r5);
        return (f) super.a(r5);
    }

    public final f s() {
        f r5 = (f) super.b();
        r5.f1403u = r5.f1403u.a();
        return r5;
    }

    public final void t(n0.d r19, com.bumptech.glide.request.a r20, y r21) {
        h.g(r19);
        if (this.f1405w == false) goto L70;
        Object r5 = new Object();
        a r10 = this.f1403u;
        Priority r11 = r20.f1675c;
        int r12 = r20.g;
        int r13 = r20.f;
        Object r14 = this.f1404v;
        c r15 = this.f1402t;
        com.bumptech.glide.request.d r16 = r7;
        com.bumptech.glide.request.d r17 = new com.bumptech.glide.request.d(this.f1400q, r15, r5, r14, this.s, r20, r12, r13, r11, r19, null, r15.g, r10.f1379a, r21);
        com.bumptech.glide.request.b r18 = r19.e();
        if ((r18 instanceof com.bumptech.glide.request.d) == true) goto L7;
    L6:
        boolean r22 = false;
    L41:
        if (r22 == false) goto L51;
        if (r20.e == false) goto L45;
    L47:
        h.h(r18, "Argument must not be null");
        com.bumptech.glide.request.d r23 = (com.bumptech.glide.request.d) r18;
        if (r23.g() == true) goto L76;
        r23.a();
        return;
    L76:
        return;
    L45:
        if (((com.bumptech.glide.request.d) r18).f() == false) goto L47;
    L51:
        this.f1401r.j(r19);
        com.bumptech.glide.request.d r24 = r16;
        r19.g(r24);
        g r25 = this.f1401r;
        monitor-enter(r25);
        r25.f.f18578a.add(r19);     // Catch: Throwable -> L62
        c5.a r26 = r25.d;     // Catch: Throwable -> L62
        ((Set) r26.d).add(r24);     // Catch: Throwable -> L62
        if (r26.f1118b == true) goto L56;
        r24.a();     // Catch: Throwable -> L62
    L60:
        monitor-exit(r25);
        return;
    L56:
        r24.c();     // Catch: Throwable -> L62
        if (Log.isLoggable("RequestTracker", 2) == false) goto L59;
        Log.v("RequestTracker", "Paused, delaying request");     // Catch: Throwable -> L62
    L59:
        ((ArrayList) r26.f1119c).add(r24);     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        throw th;
    L7:
        Object r27 = r16.f1687c;
        monitor-enter(r27);
        int r28 = r16.f1689i;     // Catch: Throwable -> L12
        int r29 = r16.f1690j;     // Catch: Throwable -> L12
        Object r30 = r16.f;     // Catch: Throwable -> L12
        Class r31 = r16.g;     // Catch: Throwable -> L12
        com.bumptech.glide.request.a r32 = r16.f1688h;     // Catch: Throwable -> L12
        Priority r110 = r16.f1691k;     // Catch: Throwable -> L12
        ArrayList r111 = r16.f1693m;     // Catch: Throwable -> L12
        if (r111 == null) goto L14;
        int r112 = r111.size();     // Catch: Throwable -> L12
    L15:
        monitor-exit(r27);     // Catch: Throwable -> L12
        com.bumptech.glide.request.d r33 = (com.bumptech.glide.request.d) r18;
        Object r113 = r33.f1687c;
        monitor-enter(r113);
        int r114 = r33.f1689i;     // Catch: Throwable -> L21
        int r115 = r33.f1690j;     // Catch: Throwable -> L21
        Object r116 = r33.f;     // Catch: Throwable -> L21
        Class r34 = r33.g;     // Catch: Throwable -> L21
        r16 = r16;
        com.bumptech.glide.request.a r35 = r33.f1688h;     // Catch: Throwable -> L21
        Priority r36 = r33.f1691k;     // Catch: Throwable -> L21
        ArrayList r37 = r33.f1693m;     // Catch: Throwable -> L21
        if (r37 == null) goto L23;
        int r38 = r37.size();     // Catch: Throwable -> L21
    L24:
        monitor-exit(r113);     // Catch: Throwable -> L21
        if (r28 != r114) goto L6;
        if (r29 != r115) goto L6;
        char[] r39 = i.f21459a;
        if (r30 != null) goto L32;
        if (r116 != null) goto L31;
        boolean r40 = true;
    L33:
        if (r40 == false) goto L6;
        if (r31.equals(r34) == false) goto L6;
        if (r32.equals(r35) == false) goto L6;
        if (r110 != r36) goto L6;
        if (r112 != r38) goto L6;
        r22 = true;
        goto L41
    L31:
        r40 = false;
        goto L33
    L32:
        r40 = r30.equals(r116);
        goto L33
    L23:
        r38 = 0;
    L21:
        th = move-exception;
        throw th;
    L14:
        r112 = 0;
    L12:
        th = move-exception;
        throw th;
    L70:
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }
}
