package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p implements View.OnTouchListener {
    public final /* synthetic */ PublicScreenConfigSliderView a;

    public p(PublicScreenConfigSliderView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r7, MotionEvent r8) {
        PublicScreenConfigSliderView r0 = this.a;
        if (r0.i == true) goto L30;
        if (r0.getDisable() == true) goto L30;
        int r1 = r8.getAction();
        if (r1 != 0) goto L9;
        this.a.requestDisallowInterceptTouchEvent(true);
        this.a.k = r8.getRawY();
        PublicScreenConfigSliderView r9 = this.a;
        r9.j = r9.g[r9.f];
    L36:
        return true;
    L9:
        if (r1 != 1) goto L11;
    L27:
        this.a.requestDisallowInterceptTouchEvent(false);
        PublicScreenConfigSliderView r10 = this.a;
        r10.b(r10.a(), true);
        goto L36
    L11:
        if (r1 != 2) goto L13;
        float r2 = this.a.j;
        float r11 = r8.getRawY();
        PublicScreenConfigSliderView r4 = this.a;
        float r3 = r2 + (r11 - r4.k);
        float[] r13 = r4.g;
        if (r3 >= r13[2]) goto L18;
    L22:
        PublicScreenConfigSliderView r14 = this.a;
        int r15 = r14.a();
        if (r14.f == r15) goto L36;
        r14.f = r15;
        r14.c.setText(r14.h[r15]);
        PublicScreenConfigSliderView.a r16 = r14.d;
        if (r16 == null) goto L36;
        r16.a(r15);
        goto L36
    L18:
        if (r3 > r13[0]) goto L22;
        r7.setY(r3);
        PublicScreenConfigSliderView r17 = this.a;
        PublicScreenConfigSliderView.a r18 = r17.d;
        if (r18 == null) goto L22;
        float[] r19 = r17.g;
        r18.b(1 - (r3 / (r19[0] - r19[2])));
        goto L22
    L13:
        if (r1 == 3) goto L27;
    L30:
        if (this.a.getDisable() == false) goto L36;
        if (r8.getAction() != 0) goto L36;
        la2.a r20 = this.a.e;
        if (r20 == null) goto L36;
        r20.a();
        goto L36
    }
}
