package com.obric.oui.popover;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.PopupWindow;
import androidx.annotation.UiThread;
import androidx.core.view.animation.PathInterpolatorCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends PopupWindow {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile int f7128l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static boolean f7129m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final C0132a f7130n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OMiddleArrowPopoverLayout f7133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AnimatorSet f7135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Activity f7136f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private c f7137g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b f7138h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Animator f7139i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Animator f7140j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Runnable f7141k;

    /* JADX INFO: renamed from: com.obric.oui.popover.a$a, reason: collision with other inner class name */
    public static final class C0132a {
        private C0132a() {
        }

        public /* synthetic */ C0132a(DefaultConstructorMarker r10) {
            this();
        }

        public final int a(int r10) {
            if (r10 != 8388611) goto L5;
            return 3;
        L5:
            if (r10 != 8388613) goto L11;
            return 5;
        L11:
            return r10;
        }
    }

    public interface b {
        void a();
    }

    public interface c {
        void a();
    }

    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f7142c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f7143g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ OMiddleArrowPopoverLayout f7144h;

        d(a r10, boolean r11, OMiddleArrowPopoverLayout r12) {
            this.f7142c = r10;
            this.f7143g = r11;
            this.f7144h = r12;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            super.onAnimationEnd(r10);
            if (this.f7143g == true) goto L9;
            this.f7144h.setVisibility(8);
            b r11 = a.a(this.f7142c);
            if (r11 == null) goto L7;
            r11.a();
        L7:
            this.f7142c.g();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            super.onAnimationStart(r10);
            if (this.f7143g == false) goto L9;
            c r11 = a.c(this.f7142c);
            if (r11 == null) goto L7;
            r11.a();
        L7:
            this.f7144h.setVisibility(0);
            return;
        }
    }

    static {
        f7130n = new C0132a(null);
    }

    public static final /* synthetic */ b a(a r10) {
        return r10.f7138h;
    }

    public static final /* synthetic */ OMiddleArrowPopoverLayout b(a r10) {
        OMiddleArrowPopoverLayout r11 = r10.f7133c;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L5:
        return r11;
    }

    public static final /* synthetic */ c c(a r10) {
        return r10.f7137g;
    }

    public static final /* synthetic */ void d(a r10, OMiddleArrowPopoverLayout r11) {
        r10.f7133c = r11;
    }

    @UiThread
    private final void e(boolean r18) {
        OMiddleArrowPopoverLayout r10 = this.f7133c;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L6:
        if (r18 == true) goto L8;
        f7128l--;
        this.f7134d = true;
    L8:
        this.f7135e = new AnimatorSet();
        int r11 = f();
        float r12 = 0.0f;
        if (r11 != 3) goto L11;
        float r13 = r10.getX() + r10.getMeasuredWidth();
        float r14 = r10.getY();
        OMiddleArrowPopoverLayout r15 = this.f7133c;
        if (r15 != null) goto L31;
    L30:
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L31:
        float r16 = r15.getBubbleOffset() + r14;
    L32:
        r10.setPivotY(r16);
        r10.setPivotX(r13);
        Interpolator r17 = PathInterpolatorCompat.create(0.0f, 0.0f, 1.0f, 1.0f);
        Interpolator r19 = PathInterpolatorCompat.create(0.3f, 0.0f, 0.9f, 0.6f);
        float[] r20 = new float[2];
        if (r18 == false) goto L35;
        float r110 = 0.0f;
    L36:
        r20[0] = r110;
        if (r18 == false) goto L39;
        r12 = 1.0f;
    L39:
        r20[1] = r12;
        ObjectAnimator r21 = ObjectAnimator.ofFloat(r10, "alpha", r20);
        if (r18 == true) goto L43;
        r17 = r19;
    L43:
        r21.setInterpolator(r17);
        if (r18 == false) goto L46;
        long r111 = 90;
    L47:
        r21.setDuration(r111);
        float[] r22 = new float[2];
        float r112 = 0.5f;
        if (r18 == false) goto L50;
        float r113 = 0.5f;
    L51:
        r22[0] = r113;
        float r114 = 0.8f;
        if (r18 == false) goto L54;
        float r115 = 1.0f;
    L55:
        r22[1] = r115;
        ObjectAnimator r23 = ObjectAnimator.ofFloat(r10, "scaleX", r22);
        if (r18 == false) goto L58;
        Interpolator r116 = new com.obric.oui.popover.b(0.61f);
    L59:
        r23.setInterpolator(r116);
        if (r18 == false) goto L62;
        long r24 = 420;
    L63:
        r23.setDuration(r24);
        float[] r25 = new float[2];
        if (r18 == true) goto L67;
        r112 = 1.0f;
    L67:
        r25[0] = r112;
        if (r18 == false) goto L70;
        r114 = 1.0f;
    L70:
        r25[1] = r114;
        ObjectAnimator r26 = ObjectAnimator.ofFloat(r10, "scaleY", r25);
        if (r18 == false) goto L73;
        r19 = new com.obric.oui.popover.b(0.61f);
    L73:
        r26.setInterpolator(r19);
        if (r18 == false) goto L76;
        long r27 = 420;
    L77:
        r26.setDuration(r27);
        r10.setVisibility(0);
        if (r18 == false) goto L84;
        Animator r28 = this.f7139i;
        if (r28 == null) goto L84;
        AnimatorSet r29 = this.f7135e;
        if (r29 == null) goto L97;
    L83:
        r29.play(r28);
    L97:
        AnimatorSet r30 = this.f7135e;
        if (r30 == null) goto L101;
        r30.addListener(new d(this, r18, r10));
    L101:
        if (this.f7132b == false) goto L106;
        if (r18 == false) goto L106;
        AnimatorSet r31 = this.f7135e;
        if (r31 == null) goto L106;
        r31.setInterpolator(new OvershootInterpolator(1.0f));
    L106:
        AnimatorSet r32 = this.f7135e;
        if (r32 == null) goto L110;
        r32.start();
        return;
    L110:
        return;
    L84:
        if (r18 == true) goto L90;
        r28 = this.f7140j;
        if (r28 == null) goto L90;
        r29 = this.f7135e;
        if (r29 == null) goto L97;
    L90:
        AnimatorSet r33 = this.f7135e;
        if (r33 == null) goto L97;
        AnimatorSet.Builder r34 = r33.play(r23);
        if (r34 == null) goto L97;
        AnimatorSet.Builder r35 = r34.with(r26);
        if (r35 == null) goto L97;
        r35.with(r21);
        goto L97
    L76:
        r27 = 120;
        goto L77
    L62:
        r24 = 120;
        goto L63
    L58:
        r116 = r19;
        goto L59
    L54:
        r115 = 0.8f;
        goto L55
    L50:
        r113 = 1.0f;
        goto L51
    L46:
        r111 = 120;
        goto L47
    L35:
        r110 = 1.0f;
        goto L36
    L11:
        if (r11 != 5) goto L13;
        r13 = r10.getX();
        r14 = r10.getY();
        r15 = this.f7133c;
        if (r15 != null) goto L31;
    L13:
        if (r11 != 48) goto L15;
        float r36 = r10.getX();
        OMiddleArrowPopoverLayout r37 = this.f7133c;
        if (r37 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L24:
        r13 = r36 + r37.getBubbleOffset();
        r16 = r10.getY() + r10.getMeasuredHeight();
        goto L32
    L15:
        if (r11 == 80) goto L17;
        r16 = 0.0f;
        r13 = 0.0f;
        goto L32
    L17:
        float r38 = r10.getX();
        OMiddleArrowPopoverLayout r39 = this.f7133c;
        if (r39 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L20:
        r13 = r38 + r39.getBubbleOffset();
        r16 = r10.getY();
        goto L32
    }

    private final int f() {
        return f7130n.a(this.f7131a);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.f7134d == true) goto L6;
        e(false);
        getContentView().removeCallbacks(this.f7141k);
        return;
    }

    public final void g() {
        AnimatorSet r10 = this.f7135e;
        if (r10 == null) goto L5;
        r10.removeAllListeners();
    L5:
        AnimatorSet r11 = this.f7135e;
        if (r11 == null) goto L8;
        r11.cancel();
    L8:
        this.f7135e = null;
        if (this.f7136f.isFinishing() == true) goto L13;
        if (isShowing() == false) goto L13;
    L18:
        super.dismiss();     // Catch: Exception -> L17
        return;
    L20:
        return;
    L13:
        if (f7129m == true) goto L18;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r10, int r11, int r12, int r13) {
        super.showAsDropDown(r10, r11, r12, f7130n.a(r13));     // Catch: Exception -> L5
        this.f7134d = false;     // Catch: Exception -> L5
        e(true);     // Catch: Exception -> L5
        return;
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "anchor");
        super.showAtLocation(r10, f7130n.a(r11), r12, r13);     // Catch: Exception -> L5
        this.f7134d = false;     // Catch: Exception -> L5
        e(true);     // Catch: Exception -> L5
        return;
    }
}
