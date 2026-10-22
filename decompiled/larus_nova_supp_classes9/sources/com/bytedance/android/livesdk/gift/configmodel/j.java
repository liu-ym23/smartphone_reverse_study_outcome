package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/j;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "needFrequent", "Z", "c", "()Z", "setNeedFrequent", "(Z)V", BuildConfig.FLAVOR, "dropCount", "I", "a", "()I", "setDropCount", "(I)V", "rate", "e", "setRate", BuildConfig.FLAVOR, "needFrequentLevelList", "Ljava/util/List;", "d", "()Ljava/util/List;", "setNeedFrequentLevelList", "(Ljava/util/List;)V", BuildConfig.FLAVOR, "giftIdList", "b", "setGiftIdList", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("drop_count")
    private int dropCount;

    @SerializedName("gift_id")
    private List<Long> giftIdList;

    @SerializedName("need_frequent")
    private boolean needFrequent;

    @SerializedName("need_frequent_level")
    private List<Integer> needFrequentLevelList;

    @SerializedName("rate")
    private int rate;

    public j() {
        this.dropCount = 5;
        this.rate = 10;
        this.needFrequentLevelList = CollectionsKt.listOf(0);
        this.giftIdList = CollectionsKt.emptyList();
    }

    public final int a() {
        return this.dropCount;
    }

    public final List<Long> b() {
        return this.giftIdList;
    }

    public final boolean c() {
        return this.needFrequent;
    }

    public final List<Integer> d() {
        return this.needFrequentLevelList;
    }

    public final int e() {
        return this.rate;
    }
}
