package com.larus.camera.impl.utils;

import com.larus.common.apphost.AppHost;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new j());
    }

    public static boolean a() {
        return AppHost.a.isOversea();
    }
}
