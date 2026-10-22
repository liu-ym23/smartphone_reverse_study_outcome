package com.bytedance.android.ec.core.monitor;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/core/monitor/p;", "", "", com.bytedance.android.ec.core.event.a.KEY_URL, "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "a", "(Ljava/lang/String;)V", "version", "getVersion", com.bytedance.android.ec.core.event.a.KEY_PLATFORM, "getPlatform", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PLATFORM)
    private final String platform;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_URL)
    private String url;

    @SerializedName("version")
    private final String version;

    public p(String r10) {
        Intrinsics.checkNotNullParameter("", com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r10, "version");
        Intrinsics.checkNotNullParameter("android", com.bytedance.android.ec.core.event.a.KEY_PLATFORM);
        this.url = "";
        this.version = r10;
        this.platform = "android";
    }

    public final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.url = r10;
    }
}
