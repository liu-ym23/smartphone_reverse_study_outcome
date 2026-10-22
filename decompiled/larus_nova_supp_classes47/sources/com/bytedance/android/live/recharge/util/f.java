package com.bytedance.android.live.recharge.util;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/recharge/util/f;", "", "", "counterOptEnable", "Z", "a", "()Z", "", "counterOptStyle", "I", "b", "()I", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class f {

    @SerializedName("counter_opt_enable")
    private final boolean counterOptEnable;

    @SerializedName("counter_opt_style")
    private final int counterOptStyle;

    public f() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L10;
        f r4 = (f) r3;
        if (this.counterOptEnable == r4.counterOptEnable) goto L8;
        return false;
    L8:
        if (this.counterOptStyle == r4.counterOptStyle) goto L16;
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
        boolean r0 = this.counterOptEnable;
        ?? r1 = r0;
        if (r0 == false) goto L6;
        r1 = 1;
    L6:
        return (r1 * 31) + this.counterOptStyle;
    }

    public final String toString() {
        return "RechargeCounterOptConfig(counterOptEnable=" + this.counterOptEnable + ", counterOptStyle=" + this.counterOptStyle + ")";
    }

    public final boolean a() {
        return this.counterOptEnable;
    }

    public final int b() {
        return this.counterOptStyle;
    }

    public f(int r1) {
        this.counterOptEnable = false;
        this.counterOptStyle = 0;
    }
}
