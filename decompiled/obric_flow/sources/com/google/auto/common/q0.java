package com.google.auto.common;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ga;
import com.google.common.collect.u3;
import java.util.Iterator;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Types;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 extends com.lynx.tasm.utils.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Types f8632b;

    public q0(Types r5) {
        this.f8632b = r5;
    }

    public static /* synthetic */ Types r(q0 r5) {
        return r5.f8632b;
    }

    public final ImmutableList s(ExecutableElement r5, TypeElement r10) {
        if (r5.getParameters().isEmpty() == false) goto L7;
        return ImmutableList.of();
    L7:
        return new p0(this, 0).a(r5, r10);
    }

    public final boolean t(ExecutableElement r10, ExecutableElement r11, TypeElement r12) {
        DeclaredType r5 = o0.b(r12.asType());
        return this.f8632b.isSubsignature(o0.d(this.f8632b.asMemberOf(r5, r10)), o0.d(this.f8632b.asMemberOf(r5, r11)));
    L5:
        int r13 = r10.getParameters().size();
        if (r11.getParameters().size() == r13) goto L8;
        return false;
    L8:
        ImmutableList r14 = s(r10, r12);
        ImmutableList r15 = s(r11, r12);
        if (r14 == null) goto L20;
        if (r15 == null) goto L20;
        int r16 = 0;
    L13:
        if (r16 >= r13) goto L18;
        if (this.f8632b.isSameType((TypeMirror) r14.get(r16), (TypeMirror) r15.get(r16)) == false) goto L16;
        r16 = r16 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    L20:
        return false;
    }

    public final ExecutableElement u(ExecutableElement r10, TypeElement r11) {
        TypeElement r5 = d0.b(r10.getEnclosingElement());
        com.google.common.base.b0.i(r5.getKind().isInterface());
        TypeMirror r12 = this.f8632b.erasure(r5.asType());
        ImmutableList r13 = ImmutableList.of(r11);
    L4:
        if (r13.isEmpty() == true) goto L20;
        u3 r14 = ImmutableList.builder();
        ga r15 = r13.iterator();
    L7:
        if (r15.hasNext() == false) goto L19;
        TypeElement r16 = (TypeElement) r15.next();
        TypeMirror r17 = this.f8632b.erasure(r16.asType());
        if (this.f8632b.isAssignable(r17, r12) == false) goto L15;
        ExecutableElement r18 = v(r10, r16);
        if (r18 != null) goto L12;
        r14.C0(y(r16));
        goto L15
    L12:
        return r18;
    L15:
        if (r16.getKind().isClass() == false) goto L7;
        TypeElement r19 = x(r16);
        if (r19 == null) goto L7;
        r14.B0(r19);
        goto L7
    L19:
        r13 = r14.D0();
        goto L4
    L20:
        return null;
    }

    public final ExecutableElement v(ExecutableElement r10, TypeElement r11) {
        int r5 = r10.getParameters().size();
        ImmutableList r12 = s(r10, r11);
        if (r12 != null) goto L5;
        return null;
    L5:
        Iterator r13 = ElementFilter.methodsIn(r11.getEnclosedElements()).iterator();
    L7:
        if (r13.hasNext() == false) goto L19;
        ExecutableElement r14 = (ExecutableElement) r13.next();
        if (r14.getSimpleName().equals(r10.getSimpleName()) == false) goto L7;
        if (r14.getParameters().size() != r5) goto L7;
        int r15 = 0;
    L13:
        if (r15 >= r5) goto L18;
        TypeMirror r16 = this.f8632b.erasure(((VariableElement) r14.getParameters().get(r15)).asType());
        if (this.f8632b.isSameType((TypeMirror) r12.get(r15), r16) == false) goto L7;
        r15 = r15 + 1;
        goto L13
    L18:
        return r14;
    L19:
        return null;
    }

    public final boolean w(ExecutableElement r10, ExecutableElement r11, TypeElement r12) {
        if (r10.getSimpleName().equals(r11.getSimpleName()) == true) goto L6;
        return false;
    L6:
        if (r10.getEnclosingElement().equals(r11.getEnclosingElement()) == false) goto L9;
        return false;
    L9:
        if (r11.getModifiers().contains(Modifier.STATIC) == false) goto L11;
        return false;
    L11:
        Visibility r5 = Visibility.ofElement(r11);
        Visibility r13 = Visibility.ofElement(r10);
        if (r5.equals(Visibility.PRIVATE) == false) goto L14;
    L50:
        return false;
    L14:
        if (r13.compareTo(r5) < 0) goto L50;
        if (t(r10, r11, r12) == true) goto L20;
        return false;
    L20:
        if (d0.f(r11, d0.d(r10)) == true) goto L23;
        return false;
    L23:
        if ((r11.getEnclosingElement() instanceof TypeElement) == true) goto L25;
        return false;
    L25:
        TypeElement r14 = d0.b(r11.getEnclosingElement());
        Types r15 = this.f8632b;
        if (r15.isSubtype(r15.erasure(r12.asType()), this.f8632b.erasure(r14.asType())) == true) goto L29;
        return false;
    L29:
        if (r12.getKind().isClass() == false) goto L49;
        if (r14.getKind().isClass() == false) goto L41;
    L32:
        if (r12 == null) goto L37;
        ExecutableElement r16 = v(r11, r12);
        if (r16 != null) goto L39;
        r12 = x(r12);
    L39:
        return !r11.getEnclosingElement().equals(r16.getEnclosingElement());
    L37:
        r16 = null;
        goto L39
    L41:
        if (r14.getKind().isInterface() == true) goto L43;
        return false;
    L43:
        if (r10.getModifiers().contains(Modifier.ABSTRACT) == true) goto L45;
        return true;
    L45:
        return !r11.getEnclosingElement().equals(u(r11, r12).getEnclosingElement());
    L49:
        return r12.getKind().isInterface();
    }

    public final TypeElement x(TypeElement r5) {
        TypeMirror r10 = r5.getSuperclass();
        if (r10.getKind() == TypeKind.DECLARED) goto L5;
        return null;
    L5:
        return d0.b(this.f8632b.asElement(r10));
    }

    public final ImmutableList y(TypeElement r5) {
        u3 r10 = ImmutableList.builder();
        Iterator r11 = r5.getInterfaces().iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        TypeMirror r12 = (TypeMirror) r11.next();
        r10.B0(d0.b(this.f8632b.asElement(r12)));
        goto L4
    L7:
        return r10.D0();
    }
}
