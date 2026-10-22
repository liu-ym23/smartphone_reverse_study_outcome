package com.bytedance.retrofit2;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Unit;
import o4.e0;

/* JADX INFO: loaded from: classes.dex */
final class a extends com.bytedance.retrofit2.f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2480a;

    /* JADX INFO: renamed from: com.bytedance.retrofit2.a$a, reason: collision with other inner class name */
    static final class C0067a implements com.bytedance.retrofit2.f<r4.e, r4.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final C0067a f2481a = null;

        static {
            f2481a = new C0067a();
        }

        C0067a() {
        }

        public r4.e a(r4.e r10) {
            if (r10 != null) goto L4;
        L15:
            return r10;
        L4:
            if ((r10 instanceof com.bytedance.retrofit2.mime.c) == true) goto L15;
            String r11 = r10.a();
            InputStream r12 = r10.c();
            com.bytedance.retrofit2.mime.c r13 = new com.bytedance.retrofit2.mime.c(r11, c0.v(r12), new String[0]);     // Catch: Throwable -> L11
            if (r12 != null) goto L22;
        L10:
            return r13;
        L22:
            r12.close();     // Catch: IOException -> L16
        L11:
            th = move-exception;
            if (r12 != null) goto L20;
        L14:
            throw th;
        L20:
            r12.close();     // Catch: IOException -> L17
            goto L14
        }

        @Override // com.bytedance.retrofit2.f
        public /* bridge */ /* synthetic */ r4.e convert(r4.e r10) {
            return a(r10);
        }
    }

    static final class b implements com.bytedance.retrofit2.f<n4.b, n4.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f2482a = null;

        static {
            f2482a = new b();
        }

        b() {
        }

        public n4.b a(n4.b r10) {
            return r10;
        }

        @Override // com.bytedance.retrofit2.f
        public /* bridge */ /* synthetic */ n4.b convert(n4.b r10) {
            return a(r10);
        }
    }

    static final class c implements com.bytedance.retrofit2.f<Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f2483a = null;

        static {
            f2483a = new c();
        }

        c() {
        }

        @Override // com.bytedance.retrofit2.f
        public Object convert(Object r10) {
            return r10;
        }
    }

    static final class d implements com.bytedance.retrofit2.f<r4.f, r4.f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final d f2484a = null;

        static {
            f2484a = new d();
        }

        d() {
        }

        public r4.f a(r4.f r10) {
            return r10;
        }

        @Override // com.bytedance.retrofit2.f
        public /* bridge */ /* synthetic */ r4.f convert(r4.f r10) {
            return a(r10);
        }
    }

    static final class e implements com.bytedance.retrofit2.f<r4.e, r4.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final e f2485a = null;

        static {
            f2485a = new e();
        }

        e() {
        }

        public r4.e a(r4.e r10) {
            return r10;
        }

        @Override // com.bytedance.retrofit2.f
        public /* bridge */ /* synthetic */ r4.e convert(r4.e r10) {
            return a(r10);
        }
    }

    static final class f implements com.bytedance.retrofit2.f<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final f f2486a = null;

        static {
            f2486a = new f();
        }

        f() {
        }

        public String a(String r10) {
            return r10;
        }

        @Override // com.bytedance.retrofit2.f
        public /* bridge */ /* synthetic */ String convert(String r10) {
            return a(r10);
        }
    }

    static final class g implements com.bytedance.retrofit2.f<r4.e, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final g f2487a = null;

        static {
            f2487a = new g();
        }

        g() {
        }

        public String a(r4.e r10) {
            if ((r10 instanceof com.bytedance.retrofit2.mime.c) == false) goto L9;
            String r11 = "UTF-8";
            if (r10.a() == null) goto L8;
            r11 = r4.b.a(r10.a(), "UTF-8");
        L8:
            return new String(((com.bytedance.retrofit2.mime.c) r10).j(), r11);
        L9:
            return null;
        }

        @Override // com.bytedance.retrofit2.f
        public /* bridge */ /* synthetic */ String convert(r4.e r10) {
            return a(r10);
        }
    }

    static final class h implements com.bytedance.retrofit2.f<Object, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final h f2488a = null;

        static {
            f2488a = new h();
        }

        h() {
        }

        public String a(Object r10) {
            return r10.toString();
        }

        @Override // com.bytedance.retrofit2.f
        public /* bridge */ /* synthetic */ String convert(Object r10) {
            return a(r10);
        }
    }

    static final class i implements com.bytedance.retrofit2.f<r4.e, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final i f2489a = null;

        static {
            f2489a = new i();
        }

        i() {
        }

        public Unit a(r4.e r10) {
            r10.c().close();     // Catch: IOException -> L4
        L7:
            return Unit.INSTANCE;
        L4:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        @Override // com.bytedance.retrofit2.f
        public /* bridge */ /* synthetic */ Unit convert(r4.e r10) {
            return a(r10);
        }
    }

    static final class j implements com.bytedance.retrofit2.f<r4.e, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final j f2490a = null;

        static {
            f2490a = new j();
        }

        j() {
        }

        public Void a(r4.e r10) {
            InputStream r11 = r10.c();
            if (r11 == null) goto L7;
            r11.close();
            return null;
        L7:
            return null;
        }

        @Override // com.bytedance.retrofit2.f
        public /* bridge */ /* synthetic */ Void convert(r4.e r10) {
            return a(r10);
        }
    }

    a() {
        this.f2480a = true;
    }

    @Override // com.bytedance.retrofit2.f.a
    public com.bytedance.retrofit2.f<?, n4.b> a(Type r10, Annotation[] r11, t r12) {
        if (r10 == n4.b.class) goto L5;
        return null;
    L5:
        return b.f2482a;
    }

    @Override // com.bytedance.retrofit2.f.a
    public com.bytedance.retrofit2.f<?, Object> b(Type r10, Annotation[] r11, t r12) {
        if (r10 == Object.class) goto L5;
        return null;
    L5:
        return c.f2483a;
    }

    @Override // com.bytedance.retrofit2.f.a
    public com.bytedance.retrofit2.f<?, r4.f> c(Type r10, Annotation[] r11, Annotation[] r12, t r13) {
        if (r4.f.class.isAssignableFrom(c0.j(r10)) == true) goto L5;
        return null;
    L5:
        return d.f2484a;
    }

    @Override // com.bytedance.retrofit2.f.a
    public com.bytedance.retrofit2.f<r4.e, ?> d(Type r10, Annotation[] r11, t r12) {
        if (r10 != r4.e.class) goto L11;
        if (c0.n(r11, e0.class) == false) goto L9;
        return e.f2485a;
    L9:
        return C0067a.f2481a;
    L11:
        if (r10 != String.class) goto L15;
        return g.f2487a;
    L15:
        if (r10 != Void.class) goto L19;
        return j.f2490a;
    L19:
        if (this.f2480a == true) goto L21;
        return null;
    L21:
        if (r10 != Unit.class) goto L30;
        return i.f2489a;
    L24:
        this.f2480a = false;
        return null;
    L30:
        return null;
    }

    @Override // com.bytedance.retrofit2.f.a
    public com.bytedance.retrofit2.f<?, String> e(Type r10, Annotation[] r11, t r12) {
        if (r10 == String.class) goto L5;
        return null;
    L5:
        return f.f2486a;
    }
}
