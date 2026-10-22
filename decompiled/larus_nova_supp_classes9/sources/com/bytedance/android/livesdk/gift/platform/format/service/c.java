package com.bytedance.android.livesdk.gift.platform.format.service;

import ca0.w;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements SingleOnSubscribe {
    public final /* synthetic */ FormatGiftListService a;
    public final /* synthetic */ w b;

    public c(FormatGiftListService r1, w r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(SingleEmitter<Object> r2) {
        w r3 = this.b;
        if (r3 == null) goto L6;
        r3.b(this.a.b);
        return;
    }
}
