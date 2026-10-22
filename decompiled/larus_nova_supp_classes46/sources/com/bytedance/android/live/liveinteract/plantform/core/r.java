package com.bytedance.android.live.liveinteract.plantform.core;

import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r<T> implements Consumer {
    public static final r a = null;

    static {
        a = new r();
    }

    public r() {
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        Intrinsics.checkNotNullParameter(r3, "throwable");
        int r0 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        LinkedHashMap r1 = new LinkedHashMap();
        com.bytedance.android.live.liveinteract.plantform.utils.x.X(r3, r1);
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("notify_join_rtc_failed", r1);
    }
}
