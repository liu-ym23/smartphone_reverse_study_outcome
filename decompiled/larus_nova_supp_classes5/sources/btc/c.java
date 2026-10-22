package btc;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c extends LinkMovementMethod {
    public final int a;
    public int b;
    public float c;
    public float d;
    public long e;
    public a[] f;

    public c() {
        this.a = ViewConfiguration.getLongPressTimeout();
        this.f = new a[0];
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final void initialize(TextView r1, Spannable r2) {
        super.initialize(r1, r2);
        this.b = ViewConfiguration.get(r1.getContext()).getScaledTouchSlop();
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r12, Spannable r13, MotionEvent r14) {
        if (r14.getActionMasked() != 1) goto L5;
    L8:
        float r0 = (r14.getX() - r12.getTotalPaddingLeft()) + r12.getScrollX();
        float r2 = (r14.getY() - r12.getTotalPaddingTop()) + r12.getScrollY();
        Layout r3 = r12.getLayout();
        int r4 = r3.getOffsetForHorizontal(r3.getLineForVertical((int) r2), r0);
        ClickableSpan[] r5 = (ClickableSpan[]) r13.getSpans(r4, r4, ClickableSpan.class);
        int r6 = 0;
        if (r14.getActionMasked() != 0) goto L20;
        this.c = r14.getX();
        this.d = r14.getY();
        this.e = System.currentTimeMillis();
        a[] r1 = (a[]) r13.getSpans(r4, r4, a.class);
        this.f = r1;
        int r7 = r1.length;
        int r8 = 0;
    L11:
        if (r8 >= r7) goto L14;
        r1[r8].d(r12);
        r8 = r8 + 1;
        goto L11
    L14:
        if (r5.length != 0) goto L17;
        r6 = 1;
    L17:
        if ((r6 ^ 1) == 0) goto L55;
        Selection.setSelection(r13, r13.getSpanStart(ArraysKt.first(r5)), r13.getSpanEnd(ArraysKt.first(r5)));
    L55:
        return Touch.onTouchEvent(r12, r13, r14);
    L20:
        if (r14.getActionMasked() != 1) goto L51;
        a[] r9 = this.f;
        int r10 = r9.length;
        int r11 = 0;
    L22:
        if (r11 >= r10) goto L25;
        r9[r11].b(r12);
        r11 = r11 + 1;
        goto L22
    L25:
        if (Math.abs(r14.getX() - this.c) < this.b) goto L27;
    L49:
        Selection.removeSelection(r13);
        return Touch.onTouchEvent(r12, r13, r14);
    L27:
        if (Math.abs(r14.getY() - this.d) >= this.b) goto L49;
        if ((System.currentTimeMillis() - this.e) >= this.a) goto L49;
        if (r5.length != 0) goto L33;
        boolean r15 = true;
    L35:
        if ((!r15) == false) goto L49;
        float r16 = r3.getPrimaryHorizontal(r4);
        int r17 = r5.length;
    L37:
        if (r6 >= r17) goto L49;
        ClickableSpan r18 = r5[r6];
        if (r16 >= r0) goto L45;
        if (r13.getSpanEnd(r18) <= r4) goto L48;
        r18.onClick(r12);
        return true;
    L48:
        r6 = r6 + 1;
        goto L37
    L45:
        if (r13.getSpanStart(r18) >= r4) goto L48;
        r18.onClick(r12);
        return true;
    L33:
        r15 = false;
        goto L35
    L51:
        a[] r19 = this.f;
        int r20 = r19.length;
    L52:
        if (r6 >= r20) goto L55;
        r19[r6].c(r12);
        r6 = r6 + 1;
        goto L52
    L5:
        if (r14.getActionMasked() == 0) goto L8;
        if (r14.getActionMasked() != 3) goto L55;
        goto L8
    }
}
