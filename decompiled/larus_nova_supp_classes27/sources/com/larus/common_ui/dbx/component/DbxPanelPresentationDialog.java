package com.larus.common_ui.dbx.component;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.FragmentActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DbxPanelPresentationDialog extends Dialog implements DbxPanelDragLayout.a {
    public boolean A;
    public final Handler B;
    public int C;
    public ValueAnimator D;
    public AnimationKind E;
    public Function1<? super Boolean, Unit> F;
    public final k G;
    public final float H;
    public final float I;
    public final float J;
    public final float K;
    public final v a;
    public DbxPanelDetent b;
    public Function1<? super DbxPanelDismissReason, Unit> c;
    public final boolean d;
    public final FrameLayout e;
    public final View f;
    public final DbxPanelDragLayout g;
    public PresentationState h;
    public int i;
    public int j;
    public int k;
    public Pair<Integer, Integer> l;
    public boolean m;
    public float n;
    public Integer o;
    public boolean p;
    public boolean q;
    public float r;
    public float s;
    public DbxPanelDetent t;
    public float u;
    public boolean v;
    public Function0<Unit> w;
    public a x;
    public boolean y;
    public boolean z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxPanelPresentationDialog$AnimationKind;", "", "<init>", "(Ljava/lang/String;I)V", "PRESENTATION", "SETTLEMENT", "DISMISSAL", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AnimationKind extends Enum<AnimationKind> {
        public static final AnimationKind DISMISSAL = null;
        public static final AnimationKind PRESENTATION = null;
        public static final AnimationKind SETTLEMENT = null;
        public static final /* synthetic */ AnimationKind[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<AnimationKind> getEntries() {
            return b;
        }

        static {
            AnimationKind r0 = new AnimationKind("PRESENTATION", 0);
            PRESENTATION = r0;
            AnimationKind r1 = new AnimationKind("SETTLEMENT", 1);
            SETTLEMENT = r1;
            AnimationKind r3 = new AnimationKind("DISMISSAL", 2);
            DISMISSAL = r3;
            AnimationKind[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static AnimationKind[] values() {
            return (AnimationKind[]) a.clone();
        }

        public static AnimationKind valueOf(String r1) {
            return (AnimationKind) r27.a.a(AnimationKind.class, r1);
        }

        public AnimationKind(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxPanelPresentationDialog$PresentationState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "PREPARING", "PRESENTING", "STABLE", "DRAGGING", "SETTLING", "CLOSING", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PresentationState extends Enum<PresentationState> {
        public static final PresentationState CLOSING = null;
        public static final PresentationState DRAGGING = null;
        public static final PresentationState IDLE = null;
        public static final PresentationState PREPARING = null;
        public static final PresentationState PRESENTING = null;
        public static final PresentationState SETTLING = null;
        public static final PresentationState STABLE = null;
        public static final /* synthetic */ PresentationState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PresentationState> getEntries() {
            return b;
        }

        static {
            PresentationState r0 = new PresentationState("IDLE", 0);
            IDLE = r0;
            PresentationState r1 = new PresentationState("PREPARING", 1);
            PREPARING = r1;
            PresentationState r3 = new PresentationState("PRESENTING", 2);
            PRESENTING = r3;
            PresentationState r5 = new PresentationState("STABLE", 3);
            STABLE = r5;
            PresentationState r7 = new PresentationState("DRAGGING", 4);
            DRAGGING = r7;
            PresentationState r9 = new PresentationState("SETTLING", 5);
            SETTLING = r9;
            PresentationState r11 = new PresentationState("CLOSING", 6);
            CLOSING = r11;
            PresentationState[] r13 = {r0, r1, r3, r5, r7, r9, r11};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
        }

        public static PresentationState[] values() {
            return (PresentationState[]) a.clone();
        }

        public static PresentationState valueOf(String r1) {
            return (PresentationState) r27.a.a(PresentationState.class, r1);
        }

        public PresentationState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final DbxPanelDismissReason a;
        public final Function1<DbxPanelDismissReason, Unit> b;
        public final Function0<Unit> c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Function1<DbxPanelDismissReason, Unit> r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Function0<Unit> r5 = this.c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "PendingDismissal(reason=" + this.a + ", callback=" + this.b + ", completion=" + this.c + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(DbxPanelDismissReason r2, Function1<? super DbxPanelDismissReason, Unit> r3, Function0<Unit> r4) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[DbxPanelDragEndAction.values().length];
            r0[DbxPanelDragEndAction.RESTORE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L46:
            r0[DbxPanelDragEndAction.MINIMUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L60:
            r0[DbxPanelDragEndAction.MAXIMUM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L48:
            r0[DbxPanelDragEndAction.DISMISS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L10:
            a = r0;
            int[] r1 = new int[PresentationState.values().length];
            r1[PresentationState.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L52:
            r1[PresentationState.PREPARING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L36:
            r1[PresentationState.PRESENTING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L50:
            r1[PresentationState.STABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L40:
            r1[PresentationState.DRAGGING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
        L54:
            r1[PresentationState.SETTLING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L32
        L42:
            r1[PresentationState.CLOSING.ordinal()] = 7;     // Catch: NoSuchFieldError -> L33
        L18:
            b = r1;
            int[] r2 = new int[DbxPanelDetent.values().length];
            r2[DbxPanelDetent.MINIMUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L44:
            r2[DbxPanelDetent.MAXIMUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L21:
            c = r2;
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ DbxPanelPresentationDialog a;
        public final /* synthetic */ int b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;
        public final /* synthetic */ float e;
        public final /* synthetic */ Function0<Unit> f;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            DbxPanelPresentationDialog r0 = this.a;
            if (r0.C == this.b) goto L5;
            return;
        L5:
            if (r0.D != r4) goto L10;
            r0.D = null;
            r0.E = null;
            r0.f(this.c, this.d, this.e);
            this.f.invoke();
            return;
        }

        public c(DbxPanelPresentationDialog r1, int r2, float r3, float r4, float r5, Function0<Unit> r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public final void r() {
        g(false);
        this.e.removeCallbacks(this.G);
        DbxPanelDragLayout r1 = this.g;
        r1.b = false;
        r1.setScrollInteractionBlocked(false);
        r1.l = false;
        r1.k = false;
        r1.m = false;
        r1.n = false;
        r1.t = false;
        r1.u = false;
        r1.v = 0.0f;
        r1.q = false;
        r1.s = false;
        r1.y = null;
        r1.w = 0.0f;
        r1.x = false;
        r1.g = -1;
        r1.z.clear();
        VelocityTracker r4 = r1.f;
        if (r4 == null) goto L5;
        r4.recycle();
    L5:
        r1.f = null;
        r1.d.onStopNestedScroll(r1, 0);
        r1.g();
        r1.requestDisallowInterceptTouchEvent(false);
        v r2 = this.a;
        View r5 = r2.e.get();
        if (r5 == null) goto L8;
        r5.removeOnLayoutChangeListener(r2.d);
    L8:
        r2.e.clear();
        r2.f = 0;
        r2.g = null;
        r2.setMinimumHeight(0);
        r2.requestLayout();
        this.h = PresentationState.IDLE;
        this.w = null;
        this.x = null;
        this.m = false;
        this.j = 0;
        this.k = 0;
        this.o = null;
        this.p = false;
        this.q = true;
        this.A = false;
        this.u = 0.0f;
        this.g.setVisibility(4);
        this.g.setTranslationY(0.0f);
        this.f.setAlpha(0.0f);
    }

    @Override // com.larus.common_ui.dbx.component.DbxPanelDragLayout.a
    public final void c() {
        if (this.h == PresentationState.STABLE) goto L5;
        return;
    L5:
        this.h = PresentationState.DRAGGING;
        this.r = this.n;
        this.s = RangesKt.coerceAtLeast(this.g.getTranslationY(), 0.0f);
        this.t = this.b;
        this.u = 0.0f;
    }

    public final void i() {
        if (this.h == PresentationState.CLOSING) goto L5;
        return;
    L5:
        a r0 = this.x;
        if (r0 != null) goto L8;
        r0 = new a(DbxPanelDismissReason.PROGRAMMATIC, this.c, null);
    L8:
        this.x = null;
        this.z = true;
        e(this);     // Catch: Throwable -> L19
        this.z = false;
        r();
        DbxPanelDismissReason r2 = r0.a;
        Function1<DbxPanelDismissReason, Unit> r3 = r0.b;
        Function0<Unit> r1 = r0.c;
        if (this.y == true) goto L25;
        this.y = true;
        if (r3 == null) goto L16;
        r3.invoke(r2);
    L16:
        if (r1 == null) goto L24;
        r1.invoke();
        return;
    L24:
        return;
    L25:
        return;
    L19:
        th = move-exception;
        this.z = false;
        throw th;
    }

    public final void j() {
        PresentationState r0 = this.h;
        if (r0 != PresentationState.CLOSING) goto L5;
        return;
    L5:
        if (r0 == PresentationState.IDLE) goto L16;
        this.h = PresentationState.STABLE;
        this.g.setInteractionEnabled(true);
        this.g.setScrollInteractionBlocked(false);
        this.g.g();
        Function0<Unit> r1 = this.w;
        this.w = null;
        if (r1 == null) goto L11;
        r1.invoke();
    L11:
        if (this.p == false) goto L17;
        boolean r2 = this.q;
        this.p = false;
        this.q = true;
        p(r2);
        return;
    L17:
        return;
    }

    public final float m() {
        return RangesKt.coerceAtLeast(Math.max(this.e.getHeight(), this.g.getHeight()), this.n);
    }

    public final float n() {
        if (this.a.getWrapsContentHeight() == true) goto L7;
        int r0 = ((Number) this.l.getFirst()).intValue();
    L6:
        return r0;
    L7:
        Integer r1 = this.o;
        if (r1 == null) goto L10;
        r0 = RangesKt.coerceAtMost(r1.intValue(), ((Number) this.l.getSecond()).intValue());
        goto L6
    L10:
        r0 = ((Number) this.l.getFirst()).intValue();
        goto L6
    }

    public final boolean q() {
        boolean r1 = true;
        if (this.a.getWrapsContentHeight() == true) goto L11;
        if (this.o != null) goto L8;
        r1 = false;
    L8:
        this.o = null;
        return r1;
    L11:
        if (this.j > 0) goto L13;
    L39:
        return false;
    L13:
        if (((Number) this.l.getSecond()).intValue() <= 0) goto L39;
        v r0 = this.a;
        int r3 = this.j;
        int r4 = ((Number) this.l.getSecond()).intValue();
        r0.getClass();
        int r5 = Math.max(0, r3);
        int r6 = Math.max(0, r4);
        if (r5 <= 0) goto L30;
        if (r6 <= 0) goto L30;
        r0.measure(View.MeasureSpec.makeMeasureSpec(r5, 1073741824), View.MeasureSpec.makeMeasureSpec(r6, Integer.MIN_VALUE));
        if (r0.m.getChildCount() <= 0) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == false) goto L25;
        int r8 = RangesKt.coerceAtLeast(r0.j.getMeasuredHeight(), 0);
    L26:
        if (r7 == false) goto L28;
        int r9 = 0;
    L29:
        int r10 = Math.min(((r0.c(56) + r8) + r0.c(88)) + r9, r6);
        r6 = RangesKt.coerceIn(r0.getMeasuredHeight(), r10, r6);
        r0.requestLayout();
        goto L30
    L28:
        int r11 = r0.q.bottom;
        r9 = r0.k + r11;
        goto L29
    L25:
        r8 = 0;
        goto L26
    L22:
        r7 = false;
    L30:
        Integer r2 = this.o;
        if (r2 != null) goto L34;
    L37:
        this.o = Integer.valueOf(r6);
        return r1;
    L34:
        if (r2.intValue() != r6) goto L37;
        r1 = false;
        goto L37
    }

    public final void s() {
        if (this.h == PresentationState.CLOSING) goto L5;
        return;
    L5:
        t(AnimationKind.DISMISSAL, 250, this.n, m(), 0.0f, new AccelerateInterpolator(), new g(this));
    }

    public static void h() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("DbxPanelPresentationDialog 只能在主线程调用".toString());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L7;
        this.B.post(new m(this));
        return;
    L7:
        if (this.z == false) goto L10;
        e(this);
        return;
    L10:
        if (this.h == PresentationState.IDLE) goto L12;
        l(this, DbxPanelDismissReason.PROGRAMMATIC, 5);
        return;
    L12:
        e(this);
    }

    public final void k() {
        Window r0 = getWindow();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setBackgroundDrawable(new ColorDrawable(0));
        r0.clearFlags(2);
        r0.addFlags(Integer.MIN_VALUE);
        r0.setStatusBarColor(0);
        r0.setNavigationBarColor(0);
        r0.setLayout(-1, -1);
        WindowCompat.setDecorFitsSystemWindows(r0, false);
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        k();
        ViewCompat.requestApplyInsets(this.e);
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        if (this.z == false) goto L5;
        return;
    L5:
        if (this.h == PresentationState.IDLE) goto L30;
        a r0 = this.x;
        if (r0 == null) goto L11;
        DbxPanelDismissReason r1 = r0.a;
        if (r1 == null) goto L11;
    L12:
        if (r0 == null) goto L15;
        Function1 r2 = r0.b;
        if (r2 == null) goto L15;
    L16:
        if (r0 == null) goto L18;
        Function0<Unit> r3 = r0.c;
    L19:
        r();
        if (this.y == true) goto L31;
        this.y = true;
        if (r2 == null) goto L25;
        r2.invoke(r1);
    L25:
        if (r3 == null) goto L29;
        r3.invoke();
        return;
    L29:
        return;
    L31:
        return;
    L18:
        r3 = null;
    L15:
        r2 = this.c;
    L11:
        r1 = DbxPanelDismissReason.PROGRAMMATIC;
        goto L12
    }

    @Override // android.app.Dialog
    public final void show() {
        h();
        if (isShowing() == false) goto L10;
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L21;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L21:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L8:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        return;
    L10:
        if (this.h != PresentationState.IDLE) goto L27;
        this.v = true;
        this.w = null;
        this.y = false;
        this.A = false;
        this.h = PresentationState.PREPARING;
        this.a.b(this.e);
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L23;
        DialogLancet.handleBlockedDialogShow(this);
    L17:
        k();
        this.e.post(new n(this));
        return;
    L23:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L16:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L17
    }

    public final void v() {
        if (isShowing() == false) goto L19;
        PresentationState r0 = this.h;
        PresentationState r1 = PresentationState.PREPARING;
        if (r0 == r1) goto L8;
        return;
    L8:
        if (w(false) == true) goto L11;
        return;
    L11:
        if (this.h != r1) goto L21;
        this.h = PresentationState.PRESENTING;
        this.g.setInteractionEnabled(false);
        this.g.setScrollInteractionBlocked(true);
        float r6 = o(this.b);
        f(r6, m(), 0.0f);
        this.g.setVisibility(0);
        AnimationKind r3 = AnimationKind.PRESENTATION;
        if (this.v == false) goto L16;
        long r2 = 300;
    L17:
        t(r3, r2, r6, 0.0f, 1.0f, new DecelerateInterpolator(), new h(this));
        return;
    L16:
        r2 = 0;
        goto L17
    L21:
        return;
    }

    public static void e(Dialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        super.dismiss();     // Catch: Exception -> L11 Throwable -> L17
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // com.larus.common_ui.dbx.component.DbxPanelDragLayout.a
    public final float a(float r7) {
        float r2 = 0.0f;
        if (this.h == PresentationState.DRAGGING) goto L5;
        return 0.0f;
    L5:
        float r0 = this.u;
        float r8 = r7 + r0;
        float r1 = n();
        float r3 = ((Number) this.l.getSecond()).intValue();
        if (this.a.t == true) goto L8;
    L13:
        r1 = this.r;
        float r9 = RangesKt.coerceAtLeast(this.s + r8, 0.0f);
        float r4 = r9 - this.s;
    L14:
        this.u = r4;
        if (this.J <= 0.0f) goto L18;
        r2 = RangesKt.coerceIn(1.0f - (RangesKt.coerceAtLeast(r9, 0.0f) / this.J), 0.0f, 1.0f);
    L18:
        f(r1, r9, r2);
        return r4 - r0;
    L8:
        if (r3 <= r1) goto L13;
        float r5 = this.r - r8;
        if (r5 < r1) goto L12;
        r1 = RangesKt.coerceIn(r5, r1, r3);
        r9 = this.s;
        r4 = this.r - r1;
        goto L14
    L12:
        r9 = RangesKt.coerceAtLeast((this.s + r1) - r5, 0.0f);
        r4 = ((this.r - r1) + r9) - this.s;
        goto L14
    }

    @Override // com.larus.common_ui.dbx.component.DbxPanelDragLayout.a
    public final boolean b(float r3) {
        if (this.h == PresentationState.STABLE) goto L5;
    L9:
        return false;
    L5:
        if (this.a.t == false) goto L7;
    L8:
        return true;
    L7:
        if (r3 <= 0.0f) goto L9;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Function1<Boolean, Unit> g(boolean r3) {
        if (r3 == true) goto L5;
    L7:
        Function1 r4 = null;
    L8:
        this.F = null;
        this.C++;
        ValueAnimator r1 = this.D;
        this.D = null;
        this.E = null;
        if (r1 == null) goto L11;
        r1.removeAllUpdateListeners();
    L11:
        if (r1 == null) goto L13;
        r1.removeAllListeners();
    L13:
        if (r1 == null) goto L15;
        r1.cancel();
    L15:
        return r4;
    L5:
        if (this.E != AnimationKind.SETTLEMENT) goto L7;
        r4 = this.F;
        goto L8
    }

    public final float o(DbxPanelDetent r2) {
        int r3 = b.c[r2.ordinal()];
        if (r3 == 1) goto L10;
        if (r3 != 2) goto L8;
        return ((Number) this.l.getSecond()).intValue();
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return n();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        setContentView(this.e, new ViewGroup.LayoutParams(-1, -1));
        this.a.b(this.e);
        k();
    }

    public final void p(boolean r4) {
        h();
        PresentationState r0 = this.h;
        switch(b.b[r0.ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L14;
            case 4: goto L7;
            case 5: goto L14;
            case 6: goto L14;
            case 7: goto L23;
            default: goto L5;
        };
    L14:
        boolean r1 = true;
        this.p = true;
        if (this.q == false) goto L18;
        if (r4 == false) goto L18;
    L19:
        this.q = r1;
        return;
    L18:
        r1 = false;
        goto L19
    L21:
        q();
        return;
    L23:
        return;
    L5:
        throw new NoWhenBranchMatchedException();
    L7:
        if (q() == true) goto L9;
        return;
    L9:
        float r2 = o(this.b);
        if (Math.abs(r2 - this.n) > 0.5f) goto L12;
        return;
    L12:
        u(this, this.b, r2, r4);
    }

    public final boolean w(boolean r11) {
        int r0 = this.e.getWidth();
        int r1 = this.e.getHeight();
        if (r0 <= 0) goto L38;
        if (r1 <= 0) goto L38;
        if (this.m == true) goto L9;
    L13:
        boolean r3 = false;
    L14:
        Pair<Integer, Integer> r4 = this.l;
        this.j = r0;
        this.k = r1;
        Rect r2 = v.x;
        Pair<Integer, Integer> r5 = v.a.a(r1, this.i);
        this.l = r5;
        boolean r6 = !Intrinsics.areEqual(r4, r5);
        this.m = true;
        this.a.d(true);
        boolean r7 = q();
        if (r11 == false) goto L35;
        if (r3 == true) goto L21;
        if (r6 == true) goto L21;
        if (r7 == false) goto L35;
    L21:
        switch(b.b[this.h.ordinal()]) {
            case 1: goto L32;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L26;
            case 6: goto L25;
            case 7: goto L24;
            default: goto L23;
        };
    L24:
        g(false);
        s();
    L33:
        return true;
    L25:
        DbxPanelDetent r8 = this.b;
        u(this, r8, o(r8), true);
        goto L33
    L26:
        DbxPanelDragLayout r9 = this.g;
        if (r9.u == false) goto L29;
        r9.d(0.0f, true);
    L29:
        r9.m = false;
        r9.y = null;
        goto L33
    L30:
        f(o(this.b), 0.0f, 1.0f);
        goto L33
    L31:
        g(false);
        t(AnimationKind.PRESENTATION, 300, o(this.b), 0.0f, 1.0f, new DecelerateInterpolator(), new i(this));
        goto L33
    L32:
        f(o(this.b), this.g.getTranslationY(), this.f.getAlpha());
        goto L33
    L23:
        throw new NoWhenBranchMatchedException();
    L35:
        if (this.n > 0.0f) goto L37;
        f(o(this.b), this.g.getTranslationY(), this.f.getAlpha());
    L37:
        return true;
    L9:
        if (r0 == this.j) goto L11;
    L12:
        r3 = true;
        goto L14
    L11:
        if (r1 == this.k) goto L13;
    L38:
        return false;
    }

    public static void l(DbxPanelPresentationDialog r7, DbxPanelDismissReason r8, int r9) {
        if ((r9 & 1) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r9 & 2) == 0) goto L9;
        r8 = DbxPanelDismissReason.PROGRAMMATIC;
    L9:
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "reason");
        h();
        if (r0 == true) goto L12;
    L14:
        boolean r10 = false;
    L15:
        PresentationState r1 = r7.h;
        if (r1 == PresentationState.IDLE) goto L43;
        PresentationState r3 = PresentationState.CLOSING;
        if (r1 != r3) goto L22;
        if (r10 == true) goto L39;
        r7.g(false);
        r7.f(r7.n, r7.m(), 0.0f);
        r7.i();
        return;
    L39:
        return;
    L22:
        r7.x = new a(r8, r7.c, null);
        r7.h = r3;
        r7.g.setInteractionEnabled(false);
        r7.g.setScrollInteractionBlocked(true);
        DbxPanelDragLayout r11 = r7.g;
        if (r11.u == false) goto L25;
        r11.d(0.0f, true);
    L25:
        r11.m = false;
        r11.y = null;
        r7.w = null;
        Function1<Boolean, Unit> r12 = r7.g(true);
        if (r7.isShowing() == true) goto L28;
    L34:
        r7.f(r7.n, r7.m(), 0.0f);
        if (r12 == null) goto L37;
        r12.invoke(Boolean.FALSE);
    L37:
        r7.i();
        return;
    L28:
        if (r7.e.getHeight() <= 0) goto L34;
        if (r10 == false) goto L34;
        r7.s();
        if (r12 == null) goto L41;
        r12.invoke(Boolean.FALSE);
        return;
    L41:
        return;
    L43:
        return;
    L12:
        if (r7.A == true) goto L14;
        r10 = true;
        goto L15
    L5:
        r0 = false;
        goto L7
    }

    @Override // com.larus.common_ui.dbx.component.DbxPanelDragLayout.a
    public final boolean d(float r10, float r11, boolean r12) {
        if (this.h == PresentationState.DRAGGING) goto L5;
        return false;
    L5:
        this.g.setInteractionEnabled(false);
        int r0 = f.a;
        float r1 = RangesKt.coerceAtLeast(this.g.getTranslationY(), 0.0f);
        float r2 = this.n;
        float r3 = n();
        float r4 = ((Number) this.l.getSecond()).intValue();
        boolean r5 = this.a.t;
        float r6 = this.H;
        float r7 = this.I;
        float r8 = this.K;
        if (r12 == false) goto L8;
    L33:
        DbxPanelDragEndAction r13 = DbxPanelDragEndAction.RESTORE;
    L34:
        this.h = PresentationState.STABLE;
        int r14 = b.a[r13.ordinal()];
        if (r14 != 1) goto L37;
        DbxPanelDetent r15 = this.t;
        u(this, r15, o(r15), true);
    L48:
        PresentationState r16 = this.h;
        if (r16 != PresentationState.SETTLING) goto L51;
    L52:
        return true;
    L51:
        if (r16 == PresentationState.CLOSING) goto L52;
        return false;
    L37:
        if (r14 != 2) goto L39;
        DbxPanelDetent r17 = DbxPanelDetent.MINIMUM;
        u(this, r17, o(r17), true);
        goto L48
    L39:
        if (r14 != 3) goto L41;
        DbxPanelDetent r18 = DbxPanelDetent.MAXIMUM;
        u(this, r18, o(r18), true);
        goto L48
    L41:
        if (r14 != 4) goto L44;
        l(this, DbxPanelDismissReason.DRAG_DOWN, 5);
        goto L48
    L44:
        throw new NoWhenBranchMatchedException();
    L8:
        if (Math.abs(r10) <= r8) goto L33;
        if (r1 > r8) goto L13;
        if (r5 == true) goto L24;
        r13 = DbxPanelDragEndAction.RESTORE;
        goto L34
    L24:
        if (r11 >= (-r6)) goto L27;
        r13 = DbxPanelDragEndAction.MAXIMUM;
        goto L34
    L27:
        if (r11 <= r6) goto L30;
        r13 = DbxPanelDragEndAction.MINIMUM;
        goto L34
    L30:
        if (r2 < ((r3 + r4) / 2.0f)) goto L32;
        r13 = DbxPanelDragEndAction.MAXIMUM;
        goto L34
    L32:
        r13 = DbxPanelDragEndAction.MINIMUM;
        goto L34
    L13:
        if (r11 <= r6) goto L15;
    L20:
        r13 = DbxPanelDragEndAction.DISMISS;
        goto L34
    L15:
        if (r1 > r7) goto L20;
        if (r5 == false) goto L19;
        r13 = DbxPanelDragEndAction.MINIMUM;
        goto L34
    L19:
        r13 = DbxPanelDragEndAction.RESTORE;
        goto L34
    }

    public final void f(float r4, float r5, float r6) {
        if (this.m == false) goto L5;
        float r7 = RangesKt.coerceIn(r4, n(), ((Number) this.l.getSecond()).intValue());
    L6:
        this.n = r7;
        ViewGroup.LayoutParams r0 = this.g.getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == false) goto L9;
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
    L10:
        int r8 = RangesKt.coerceAtLeast(MathKt.roundToInt(r7), 1);
        if (r1 != null) goto L13;
    L15:
        this.g.setTranslationY(RangesKt.coerceAtLeast(r5, 0.0f));
        this.f.setAlpha(RangesKt.coerceIn(r6, 0.0f, 1.0f));
        return;
    L13:
        if (r1.height == r8) goto L15;
        r1.height = r8;
        this.g.setLayoutParams(r1);
        goto L15
    L9:
        r1 = null;
        goto L10
    L5:
        r7 = RangesKt.coerceAtLeast(r4, 1.0f);
        goto L6
    }

    /* JADX WARN: Type inference failed for: r10v2, types: [com.larus.common_ui.dbx.component.k] */
    public DbxPanelPresentationDialog(FragmentActivity r8, v r9, DbxPanelDetent r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "panelView");
        Intrinsics.checkNotNullParameter(r10, "initialDetent");
        super(r8, R.style.Theme.Translucent.NoTitleBar);
        this.a = r9;
        this.b = r10;
        this.d = r11;
        FrameLayout r0 = new FrameLayout(r8);
        this.e = r0;
        View r1 = new View(r8);
        this.f = r1;
        CharSequence r3 = null;
        DbxPanelDragLayout r2 = new DbxPanelDragLayout(r8, null, 6, 0);
        this.g = r2;
        this.h = PresentationState.IDLE;
        this.l = TuplesKt.to(0, 0);
        int r4 = 1;
        this.q = true;
        this.t = r10;
        this.v = true;
        this.B = new Handler(Looper.getMainLooper());
        this.G = new k(this);
        Resources r12 = r8.getResources();
        float r13 = WindowDisplayMetricsOverride.apply(r12, r12.getDisplayMetrics()).density;
        this.H = 240.0f * r13;
        this.I = 120.0f * r13;
        this.J = 320.0f * r13;
        this.K = r13 * 0.5f;
        if (r9.getParent() != null) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L17;
        r0.setBackgroundColor(0);
        r1.setBackgroundColor(com.larus.common_ui.dbx.theme.a.b(r1.getContext(), 2130971019));
        r1.setAlpha(0.0f);
        r1.setClickable(true);
        r1.setOnClickListener(new q(this));
        r0.addView(r1, new FrameLayout.LayoutParams(-1, -1));
        r2.setDelegate(this);
        r2.setVisibility(4);
        r2.addView(r9, new FrameLayout.LayoutParams(-1, -1));
        r0.addView(r2, new FrameLayout.LayoutParams(-1, 1, 80));
        r0.addOnLayoutChangeListener(new r(this));
        ViewCompat.setOnApplyWindowInsetsListener(r0, new s(this));
        r1.setFocusable(r11);
        if (r11 == false) goto L10;
        r3 = r9.getCloseAccessibilityLabel();
    L10:
        r1.setContentDescription(r3);
        if (r11 == true) goto L14;
        r4 = 2;
    L14:
        ViewCompat.setImportantForAccessibility(r1, r4);
        r9.setOnCloseRequestListener$common_ui_mainlandRelease(new l(this));
        return;
    L17:
        throw new IllegalArgumentException("DbxPanelView 已被其他容器持有".toString());
    L5:
        r14 = false;
        goto L6
    }

    public static void u(final DbxPanelPresentationDialog r11, DbxPanelDetent r12, float r13, boolean r14) {
        PresentationState r0 = r11.h;
        if (r0 != PresentationState.CLOSING) goto L5;
        return;
    L5:
        if (r0 == PresentationState.IDLE) goto L21;
        Function1<Boolean, Unit> r1 = r11.g(true);
        r11.b = r12;
        r11.h = PresentationState.SETTLING;
        r11.g.setInteractionEnabled(false);
        r11.g.setScrollInteractionBlocked(true);
        r11.F = null;
        AnimationKind r3 = AnimationKind.SETTLEMENT;
        if (r14 == false) goto L10;
        long r4 = 300;
    L12:
        if (r11.J > 0.0f) goto L14;
        float r8 = 0.0f;
    L15:
        r11.t(r3, r4, r13, 0.0f, r8, new PathInterpolator(0.2f, 0.0f, 0.0f, 1.0f), new o(r11));
        if (r1 == null) goto L20;
        r1.invoke(Boolean.FALSE);
        return;
    L20:
        return;
    L14:
        r8 = RangesKt.coerceIn(1.0f - (RangesKt.coerceAtLeast(0.0f, 0.0f) / r11.J), 0.0f, 1.0f);
        goto L15
    L10:
        r4 = 0;
        goto L12
    }

    public final void t(AnimationKind r17, long r18, final float r20, final float r21, final float r22, TimeInterpolator r23, Function0<Unit> r24) {
        final float r3 = this.n;
        final float r5 = this.g.getTranslationY();
        final float r7 = this.f.getAlpha();
        if (r18 > 0) goto L5;
    L13:
        f(r20, r21, r22);
        this.E = null;
        r24.invoke();
        return;
    L5:
        if (Math.abs(r3 - r20) <= 0.5f) goto L7;
    L11:
        final int r13 = this.C + 1;
        this.C = r13;
        ValueAnimator r14 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r14.setDuration(r18);
        r14.setInterpolator(r23);
        r14.addUpdateListener(new p(this, r13, r3, r20, r5, r21, r7, r22));
        r14.addListener(new c(this, r13, r20, r21, r22, r24));
        this.D = r14;
        this.E = r17;
        r14.start();
        return;
    L7:
        if (Math.abs(r5 - r21) > 0.5f) goto L11;
        if (Math.abs(r7 - r22) > 0.001f) goto L11;
        goto L11
    }
}
