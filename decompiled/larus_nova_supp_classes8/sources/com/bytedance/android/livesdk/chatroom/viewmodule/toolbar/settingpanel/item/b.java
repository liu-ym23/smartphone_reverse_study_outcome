package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.r3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ LiveSwitchButton a;

    public b(LiveSwitchButton r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        if (r3.l(r1.getContext()) == false) goto L8;
        LiveSwitchButton r2 = this.a;
        if (r2 == null) goto L9;
        r2.performClick();
        return;
    L9:
        return;
    }
}
