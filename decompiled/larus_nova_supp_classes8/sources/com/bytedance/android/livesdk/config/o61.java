package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/config/o61;", "", "", "enableSearch", "Z", "c", "()Z", "enablePersonalPage", "a", "enablePrivateLetter", "b", "<init>", "()V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o61 {

    @SerializedName("enable_personal_page")
    private final boolean enablePersonalPage;

    @SerializedName("enable_private_letter")
    private final boolean enablePrivateLetter;

    @SerializedName("enable_search")
    private final boolean enableSearch;

    public o61() {
    }

    public final boolean a() {
        return this.enablePersonalPage;
    }

    public final boolean b() {
        return this.enablePrivateLetter;
    }

    public final boolean c() {
        return this.enableSearch;
    }
}
