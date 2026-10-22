package io.noties.markwon.ext.tables;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d implements MovementMethod {
    public final MovementMethod a;

    @Override // android.text.method.MovementMethod
    public final boolean canSelectArbitrarily() {
        return this.a.canSelectArbitrarily();
    }

    public d(btc.c r1) {
        this.a = r1;
    }

    @Override // android.text.method.MovementMethod
    public final void initialize(TextView r2, Spannable r3) {
        this.a.initialize(r2, r3);
    }

    @Override // android.text.method.MovementMethod
    public final boolean onGenericMotionEvent(TextView r2, Spannable r3, MotionEvent r4) {
        return this.a.onGenericMotionEvent(r2, r3, r4);
    }

    @Override // android.text.method.MovementMethod
    public final boolean onKeyOther(TextView r2, Spannable r3, KeyEvent r4) {
        return this.a.onKeyOther(r2, r3, r4);
    }

    @Override // android.text.method.MovementMethod
    public final void onTakeFocus(TextView r2, Spannable r3, int r4) {
        this.a.onTakeFocus(r2, r3, r4);
    }

    @Override // android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r8, Spannable r9, MotionEvent r10) {
        if (this.a.onTouchEvent(r8, r9, r10) == false) goto L5;
        return true;
    L5:
        if (r10.getAction() == 1) goto L7;
    L6:
        boolean r11 = false;
    L15:
        if (r11 == true) goto L20;
        return false;
    L20:
        return true;
    L7:
        int r0 = (int) r10.getX();
        int r12 = (int) r10.getY();
        int r1 = r0 - r8.getTotalPaddingLeft();
        int r13 = r12 - r8.getTotalPaddingTop();
        int r2 = r1 + r8.getScrollX();
        int r14 = r13 + r8.getScrollY();
        Layout r3 = r8.getLayout();
        int r4 = r3.getLineForVertical(r14);
        int r5 = r3.getOffsetForHorizontal(r4, r2);
        a[] r15 = (a[]) r9.getSpans(r5, r5, a.class);
        if (r15.length == 0) goto L6;
        ClickableSpan[] r16 = (ClickableSpan[]) r15[0].a(r2, r14 - r3.getLineTop(r4), ClickableSpan.class);
        if (r16 == null) goto L6;
        if (r16.length <= 0) goto L6;
        r16[0].onClick(r8);
        r11 = true;
        goto L15
    }

    @Override // android.text.method.MovementMethod
    public final boolean onTrackballEvent(TextView r2, Spannable r3, MotionEvent r4) {
        return this.a.onTrackballEvent(r2, r3, r4);
    }

    @Override // android.text.method.MovementMethod
    public final boolean onKeyDown(TextView r2, Spannable r3, int r4, KeyEvent r5) {
        return this.a.onKeyDown(r2, r3, r4, r5);
    }

    @Override // android.text.method.MovementMethod
    public final boolean onKeyUp(TextView r2, Spannable r3, int r4, KeyEvent r5) {
        return this.a.onKeyUp(r2, r3, r4, r5);
    }
}
