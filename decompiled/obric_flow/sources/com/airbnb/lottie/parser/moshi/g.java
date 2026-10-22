package com.airbnb.lottie.parser.moshi;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Map.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f1321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f1322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f1323c;
    public g d;
    public g e;
    public final Object f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f1324h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1325i;

    public g() {
        this.f = null;
        this.g = -1;
        this.e = this;
        this.d = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object r5) {
        if ((r5 instanceof Map.Entry) == false) goto L20;
        Map.Entry r10 = (Map.Entry) r5;
        Object r11 = this.f;
        if (r11 != null) goto L10;
        if (r10.getKey() != null) goto L21;
    L11:
        Object r12 = this.f1324h;
        if (r12 != null) goto L17;
        if (r10.getValue() != null) goto L23;
    L18:
        return true;
    L23:
        return false;
    L17:
        if (r12.equals(r10.getValue()) == true) goto L18;
        return false;
    L21:
        return false;
    L10:
        if (r11.equals(r10.getKey()) == true) goto L11;
        return false;
    L20:
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f1324h;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int r5 = 0;
        Object r10 = this.f;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        Object r12 = this.f1324h;
        if (r12 == null) goto L11;
        r5 = r12.hashCode();
    L11:
        return r11 ^ r5;
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object r5) {
        Object r10 = this.f1324h;
        this.f1324h = r5;
        return r10;
    }

    public final String toString() {
        return this.f + "=" + this.f1324h;
    }

    public g(g r5, Object r10, int r11, g r12, g r13) {
        this.f1321a = r5;
        this.f = r10;
        this.g = r11;
        this.f1325i = 1;
        this.d = r12;
        this.e = r13;
        r13.d = this;
        r12.e = this;
    }
}
