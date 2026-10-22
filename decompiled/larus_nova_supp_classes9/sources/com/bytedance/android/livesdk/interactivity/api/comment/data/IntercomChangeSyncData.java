package com.bytedance.android.livesdk.interactivity.api.comment.data;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class IntercomChangeSyncData {

    @SerializedName("close_reason")
    public long closeReason;

    @SerializedName("intercom_status")
    public long intercomStatus;

    public IntercomChangeSyncData() {
    }

    public boolean isInIntercom() {
        if (this.intercomStatus != 1) goto L5;
        return true;
    L5:
        return false;
    }
}
