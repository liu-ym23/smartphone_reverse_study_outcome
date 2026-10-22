package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.text.Layout;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.ss.android.lark.widget.light.LKUILightTextView;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements View.OnTouchListener {
    public final /* synthetic */ ContentLongClickListener a;
    public final /* synthetic */ GestureDetector b;

    public g(ContentLongClickListener r1, GestureDetector r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r6, MotionEvent r7) {
        int r0 = -1;
        if (r7.getActionMasked() != 0) goto L10;
        ContentLongClickListener r8 = this.a;
        LKUILightTextView r1 = r8.a;
        float r2 = r7.getX();
        float r3 = r7.getY();
        r8.getClass();
        Layout r9 = r1.getLayout();
        if (r9 == null) goto L8;
        r0 = r9.getOffsetForHorizontal(r9.getLineForVertical((int) (r3 - r1.getPaddingTop())), r2 - r1.getPaddingStart());
    L8:
        this.a.e = TuplesKt.to(Integer.valueOf(r0), Integer.valueOf(r0));
    L19:
        return this.b.onTouchEvent(r7);
    L10:
        if (r7.getActionMasked() != 2) goto L12;
    L13:
        ContentLongClickListener r10 = this.a;
        LKUILightTextView r4 = r10.a;
        float r5 = r7.getX();
        float r11 = r7.getY();
        int r12 = ((Number) this.a.e.getFirst()).intValue();
        r10.getClass();
        Layout r13 = r4.getLayout();
        if (r13 == null) goto L17;
        r0 = com.ss.android.lark.widget.select.i.a(r13, (int) (r5 - r4.getPaddingStart()), (int) (r11 - r4.getPaddingTop()), r12);
    L17:
        int r14 = Math.min(r0, ((Number) this.a.e.getFirst()).intValue());
        int r15 = Math.max(r0, ((Number) this.a.e.getSecond()).intValue());
        this.a.e = TuplesKt.to(Integer.valueOf(r14), Integer.valueOf(r15));
        goto L19
    L12:
        if (r7.getActionMasked() != 1) goto L19;
        goto L13
    }
}
