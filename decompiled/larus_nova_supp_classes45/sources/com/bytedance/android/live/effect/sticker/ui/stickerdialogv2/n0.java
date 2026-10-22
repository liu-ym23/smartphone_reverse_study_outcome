package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import androidx.lifecycle.Observer;
import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n0<T> implements Observer {
    public final /* synthetic */ StickerSearchPageView a;

    public n0(StickerSearchPageView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        Sticker r2 = (Sticker) r1;
        LiveStickerDialogListAdapter r3 = this.a.p;
        if (r3 == null) goto L6;
        r3.C2();
        return;
    }
}
