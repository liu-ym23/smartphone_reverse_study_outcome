package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0014\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/config/d3;", "", "", "state", "I", "getState", "()I", "", "inDuration", "J", "getInDuration", "()J", "outDuration", "getOutDuration", "stayDuration", "getStayDuration", "extraDuration", "getExtraDuration", "switchDuration", "getSwitchDuration", "specialInDuration", "getSpecialInDuration", "a", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d3 {

    @SerializedName("extra")
    private final long extraDuration;

    @SerializedName("in")
    private final long inDuration;

    @SerializedName("out")
    private final long outDuration;

    @SerializedName("special_in")
    private final long specialInDuration;

    @SerializedName("state")
    private final int state;

    @SerializedName("stay")
    private final long stayDuration;

    @SerializedName("switch")
    private final long switchDuration;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof d3) == false) goto L20;
        d3 r7 = (d3) r6;
        if (this.state == r7.state) goto L8;
        return false;
    L8:
        if (this.inDuration == r7.inDuration) goto L10;
        return false;
    L10:
        if (this.outDuration == r7.outDuration) goto L12;
        return false;
    L12:
        if (this.stayDuration == r7.stayDuration) goto L14;
        return false;
    L14:
        if (this.extraDuration == r7.extraDuration) goto L16;
        return false;
    L16:
        if (this.switchDuration == r7.switchDuration) goto L18;
        return false;
    L18:
        if (this.specialInDuration == r7.specialInDuration) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r0 = this.state * 31;
        long r1 = this.inDuration;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.outDuration;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.stayDuration;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        long r7 = this.extraDuration;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        long r9 = this.switchDuration;
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        long r11 = this.specialInDuration;
        return r10 + ((int) (r11 ^ (r11 >>> 32)));
    }

    public final String toString() {
        return "Duration(state=" + this.state + ", inDuration=" + this.inDuration + ", outDuration=" + this.outDuration + ", stayDuration=" + this.stayDuration + ", extraDuration=" + this.extraDuration + ", switchDuration=" + this.switchDuration + ", specialInDuration=" + this.specialInDuration + ")";
    }

    public d3() {
        this.state = 1;
        this.inDuration = 800;
        this.outDuration = 1000;
        this.stayDuration = 2000;
        this.extraDuration = 2000;
        this.switchDuration = 500;
        this.specialInDuration = 200;
    }
}
