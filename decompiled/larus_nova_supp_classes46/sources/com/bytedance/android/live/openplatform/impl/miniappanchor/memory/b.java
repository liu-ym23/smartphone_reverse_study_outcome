package com.bytedance.android.live.openplatform.impl.miniappanchor.memory;

import com.bytedance.android.live.openplatform.impl.miniappcommon.monitor.MiniAppMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void accept(Object r3) {
        qo0.a.b("MemoryContextService", "requestMemoryData fail", (Throwable) r3);
        int r4 = MiniAppMonitor.a;
        MiniAppMonitor.a(MiniAppMonitor.ExceptionType.Mount, "requestMemoryData fail");
    }
}
