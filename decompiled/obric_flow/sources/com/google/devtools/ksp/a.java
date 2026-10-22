package com.google.devtools.ksp;

import bd.d;
import com.google.devtools.ksp.symbol.Visibility;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static final Visibility a() {
        Intrinsics.checkNotNullParameter(null, "<this>");
        throw null;
    }

    public static final void b() {
        Intrinsics.checkNotNullParameter(null, "<this>");
        Intrinsics.checkNotNullParameter(null, "<this>");
        throw null;
    }

    public static final Object[] c(List r5, Method r10, Function1 r11) {
        Object r12 = Array.newInstance(r10.getReturnType().getComponentType(), r5.size());
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] r13 = (Object[]) r12;
        int r14 = r5.size();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L9;
        Object r16 = r5.get(r15);
        if (r16 == null) goto L7;
        Object r17 = r11.invoke(r16);
    L8:
        r13[r15] = r17;
        r15 = r15 + 1;
        goto L3
    L7:
        r17 = null;
        goto L8
    L9:
        return r13;
    }

    public static boolean d(il.a r5) {
        UtilsKt$validate$1 r10 = UtilsKt$validate$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "predicate");
        return ((Boolean) r5.accept(new d(r10), null)).booleanValue();
    }
}
