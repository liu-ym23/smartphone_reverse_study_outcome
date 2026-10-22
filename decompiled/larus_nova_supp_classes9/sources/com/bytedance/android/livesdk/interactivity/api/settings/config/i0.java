package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/i0;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isScrollFromEnd", "Z", "b", "()Z", "setScrollFromEnd", "(Z)V", "onlyLandscapeStream", "a", "setOnlyLandscapeStream", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i0 {

    @SerializedName("is_scroll_formend")
    private boolean isScrollFromEnd;

    @SerializedName("only_landscape_stream")
    private boolean onlyLandscapeStream;

    public i0() {
    }

    public final boolean a() {
        return this.onlyLandscapeStream;
    }

    public final boolean b() {
        return this.isScrollFromEnd;
    }
}
