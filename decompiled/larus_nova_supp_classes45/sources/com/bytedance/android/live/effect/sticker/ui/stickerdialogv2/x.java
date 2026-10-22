package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.effect.sticker.ui.aigc.AigcTaskPanel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x<T> implements Observer {
    public final /* synthetic */ LiveStickerDialogV2 a;

    public x(LiveStickerDialogV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        LiveStickerDialogV2 r0 = this.a;
        boolean r4 = ((Boolean) r3).booleanValue();
        int r1 = LiveStickerDialogV2.y;
        View r2 = r0.getView();
        if (r2 == null) goto L11;
        ConstraintLayout r5 = (AigcTaskPanel) r2.findViewById(2131362448);
        if (r5 == null) goto L12;
        if (r4 == false) goto L8;
        int r6 = 0;
    L9:
        r5.setVisibility(r6);
        return;
    L8:
        r6 = 8;
        goto L9
    L12:
        return;
    }
}
