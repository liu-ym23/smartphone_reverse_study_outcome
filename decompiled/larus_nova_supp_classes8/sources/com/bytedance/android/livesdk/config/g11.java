package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/config/g11;", "", "", "online_friend_prompt", "Ljava/lang/String;", "getOnline_friend_prompt", "()Ljava/lang/String;", "setOnline_friend_prompt", "(Ljava/lang/String;)V", "living_friend_prompt", "getLiving_friend_prompt", "setLiving_friend_prompt", "online_fans_prompt", "getOnline_fans_prompt", "setOnline_fans_prompt", "", "max_show_count", "I", "getMax_show_count", "()I", "setMax_show_count", "(I)V", "", "max_show_time", "J", "getMax_show_time", "()J", "setMax_show_time", "(J)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g11 {

    @SerializedName("living_friend_prompt")
    private String living_friend_prompt;

    @SerializedName("max_show_count")
    private int max_show_count;

    @SerializedName("max_show_time")
    private long max_show_time;

    @SerializedName("online_fans_prompt")
    private String online_fans_prompt;

    @SerializedName("online_friend_prompt")
    private String online_friend_prompt;

    public g11() {
        this.online_friend_prompt = "位好友正在线";
        this.living_friend_prompt = "位好友正在直播";
        this.online_fans_prompt = "位粉丝正在线";
        this.max_show_time = 3000;
    }
}
