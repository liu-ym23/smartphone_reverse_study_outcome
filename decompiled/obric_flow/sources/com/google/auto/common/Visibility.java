package com.google.auto.common;

import com.google.common.collect.g8;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;

/* JADX INFO: loaded from: classes2.dex */
public final enum Visibility extends Enum<Visibility> {
    public static final Visibility DEFAULT = null;
    public static final Visibility PRIVATE = null;
    public static final Visibility PROTECTED = null;
    public static final Visibility PUBLIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ElementKind f8618a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ Visibility[] f8619b = null;

    static {
        Visibility r5 = new Visibility("PRIVATE", 0);
        PRIVATE = r5;
        Visibility r10 = new Visibility("DEFAULT", 1);
        DEFAULT = r10;
        Visibility r11 = new Visibility("PROTECTED", 2);
        PROTECTED = r11;
        Visibility r12 = new Visibility("PUBLIC", 3);
        PUBLIC = r12;
        f8619b = new Visibility[]{r5, r10, r11, r12};
        f8618a = (ElementKind) com.google.common.base.n.a(ElementKind.class).orNull();
    }

    public static Visibility effectiveVisibilityOfElement(Element r5) {
        com.google.common.base.b0.m(r5);
        Visibility r10 = PUBLIC;
    L3:
        if (r5 == null) goto L5;
        r10 = (Visibility) g8.natural().min(r10, ofElement(r5));
        r5 = r5.getEnclosingElement();
        goto L3
    L5:
        return r10;
    }

    public static Visibility ofElement(Element r5) {
        com.google.common.base.b0.m(r5);
        if (r5.getKind().equals(ElementKind.PACKAGE) == true) goto L22;
        if (r5.getKind().equals(f8618a) == true) goto L22;
        Set r10 = r5.getModifiers();
        if (r10.contains(Modifier.PRIVATE) == false) goto L12;
        return PRIVATE;
    L12:
        if (r10.contains(Modifier.PROTECTED) == false) goto L16;
        return PROTECTED;
    L16:
        if (r10.contains(Modifier.PUBLIC) == false) goto L20;
        return PUBLIC;
    L20:
        return DEFAULT;
    L22:
        return PUBLIC;
    }

    public static Visibility valueOf(String r5) {
        return (Visibility) Enum.valueOf(Visibility.class, r5);
    }

    public static Visibility[] values() {
        return (Visibility[]) f8619b.clone();
    }
}
