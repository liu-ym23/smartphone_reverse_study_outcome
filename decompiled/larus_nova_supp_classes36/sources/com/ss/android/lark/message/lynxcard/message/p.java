package com.ss.android.lark.message.lynxcard.message;

import com.larksuite.component.card.protocol.CardRenderData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class p implements com.ss.android.lark.message.universalcard.datachannel.b {
    public final /* synthetic */ b a;
    public final /* synthetic */ LynxCardViewHolder b;

    @Override // com.ss.android.lark.message.universalcard.datachannel.b
    public final void a(CardRenderData r3) {
        this.a.h(this.b, r3);
    }

    public p(b r1, LynxCardViewHolder r2) {
        this.a = r1;
        this.b = r2;
    }
}
