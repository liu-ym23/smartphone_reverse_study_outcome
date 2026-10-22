package y5;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.animation.PathInterpolator;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.utils.l;
import com.bytedance.ai.view.popup.anim.AnimController;
import com.bytedance.ai.view.popup.anim.AnimationStyle;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import k2.s;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements x5.a {
    public final AppletPopupSchemaParam a;
    public final View b;
    public final AnimController c;

    public static final class a implements Animator.AnimatorListener {
        public final /* synthetic */ b a;
        public final /* synthetic */ Ref.ObjectRef<String> b;
        public final /* synthetic */ Function0<Unit> c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            this.a.c.a(AnimController.AnimProcessType.DONE, true, null);
            Function0<Unit> r11 = this.c;
            if (r11 == null) goto L6;
            r11.invoke();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            this.a.c.a(AnimController.AnimProcessType.DONE, true, null);
            Function0<Unit> r11 = this.c;
            if (r11 == null) goto L6;
            r11.invoke();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            this.a.b.setVisibility(0);
            this.a.c.a(AnimController.AnimProcessType.DOING, true, (String) this.b.element);
        }

        public a(b r1, Ref.ObjectRef<String> r10, Function0<Unit> r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }
    }

    @Override // x5.a
    public final void invoke() {
        AppletPopupSchemaParam.getRealTransitionAnimation$default(this.a, this.b.getContext(), false, 2, null);
    }

    public final String a(boolean r10) {
        String r11 = this.a.getRealTransitionAnimation(this.b.getContext(), r10);
        if (Intrinsics.areEqual(r11, AnimationStyle.START.getValue()) == false) goto L10;
        int r12 = z5.a.a;
        if (z5.a.a(this.b.getContext()) == false) goto L8;
        return AnimationStyle.RIGHT.getValue();
    L8:
        return AnimationStyle.LEFT.getValue();
    L10:
        if (Intrinsics.areEqual(r11, AnimationStyle.END.getValue()) == false) goto L17;
        int r13 = z5.a.a;
        if (z5.a.a(this.b.getContext()) == false) goto L15;
        return AnimationStyle.LEFT.getValue();
    L15:
        return AnimationStyle.RIGHT.getValue();
    L17:
        return r11;
    }

    public b(AppletPopupSchemaParam r10, View r11, AnimController r12) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r12, "animController");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }

    public final void b(v5.a r18, int r19, Function0<Unit> r20) {
        boolean r10 = false;
        if (this.c.a == AnimController.AnimProcessType.NONE) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
        return;
    L8:
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        String r13 = a(true);
        r12.element = r13;
        if (Intrinsics.areEqual(r13, AnimationStyle.ZOOM.getValue()) == false) goto L52;
        PathInterpolator r14 = w5.d.a;
        View r15 = this.b;
        String r16 = this.a.getFloatingPageName();
        AnimController r17 = this.c;
        Intrinsics.checkNotNullParameter(r15, "transitionView");
        Intrinsics.checkNotNullParameter(r16, "floatingPageName");
        Intrinsics.checkNotNullParameter(r17, "animController");
        i2.j r110 = i2.i.a;
        s r111 = i2.i.a.a().j();
        if (r111 != null) goto L14;
    L49:
        if (r10 == false) goto L51;
        return;
    L51:
        r12.element = AnimationStyle.SLIDE.getValue();
        goto L52
    L14:
        if (Intrinsics.areEqual(r111.getPageInfo().getPageName(), r16) == true) goto L16;
    L18:
        boolean r112 = false;
    L19:
        if (r112 == false) goto L49;
        Rect r113 = i2.i.a.a().b();
        if (r113 == null) goto L49;
        com.bytedance.ai.view.popup.anim.b r114 = new com.bytedance.ai.view.popup.anim.b(r15, r17, r20);
        if (r15.getWidth() > 0) goto L38;
        l r115 = l.a;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r116 = AppletRuntimeManager.d;
        if (r116 == null) goto L29;
        Activity r117 = r116.currentActivity();
    L30:
        if (r117 != null) goto L32;
        int r118 = l.c(null);
    L39:
        com.bytedance.ai.utils.g r21 = com.bytedance.ai.utils.g.a;
        r21.i("AppletPopup", "zoomIn: hide floating widget");
        i2.i.a.a().a(r111.getPageID(), false);
        r21.i("AppletPopup", "zoomIn: zoomIn with Animation");
        r21.i("AppletPopup", "zoomUpAnimation " + r113.flattenToString());
        r15.setPivotX(0.0f);
        r15.setPivotY(0.0f);
        r15.setScaleX(r113.width() / r118);
        r15.setScaleY(r113.height() / r19);
        r15.setTranslationX(r113.left);
        r15.setTranslationY(r113.top - (l.b(null) - r19));
        r15.setAlpha(0.0f);
        r15.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).alpha(1.0f).translationX(0.0f).translationY(0.0f).setInterpolator(w5.d.a).setDuration(300).setListener(r114).start();
        View r22 = r15.getRootView();
        if (r22 == null) goto L48;
        ViewPropertyAnimator r23 = r22.animate();
        if (r23 == null) goto L48;
        ViewPropertyAnimator r24 = r23.alpha(1.0f);
        if (r24 == null) goto L48;
        ViewPropertyAnimator r25 = r24.setDuration(300);
        if (r25 == null) goto L48;
        r25.start();
    L48:
        r10 = true;
        goto L49
    L32:
        Rect r119 = new Rect();
        View r120 = r117.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L37;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r26 = ThreadMethodProxy.currentThread();
        if (r26 == com.larus.home.impl.utils.c.a) goto L37;
        com.larus.home.impl.utils.c.a(r26, "getDecorView");
    L37:
        r120.getWindowVisibleDisplayFrame(r119);
        r118 = r119.right - r119.left;
        goto L39
    L29:
        r117 = null;
        goto L30
    L38:
        r118 = r15.getWidth();
        goto L39
    L16:
        if (i2.i.a.a().e() == false) goto L18;
        r112 = true;
    L52:
        a r27 = new a(this, r12, r20);
        String r28 = (String) r12.element;
        if (Intrinsics.areEqual(r28, AnimationStyle.SLIDE.getValue()) == false) goto L56;
        this.b.setVisibility(4);
        View r29 = this.b;
        r29.setTranslationY(r19);
        r29.animate().translationY(0.0f).setDuration(this.a.getResizeDurationInMillSeconds()).setListener(r27);
    L81:
        if (r18 == null) goto L83;
        r18.b(this.b.animate());
    L83:
        this.b.animate().start();
        return;
    L56:
        if (Intrinsics.areEqual(r28, AnimationStyle.LEFT.getValue()) == false) goto L67;
        this.b.setVisibility(4);
        DisplayMetrics r30 = new DisplayMetrics();
        if ((this.b.getContext() instanceof Activity) == false) goto L60;
        Context r31 = this.b.getContext();
        Intrinsics.checkNotNull(r31, "null cannot be cast to non-null type android.app.Activity");
        WindowManager r32 = ((Activity) r31).getWindowManager();
    L61:
        if (r32 == null) goto L65;
        Display r33 = r32.getDefaultDisplay();
        if (r33 == null) goto L65;
        r33.getMetrics(r30);
    L65:
        View r34 = this.b;
        r34.setTranslationX(-r30.widthPixels);
        r34.animate().translationX(0.0f).setDuration(this.a.getResizeDurationInMillSeconds()).setListener(r27);
        goto L81
    L60:
        Object r35 = this.b.getContext().getSystemService("window");
        Intrinsics.checkNotNull(r35, "null cannot be cast to non-null type android.view.WindowManager");
        r32 = (WindowManager) r35;
        goto L61
    L67:
        if (Intrinsics.areEqual(r28, AnimationStyle.RIGHT.getValue()) == false) goto L78;
        this.b.setVisibility(4);
        DisplayMetrics r36 = new DisplayMetrics();
        if ((this.b.getContext() instanceof Activity) == false) goto L71;
        Context r37 = this.b.getContext();
        Intrinsics.checkNotNull(r37, "null cannot be cast to non-null type android.app.Activity");
        WindowManager r38 = ((Activity) r37).getWindowManager();
    L72:
        if (r38 == null) goto L76;
        Display r39 = r38.getDefaultDisplay();
        if (r39 == null) goto L76;
        r39.getMetrics(r36);
    L76:
        View r40 = this.b;
        r40.setTranslationX(r36.widthPixels);
        r40.animate().translationX(0.0f).setDuration(this.a.getResizeDurationInMillSeconds()).setListener(r27);
        goto L81
    L71:
        Object r41 = this.b.getContext().getSystemService("window");
        Intrinsics.checkNotNull(r41, "null cannot be cast to non-null type android.view.WindowManager");
        r38 = (WindowManager) r41;
        goto L72
    L78:
        if (Intrinsics.areEqual(r28, AnimationStyle.AUTO.getValue()) == false) goto L80;
        this.b.setVisibility(4);
        View r42 = this.b;
        r42.setAlpha(0.0f);
        r42.animate().alpha(1.0f).setDuration(this.a.getResizeDurationInMillSeconds()).setListener(r27);
        goto L81
    L80:
        this.c.a(AnimController.AnimProcessType.DONE, true, null);
        r20.invoke();
        Unit r43 = Unit.INSTANCE;
        goto L81
    L5:
        r11 = false;
        goto L6
    }
}
