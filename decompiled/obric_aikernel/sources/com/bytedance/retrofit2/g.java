package com.bytedance.retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
final class g extends c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final c.a f2509a = null;

    class a implements c<Object, b<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f2510a;

        a(g r10, Type r11) {
            this.f2510a = r11;
        }

        @Override // com.bytedance.retrofit2.c
        public Type a() {
            return this.f2510a;
        }

        @Override // com.bytedance.retrofit2.c
        public /* bridge */ /* synthetic */ b<?> b(b<Object> r10) {
            return c(r10);
        }

        public b<Object> c(b<Object> r10) {
            return r10;
        }
    }

    static {
        f2509a = new g();
    }

    g() {
    }

    @Override // com.bytedance.retrofit2.c.a
    public c<?, ?> a(Type r10, Annotation[] r11, t r12) {
        if (c.a.b(r10) == b.class) goto L7;
        return null;
    L7:
        return new a(this, c0.f(r10));
    }
}
