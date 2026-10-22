package com.larus.bmhome.chat.component.bottom.core;

import android.animation.ValueAnimator;
import android.view.ViewTreeObserver;
import android.view.animation.PathInterpolator;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b7 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ ConstraintLayout a;
    public final /* synthetic */ CoreInputComponent b;
    public final /* synthetic */ CoreInputComponent$b c;
    public final /* synthetic */ EditText d;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        CoreInputComponent$b r0 = this.b.G;
        CoreInputComponent$b r1 = this.c;
        if (r0 == r1) goto L5;
        return true;
    L5:
        r1.k = null;
        r1.g = this.d.getLeft();
        CoreInputComponent$b r2 = this.c;
        r2.h = this.a.getWidth() - this.d.getRight();
        CoreInputComponent$b r3 = this.c;
        int r4 = r3.g;
        int r5 = r3.c;
        if (r4 == r5) goto L8;
    L11:
        boolean r6 = true;
    L13:
        if (r3.e == r3.a) goto L15;
    L18:
        boolean r7 = true;
    L19:
        if (r6 == true) goto L23;
        if (r7 == true) goto L23;
        this.b.h4();
        return true;
    L23:
        this.b.z5(this.d, r5, r3.d);
        final CoreInputComponent r8 = this.b;
        final CoreInputComponent$b r9 = this.c;
        r8.getClass();
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r10.setDuration(r9.i);
        r10.setInterpolator((PathInterpolator) r8.Z2.getValue());
        r10.addUpdateListener(new z6(r8, r9));
        r10.addListener(new p7(r8, r9));
        r10.start();
        r9.j = r10;
        return false;
    L15:
        if (r3.f != r3.b) goto L18;
        r7 = false;
        goto L19
    L8:
        if (r3.h != r3.d) goto L11;
        r6 = false;
        goto L13
    }

    public b7(ConstraintLayout r1, CoreInputComponent r2, CoreInputComponent$b r3, EditText r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
