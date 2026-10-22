package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/config/t6;", "", "", "showCount", "I", "getShowCount", "()I", "", "showTimestamp", "J", "getShowTimestamp", "()J", "dismissCount", "getDismissCount", "lastDismissTimestamp", "getLastDismissTimestamp", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t6 {

    @SerializedName("dismiss_count")
    private final int dismissCount;

    @SerializedName("last_dismiss_timestamp")
    private final long lastDismissTimestamp;

    @SerializedName("show_count")
    private final int showCount;

    @SerializedName("show_timestamp")
    private final long showTimestamp;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof t6) == false) goto L14;
        t6 r7 = (t6) r6;
        if (this.showCount == r7.showCount) goto L8;
        return false;
    L8:
        if (this.showTimestamp == r7.showTimestamp) goto L10;
        return false;
    L10:
        if (this.dismissCount == r7.dismissCount) goto L12;
        return false;
    L12:
        if (this.lastDismissTimestamp == r7.lastDismissTimestamp) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r0 = this.showCount * 31;
        long r1 = this.showTimestamp;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.dismissCount) * 31;
        long r3 = this.lastDismissTimestamp;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "GamePromoteMessageHistory(showCount=" + this.showCount + ", showTimestamp=" + this.showTimestamp + ", dismissCount=" + this.dismissCount + ", lastDismissTimestamp=" + this.lastDismissTimestamp + ')';
    }

    public t6() {
        this.showCount = 0;
        this.showTimestamp = 0;
        this.dismissCount = 0;
        this.lastDismissTimestamp = 0;
    }
}
