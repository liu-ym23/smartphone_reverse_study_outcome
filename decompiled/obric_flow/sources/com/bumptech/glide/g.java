package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.load.engine.m;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import k0.h;
import q0.i;

/* JADX INFO: loaded from: classes.dex */
public final class g implements ComponentCallbacks2, k0.d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final com.bumptech.glide.request.c f1406l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f1407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k0.c f1409c;
    public final c5.a d;
    public final k0.g e;
    public final h f;
    public final a6.a g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handler f1410h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final k0.a f1411i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CopyOnWriteArrayList f1412j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bumptech.glide.request.c f1413k;

    static {
        com.bumptech.glide.request.c r5 = (com.bumptech.glide.request.c) new com.bumptech.glide.request.c().c(Bitmap.class);
        r5.f1681m = true;
        f1406l = r5;
        ((com.bumptech.glide.request.c) new com.bumptech.glide.request.c().c(GifDrawable.class)).f1681m = true;
        m r10 = m.f1545c;
        com.bumptech.glide.request.c r11 = (com.bumptech.glide.request.c) ((com.bumptech.glide.request.c) ((com.bumptech.glide.request.c) new com.bumptech.glide.request.c().e(r10)).j(Priority.LOW)).n();
    }

    public g(b r10, k0.c r11, k0.g r12, Context r13) {
        c5.a r5 = new c5.a(8);
        s6.b r14 = r10.g;
        this.f = new h();
        a6.a r15 = new a6.a(this, 4);
        this.g = r15;
        Handler r16 = new Handler(Looper.getMainLooper());
        this.f1410h = r16;
        this.f1407a = r10;
        this.f1409c = r11;
        this.e = r12;
        this.d = r5;
        this.f1408b = r13;
        Context r17 = r13.getApplicationContext();
        q7.a r18 = new q7.a(2, this, r5);
        r14.getClass();
        boolean r19 = false;
        if (ContextCompat.checkSelfPermission(r17, "android.permission.ACCESS_NETWORK_STATE") != 0) goto L5;
        boolean r20 = true;
    L7:
        if (Log.isLoggable("ConnectivityMonitor", 3) == false) goto L12;
        if (r20 == false) goto L10;
        String r21 = "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor";
    L11:
        Log.d("ConnectivityMonitor", r21);
        goto L12
    L10:
        r21 = "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
    L12:
        if (r20 == false) goto L14;
        k0.a r22 = new k0.b(r17, r18);
    L15:
        this.f1411i = r22;
        char[] r110 = i.f21459a;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L18;
        r19 = true;
    L18:
        if (r19 == true) goto L20;
        r16.post(r15);
    L21:
        r11.c(r22);
        this.f1412j = new CopyOnWriteArrayList(r10.f1384c.e);
        c r23 = r10.f1384c;
        monitor-enter(r23);
    L26:
        th = move-exception;
        throw th;
    L24:
        if (r23.f1391i != null) goto L28;
        r23.d.getClass();     // Catch: Throwable -> L26
        com.bumptech.glide.request.c r111 = new com.bumptech.glide.request.c();     // Catch: Throwable -> L26
        r111.f1681m = true;     // Catch: Throwable -> L26
        r23.f1391i = r111;     // Catch: Throwable -> L26
    L28:
        com.bumptech.glide.request.c r112 = r23.f1391i;     // Catch: Throwable -> L26
        monitor-exit(r23);
        monitor-enter(this);
        com.bumptech.glide.request.c r24 = (com.bumptech.glide.request.c) r112.b();     // Catch: Throwable -> L53
        if (r24.f1681m == true) goto L34;
    L38:
        r24.f1682n = true;     // Catch: Throwable -> L53
        r24.f1681m = true;     // Catch: Throwable -> L53
        this.f1413k = r24;     // Catch: Throwable -> L53
        monitor-exit(this);
        ArrayList r25 = r10.f1385h;
        monitor-enter(r25);
    L47:
        th = move-exception;
        throw th;
    L43:
        if (r10.f1385h.contains(this) == true) goto L50;
        r10.f1385h.add(this);     // Catch: Throwable -> L47
        monitor-exit(r25);     // Catch: Throwable -> L47
        return;
    L50:
        throw new IllegalStateException("Cannot register already registered manager");     // Catch: Throwable -> L47
    L34:
        if (r24.f1682n == true) goto L38;
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        throw th;
    L20:
        r11.c(this);
        goto L21
    L14:
        r22 = new k0.e();
        goto L15
    L5:
        r20 = false;
        goto L7
    }

    @Override // k0.d
    public final synchronized void i() {
        monitor-enter(this);
        k();     // Catch: Throwable -> L6
        this.f.i();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void j(n0.d r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        boolean r10 = m(r5);
        com.bumptech.glide.request.b r11 = r5.e();
        if (r10 == true) goto L29;
        b r12 = this.f1407a;
        ArrayList r13 = r12.f1385h;
        monitor-enter(r13);
        Iterator r14 = r12.f1385h.iterator();     // Catch: Throwable -> L15
    L10:
        if (r14.hasNext() == false) goto L17;
        if (((g) r14.next()).m(r5) == false) goto L10;
        monitor-exit(r13);     // Catch: Throwable -> L15
    L23:
        return;
    L17:
        monitor-exit(r13);     // Catch: Throwable -> L15
        if (r11 == null) goto L23;
        r5.g(null);
        ((com.bumptech.glide.request.d) r11).c();
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized void k() {
        monitor-enter(this);
        c5.a r5 = this.d;     // Catch: Throwable -> L22
        r5.f1118b = true;     // Catch: Throwable -> L22
        Iterator r10 = i.d((Set) r5.d).iterator();     // Catch: Throwable -> L22
    L5:
        if (r10.hasNext() == false) goto L20;
        com.bumptech.glide.request.d r11 = (com.bumptech.glide.request.d) ((com.bumptech.glide.request.b) r10.next());     // Catch: Throwable -> L22
        if (r11.g() == false) goto L5;
        Object r12 = r11.f1687c;     // Catch: Throwable -> L22
        monitor-enter(r12);     // Catch: Throwable -> L22
        if (r11.g() == false) goto L15;
        r11.c();     // Catch: Throwable -> L13
    L15:
        monitor-exit(r12);     // Catch: Throwable -> L13
        ((ArrayList) r5.f1119c).add(r11);     // Catch: Throwable -> L22
        goto L5
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L20:
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public final synchronized void l() {
        monitor-enter(this);
        c5.a r5 = this.d;     // Catch: Throwable -> L14
        r5.f1118b = false;     // Catch: Throwable -> L14
        Iterator r10 = i.d((Set) r5.d).iterator();     // Catch: Throwable -> L14
    L5:
        if (r10.hasNext() == false) goto L11;
        com.bumptech.glide.request.d r11 = (com.bumptech.glide.request.d) ((com.bumptech.glide.request.b) r10.next());     // Catch: Throwable -> L14
        if (r11.f() == true) goto L5;
        if (r11.g() == true) goto L5;
        r11.a();     // Catch: Throwable -> L14
        goto L5
    L11:
        ((ArrayList) r5.f1119c).clear();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean m(n0.d r5) {
        monitor-enter(this);
        com.bumptech.glide.request.b r10 = r5.e();     // Catch: Throwable -> L13
        if (r10 != null) goto L9;
        monitor-exit(this);
        return true;
    L9:
        if (this.d.c(r10) == false) goto L15;
        this.f.f18578a.remove(r5);     // Catch: Throwable -> L13
        r5.g(null);     // Catch: Throwable -> L13
        monitor-exit(this);
        return true;
    L15:
        monitor-exit(this);
        return false;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r5) {
    }

    @Override // k0.d
    public final synchronized void onDestroy() {
        monitor-enter(this);
        this.f.onDestroy();     // Catch: Throwable -> L7
        Iterator r5 = i.d(this.f.f18578a).iterator();     // Catch: Throwable -> L7
    L5:
        if (r5.hasNext() == false) goto L9;
        j((n0.d) r5.next());     // Catch: Throwable -> L7
        goto L5
    L9:
        this.f.f18578a.clear();     // Catch: Throwable -> L7
        c5.a r10 = this.d;     // Catch: Throwable -> L7
        Iterator r11 = i.d((Set) r10.d).iterator();     // Catch: Throwable -> L7
    L11:
        if (r11.hasNext() == false) goto L13;
        r10.c((com.bumptech.glide.request.b) r11.next());     // Catch: Throwable -> L7
        goto L11
    L13:
        ((ArrayList) r10.f1119c).clear();     // Catch: Throwable -> L7
        this.f1409c.e(this);     // Catch: Throwable -> L7
        this.f1409c.e(this.f1411i);     // Catch: Throwable -> L7
        this.f1410h.removeCallbacks(this.g);     // Catch: Throwable -> L7
        b r12 = this.f1407a;     // Catch: Throwable -> L7
        ArrayList r13 = r12.f1385h;     // Catch: Throwable -> L7
        monitor-enter(r13);     // Catch: Throwable -> L7
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L7
    L16:
        if (r12.f1385h.contains(this) == false) goto L24;
        r12.f1385h.remove(this);     // Catch: Throwable -> L21
        monitor-exit(r13);     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L24:
        throw new IllegalStateException("Cannot unregister not yet registered manager");     // Catch: Throwable -> L21
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // k0.d
    public final synchronized void onStart() {
        monitor-enter(this);
        l();     // Catch: Throwable -> L6
        this.f.onStart();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int r5) {
    }

    public final synchronized String toString() {
        monitor-enter(this);
        String r5 = super.toString() + "{tracker=" + this.d + ", treeNode=" + this.e + "}";     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }
}
