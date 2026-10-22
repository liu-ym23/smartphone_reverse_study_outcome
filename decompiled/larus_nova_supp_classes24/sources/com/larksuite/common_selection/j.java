package com.larksuite.common_selection;

import android.view.MotionEvent;
import android.view.View;
import com.larksuite.common_selection.selectionhandle.SelectionHandleType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class j implements View.OnTouchListener {
    public final /* synthetic */ i a;
    public final /* synthetic */ SelectionHandleType b;
    public final /* synthetic */ SelectionContainer c;

    public j(i r1, SelectionHandleType r2, SelectionContainer r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r1, MotionEvent r2) {
        if (r2.getAction() != 0) goto L11;
        i r3 = this.a;
        SelectionHandleType r4 = this.b;
        r3.n = r4;
        if (r4 != null) goto L10;
        b r5 = r3.s;
        if (r5 == null) goto L9;
        r5.a.dismiss();
    L9:
        r3.s = null;
    L10:
        this.c.getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L11:
        return false;
    }
}
