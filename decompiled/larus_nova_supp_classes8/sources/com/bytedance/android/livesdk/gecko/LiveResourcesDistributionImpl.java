package com.bytedance.android.livesdk.gecko;

import android.webkit.WebResourceResponse;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveResourcesDistributionImpl {
    public static boolean d;
    public j a;
    public Function1<? super String, ? extends WebResourceResponse> b;
    public final Lazy c;

    public static final class a {
    }

    static {
    }

    public LiveResourcesDistributionImpl() {
        this.c = LazyKt.lazy(LiveResourcesDistributionImpl$mPrefetchChannels$2.INSTANCE);
    }
}
