package com.bytedance.android.live.liveinteract.linkpanel.list;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ InviteMoreFriendItemBinder a;

    public m(InviteMoreFriendItemBinder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.b.invoke();
    }
}
