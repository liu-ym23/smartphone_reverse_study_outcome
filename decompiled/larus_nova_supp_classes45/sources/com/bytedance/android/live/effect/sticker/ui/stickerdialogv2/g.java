package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDialogUIViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ LiveStickerDialogListAdapter a;
    public final /* synthetic */ Sticker b;

    public g(LiveStickerDialogListAdapter r1, Sticker r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        StickerDialogUIViewModel r0 = this.a.z2();
        if (r0 == null) goto L6;
        Context r6 = r5.getContext();
        Sticker r1 = this.b;
        LiveStickerDialogListAdapter r2 = this.a;
        r0.tryApplySticker(r6, r1, r2.i, r2.j);
        return;
    }
}
