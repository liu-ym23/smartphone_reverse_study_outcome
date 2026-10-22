package com.bytedance.android.live.browser.jsbridge.state.annieStatic;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/state/annieStatic/b;", "", "", "cacheData", "Ljava/lang/String;", "getCacheData", "()Ljava/lang/String;", "", "statusCode", "I", "getStatusCode", "()I", "", "costTime", "J", "getCostTime", "()J", "failReason", "getFailReason", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("cacheData")
    private final String cacheData;

    @SerializedName("costTime")
    private final long costTime;

    @SerializedName("failReason")
    private final String failReason;

    @SerializedName("statusCode")
    private final int statusCode;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b) == false) goto L14;
        b r7 = (b) r6;
        if (Intrinsics.areEqual(this.cacheData, r7.cacheData) == true) goto L8;
        return false;
    L8:
        if (this.statusCode == r7.statusCode) goto L10;
        return false;
    L10:
        if (this.costTime == r7.costTime) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.failReason, r7.failReason) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.cacheData;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.statusCode) * 31;
        long r4 = this.costTime;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        String r6 = this.failReason;
        if (r6 == null) goto L10;
        r1 = r6.hashCode();
    L10:
        return r5 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "CacheResponse(cacheData=" + this.cacheData + ", statusCode=" + this.statusCode + ", costTime=" + this.costTime + ", failReason=" + this.failReason + ")";
    }

    public b(String r1, int r2, long r3, String r5) {
        this.cacheData = r1;
        this.statusCode = r2;
        this.costTime = r3;
        this.failReason = r5;
    }
}
