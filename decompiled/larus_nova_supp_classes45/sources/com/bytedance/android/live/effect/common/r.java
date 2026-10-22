package com.bytedance.android.live.effect.common;

import androidx.lifecycle.Observer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r<T> implements Observer {
    public final /* synthetic */ LiveCommonStickerListView a;

    public r(LiveCommonStickerListView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        LiveCommonStickerListView r0 = this.a;
        LiveCommonStickerListView.c6(r0, (List) r2);
    }
}
