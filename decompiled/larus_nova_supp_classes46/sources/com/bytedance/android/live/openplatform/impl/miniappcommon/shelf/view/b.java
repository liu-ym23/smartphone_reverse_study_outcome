package com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ LinkCastItemViewHolder a;

    public b(LinkCastItemViewHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.b.onClick();
    }
}
