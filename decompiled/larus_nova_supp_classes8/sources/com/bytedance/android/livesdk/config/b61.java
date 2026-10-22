package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/config/b61;", "", "", "enable", "Z", "a", "()Z", "", "previewPollingInternal", "J", "getPreviewPollingInternal", "()J", "subDevicePingInternal", "getSubDevicePingInternal", "", "helpUrl", "Ljava/lang/String;", "getHelpUrl", "()Ljava/lang/String;", "subBroadcastEnable", "getSubBroadcastEnable", "interactToolsEnable", "b", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b61 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("help_url")
    private final String helpUrl;

    @SerializedName("interact_tools_enable")
    private final boolean interactToolsEnable;

    @SerializedName("preview_polling_internal")
    private final long previewPollingInternal;

    @SerializedName("sub_broadcast_enable")
    private final boolean subBroadcastEnable;

    @SerializedName("sub_device_ping_internal")
    private final long subDevicePingInternal;

    public b61() {
        this(0);
    }

    public final boolean a() {
        return this.enable;
    }

    public final boolean b() {
        return this.interactToolsEnable;
    }

    public b61(int r3) {
        this.enable = false;
        this.previewPollingInternal = 5000;
        this.subDevicePingInternal = 5000;
        this.helpUrl = null;
        this.subBroadcastEnable = true;
        this.interactToolsEnable = false;
    }
}
