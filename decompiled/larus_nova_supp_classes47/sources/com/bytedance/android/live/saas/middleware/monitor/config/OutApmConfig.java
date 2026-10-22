package com.bytedance.android.live.saas.middleware.monitor.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/monitor/config/OutApmConfig;", "", "blockDetect", "", "blockThresholdMs", "", "batteryDetect", "(ZJZ)V", "getBatteryDetect", "()Z", "setBatteryDetect", "(Z)V", "getBlockDetect", "setBlockDetect", "getBlockThresholdMs", "()J", "setBlockThresholdMs", "(J)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class OutApmConfig {
    private boolean batteryDetect;
    private boolean blockDetect;
    private long blockThresholdMs;

    public OutApmConfig() {
        this(false, 0, false, 7, null);
    }

    public static /* synthetic */ OutApmConfig copy$default(OutApmConfig r0, boolean r1, long r2, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.blockDetect;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.blockThresholdMs;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r0.batteryDetect;
    L12:
        return r0.copy(r1, r2, r4);
    }

    public final boolean component1() {
        return this.blockDetect;
    }

    public final long component2() {
        return this.blockThresholdMs;
    }

    public final boolean component3() {
        return this.batteryDetect;
    }

    public final OutApmConfig copy(boolean r2, long r3, boolean r5) {
        return new OutApmConfig(r2, r3, r5);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof OutApmConfig) == false) goto L12;
        OutApmConfig r7 = (OutApmConfig) r6;
        if (this.blockDetect == r7.blockDetect) goto L8;
        return false;
    L8:
        if (this.blockThresholdMs == r7.blockThresholdMs) goto L10;
        return false;
    L10:
        if (this.batteryDetect == r7.batteryDetect) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean r0 = this.blockDetect;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        long r3 = this.blockThresholdMs;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        boolean r5 = this.batteryDetect;
        if (r5 == true) goto L10;
        r1 = r5;
    L10:
        return r4 + r1;
    }

    public String toString() {
        return "OutApmConfig(blockDetect=" + this.blockDetect + ", blockThresholdMs=" + this.blockThresholdMs + ", batteryDetect=" + this.batteryDetect + ")";
    }

    public final boolean getBatteryDetect() {
        return this.batteryDetect;
    }

    public final boolean getBlockDetect() {
        return this.blockDetect;
    }

    public final long getBlockThresholdMs() {
        return this.blockThresholdMs;
    }

    public final void setBatteryDetect(boolean r1) {
        this.batteryDetect = r1;
    }

    public final void setBlockDetect(boolean r1) {
        this.blockDetect = r1;
    }

    public final void setBlockThresholdMs(long r1) {
        this.blockThresholdMs = r1;
    }

    public OutApmConfig(boolean r1, long r2, boolean r4) {
        this.blockDetect = r1;
        this.blockThresholdMs = r2;
        this.batteryDetect = r4;
    }

    public /* synthetic */ OutApmConfig(boolean r2, long r3, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 2500;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r5 = false;
    L11:
        this(r2, r3, r5);
    }
}
