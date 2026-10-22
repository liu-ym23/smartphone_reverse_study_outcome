package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import com.bytedance.android.livesdk.link.model.c3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h extends a {
    public final /* synthetic */ FeedPkMachinePresenter a;

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.machine.d
    public final void onFailed() {
        FeedPkMachinePresenter r0 = this.a;
        r0.getClass();
        l r1 = r0.j.getState();
        if ((r1 instanceof l.c) == false) goto L5;
        r0.i(new e.f(new x(FeedPkMachinePresenter.b(((l.c) r1).c.e, null, 0), null)));
    L5:
        FeedPkMachinePresenter.a(this.a, null);
    }

    public h(FeedPkMachinePresenter r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.machine.d
    public final void a(c3 r1, com.bytedance.android.livesdk.link.model.r.b r2) {
        Intrinsics.checkNotNullParameter(r1, "battleStatsMeta");
        FeedPkMachinePresenter.a(this.a, r1);
    }
}
