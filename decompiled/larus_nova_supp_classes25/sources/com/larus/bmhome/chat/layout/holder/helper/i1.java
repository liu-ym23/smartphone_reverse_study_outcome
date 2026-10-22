package com.larus.bmhome.chat.layout.holder.helper;

import com.larus.bmhome.view.MessageMenu;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class i1 implements Runnable {
    public final /* synthetic */ MessageMenu a;

    public /* synthetic */ i1(MessageMenu r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MessageMenu r0 = this.a;
        if (r0 == null) goto L6;
        r0.w = true;
        MessageMenu.c(r0, true, false, true, 2);
        return;
    }
}
