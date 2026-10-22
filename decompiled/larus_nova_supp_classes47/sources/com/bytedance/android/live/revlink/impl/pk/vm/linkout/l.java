package com.bytedance.android.live.revlink.impl.pk.vm.linkout;

import com.bytedance.android.live.revlink.impl.pk.service.ToolBarPic;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l<T> implements Observer {
    public final /* synthetic */ PkAutoMatchManager a;

    public l(PkAutoMatchManager r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Long r6 = (Long) r5;
        if (r6 == null) goto L28;
        long r0 = r6.longValue();
        if (1 <= r0) goto L8;
    L21:
        com.bytedance.android.live.revlink.impl.pk.service.i r7 = PkAutoMatchManager.g(this.a);
        if (r7 == null) goto L24;
        r7.setText("");
    L24:
        com.bytedance.android.live.revlink.impl.pk.service.i r8 = PkAutoMatchManager.g(this.a);
        if (r8 == null) goto L31;
        r8.Z2(this.a.f);
        return;
    L31:
        return;
    L8:
        if (59 < r0) goto L21;
        com.bytedance.android.live.revlink.impl.pk.service.i r9 = PkAutoMatchManager.g(this.a);
        if (r9 == null) goto L12;
        r9.V2();
    L12:
        com.bytedance.android.live.revlink.impl.pk.service.i r10 = PkAutoMatchManager.g(this.a);
        if (r10 == null) goto L15;
        r10.R2(ToolBarPic.NONE);
    L15:
        com.bytedance.android.live.revlink.impl.pk.service.i r12 = PkAutoMatchManager.g(this.a);
        if (r12 == null) goto L18;
        r12.setText(String.valueOf(r0));
    L18:
        com.bytedance.android.live.revlink.impl.pk.service.i r13 = PkAutoMatchManager.g(this.a);
        if (r13 == null) goto L29;
        r13.i3();
        return;
    L29:
        return;
    }
}
