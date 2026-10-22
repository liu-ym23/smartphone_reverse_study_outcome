package com.obric.aikernel.res.downloader;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f4974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f4975b;

    public f(boolean r10, boolean r11) {
        this.f4974a = r10;
        this.f4975b = r11;
    }

    public final boolean a() {
        return this.f4975b;
    }

    public final boolean b() {
        return this.f4974a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof f) == true) goto L8;
        return false;
    L8:
        f r11 = (f) r10;
        if (this.f4974a == r11.f4974a) goto L12;
        return false;
    L12:
        if (this.f4975b == r11.f4975b) goto L14;
        return false;
    L14:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean r10 = this.f4974a;
        ?? r11 = 1;
        ?? r12 = r10;
        if (r10 == false) goto L5;
        r12 = 1;
    L5:
        int r13 = r12 * 31;
        boolean r14 = this.f4975b;
        if (r14 == true) goto L10;
        r11 = r14;
    L10:
        return r13 + r11;
    }

    public String toString() {
        return "DownloadNetworkState(hasValidatedInternet=" + this.f4974a + ", hasUnmeteredNetwork=" + this.f4975b + ')';
    }
}
