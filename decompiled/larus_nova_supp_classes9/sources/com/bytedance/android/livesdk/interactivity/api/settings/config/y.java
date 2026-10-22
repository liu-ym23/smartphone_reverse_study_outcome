package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/y;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enable", "Z", "a", "()Z", "setEnable", "(Z)V", BuildConfig.FLAVOR, "lowLevelHeight", "I", "getLowLevelHeight", "()I", "setLowLevelHeight", "(I)V", "midLevelHeight", "getMidLevelHeight", "setMidLevelHeight", "highLevelHeight", "getHighLevelHeight", "setHighLevelHeight", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y {

    @SerializedName("enable_platform_strategy")
    private boolean enable;

    @SerializedName("high_height")
    private int highLevelHeight;

    @SerializedName("low_height")
    private int lowLevelHeight;

    @SerializedName("mid_height")
    private int midLevelHeight;

    public y() {
        this.enable = true;
        this.lowLevelHeight = -20;
        this.highLevelHeight = 20;
    }

    public final boolean a() {
        return this.enable;
    }

    public final int b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        int r0 = r3.hashCode();
        if (r0 == (-1074341483)) goto L16;
        if (r0 == 107348) goto L13;
        if (r0 == 3202466) goto L10;
    L18:
        int r4 = 0;
    L19:
        if (r4 < 0) goto L22;
        return UtilityKotlinExtentionsKt.i(r4);
    L22:
        return UtilityKotlinExtentionsKt.i(Math.abs(r4)) * (-1);
    L10:
        if (r3.equals("high") == false) goto L18;
        r4 = this.highLevelHeight;
        goto L19
    L13:
        if (r3.equals("low") == false) goto L18;
        r4 = this.lowLevelHeight;
        goto L19
    L16:
        if (r3.equals("middle") == false) goto L18;
        r4 = this.midLevelHeight;
        goto L19
    }
}
