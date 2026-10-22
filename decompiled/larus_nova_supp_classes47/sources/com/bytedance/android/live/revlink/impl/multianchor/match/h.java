package com.bytedance.android.live.revlink.impl.multianchor.match;

import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.livesdk.link.model.w1;
import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ g a;
    public final /* synthetic */ w1 b;

    public h(g r1, w1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        jy0.b.c("ttlive_anchor_link_match", "passive waiting time out, " + this.a.h(), null, 4);
        c r6 = this.a.h();
        r6.getClass();
        if ((r6 instanceof c.d) == false) goto L17;
        int r7 = ToastUtil.a;
        int r8 = w11.a.a;
        ToastUtil.a(2131921528, 1);
        f r9 = this.a.j();
        if (r9 == null) goto L7;
        r9.g(this.a.h().b, this.a.h().c);
    L7:
        f r10 = this.a.j();
        if (r10 == null) goto L10;
        r10.h(this.a.h().b, AutoMatchSource.MaxWaitTimeOut);
    L10:
        Iterator<g.b> r12 = this.a.f.iterator();
    L12:
        if (r12.hasNext() == false) goto L14;
        r12.next().no(this.b);
        goto L12
    L14:
        g.p(this.a, 2, "passiveTimeout");
        return;
    }
}
