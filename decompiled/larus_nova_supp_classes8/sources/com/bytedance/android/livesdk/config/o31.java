package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.feed.services.AppointmentService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/config/o31;", "", "", "max", "J", "b", "()J", "min", "c", "defaultValue", "a", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o31 {

    @SerializedName("default")
    private final long defaultValue;

    @SerializedName("max")
    private final long max;

    @SerializedName("min")
    private final long min;

    public static final class a {
    }

    static {
    }

    public o31() {
        this(0);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof o31) == false) goto L12;
        o31 r7 = (o31) r6;
        if (this.max == r7.max) goto L8;
        return false;
    L8:
        if (this.min == r7.min) goto L10;
        return false;
    L10:
        if (this.defaultValue == r7.defaultValue) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r0 = this.max;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.min;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.defaultValue;
        return r2 + ((int) (r4 ^ (r4 >>> 32)));
    }

    public final String toString() {
        return "LiveGameImDelayConfig(max=" + this.max + ", min=" + this.min + ", defaultValue=" + this.defaultValue + ")";
    }

    public final long a() {
        return this.defaultValue;
    }

    public final long b() {
        return this.max;
    }

    public final long c() {
        return this.min;
    }

    public o31(int r3) {
        this.max = AppointmentService.SOURCE_UNDEFINED;
        this.min = 1000;
        this.defaultValue = 7000;
    }
}
