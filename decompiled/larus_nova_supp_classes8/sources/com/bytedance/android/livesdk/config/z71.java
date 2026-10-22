package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/config/z71;", "", "", "scrollGcEnable", "Z", "a", "()Z", "", "scrollGcStrategy", "I", "b", "()I", "scrollGcTime", "c", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z71 {

    @SerializedName("scroll_gc_enable")
    private final boolean scrollGcEnable;

    @SerializedName("scroll_gc_strategy")
    private final int scrollGcStrategy;

    @SerializedName("scroll_gc_time")
    private final int scrollGcTime;

    public z71() {
        this.scrollGcStrategy = 1;
        this.scrollGcTime = -1;
    }

    public final boolean a() {
        return this.scrollGcEnable;
    }

    public final int b() {
        return this.scrollGcStrategy;
    }

    public final int c() {
        return this.scrollGcTime;
    }
}
