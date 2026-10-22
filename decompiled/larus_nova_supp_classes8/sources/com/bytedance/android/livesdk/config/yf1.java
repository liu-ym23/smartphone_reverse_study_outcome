package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/yf1;", "", "", "x", "F", "getX", "()F", "setX", "(F)V", "y", "getY", "setY", "z", "getZ", "setZ", "liverevlink-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class yf1 {

    @SerializedName("x")
    private float x;

    @SerializedName("y")
    private float y;

    @SerializedName("z")
    private float z;

    public yf1() {
        this(0.0f, 0.0f, 0.0f);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof yf1) == false) goto L12;
        yf1 r4 = (yf1) r3;
        if (Float.compare(this.x, r4.x) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.y, r4.y) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.z, r4.z) == 0) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y)) * 31) + Float.floatToIntBits(this.z);
    }

    public final String toString() {
        return "RevSpatialOrientation(x=" + this.x + ", y=" + this.y + ", z=" + this.z + ")";
    }

    public yf1(float r1, float r2, float r3) {
        this.x = r1;
        this.y = r2;
        this.z = r3;
    }
}
