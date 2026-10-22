package com.bytedance.android.livesdk.gamesticker.layoutstrategy;

import com.bytedance.android.livesdk.chatroom.gamestickerv2.GameStickerContext;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.TranslationAndScaleProperty;
import com.bytedance.android.livesdkapi.view.IRenderView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements IRenderView.TranslationAndScaleListener {
    public final /* synthetic */ LiveFoldScreenLandscapeLayoutStrategy a;

    public d(LiveFoldScreenLandscapeLayoutStrategy r1) {
        this.a = r1;
    }

    public final void onTranslationAndScaleChange(float r3, float r4, float r5, float r6) {
        this.a.d(r3, r4, r5, r6);
        LiveFoldScreenLandscapeLayoutStrategy r0 = this.a;
        GameStickerContext r1 = r0.b();
        if (r1 == null) goto L5;
        TranslationAndScaleProperty r2 = r1.getTranslationAndScaleProperty();
    L6:
        if (r2 != null) goto L8;
        r2 = new TranslationAndScaleProperty();
    L8:
        r2.setTranslationX(r3);
        r2.setTranslationY(r4);
        r2.setScaleX(r5);
        r2.setScaleY(r6);
        GameStickerContext r7 = r0.b();
        if (r7 == null) goto L12;
        r7.setTranslationAndScaleProperty(r2);
        return;
    L12:
        return;
    L5:
        r2 = null;
        goto L6
    }
}
