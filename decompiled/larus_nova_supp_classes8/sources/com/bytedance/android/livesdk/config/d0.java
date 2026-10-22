package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/config/d0;", "", "", "enable", "Z", "getEnable", "()Z", "", "createLimitCount", "I", "getCreateLimitCount", "()I", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d0 {

    @SerializedName("create_limit_count")
    private final int createLimitCount;

    @SerializedName("enable")
    private final boolean enable;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d0) == false) goto L10;
        d0 r4 = (d0) r3;
        if (this.enable == r4.enable) goto L8;
        return false;
    L8:
        if (this.createLimitCount == r4.createLimitCount) goto L16;
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
        if (r0 == false) goto L6;
        r1 = 1;
    L6:
        return (r1 * 31) + this.createLimitCount;
    }

    public final String toString() {
        return "AnnouncementOptV2(enable=" + this.enable + ", createLimitCount=" + this.createLimitCount + ")";
    }

    public d0() {
        this.enable = false;
        this.createLimitCount = 4;
    }
}
