package com.bytedance.android.livesdk.gift.platform.format.service;

import ca0.w;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ FormatGiftListService a;
    public final /* synthetic */ w b;

    public f(FormatGiftListService r1, w r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        this.a.e = false;
        w r4 = this.b;
        if (r4 == null) goto L6;
        r4.a();
        return;
    }
}
