package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\"\u0010\u001d\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\"\u0010 \u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\"\u0010#\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/p;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enableStatus", "I", "d", "()I", "setEnableStatus", "(I)V", BuildConfig.FLAVOR, "giftDelay", "J", "e", "()J", "setGiftDelay", "(J)V", "giftShortDelay", "f", "setGiftShortDelay", BuildConfig.FLAVOR, "enableImmediate", "Z", "c", "()Z", "setEnableImmediate", "(Z)V", "assetDelay", "b", "setAssetDelay", "launchDelayGiftList", "h", "setLaunchDelayGiftList", "launchDelayAssetList", "g", "setLaunchDelayAssetList", "openGiftCancelDelay", "i", "setOpenGiftCancelDelay", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("asset_delay")
    private long assetDelay;

    @SerializedName("enable_immediate")
    private boolean enableImmediate;

    @SerializedName("enable")
    private int enableStatus;

    @SerializedName("gift_delay")
    private long giftDelay;

    @SerializedName("gift_short_delay")
    private long giftShortDelay;

    @SerializedName("launch_asset_enable")
    private boolean launchDelayAssetList;

    @SerializedName("launch_gift_enable")
    private boolean launchDelayGiftList;

    @SerializedName("open_gift_cancel")
    private boolean openGiftCancelDelay;

    public final void a() {
        this.enableStatus = 0;
        this.giftDelay = 0;
        this.assetDelay = 0;
        this.launchDelayGiftList = true;
    }

    public final String toString() {
        return "enableStatus=" + this.enableStatus + ", giftDelay=" + this.giftDelay + ", assetDelay=" + this.assetDelay + ", launchDelayGiftLis=" + this.launchDelayGiftList + ", launchDelayAssetList=" + this.launchDelayAssetList + ", openGiftCancelDelay=" + this.openGiftCancelDelay;
    }

    public p() {
        this.giftShortDelay = 2000;
        this.launchDelayGiftList = true;
        this.launchDelayAssetList = true;
    }

    public final long b() {
        return this.assetDelay;
    }

    public final boolean c() {
        return this.enableImmediate;
    }

    public final int d() {
        return this.enableStatus;
    }

    public final long e() {
        return this.giftDelay;
    }

    public final long f() {
        return this.giftShortDelay;
    }

    public final boolean g() {
        return this.launchDelayAssetList;
    }

    public final boolean h() {
        return this.launchDelayGiftList;
    }

    public final boolean i() {
        return this.openGiftCancelDelay;
    }
}
