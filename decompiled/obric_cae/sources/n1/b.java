package n1;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9422d;

    public b(boolean r8, boolean r10, boolean r11, boolean r12) {
        this.f9419a = r8;
        this.f9420b = r10;
        this.f9421c = r11;
        this.f9422d = r12;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r10 = (b) r8;
        boolean r11 = r10.f9419a;
        if (this.f9419a == r11) goto L12;
        return false;
    L12:
        if (this.f9420b == r10.f9420b) goto L15;
        return false;
    L15:
        if (this.f9421c == r10.f9421c) goto L18;
        return false;
    L18:
        if (this.f9422d == r10.f9422d) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    public final int hashCode() {
        ?? r8 = 1;
        boolean r10 = this.f9419a;
        ?? r11 = r10;
        if (r10 == false) goto L5;
        r11 = 1;
    L5:
        int r12 = r11 * 31;
        boolean r13 = this.f9420b;
        ?? r14 = r13;
        if (r13 == false) goto L8;
        r14 = 1;
    L8:
        int r15 = (r12 + r14) * 31;
        boolean r16 = this.f9421c;
        ?? r17 = r16;
        if (r16 == false) goto L11;
        r17 = 1;
    L11:
        int r18 = (r15 + r17) * 31;
        boolean r19 = this.f9422d;
        if (r19 == true) goto L16;
        r8 = r19;
    L16:
        return r18 + r8;
    }

    public final String toString() {
        return "NetworkState(isConnected=" + this.f9419a + ", isValidated=" + this.f9420b + ", isMetered=" + this.f9421c + ", isNotRoaming=" + this.f9422d + ')';
    }
}
