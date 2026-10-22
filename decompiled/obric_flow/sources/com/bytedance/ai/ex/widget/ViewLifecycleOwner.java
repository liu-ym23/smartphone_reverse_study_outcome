package com.bytedance.ai.ex.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/ex/widget/ViewLifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "windowVisibleListener", "Landroid/view/ViewTreeObserver$OnWindowVisibilityChangeListener;", "windowFocusListener", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "registry", "Landroidx/lifecycle/LifecycleRegistry;", "onCreate", "", "onDestroy", "updateState", "getLifecycle", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ViewLifecycleOwner implements LifecycleOwner {
    private final LifecycleRegistry registry;
    private final View view;
    private final ViewTreeObserver.OnWindowFocusChangeListener windowFocusListener;
    private final ViewTreeObserver.OnWindowVisibilityChangeListener windowVisibleListener;

    public ViewLifecycleOwner(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        this.view = r5;
        int r10 = 1;
        this.windowVisibleListener = new e(this, r10);
        this.windowFocusListener = new d(this, r10);
        this.registry = new LifecycleRegistry(this);
    }

    public static /* synthetic */ void a(ViewLifecycleOwner r5, int r10) {
        windowVisibleListener$lambda$0(r5, r10);
    }

    public static /* synthetic */ void b(ViewLifecycleOwner r5, boolean r10) {
        windowFocusListener$lambda$1(r5, r10);
    }

    private final void updateState() {
        LifecycleRegistry r5 = this.registry;
        if (this.view.getWindowVisibility() == 0) goto L6;
        Lifecycle.State r10 = Lifecycle.State.CREATED;
    L9:
        r5.setCurrentState(r10);
        return;
    L6:
        if (this.view.hasWindowFocus() == true) goto L8;
        r10 = Lifecycle.State.STARTED;
        goto L9
    L8:
        r10 = Lifecycle.State.RESUMED;
        goto L9
    }

    private static final void windowFocusListener$lambda$1(ViewLifecycleOwner r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        r5.updateState();
    }

    private static final void windowVisibleListener$lambda$0(ViewLifecycleOwner r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        r5.updateState();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return getLifecycle();
    }

    public final void onCreate() {
        this.registry.setCurrentState(Lifecycle.State.CREATED);
        androidx.room.b.n(this.view.getViewTreeObserver(), this.windowVisibleListener);
        this.view.getViewTreeObserver().addOnWindowFocusChangeListener(this.windowFocusListener);
        updateState();
    }

    public final void onDestroy() {
        androidx.room.b.g(this.view.getViewTreeObserver(), this.windowVisibleListener);
        this.view.getViewTreeObserver().removeOnWindowFocusChangeListener(this.windowFocusListener);
        this.registry.setCurrentState(Lifecycle.State.DESTROYED);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public LifecycleRegistry getLifecycle() {
        return this.registry;
    }
}
