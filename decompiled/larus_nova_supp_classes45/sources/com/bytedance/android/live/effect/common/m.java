package com.bytedance.android.live.effect.common;

import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m implements com.bytedance.android.live.effect.api.l.a {
    public final /* synthetic */ LiveCommonStickerListAdapter a;
    public final /* synthetic */ Sticker b;
    public final /* synthetic */ LiveCommonStickerListAdapter.StickerViewHolder c;

    @Override // com.bytedance.android.live.effect.api.l.a
    public final void a(boolean r3) {
        this.b.setDownloaded(r3);
        this.a.B2(this.b, this.c);
    }

    public m(LiveCommonStickerListAdapter r1, Sticker r2, LiveCommonStickerListAdapter.StickerViewHolder r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
