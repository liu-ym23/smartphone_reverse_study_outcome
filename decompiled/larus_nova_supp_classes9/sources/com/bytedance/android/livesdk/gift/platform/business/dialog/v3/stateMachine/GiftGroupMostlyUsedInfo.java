package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J'\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftGroupMostlyUsedInfo;", BuildConfig.FLAVOR, "show", BuildConfig.FLAVOR, "isCurMostlyUsed", "isLoading", "(ZZZ)V", "()Z", "getShow", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftGroupMostlyUsedInfo {
    private final boolean isCurMostlyUsed;
    private final boolean isLoading;
    private final boolean show;

    public static /* synthetic */ GiftGroupMostlyUsedInfo copy$default(GiftGroupMostlyUsedInfo r0, boolean r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.show;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.isCurMostlyUsed;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.isLoading;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.show;
    }

    public final boolean component2() {
        return this.isCurMostlyUsed;
    }

    public final boolean component3() {
        return this.isLoading;
    }

    public final GiftGroupMostlyUsedInfo copy(boolean r2, boolean r3, boolean r4) {
        return new GiftGroupMostlyUsedInfo(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof GiftGroupMostlyUsedInfo) == false) goto L12;
        GiftGroupMostlyUsedInfo r4 = (GiftGroupMostlyUsedInfo) r3;
        if (this.show == r4.show) goto L8;
        return false;
    L8:
        if (this.isCurMostlyUsed == r4.isCurMostlyUsed) goto L10;
        return false;
    L10:
        if (this.isLoading == r4.isLoading) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        boolean r0 = this.show;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.isCurMostlyUsed;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.isLoading;
        if (r7 == true) goto L13;
        r1 = r7;
    L13:
        return r6 + r1;
    }

    public String toString() {
        return "GiftGroupMostlyUsedInfo(show=" + this.show + ", isCurMostlyUsed=" + this.isCurMostlyUsed + ", isLoading=" + this.isLoading + ")";
    }

    public final boolean getShow() {
        return this.show;
    }

    public final boolean isCurMostlyUsed() {
        return this.isCurMostlyUsed;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public GiftGroupMostlyUsedInfo(boolean r1, boolean r2, boolean r3) {
        this.show = r1;
        this.isCurMostlyUsed = r2;
        this.isLoading = r3;
    }
}
