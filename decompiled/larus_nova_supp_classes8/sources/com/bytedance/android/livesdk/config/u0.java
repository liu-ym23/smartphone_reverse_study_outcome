package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/config/u0;", "", "", "default", "I", "getDefault", "()I", "min", "getMin", "max", "getMax", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u0 {

    /* JADX INFO: renamed from: default, reason: not valid java name */
    @SerializedName("default")
    private final int f1default;

    @SerializedName("max")
    private final int max;

    @SerializedName("min")
    private final int min;

    public u0() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof u0) == false) goto L12;
        u0 r4 = (u0) r3;
        if (this.f1default == r4.f1default) goto L8;
        return false;
    L8:
        if (this.min == r4.min) goto L10;
        return false;
    L10:
        if (this.max == r4.max) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.f1default * 31) + this.min) * 31) + this.max;
    }

    public final String toString() {
        return "BackgroundOpacityConfig(default=" + this.f1default + ", min=" + this.min + ", max=" + this.max + ")";
    }

    public u0(int r1) {
        this.f1default = 50;
        this.min = 30;
        this.max = 80;
    }
}
