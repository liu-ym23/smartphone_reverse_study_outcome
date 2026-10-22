package com.larus.platform.model.mainbot;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/larus/platform/model/mainbot/ECommerceProductCardPreloadConfig;", "", "productCardPreloadGroup", "", "productCardPreloadThrottleInterval", "", "productCardPreloadMaxCardCount", "<init>", "(IDI)V", "getProductCardPreloadGroup", "()I", "getProductCardPreloadThrottleInterval", "()D", "getProductCardPreloadMaxCardCount", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ECommerceProductCardPreloadConfig {

    @SerializedName("product_card_preload_group")
    private final int productCardPreloadGroup;

    @SerializedName("product_card_preload_max_card_count")
    private final int productCardPreloadMaxCardCount;

    @SerializedName("product_card_preload_throttle_interval")
    private final double productCardPreloadThrottleInterval;

    public ECommerceProductCardPreloadConfig() {
        this(0, 0.0d, 0, 7, null);
    }

    public static /* synthetic */ ECommerceProductCardPreloadConfig copy$default(ECommerceProductCardPreloadConfig r0, int r1, double r2, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.productCardPreloadGroup;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.productCardPreloadThrottleInterval;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r0.productCardPreloadMaxCardCount;
    L12:
        return r0.copy(r1, r2, r4);
    }

    public final int component1() {
        return this.productCardPreloadGroup;
    }

    public final double component2() {
        return this.productCardPreloadThrottleInterval;
    }

    public final int component3() {
        return this.productCardPreloadMaxCardCount;
    }

    public final ECommerceProductCardPreloadConfig copy(int r2, double r3, int r5) {
        return new ECommerceProductCardPreloadConfig(r2, r3, r5);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ECommerceProductCardPreloadConfig) == true) goto L8;
        return false;
    L8:
        ECommerceProductCardPreloadConfig r9 = (ECommerceProductCardPreloadConfig) r8;
        if (this.productCardPreloadGroup == r9.productCardPreloadGroup) goto L12;
        return false;
    L12:
        if (Double.compare(this.productCardPreloadThrottleInterval, r9.productCardPreloadThrottleInterval) == 0) goto L15;
        return false;
    L15:
        if (this.productCardPreloadMaxCardCount == r9.productCardPreloadMaxCardCount) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.productCardPreloadGroup * 31;
        long r1 = Double.doubleToLongBits(this.productCardPreloadThrottleInterval);
        return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.productCardPreloadMaxCardCount;
    }

    public String toString() {
        return "ECommerceProductCardPreloadConfig(productCardPreloadGroup=" + this.productCardPreloadGroup + ", productCardPreloadThrottleInterval=" + this.productCardPreloadThrottleInterval + ", productCardPreloadMaxCardCount=" + this.productCardPreloadMaxCardCount + ')';
    }

    public final int getProductCardPreloadGroup() {
        return this.productCardPreloadGroup;
    }

    public final int getProductCardPreloadMaxCardCount() {
        return this.productCardPreloadMaxCardCount;
    }

    public final double getProductCardPreloadThrottleInterval() {
        return this.productCardPreloadThrottleInterval;
    }

    public ECommerceProductCardPreloadConfig(int r1, double r2, int r4) {
        this.productCardPreloadGroup = r1;
        this.productCardPreloadThrottleInterval = r2;
        this.productCardPreloadMaxCardCount = r4;
    }

    public /* synthetic */ ECommerceProductCardPreloadConfig(int r1, double r2, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = 60.0d;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 5;
    L11:
        this(r1, r2, r4);
    }
}
