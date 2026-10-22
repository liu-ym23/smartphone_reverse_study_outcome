package com.obric.aikernel.middleware.api.appcontext.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.obric.aikernel.middleware.api.log.AIKLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.q1;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f4534a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4535b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f4536c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<a> f4537d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static AtomicLong f4538e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final g1<Boolean> f4539f = null;

    public interface a {
        void a(boolean r10);
    }

    static {
        d r10 = new d();
        f4534a = r10;
        f4535b = "NetWindowListener";
        f4536c = "com.android.server.power.NET_WINDOW_ALLOW";
        f4537d = new ArrayList();
        f4538e = new AtomicLong(-1);
        f4539f = q1.a(Boolean.valueOf(r10.e()));
    }

    private d() {
    }

    public static /* synthetic */ void a() {
        f();
    }

    private final void b() {
        boolean r10 = e();
        AIKLog.INSTANCE.i(f4535b, "broadcast netwindow allow=" + r10);
        List<a> r11 = f4537d;
        monitor-enter(r11);
        Iterator<a> r12 = r11.iterator();     // Catch: Throwable -> L12
    L6:
        if (r12.hasNext() == false) goto L8;
        r12.next().a(r10);     // Catch: Throwable -> L12
        goto L6
    L8:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r11);
        f4539f.setValue(Boolean.valueOf(r10));
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private static final void f() {
        f4534a.b();
    }

    public final g1<Boolean> c() {
        return f4539f;
    }

    public final void d(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        IntentFilter r11 = new IntentFilter();
        r11.addAction(f4536c);
        r10.registerReceiver(f4534a, r11, 4);
    }

    public final boolean e() {
        if (SystemClock.elapsedRealtime() >= f4538e.get()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        if (r11 == null) goto L6;
        Bundle r12 = r11.getExtras();
        if (r12 == null) goto L6;
        boolean r13 = r12.getBoolean("allow");
    L8:
        if (r11 == null) goto L12;
        Bundle r14 = r11.getExtras();
        if (r14 == null) goto L12;
        long r15 = r14.getLong("window_duration");
    L13:
        AIKLog.INSTANCE.i(f4535b, "on receive netwindow " + r13 + ", " + r15);
        long r16 = SystemClock.elapsedRealtime() + r15;
        if (r13 == true) goto L16;
    L23:
        f4538e.set(-1);
    L24:
        b();
        return;
    L16:
        if (r15 <= 0) goto L23;
        if (f4538e.get() >= r16) goto L23;
        f4538e.set(r16);
        Looper r17 = Looper.myLooper();
        if (r17 != null) goto L22;
        r17 = Looper.getMainLooper();
    L22:
        new Handler(r17).postDelayed(c.f4533c, r15 + ((long) 100));
    L12:
        r15 = -1;
    L6:
        r13 = true;
        goto L8
    }
}
