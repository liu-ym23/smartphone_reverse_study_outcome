package com.bytedance.android.live.messagewindow.framework.process.card;

import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class HideCardPs extends a {
    public final CardPsId e;

    public HideCardPs() {
        this.e = CardPsId.HideCard;
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
        final d71.d r1 = r6.b.recordManager(r6.c.getPosition());
        if (r0 == null) goto L5;
        r0.yc(r6.c, false, new HideCardPs$onProcess$1(this, r1, r6));
        return;
    L5:
        com.bytedance.android.live.room.api.messagewindow.monitor.i r2 = r6.b.monitor();
        if (r2 == null) goto L9;
        CardAlogParamsBuilder r3 = new CardAlogParamsBuilder();
        r3.c(this.e.name() + " process fail");
        IllegalStateException r4 = new IllegalStateException("the IMsgWindowContainer is null");
        Intrinsics.checkNotNullParameter(r4, "tr");
        r3.a = r4;
        Unit r7 = Unit.INSTANCE;
        r2.d(r3.b());
    L9:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r8 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("hide_card_ps_fail_by_null_container");
        r8.b = 1000;
        com.bytedance.android.live.room.api.messagewindow.monitor.i r9 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r9 == null) goto L12;
        r9.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r8));
    L12:
        f(new HideCardPs$onProcess$$inlined$run$lambda$1(this, r6));
    }
}
