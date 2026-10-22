package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.animation.ValueAnimator;
import androidx.core.view.ViewCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class q implements Runnable {
    public final /* synthetic */ MmAINotePanelAnimator a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public q(MmAINotePanelAnimator r1, boolean r2, int r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        if (this.a.f.isAttachedToWindow() == true) goto L5;
        return;
    L5:
        boolean r0 = this.b;
        boolean r1 = false;
        if (r0 == false) goto L8;
        int r2 = this.c;
    L9:
        if (r0 == false) goto L11;
        int r3 = this.d;
    L12:
        MmAINotePanelAnimator r10 = this.a;
        if (r10.u == r2) goto L15;
    L17:
        String r11 = "ai_note_delegate(visible=" + this.b + ')';
        if (r10.f.getHeight() > 0) goto L20;
    L30:
        if (r1 == false) goto L42;
        int r5 = r10.u;
        int r7 = r10.w;
        if (r5 != r2) goto L35;
        if (r7 != r3) goto L35;
        return;
    L35:
        long r8 = RangesKt.coerceAtLeast(r10.M, 0);
        if (r8 != 0) goto L38;
        r10.f(r2, r3, r11, true);
        return;
    L38:
        ValueAnimator r4 = r10.s;
        if (r4 == null) goto L41;
        r4.cancel();
    L41:
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r6.setDuration(r8);
        r6.setInterpolator(r10.N);
        r6.addUpdateListener(new h(r10, r5, r2, r7, r3, r11));
        r6.addListener(new i(r10, r2, r3, r11));
        r6.start();
        r10.s = r6;
        return;
    L42:
        ValueAnimator r9 = r10.s;
        if (r9 == null) goto L45;
        r9.cancel();
    L45:
        r10.f(r2, r3, r11, true);
        return;
    L20:
        if (ViewCompat.isLaidOut(r10.f) == false) goto L30;
        if (r10.y == true) goto L30;
        if (r10.K == true) goto L30;
        if (r10.u == r2) goto L28;
    L29:
        r1 = true;
        goto L30
    L28:
        if (r10.w == r3) goto L30;
    L15:
        if (r10.w != r3) goto L17;
        return;
    L11:
        r3 = 0;
        goto L12
    L8:
        r2 = 0;
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
