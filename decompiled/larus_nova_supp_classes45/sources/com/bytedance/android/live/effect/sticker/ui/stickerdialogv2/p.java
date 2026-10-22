package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.view.View;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.effect.sticker.ui.aigc.AigcTaskPanel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p<T> implements Observer {
    public final /* synthetic */ LiveStickerDialogV2 a;

    public p(LiveStickerDialogV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        com.bytedance.android.live.effect.sticker.ui.aigc.b r4 = (com.bytedance.android.live.effect.sticker.ui.aigc.b) r3;
        LiveStickerDialogV2 r0 = this.a;
        int r1 = LiveStickerDialogV2.y;
        if (r4 == null) goto L9;
        View r2 = r0.getView();
        if (r2 == null) goto L11;
        AigcTaskPanel r5 = (AigcTaskPanel) r2.findViewById(2131362448);
        if (r5 == null) goto L12;
        r5.setListener(r4);
        return;
    L12:
        return;
    L11:
        return;
    L9:
        r0.getClass();
    }
}
