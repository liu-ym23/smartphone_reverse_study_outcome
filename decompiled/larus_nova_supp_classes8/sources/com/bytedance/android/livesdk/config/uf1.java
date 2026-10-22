package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/uf1;", "", "Lcom/bytedance/android/livesdk/config/yf1;", "forward", "Lcom/bytedance/android/livesdk/config/yf1;", "getForward", "()Lcom/bytedance/android/livesdk/config/yf1;", "setForward", "(Lcom/bytedance/android/livesdk/config/yf1;)V", "right", "getRight", "setRight", "up", "getUp", "setUp", "liverevlink-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class uf1 {

    @SerializedName("forward")
    private yf1 forward;

    @SerializedName("right")
    private yf1 right;

    @SerializedName("up")
    private yf1 up;

    public uf1() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof uf1) == false) goto L12;
        uf1 r4 = (uf1) r3;
        if (Intrinsics.areEqual(this.forward, r4.forward) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.right, r4.right) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.up, r4.up) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        yf1 r0 = this.forward;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        yf1 r4 = this.right;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        yf1 r7 = this.up;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "RevSpatialAudioHumanOrientation(forward=" + this.forward + ", right=" + this.right + ", up=" + this.up + ")";
    }

    public uf1(int r5) {
        yf1 r6 = new yf1(1.0f, 0.0f, 0.0f);
        yf1 r2 = new yf1(0.0f, 1.0f, 0.0f);
        yf1 r3 = new yf1(0.0f, 0.0f, 1.0f);
        this.forward = r6;
        this.right = r2;
        this.up = r3;
    }
}
