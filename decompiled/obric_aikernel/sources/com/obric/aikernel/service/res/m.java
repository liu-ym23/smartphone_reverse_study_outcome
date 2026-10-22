package com.obric.aikernel.service.res;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f5526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f5527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Long f5528c;

    public m(n r10, boolean r11, Long r12) {
        Intrinsics.checkNotNullParameter(r10, "state");
        this.f5526a = r10;
        this.f5527b = r11;
        this.f5528c = r12;
    }

    public final boolean a() {
        return this.f5527b;
    }

    public final Long b() {
        return this.f5528c;
    }

    public final n c() {
        return this.f5526a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof m) == true) goto L8;
        return false;
    L8:
        m r11 = (m) r10;
        if (Intrinsics.areEqual(this.f5526a, r11.f5526a) == true) goto L12;
        return false;
    L12:
        if (this.f5527b == r11.f5527b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f5528c, r11.f5528c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int r10 = this.f5526a.hashCode() * 31;
        boolean r11 = this.f5527b;
        ?? r12 = r11;
        if (r11 == false) goto L5;
        r12 = 1;
    L5:
        int r13 = (r10 + r12) * 31;
        Long r14 = this.f5528c;
        if (r14 != null) goto L8;
        int r15 = 0;
    L10:
        return r13 + r15;
    L8:
        r15 = r14.hashCode();
        goto L10
    }

    public String toString() {
        return "StartupAutoUpdateResolution(state=" + this.f5526a + ", commitIntervalWindow=" + this.f5527b + ", retryDelayMs=" + this.f5528c + ')';
    }
}
