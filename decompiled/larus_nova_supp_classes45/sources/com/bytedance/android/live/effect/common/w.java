package com.bytedance.android.live.effect.common;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w<T> implements Consumer {
    public final /* synthetic */ LiveCommonStickerListView a;

    public w(LiveCommonStickerListView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        LiveCommonStickerListAdapter r0 = LiveCommonStickerListView.T5(this.a);
        r0.z2((Sticker) r2);
    }
}
