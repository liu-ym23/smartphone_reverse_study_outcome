package com.larus.bmhome.chat.nestedmenu.ui;

import android.view.View;
import android.view.ViewTreeObserver;
import com.skydoves.balloon.Balloon;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ NestedMenuPopup b;
    public final /* synthetic */ Balloon c;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ViewTreeObserver r0 = this.a.getViewTreeObserver();
        if (r0.isAlive() == false) goto L5;
        r0.removeOnPreDrawListener(this);
    L5:
        NestedMenuPopup r1 = this.b;
        View r2 = r1.j;
        Balloon r3 = r1.g;
        Balloon r4 = this.c;
        if (r3 == r4) goto L8;
        return true;
    L8:
        if (r4.g == false) goto L17;
        if (r2 != null) goto L11;
        return true;
    L11:
        if (r1.a.e.isAttachedToWindow() == false) goto L19;
        this.b.s(r2);
        this.a.postInvalidateOnAnimation();
        return false;
    L19:
        return true;
    L17:
        return true;
    }

    public p(View r1, NestedMenuPopup r2, Balloon r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
