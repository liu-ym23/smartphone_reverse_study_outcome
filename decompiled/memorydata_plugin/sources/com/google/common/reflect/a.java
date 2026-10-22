package com.google.common.reflect;

import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T, R> implements AnnotatedElement, Member {
    private static final boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AccessibleObject f4786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Member f4787b;

    /* JADX INFO: renamed from: com.google.common.reflect.a$a, reason: collision with other inner class name */
    static class C0204a<T> extends a<T, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Constructor<?> f4788a;

        C0204a(Constructor<?> r1) {
            super(r1);
            this.f4788a = r1;
        }

        private boolean c() {
            Class<?> r2 = this.f4788a.getDeclaringClass();
            if (r2.getEnclosingConstructor() == null) goto L5;
            return true;
        L5:
            Method r0 = r2.getEnclosingMethod();
            if (r0 == null) goto L10;
            return !Modifier.isStatic(r0.getModifiers());
        L10:
            if (r2.getEnclosingClass() != null) goto L12;
        L14:
            return false;
        L12:
            if (Modifier.isStatic(r2.getModifiers()) == true) goto L14;
            return true;
        }

        @Override // com.google.common.reflect.a
        Type[] b() {
            Type[] r0 = this.f4788a.getGenericParameterTypes();
            if (r0.length > 0) goto L5;
        L12:
            return r0;
        L5:
            if (c() == false) goto L12;
            Class<?>[] r1 = this.f4788a.getParameterTypes();
            if (r0.length != r1.length) goto L12;
            if (r1[0] != getDeclaringClass().getEnclosingClass()) goto L12;
            return (Type[]) ZeusTransformUtils.preCheckCast(Arrays.copyOfRange(r0, 1, r0.length), Type[].class, "com.obric.memorydata.plugin");
        }
    }

    static class b<T> extends a<T, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Method f4789a;

        b(Method r1) {
            super(r1);
            this.f4789a = r1;
        }

        @Override // com.google.common.reflect.a
        Type[] b() {
            return this.f4789a.getGenericParameterTypes();
        }
    }

    static {
        c = c();
    }

    <M extends AccessibleObject & Member> a(M r3) {
        n.a(r3);
        this.f4786a = r3;
        this.f4787b = (Member) ZeusTransformUtils.preCheckCast(r3, Member.class, "com.obric.memorydata.plugin");
    }

    private static boolean c() {
        ZeusTransformUtils.forName("java.lang.reflect.AnnotatedType", "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L5
        return true;
    L5:
        return false;
    }

    public TypeToken<T> a() {
        return TypeToken.of(getDeclaringClass());
    }

    abstract Type[] b();

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L10;
        a r5 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin");
        if (a().equals(r5.a()) == true) goto L7;
        return false;
    L7:
        if (this.f4787b.equals(r5.f4787b) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final <A extends Annotation> A getAnnotation(Class<A> r1) {
        return (A) this.f4786a.getAnnotation(r1);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        return this.f4786a.getAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        return this.f4786a.getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) this.f4787b.getDeclaringClass();
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        return this.f4787b.getModifiers();
    }

    @Override // java.lang.reflect.Member
    public final String getName() {
        return this.f4787b.getName();
    }

    public int hashCode() {
        return this.f4787b.hashCode();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class<? extends Annotation> r1) {
        return this.f4786a.isAnnotationPresent(r1);
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        return this.f4787b.isSynthetic();
    }

    public String toString() {
        return this.f4787b.toString();
    }
}
