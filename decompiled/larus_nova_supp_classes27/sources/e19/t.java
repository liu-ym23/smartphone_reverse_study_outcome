package e19;

import android.os.Handler;
import android.view.View;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.floatwindow.manager.FloatPriority;
import com.larus.common_ui.floatwindow.view.SingleFloatWindowState;
import com.larus.utils.logger.FLogger;
import hq9.f1;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t implements i {
    public static t j;
    public final Lazy a;
    public final k b;
    public final com.larus.common_ui.floatwindow.view.c c;
    public boolean d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;

    public static final class a {
        public static t a() {
            if (t.j != null) goto L16;
            monitor-enter(t.class);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (t.j != null) goto L9;
            t.j = new t();     // Catch: Throwable -> L12
        L9:
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(t.class);
        L16:
            return t.j;
        }
    }

    public static final class b {
        public final SingleFloatWindowState a;
        public final boolean b;
        public final long c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L6:
            int r2 = (r0 + r1) * 31;
            long r3 = this.c;
            return r2 + ((int) (r3 ^ (r3 >>> 32)));
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "RequestFloatWindowRequirement(targetWindowState=" + this.a + ", animateIfRequired=" + this.b + ", autoShrinkDelayTime=" + this.c + ')';
        }

        public b(SingleFloatWindowState r2, boolean r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, "targetWindowState");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
    }

    public final void b() {
        if (this.d == false) goto L5;
        return;
    L5:
        FLogger r0 = FLogger.a;
        r0.d("MutexFloatManager", "alphaShowFloatWindow.");
        com.larus.common_ui.floatwindow.view.c r1 = this.c;
        r1.c.e();
        r1.d = true;
        r0.d("FloatController", "alphaShowFloatWindow");
        this.d = true;
        h r2 = this.b.a;
        if (r2 == null) goto L9;
        r2.onWindowShow();
        return;
    }

    public final f1 f() {
        return (f1) this.a.getValue();
    }

    public final ConcurrentHashMap<h, b> g() {
        return (ConcurrentHashMap) this.e.getValue();
    }

    public final void h() {
        if (this.b.a == null) goto L6;
        FLogger.a.i("MutexFloatManager", "handleNextRequest ignored due to current");
        return;
    L6:
        FLogger.a.d("MutexFloatManager", "handleNextRequest.");
        i(this.b.b.poll());
    }

    public final void l() {
        h r0 = this.b.a;
        if (r0 == null) goto L5;
        FLogger.a.d("MutexFloatManager", "removeCurrentRequest. contentView:" + r0.getContentView());
        this.c.a(r0.getContentView());
        r0.a();
        b r1 = g().remove(r0);
    L5:
        this.b.a = null;
    }

    public t() {
        this.a = LazyKt.lazy(new m());
        this.b = new k();
        this.c = new com.larus.common_ui.floatwindow.view.c(AppHost.a.getApplication());
        this.e = LazyKt.lazy(new n());
        this.f = LazyKt.lazy(new o(this));
        this.g = LazyKt.lazy(new p());
        this.h = LazyKt.lazy(new q());
        this.i = LazyKt.lazy(new r());
    }

    public final void d(final h r7) {
        this.b.a = r7;
        if (r7 == null) goto L29;
        SingleFloatWindowState r0 = null;
        k(null);
        FLogger.a.d("MutexFloatManager", "handleRequest. contentView:" + r7.getContentView() + " width:" + r7.getWidth() + " height:" + r7.getHeight());
        b r1 = g().get(r7);
        if (r1 != null) goto L7;
        r1 = null;
    L12:
        g().remove(r7);
        this.c.b(r7.n0());
        com.larus.common_ui.floatwindow.view.c r2 = this.c;
        if (r1 == null) goto L15;
        r0 = r1.a;
    L15:
        if (r1 == null) goto L17;
        boolean r3 = r1.b;
    L18:
        r2.c(r7, r0, r3);
        r7.b();
        if (r7.n0() == true) goto L32;
        if (r1 == null) goto L30;
        long r4 = Long.valueOf(r1.c).longValue();
        if (r4 > 0) goto L25;
        return;
    L25:
        if (r1.a != SingleFloatWindowState.MAXIMIZE) goto L33;
        Runnable r5 = new s(this, r7);
        ((Map) this.i.getValue()).put(r7, r5);
        ((Handler) this.h.getValue()).postDelayed(r5, r4);
        return;
    L33:
        return;
    L30:
        return;
    L32:
        return;
    L17:
        r3 = false;
        goto L18
    L7:
        if (f().c() == false) goto L12;
        if (f().f() == false) goto L12;
        ((List) this.f.getValue()).add(r7.k());
        goto L12
    }

    public final int e(h r18) {
        Intrinsics.checkNotNullParameter(r18, "request");
        FLogger r2 = FLogger.a;
        r2.d("MutexFloatManager", "enqueueRequest. contentView:" + r18.getContentView());
        boolean r6 = false;
        if (this.b.b.size() < 128) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L9;
    L78:
        r2.d("MutexFloatManager", "enqueueRequest same.");
        h r4 = this.b.a;
        if (r4 == null) goto L82;
        r2.d("MutexFloatManager", "enqueueRequest updateView. currentView:" + r4.getContentView() + " width:" + r4.getWidth() + " height:" + r4.getHeight());
        this.c.b(r4.n0());
        this.c.c(r4, null, false);
    L82:
        if (Intrinsics.areEqual(this.b.a, r18) == true) goto L88;
        return 2;
    L88:
        return 1;
    L9:
        if (this.b.b.contains(r18) == false) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == true) goto L78;
        h r7 = this.b.a;
        if (r7 == null) goto L20;
        FloatPriority r8 = r7.getPriority();
    L21:
        FloatPriority r9 = r18.getPriority();
        long r11 = 0;
        if (f().d() == false) goto L45;
        h r10 = this.b.a;
        if (r10 == null) goto L26;
        String r12 = r10.k();
    L28:
        if (Intrinsics.areEqual(r12, r18.k()) == true) goto L45;
        if (((List) this.f.getValue()).contains(r18.k()) == true) goto L45;
        ConcurrentHashMap<h, b> r13 = g();
        if (f().f() == false) goto L34;
        SingleFloatWindowState r14 = SingleFloatWindowState.MINIMIZE;
    L36:
        if (this.b.a == null) goto L38;
        boolean r15 = true;
    L40:
        if (f().f() == true) goto L43;
        r11 = f().b();
    L43:
        r13.put(r18, new b(r14, r15, r11));
    L50:
        if (r8 != null) goto L52;
    L67:
        if (r8 != null) goto L69;
    L76:
        r2.d("MutexFloatManager", "enqueueRequest put into queue.");
        this.b.b.add(r18);
        h();
        return 2;
    L69:
        if (Intrinsics.areEqual(r9, r8) == false) goto L76;
        r2.d("MutexFloatManager", "enqueueRequest replace current request due to same priority");
        if (this.d == false) goto L75;
        h r16 = this.b.a;
        if (r16 == null) goto L75;
        r16.onWindowDismiss();
    L75:
        l();
        i(r18);
        return 1;
    L52:
        if (r9.compareTo(r8) <= 0) goto L67;
        r2.d("MutexFloatManager", "enqueueRequest replace current request.");
        h r17 = this.b.a;
        if (r17 != null) goto L56;
    L58:
        if (r6 == false) goto L65;
        r2.d("MutexFloatManager", "enqueueRequest requeue current request due to higher priority");
        h r20 = this.b.a;
        if (r20 == null) goto L64;
        r2.d("MutexFloatManager", "requeueCurrentRequest. contentView:" + r20.getContentView());
        this.c.a(r20.getContentView());
        this.b.b.add(r20);
        if (this.d == false) goto L64;
        r20.onWindowDismiss();
    L64:
        this.b.a = null;
    L66:
        i(r18);
        return 1;
    L65:
        r2.d("MutexFloatManager", "enqueueRequest replace current request due to higher priority");
        l();
        goto L66
    L56:
        if (r17.f() != true) goto L58;
        r6 = true;
        goto L58
    L38:
        r15 = false;
        goto L40
    L34:
        r14 = SingleFloatWindowState.MAXIMIZE;
        goto L36
    L26:
        r12 = null;
    L45:
        if (f().d() == false) goto L50;
        if (r8 != null) goto L50;
        if (((List) this.g.getValue()).contains(r18.k()) == false) goto L50;
        g().put(r18, new b(SingleFloatWindowState.MINIMIZE, false, 0));
        goto L50
    L20:
        r8 = null;
        goto L21
    L11:
        if (Intrinsics.areEqual(this.b.a, r18) == true) goto L14;
        r5 = false;
        goto L15
    L5:
        r3 = false;
        goto L7
    }

    public final void i(final h r2) {
        if (r2 != null) goto L6;
        this.b.a = null;
        return;
    L6:
        if (this.d == false) goto L11;
        if (r2.i() == false) goto L11;
        i.a.a(this, new l(this, r2), 1);
        return;
    L11:
        if (this.d == true) goto L16;
        if (r2.i() == true) goto L16;
        d(r2);
        b();
        return;
    L16:
        if (this.d == true) goto L18;
    L20:
        d(r2);
        return;
    L18:
        if (r2.i() == true) goto L20;
        d(r2);
        r2.onWindowShow();
    }

    public final boolean j(h r2) {
        return Intrinsics.areEqual(this.b.a, r2);
    }

    public final void k(h r3) {
        if (f().d() == true) goto L5;
        return;
    L5:
        if (f().f() == true) goto L16;
        if (r3 != null) goto L10;
        ((Handler) this.h.getValue()).removeCallbacksAndMessages(null);
        return;
    L10:
        Runnable r0 = (Runnable) ((Map) this.i.getValue()).get(r3);
        if (r0 == null) goto L15;
        ((Handler) this.h.getValue()).removeCallbacks(r0);
        Runnable r4 = (Runnable) ((Map) this.i.getValue()).remove(r3);
        return;
    L15:
        return;
    }

    public final void m(h r4) {
        Intrinsics.checkNotNullParameter(r4, "request");
        FLogger r0 = FLogger.a;
        r0.d("MutexFloatManager", "removeRequest. contentView:" + r4.getContentView());
        k(r4);
        if (Intrinsics.areEqual(this.b.a, r4) == false) goto L5;
        r0.d("MutexFloatManager", "removeRequest. remove current and handle next request");
        l();
        h();
        return;
    L5:
        r0.d("MutexFloatManager", "removeRequest. remove from queue");
        g().remove(r4);
        this.b.b.remove(r4);
    }

    public final void n(h r5) {
        Intrinsics.checkNotNullParameter(r5, "request");
        h r0 = this.b.a;
        if (r0 == null) goto L5;
        View r1 = r0.getContentView();
    L7:
        if (Intrinsics.areEqual(r1, r5.getContentView()) == false) goto L10;
        FLogger.a.d("MutexFloatManager", "updateRequestViewSize. currentView:" + r5.getContentView() + " width:" + r5.getWidth() + " height:" + r5.getHeight());
        this.c.b(r5.n0());
        this.c.c(r5, null, false);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // e19.i
    public final void a(String r4, final Function0<Unit> r5) {
        if (this.d == true) goto L7;
        if (r5 == null) goto L21;
        r5.invoke();
        return;
    L21:
        return;
    L7:
        if (r4 == null) goto L17;
        h r0 = this.b.a;
        if (r0 == null) goto L11;
        String r1 = r0.k();
    L13:
        if (Intrinsics.areEqual(r1, r4) == true) goto L17;
        if (r5 == null) goto L22;
        r5.invoke();
        return;
    L22:
        return;
    L11:
        r1 = null;
    L17:
        FLogger r6 = FLogger.a;
        r6.d("MutexFloatManager", "hideFloatWindow.");
        final com.larus.common_ui.floatwindow.view.c r2 = this.c;
        r2.c.a(new com.larus.common_ui.floatwindow.view.a(r2, r5));
        r6.d("FloatController", "alphaHideFloatWindow");
        this.d = false;
        h r7 = this.b.a;
        if (r7 == null) goto L23;
        r7.onWindowDismiss();
        return;
    }

    public final void c(SingleFloatWindowState r5, boolean r6) {
        FLogger r0 = FLogger.a;
        r0.d("MutexFloatManager", "changeWindowState. windowState:" + r5 + " animateIfRequired:" + r6);
        com.larus.common_ui.floatwindow.view.c r1 = this.c;
        r1.getClass();
        r0.d("FloatController", "changeWindowState. windowState:" + r5);
        r1.c.b(r5, r6);
    }
}
