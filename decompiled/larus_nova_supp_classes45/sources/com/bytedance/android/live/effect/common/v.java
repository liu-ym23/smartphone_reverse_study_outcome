package com.bytedance.android.live.effect.common;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v implements Action {
    public final /* synthetic */ LiveCommonStickerListView a;

    public v(LiveCommonStickerListView r1) {
        this.a = r1;
    }

    public final void run() {
        this.a.c.clear();
    }
}
