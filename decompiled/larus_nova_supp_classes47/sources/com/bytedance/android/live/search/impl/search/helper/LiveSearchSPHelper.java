package com.bytedance.android.live.search.impl.search.helper;

import android.content.SharedPreferences;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LiveSearchSPHelper {
    public static final Lazy a = null;
    public static final SharedPreferences.Editor b = null;

    static {
        Lazy r0 = LazyKt.lazy(LiveSearchSPHelper$sharedPreferences$2.INSTANCE);
        a = r0;
        SharedPreferences r1 = (SharedPreferences) r0.getValue();
        if (r1 == null) goto L5;
        SharedPreferences.Editor r2 = r1.edit();
    L6:
        b = r2;
        return;
    L5:
        r2 = null;
        goto L6
    }
}
