package com.bytedance.android.live.room.navi.tetris;

import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ AnchorRoomNavigatorTetris a;

    public e(AnchorRoomNavigatorTetris r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        if (this.a.W() == false) goto L8;
        LivePopupWindow r3 = this.a.w;
        if (r3 == null) goto L9;
        PopupWindowLancet.handleDismissBeforeOrigin(r3);
        r3.dismiss();
        return;
    L9:
        return;
    }
}
