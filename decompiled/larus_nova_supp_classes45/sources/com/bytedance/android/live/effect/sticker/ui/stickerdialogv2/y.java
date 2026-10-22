package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.effect.sticker.ui.aigc.AigcTaskPanel;
import com.bytedance.android.live.effect.sticker.ui.aigc.AigcTaskPanelStatus;
import com.bytedance.android.live.effect.sticker.ui.aigc.AigcTaskPanelStatusBundleKey;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y<T> implements Observer {
    public final /* synthetic */ LiveStickerDialogV2 a;

    public y(LiveStickerDialogV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        Pair r7 = (Pair) r6;
        LiveStickerDialogV2 r0 = this.a;
        AigcTaskPanelStatus r1 = (AigcTaskPanelStatus) r7.getFirst();
        Bundle r8 = (Bundle) r7.getSecond();
        int r2 = LiveStickerDialogV2.y;
        View r3 = r0.getView();
        if (r3 == null) goto L18;
        AigcTaskPanel r4 = (AigcTaskPanel) r3.findViewById(2131362448);
        if (r4 == null) goto L21;
        int r5 = h.c[r1.ordinal()];
        if (r5 != 1) goto L10;
        r4.T5(r8.getString(AigcTaskPanelStatusBundleKey.Keyword.getKeyName(), ""));
        return;
    L10:
        if (r5 != 2) goto L12;
        r4.U5(r8.getBoolean(AigcTaskPanelStatusBundleKey.CanApplyBackgroundImage.getKeyName(), false));
        return;
    L12:
        if (r5 != 3) goto L22;
        r4.V5(r8.getString(AigcTaskPanelStatusBundleKey.Keyword.getKeyName(), ""), r8.getBoolean(AigcTaskPanelStatusBundleKey.ShowAnimation.getKeyName(), false));
        return;
    L22:
        return;
    L21:
        return;
    }
}
