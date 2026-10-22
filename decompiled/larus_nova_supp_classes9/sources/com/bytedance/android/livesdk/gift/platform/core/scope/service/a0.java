package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/scope/service/a0;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", BuildConfig.FLAVOR, "effectID", "J", "a", "()J", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
final class a0 {

    @SerializedName("effect_id")
    private final long effectID;

    @SerializedName("type")
    private final String type;

    public a0() {
        this.type = BuildConfig.FLAVOR;
    }

    public final long a() {
        return this.effectID;
    }

    public final String getType() {
        return this.type;
    }
}
