package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/config/e51;", "", "", "diggCountLayoutLogDelay", "Z", "a", "()Z", "setDiggCountLayoutLogDelay", "(Z)V", "packagTimeOpt", "g", "setPackagTimeOpt", "logAnchorAvatarDelay", "e", "setLogAnchorAvatarDelay", "logLandscapeInterationDurationDelay", "f", "setLogLandscapeInterationDurationDelay", "enableEntraceviewCache", "c", "setEnableEntraceviewCache", "enableInteractionLayeredLoading", "d", "setEnableInteractionLayeredLoading", "enableAnnotationVisibilityControl", "b", "setEnableAnnotationVisibilityControl", "rotateEntranceOpt", "h", "setRotateEntranceOpt", "<init>", "()V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e51 {

    @SerializedName("enable_digg_count_layout_log_delay")
    private boolean diggCountLayoutLogDelay;

    @SerializedName("enable_landscape_annotation_clear_screen")
    private boolean enableAnnotationVisibilityControl;

    @SerializedName("enable_entraceview_cache")
    private boolean enableEntraceviewCache;

    @SerializedName("enable_interaction_layered_loading")
    private boolean enableInteractionLayeredLoading;

    @SerializedName("enable_log_anchor_avatar_delay")
    private boolean logAnchorAvatarDelay;

    @SerializedName("enable_log_landscape_interation_duration_delay")
    private boolean logLandscapeInterationDurationDelay;

    @SerializedName("packag_time_opt")
    private boolean packagTimeOpt;

    @SerializedName("rotate_entrance_opt")
    private boolean rotateEntranceOpt;

    public e51() {
    }

    public final boolean a() {
        return this.diggCountLayoutLogDelay;
    }

    public final boolean b() {
        return this.enableAnnotationVisibilityControl;
    }

    public final boolean c() {
        return this.enableEntraceviewCache;
    }

    public final boolean d() {
        return this.enableInteractionLayeredLoading;
    }

    public final boolean e() {
        return this.logAnchorAvatarDelay;
    }

    public final boolean f() {
        return this.logLandscapeInterationDurationDelay;
    }

    public final boolean g() {
        return this.packagTimeOpt;
    }

    public final boolean h() {
        return this.rotateEntranceOpt;
    }
}
