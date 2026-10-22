package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements com.bytedance.android.live.effect.sticker.presenter.o.b {
    public final /* synthetic */ LiveStickerDialogListAdapter a;
    public final /* synthetic */ Sticker b;
    public final /* synthetic */ LiveStickerDialogListAdapter.StickerViewHolder c;

    @Override // com.bytedance.android.live.effect.sticker.presenter.o.b
    public final void a(boolean r3) {
        this.b.setDownloaded(r3);
        LiveStickerDialogListAdapter r4 = this.a;
        Sticker r0 = this.b;
        LiveStickerDialogListAdapter.StickerViewHolder r1 = this.c;
        r4.getClass();
        LiveStickerDialogListAdapter.D2(r0, r1);
    }

    public f(LiveStickerDialogListAdapter r1, Sticker r2, LiveStickerDialogListAdapter.StickerViewHolder r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
