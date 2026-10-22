package com.bytedance.ttnet;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.o;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.ttnet.tnc.TNCManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.MalformedURLException;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final C0165c f3208a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final a f3209b = null;
    static boolean c = false;
    static volatile boolean d = false;
    static String e;
    private static volatile b f;

    /* JADX INFO: renamed from: com.bytedance.ttnet.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a extends C0165c {
        private a() {
            super(null);
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.ttnet.c.C0165c
        public com.bytedance.frameworks.baselib.network.http.d a() {
            return d.a(com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));
        }
    }

    public interface b {
        boolean isChromiumOpen();
    }

    /* JADX INFO: renamed from: com.bytedance.ttnet.c$c, reason: collision with other inner class name */
    private static class C0165c {
        private C0165c() {
        }

        /* synthetic */ C0165c(AnonymousClass1 r1) {
            this();
        }

        public com.bytedance.frameworks.baselib.network.http.d a() {
            Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            o r0 = o.a(r2);
            if (com.bytedance.frameworks.baselib.network.http.util.g.b(r2) == false) goto L5;
            r0.a(TNCManager.c());
        L5:
            return r0;
        }
    }

    private static class d implements com.bytedance.frameworks.baselib.network.http.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static volatile d f3210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.bytedance.frameworks.baselib.network.http.cronet.impl.h f3211b;
        private volatile int c;

        private d(com.bytedance.frameworks.baselib.network.http.cronet.impl.h r1) {
            this.f3211b = r1;
        }

        public static d a(com.bytedance.frameworks.baselib.network.http.cronet.impl.h r2) {
            if (f3210a != null) goto L15;
            monitor-enter(d.class);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (f3210a != null) goto L9;
            f3210a = new d(r2);     // Catch: Throwable -> L11
        L9:
            monitor-exit(d.class);     // Catch: Throwable -> L11
        L15:
            return f3210a;
        }

        private void a(Throwable r4) {
            if (ZeusTransformUtils.instanceOf(r4, MalformedURLException.class) == false) goto L6;
            return;
        L6:
            if (r4.getMessage() == null) goto L11;
            if (r4.getMessage().contains("MalformedURLException") == false) goto L11;
            return;
        L11:
            if (Logger.debug() == false) goto L14;
            Logger.d("HttpClient", "init mode is " + TTNetInitMetrics.c().b());
            Logger.d("HttpClient", "exception times is " + this.c);
        L14:
            if (TTNetInitMetrics.c().b() == false) goto L27;
            int r0 = this.c + 1;
            this.c = r0;
            if (r0 > 3) goto L18;
            return;
        L18:
            if (com.bytedance.ttnet.config.b.d() == false) goto L20;
        L23:
            c.e = com.bytedance.ttnet.utils.d.a(r4);
            if (c.e.length() <= 256) goto L29;
            c.e = c.e.substring(0, 256);
            return;
        L29:
            return;
        L20:
            if (Logger.debug() == false) goto L22;
            Logger.d("HttpClient", "set sIsCronetException true");
        L22:
            c.c = true;
            goto L23
        }

        @Override // com.bytedance.retrofit2.client.Client
        public SsCall newSsCall(Request r4) {
            return this.f3211b.newSsCall(r4);
        L4:
            th = move-exception;
            a(th);
            TTNetInit.notifyColdStartFinish();
            if (r4.getMetrics() == null) goto L14;
            String r0 = com.bytedance.ttnet.utils.d.a(th);
            if (r0.length() <= 1024) goto L10;
            r0 = r0.substring(0, 1024);
        L10:
            r4.getMetrics().requestFallbackMessage = r0;
            r4.getMetrics().requestFallbackReason = 10;
            if (Logger.debug() == false) goto L14;
            Logger.d("HttpClient", "new CronetSscall failed " + this.c + " for " + r4.getPath());
            Logger.d("HttpClient", "new CronetSscall failed message " + r0);
        L14:
            return c.f3208a.a().newSsCall(r4);
        }
    }

    static {
        AnonymousClass1 r1 = null;
        f3208a = new C0165c(r1);
        f3209b = new a(r1);
    }

    public static com.bytedance.frameworks.baselib.network.http.d a(String r0, boolean r1) {
        if (b() == false) goto L8;
        if (r1 == true) goto L8;
        return f3209b.a();
    L8:
        return f3208a.a();
    }

    public static String a() {
        return e;
    }

    public static void a(b r2) {
        f = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
    }

    public static void a(boolean r0) {
        d = r0;
    }

    public static boolean b() {
        if (f == null) goto L11;
        if (o.e() != 9) goto L11;
        if (Logger.debug() == false) goto L9;
        Logger.d("HttpClient", "reset null config fallback");
    L9:
        o.a(-1);
    L11:
        if (f != null) goto L20;
        if (com.bytedance.ttnet.config.b.e() == true) goto L20;
        if (Logger.debug() == false) goto L17;
        Logger.d("HttpClient", "check null config and fallback");
    L17:
        TNCManager.c().f();
        o.a(9);
        return false;
    L20:
        if (f == null) goto L25;
        if (f.isChromiumOpen() == true) goto L25;
        return false;
    L25:
        if (c == true) goto L27;
        return true;
    L27:
        if (d == true) goto L32;
        o.a(7);
        o.b(e);
        return false;
    L32:
        return true;
    }
}
