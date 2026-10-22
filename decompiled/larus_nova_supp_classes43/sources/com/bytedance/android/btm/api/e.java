package com.bytedance.android.btm.api;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public final WeakReference<Object> a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final String f;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof e) == false) goto L18;
        e r11 = (e) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r11.c) goto L12;
        return false;
    L12:
        if (this.d == r11.d) goto L14;
        return false;
    L14:
        if (this.e == r11.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L28;
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
        WeakReference<Object> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.b;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        boolean r15 = this.c;
        ?? r16 = 1;
        ?? r17 = r15;
        if (r15 == false) goto L13;
        r17 = 1;
    L13:
        int r18 = (r14 + r17) * 31;
        boolean r19 = this.d;
        ?? r20 = r19;
        if (r19 == false) goto L16;
        r20 = 1;
    L16:
        int r21 = (r18 + r20) * 31;
        boolean r22 = this.e;
        if (r22 == true) goto L20;
        r16 = r22;
    L20:
        int r23 = (r21 + r16) * 31;
        String r24 = this.f;
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
        return "BtmPageInstance(pageRef=" + this.a + ", btm=" + this.b + ", auto=" + this.c + ", singleton=" + this.d + ", reuse=" + this.e + ", sourceBtmToken=" + this.f + ")";
    }

    public /* synthetic */ e(WeakReference r10, String r11, boolean r12, String r13, int r14) {
        if ((r14 & 2) == 0) goto L5;
        r11 = "";
    L5:
        String r15 = r11;
        if ((r14 & 4) == 0) goto L8;
        boolean r16 = true;
    L10:
        if ((r14 & 32) == 0) goto L12;
        r13 = null;
    L12:
        this(r10, r15, r16, false, false, r13);
        return;
    L8:
        r16 = r12;
        goto L10
    }

    public e(WeakReference<Object> r1, String r10, boolean r11, boolean r12, boolean r13, String r14) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }
}
