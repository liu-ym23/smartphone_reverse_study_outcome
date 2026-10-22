package com.bytedance.android.live.messagewindow.framework.process.card;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class NotifyCardShowPs extends a {
    public final CardPsId e;

    public NotifyCardShowPs() {
        this.e = CardPsId.NotifyCardShow;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.process.card.a
    public final CardPsId b() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.messagewindow.framework.process.card.a
    public final void d(h71.f.a<com.bytedance.android.live.messagewindow.framework.process.a> r6) {
        Intrinsics.checkNotNullParameter(r6, "chain");
        com.bytedance.android.live.messagewindow.framework.process.a r7 = (com.bytedance.android.live.messagewindow.framework.process.a) ((hm0.a) r6).a;
        d71.d r0 = r7.b.recordManager(r7.c.getPosition());
        i71.a r1 = r7.b.scheduler();
        e();
        if (r0 == null) goto L13;
        final d71.b r2 = r0.f();
        if (r2 == null) goto L14;
        com.bytedance.android.live.room.api.messagewindow.monitor.f r3 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("notify_card_show_process");
        String r8 = "通知 " + ((d71.e) r2).b.j + " 展示 by " + r7.c.j;
        Intrinsics.checkNotNullParameter(r8, "info");
        r3.c = r8;
        com.bytedance.android.live.room.api.messagewindow.monitor.i r9 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r9 == null) goto L9;
        r9.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r3));
    L9:
        r2.a();
        if (r1 == null) goto L15;
        r1.execute(new NotifyCardShowPs$onProcess$1$1(r2));
        return;
    L15:
        return;
    L14:
        return;
    }
}
