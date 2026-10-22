package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/scope/service/p3;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "userId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", BuildConfig.FLAVOR, "lastTimestamp", "J", "a", "()J", "c", "(J)V", BuildConfig.FLAVOR, "type", "I", "getType", "()I", "d", "(I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p3 {

    @SerializedName("last_timestamp")
    private long lastTimestamp;

    @SerializedName("type")
    private int type;

    @SerializedName("user_id")
    private final String userId;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof p3) == false) goto L12;
        p3 r7 = (p3) r6;
        if (Intrinsics.areEqual(this.userId, r7.userId) == true) goto L8;
        return false;
    L8:
        if (this.lastTimestamp == r7.lastTimestamp) goto L10;
        return false;
    L10:
        if (this.type == r7.type) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.userId;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r2 = this.lastTimestamp;
        return (((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31) + this.type;
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "SendGiftRelation(userId=" + this.userId + ", lastTimestamp=" + this.lastTimestamp + ", type=" + this.type + ")";
    }

    public final long a() {
        return this.lastTimestamp;
    }

    public final String b() {
        return this.userId;
    }

    public final int getType() {
        return this.type;
    }

    public final void c(long r1) {
        this.lastTimestamp = r1;
    }

    public final void d(int r1) {
        this.type = r1;
    }

    public p3(String r2, long r3, int r5) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        this.userId = r2;
        this.lastTimestamp = r3;
        this.type = r5;
    }
}
