package com.larus.bmhome.view.screenmenu;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.core.content.ContextCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x0 {
    public ScreenMenuLayout a;
    public WeakReference<Fragment> b;
    public WeakReference<FragmentActivity> c;
    public WeakReference<FrameLayout> d;
    public boolean e;

    public x0() {
    }

    public final void c() {
        ScreenMenuLayout r0 = this.a;
        if (r0 == null) goto L6;
        r0.f(new y0());
        Unit r1 = Unit.INSTANCE;
        return;
    }

    public final FragmentActivity e() {
        WeakReference<Fragment> r0 = this.b;
        ViewParent r1 = null;
        if (r0 == null) goto L46;
        Fragment r2 = r0.get();
        if (r2 == null) goto L46;
        if (r2.isAdded() == false) goto L46;
        if (r2.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L46;
        FragmentActivity r3 = r2.getActivity();
        if (r3 != null) goto L15;
        return null;
    L15:
        FrameLayout r4 = f(r2);
        if (r4 != null) goto L23;
        View r5 = a(r3.getWindow());
        if ((r5 instanceof FrameLayout) == false) goto L20;
        FrameLayout r6 = (FrameLayout) r5;
    L21:
        if (r6 != null) goto L24;
        r6 = (FrameLayout) r3.findViewById(R.id.content);
    L24:
        WeakReference<FragmentActivity> r7 = this.c;
        if (r7 == null) goto L27;
        FragmentActivity r8 = r7.get();
    L28:
        boolean r9 = true;
        if (r8 != r3) goto L43;
        WeakReference<FrameLayout> r10 = this.d;
        if (r10 == null) goto L33;
        FrameLayout r11 = r10.get();
    L34:
        if (r11 != r6) goto L43;
        ScreenMenuLayout r12 = this.a;
        if (r12 == null) goto L38;
        r1 = r12.getParent();
    L38:
        if (r1 != r6) goto L43;
        if (r6.indexOfChild(this.a) != (r6.getChildCount() - 1)) goto L43;
        r9 = false;
        goto L43
    L33:
        r11 = null;
    L43:
        if (r9 == false) goto L45;
        g(r2, r4);
    L45:
        return r3;
    L27:
        r8 = null;
        goto L28
    L20:
        r6 = null;
        goto L21
    L23:
        r6 = r4;
    L46:
        return null;
    }

    public final boolean h() {
        ScreenMenuLayout r0 = this.a;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getVisibility() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 != true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r1 = false;
        goto L8
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static FrameLayout f(Fragment r2) {
        if ((r2 instanceof DialogFragment) == false) goto L5;
        DialogFragment r3 = (DialogFragment) r2;
    L6:
        if (r3 == null) goto L18;
        Dialog r4 = r3.getDialog();
        if (r4 == null) goto L20;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L13;
        View r6 = a(r5);
    L15:
        if ((r6 instanceof FrameLayout) == true) goto L17;
        return null;
    L17:
        return (FrameLayout) r6;
    L13:
        r6 = null;
        goto L15
    L20:
        return null;
    L18:
        return null;
    L5:
        r3 = null;
        goto L6
    }

    public final void d(final Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        this.b = new WeakReference(r3);
        if (r3.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L5;
        g(r3, f(r3));
    L5:
        r3.getLifecycle().addObserver(new ScreenMenu$create$1$1(this, r3));
    }

    public final void i(Function1<? super View, r0> r2) {
        Intrinsics.checkNotNullParameter(r2, "locateAction");
        ScreenMenuLayout r0 = this.a;
        if (r0 == null) goto L6;
        r0.setMenuLocate$common_ui_mainlandRelease(r2);
        return;
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [com.larus.bmhome.view.screenmenu.v0] */
    public final void g(Fragment r4, FrameLayout r5) {
        final FragmentActivity r0 = r4.requireActivity();
        if (this.e == true) goto L5;
        final ?? r1 = new v0(this);
        OnBackPressedCallback r2 = new ScreenMenu$addOnBackPressed$callback$1(r1, r0);
        r0.getOnBackPressedDispatcher().addCallback(r4, r2);
        this.e = true;
    L5:
        this.c = new WeakReference(r0);
        View r6 = r5;
        if (r5 != null) goto L9;
        r6 = a(r0.getWindow());
    L9:
        Intrinsics.checkNotNull(r6);
        if ((r6 instanceof FrameLayout) == true) goto L12;
        View r7 = r0.findViewById(R.id.content);
        Intrinsics.checkNotNull(r7);
        FrameLayout r8 = (FrameLayout) r7;
    L13:
        this.d = new WeakReference(r8);
        ScreenMenuLayout r3 = (ScreenMenuLayout) r8.findViewWithTag(r4);
        if (r3 != null) goto L16;
        ScreenMenuLayout r9 = new ScreenMenuLayout(r0);
        this.a = r9;
        Intrinsics.checkNotNull(r9);
        r9.setTag(r4);
        r8.addView(this.a);
    L17:
        ScreenMenuLayout r10 = this.a;
        Intrinsics.checkNotNull(r10);
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r12 = (FrameLayout.LayoutParams) r11;
        r12.width = -1;
        r12.height = -1;
        ScreenMenuLayout r13 = this.a;
        Intrinsics.checkNotNull(r13);
        r13.getClass();
        r13.f(new y0());
        return;
    L16:
        r8.removeView(r3);
        this.a = r3;
        r8.addView(r3);
        goto L17
    L12:
        r8 = (FrameLayout) r6;
        goto L13
    }

    public static final void b(x0 r2, FragmentActivity r3, Fragment r4) {
        WeakReference<FrameLayout> r0 = r2.d;
        if (r0 == null) goto L6;
        FrameLayout r1 = r0.get();
        if (r1 == null) goto L6;
    L11:
        ScreenMenuLayout r5 = (ScreenMenuLayout) r1.findViewWithTag(r4);
        if (r5 == null) goto L14;
        r5.f(new y0());
    L14:
        if (r5 == null) goto L16;
        r5.setTag(null);
    L16:
        r1.removeView(r5);
        r2.d = null;
        return;
    L6:
        if (r3 == null) goto L8;
        r1 = (FrameLayout) r3.findViewById(R.id.content);
    L9:
        if (r1 != null) goto L11;
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void j(final View r2, boolean r3, final Bitmap r4, Function0<? extends View> r5) {
        Intrinsics.checkNotNullParameter(r2, "anchor");
        Intrinsics.checkNotNullParameter(r4, "bitmap");
        Intrinsics.checkNotNullParameter(r5, "menuViewHolder");
        k(r2, r3, new w0(r2, r4), r5);
    }

    public final void k(View r16, boolean r17, Function0<? extends View> r18, Function0<? extends View> r19) {
        Intrinsics.checkNotNullParameter(r16, "anchor");
        Intrinsics.checkNotNullParameter(r18, "itemViewHolder");
        Intrinsics.checkNotNullParameter(r19, "menuViewHolder");
        FragmentActivity r6 = e();
        if (r6 != null) goto L5;
        return;
    L5:
        r6.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0f, 0.0f, 0));
        ScreenMenuLayout r7 = this.a;
        if (r7 == null) goto L75;
        Intrinsics.checkNotNullParameter(r16, "anchor");
        Intrinsics.checkNotNullParameter(r18, "itemViewHolder");
        Intrinsics.checkNotNullParameter(r19, "menuViewHolder");
        r7.removeAllViews();
        if (r17 == true) goto L10;
    L18:
        View r0 = (View) r18.invoke();
        r7.addView(r0);
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2;
        r3.width = r16.getWidth();
        r3.height = r16.getHeight();
        int[] r9 = new int[2];
        r16.getLocationOnScreen(r9);
        int[] r10 = new int[2];
        r7.getLocationOnScreen(r10);
        ViewParent r11 = r7.getParent();
        ViewGroup r13 = null;
        if ((r11 instanceof ViewGroup) == false) goto L21;
        ViewGroup r12 = (ViewGroup) r11;
    L22:
        if (r12 == null) goto L24;
        int r14 = r12.getPaddingTop();
    L25:
        r3.gravity = 51;
        r3.leftMargin = r9[0] - r10[0];
        boolean r4 = true;
        r0.setY(r9[1] - r14);
        int r15 = com.larus.utils.m0.a;
        int r110 = com.larus.utils.m0.a(r7.getContext());
        int r111 = r9[1] + r16.getHeight();
        int r112 = ScreenMenuLayout.h;
        if ((r111 + r112) <= r110) goto L28;
        r0.setY(((r110 - r112) - r16.getHeight()) - r14);
    L29:
        View r1 = (View) r19.invoke();
        r7.b = r16;
        r7.c = r1;
        r7.addView(r1);
        ViewGroup.LayoutParams r5 = r1.getLayoutParams();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r8 = (FrameLayout.LayoutParams) r5;
        r8.width = -2;
        r8.height = -2;
        r8.gravity = 1;
        Function1<? super View, r0> r20 = r7.a;
        if (r20 == null) goto L33;
        r0 r21 = (r0) r20.invoke(r1);
        if (r21 == null) goto L33;
    L34:
        int[] r22 = new int[2];
        r16.getLocationOnScreen(r22);
        int r23 = com.larus.utils.m0.a(r7.getContext());
        if (((r22[1] + r16.getHeight()) + r112) <= r23) goto L38;
        r22[1] = (r23 - r112) - r16.getHeight();
    L38:
        if (r1.getHeight() <= 0) goto L40;
        int r24 = r1.getHeight();
    L41:
        ViewParent r113 = r7.getParent();
        if ((r113 instanceof ViewGroup) == false) goto L44;
        r13 = (ViewGroup) r113;
    L44:
        if (r13 == null) goto L46;
        int r114 = r13.getPaddingTop();
    L47:
        int r25 = r22[1];
        int r115 = ScreenMenuLayout.i;
        int r116 = ((r25 - r115) - r24) - r114;
        int r26 = ((r25 + r16.getHeight()) + r115) - r114;
        int r27 = r112 - r114;
        int r28 = Math.max(r27, ((r23 - r112) - r24) - r114);
        if (r116 < (r21.b + r27)) goto L50;
        boolean r29 = true;
    L51:
        if (r26 <= r28) goto L54;
        r4 = false;
    L54:
        boolean r30 = r21.a;
        if (r30 == false) goto L58;
        if (r29 == false) goto L58;
    L66:
        float r31 = r116;
    L71:
        r1.setY(r31);
        r7.setVisibility(0);
        OneShotPreDrawListener.add(r7, new d1(r7, r7));
        return;
    L58:
        if (r30 == false) goto L61;
        if (r4 == false) goto L61;
    L63:
        r31 = r26;
    L61:
        if (r30 == true) goto L64;
        if (r4 == true) goto L63;
    L64:
        if (r30 == true) goto L67;
        if (r29 == true) goto L66;
    L67:
        if (r30 == false) goto L69;
        int r32 = RangesKt.coerceIn(r116, r27, r28);
    L70:
        r31 = r32;
        goto L71
    L69:
        r32 = RangesKt.coerceIn(r26, r27, r28);
        goto L70
    L50:
        r29 = false;
        goto L51
    L46:
        r114 = 0;
        goto L47
    L40:
        r1.measure(View.MeasureSpec.makeMeasureSpec(-2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(-2, Integer.MIN_VALUE));
        r24 = r1.getMeasuredHeight();
    L33:
        r21 = new r0(false, 0);
        goto L34
    L28:
        r0.setY(r9[1] - r14);
        goto L29
    L24:
        r14 = 0;
        goto L25
    L21:
        r12 = null;
        goto L22
    L10:
        if (Build.VERSION.SDK_INT < 31) goto L18;
        View r33 = new View(r7.getContext());     // Catch: Exception -> L16
        Activity r34 = AppHost.a.a().getCurrentActivity();     // Catch: Exception -> L16
        if (r34 == null) goto L14;
        r33.setBackground(new BitmapDrawable(r34.getResources(), ScreenMenuLayout.c(r34)));     // Catch: Exception -> L16
        r33.setForeground(new ColorDrawable(ContextCompat.getColor(r7.getContext(), 2131103273)));     // Catch: Exception -> L16
    L14:
        r7.addView(r33, 0, new ViewGroup.LayoutParams(-1, -1));     // Catch: Exception -> L16
        r33.setRenderEffect(RenderEffect.createBlurEffect(48.0f, 48.0f, Shader.TileMode.CLAMP));     // Catch: Exception -> L16
    L16:
        e = move-exception;
        FLogger.a.e("FullScreenMenuLayout", "showBlurView exception e=" + e.getMessage());
        com.larus.platform.service.g.a.ensureNotReachHere(e);
        goto L18
    }
}
