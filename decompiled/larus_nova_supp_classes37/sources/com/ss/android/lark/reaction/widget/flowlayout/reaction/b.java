package com.ss.android.lark.reaction.widget.flowlayout.reaction;

import android.text.Layout;
import android.text.NoCopySpan;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;
import com.larksuite.framework.utils.b0;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b extends LinkMovementMethod {
    public static b a;
    public static final Object b = null;

    static {
        b = new NoCopySpan.Concrete();
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean canSelectArbitrarily() {
        return super.canSelectArbitrarily();
    }

    public b() {
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean down(TextView r2, Spannable r3) {
        if (a(3, r2, r3) == false) goto L7;
        return true;
    L7:
        return super.down(r2, r3);
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final void initialize(TextView r1, Spannable r2) {
        Selection.removeSelection(r2);
        r2.removeSpan(b);
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean left(TextView r2, Spannable r3) {
        if (a(2, r2, r3) == false) goto L7;
        return true;
    L7:
        return super.left(r2, r3);
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean right(TextView r2, Spannable r3) {
        if (a(3, r2, r3) == false) goto L7;
        return true;
    L7:
        return super.right(r2, r3);
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean up(TextView r2, Spannable r3) {
        if (a(2, r2, r3) == false) goto L7;
        return true;
    L7:
        return super.up(r2, r3);
    }

    public static boolean a(int r8, TextView r9, Spannable r10) {
        Layout r0 = r9.getLayout();
        int r1 = r9.getTotalPaddingTop() + r9.getTotalPaddingBottom();
        int r2 = r9.getScrollY();
        int r3 = (r9.getHeight() + r2) - r1;
        int r4 = r0.getLineForVertical(r2);
        int r5 = r0.getLineForVertical(r3);
        int r6 = r0.getLineStart(r4);
        int r7 = r0.getLineEnd(r5);
        d[] r11 = (d[]) r10.getSpans(r6, r7, d.class);
        d[] r12 = (d[]) r10.getSpans(r6, r7, d.class);
        int r13 = Selection.getSelectionStart(r10);
        int r14 = Selection.getSelectionEnd(r10);
        int r15 = Math.min(r13, r14);
        int r16 = Math.max(r13, r14);
        if (r15 >= 0) goto L8;
        if (r10.getSpanStart(b) < 0) goto L8;
        r15 = r10.length();
        r16 = r15;
    L8:
        if (r15 <= r7) goto L10;
        r16 = Integer.MAX_VALUE;
        r15 = Integer.MAX_VALUE;
    L10:
        int r17 = -1;
        if (r16 >= r6) goto L14;
        r16 = -1;
        r15 = -1;
    L14:
        if (r8 != 1) goto L16;
        if (r15 != r16) goto L46;
        return false;
    L46:
        d[] r18 = (d[]) r10.getSpans(r15, r16, d.class);
        if (r18.length != 1) goto L50;
        r18[0].c(r9);
    L52:
        return false;
    L50:
        if (r12.length != 1) goto L52;
        r12[0].c(r9);
        goto L52
    L16:
        if (r8 != 2) goto L18;
        int r19 = -1;
        int r20 = 0;
    L34:
        if (r20 >= r11.length) goto L41;
        int r21 = r10.getSpanEnd(r11[r20]);
        if (r21 < r16) goto L38;
        if (r15 == r16) goto L38;
    L40:
        r20 = r20 + 1;
    L38:
        if (r21 <= r19) goto L40;
        r17 = r10.getSpanStart(r11[r20]);
        r19 = r21;
        goto L40
    L41:
        if (r17 < 0) goto L52;
        Selection.setSelection(r10, r19, r17);
        return true;
    L18:
        if (r8 != 3) goto L52;
        int r22 = 0;
        int r23 = Integer.MAX_VALUE;
        int r24 = Integer.MAX_VALUE;
    L22:
        if (r22 >= r11.length) goto L29;
        int r25 = r10.getSpanStart(r11[r22]);
        if (r25 > r15) goto L26;
        if (r15 == r16) goto L26;
    L28:
        r22 = r22 + 1;
    L26:
        if (r25 >= r24) goto L28;
        r23 = r10.getSpanEnd(r11[r22]);
        r24 = r25;
        goto L28
    L29:
        if (r23 >= Integer.MAX_VALUE) goto L52;
        Selection.setSelection(r10, r24, r23);
        return true;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final void onTakeFocus(TextView r2, Spannable r3, int r4) {
        Selection.removeSelection(r3);
        if ((r4 & 1) == 0) goto L5;
        r3.setSpan(b, 0, 0, 34);
        return;
    L5:
        r3.removeSpan(b);
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r8, Spannable r9, MotionEvent r10) {
        int r0 = r10.getAction();
        if (r0 == 1) goto L5;
        if (r0 == 0) goto L5;
    L35:
        return super.onTouchEvent(r8, r9, r10);
    L5:
        int r2 = (int) r10.getX();
        int r3 = (int) r10.getY();
        int r4 = r2 - r8.getTotalPaddingLeft();
        int r5 = r3 - r8.getTotalPaddingTop();
        int r6 = r4 + r8.getScrollX();
        int r7 = r5 + r8.getScrollY();
        Layout r11 = r8.getLayout();
        int r12 = r11.getLineForVertical(r7);
        float r13 = r6;
        int r14 = r11.getOffsetForHorizontal(r12, r13);
        if (r11.getLineRight(r12) >= r13) goto L8;
    L36:
        return true;
    L8:
        if (r11.getLineLeft(r12) > r13) goto L36;
        d[] r15 = (d[]) r9.getSpans(r14, r14, d.class);
        if (r15.length == 0) goto L28;
        d r16 = r15[0];
        if (r0 != 1) goto L15;
        r16.c(r8);
    L27:
        return true;
    L15:
        if (r0 != 0) goto L27;
        if (r8.getContext().getApplicationInfo().targetSdkVersion >= 28) goto L37;
    L26:
        Selection.setSelection(r9, r9.getSpanStart(r16), r9.getSpanEnd(r16));
        goto L27
    L37:
        Method r1 = b0.b(TextView.class, "hideFloatingToolbar", new Class[]{Integer.class});     // Catch: Throwable -> L22 IllegalAccessException -> L24
        if (r1 == null) goto L26;
        r1.setAccessible(true);     // Catch: Throwable -> L22 IllegalAccessException -> L24
        r1.invoke(r8, new Object[]{200});     // Catch: Throwable -> L22 IllegalAccessException -> L24
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L26
    L28:
        a[] r17 = (a[]) r9.getSpans(r14, r14, a.class);
        if (r17.length == 0) goto L33;
        a r18 = r17[0];
        if (r0 != 1) goto L35;
        r18.c(r8);
        goto L35
    L33:
        Selection.removeSelection(r9);
        goto L35
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.BaseMovementMethod
    public final boolean handleMovementKey(TextView r1, Spannable r2, int r3, int r4, KeyEvent r5) {
        return super.canSelectArbitrarily();
    }
}
