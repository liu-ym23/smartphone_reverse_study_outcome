package com.bytedance.common.wschannel;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f2127a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.bytedance.common.wschannel.client.k f2128b;
    private static volatile boolean c;
    private static Application d;
    private static a e;
    private static f f;
    private static Map<Integer, com.bytedance.common.wschannel.a> g;
    private static Map<Integer, com.bytedance.common.wschannel.heartbeat.a> h;
    private static String i;
    private static b j;
    private static boolean k;
    private static boolean l;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.j$1, reason: invalid class name */
    static class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (j.b() == false) goto L5;
            j.d().b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(j.c(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"));
            return;
        L5:
            j.d().a((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(j.c(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"));
        }
    }

    private static class a implements d.a {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.common.wschannel.d.a
        public void a() {
            j.a(false);
            if (j.e() != null) goto L5;
        L6:
            j.d().a((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(j.c(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"));
            return;
        L5:
            if (b.a(j.e()) == true) goto L6;
        }

        @Override // com.bytedance.common.wschannel.d.a
        public void b() {
            j.a(true);
            if (j.e() != null) goto L5;
        L6:
            j.d().b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(j.c(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"));
            return;
        L5:
            if (b.a(j.e()) == true) goto L6;
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f2129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<Integer, com.bytedance.common.wschannel.a> f2130b;

        private b() {
            this.f2129a = false;
            this.f2130b = new ConcurrentHashMap();
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ boolean a(b r0) {
            return r0.f2129a;
        }

        static /* synthetic */ boolean a(b r0, boolean r1) {
            r0.f2129a = r1;
            return r1;
        }
    }

    static {
        f2127a = new Object();
        f2128b = new com.bytedance.common.wschannel.client.l();
        e = new a(null);
        f = null;
        g = new ConcurrentHashMap();
        h = new ConcurrentHashMap();
    }

    public static f a() {
        return f;
    }

    public static <T extends com.bytedance.common.wschannel.heartbeat.model.a> com.bytedance.common.wschannel.heartbeat.a<T> a(int r2) {
        return (com.bytedance.common.wschannel.heartbeat.a) ZeusTransformUtils.preCheckCast(h.get(Integer.valueOf(r2)), com.bytedance.common.wschannel.heartbeat.a.class, "com.obric.memorydata.plugin");
    }

    public static void a(Application r3, com.bytedance.common.wschannel.app.d r4) {
        a((Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin"), (com.bytedance.common.wschannel.app.d) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.common.wschannel.app.d.class, "com.obric.memorydata.plugin"), false, true, null);
    }

    private static void a(Application r2, com.bytedance.common.wschannel.app.d r3, boolean r4, boolean r5, com.bytedance.common.wschannel.app.b r6) {
        Application r7 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.memorydata.plugin");
        com.bytedance.common.wschannel.app.d r8 = (com.bytedance.common.wschannel.app.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.common.wschannel.app.d.class, "com.obric.memorydata.plugin");
        com.bytedance.common.wschannel.app.b r9 = (com.bytedance.common.wschannel.app.b) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.common.wschannel.app.b.class, "com.obric.memorydata.plugin");
        a(new m.a().a(r7).a(r8).a(r4).b(r5).c(false).a(r9).a());
    }

    private static void a(m r9) {
        if (c == false) goto L5;
        return;
    L5:
        Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        com.bytedance.common.wschannel.app.d r1 = r9.b();
        boolean r2 = r9.e();
        boolean r3 = r9.d();
        com.bytedance.common.wschannel.app.b r4 = r9.f2136a;
        boolean r5 = r9.c();
        c = true;
        d = r0;
        k = r2;
        String r7 = com.bytedance.common.wschannel.c.c.b(r0);
        i = r7;
        boolean r8 = com.bytedance.common.wschannel.c.c.a(r0, r7);
        if (r3 == false) goto L9;
        if (r8 == false) goto L9;
        b r6 = new b(null);
        j = r6;
        b.a(r6, false);
    L9:
        if (r8 == false) goto L18;
        if (r2 == false) goto L12;
        d r10 = new d();
        r10.a(e);
        r0.registerActivityLifecycleCallbacks(r10);
    L12:
        WsConstants.setOnMessageReceiveListener(r1);
        WsConstants.setOptLogic(r9.f());
        WsConstants.setBindWsChannelServiceListener(r4);
        if (r0 == null) goto L21;
        l r11 = l.a(r0);
        if (r11 == null) goto L21;
        r11.a(r5);
    L21:
        if (j != null) goto L24;
        f2128b.a(d, r8, true);
        return;
    L24:
        return;
    L18:
        if (com.bytedance.common.wschannel.c.c.b(i) == false) goto L21;
        f();
        goto L21
    }

    static /* synthetic */ boolean a(boolean r0) {
        l = r0;
        return r0;
    }

    static /* synthetic */ boolean b() {
        return l;
    }

    static /* synthetic */ Application c() {
        return d;
    }

    static /* synthetic */ com.bytedance.common.wschannel.client.k d() {
        return f2128b;
    }

    static /* synthetic */ b e() {
        return j;
    }

    private static void f() {
        IntentFilter r0 = new IntentFilter();     // Catch: Exception -> L4
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Exception -> L4
        Application r1 = d;     // Catch: Exception -> L4
        Application r3 = d;     // Catch: Exception -> L4
        ZeusTransformUtils.registerReceiver(r1, new com.bytedance.common.wschannel.server.m(r3, com.bytedance.common.wschannel.server.j.a(r3)), r0, "com.obric.memorydata.plugin");     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static Context getContext() {
        return d;
    }
}
