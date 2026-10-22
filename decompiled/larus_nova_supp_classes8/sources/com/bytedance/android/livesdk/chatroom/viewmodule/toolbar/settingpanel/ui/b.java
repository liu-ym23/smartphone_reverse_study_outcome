package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.ui;

import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import np1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements LiveSwitchButton.e {
    public final /* synthetic */ OptionNormalView a;
    public final /* synthetic */ f b;

    public b(OptionNormalView r1, f r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton.e
    public final void d0(LiveSwitchButton r2, boolean r3) {
        this.b.d.a(Boolean.valueOf(r3));
        OptionNormalView r4 = this.a;
        int r0 = OptionNormalView.f;
        r4.R5(r3);
    }
}
