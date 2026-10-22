package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/config/n8;", "", "", "seiExamineMasDiff", "J", "getSeiExamineMasDiff", "()J", "seiExamineTimerDiff", "e", "seiSendTimerDiff", "getSeiSendTimerDiff", "adjustMinOffsetDiff", "c", "adjustMaxOffsetDiff", "a", "adjustMinTimeDiff", "d", "adjustMaxTimeDiff", "b", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n8 {

    @SerializedName("adjust_max_offset_diff")
    private final long adjustMaxOffsetDiff;

    @SerializedName("adjust_max_time_diff")
    private final long adjustMaxTimeDiff;

    @SerializedName("adjust_min_offset_diff")
    private final long adjustMinOffsetDiff;

    @SerializedName("adjust_min_time_diff")
    private final long adjustMinTimeDiff;

    @SerializedName("sei_examine_max_diff")
    private final long seiExamineMasDiff;

    @SerializedName("sei_examine_timer_diff")
    private final long seiExamineTimerDiff;

    @SerializedName("sei_send_timer_diff")
    private final long seiSendTimerDiff;

    public n8() {
        this.seiExamineMasDiff = 3000;
        this.seiExamineTimerDiff = 3000;
        this.seiSendTimerDiff = 1000;
        this.adjustMinOffsetDiff = 1000;
        this.adjustMaxOffsetDiff = 5000;
        this.adjustMinTimeDiff = 5000;
        this.adjustMaxTimeDiff = 20000;
    }

    public final long a() {
        return this.adjustMaxOffsetDiff;
    }

    public final long b() {
        return this.adjustMaxTimeDiff;
    }

    public final long c() {
        return this.adjustMinOffsetDiff;
    }

    public final long d() {
        return this.adjustMinTimeDiff;
    }

    public final long e() {
        return this.seiExamineTimerDiff;
    }
}
