package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b<\u0010=R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\"\u00103\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\"\u001a\u0004\b4\u0010$\"\u0004\b5\u0010&R\"\u00106\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0015\u001a\u0004\b7\u0010\u0017\"\u0004\b8\u0010\u0019R\"\u00109\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\u0015\u001a\u0004\b:\u0010\u0017\"\u0004\b;\u0010\u0019¨\u0006>"}, d2 = {"Lcom/bytedance/android/livesdk/config/n1;", "", "", "clickClearEnable", "Z", "a", "()Z", "setClickClearEnable", "(Z)V", "keepClearEnable", "h", "setKeepClearEnable", "", "exitAreaPercent", "F", "c", "()F", "setExitAreaPercent", "(F)V", "", "exitDistance", "I", "d", "()I", "setExitDistance", "(I)V", "exitVelocity", "e", "setExitVelocity", "guideCount", "g", "setGuideCount", "", "clickDelayTIme", "J", "b", "()J", "setClickDelayTIme", "(J)V", "gestureRegisterOpt", "f", "setGestureRegisterOpt", "psClickOpt", "j", "setPsClickOpt", "playerClickOpt", "i", "setPlayerClickOpt", "roomGuideEnable", "l", "setRoomGuideEnable", "roomGuideCountdown", "k", "setRoomGuideCountdown", "roomGuideLimitToday", "m", "setRoomGuideLimitToday", "roomGuideLimitTotal", "n", "setRoomGuideLimitTotal", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n1 {

    @SerializedName("click_clear_enable")
    private boolean clickClearEnable;

    @SerializedName("click_delay_time")
    private long clickDelayTIme;

    @SerializedName("exit_area_percent")
    private float exitAreaPercent;

    @SerializedName("exit_distance")
    private int exitDistance;

    @SerializedName("exit_velocity")
    private int exitVelocity;

    @SerializedName("gesture_register_opt")
    private boolean gestureRegisterOpt;

    @SerializedName("guide_count")
    private int guideCount;

    @SerializedName("keep_clear_enable")
    private boolean keepClearEnable;

    @SerializedName("player_click_opt")
    private boolean playerClickOpt;

    @SerializedName("ps_click_opt")
    private boolean psClickOpt;

    @SerializedName("room_guide_countdown")
    private long roomGuideCountdown;

    @SerializedName("room_guide_enable")
    private boolean roomGuideEnable;

    @SerializedName("room_guide_limit_today")
    private int roomGuideLimitToday;

    @SerializedName("room_guide_limit_total")
    private int roomGuideLimitTotal;

    public n1() {
        this.exitAreaPercent = 0.5f;
        this.exitDistance = 40;
        this.exitVelocity = 100;
        this.guideCount = 1;
        this.clickDelayTIme = 700;
        this.roomGuideCountdown = 10;
        this.roomGuideLimitToday = 1;
        this.roomGuideLimitTotal = 2;
    }

    public final boolean a() {
        return this.clickClearEnable;
    }

    public final long b() {
        return this.clickDelayTIme;
    }

    public final float c() {
        return this.exitAreaPercent;
    }

    public final int d() {
        return this.exitDistance;
    }

    public final int e() {
        return this.exitVelocity;
    }

    public final boolean f() {
        return this.gestureRegisterOpt;
    }

    public final int g() {
        return this.guideCount;
    }

    public final boolean h() {
        return this.keepClearEnable;
    }

    public final boolean i() {
        return this.playerClickOpt;
    }

    public final boolean j() {
        return this.psClickOpt;
    }

    public final long k() {
        return this.roomGuideCountdown;
    }

    public final boolean l() {
        return this.roomGuideEnable;
    }

    public final int m() {
        return this.roomGuideLimitToday;
    }

    public final int n() {
        return this.roomGuideLimitTotal;
    }
}
