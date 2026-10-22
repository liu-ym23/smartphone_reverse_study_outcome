package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/config/l6;", "", "", "enable", "Z", "getEnable", "()Z", "", "pollInterval", "J", "getPollInterval", "()J", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l6 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("poll_interval")
    private final long pollInterval;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof l6) == false) goto L10;
        l6 r6 = (l6) r5;
        if (this.enable == r6.enable) goto L8;
        return false;
    L8:
        if (this.pollInterval == r6.pollInterval) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r0 = this.enable;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        long r2 = this.pollInterval;
        return (r1 * 31) + ((int) (r2 ^ (r2 >>> 32)));
    }

    public final String toString() {
        return "GameLiveProcessImportancePoll(enable=" + this.enable + ", pollInterval=" + this.pollInterval + ")";
    }

    public l6() {
        this.enable = false;
        this.pollInterval = 10;
    }
}
