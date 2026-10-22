package com.ss.android.lark.inline.ai.ui.richtext;

import android.text.Layout;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.ss.android.lark.inline.ai.ui.InlineAIEditText;
import com.ss.android.lark.log.Log;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class InlineAiRichTextMovementMethod extends com.ss.android.lark.keyboard.edittext2.span.h {
    public final InlineAIEditText f;
    public long g;
    public float h;
    public float i;

    public static final class a {
    }

    static {
    }

    public InlineAiRichTextMovementMethod(InlineAIEditText r2) {
        Intrinsics.checkNotNullParameter(r2, "editText");
        this.f = r2;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.h, com.ss.android.lark.keyboard.edittext2.widget.o, android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(final TextView r18, Spannable r19, MotionEvent r20) {
        if (r18 == null) goto L75;
        if (r20 == null) goto L75;
        if (r19 == null) goto L75;
        int r3 = r20.getActionMasked();
        if (r3 == 0) goto L11;
        if (r3 == 1) goto L11;
    L71:
        return super.onTouchEvent(r18, r19, r20);
    L11:
        float r5 = (r20.getX() - r18.getTotalPaddingLeft()) + r18.getScrollX();
        float r6 = (r20.getY() - r18.getTotalPaddingTop()) + r18.getScrollY();
        Layout r7 = r18.getLayout();
        int r8 = r7.getLineBottom(r7.getLineCount() - 1);
        int r10 = r7.getLineTop(0);
        int r11 = r7.getLineForVertical((int) r6);
        int r12 = r7.getOffsetForHorizontal(r11, r5);
        if (r8 < r6) goto L73;
        if (r10 > r6) goto L73;
        InlineAIAtSpanHolder.a[] r9 = (InlineAIAtSpanHolder.a[]) r19.getSpans(r12, r12, InlineAIAtSpanHolder.a.class);
        Intrinsics.checkNotNull(r9);
        if (r9.length != 0) goto L19;
        boolean r13 = true;
    L21:
        if ((!r13) == false) goto L71;
        InlineAIAtSpanHolder.a r14 = r9[0];
        int r15 = r19.getSpanStart(r14);
        int r16 = r19.getSpanEnd(r14);
        if (r12 < r19.length()) goto L27;
        return super.onTouchEvent(r18, r19, r20);
    L27:
        if ((r15 + 1) > r12) goto L30;
        if (r12 >= r16) goto L30;
        boolean r17 = true;
    L31:
        if (r17 == false) goto L33;
    L32:
        boolean r110 = true;
    L43:
        if (r110 == false) goto L45;
        if (r3 == 0) goto L68;
        if (r3 != 1) goto L71;
        if ((System.currentTimeMillis() - this.g) < 500) goto L52;
        boolean r21 = true;
    L54:
        if (r11 == (r18.getLineCount() - 1)) goto L56;
    L58:
        boolean r22 = false;
    L59:
        int r111 = ViewConfiguration.get(r18.getContext()).getScaledTouchSlop();
        double r4 = 2;
        if ((((float) Math.pow(r5 - this.h, r4)) + ((float) Math.pow(r6 - this.i, r4))) <= (r111 * r111)) goto L62;
        boolean r23 = true;
    L63:
        if (r21 == true) goto L71;
        if (r22 == true) goto L71;
        if (r23 == true) goto L71;
        Log.i("InlineAiRichTextMovementMethod", "onClick: x is " + r5 + " , y is " + r6 + ", characterOffset is " + r12);
        r14.onClick(r18);
        r18.setShowSoftInputOnFocus(false);
        InlineAIEditText r2 = this.f;
        Function0<Unit> r24 = new AnonymousClass1(r18);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r24, "action");
        r2.g = r24;
        return true;
    L62:
        r23 = false;
        goto L63
    L56:
        if (r5 <= r7.getLineRight(r18.getLineCount() - 1)) goto L58;
        r22 = true;
        goto L59
    L52:
        r21 = false;
        goto L54
    L68:
        this.h = r5;
        this.i = r6;
        this.g = System.currentTimeMillis();
        return true;
    L45:
        return super.onTouchEvent(r18, r19, r20);
    L33:
        float r112 = r7.getPaint().measureText(String.valueOf(r19.charAt(r12)));
        float r113 = r7.getPrimaryHorizontal(r12);
        if (r12 == r15) goto L36;
        if (r12 == r16) goto L40;
    L42:
        r110 = false;
        goto L43
    L40:
        if ((r113 - (r112 / 2.0f)) < r5) goto L42;
    L36:
        if ((r113 + (r112 / 2.0f)) > r5) goto L42;
    L30:
        r17 = false;
        goto L31
    L19:
        r13 = false;
    L73:
        return super.onTouchEvent(r18, r19, r20);
    L75:
        return super.onTouchEvent(r18, r19, r20);
    }
}
