package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class o extends ArrowKeyMovementMethod {
    public o() {
    }

    @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView r4, Spannable r5, MotionEvent r6) {
        boolean r0 = false;
        if (r6 != null) goto L5;
    L7:
        if (r0 == false) goto L11;
        return Touch.onTouchEvent(r4, r5, r6);
    L11:
        return super.onTouchEvent(r4, r5, r6);
    L5:
        if (r6.getActionMasked() != 1) goto L7;
        r0 = true;
        goto L7
    }
}
