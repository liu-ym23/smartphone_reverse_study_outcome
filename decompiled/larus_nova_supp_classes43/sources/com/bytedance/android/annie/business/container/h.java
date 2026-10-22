package com.bytedance.android.annie.business.container;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h implements Runnable {
    public final /* synthetic */ AnnieXLiveHybridComponent a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public h(AnnieXLiveHybridComponent r1, String r10, String r11, String r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AnnieXLiveHybridComponent r0 = this.a;     // Catch: Throwable -> L4
        r0.g(r0.c.b(), this.b, this.c, this.d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
