package com.bytedance.android.live.network.impl.utils;

import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class NetworkGson {
    public static final Lazy a = null;

    public static Gson a() {
        return (Gson) a.getValue();
    }

    static {
        a = LazyKt.lazy(NetworkGson$instance$2.INSTANCE);
    }
}
