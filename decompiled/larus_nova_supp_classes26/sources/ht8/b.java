package ht8;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ Runnable b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.b.run();
        return false;
    }

    public b(View r1, Runnable r2) {
        this.a = r1;
        this.b = r2;
    }
}
