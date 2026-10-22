package com.bytedance.android.live.messagewindow.framework.process.card;

import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class DetachContainerPs extends a {
    public static final /* synthetic */ int f = 0;
    public final CardPsId e;

    public DetachContainerPs() {
        this.e = CardPsId.DetachContainer;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.process.card.a
    public final CardPsId b() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.messagewindow.framework.process.card.a
    public final void d(h71.f.a<com.bytedance.android.live.messagewindow.framework.process.a> r5) {
        Intrinsics.checkNotNullParameter(r5, "chain");
        final com.bytedance.android.live.messagewindow.framework.process.a r6 = (com.bytedance.android.live.messagewindow.framework.process.a) ((hm0.a) r5).a;
        w61.a r0 = r6.b.windowContainer(r6.c.getPosition());
        if (r0 == null) goto L5;
        r0.Fb(r6.c, new DetachContainerPs$onProcess$1(this, r6));
        return;
    L5:
        com.bytedance.android.live.room.api.messagewindow.monitor.i r1 = r6.b.monitor();
        if (r1 == null) goto L9;
        CardAlogParamsBuilder r2 = new CardAlogParamsBuilder();
        r2.c(this.e.name() + " process fail");
        IllegalStateException r3 = new IllegalStateException("the IMsgWindowContainer is null");
        Intrinsics.checkNotNullParameter(r3, "tr");
        r2.a = r3;
        Unit r4 = Unit.INSTANCE;
        r1.d(r2.b());
    L9:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r7 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("detach_container_ps_fail_by_null_container");
        r7.b = 1000;
        com.bytedance.android.live.room.api.messagewindow.monitor.i r8 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r8 == null) goto L12;
        r8.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r7));
    L12:
        f(new DetachContainerPs$onProcess$$inlined$run$lambda$1(this, r6));
    }
}
