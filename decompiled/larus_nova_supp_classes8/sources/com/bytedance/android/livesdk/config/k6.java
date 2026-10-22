package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/config/k6;", "", "", "enable", "Z", "getEnable", "()Z", "", "category", "I", "getCategory", "()I", "errorCode", "getErrorCode", "maxTimes", "getMaxTimes", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k6 {

    @SerializedName("category")
    private final int category;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("error_code")
    private final int errorCode;

    @SerializedName("max_times")
    private final int maxTimes;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof k6) == false) goto L14;
        k6 r4 = (k6) r3;
        if (this.enable == r4.enable) goto L8;
        return false;
    L8:
        if (this.category == r4.category) goto L10;
        return false;
    L10:
        if (this.errorCode == r4.errorCode) goto L12;
        return false;
    L12:
        if (this.maxTimes == r4.maxTimes) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r0 = this.enable;
        ?? r1 = r0;
        if (r0 == false) goto L6;
        r1 = 1;
    L6:
        return (((((r1 * 31) + this.category) * 31) + this.errorCode) * 31) + this.maxTimes;
    }

    public final String toString() {
        return "GameLiveHandlerConfig(enable=" + this.enable + ", category=" + this.category + ", errorCode=" + this.errorCode + ", maxTimes=" + this.maxTimes + ")";
    }

    public k6() {
        this.enable = false;
        this.category = -1;
        this.errorCode = -1;
        this.maxTimes = -1;
    }
}
