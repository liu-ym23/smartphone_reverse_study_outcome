package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/g0;", "", "", "percent", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "", "", "Lcom/bytedance/android/live/ktv/common/model/api/q0;", "range", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class g0 {

    @SerializedName("score_reporting_threshold_sung_percent")
    private final Integer percent;

    @SerializedName("rate_feedback")
    private final Map<String, q0> range;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g0) == false) goto L10;
        g0 r4 = (g0) r3;
        if (Intrinsics.areEqual(this.percent, r4.percent) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.range, r4.range) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.percent;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, q0> r4 = this.range;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "MidiConfig(percent=" + this.percent + ", range=" + this.range + ")";
    }

    public g0() {
        this.percent = null;
        this.range = null;
    }

    public final Integer a() {
        return this.percent;
    }

    public final Map<String, q0> b() {
        return this.range;
    }
}
