package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/config/gk1;", "", "", "dumpXplayVideoFrame", "Z", "a", "()Z", "setDumpXplayVideoFrame", "(Z)V", "showXplayVideoFrame", "h", "setShowXplayVideoFrame", "showCustomMixerVideoFrame", "g", "setShowCustomMixerVideoFrame", "enableCustomMixer", "d", "setEnableCustomMixer", "enableClipPath", "c", "setEnableClipPath", "enableSwitchMixType", "f", "setEnableSwitchMixType", "enableHideAnchorLayer", "e", "setEnableHideAnchorLayer", "enableAnchorPreviewOptimize", "b", "setEnableAnchorPreviewOptimize", "enableDebugLog", "getEnableDebugLog", "setEnableDebugLog", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class gk1 {

    @SerializedName("dumpXplayVideoFrame")
    private boolean dumpXplayVideoFrame;

    @SerializedName("enableAnchorPreviewOptimize")
    private boolean enableAnchorPreviewOptimize;

    @SerializedName("enableClipPath")
    private boolean enableClipPath;

    @SerializedName("enableCustomMixer")
    private boolean enableCustomMixer;

    @SerializedName("enableDebugLog")
    private boolean enableDebugLog;

    @SerializedName("enableHideAnchorLayer")
    private boolean enableHideAnchorLayer;

    @SerializedName("enableSwitchMixType")
    private boolean enableSwitchMixType;

    @SerializedName("showCustomMixerVideoFrame")
    private boolean showCustomMixerVideoFrame;

    @SerializedName("showXplayVideoFrame")
    private boolean showXplayVideoFrame;

    public gk1() {
        this.enableCustomMixer = true;
        this.enableClipPath = true;
        this.enableSwitchMixType = true;
        this.enableHideAnchorLayer = true;
        this.enableAnchorPreviewOptimize = true;
    }

    public final boolean a() {
        return this.dumpXplayVideoFrame;
    }

    public final boolean b() {
        return this.enableAnchorPreviewOptimize;
    }

    public final boolean c() {
        return this.enableClipPath;
    }

    public final boolean d() {
        return this.enableCustomMixer;
    }

    public final boolean e() {
        return this.enableHideAnchorLayer;
    }

    public final boolean f() {
        return this.enableSwitchMixType;
    }

    public final boolean g() {
        return this.showCustomMixerVideoFrame;
    }

    public final boolean h() {
        return this.showXplayVideoFrame;
    }
}
