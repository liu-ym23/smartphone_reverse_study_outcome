package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/y2;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enable", "Z", "a", "()Z", "setEnable", "(Z)V", BuildConfig.FLAVOR, "extraRequestInterval", "I", "b", "()I", "setExtraRequestInterval", "(I)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y2 {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("extra_update_interval")
    private int extraRequestInterval;

    public y2() {
        this.enable = true;
        this.extraRequestInterval = 5;
    }

    public final boolean a() {
        return this.enable;
    }

    public final int b() {
        return this.extraRequestInterval;
    }
}
