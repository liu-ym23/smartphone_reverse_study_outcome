package com.obric.aikernel.res.downloader;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f4961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f4962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f4963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f4964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f4965e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f4966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f4967g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f4968h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f4969i;

    public c(boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, String r15, boolean r16, boolean r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r15, "backgroundReason");
        this.f4961a = r10;
        this.f4962b = r11;
        this.f4963c = r12;
        this.f4964d = r13;
        this.f4965e = r14;
        this.f4966f = r15;
        this.f4967g = r16;
        this.f4968h = r17;
        this.f4969i = r18;
    }

    public final boolean a() {
        return this.f4965e;
    }

    public final boolean b() {
        return this.f4961a;
    }

    public final boolean c() {
        return this.f4964d;
    }

    public final String d() {
        return this.f4966f;
    }

    public final boolean e() {
        return this.f4963c;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        if (this.f4961a == r11.f4961a) goto L12;
        return false;
    L12:
        if (this.f4962b == r11.f4962b) goto L15;
        return false;
    L15:
        if (this.f4963c == r11.f4963c) goto L18;
        return false;
    L18:
        if (this.f4964d == r11.f4964d) goto L21;
        return false;
    L21:
        if (this.f4965e == r11.f4965e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f4966f, r11.f4966f) == true) goto L27;
        return false;
    L27:
        if (this.f4967g == r11.f4967g) goto L30;
        return false;
    L30:
        if (this.f4968h == r11.f4968h) goto L33;
        return false;
    L33:
        if (this.f4969i == r11.f4969i) goto L35;
        return false;
    L35:
        return true;
    }

    public final boolean f() {
        return this.f4962b;
    }

    public final boolean g() {
        return this.f4969i;
    }

    public final boolean h() {
        return this.f4967g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    public int hashCode() {
        boolean r10 = this.f4961a;
        ?? r11 = 1;
        ?? r12 = r10;
        if (r10 == false) goto L5;
        r12 = 1;
    L5:
        int r13 = r12 * 31;
        boolean r14 = this.f4962b;
        ?? r15 = r14;
        if (r14 == false) goto L8;
        r15 = 1;
    L8:
        int r16 = (r13 + r15) * 31;
        boolean r17 = this.f4963c;
        ?? r18 = r17;
        if (r17 == false) goto L11;
        r18 = 1;
    L11:
        int r19 = (r16 + r18) * 31;
        boolean r20 = this.f4964d;
        ?? r21 = r20;
        if (r20 == false) goto L14;
        r21 = 1;
    L14:
        int r22 = (r19 + r21) * 31;
        boolean r23 = this.f4965e;
        ?? r24 = r23;
        if (r23 == false) goto L17;
        r24 = 1;
    L17:
        int r25 = (((r22 + r24) * 31) + this.f4966f.hashCode()) * 31;
        boolean r26 = this.f4967g;
        ?? r27 = r26;
        if (r26 == false) goto L20;
        r27 = 1;
    L20:
        int r28 = (r25 + r27) * 31;
        boolean r29 = this.f4968h;
        ?? r30 = r29;
        if (r29 == false) goto L23;
        r30 = 1;
    L23:
        int r31 = (r28 + r30) * 31;
        boolean r32 = this.f4969i;
        if (r32 == true) goto L28;
        r11 = r32;
    L28:
        return r31 + r11;
    }

    public final boolean i() {
        return this.f4968h;
    }

    public String toString() {
        return "DownloadConstraintSnapshot(allowNetworkRequest=" + this.f4961a + ", hasGroups=" + this.f4962b + ", enableBackgroundRestriction=" + this.f4963c + ", background=" + this.f4964d + ", allowBackgroundUpdate=" + this.f4965e + ", backgroundReason=" + this.f4966f + ", hasValidatedInternet=" + this.f4967g + ", requireUnmeteredNetwork=" + this.f4968h + ", hasUnmeteredNetwork=" + this.f4969i + ')';
    }
}
