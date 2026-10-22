package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.effect.sticker.viewmodel.StickerAigcViewModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ j a;

    public u(StickerAigcViewModel.b.a r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Throwable r2 = (Throwable) r1;
        j r3 = this.a;
        if (r3 == null) goto L6;
        r3.onFail();
        return;
    }
}
