package sga;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ View a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ViewTreeObserver r0 = this.a.getViewTreeObserver();
        if (r0.isAlive() == false) goto L5;
        r0.removeOnPreDrawListener(this);
    L5:
        this.a.post(new c());
        return true;
    }

    public d(View r1) {
        this.a = r1;
    }
}
