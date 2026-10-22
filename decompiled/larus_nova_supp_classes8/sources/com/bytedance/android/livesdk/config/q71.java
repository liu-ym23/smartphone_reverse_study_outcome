package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/config/q71;", "", "", "enable", "Z", "a", "()Z", "setEnable", "(Z)V", "", "urlPath", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setUrlPath", "(Ljava/lang/String;)V", "", "entranceStyle", "I", "b", "()I", "setEntranceStyle", "(I)V", "group", "c", "setGroup", "<init>", "()V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q71 {

    @SerializedName("open")
    private boolean enable;

    @SerializedName("entrance_style")
    private int entranceStyle;

    @SerializedName("unique_entrance_group")
    private int group;

    @SerializedName("url_path")
    private String urlPath;

    public static final class a {
    }

    static {
    }

    public q71() {
        this.urlPath = "/falcon/douyin_falcon/dou_plus/renqibao?dp_can_gesture_close=1&dp_max_loading_interval=10&hide_status_bar=0&hide_nav_bar=1&status_bar_style_type=0&status_bar_color=00000000&loading_bgcolor=00000000&container_bgcolor=00000000&should_full_screen=true&hide_source=true";
    }

    public final boolean a() {
        return this.enable;
    }

    public final int b() {
        return this.entranceStyle;
    }

    public final int c() {
        return this.group;
    }

    public final String d() {
        return this.urlPath;
    }
}
