package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/config/c0;", "", "", "liveFirstDuration", "J", "a", "()J", "liveSecondDuration", "b", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c0 {

    @SerializedName("live_first_duration")
    private final long liveFirstDuration;

    @SerializedName("live_second_duration")
    private final long liveSecondDuration;

    public c0() {
        this(0);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c0) == false) goto L10;
        c0 r7 = (c0) r6;
        if (this.liveFirstDuration == r7.liveFirstDuration) goto L8;
        return false;
    L8:
        if (this.liveSecondDuration == r7.liveSecondDuration) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r0 = this.liveFirstDuration;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.liveSecondDuration;
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "AnchorRoomPerfConfig(liveFirstDuration=" + this.liveFirstDuration + ", liveSecondDuration=" + this.liveSecondDuration + ")";
    }

    public final long a() {
        return this.liveFirstDuration;
    }

    public final long b() {
        return this.liveSecondDuration;
    }

    public c0(int r3) {
        this.liveFirstDuration = 5;
        this.liveSecondDuration = 120;
    }
}
