package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/config/i0;", "", "", "filterDisabledResolution", "I", "d", "()I", "setFilterDisabledResolution", "(I)V", "highFramerateThresh", "e", "setHighFramerateThresh", "enablePlayerResolutionDegradeObserver", "b", "setEnablePlayerResolutionDegradeObserver", "enableSave4KResolution", "c", "setEnableSave4KResolution", "", "disableHdrWhileUsingTextureView", "Z", "a", "()Z", "setDisableHdrWhileUsingTextureView", "(Z)V", "<init>", "()V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i0 {

    @SerializedName("disable_hdr_while_using_texture_view")
    private boolean disableHdrWhileUsingTextureView;

    @SerializedName("enable_player_resolution_degrade_observer")
    private int enablePlayerResolutionDegradeObserver;

    @SerializedName("enable_save_4k_resolution")
    private int enableSave4KResolution;

    @SerializedName("filter_disabled_resolution")
    private int filterDisabledResolution;

    @SerializedName("high_framerate_thresh")
    private int highFramerateThresh;

    public i0() {
        this.filterDisabledResolution = 1;
        this.highFramerateThresh = 48;
        this.enablePlayerResolutionDegradeObserver = 1;
        this.disableHdrWhileUsingTextureView = true;
    }

    public final boolean a() {
        return this.disableHdrWhileUsingTextureView;
    }

    public final int b() {
        return this.enablePlayerResolutionDegradeObserver;
    }

    public final int c() {
        return this.enableSave4KResolution;
    }

    public final int d() {
        return this.filterDisabledResolution;
    }

    public final int e() {
        return this.highFramerateThresh;
    }
}
