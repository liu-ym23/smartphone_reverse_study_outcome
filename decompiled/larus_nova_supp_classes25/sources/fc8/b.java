package fc8;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.utils.CubicBezierInterpolator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ View a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        Object r0 = this.a.getParent();
        if ((r0 instanceof View) == false) goto L5;
        View r1 = (View) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        this.a.setTranslationY(r1.getHeight() - this.a.getY());
        this.a.animate().setDuration(240).setInterpolator(new CubicBezierInterpolator(0.23f, 0.0f, 0.58f)).translationY(0.0f).start();
        return;
    L5:
        r1 = null;
        goto L6
    }

    public b(View r1) {
        this.a = r1;
    }
}
