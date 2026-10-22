package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.view.View;
import com.bytedance.android.live.liveinteract.linkpanel.fragment.TalkRoomSearchFragment;
import com.bytedance.android.live.liveinteract.linkpanel.fragment.n0;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ LinkInviteListWidget a;

    public m(LinkInviteListWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        LinkInviteListWidget r5 = this.a;
        int r0 = LinkInviteListWidget.R;
        yf0.g r1 = r5.a;
        if (r1 == null) goto L5;
        int r2 = TalkRoomSearchFragment.t;
        int r6 = r5.L;
        TalkRoomSearchFragment r3 = new TalkRoomSearchFragment();
        r3.i = new n0(r3);
        r3.d = r1;
        r3.g = 1;
        r3.h = r6;
        r1.Rh(r3);
    L5:
        com.bytedance.android.live.liveinteract.linkpanel.util.m.r("invite", 0, ((ArrayList) this.a.z).size(), ((ArrayList) this.a.A).size());
    }
}
