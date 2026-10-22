package io.noties.markwon;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final io.noties.markwon.core.c f16622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final io.noties.markwon.a.b f16623b;
    private final io.noties.markwon.syntax.f c;
    private final d d;
    private final io.noties.markwon.a.a.a e;
    private final io.noties.markwon.a.i f;
    private final l g;

    /* JADX INFO: renamed from: io.noties.markwon.i$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private io.noties.markwon.core.c f16624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private io.noties.markwon.a.b f16625b;
        private io.noties.markwon.syntax.f c;
        private d d;
        private io.noties.markwon.a.a.a e;
        private io.noties.markwon.a.i f;
        private l g;

        a() {
        }

        static /* synthetic */ io.noties.markwon.core.c a(a r0) {
            return r0.f16624a;
        }

        static /* synthetic */ io.noties.markwon.a.b b(a r0) {
            return r0.f16625b;
        }

        static /* synthetic */ io.noties.markwon.syntax.f c(a r0) {
            return r0.c;
        }

        static /* synthetic */ d d(a r0) {
            return r0.d;
        }

        static /* synthetic */ io.noties.markwon.a.a.a e(a r0) {
            return r0.e;
        }

        static /* synthetic */ io.noties.markwon.a.i f(a r0) {
            return r0.f;
        }

        static /* synthetic */ l g(a r0) {
            return r0.g;
        }

        public a a(d r3) {
            this.d = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
            return this;
        }

        public a a(io.noties.markwon.syntax.f r3) {
            this.c = (io.noties.markwon.syntax.f) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.syntax.f.class, "com.obric.memorydata.plugin");
            return this;
        }

        public i a(io.noties.markwon.core.c r3, l r4) {
            l r5 = (l) ZeusTransformUtils.wrapperContextForParams(r4, l.class, "com.obric.memorydata.plugin");
            this.f16624a = r3;
            this.g = r5;
            if (this.f16625b != null) goto L6;
            this.f16625b = io.noties.markwon.a.b.a();
        L6:
            if (this.c != null) goto L9;
            this.c = new io.noties.markwon.syntax.g();
        L9:
            if (this.d != null) goto L12;
            this.d = new f();
        L12:
            if (this.e != null) goto L15;
            this.e = io.noties.markwon.a.a.a.a();
        L15:
            if (this.f != null) goto L18;
            this.f = new io.noties.markwon.a.j();
        L18:
            return new i(this, null);
        }
    }

    private i(a r2) {
        this.f16622a = a.a(r2);
        this.f16623b = a.b(r2);
        this.c = a.c(r2);
        this.d = a.d(r2);
        this.e = a.e(r2);
        this.f = a.f(r2);
        this.g = a.g(r2);
    }

    /* synthetic */ i(a r1, AnonymousClass1 r2) {
        this(r1);
    }

    public io.noties.markwon.core.c a() {
        return this.f16622a;
    }

    public io.noties.markwon.a.b b() {
        return this.f16623b;
    }

    public io.noties.markwon.syntax.f c() {
        return this.c;
    }

    public d d() {
        return this.d;
    }

    public io.noties.markwon.a.a.a e() {
        return this.e;
    }

    public l f() {
        return this.g;
    }
}
