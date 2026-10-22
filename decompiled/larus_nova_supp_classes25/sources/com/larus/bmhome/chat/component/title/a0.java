package com.larus.bmhome.chat.component.title;

import com.larus.bmhome.view.ChatTitleAlignLeftStyle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a0 implements Runnable {
    public final /* synthetic */ ChatTitleComponent a;

    public /* synthetic */ a0(ChatTitleComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatTitleComponent r0 = this.a;
        ChatTitleAlignLeftStyle r1 = r0.n;
        if ((r1 instanceof ChatTitleAlignLeftStyle) == false) goto L5;
        ChatTitleAlignLeftStyle r2 = r1;
    L6:
        if (r2 == null) goto L8;
        r2.setMainBot(r2.D);
    L8:
        com.larus.platform.api.g0 r3 = r0.n;
        if (r3 == null) goto L12;
        r3.refresh();
        return;
    L12:
        return;
    L5:
        r2 = null;
        goto L6
    }
}
