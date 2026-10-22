package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab;

import android.widget.PopupWindow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements PopupWindow.OnDismissListener {
    public final /* synthetic */ TabSelectorView a;

    public d(TabSelectorView r1) {
        this.a = r1;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        TabSelectorView r0 = this.a;
        r0.c = false;
        r0.b.setRotation(0.0f);
    }
}
