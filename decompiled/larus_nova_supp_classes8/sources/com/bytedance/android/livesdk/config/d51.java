package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b9\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b9\u0010:R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\"\u00103\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\"\u00106\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0004\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\b¨\u0006;"}, d2 = {"Lcom/bytedance/android/livesdk/config/d51;", "", "", "danmukuV1Enable", "Z", "c", "()Z", "setDanmukuV1Enable", "(Z)V", "danmukuV2Enable", "d", "setDanmukuV2Enable", "danmukuCommentGrayEnable", "b", "setDanmukuCommentGrayEnable", "clarityEnable", "a", "setClarityEnable", "shareOutsideEnable", "p", "setShareOutsideEnable", "shareLandscapeCycleEnable", "o", "setShareLandscapeCycleEnable", "shareQuickShotEnable", "q", "setShareQuickShotEnable", "enableVideoScale", "k", "setEnableVideoScale", "enableVideoScaleV2", "n", "setEnableVideoScaleV2", "enableVideoScaleMoreDialogV2", "l", "setEnableVideoScaleMoreDialogV2", "enableVideoScalePicTypeV2", "m", "setEnableVideoScalePicTypeV2", "enablePlayerScaleBugfix", "f", "setEnablePlayerScaleBugfix", "enablePlayerScaleFastClk", "h", "setEnablePlayerScaleFastClk", "enablePlayerScaleBugfixV2", "g", "setEnablePlayerScaleBugfixV2", "enablePlayerScalePicTypeCrashfix", "j", "setEnablePlayerScalePicTypeCrashfix", "enablePlayerScaleOOMfix", "i", "setEnablePlayerScaleOOMfix", "enableCommentScaleBugfix", "e", "setEnableCommentScaleBugfix", "<init>", "()V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d51 {

    @SerializedName("clarity_enable")
    private boolean clarityEnable;

    @SerializedName("danmuku_comment_gray_enable")
    private boolean danmukuCommentGrayEnable;

    @SerializedName("danmuku_v1_enable")
    private boolean danmukuV1Enable;

    @SerializedName("danmuku_v2_enable")
    private boolean danmukuV2Enable;

    @SerializedName("mediaroom_comment_scale_bugfix")
    private boolean enableCommentScaleBugfix;

    @SerializedName("player_scale_bugfix")
    private boolean enablePlayerScaleBugfix;

    @SerializedName("player_scale_bugfix_v2")
    private boolean enablePlayerScaleBugfixV2;

    @SerializedName("player_scale_fastclk_fix")
    private boolean enablePlayerScaleFastClk;

    @SerializedName("player_scale_oom_fix")
    private boolean enablePlayerScaleOOMfix;

    @SerializedName("player_scale_picstyle_crash_fix")
    private boolean enablePlayerScalePicTypeCrashfix;

    @SerializedName("player_scale_enable")
    private boolean enableVideoScale;

    @SerializedName("player_scale_enable_moredialog_v2")
    private boolean enableVideoScaleMoreDialogV2;

    @SerializedName("player_scale_enable_pictype")
    private boolean enableVideoScalePicTypeV2;

    @SerializedName("player_scale_enable_v2")
    private boolean enableVideoScaleV2;

    @SerializedName("share_landscape_cycle_enable")
    private boolean shareLandscapeCycleEnable;

    @SerializedName("share_outside_enable")
    private boolean shareOutsideEnable;

    @SerializedName("share_quickshot_enable")
    private boolean shareQuickShotEnable;

    public d51() {
        this.shareLandscapeCycleEnable = true;
        this.enableVideoScaleMoreDialogV2 = true;
        this.enableVideoScalePicTypeV2 = true;
        this.enablePlayerScaleBugfix = true;
        this.enablePlayerScaleFastClk = true;
        this.enablePlayerScaleBugfixV2 = true;
        this.enablePlayerScalePicTypeCrashfix = true;
        this.enablePlayerScaleOOMfix = true;
        this.enableCommentScaleBugfix = true;
    }

    public final boolean a() {
        return this.clarityEnable;
    }

    public final boolean b() {
        return this.danmukuCommentGrayEnable;
    }

    public final boolean c() {
        return this.danmukuV1Enable;
    }

    public final boolean d() {
        return this.danmukuV2Enable;
    }

    public final boolean e() {
        return this.enableCommentScaleBugfix;
    }

    public final boolean f() {
        return this.enablePlayerScaleBugfix;
    }

    public final boolean g() {
        return this.enablePlayerScaleBugfixV2;
    }

    public final boolean h() {
        return this.enablePlayerScaleFastClk;
    }

    public final boolean i() {
        return this.enablePlayerScaleOOMfix;
    }

    public final boolean j() {
        return this.enablePlayerScalePicTypeCrashfix;
    }

    public final boolean k() {
        return this.enableVideoScale;
    }

    public final boolean l() {
        return this.enableVideoScaleMoreDialogV2;
    }

    public final boolean m() {
        return this.enableVideoScalePicTypeV2;
    }

    public final boolean n() {
        return this.enableVideoScaleV2;
    }

    public final boolean o() {
        return this.shareLandscapeCycleEnable;
    }

    public final boolean p() {
        return this.shareOutsideEnable;
    }

    public final boolean q() {
        return this.shareQuickShotEnable;
    }
}
