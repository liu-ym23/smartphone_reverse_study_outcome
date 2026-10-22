package com.bytedance.android.ec.core.abtest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final c a = null;

    public c() {
    }

    static {
        a = new c();
    }

    public static String a(yf7.j.a r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L43
        Method[] r11 = r10.getClass().getMethods();     // Catch: Throwable -> L43
        int r12 = r11.length;     // Catch: Throwable -> L43
        int r13 = 0;
        int r14 = 0;
    L5:
        if (r14 >= r12) goto L18;
        Method r15 = r11[r14];     // Catch: Throwable -> L43
        if (Intrinsics.areEqual(r15.getName(), "getMsgId") == true) goto L9;
    L14:
        boolean r16 = false;
    L15:
        if (r16 == true) goto L19;
        r14 = r14 + 1;     // Catch: Throwable -> L43
    L19:
        if (r15 == null) goto L21;
        Object r17 = r15.invoke(r10, new Object[0]);     // Catch: Throwable -> L43
    L23:
        if ((r17 instanceof String) == false) goto L25;
        String r18 = (String) r17;     // Catch: Throwable -> L43
    L41:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L43
    L46:
        if (Result.isFailure-impl(r19) == true) goto L50;
        r0 = r19;
    L50:
        return (String) r0;
    L25:
        Field[] r20 = yf7.j.a.class.getDeclaredFields();     // Catch: Throwable -> L43
        int r21 = r20.length;     // Catch: Throwable -> L43
    L26:
        if (r13 >= r21) goto L31;
        Field r22 = r20[r13];     // Catch: Throwable -> L43
        if (Intrinsics.areEqual(r22.getName(), "msgId") == true) goto L32;
        r13 = r13 + 1;     // Catch: Throwable -> L43
    L32:
        if (r22 == null) goto L34;
        r22.setAccessible(true);     // Catch: Throwable -> L43
    L34:
        if (r22 == null) goto L36;
        Object r23 = r22.get(r10);     // Catch: Throwable -> L43
    L38:
        if ((r23 instanceof String) == true) goto L40;
        r23 = null;
    L40:
        r18 = (String) r23;     // Catch: Throwable -> L43
        goto L41
    L36:
        r23 = null;
        goto L38
    L31:
        r22 = null;
        goto L32
    L21:
        r17 = null;
        goto L23
    L9:
        if (r15.getParameterTypes().length != 0) goto L11;
        boolean r24 = true;
    L12:
        if (r24 == false) goto L14;
        r16 = true;
        goto L15
    L11:
        r24 = false;
        goto L12
    L18:
        r15 = null;
    L43:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L46
    }
}
