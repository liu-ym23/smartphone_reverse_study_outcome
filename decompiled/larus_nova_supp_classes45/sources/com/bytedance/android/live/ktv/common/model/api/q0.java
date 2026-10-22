package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/q0;", "", "", "ceiling", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "floor", "b", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class q0 {

    @SerializedName("ceiling")
    private final Long ceiling;

    @SerializedName("floor")
    private final Long floor;

    public q0() {
        this(null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof q0) == false) goto L10;
        q0 r4 = (q0) r3;
        if (Intrinsics.areEqual(this.ceiling, r4.ceiling) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.floor, r4.floor) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Long r0 = this.ceiling;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.floor;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "RateRange(ceiling=" + this.ceiling + ", floor=" + this.floor + ")";
    }

    public final Long a() {
        return this.ceiling;
    }

    public final Long b() {
        return this.floor;
    }

    public q0(Long r1, Long r2) {
        this.ceiling = r1;
        this.floor = r2;
    }
}
