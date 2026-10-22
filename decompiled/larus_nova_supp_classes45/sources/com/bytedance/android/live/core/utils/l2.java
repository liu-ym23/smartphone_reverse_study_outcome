package com.bytedance.android.live.core.utils;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.liveinteract.animator.LiveAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l2 implements View.OnTouchListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ float b;
    public final /* synthetic */ long c;

    public l2(View r1, float r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r7, MotionEvent r8) {
        if (r8 == null) goto L4;
        Integer r9 = Integer.valueOf(r8.getAction());
    L6:
        if (r9 != null) goto L9;
    L15:
        if (r9 != null) goto L18;
    L24:
        if (r9 != null) goto L27;
    L33:
        return false;
    L27:
        if (r9.intValue() != 3) goto L33;
        if (this.a.isEnabled() == false) goto L33;
        if (Intrinsics.areEqual(this.a.getTag(), Boolean.TRUE) == false) goto L33;
        fd0.f r11 = LiveAnimator.a(new View[]{r7});
        r11.c(LiveDegradeFpsAnimator.ALPHA, new float[]{this.b, 1.0f});
        r11.a.b = this.c;
        r11.e();
        goto L33
    L18:
        if (r9.intValue() != 1) goto L24;
        if (this.a.isEnabled() == false) goto L33;
        if (Intrinsics.areEqual(this.a.getTag(), Boolean.TRUE) == false) goto L33;
        fd0.f r12 = LiveAnimator.a(new View[]{r7});
        r12.c(LiveDegradeFpsAnimator.ALPHA, new float[]{this.b, 1.0f});
        r12.a.b = this.c;
        r12.e();
        goto L33
    L9:
        if (r9.intValue() != 0) goto L15;
        if (this.a.isEnabled() == false) goto L33;
        if (Intrinsics.areEqual(this.a.getTag(), Boolean.TRUE) == false) goto L33;
        fd0.f r13 = LiveAnimator.a(new View[]{r7});
        r13.c(LiveDegradeFpsAnimator.ALPHA, new float[]{1.0f, this.b});
        r13.a.b = this.c;
        r13.e();
        goto L33
    L4:
        r9 = null;
        goto L6
    }
}
