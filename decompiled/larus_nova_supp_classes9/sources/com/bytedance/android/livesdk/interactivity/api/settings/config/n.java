package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class n {

    @SerializedName("monitor_ai_param")
    public boolean monitorAiParam;

    @SerializedName("monitor_cost_click")
    public boolean monitorCostClick;

    @SerializedName("monitor_cost_show")
    public boolean monitorCostShow;

    @SerializedName("monitor_danmaku_click")
    public boolean monitorDanmakuClick;

    @SerializedName("monitor_jsb_event")
    public boolean monitorJsbEvent;

    @SerializedName("monitor_keyboard")
    public boolean monitorKeyboard;

    @SerializedName("monitor_send_failed")
    public boolean monitorSendFailed;

    @SerializedName("monitor_show")
    public boolean monitorShow;

    @SerializedName("monitor_try_show")
    public boolean monitorTryShow;

    public n() {
        this.monitorJsbEvent = true;
        this.monitorTryShow = true;
        this.monitorShow = true;
        this.monitorCostShow = true;
        this.monitorCostClick = true;
        this.monitorDanmakuClick = true;
        this.monitorKeyboard = true;
        this.monitorSendFailed = true;
        this.monitorAiParam = true;
    }
}
