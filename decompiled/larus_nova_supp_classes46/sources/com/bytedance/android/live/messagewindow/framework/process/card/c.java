package com.bytedance.android.live.messagewindow.framework.process.card;

import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends a {
    public final CardPsId e;

    public c() {
        this.e = CardPsId.DismissDebounce;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.process.card.a
    public final CardPsId b() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.messagewindow.framework.process.card.a
    public final void d(h71.f.a<com.bytedance.android.live.messagewindow.framework.process.a> r4) {
        Intrinsics.checkNotNullParameter(r4, "chain");
        com.bytedance.android.live.messagewindow.framework.process.a r5 = (com.bytedance.android.live.messagewindow.framework.process.a) ((hm0.a) r4).a;
        v61.a r0 = r5.c;
        d71.d r1 = r5.b.recordManager(r0.getPosition());
        if (r1 == null) goto L5;
        boolean r2 = r1.g(r0);
    L6:
        if (r2 == true) goto L16;
        com.bytedance.android.live.room.api.messagewindow.monitor.i r6 = r5.b.monitor();
        String r3 = this.e.name() + " process fail, the card is not in records";
        if (r6 == null) goto L11;
        CardAlogParamsBuilder r7 = new CardAlogParamsBuilder();
        r7.c(r3);
        Unit r8 = Unit.INSTANCE;
        r6.d(r7.b());
    L11:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r9 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("dismiss_debounce_ps_intercept");
        com.bytedance.android.live.room.api.messagewindow.monitor.i r10 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r10 == null) goto L14;
        r10.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r9));
    L14:
        f(null);
        return;
    L16:
        e();
        return;
    L5:
        r2 = false;
        goto L6
    }
}
