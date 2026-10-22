package com.google.common.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final sj.k f9363a;

    public j() {
        this.f9363a = new sj.k(5);
    }

    public static void a(HashMap r5, Type r10, Type r11) {
        if (r10.equals(r11) == false) goto L5;
        return;
    L5:
        new d(r5, r11).z(new Type[]{r10});
    }

    public final Type b(Type r5) {
        r5.getClass();
        if ((r5 instanceof TypeVariable) == false) goto L7;
        TypeVariable r10 = (TypeVariable) r5;
        sj.k r11 = this.f9363a;
        r11.getClass();
        return r11.n(r10, new f(r10, r11));
    L7:
        if ((r5 instanceof ParameterizedType) == false) goto L15;
        ParameterizedType r12 = (ParameterizedType) r5;
        Type r13 = r12.getOwnerType();
        if (r13 != null) goto L11;
        Type r14 = null;
    L12:
        Type r15 = b(r12.getRawType());
        Class r16 = (Class) r15;
        return y.f(r14, r16, c(r12.getActualTypeArguments()));
    L11:
        r14 = b(r13);
        goto L12
    L15:
        if ((r5 instanceof GenericArrayType) == false) goto L19;
        return y.d(b(((GenericArrayType) r5).getGenericComponentType()));
    L19:
        if ((r5 instanceof WildcardType) == false) goto L22;
        WildcardType r17 = (WildcardType) r5;
        Type[] r18 = r17.getLowerBounds();
        Type[] r19 = r17.getUpperBounds();
        return new Types$WildcardTypeImpl(c(r18), c(r19));
    L22:
        return r5;
    }

    public final Type[] c(Type[] r5) {
        Type[] r10 = new Type[r5.length];
        int r11 = 0;
    L4:
        if (r11 >= r5.length) goto L6;
        r10[r11] = b(r5[r11]);
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    public j(sj.k r5) {
        this.f9363a = r5;
    }
}
