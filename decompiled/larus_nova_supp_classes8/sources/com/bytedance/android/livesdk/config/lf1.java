package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000f¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/config/lf1;", "", "", "cellularEnable", "Z", "c", "()Z", "setCellularEnable", "(Z)V", "", "cellularMaxCount", "I", "d", "()I", "setCellularMaxCount", "(I)V", "cellularDialogDurationTime", "a", "setCellularDialogDurationTime", "", "cellularDialogShowInterval", "J", "b", "()J", "setCellularDialogShowInterval", "(J)V", "txQualityLevel", "f", "setTxQualityLevel", "txQualityCount", "e", "setTxQualityCount", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class lf1 {

    @SerializedName("cellular_dialog_duration_time")
    private int cellularDialogDurationTime;

    @SerializedName("cellular_dialog_show_interval")
    private long cellularDialogShowInterval;

    @SerializedName("cellular_enable")
    private boolean cellularEnable;

    @SerializedName("cellular_dialog_show_max_count")
    private int cellularMaxCount;

    @SerializedName("rtt_continue_count")
    private int txQualityCount;

    @SerializedName("rtt_threshold")
    private int txQualityLevel;

    public lf1() {
        this.cellularMaxCount = 4;
        this.cellularDialogDurationTime = 5;
        this.cellularDialogShowInterval = 86400000;
        this.txQualityLevel = 4;
        this.txQualityCount = 5;
    }

    public final int a() {
        return this.cellularDialogDurationTime;
    }

    public final long b() {
        return this.cellularDialogShowInterval;
    }

    public final boolean c() {
        return this.cellularEnable;
    }

    public final int d() {
        return this.cellularMaxCount;
    }

    public final int e() {
        return this.txQualityCount;
    }

    public final int f() {
        return this.txQualityLevel;
    }
}
