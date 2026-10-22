package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public d(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        Function1 r0 = this.a;
        String r1 = r5.getMessage();
        if (r1 != null) goto L5;
        r1 = "request live/data/real_time fail";
    L5:
        r0.invoke(r1);
        qo0.a.b("LiveMgMountContextService", "request live/data/real_time fail", r5);
    }
}
