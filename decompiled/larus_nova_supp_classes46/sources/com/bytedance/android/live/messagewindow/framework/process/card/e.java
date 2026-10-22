package com.bytedance.android.live.messagewindow.framework.process.card;

import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e extends a {
    public final CardPsId e;

    public e() {
        this.e = CardPsId.MarkEnd;
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
        com.bytedance.android.live.room.api.messagewindow.monitor.i r0 = r6.b.monitor();
        if (r0 == null) goto L10;
        CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();
        StringBuilder r2 = new StringBuilder("—————— 卡片 ");
        r2.append(r6.c.j);
        r2.append(' ');
        im0.a r3 = r6.a;
        if (r3 == null) goto L8;
        j71.a r4 = r3.c;
    L9:
        r2.append(r4);
        r2.append(" 流程处理完毕——————");
        r1.c(r2.toString());
        Unit r7 = Unit.INSTANCE;
        r0.d(r1.b());
        goto L10
    L8:
        r4 = null;
    L10:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r8 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("mark_end_ps_action_end");
        com.bytedance.android.live.room.api.messagewindow.monitor.i r9 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r9 == null) goto L14;
        r9.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r8));
    L14:
        if ((r6.a instanceof im0.b) == false) goto L18;
        if (r0 == null) goto L18;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r10 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_msg_card_dismiss_success");
        r10.b("card_id", r6.c.j);
        Unit r11 = Unit.INSTANCE;
        r0.b(r10.a());
    L18:
        im0.a r12 = r6.a;
        if (r12 == null) goto L22;
        r12.a(3);
        return;
    }
}
