package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\"\u0010 \u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000f¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/config/j61;", "", "", "enable", "Z", "c", "()Z", "setEnable", "(Z)V", "", "minWatchTime", "J", "e", "()J", "setMinWatchTime", "(J)V", "", "showMaxCountOneDay", "I", "g", "()I", "setShowMaxCountOneDay", "(I)V", "continuousRejectCountOneWeek", "b", "setContinuousRejectCountOneWeek", "continuousRejectCountNever", "a", "setContinuousRejectCountNever", "popupAlways", "f", "setPopupAlways", "feedApiTimeout", "d", "setFeedApiTimeout", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j61 {

    @SerializedName("continuous_reject_count_never")
    private int continuousRejectCountNever;

    @SerializedName("continuous_reject_count_one_week")
    private int continuousRejectCountOneWeek;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("feed_api_timeout")
    private long feedApiTimeout;

    @SerializedName("min_watch_time")
    private long minWatchTime;

    @SerializedName("popup_always")
    private boolean popupAlways;

    @SerializedName("show_max_time_one_day")
    private int showMaxCountOneDay;

    public j61() {
        this.minWatchTime = 60;
        this.showMaxCountOneDay = 3;
        this.continuousRejectCountOneWeek = 3;
        this.continuousRejectCountNever = 5;
        this.feedApiTimeout = 1000;
    }

    public final int a() {
        return this.continuousRejectCountNever;
    }

    public final int b() {
        return this.continuousRejectCountOneWeek;
    }

    public final boolean c() {
        return this.enable;
    }

    public final long d() {
        return this.feedApiTimeout;
    }

    public final long e() {
        return this.minWatchTime;
    }

    public final boolean f() {
        return this.popupAlways;
    }

    public final int g() {
        return this.showMaxCountOneDay;
    }
}
