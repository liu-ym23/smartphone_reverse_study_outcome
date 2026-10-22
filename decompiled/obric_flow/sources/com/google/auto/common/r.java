package com.google.auto.common;

import javax.lang.model.element.AnnotationValue;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends com.google.common.base.p {
    public static boolean a(AnnotationValue r5, AnnotationValue r10) {
        return ((Boolean) r5.accept(new p(), r10)).booleanValue();
    }

    public static int b(AnnotationValue r5) {
        return ((Integer) r5.accept(new q(), null)).intValue();
    }

    @Override // com.google.common.base.p
    public final /* bridge */ /* synthetic */ boolean doEquivalent(Object r5, Object r10) {
        return a((AnnotationValue) r5, (AnnotationValue) r10);
    }

    @Override // com.google.common.base.p
    public final /* bridge */ /* synthetic */ int doHash(Object r5) {
        return b((AnnotationValue) r5);
    }
}
