package com.suite.lark.platform.feature.forward.doubao;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements View.OnTouchListener {
    public final /* synthetic */ DoubaoForwardConfirmFragment a;
    public final /* synthetic */ Ref.FloatRef b;
    public final /* synthetic */ Ref.FloatRef c;
    public final /* synthetic */ int d;

    public g(DoubaoForwardConfirmFragment r1, Ref.FloatRef r2, Ref.FloatRef r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r6, MotionEvent r7) {
        DoubaoForwardConfirmFragment r0 = this.a;
        boolean r2 = true;
        if (r0.u == true) goto L9;
        HorizontalScrollView r8 = r0.h;
        if (r8 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("avatarScroll");
        r8 = null;
    L7:
        r8.scrollTo(0, 0);
        return true;
    L9:
        int r1 = r7.getActionMasked();
        if (r1 == 0) goto L27;
        if (r1 != 1) goto L13;
    L26:
        r6.getParent().requestDisallowInterceptTouchEvent(false);
    L28:
        return false;
    L13:
        if (r1 != 2) goto L15;
        float r3 = Math.abs(r7.getX() - this.b.element);
        float r9 = Math.abs(r7.getY() - this.c.element);
        int r4 = this.d;
        if (r3 <= r4) goto L20;
    L21:
        ViewParent r10 = r6.getParent();
        if (r3 > r9) goto L25;
        r2 = false;
    L25:
        r10.requestDisallowInterceptTouchEvent(r2);
        goto L28
    L20:
        if (r9 <= r4) goto L28;
    L15:
        if (r1 == 3) goto L26;
    L27:
        this.b.element = r7.getX();
        this.c.element = r7.getY();
        r6.getParent().requestDisallowInterceptTouchEvent(true);
        goto L28
    }
}
