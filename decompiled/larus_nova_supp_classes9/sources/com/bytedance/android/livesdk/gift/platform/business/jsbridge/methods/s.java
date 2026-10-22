package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ SendGiftMethod a;

    public s(SendGiftMethod r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        if (ay0.c.d() == false) goto L5;
        this.a.finishWithFailure(new RuntimeException("1: " + r5.getMessage()));
        return;
    L5:
        this.a.finishWithFailure(r5);
    }
}
