package com.google.common.primitives;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f9340a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f9341b = null;

    static {
        LinkedHashMap r5 = new LinkedHashMap(16);
        LinkedHashMap r10 = new LinkedHashMap(16);
        Class r11 = Boolean.TYPE;
        r5.put(r11, Boolean.class);
        r10.put(Boolean.class, r11);
        Class r12 = Byte.TYPE;
        r5.put(r12, Byte.class);
        r10.put(Byte.class, r12);
        Class r13 = Character.TYPE;
        r5.put(r13, Character.class);
        r10.put(Character.class, r13);
        Class r14 = Double.TYPE;
        r5.put(r14, Double.class);
        r10.put(Double.class, r14);
        Class r15 = Float.TYPE;
        r5.put(r15, Float.class);
        r10.put(Float.class, r15);
        Class r16 = Integer.TYPE;
        r5.put(r16, Integer.class);
        r10.put(Integer.class, r16);
        Class r17 = Long.TYPE;
        r5.put(r17, Long.class);
        r10.put(Long.class, r17);
        Class r18 = Short.TYPE;
        r5.put(r18, Short.class);
        r10.put(Short.class, r18);
        Class r19 = Void.TYPE;
        r5.put(r19, Void.class);
        r10.put(Void.class, r19);
        f9340a = Collections.unmodifiableMap(r5);
        f9341b = Collections.unmodifiableMap(r10);
    }
}
