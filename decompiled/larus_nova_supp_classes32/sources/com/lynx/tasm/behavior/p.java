package com.lynx.tasm.behavior;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p implements ViewTreeObserver.OnGlobalFocusChangeListener {
    public final /* synthetic */ n.e a;

    public p(n.e r1) {
        this.a = r1;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public final void onGlobalFocusChanged(View r4, View r5) {
        n.e r0 = this.a;
        n.d r6 = r0.i(r4);
        n.d r7 = r0.i(r5);
        if (r6 == null) goto L5;
        r0.r(r6.a.get());
    L5:
        if (r7 == null) goto L7;
        r0.b(r7);
        return;
    L7:
        if (r6 == null) goto L33;
        Object r8 = r6.a.get();
        n.d r9 = r0.j();
        if (r9 != null) goto L11;
    L30:
        r0.r(r8);
        return;
    L11:
        if (r9.b(r8) == false) goto L30;
        r0.q(null);
        r0.r(r8);
        if (r0.i > 0) goto L34;
        boolean r10 = false;
        if (r0.k == false) goto L17;
    L29:
        r0.l(r10);
        return;
    L17:
        if (Build.VERSION.SDK_INT >= 30) goto L19;
    L21:
        boolean r11 = false;
    L22:
        if (r11 == true) goto L24;
    L26:
        boolean r12 = false;
    L27:
        if (r12 == true) goto L29;
        r10 = true;
        goto L29
    L24:
        if (r0.n == 0) goto L26;
        r12 = true;
        goto L27
    L19:
        if (r0.g == null) goto L21;
        r11 = true;
        goto L22
    L34:
        return;
    }
}
