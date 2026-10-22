package com.bytedance.android.live.effect.common;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q implements View.OnClickListener {
    public final /* synthetic */ LiveCommonStickerListView a;

    public q(LiveCommonStickerListView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        LiveCommonStickerDataViewModel r3 = LiveCommonStickerListView.S5(this.a);
        if (r3 == null) goto L6;
        r3.fetchStickerList(this.a.f);
        return;
    }
}
