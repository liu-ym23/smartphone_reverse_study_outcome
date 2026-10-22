package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import com.bytedance.android.live.effect.sticker.ui.StickerSearchBox;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v0<T> implements Consumer {
    public final /* synthetic */ StickerSearchPageView a;

    public v0(StickerSearchPageView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        String r3 = (String) r2;
        StickerSearchBox r0 = StickerSearchPageView.T5(this.a);
        if (r0 == null) goto L6;
        r0.T5(r3);
        return;
    }
}
