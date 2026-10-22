package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/config/t81;", "", "", "period", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setPeriod", "(Ljava/lang/String;)V", "", "noActionTimeLimit", "F", "a", "()F", "setNoActionTimeLimit", "(F)V", "", "screenOffCountLimit", "I", "c", "()I", "setScreenOffCountLimit", "(I)V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t81 {

    @SerializedName("no_action_limit_time")
    private float noActionTimeLimit;

    @SerializedName("period")
    private String period;

    @SerializedName("screen_off_limit_count")
    private int screenOffCountLimit;

    public t81() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof t81) == false) goto L12;
        t81 r4 = (t81) r3;
        if (Intrinsics.areEqual(this.period, r4.period) == true) goto L8;
        return false;
    L8:
        if (Float.compare(this.noActionTimeLimit, r4.noActionTimeLimit) == 0) goto L10;
        return false;
    L10:
        if (this.screenOffCountLimit == r4.screenOffCountLimit) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.period;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (((r1 * 31) + Float.floatToIntBits(this.noActionTimeLimit)) * 31) + this.screenOffCountLimit;
    L5:
        r1 = 0;
        goto L7
    }

    public final String toString() {
        return "LiveTimePeriodConfig(period=" + this.period + ", noActionTimeLimit=" + this.noActionTimeLimit + ", screenOffCountLimit=" + this.screenOffCountLimit + ")";
    }

    public final float a() {
        return this.noActionTimeLimit;
    }

    public final String b() {
        return this.period;
    }

    public final int c() {
        return this.screenOffCountLimit;
    }

    public t81(int r1) {
        this.period = "22:00:00-07:00:00";
        this.noActionTimeLimit = 1.5f;
        this.screenOffCountLimit = 1;
    }
}
