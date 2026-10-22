package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/config/k41;", "", "", "globalEnable", "Z", "c", "()Z", "", "customCount", "I", "a", "()I", "hideBucketCount", "d", "debugToast", "b", "useNewAdjust", "e", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k41 {
    public static final /* synthetic */ int a = 0;

    @SerializedName("custom_count")
    private final int customCount;

    @SerializedName("debug_toast_enable")
    private final boolean debugToast;

    @SerializedName("global_enable")
    private final boolean globalEnable;

    @SerializedName("hide_bucket_count")
    private final int hideBucketCount;

    @SerializedName("use_new_adjust")
    private final boolean useNewAdjust;

    public static final class a {
    }

    static {
    }

    public k41() {
        this.customCount = -1;
        this.hideBucketCount = -1;
        this.debugToast = true;
    }

    public final int a() {
        return this.customCount;
    }

    public final boolean b() {
        return this.debugToast;
    }

    public final boolean c() {
        return this.globalEnable;
    }

    public final int d() {
        return this.hideBucketCount;
    }

    public final boolean e() {
        return this.useNewAdjust;
    }
}
