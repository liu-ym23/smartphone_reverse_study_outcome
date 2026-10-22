package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/config/a81;", "", "", "enable", "Z", "a", "()Z", "enableFullMonitor", "d", "enableScrollFinishMonitor", "e", "enableDragMonitor", "b", "enableFlingMonitor", "c", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a81 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_drag_monitor")
    private final boolean enableDragMonitor;

    @SerializedName("enable_fling_monitor")
    private final boolean enableFlingMonitor;

    @SerializedName("enable_full_monitor")
    private final boolean enableFullMonitor;

    @SerializedName("enable_scroll_finish_monitor")
    private final boolean enableScrollFinishMonitor;

    public a81() {
    }

    public final boolean a() {
        return this.enable;
    }

    public final boolean b() {
        return this.enableDragMonitor;
    }

    public final boolean c() {
        return this.enableFlingMonitor;
    }

    public final boolean d() {
        return this.enableFullMonitor;
    }

    public final boolean e() {
        return this.enableScrollFinishMonitor;
    }
}
