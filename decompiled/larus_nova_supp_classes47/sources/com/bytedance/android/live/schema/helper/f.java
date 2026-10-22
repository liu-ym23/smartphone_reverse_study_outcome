package com.bytedance.android.live.schema.helper;

import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.keva.Keva;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Pair a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Keva r0 = Keva.getRepo("lynx_common_cache");
        long r4 = Keva.getRepo("lynx_cache_valid_time").getLong(r10, 0);
        if (r4 <= (System.currentTimeMillis() / ((long) WebcastRedirectException.UNKNOWN))) goto L7;
        return TuplesKt.to(Boolean.TRUE, r0.getString(r10, null));
    L7:
        if (r4 != 0) goto L11;
        return TuplesKt.to(Boolean.TRUE, null);
    L11:
        return TuplesKt.to(Boolean.FALSE, null);
    }
}
