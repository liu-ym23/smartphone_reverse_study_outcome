package androidx.work.impl.constraints;

/* JADX INFO: loaded from: classes.dex */
public final class NetworkState {
    private final boolean isConnected;
    private final boolean isMetered;
    private final boolean isNotRoaming;
    private final boolean isValidated;

    public NetworkState(boolean r10, boolean r11, boolean r12, boolean r13) {
        this.isConnected = r10;
        this.isValidated = r11;
        this.isMetered = r12;
        this.isNotRoaming = r13;
    }

    public static /* synthetic */ NetworkState copy$default(NetworkState r10, boolean r11, boolean r12, boolean r13, boolean r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.isConnected;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.isValidated;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.isMetered;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r14 = r10.isNotRoaming;
    L15:
        return r10.copy(r11, r12, r13, r14);
    }

    public final boolean component1() {
        return this.isConnected;
    }

    public final boolean component2() {
        return this.isValidated;
    }

    public final boolean component3() {
        return this.isMetered;
    }

    public final boolean component4() {
        return this.isNotRoaming;
    }

    public final NetworkState copy(boolean r10, boolean r11, boolean r12, boolean r13) {
        return new NetworkState(r10, r11, r12, r13);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof NetworkState) == true) goto L8;
        return false;
    L8:
        NetworkState r11 = (NetworkState) r10;
        if (this.isConnected == r11.isConnected) goto L12;
        return false;
    L12:
        if (this.isValidated == r11.isValidated) goto L15;
        return false;
    L15:
        if (this.isMetered == r11.isMetered) goto L18;
        return false;
    L18:
        if (this.isNotRoaming == r11.isNotRoaming) goto L20;
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
        boolean r10 = this.isConnected;
        ?? r11 = 1;
        ?? r12 = r10;
        if (r10 == false) goto L5;
        r12 = 1;
    L5:
        int r13 = r12 * 31;
        boolean r14 = this.isValidated;
        ?? r15 = r14;
        if (r14 == false) goto L8;
        r15 = 1;
    L8:
        int r16 = (r13 + r15) * 31;
        boolean r17 = this.isMetered;
        ?? r18 = r17;
        if (r17 == false) goto L11;
        r18 = 1;
    L11:
        int r19 = (r16 + r18) * 31;
        boolean r20 = this.isNotRoaming;
        if (r20 == true) goto L16;
        r11 = r20;
    L16:
        return r19 + r11;
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public final boolean isMetered() {
        return this.isMetered;
    }

    public final boolean isNotRoaming() {
        return this.isNotRoaming;
    }

    public final boolean isValidated() {
        return this.isValidated;
    }

    public String toString() {
        return "NetworkState(isConnected=" + this.isConnected + ", isValidated=" + this.isValidated + ", isMetered=" + this.isMetered + ", isNotRoaming=" + this.isNotRoaming + ')';
    }
}
