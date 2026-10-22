package com.bytedance.android.live.effect.sticker.ui;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n implements StickerFavoriteImageView.b {
    public final /* synthetic */ StickerFavoriteView a;

    @Override // com.bytedance.android.live.effect.sticker.ui.StickerFavoriteImageView.b
    public final void onAnimationEnd() {
        StickerFavoriteView.a r0 = this.a.getFavoriteStatusListener();
        if (r0 == null) goto L5;
        StickerFavoriteView r1 = this.a;
        r0.a(r1.g, r1.f);
    L5:
        StickerFavoriteView r2 = this.a;
        r2.h = true;
        if (r2.m == false) goto L9;
        r2.m = false;
        r2.e(r2.k, r2.l);
        return;
    }

    public n(StickerFavoriteView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.sticker.ui.StickerFavoriteImageView.b
    public final void onStateChange(int r2) {
        if (r2 != 1) goto L6;
        StickerFavoriteView.a(this.a).setSelected(this.a.f);
        return;
    }
}
