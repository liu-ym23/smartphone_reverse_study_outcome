package com.larus.business.debug.base.audio.module;

import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public static final Lazy a = null;
    public static final boolean b = false;

    static {
        a = LazyKt.lazy(new e());
        b = ArraysKt.contains(new String[]{"local_test", "debug"}, AppHost.a.getBuildChannel());
    }

    public static final Keva a() {
        return (Keva) a.getValue();
    }
}
