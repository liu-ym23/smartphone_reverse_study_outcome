package com.bytedance.android.live.revlink.impl.pk.ui;

import android.view.View;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.ies.sdk.widgets.NextLiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        i41.a r13 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r13 == null) goto L5;
        r13.b(AutoMatchSource.Manual);
    L5:
        this.a.getLogger().getClass();
        h41.g.c("end");
        this.a.getLogger().getClass();
        h41.g.a("pk_room");
        if (com.bytedance.android.live.revlink.impl.global.b.O() == null) goto L8;
        com.bytedance.android.live.revlink.impl.pk.utils.j.f();
    L8:
        gt1.d r14 = gt1.e.a(1, Boolean.FALSE, false, false, false, false, 0, false, false, null, 2044);
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L13;
        NextLiveData r1 = r0.Y1();
        if (r1 == null) goto L13;
        r1.setValue(r14);
    L13:
        wq2.f r2 = ma1.a.a();
        if (r2 == null) goto L16;
        r2.S1(r14);
    L16:
        IPKLinkBizDataService r15 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r15 == null) goto L20;
        r15.setIsRandomReMatch(false);
        return;
    }
}
