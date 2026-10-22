package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.effect.sticker.ui.StickerSearchBox;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h0 implements View.OnTouchListener {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ StickerSearchPageView b;

    public h0(RecyclerView r1, StickerSearchPageView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        if (r3.getAction() != 2) goto L7;
        this.b.hideKeyboard();
        StickerSearchBox r4 = (StickerSearchBox) this.a.findViewById(2131385341);
        if (r4 == null) goto L7;
        r4.U5(false);
    L7:
        return false;
    }
}
