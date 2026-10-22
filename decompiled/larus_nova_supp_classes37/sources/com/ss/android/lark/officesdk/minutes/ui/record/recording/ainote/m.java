package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class m implements View.OnTouchListener {
    public final /* synthetic */ MmAINotePanelAnimator a;

    public m(MmAINotePanelAnimator r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r8, MotionEvent r9) {
        MmAINotePanelAnimator r10 = this.a;
        VelocityTracker r0 = r10.F;
        if (r0 != null) goto L5;
        r0 = VelocityTracker.obtain();
        r10.F = r0;
    L5:
        r0.addMovement(r9);
        int r11 = r9.getActionMasked();
        boolean r1 = false;
        if (r11 == 0) goto L57;
        float r2 = 0.0f;
        if (r11 != 1) goto L10;
    L41:
        MmAINotePanelAnimator r12 = this.a;
        if (r12.y == false) goto L48;
        float r13 = r9.getRawY();
        MmAINotePanelAnimator r3 = this.a;
        float r14 = r13 - r3.A;
        VelocityTracker r4 = r3.F;
        if (r4 == null) goto L47;
        r4.computeCurrentVelocity(1000);
        r2 = r4.getYVelocity();
    L47:
        r12.D(r14, r2);
    L48:
        MmAINotePanelAnimator r15 = this.a;
        r15.y = false;
        r15.B = false;
        if (r15.u == 0) goto L51;
    L53:
        VelocityTracker r16 = r15.F;
        if (r16 == null) goto L56;
        r16.recycle();
    L56:
        r15.F = null;
    L58:
        return true;
    L51:
        if (r15.L == false) goto L53;
        r15.L = false;
        goto L53
    L10:
        if (r11 == 2) goto L13;
        if (r11 == 3) goto L41;
        return false;
    L13:
        float r17 = r9.getRawY();
        MmAINotePanelAnimator r18 = this.a;
        float r19 = r17 - r18.A;
        if (r18.y == true) goto L38;
        float r20 = Math.abs(r19);
        MmAINotePanelAnimator r5 = this.a;
        if (r20 <= r5.l) goto L38;
        MmAINoteSheetState r21 = r5.o;
        int r22 = MmAINotePanelAnimator.e.b[r21.ordinal()];
        if (r22 == 1) goto L26;
        if (r22 == 2) goto L24;
        if (r22 != 3) goto L23;
    L30:
        if (r1 == false) goto L38;
        ValueAnimator r23 = this.a.q;
        if (r23 == null) goto L34;
        r23.cancel();
    L34:
        ValueAnimator r24 = this.a.r;
        if (r24 == null) goto L37;
        r24.cancel();
    L37:
        this.a.y("header");
        MmAINotePanelAnimator r25 = this.a;
        r25.z = r25.m();
        MmAINotePanelAnimator r26 = this.a;
        r26.B(r26.z);
        this.a.i();
        this.a.y = true;
        goto L38
    L23:
        throw new NoWhenBranchMatchedException();
    L24:
        r1 = r5.B;
        goto L30
    L26:
        if (r5.B == false) goto L30;
        if (r19 <= 0.0f) goto L30;
        r1 = true;
    L38:
        MmAINotePanelAnimator r27 = this.a;
        if (r27.y == false) goto L58;
        r27.G(r19);
        goto L58
    L57:
        MmAINotePanelAnimator r28 = this.a;
        r28.A = r9.getRawY();
        MmAINotePanelAnimator r29 = this.a;
        r29.z = r29.m();
        MmAINotePanelAnimator r30 = this.a;
        r30.B(r30.z);
        MmAINotePanelAnimator r31 = this.a;
        r31.B = true;
        r31.y = false;
        goto L58
    }
}
