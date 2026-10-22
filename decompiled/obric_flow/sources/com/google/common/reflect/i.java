package com.google.common.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f9361b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f9362a;

    static {
        f9361b = new i(new AtomicInteger());
    }

    public i(AtomicInteger r5) {
        this.f9362a = r5;
    }

    public final Type a(Type r10) {
        r10.getClass();
        if ((r10 instanceof Class) == false) goto L6;
        return r10;
    L6:
        if ((r10 instanceof TypeVariable) == false) goto L8;
        return r10;
    L8:
        boolean r5 = r10 instanceof GenericArrayType;
        AtomicInteger r11 = this.f9362a;
        if (r5 == false) goto L13;
        return y.d(new i(r11).a(((GenericArrayType) r10).getGenericComponentType()));
    L13:
        if ((r10 instanceof ParameterizedType) == false) goto L25;
        ParameterizedType r12 = (ParameterizedType) r10;
        Class r13 = (Class) r12.getRawType();
        TypeVariable[] r14 = r13.getTypeParameters();
        Type[] r15 = r12.getActualTypeArguments();
        int r16 = 0;
    L16:
        if (r16 >= r15.length) goto L18;
        r15[r16] = new h(r11, r14[r16]).a(r15[r16]);
        r16 = r16 + 1;
        goto L16
    L18:
        i r17 = new i(r11);
        Type r18 = r12.getOwnerType();
        if (r18 != null) goto L21;
        Type r19 = null;
    L23:
        return y.f(r19, r13, r15);
    L21:
        r19 = r17.a(r18);
        goto L23
    L25:
        if ((r10 instanceof WildcardType) == false) goto L32;
        WildcardType r20 = (WildcardType) r10;
        if (r20.getLowerBounds().length == 0) goto L29;
        return r10;
    L29:
        return b(r20.getUpperBounds());
    L32:
        throw new AssertionError("must have been one of the known types");
    }

    public TypeVariable b(Type[] r5) {
        int r10 = this.f9362a.incrementAndGet();
        String r11 = new com.google.common.base.u(String.valueOf(Typography.amp), 0).a(Arrays.asList(r5));
        StringBuilder r12 = new StringBuilder(androidx.room.jarjarred.org.antlr.runtime.a.g(33, r11));
        r12.append("capture#");
        r12.append(r10);
        r12.append("-of ? extends ");
        r12.append(r11);
        return y.e(i.class, r12.toString(), r5);
    }
}
