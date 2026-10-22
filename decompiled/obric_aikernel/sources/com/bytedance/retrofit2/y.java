package com.bytedance.retrofit2;

import java.lang.annotation.Annotation;

/* JADX INFO: loaded from: classes.dex */
final class y implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final x f2727a = null;

    static {
        f2727a = new y();
    }

    y() {
    }

    static Annotation[] a(Annotation[] r10) {
        if (c0.n(r10, x.class) == false) goto L5;
        return r10;
    L5:
        Annotation[] r11 = new Annotation[r10.length + 1];
        r11[0] = f2727a;
        System.arraycopy(r10, 0, r11, 1, r10.length);
        return r11;
    }

    @Override // java.lang.annotation.Annotation
    public Class<? extends Annotation> annotationType() {
        return x.class;
    }

    @Override // java.lang.annotation.Annotation
    public boolean equals(Object r10) {
        return r10 instanceof x;
    }

    @Override // java.lang.annotation.Annotation
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.annotation.Annotation
    public String toString() {
        return "@" + x.class.getName() + "()";
    }
}
