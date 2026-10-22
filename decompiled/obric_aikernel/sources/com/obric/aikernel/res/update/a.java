package com.obric.aikernel.res.update;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f5156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f5157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MetadataRequestFailureKind f5158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f5159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f5160f;

    public a(String r10, boolean r11, boolean r12, MetadataRequestFailureKind r13, String r14, int r15) {
        Intrinsics.checkNotNullParameter(r10, "caller");
        Intrinsics.checkNotNullParameter(r14, "triggerReason");
        this.f5155a = r10;
        this.f5156b = r11;
        this.f5157c = r12;
        this.f5158d = r13;
        this.f5159e = r14;
        this.f5160f = r15;
    }

    public final int a() {
        return this.f5160f;
    }

    public final String b() {
        return this.f5155a;
    }

    public final MetadataRequestFailureKind c() {
        return this.f5158d;
    }

    public final boolean d() {
        return this.f5156b;
    }

    public final boolean e() {
        return this.f5157c;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (Intrinsics.areEqual(this.f5155a, r11.f5155a) == true) goto L12;
        return false;
    L12:
        if (this.f5156b == r11.f5156b) goto L15;
        return false;
    L15:
        if (this.f5157c == r11.f5157c) goto L18;
        return false;
    L18:
        if (this.f5158d == r11.f5158d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f5159e, r11.f5159e) == true) goto L24;
        return false;
    L24:
        if (this.f5160f == r11.f5160f) goto L26;
        return false;
    L26:
        return true;
    }

    public final String f() {
        return this.f5159e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r10 = this.f5155a.hashCode() * 31;
        boolean r11 = this.f5156b;
        ?? r12 = 1;
        ?? r13 = r11;
        if (r11 == false) goto L5;
        r13 = 1;
    L5:
        int r14 = (r10 + r13) * 31;
        boolean r15 = this.f5157c;
        if (r15 == true) goto L9;
        r12 = r15;
    L9:
        int r16 = (r14 + r12) * 31;
        MetadataRequestFailureKind r17 = this.f5158d;
        if (r17 != null) goto L12;
        int r18 = 0;
    L14:
        return ((((r16 + r18) * 31) + this.f5159e.hashCode()) * 31) + Integer.hashCode(this.f5160f);
    L12:
        r18 = r17.hashCode();
        goto L14
    }

    public String toString() {
        return "AutoUpdateAttemptResult(caller=" + this.f5155a + ", onlyFetchConfig=" + this.f5156b + ", success=" + this.f5157c + ", failureKind=" + this.f5158d + ", triggerReason=" + this.f5159e + ", cachedPackageCount=" + this.f5160f + ')';
    }
}
