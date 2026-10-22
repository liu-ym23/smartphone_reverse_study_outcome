package com.bytedance.android.live.recharge.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/recharge/model/e;", "", "", "enable", "Z", "d", "()Z", "setEnable", "(Z)V", "", "dailyMaxTimes", "I", "a", "()I", "setDailyMaxTimes", "(I)V", "defaultShowTimes", "c", "setDefaultShowTimes", "defaultGapTimes", "b", "setDefaultGapTimes", "", "noticeText", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setNoticeText", "(Ljava/lang/String;)V", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class e {

    @SerializedName("max_show_times")
    private int dailyMaxTimes;

    @SerializedName("default_gap_times")
    private int defaultGapTimes;

    @SerializedName("default_show_times")
    private int defaultShowTimes;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("notice_text")
    private String noticeText;

    public e() {
        this.dailyMaxTimes = 6;
        this.defaultShowTimes = 2;
        this.defaultGapTimes = 3;
        this.noticeText = "平台倡导量入为出，理性消费";
    }

    public final int a() {
        return this.dailyMaxTimes;
    }

    public final int b() {
        return this.defaultGapTimes;
    }

    public final int c() {
        return this.defaultShowTimes;
    }

    public final boolean d() {
        return this.enable;
    }

    public final String e() {
        return this.noticeText;
    }
}
