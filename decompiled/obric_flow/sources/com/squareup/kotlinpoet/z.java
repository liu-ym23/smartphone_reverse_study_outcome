package com.squareup.kotlinpoet;

import ai.j0;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import javax.lang.model.type.TypeMirror;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class z {
    /* JADX WARN: Multi-variable type inference failed */
    public static a0 a(Type r10, LinkedHashMap r11) {
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "map");
        u r5 = null;
        Object[] r12 = 0;
        Object[] r13 = 0;
        if ((r10 instanceof Class) == false) goto L37;
        if (r10 != Void.TYPE) goto L8;
        return b0.f15082c;
    L8:
        if (r10 != Boolean.TYPE) goto L11;
        return b0.d;
    L11:
        if (r10 != Byte.TYPE) goto L14;
        return b0.e;
    L14:
        if (r10 != Short.TYPE) goto L17;
        return b0.f;
    L17:
        if (r10 != Integer.TYPE) goto L20;
        return b0.g;
    L20:
        if (r10 != Long.TYPE) goto L23;
        return b0.f15083h;
    L23:
        if (r10 != Character.TYPE) goto L26;
        return b0.f15084i;
    L26:
        if (r10 != Float.TYPE) goto L29;
        return b0.f15085j;
    L29:
        if (r10 == Double.TYPE) goto L76;
        Class r14 = (Class) r10;
        if (r14.isArray() == false) goto L78;
        c r15 = b0.f15081b;
        a0[] r16 = {a(r14.getComponentType(), r11)};
        Intrinsics.checkNotNullParameter(r15, "<this>");
        Intrinsics.checkNotNullParameter(r16, "typeArguments");
        u r17 = new u(r5, r15, ArraysKt.toList(r16));
    L77:
        return r17;
    L78:
        return mh.e.r(r14);
    L76:
        return b0.f15086k;
    L37:
        if ((r10 instanceof ParameterizedType) == true) goto L79;
        int r18 = 0;
        if ((r10 instanceof WildcardType) == false) goto L49;
        WildcardType r19 = (WildcardType) r10;
        Intrinsics.checkNotNullParameter(r19, "wildcardName");
        Intrinsics.checkNotNullParameter(r11, "map");
        Type[] r20 = r19.getUpperBounds();
        ArrayList r21 = new ArrayList(r20.length);
        int r22 = r20.length;
        int r23 = 0;
    L42:
        if (r23 >= r22) goto L44;
        r21.add(a(r20[r23], r11));
        r23 = r23 + 1;
        goto L42
    L44:
        Type[] r24 = r19.getLowerBounds();
        ArrayList r25 = new ArrayList(r24.length);
        int r26 = r24.length;
    L45:
        if (r18 >= r26) goto L80;
        r25.add(a(r24[r18], r11));
        r18 = r18 + 1;
        goto L45
    L80:
        return new g0(r21, r25);
    L49:
        if ((r10 instanceof TypeVariable) == false) goto L61;
        List r27 = e0.f15133i;
        TypeVariable r28 = (TypeVariable) r10;
        Intrinsics.checkNotNullParameter(r28, "type");
        Intrinsics.checkNotNullParameter(r11, "map");
        e0 r29 = (e0) r11.get(r28);
        if (r29 != null) goto L82;
        ArrayList r30 = new ArrayList();
        e0 r31 = new e0(r28.getName(), Collections.unmodifiableList(r30), r13 == true ? 1 : 0, 124);
        r11.put(r28, r31);
        Type[] r32 = r28.getBounds();
        int r33 = r32.length;
    L53:
        if (r18 >= r33) goto L55;
        r30.add(a(r32[r18], r11));
        r18 = r18 + 1;
        goto L53
    L55:
        r30.remove(b0.f15080a);
        r30.remove(e0.f15134j);
        if (r30.isEmpty() == false) goto L81;
        r30.add(g.f15152b);
    L81:
        return r31;
    L82:
        return r29;
    L61:
        if ((r10 instanceof GenericArrayType) == false) goto L65;
        c r34 = b0.f15081b;
        a0[] r35 = {a(((GenericArrayType) r10).getGenericComponentType(), r11)};
        Intrinsics.checkNotNullParameter(r34, "<this>");
        Intrinsics.checkNotNullParameter(r35, "typeArguments");
        r17 = new u(r12 == true ? 1 : 0, r34, ArraysKt.toList(r35));
        goto L77
    L65:
        throw new IllegalArgumentException(j0.m("unexpected type: ", r10));
    L79:
        return io.reactivex.internal.observers.h.o((ParameterizedType) r10, r11);
    }

    public static a0 b(TypeMirror r5, LinkedHashMap r10) {
        Intrinsics.checkNotNullParameter(r5, "mirror");
        Intrinsics.checkNotNullParameter(r10, "typeVariables");
        return (a0) r5.accept(new y(r10), null);
    }
}
