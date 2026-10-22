package com.bytedance.android.live.room.navi.tetris;

import android.os.Bundle;
import android.view.View;
import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Unit;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ AnchorRoomNavigatorTetris a;

    public a(AnchorRoomNavigatorTetris r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        LivePopupWindow r6 = this.a.w;
        if (r6 != null) goto L5;
    L15:
        h1 r7 = new h1(6);
        Bundle r0 = new Bundle();
        r0.putLong(Constants.OperatorKey.KEY_COST_TIME, System.currentTimeMillis());
        r0.putString("action_type", "click");
        Unit r1 = Unit.INSTANCE;
        r7.d = r0;
        xs2.b.a().post(r7);
        return;
    L5:
        if (r6.isShowing() == true) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == true) goto L13;
        r6 = null;
    L13:
        if (r6 == null) goto L15;
        PopupWindowLancet.handleDismissBeforeOrigin(r6);
        r6.dismiss();
        goto L15
    L7:
        if (this.a.W() == false) goto L9;
        r2 = true;
        goto L10
    }
}
