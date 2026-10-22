package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/g0;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enable", "Z", "a", "()Z", "setEnable", "(Z)V", BuildConfig.FLAVOR, "maxShowDuration", "I", "b", "()I", "setMaxShowDuration", "(I)V", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g0 {
    public static final a a = null;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("max_show_duration_seconds")
    private int maxShowDuration;

    public static final class a {
        public a() {
        }
    }

    static {
        a = new a();
    }

    public g0() {
        this.maxShowDuration = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
    }

    public final boolean a() {
        return this.enable;
    }

    public final int b() {
        return this.maxShowDuration;
    }
}
