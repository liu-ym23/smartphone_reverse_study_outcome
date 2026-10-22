package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/config/s4;", "", "", "frequencyControlTimeWindow", "I", "b", "()I", "setFrequencyControlTimeWindow", "(I)V", "frequencyControlMaxTimes", "a", "", "toastText", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s4 {
    public static final s4 a = null;

    @SerializedName("fre_ctrl_max_times")
    private final int frequencyControlMaxTimes;

    @SerializedName("fre_ctrl_time_window")
    private int frequencyControlTimeWindow;

    @SerializedName("temp_state_area_toast_text")
    private final String toastText;

    public static final class a {
    }

    static {
        a = new s4();
    }

    public s4() {
        this.frequencyControlTimeWindow = 180;
        this.frequencyControlMaxTimes = 5;
        this.toastText = "主播还未开启新一轮互动";
    }

    public final int a() {
        return this.frequencyControlMaxTimes;
    }

    public final int b() {
        return this.frequencyControlTimeWindow;
    }

    public final String c() {
        return this.toastText;
    }
}
