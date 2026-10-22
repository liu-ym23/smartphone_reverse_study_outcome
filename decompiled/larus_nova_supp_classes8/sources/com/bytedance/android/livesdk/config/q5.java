package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class q5 {

    @SerializedName("fold_screen_opt_enable")
    public boolean enableFoldScreenKeyboardOpt;

    @SerializedName("expand_status_threshold")
    public float expandStatusThreshold;

    @SerializedName("fold_status_threshold")
    public float foldStatusThreshold;

    public q5() {
        this.enableFoldScreenKeyboardOpt = false;
        this.foldStatusThreshold = 80.0f;
        this.expandStatusThreshold = 150.0f;
    }
}
