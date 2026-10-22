package com.bytedance.android.livesdk.gamecp;

import io.reactivex.functions.Consumer;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ GamecpDependService a;

    public e(GamecpDependService r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        GamecpDependService r0 = this.a;
        r0.onEvent((h1) r2);
    }
}
