package com.obric.aiagent.flow.applog;

import android.os.Handler;
import com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class FlowAppLog {
    public static final FlowAppLog a = null;
    public static IFlowAppLogIDL b;
    public static volatile boolean c;
    public static volatile boolean d;
    public static final long e = 0;
    public static final Handler f = null;
    public static final q9a.a g = null;
    public static final a<String> h = null;

    public static final class a<T> {
        public final int a;
        public final List<T> b;

        public a(int r1) {
            this.a = r1;
            this.b = Collections.synchronizedList(new ArrayList());
        }

        public final void a(T r3) {
            List<T> r0 = this.b;
            monitor-enter(r0);
            this.b.add(r3);     // Catch: Throwable -> L11
        L6:
            if (this.b.size() <= this.a) goto L8;
            CollectionsKt.removeFirst(this.b);     // Catch: Throwable -> L11
            goto L6
        L8:
            Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r0);
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    public FlowAppLog() {
    }

    public static void b() {
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [q9a.a] */
    static {
        a = new FlowAppLog();
        e = -1;
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("FlowAppLog");
        ThreadMethodProxy.start(r0);
        f = new Handler(r0.getLooper());
        g = new q9a.a();
        new a(10);
        new a(100);
        h = new a(5000);
        new a(5000);
        new a(5000);
        new a(100);
        new dataObserver.1();
    }

    public static void c() {
        if (c == false) goto L5;
    L9:
        ILogDepend.a.i("FlowAppLog", "has binded or binding, skip executeBind, onBindSuccess: " + c + ", isBinding: " + d);
        return;
    L5:
        if (d == true) goto L9;
        ILogDepend.a.i("FlowAppLog", "context is null, skip executeBind");
    }

    public static void d() {
        if (c == true) goto L5;
        return;
    L5:
        a("safeUnbind");
        b = null;
        c = false;
        d = false;
        b();
    }

    public static void a(String r3) {
        f.removeCallbacks(g);
        ILogDepend.a.i("FlowAppLog", "cancelAutoUnbindLocked, reason: " + r3);
    }

    public static void e(String r5) {
        long r0 = e;
        a("reschedule: ".concat(r5));
        if (r0 > 0) goto L5;
        return;
    L5:
        if (c == false) goto L10;
        f.postDelayed(g, r0);
        ILogDepend.a.i("FlowAppLog", "scheduleAutoUnbindLocked, delayMs: " + r0 + ", reason: " + r5);
        return;
    }

    public final void onEventV3(String r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        monitor-enter(this);
    L16:
        e = move-exception;
        ILogDepend.a.e("FlowAppLog", "onEventV3 error", e);     // Catch: Throwable -> L14
    L21:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L5:
        if (c == false) goto L18;
        IFlowAppLogIDL r0 = b;     // Catch: Throwable -> L14 Exception -> L16
        if (r0 == null) goto L18;
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L14 Exception -> L16
        if (r0.asBinder().isBinderAlive() == false) goto L18;
        IFlowAppLogIDL r1 = b;     // Catch: Throwable -> L14 Exception -> L16
        if (r1 == null) goto L13;
        r1.onEventV3(r4);     // Catch: Throwable -> L14 Exception -> L16
    L13:
        a.getClass();     // Catch: Throwable -> L14 Exception -> L16
        e("onEventV3");     // Catch: Throwable -> L14 Exception -> L16
    L18:
        h.a(r4);     // Catch: Throwable -> L14 Exception -> L16
        a.getClass();     // Catch: Throwable -> L14 Exception -> L16
        c();     // Catch: Throwable -> L14 Exception -> L16
    L14:
        th = move-exception;
        throw th;
    }
}
