package com.obric.assistant.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class n2 implements Runnable {
    public final /* synthetic */ ObricIntercomComponent a;
    public final /* synthetic */ String b;

    public /* synthetic */ n2(ObricIntercomComponent r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricIntercomComponent r0 = this.a;
        String r1 = this.b;
        ObricIntercomComponent$c r2 = r0.L;
        if (r2 == null) goto L5;
        String r3 = r2.a;
    L7:
        if (Intrinsics.areEqual(r3, r1) == false) goto L11;
        r0.qm();
        return;
    L11:
        return;
    L5:
        r3 = null;
        goto L7
    }
}
