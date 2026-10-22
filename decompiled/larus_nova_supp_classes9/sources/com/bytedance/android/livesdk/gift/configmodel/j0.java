package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/j0;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enable", "Z", "a", "()Z", "setEnable", "(Z)V", BuildConfig.FLAVOR, "guideLimitCount", "I", "d", "()I", "setGuideLimitCount", "(I)V", "guideDelayShowTimeSecond", "c", "setGuideDelayShowTimeSecond", "guideDelayInvalidAfterAnimEndSecond", "b", "setGuideDelayInvalidAfterAnimEndSecond", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j0 {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("guide_show_finish_after_time_second")
    private int guideDelayInvalidAfterAnimEndSecond;

    @SerializedName("guide_delay_show_time_second")
    private int guideDelayShowTimeSecond;

    @SerializedName("guide_limit_count")
    private int guideLimitCount;

    public j0() {
        this.guideLimitCount = 3;
        this.guideDelayShowTimeSecond = 4;
        this.guideDelayInvalidAfterAnimEndSecond = 2;
    }

    public final boolean a() {
        return this.enable;
    }

    public final int b() {
        return this.guideDelayInvalidAfterAnimEndSecond;
    }

    public final int c() {
        return this.guideDelayShowTimeSecond;
    }

    public final int d() {
        return this.guideLimitCount;
    }
}
