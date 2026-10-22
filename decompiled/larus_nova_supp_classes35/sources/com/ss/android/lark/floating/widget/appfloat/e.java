package com.ss.android.lark.floating.widget.appfloat;

import android.animation.ValueAnimator;
import android.graphics.Point;
import android.view.View;
import android.view.WindowManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ h a;
    public final /* synthetic */ WindowManager b;
    public final /* synthetic */ View c;
    public final /* synthetic */ ValueAnimator d;

    public e(h r1, WindowManager r2, d r3, ValueAnimator r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        Object r4 = r3.getAnimatedValue();     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.graphics.Point");     // Catch: Exception -> L5
        Point r5 = (Point) r4;     // Catch: Exception -> L5
        h r0 = this.a;     // Catch: Exception -> L5
        int r1 = r5.x;     // Catch: Exception -> L5
        WindowManagerLayoutParamsInternal r2 = r0.a;     // Catch: Exception -> L5
        ((WindowManager.LayoutParams) r2).x = r1;     // Catch: Exception -> L5
        ((WindowManager.LayoutParams) r2).y = r5.y;     // Catch: Exception -> L5
        this.b.updateViewLayout(this.c, r2);     // Catch: Exception -> L5
        return;
    L5:
        this.d.cancel();
    }
}
