package org.sqlite.date;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f21115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21116b;

    public u(Object... r5) {
        this.f21115a = r5;
    }

    public final boolean equals(Object r5) {
        Object[] r10 = ((u) r5).f21115a;
        return Arrays.equals(this.f21115a, r10);
    }

    public final int hashCode() {
        if (this.f21116b != 0) goto L12;
        Object[] r5 = this.f21115a;
        int r10 = r5.length;
        int r11 = 0;
        int r12 = 0;
    L5:
        if (r11 >= r10) goto L10;
        Object r13 = r5[r11];
        if (r13 == null) goto L9;
        r12 = r13.hashCode() + (r12 * 7);
    L9:
        r11 = r11 + 1;
        goto L5
    L10:
        this.f21116b = r12;
    L12:
        return this.f21116b;
    }
}
