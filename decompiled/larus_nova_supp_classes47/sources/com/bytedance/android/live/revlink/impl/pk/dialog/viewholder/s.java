package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.view.View;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.livesdk.link.model.x8;
import gd0.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s implements View.OnClickListener {
    public final /* synthetic */ PKRivalsSearchViewHolder a;
    public final /* synthetic */ int b;
    public final /* synthetic */ x8 c;

    public s(PKRivalsSearchViewHolder r1, x8 r2) {
        this.a = r1;
        this.b = 5;
        this.c = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        com.bytedance.android.live.revlink.impl.service.internal.a r7 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r7 != null) goto L6;
        return;
    L6:
        if (v.a(r7.getCurrentMode(), 64) == false) goto L17;
        w r8 = com.bytedance.android.live.revlink.impl.global.b.D();
        if (r8 == null) goto L10;
        int r9 = r8.h();
    L12:
        if (r9 < r41.f.b) goto L15;
        ToastUtil.a(2131920506, 0);
        return;
    L15:
        this.a.q.Ko(this.b, this.c);
        return;
    L10:
        r9 = 0;
        goto L12
    L17:
        if (this.c.getLinkStatus() != 1) goto L20;
        ToastUtil.a(2131917935, 0);
        return;
    L20:
        if (this.c.getLinkStatus() != 2) goto L22;
        ToastUtil.a(2131917943, 0);
        return;
    L22:
        PKRivalsSearchViewHolder r10 = this.a;
        String r1 = this.c.getUserId();
        int r2 = PKRivalsSearchViewHolder.r;
        if (r10.T3(r1) == false) goto L25;
        this.a.q.jm(this.c, 0);
        return;
    L25:
        this.a.q.Ko(this.b, this.c);
    }
}
