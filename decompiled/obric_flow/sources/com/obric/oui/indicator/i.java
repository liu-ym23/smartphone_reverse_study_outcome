package com.obric.oui.indicator;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OBaseIndicator f13483b;

    public /* synthetic */ i(OBaseIndicator r5, int r10) {
        this.f13482a = r10;
        this.f13483b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OBaseIndicator r5 = this.f13483b;
        switch(this.f13482a) {
            case 0: goto L26;
            default: goto L4;
        };
    L4:
        int r10 = OBaseIndicator.f13440v;
        Intrinsics.checkNotNullParameter(r5, "this$0");
        if (r5.f13442b == true) goto L7;
        r5.d = true;
        return;
    L7:
        r5.d = false;
        r5.f();
        if (r5.f13442b == true) goto L10;
        r5.f = true;
    L11:
        r5.i();
        r5.j();
        l r11 = r5.f13455t;
        if (r11 != null) goto L15;
    L18:
        l r12 = r5.f13455t;
        if (r12 != null) goto L22;
    L24:
        com.lynx.tasm.utils.d.t(r5);
        return;
    L22:
        if (r12.getCount() != 1) goto L24;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5.setVisibility(4);
        return;
    L15:
        if (r11.d() == false) goto L18;
        r11.e();
        r6.a r13 = r5.b();
        r11.f(r13);
        r13.l(0.0f, r11.a());
        goto L18
    L10:
        r5.f = false;
        r5.e();
        goto L11
    L26:
        int r14 = OBaseIndicator.f13440v;
        Intrinsics.checkNotNullParameter(r5, "this$0");
        if (r5.f13443c == false) goto L30;
        r5.k();
    L30:
        if (r5.d == false) goto L33;
        r5.h();
        return;
    L33:
        if (r5.f == false) goto L39;
        if (r5.f13442b == true) goto L37;
        r5.f = true;
        goto L39
    L37:
        r5.f = false;
        r5.e();
    L39:
        if (r5.e == false) goto L42;
        r5.i();
    L42:
        if (r5.g == false) goto L48;
        r5.j();
        return;
    }
}
