package com.ss.android.lark.floating.widget.appfloat;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.floating.enums.SideHideDirection;
import com.ss.android.lark.floating.enums.SidePattern;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class TouchUtils {
    public static final /* synthetic */ int v = 0;
    public final Context a;
    public final vfb.a b;
    public final Rect c;
    public int d;
    public int e;
    public float f;
    public float g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public final int[] n;
    public int o;
    public boolean p;
    public Animator q;
    public boolean r;
    public boolean s;
    public SideHideDirection t;
    public final int u;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SidePattern.values().length];
            r0[SidePattern.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L49:
            r0[SidePattern.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L59:
            r0[SidePattern.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L37:
            r0[SidePattern.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L39:
            r0[SidePattern.AUTO_HORIZONTAL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L45:
            r0[SidePattern.AUTO_VERTICAL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L24
        L55:
            r0[SidePattern.AUTO_SIDE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L25
        L41:
            r0[SidePattern.RESULT_LEFT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L51:
            r0[SidePattern.RESULT_RIGHT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L27
        L53:
            r0[SidePattern.RESULT_TOP.ordinal()] = 10;     // Catch: NoSuchFieldError -> L28
        L35:
            r0[SidePattern.RESULT_BOTTOM.ordinal()] = 11;     // Catch: NoSuchFieldError -> L29
        L47:
            r0[SidePattern.RESULT_VERTICAL.ordinal()] = 12;     // Catch: NoSuchFieldError -> L30
        L57:
            r0[SidePattern.RESULT_SIDE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L31
        L33:
            r0[SidePattern.RESULT_HORIZONTAL.ordinal()] = 14;     // Catch: NoSuchFieldError -> L32
        L17:
            a = r0;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ h b;
        public final /* synthetic */ WindowManager c;
        public final /* synthetic */ View d;
        public final /* synthetic */ ValueAnimator e;

        public c(boolean r1, h r2, WindowManager r3, View r4, ValueAnimator r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
        L10:
            this.e.cancel();
            return;
        L5:
            if (this.a == false) goto L7;
            h r0 = this.b;     // Catch: Exception -> L10
            Object r4 = r3.getAnimatedValue();     // Catch: Exception -> L10
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L10
            ((WindowManager.LayoutParams) r0.a).x = ((Integer) r4).intValue();     // Catch: Exception -> L10
        L8:
            this.c.updateViewLayout(this.d, this.b.a);     // Catch: Exception -> L10
            return;
        L7:
            h r1 = this.b;     // Catch: Exception -> L10
            Object r5 = r3.getAnimatedValue();     // Catch: Exception -> L10
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L10
            ((WindowManager.LayoutParams) r1.a).y = ((Integer) r5).intValue();     // Catch: Exception -> L10
            goto L8
        }
    }

    public static final class d implements Animator.AnimatorListener {
        public final /* synthetic */ TouchUtils a;
        public final /* synthetic */ View b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ AppFloatManager.b d;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            this.a.c(this.b, this.c, false);
            AppFloatManager.b r5 = this.d;
            if (r5 == null) goto L6;
            r5.a();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            this.a.c(this.b, this.c, false);
            AppFloatManager.b r5 = this.d;
            if (r5 == null) goto L6;
            r5.a();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            TouchUtils r4 = this.a;
            r4.b.j = true;
            TouchUtils.a(r4, this.c);
        }

        public d(TouchUtils r1, View r2, boolean r3, AppFloatManager.b r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public final int e() {
        int r0 = this.e;
        vfb.a r1 = this.b;
        return ((r0 - r1.g) - r1.f) - this.u;
    }

    public final void l() {
        if (this.r == false) goto L17;
        SidePattern r0 = this.b.m;
        int r1 = b.a[r0.ordinal()];
        if (r1 != 8) goto L7;
        SideHideDirection r2 = SideHideDirection.LEFT;
    L18:
        this.t = r2;
        return;
    L7:
        if (r1 != 9) goto L9;
        r2 = SideHideDirection.RIGHT;
        goto L18
    L9:
        if (r1 == 14) goto L12;
        r2 = SideHideDirection.NONE;
        goto L18
    L12:
        if (this.h >= this.i) goto L14;
        r2 = SideHideDirection.LEFT;
        goto L18
    L14:
        r2 = SideHideDirection.RIGHT;
        goto L18
    L17:
        r2 = SideHideDirection.NONE;
        goto L18
    }

    public final Context getContext() {
        return this.a;
    }

    public static int k(View r3) {
        int r0 = xfb.d.a;
        Intrinsics.checkNotNullParameter(r3, "view");
        Context r4 = r3.getContext().getApplicationContext();
        Intrinsics.checkNotNullParameter(r4, "context");
        Resources r5 = r4.getResources();
        int r1 = r5.getIdentifier("status_bar_height", "dimen", "android");
        if (r1 > 0) goto L7;
        return 0;
    L7:
        return r5.getDimensionPixelSize(r1);
    }

    public final int d(View r3) {
        int r4 = 0 - r3.getWidth();
        vfb.a r0 = this.b;
        return ((r4 + r0.g) + r0.f) + this.u;
    }

    public final void h(final Function0<Unit> r4) {
        if (FeatureGatingModule.getFeatureGatingService().isEnable("core.appfloat.windowsize_refactor") == false) goto L9;
        xfb.g r0 = xfb.g.e;
        if (r0 != null) goto L8;
        r0 = new xfb.g();
        xfb.g.e = r0;
    L8:
        Function1<Point, Unit> r1 = new TouchUtils$resetParentWidthAndHeight$1(this, r4);
        Intrinsics.checkNotNullParameter(r1, "callback");
        r0.d.post(new xfb.h(r0, r1));
        return;
    L9:
        this.e = xfb.d.b(this.a);
        this.d = this.b.E.a(this.a);
    }

    public TouchUtils(Context r3, vfb.a r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "config");
        this.a = r3;
        this.b = r4;
        this.c = new Rect();
        this.n = new int[2];
        this.p = true;
        this.t = SideHideDirection.NONE;
        this.u = UIHelper.dp2px(5.0f);
        if (FeatureGatingModule.getFeatureGatingService().isEnable("core.appfloat.windowsize_refactor") == false) goto L6;
        h(null);
        return;
    L6:
        if (this.e != 0) goto L9;
        this.e = xfb.d.b(r3);
    L9:
        if (this.d != 0) goto L13;
        this.d = r4.E.a(r3);
        return;
    }

    public static final void a(TouchUtils r2, boolean r3) {
        r2.s = r2.r;
        if (r3 == false) goto L16;
        wfb.a r4 = r2.b.B;
        if (r4 == null) goto L17;
        wfb.a.C0318a r5 = r4.a();
        if (r5 == null) goto L18;
        Function2<? super Boolean, ? super Boolean, Unit> r6 = r5.f;
        if (r6 == null) goto L19;
        Boolean r0 = Boolean.valueOf(r2.r);
        if (r2.t != SideHideDirection.RIGHT) goto L13;
        boolean r7 = true;
    L14:
        r6.invoke(r0, Boolean.valueOf(r7));
        return;
    L13:
        r7 = false;
        goto L14
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void f(h r4, View r5) {
        int r0 = ((WindowManager.LayoutParams) r4.a).x;
        this.h = r0;
        this.i = this.e - (r0 + r5.getRight());
        int r6 = ((WindowManager.LayoutParams) r4.a).y;
        this.j = r6;
        if (this.p == false) goto L5;
        int r7 = ((this.d - k(r5)) - this.j) - r5.getHeight();
    L6:
        this.k = r7;
        this.l = Math.min(this.h, this.i);
        this.m = Math.min(this.j, this.k);
        return;
    L5:
        r7 = (this.d - r6) - r5.getHeight();
        goto L6
    }

    public final void c(View r3, boolean r4, boolean r5) {
        vfb.a r0 = this.b;
        boolean r1 = false;
        r0.j = false;
        r0.getClass();
        this.s = this.r;
        wfb.a r2 = this.b.B;
        if (r2 == null) goto L9;
        wfb.a.C0318a r6 = r2.a();
        if (r6 == null) goto L9;
        Function1<? super View, Unit> r7 = r6.e;
        if (r7 == null) goto L9;
        r7.invoke(r3);
    L9:
        if (r4 == false) goto L28;
        wfb.a r8 = this.b.B;
        if (r8 == null) goto L17;
        wfb.a.C0318a r9 = r8.a();
        if (r9 == null) goto L17;
        Function1<? super Boolean, Unit> r10 = r9.h;
        if (r10 == null) goto L17;
        r10.invoke(Boolean.valueOf(r5));
    L17:
        wfb.a r11 = this.b.B;
        if (r11 == null) goto L29;
        wfb.a.C0318a r12 = r11.a();
        if (r12 == null) goto L30;
        Function2<? super Boolean, ? super Boolean, Unit> r13 = r12.g;
        if (r13 == null) goto L31;
        Boolean r14 = Boolean.valueOf(this.r);
        if (this.t != SideHideDirection.RIGHT) goto L26;
        r1 = true;
    L26:
        r13.invoke(r14, Boolean.valueOf(r1));
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    }

    public final void g(com.ss.android.lark.floating.widget.appfloat.d r9, h r10, int r11, WindowManager r12, AppFloatManager.d.a r13) {
        f(r10, r9);
        int r0 = 0;
        this.r = false;
        this.s = false;
        this.t = SideHideDirection.NONE;
        SidePattern r1 = this.b.m;
        int[] r2 = b.a;
        switch(r2[r1.ordinal()]) {
            case 8: goto L37;
            case 9: goto L36;
            case 10: goto L34;
            case 11: goto L30;
            case 12: goto L23;
            case 13: goto L10;
            case 14: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        int r3 = this.h;
        int r4 = this.i;
        if (r3 >= r4) goto L8;
        r0 = 0 - r11;
        goto L37
    L8:
        r0 = (((WindowManager.LayoutParams) r10.a).x + r4) + r11;
    L34:
        int r14 = 0;
    L35:
        boolean r5 = false;
    L38:
        vfb.a r6 = this.b;
        if (r6.u == 8388613) goto L42;
    L68:
        b(r5, r10, r14, r12, r9, r13, true);
        return;
    L42:
        switch(r2[r6.m.ordinal()]) {
            case 8: goto L66;
            case 9: goto L64;
            case 10: goto L63;
            case 11: goto L62;
            case 12: goto L59;
            case 13: goto L49;
            case 14: goto L45;
            default: goto L68;
        };
    L62:
        int r7 = ((Number) this.b.v.getSecond()).intValue();
    L65:
        r14 = r14 + r7;
        goto L68
    L63:
        int r8 = ((Number) this.b.v.getSecond()).intValue();
    L67:
        r14 = r14 - r8;
        goto L68
    L64:
        r7 = ((Number) this.b.v.getFirst()).intValue();
        goto L65
    L66:
        r8 = ((Number) this.b.v.getFirst()).intValue();
        goto L67
    L45:
        if (this.h >= this.i) goto L47;
        r8 = ((Number) this.b.v.getFirst()).intValue();
        goto L67
    L47:
        r7 = ((Number) this.b.v.getFirst()).intValue();
        goto L65
    L49:
        if (this.l >= this.m) goto L55;
        if (this.h >= this.i) goto L53;
        r8 = ((Number) this.b.v.getFirst()).intValue();
        goto L67
    L53:
        r7 = ((Number) this.b.v.getFirst()).intValue();
        goto L65
    L55:
        if (this.j >= this.k) goto L57;
        r8 = ((Number) this.b.v.getSecond()).intValue();
        goto L67
    L57:
        r7 = ((Number) this.b.v.getSecond()).intValue();
        goto L65
    L59:
        if (this.j >= this.k) goto L61;
        r8 = ((Number) this.b.v.getSecond()).intValue();
        goto L67
    L61:
        r7 = ((Number) this.b.v.getSecond()).intValue();
        goto L65
    L36:
        int r15 = ((WindowManager.LayoutParams) r10.a).x;
        r0 = this.i + r15;
    L37:
        r14 = r0;
        r5 = true;
        goto L38
    L10:
        if (this.l >= this.m) goto L16;
        int r16 = this.h;
        int r17 = this.i;
        if (r16 < r17) goto L37;
        r0 = ((WindowManager.LayoutParams) r10.a).x + r17;
        goto L37
    L16:
        if (this.j < this.k) goto L34;
        if (this.p == false) goto L21;
        int r18 = this.o;
        int r19 = k(r9);
    L32:
        r14 = r18 - r19;
        goto L35
    L21:
        r14 = this.o;
        goto L35
    L23:
        if (this.j < this.k) goto L34;
        if (this.p == false) goto L28;
        r18 = this.o;
        r19 = k(r9);
        goto L32
    L28:
        r14 = this.o;
        goto L35
    L30:
        if (this.p == false) goto L33;
        r18 = this.o;
        r19 = k(r9);
        goto L32
    L33:
        r14 = this.o;
        goto L35
    }

    public static /* synthetic */ void j(TouchUtils r9, h r10, int r11, WindowManager r12, com.ss.android.lark.floating.widget.appfloat.d r13, AppFloatManager.e r14, boolean r15) {
        r9.i(r10, r11, 0, r12, r13, r14, r15, false);
    }

    public final Animator b(boolean r9, h r10, int r11, WindowManager r12, View r13, AppFloatManager.b r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r12, "windowManager");
        Intrinsics.checkNotNullParameter(r13, "view");
        Animator r0 = this.q;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.q = null;
        int[] r1 = new int[2];
        if (r9 == false) goto L8;
        int r2 = ((WindowManager.LayoutParams) r10.a).x;
    L9:
        r1[0] = r2;
        r1[1] = r11;
        ValueAnimator r16 = ValueAnimator.ofInt(r1);
        r16.addUpdateListener(new c(r9, r10, r12, r13, r16));
        r16.setDuration(300);
        r16.addListener(new d(this, r13, r15, r14));
        r16.start();
        this.q = r16;
        Intrinsics.checkNotNull(r16);
        return r16;
    L8:
        r2 = ((WindowManager.LayoutParams) r10.a).y;
        goto L9
    }

    public final Animator i(h r7, int r8, int r9, WindowManager r10, com.ss.android.lark.floating.widget.appfloat.d r11, AppFloatManager.e r12, boolean r13, boolean r14) {
        Animator r0 = this.q;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.q = null;
        this.r = false;
        this.s = false;
        this.t = SideHideDirection.NONE;
        WindowManagerLayoutParamsInternal r2 = r7.a;
        Point r1 = new Point(((WindowManager.LayoutParams) r2).x, ((WindowManager.LayoutParams) r2).y);
        if (r9 != 0) goto L9;
        r9 = ((WindowManager.LayoutParams) r7.a).y;
    L9:
        if (r9 < (this.d - r11.getHeight())) goto L11;
        r9 = this.d - r11.getHeight();
    L11:
        Point r3 = new Point(r8, r9);
        ValueAnimator r15 = ValueAnimator.ofObject(new g(new Point()), new Object[]{r1, r3});
        r15.setDuration(300);
        r15.addUpdateListener(new e(r7, r10, r11, r15));
        r15.addListener(new f(this, r11, r13, r14, r12));
        r15.start();
        this.q = r15;
        return r15;
    }
}
