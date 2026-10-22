package com.airbnb.lottie;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f1248b;

    public a0(Object r5) {
        this.f1247a = r5;
        this.f1248b = null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r10 = (a0) r5;
        Object r11 = this.f1247a;
        if (r11 != null) goto L11;
    L13:
        Throwable r12 = this.f1248b;
        if (r12 != null) goto L16;
    L19:
        return false;
    L16:
        if (r10.f1248b == null) goto L19;
        return r12.toString().equals(r12.toString());
    L11:
        if (r11.equals(r10.f1247a) == false) goto L13;
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1247a, this.f1248b});
    }

    public a0(Throwable r5) {
        this.f1248b = r5;
        this.f1247a = null;
    }
}
