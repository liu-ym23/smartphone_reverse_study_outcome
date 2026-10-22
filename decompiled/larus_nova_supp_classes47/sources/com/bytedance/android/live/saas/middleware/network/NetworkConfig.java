package com.bytedance.android.live.saas.middleware.network;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/network/NetworkConfig;", "", "retrofit", "Lcom/bytedance/android/live/saas/middleware/network/IRetrofitProvider;", "standalone", "", "cornet", "isCornet2B", "extraParamProvider", "Lcom/bytedance/android/live/saas/middleware/network/IExtraParamProvider;", "(Lcom/bytedance/android/live/saas/middleware/network/IRetrofitProvider;ZZZLcom/bytedance/android/live/saas/middleware/network/IExtraParamProvider;)V", "getCornet", "()Z", "getExtraParamProvider", "()Lcom/bytedance/android/live/saas/middleware/network/IExtraParamProvider;", "getRetrofit", "()Lcom/bytedance/android/live/saas/middleware/network/IRetrofitProvider;", "getStandalone", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class NetworkConfig {
    private final boolean cornet;
    private final IExtraParamProvider extraParamProvider;
    private final boolean isCornet2B;
    private final IRetrofitProvider retrofit;
    private final boolean standalone;

    public NetworkConfig(IRetrofitProvider r9, boolean r10) {
        this(r9, r10, false, false, null, 28, null);
    }

    public NetworkConfig(IRetrofitProvider r9, boolean r10, boolean r12) {
        this(r9, r10, r12, false, null, 24, null);
    }

    public NetworkConfig(IRetrofitProvider r9, boolean r10, boolean r12, boolean r13) {
        this(r9, r10, r12, r13, null, 16, null);
    }

    public static /* synthetic */ NetworkConfig copy$default(NetworkConfig r3, IRetrofitProvider r4, boolean r5, boolean r6, boolean r7, IExtraParamProvider r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.retrofit;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.standalone;
    L8:
        boolean r12 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.cornet;
    L11:
        boolean r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.isCornet2B;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.extraParamProvider;
    L17:
        IRetrofitProvider r13 = r4;
        return r3.copy(r13, r12, r0, r1, r8);
    }

    public final IRetrofitProvider component1() {
        return this.retrofit;
    }

    public final boolean component2() {
        return this.standalone;
    }

    public final boolean component3() {
        return this.cornet;
    }

    public final boolean component4() {
        return this.isCornet2B;
    }

    public final IExtraParamProvider component5() {
        return this.extraParamProvider;
    }

    public final NetworkConfig copy(IRetrofitProvider r8, boolean r9, boolean r10, boolean r12, IExtraParamProvider r13) {
        return new NetworkConfig(r8, r9, r10, r12, r13);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof NetworkConfig) == false) goto L16;
        NetworkConfig r4 = (NetworkConfig) r3;
        if (Intrinsics.areEqual(this.retrofit, r4.retrofit) == true) goto L8;
        return false;
    L8:
        if (this.standalone == r4.standalone) goto L10;
        return false;
    L10:
        if (this.cornet == r4.cornet) goto L12;
        return false;
    L12:
        if (this.isCornet2B == r4.isCornet2B) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.extraParamProvider, r4.extraParamProvider) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        IRetrofitProvider r0 = this.retrofit;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.standalone;
        ?? r5 = 1;
        ?? r6 = r4;
        if (r4 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r3 + r6) * 31;
        boolean r8 = this.cornet;
        ?? r9 = r8;
        if (r8 == false) goto L12;
        r9 = 1;
    L12:
        int r10 = (r7 + r9) * 31;
        boolean r12 = this.isCornet2B;
        if (r12 == true) goto L16;
        r5 = r12;
    L16:
        int r13 = (r10 + r5) * 31;
        IExtraParamProvider r14 = this.extraParamProvider;
        if (r14 == null) goto L20;
        r1 = r14.hashCode();
    L20:
        return r13 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "NetworkConfig(retrofit=" + this.retrofit + ", standalone=" + this.standalone + ", cornet=" + this.cornet + ", isCornet2B=" + this.isCornet2B + ", extraParamProvider=" + this.extraParamProvider + ")";
    }

    public final boolean getCornet() {
        return this.cornet;
    }

    public final IExtraParamProvider getExtraParamProvider() {
        return this.extraParamProvider;
    }

    public final IRetrofitProvider getRetrofit() {
        return this.retrofit;
    }

    public final boolean getStandalone() {
        return this.standalone;
    }

    public final boolean isCornet2B() {
        return this.isCornet2B;
    }

    public NetworkConfig(IRetrofitProvider r1, boolean r2, boolean r3, boolean r4, IExtraParamProvider r5) {
        this.retrofit = r1;
        this.standalone = r2;
        this.cornet = r3;
        this.isCornet2B = r4;
        this.extraParamProvider = r5;
    }

    public /* synthetic */ NetworkConfig(IRetrofitProvider r8, boolean r9, boolean r10, boolean r12, IExtraParamProvider r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 4) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r14 & 8) == 0) goto L9;
        boolean r5 = false;
    L11:
        if ((r14 & 16) == 0) goto L13;
        r13 = null;
    L13:
        this(r8, r9, r4, r5, r13);
        return;
    L9:
        r5 = r12;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }
}
