package com.bumptech.glide.load.engine;

import androidx.collection.ArrayMap;
import com.bumptech.glide.load.DataSource;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class e0 implements f, com.bumptech.glide.load.data.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f1481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f1482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1483c;
    public int d;
    public z.c e;
    public List f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile d0.q f1484h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public File f1485i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f0 f1486j;

    public e0(g r5, k r10) {
        this.d = -1;
        this.f1482b = r5;
        this.f1481a = r10;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void a(Exception r5) {
        this.f1481a.a(this.f1486j, r5, this.f1484h.f16567c, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.f
    public final boolean b() {
        ArrayList r5 = this.f1482b.a();
        boolean r10 = false;
        if (r5.isEmpty() == false) goto L5;
        return false;
    L5:
        g r11 = this.f1482b;
        com.bumptech.glide.d r12 = r11.f1494c.f1388b;
        Class<?> r13 = r11.d.getClass();
        Class r14 = r11.g;
        Class r15 = r11.f1498k;
        s6.c r16 = r12.f1395h;
        q0.g r17 = (q0.g) ((AtomicReference) r16.f21828b).getAndSet(null);
        if (r17 != null) goto L8;
        r17 = new q0.g(r13, r14, r15);
    L9:
        ArrayMap r18 = (ArrayMap) r16.f21829c;
        monitor-enter(r18);
        List r19 = (List) ((ArrayMap) r16.f21829c).get(r17);     // Catch: Throwable -> L71
        monitor-exit(r18);     // Catch: Throwable -> L71
        ((AtomicReference) r16.f21828b).set(r17);
        List r110 = r19;
        if (r19 != null) goto L42;
        ArrayList r111 = new ArrayList();
        d0.u r20 = r12.f1392a;
        monitor-enter(r20);
        ArrayList r21 = r20.f16569a.d(r13);     // Catch: Throwable -> L38
        monitor-exit(r20);
        Iterator r22 = r21.iterator();
    L21:
        if (r22.hasNext() == false) goto L30;
        Iterator r23 = r12.f1394c.o((Class) r22.next(), r14).iterator();
    L24:
        if (r23.hasNext() == false) goto L21;
        Class r112 = (Class) r23.next();
        if (r12.f.g(r112, r15).isEmpty() == true) goto L24;
        if (r111.contains(r112) == true) goto L24;
        r111.add(r112);
        goto L24
    L30:
        s6.c r24 = r12.f1395h;
        List r25 = Collections.unmodifiableList(r111);
        ArrayMap r26 = (ArrayMap) r24.f21829c;
        monitor-enter(r26);
        ((ArrayMap) r24.f21829c).put(new q0.g(r13, r14, r15), r25);     // Catch: Throwable -> L35
        monitor-exit(r26);     // Catch: Throwable -> L35
        r110 = r111;
    L35:
        th = move-exception;
        throw th;
    L38:
        th = move-exception;
        throw th;
    L42:
        if (r110.isEmpty() == true) goto L44;
    L48:
        List r27 = this.f;
        if (r27 != null) goto L51;
    L62:
        int r28 = this.d + 1;
        this.d = r28;
        if (r28 < r110.size()) goto L68;
        int r29 = this.f1483c + 1;
        this.f1483c = r29;
        if (r29 >= r5.size()) goto L66;
        this.d = 0;
        goto L68
    L66:
        return false;
    L68:
        z.c r30 = (z.c) r5.get(this.f1483c);
        Class r31 = (Class) r110.get(this.d);
        z.i r113 = this.f1482b.e(r31);
        g r32 = this.f1482b;
        this.f1486j = new f0(r32.f1494c.f1387a, r30, r32.f1501n, r32.e, r32.f, r113, r31, r32.f1496i);
        File r33 = r32.f1495h.a().h(this.f1486j);
        this.f1485i = r33;
        if (r33 == null) goto L48;
        this.e = r30;
        this.f = this.f1482b.f1494c.f1388b.f(r33);
        this.g = 0;
        goto L48
    L51:
        if (this.g >= r27.size()) goto L62;
        this.f1484h = null;
    L53:
        if (r10 == true) goto L61;
        if (this.g >= this.f.size()) goto L61;
        List r34 = this.f;
        int r35 = this.g;
        this.g = r35 + 1;
        d0.r r36 = (d0.r) r34.get(r35);
        File r37 = this.f1485i;
        g r38 = this.f1482b;
        this.f1484h = r36.b(r37, r38.e, r38.f, r38.f1496i);
        if (this.f1484h == null) goto L53;
        if (this.f1482b.c(this.f1484h.f16567c.c()) == null) goto L53;
        this.f1484h.f16567c.e(this.f1482b.f1502o, this);
        r10 = true;
    L61:
        return r10;
    L44:
        if (File.class.equals(this.f1482b.f1498k) == false) goto L47;
        return false;
    L47:
        throw new IllegalStateException("Failed to find any load path from " + this.f1482b.d.getClass() + " to " + this.f1482b.f1498k);
    L71:
        th = move-exception;
        throw th;
    L8:
        r17.f21455a = r13;
        r17.f21456b = r14;
        r17.f21457c = r15;
        goto L9
    }

    @Override // com.bumptech.glide.load.engine.f
    public final void cancel() {
        d0.q r5 = this.f1484h;
        if (r5 == null) goto L6;
        r5.f16567c.cancel();
        return;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void f(Object r10) {
        this.f1481a.c(this.e, r10, this.f1484h.f16567c, DataSource.RESOURCE_DISK_CACHE, this.f1486j);
    }
}
