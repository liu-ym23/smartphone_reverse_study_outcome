package com.bytedance.android.live.effect.common;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements Action {
    public final /* synthetic */ LiveCommonStickerAdjustBarView a;

    public i(LiveCommonStickerAdjustBarView r1) {
        this.a = r1;
    }

    public final void run() {
        this.a.b.clear();
    }
}
