package v0c;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class a extends b implements View.OnAttachStateChangeListener {
    public final View d;

    public void k() {
    }

    public void l() {
    }

    public abstract View m(Context r1);

    public final void o() {
        j(-66001, null);
    }

    public final void p() {
        j(-66007, null);
    }

    public final void n() {
        j(-66015, null);
    }

    public a(Context r1) {
        super(r1);
        View r2 = m(r1);
        this.d = r2;
        r2.addOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r1) {
        k();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
        l();
    }

    public final void q(int r2) {
        this.d.setVisibility(r2);
    }
}
