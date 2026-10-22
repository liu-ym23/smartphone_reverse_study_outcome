package com.bytedance.android.livesdk.interactivity.api.entity;

import com.bytedance.android.live.base.model.message.a5;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class RiskAdviseSyncData {
    public static final long PRIORITY = 10000;

    @SerializedName("advise_text")
    public a5 adviseText;

    @SerializedName("create_time")
    public long createTime;

    public RiskAdviseSyncData() {
    }
}
