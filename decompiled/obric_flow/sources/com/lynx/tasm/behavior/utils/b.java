package com.lynx.tasm.behavior.utils;

import com.lynx.tasm.behavior.f0;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f10790a = null;

    static {
        f10790a = new HashMap();
    }

    public static HashMap a(Class r10) {
        HashMap r5 = f10790a;
        if (r5.containsKey(r10) == true) goto L5;
        HashMap r11 = new HashMap();
        Method[] r12 = r10.getDeclaredMethods();
        int r13 = r12.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L12;
        Method r15 = r12[r14];
        if (((f0) r15.getAnnotation(f0.class)) == null) goto L11;
        r11.put(r15.getName(), r15);
    L11:
        r14 = r14 + 1;
        goto L7
    L12:
        Class r16 = r10.getSuperclass();
        if (r16 == null) goto L15;
        r11.putAll(a(r16));
    L15:
        r5.put(r10, r11);
        return r11;
    L5:
        return (HashMap) r5.get(r10);
    }
}
