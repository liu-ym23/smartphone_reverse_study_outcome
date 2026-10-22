package com.bytedance.common.wschannel;

import android.app.Application;
import android.content.IntentFilter;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static z1.k f1314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f1315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Application f1316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a f1317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static e f1318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Map<Integer, b2.a> f1319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f1320g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static b f1321h;

    private static class a implements c.InterfaceC0045c {
        private a() {
        }

        /* synthetic */ a(i r10) {
            this();
        }

        @Override // com.bytedance.common.wschannel.c.InterfaceC0045c
        public void onEnterToBackground() {
            j.a(true);
            if (j.d() != null) goto L5;
        L6:
            j.c().b(j.b());
            return;
        L5:
            if (b.a(j.d()) == true) goto L6;
        }

        @Override // com.bytedance.common.wschannel.c.InterfaceC0045c
        public void onEnterToForeground() {
            j.a(false);
            if (j.d() != null) goto L5;
        L6:
            j.c().c(j.b());
            return;
        L5:
            if (b.a(j.d()) == true) goto L6;
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1322a;

        private b() {
            this.f1322a = false;
            new ConcurrentHashMap();
        }

        /* synthetic */ b(i r10) {
            this();
        }

        static /* synthetic */ boolean a(b r10) {
            return r10.f1322a;
        }

        static /* synthetic */ boolean b(b r10, boolean r11) {
            r10.f1322a = r11;
            return r11;
        }
    }

    static {
        f1314a = new z1.l();
        f1317d = new a(null);
        f1318e = null;
        new ConcurrentHashMap();
        f1319f = new ConcurrentHashMap();
    }

    static /* synthetic */ boolean a(boolean r10) {
        return r10;
    }

    static /* synthetic */ Application b() {
        return f1316c;
    }

    static /* synthetic */ z1.k c() {
        return f1314a;
    }

    static /* synthetic */ b d() {
        return f1321h;
    }

    private static void e(Application r10, @Nullable u1.d r11, boolean r12, boolean r13, @Nullable u1.b r14) {
        f(new m.a().a(r10).g(r11).e(r12).d(r13).f(false).b(r14).c());
    }

    private static void f(m r10) {
        if (f1315b == false) goto L5;
        return;
    L5:
        Application r11 = r10.a();
        u1.d r12 = r10.b();
        boolean r13 = r10.d();
        boolean r14 = r10.e();
        u1.b r15 = r10.f1336f;
        boolean r16 = r10.f();
        f1315b = true;
        f1316c = r11;
        String r17 = g2.c.c(r11);
        f1320g = r17;
        boolean r18 = g2.c.j(r11, r17);
        if (r14 == false) goto L9;
        if (r18 == false) goto L9;
        b r19 = new b(null);
        f1321h = r19;
        b.b(r19, false);
    L9:
        if (r18 == false) goto L18;
        if (r13 == false) goto L12;
        c r20 = new c();
        r20.d(f1317d);
        r11.registerActivityLifecycleCallbacks(r20);
    L12:
        WsConstants.setOnMessageReceiveListener(r12);
        WsConstants.setOptLogic(r10.c());
        WsConstants.setBindWsChannelServiceListener(r15);
        if (r11 == null) goto L21;
        l r21 = l.f(r11);
        if (r21 == null) goto L21;
        r21.k(r16);
    L21:
        if (f1321h != null) goto L24;
        f1314a.a(f1316c, r18, true);
        return;
    L24:
        return;
    L18:
        if (g2.c.k(f1320g) == false) goto L21;
        j();
        goto L21
    }

    public static <T extends c2.a> b2.a<T> g(int r10) {
        return f1319f.get(Integer.valueOf(r10));
    }

    public static e h() {
        return f1318e;
    }

    public static void i(Application r10, @Nullable u1.d r11) {
        e(r10, r11, false, true, null);
    }

    private static void j() {
        IntentFilter r10 = new IntentFilter();     // Catch: Exception -> L4
        r10.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Exception -> L4
        Application r11 = f1316c;     // Catch: Exception -> L4
        Application r12 = f1316c;     // Catch: Exception -> L4
        r11.registerReceiver(new com.bytedance.common.wschannel.server.m(r12, com.bytedance.common.wschannel.server.j.b(r12)), r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
