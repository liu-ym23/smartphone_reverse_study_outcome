package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/config/w;", "", "", "button", "Ljava/lang/String;", "a", "()Ljava/lang/String;", LiveEndPageData.TAG_TITLE, "b", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w {

    @SerializedName("button")
    private final String button;

    @SerializedName(LiveEndPageData.TAG_TITLE)
    private final String title;

    public w() {
        this(0);
    }

    public final String a() {
        return this.button;
    }

    public final String b() {
        return this.title;
    }

    public w(int r3) {
        Intrinsics.checkNotNullParameter("同意并继续", "button");
        Intrinsics.checkNotNullParameter("授权协议", LiveEndPageData.TAG_TITLE);
        this.button = "同意并继续";
        this.title = "授权协议";
    }
}
