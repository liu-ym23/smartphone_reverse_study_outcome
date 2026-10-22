package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import com.bytedance.android.live.effect.sticker.ui.StickerSearchBox;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u0<T> implements Consumer {
    public final /* synthetic */ StickerSearchPageView a;

    public u0(StickerSearchPageView r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Unit r2 = (Unit) r1;
        StickerSearchBox r3 = StickerSearchPageView.T5(this.a);
        if (r3 == null) goto L6;
        r3.Z5();
        return;
    }
}
