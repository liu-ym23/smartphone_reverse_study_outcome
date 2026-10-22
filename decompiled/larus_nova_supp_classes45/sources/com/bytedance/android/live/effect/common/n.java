package com.bytedance.android.live.effect.common;

import android.view.View;
import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ LiveCommonStickerListAdapter a;
    public final /* synthetic */ Sticker b;

    public n(LiveCommonStickerListAdapter r1, Sticker r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        this.a.k.b(r3.getContext(), this.b);
    }
}
