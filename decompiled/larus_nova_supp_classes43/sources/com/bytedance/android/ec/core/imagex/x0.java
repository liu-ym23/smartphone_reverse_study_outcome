package com.bytedance.android.ec.core.imagex;

import com.facebook.imagepipeline.image.CloseableImage;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class x0 implements InvocationHandler {
    public final /* synthetic */ Function3 a;

    public x0(Function3 r1) {
        this.a = r1;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r10, Method r11, Object[] r12) {
        String r13 = r11.getName();
        boolean r1 = true;
        Object r14 = null;
        switch(r13.hashCode()) {
            case -2043700309: goto L20;
            case -1776922004: goto L17;
            case -1295482945: goto L9;
            case 147696667: goto L6;
            default: goto L51;
        };
    L51:
        return null;
    L6:
        if (r13.equals("hashCode") == true) goto L45;
        return null;
    L45:
        return Integer.valueOf(System.identityHashCode(r10));
    L9:
        if (r13.equals("equals") == false) goto L46;
        if (r12 == null) goto L12;
        r14 = ArraysKt.getOrNull(r12, 0);
    L12:
        if (r10 == r14) goto L47;
        r1 = false;
    L47:
        return Boolean.valueOf(r1);
    L46:
        return null;
    L17:
        if (r13.equals("toString") == false) goto L48;
        return "SimpleDecodeCallBackProxy";
    L48:
        return null;
    L20:
        if (r13.equals("decodeResult") == false) goto L50;
        Function3 r15 = this.a;
        if (r12 == null) goto L24;
        Object r16 = ArraysKt.getOrNull(r12, 0);
    L26:
        if ((r16 instanceof Boolean) == true) goto L28;
        r16 = null;
    L28:
        Boolean r17 = Boolean.valueOf(Intrinsics.areEqual((Boolean) r16, Boolean.TRUE));
        if (r12 == null) goto L31;
        Object r0 = ArraysKt.getOrNull(r12, 1);
    L33:
        if ((r0 instanceof CloseableImage) == true) goto L35;
        r0 = null;
    L35:
        CloseableImage r18 = (CloseableImage) r0;
        if (r12 == null) goto L38;
        Object r19 = ArraysKt.getOrNull(r12, 2);
    L40:
        if ((r19 instanceof String) == true) goto L42;
        r19 = null;
    L42:
        r15.invoke(r17, r18, (String) r19);
        return null;
    L38:
        r19 = null;
        goto L40
    L31:
        r0 = null;
        goto L33
    L24:
        r16 = null;
        goto L26
    L50:
        return null;
    }
}
