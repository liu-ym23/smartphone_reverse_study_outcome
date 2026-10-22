package com.bytedance.android.live.profit.taskcenter.preload;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/profit/taskcenter/preload/b;", "", "", "type", "I", "getType", "()I", "", "delay", "J", "a", "()J", "interval", "b", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("delay")
    private final long delay;

    @SerializedName("pollingTime")
    private final long interval;

    @SerializedName("type")
    private final int type;

    public static final class a {
    }

    static {
    }

    public b() {
        this.delay = 3000;
        this.interval = 180000;
    }

    public final long a() {
        return this.delay;
    }

    public final long b() {
        return this.interval;
    }

    public final int getType() {
        return this.type;
    }
}
