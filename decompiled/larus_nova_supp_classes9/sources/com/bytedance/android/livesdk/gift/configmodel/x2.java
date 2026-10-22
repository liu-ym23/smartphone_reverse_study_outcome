package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/x2;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "vsLiveSupportGift", "Z", "c", "()Z", "setVsLiveSupportGift", "(Z)V", "vsFirstShowSupportGift", "b", "setVsFirstShowSupportGift", "vsEpisodeSupportGift", "a", "setVsEpisodeSupportGift", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x2 {

    @SerializedName("vs_episode_support_gift")
    private boolean vsEpisodeSupportGift;

    @SerializedName("vs_first_show_support_gift")
    private boolean vsFirstShowSupportGift;

    @SerializedName("vs_live_support_gift")
    private boolean vsLiveSupportGift;

    public x2() {
        this.vsLiveSupportGift = true;
        this.vsFirstShowSupportGift = true;
        this.vsEpisodeSupportGift = true;
    }

    public final boolean a() {
        return this.vsEpisodeSupportGift;
    }

    public final boolean b() {
        return this.vsFirstShowSupportGift;
    }

    public final boolean c() {
        return this.vsLiveSupportGift;
    }
}
