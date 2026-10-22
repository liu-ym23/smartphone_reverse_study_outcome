package fc8;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.utils.CubicBezierInterpolator;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ View a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.a.setTranslationY(c7.b(40));
        this.a.animate().setDuration(240).setInterpolator(new CubicBezierInterpolator(0.23f, 0.0f, 0.58f)).translationY(0.0f).start();
    }

    public a(View r1) {
        this.a = r1;
    }
}
