package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/config/a91;", "", "", "enable", "Z", "getEnable", "()Z", "", "uplinkStrategy", "I", "getUplinkStrategy", "()I", "setUplinkStrategy", "(I)V", "", "wsUplinkWaitTimeout", "J", "getWsUplinkWaitTimeout", "()J", "setWsUplinkWaitTimeout", "(J)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a91 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("uplink_strategy")
    private int uplinkStrategy;

    @SerializedName("ws_uplink_wait_timeout")
    private long wsUplinkWaitTimeout;

    public a91() {
        this.enable = true;
        this.uplinkStrategy = 1;
        this.wsUplinkWaitTimeout = 15000;
    }
}
