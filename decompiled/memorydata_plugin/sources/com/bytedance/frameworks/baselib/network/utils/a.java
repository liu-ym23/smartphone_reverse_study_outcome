package com.bytedance.frameworks.baselib.network.utils;

import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.retrofit2.RetrofitMetrics;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f2554a = false;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.utils.a$a, reason: collision with other inner class name */
    private static class C0131a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Reflect f2555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final RetrofitMetrics f2556b;

        C0131a(Reflect r1, RetrofitMetrics r2) {
            this.f2555a = r1;
            this.f2556b = r2;
        }

        @Override // com.bytedance.frameworks.baselib.network.utils.a.b
        public <T> T a() {
            return (T) this.f2555a.get();
        }

        @Override // com.bytedance.frameworks.baselib.network.utils.a.b
        public b call(String r9) {
            long r0 = System.nanoTime();
            this.f2555a = this.f2555a.call(r9);     // Catch: Throwable -> L11 Exception -> L13
            RetrofitMetrics r10 = this.f2556b;
            if (r10 != null) goto L7;
        L10:
            return this;
        L7:
            if (r10.networklib.innerSpan.reflection != (-1)) goto L9;
            this.f2556b.networklib.innerSpan.reflection = 0;
        L9:
            this.f2556b.networklib.innerSpan.reflection += System.nanoTime() - r0;
            goto L10
        L13:
            e = move-exception;
            throw new TTReflectIOException(e.getMessage(), e.getCause());     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            RetrofitMetrics r6 = this.f2556b;
            if (r6 != null) goto L19;
        L22:
            throw th;
        L19:
            if (r6.networklib.innerSpan.reflection != (-1)) goto L21;
            this.f2556b.networklib.innerSpan.reflection = 0;
        L21:
            this.f2556b.networklib.innerSpan.reflection += System.nanoTime() - r0;
            goto L22
        }

        @Override // com.bytedance.frameworks.baselib.network.utils.a.b
        public b call(String r8, Class<?>[] r9, Object... r10) {
            long r0 = System.nanoTime();
            this.f2555a = this.f2555a.call(r8, r9, r10);     // Catch: Throwable -> L11 Exception -> L13
            RetrofitMetrics r11 = this.f2556b;
            if (r11 != null) goto L7;
        L10:
            return this;
        L7:
            if (r11.networklib.innerSpan.reflection != (-1)) goto L9;
            this.f2556b.networklib.innerSpan.reflection = 0;
        L9:
            this.f2556b.networklib.innerSpan.reflection += System.nanoTime() - r0;
            goto L10
        L13:
            e = move-exception;
            throw new TTReflectIOException(e.getMessage(), e.getCause());     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            RetrofitMetrics r12 = this.f2556b;
            if (r12 != null) goto L19;
        L22:
            throw th;
        L19:
            if (r12.networklib.innerSpan.reflection != (-1)) goto L21;
            this.f2556b.networklib.innerSpan.reflection = 0;
        L21:
            this.f2556b.networklib.innerSpan.reflection += System.nanoTime() - r0;
            goto L22
        }
    }

    public interface b {
        <T> T a();

        b call(String r1);

        b call(String r1, Class<?>[] r2, Object... r3);
    }

    private static class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.bytedance.frameworks.baselib.network.utils.b f2557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final RetrofitMetrics f2558b;

        c(com.bytedance.frameworks.baselib.network.utils.b r1, RetrofitMetrics r2) {
            this.f2557a = r1;
            this.f2558b = r2;
        }

        @Override // com.bytedance.frameworks.baselib.network.utils.a.b
        public <T> T a() {
            return (T) this.f2557a.a();
        }

        @Override // com.bytedance.frameworks.baselib.network.utils.a.b
        public b call(String r9) {
            long r0 = System.nanoTime();
            this.f2557a = this.f2557a.call(r9);     // Catch: Throwable -> L11 Exception -> L13
            RetrofitMetrics r10 = this.f2558b;
            if (r10 != null) goto L7;
        L10:
            return this;
        L7:
            if (r10.networklib.innerSpan.reflection != (-1)) goto L9;
            this.f2558b.networklib.innerSpan.reflection = 0;
        L9:
            this.f2558b.networklib.innerSpan.reflection += System.nanoTime() - r0;
            goto L10
        L13:
            e = move-exception;
            throw new TTReflectIOException(e.getMessage(), e.getCause());     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            RetrofitMetrics r6 = this.f2558b;
            if (r6 != null) goto L19;
        L22:
            throw th;
        L19:
            if (r6.networklib.innerSpan.reflection != (-1)) goto L21;
            this.f2558b.networklib.innerSpan.reflection = 0;
        L21:
            this.f2558b.networklib.innerSpan.reflection += System.nanoTime() - r0;
            goto L22
        }

        @Override // com.bytedance.frameworks.baselib.network.utils.a.b
        public b call(String r8, Class<?>[] r9, Object... r10) {
            long r0 = System.nanoTime();
            this.f2557a = this.f2557a.call(r8, r9, r10);     // Catch: Throwable -> L11 Exception -> L13
            RetrofitMetrics r11 = this.f2558b;
            if (r11 != null) goto L7;
        L10:
            return this;
        L7:
            if (r11.networklib.innerSpan.reflection != (-1)) goto L9;
            this.f2558b.networklib.innerSpan.reflection = 0;
        L9:
            this.f2558b.networklib.innerSpan.reflection += System.nanoTime() - r0;
            goto L10
        L13:
            e = move-exception;
            throw new TTReflectIOException(e.getMessage(), e.getCause());     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            RetrofitMetrics r12 = this.f2558b;
            if (r12 != null) goto L19;
        L22:
            throw th;
        L19:
            if (r12.networklib.innerSpan.reflection != (-1)) goto L21;
            this.f2558b.networklib.innerSpan.reflection = 0;
        L21:
            this.f2558b.networklib.innerSpan.reflection += System.nanoTime() - r0;
            goto L22
        }
    }

    static {
    }

    public static b a(Class<?> r2) {
        return a(r2, null);
    L5:
        e = move-exception;
        throw new TTReflectIOException(e.getMessage(), e.getCause());
    }

    public static b a(Class<?> r1, RetrofitMetrics r2) {
    L8:
        e = move-exception;
        throw new TTReflectIOException(e.getMessage(), e.getCause());
    L3:
        if (f2554a == false) goto L7;
        return new c(com.bytedance.frameworks.baselib.network.utils.b.a(r1), r2);
    L7:
        return new C0131a(Reflect.on(r1), r2);
    }

    public static b a(Object r2) {
        return a(r2, null);
    L5:
        e = move-exception;
        throw new TTReflectIOException(e.getMessage(), e.getCause());
    }

    public static b a(Object r1, RetrofitMetrics r2) {
    L8:
        e = move-exception;
        throw new TTReflectIOException(e.getMessage(), e.getCause());
    L3:
        if (f2554a == false) goto L7;
        return new c(com.bytedance.frameworks.baselib.network.utils.b.a(r1), r2);
    L7:
        return new C0131a(Reflect.on(r1), r2);
    }

    public static b a(String r2) {
        return a(r2, null);
    L5:
        e = move-exception;
        throw new TTReflectIOException(e.getMessage(), e.getCause());
    }

    public static b a(String r1, RetrofitMetrics r2) {
    L8:
        e = move-exception;
        throw new TTReflectIOException(e.getMessage(), e.getCause());
    L3:
        if (f2554a == false) goto L7;
        return new c(com.bytedance.frameworks.baselib.network.utils.b.a(r1), r2);
    L7:
        return new C0131a(Reflect.on(r1), r2);
    }

    public static void a(boolean r0) {
        f2554a = r0;
    }
}
