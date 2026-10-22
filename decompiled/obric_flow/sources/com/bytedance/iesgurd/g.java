package com.bytedance.iesgurd;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6629c;

    public g(String r5, long r10, boolean r11) {
        this.f6627a = r11;
        this.f6628b = r10;
        this.f6629c = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof g) == false) goto L12;
        g r10 = (g) r5;
        boolean r11 = r10.f6627a;
        if (this.f6627a == r11) goto L8;
        return false;
    L8:
        if (this.f6628b == r10.f6628b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f6629c, r10.f6629c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r5 = this.f6627a;
        ?? r10 = r5;
        if (r5 == false) goto L5;
        r10 = 1;
    L5:
        long r11 = this.f6628b;
        int r12 = ((r10 * 31) + ((int) (r11 ^ (r11 >>> 32)))) * 31;
        String r13 = this.f6629c;
        if (r13 == null) goto L8;
        int r14 = r13.hashCode();
    L10:
        return r12 + r14;
    L8:
        r14 = 0;
        goto L10
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("IESGurdUpdateChannelInfo(success=");
        r5.append(this.f6627a);
        r5.append(", version=");
        r5.append(this.f6628b);
        r5.append(", errorMessage=");
        return j0.q(r5, this.f6629c, ")");
    }
}
