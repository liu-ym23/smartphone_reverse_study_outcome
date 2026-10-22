package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class OneShotPreDrawListener implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
    private final Runnable mRunnable;
    private final View mView;
    private ViewTreeObserver mViewTreeObserver;

    private OneShotPreDrawListener(View r3, Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        this.mView = r3;
        this.mViewTreeObserver = r3.getViewTreeObserver();
        this.mRunnable = r5;
    }

    public static OneShotPreDrawListener add(View r2, Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r2, "view == null");
        Objects.requireNonNull(r4, "runnable == null");
        OneShotPreDrawListener r0 = new OneShotPreDrawListener(r2, r4);
        r2.getViewTreeObserver().addOnPreDrawListener(r0);
        r2.addOnAttachStateChangeListener(r0);
        return r0;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        removeListener();
        this.mRunnable.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r1) {
        this.mViewTreeObserver = r1.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r1) {
        removeListener();
    }

    public void removeListener() {
        if (this.mViewTreeObserver.isAlive() == false) goto L5;
        ViewTreeObserver r0 = this.mViewTreeObserver;
    L6:
        r0.removeOnPreDrawListener(this);
        this.mView.removeOnAttachStateChangeListener(this);
        return;
    L5:
        r0 = this.mView.getViewTreeObserver();
        goto L6
    }
}
