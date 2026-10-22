package com.bytedance.ttnet;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.n;
import com.bytedance.ttnet.tnc.TNCManager;
import java.net.MalformedURLException;
import r2.i;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile InterfaceC0072c f2781a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final d f2782b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final b f2783c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static boolean f2784d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static volatile boolean f2785e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static String f2786f;

    static /* synthetic */ class a {
    }

    private static class b extends d {
        private b() {
            super(null);
        }

        /* synthetic */ b(a r10) {
            this();
        }

        @Override // com.bytedance.ttnet.c.d
        public o2.d a() {
            return e.b(i.w(TTNetInit.getTTNetDepend().getContext()));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ttnet.c$c, reason: collision with other inner class name */
    public interface InterfaceC0072c {
        boolean i();
    }

    private static class d {
        private d() {
        }

        /* synthetic */ d(a r10) {
            this();
        }

        public o2.d a() {
            Context r10 = TTNetInit.getTTNetDepend().getContext();
            n r11 = n.t(r10);
            if (com.bytedance.frameworks.baselib.network.http.util.g.h(r10) == false) goto L5;
            r11.w(TNCManager.m());
        L5:
            return r11;
        }
    }

    private static class e implements o2.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static volatile e f2787c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private i f2788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile int f2789b;

        private e(i r10) {
            this.f2788a = r10;
        }

        public static e b(i r10) {
            if (f2787c != null) goto L15;
            monitor-enter(e.class);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (f2787c != null) goto L9;
            f2787c = new e(r10);     // Catch: Throwable -> L11
        L9:
            monitor-exit(e.class);     // Catch: Throwable -> L11
        L15:
            return f2787c;
        }

        private void c(Throwable r10) {
            if ((r10 instanceof MalformedURLException) == false) goto L6;
            return;
        L6:
            if (r10.getMessage() == null) goto L11;
            if (r10.getMessage().contains("MalformedURLException") == false) goto L11;
            return;
        L11:
            if (Logger.debug() == false) goto L14;
            Logger.d("HttpClient", "init mode is " + TTNetInitMetrics.k().m());
            Logger.d("HttpClient", "exception times is " + this.f2789b);
        L14:
            if (TTNetInitMetrics.k().m() == false) goto L27;
            int r11 = this.f2789b + 1;
            this.f2789b = r11;
            if (r11 > 3) goto L18;
            return;
        L18:
            if (w4.c.b() == false) goto L20;
        L23:
            String r12 = com.bytedance.ttnet.utils.d.c(r10);
            c.f2786f = r12;
            if (r12.length() <= 256) goto L29;
            c.f2786f = c.f2786f.substring(0, 256);
            return;
        L29:
            return;
        L20:
            if (Logger.debug() == false) goto L22;
            Logger.d("HttpClient", "set sIsCronetException true");
        L22:
            c.f2784d = true;
            goto L23
        }

        @Override // n4.a
        public n4.e a(n4.c r10) {
            return this.f2788a.a(r10);
        L4:
            th = move-exception;
            c(th);
            TTNetInit.notifyColdStartFinish();
            if (r10.z() == null) goto L14;
            String r11 = com.bytedance.ttnet.utils.d.c(th);
            if (r11.length() <= 1024) goto L10;
            r11 = r11.substring(0, 1024);
        L10:
            r10.z().f2441i = r11;
            r10.z().f2439h = 10;
            if (Logger.debug() == false) goto L14;
            Logger.d("HttpClient", "new CronetSscall failed " + this.f2789b + " for " + r10.A());
            StringBuilder r12 = new StringBuilder();
            r12.append("new CronetSscall failed message ");
            r12.append(r11);
            Logger.d("HttpClient", r12.toString());
        L14:
            return c.f2782b.a().a(r10);
        }
    }

    static {
        a r10 = null;
        f2782b = new d(r10);
        f2783c = new b(r10);
    }

    public static String a() {
        return f2786f;
    }

    public static o2.d b(String r10, boolean r11) {
        if (c() == false) goto L8;
        if (r11 == true) goto L8;
        return f2783c.a();
    L8:
        return f2782b.a();
    }

    public static boolean c() {
        if (f2781a == null) goto L11;
        if (n.l() != 9) goto L11;
        if (Logger.debug() == false) goto L9;
        Logger.d("HttpClient", "reset null config fallback");
    L9:
        n.v(-1);
    L11:
        if (f2781a != null) goto L20;
        if (w4.c.c() == true) goto L20;
        if (Logger.debug() == false) goto L17;
        Logger.d("HttpClient", "check null config and fallback");
    L17:
        TNCManager.m().p();
        n.v(9);
        return false;
    L20:
        if (f2781a == null) goto L25;
        if (f2781a.i() == true) goto L25;
        return false;
    L25:
        if (f2784d == true) goto L27;
        return true;
    L27:
        if (f2785e == true) goto L32;
        n.v(7);
        n.u(f2786f);
        return false;
    L32:
        return true;
    }

    public static void d(boolean r10) {
        f2785e = r10;
    }

    public static void e(InterfaceC0072c r10) {
        f2781a = r10;
    }
}
