package com.google.auto.common;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ga;
import com.google.common.collect.x3;
import java.util.Iterator;
import java.util.Map;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.util.ElementFilter;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    static {
        new a();
    }

    public static Map.Entry a(AnnotationMirror r5, String r10) {
        com.google.common.base.b0.m(r5);
        com.google.common.base.b0.m(r10);
        ga r11 = c(r5).entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Map.Entry r12 = (Map.Entry) r11.next();
        if (((ExecutableElement) r12.getKey()).getSimpleName().contentEquals(r10) == false) goto L4;
        return r12;
    L9:
        throw new IllegalArgumentException(String.format("@%s does not define an element %s()", new Object[]{d0.b(r5.getAnnotationType().asElement()).getQualifiedName(), r10}));
    }

    public static AnnotationValue b(AnnotationMirror r5, String r10) {
        return (AnnotationValue) a(r5, r10).getValue();
    }

    public static ImmutableMap c(AnnotationMirror r5) {
        x3 r10 = ImmutableMap.builder();
        Map r11 = r5.getElementValues();
        Iterator r12 = ElementFilter.methodsIn(r5.getAnnotationType().asElement().getEnclosedElements()).iterator();
    L4:
        if (r12.hasNext() == false) goto L14;
        ExecutableElement r13 = (ExecutableElement) r12.next();
        if (r11.containsKey(r13) == true) goto L7;
        if (r13.getDefaultValue() == null) goto L11;
        r10.g(r13, r13.getDefaultValue());
        goto L4
    L11:
        String r14 = String.valueOf(d0.b(r13.getEnclosingElement()).getQualifiedName());
        String r15 = String.valueOf(r13.getSimpleName());
        int r16 = r14.length() + 63;
        StringBuilder r17 = new StringBuilder(r15.length() + r16);
        r17.append("Unset annotation value without default should never happen: ");
        r17.append(r14);
        r17.append('.');
        r17.append(r15);
        r17.append("()");
        throw new IllegalStateException(r17.toString());
    L7:
        r10.g(r13, (AnnotationValue) r11.get(r13));
        goto L4
    L14:
        return r10.a();
    }
}
