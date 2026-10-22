package j0;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public final class r implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f8434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewTreeObserver f8435b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Runnable f8436m;

    public r(View r8, Runnable r10) {
        this.f8434a = r8;
        this.f8435b = r8.getViewTreeObserver();
        this.f8436m = r10;
    }

    public static r a(View r8, Runnable r10) {
        if (r8 == null) goto L9;
        if (r10 == null) goto L7;
        r r11 = new r(r8, r10);
        r8.getViewTreeObserver().addOnPreDrawListener(r11);
        r8.addOnAttachStateChangeListener(r11);
        return r11;
    L7:
        throw new NullPointerException("runnable == null");
    L9:
        throw new NullPointerException("view == null");
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        boolean r8 = this.f8435b.isAlive();
        View r10 = this.f8434a;
        if (r8 == false) goto L5;
        ViewTreeObserver r11 = this.f8435b;
    L6:
        r11.removeOnPreDrawListener(this);
        r10.removeOnAttachStateChangeListener(this);
        this.f8436m.run();
        return true;
    L5:
        r11 = r10.getViewTreeObserver();
        goto L6
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r8) {
        this.f8435b = r8.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r8) {
        boolean r10 = this.f8435b.isAlive();
        View r11 = this.f8434a;
        if (r10 == false) goto L5;
        ViewTreeObserver r12 = this.f8435b;
    L6:
        r12.removeOnPreDrawListener(this);
        r11.removeOnAttachStateChangeListener(this);
        return;
    L5:
        r12 = r11.getViewTreeObserver();
        goto L6
    }
}
