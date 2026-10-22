package com.google.common.cache;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
public final class x0 implements PrivilegedExceptionAction {
    public x0() {
    }

    public static Unsafe a() {
        Field[] r5 = Unsafe.class.getDeclaredFields();
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L10;
        Field r12 = r5[r11];
        r12.setAccessible(true);
        Object r13 = r12.get(null);
        if (Unsafe.class.isInstance(r13) == true) goto L7;
        r11 = r11 + 1;
        goto L3
    L7:
        return (Unsafe) Unsafe.class.cast(r13);
    L10:
        throw new NoSuchFieldError("the Unsafe");
    }

    @Override // java.security.PrivilegedExceptionAction
    public final /* bridge */ /* synthetic */ Object run() {
        return a();
    }
}
