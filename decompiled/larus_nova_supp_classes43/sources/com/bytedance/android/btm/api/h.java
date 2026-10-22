package com.bytedance.android.btm.api;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h extends f<Fragment> {
    public final Fragment g;
    public final String h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final String l;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof h) == false) goto L18;
        h r11 = (h) r10;
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L10;
        return false;
    L10:
        if (this.i == r11.i) goto L12;
        return false;
    L12:
        if (this.j == r11.j) goto L14;
        return false;
    L14:
        if (this.k == r11.k) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.l, r11.l) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        Fragment r0 = this.g;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.h;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        boolean r15 = this.i;
        ?? r16 = 1;
        ?? r17 = r15;
        if (r15 == false) goto L13;
        r17 = 1;
    L13:
        int r18 = (r14 + r17) * 31;
        boolean r19 = this.j;
        ?? r20 = r19;
        if (r19 == false) goto L16;
        r20 = 1;
    L16:
        int r21 = (r18 + r20) * 31;
        boolean r22 = this.k;
        if (r22 == true) goto L20;
        r16 = r22;
    L20:
        int r23 = (r21 + r16) * 31;
        String r24 = this.l;
        if (r24 == null) goto L24;
        r1 = r24.hashCode();
    L24:
        return r23 + r1;
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "FragmentPageInstance(page=" + this.g + ", btm=" + this.h + ", auto=" + this.i + ", singleton=" + this.j + ", reuse=" + this.k + ", sourceBtmToken=" + this.l + ")";
    }

    public h(Fragment r11, String r12, String r13, int r14) {
        if ((r14 & 2) == 0) goto L6;
        r12 = "";
    L6:
        if ((r14 & 4) == 0) goto L8;
        boolean r10 = true;
    L10:
        if ((r14 & 32) == 0) goto L12;
        r13 = null;
    L12:
        super(r11, r12, r10, false, false, r13);
        this.g = r11;
        this.h = r12;
        this.i = r10;
        this.j = false;
        this.k = false;
        this.l = r13;
        return;
    L8:
        r10 = false;
        goto L10
    }
}
