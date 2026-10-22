package com.bytedance.android.live.effect.common;

import androidx.lifecycle.Observer;
import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ LiveCommonStickerAdjustBarView a;

    public h(LiveCommonStickerAdjustBarView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        LiveCommonStickerAdjustBarView r0 = this.a;
        LiveCommonStickerAdjustBarView.S5(r0, (Sticker) r2);
    }
}
