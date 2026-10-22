package com.ss.android.lark.inline.ai.creationai;

import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i implements wlb.d.a {
    public final /* synthetic */ CreationAIDragView a;

    public i(CreationAIDragView r1) {
        this.a = r1;
    }

    @Override // wlb.d.a
    public final void a(int r5) {
        Log.i("CreationAIDragView", "onKeyboardHeightChange: " + r5 + ", needStartShowWhenKeyboardShow = " + this.a.O + ", forceKeyboardWhenShowing = " + this.a.N + ", this@CreationAIDragView.keyboardHeight = " + this.a.m);
        CreationAIDragView r0 = this.a;
        boolean r2 = true;
        if (r0.m == r5) goto L5;
        boolean r1 = true;
    L6:
        if (r5 <= 0) goto L8;
        r0.n = r5;
    L8:
        r0.m = r5;
        if (r5 > 0) goto L12;
        r2 = false;
    L12:
        r0.l = r2;
        if (r1 == false) goto L15;
        r0.u();
    L15:
        CreationAIDragView r6 = this.a;
        if (r6.l == false) goto L19;
        r6.s();
    L19:
        if (Intrinsics.areEqual(this.a.N, Boolean.TRUE) == false) goto L26;
        CreationAIDragView r7 = this.a;
        if (r7.l == true) goto L23;
        CreationAIDragView.d(r7);
        return;
    L23:
        if (r7.O == false) goto L30;
        r7.O = false;
        r7.b.removeCallbacks(r7.c0);
        CreationAIDragView.c(this.a);
        return;
    L30:
        return;
    L26:
        CreationAIDragView r8 = this.a;
        if (r8.N != null) goto L33;
        r8.t(false, r1, CreationAIDragView.AdjustTopSource.KEYBOARD_CHANGE);
        CreationAIDragView r9 = this.a;
        r9.e.b(r9.l);
        return;
    L33:
        return;
    L5:
        r1 = false;
        goto L6
    }
}
