package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/x1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enable", "Z", "b", "()Z", BuildConfig.FLAVOR, "fetchAssetDuration", "J", "c", "()J", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "assetIds", "Ljava/util/List;", "a", "()Ljava/util/List;", "waitExecuteDuration", "d", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x1 {

    @SerializedName("asset_ids")
    private final List<String> assetIds;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("fetch_asset_duration")
    private final long fetchAssetDuration;

    @SerializedName("wait_execute_duration")
    private final long waitExecuteDuration;

    public x1() {
        this.enable = true;
        this.fetchAssetDuration = 10;
        this.assetIds = new ArrayList();
        this.waitExecuteDuration = 21600;
    }

    public final List<String> a() {
        return this.assetIds;
    }

    public final boolean b() {
        return this.enable;
    }

    public final long c() {
        return this.fetchAssetDuration;
    }

    public final long d() {
        return this.waitExecuteDuration;
    }
}
