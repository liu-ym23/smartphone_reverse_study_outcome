package com.google.common.reflect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.u3;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes2.dex */
abstract enum Types$JavaVersion extends Enum<Types$JavaVersion> {
    static final Types$JavaVersion CURRENT = null;
    public static final Types$JavaVersion JAVA6 = null;
    public static final Types$JavaVersion JAVA7 = null;
    public static final Types$JavaVersion JAVA8 = null;
    public static final Types$JavaVersion JAVA9 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Types$JavaVersion[] f9353a = null;

    static {
        final String r5 = "JAVA6";
        final int r10 = 0;
        Types$JavaVersion r11 = new AnonymousClass1(r5, r10);
        JAVA6 = r11;
        final String r12 = "JAVA7";
        final int r13 = 1;
        Types$JavaVersion r14 = new AnonymousClass2(r12, r13);
        JAVA7 = r14;
        final String r15 = "JAVA8";
        final int r16 = 2;
        Types$JavaVersion r17 = new AnonymousClass3(r15, r16);
        JAVA8 = r17;
        final String r18 = "JAVA9";
        final int r19 = 3;
        Types$JavaVersion r20 = new AnonymousClass4(r18, r19);
        JAVA9 = r20;
        f9353a = new Types$JavaVersion[]{r11, r14, r17, r20};
        if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class) == false) goto L9;
        if (new t().capture().toString().contains("java.util.Map.java.util.Map") == false) goto L7;
        CURRENT = r17;
        return;
    L7:
        CURRENT = r20;
        return;
    L9:
        if ((new t().capture() instanceof Class) == false) goto L11;
        CURRENT = r14;
        return;
    L11:
        CURRENT = r11;
    }

    public Types$JavaVersion(String r5, int r10, r r11) {
        super(r5, r10);
    }

    public static Types$JavaVersion valueOf(String r5) {
        return (Types$JavaVersion) Enum.valueOf(Types$JavaVersion.class, r5);
    }

    public static Types$JavaVersion[] values() {
        return (Types$JavaVersion[]) f9353a.clone();
    }

    public boolean jdkTypeDuplicatesOwnerName() {
        return true;
    }

    public abstract Type newArrayType(Type r5);

    public String typeName(Type r5) {
        com.google.common.base.t r10 = y.f9380a;
        if ((r5 instanceof Class) == false) goto L6;
        return ((Class) r5).getName();
    L6:
        return r5.toString();
    }

    public final ImmutableList<Type> usedInGenericType(Type[] r5) {
        u3 r10 = ImmutableList.builder();
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        r10.B0(usedInGenericType(r5[r12]));
        r12 = r12 + 1;
        goto L3
    L6:
        return r10.D0();
    }

    public abstract Type usedInGenericType(Type r5);
}
