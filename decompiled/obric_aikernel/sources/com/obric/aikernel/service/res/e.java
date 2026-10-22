package com.obric.aikernel.service.res;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5522b;

    public e(boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "reason");
        this.f5521a = r10;
        this.f5522b = r11;
    }

    public final boolean a() {
        return this.f5521a;
    }

    public final String b() {
        return this.f5522b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof e) == true) goto L8;
        return false;
    L8:
        e r11 = (e) r10;
        if (this.f5521a == r11.f5521a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5522b, r11.f5522b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean r10 = this.f5521a;
        ?? r11 = r10;
        if (r10 == false) goto L6;
        r11 = 1;
    L6:
        return (r11 * 31) + this.f5522b.hashCode();
    }

    public String toString() {
        return "BackgroundUpdateGateState(allowed=" + this.f5521a + ", reason=" + this.f5522b + ')';
    }
}
