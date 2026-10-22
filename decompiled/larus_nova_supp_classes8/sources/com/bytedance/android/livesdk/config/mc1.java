package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/config/mc1;", "", "Lcom/bytedance/android/livesdk/config/w;", "agreement", "Lcom/bytedance/android/livesdk/config/w;", "a", "()Lcom/bytedance/android/livesdk/config/w;", "Lcom/bytedance/android/livesdk/config/lc1;", "oneKeyAuth", "Lcom/bytedance/android/livesdk/config/lc1;", "b", "()Lcom/bytedance/android/livesdk/config/lc1;", "Lcom/bytedance/android/livesdk/config/be1;", "passive", "Lcom/bytedance/android/livesdk/config/be1;", "c", "()Lcom/bytedance/android/livesdk/config/be1;", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class mc1 {

    @SerializedName("agreement")
    private final w agreement;

    @SerializedName("oneKeyAuth")
    private final lc1 oneKeyAuth;

    @SerializedName("passive")
    private final be1 passive;

    public mc1() {
        w r0 = new w(0);
        lc1 r2 = new lc1(0);
        be1 r3 = new be1(0);
        Intrinsics.checkNotNullParameter(r0, "agreement");
        Intrinsics.checkNotNullParameter(r2, "oneKeyAuth");
        Intrinsics.checkNotNullParameter(r3, "passive");
        this.agreement = r0;
        this.oneKeyAuth = r2;
        this.passive = r3;
    }

    public final w a() {
        return this.agreement;
    }

    public final lc1 b() {
        return this.oneKeyAuth;
    }

    public final be1 c() {
        return this.passive;
    }
}
