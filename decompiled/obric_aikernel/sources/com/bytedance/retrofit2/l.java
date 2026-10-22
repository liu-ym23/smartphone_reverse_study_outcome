package com.bytedance.retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes.dex */
abstract class l<ResponseT, ReturnT> extends w<ReturnT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final s<ReturnT> f2523a;

    static final class a<ResponseT, ReturnT> extends l<ResponseT, ReturnT> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bytedance.retrofit2.c<ResponseT, ReturnT> f2524b;

        a(s r10, com.bytedance.retrofit2.c<ResponseT, ReturnT> r11) {
            super(r10);
            this.f2524b = r11;
        }

        @Override // com.bytedance.retrofit2.l
        protected ReturnT c(com.bytedance.retrofit2.b<ResponseT> r10, Object[] r11) {
            return this.f2524b.b(r10);
        }
    }

    static final class b<ResponseT> extends l<ResponseT, Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bytedance.retrofit2.c<ResponseT, com.bytedance.retrofit2.b<ResponseT>> f2525b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f2526c;

        b(s r10, com.bytedance.retrofit2.c<ResponseT, com.bytedance.retrofit2.b<ResponseT>> r11, boolean r12) {
            super(r10);
            this.f2525b = r11;
            this.f2526c = r12;
        }

        @Override // com.bytedance.retrofit2.l
        protected Object c(com.bytedance.retrofit2.b<ResponseT> r10, Object[] r11) {
            com.bytedance.retrofit2.b<ResponseT> r12 = this.f2525b.b(r10);
            Continuation r13 = (Continuation) r11[r11.length - 1];
        L8:
            e = move-exception;
            return KotlinExtensions.d(e, r13);
        L4:
            if (this.f2526c == false) goto L7;
            return KotlinExtensions.b(r12, r13);
        L7:
            return KotlinExtensions.a(r12, r13);
        }
    }

    static final class c<ResponseT> extends l<ResponseT, Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bytedance.retrofit2.c<ResponseT, com.bytedance.retrofit2.b<ResponseT>> f2527b;

        c(s r10, com.bytedance.retrofit2.c<ResponseT, com.bytedance.retrofit2.b<ResponseT>> r11) {
            super(r10);
            this.f2527b = r11;
        }

        @Override // com.bytedance.retrofit2.l
        protected Object c(com.bytedance.retrofit2.b<ResponseT> r10, Object[] r11) {
            com.bytedance.retrofit2.b<ResponseT> r12 = this.f2527b.b(r10);
            Continuation r13 = (Continuation) r11[r11.length - 1];
            return KotlinExtensions.c(r12, r13);
        L5:
            e = move-exception;
            return KotlinExtensions.d(e, r13);
        }
    }

    l(s<ReturnT> r10) {
        this.f2523a = r10;
    }

    private static <ResponseT, ReturnT> com.bytedance.retrofit2.c<ResponseT, ReturnT> d(t r10, Method r11, Type r12, Annotation[] r13) {
        return (com.bytedance.retrofit2.c<ResponseT, ReturnT>) r10.c(r12, r13);
    L4:
        e = move-exception;
        throw c0.p(r11, e, "Unable to create call adapter for %s", new Object[]{r12});
    }

    private static <ResponseT> f<r4.e, ResponseT> e(t r10, Method r11, Type r12) {
        return r10.q(r12, r11.getAnnotations());
    L5:
        e = move-exception;
        throw c0.p(r11, e, "Unable to create converter for %s", new Object[]{r12});
    }

    static <ResponseT, ReturnT> l<ResponseT, ReturnT> f(t r10, Method r11, s r12) {
        boolean r13 = r12.f2646a;
        Annotation[] r14 = r11.getAnnotations();
        if (r13 == false) goto L11;
        Type[] r15 = r11.getGenericParameterTypes();
        Type r16 = c0.h(0, (ParameterizedType) r15[r15.length - 1]);
        if (c0.j(r16) == a0.class) goto L7;
    L9:
        boolean r17 = false;
    L10:
        Type r18 = new c0.c(null, com.bytedance.retrofit2.b.class, new Type[]{r16});
        r14 = y.a(r14);
    L12:
        com.bytedance.retrofit2.c r19 = d(r10, r11, r18, r14);
        Type r20 = r19.a();
        if (r20 == okhttp3.z.class) goto L38;
        if (r20 == a0.class) goto L36;
        if (r20 == n4.d.class) goto L34;
        if (r12.f2662q.equals("HEAD") == true) goto L20;
    L24:
        r12.f2661p = e(r10, r11, r20);
        if (r13 == false) goto L27;
        if (r17 == false) goto L32;
        return new c(r12, r19);
    L32:
        return new b(r12, r19, false);
    L27:
        return new a(r12, r19);
    L20:
        if (Void.class.equals(r20) == true) goto L24;
        throw c0.o(r11, "HEAD method must use Void as response type.", new Object[0]);
    L34:
        throw c0.o(r11, "'" + c0.j(r20).getName() + "' is not a valid response body type.", new Object[0]);
    L36:
        throw c0.o(r11, "Response must include generic type (e.g., SsResponse<String>)", new Object[0]);
    L38:
        throw c0.o(r11, "'" + c0.j(r20).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
    L7:
        if ((r16 instanceof ParameterizedType) == false) goto L9;
        r16 = c0.i(0, (ParameterizedType) r16);
        r17 = true;
        goto L10
    L11:
        r18 = r11.getGenericReturnType();
        r17 = false;
        goto L12
    }

    @Override // com.bytedance.retrofit2.w
    final ReturnT a(Object[] r10) {
        return c(new z(this.f2523a, r10), r10);
    }

    protected abstract ReturnT c(com.bytedance.retrofit2.b<ResponseT> r10, Object[] r11);
}
