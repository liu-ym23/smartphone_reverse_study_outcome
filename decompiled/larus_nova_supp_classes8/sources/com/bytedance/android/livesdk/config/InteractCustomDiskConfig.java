package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/config/InteractCustomDiskConfig;", "", "", "cacheEnable", "Z", "a", "()Z", "setCacheEnable", "(Z)V", "", "maxDiskSize", "I", "getMaxDiskSize", "()I", "setMaxDiskSize", "(I)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractCustomDiskConfig {
    public static final Lazy a = null;

    @SerializedName("enable")
    private boolean cacheEnable;

    @SerializedName("max_disk_cache")
    private int maxDiskSize;

    public static final class a {
    }

    static {
        a = LazyKt.lazy(InteractCustomDiskConfig$Companion$hasInit$2.INSTANCE);
    }

    public InteractCustomDiskConfig() {
        this.maxDiskSize = 20;
    }

    public final boolean a() {
        return this.cacheEnable;
    }
}
