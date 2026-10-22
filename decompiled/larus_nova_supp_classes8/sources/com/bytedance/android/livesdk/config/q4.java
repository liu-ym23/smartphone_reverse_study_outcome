package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/config/q4;", "", "", "settingOpt", "I", "a", "()I", "setSettingOpt", "(I)V", "", "isLoadUiOpt", "Z", "c", "()Z", "setLoadUiOpt", "(Z)V", "useToolbarCache", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "setUseToolbarCache", "(Ljava/lang/Boolean;)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q4 {

    @SerializedName("is_load_opt")
    private boolean isLoadUiOpt;

    @SerializedName("setting_opt")
    private int settingOpt;

    @SerializedName("toolbar_cache")
    private Boolean useToolbarCache;

    public q4() {
        this.useToolbarCache = Boolean.FALSE;
    }

    public final int a() {
        return this.settingOpt;
    }

    public final Boolean b() {
        return this.useToolbarCache;
    }

    public final boolean c() {
        return this.isLoadUiOpt;
    }
}
