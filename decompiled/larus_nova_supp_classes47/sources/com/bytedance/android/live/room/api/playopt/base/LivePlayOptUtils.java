package com.bytedance.android.live.room.api.playopt.base;

import com.bytedance.android.live.schema.api.WebcastRedirectException;
import fv1.e;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LivePlayOptUtils {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(LivePlayOptUtils$pushConfig$2.INSTANCE);
    }

    public static long a() {
        return ((e) a.getValue()).b() * ((long) WebcastRedirectException.UNKNOWN);
    }
}
