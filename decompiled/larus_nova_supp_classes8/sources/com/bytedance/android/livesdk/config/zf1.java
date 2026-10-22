package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/zf1;", "", "", "x", "I", "getX", "()I", "setX", "(I)V", "y", "getY", "setY", "z", "getZ", "setZ", "liverevlink-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class zf1 {

    @SerializedName("x")
    private int x;

    @SerializedName("y")
    private int y;

    @SerializedName("z")
    private int z;

    public zf1() {
        this(0, 0, 0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof zf1) == false) goto L12;
        zf1 r4 = (zf1) r3;
        if (this.x == r4.x) goto L8;
        return false;
    L8:
        if (this.y == r4.y) goto L10;
        return false;
    L10:
        if (this.z == r4.z) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.x * 31) + this.y) * 31) + this.z;
    }

    public final String toString() {
        return "RevSpatialPosition(x=" + this.x + ", y=" + this.y + ", z=" + this.z + ")";
    }

    public zf1(int r1, int r2, int r3) {
        this.x = r1;
        this.y = r2;
        this.z = r3;
    }
}
