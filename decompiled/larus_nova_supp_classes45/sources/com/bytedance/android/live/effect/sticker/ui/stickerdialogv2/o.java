package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o<T> implements Observer {
    public final /* synthetic */ LiveStickerDialogV2 a;

    public o(LiveStickerDialogV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Pair r5 = (Pair) r4;
        LiveStickerDialogV2 r0 = this.a;
        boolean r1 = ((Boolean) r5.getFirst()).booleanValue();
        String r6 = (String) r5.getSecond();
        int r2 = LiveStickerDialogV2.y;
        View r3 = r0.getView();
        if (r3 == null) goto L12;
        TextView r7 = (TextView) r3.findViewById(2131362446);
        if (r7 == null) goto L13;
        r7.setText(r6);
        if (r1 == false) goto L9;
        int r8 = 0;
    L10:
        r7.setVisibility(r8);
        return;
    L9:
        r8 = 8;
        goto L10
    L13:
        return;
    }
}
