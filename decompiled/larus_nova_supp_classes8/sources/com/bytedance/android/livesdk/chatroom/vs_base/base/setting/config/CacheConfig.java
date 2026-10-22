package com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/setting/config/CacheConfig;", "", "", "value", "I", "getValue", "()I", "DISABLE", "ONLY_CACHE_API", "CACHE_API_AND_VIDEO", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CacheConfig extends Enum<CacheConfig> {
    public static final CacheConfig CACHE_API_AND_VIDEO = null;
    public static final CacheConfig DISABLE = null;
    public static final CacheConfig ONLY_CACHE_API = null;
    public static final /* synthetic */ CacheConfig[] a = null;
    private final int value;

    static {
        CacheConfig r1 = new CacheConfig("DISABLE", 0, 0);
        DISABLE = r1;
        CacheConfig r2 = new CacheConfig("ONLY_CACHE_API", 1, 1);
        ONLY_CACHE_API = r2;
        CacheConfig r3 = new CacheConfig("CACHE_API_AND_VIDEO", 2, 2);
        CACHE_API_AND_VIDEO = r3;
        a = new CacheConfig[]{r1, r2, r3};
    }

    public static CacheConfig valueOf(String r1) {
        return (CacheConfig) a.a(CacheConfig.class, r1);
    }

    public static CacheConfig[] values() {
        return (CacheConfig[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public CacheConfig(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
