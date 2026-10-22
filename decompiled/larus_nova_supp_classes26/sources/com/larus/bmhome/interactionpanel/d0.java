package com.larus.bmhome.interactionpanel;

import com.larus.bmhome.chat.component.cvs.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d0 implements y.a<wc9.e> {
    public final /* synthetic */ MainConversationInteractionPanelHostComponent a;

    public d0(MainConversationInteractionPanelHostComponent r1) {
        this.a = r1;
    }

    public final void c(Object r4) {
        Intrinsics.checkNotNullParameter((wc9.e) r4, "new");
        final MainConversationInteractionPanelHostComponent r5 = this.a;
        int r0 = MainConversationInteractionPanelHostComponent.u;
        final String r2 = "conversationChanged";
        r5.F2().post(new z(r5, r2));
    }
}
