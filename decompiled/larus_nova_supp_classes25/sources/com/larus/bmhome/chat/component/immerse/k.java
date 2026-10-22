package com.larus.bmhome.chat.component.immerse;

import com.larus.bmhome.chat.component.list.u7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ ImmerseComponent a;

    public /* synthetic */ k(ImmerseComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImmerseComponent r0 = this.a;
        int r1 = ImmerseComponent.t;
        u7 r2 = (u7) r0.m.getValue();
        if (r2 == null) goto L6;
        r2.U1();
        return;
    }
}
