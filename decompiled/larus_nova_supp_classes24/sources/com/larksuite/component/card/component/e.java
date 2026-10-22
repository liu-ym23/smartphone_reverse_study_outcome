package com.larksuite.component.card.component;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e extends LinkMovementMethod {
    public static e b;
    public long a;

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean bottom(TextView r1, Spannable r2) {
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean down(TextView r1, Spannable r2) {
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean left(TextView r1, Spannable r2) {
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean lineEnd(TextView r1, Spannable r2) {
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean lineStart(TextView r1, Spannable r2) {
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean pageDown(TextView r1, Spannable r2) {
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean pageUp(TextView r1, Spannable r2) {
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean right(TextView r1, Spannable r2) {
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean top(TextView r1, Spannable r2) {
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean up(TextView r1, Spannable r2) {
        return false;
    }

    public e() {
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r8, Spannable r9, MotionEvent r10) {
        int r0 = r10.getAction();
        if (r0 == 1) goto L7;
        if (r0 == 0) goto L7;
        return false;
    L7:
        int r3 = (int) r10.getX();
        int r11 = (int) r10.getY();
        int r4 = r3 - r8.getTotalPaddingLeft();
        int r12 = r11 - r8.getTotalPaddingTop();
        int r5 = r4 + r8.getScrollX();
        int r13 = r12 + r8.getScrollY();
        Layout r6 = r8.getLayout();
        int r14 = r6.getLineForVertical(r13);
        float r7 = r5;
        int r15 = r6.getOffsetForHorizontal(r14, r7);
        ClickableSpan[] r16 = (ClickableSpan[]) r9.getSpans(r15, r15, ClickableSpan.class);
        if (r16.length == 0) goto L22;
        if (r0 == 1) goto L11;
        this.a = System.currentTimeMillis();
    L21:
        return true;
    L11:
        if (r14 == (r8.getLineCount() - 1)) goto L13;
    L15:
        boolean r17 = false;
    L16:
        Log.d("CardSpanMovementClickMethod", "touch area: " + r17);
        if ((System.currentTimeMillis() - this.a) >= 500) goto L21;
        if (r17 == true) goto L21;
        r16[0].onClick(r8);
        goto L21
    L13:
        if (r7 <= r6.getLineRight(r8.getLineCount() - 1)) goto L15;
        r17 = true;
        goto L16
    L22:
        return false;
    }
}
