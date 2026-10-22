package com.bytedance.gkfs.storage;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f4918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f4920c;

    public c(b r5, boolean r10, boolean r11) {
        this.f4918a = r5;
        this.f4919b = r10;
        this.f4920c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof c) == false) goto L12;
        c r10 = (c) r5;
        b r11 = r10.f4918a;
        if (Intrinsics.areEqual(this.f4918a, r11) == true) goto L8;
        return false;
    L8:
        if (this.f4919b == r10.f4919b) goto L10;
        return false;
    L10:
        if (this.f4920c == r10.f4920c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    public final int hashCode() {
        b r5 = this.f4918a;
        if (r5 == null) goto L5;
        int r10 = r5.hashCode();
    L6:
        int r11 = r10 * 31;
        ?? r12 = 1;
        boolean r13 = this.f4919b;
        ?? r14 = r13;
        if (r13 == false) goto L9;
        r14 = 1;
    L9:
        int r15 = (r11 + r14) * 31;
        boolean r16 = this.f4920c;
        if (r16 == true) goto L14;
        r12 = r16;
    L14:
        return r15 + r12;
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ChunkIndexingTidyUpInfo(indexingInfo=");
        r5.append(this.f4918a);
        r5.append(", isTidyUp=");
        r5.append(this.f4919b);
        r5.append(", needDelete=");
        return j0.r(r5, this.f4920c, ")");
    }
}
