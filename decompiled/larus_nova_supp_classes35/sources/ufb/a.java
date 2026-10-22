package ufb;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.WindowManager;
import com.ss.android.lark.floating.widget.appfloat.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ h a;
    public final /* synthetic */ WindowManager b;
    public final /* synthetic */ View c;

    public a(h r1, WindowManager r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        h r0 = this.a;
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");
        ((WindowManager.LayoutParams) r0.a).x = ((Integer) r4).intValue();
        this.b.updateViewLayout(this.c, this.a.a);
    }
}
