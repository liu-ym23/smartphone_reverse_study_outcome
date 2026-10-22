package com.larus.business.floatchat.impl.component;

import com.larus.bmhome.view.ChatConstraintLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class p implements Runnable {
    public final /* synthetic */ AIFloatChatComponent a;
    public final /* synthetic */ ChatConstraintLayout b;

    public /* synthetic */ p(AIFloatChatComponent r1, ChatConstraintLayout r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AIFloatChatComponent r0 = this.a;
        ChatConstraintLayout r1 = this.b;
        int r2 = AIFloatChatComponent.o;
        r0.F2(r1);
    }
}
