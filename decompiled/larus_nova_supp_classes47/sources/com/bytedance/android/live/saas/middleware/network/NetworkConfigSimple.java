package com.bytedance.android.live.saas.middleware.network;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/network/NetworkConfigSimple;", "", "standalone", "", "cornet", "isCornet2B", "extraParamProvider", "Lcom/bytedance/android/live/saas/middleware/network/IExtraParamProvider;", "(ZZZLcom/bytedance/android/live/saas/middleware/network/IExtraParamProvider;)V", "getCornet", "()Z", "getExtraParamProvider", "()Lcom/bytedance/android/live/saas/middleware/network/IExtraParamProvider;", "getStandalone", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class NetworkConfigSimple {
    private final boolean cornet;
    private final IExtraParamProvider extraParamProvider;
    private final boolean isCornet2B;
    private final boolean standalone;

    public static /* synthetic */ NetworkConfigSimple copy$default(NetworkConfigSimple r0, boolean r1, boolean r2, boolean r3, IExtraParamProvider r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.standalone;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.cornet;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.isCornet2B;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.extraParamProvider;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final boolean component1() {
        return this.standalone;
    }

    public final boolean component2() {
        return this.cornet;
    }

    public final boolean component3() {
        return this.isCornet2B;
    }

    public final IExtraParamProvider component4() {
        return this.extraParamProvider;
    }

    public final NetworkConfigSimple copy(boolean r2, boolean r3, boolean r4, IExtraParamProvider r5) {
        return new NetworkConfigSimple(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof NetworkConfigSimple) == false) goto L14;
        NetworkConfigSimple r4 = (NetworkConfigSimple) r3;
        if (this.standalone == r4.standalone) goto L8;
        return false;
    L8:
        if (this.cornet == r4.cornet) goto L10;
        return false;
    L10:
        if (this.isCornet2B == r4.isCornet2B) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extraParamProvider, r4.extraParamProvider) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        boolean r0 = this.standalone;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.cornet;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.isCornet2B;
        if (r7 == true) goto L12;
        r1 = r7;
    L12:
        int r8 = (r6 + r1) * 31;
        IExtraParamProvider r9 = this.extraParamProvider;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L17:
        return r8 + r10;
    L15:
        r10 = 0;
        goto L17
    }

    public String toString() {
        return "NetworkConfigSimple(standalone=" + this.standalone + ", cornet=" + this.cornet + ", isCornet2B=" + this.isCornet2B + ", extraParamProvider=" + this.extraParamProvider + ")";
    }

    public final boolean getCornet() {
        return this.cornet;
    }

    public final IExtraParamProvider getExtraParamProvider() {
        return this.extraParamProvider;
    }

    public final boolean getStandalone() {
        return this.standalone;
    }

    public final boolean isCornet2B() {
        return this.isCornet2B;
    }

    public NetworkConfigSimple(boolean r1, boolean r2, boolean r3, IExtraParamProvider r4) {
        this.standalone = r1;
        this.cornet = r2;
        this.isCornet2B = r3;
        this.extraParamProvider = r4;
    }

    public /* synthetic */ NetworkConfigSimple(boolean r2, boolean r3, boolean r4, IExtraParamProvider r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        this(r2, r3, r4, r5);
    }
}
