package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class OneShotPreDrawListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    private final Runnable mRunnable;
    private final View mView;
    private ViewTreeObserver mViewTreeObserver;

    private OneShotPreDrawListener(View r10, Runnable r11) {
        this.mView = r10;
        this.mViewTreeObserver = r10.getViewTreeObserver();
        this.mRunnable = r11;
    }

    @NonNull
    public static OneShotPreDrawListener add(@NonNull View r10, @NonNull Runnable r11) {
        Objects.requireNonNull(r10, "view == null");
        Objects.requireNonNull(r11, "runnable == null");
        OneShotPreDrawListener r12 = new OneShotPreDrawListener(r10, r11);
        r10.getViewTreeObserver().addOnPreDrawListener(r12);
        r10.addOnAttachStateChangeListener(r12);
        return r12;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        removeListener();
        this.mRunnable.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NonNull View r10) {
        this.mViewTreeObserver = r10.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NonNull View r10) {
        removeListener();
    }

    public void removeListener() {
        if (this.mViewTreeObserver.isAlive() == false) goto L5;
        ViewTreeObserver r10 = this.mViewTreeObserver;
    L6:
        r10.removeOnPreDrawListener(this);
        this.mView.removeOnAttachStateChangeListener(this);
        return;
    L5:
        r10 = this.mView.getViewTreeObserver();
        goto L6
    }
}
