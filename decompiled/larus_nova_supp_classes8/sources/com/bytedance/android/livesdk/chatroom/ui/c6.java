package com.bytedance.android.livesdk.chatroom.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.EditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c6 implements View.OnTouchListener {
    public final /* synthetic */ EditIntroductionFragment a;

    public c6(EditIntroductionFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r4, MotionEvent r5) {
        ViewParent r0 = r4.getParent();
        if (r0 == null) goto L5;
        r0.requestDisallowInterceptTouchEvent(true);
    L5:
        int r6 = r5.getAction() & 255;
        if (r6 != 1) goto L8;
        EditIntroductionFragment r7 = this.a;
        EditText r2 = r7.f;
        if (r2 == null) goto L16;
        r2.setFocusable(true);
    L16:
        EditText r3 = r7.f;
        if (r3 == null) goto L19;
        r3.setFocusableInTouchMode(true);
    L19:
        EditText r1 = r7.f;
        if (r1 == null) goto L22;
        r1.requestFocus();
    L22:
        EditText r8 = r7.f;
        if (r8 == null) goto L25;
        r8.requestFocusFromTouch();
    L25:
        ViewParent r9 = r4.getParent();
        if (r9 == null) goto L28;
        r9.requestDisallowInterceptTouchEvent(false);
    L28:
        return false;
    L8:
        if (r6 != 2) goto L28;
        EditText r10 = this.a.f;
        if (r10 == null) goto L28;
        r10.setFocusable(false);
        goto L28
    }
}
