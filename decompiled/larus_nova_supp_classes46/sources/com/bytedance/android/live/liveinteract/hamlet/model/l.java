package com.bytedance.android.live.liveinteract.hamlet.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/hamlet/model/l;", "", "", "x", "Ljava/lang/Double;", "a", "()Ljava/lang/Double;", "y", "b", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class l {

    @SerializedName("x")
    private final Double x;

    @SerializedName("y")
    private final Double y;

    public l() {
        this(null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof l) == false) goto L10;
        l r4 = (l) r3;
        if (Intrinsics.areEqual(this.x, r4.x) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.y, r4.y) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Double r0 = this.x;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Double r4 = this.y;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "HamletCestPositionStruct(x=" + this.x + ", y=" + this.y + ")";
    }

    public final Double a() {
        return this.x;
    }

    public final Double b() {
        return this.y;
    }

    public l(Double r1, Double r2) {
        this.x = r1;
        this.y = r2;
    }
}
