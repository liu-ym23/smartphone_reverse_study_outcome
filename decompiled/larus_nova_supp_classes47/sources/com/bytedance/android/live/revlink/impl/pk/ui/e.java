package com.bytedance.android.live.revlink.impl.pk.ui;

import android.view.View;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.NextLiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ g a;

    public e(g r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        i41.a r13 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r13 == null) goto L5;
        r13.b(AutoMatchSource.Manual);
    L5:
        IPKLinkBizDataService r14 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r14 == null) goto L9;
        r14.setIsRandomReMatch(false);
    L9:
        if (com.bytedance.android.live.revlink.impl.global.b.O() == null) goto L11;
        com.bytedance.android.live.revlink.impl.pk.utils.j.f();
    L11:
        gt1.d r15 = gt1.e.a(1, Boolean.FALSE, false, false, false, false, 0, false, false, null, 2044);
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L16;
        NextLiveData r1 = r0.Y1();
        if (r1 == null) goto L16;
        r1.setValue(r15);
    L16:
        wq2.f r2 = ma1.a.a();
        if (r2 == null) goto L19;
        r2.S1(r15);
    L19:
        IRoom r16 = this.a.b;
        com.bytedance.android.live.revlink.impl.global.b.j();
        h41.g.c("end");
        h41.g.a("pk_room");
    }
}
