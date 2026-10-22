package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x1<T> implements Consumer {
    public final /* synthetic */ w1 a;

    public x1(w1 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        w1 r5 = this.a;
        r5.a.stopMonitorFps("open_gift_panel", r5.f);
        this.a.a.releaseFpsMonitor("open_gift_panel");
        this.a.e = true;
    }
}
