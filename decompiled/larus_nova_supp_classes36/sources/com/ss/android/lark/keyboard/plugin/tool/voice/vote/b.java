package com.ss.android.lark.keyboard.plugin.tool.voice.vote;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements View.OnTouchListener {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r4, MotionEvent r5) {
        if ((r4 instanceof EditText) == false) goto L10;
        EditText r6 = (EditText) r4;
        r6.getParent().requestDisallowInterceptTouchEvent(true);
        int r7 = r5.getAction() & 255;
        if (r7 != 1) goto L7;
    L9:
        r6.getParent().requestDisallowInterceptTouchEvent(false);
        goto L10
    L7:
        if (r7 == 3) goto L9;
    L10:
        return false;
    }
}
