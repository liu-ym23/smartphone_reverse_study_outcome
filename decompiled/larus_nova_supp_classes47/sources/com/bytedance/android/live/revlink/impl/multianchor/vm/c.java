package com.bytedance.android.live.revlink.impl.multianchor.vm;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.MultiAnchorPkLaunchContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.live.datacontext.k;
import io.reactivex.functions.Consumer;
import java.util.HashSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ LinkingInvitePreloadUtils a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;

    public c(LinkingInvitePreloadUtils r1, int r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r8) {
        ExtraResponse r9 = (ExtraResponse) r8;
        v r0 = this.a.d();
        if (r0 == null) goto L5;
        r0.p("preload", this.b, t.a(this.c));
    L5:
        LinkingInvitePreloadUtils r1 = this.a;
        r1.d = false;
        r1.e = 0;
        ((HashSet) r1.j.getValue()).clear();
        if (r9 == null) goto L18;
        IRivalRankRecommendResponse r2 = (IRivalRankRecommendResponse) r9.data;
        if (r2 == null) goto L19;
        int r3 = this.b;
        long r4 = this.c;
        i97.a r5 = i97.a.a;
        h r10 = new h(r2, r3, r4, System.currentTimeMillis());
        LinkingInvitePreloadUtils r6 = this.a;
        r6.f = r10;
        com.bytedance.android.live.revlink.impl.global.c r7 = r6.l;
        if (r7 == null) goto L12;
        MultiAnchorPkLaunchContext r12 = r7.Ib();
    L13:
        if (r12 == null) goto L20;
        k<h> r13 = r12.getPreloadCompleteEvent();
        if (r13 == null) goto L21;
        r13.post(r10);
        return;
    L21:
        return;
    L20:
        return;
    L12:
        r12 = null;
        goto L13
    L19:
        return;
    }
}
