package com.bytedance.applog.monitor.v3;

import android.content.Context;
import com.bytedance.bdinstall.INetworkClient;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f1691b;
    private long c;
    private final INetworkClient d;
    private final ExecutorService e;
    private final String f;
    private final com.bytedance.applog.monitor.v3.a g;

    /* JADX INFO: renamed from: com.bytedance.applog.monitor.v3.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f1692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private c f1693b;
        private long c;
        private INetworkClient d;
        private String e;
        private ExecutorService f;
        private com.bytedance.applog.monitor.v3.a g;

        public a() {
        }

        static /* synthetic */ Context a(a r0) {
            return r0.f1692a;
        }

        static /* synthetic */ c b(a r0) {
            return r0.f1693b;
        }

        static /* synthetic */ long c(a r2) {
            return r2.c;
        }

        static /* synthetic */ INetworkClient d(a r0) {
            return r0.d;
        }

        static /* synthetic */ String e(a r0) {
            return r0.e;
        }

        static /* synthetic */ ExecutorService f(a r0) {
            return r0.f;
        }

        static /* synthetic */ com.bytedance.applog.monitor.v3.a g(a r0) {
            return r0.g;
        }

        public a a(long r1) {
            this.c = r1;
            return this;
        }

        public a a(Context r3) {
            this.f1692a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
            return this;
        }

        public a a(com.bytedance.applog.monitor.v3.a r3) {
            this.g = (com.bytedance.applog.monitor.v3.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.applog.monitor.v3.a.class, "com.obric.memorydata.plugin");
            return this;
        }

        public a a(c r1) {
            this.f1693b = r1;
            return this;
        }

        public a a(INetworkClient r3) {
            this.d = (INetworkClient) ZeusTransformUtils.wrapperContextForParams(r3, INetworkClient.class, "com.obric.memorydata.plugin");
            return this;
        }

        public a a(String r1) {
            this.e = r1;
            return this;
        }

        public a a(ExecutorService r3) {
            this.f = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.memorydata.plugin");
            return this;
        }

        public d a() {
            return new d(this, null);
        }
    }

    private d(a r4) {
        this.c = 60000;
        this.f1690a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.a(r4), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f1691b = a.b(r4);
        this.c = a.c(r4);
        this.d = a.d(r4);
        this.f = a.e(r4);
        this.e = a.f(r4);
        this.g = a.g(r4);
    }

    /* synthetic */ d(a r1, AnonymousClass1 r2) {
        this(r1);
    }

    public c a() {
        return this.f1691b;
    }

    public long b() {
        return this.c;
    }

    public INetworkClient c() {
        return this.d;
    }

    public String d() {
        return this.f;
    }

    public ExecutorService e() {
        return this.e;
    }

    public com.bytedance.applog.monitor.v3.a f() {
        return this.g;
    }

    public Context getContext() {
        return this.f1690a;
    }

    public String toString() {
        return "MonitorV3Config{context=" + this.f1690a + ", appLogConfig=" + this.f1691b + ", eventReportInterval=" + this.c + ", networkClient=" + this.d + ", executor=" + this.e + ", reportUrl='" + this.f + "'}";
    }
}
