package com.bytedance.android.live.profit.redpacket.jsbridge;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/jsbridge/a;", "", "", "propDefId", "J", "c", "()J", "", "giftCount", "I", "a", "()I", "", "giftSource", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("giftCount")
    private final int giftCount;

    @SerializedName("giftSource")
    private final String giftSource;

    @SerializedName("propDefId")
    private final long propDefId;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a) == false) goto L12;
        a r7 = (a) r6;
        if (this.propDefId == r7.propDefId) goto L8;
        return false;
    L8:
        if (this.giftCount == r7.giftCount) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.giftSource, r7.giftSource) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r0 = this.propDefId;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.giftCount) * 31;
        String r2 = this.giftSource;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r1 + r3;
    L5:
        r3 = 0;
        goto L7
    }

    public final String toString() {
        return "PropFromRedPacketLynx(propDefId=" + this.propDefId + ", giftCount=" + this.giftCount + ", giftSource=" + this.giftSource + ")";
    }

    public final int a() {
        return this.giftCount;
    }

    public final String b() {
        return this.giftSource;
    }

    public final long c() {
        return this.propDefId;
    }
}
