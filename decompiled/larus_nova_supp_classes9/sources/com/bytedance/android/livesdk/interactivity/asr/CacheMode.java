package com.bytedance.android.livesdk.interactivity.asr;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/asr/CacheMode;", BuildConfig.FLAVOR, "TIME", "NUM", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CacheMode extends Enum<CacheMode> {
    public static final CacheMode NUM = null;
    public static final CacheMode TIME = null;
    public static final /* synthetic */ CacheMode[] a = null;

    static {
        CacheMode r1 = new CacheMode("TIME", 0);
        TIME = r1;
        CacheMode r2 = new CacheMode("NUM", 1);
        NUM = r2;
        a = new CacheMode[]{r1, r2};
    }

    public static CacheMode valueOf(String r1) {
        return (CacheMode) r27.a.a(CacheMode.class, r1);
    }

    public static CacheMode[] values() {
        return (CacheMode[]) a.clone();
    }

    public CacheMode(String r1, int r2) {
        super(r1, r2);
    }
}
