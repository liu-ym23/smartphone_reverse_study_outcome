package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/e91;", "", "", "lazyToolbarBehavior", "Z", "getLazyToolbarBehavior", "()Z", "setLazyToolbarBehavior", "(Z)V", "blockCommercial", "getBlockCommercial", "setBlockCommercial", "<init>", "()V", "a", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e91 {
    public static final e91 a = null;

    @SerializedName("block_commercial")
    private boolean blockCommercial;

    @SerializedName("lazy_toolbar")
    private boolean lazyToolbarBehavior;

    public static final class a {
    }

    public static final e91 a() {
        return a;
    }

    static {
        a = new e91();
    }

    public e91() {
        this.lazyToolbarBehavior = true;
        this.blockCommercial = true;
    }
}
