package com.bytedance.android.live.liveinteract.linkpanel.list;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.utils.s0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ FriendsItemBinderHorizontal.ViewHolder a;
    public final /* synthetic */ FriendsItemBinderHorizontal b;
    public final /* synthetic */ ILinkPlayerInfoBridge c;

    public k(FriendsItemBinderHorizontal.ViewHolder r1, FriendsItemBinderHorizontal r2, ILinkPlayerInfoBridge r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        final FriendsItemBinderHorizontal r5 = this.b;
        Context r0 = ((RecyclerView.ViewHolder) this.a).itemView.getContext();
        final ILinkPlayerInfoBridge r1 = this.c;
        r5.getClass();
        s0.a(r0, new FriendsItemBinderHorizontal$tryInvite$1(r5, r1));
    }
}
