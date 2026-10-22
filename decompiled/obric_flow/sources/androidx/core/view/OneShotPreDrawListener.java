package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class OneShotPreDrawListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    private final Runnable mRunnable;
    private final View mView;
    private ViewTreeObserver mViewTreeObserver;

    private OneShotPreDrawListener(View r5, Runnable r10) {
        this.mView = r5;
        this.mViewTreeObserver = r5.getViewTreeObserver();
        this.mRunnable = r10;
    }

    @NonNull
    public static OneShotPreDrawListener add(@NonNull View r5, @NonNull Runnable r10) {
        if (r5 == null) goto L9;
        if (r10 == null) goto L7;
        OneShotPreDrawListener r11 = new OneShotPreDrawListener(r5, r10);
        r5.getViewTreeObserver().addOnPreDrawListener(r11);
        r5.addOnAttachStateChangeListener(r11);
        return r11;
    L7:
        throw new NullPointerException("runnable == null");
    L9:
        throw new NullPointerException("view == null");
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        removeListener();
        this.mRunnable.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NonNull View r5) {
        this.mViewTreeObserver = r5.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NonNull View r5) {
        removeListener();
    }

    public void removeListener() {
        if (this.mViewTreeObserver.isAlive() == false) goto L5;
        this.mViewTreeObserver.removeOnPreDrawListener(this);
    L6:
        this.mView.removeOnAttachStateChangeListener(this);
        return;
    L5:
        this.mView.getViewTreeObserver().removeOnPreDrawListener(this);
        goto L6
    }
}
