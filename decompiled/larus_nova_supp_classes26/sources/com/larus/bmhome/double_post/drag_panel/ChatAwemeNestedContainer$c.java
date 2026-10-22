package com.larus.bmhome.double_post.drag_panel;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatAwemeNestedContainer$c implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ ChatAwemeNestedContainer a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        View r0 = this.a.b;
        if (r0 == null) goto L5;
        ViewTreeObserver r1 = r0.getViewTreeObserver();
    L7:
        if (r1 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L14;
        r1.removeOnPreDrawListener(this);
    L14:
        ChatAwemeNestedContainer r2 = this.a;
        r2.scrollTo(0, r2.getScrollY() + (this.b - this.c));
        return true;
    L9:
        if (r1.isAlive() != true) goto L11;
        r3 = true;
        goto L12
    L5:
        r1 = null;
        goto L7
    }

    public ChatAwemeNestedContainer$c(ChatAwemeNestedContainer r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
