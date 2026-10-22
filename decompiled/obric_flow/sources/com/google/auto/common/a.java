package com.google.auto.common;

import com.google.common.collect.ImmutableCollection;
import java.util.Arrays;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.type.DeclaredType;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends com.google.common.base.p {
    public static boolean a(AnnotationMirror r5, AnnotationMirror r10) {
        if (o0.i().equivalent(r5.getAnnotationType(), r10.getAnnotationType()) == true) goto L5;
    L7:
        return false;
    L5:
        if (x.a().pairwise().equivalent(b.c(r5).values(), b.c(r10).values()) == false) goto L7;
        return true;
    }

    public static int b(AnnotationMirror r5) {
        DeclaredType r10 = r5.getAnnotationType();
        ImmutableCollection r11 = b.c(r5).values();
        return Arrays.hashCode(new int[]{o0.i().hash(r10), x.a().pairwise().hash(r11)});
    }

    @Override // com.google.common.base.p
    public final /* bridge */ /* synthetic */ boolean doEquivalent(Object r5, Object r10) {
        return a((AnnotationMirror) r5, (AnnotationMirror) r10);
    }

    @Override // com.google.common.base.p
    public final /* bridge */ /* synthetic */ int doHash(Object r5) {
        return b((AnnotationMirror) r5);
    }
}
