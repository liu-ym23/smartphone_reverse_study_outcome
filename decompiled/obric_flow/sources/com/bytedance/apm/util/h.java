package com.bytedance.apm.util;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f3917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f3918b;

    public h(Long r5, Long r10) {
        this.f3917a = r5;
        this.f3918b = r10;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof h) == true) goto L5;
        return false;
    L5:
        h r10 = (h) r5;
        Long r11 = r10.f3917a;
        Long r12 = this.f3917a;
        if (r11 != r12) goto L8;
    L9:
        Long r13 = r10.f3918b;
        Long r14 = this.f3918b;
        if (r13 != r14) goto L12;
    L13:
        return true;
    L12:
        if (r13.equals(r14) == true) goto L13;
        return false;
    L8:
        if (r11.equals(r12) == true) goto L9;
        return false;
    }

    public final int hashCode() {
        int r5 = this.f3917a.hashCode();
        return this.f3918b.hashCode() ^ r5;
    }

    public final String toString() {
        return "Pair{" + String.valueOf(this.f3917a) + " " + this.f3918b + "}";
    }
}
