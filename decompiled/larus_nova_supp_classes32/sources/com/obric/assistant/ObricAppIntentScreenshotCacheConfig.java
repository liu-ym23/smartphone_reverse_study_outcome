package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/ObricAppIntentScreenshotCacheConfig;", NameKeys.UnloadStrategy_No_Strategy, "maxSize", NameKeys.UnloadStrategy_No_Strategy, "ttlMs", NameKeys.UnloadStrategy_No_Strategy, "enableAppendScreenshotNoise", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(IJZ)V", "getMaxSize", "()I", "getTtlMs", "()J", "getEnableAppendScreenshotNoise", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", NameKeys.UnloadStrategy_No_Strategy, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAppIntentScreenshotCacheConfig {

    @SerializedName("enable_append_screenshot_noise")
    private final boolean enableAppendScreenshotNoise;

    @SerializedName("max_size")
    private final int maxSize;

    @SerializedName("ttl_ms")
    private final long ttlMs;

    public ObricAppIntentScreenshotCacheConfig() {
        this(0, 0, false, 7, null);
    }

    public static /* synthetic */ ObricAppIntentScreenshotCacheConfig copy$default(ObricAppIntentScreenshotCacheConfig r0, int r1, long r2, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.maxSize;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.ttlMs;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r0.enableAppendScreenshotNoise;
    L12:
        return r0.copy(r1, r2, r4);
    }

    public final int component1() {
        return this.maxSize;
    }

    public final long component2() {
        return this.ttlMs;
    }

    public final boolean component3() {
        return this.enableAppendScreenshotNoise;
    }

    public final ObricAppIntentScreenshotCacheConfig copy(int r2, long r3, boolean r5) {
        return new ObricAppIntentScreenshotCacheConfig(r2, r3, r5);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ObricAppIntentScreenshotCacheConfig) == true) goto L8;
        return false;
    L8:
        ObricAppIntentScreenshotCacheConfig r9 = (ObricAppIntentScreenshotCacheConfig) r8;
        if (this.maxSize == r9.maxSize) goto L12;
        return false;
    L12:
        if (this.ttlMs == r9.ttlMs) goto L15;
        return false;
    L15:
        if (this.enableAppendScreenshotNoise == r9.enableAppendScreenshotNoise) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.maxSize * 31;
        long r1 = this.ttlMs;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        if (this.enableAppendScreenshotNoise == false) goto L5;
        int r3 = 1231;
    L7:
        return r2 + r3;
    L5:
        r3 = 1237;
        goto L7
    }

    public String toString() {
        return "ObricAppIntentScreenshotCacheConfig(maxSize=" + this.maxSize + ", ttlMs=" + this.ttlMs + ", enableAppendScreenshotNoise=" + this.enableAppendScreenshotNoise + ')';
    }

    public final boolean getEnableAppendScreenshotNoise() {
        return this.enableAppendScreenshotNoise;
    }

    public final int getMaxSize() {
        return this.maxSize;
    }

    public final long getTtlMs() {
        return this.ttlMs;
    }

    public ObricAppIntentScreenshotCacheConfig(int r1, long r2, boolean r4) {
        this.maxSize = r1;
        this.ttlMs = r2;
        this.enableAppendScreenshotNoise = r4;
    }

    public /* synthetic */ ObricAppIntentScreenshotCacheConfig(int r1, long r2, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = 2;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = 600000;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = true;
    L11:
        this(r1, r2, r4);
    }
}
