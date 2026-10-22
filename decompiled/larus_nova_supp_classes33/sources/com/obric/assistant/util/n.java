package com.obric.assistant.util;

import com.obric.assistant.component.ObricChatPageStateComponent;
import com.obric.assistant.data.ObricFloatChatPageState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class n implements s {
    public final /* synthetic */ hca.d a;

    @Override // com.obric.assistant.util.s
    public final ObricFloatChatPageState getPageState() {
        return this.a.getPageState();
    }

    public n(ObricChatPageStateComponent r1) {
        this.a = r1;
    }

    @Override // com.obric.assistant.util.s
    public final void a(int r4) {
        this.a.Ns(r4, true, false);
    }
}
