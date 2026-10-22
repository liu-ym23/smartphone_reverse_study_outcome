package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.view.View;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r<T> implements Observer {
    public final /* synthetic */ LiveStickerDialogV2 a;

    public r(LiveStickerDialogV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        LiveStickerDialogV2 r0 = this.a;
        int r1 = LiveStickerDialogV2.y;
        r0.getClass();
        int r5 = h.a[((StickerLoadingStatus) r4).ordinal()];
        if (r5 != 1) goto L5;
        View r6 = r0.getView();
        if (r6 == null) goto L31;
        LoadingStatusView r7 = r6.findViewById(2131387318);
        if (r7 == null) goto L32;
        r7.reset();
        return;
    L32:
        return;
    L31:
        return;
    L5:
        if (r5 != 2) goto L7;
        View r8 = r0.getView();
        if (r8 == null) goto L28;
        LoadingStatusView r9 = r8.findViewById(2131387318);
        if (r9 == null) goto L29;
        r9.showLoading();
        return;
    L29:
        return;
    L28:
        return;
    L7:
        if (r5 != 3) goto L33;
        View r11 = r0.getView();
        if (r11 == null) goto L25;
        LoadingStatusView r12 = r11.findViewById(2131387318);
        if (r12 == null) goto L26;
        r12.showError();
        return;
    L26:
        return;
    L25:
        return;
    }
}
