package com.larus.bmhome.chat.component.title;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class x0 implements Runnable {
    public final /* synthetic */ ChatTitleComponent a;

    public /* synthetic */ x0(ChatTitleComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatTitleComponent r0 = this.a;
        r0.k0 = false;
        r0.Y = null;
        com.larus.platform.api.g0 r1 = r0.n;
        if (r1 == null) goto L9;
        String r2 = r0.Z;
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        com.larus.platform.api.g0.a.a(r1, r2, 1, 10);
        return;
    }
}
