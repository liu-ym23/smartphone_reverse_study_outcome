package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements View.OnTouchListener {
    public final /* synthetic */ PanelBottomDialog a;

    public d(PanelBottomDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r7, MotionEvent r8) {
        int r9 = r8.getAction();
        if (r9 != 0) goto L5;
        PanelBottomDialog r10 = this.a;
        r10.w = r8.getRawY();
        this.a.x = false;
    L47:
        return true;
    L5:
        if (r9 != 1) goto L7;
        float r11 = r8.getRawY();
        PanelBottomDialog r12 = this.a;
        float r13 = r11 - r12.w;
        if (r12.x == true) goto L29;
    L36:
        View r14 = r12.v;
        if (r14 == null) goto L45;
        ViewPropertyAnimator r15 = r14.animate();
        if (r15 == null) goto L45;
        ViewPropertyAnimator r16 = r15.translationY(0.0f);
        if (r16 == null) goto L45;
        ViewPropertyAnimator r17 = r16.setDuration(200);
        if (r17 == null) goto L45;
        r17.start();
    L45:
        this.a.x = false;
        goto L47
    L29:
        if (r13 <= 100.0f) goto L36;
        r12.dismiss();     // Catch: Exception -> L32
    L32:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r18 = DialogFragmentLancet.sLastShowStack;
        if (r18 == null) goto L45;
        com.bytedance.crash.d.d(r18, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L45
    L7:
        if (r9 != 2) goto L9;
        float r19 = r8.getRawY();
        PanelBottomDialog r20 = this.a;
        float r21 = r19 - r20.w;
        if (r21 <= 10.0f) goto L47;
        r20.x = true;
        View r22 = r20.v;
        if (r22 == null) goto L47;
        r22.setTranslationY(r21);
        goto L47
    L9:
        if (r9 != 3) goto L47;
        View r23 = this.a.v;
        if (r23 == null) goto L20;
        ViewPropertyAnimator r24 = r23.animate();
        if (r24 == null) goto L20;
        ViewPropertyAnimator r25 = r24.translationY(0.0f);
        if (r25 == null) goto L20;
        ViewPropertyAnimator r26 = r25.setDuration(200);
        if (r26 == null) goto L20;
        r26.start();
    L20:
        this.a.x = false;
        goto L47
    }
}
