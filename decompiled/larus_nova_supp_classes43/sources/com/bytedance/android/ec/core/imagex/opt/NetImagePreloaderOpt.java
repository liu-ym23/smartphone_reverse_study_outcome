package com.bytedance.android.ec.core.imagex.opt;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class NetImagePreloaderOpt implements pi.c {
    public final Lazy a;

    public NetImagePreloaderOpt() {
        this.a = LazyKt.lazy(LazyThreadSafetyMode.NONE, NetImagePreloaderOpt$proxy$2.INSTANCE);
    }
}
