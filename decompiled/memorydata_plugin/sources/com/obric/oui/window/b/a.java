package com.obric.oui.window.b;

import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.obric.oui.c.a.b;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.c;
import com.obric.oui.material.l;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bJ\b\u0010\u001e\u001a\u00020\u0019H\u0002J\u0006\u0010\u001f\u001a\u00020\u0019J\u0006\u0010 \u001a\u00020\u0019J\"\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u000e2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00190$J\b\u0010&\u001a\u00020\u0019H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/oui/window/floating/OFloatingWindowHelper;", "", "targetView", "Landroid/view/View;", "(Landroid/view/View;)V", "currentBlurRadius", "", "gravity", "", "getGravity", "()I", "setGravity", "(I)V", "isAddedToWindowManager", "", "isFloatingType", "()Z", "setFloatingType", "(Z)V", "mParentGroup", "Landroid/view/ViewGroup;", "parentAttachStateChangeListener", "com/obric/oui/window/floating/OFloatingWindowHelper$parentAttachStateChangeListener$1", "Lcom/obric/oui/window/floating/OFloatingWindowHelper$parentAttachStateChangeListener$1;", "applyBlur", "", "maskView", "maskMaterialConfig", "Lcom/obric/oui/material/MaterialConfig;", "srcType", "attachToWindowManager", "onAttachedToWindow", "removeFromWindowManager", "setupInsets", "fitInset", "updateLayout", "Lkotlin/Function1;", "Lcom/obric/oui/view/Insets;", "updateHeight", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f14885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f14886b;
    private int c;
    private boolean d;
    private ViewGroup e;
    private float f;
    private final ViewOnAttachStateChangeListenerC0794a g;

    /* JADX INFO: renamed from: com.obric.oui.window.b.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/oui/window/floating/OFloatingWindowHelper$parentAttachStateChangeListener$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", BaseSwitches.V, "Landroid/view/View;", "onViewDetachedFromWindow", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewOnAttachStateChangeListenerC0794a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f14887a;

        ViewOnAttachStateChangeListenerC0794a(a r1) {
            this.f14887a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r1) {
            Intrinsics.checkNotNullParameter(r1, BaseSwitches.V);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, BaseSwitches.V);
            this.f14887a.b();
        }
    }

    public a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "targetView");
        this.f14885a = r2;
        this.c = 1;
        this.g = new ViewOnAttachStateChangeListenerC0794a(this);
    }

    private static final WindowInsets a(final a r4, Function1 r5, View r6, WindowInsets r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "this$0");
        Intrinsics.checkNotNullParameter(r8, "$updateLayout");
        Intrinsics.checkNotNullParameter(r6, "$noName_0");
        Intrinsics.checkNotNullParameter(r7, "insets");
        if (r4.f14886b == true) goto L5;
    L15:
        com.obric.oui.window.a r9 = com.obric.oui.window.a.f14878a;
        r8.invoke(com.obric.oui.window.a.a(r4.f14885a, r7, true));
    L16:
        return r7;
    L5:
        if (r4.d == false) goto L15;
        if (Build.VERSION.SDK_INT < 23) goto L16;
        ViewGroup r10 = r4.e;
        if (r10 == null) goto L16;
        WindowInsets r11 = r10.getRootWindowInsets();
        if (r11 == null) goto L16;
        com.obric.oui.window.a r2 = com.obric.oui.window.a.f14878a;
        ViewGroup r3 = r4.e;
        Intrinsics.checkNotNull(r3);
        r8.invoke(com.obric.oui.window.a.a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"), r11, true));
        r4.f14885a.post(new $$Lambda$a$tcuXuUQuoN0OPIjkCjEdjtGD7VQ(r4));
        goto L16
    }

    private static final void a(a r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.d();
    }

    private static final void b(a r9) {
        Intrinsics.checkNotNullParameter(r9, "this$0");
        if (r9.f14885a.isAttachedToWindow() == true) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r9.f14885a.getParent(), ViewGroup.class) == false) goto L38;
        ViewParent r0 = r9.f14885a.getParent();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.memorydata.plugin");
        r9.e = r1;
        if (r1 == null) goto L10;
        r1.removeView(r9.f14885a);
    L10:
        ViewGroup r2 = r9.e;
        if (r2 == null) goto L14;
        r2.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(r9.g, View.OnAttachStateChangeListener.class, "com.obric.memorydata.plugin"));
    L14:
        Object r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.f14885a.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("window");
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager r4 = (WindowManager) ZeusTransformUtils.preCheckCast(r3, WindowManager.class, "com.obric.memorydata.plugin");
        WindowManager.LayoutParams r5 = new WindowManager.LayoutParams(-1, -2, 1000, 16778024, -3);
        r5.gravity = r9.c;
        if (Build.VERSION.SDK_INT < 30) goto L17;
        r5.setFitInsetsSides(0);
    L17:
        ViewGroup r6 = r9.e;
        if (r6 != null) goto L20;
        IBinder r7 = null;
    L21:
        r5.token = r7;
        r4.addView(r9.f14885a, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L32
        r9.d = true;     // Catch: Exception -> L32
        if (Build.VERSION.SDK_INT < 23) goto L39;
        ViewGroup r8 = r9.e;     // Catch: Exception -> L32
        if (r8 != null) goto L28;
        return;
    L28:
        if (r8.getRootWindowInsets() == null) goto L41;
        r9.f14885a.requestApplyInsets();     // Catch: Exception -> L32
        return;
    L41:
        return;
    L39:
        return;
    L32:
        e = move-exception;
        b.e("OFloatingWindowHelper", Intrinsics.stringPlus("Failed to add view to WindowManager: ", e.getMessage()));
        return;
    L20:
        r7 = r6.getWindowToken();
        goto L21
    }

    private final void c() {
        if (this.d == false) goto L5;
        return;
    L5:
        this.f14885a.post(new $$Lambda$a$KobSjUFTiXmPAdL27FA4kOSnK9c(this));
    }

    private final void d() {
        if (this.d == false) goto L14;
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f14885a.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("window");
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager r1 = (WindowManager) ZeusTransformUtils.preCheckCast(r0, WindowManager.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r2 = this.f14885a.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r2, WindowManager.LayoutParams.class) == false) goto L7;
        WindowManager.LayoutParams r3 = (WindowManager.LayoutParams) ZeusTransformUtils.preCheckCast(r2, WindowManager.LayoutParams.class, "com.obric.memorydata.plugin");
    L8:
        int r4 = this.f14885a.getMeasuredHeight();
        if (r3 != null) goto L11;
        return;
    L11:
        if (r3.height == r4) goto L16;
        r3.height = r4;
        r1.updateViewLayout(this.f14885a, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L16:
        return;
    L7:
        r3 = null;
        goto L8
    }

    public static /* synthetic */ void lambda$KobSjUFTiXmPAdL27FA4kOSnK9c(a r0) {
        b(r0);
    }

    public static /* synthetic */ WindowInsets lambda$TgmU27f3rqg0bCYa4R17TS7sDFI(a r0, Function1 r1, View r2, WindowInsets r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$tcuXuUQuoN0OPIjkCjEdjtGD7VQ(a r0) {
        a(r0);
    }

    public final void a() {
        if (this.f14886b == true) goto L5;
        return;
    L5:
        if (this.d == true) goto L9;
        c();
        return;
    }

    public final void a(int r1) {
        this.c = r1;
    }

    public final void a(View r2, c r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "maskView");
        Intrinsics.checkNotNullParameter(r3, "maskMaterialConfig");
        com.obric.oui.blur.a r0 = r3.g();
        Intrinsics.checkNotNull(r0);
        float r1 = r0.a();
        this.f = r1;
        if (r1 <= 0.0f) goto L5;
        OMaterialHelper.a(r2, r3, r4);
    L6:
        l.a(r2, r2);
        return;
    L5:
        OMaterialHelper.b(r2, 0);
        goto L6
    }

    public final void a(boolean r1) {
        this.f14886b = r1;
    }

    public final void a(boolean r3, Function1<? super com.obric.oui.view.b, Unit> r4) {
        final Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "updateLayout");
        if (r3 == false) goto L6;
        com.obric.oui.window.a r6 = com.obric.oui.window.a.f14878a;
        r5.invoke(com.obric.oui.window.a.a(this.f14885a, null, true));
        this.f14885a.setOnApplyWindowInsetsListener(new $$Lambda$a$TgmU27f3rqg0bCYa4R17TS7sDFI(this, r5));
        return;
    }

    public final void b() {
        if (this.d == false) goto L18;
        Object r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f14885a.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("window");     // Catch: Exception -> L9
        if (r1 == null) goto L8;
        ((WindowManager) ZeusTransformUtils.preCheckCast(r1, WindowManager.class, "com.obric.memorydata.plugin")).removeViewImmediate(this.f14885a);     // Catch: Exception -> L9
    L11:
        this.d = false;
        ViewGroup r2 = this.e;
        if (r2 == null) goto L15;
        r2.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(this.g, View.OnAttachStateChangeListener.class, "com.obric.memorydata.plugin"));
    L15:
        this.e = null;
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");     // Catch: Exception -> L9
    L9:
        e = move-exception;
        b.e("OFloatingWindowHelper", Intrinsics.stringPlus("Failed to remove view from WindowManager: ", e.getMessage()));
        goto L11
    }
}
