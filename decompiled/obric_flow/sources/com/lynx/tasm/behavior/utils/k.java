package com.lynx.tasm.behavior.utils;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.d0;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f10798a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap f10799b = null;

    static {
        f10798a = new ConcurrentHashMap();
        f10799b = new HashMap();
    }

    public static j a(c0 r5, Method r10, Class r11) {
        if (r11 != pm.a.class) goto L7;
        return new e(r5, r10, 3);
    L7:
        if (r11 != Boolean.TYPE) goto L11;
        return new f(r5, r10, r5.defaultBoolean());
    L11:
        if (r11 != Integer.TYPE) goto L15;
        return new i(r5, r10, r5.defaultInt());
    L15:
        if (r11 != Float.TYPE) goto L19;
        return new h(r5, r10, r5.defaultFloat());
    L19:
        if (r11 != Double.TYPE) goto L23;
        return new g(r5, r10, r5.defaultDouble());
    L23:
        if (r11 != String.class) goto L27;
        return new e(r5, r10, 5);
    L27:
        if (r11 != Boolean.class) goto L31;
        return new e(r5, r10, 1);
    L31:
        if (r11 != Integer.class) goto L35;
        return new e(r5, r10, 2);
    L35:
        if (r11 != ReadableArray.class) goto L39;
        return new e(r5, r10, 0);
    L39:
        if (r11 != ReadableMap.class) goto L43;
        return new e(r5, r10, 4);
    L43:
        throw new RuntimeException("Unrecognized type: " + r11 + " for method: " + r10.getDeclaringClass().getName() + "#" + r10.getName());
    }

    public static Map b(Class r13) {
        if (r13 == null) goto L4;
        ConcurrentHashMap r5 = f10798a;
        Map r10 = (Map) r5.get(r13);
        if (r10 == null) goto L8;
        return r10;
    L8:
        HashMap r11 = new HashMap();
        if (r13 != LynxBaseUI.class) goto L11;
        Class r12 = null;
    L12:
        r11.putAll(b(r12));
        Method[] r14 = r13.getDeclaredMethods();
        int r15 = r14.length;
        int r16 = 0;
    L13:
        if (r16 >= r15) goto L33;
        Method r17 = r14[r16];
        c0 r18 = (c0) r17.getAnnotation(c0.class);
        if (r18 == null) goto L21;
        Class<?>[] r19 = r17.getParameterTypes();
        if (r19.length != 1) goto L20;
        r11.put(r18.name(), a(r18, r17, r19[0]));
        goto L21
    L20:
        throw new RuntimeException("Wrong number of args for prop setter: " + r13.getName() + "#" + r17.getName());
    L21:
        d0 r20 = (d0) r17.getAnnotation(d0.class);
        if (r20 == null) goto L32;
        Class<?>[] r110 = r17.getParameterTypes();
        if (r110.length != 2) goto L31;
        if (r110[0] != Integer.TYPE) goto L29;
        c(r20, r17, r110[1], r11);
        goto L32
    L29:
        throw new RuntimeException("Second argument should be property index: " + r13.getName() + "#" + r17.getName());
    L31:
        throw new RuntimeException("Wrong number of args for group prop setter: " + r13.getName() + "#" + r17.getName());
    L32:
        r16 = r16 + 1;
        goto L13
    L33:
        r5.put(r13, r11);
        return r11;
    L11:
        r12 = r13.getSuperclass();
        goto L12
    L4:
        return f10799b;
    }

    public static void c(d0 r10, Method r11, Class r12, HashMap r13) {
        String[] r5 = r10.names();
        int r14 = 0;
        if (r12 != pm.a.class) goto L8;
    L5:
        if (r14 >= r5.length) goto L37;
        r13.put(r5[r14], new e(r10, r11, r14, 3));
        r14 = r14 + 1;
        goto L5
    L37:
        return;
    L8:
        if (r12 != Integer.TYPE) goto L13;
    L10:
        if (r14 >= r5.length) goto L47;
        r13.put(r5[r14], new i(r10, r11, r14, r10.defaultInt()));
        r14 = r14 + 1;
        goto L10
    L47:
        return;
    L13:
        if (r12 != Float.TYPE) goto L18;
    L15:
        if (r14 >= r5.length) goto L48;
        r13.put(r5[r14], new h(r10, r11, r14, r10.defaultFloat()));
        r14 = r14 + 1;
        goto L15
    L48:
        return;
    L18:
        if (r12 != Double.TYPE) goto L23;
    L20:
        if (r14 >= r5.length) goto L49;
        r13.put(r5[r14], new g(r10, r11, r14, r10.defaultDouble()));
        r14 = r14 + 1;
        goto L20
    L49:
        return;
    L23:
        if (r12 != Integer.class) goto L28;
    L25:
        if (r14 >= r5.length) goto L50;
        r13.put(r5[r14], new e(r10, r11, r14, 2));
        r14 = r14 + 1;
        goto L25
    L50:
        return;
    L28:
        if (r12 != String.class) goto L33;
    L30:
        if (r14 >= r5.length) goto L51;
        r13.put(r5[r14], new e(r10, r11, r14, 5));
        r14 = r14 + 1;
        goto L30
    L51:
        return;
    L33:
        if (r12 != ReadableArray.class) goto L39;
    L35:
        if (r14 >= r5.length) goto L52;
        r13.put(r5[r14], new e(r10, r11, r14, 0));
        r14 = r14 + 1;
        goto L35
    L52:
        return;
    L39:
        throw new RuntimeException("Unrecognized type: " + r12 + " for method: " + r11.getDeclaringClass().getName() + "#" + r11.getName());
    }

    public static Map d(Class r13) {
        if (r13 == null) goto L4;
        ConcurrentHashMap r5 = f10798a;
        Map r10 = (Map) r5.get(r13);
        if (r10 == null) goto L8;
        return r10;
    L8:
        HashMap r11 = new HashMap();
        if (r13 != ShadowNode.class) goto L11;
        Class r12 = null;
    L12:
        r11.putAll(d(r12));
        Method[] r14 = r13.getDeclaredMethods();
        int r15 = r14.length;
        int r16 = 0;
    L13:
        if (r16 >= r15) goto L33;
        Method r17 = r14[r16];
        c0 r18 = (c0) r17.getAnnotation(c0.class);
        if (r18 == null) goto L21;
        Class<?>[] r19 = r17.getParameterTypes();
        if (r19.length != 1) goto L20;
        r11.put(r18.name(), a(r18, r17, r19[0]));
        goto L21
    L20:
        throw new RuntimeException("Wrong number of args for prop setter: " + r13.getName() + "#" + r17.getName());
    L21:
        d0 r20 = (d0) r17.getAnnotation(d0.class);
        if (r20 == null) goto L32;
        Class<?>[] r110 = r17.getParameterTypes();
        if (r110.length != 2) goto L31;
        if (r110[0] != Integer.TYPE) goto L29;
        c(r20, r17, r110[1], r11);
        goto L32
    L29:
        throw new RuntimeException("Second argument should be property index: " + r13.getName() + "#" + r17.getName());
    L31:
        throw new RuntimeException("Wrong number of args for group prop setter: " + r13.getName() + "#" + r17.getName());
    L32:
        r16 = r16 + 1;
        goto L13
    L33:
        r5.put(r13, r11);
        return r11;
    L11:
        r12 = r13.getSuperclass();
        goto L12
    L4:
        return f10799b;
    }
}
