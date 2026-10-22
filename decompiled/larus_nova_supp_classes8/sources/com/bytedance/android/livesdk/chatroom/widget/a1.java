package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.ui.LiveStickerSelectDialogFactory;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a1<T> implements Consumer {
    public final /* synthetic */ LiveStickerSelectServiceWidget a;

    public a1(LiveStickerSelectServiceWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        int r0 = LiveStickerSelectDialogFactory.a;
        LiveEffectScene r1 = LiveEffectScene.GiftMenuLive;
        LiveStickerSelectDialogFactory.a(r1, (zg1.d2) r3, new LiveStickerSelectServiceWidget$initJSBEventListener$1$1(this));
    }
}
