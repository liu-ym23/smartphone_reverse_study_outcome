package com.bytedance.android.live.messagewindow.framework.process.card;

import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class ShowDebouncePs extends a {
    public final CardPsId e;

    public ShowDebouncePs() {
        this.e = CardPsId.ShowDebounce;
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
        d71.d r0 = r5.b.recordManager(r5.c.getPosition());
        if (r0 != null) goto L5;
    L14:
        if (r0 == null) goto L16;
        r0.i(r5.c);
    L16:
        e();
        return;
    L5:
        if (r0.c(r5.c) != true) goto L14;
        com.bytedance.android.live.room.api.messagewindow.monitor.i r6 = r5.b.monitor();
        String r1 = this.e.name() + " process fail, the card is showing now";
        if (r6 == null) goto L10;
        CardAlogParamsBuilder r2 = new CardAlogParamsBuilder();
        r2.c(r1);
        Unit r3 = Unit.INSTANCE;
        r6.d(r2.b());
    L10:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r7 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("show_debounce_ps_intercept");
        com.bytedance.android.live.room.api.messagewindow.monitor.i r8 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r8 == null) goto L13;
        r8.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r7));
    L13:
        f(ShowDebouncePs$onProcess$2.INSTANCE);
    }
}
