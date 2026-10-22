package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.feed.services.AppointmentService;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class j11 {

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("interval")
    public long interval;

    public j11() {
        this.enable = false;
        this.interval = AppointmentService.SOURCE_UNDEFINED;
    }
}
