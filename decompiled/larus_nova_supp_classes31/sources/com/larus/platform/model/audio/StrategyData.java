package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import lq9.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/larus/platform/model/audio/StrategyData;", "", "strategyType", "", "timeoutDuration", "retryCount", "isRetryEnabled", "", "<init>", "(IIIZ)V", "getStrategyType", "()I", "getTimeoutDuration", "getRetryCount", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class StrategyData {

    @SerializedName("is_retry_enable")
    private final boolean isRetryEnabled;

    @SerializedName("retry_count")
    private final int retryCount;

    @SerializedName("strategy_type")
    private final int strategyType;

    @SerializedName("timeout_duration")
    private final int timeoutDuration;

    public StrategyData() {
        this(0, 0, 0, false, 15, null);
    }

    public static /* synthetic */ StrategyData copy$default(StrategyData r0, int r1, int r2, int r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.strategyType;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.timeoutDuration;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.retryCount;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.isRetryEnabled;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.strategyType;
    }

    public final int component2() {
        return this.timeoutDuration;
    }

    public final int component3() {
        return this.retryCount;
    }

    public final boolean component4() {
        return this.isRetryEnabled;
    }

    public final StrategyData copy(int r2, int r3, int r4, boolean r5) {
        return new StrategyData(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof StrategyData) == true) goto L8;
        return false;
    L8:
        StrategyData r6 = (StrategyData) r5;
        if (this.strategyType == r6.strategyType) goto L12;
        return false;
    L12:
        if (this.timeoutDuration == r6.timeoutDuration) goto L15;
        return false;
    L15:
        if (this.retryCount == r6.retryCount) goto L18;
        return false;
    L18:
        if (this.isRetryEnabled == r6.isRetryEnabled) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.strategyType * 31) + this.timeoutDuration) * 31) + this.retryCount) * 31;
        if (this.isRetryEnabled == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public String toString() {
        return "StrategyData(strategyType=" + this.strategyType + ", timeoutDuration=" + this.timeoutDuration + ", retryCount=" + this.retryCount + ", isRetryEnabled=" + this.isRetryEnabled + ')';
    }

    public final int getRetryCount() {
        return this.retryCount;
    }

    public final int getStrategyType() {
        return this.strategyType;
    }

    public final int getTimeoutDuration() {
        return this.timeoutDuration;
    }

    public final boolean isRetryEnabled() {
        return this.isRetryEnabled;
    }

    public StrategyData(int r1, int r2, int r3, boolean r4) {
        this.strategyType = r1;
        this.timeoutDuration = r2;
        this.retryCount = r3;
        this.isRetryEnabled = r4;
    }

    public /* synthetic */ StrategyData(int r2, int r3, int r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r6 & 2) == 0) goto L9;
        int r8 = m.a;
        r3 = 0;
    L9:
        if ((r6 & 4) == 0) goto L12;
        int r9 = m.a;
        r4 = 0;
    L12:
        if ((r6 & 8) == 0) goto L14;
        int r10 = m.a;
        r5 = false;
    L14:
        this(r2, r3, r4, r5);
    }
}
