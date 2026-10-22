package com.obric.aikernel.service.res;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f5530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Long f5531c;

    public n() {
        this(false, false, null, 7, null);
    }

    public n(boolean r10, boolean r11, Long r12) {
        this.f5529a = r10;
        this.f5530b = r11;
        this.f5531c = r12;
    }

    public /* synthetic */ n(boolean r10, boolean r11, Long r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = true;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = false;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }

    public static /* synthetic */ n b(n r10, boolean r11, boolean r12, Long r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.f5529a;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.f5530b;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.f5531c;
    L12:
        return r10.a(r11, r12, r13);
    }

    public final n a(boolean r10, boolean r11, Long r12) {
        return new n(r10, r11, r12);
    }

    public final boolean c() {
        return this.f5530b;
    }

    public final boolean d() {
        return this.f5529a;
    }

    public final Long e() {
        return this.f5531c;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof n) == true) goto L8;
        return false;
    L8:
        n r11 = (n) r10;
        if (this.f5529a == r11.f5529a) goto L12;
        return false;
    L12:
        if (this.f5530b == r11.f5530b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f5531c, r11.f5531c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean r10 = this.f5529a;
        ?? r11 = 1;
        ?? r12 = r10;
        if (r10 == false) goto L5;
        r12 = 1;
    L5:
        int r13 = r12 * 31;
        boolean r14 = this.f5530b;
        if (r14 == true) goto L9;
        r11 = r14;
    L9:
        int r15 = (r13 + r11) * 31;
        Long r16 = this.f5531c;
        if (r16 != null) goto L12;
        int r17 = 0;
    L14:
        return r15 + r17;
    L12:
        r17 = r16.hashCode();
        goto L14
    }

    public String toString() {
        return "StartupAutoUpdateState(pending=" + this.f5529a + ", inFlight=" + this.f5530b + ", retryDelayMs=" + this.f5531c + ')';
    }
}
