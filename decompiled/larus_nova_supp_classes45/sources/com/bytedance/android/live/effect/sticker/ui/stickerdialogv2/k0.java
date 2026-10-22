package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.view.View;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDialogUIViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k0 implements View.OnClickListener {
    public final /* synthetic */ StickerSearchPageView a;

    public k0(StickerSearchPageView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        StickerDialogUIViewModel r3 = this.a.o;
        if (r3 == null) goto L8;
        com.bytedance.live.datacontext.m<Boolean> r4 = r3.getSearchPageStatus();
        if (r4 == null) goto L9;
        r4.setValue(Boolean.FALSE);
        return;
    L9:
        return;
    }
}
