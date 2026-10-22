package com.larus.common_ui.floatwindow.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.floatwindow.manager.IFloatWindowHostProvider;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class FullScreenFloatWindowHandler implements v {
    public m A;
    public WeakReference<ViewGroup> B;
    public boolean C;
    public final WeakHashMap<Dialog, DialogInterface.OnKeyListener> D;
    public final Application a;
    public final Context b;
    public WeakReference<FrameLayout> c;
    public e19.h d;
    public e19.b e;
    public View f;
    public HorizontalDragFrameLayout g;
    public View h;
    public WeakReference<Context> i;
    public WeakReference<Context> j;
    public boolean k;
    public float l;
    public int m;
    public IntRange n;
    public IntRange o;
    public IntRange p;
    public IntRange q;
    public Integer r;
    public Float s;
    public int t;
    public final OvershootInterpolator u;
    public final PathInterpolator v;
    public final PathInterpolator w;
    public FullScreenFloatWindowHandler$setupInActivity$3$callback$1 x;
    public FragmentManager y;
    public FullScreenFloatWindowHandler$ensureFragmentLifecycleCallbacks$callback$1 z;

    public static final class a implements f09.a.a {
        public final /* synthetic */ FullScreenFloatWindowHandler a;

        public final void onPaused(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public a(FullScreenFloatWindowHandler r1) {
            this.a = r1;
        }

        public final void onPreDestroyed(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void onResumed(Activity r4) {
            Intrinsics.checkNotNullParameter(r4, "activity");
            FullScreenFloatWindowHandler r0 = this.a;
            r0.v(r4, r0.d, "activity-resumed");
        }

        public final void onStart(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void onStopped(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void onCreate(Activity r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r1, "activity");
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SingleFloatWindowState.values().length];
            r0[SingleFloatWindowState.MAXIMIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[SingleFloatWindowState.MINIMIZE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class d implements Animator.AnimatorListener {
        public final /* synthetic */ FullScreenFloatWindowHandler a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        public d(FullScreenFloatWindowHandler r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.a.k = false;
        }
    }

    public static final class e implements Animator.AnimatorListener {
        public final /* synthetic */ FullScreenFloatWindowHandler a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        public e(FullScreenFloatWindowHandler r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.a.k = true;
        }
    }

    static {
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void c() {
        View r0 = this.h;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNullParameter(r0, "view");
        w();
        return;
    L5:
        w();
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final SingleFloatWindowState d() {
        if (this.k == false) goto L6;
        return SingleFloatWindowState.MAXIMIZE;
    L6:
        return SingleFloatWindowState.MINIMIZE;
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void e() {
        HorizontalDragFrameLayout r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.animate().cancel();
        float r1 = 0.0f;
        r0.setAlpha(0.0f);
        r0.setVisibility(0);
        if (this.k == false) goto L8;
        r1 = 1.0f;
    L8:
        y(r1, false);
        r0.animate().alpha(1.0f).setDuration(150).setInterpolator(this.w).start();
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void g() {
        v(AppHost.a.a().getCurrentActivity(), this.d, "reset-pos");
        if (this.k == false) goto L5;
        float r0 = 1.0f;
    L6:
        y(r0, false);
        return;
    L5:
        r0 = 0.0f;
        goto L6
    }

    public final void m() {
        float r0 = this.l;
        PathInterpolator r1 = this.v;
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{r0, 0.0f});
        r2.setDuration(200);
        r2.setInterpolator(r1);
        r2.addUpdateListener(new j(this));
        Intrinsics.checkNotNull(r2);
        r2.addListener(new d(this));
        r2.start();
    }

    public final void n() {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{this.l, 1.0f});
        r0.setDuration(350);
        r0.setInterpolator(this.u);
        r0.addUpdateListener(new l(this));
        Intrinsics.checkNotNull(r0);
        r0.addListener(new e(this));
        r0.start();
    }

    public final void w() {
        FLogger.a.d("FullScreenFloatWindowHandler", "hideFloatWindow");
        View r0 = this.f;
        if (r0 == null) goto L10;
        ViewParent r3 = r0.getParent();
        if ((r3 instanceof ViewGroup) == false) goto L7;
        ViewGroup r4 = (ViewGroup) r3;
    L8:
        if (r4 == null) goto L10;
        r4.removeView(r0);
        goto L10
    L7:
        r4 = null;
    L10:
        this.f = null;
        HorizontalDragFrameLayout r1 = this.g;
        if (r1 == null) goto L18;
        ViewParent r5 = r1.getParent();
        if ((r5 instanceof ViewGroup) == false) goto L15;
        ViewGroup r6 = (ViewGroup) r5;
    L16:
        if (r6 == null) goto L18;
        r6.removeView(r1);
        goto L18
    L15:
        r6 = null;
    L18:
        this.g = null;
        this.h = null;
        this.d = null;
        this.e = null;
        this.k = false;
        this.l = 0.0f;
        FullScreenFloatWindowHandler$setupInActivity$3$callback$1 r7 = this.x;
        if (r7 == null) goto L21;
        r7.remove();
    L21:
        this.x = null;
        Iterator<Map.Entry<Dialog, DialogInterface.OnKeyListener>> r8 = this.D.entrySet().iterator();
    L23:
        if (r8.hasNext() == false) goto L32;
        Map.Entry<Dialog, DialogInterface.OnKeyListener> r9 = r8.next();
        Dialog r10 = r9.getKey();
        DialogInterface.OnKeyListener r11 = r9.getValue();
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L27
        r10.setOnKeyListener(r11);     // Catch: Throwable -> L27
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L23;
        FLogger.a.e("FullScreenFloatWindowHandler", "restore dialog onKeyListener failed: " + r14);
    L27:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L32:
        this.D.clear();
        FragmentManager r2 = this.y;
        if (r2 == null) goto L37;
        FullScreenFloatWindowHandler$ensureFragmentLifecycleCallbacks$callback$1 r16 = this.z;
        if (r16 == null) goto L37;
        r2.unregisterFragmentLifecycleCallbacks(r16);
    L37:
        this.y = null;
        this.z = null;
        m r17 = this.A;
        if (r17 == null) goto L44;
        WeakReference<ViewGroup> r18 = this.B;
        if (r18 == null) goto L44;
        ViewGroup r20 = r18.get();
        if (r20 == null) goto L44;
        r20.removeOnLayoutChangeListener(r17);
    L44:
        this.A = null;
        this.B = null;
        this.C = false;
        this.c = null;
    }

    public FullScreenFloatWindowHandler(Application r6) {
        Intrinsics.checkNotNullParameter(r6, "application");
        this.a = r6;
        AppHost.Companion r0 = AppHost.a;
        this.b = r0.getApplication().getApplicationContext();
        this.m = r6.getResources().getDimensionPixelSize(v19.c.b(2130971208, null, 2131166786));
        this.t = com.larus.utils.m0.b(r6);
        this.u = new OvershootInterpolator(1.0f);
        new AnticipateInterpolator(1.0f);
        this.v = new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f);
        this.w = new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f);
        this.D = new WeakHashMap();
        r0.a().e(new a(this));
    }

    public static View j(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static final void k(final FullScreenFloatWindowHandler r3) {
        r3.getClass();
        final Activity r0 = AppHost.a.a().getCurrentActivity();
        if (r0 == null) goto L13;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L11;
        View r2 = j(r1);
        if (r2 == null) goto L12;
        r2.post(new k(r3, r0));
        return;
    L12:
        return;
    L11:
        return;
    }

    public static String s(e19.b r2) {
        return r2.a + '@' + System.identityHashCode(r2.b) + "(parent=" + r2.b.getClass().getSimpleName() + ", local=" + r2.c + ", screen=" + r2.d + ", orientation=" + r2.e + ')';
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void a(final Function0<Unit> r5) {
        final HorizontalDragFrameLayout r0 = this.g;
        if (r0 != null) goto L9;
        View r1 = this.f;
        if (r1 == null) goto L7;
        r1.setVisibility(8);
    L7:
        r5.invoke();
        return;
    L9:
        r0.animate().cancel();
        r0.setAlpha(1.0f);
        r0.animate().alpha(0.0f).setDuration(150).setInterpolator(this.w).withEndAction(new r(r0, this, r5)).start();
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final Rect f(boolean r7) {
        Rect r8 = new Rect();
        HorizontalDragFrameLayout r0 = this.g;
        if (r0 == null) goto L5;
        int[] r1 = new int[2];
        r0.getLocationOnScreen(r1);
        int r2 = r1[0];
        r8.set(r2, r1[1], r0.getWidth() + r2, r1[1] + r0.getHeight());
    L5:
        return r8;
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void i(AppCompatActivity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        FLogger r1 = FLogger.a;
        r1.d("FullScreenFloatWindowHandler", "forwardSwitch activity: " + r5);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Activity r6 = com.larus.common_ui.floatwindow.view.e.b(r5);     // Catch: Throwable -> L5
        r1.d("FullScreenFloatWindowHandler", "forwardSwitch forwardActivity: " + r6);     // Catch: Throwable -> L5
        v(r6, this.d, "forward-switch");     // Catch: Throwable -> L5
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L13;
        FLogger.a.d("FullScreenFloatWindowHandler", "forwardSwitch crash. throwable:" + r8.getMessage());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void removeView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        w();
    }

    public final DialogFragment t(Fragment r8) {
        if (r8.isAdded() == true) goto L5;
    L93:
        return null;
    L5:
        if (r8.isDetached() == true) goto L93;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        Object r1 = Result.constructor-impl(u(r8.getChildFragmentManager()));     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r1) == false) goto L14;
        r1 = null;
    L14:
        DialogFragment r2 = (DialogFragment) r1;
        if (r2 == null) goto L17;
        return r2;
    L17:
        e19.h r3 = this.d;
        if (r3 == null) goto L21;
        List<String> r4 = r3.d();
        if (r4 == null) goto L21;
    L23:
        if ((r8 instanceof DialogFragment) == false) goto L93;
        DialogFragment r9 = (DialogFragment) r8;
        if (r9.isAdded() == false) goto L93;
        if (r9.isDetached() == true) goto L93;
        Dialog r5 = r9.getDialog();
        boolean r6 = false;
        boolean r7 = true;
        if (r5 != null) goto L31;
    L33:
        boolean r10 = false;
    L34:
        if (r10 == false) goto L93;
        if (CollectionsKt.contains(r4, r9.getTag()) == true) goto L93;
        Dialog r11 = r9.getDialog();
        if (r11 == null) goto L42;
        Window r12 = r11.getWindow();
        if (r12 == null) goto L42;
        View r13 = j(r12);
    L44:
        if ((r13 instanceof ViewGroup) == false) goto L46;
        ViewGroup r14 = (ViewGroup) r13;
    L47:
        if (r14 != null) goto L49;
    L51:
        boolean r15 = false;
    L52:
        if (r15 == false) goto L93;
        Context r16 = r14.getContext();
        if (r16 != null) goto L56;
        r16 = this.a;
    L56:
        int r17 = com.larus.utils.m0.b(r16);
        int r18 = com.larus.utils.m0.a(r16);
        int r20 = r14.getWidth();
        int r21 = r14.getHeight();
        if (r20 == 0) goto L90;
        if (r21 == 0) goto L90;
        if (r20 != r17) goto L62;
        boolean r22 = true;
    L63:
        if (r21 != r18) goto L65;
        boolean r23 = true;
    L66:
        if (r22 == false) goto L69;
        if (r23 == false) goto L69;
    L91:
        if (r7 == false) goto L93;
        return r9;
    L69:
        Dialog r24 = r9.getDialog();
        if (r24 == null) goto L74;
        Window r25 = r24.getWindow();
        if (r25 == null) goto L74;
        WindowManager.LayoutParams r26 = r25.getAttributes();
    L76:
        if (r26 != null) goto L78;
    L80:
        boolean r27 = false;
    L81:
        if (r26 != null) goto L83;
    L85:
        boolean r28 = false;
    L86:
        if (r27 == false) goto L90;
        if (r28 == false) goto L90;
        if (r22 == false) goto L90;
        r6 = true;
        goto L90
    L83:
        if (r26.height != (-1)) goto L85;
        r28 = true;
        goto L86
    L78:
        if (r26.width != (-1)) goto L80;
        r27 = true;
    L74:
        r26 = null;
        goto L76
    L65:
        r23 = false;
        goto L66
    L62:
        r22 = false;
    L90:
        r7 = r6;
        goto L91
    L49:
        if (r14.isAttachedToWindow() != true) goto L51;
        r15 = true;
        goto L52
    L46:
        r14 = null;
    L42:
        r13 = null;
        goto L44
    L31:
        if (r5.isShowing() != true) goto L33;
        r10 = true;
    L21:
        r4 = CollectionsKt.emptyList();
    L9:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final DialogFragment u(FragmentManager r4) {
        Iterator r5 = CollectionsKt.asReversedMutable(r4.getFragments()).iterator();
    L3:
        DialogFragment r1 = null;
        if (r5.hasNext() == false) goto L11;
        Fragment r0 = (Fragment) r5.next();
        if (r0.isAdded() == false) goto L10;
        if (r0.isDetached() == true) goto L10;
        Intrinsics.checkNotNull(r0);
        r1 = t(r0);
    L10:
        if (r1 == null) goto L3;
    L11:
        return r1;
    }

    public static boolean o(FrameLayout r4, e19.b r5) {
        Rect r6 = r5.c;
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        if (r1 != null) goto L9;
        r1 = new FrameLayout.LayoutParams(r6.width(), r6.height());
    L9:
        if (r1.width == r6.width()) goto L11;
    L22:
        r1.width = r6.width();
        r1.height = r6.height();
        r1.leftMargin = r6.left;
        r1.topMargin = r6.top;
        r1.rightMargin = 0;
        r1.bottomMargin = 0;
        r4.setLayoutParams(r1);
        return true;
    L11:
        if (r1.height != r6.height()) goto L22;
        if (r1.leftMargin != r6.left) goto L22;
        if (r1.topMargin != r6.top) goto L22;
        if (r1.rightMargin != 0) goto L22;
        if (r1.bottomMargin != 0) goto L22;
        return false;
    L5:
        r1 = null;
        goto L6
    }

    public static void q(FrameLayout r4, View r5) {
        FrameLayout.LayoutParams r1 = null;
        ViewGroup r2 = null;
        if (r5.getParent() == r4) goto L11;
        ViewParent r0 = r5.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L7;
        r2 = (ViewGroup) r0;
    L7:
        if (r2 == null) goto L9;
        r2.removeView(r5);
    L9:
        r4.addView(r5, 0, new FrameLayout.LayoutParams(-1, -1));
        return;
    L11:
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if ((r6 instanceof FrameLayout.LayoutParams) == false) goto L14;
        r1 = (FrameLayout.LayoutParams) r6;
    L14:
        if (r1 != null) goto L17;
        return;
    L17:
        if (r1.width == (-1)) goto L19;
    L20:
        r1.width = -1;
        r1.height = -1;
        r5.setLayoutParams(r1);
        return;
    L19:
        if (r1.height != (-1)) goto L20;
    }

    public static void r(ViewGroup r2, FrameLayout r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3.getParent() == r2) goto L7;
        return;
    L7:
        if (r2.indexOfChild(r3) == (r2.getChildCount() - 1)) goto L11;
        r3.bringToFront();
        r2.invalidate();
        return;
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void b(SingleFloatWindowState r3, boolean r4) {
        if (r3 != null) goto L4;
        int r5 = -1;
    L6:
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L11;
        return;
    L11:
        if (this.k == true) goto L13;
        return;
    L13:
        if (r4 == false) goto L15;
        m();
        return;
    L15:
        this.k = false;
        y(0.0f, false);
        return;
    L17:
        if (this.k == false) goto L19;
        return;
    L19:
        if (r4 == false) goto L21;
        n();
        return;
    L21:
        this.k = true;
        y(1.0f, false);
        return;
    L4:
        r5 = c.a[r3.ordinal()];
        goto L6
    }

    public final void l(Context r6, e19.h r7) {
        r7.a();
        HorizontalDragFrameLayout r0 = this.g;
        if (r0 == null) goto L19;
        View r1 = this.h;
        ViewGroup r2 = null;
        if (r1 == null) goto L12;
        ViewParent r3 = r1.getParent();
        if ((r3 instanceof ViewGroup) == false) goto L9;
        ViewGroup r4 = (ViewGroup) r3;
    L10:
        if (r4 == null) goto L12;
        r4.removeView(r1);
        goto L12
    L9:
        r4 = null;
    L12:
        View r8 = r7.l(r6);
        this.h = r8;
        ViewParent r5 = r8.getParent();
        if ((r5 instanceof ViewGroup) == false) goto L15;
        r2 = (ViewGroup) r5;
    L15:
        if (r2 == null) goto L17;
        r2.removeView(r8);
    L17:
        r0.removeAllViews();
        r0.addView(r8, new FrameLayout.LayoutParams(this.t, -1));
        r7.b();
        return;
    }

    public final void p(FrameLayout r6, HorizontalDragFrameLayout r7) {
        FrameLayout.LayoutParams r1 = null;
        ViewGroup r2 = null;
        if (r7.getParent() == r6) goto L11;
        ViewParent r0 = r7.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L7;
        r2 = (ViewGroup) r0;
    L7:
        if (r2 == null) goto L9;
        r2.removeView(r7);
    L9:
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(this.t, -1);
        r3.gravity = 8388613;
        r6.addView(r7, r3);
        return;
    L11:
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if ((r8 instanceof FrameLayout.LayoutParams) == false) goto L14;
        r1 = (FrameLayout.LayoutParams) r8;
    L14:
        if (r1 == null) goto L23;
        int r9 = r1.width;
        int r4 = this.t;
        if (r9 == r4) goto L18;
    L21:
        r1.width = r4;
        r1.height = -1;
        r1.gravity = 8388613;
        r7.setLayoutParams(r1);
        return;
    L18:
        if (r1.height != (-1)) goto L21;
        if (r1.gravity != 8388613) goto L21;
        return;
    }

    public final void y(float r7, boolean r8) {
        float r9 = RangesKt.coerceIn(r7, 0.0f, 1.0f);
        this.l = r9;
        View r2 = this.f;
        if (r2 == null) goto L9;
        r2.setAlpha(r9);
        if (r9 <= 0.0f) goto L7;
        int r3 = 0;
    L8:
        r2.setVisibility(r3);
        goto L9
    L7:
        r3 = 8;
    L9:
        HorizontalDragFrameLayout r4 = this.g;
        i r5 = null;
        if (r4 != null) goto L12;
    L28:
        HorizontalDragFrameLayout r0 = this.g;
        if (r0 == null) goto L33;
        Sequence r1 = ViewGroupKt.getChildren(r0);
        if (r1 == null) goto L33;
        View r6 = (View) SequencesKt.firstOrNull(r1);
    L35:
        if ((r6 instanceof i) == false) goto L37;
        r5 = (i) r6;
    L37:
        if (r5 == null) goto L40;
        r5.a(r9, r8);
        return;
    L40:
        return;
    L33:
        r6 = null;
        goto L35
    L12:
        if (r9 > 0.0f) goto L14;
        IntRange r10 = this.n;
    L15:
        r4.setDragHotArea(r10);
        if (r9 > 0.0f) goto L18;
        IntRange r11 = this.o;
    L19:
        r4.setDragHotAreaX(r11);
        if (r9 > 0.0f) goto L22;
        IntRange r12 = this.p;
    L23:
        r4.setClickHotArea(r12);
        if (r9 > 0.0f) goto L26;
        IntRange r13 = this.q;
    L27:
        r4.setClickHotAreaX(r13);
        r4.setTranslationX(RangesKt.coerceAtLeast(this.t - this.m, 0.0f) * (1.0f - r9));
        goto L28
    L26:
        r13 = null;
        goto L27
    L22:
        r12 = null;
        goto L23
    L18:
        r11 = null;
        goto L19
    L14:
        r10 = null;
        goto L15
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void h(e19.h r9, SingleFloatWindowState r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "request");
        e19.h r0 = this.d;
        this.d = r9;
        float r2 = 0.0f;
        if (r0 == r9) goto L5;
        this.k = false;
        this.l = 0.0f;
    L5:
        Activity r1 = AppHost.a.a().getCurrentActivity();
        if (r1 != null) goto L8;
        return;
    L8:
        FrameLayout r3 = x(r1, r9, "update-view");
        if (r3 != null) goto L11;
        return;
    L11:
        View r4 = this.f;
        if (r4 != null) goto L14;
        r4 = new View(this.b);
        r4.setTag("fullscreen_mask");
        r4.setAlpha(0.0f);
        r4.setVisibility(8);
        r4.setImportantForAccessibility(2);
        r4.setOnClickListener(new o(this));
        this.f = r4;
    L14:
        r4.setBackgroundColor(r9.c());
        q(r3, r4);
        HorizontalDragFrameLayout r5 = this.g;
        IntRange r6 = null;
        if (r5 != null) goto L18;
        r5 = new HorizontalDragFrameLayout(this.b, null, 6, 0);
        r5.setTag("fullscreen_content");
        this.g = r5;
        r5.setOnDragListener(new t(r5, this));
    L18:
        if (this.l > 0.0f) goto L20;
        IntRange r7 = this.n;
    L21:
        r5.setDragHotArea(r7);
        if (this.l > 0.0f) goto L24;
        IntRange r8 = this.o;
    L25:
        r5.setDragHotAreaX(r8);
        if (this.l > 0.0f) goto L28;
        IntRange r12 = this.p;
    L29:
        r5.setClickHotArea(r12);
        if (this.l > 0.0f) goto L32;
        r6 = this.q;
    L32:
        r5.setClickHotAreaX(r6);
        r5.setOnClickHotAreaListener(new s(this));
        l(r1, r9);
        p(r3, r5);
        if (this.k == false) goto L35;
        r2 = 1.0f;
    L35:
        y(r2, false);
        b(r10, r11);
        return;
    L28:
        r12 = null;
        goto L29
    L24:
        r8 = null;
        goto L25
    L20:
        r7 = null;
        goto L21
    }

    public final void v(Activity r2, e19.h r3, String r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3 != this.d) goto L9;
        x(r2, r3, r4);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v31, types: [android.view.ViewGroup, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v43, types: [androidx.activity.OnBackPressedCallback, com.larus.common_ui.floatwindow.view.FullScreenFloatWindowHandler$setupInActivity$3$callback$1] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v3, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r2v38, types: [androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks, com.larus.common_ui.floatwindow.view.FullScreenFloatWindowHandler$ensureFragmentLifecycleCallbacks$callback$1] */
    /* JADX WARN: Type inference failed for: r4v19, types: [com.larus.common_ui.floatwindow.view.m] */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v9, types: [android.view.View$OnLayoutChangeListener] */
    public final FrameLayout x(Activity r23, e19.h r24, String r25) {
        FragmentActivity r9 = com.larus.common_ui.floatwindow.view.e.a(r23);
        if (r9 != null) goto L5;
        return null;
    L5:
        v19.f.a(r9.getTheme());
        if (r24 != null) goto L8;
        return null;
    L8:
        boolean r11 = r9 instanceof FragmentActivity;
        if (r11 == false) goto L11;
        FragmentActivity r0 = r9;
    L12:
        if (r0 == null) goto L32;
        FragmentManager r1 = r0.getSupportFragmentManager();
        if (r1 == null) goto L32;
        Iterator r2 = CollectionsKt.asReversedMutable(r1.getFragments()).iterator();
    L17:
        if (r2.hasNext() == false) goto L32;
        Fragment r3 = (Fragment) r2.next();
        Intrinsics.checkNotNull(r3);
        DialogFragment r4 = t(r3);
        if (r4 == null) goto L25;
        Dialog r5 = r4.getDialog();
        if (r5 == null) goto L25;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L25;
        View r7 = j(r6);
    L27:
        if ((r7 instanceof ViewGroup) == false) goto L29;
        ViewGroup r8 = (ViewGroup) r7;
    L30:
        if (r8 == null) goto L17;
    L33:
        if (r8 != null) goto L42;
        Window r10 = r9.getWindow();
        if (r10 == null) goto L37;
        View r12 = j(r10);
    L39:
        if ((r12 instanceof ViewGroup) == false) goto L41;
        ViewGroup r13 = (ViewGroup) r12;
    L43:
        if (r13 != null) goto L45;
        return null;
    L45:
        if (r11 == false) goto L47;
        FragmentActivity r14 = r9;
    L48:
        if (r14 == null) goto L50;
        FragmentManager r15 = r14.getSupportFragmentManager();
    L51:
        FragmentManager r16 = this.y;
        boolean r17 = true;
        if (r16 == r15) goto L62;
        if (r16 == null) goto L58;
        FullScreenFloatWindowHandler$ensureFragmentLifecycleCallbacks$callback$1 r18 = this.z;
        if (r18 == null) goto L58;
        r16.unregisterFragmentLifecycleCallbacks(r18);
    L58:
        this.y = r15;
        if (r15 != null) goto L61;
        this.z = null;
        goto L62
    L61:
        ?? r20 = new FullScreenFloatWindowHandler$ensureFragmentLifecycleCallbacks$callback$1(this);
        r15.registerFragmentLifecycleCallbacks(r20, true);
        this.z = r20;
    L62:
        e19.b r110 = this.e;
        int r21 = e19.e.a;
        e19.c r111 = new e19.c(r24, r9, r13, r110, r25);
        Intrinsics.checkNotNullParameter(r111, "context");
        Iterator r22 = CollectionsKt.sortedWith(CollectionsKt.toList(ServiceManager.get().getServices(IFloatWindowHostProvider.class)), new e19.d()).iterator();
    L64:
        if (r22.hasNext() == false) goto L100;
        IFloatWindowHostProvider r26 = (IFloatWindowHostProvider) r22.next();
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L68
        Object r28 = Result.constructor-impl(r26.provideFloatWindowHost(r111));     // Catch: Throwable -> L68
    L70:
        Throwable r30 = Result.exceptionOrNull-impl(r28);
        if (r30 == null) goto L78;
        FLogger r31 = FLogger.a;
        StringBuilder r112 = new StringBuilder("provider failed, provider=");
        r112.append(r26.getClass().getSimpleName());
        r112.append(", bizSource=");
        e19.h r32 = r111.a;
        if (r32 == null) goto L75;
        String r33 = r32.k();
    L76:
        r112.append(r33);
        r112.append(", reason=");
        r112.append(r111.e);
        r31.e("FloatWindowHostResolver", r112.toString(), r30);
        goto L78
    L75:
        r33 = null;
    L78:
        if (Result.isFailure-impl(r28) == false) goto L80;
        r28 = null;
    L80:
        e19.b r34 = (e19.b) r28;
        if (r34 == null) goto L96;
        Rect r35 = new Rect(r34.c);
        Rect r36 = new Rect(r34.d);
        String r37 = r34.a;
        ViewGroup r113 = r34.b;
        int r38 = r34.e;
        Intrinsics.checkNotNullParameter(r37, "hostId");
        Intrinsics.checkNotNullParameter(r113, "parent");
        Intrinsics.checkNotNullParameter(r35, "localBounds");
        Intrinsics.checkNotNullParameter(r36, "screenBounds");
        e19.b r114 = new e19.b(r37, r113, r35, r36, r38);
        if (r114.b.isAttachedToWindow() == true) goto L85;
    L93:
        boolean r40 = false;
    L94:
        if (r40 == false) goto L96;
        final e19.b r115 = r114;
    L97:
        if (r115 == null) goto L64;
    L101:
        if (r115 != null) goto L137;
        ViewGroup r41 = r111.c;
        if (r41 == null) goto L135;
        Context r42 = r41.getContext();
        Integer r43 = Integer.valueOf(r41.getWidth());
        if (r43.intValue() <= 0) goto L109;
        boolean r44 = true;
    L110:
        if (r44 == true) goto L113;
        r43 = null;
    L113:
        if (r43 == null) goto L115;
        int r45 = r43.intValue();
    L116:
        Integer r46 = Integer.valueOf(r41.getHeight());
        if (r46.intValue() <= 0) goto L119;
        boolean r47 = true;
    L120:
        if (r47 == true) goto L123;
        r46 = null;
    L123:
        if (r46 == null) goto L125;
        int r48 = r46.intValue();
    L126:
        if (r45 <= 0) goto L135;
        if (r48 <= 0) goto L135;
        Rect r50 = new Rect(0, -r41.getPaddingTop(), r45, r48 + r41.getPaddingBottom());
        Rect r51 = new Rect();
        if (r41.getGlobalVisibleRect(r51) == true) goto L132;
    L133:
        int[] r52 = new int[2];
        r41.getLocationOnScreen(r52);
        int r53 = r52[0];
        int r54 = r52[1];
        r51.set(r53, r50.top + r54, r50.right + r53, r54 + r50.bottom);
    L134:
        r115 = new e19.b("activity_decor", r41, r50, r51, r41.getResources().getConfiguration().orientation);
        goto L137
    L132:
        if (r51.isEmpty() == false) goto L134;
    L125:
        r48 = com.larus.utils.m0.a(r42);
        goto L126
    L119:
        r47 = false;
        goto L120
    L115:
        r45 = com.larus.utils.m0.b(r42);
        goto L116
    L109:
        r44 = false;
    L135:
        r115 = null;
    L137:
        if (r115 != null) goto L139;
        return null;
    L139:
        if (r110 == null) goto L141;
        String r55 = r110.a;
    L143:
        if (Intrinsics.areEqual(r55, r115.a) == true) goto L145;
    L151:
        boolean r56 = false;
    L152:
        boolean r57 = !r56;
        this.e = r115;
        if (r57 == false) goto L159;
        FLogger r58 = FLogger.a;
        StringBuilder r116 = new StringBuilder("float host changed. reason=");
        r116.append(r25);
        r116.append(", from=");
        if (r110 == null) goto L157;
        String r117 = s(r110);
    L158:
        r116.append(r117);
        r116.append(", to=");
        r116.append(s(r115));
        r116.append(", activity=");
        r116.append(r9.getClass().getSimpleName());
        r116.append('@');
        r116.append(System.identityHashCode(r9));
        r116.append(", bizSource=");
        r116.append(r24.k());
        r58.i("FullScreenFloatWindowHandler", r116.toString());
        r24.j(r115);
        goto L159
    L157:
        r117 = null;
    L159:
        e19.f r60 = r24.h();
        this.m = r60.a;
        this.n = r60.b;
        this.o = r60.c;
        this.p = r60.d;
        this.q = r60.e;
        this.r = r60.f;
        this.s = r60.g;
        int r61 = r115.c.width();
        if (r61 <= 0) goto L162;
        int r62 = RangesKt.coerceAtMost(r24.getWidth(), r61);
    L163:
        this.t = RangesKt.coerceAtLeast(r62, 0);
        ?? r63 = r115.b;
        m r64 = this.A;
        ?? r65 = r64;
        if (r64 != null) goto L166;
        ?? r66 = new m(this);
        this.A = r66;
        r65 = r66;
    L166:
        WeakReference<ViewGroup> r118 = this.B;
        if (r118 == null) goto L169;
        ?? r119 = r118.get();
    L170:
        if (r119 == r63) goto L174;
        if (r119 == 0) goto L173;
        r119.removeOnLayoutChangeListener(r65);
    L173:
        r63.addOnLayoutChangeListener(r65);
        this.B = new WeakReference(r63);
    L174:
        final ViewGroup r67 = r115.b;
        WeakReference<FrameLayout> r68 = this.c;
        if (r68 == null) goto L177;
        final FrameLayout r70 = r68.get();
    L178:
        Iterator r120 = ViewGroupKt.getChildren(r67).iterator();
    L180:
        if (r120.hasNext() == false) goto L188;
        Object r121 = r120.next();
        if (((View) r121).getTag() != "global.fullscreen_float_container") goto L184;
        boolean r71 = true;
    L185:
        if (r71 == false) goto L180;
    L190:
        if ((r121 instanceof FrameLayout) == false) goto L192;
        FrameLayout r122 = (FrameLayout) r121;
    L193:
        if (r122 != null) goto L196;
        if (r70 != null) goto L197;
        r70 = new FrameLayout(this.b);
        r70.setTag("global.fullscreen_float_container");
    L197:
        r70.setClipChildren(true);
        r70.setClipToPadding(true);
        if (r70.getParent() == r67) goto L202;
        r17 = false;
    L202:
        if (r70.getParent() == r67) goto L219;
        ViewParent r72 = r70.getParent();
        if ((r72 instanceof ViewGroup) == false) goto L206;
        ViewGroup r73 = (ViewGroup) r72;
    L207:
        FLogger r123 = FLogger.a;
        StringBuilder r124 = new StringBuilder("float container reparent. from=");
        if (r73 == null) goto L210;
        String r125 = r73.getClass().getSimpleName();
    L211:
        r124.append(r125);
        r124.append('@');
        if (r73 == null) goto L214;
        Integer r126 = Integer.valueOf(System.identityHashCode(r73));
    L215:
        r124.append(r126);
        r124.append(", to=");
        r124.append(r67.getClass().getSimpleName());
        r124.append('@');
        r124.append(System.identityHashCode(r67));
        r124.append(", host=");
        r124.append(s(r115));
        r123.i("FullScreenFloatWindowHandler", r124.toString());
        if (r73 == null) goto L218;
        r73.removeView(r70);
    L218:
        r67.addView(r70, new ViewGroup.MarginLayoutParams(r115.c.width(), r115.c.height()));
        goto L219
    L214:
        r126 = null;
        goto L215
    L210:
        r125 = null;
        goto L211
    L206:
        r73 = null;
    L219:
        boolean r74 = o(r70, r115);
        if (r17 == false) goto L224;
        if (r74 == true) goto L224;
        r(r67, r70);
    L225:
        this.c = new WeakReference(r70);
        View r75 = this.f;
        if (r75 == null) goto L228;
        q(r70, r75);
    L228:
        HorizontalDragFrameLayout r76 = this.g;
        if (r76 == null) goto L231;
        p(r70, r76);
    L231:
        Context r77 = r115.b.getContext();
        WeakReference<Context> r78 = this.j;
        if (r78 == null) goto L234;
        Context r80 = r78.get();
    L235:
        WeakReference<Context> r81 = this.i;
        if (r81 == null) goto L238;
        Context r82 = r81.get();
    L239:
        if (r82 != r77) goto L242;
        if (r80 == null) goto L242;
    L243:
        l(r80, r24);
        if (this.k == false) goto L246;
        float r83 = 1.0f;
    L247:
        y(r83, false);
        if (r11 == false) goto L250;
        final FragmentActivity r127 = r9;
    L251:
        if (r127 == null) goto L256;
        FullScreenFloatWindowHandler$setupInActivity$3$callback$1 r84 = this.x;
        if (r84 == null) goto L255;
        r84.remove();
    L255:
        ?? r85 = new FullScreenFloatWindowHandler$setupInActivity$3$callback$1(this, r127);
        r127.getOnBackPressedDispatcher().addCallback(r127, r85);
        this.x = r85;
    L256:
        return r70;
    L250:
        r127 = null;
        goto L251
    L246:
        r83 = 0.0f;
    L242:
        r80 = v19.f.d(r77);
        this.i = new WeakReference(r77);
        this.j = new WeakReference(r80);
        goto L243
    L238:
        r82 = null;
        goto L239
    L234:
        r80 = null;
    L224:
        r67.post(new p(r70, r67, this, r115));
        goto L225
    L196:
        r70 = r122;
        goto L197
    L192:
        r122 = null;
        goto L193
    L184:
        r71 = false;
        goto L185
    L188:
        r121 = null;
        goto L190
    L177:
        r70 = null;
        goto L178
    L169:
        r119 = 0;
        goto L170
    L162:
        r62 = r24.getWidth();
        goto L163
    L145:
        if (r110.b != r115.b) goto L151;
        if (Intrinsics.areEqual(r110.c, r115.c) == false) goto L151;
        if (r110.e != r115.e) goto L151;
        r56 = true;
        goto L152
    L141:
        r55 = null;
        goto L143
    L85:
        if (r114.c.width() <= 0) goto L93;
        if (r114.c.height() <= 0) goto L93;
        if (r114.d.width() <= 0) goto L93;
        if (r114.d.height() <= 0) goto L93;
        r40 = true;
    L96:
        r115 = null;
    L68:
        th = move-exception;
        Result.Companion r86 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L70
    L100:
        r115 = null;
        goto L101
    L50:
        r15 = null;
        goto L51
    L47:
        r14 = null;
        goto L48
    L41:
        r13 = null;
        goto L43
    L37:
        r12 = null;
        goto L39
    L42:
        r13 = r8;
        goto L43
    L29:
        r8 = null;
    L25:
        r7 = null;
    L32:
        r8 = null;
        goto L33
    L11:
        r0 = null;
        goto L12
    }
}
