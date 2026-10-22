package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.view.KeyEvent;
import android.view.View;
import com.bytedance.android.live.effect.sticker.ui.StickerSearchBox;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l0 implements View.OnKeyListener {
    public final /* synthetic */ StickerSearchPageView a;

    public l0(StickerSearchPageView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r1, int r2, KeyEvent r3) {
        boolean r4 = false;
        if (r2 != 66) goto L16;
        StickerSearchBox r5 = StickerSearchPageView.T5(this.a);
        if (r5 == null) goto L7;
        String r6 = r5.getContent();
    L9:
        if (r6 != null) goto L11;
    L12:
        r4 = true;
    L13:
        if (r4 == true) goto L15;
        StickerSearchPageView r7 = this.a;
        r7.q = true;
        StickerSearchPageView.c6(r7);
        this.a.hideKeyboard();
    L15:
        return true;
    L11:
        if (r6.length() != 0) goto L13;
    L7:
        r6 = null;
        goto L9
    L16:
        return false;
    }
}
