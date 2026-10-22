package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"CheckResult"})
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f5899a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static IBinder f5900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static f9.a f5901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f5902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f5903e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Handler f5904f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f5905g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Runnable f5906h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Set<j> f5907i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final CopyOnWriteArraySet<c> f5908j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f5909k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final a f5910l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Runnable f5911m = null;

    public static final class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        @SuppressLint({"CheckResult"})
        public void onServiceConnected(ComponentName r10, IBinder r11) {
            Intrinsics.checkNotNullParameter(r11, "service");
            e9.b.d("MatrixBinderManager", "onServiceConnected() called with: name = " + r10 + ", service = " + r11 + " this = " + this, null, 4, null);
            i r12 = i.f5899a;
            r12.s(false);
            r12.t(r11);
            r12.r(f9.a.AbstractBinderC0167a.U0(r11));
            f9.a r13 = r12.k();
            if (r13 != null) goto L14;
        L12:
            i r14 = i.f5899a;
            f9.a r15 = r14.k();
            Intrinsics.checkNotNull(r15);
            r14.g(r15);
            i.d(r14, true);
            return;
        L14:
            e r16 = new e();     // Catch: Exception -> L10
            Context r17 = z8.c.f13804a.e();     // Catch: Exception -> L10
            if (r17 == null) goto L7;
            String r18 = r17.getPackageName();     // Catch: Exception -> L10
        L8:
            r13.z1(r18, r16);     // Catch: Exception -> L10
            e9.b.b("MatrixBinderManager", "registerServerCallback for " + Binder.getCallingPid() + " and binder is " + r16.asBinder() + " and service is " + r11, null, 4, null);     // Catch: Exception -> L10
            goto L12
        L7:
            r18 = null;
        L10:
            e = move-exception;
            e9.b.d("MatrixBinderManager", "registerServerCallback exception " + e.getMessage(), null, 4, null);
            goto L12
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r10) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            StringBuilder r11 = new StringBuilder();
            r11.append("MatrixCallBinder  onServiceDisconnected  isBinding ");
            i r12 = i.f5899a;
            r11.append(r12.o());
            r11.append(", bind = ");
            r11.append(r12.k());
            e9.b.b("MatrixBinderManager", r11.toString(), null, 4, null);
            r12.s(false);
            r12.r(null);
            r12.t(null);
            e9.b.d("MatrixBinderManager", "onServiceDisconnected() called with: name = " + r10 + " this = " + this, null, 4, null);
            r12.m().removeCallbacks(i.c());
            r12.m().postDelayed(i.c(), r12.l());
            r12.f(r10);
        }
    }

    static {
        f5899a = new i();
        f5903e = WsConstants.EXIT_DELAY_TIME;
        f5904f = new Handler(Looper.getMainLooper());
        f5906h = h.f5898c;
        f5907i = new LinkedHashSet();
        f5908j = new CopyOnWriteArraySet();
        f5910l = new a();
        f5911m = g.f5897c;
    }

    private i() {
    }

    public static /* synthetic */ void a() {
        j();
    }

    public static /* synthetic */ void b() {
        q();
    }

    public static final /* synthetic */ Runnable c() {
        return f5911m;
    }

    public static final /* synthetic */ void d(i r10, boolean r11) {
        r10.p(r11);
    }

    private final synchronized void e(j r10) {
        monitor-enter(this);
        if (r10 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        f5907i.add(r10);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void i(i r10, j r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = null;
    L5:
        r10.h(r11);
    }

    private static final void j() {
        StringBuilder r10 = new StringBuilder();
        r10.append("CallBinder post delay in handler bind = ");
        i r11 = f5899a;
        r10.append(r11.k());
        r10.append(", isBinding = ");
        r10.append(f5905g);
        e9.b.b("MatrixBinderManager", r10.toString(), null, 4, null);
        if (r11.k() != null) goto L6;
        f5905g = false;
        f5906h.run();
        return;
    }

    private final synchronized void p(boolean r10) {
        monitor-enter(this);
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L10
        r11.append("onConnectCallbackResult isconnected ");     // Catch: Throwable -> L10
        r11.append(r10);     // Catch: Throwable -> L10
        r11.append(' ');     // Catch: Throwable -> L10
        Set<j> r12 = f5907i;     // Catch: Throwable -> L10
        r11.append(r12.size());     // Catch: Throwable -> L10
        e9.b.b("MatrixBinderManager", r11.toString(), null, 4, null);     // Catch: Throwable -> L10
        Iterator<T> r13 = r12.iterator();     // Catch: Throwable -> L10
    L5:
        if (r13.hasNext() == false) goto L7;
        ((j) r13.next()).a(r10);     // Catch: Throwable -> L10
        goto L5
    L7:
        f5907i.clear();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static final void q() {
        i r10 = f5899a;
        f5905g = false;
        i(r10, null, 1, null);
        e9.b.b("MatrixBinderManager", "called reConnectRunnable", null, 4, null);
        f5902d = f5903e;
    }

    public final synchronized void f(ComponentName r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);     // Catch: Throwable -> L6
        f5909k = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void g(f9.a r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "binder");     // Catch: Throwable -> L8
        if (f5909k == true) goto L6;
        f5909k = true;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized void h(j r10) {
        monitor-enter(this);
        e9.b.b("MatrixBinderManager", "start connect binder isbinding " + f5905g, null, 4, null);     // Catch: Throwable -> L32
        z8.c r11 = z8.c.f13804a;     // Catch: Throwable -> L32
        r11.b();     // Catch: Throwable -> L32
        e(r10);     // Catch: Exception -> L35 Throwable -> L32
        if (f5905g == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (k() == null) goto L21;
        IBinder r12 = f5900b;     // Catch: Exception -> L35 Throwable -> L32
        if (r12 == null) goto L21;
        if (r12 != null) goto L14;
    L16:
        boolean r13 = false;
    L17:
        if (r13 == false) goto L21;
        e9.b.b("MatrixBinderManager", "binder alive , don't need rebind", null, 4, null);     // Catch: Exception -> L35 Throwable -> L32
        p(true);     // Catch: Exception -> L35 Throwable -> L32
        monitor-exit(this);
        return;
    L14:
        if (r12.isBinderAlive() != true) goto L16;
        r13 = true;
    L21:
        f5905g = true;     // Catch: Exception -> L35 Throwable -> L32
        Intent r14 = new Intent();     // Catch: Exception -> L35 Throwable -> L32
        r14.setComponent(new ComponentName("com.obric.matrix", "com.obric.matrix.server.MatrixServer"));     // Catch: Exception -> L35 Throwable -> L32
        Context r15 = r11.e();     // Catch: Exception -> L35 Throwable -> L32
        if (r15 == null) goto L24;
        Boolean r16 = Boolean.valueOf(r15.bindService(r14, f5910l, 1));     // Catch: Exception -> L35 Throwable -> L32
    L25:
        d9.a.f8514a.a(r16);     // Catch: Exception -> L35 Throwable -> L32
        if (Intrinsics.areEqual(r16, Boolean.TRUE) == true) goto L28;
        e9.b.d("MatrixBinderManager", "CallBinder call reConnect bind result = " + r16, null, 4, null);     // Catch: Exception -> L35 Throwable -> L32
        Handler r17 = f5904f;     // Catch: Exception -> L35 Throwable -> L32
        Runnable r18 = f5911m;     // Catch: Exception -> L35 Throwable -> L32
        r17.removeCallbacks(r18);     // Catch: Exception -> L35 Throwable -> L32
        f5904f.postDelayed(r18, f5902d);     // Catch: Exception -> L35 Throwable -> L32
        p(false);     // Catch: Exception -> L35 Throwable -> L32
    L29:
        e9.b.b("MatrixBinderManager", "initBinder: bindResult = " + r16, null, 4, null);     // Catch: Exception -> L35 Throwable -> L32
        goto L30
    L28:
        Handler r19 = f5904f;     // Catch: Exception -> L35 Throwable -> L32
        Runnable r20 = f5911m;     // Catch: Exception -> L35 Throwable -> L32
        r19.removeCallbacks(r20);     // Catch: Exception -> L35 Throwable -> L32
        f5904f.postDelayed(r20, f5903e);     // Catch: Exception -> L35 Throwable -> L32
        goto L29
    L24:
        r16 = null;
    L30:
        monitor-exit(this);
        return;
    L32:
        th = move-exception;
        throw th;
    }

    public final f9.a k() {
        z8.c.f13804a.b();
        return f5901c;
    }

    public final long l() {
        return f5902d;
    }

    public final Handler m() {
        return f5904f;
    }

    public final CopyOnWriteArraySet<c> n() {
        return f5908j;
    }

    public final boolean o() {
        return f5905g;
    }

    public final void r(f9.a r10) {
        f5901c = r10;
    }

    public final void s(boolean r10) {
        f5905g = r10;
    }

    public final void t(IBinder r10) {
        f5900b = r10;
    }
}
