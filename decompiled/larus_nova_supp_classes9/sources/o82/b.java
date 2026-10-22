package o82;

import android.animation.ValueAnimator;
import android.view.Window;
import android.view.WindowManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ Ref.IntRef a;
    public final /* synthetic */ Window b;

    public b(Ref.IntRef r1, Window r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        int r0 = f.a;
        if (f.a(this.b) == false) goto L24;
        Window r1 = this.b;
        if (r1 == null) goto L10;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        if (r2 == null) goto L10;
        r2.x = f.c + ((int) (this.a.element * r5.getAnimatedFraction()));
    L10:
        if (r5.getAnimatedFraction() != 1.0f) goto L20;
        f.c = f.b;
        Window r6 = this.b;
        if (r6 == null) goto L16;
        WindowManager.LayoutParams r7 = r6.getAttributes();
        if (r7 == null) goto L16;
        r7.x = f.c;
    L16:
        Window r8 = this.b;
        if (r8 == null) goto L19;
        r8.setAttributes(r8.getAttributes());
    L19:
        f.e.cancel();
    L20:
        Window r9 = this.b;
        if (r9 == null) goto L25;
        r9.setAttributes(r9.getAttributes());
        return;
    L25:
        return;
    }
}
