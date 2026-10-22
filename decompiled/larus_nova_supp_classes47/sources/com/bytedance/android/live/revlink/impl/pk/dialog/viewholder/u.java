package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import y31.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u implements View.OnClickListener {
    public final /* synthetic */ ReserveTabViewHolder a;
    public final /* synthetic */ w.a b;

    public u(ReserveTabViewHolder r1, w.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        w.a r4 = this.a.a;
        if (r4 == null) goto L13;
        y31.b r0 = r4.c;
        if (r0 == null) goto L13;
        if (r4 == null) goto L8;
        int r5 = r4.b;
    L9:
        String r1 = this.b.a;
        if (r1 != null) goto L12;
        r1 = "";
    L12:
        r0.K(r5, r1);
        goto L13
    L8:
        r5 = 0;
    L13:
        TextView r6 = this.a.b;
        if (r6 == null) goto L16;
        r6.setBackground(s1.m(2131252606));
    L16:
        TextView r7 = this.a.b;
        if (r7 == null) goto L20;
        r7.setTextColor(s1.h(2131100641));
        return;
    }
}
