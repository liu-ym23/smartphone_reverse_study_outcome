package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000fR\u001a\u0010\u0017\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/config/yc1;", "", "", "snowIconSpreadFlowersUrl", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "smallCardShowUrl", "b", "smallCardHideUrl", "a", "", "snowIconAnimType", "I", "e", "()I", "", "snowIconAnimLowDevice", "F", "d", "()F", "snowIconPeriodicSpreadFlowersAnimInterval", "g", "snowIconDisableSmallCard", "f", "smallCardShowUrlV2", "c", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class yc1 {

    @SerializedName("small_card_hide_url")
    private final String smallCardHideUrl;

    @SerializedName("small_card_show_url")
    private final String smallCardShowUrl;

    @SerializedName("small_card_show_url_v2")
    private final String smallCardShowUrlV2;

    @SerializedName("snow_icon_animation_android_low_device")
    private final float snowIconAnimLowDevice;

    @SerializedName("live_miniapp_snow_icon_animation")
    private final int snowIconAnimType;

    @SerializedName("snow_icon_animation_disable_small_card")
    private final int snowIconDisableSmallCard;

    @SerializedName("snow_icon_animation_time_interval")
    private final int snowIconPeriodicSpreadFlowersAnimInterval;

    @SerializedName("snow_icon_spread_flowers_url")
    private final String snowIconSpreadFlowersUrl;

    public static final class a {
    }

    static {
    }

    public yc1() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof yc1) == false) goto L22;
        yc1 r4 = (yc1) r3;
        if (Intrinsics.areEqual(this.snowIconSpreadFlowersUrl, r4.snowIconSpreadFlowersUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.smallCardShowUrl, r4.smallCardShowUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.smallCardHideUrl, r4.smallCardHideUrl) == true) goto L12;
        return false;
    L12:
        if (this.snowIconAnimType == r4.snowIconAnimType) goto L14;
        return false;
    L14:
        if (Float.compare(this.snowIconAnimLowDevice, r4.snowIconAnimLowDevice) == 0) goto L16;
        return false;
    L16:
        if (this.snowIconPeriodicSpreadFlowersAnimInterval == r4.snowIconPeriodicSpreadFlowersAnimInterval) goto L18;
        return false;
    L18:
        if (this.snowIconDisableSmallCard == r4.snowIconDisableSmallCard) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.smallCardShowUrlV2, r4.smallCardShowUrlV2) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r0 = this.snowIconSpreadFlowersUrl;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.smallCardShowUrl;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.smallCardHideUrl;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (((((((((r6 + r8) * 31) + this.snowIconAnimType) * 31) + Float.floatToIntBits(this.snowIconAnimLowDevice)) * 31) + this.snowIconPeriodicSpreadFlowersAnimInterval) * 31) + this.snowIconDisableSmallCard) * 31;
        String r10 = this.smallCardShowUrlV2;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenPlatformMicroAppSnowIconAnimConfig(snowIconSpreadFlowersUrl=" + this.snowIconSpreadFlowersUrl + ", smallCardShowUrl=" + this.smallCardShowUrl + ", smallCardHideUrl=" + this.smallCardHideUrl + ", snowIconAnimType=" + this.snowIconAnimType + ", snowIconAnimLowDevice=" + this.snowIconAnimLowDevice + ", snowIconPeriodicSpreadFlowersAnimInterval=" + this.snowIconPeriodicSpreadFlowersAnimInterval + ", snowIconDisableSmallCard=" + this.snowIconDisableSmallCard + ", smallCardShowUrlV2=" + this.smallCardShowUrlV2 + ")";
    }

    public final String a() {
        return this.smallCardHideUrl;
    }

    public final String b() {
        return this.smallCardShowUrl;
    }

    public final String c() {
        return this.smallCardShowUrlV2;
    }

    public final float d() {
        return this.snowIconAnimLowDevice;
    }

    public final int e() {
        return this.snowIconAnimType;
    }

    public final int f() {
        return this.snowIconDisableSmallCard;
    }

    public final int g() {
        return this.snowIconPeriodicSpreadFlowersAnimInterval;
    }

    public final String h() {
        return this.snowIconSpreadFlowersUrl;
    }

    public yc1(int r3) {
        this.snowIconSpreadFlowersUrl = null;
        this.smallCardShowUrl = null;
        this.smallCardHideUrl = null;
        this.snowIconAnimType = 0;
        this.snowIconAnimLowDevice = 0.0f;
        this.snowIconPeriodicSpreadFlowersAnimInterval = 10000;
        this.snowIconDisableSmallCard = 0;
        this.smallCardShowUrlV2 = null;
    }
}
