package com.squareup.javapoet;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements Appendable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Appendable f14998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public char f14999b;

    public q(Appendable r5) {
        this.f14999b = 0;
        this.f14998a = r5;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence r5) {
        int r10 = r5.length();
        if (r10 == 0) goto L6;
        this.f14999b = r5.charAt(r10 - 1);
    L6:
        return this.f14998a.append(r5);
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence r5, int r10, int r11) {
        return append(r5.subSequence(r10, r11));
    }

    @Override // java.lang.Appendable
    public final Appendable append(char r5) {
        this.f14999b = r5;
        return this.f14998a.append(r5);
    }
}
