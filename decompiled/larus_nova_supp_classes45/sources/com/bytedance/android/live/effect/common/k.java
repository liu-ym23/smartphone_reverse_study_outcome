package com.bytedance.android.live.effect.common;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k implements Runnable {
    public final /* synthetic */ LiveCommonStickerListAdapter a;
    public final /* synthetic */ LiveCommonStickerListAdapter.StickerViewHolder b;

    public k(LiveCommonStickerListAdapter r1, LiveCommonStickerListAdapter.StickerViewHolder r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Sticker r0 = (Sticker) CollectionsKt.getOrNull(this.a.c, this.b.getAdapterPosition());     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        LiveCommonStickerListAdapter r1 = this.a;     // Catch: Throwable -> L6
        r1.k.a(r1.i, r0, this.b.getAdapterPosition());     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
