package com.bytedance.android.livesdk.gamesticker.layoutstrategy;

import com.bytedance.android.livesdk.chatroom.gamestickerv2.GameStickerContext;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerParams;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.TranslationAndScaleProperty;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContainerViewProxy;
import com.bytedance.android.livesdkapi.view.IRenderView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements IRenderView.LayoutListener {
    public final /* synthetic */ e a;

    public f(e r1) {
        this.a = r1;
    }

    public final void onLayoutReady(int r3, int r4, int r5, int r6) {
        GameStickerContext r7 = this.a.a();
        if (r7 == null) goto L5;
        BottomContainerParams r8 = r7.getLandscapeOutputParam();
    L6:
        if (r8 == null) goto L21;
        this.a.b("render view layout finish " + r8);
        e r9 = this.a;
        GameStickerContext r10 = r9.a();
        if (r10 == null) goto L12;
        TranslationAndScaleProperty r11 = r10.getTranslationAndScaleProperty();
        if (r11 == null) goto L12;
        r9.c(r11.getTranslationX(), r11.getTranslationY(), r11.getScaleX(), r11.getScaleY());
    L12:
        IGameStickerContainerViewProxy r12 = this.a.a;
        if (r12 == null) goto L15;
        r12.setMargin(r8.getContainerY(), r8.getContainerX());
    L15:
        IGameStickerContainerViewProxy r13 = this.a.a;
        if (r13 == null) goto L18;
        r13.setSize(r8.getContainerW(), r8.getContainerH());
    L18:
        IGameStickerContainerViewProxy r14 = this.a.a;
        if (r14 == null) goto L28;
        r14.onLayoutFinished();
        return;
    L28:
        return;
    L21:
        this.a.b("render view layout finish hide");
        IGameStickerContainerViewProxy r15 = this.a.a;
        if (r15 == null) goto L24;
        r15.setSize(0, 0);
    L24:
        IGameStickerContainerViewProxy r16 = this.a.a;
        if (r16 == null) goto L30;
        r16.onLayoutFinished();
        return;
    L30:
        return;
    L5:
        r8 = null;
        goto L6
    }
}
