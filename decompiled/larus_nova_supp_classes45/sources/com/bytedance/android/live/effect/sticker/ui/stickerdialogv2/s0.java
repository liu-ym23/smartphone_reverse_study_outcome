package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import com.bytedance.android.live.effect.sticker.ui.StickerSearchBox;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDialogUIViewModel;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s0<T> implements Consumer {
    public final /* synthetic */ StickerSearchPageView a;

    public s0(StickerSearchPageView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Unit r3 = (Unit) r2;
        StickerSearchBox r4 = StickerSearchPageView.T5(this.a);
        if (r4 == null) goto L5;
        r4.T5("");
    L5:
        StickerDialogUIViewModel r5 = this.a.o;
        if (r5 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r6 = r5.getSearchPageStatus();
        if (r6 == null) goto L12;
        r6.setValue(Boolean.TRUE);
        return;
    L12:
        return;
    }
}
