package com.bytedance.android.livesdk.commonpop;

import android.view.View;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends b7.a {
    public final /* synthetic */ CommonPopupMessageWidget a;

    public d(CommonPopupMessageWidget r1) {
        this.a = r1;
    }

    public final void onLoadSuccess(View r4) {
        super.onLoadSuccess(r4);
        CommonPopupMessageWidget r0 = this.a;
        int r1 = CommonPopupMessageWidget.g;
        if (r0.isViewValid() == false) goto L17;
        if (r4 == null) goto L21;
        ((Widget) r0).contentView.setVisibility(0);
        r4.setVisibility(0);
        if (k.f(IGiftServiceExternal.class) == null) goto L9;
        k.n(IGiftServiceExternal.class).toggleVideoGiftView(false);
    L9:
        RoomContext r5 = com.bytedance.live.datacontext.d.e(Integer.valueOf(((Widget) r0).dataCenter.hashCode()), RoomContext.class);
        if (r5 == null) goto L18;
        m r6 = r5.getCommonPopupModel();
        if (r6 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.viewmodel.b r7 = (com.bytedance.android.livesdk.chatroom.viewmodel.b) r6.getValue();
        if (r7 == null) goto L20;
        r7.a = true;
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L21:
        return;
    }
}
