package com.bytedance.iesgurd;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6621c;
    public String d;

    public e(int r5, String r10) {
        this.f6619a = r5;
        this.f6620b = r10;
        this.f6621c = 0;
        this.d = null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof e) == false) goto L14;
        e r10 = (e) r5;
        int r11 = r10.f6619a;
        if (this.f6619a == r11) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f6620b, r10.f6620b) == true) goto L10;
        return false;
    L10:
        if (this.f6621c == r10.f6621c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r5 = this.f6619a * 31;
        int r10 = 0;
        String r11 = this.f6620b;
        if (r11 == null) goto L5;
        int r12 = r11.hashCode();
    L6:
        int r13 = (((r5 + r12) * 31) + this.f6621c) * 31;
        String r14 = this.d;
        if (r14 == null) goto L10;
        r10 = r14.hashCode();
    L10:
        return r13 + r10;
    L5:
        r12 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("IESGurdResError(offlineCode=");
        r5.append(this.f6619a);
        r5.append(", offlineMessage=");
        r5.append(this.f6620b);
        r5.append(", cdnCode=");
        r5.append(this.f6621c);
        r5.append(", cdnMessage=");
        return j0.q(r5, this.d, ")");
    }
}
