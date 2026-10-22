package com.google.common.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Executable;
import java.lang.reflect.Member;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements AnnotatedElement, Member {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executable f9354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Member f9355b;

    public a(Executable r5) {
        r5.getClass();
        this.f9354a = r5;
        this.f9355b = r5;
    }

    public abstract TypeToken a();

    public final boolean equals(Object r5) {
        if ((r5 instanceof a) == false) goto L10;
        a r10 = (a) r5;
        if (a().equals(r10.a()) == true) goto L7;
        return false;
    L7:
        if (this.f9355b.equals(r10.f9355b) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation getAnnotation(Class r5) {
        return this.f9354a.getAnnotation(r5);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        return this.f9354a.getAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        return this.f9354a.getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.Member
    public final Class getDeclaringClass() {
        return this.f9355b.getDeclaringClass();
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        return this.f9355b.getModifiers();
    }

    @Override // java.lang.reflect.Member
    public final String getName() {
        return this.f9355b.getName();
    }

    public final int hashCode() {
        return this.f9355b.hashCode();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class r5) {
        return this.f9354a.isAnnotationPresent(r5);
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        return this.f9355b.isSynthetic();
    }
}
