package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/e0;", "", "", "rank", "I", "a", "()I", "", "hot", "J", "getHot", "()J", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class e0 implements vh7.h {

    @SerializedName("hot")
    protected long hot;

    @SerializedName("rank")
    protected int rank;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof e0) == false) goto L10;
        e0 r6 = (e0) r5;
        if (this.rank == r6.rank) goto L8;
        return false;
    L8:
        if (this.hot == r6.hot) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r0 = this.rank * 31;
        long r1 = this.hot;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "KtvUserWeeklyHotRankResponse(rank=" + this.rank + ", hot=" + this.hot + ")";
    }

    public e0() {
        this.rank = 0;
        this.hot = 0;
    }

    public final int a() {
        return this.rank;
    }

    public e0(am3.g r8) {
        long r0 = r8.c();
        int r3 = 0;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L11;
        if (r4 != 1) goto L7;
        this.rank = r8.i();
        r3 = r3 | 1;
        goto L3
    L7:
        if (r4 != 2) goto L8;
        this.hot = r8.j();
        r3 = r3 | 2;
        goto L3
    L8:
        am3.h.e(r8);
        goto L3
    L11:
        r8.d(r0);
        if ((r3 & 1) != 0) goto L15;
        this.rank = 0;
    L15:
        if ((r3 & 2) != 0) goto L27;
        this.hot = 0;
        return;
    }
}
