package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/config/rj1;", "", "", "enable", "Z", "a", "()Z", "setEnable", "(Z)V", "", "", "modeSelectUrlConfig", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "setModeSelectUrlConfig", "(Ljava/util/Map;)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class rj1 {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("mode_select_start_url")
    private Map<String, String> modeSelectUrlConfig;

    public rj1() {
        this.modeSelectUrlConfig = MapsKt.emptyMap();
    }

    public final boolean a() {
        return this.enable;
    }

    public final Map<String, String> b() {
        return this.modeSelectUrlConfig;
    }
}
