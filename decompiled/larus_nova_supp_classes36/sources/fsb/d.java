package fsb;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements View.OnAttachStateChangeListener {
    public final /* synthetic */ f.a a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r1) {
    }

    public d(f.a r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
        f.a.a(this.a);
    }
}
