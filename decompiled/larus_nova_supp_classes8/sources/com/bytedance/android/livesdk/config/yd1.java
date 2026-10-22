package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/config/yd1;", "", "", "scopeCheckEnable", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "setScopeCheckEnable", "(Ljava/lang/Boolean;)V", "", "scopeCheckInterval", "J", "b", "()J", "setScopeCheckInterval", "(J)V", "disableFallbackClear", "Z", "getDisableFallbackClear", "()Z", "setDisableFallbackClear", "(Z)V", "scopeLoadNeedInRoom", "c", "setScopeLoadNeedInRoom", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class yd1 {

    @SerializedName("disable_fallback_clear")
    private boolean disableFallbackClear;

    @SerializedName("scope_check_enable")
    private Boolean scopeCheckEnable;

    @SerializedName("scope_check_interval")
    private long scopeCheckInterval;

    @SerializedName("scope_load_need_inroom")
    private boolean scopeLoadNeedInRoom;

    public yd1() {
        this.scopeCheckEnable = Boolean.TRUE;
        this.scopeCheckInterval = 15;
        this.disableFallbackClear = true;
        this.scopeLoadNeedInRoom = true;
    }

    public final Boolean a() {
        return this.scopeCheckEnable;
    }

    public final long b() {
        return this.scopeCheckInterval;
    }

    public final boolean c() {
        return this.scopeLoadNeedInRoom;
    }
}
