package com.obric.assistant.component;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class m5 implements Runnable {
    public final /* synthetic */ OrionChatWindowComponent a;

    public /* synthetic */ m5(OrionChatWindowComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OrionChatWindowComponent r0 = this.a;
        int r1 = OrionChatWindowComponent.T;
        laa.f r2 = (laa.f) r0.t.getValue();
        if (r2 == null) goto L6;
        r2.LE(false);
        return;
    }
}
