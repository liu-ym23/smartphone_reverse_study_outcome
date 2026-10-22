package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/e3;", "", "", "enable", "Z", "getEnable", "()Z", "", LiveEndPageData.TAG_COUNT, "J", "getCount", "()J", "time_diff", "getTime_diff", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class e3 {

    @SerializedName(LiveEndPageData.TAG_COUNT)
    private final long count;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("time_diff")
    private final long time_diff;

    public e3() {
        this(0);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof e3) == false) goto L12;
        e3 r7 = (e3) r6;
        if (this.enable == r7.enable) goto L8;
        return false;
    L8:
        if (this.count == r7.count) goto L10;
        return false;
    L10:
        if (this.time_diff == r7.time_diff) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r0 = this.enable;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        long r2 = this.count;
        int r3 = ((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31;
        long r4 = this.time_diff;
        return r3 + ((int) (r4 ^ (r4 >>> 32)));
    }

    public final String toString() {
        return "DynamicAggregateALogConfig(enable=" + this.enable + ", count=" + this.count + ", time_diff=" + this.time_diff + ")";
    }

    public e3(int r3) {
        this.enable = true;
        this.count = 30;
        this.time_diff = 5000;
    }
}
