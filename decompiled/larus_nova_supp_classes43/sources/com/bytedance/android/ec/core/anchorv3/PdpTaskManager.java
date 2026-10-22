package com.bytedance.android.ec.core.anchorv3;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PdpTaskManager {
    public static final Handler k = null;
    public static final a l = null;
    public volatile boolean a;
    public volatile boolean b;
    public volatile boolean c;
    public volatile boolean d;
    public final List<q> e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile boolean h;
    public MessageQueue.IdleHandler i;
    public String j;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ PdpTaskManager a;

        public b(PdpTaskManager r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PdpTaskManager.d(this.a, 3, null, 6);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ PdpTaskManager a;

        public c(PdpTaskManager r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PdpTaskManager.d(this.a, 4, null, 6);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void e() {
        this.a = true;
        if (PdpMessageOpt.b() == true) goto L5;
        f(new PdpTaskManager$endReportFirstFrame$1(this));
        return;
    L5:
        f(new PdpTaskManager$endReportFirstFrame$2(this));
    }

    static {
        l = new a();
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("PdpAsyncTask");
        ThreadMethodProxy.start(r0);
        k = new Handler(r0.getLooper());
    }

    public PdpTaskManager() {
        this.e = new ArrayList();
    }

    public static void f(Runnable r10) {
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == false) goto L5;
        r10.run();
        return;
    L5:
        Lazy r0 = UIUtils.a;
        UIUtils.c().post(r10);
    }

    public final void b(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.j = r10;
        boolean r0 = PdpMessageOpt.a;
        Function1<Boolean, Unit> r1 = new PdpTaskManager$configSessionId$1(this);
        Intrinsics.checkNotNullParameter(r1, "endCallback");
        if (Intrinsics.areEqual(r10, PdpMessageOpt.c) == false) goto L10;
        BasePdpMessageOptWorker r11 = PdpMessageOpt.d;
        if (r11 == null) goto L11;
        Intrinsics.checkNotNullParameter(r1, "callback");
        ((ArrayList) r11.e).add(r1);
        return;
    L11:
        return;
    }

    public final synchronized void g(q r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "task");     // Catch: Throwable -> L9
        if (this.b == false) goto L6;
        r10.a();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        a(r10, 0);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void h(q r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "task");     // Catch: Throwable -> L9
        if (this.d == false) goto L6;
        r10.a();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        a(r10, 2);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final void a(q r1, int r10) {
        monitor-enter(this);
        r1.d = r10;     // Catch: Throwable -> L6
        ((ArrayList) this.e).add(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void i(q r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "task");
        if (r11 == false) goto L5;
    L6:
        if (r11 == true) goto L8;
    L10:
        if (r11 == false) goto L12;
        a(r10, 4);
    L14:
        if (this.h == false) goto L17;
        f(new b(this));
    L17:
        if (this.g == false) goto L21;
        f(new c(this));
        return;
    L21:
        return;
    L12:
        a(r10, 3);
        goto L14
    L8:
        if (this.g == false) goto L10;
    L9:
        r10.a();
        return;
    L5:
        if (this.h == true) goto L9;
        goto L6
    }

    public final void c(int r10, Function1<? super q, Unit> r11, Function0<Unit> r12) {
        ArrayList r0 = new ArrayList();
        monitor-enter(this);
        Iterator r1 = ((ArrayList) this.e).iterator();     // Catch: Throwable -> L22
    L6:
        if (r1.hasNext() == false) goto L10;
        q r13 = (q) r1.next();     // Catch: Throwable -> L22
        if (r13.d != r10) goto L6;
        r0.add(r13);     // Catch: Throwable -> L22
        r1.remove();     // Catch: Throwable -> L22
        goto L6
    L10:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(this);
        Iterator r15 = r0.iterator();
    L14:
        if (r15.hasNext() == false) goto L19;
        q r16 = (q) r15.next();
        if (r11 != null) goto L17;
        r16.a();
        goto L14
    L17:
        r11.invoke(r16);
        goto L14
    L19:
        if (r12 == null) goto L38;
        Unit r17 = (Unit) r12.invoke();
        return;
    L38:
        return;
    L22:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(PdpTaskManager r1, int r10, Function0 r11, int r12) {
        if ((r12 & 4) == 0) goto L5;
        r11 = null;
    L5:
        r1.c(r10, null, r11);
    }
}
