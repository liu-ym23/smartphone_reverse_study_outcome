package com.google.common.util.concurrent;

import com.google.common.collect.g8;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g8 f9433a = null;

    static {
        f9433a = g8.natural().onResultOf(new q0()).reverse();
    }

    public static void a(Class r5) {
        boolean r10 = true;
        com.google.common.base.b0.h("Futures.getChecked exception type (%s) must not be a RuntimeException", !RuntimeException.class.isAssignableFrom(r5), r5);
        b(r5, new Exception());     // Catch: Exception -> L5
    L6:
        com.google.common.base.b0.h("Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", r10, r5);
        return;
    L5:
        r10 = false;
        goto L6
    }

    public static void b(Class r10, Exception r11) {
        List r5 = Arrays.asList(r10.getConstructors());
        Iterator r12 = f9433a.sortedCopy(r5).iterator();
    L4:
        if (r12.hasNext() == false) goto L22;
        Constructor r13 = (Constructor) r12.next();
        Class<?>[] r14 = r13.getParameterTypes();
        Object[] r15 = new Object[r14.length];
        int r16 = 0;
    L6:
        Object r17 = null;
        if (r16 >= r14.length) goto L25;
        Class<?> r18 = r14[r16];
        if (r18.equals(String.class) == false) goto L12;
        r15[r16] = r11.toString();
    L14:
        r16 = r16 + 1;
        goto L6
    L12:
        if (r18.equals(Throwable.class) == false) goto L16;
        r15[r16] = r11;
    L16:
        Exception r19 = (Exception) r17;
        if (r19 == null) goto L4;
        if (r19.getCause() != null) goto L33;
        r19.initCause(r11);
        return;
    L33:
        return;
    L25:
        r17 = r13.newInstance(r15);     // Catch: Throwable -> L24
        goto L16
    L22:
        String r20 = String.valueOf(r10);
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.m(r20.length() + 82, "No appropriate constructor for exception of type ", r20, " in response to chained exception"), r11);
    }
}
