package com.bytedance.android.ec.core.order;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/core/order/OrderSkeletonMonitorConfig;", "Ljava/io/Serializable;", "on", "", "maxMonitorCount", "", "singleTimerDuration", "renderIntervalThreshold", "revertIntervalThreshold", "(ZIIII)V", "getMaxMonitorCount", "()I", "getOn", "()Z", "getRenderIntervalThreshold", "getRevertIntervalThreshold", "getSingleTimerDuration", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderSkeletonMonitorConfig implements Serializable {

    @SerializedName("inspectionMaxCount")
    private final int maxMonitorCount;

    @SerializedName("on")
    private final boolean on;

    @SerializedName("renderIntervalThreshold")
    private final int renderIntervalThreshold;

    @SerializedName("renderIntervalThreshold")
    private final int revertIntervalThreshold;

    @SerializedName("inspectionDuration")
    private final int singleTimerDuration;

    public OrderSkeletonMonitorConfig() {
        this(false, 0, 0, 0, 0, 31, null);
    }

    public static /* synthetic */ OrderSkeletonMonitorConfig copy$default(OrderSkeletonMonitorConfig r10, boolean r11, int r12, int r13, int r14, int r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.on;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.maxMonitorCount;
    L8:
        int r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.singleTimerDuration;
    L11:
        int r0 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.renderIntervalThreshold;
    L14:
        int r1 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.revertIntervalThreshold;
    L17:
        boolean r19 = r11;
        return r10.copy(r19, r18, r0, r1, r15);
    }

    public final boolean component1() {
        return this.on;
    }

    public final int component2() {
        return this.maxMonitorCount;
    }

    public final int component3() {
        return this.singleTimerDuration;
    }

    public final int component4() {
        return this.renderIntervalThreshold;
    }

    public final int component5() {
        return this.revertIntervalThreshold;
    }

    public final OrderSkeletonMonitorConfig copy(boolean r10, int r11, int r12, int r13, int r14) {
        return new OrderSkeletonMonitorConfig(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof OrderSkeletonMonitorConfig) == false) goto L16;
        OrderSkeletonMonitorConfig r11 = (OrderSkeletonMonitorConfig) r10;
        if (this.on == r11.on) goto L8;
        return false;
    L8:
        if (this.maxMonitorCount == r11.maxMonitorCount) goto L10;
        return false;
    L10:
        if (this.singleTimerDuration == r11.singleTimerDuration) goto L12;
        return false;
    L12:
        if (this.renderIntervalThreshold == r11.renderIntervalThreshold) goto L14;
        return false;
    L14:
        if (this.revertIntervalThreshold == r11.revertIntervalThreshold) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean r0 = this.on;
        ?? r1 = r0;
        if (r0 == false) goto L6;
        r1 = 1;
    L6:
        return (((((((r1 * 31) + this.maxMonitorCount) * 31) + this.singleTimerDuration) * 31) + this.renderIntervalThreshold) * 31) + this.revertIntervalThreshold;
    }

    public String toString() {
        return "OrderSkeletonMonitorConfig(on=" + this.on + ", maxMonitorCount=" + this.maxMonitorCount + ", singleTimerDuration=" + this.singleTimerDuration + ", renderIntervalThreshold=" + this.renderIntervalThreshold + ", revertIntervalThreshold=" + this.revertIntervalThreshold + ")";
    }

    public final int getMaxMonitorCount() {
        return this.maxMonitorCount;
    }

    public final boolean getOn() {
        return this.on;
    }

    public final int getRenderIntervalThreshold() {
        return this.renderIntervalThreshold;
    }

    public final int getRevertIntervalThreshold() {
        return this.revertIntervalThreshold;
    }

    public final int getSingleTimerDuration() {
        return this.singleTimerDuration;
    }

    public OrderSkeletonMonitorConfig(boolean r1, int r10, int r11, int r12, int r13) {
        this.on = r1;
        this.maxMonitorCount = r10;
        this.singleTimerDuration = r11;
        this.renderIntervalThreshold = r12;
        this.revertIntervalThreshold = r13;
    }

    public /* synthetic */ OrderSkeletonMonitorConfig(boolean r10, int r11, int r12, int r13, int r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L6;
        r10 = true;
    L6:
        if ((r15 & 2) == 0) goto L8;
        int r17 = 3;
    L9:
        int r0 = 5000;
        if ((r15 & 4) == 0) goto L12;
        int r1 = 5000;
    L14:
        if ((r15 & 8) == 0) goto L16;
        int r18 = 2000;
    L18:
        if ((r15 & 16) != 0) goto L21;
        r0 = r14;
    L21:
        this(r10, r17, r1, r18, r0);
        return;
    L16:
        r18 = r13;
        goto L18
    L12:
        r1 = r12;
        goto L14
    L8:
        r17 = r11;
        goto L9
    }
}
