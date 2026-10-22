package com.bytedance.android.live.liveinteract.linkpanel.list;

import android.view.View;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ FriendsInviteItemBinder a;
    public final /* synthetic */ ILinkPlayerInfoBridge b;

    public h(FriendsInviteItemBinder r1, ILinkPlayerInfoBridge r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.c.invoke(this.b);
    }
}
