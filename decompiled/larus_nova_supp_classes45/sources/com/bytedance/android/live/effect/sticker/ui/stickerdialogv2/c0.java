package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c0<T> implements Consumer {
    public final /* synthetic */ LiveStickerDialogV2 a;

    public c0(LiveStickerDialogV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        String r3 = (String) r2;
        View r4 = this.a.getView();
        if (r4 == null) goto L8;
        ConstraintLayout r5 = r4.findViewById(2131371502);
        if (r5 == null) goto L9;
        r5.setVisibility(8);
        return;
    L9:
        return;
    }
}
