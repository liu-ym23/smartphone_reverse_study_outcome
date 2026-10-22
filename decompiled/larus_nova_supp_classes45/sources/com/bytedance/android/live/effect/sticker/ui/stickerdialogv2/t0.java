package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import com.bytedance.android.live.effect.sticker.viewmodel.StickerDialogUIViewModel;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t0<T> implements Consumer {
    public final /* synthetic */ StickerSearchPageView a;

    public t0(StickerSearchPageView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Unit r3 = (Unit) r2;
        StickerDialogUIViewModel r4 = this.a.o;
        if (r4 == null) goto L8;
        com.bytedance.live.datacontext.m<Boolean> r5 = r4.getSearchPageStatus();
        if (r5 == null) goto L9;
        r5.setValue(Boolean.TRUE);
        return;
    L9:
        return;
    }
}
