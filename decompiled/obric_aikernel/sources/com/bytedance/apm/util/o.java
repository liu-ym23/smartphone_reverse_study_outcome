package com.bytedance.apm.util;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class o<F, S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public F f1139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public S f1140b;

    public o(@Nullable F r10, @Nullable S r11) {
        this.f1139a = r10;
        this.f1140b = r11;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof o) == true) goto L5;
        return false;
    L5:
        o r11 = (o) r10;
        if (n.a(r11.f1139a, this.f1139a) == true) goto L8;
        return false;
    L8:
        if (n.a(r11.f1140b, this.f1140b) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        F r10 = this.f1139a;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        S r13 = this.f1140b;
        if (r13 == null) goto L11;
        r11 = r13.hashCode();
    L11:
        return r12 ^ r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f1139a) + " " + this.f1140b + "}";
    }
}
