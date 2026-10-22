package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/config/a6;", "", "", "duration", "I", "a", "()I", "iconStyle", "b", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a6 {

    @SerializedName("duration")
    private final int duration;

    @SerializedName("portrait_cast_screen_icon_style")
    private final int iconStyle;

    public a6() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a6) == false) goto L10;
        a6 r4 = (a6) r3;
        if (this.duration == r4.duration) goto L8;
        return false;
    L8:
        if (this.iconStyle == r4.iconStyle) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.duration * 31) + this.iconStyle;
    }

    public final String toString() {
        return "GameCastScreenConfig(duration=" + this.duration + ", iconStyle=" + this.iconStyle + ")";
    }

    public final int a() {
        return this.duration;
    }

    public final int b() {
        return this.iconStyle;
    }

    public a6(int r1) {
        this.duration = 5;
        this.iconStyle = 0;
    }
}
