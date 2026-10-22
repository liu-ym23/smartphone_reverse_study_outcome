package com.bytedance.retrofit2;

import android.os.SystemClock;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
abstract class w<T> {
    w() {
    }

    static <T> w<T> b(t r10, Method r11, RetrofitMetrics r12) {
        r12.f2465u = SystemClock.uptimeMillis();
        s r13 = s.b(r10, r11, r12);
        Type r14 = r11.getGenericReturnType();
        if (c0.l(r14) == true) goto L11;
        if (r14 == Void.TYPE) goto L9;
        r12.f2467v = SystemClock.uptimeMillis();
        return l.f(r10, r11, r13);
    L9:
        throw c0.o(r11, "Service methods cannot return void.", new Object[0]);
    L11:
        throw c0.o(r11, "Method return type must not include a type variable or wildcard: %s", new Object[]{r14});
    }

    abstract T a(Object[] r10);
}
