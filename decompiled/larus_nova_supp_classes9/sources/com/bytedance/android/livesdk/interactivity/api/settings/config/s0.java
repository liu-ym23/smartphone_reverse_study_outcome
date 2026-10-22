package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class s0 {

    @SerializedName("monitor_max_log_items")
    public int maxLogSize;

    @SerializedName("monitor_adjust_layout")
    public boolean monitorAdjustLayout;

    @SerializedName("monitor_audio_comment")
    public boolean monitorAudioComment;

    @SerializedName("monitor_engine_error")
    public boolean monitorEngineError;

    @SerializedName("monitor_first_message")
    public boolean monitorFirstMessageDelay;

    @SerializedName("monitor_gift_tray_mask")
    public boolean monitorGiftTrayMask;

    @SerializedName("monitor_history_msg_error")
    public boolean monitorHistoryFail;

    @SerializedName("monitor_ps_context_empty")
    public boolean monitorPSContextEmpty;

    @SerializedName("monitor_ps_lift_up")
    public boolean monitorPublicScreenLiftUp;

    @SerializedName("monitor_visibility")
    public boolean monitorPublicScreenVis;

    @SerializedName("monitor_self_gift_event")
    public boolean monitorSelfGiftEvent;

    @SerializedName("monitor_top_msg_backend_fail")
    public boolean monitorTopMsgBackendFail;

    @SerializedName("monitor_first_message_threshold")
    public long reportThreshold;

    public s0() {
        this.monitorFirstMessageDelay = true;
        this.reportThreshold = 3000;
        this.monitorEngineError = true;
        this.monitorPSContextEmpty = true;
        this.monitorPublicScreenVis = true;
        this.monitorAudioComment = true;
        this.monitorAdjustLayout = true;
        this.maxLogSize = 20;
        this.monitorGiftTrayMask = true;
        this.monitorSelfGiftEvent = true;
        this.monitorTopMsgBackendFail = true;
        this.monitorHistoryFail = true;
        this.monitorPublicScreenLiftUp = true;
    }
}
