package com.bytedance.android.live.effect.common;

import androidx.lifecycle.Observer;
import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t<T> implements Observer {
    public final /* synthetic */ LiveCommonStickerListView a;

    public t(LiveCommonStickerListView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        Sticker r2 = (Sticker) r1;
        LiveCommonStickerListView.b6(this.a);
    }
}
