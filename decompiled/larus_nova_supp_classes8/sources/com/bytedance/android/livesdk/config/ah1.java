package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class ah1 {

    @SerializedName("pk_anchor_switch")
    public boolean PKAnchorSwitch;

    @SerializedName("allow_send_gift_to_other_anchors")
    public boolean allowSendGiftToOtherAnchors;

    @SerializedName("multi_anchor_switch")
    public boolean multiAnchorSwitch;

    public ah1() {
        this.allowSendGiftToOtherAnchors = false;
        this.PKAnchorSwitch = true;
        this.multiAnchorSwitch = true;
    }
}
