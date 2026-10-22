package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import rx1.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements LiveSwitchButton.e {
    public final /* synthetic */ SmallWindowItem$PartSceneSmallWindowOpt$provide$1.AnonymousClass2.a a;
    public final /* synthetic */ View b;
    public final /* synthetic */ TextView c;
    public final /* synthetic */ LiveSwitchButton d;

    public d(SmallWindowItem$PartSceneSmallWindowOpt$provide$1.AnonymousClass2.a r1, View r2, TextView r3, LiveSwitchButton r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton.e
    public final void d0(LiveSwitchButton r4, boolean r5) {
        if (r5 == true) goto L4;
        e r6 = b6.j;
        r6.getClass();
        f.d(r6, 2);
        com.bytedance.android.livesdk.floatview.mob.a.c("close");
    L9:
        SmallWindowItem.d.a(SmallWindowItem.d.a, this.b, this.c, this.d, r5);
        return;
    L4:
        if (m.e(r4.getContext()) == false) goto L6;
        e r7 = b6.j;
        r7.getClass();
        f.d(r7, 1);
    L7:
        com.bytedance.android.livesdk.floatview.mob.a.c("open");
        goto L9
    L6:
        this.a.a.c.closeSettingPanel();
        m.h(r4.getContext());
        e r8 = b6.j;
        r8.getClass();
        f.d(r8, 1);
        goto L7
    }
}
