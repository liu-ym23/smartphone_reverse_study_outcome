package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00068\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/x2;", "", "", "isPostStart", "Z", "()Z", "", "startRtcTimer", "J", "getStartRtcTimer", "()J", "sendMsgTimer", "getSendMsgTimer", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x2 {

    @SerializedName("is_post_start")
    private final boolean isPostStart;

    @SerializedName("send_msg_timer")
    private final long sendMsgTimer;

    @SerializedName("start_rtc_timer")
    private final long startRtcTimer;

    public x2() {
        this.isPostStart = true;
        this.startRtcTimer = 15000;
        this.sendMsgTimer = 5000;
    }
}
