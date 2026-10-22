package com.bytedance.android.live.liveinteract.banner;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ BannerWidget a;

    public b(BannerWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        ALogger.e("BannerWidget", "getActivityLinks failed", (Throwable) r3);
        BannerWidget.a r4 = this.a.h;
        if (r4 == null) goto L6;
        r4.b(false, null);
        return;
    }
}
