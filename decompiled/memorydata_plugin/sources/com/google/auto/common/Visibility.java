package com.google.auto.common;

import com.google.common.base.Enums;
import com.google.common.base.n;
import com.google.common.collect.Ordering;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;

/* JADX INFO: loaded from: classes2.dex */
public final enum Visibility extends Enum<Visibility> {
    private static final /* synthetic */ Visibility[] $VALUES = null;
    public static final Visibility DEFAULT = null;
    private static final ElementKind MODULE = null;
    public static final Visibility PRIVATE = null;
    public static final Visibility PROTECTED = null;
    public static final Visibility PUBLIC = null;

    private static /* synthetic */ Visibility[] $values() {
        return new Visibility[]{PRIVATE, DEFAULT, PROTECTED, PUBLIC};
    }

    static {
        PRIVATE = new Visibility("PRIVATE", 0);
        DEFAULT = new Visibility("DEFAULT", 1);
        PROTECTED = new Visibility("PROTECTED", 2);
        PUBLIC = new Visibility("PUBLIC", 3);
        $VALUES = $values();
        MODULE = (ElementKind) ZeusTransformUtils.preCheckCast(Enums.a(ElementKind.class, "MODULE").orNull(), ElementKind.class, "com.obric.memorydata.plugin");
    }

    private Visibility(String r1, int r2) {
        super(r1, r2);
    }

    public static Visibility effectiveVisibilityOfElement(Element r4) {
        Element r5 = (Element) ZeusTransformUtils.wrapperContextForParams(r4, Element.class, "com.obric.memorydata.plugin");
        n.a(r5);
        Visibility r0 = PUBLIC;
    L3:
        if (r5 == null) goto L5;
        r0 = (Visibility) ZeusTransformUtils.preCheckCast(Ordering.natural().min(r0, ofElement(r5)), Visibility.class, "com.obric.memorydata.plugin");
        r5 = r5.getEnclosingElement();
        goto L3
    L5:
        return r0;
    }

    public static Visibility ofElement(Element r2) {
        Element r3 = (Element) ZeusTransformUtils.wrapperContextForParams(r2, Element.class, "com.obric.memorydata.plugin");
        n.a(r3);
        if (r3.getKind().equals(ElementKind.PACKAGE) == true) goto L22;
        if (r3.getKind().equals(MODULE) == true) goto L22;
        Set r4 = r3.getModifiers();
        if (r4.contains(Modifier.PRIVATE) == false) goto L12;
        return PRIVATE;
    L12:
        if (r4.contains(Modifier.PROTECTED) == false) goto L16;
        return PROTECTED;
    L16:
        if (r4.contains(Modifier.PUBLIC) == false) goto L20;
        return PUBLIC;
    L20:
        return DEFAULT;
    L22:
        return PUBLIC;
    }

    public static Visibility valueOf(String r2) {
        return (Visibility) ZeusTransformUtils.preCheckCast(Enum.valueOf(Visibility.class, r2), Visibility.class, "com.obric.memorydata.plugin");
    }

    public static Visibility[] values() {
        return (Visibility[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Visibility[].class, "com.obric.memorydata.plugin");
    }
}
