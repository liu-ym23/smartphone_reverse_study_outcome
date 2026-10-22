package com.google.common.reflect;

import com.google.common.base.b0;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.common.base.t f9380a = null;

    static {
        com.google.common.base.u r5 = new com.google.common.base.u(", ", 0);
        f9380a = new com.google.common.base.t(r5, r5);
    }

    public static Type a(Type[] r5) {
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L13;
        Type r12 = c(r5[r11]);
        if (r12 != null) goto L7;
        r11 = r11 + 1;
        goto L3
    L7:
        if ((r12 instanceof Class) == false) goto L17;
        Class r13 = (Class) r12;
        if (r13.isPrimitive() == false) goto L17;
        return r13;
    L17:
        return new Types$WildcardTypeImpl(new Type[0], new Type[]{r12});
    L13:
        return null;
    }

    public static void b(Type[] r5, String r10) {
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        Type r13 = r5[r12];
        if ((r13 instanceof Class) == false) goto L7;
        Class r14 = (Class) r13;
        b0.k(!r14.isPrimitive(), "Primitive type '%s' used as %s", r14, r10);
    L7:
        r12 = r12 + 1;
        goto L3
    }

    public static Type c(Type r5) {
        r5.getClass();
        AtomicReference r10 = new AtomicReference();
        new r(r10).z(new Type[]{r5});
        return (Type) r10.get();
    }

    public static Type d(Type r5) {
        if ((r5 instanceof WildcardType) == false) goto L19;
        WildcardType r10 = (WildcardType) r5;
        Type[] r11 = r10.getLowerBounds();
        if (r11.length > 1) goto L7;
        boolean r12 = true;
    L8:
        b0.g("Wildcard cannot have more than one lower bounds.", r12);
        if (r11.length == 1) goto L11;
        Type[] r13 = r10.getUpperBounds();
        if (r13.length != 1) goto L15;
        boolean r14 = true;
    L16:
        b0.g("Wildcard should have only one upper bound.", r14);
        return new Types$WildcardTypeImpl(new Type[0], new Type[]{d(r13[0])});
    L15:
        r14 = false;
        goto L16
    L11:
        return new Types$WildcardTypeImpl(new Type[]{d(r11[0])}, new Type[]{Object.class});
    L7:
        r12 = false;
        goto L8
    L19:
        return Types$JavaVersion.CURRENT.newArrayType(r5);
    }

    public static TypeVariable e(GenericDeclaration r5, String r10, Type... r11) {
        if (r11.length != 0) goto L5;
        r11 = new Type[]{Object.class};
    L5:
        x r12 = new x(new w(r5, r10, r11));
        b0.h("%s is not an interface", TypeVariable.class.isInterface(), TypeVariable.class);
        return (TypeVariable) TypeVariable.class.cast(Proxy.newProxyInstance(TypeVariable.class.getClassLoader(), new Class[]{TypeVariable.class}, r12));
    }

    public static ParameterizedType f(Type r5, Class r10, Type... r11) {
        if (r5 == null) goto L4;
        r11.getClass();
        if (r10.getEnclosingClass() == null) goto L8;
        boolean r12 = true;
    L9:
        b0.h("Owner type for unenclosed %s", r12, r10);
        return new Types$ParameterizedTypeImpl(r5, r10, r11);
    L8:
        r12 = false;
        goto L9
    L4:
        return new Types$ParameterizedTypeImpl(Types$ClassOwnership.JVM_BEHAVIOR.getOwnerType(r10), r10, r11);
    }
}
