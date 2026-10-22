package com.bytedance.android.live.messagewindow.framework.process.card;

import com.bytedance.android.live.messagewindow.framework.ability.CardAbilityPlatformImpl;
import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle;
import com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i extends a {
    public final CardPsId e;

    public i() {
        this.e = CardPsId.PrepareAbility;
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
        if (r0.c == true) goto L14;
        r61.a r1 = k.n(IMiddlewareMsgWindowService.class).cardAbilityImpl(r0);
        if (r1 != null) goto L7;
        r1 = new CardAbilityPlatformImpl(r0);
    L7:
        r1.g(r5.b.getRoomContext(), r5.b.getDataCenter());
        Intrinsics.checkNotNullParameter(r1, "abilityImpl");
        s61.a r2 = r0.l;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "abilityImpl");
        if (r2.a != null) goto L10;
        r2.a = r1;
    L10:
        r61.a r6 = r2.a;
        if (r6 == null) goto L13;
        r6.g(r1.getRoomContext(), r1.getDataCenter());
    L13:
        r0.c = true;
    L14:
        ICardLifecycle.State r7 = r0.A();
        ICardLifecycle.State r3 = ICardLifecycle.State.Created;
        if (r7.isAtLeast(r3) == true) goto L17;
        r0.n(r3);
    L17:
        e();
    }
}
