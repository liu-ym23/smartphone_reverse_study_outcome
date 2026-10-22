package com.ss.android.lark.inline.ai.ui;

import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements wlb.d.a {
    public final /* synthetic */ InlineAIDragView a;

    public j(InlineAIDragView r1) {
        this.a = r1;
    }

    @Override // wlb.d.a
    public final void a(int r5) {
        Log.i("InlineAIDragView", "onKeyboardHeightChange: " + r5 + ", needStartShowWhenKeyboardShow = " + this.a.O + ", forceKeyboardWhenShowing = " + this.a.N);
        InlineAIDragView r0 = this.a;
        boolean r2 = true;
        if (r0.l == r5) goto L5;
        boolean r1 = true;
    L6:
        if (r5 <= 0) goto L8;
        r0.m = r5;
    L8:
        r0.l = r5;
        if (r5 > 0) goto L12;
        r2 = false;
    L12:
        r0.k = r2;
        if (r1 == false) goto L16;
        r0.o();
    L16:
        if (Intrinsics.areEqual(this.a.N, Boolean.TRUE) == false) goto L23;
        InlineAIDragView r6 = this.a;
        if (r6.k == true) goto L20;
        KeyboardUtils.showKeyboard(r6.a);
        return;
    L20:
        if (r6.O == false) goto L27;
        r6.O = false;
        r6.b.removeCallbacks(r6.X);
        InlineAIDragView.c(this.a);
        return;
    L27:
        return;
    L23:
        InlineAIDragView r7 = this.a;
        if (r7.N != null) goto L30;
        r7.n(false, r1, InlineAIDragView.AdjustTopSource.KEYBOARD_CHANGE);
        InlineAIDragView r8 = this.a;
        r8.e.b(r8.k);
        return;
    L30:
        return;
    L5:
        r1 = false;
        goto L6
    }
}
