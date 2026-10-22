package com.larus.bmhome.chat.layout.widget;

import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p0 extends LinkMovementMethod {
    public final Function0<Unit> a;
    public long b;
    public o0 c;
    public final Handler d;

    public static final class a {
    }

    static {
    }

    public p0(Function0<Unit> r2) {
        this.a = r2;
        this.d = new Handler(Looper.getMainLooper());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v4, types: [com.larus.bmhome.chat.layout.widget.o0, java.lang.Runnable] */
    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(final TextView r8, Spannable r9, MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r8, "widget");
        Intrinsics.checkNotNullParameter(r9, "buffer");
        Intrinsics.checkNotNullParameter(r10, "event");
        FLogger.a.i("LinkMovementLongClickMethod", "onTouchEvent event=" + r10.getAction());
        int r0 = r10.getAction();
        if (r0 == 1) goto L7;
        if (r0 == 0) goto L7;
        if (r0 == 3) goto L7;
        if (r0 == 2) goto L7;
    L38:
        return super.onTouchEvent(r8, r9, r10);
    L7:
        float r4 = (r10.getX() - r8.getTotalPaddingLeft()) + r8.getScrollX();
        float r5 = (r10.getY() - r8.getTotalPaddingTop()) + r8.getScrollY();
        Layout r6 = r8.getLayout();
        int r7 = r6.getOffsetForHorizontal(r6.getLineForVertical((int) r5), r4);
        final ClickableSpan[] r11 = (ClickableSpan[]) r9.getSpans(r7, r7, ClickableSpan.class);
        if (r11 != null) goto L10;
    L12:
        boolean r12 = false;
    L13:
        if (r12 == true) goto L38;
        if (r0 != 1) goto L26;
        o0 r13 = this.c;
        if (r13 == null) goto L19;
        this.d.removeCallbacks(r13);
    L19:
        if ((System.currentTimeMillis() - this.b) >= ViewConfiguration.getLongPressTimeout()) goto L36;
        Function0<Unit> r14 = this.a;
        if (r14 == null) goto L23;
        r14.invoke();
    L23:
        Intrinsics.checkNotNull(r11);
        ClickableSpan r15 = (ClickableSpan) ArraysKt.getOrNull(r11, 0);
        if (r15 == null) goto L36;
        r15.onClick(r8);
    L36:
        return true;
    L26:
        if (r0 != 0) goto L28;
        Selection.setSelection(r9, r9.getSpanStart(r11[0]), r9.getSpanEnd(r11[0]));
        this.b = System.currentTimeMillis();
        ?? r16 = new o0(r11, r8);
        this.c = r16;
        this.d.postDelayed(r16, ViewConfiguration.getLongPressTimeout());
        goto L36
    L28:
        if (r0 != 3) goto L32;
        o0 r17 = this.c;
        if (r17 == null) goto L36;
        this.d.removeCallbacks(r17);
        goto L36
    L32:
        if (r0 == 2) goto L36;
        o0 r18 = this.c;
        if (r18 == null) goto L36;
        this.d.removeCallbacks(r18);
        goto L36
    L10:
        if (r11.length != 0) goto L12;
        r12 = true;
        goto L13
    }
}
