package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ LiveStickerDialogV2 a;

    public q(LiveStickerDialogV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Unit r2 = (Unit) r1;
        LiveStickerDialogV2.T90(this.a);
    }
}
