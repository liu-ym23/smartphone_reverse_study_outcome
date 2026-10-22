package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/m0;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "countCheckEnable", "Z", "a", "()Z", BuildConfig.FLAVOR, "minCount", "I", "b", "()I", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m0 {

    @SerializedName("count_check_enable")
    private final boolean countCheckEnable;

    @SerializedName("min_count")
    private final int minCount;

    public m0() {
        this.countCheckEnable = true;
    }

    public final boolean a() {
        return this.countCheckEnable;
    }

    public final int b() {
        return this.minCount;
    }
}
