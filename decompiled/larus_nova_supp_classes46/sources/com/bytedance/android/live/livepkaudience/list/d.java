package com.bytedance.android.live.livepkaudience.list;

import android.view.View;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ PkControlViewHolder a;
    public final /* synthetic */ LinkPlayerInfo b;

    public d(PkControlViewHolder r1) {
        this.a = r1;
        this.b = null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        xk0.c r3 = this.a.d;
        if (r3 == null) goto L6;
        r3.a(this.b);
        return;
    }
}
