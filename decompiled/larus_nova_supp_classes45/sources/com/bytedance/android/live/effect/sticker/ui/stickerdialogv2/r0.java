package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r0<T> implements Consumer {
    public final /* synthetic */ StickerSearchPageView a;

    public r0(StickerSearchPageView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Sticker r3 = (Sticker) r2;
        LiveStickerDialogListAdapter r0 = this.a.p;
        if (r0 == null) goto L6;
        r0.B2(r3);
        return;
    }
}
