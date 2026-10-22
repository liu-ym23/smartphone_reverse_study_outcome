package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/x41;", "", "", "enableLocalLyrics", "I", "getEnableLocalLyrics", "()I", "enablePing", "getEnablePing", "pingInterval", "getPingInterval", "ksongLyricsOpt", "getKsongLyricsOpt", "disableLyricsSei", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class x41 {

    @SerializedName("disable_lyric_sei")
    private final int disableLyricsSei;

    @SerializedName("enable_local_lyric")
    private final int enableLocalLyrics;

    @SerializedName("enable_ping")
    private final int enablePing;

    @SerializedName("ksong_lyric_opt")
    private final int ksongLyricsOpt;

    @SerializedName("ping_interval")
    private final int pingInterval;

    public x41() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof x41) == false) goto L16;
        x41 r4 = (x41) r3;
        if (this.enableLocalLyrics == r4.enableLocalLyrics) goto L8;
        return false;
    L8:
        if (this.enablePing == r4.enablePing) goto L10;
        return false;
    L10:
        if (this.pingInterval == r4.pingInterval) goto L12;
        return false;
    L12:
        if (this.ksongLyricsOpt == r4.ksongLyricsOpt) goto L14;
        return false;
    L14:
        if (this.disableLyricsSei == r4.disableLyricsSei) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        return (((((((this.enableLocalLyrics * 31) + this.enablePing) * 31) + this.pingInterval) * 31) + this.ksongLyricsOpt) * 31) + this.disableLyricsSei;
    }

    public final String toString() {
        return "LiveKtvLyricsSetting(enableLocalLyrics=" + this.enableLocalLyrics + ", enablePing=" + this.enablePing + ", pingInterval=" + this.pingInterval + ", ksongLyricsOpt=" + this.ksongLyricsOpt + ", disableLyricsSei=" + this.disableLyricsSei + ")";
    }

    public final int a() {
        return this.disableLyricsSei;
    }

    public x41(int r2) {
        this.enableLocalLyrics = 1;
        this.enablePing = 1;
        this.pingInterval = 3;
        this.ksongLyricsOpt = 1;
        this.disableLyricsSei = 0;
    }
}
