package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.StyleRes;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public class ComponentDialog extends Dialog implements LifecycleOwner, OnBackPressedDispatcherOwner {
    private LifecycleRegistry _lifecycleRegistry;
    private final OnBackPressedDispatcher onBackPressedDispatcher;

    @JvmOverloads
    public ComponentDialog(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, 0, 2, null);
    }

    @JvmOverloads
    public ComponentDialog(Context r10, @StyleRes int r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.onBackPressedDispatcher = new OnBackPressedDispatcher(new d(this));
    }

    public /* synthetic */ ComponentDialog(Context r10, int r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = 0;
    L5:
        this(r10, r11);
    }

    public static /* synthetic */ void a(ComponentDialog r10) {
        m0onBackPressedDispatcher$lambda1(r10);
    }

    private final LifecycleRegistry getLifecycleRegistry() {
        LifecycleRegistry r10 = this._lifecycleRegistry;
        if (r10 != null) goto L6;
        LifecycleRegistry r11 = new LifecycleRegistry(this);
        this._lifecycleRegistry = r11;
        return r11;
    L6:
        return r10;
    }

    private static /* synthetic */ void getOnBackPressedDispatcher$annotations() {
    }

    private final void initViewTreeOwners() {
        Window r10 = getWindow();
        Intrinsics.checkNotNull(r10);
        ViewTreeLifecycleOwner.set(r10.getDecorView(), this);
        Window r11 = getWindow();
        Intrinsics.checkNotNull(r11);
        View r12 = r11.getDecorView();
        Intrinsics.checkNotNullExpressionValue(r12, "window!!.decorView");
        ViewTreeOnBackPressedDispatcherOwner.set(r12, this);
    }

    /* JADX INFO: renamed from: onBackPressedDispatcher$lambda-1, reason: not valid java name */
    private static final void m0onBackPressedDispatcher$lambda1(ComponentDialog r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View r10, ViewGroup.LayoutParams r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        initViewTreeOwners();
        super.addContentView(r10, r11);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return getLifecycleRegistry();
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher;
    }

    @Override // android.app.Dialog
    @CallSuper
    public void onBackPressed() {
        this.onBackPressedDispatcher.onBackPressed();
    }

    @Override // android.app.Dialog
    @CallSuper
    protected void onCreate(Bundle r10) {
        super.onCreate(r10);
        if (Build.VERSION.SDK_INT < 33) goto L5;
        this.onBackPressedDispatcher.setOnBackInvokedDispatcher(getOnBackInvokedDispatcher());
    L5:
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Dialog
    @CallSuper
    protected void onStart() {
        super.onStart();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Dialog
    @CallSuper
    protected void onStop() {
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this._lifecycleRegistry = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int r10) {
        initViewTreeOwners();
        super.setContentView(r10);
    }

    @Override // android.app.Dialog
    public void setContentView(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        initViewTreeOwners();
        super.setContentView(r10);
    }

    @Override // android.app.Dialog
    public void setContentView(View r10, ViewGroup.LayoutParams r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        initViewTreeOwners();
        super.setContentView(r10, r11);
    }
}
