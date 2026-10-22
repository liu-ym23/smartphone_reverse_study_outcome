package com.larus.bmhome.interactionpanel;

import com.larus.bmhome.chat.component.cvs.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u0 implements y.a<wc9.e> {
    public final /* synthetic */ MainConversationInteractionPanelMessageSourceComponent a;

    public u0(MainConversationInteractionPanelMessageSourceComponent r1) {
        this.a = r1;
    }

    public final void c(Object r3) {
        Intrinsics.checkNotNullParameter((wc9.e) r3, "new");
        MainConversationInteractionPanelMessageSourceComponent.C3(this.a, "conversationChanged", null);
    }
}
