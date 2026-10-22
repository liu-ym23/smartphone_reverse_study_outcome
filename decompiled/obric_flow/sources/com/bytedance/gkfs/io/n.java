package com.bytedance.gkfs.io;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class n {
    public static final n d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f4896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GkFSError f4897c;

    static {
        d = new n(true, null, GkFSError.f4839b);
    }

    public n(boolean r5, Throwable r10, GkFSError r11) {
        this.f4895a = r5;
        this.f4896b = r10;
        this.f4897c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof n) == false) goto L12;
        n r10 = (n) r5;
        boolean r11 = r10.f4895a;
        if (this.f4895a == r11) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f4896b, r10.f4896b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f4897c, r10.f4897c) == true) goto L19;
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
        boolean r5 = this.f4895a;
        ?? r10 = r5;
        if (r5 == false) goto L5;
        r10 = 1;
    L5:
        int r11 = r10 * 31;
        int r12 = 0;
        Throwable r13 = this.f4896b;
        if (r13 == null) goto L8;
        int r14 = r13.hashCode();
    L9:
        int r15 = (r11 + r14) * 31;
        GkFSError r16 = this.f4897c;
        if (r16 == null) goto L13;
        r12 = r16.hashCode();
    L13:
        return r15 + r12;
    L8:
        r14 = 0;
        goto L9
    }

    public final String toString() {
        return "GkFSStatus(isSuccess=" + this.f4895a + ", error=" + this.f4896b + ", errorCode=" + this.f4897c + ")";
    }
}
