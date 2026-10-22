package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/i;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "maxDeleteCount", "I", "b", "()I", "cleanGapInterval", "getCleanGapInterval", "cleanStartTimeAfterExitRoom", "getCleanStartTimeAfterExitRoom", "assetKeepLiveDuration", "a", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("asset_keep_live_duration")
    private final int assetKeepLiveDuration;

    @SerializedName("clean_gap_interval")
    private final int cleanGapInterval;

    @SerializedName("clean_start_time_after_exit_room")
    private final int cleanStartTimeAfterExitRoom;

    @SerializedName("max_delete_count")
    private final int maxDeleteCount;

    public i() {
        this.maxDeleteCount = 10;
        this.cleanGapInterval = 86400;
        this.cleanStartTimeAfterExitRoom = 5;
        this.assetKeepLiveDuration = 604800;
    }

    public final int a() {
        return this.assetKeepLiveDuration;
    }

    public final int b() {
        return this.maxDeleteCount;
    }
}
