package com.bytedance.android.live.messagewindow.framework.process.card;

import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AttachContainerPs extends a {
    public final CardPsId e;

    public AttachContainerPs() {
        this.e = CardPsId.AttachContainer;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.process.card.a
    public final CardPsId b() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.messagewindow.framework.process.card.a
    public final void d(h71.f.a<com.bytedance.android.live.messagewindow.framework.process.a> r5) {
        Intrinsics.checkNotNullParameter(r5, "chain");
        com.bytedance.android.live.messagewindow.framework.process.a r6 = (com.bytedance.android.live.messagewindow.framework.process.a) ((hm0.a) r5).a;
        final v61.a r0 = r6.c;
        w61.a r1 = r6.b.windowContainer(r0.getPosition());
        final d71.d r2 = r6.b.recordManager(r0.getPosition());
        if (r1 == null) goto L5;
        r1.pk(r0, new AttachContainerPs$onProcess$1(this, r2, r0));
        return;
    L5:
        com.bytedance.android.live.room.api.messagewindow.monitor.i r3 = r6.b.monitor();
        if (r3 == null) goto L9;
        CardAlogParamsBuilder r4 = new CardAlogParamsBuilder();
        r4.c(this.e.name() + " process fail");
        IllegalStateException r7 = new IllegalStateException("the IMsgWindowContainer is null");
        Intrinsics.checkNotNullParameter(r7, "tr");
        r4.a = r7;
        Unit r8 = Unit.INSTANCE;
        r3.d(r4.b());
    L9:
        final String r9 = v71.a.g(null);
        final String r10 = v71.a.f(r6.b.getRoomContext(), r6.b.getDataCenter());
        com.bytedance.android.live.room.api.messagewindow.monitor.f r11 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("attach_container_ps_fail_by_null_container");
        r11.b = 1000;
        r11.b(r9);
        r11.c("container_load_msg", r10);
        com.bytedance.android.live.room.api.messagewindow.monitor.i r12 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r12 == null) goto L12;
        r12.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r11));
    L12:
        f(new AttachContainerPs$onProcess$2$2(r9, r10));
    }
}
