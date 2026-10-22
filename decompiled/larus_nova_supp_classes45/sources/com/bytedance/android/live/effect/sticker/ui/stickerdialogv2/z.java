package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z<T> implements Consumer {
    public final /* synthetic */ LiveStickerDialogV2 a;

    public z(LiveStickerDialogV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ((n90.f) r2).getClass();
        View r3 = this.a.getView();
        if (r3 == null) goto L8;
        View r4 = r3.findViewById(2131387344);
        if (r4 == null) goto L9;
        r4.setVisibility(4);
        return;
    L9:
        return;
    }
}
