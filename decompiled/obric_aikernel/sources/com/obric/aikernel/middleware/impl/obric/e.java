package com.obric.aikernel.middleware.impl.obric;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f4575b;

    public e(String r10, boolean r11) {
        this.f4574a = r10;
        this.f4575b = r11;
    }

    public final String a() {
        return this.f4574a;
    }

    public final boolean b() {
        return this.f4575b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof e) == true) goto L8;
        return false;
    L8:
        e r11 = (e) r10;
        if (Intrinsics.areEqual(this.f4574a, r11.f4574a) == true) goto L12;
        return false;
    L12:
        if (this.f4575b == r11.f4575b) goto L14;
        return false;
    L14:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        String r10 = this.f4574a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        boolean r13 = this.f4575b;
        ?? r14 = r13;
        if (r13 == false) goto L10;
        r14 = 1;
    L10:
        return r12 + r14;
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public String toString() {
        return "ProcessServiceRoute(keepAliveProcessName=" + this.f4574a + ", shouldBindSilentUpdate=" + this.f4575b + ')';
    }
}
