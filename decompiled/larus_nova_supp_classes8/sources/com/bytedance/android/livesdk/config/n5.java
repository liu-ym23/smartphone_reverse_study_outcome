package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class n5 {

    @SerializedName("ktv_disable_toast")
    public String disableToast;

    @SerializedName("enable_ktv_publish")
    public boolean enableKtvPublish;

    @SerializedName("enable_ktv_save_to_draft")
    public boolean enableKtvSaveToDraft;

    public n5() {
        this.enableKtvPublish = true;
        this.enableKtvSaveToDraft = true;
        this.disableToast = "";
    }
}
