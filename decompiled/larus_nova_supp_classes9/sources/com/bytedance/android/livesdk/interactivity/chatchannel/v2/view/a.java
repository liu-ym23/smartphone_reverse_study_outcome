package com.bytedance.android.livesdk.interactivity.chatchannel.v2.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ ChannelTrayListViewBinder.ItemViewHolder a;
    public final /* synthetic */ p62.a b;

    public a(ChannelTrayListViewBinder.ItemViewHolder r1, p62.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.j.a(this.b);
    }
}
