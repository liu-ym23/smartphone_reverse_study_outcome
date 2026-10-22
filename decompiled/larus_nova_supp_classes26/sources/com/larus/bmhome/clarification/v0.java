package com.larus.bmhome.clarification;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class v0 implements Runnable {
    public final /* synthetic */ ClarificationComponent a;
    public final /* synthetic */ String b;

    public /* synthetic */ v0(ClarificationComponent r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ClarificationComponent r0 = this.a;
        String r1 = this.b;
        if (Intrinsics.areEqual(r0.O, r1) == false) goto L37;
        d2 r2 = r0.n.a;
        if (r2 == null) goto L38;
        ze8.b r3 = r2.k;
        boolean r4 = false;
        if (r3 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        if (r5 == true) goto L36;
        if (r3 != null) goto L17;
    L19:
        boolean r6 = false;
    L20:
        if (r6 == true) goto L39;
        va8.o r7 = r0.G3();
        if (r7 == null) goto L25;
        String r8 = r7.u7();
    L26:
        if (r8 != null) goto L29;
        r8 = "";
    L29:
        if (r8.length() != 0) goto L31;
        r4 = true;
    L31:
        if (r4 == true) goto L34;
        r1 = r8;
    L34:
        r0.O = null;
        r0.p4(r1, "voice");
        return;
    L25:
        r8 = null;
        goto L26
    L39:
        return;
    L17:
        if (r3.f() != true) goto L19;
        r6 = true;
        goto L20
    L36:
        return;
    L11:
        if (r3.c() != true) goto L13;
        r5 = true;
        goto L14
    L38:
        return;
    }
}
