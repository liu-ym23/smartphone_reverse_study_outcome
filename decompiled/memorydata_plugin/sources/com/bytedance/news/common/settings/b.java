package com.bytedance.news.common.settings;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.news.common.settings.api.g;
import com.bytedance.news.common.settings.api.h;
import com.bytedance.news.common.settings.api.j;
import com.bytedance.news.common.settings.api.request.RequestV3Service;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class b implements com.bytedance.news.common.settings.internal.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.news.common.settings.api.b f2927b;
    private C0147b c;

    /* JADX INFO: renamed from: com.bytedance.news.common.settings.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f2928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private j f2929b;
        private com.bytedance.news.common.settings.api.b c;
        private Executor d;
        private long e;
        private long f;
        private String g;
        private h h;
        private com.bytedance.news.common.settings.api.f i;
        private com.bytedance.news.common.settings.api.d j;
        private boolean k;
        private boolean l;
        private boolean m;
        private int n;
        private boolean o;
        private com.bytedance.news.common.settings.api.a p;
        private com.bytedance.news.common.settings.api.model.a q;
        private RequestV3Service r;
        private boolean s;
        private g t;
        private boolean u;

        public a() {
            this.e = -1;
            this.f = -1;
            this.k = true;
            this.l = true;
            this.p = null;
        }

        public a a(Context r3) {
            this.f2928a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
            return this;
        }

        public a a(com.bytedance.news.common.settings.api.b r3) {
            this.c = (com.bytedance.news.common.settings.api.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.news.common.settings.api.b.class, "com.obric.memorydata.plugin");
            return this;
        }

        public a a(boolean r1) {
            this.k = r1;
            return this;
        }

        public b a() {
            if (this.f2928a == null) goto L27;
            if (this.c == null) goto L25;
            if (this.f2929b != null) goto L10;
            this.f2929b = new com.bytedance.news.common.settings.a.c();
        L10:
            if (this.d != null) goto L13;
            this.d = Executors.newCachedThreadPool();
        L13:
            if (this.e >= 0) goto L16;
            this.e = ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS;
        L16:
            if (this.f >= 0) goto L18;
            this.f = 120000;
        L18:
            AnonymousClass1 r1 = null;
            C0147b r0 = new C0147b(r1);
            r0.f2931b = this.f2929b;
            r0.c = this.d;
            r0.d = this.e;
            r0.e = this.f;
            r0.f = this.g;
            r0.g = this.h;
            r0.h = this.i;
            r0.j = this.k;
            r0.k = this.l;
            r0.l = this.m;
            r0.i = this.j;
            r0.o = this.p;
            r0.m = this.n;
            r0.n = this.o;
            r0.o = this.p;
            r0.p = this.q;
            r0.q = this.r;
            r0.r = this.s;
            r0.s = this.t;
            r0.t = this.u;
            if (ZeusTransformUtils.instanceOf(this.f2928a, Application.class) == false) goto L23;
            return new b(this.f2928a, this.c, r0, r1);
        L23:
            return new b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f2928a.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.c, r0, r1);
        L25:
            throw new IllegalArgumentException("requestService不能为空");
        L27:
            throw new IllegalArgumentException("context不能为空");
        }

        public a b(boolean r1) {
            this.l = r1;
            return this;
        }

        public a c(boolean r1) {
            this.o = r1;
            return this;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.news.common.settings.b$b, reason: collision with other inner class name */
    private static class C0147b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j f2931b;
        public Executor c;
        public long d;
        public long e;
        public String f;
        public h g;
        public com.bytedance.news.common.settings.api.f h;
        public com.bytedance.news.common.settings.api.d i;
        public boolean j;
        public boolean k;
        public boolean l;
        public int m;
        public boolean n;
        public com.bytedance.news.common.settings.api.a o;
        public com.bytedance.news.common.settings.api.model.a p;
        public RequestV3Service q;
        public boolean r;
        public g s;
        public boolean t;

        private C0147b() {
            this.j = true;
            this.k = true;
        }

        /* synthetic */ C0147b(AnonymousClass1 r1) {
            this();
        }
    }

    private b(Context r3, com.bytedance.news.common.settings.api.b r4, C0147b r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        com.bytedance.news.common.settings.api.b r7 = (com.bytedance.news.common.settings.api.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.news.common.settings.api.b.class, "com.obric.memorydata.plugin");
        this.f2926a = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.f2927b = r7;
        this.c = r5;
    }

    /* synthetic */ b(Context r2, com.bytedance.news.common.settings.api.b r3, C0147b r4, AnonymousClass1 r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (com.bytedance.news.common.settings.api.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.news.common.settings.api.b.class, "com.obric.memorydata.plugin"), r4);
    }

    public SharedPreferences a(Context r3, String r4, int r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (this.c.g != null) goto L7;
        return null;
    L7:
        return this.c.g.a(r7, r4, r5, r6);
    }

    public com.bytedance.news.common.settings.api.b a() {
        return this.f2927b;
    }

    void a(String r1) {
        this.c.f2930a = r1;
    }

    public j b() {
        return this.c.f2931b;
    }

    public Executor c() {
        return this.c.c;
    }

    public long d() {
        return this.c.d;
    }

    public long e() {
        return this.c.e;
    }

    public com.bytedance.news.common.settings.api.f f() {
        return this.c.h;
    }

    public boolean g() {
        return this.c.j;
    }

    @Override // com.bytedance.news.common.settings.internal.c
    public Context getContext() {
        return this.f2926a;
    }

    public boolean h() {
        return this.c.k;
    }

    public boolean i() {
        return this.c.l;
    }

    public com.bytedance.news.common.settings.api.d j() {
        return this.c.i;
    }

    public int k() {
        return this.c.m;
    }

    public boolean l() {
        return this.c.n;
    }

    public com.bytedance.news.common.settings.api.a m() {
        return this.c.o;
    }

    public com.bytedance.news.common.settings.api.model.a n() {
        return this.c.p;
    }

    public RequestV3Service o() {
        return this.c.q;
    }

    public boolean p() {
        return this.c.r;
    }

    @Override // com.bytedance.news.common.settings.internal.c
    public g q() {
        return this.c.s;
    }

    public boolean r() {
        return this.c.t;
    }

    public String s() {
        return this.c.f2930a;
    }
}
