package com.bytedance.android.live.messagewindow.framework.process.card;

import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j extends a {
    public final CardPsId e;

    public j() {
        this.e = CardPsId.SuspendDebounce;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.process.card.a
    public final CardPsId b() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.messagewindow.framework.process.card.a
    public final void d(h71.f.a<com.bytedance.android.live.messagewindow.framework.process.a> r3) {
        Intrinsics.checkNotNullParameter(r3, "chain");
        com.bytedance.android.live.messagewindow.framework.process.a r4 = (com.bytedance.android.live.messagewindow.framework.process.a) ((hm0.a) r3).a;
        d71.d r0 = r4.b.recordManager(r4.c.getPosition());
        if (r0 == null) goto L5;
        boolean r1 = r0.m(r4.c);
    L6:
        if (r1 == false) goto L16;
        com.bytedance.android.live.room.api.messagewindow.monitor.i r5 = r4.b.monitor();
        String r2 = this.e.name() + " process fail, the card is already in waiting list";
        if (r5 == null) goto L11;
        CardAlogParamsBuilder r6 = new CardAlogParamsBuilder();
        r6.c(r2);
        Unit r7 = Unit.INSTANCE;
        r5.d(r6.b());
    L11:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r8 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("suspend_debounce_ps_intercept");
        com.bytedance.android.live.room.api.messagewindow.monitor.i r9 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r9 == null) goto L14;
        r9.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r8));
    L14:
        f(null);
        return;
    L16:
        e();
        return;
    L5:
        r1 = false;
        goto L6
    }
}
