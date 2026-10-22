package com.bytedance.retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
abstract class ServiceMethod<T> {
    ServiceMethod() {
    }

    static <T> ServiceMethod<T> parseAnnotations(Retrofit r4, Method r5, RetrofitMetrics r6) {
        r6.createRequestFactoryStart();
        RequestFactory r0 = RequestFactory.parseAnnotations(r4, r5, r6);     // Catch: Throwable -> L19
        r6.createRequestFactoryEnd();
        Type r1 = r5.getGenericReturnType();
        if (Utils.hasUnresolvableType(r1) == true) goto L18;
        if (r1 == Void.TYPE) goto L16;
        r6.createHttpServiceMethodStart();
        HttpServiceMethod r7 = HttpServiceMethod.parseAnnotations(r4, r5, r0);     // Catch: Throwable -> L12
        r6.createHttpServiceMethodEnd();
        return r7;
    L12:
        th = move-exception;
        r6.createHttpServiceMethodEnd();
        throw th;
    L16:
        throw Utils.methodError(r5, "Service methods cannot return void.", new Object[0]);
    L18:
        throw Utils.methodError(r5, "Method return type must not include a type variable or wildcard: %s", new Object[]{r1});
    L19:
        th = move-exception;
        r6.createRequestFactoryEnd();
        throw th;
    }

    abstract T invoke(Object[] r1);
}
