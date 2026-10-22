package com.bytedance.android.live.messagewindow.framework.process.card;

import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class TransitionAnimPs extends a {
    public final CardPsId e;
    public final boolean f;

    @Override // com.bytedance.android.live.messagewindow.framework.process.card.a
    public final CardPsId b() {
        return this.e;
    }

    public TransitionAnimPs(boolean r1) {
        this.f = r1;
        this.e = CardPsId.TransitionAnim;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.messagewindow.framework.process.card.a
    public final void d(h71.f.a<com.bytedance.android.live.messagewindow.framework.process.a> r5) {
        Intrinsics.checkNotNullParameter(r5, "chain");
        final com.bytedance.android.live.messagewindow.framework.process.a r6 = (com.bytedance.android.live.messagewindow.framework.process.a) ((hm0.a) r5).a;
        final v61.a r0 = r6.c;
        w61.a r1 = r6.b.windowContainer(r0.getPosition());
        if (r1 == null) goto L5;
        r1.Wi(r0, r6.c.b(), this.f, new TransitionAnimPs$onProcess$1(this, r0));
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
        com.bytedance.android.live.room.api.messagewindow.monitor.f r8 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("transition_anim_ps_fail_by_null_container");
        r8.c("isEnter", Boolean.valueOf(this.f));
        com.bytedance.android.live.room.api.messagewindow.monitor.i r9 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r9 == null) goto L12;
        r9.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r8));
    L12:
        f(new TransitionAnimPs$onProcess$$inlined$run$lambda$1(this, r6));
    }
}
