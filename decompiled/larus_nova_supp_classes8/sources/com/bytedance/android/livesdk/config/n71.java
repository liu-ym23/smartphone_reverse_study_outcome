package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u00100R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\"\u0010 \u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\"\u0010#\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u000e\u001a\u0004\b$\u0010\u0010\"\u0004\b%\u0010\u0012R\"\u0010&\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u000e\u001a\u0004\b'\u0010\u0010\"\u0004\b(\u0010\u0012R\"\u0010)\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u000e\u001a\u0004\b*\u0010\u0010\"\u0004\b+\u0010\u0012R\"\u0010,\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u000e\u001a\u0004\b-\u0010\u0010\"\u0004\b.\u0010\u0012¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdk/config/n71;", "", "", "enableRealTimeSignal", "Z", "f", "()Z", "setEnableRealTimeSignal", "(Z)V", "enableCommentReport", "d", "setEnableCommentReport", "", "commentThreshold", "I", "b", "()I", "setCommentThreshold", "(I)V", "enableViewLiveReport", "g", "setEnableViewLiveReport", "", "watchAggregationTime", "J", "j", "()J", "setWatchAggregationTime", "(J)V", "enableDislikeReport", "e", "setEnableDislikeReport", "expiredTime", "h", "setExpiredTime", "reportCount", "i", "setReportCount", "watchLiveMaxSaveItem", "k", "setWatchLiveMaxSaveItem", "commentMaxSaveItem", "a", "setCommentMaxSaveItem", "dislikeMaxSaveItem", "c", "setDislikeMaxSaveItem", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n71 {

    @SerializedName("live_saas_real_time_signal_comment_max_save_item")
    private int commentMaxSaveItem;

    @SerializedName("live_saas_real_time_signal_comment_threshold")
    private int commentThreshold;

    @SerializedName("live_saas_real_time_signal_dislike_max_save_item")
    private int dislikeMaxSaveItem;

    @SerializedName("live_saas_real_time_signal_comment_report_enable")
    private boolean enableCommentReport;

    @SerializedName("live_saas_real_time_signal_dislike_report_enable")
    private boolean enableDislikeReport;

    @SerializedName("live_saas_real_time_signal_enable")
    private boolean enableRealTimeSignal;

    @SerializedName("live_saas_real_time_signal_view_live_report_enable")
    private boolean enableViewLiveReport;

    @SerializedName("live_saas_real_time_signal_expired_time")
    private long expiredTime;

    @SerializedName("live_saas_real_time_signal_report_count")
    private int reportCount;

    @SerializedName("live_saas_real_time_signal_watch_aggregation_time")
    private long watchAggregationTime;

    @SerializedName("live_saas_real_time_signal_watch_live_max_save_item")
    private int watchLiveMaxSaveItem;

    public n71() {
        this.commentThreshold = 2;
        this.watchAggregationTime = 60000;
        this.expiredTime = 604800000;
        this.reportCount = 10;
        this.watchLiveMaxSaveItem = 50;
        this.commentMaxSaveItem = 20;
        this.dislikeMaxSaveItem = 20;
    }

    public final int a() {
        return this.commentMaxSaveItem;
    }

    public final int b() {
        return this.commentThreshold;
    }

    public final int c() {
        return this.dislikeMaxSaveItem;
    }

    public final boolean d() {
        return this.enableCommentReport;
    }

    public final boolean e() {
        return this.enableDislikeReport;
    }

    public final boolean f() {
        return this.enableRealTimeSignal;
    }

    public final boolean g() {
        return this.enableViewLiveReport;
    }

    public final long h() {
        return this.expiredTime;
    }

    public final int i() {
        return this.reportCount;
    }

    public final long j() {
        return this.watchAggregationTime;
    }

    public final int k() {
        return this.watchLiveMaxSaveItem;
    }
}
