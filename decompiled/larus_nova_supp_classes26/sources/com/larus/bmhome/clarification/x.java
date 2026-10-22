package com.larus.bmhome.clarification;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class x implements Runnable {
    public final /* synthetic */ ClarificationComponent a;
    public final /* synthetic */ k2 b;

    public /* synthetic */ x(ClarificationComponent r1, k2 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ClarificationComponent r0 = this.a;
        k2 r1 = this.b;
        int r2 = ClarificationComponent.k0;
        r0.d4(r1);
    }
}
