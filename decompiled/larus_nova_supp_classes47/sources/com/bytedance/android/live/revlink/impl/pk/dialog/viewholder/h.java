package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.view.View;
import com.bytedance.android.livesdk.link.model.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ PKBanViewHolder a;
    public final /* synthetic */ u0 b;

    public h(PKBanViewHolder r1, u0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        PKBanViewHolder r4 = this.a;
        x31.s r0 = r4.a;
        if (r0 == null) goto L6;
        r0.rd(r4.getAdapterPosition(), this.b);
        return;
    }
}
