package com.bytedance.android.livesdk.gift.platform.core.keva_store;

import com.bytedance.bdlocation.BuildConfig;
import iz0.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final iz0.a a = null;

    static {
        a = c.a("live_asset_download_repo", 0);
    }

    public static String a(AssetKevaKey r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return a.d(r2.getKey(), BuildConfig.FLAVOR);
    }

    public static long c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "md5");
        return a.e("last_use_time_".concat(r3), 0);
    }

    public static void b(AssetKevaKey r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r2, "value");
        a.a(r1.getKey(), r2);
    }

    public static void d(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "md5");
        a.b("last_use_time_" + r2, r3);
    }
}
