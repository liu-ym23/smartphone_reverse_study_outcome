package com.bytedance.android.live.ai.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0005J\u0006\u0010*\u001a\u00020\u0011J\u0006\u0010+\u001a\u00020\u0011R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001e\u0010\u0019\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001e\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001e\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001e\u0010\"\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u001e\u0010%\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015¨\u0006,"}, d2 = {"Lcom/bytedance/android/live/ai/config/LiveDetectionConfig;", "", "()V", "customEventIgnoreList", "", "", "getCustomEventIgnoreList", "()Ljava/util/List;", "setCustomEventIgnoreList", "(Ljava/util/List;)V", "detectInterval", "", "getDetectInterval", "()I", "setDetectInterval", "(I)V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "enableAnchorDetect", "getEnableAnchorDetect", "setEnableAnchorDetect", "enableCustomEvent", "getEnableCustomEvent", "setEnableCustomEvent", "enableSync", "getEnableSync", "setEnableSync", "reportLevel", "getReportLevel", "setReportLevel", "requiredAudienceCount", "getRequiredAudienceCount", "setRequiredAudienceCount", "showToastEnable", "getShowToastEnable", "setShowToastEnable", "ignoreCustomEvent", "eventName", "isAnchorDetectEnable", "isCustomEventEnable", "liveai-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDetectionConfig {

    @SerializedName("custom_event_ignore_list")
    private List<String> customEventIgnoreList;

    @SerializedName("detect_interval")
    private int detectInterval;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_anchor_detect")
    private boolean enableAnchorDetect;

    @SerializedName("enable_custom_event")
    private boolean enableCustomEvent;

    @SerializedName("enable_sync")
    private boolean enableSync;

    @SerializedName("report_level")
    private int reportLevel;

    @SerializedName("required_audience_count")
    private int requiredAudienceCount;

    @SerializedName("show_toast_enable")
    private boolean showToastEnable;

    public final boolean isAnchorDetectEnable() {
        if (this.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.enableAnchorDetect == false) goto L7;
        return true;
    }

    public final boolean isCustomEventEnable() {
        if (this.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.enableCustomEvent == false) goto L7;
        return true;
    }

    public LiveDetectionConfig() {
        this.customEventIgnoreList = CollectionsKt.emptyList();
        this.detectInterval = 30;
        this.reportLevel = 3;
        this.requiredAudienceCount = 1000;
        this.enableSync = true;
    }

    public final List<String> getCustomEventIgnoreList() {
        return this.customEventIgnoreList;
    }

    public final int getDetectInterval() {
        return this.detectInterval;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getEnableAnchorDetect() {
        return this.enableAnchorDetect;
    }

    public final boolean getEnableCustomEvent() {
        return this.enableCustomEvent;
    }

    public final boolean getEnableSync() {
        return this.enableSync;
    }

    public final int getReportLevel() {
        return this.reportLevel;
    }

    public final int getRequiredAudienceCount() {
        return this.requiredAudienceCount;
    }

    public final boolean getShowToastEnable() {
        return this.showToastEnable;
    }

    public final boolean ignoreCustomEvent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        if (isCustomEventEnable() == true) goto L5;
    L8:
        return true;
    L5:
        if (this.customEventIgnoreList.contains(r2) == true) goto L8;
        return false;
    }

    public final void setCustomEventIgnoreList(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.customEventIgnoreList = r2;
    }

    public final void setDetectInterval(int r1) {
        this.detectInterval = r1;
    }

    public final void setEnable(boolean r1) {
        this.enable = r1;
    }

    public final void setEnableAnchorDetect(boolean r1) {
        this.enableAnchorDetect = r1;
    }

    public final void setEnableCustomEvent(boolean r1) {
        this.enableCustomEvent = r1;
    }

    public final void setEnableSync(boolean r1) {
        this.enableSync = r1;
    }

    public final void setReportLevel(int r1) {
        this.reportLevel = r1;
    }

    public final void setRequiredAudienceCount(int r1) {
        this.requiredAudienceCount = r1;
    }

    public final void setShowToastEnable(boolean r1) {
        this.showToastEnable = r1;
    }
}
