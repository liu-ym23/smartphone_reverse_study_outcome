package com.google.auto.common;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f8637a = null;

    static {
        f8637a = new r();
        new t(new c());
        new t(new j());
        new t(new k());
        new t(new l());
        new t(new m());
        new t(new n());
        new t(new o());
        new t(new d());
        new t(new e());
        new t(new f());
        new t(new g());
        new t(new h());
        new t(new i());
    }

    public static r a() {
        return f8637a;
    }

    public static AnnotationMirror b(AnnotationValue r5) {
        return (AnnotationMirror) s.f8633a.visit(r5);
    }

    public static boolean c(AnnotationValue r5) {
        return ((Boolean) n(r5, Boolean.class)).booleanValue();
    }

    public static byte d(AnnotationValue r5) {
        return ((Byte) n(r5, Byte.class)).byteValue();
    }

    public static char e(AnnotationValue r5) {
        return ((Character) n(r5, Character.class)).charValue();
    }

    public static double f(AnnotationValue r5) {
        return ((Double) n(r5, Double.class)).doubleValue();
    }

    public static VariableElement g(AnnotationValue r5) {
        return (VariableElement) v.f8635a.visit(r5);
    }

    public static float h(AnnotationValue r5) {
        return ((Float) n(r5, Float.class)).floatValue();
    }

    public static int i(AnnotationValue r5) {
        return ((Integer) n(r5, Integer.class)).intValue();
    }

    public static long j(AnnotationValue r5) {
        return ((Long) n(r5, Long.class)).longValue();
    }

    public static short k(AnnotationValue r5) {
        return ((Short) n(r5, Short.class)).shortValue();
    }

    public static String l(AnnotationValue r5) {
        return (String) n(r5, String.class);
    }

    public static DeclaredType m(AnnotationValue r5) {
        return (DeclaredType) w.f8636a.visit(r5);
    }

    public static Object n(AnnotationValue r5, Class r10) {
        Object r11 = r5.getValue();
        if (r10.isInstance(r11) == true) goto L5;
        String r12 = r10.getSimpleName();
        String r13 = String.valueOf(r11);
        int r14 = r12.length() + 24;
        StringBuilder r15 = new StringBuilder(r13.length() + r14);
        r15.append("Expected ");
        r15.append(r12);
        r15.append(", got instead: ");
        r15.append(r13);
        throw new IllegalArgumentException(r15.toString());
    L5:
        return r10.cast(r11);
    }
}
