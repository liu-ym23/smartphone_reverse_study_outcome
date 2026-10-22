package com.bytedance.android.live.messagewindow.framework.process.card;

import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends a {
    public final CardPsId e;

    public d() {
        this.e = CardPsId.LogCardRecordsPs;
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
        if (r0 == null) goto L5;
        String r1 = r0.k();
    L6:
        com.bytedance.android.live.room.api.messagewindow.monitor.i r6 = r5.b.monitor();
        if (r6 == null) goto L10;
        CardAlogParamsBuilder r2 = new CardAlogParamsBuilder();
        r2.c(String.valueOf(this.e.name()));
        r2.c(r1);
        Unit r3 = Unit.INSTANCE;
        r6.d(r2.b());
    L10:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r7 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("log_card_records_ps_process");
        r7.c("card_record_info", r1);
        com.bytedance.android.live.room.api.messagewindow.monitor.i r8 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r8 == null) goto L13;
        r8.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r7));
    L13:
        e();
        return;
    L5:
        r1 = null;
        goto L6
    }
}
