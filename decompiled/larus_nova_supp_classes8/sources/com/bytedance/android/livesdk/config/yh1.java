package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/config/yh1;", "", "", "tapAnimInterval", "J", "f", "()J", "", "cancelDiggCountAnim", "Z", "a", "()Z", "disableVibrationEffect", "e", "disableIconScale", "d", "disableIconRotate", "c", "disableIconAlpha", "b", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class yh1 {

    @SerializedName("cancel_digg_count_anim")
    private final boolean cancelDiggCountAnim;

    @SerializedName("disable_icon_alpha")
    private final boolean disableIconAlpha;

    @SerializedName("disable_icon_rotate")
    private final boolean disableIconRotate;

    @SerializedName("disable_icon_scale")
    private final boolean disableIconScale;

    @SerializedName("disable_vibration_effect")
    private final boolean disableVibrationEffect;

    @SerializedName("tap_anim_interval")
    private final long tapAnimInterval;

    public yh1() {
        this(0);
    }

    public final boolean a() {
        return this.cancelDiggCountAnim;
    }

    public final boolean b() {
        return this.disableIconAlpha;
    }

    public final boolean c() {
        return this.disableIconRotate;
    }

    public final boolean d() {
        return this.disableIconScale;
    }

    public final boolean e() {
        return this.disableVibrationEffect;
    }

    public final long f() {
        return this.tapAnimInterval;
    }

    public yh1(int r3) {
        this.tapAnimInterval = 0;
        this.cancelDiggCountAnim = false;
        this.disableVibrationEffect = false;
        this.disableIconScale = false;
        this.disableIconRotate = false;
        this.disableIconAlpha = false;
    }
}
