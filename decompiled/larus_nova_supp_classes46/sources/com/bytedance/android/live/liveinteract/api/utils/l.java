package com.bytedance.android.live.liveinteract.api.utils;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class l implements Consumer<Throwable> {
    public static final l a = null;

    public l() {
    }

    static {
        a = new l();
    }

    public void a(Throwable r3) throws Exception {
        if (r3 == null) goto L5;
        ALogger.stacktrace(6, "RxErrorConsumer", r3.getStackTrace());
        return;
    }

    public /* bridge */ /* synthetic */ void accept(Object r1) throws Exception {
        a((Throwable) r1);
    }
}
