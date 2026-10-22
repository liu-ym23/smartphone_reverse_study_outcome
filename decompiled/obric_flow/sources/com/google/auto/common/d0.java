package com.google.auto.common;

import com.google.common.base.Optional;
import java.util.Iterator;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d0 {
    public static ExecutableElement a(Element r5) {
        return (ExecutableElement) r5.accept(b0.a(), null);
    }

    public static TypeElement b(Element r5) {
        return (TypeElement) r5.accept(c0.a(), null);
    }

    public static Optional c(Element r5, Class r10) {
        String r11 = r10.getCanonicalName();
        Iterator r12 = r5.getAnnotationMirrors().iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        AnnotationMirror r13 = (AnnotationMirror) r12.next();
        if (b(r13.getAnnotationType().asElement()).getQualifiedName().contentEquals(r11) == false) goto L4;
        return Optional.of(r13);
    L10:
        return Optional.absent();
    }

    public static PackageElement d(Element r5) {
    L3:
        if (r5.getKind() == ElementKind.PACKAGE) goto L6;
        r5 = r5.getEnclosingElement();
        goto L3
    L6:
        return (PackageElement) r5;
    }

    public static boolean e(Element r5) {
        if (r5.getKind().isClass() == false) goto L5;
    L8:
        return true;
    L5:
        if (r5.getKind().isInterface() == true) goto L8;
        return false;
    }

    public static boolean f(ExecutableElement r5, PackageElement r10) {
        Visibility r11 = Visibility.ofElement(r5);
        int r12 = z.f8638a[r11.ordinal()];
        if (r12 != 1) goto L5;
        return false;
    L5:
        if (r12 == 2) goto L8;
        return true;
    L8:
        return d(r5).equals(r10);
    }
}
