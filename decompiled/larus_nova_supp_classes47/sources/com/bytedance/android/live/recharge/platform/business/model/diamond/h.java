package com.bytedance.android.live.recharge.platform.business.model.diamond;

import com.bytedance.android.livesdkapi.depend.model.IChargeDeal;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/diamond/h;", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/IChargeDeal;", Constants.Keys.DATA, "Ljava/util/List;", "a", "()Ljava/util/List;", "d", "(Ljava/util/List;)V", "Lcom/bytedance/android/live/recharge/model/diamond/a;", "extra", "Lcom/bytedance/android/live/recharge/model/diamond/a;", "b", "()Lcom/bytedance/android/live/recharge/model/diamond/a;", "setExtra", "(Lcom/bytedance/android/live/recharge/model/diamond/a;)V", "", "timestamp", "J", "c", "()J", "setTimestamp", "(J)V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class h {

    @SerializedName(Constants.Keys.DATA)
    private List<IChargeDeal> data;

    @SerializedName("extra")
    private com.bytedance.android.live.recharge.model.diamond.a extra;

    @SerializedName("timestamp")
    private long timestamp;

    public h() {
        this(null, null, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof h) == false) goto L12;
        h r6 = (h) r5;
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L10;
        return false;
    L10:
        if (this.timestamp == r6.timestamp) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<IChargeDeal> r0 = this.data;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        com.bytedance.android.live.recharge.model.diamond.a r4 = this.extra;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        long r6 = this.timestamp;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LocalDealSetCache(data=" + this.data + ", extra=" + this.extra + ", timestamp=" + this.timestamp + ")";
    }

    public final List<IChargeDeal> a() {
        return this.data;
    }

    public final com.bytedance.android.live.recharge.model.diamond.a b() {
        return this.extra;
    }

    public final long c() {
        return this.timestamp;
    }

    public final void d(List<IChargeDeal> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.data = r2;
    }

    public h(List r3, com.bytedance.android.live.recharge.model.diamond.a r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = new ArrayList();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r4 = new com.bytedance.android.live.recharge.model.diamond.a();
    L9:
        if ((r5 & 4) == 0) goto L11;
        long r0 = System.currentTimeMillis();
    L12:
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r4, "extra");
        this.data = r3;
        this.extra = r4;
        this.timestamp = r0;
        return;
    L11:
        r0 = 0;
        goto L12
    }
}
