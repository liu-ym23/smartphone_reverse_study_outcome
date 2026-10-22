package com.google.common.reflect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.x3;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.security.AccessControlException;

/* JADX INFO: loaded from: classes2.dex */
public final class x implements InvocationHandler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ImmutableMap f9378b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f9379a;

    static {
        x3 r5 = ImmutableMap.builder();
        Method[] r10 = w.class.getMethods();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L10;
        Method r13 = r10[r12];
        if (r13.getDeclaringClass().equals(w.class) == false) goto L9;
        r13.setAccessible(true);     // Catch: AccessControlException -> L12
    L8:
        r5.g(r13.getName(), r13);
    L9:
        r12 = r12 + 1;
        goto L3
    L10:
        f9378b = r5.c();
    }

    public x(w r5) {
        this.f9379a = r5;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r5, Method r10, Object[] r11) {
        String r12 = r10.getName();
        Method r13 = (Method) f9378b.get(r12);
        if (r13 == null) goto L10;
        return r13.invoke(this.f9379a, r11);
    L6:
        e = move-exception;
        throw e.getCause();
    L10:
        throw new UnsupportedOperationException(r12);
    }
}
