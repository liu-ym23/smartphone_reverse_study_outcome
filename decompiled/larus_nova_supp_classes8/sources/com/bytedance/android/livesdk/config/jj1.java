package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b$\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\b¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/config/jj1;", "", "", "enableSpecialDrawer", "Z", "g", "()Z", "setEnableSpecialDrawer", "(Z)V", "enableLandscapeEntrance", "c", "setEnableLandscapeEntrance", "enablePortraitEntrance", "f", "setEnablePortraitEntrance", "enableLandscapeScale", "d", "setEnableLandscapeScale", "enableLandJump", "b", "setEnableLandJump", "enableCameraJumpBack", "a", "setEnableCameraJumpBack", "enableMoreVideoAnywhere", "e", "setEnableMoreVideoAnywhere", "schemaSupportOpenDrawer", "j", "setSchemaSupportOpenDrawer", "fixedReplayJump", "i", "setFixedReplayJump", "fixedAutoSwitchOrientation", "h", "setFixedAutoSwitchOrientation", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class jj1 {

    @SerializedName("enable_camera_jump_back")
    private boolean enableCameraJumpBack;

    @SerializedName("enable_landscape_jump")
    private boolean enableLandJump;

    @SerializedName("enable_landscape_entrance")
    private boolean enableLandscapeEntrance;

    @SerializedName("enable_landscape_scale")
    private boolean enableLandscapeScale;

    @SerializedName("enable_more_video_anywhere")
    private boolean enableMoreVideoAnywhere;

    @SerializedName("enable_portrait_entrance")
    private boolean enablePortraitEntrance;

    @SerializedName("enable_special_drawer")
    private boolean enableSpecialDrawer;

    @SerializedName("fixed_auto_switch_orientation")
    private boolean fixedAutoSwitchOrientation;

    @SerializedName("fixed_replay_jump")
    private boolean fixedReplayJump;

    @SerializedName("schema_support_open_drawer")
    private boolean schemaSupportOpenDrawer;

    public jj1() {
        this.enableSpecialDrawer = true;
        this.enableLandscapeEntrance = true;
        this.enablePortraitEntrance = true;
        this.enableLandscapeScale = true;
        this.enableLandJump = true;
        this.enableCameraJumpBack = true;
        this.enableMoreVideoAnywhere = true;
        this.schemaSupportOpenDrawer = true;
        this.fixedReplayJump = true;
        this.fixedAutoSwitchOrientation = true;
    }

    public final boolean a() {
        return this.enableCameraJumpBack;
    }

    public final boolean b() {
        return this.enableLandJump;
    }

    public final boolean c() {
        return this.enableLandscapeEntrance;
    }

    public final boolean d() {
        return this.enableLandscapeScale;
    }

    public final boolean e() {
        return this.enableMoreVideoAnywhere;
    }

    public final boolean f() {
        return this.enablePortraitEntrance;
    }

    public final boolean g() {
        return this.enableSpecialDrawer;
    }

    public final boolean h() {
        return this.fixedAutoSwitchOrientation;
    }

    public final boolean i() {
        return this.fixedReplayJump;
    }

    public final boolean j() {
        return this.schemaSupportOpenDrawer;
    }
}
