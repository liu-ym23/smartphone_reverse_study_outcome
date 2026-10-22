package com.bytedance.android.live.ai.api.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/ai/api/model/RechargeFeatureData;", "", "balance", "", "dealList", "", "(JLjava/util/List;)V", "getBalance", "()J", "setBalance", "(J)V", "getDealList", "()Ljava/util/List;", "setDealList", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeFeatureData {
    private long balance;
    private List<Long> dealList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RechargeFeatureData copy$default(RechargeFeatureData r0, long r1, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.balance;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r0.dealList;
    L9:
        return r0.copy(r1, r3);
    }

    public final long component1() {
        return this.balance;
    }

    public final List<Long> component2() {
        return this.dealList;
    }

    public final RechargeFeatureData copy(long r2, List<Long> r4) {
        Intrinsics.checkNotNullParameter(r4, "dealList");
        return new RechargeFeatureData(r2, r4);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof RechargeFeatureData) == false) goto L10;
        RechargeFeatureData r7 = (RechargeFeatureData) r6;
        if (this.balance == r7.balance) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.dealList, r7.dealList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        long r0 = this.balance;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        List<Long> r2 = this.dealList;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r1 + r3;
    L5:
        r3 = 0;
        goto L7
    }

    public String toString() {
        return "RechargeFeatureData(balance=" + this.balance + ", dealList=" + this.dealList + ")";
    }

    public final long getBalance() {
        return this.balance;
    }

    public final List<Long> getDealList() {
        return this.dealList;
    }

    public final void setBalance(long r1) {
        this.balance = r1;
    }

    public final void setDealList(List<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.dealList = r2;
    }

    public RechargeFeatureData(long r2, List<Long> r4) {
        Intrinsics.checkNotNullParameter(r4, "dealList");
        this.balance = r2;
        this.dealList = r4;
    }
}
