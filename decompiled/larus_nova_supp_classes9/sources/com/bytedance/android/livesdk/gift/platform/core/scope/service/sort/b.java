package com.bytedance.android.livesdk.gift.platform.core.scope.service.sort;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00038\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/scope/service/sort/b;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "giftIds", "Ljava/util/List;", "c", "()Ljava/util/List;", "startTime", "J", "e", "()J", "endTime", "a", BuildConfig.FLAVOR, "scene", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "extra", "b", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
final class b {

    @SerializedName("end_time")
    private final long endTime;

    @SerializedName("extra")
    private final String extra;

    @SerializedName("gift_ids")
    private final List<Long> giftIds;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("start_time")
    private final long startTime;

    public b() {
        this.scene = BuildConfig.FLAVOR;
        this.extra = BuildConfig.FLAVOR;
    }

    public final long a() {
        return this.endTime;
    }

    public final String b() {
        return this.extra;
    }

    public final List<Long> c() {
        return this.giftIds;
    }

    public final String d() {
        return this.scene;
    }

    public final long e() {
        return this.startTime;
    }
}
