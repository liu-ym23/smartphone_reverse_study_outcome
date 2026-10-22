package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/config/m11;", "", "", "dialogSchema", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setDialogSchema", "(Ljava/lang/String;)V", "", "enable", "Z", "b", "()Z", "setEnable", "(Z)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m11 {

    @SerializedName("dialog_schema")
    private String dialogSchema;

    @SerializedName("enable")
    private boolean enable;

    public m11() {
        this.dialogSchema = "sslocal://webcast_lynxview?type=popup&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Fdouyin_lynx_community%2Ftemplate%2Fpages%2Fstable_audio_feedback%2Ftemplate.js&gravity=bottom&height_percent=75&width_percent=100&pull_down_close=1&pull_down_indicator_not_show=1";
        this.enable = true;
    }

    public final String a() {
        return this.dialogSchema;
    }

    public final boolean b() {
        return this.enable;
    }
}
