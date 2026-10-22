package com.facebook.imagepipeline.common;

/* JADX INFO: loaded from: classes2.dex */
public class ResizeOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f8053c;

    public ResizeOptions(int r5, int r10, float r11) {
        if (r5 <= 0) goto L10;
        if (r10 <= 0) goto L8;
        this.f8051a = r5;
        this.f8052b = r10;
        this.f8053c = r11;
        return;
    L8:
        throw new IllegalArgumentException();
    L10:
        throw new IllegalArgumentException();
    }

    public final boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResizeOptions) == true) goto L8;
        return false;
    L8:
        ResizeOptions r10 = (ResizeOptions) r5;
        if (this.f8051a == r10.f8051a) goto L11;
    L13:
        return false;
    L11:
        if (this.f8052b != r10.f8052b) goto L13;
        return true;
    }

    public final int hashCode() {
        int r5 = this.f8051a;
        int r10 = (r5 + 31) * 31;
        return r10 + this.f8052b;
    }

    public final String toString() {
        return this.f8051a + "x" + this.f8052b;
    }
}
