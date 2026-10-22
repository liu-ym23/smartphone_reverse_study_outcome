package com.bumptech.glide;

import androidx.core.util.Pools;
import com.bumptech.glide.load.data.i;
import d0.r;
import d0.s;
import d0.t;
import d0.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import ym.p;
import z.h;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f1392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m0.b f1393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f1394c;
    public final ym.d d;
    public final i e;
    public final android.support.v4.media.c f;
    public final bd.d g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final s6.c f1395h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final m0.c f1396i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final r0.d f1397j;

    public d() {
        this.f1395h = new s6.c(13);
        this.f1396i = new m0.c();
        r0.d r5 = new r0.d(new Pools.SynchronizedPool(20), new r0.a(), new r0.b());
        this.f1397j = r5;
        this.f1392a = new u(r5);
        this.f1393b = new m0.b();
        p r10 = new p(13);
        this.f1394c = r10;
        ym.d r11 = new ym.d();
        r11.f23297a = new ArrayList();
        this.d = r11;
        this.e = new i();
        this.f = new android.support.v4.media.c(7);
        this.g = new bd.d(8);
        List r12 = Arrays.asList(new String[]{"Gif", "Bitmap", "BitmapDrawable"});
        ArrayList r13 = new ArrayList(r12.size());
        r13.addAll(r12);
        r13.add(0, "legacy_prepend_all");
        r13.add("legacy_append");
        monitor-enter(r10);
        ArrayList r14 = new ArrayList((ArrayList) r10.f23312b);     // Catch: Throwable -> L8
        ((ArrayList) r10.f23312b).clear();     // Catch: Throwable -> L8
        Iterator r15 = r13.iterator();     // Catch: Throwable -> L8
    L6:
        if (r15.hasNext() == false) goto L10;
        String r16 = (String) r15.next();     // Catch: Throwable -> L8
        ((ArrayList) r10.f23312b).add(r16);     // Catch: Throwable -> L8
        goto L6
    L10:
        Iterator r17 = r14.iterator();     // Catch: Throwable -> L8
    L11:
        if (r17.hasNext() == false) goto L17;
        String r18 = (String) r17.next();     // Catch: Throwable -> L8
        if (r13.contains(r18) == true) goto L11;
        ((ArrayList) r10.f23312b).add(r18);     // Catch: Throwable -> L8
        goto L11
    L17:
        monitor-exit(r10);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void a(Class r5, Class r10, s r11) {
        u r12 = this.f1392a;
        monitor-enter(r12);
        r12.f16569a.a(r5, r10, r11);     // Catch: Throwable -> L7
        ((HashMap) r12.f16570b.f23310b).clear();     // Catch: Throwable -> L7
        monitor-exit(r12);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void b(Class r5, z.a r10) {
        m0.b r11 = this.f1393b;
        monitor-enter(r11);
        r11.f19945a.add(new m0.a(r5, r10));     // Catch: Throwable -> L7
        monitor-exit(r11);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void c(Class r5, h r10) {
        ym.d r11 = this.d;
        monitor-enter(r11);
        ((ArrayList) r11.f23297a).add(new m0.e(r5, r10));     // Catch: Throwable -> L7
        monitor-exit(r11);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void d(String r5, Class r10, Class r11, z.g r12) {
        p r13 = this.f1394c;
        monitor-enter(r13);
        r13.n(r5).add(new m0.d(r10, r11, r12));     // Catch: Throwable -> L7
        monitor-exit(r13);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final ArrayList e() {
        bd.d r5 = this.g;
        monitor-enter(r5);
        ArrayList r10 = (ArrayList) r5.f905a;     // Catch: Throwable -> L13
        monitor-exit(r5);
        if (r10.isEmpty() == true) goto L10;
        return r10;
    L10:
        throw new Registry$NoImageHeaderParserException();
    L13:
        th = move-exception;
        throw th;
    }

    public final List f(Object r10) {
        u r11 = this.f1392a;
        r11.getClass();
        Class<?> r5 = r10.getClass();
        monitor-enter(r11);
        t r12 = (t) ((HashMap) r11.f16570b.f23310b).get(r5);     // Catch: Throwable -> L14
        if (r12 != null) goto L7;
        List r13 = null;
    L8:
        if (r13 != null) goto L16;
        r13 = Collections.unmodifiableList(r11.f16569a.c(r5));     // Catch: Throwable -> L14
        if (((t) ((HashMap) r11.f16570b.f23310b).put(r5, new t(r13))) == null) goto L16;
        throw new IllegalStateException("Already cached loaders for model: " + r5);     // Catch: Throwable -> L14
    L16:
        monitor-exit(r11);
        if (r13.isEmpty() == true) goto L33;
        int r14 = r13.size();
        List r15 = Collections.emptyList();
        boolean r16 = true;
        int r17 = 0;
    L20:
        if (r17 >= r14) goto L28;
        r r18 = (r) r13.get(r17);
        if (r18.a(r10) == false) goto L26;
        if (r16 == false) goto L25;
        r15 = new ArrayList(r14 - r17);
        r16 = false;
    L25:
        r15.add(r18);
    L26:
        r17 = r17 + 1;
        goto L20
    L28:
        if (r15.isEmpty() == true) goto L31;
        return r15;
    L31:
        throw new Registry$NoModelLoaderAvailableException(r10, r13);
    L33:
        throw new Registry$NoModelLoaderAvailableException(r10);
    L7:
        r13 = r12.f16568a;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final void g(com.bumptech.glide.load.data.f r5) {
        i r10 = this.e;
        monitor-enter(r10);
        ((HashMap) r10.f1428b).put(r5.c(), r5);     // Catch: Throwable -> L7
        monitor-exit(r10);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void h(Class r5, Class r10, j0.a r11) {
        android.support.v4.media.c r12 = this.f;
        monitor-enter(r12);
        ((ArrayList) r12.f367a).add(new j0.b(r5, r10, r11));     // Catch: Throwable -> L7
        monitor-exit(r12);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
