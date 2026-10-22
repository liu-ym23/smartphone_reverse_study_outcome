package com.larus.common_ui.floatwindow.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import hq9.f1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m0 implements v {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public int f;
    public final SingleFloatBall g;
    public View h;
    public SingleFloatWindowState i;
    public final ObjectAnimator j;
    public final ObjectAnimator k;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {
        public final /* synthetic */ m0 a;
        public final /* synthetic */ Function0 b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            SingleFloatBall r3 = this.a.g;
            r3.b.removeView(r3);
            Function0 r4 = this.b;
            if (r4 == null) goto L6;
            r4.invoke();
            return;
        }

        public b(m0 r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements Animator.AnimatorListener {
        public final /* synthetic */ WindowManager.LayoutParams a;
        public final /* synthetic */ m0 b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r6) {
            if (this.a.x >= 0) goto L6;
            final m0 r7 = this.b;
            r7.getClass();
            ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r0.setDuration(150);
            r0.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
            r0.addUpdateListener(new c0(r7));
            r0.start();
            return;
        }

        public c(WindowManager.LayoutParams r1, m0 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements Animator.AnimatorListener {
        public final /* synthetic */ m0 a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        public d(m0 r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            m0 r3 = this.a;
            r3.i = SingleFloatWindowState.MINIMIZE;
        }
    }

    public static final class e implements Animator.AnimatorListener {
        public final /* synthetic */ m0 a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        public e(m0 r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            m0 r3 = this.a;
            r3.i = SingleFloatWindowState.MAXIMIZE;
        }
    }

    public static final class f implements Animator.AnimatorListener {
        public final /* synthetic */ m0 a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        public f(m0 r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            m0 r3 = this.a;
            r3.i = SingleFloatWindowState.MAXIMIZE;
        }
    }

    static {
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void c() {
        View r0 = this.h;
        if (r0 == null) goto L6;
        removeView(r0);
        return;
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void e() {
        this.k.end();
        this.g.setAlpha(0.0f);
        SingleFloatBall r0 = this.g;
        r0.b.addView(r0, r0.e);
        this.g.post(new k0(this));
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void g() {
        WindowManager.LayoutParams r0 = this.g.getParams();
        int r1 = com.larus.utils.m0.a;
        r0.y = (com.larus.utils.m0.a(this.g.getContext()) - r0.height) / 2;
        this.g.c(r0);
    }

    public final f1 j() {
        return (f1) this.a.getValue();
    }

    public final int k() {
        return ((Number) this.c.getValue()).intValue();
    }

    public final int l() {
        return ((Number) this.d.getValue()).intValue();
    }

    public final int m() {
        return ((Number) this.e.getValue()).intValue();
    }

    public final void o() {
        if (j().e() == false) goto L5;
        final WindowManager.LayoutParams r6 = this.g.getParams();
        AnimatorSet r11 = new AnimatorSet();
        u r0 = this.g.getHotInfo();
        int r12 = RangesKt.coerceAtLeast(r6.y - ((this.f - k()) / 2), r0.b);
        int r13 = com.larus.utils.m0.a;
        final ValueAnimator r14 = ValueAnimator.ofInt(new int[]{r6.y, RangesKt.coerceAtMost(r12, (com.larus.utils.m0.a(this.g.getContext()) - r0.c) - r6.height)});
        r14.setDuration(200);
        r14.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        final ValueAnimator r15 = ValueAnimator.ofInt(new int[]{r6.x, r0.a});
        r15.setDuration(150);
        r15.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        Intrinsics.checkNotNull(r15);
        r15.addListener(new f(this));
        final ValueAnimator r16 = ValueAnimator.ofInt(new int[]{r6.height, this.f});
        r16.setDuration(r14.getDuration());
        r16.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        final ValueAnimator r17 = ValueAnimator.ofInt(new int[]{m(), l()});
        r17.setDuration(r14.getDuration());
        r17.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        ValueAnimator r5 = ValueAnimator.ofInt(new int[]{0, 100});
        r5.setDuration(Math.max(r15.getDuration(), r14.getDuration()));
        r5.addUpdateListener(new l0(r6, r15, r14, r16, r17, this));
        r11.playTogether(new Animator[]{r15, r14, r5, r16, r17});
        r11.start();
        return;
    L5:
        final WindowManager.LayoutParams r1 = this.g.getParams();
        ValueAnimator r7 = ValueAnimator.ofInt(new int[]{r1.x, this.g.getHotInfo().a});
        r7.setDuration(150);
        r7.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        r7.addUpdateListener(new b0(r1, this));
        Intrinsics.checkNotNull(r7);
        r7.addListener(new n0(this));
        r7.start();
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final SingleFloatWindowState d() {
        return this.i;
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void a(Function0<Unit> r3) {
        this.j.end();
        this.g.setAlpha(1.0f);
        this.k.addListener(new b(this, r3));
        this.k.start();
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final Rect f(boolean r5) {
        SingleFloatBall r0 = this.g;
        r0.getClass();
        Rect r1 = new Rect();
        if (r0.b.b(r0) == true) goto L6;
        if (r5 == true) goto L6;
    L10:
        return r1;
    L6:
        if (r0.b() == false) goto L8;
        int r6 = r0.e.x;
    L9:
        WindowManager.LayoutParams r2 = r0.e;
        int r3 = r2.width + r6;
        int r4 = r2.y;
        r1.set(r6, r4, r3, r2.height + r4);
        goto L10
    L8:
        int r7 = com.larus.utils.m0.a;
        int r8 = com.larus.utils.m0.b(r0.getContext());
        WindowManager.LayoutParams r9 = r0.e;
        r6 = (r8 - r9.x) - r9.width;
        goto L9
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void i(AppCompatActivity r6) {
        Intrinsics.checkNotNullParameter(r6, "activity");
        SingleFloatBall r1 = this.g;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "activity");
        h r2 = r1.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "activity");
        FLogger r0 = FLogger.a;
        r0.d("FloatWindowManager", "forwardSwitch activity: " + r6);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        Activity r7 = com.larus.common_ui.floatwindow.view.e.b(r6);     // Catch: Throwable -> L5
        r0.d("FloatWindowManager", "forwardSwitch forwardActivity: " + r7);     // Catch: Throwable -> L5
        r2.e(r7);     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L13;
        FLogger.a.d("FloatWindowManager", "forwardSwitch crash. throwable:" + r9.getMessage());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void removeView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        if (this.h != r5) goto L5;
        this.h = null;
    L5:
        SingleFloatBall r1 = this.g;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "view");
        FLogger.a.d("SingleFloatBall", "removeContentView.");
        r1.f.removeView(r5);
        WindowManager.LayoutParams r6 = r1.e;
        r6.width = 0;
        r6.height = 0;
        r1.b.updateViewLayout(r1, r6);
    }

    public m0(Application r8, h r9) {
        Intrinsics.checkNotNullParameter(r8, "application");
        Intrinsics.checkNotNullParameter(r9, "winManager");
        this.a = LazyKt.lazy(new f0());
        this.b = LazyKt.lazy(new g0(this));
        this.c = LazyKt.lazy(new h0());
        this.d = LazyKt.lazy(new i0());
        this.e = LazyKt.lazy(new j0());
        SingleFloatBall r0 = new SingleFloatBall(r8, this, r9);
        this.g = r0;
        this.i = SingleFloatWindowState.MAXIMIZE;
        ObjectAnimator r10 = ObjectAnimator.ofFloat(r0, View.ALPHA, new float[]{0.0f, 1.0f});
        r10.setDuration(150);
        r10.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        this.j = r10;
        ObjectAnimator r11 = ObjectAnimator.ofFloat(r0, View.ALPHA, new float[]{1.0f, 0.0f});
        r11.setDuration(150);
        r11.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        this.k = r11;
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void b(SingleFloatWindowState r5, boolean r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5 != this.i) goto L7;
        return;
    L7:
        if (r6 == true) goto L9;
        WindowManager.LayoutParams r7 = this.g.getParams();
        u r1 = this.g.getHotInfo();
        SingleFloatWindowState r2 = SingleFloatWindowState.MAXIMIZE;
        if (r5 != r2) goto L22;
        FLogger.a.i("SingleFloatWindowHandler", "changeWindowStateWithoutAnimation. MAXIMIZE");
        r7.x = this.g.getHotInfo().a;
        if (j().e() == false) goto L17;
        int r8 = RangesKt.coerceAtLeast(r7.y - ((this.f - k()) / 2), r1.b);
        int r0 = com.larus.utils.m0.a;
        r7.y = RangesKt.coerceAtMost(r8, (com.larus.utils.m0.a(this.g.getContext()) - r1.c) - r7.height);
        r7.height = this.f;
        this.g.setClipViewCornerRadius(l());
    L17:
        SingleFloatBall r9 = this.g;
        r9.c(r9.getParams());
        SingleFloatBall r10 = this.g;
        if (r10.b() == false) goto L20;
        ImageView r11 = r10.i;
    L21:
        e1.o(r11);
        this.i = r2;
        return;
    L20:
        r11 = r10.j;
        goto L21
    L22:
        FLogger.a.i("SingleFloatWindowHandler", "changeWindowStateWithoutAnimation. MINIMIZE");
        r7.x = 0 - (r7.width - ((Number) this.b.getValue()).intValue());
        if (j().e() == false) goto L25;
        int r12 = RangesKt.coerceAtLeast(r7.y + ((this.f - k()) / 2), r1.b);
        int r3 = com.larus.utils.m0.a;
        r7.y = RangesKt.coerceAtMost(r12, (com.larus.utils.m0.a(this.g.getContext()) - r1.c) - r7.height);
        r7.height = k();
        this.g.setClipViewCornerRadius(m());
    L25:
        this.g.c(r7);
        SingleFloatBall r13 = this.g;
        if (r13.b() == false) goto L28;
        ImageView r14 = r13.i;
    L29:
        r14.setAlpha(1.0f);
        e1.x(r14);
        this.g.setMaskClickListener(new a0(this));
        this.i = SingleFloatWindowState.MINIMIZE;
        return;
    L28:
        r14 = r13.j;
        goto L29
    L9:
        if (r5 != SingleFloatWindowState.MAXIMIZE) goto L11;
        FLogger.a.i("SingleFloatWindowHandler", "changeWindowStateWithAnimation. MAXIMIZE");
        o();
        this.g.setMaskClickListener(null);
        return;
    L11:
        FLogger.a.i("SingleFloatWindowHandler", "changeWindowStateWithAnimation. MINIMIZE");
        n(true, true);
    }

    public final void n(boolean r18, boolean r110) {
        final WindowManager.LayoutParams r8 = this.g.getParams();
        AnimatorSet r9 = new AnimatorSet();
        u r0 = this.g.getHotInfo();
        if (r110 == false) goto L5;
        long r1 = 2;
    L6:
        int r3 = r8.x;
        if (r3 < ((-r8.width) / 2)) goto L14;
        if (r3 < 0) goto L10;
    L11:
        if (r18 == true) goto L14;
        boolean r4 = false;
    L15:
        if (r4 == false) goto L17;
    L21:
        boolean r5 = false;
    L22:
        if (r4 == true) goto L24;
    L26:
        if (r5 == false) goto L28;
        int r6 = r8.y - ((this.f - k()) / 2);
    L29:
        int r7 = RangesKt.coerceAtLeast(r6, r0.b);
        int r10 = com.larus.utils.m0.a;
        final ValueAnimator r13 = ValueAnimator.ofInt(new int[]{r8.y, RangesKt.coerceAtMost(r7, (com.larus.utils.m0.a(this.g.getContext()) - r0.c) - r8.height)});
        long r11 = ((long) BaiduNaviStatus.WRONG_AK_PARAM) * r1;
        r13.setDuration(r11);
        r13.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        if (r4 == false) goto L32;
        this.g.setMaskClickListener(new d0(this));
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{r8.x, -(r8.width - ((Number) this.b.getValue()).intValue())});
        r2.setDuration(((long) 150) * r1);
        r2.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        Intrinsics.checkNotNull(r2);
        r2.addListener(new d(this));
    L33:
        final ValueAnimator r14 = r2;
        int[] r12 = new int[2];
        r12[0] = r8.height;
        if (r4 == true) goto L36;
    L38:
        if (r5 == false) goto L40;
        int r15 = this.f;
    L41:
        r12[1] = r15;
        final ValueAnimator r16 = ValueAnimator.ofInt(r12);
        r16.setDuration(r13.getDuration());
        r16.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        int[] r17 = new int[2];
        if (this.i == SingleFloatWindowState.MINIMIZE) goto L44;
    L46:
        int r20 = l();
    L47:
        r17[0] = r20;
        if (r4 == true) goto L50;
    L52:
        int r21 = l();
    L53:
        r17[1] = r21;
        final ValueAnimator r22 = ValueAnimator.ofInt(r17);
        r22.setDuration(r13.getDuration());
        r22.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        ValueAnimator r111 = ValueAnimator.ofInt(new int[]{0, 100});
        r111.setDuration(Math.max(r14.getDuration(), r13.getDuration()));
        r111.addUpdateListener(new e0(r8, r14, r13, r16, r22, this));
        Intrinsics.checkNotNull(r111);
        r111.addListener(new c(r8, this));
        r9.playTogether(new Animator[]{r14, r13, r111, r16, r22});
        r9.start();
        return;
    L50:
        if (j().e() == false) goto L52;
        r21 = m();
        goto L53
    L44:
        if (j().e() == false) goto L46;
        r20 = m();
        goto L47
    L40:
        r15 = r8.height;
        goto L41
    L36:
        if (j().e() == false) goto L38;
        r15 = k();
        goto L41
    L32:
        r2 = ValueAnimator.ofInt(new int[]{r8.x, r0.a});
        r2.setDuration(r11);
        r2.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        Intrinsics.checkNotNull(r2);
        r2.addListener(new e(this));
        goto L33
    L28:
        r6 = r8.y;
        goto L29
    L24:
        if (j().e() == false) goto L26;
        r6 = r8.y + ((r8.height - k()) / 2);
        goto L29
    L17:
        if (j().e() == false) goto L21;
        if (this.i != SingleFloatWindowState.MINIMIZE) goto L21;
        r5 = true;
        goto L22
    L10:
        if (this.i != SingleFloatWindowState.MAXIMIZE) goto L11;
    L14:
        r4 = true;
        goto L15
    L5:
        r1 = 1;
        goto L6
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void h(e19.h r7, SingleFloatWindowState r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "request");
        this.f = r7.getHeight();
        if (this.i == SingleFloatWindowState.MINIMIZE) goto L5;
    L7:
        int r0 = r7.getHeight();
    L8:
        View r1 = r7.getContentView();
        this.h = r1;
        final SingleFloatBall r2 = this.g;
        int r3 = r7.getWidth();
        int r10 = r7.getHeight();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "view");
        WindowManager.LayoutParams r4 = r2.e;
        r4.width = r3;
        r4.height = r0;
        if (r2.f.indexOfChild(r1) == (-1)) goto L11;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L15;
        FLogger.a.d("SingleFloatBall", "updateContentView. has contained");
        r1.getLayoutParams().width = r3;
        r1.getLayoutParams().height = r10;
        r2.b.updateViewLayout(r2, r2.e);
    L17:
        if (r2.g.getBackground() != null) goto L19;
    L20:
        boolean r11 = v19.h.a;
        if (v19.h.a(null) == false) goto L23;
        int r12 = 2131103092;
    L24:
        ColorDrawable r6 = new ColorDrawable(ContextCompat.getColor(r1.getContext(), r12));
        r2.g.setBackground(r6);
        r2.h.setBackground(r6);
    L25:
        r2.postDelayed(new w(r2), 1100);
        b(r8, r9);
        return;
    L23:
        r12 = 2131103091;
        goto L24
    L19:
        if (r2.h.getBackground() != null) goto L25;
    L15:
        r2.f.removeAllViews();
        FLogger.a.d("SingleFloatBall", "updateContentView. remove all and add");
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(r3, r10);
        r2.f.addView(r1, r13);
        r2.b.updateViewLayout(r2, r2.e);
        goto L17
    L11:
        r5 = false;
        goto L13
    L5:
        if (j().e() == false) goto L7;
        r0 = k();
        goto L8
    }
}
