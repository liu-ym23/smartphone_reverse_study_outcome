package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/ui/configuration/q;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "message", "getMessage", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q {

    @SerializedName("message")
    private final String message;

    @SerializedName("title")
    private final String title;

    public q(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "message");
        this.title = r2;
        this.message = r3;
    }
}
