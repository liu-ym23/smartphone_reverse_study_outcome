package com.bytedance.android.live.revlink.impl.pk.ui;

import android.view.View;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.NextLiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ g a;

    public c(g r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        gt1.d r13 = gt1.e.a(1, Boolean.FALSE, false, false, false, false, 0, false, false, null, 2044);
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L7;
        NextLiveData r1 = r0.Y1();
        if (r1 == null) goto L7;
        r1.setValue(r13);
    L7:
        wq2.f r2 = ma1.a.a();
        if (r2 == null) goto L10;
        r2.S1(r13);
    L10:
        IRoom r14 = this.a.b;
        com.bytedance.android.live.revlink.impl.global.b.j();
        h41.g.c("end");
        h41.g.a("pk_room");
        if (this.a.a(2131383716).isChecked() == false) goto L13;
        l51.a.h0.setValue(null, l51.a.a[69], 1);
    L13:
        IPKLinkBizDataService r15 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r15 == null) goto L17;
        r15.setIsRandomReMatch(false);
        return;
    }
}
