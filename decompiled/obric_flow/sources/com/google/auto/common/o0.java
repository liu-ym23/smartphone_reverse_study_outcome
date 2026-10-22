package com.google.auto.common;

import com.google.common.collect.ImmutableSet;
import java.util.List;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Types;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o0 {
    public static ArrayType a(TypeMirror r5) {
        return (ArrayType) r5.accept(e0.a(), null);
    }

    public static DeclaredType b(TypeMirror r5) {
        return (DeclaredType) r5.accept(h0.a(), null);
    }

    public static Element c(TypeMirror r5) {
        return (Element) r5.accept(f0.a(), null);
    }

    public static ExecutableType d(TypeMirror r5) {
        return (ExecutableType) r5.accept(j0.a(), null);
    }

    public static TypeMirror e(Types r5, DeclaredType r10, VariableElement r11) {
        if (r11.getKind().equals(ElementKind.PARAMETER) == false) goto L19;
        ExecutableElement r12 = d0.a(r11.getEnclosingElement());
        ExecutableType r13 = d(r5.asMemberOf(r10, r12));
        List r14 = r12.getParameters();
        List r15 = r13.getParameterTypes();
        int r16 = 0;
        if (r14.size() != r15.size()) goto L7;
        boolean r17 = true;
    L8:
        com.google.common.base.b0.t(r17);
    L10:
        if (r16 >= r14.size()) goto L16;
        if (((VariableElement) r14.get(r16)).equals(r11) == true) goto L14;
        r16 = r16 + 1;
        goto L10
    L14:
        return (TypeMirror) r15.get(r16);
    L16:
        String r18 = String.valueOf(r11);
        throw new IllegalStateException(androidx.room.jarjarred.org.antlr.runtime.a.l(r18.length() + 25, "Could not find variable: ", r18));
    L7:
        r17 = false;
        goto L8
    L19:
        return r5.asMemberOf(r10, r11);
    }

    public static PrimitiveType f(TypeMirror r5) {
        return (PrimitiveType) r5.accept(m0.a(), null);
    }

    public static TypeElement g(TypeMirror r5) {
        return d0.b(c(r5));
    }

    public static boolean h(TypeMirror r5, TypeMirror r10, ImmutableSet r11) {
        if (com.google.common.base.b0.w(r5, r10) == true) goto L5;
    L7:
        com.bytedance.ies.bullet.service.base.c r12 = new com.bytedance.ies.bullet.service.base.c(8);
        if (r5 == r10) goto L16;
        if (r5 == null) goto L14;
        if (r10 == null) goto L14;
        if (((Boolean) r5.accept(i0.a(), r12)).booleanValue() == false) goto L14;
        return true;
    L14:
        return false;
    L16:
        return true;
    L5:
        if ((r5 instanceof ExecutableType) == true) goto L7;
        return true;
    }

    public static n0 i() {
        return n0.f8629a;
    }

    public static int j(TypeMirror r5, ImmutableSet r10) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        return ((Integer) r5.accept(k0.a(), r10)).intValue();
    }

    public static boolean k(Class r5, TypeMirror r10) {
        com.google.common.base.b0.m(r5);
        return ((Boolean) r10.accept(new l0(), null)).booleanValue();
    }
}
