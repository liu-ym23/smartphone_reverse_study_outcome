package com.bumptech.glide.load.engine;

import androidx.collection.ArrayMap;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry$NoSourceEncoderAvailableException;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f1493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bumptech.glide.c f1494c;
    public Object d;
    public int e;
    public int f;
    public Class g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public r f1495h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public z.f f1496i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CachedHashCodeArrayMap f1497j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Class f1498k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f1499l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1500m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public z.c f1501n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Priority f1502o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public m f1503p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f1504q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1505r;

    public g() {
        this.f1492a = new ArrayList();
        this.f1493b = new ArrayList();
    }

    public final ArrayList a() {
        boolean r5 = this.f1500m;
        ArrayList r10 = this.f1493b;
        if (r5 == true) goto L17;
        this.f1500m = true;
        r10.clear();
        ArrayList r11 = b();
        int r12 = r11.size();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L17;
        d0.q r14 = (d0.q) r11.get(r13);
        if (r10.contains(r14.f16565a) == true) goto L9;
        r10.add(r14.f16565a);
    L9:
        int r15 = 0;
    L10:
        List r16 = r14.f16566b;
        if (r15 >= r16.size()) goto L16;
        if (r10.contains(r16.get(r15)) == true) goto L15;
        r10.add(r16.get(r15));
    L15:
        r15 = r15 + 1;
        goto L10
    L16:
        r13 = r13 + 1;
    L17:
        return r10;
    }

    public final ArrayList b() {
        boolean r5 = this.f1499l;
        ArrayList r10 = this.f1492a;
        if (r5 == true) goto L10;
        this.f1499l = true;
        r10.clear();
        List r11 = this.f1494c.f1388b.f(this.d);
        int r12 = r11.size();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L10;
        d0.q r14 = ((d0.r) r11.get(r13)).b(this.d, this.e, this.f, this.f1496i);
        if (r14 == null) goto L9;
        r10.add(r14);
    L9:
        r13 = r13 + 1;
    L10:
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final b0 c(Class r18) {
        com.bumptech.glide.d r10 = this.f1494c.f1388b;
        Class r11 = this.g;
        Class r12 = this.f1498k;
        m0.c r5 = r10.f1396i;
        q0.g r13 = (q0.g) r5.f19948b.getAndSet(null);
        if (r13 != null) goto L5;
        r13 = new q0.g();
    L5:
        r13.f21455a = r18;
        r13.f21456b = r11;
        r13.f21457c = r12;
        ArrayMap r14 = r5.f19947a;
        monitor-enter(r14);
        b0 r15 = (b0) r5.f19947a.get(r13);     // Catch: Throwable -> L89
        monitor-exit(r14);     // Catch: Throwable -> L89
        r5.f19948b.set(r13);
        r10.f1396i.getClass();
        if (m0.c.f19946c.equals(r15) == true) goto L118;
        if (r15 != null) goto L88;
        ArrayList r16 = new ArrayList();
        Iterator r17 = r10.f1394c.o(r18, r11).iterator();
    L15:
        if (r17.hasNext() == false) goto L72;
        Class<?> r19 = (Class) r17.next();
        Iterator r110 = r10.f.g(r19, r12).iterator();
    L18:
        if (r110.hasNext() == false) goto L15;
        Class r20 = (Class) r110.next();
        ym.p r21 = r10.f1394c;
        monitor-enter(r21);
        ArrayList r22 = new ArrayList();     // Catch: Throwable -> L39
        Iterator r23 = ((ArrayList) r21.f23312b).iterator();     // Catch: Throwable -> L39
    L23:
        if (r23.hasNext() == false) goto L41;
        List r24 = (List) ((HashMap) r21.f23313c).get((String) r23.next());     // Catch: Throwable -> L39
        if (r24 == null) goto L23;
        Iterator r25 = r24.iterator();     // Catch: Throwable -> L39
    L29:
        if (r25.hasNext() == false) goto L23;
        m0.d r26 = (m0.d) r25.next();     // Catch: Throwable -> L39
        if (r26.f19949a.isAssignableFrom(r18) == true) goto L33;
    L35:
        boolean r27 = false;
    L36:
        if (r27 == false) goto L29;
        r22.add(r26.f19951c);     // Catch: Throwable -> L39
        goto L29
    L33:
        if (r19.isAssignableFrom(r26.f19950b) == false) goto L35;
        r27 = true;
        goto L36
    L41:
        monitor-exit(r21);
        android.support.v4.media.c r28 = r10.f;
        monitor-enter(r28);
    L63:
        th = move-exception;
        throw th;
    L45:
        if (r20.isAssignableFrom(r19) == false) goto L49;
        j0.a r29 = j0.c.f18219b;     // Catch: Throwable -> L63
        monitor-exit(r28);
    L62:
        r16.add(new l(r18, r19, r20, r22, r29, r10.f1397j));
        goto L18
    L49:
        Iterator r30 = ((ArrayList) r28.f367a).iterator();     // Catch: Throwable -> L63
    L51:
        if (r30.hasNext() == false) goto L66;
        j0.b r31 = (j0.b) r30.next();     // Catch: Throwable -> L63
        if (r31.f18216a.isAssignableFrom(r19) == true) goto L55;
    L57:
        boolean r32 = false;
    L58:
        if (r32 == false) goto L51;
        r29 = r31.f18218c;     // Catch: Throwable -> L63
        monitor-exit(r28);
        goto L62
    L55:
        if (r20.isAssignableFrom(r31.f18217b) == false) goto L57;
        r32 = true;
        goto L58
    L66:
        throw new IllegalArgumentException("No transcoder registered to transcode from " + r19 + " to " + r20);     // Catch: Throwable -> L63
    L39:
        th = move-exception;
        throw th;
    L72:
        if (r16.isEmpty() == false) goto L74;
        b0 r111 = null;
    L75:
        m0.c r33 = r10.f1396i;
        ArrayMap r34 = r33.f19947a;
        monitor-enter(r34);
        ArrayMap r35 = r33.f19947a;     // Catch: Throwable -> L84
        q0.g r36 = new q0.g(r18, r11, r12);     // Catch: Throwable -> L84
        if (r111 == null) goto L80;
        b0 r37 = r111;
    L81:
        r35.put(r36, r37);     // Catch: Throwable -> L84
        monitor-exit(r34);     // Catch: Throwable -> L84
        return r111;
    L80:
        r37 = m0.c.f19946c;     // Catch: Throwable -> L84
    L84:
        th = move-exception;
        throw th;
    L74:
        r111 = new b0(r18, r11, r12, r16, r10.f1397j);
        goto L75
    L88:
        return r15;
    L118:
        return null;
    L89:
        th = move-exception;
        throw th;
    }

    public final z.a d(Object r5) {
        m0.b r10 = this.f1494c.f1388b.f1393b;
        Class<?> r11 = r5.getClass();
        monitor-enter(r10);
        Iterator r12 = r10.f19945a.iterator();     // Catch: Throwable -> L12
    L6:
        if (r12.hasNext() == false) goto L14;
        m0.a r13 = (m0.a) r12.next();     // Catch: Throwable -> L12
        if (r13.f19943a.isAssignableFrom(r11) == false) goto L6;
        z.a r14 = r13.f19944b;     // Catch: Throwable -> L12
        monitor-exit(r10);
    L16:
        if (r14 == null) goto L18;
        return r14;
    L18:
        final Class<?> r15 = r5.getClass();
        throw new Registry$NoSourceEncoderAvailableException(r15);
    L14:
        monitor-exit(r10);
        r14 = null;
    L12:
        th = move-exception;
        throw th;
    }

    public final z.i e(Class r5) {
        z.i r10 = (z.i) this.f1497j.get(r5);
        if (r10 != null) goto L10;
        Iterator r11 = this.f1497j.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        Map.Entry r12 = (Map.Entry) r11.next();
        if (((Class) r12.getKey()).isAssignableFrom(r5) == false) goto L6;
        r10 = (z.i) r12.getValue();
    L10:
        if (r10 == null) goto L12;
        return r10;
    L12:
        if (this.f1497j.isEmpty() == false) goto L19;
        if (this.f1504q == false) goto L19;
        throw new IllegalArgumentException("Missing transformation for " + r5 + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    L19:
        return f0.a.f16872b;
    }
}
