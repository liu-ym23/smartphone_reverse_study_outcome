package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h extends b7.a {
    public final /* synthetic */ ChatRoomPanelLynxItemVH a;

    public h(ChatRoomPanelLynxItemVH r1) {
        this.a = r1;
    }

    public final void onLoadSuccess(View r4) {
        super.onLoadSuccess(r4);
        FrameLayout r5 = this.a.a;
        if (r5 == null) goto L5;
        int r6 = r5.getChildCount();
    L6:
        if (r6 <= 0) goto L19;
        FrameLayout r7 = this.a.a;
        View r1 = null;
        if (r7 == null) goto L10;
        View r8 = r7.getChildAt(0);
    L12:
        if ((r8 instanceof ViewGroup) == false) goto L15;
        r1 = r8;
    L15:
        ViewGroup r2 = (ViewGroup) r1;
        if (r2 == null) goto L20;
        r2.setClipChildren(false);
        return;
    L20:
        return;
    L10:
        r8 = null;
        goto L12
    L19:
        return;
    L5:
        r6 = 0;
        goto L6
    }
}
