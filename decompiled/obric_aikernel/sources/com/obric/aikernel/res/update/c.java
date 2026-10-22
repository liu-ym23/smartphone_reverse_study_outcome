package com.obric.aikernel.res.update;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f5166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f5167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f5168d;

    public c(boolean r10, boolean r11, boolean r12, boolean r13) {
        this.f5165a = r10;
        this.f5166b = r11;
        this.f5167c = r12;
        this.f5168d = r13;
    }

    public final boolean a() {
        return this.f5165a;
    }

    public final boolean b() {
        return this.f5166b;
    }

    public final boolean c() {
        return this.f5167c;
    }

    public final boolean d() {
        return this.f5168d;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        if (this.f5165a == r11.f5165a) goto L12;
        return false;
    L12:
        if (this.f5166b == r11.f5166b) goto L15;
        return false;
    L15:
        if (this.f5167c == r11.f5167c) goto L18;
        return false;
    L18:
        if (this.f5168d == r11.f5168d) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    public int hashCode() {
        boolean r10 = this.f5165a;
        ?? r11 = 1;
        ?? r12 = r10;
        if (r10 == false) goto L5;
        r12 = 1;
    L5:
        int r13 = r12 * 31;
        boolean r14 = this.f5166b;
        ?? r15 = r14;
        if (r14 == false) goto L8;
        r15 = 1;
    L8:
        int r16 = (r13 + r15) * 31;
        boolean r17 = this.f5167c;
        ?? r18 = r17;
        if (r17 == false) goto L11;
        r18 = 1;
    L11:
        int r19 = (r16 + r18) * 31;
        boolean r20 = this.f5168d;
        if (r20 == true) goto L16;
        r11 = r20;
    L16:
        return r19 + r11;
    }

    public String toString() {
        return "InstallArtifactState(sourceExists=" + this.f5165a + ", sourceIsDirectory=" + this.f5166b + ", targetExists=" + this.f5167c + ", targetTempExists=" + this.f5168d + ')';
    }
}
