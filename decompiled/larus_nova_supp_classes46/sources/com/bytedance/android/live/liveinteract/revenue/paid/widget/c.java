package com.bytedance.android.live.liveinteract.revenue.paid.widget;

import cj0.k;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ BasePaidLinkMicWidget a;

    public c(BasePaidLinkMicWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        k r3 = (k) r2;
        if (r3 == null) goto L6;
        this.a.wq(r3);
        return;
    }
}
