package com.bytedance.android.live.revlink.impl.pk.vm.linkout;

import com.bytedance.android.live.revlink.impl.pk.service.RingDrawable;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ PkAutoMatchManager a;

    public k(PkAutoMatchManager r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        l41.a r3 = (l41.a) r2;
        if (Intrinsics.areEqual(r3, l41.a.b.a) == false) goto L8;
        com.bytedance.android.live.revlink.impl.pk.service.i r4 = PkAutoMatchManager.g(this.a);
        if (r4 == null) goto L13;
        r4.P2(RingDrawable.ttlive_ic_pk_random_normal_circle);
        return;
    L13:
        return;
    L8:
        if (Intrinsics.areEqual(r3, l41.a.C0265a.a) == false) goto L15;
        com.bytedance.android.live.revlink.impl.pk.service.i r5 = PkAutoMatchManager.g(this.a);
        if (r5 == null) goto L16;
        r5.n3(true);
        return;
    L16:
        return;
    }
}
