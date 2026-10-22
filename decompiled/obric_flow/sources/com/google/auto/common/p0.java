package com.google.auto.common;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.p7;
import com.google.common.collect.u3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleTypeVisitor8;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 extends SimpleTypeVisitor8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f8630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q0 f8631b;

    public p0(q0 r5) {
        this.f8631b = r5;
        this.f8630a = p7.Z();
    }

    public final ImmutableList a(ExecutableElement r10, TypeElement r11) {
        if (r10.getEnclosingElement().equals(r11) == false) goto L10;
        u3 r12 = ImmutableList.builder();
        Iterator r13 = r10.getParameters().iterator();
    L6:
        if (r13.hasNext() == false) goto L9;
        r12.B0(q0.r(this.f8631b).erasure((TypeMirror) visit(((VariableElement) r13.next()).asType())));
        goto L6
    L9:
        return r12.D0();
    L10:
        ArrayList r5 = p7.T();
        if (r11.getSuperclass().getKind() != TypeKind.DECLARED) goto L13;
        r5.add(r11.getSuperclass());
    L13:
        r5.addAll(r11.getInterfaces());
        Iterator r14 = r5.iterator();
    L15:
        if (r14.hasNext() == false) goto L27;
        DeclaredType r15 = o0.b((TypeMirror) r14.next());
        TypeElement r16 = d0.b(r15.asElement());
        List r17 = r15.getTypeArguments();
        List r18 = r16.getTypeParameters();
        int r19 = 0;
        if (r17.size() != r18.size()) goto L19;
        boolean r20 = true;
    L20:
        com.google.common.base.b0.G(r20);
    L22:
        if (r19 >= r17.size()) goto L24;
        this.f8630a.put((TypeParameterElement) r18.get(r19), (TypeMirror) r17.get(r19));
        r19 = r19 + 1;
        goto L22
    L24:
        ImmutableList r21 = a(r10, r16);
        if (r21 == null) goto L15;
        return r21;
    L19:
        r20 = false;
        goto L20
    L27:
        return null;
    }

    public /* synthetic */ p0(q0 r5, int r10) {
        this(r5);
    }
}
