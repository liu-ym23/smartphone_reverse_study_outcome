package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/k1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "mEnable", "Z", "a", "()Z", "setMEnable", "(Z)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "mLevelMap", "[Ljava/lang/Integer;", "b", "()[Ljava/lang/Integer;", "setMLevelMap", "([Ljava/lang/Integer;)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k1 {

    @SerializedName("live_gift_queue_enable")
    private boolean mEnable;

    @SerializedName("live_gift_queue_level_map")
    private Integer[] mLevelMap;

    public k1() {
        this.mLevelMap = new Integer[]{0, 0, 0, 1, 2};
    }

    public final boolean a() {
        return this.mEnable;
    }

    public final Integer[] b() {
        return this.mLevelMap;
    }
}
