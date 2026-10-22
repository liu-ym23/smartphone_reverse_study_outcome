package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/sc1;", "", "", "showDuration", "J", "d", "()J", "showInterval", "e", "showCount", "c", "cacheCleanInterval", "b", "autoShowInterval", "a", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class sc1 {

    @SerializedName("auto_show_interval")
    private final long autoShowInterval;

    @SerializedName("cache_clean_interval")
    private final long cacheCleanInterval;

    @SerializedName("show_count")
    private final long showCount;

    @SerializedName("show_duration")
    private final long showDuration;

    @SerializedName("show_interval")
    private final long showInterval;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof sc1) == false) goto L16;
        sc1 r7 = (sc1) r6;
        if (this.showDuration == r7.showDuration) goto L8;
        return false;
    L8:
        if (this.showInterval == r7.showInterval) goto L10;
        return false;
    L10:
        if (this.showCount == r7.showCount) goto L12;
        return false;
    L12:
        if (this.cacheCleanInterval == r7.cacheCleanInterval) goto L14;
        return false;
    L14:
        if (this.autoShowInterval == r7.autoShowInterval) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r0 = this.showDuration;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.showInterval;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.showCount;
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.cacheCleanInterval;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        long r8 = this.autoShowInterval;
        return r7 + ((int) (r8 ^ (r8 >>> 32)));
    }

    public final String toString() {
        return "OpenPlatformHighIntentionFrequencyControl(showDuration=" + this.showDuration + ", showInterval=" + this.showInterval + ", showCount=" + this.showCount + ", cacheCleanInterval=" + this.cacheCleanInterval + ", autoShowInterval=" + this.autoShowInterval + ")";
    }

    public sc1() {
        this.showDuration = 0;
        this.showInterval = 0;
        this.showCount = 0;
        this.cacheCleanInterval = 0;
        this.autoShowInterval = 0;
    }

    public final long a() {
        return this.autoShowInterval;
    }

    public final long b() {
        return this.cacheCleanInterval;
    }

    public final long c() {
        return this.showCount;
    }

    public final long d() {
        return this.showDuration;
    }

    public final long e() {
        return this.showInterval;
    }
}
