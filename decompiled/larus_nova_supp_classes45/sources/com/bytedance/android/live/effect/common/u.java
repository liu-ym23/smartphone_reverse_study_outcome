package com.bytedance.android.live.effect.common;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u<T> implements Observer {
    public final /* synthetic */ LiveCommonStickerListView a;

    public u(LiveCommonStickerListView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        LiveCommonStickerListAdapter r0 = LiveCommonStickerListView.T5(this.a);
        r0.f = ((Boolean) r2).booleanValue();
        r0.notifyDataSetChanged();
    }
}
