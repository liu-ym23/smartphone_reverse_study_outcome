package com.obric.aikernel.res.downloader;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f4970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f4971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f4972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f4973d;

    public e(boolean r10, boolean r11, long r12, boolean r13) {
        this.f4970a = r10;
        this.f4971b = r11;
        this.f4972c = r12;
        this.f4973d = r13;
    }

    public final boolean a() {
        return this.f4970a;
    }

    public final long b() {
        return this.f4972c;
    }

    public final boolean c() {
        return this.f4971b;
    }

    public final boolean d() {
        return this.f4973d;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof e) == true) goto L8;
        return false;
    L8:
        e r11 = (e) r10;
        if (this.f4970a == r11.f4970a) goto L12;
        return false;
    L12:
        if (this.f4971b == r11.f4971b) goto L15;
        return false;
    L15:
        if (this.f4972c == r11.f4972c) goto L18;
        return false;
    L18:
        if (this.f4973d == r11.f4973d) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    public int hashCode() {
        boolean r10 = this.f4970a;
        ?? r11 = 1;
        ?? r12 = r10;
        if (r10 == false) goto L5;
        r12 = 1;
    L5:
        int r13 = r12 * 31;
        boolean r14 = this.f4971b;
        ?? r15 = r14;
        if (r14 == false) goto L8;
        r15 = 1;
    L8:
        int r16 = (((r13 + r15) * 31) + Long.hashCode(this.f4972c)) * 31;
        boolean r17 = this.f4973d;
        if (r17 == true) goto L13;
        r11 = r17;
    L13:
        return r16 + r11;
    }

    public String toString() {
        return "DownloadLocalState(saveDirExists=" + this.f4970a + ", saveFileExists=" + this.f4971b + ", saveFileBytes=" + this.f4972c + ", tmpDirExists=" + this.f4973d + ')';
    }
}
