package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/GiftPanelOptConfig;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "cacheEnable", "Z", "a", "()Z", "setCacheEnable", "(Z)V", BuildConfig.FLAVOR, "maxDiskSize", "I", "getMaxDiskSize", "()I", "setMaxDiskSize", "(I)V", "propOptEnable", BuildConfig.FLAVOR, "delayLoadIconTime", "J", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftPanelOptConfig {
    public final Lazy a;

    @SerializedName("enable")
    private boolean cacheEnable;

    @SerializedName("delay_load_icon")
    public long delayLoadIconTime;

    @SerializedName("max_disk_cache")
    private int maxDiskSize;

    @SerializedName("prop_opt_enable")
    public boolean propOptEnable;

    public static final class a {
    }

    static {
    }

    public GiftPanelOptConfig() {
        this.a = LazyKt.lazy(GiftPanelOptConfig$hasInit$2.INSTANCE);
        this.maxDiskSize = 20;
    }

    public final boolean a() {
        return this.cacheEnable;
    }
}
