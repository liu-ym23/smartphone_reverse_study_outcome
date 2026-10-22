package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/config/wf1;", "", "Lcom/bytedance/android/livesdk/config/uf1;", "orientation", "Lcom/bytedance/android/livesdk/config/uf1;", "getOrientation", "()Lcom/bytedance/android/livesdk/config/uf1;", "setOrientation", "(Lcom/bytedance/android/livesdk/config/uf1;)V", "Lcom/bytedance/android/livesdk/config/zf1;", "position", "Lcom/bytedance/android/livesdk/config/zf1;", "getPosition", "()Lcom/bytedance/android/livesdk/config/zf1;", "setPosition", "(Lcom/bytedance/android/livesdk/config/zf1;)V", "liverevlink-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class wf1 {

    @SerializedName("Orientation")
    private uf1 orientation;

    @SerializedName("position")
    private zf1 position;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof wf1) == false) goto L10;
        wf1 r4 = (wf1) r3;
        if (Intrinsics.areEqual(this.orientation, r4.orientation) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.position, r4.position) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        uf1 r0 = this.orientation;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        zf1 r4 = this.position;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "RevSpatialAudioPositionConfig(orientation=" + this.orientation + ", position=" + this.position + ")";
    }

    public wf1() {
        this.orientation = null;
        this.position = null;
    }
}
