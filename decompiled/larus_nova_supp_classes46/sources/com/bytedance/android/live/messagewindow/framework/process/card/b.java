package com.bytedance.android.live.messagewindow.framework.process.card;

import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends a {
    public final CardPsId e;

    public b() {
        this.e = CardPsId.CardStart;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.process.card.a
    public final CardPsId b() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.messagewindow.framework.process.card.a
    public final void d(h71.f.a<com.bytedance.android.live.messagewindow.framework.process.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "chain");
        ((com.bytedance.android.live.messagewindow.framework.process.a) ((hm0.a) r2).a).c.n(ICardLifecycle.State.Started);
        e();
    }
}
