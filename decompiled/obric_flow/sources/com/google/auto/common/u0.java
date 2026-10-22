package com.google.auto.common;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementVisitor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ElementVisitor f8634a = null;

    static {
        f8634a = new r0();
        new s0();
        new t0();
    }

    public static boolean a(Element r5) {
        return ((Boolean) r5.accept(f8634a, null)).booleanValue();
    }
}
