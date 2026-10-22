package com.larus.dora.impl.settings;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/impl/settings/SppLinkRetryConfig;", "", "enable", "", "delayMs", "", "<init>", "(ZJ)V", "getEnable", "()Z", "getDelayMs", "()J", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SppLinkRetryConfig {

    @SerializedName("delay_ms")
    private final long delayMs;

    @SerializedName("enable")
    private final boolean enable;

    public SppLinkRetryConfig() {
        this(false, 0, 3, null);
    }

    public static /* synthetic */ SppLinkRetryConfig copy$default(SppLinkRetryConfig r0, boolean r1, long r2, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.enable;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.delayMs;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final long component2() {
        return this.delayMs;
    }

    public final SppLinkRetryConfig copy(boolean r2, long r3) {
        return new SppLinkRetryConfig(r2, r3);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SppLinkRetryConfig) == true) goto L8;
        return false;
    L8:
        SppLinkRetryConfig r9 = (SppLinkRetryConfig) r8;
        if (this.enable == r9.enable) goto L12;
        return false;
    L12:
        if (this.delayMs == r9.delayMs) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.enable == false) goto L5;
        int r0 = 1231;
    L6:
        long r1 = this.delayMs;
        return (r0 * 31) + ((int) (r1 ^ (r1 >>> 32)));
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "SppLinkRetryConfig(enable=" + this.enable + ", delayMs=" + this.delayMs + ')';
    }

    public final long getDelayMs() {
        return this.delayMs;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public SppLinkRetryConfig(boolean r1, long r2) {
        this.enable = r1;
        this.delayMs = r2;
    }

    public /* synthetic */ SppLinkRetryConfig(boolean r1, long r2, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = true;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r2 = 1500;
    L8:
        this(r1, r2);
    }
}
