package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.os.Build;
import android.os.SystemClock;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmAINotePanelAnimator {
    public static final /* synthetic */ int Q = 0;
    public float A;
    public boolean B;
    public float C;
    public Float D;
    public float E;
    public VelocityTracker F;
    public long G;
    public boolean H;
    public boolean I;
    public MmAINoteSheetState J;
    public boolean K;
    public boolean L;
    public long M;
    public Interpolator N;
    public k O;
    public final Map<TextView, Runnable> P;
    public final mwb.b a;
    public final Function0<Integer> b;
    public final Function0<Unit> c;
    public final Function0<Unit> d;
    public final Function1<Boolean, Unit> e;
    public final FrameLayout f;
    public final FrameLayout g;
    public final View h;
    public final View i;
    public final ViewGroup j;
    public final DecelerateInterpolator k;
    public final float l;
    public final int m;
    public final float n;
    public MmAINoteSheetState o;
    public FullStateSource p;
    public ValueAnimator q;
    public ValueAnimator r;
    public ValueAnimator s;
    public int t;
    public int u;
    public MmAINoteSheetState v;
    public int w;
    public boolean x;
    public boolean y;
    public int z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINotePanelAnimator$FullStateSource;", "", "<init>", "(Ljava/lang/String;I)V", "INITIAL_SHOW", "KEYBOARD_PROMOTED", "MANUAL_GESTURE", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum FullStateSource extends Enum<FullStateSource> {
        public static final FullStateSource INITIAL_SHOW = null;
        public static final FullStateSource KEYBOARD_PROMOTED = null;
        public static final FullStateSource MANUAL_GESTURE = null;
        public static final /* synthetic */ FullStateSource[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<FullStateSource> getEntries() {
            return b;
        }

        static {
            FullStateSource r0 = new FullStateSource("INITIAL_SHOW", 0);
            INITIAL_SHOW = r0;
            FullStateSource r1 = new FullStateSource("KEYBOARD_PROMOTED", 1);
            KEYBOARD_PROMOTED = r1;
            FullStateSource r3 = new FullStateSource("MANUAL_GESTURE", 2);
            MANUAL_GESTURE = r3;
            FullStateSource[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static FullStateSource[] values() {
            return (FullStateSource[]) a.clone();
        }

        public static FullStateSource valueOf(String r1) {
            return (FullStateSource) r27.a.a(FullStateSource.class, r1);
        }

        public FullStateSource(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ MmAINotePanelAnimator a;

        public a(MmAINotePanelAnimator r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.c.invoke();
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ MmAINotePanelAnimator a;

        public b(MmAINotePanelAnimator r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.c.invoke();
        }
    }

    public static final class c implements View.OnLayoutChangeListener {
        public final /* synthetic */ MmAINotePanelAnimator a;

        public c(MmAINotePanelAnimator r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            if ((r4 - r2) == (r8 - r6)) goto L5;
        L8:
            boolean r10 = true;
        L9:
            if (r10 == false) goto L40;
            MmAINotePanelAnimator r11 = this.a;
            if (r11.f.isAttachedToWindow() == true) goto L13;
            return;
        L13:
            if (r11.K == false) goto L15;
            return;
        L15:
            if (r11.x == false) goto L43;
            WindowInsetsCompat r12 = ViewCompat.getRootWindowInsets(r11.f);
            if (r12 == null) goto L22;
            r11.t = r12.getInsets(WindowInsetsCompat.Type.statusBars()).top;
        L22:
            if (r11.o != MmAINoteSheetState.CLOSED) goto L24;
            MmAINoteSheetState r13 = null;
        L31:
            if (r13 != null) goto L34;
            return;
        L34:
            if (r11.o == r13) goto L38;
            r11.o = r13;
            if (r13 != MmAINoteSheetState.HALF) goto L38;
            r11.p = null;
        L38:
            r11.h(r11.a(r13));
            return;
        L24:
            r13 = r11.J;
            if (r13 != null) goto L31;
            if (r11.w() == false) goto L30;
            r13 = MmAINoteSheetState.FULL;
            goto L31
        L30:
            r13 = MmAINoteSheetState.HALF;
            goto L31
        L43:
            return;
        L40:
            return;
        L5:
            if ((r5 - r3) != (r9 - r7)) goto L8;
            r10 = false;
            goto L9
        }
    }

    public static final class d {
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[MmAINoteHint.values().length];
            r0[MmAINoteHint.SUBTITLE_MISSING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            r0[MmAINoteHint.MARK_THROTTLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L6:
            a = r0;
            int[] r1 = new int[MmAINoteSheetState.values().length];
            r1[MmAINoteSheetState.FULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L39:
            r1[MmAINoteSheetState.HALF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L33:
            r1[MmAINoteSheetState.CLOSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L11:
            b = r1;
            int[] r2 = new int[FullStateSource.values().length];
            r2[FullStateSource.MANUAL_GESTURE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L35:
            r2[FullStateSource.INITIAL_SHOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L25:
            r2[FullStateSource.KEYBOARD_PROMOTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L15:
            c = r2;
        }
    }

    public static final class f implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ MmAINotePanelAnimator a;
        public final /* synthetic */ float b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;
        public final /* synthetic */ float e;

        public f(MmAINotePanelAnimator r1, float r2, float r3, float r4, float r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            Object r5 = r4.getAnimatedValue();
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Float");
            float r6 = ((Float) r5).floatValue();
            MmAINotePanelAnimator r0 = this.a;
            float r1 = this.b;
            r0.D = Float.valueOf(r1 + ((this.c - r1) * r6));
            MmAINotePanelAnimator r2 = this.a;
            float r3 = this.d;
            r2.E = r3 + ((this.e - r3) * r6);
            r2.e();
        }
    }

    public static final class g extends AnimatorListenerAdapter {
        public boolean a;
        public final /* synthetic */ MmAINotePanelAnimator b;
        public final /* synthetic */ Function0<Unit> c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a = true;
            this.b.r = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            MmAINotePanelAnimator r3 = this.b;
            r3.r = null;
            if (this.a == false) goto L5;
            return;
        L5:
            r3.j();
            this.c.invoke();
        }

        public g(MmAINotePanelAnimator r1, Function0<Unit> r2) {
            this.b = r1;
            this.c = r2;
        }
    }

    public static final class h implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ MmAINotePanelAnimator a;

        public h(MmAINotePanelAnimator r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            MmAINotePanelAnimator r0 = this.a;
            Object r4 = r3.getAnimatedValue();
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");
            r0.h(((Integer) r4).intValue());
        }
    }

    public static final class i extends AnimatorListenerAdapter {
        public final /* synthetic */ MmAINotePanelAnimator a;
        public final /* synthetic */ MmAINoteSheetState b;
        public final /* synthetic */ FullStateSource c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Function0<Unit> e;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            MmAINotePanelAnimator r0 = this.a;
            if (r0.q == r3) goto L5;
            return;
        L5:
            r0.q = null;
            r0.o = this.b;
            r0.p = this.c;
            r0.h(this.d);
            this.a.j();
            MmAINotePanelAnimator r4 = this.a;
            MmAINoteSheetState r1 = this.b;
            r4.getClass();
            if (r1 == MmAINoteSheetState.HALF) goto L8;
        L10:
            Function0<Unit> r5 = this.e;
            if (r5 == null) goto L14;
            r5.invoke();
            return;
        L14:
            return;
        L8:
            if (r4.I == false) goto L10;
            r4.I = false;
            r4.H = false;
            r4.F(0);
            goto L10
        }

        public i(MmAINotePanelAnimator r1, MmAINoteSheetState r2, FullStateSource r3, int r4, Function0<Unit> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class j implements Runnable {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ MmAINotePanelAnimator b;

        public j(TextView r1, MmAINotePanelAnimator r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.setVisibility(8);     // Catch: Throwable -> L4
            this.b.P.remove(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void j() {
        this.C = 0.0f;
        this.D = null;
        this.E = 0.0f;
    }

    public final float A() {
        Float r0 = this.D;
        if (r0 != null) goto L5;
        MmAINoteSheetState r1 = this.o;
        int r2 = e.b[r1.ordinal()];
        if (r2 != 1) goto L9;
        return 1.0f;
    L9:
        if (r2 != 2) goto L11;
    L15:
        return 0.0f;
    L11:
        if (r2 == 3) goto L15;
        throw new NoWhenBranchMatchedException();
    L5:
        return r0.floatValue();
    }

    public final MmAINoteSheetState C() {
        FullStateSource r0 = this.p;
        if (r0 != null) goto L5;
        int r1 = -1;
    L6:
        if (r1 != (-1)) goto L8;
        MmAINoteSheetState r2 = this.v;
        if (r2 == null) goto L24;
        return r2;
    L24:
        return this.o;
    L8:
        if (r1 == 1) goto L27;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L17;
        throw new NoWhenBranchMatchedException();
    L17:
        if (w() == false) goto L26;
        return MmAINoteSheetState.FULL;
    L26:
        return MmAINoteSheetState.HALF;
    L27:
        return MmAINoteSheetState.FULL;
    L5:
        r1 = e.c[r0.ordinal()];
        goto L6
    }

    public final void e() {
        Float r0 = this.D;
        if (r0 == null) goto L5;
        float r1 = r0.floatValue();
    L6:
        g(MathKt.roundToInt(l() + ((q() - l()) * RangesKt.coerceIn(r1, 0.0f, 1.0f))), this.E);
        return;
    L5:
        r1 = A();
        goto L6
    }

    public final void i() {
        if (this.K == false) goto L5;
        return;
    L5:
        if (this.o == MmAINoteSheetState.CLOSED) goto L16;
        ValueAnimator r0 = this.q;
        if (r0 == null) goto L10;
        r0.cancel();
    L10:
        ValueAnimator r1 = this.r;
        if (r1 == null) goto L13;
        r1.cancel();
    L13:
        this.y = true;
        this.z = m();
        float r2 = A();
        this.C = r2;
        this.D = Float.valueOf(r2);
        this.E = 0.0f;
        return;
    }

    public final int l() {
        float r0 = this.f.getHeight();
        Resources r1 = this.f.getResources();
        Float r2 = Float.valueOf(WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density);
        if (r2.floatValue() <= 0.0f) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L9;
        r2 = null;
    L9:
        if (r2 == null) goto L11;
        float r4 = r2.floatValue();
    L13:
        if ((this.f.getWidth() / r4) < 840.0f) goto L15;
        float r5 = 0.56f;
    L17:
        return RangesKt.coerceIn(MathKt.roundToInt(r0 * r5), 0, q());
    L15:
        r5 = 0.65f;
        goto L17
    L11:
        r4 = 1.0f;
        goto L13
    L5:
        r3 = false;
        goto L6
    }

    public final int m() {
        return RangesKt.coerceAtLeast(this.f.getHeight() - n(), 0);
    }

    public final int n() {
        ViewGroup.LayoutParams r0 = this.g.getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == false) goto L5;
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
    L6:
        if (r1 == null) goto L8;
        int r2 = r1.height;
    L9:
        if (r2 <= 0) goto L12;
        return r2;
    L12:
        return this.g.getHeight();
    L8:
        r2 = 0;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public final int q() {
        return RangesKt.coerceAtLeast(this.f.getHeight() - s(), 0);
    }

    public final int s() {
        return RangesKt.coerceIn(this.t, 0, this.f.getHeight());
    }

    public final int t() {
        return RangesKt.coerceAtLeast(this.f.getHeight() - l(), s());
    }

    public final void v() {
        if (this.K == false) goto L5;
        return;
    L5:
        o("dismiss");
        this.K = true;
        View r0 = this.a.f.findFocus();
        if (r0 == null) goto L8;
        r0.clearFocus();
    L8:
        this.a.f.clearFocus();
        View r1 = this.a.f.findFocus();
        if (r1 == null) goto L11;
        r1.clearFocus();
    L11:
        this.a.f.clearFocus();
        u(this.f);
        c(this.f.getHeight(), 240, MmAINoteSheetState.CLOSED, null, "hide", new MmAINotePanelAnimator$hideSheet$1(this));
    }

    public final boolean w() {
        int r0 = ((Number) this.b.invoke()).intValue();
        View r1 = this.h;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        View r3 = this.a.q;
        if (r3 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r2 + r4) + y9c.d.a(34);
        if (r0 <= RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(l(), 0) - r5, 0)) goto L14;
        return true;
    L14:
        return false;
    L9:
        r4 = Math.max(r3.getMeasuredHeight(), r3.getHeight());
        goto L10
    L5:
        r2 = Math.max(r1.getMeasuredHeight(), r1.getHeight());
        goto L6
    }

    public final MmAINoteSheetState B(int r3) {
        if (Math.abs(r3 - s()) > Math.abs(r3 - t())) goto L6;
        return MmAINoteSheetState.FULL;
    L6:
        return MmAINoteSheetState.HALF;
    }

    public final void E(TextView r4) {
        Runnable r0 = this.P.remove(r4);
        if (r0 == null) goto L5;
        r4.removeCallbacks(r0);
    L5:
        r4.setVisibility(0);
        r4.bringToFront();
        j r1 = new j(r4, this);
        this.P.put(r4, r1);
        r4.postDelayed(r1, 2000);
    }

    public final void F(int r3) {
        if (this.H == false) goto L5;
        return;
    L5:
        int r0 = y9c.d.a(34);
        if (r3 <= 0) goto L8;
        r0 = Math.max(r0, r3);
    L8:
        ViewGroup.LayoutParams r4 = this.a.q.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
    L12:
        if (r5 != null) goto L14;
    L16:
        boolean r1 = false;
    L17:
        if (r1 == false) goto L19;
        return;
    L19:
        if (r5 == null) goto L21;
        r5.bottomMargin = r0;
        this.a.q.setLayoutParams(r5);
    L21:
        this.a.q.requestLayout();
        this.j.requestLayout();
        return;
    L14:
        if (r5.bottomMargin != r0) goto L16;
        r1 = true;
        goto L17
    L11:
        r5 = null;
        goto L12
    }

    public final void G(float r8) {
        if (this.y == true) goto L5;
        return;
    L5:
        float r0 = RangesKt.coerceAtLeast(q() - l(), 1.0f);
        if (r0 > 0.0f) goto L8;
        return;
    L8:
        int r3 = this.z + MathKt.roundToInt(r8);
        int r4 = s();
        int r5 = this.f.getHeight();
        if (r3 >= r4) goto L15;
        int r6 = r4 - r3;
        int r7 = this.m;
        if (r6 <= r7) goto L14;
        r6 = MathKt.roundToInt((r6 - r7) * 0.35f) + r7;
    L14:
        r3 = r4 - r6;
    L22:
        if (r8 <= 0.0f) goto L32;
        float r9 = RangesKt.coerceAtLeast(r8 - (this.C * r0), 0.0f);
        if (r3 <= this.f.getHeight()) goto L26;
        float r10 = r3 - this.f.getHeight();
    L27:
        this.E = r10;
        if (r9 <= 0.0f) goto L30;
        Float r11 = Float.valueOf(0.0f);
    L31:
        this.D = r11;
    L33:
        e();
        return;
    L30:
        r11 = Float.valueOf(RangesKt.coerceIn(this.C - (r8 / r0), 0.0f, 1.0f));
        goto L31
    L26:
        r10 = r9;
        goto L27
    L32:
        this.E = 0.0f;
        this.D = Float.valueOf(RangesKt.coerceIn(this.C + ((-r8) / r0), 0.0f, 1.0f));
        goto L33
    L15:
        if (r3 <= r5) goto L22;
        int r12 = r3 - r5;
        int r13 = this.m;
        if (r12 <= r13) goto L20;
        r12 = MathKt.roundToInt((r12 - r13) * 0.35f) + r13;
    L20:
        r3 = r12 + r5;
        goto L22
    }

    public final int a(MmAINoteSheetState r2) {
        int r3 = e.b[r2.ordinal()];
        if (r3 == 1) goto L13;
        if (r3 == 2) goto L15;
        if (r3 != 3) goto L10;
        return this.f.getHeight();
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return t();
    L13:
        return s();
    }

    public final void h(int r3) {
        int r4 = RangesKt.coerceIn(r3, s(), this.f.getHeight());
        g(RangesKt.coerceAtLeast(this.f.getHeight() - r4, 0), this.g.getTranslationY());
    }

    public final void k(String r9) {
        if (this.K == false) goto L5;
        return;
    L5:
        if (this.f.getHeight() <= 0) goto L10;
        this.p = null;
        d(this, t(), 220, MmAINoteSheetState.HALF, null, r9);
        return;
    }

    public final void o(String r11) {
        if (this.f.isAttachedToWindow() == true) goto L5;
        return;
    L5:
        if (this.f.isInTouchMode() == false) goto L17;
        return;
    L17:
        ViewParent r4 = this.f.getRootView().getParent();     // Catch: Throwable -> L14
        if (r4 != null) goto L12;
        int r2 = bwb.b.a;     // Catch: Throwable -> L14
        bwb.b.h(MmUiLogScene.AI_NOTE, "MmAINotePanelAnimator", "[enterTouchModeFromAINote] ViewRoot is unavailable reason=".concat(r11), null);     // Catch: Throwable -> L14
        return;
    L12:
        Method r1 = r4.getClass().getDeclaredMethod("ensureTouchMode", new Class[]{Boolean.TYPE});     // Catch: Throwable -> L14
        r1.setAccessible(true);     // Catch: Throwable -> L14
        Object r3 = r1.invoke(r4, new Object[]{Boolean.TRUE});     // Catch: Throwable -> L14
        int r5 = bwb.b.a;     // Catch: Throwable -> L14
        bwb.b.g(MmUiLogScene.AI_NOTE, "MmAINotePanelAnimator", "[enterTouchModeFromAINote] changed=" + r3 + " inTouchMode=" + this.f.isInTouchMode() + " reason=" + r11, null, 8);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        int r6 = bwb.b.a;
        bwb.b.d(MmUiLogScene.AI_NOTE, "MmAINotePanelAnimator", "[enterTouchModeFromAINote] failed reason=" + r11 + " error=" + th.getClass().getSimpleName() + ':' + th.getMessage(), null);
    }

    public final void r(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        ValueAnimator r0 = this.q;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        ValueAnimator r1 = this.r;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        z(r2);
    }

    public final void u(View r3) {
        InputMethodManager r0 = (InputMethodManager) this.f.getContext().getSystemService(InputMethodManager.class);
        if (r0 == null) goto L6;
        r0.hideSoftInputFromWindow(r3.getWindowToken(), 0);
        return;
    }

    public final int x(int r2) {
        return RangesKt.coerceAtLeast(r2 - this.w, 0);
    }

    public final void y(String r4) {
        if (this.u > 0) goto L5;
        return;
    L5:
        if (this.L == true) goto L10;
        this.L = true;
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "[maybeDismissImeForPanelDrag] source=".concat(r4), null, null, 12);
        u(this.f);
        return;
    }

    public final void z(String r4) {
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "[release] reason=".concat(r4), null, null, 12);
        ValueAnimator r5 = this.q;
        if (r5 == null) goto L5;
        r5.cancel();
    L5:
        ValueAnimator r6 = this.r;
        if (r6 == null) goto L8;
        r6.cancel();
    L8:
        ValueAnimator r7 = this.s;
        if (r7 == null) goto L11;
        r7.cancel();
    L11:
        VelocityTracker r8 = this.F;
        if (r8 == null) goto L14;
        r8.recycle();
    L14:
        this.F = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.o = MmAINoteSheetState.CLOSED;
        this.a.j.a();
        this.a.o.a();
        k r9 = this.O;
        if (r9 == null) goto L21;
        ViewTreeObserver r1 = this.f.getViewTreeObserver();
        if (r1 == null) goto L21;
        if (r1.isAlive() == false) goto L21;
        r1.removeOnGlobalFocusChangeListener(r9);
    L21:
        this.O = null;
        this.e.invoke(Boolean.FALSE);
        this.d.invoke();
    }

    public final void D(float r11, float r12) {
        final float r2 = this.C;
        Float r0 = this.D;
        if (r0 == null) goto L5;
        float r1 = r0.floatValue();
    L6:
        float r6 = this.E;
        float r3 = y9c.d.a(2);
        float r4 = y9c.d.a(40);
        boolean r5 = true;
        if (r2 > 0.0f) goto L9;
    L11:
        boolean r8 = false;
    L13:
        if (r11 > 0.0f) goto L15;
    L18:
        if (r8 == false) goto L26;
        if (r11 < r4) goto L22;
    L23:
        b(r1, r1, r6, this.f.getHeight(), new MmAINotePanelAnimator$settleAfterDrag$2(this));
        return;
    L22:
        if (r12 > this.n) goto L23;
    L26:
        if (r6 <= 0.0f) goto L38;
        if (r11 < r3) goto L30;
    L33:
        if (r5 == false) goto L35;
        b(r1, r1, r6, this.f.getHeight(), new MmAINotePanelAnimator$settleAfterDrag$3(this));
        return;
    L35:
        b(r1, 0.0f, r6, 0.0f, new MmAINotePanelAnimator$settleAfterDrag$4(this));
        return;
    L30:
        if (r12 > this.n) goto L33;
        r5 = false;
        goto L33
    L38:
        if (r11 <= (-r3)) goto L51;
        float r7 = this.n;
        if (r12 < (-r7)) goto L51;
        if (r11 < r3) goto L45;
    L50:
        r5 = false;
        goto L51
    L45:
        if (r12 > r7) goto L50;
        if (r1 <= r2) goto L50;
    L51:
        if (r5 == false) goto L53;
        b(r1, 1.0f, 0.0f, 0.0f, new MmAINotePanelAnimator$settleAfterDrag$5(this));
        return;
    L53:
        b(r1, 0.0f, 0.0f, 0.0f, new MmAINotePanelAnimator$settleAfterDrag$6(this));
        return;
    L15:
        if (r11 >= r4) goto L18;
        b(r1, r2, r6, 0.0f, new MmAINotePanelAnimator$settleAfterDrag$1(this, r2));
        return;
    L9:
        if (w() == false) goto L11;
        r8 = true;
        goto L13
    L5:
        r1 = r2;
        goto L6
    }

    public final void g(int r5, float r6) {
        boolean r1 = false;
        int r7 = RangesKt.coerceIn(r5, 0, q());
        ViewGroup.LayoutParams r0 = this.g.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r0;
        if (r2.height == r7) goto L5;
    L6:
        r2.height = r7;
        r2.gravity = 80;
        this.g.setLayoutParams(r2);
    L8:
        if (this.g.getTranslationY() != r6) goto L10;
        r1 = true;
    L10:
        if (r1 == true) goto L13;
        this.g.setTranslationY(r6);
    L13:
        if (r6 <= 0.0f) goto L15;
        float r8 = RangesKt.coerceIn(1.0f - (r6 / Math.max(1, this.f.getHeight())), 0.0f, 1.0f);
    L16:
        this.a.c.setAlpha((RangesKt.coerceIn(r7 / Math.max(1, l()), 0.0f, 1.0f) * 1.0f) * r8);
        return;
    L15:
        r8 = 1.0f;
        goto L16
    L5:
        if (r2.gravity == 80) goto L8;
        goto L6
    }

    public final void p(FullStateSource r9, String r10) {
        if (this.K == false) goto L5;
        return;
    L5:
        if (this.f.getHeight() <= 0) goto L10;
        this.p = r9;
        d(this, s(), 220, MmAINoteSheetState.FULL, r9, r10);
        return;
    }

    public final void f(int r8, int r9, String r10, boolean r11) {
        this.w = r9;
        if (this.K == false) goto L6;
        this.u = r8;
        return;
    L6:
        int r12 = x(r8);
        int r0 = x(this.u);
        if (SystemClock.uptimeMillis() >= this.G) goto L11;
        if (r12 != 0) goto L11;
        return;
    L11:
        if (r12 > 0) goto L13;
    L15:
        if (r12 != 0) goto L21;
        if (r0 <= 0) goto L21;
        if (this.L == true) goto L21;
        this.J = C();
    L21:
        if (r12 != 0) goto L29;
        if (r0 <= 0) goto L29;
        if (this.L == true) goto L29;
        if (this.J != MmAINoteSheetState.HALF) goto L29;
        this.H = true;
        this.I = true;
    L29:
        if (this.H == true) goto L49;
        if (r12 > 0) goto L32;
    L46:
        int r3 = r12;
    L47:
        F(r3);
        goto L49
    L32:
        if (this.w <= 0) goto L46;
        if (this.f.getHeight() <= 0) goto L42;
        Resources r4 = this.f.getResources();
        int r5 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).heightPixels;
        if (r5 <= 0) goto L42;
        int[] r6 = new int[2];
        this.f.getLocationOnScreen(r6);
        if ((r6[1] + this.f.getHeight()) < (r5 - y9c.d.a(2))) goto L42;
        boolean r7 = true;
    L43:
        if (r7 == false) goto L46;
        r3 = r8;
    L42:
        r7 = false;
    L49:
        if (r11 == false) goto L51;
        int r13 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "MmAINotePanelAnimator", "[applyKeyboardHeight] source=" + r10 + " imeBottom=" + r8 + " keyboardLift=" + r12 + " stableBottomInset=" + this.w, null, 8);
    L51:
        ValueAnimator r14 = this.q;
        if (r14 != null) goto L54;
    L56:
        boolean r15 = false;
    L58:
        if (this.f.getHeight() <= 0) goto L68;
        if (this.y == true) goto L68;
        if (r12 != 0) goto L68;
        if (r0 != 0) goto L68;
        MmAINoteSheetState r16 = this.o;
        if (r16 == MmAINoteSheetState.CLOSED) goto L68;
        if (r15 == true) goto L68;
        h(a(r16));
    L68:
        if (this.f.getHeight() != 0) goto L70;
        this.u = r8;
        return;
    L70:
        if (r8 > 0) goto L72;
    L88:
        int r17 = x(r8);
        int r18 = x(this.u);
        if (r17 <= 0) goto L97;
        if (r18 != 0) goto L97;
        MmAINoteSheetState r19 = this.o;
        this.v = r19;
        MmAINoteSheetState r1 = MmAINoteSheetState.FULL;
        if (r19 == r1) goto L97;
        this.p = FullStateSource.KEYBOARD_PROMOTED;
        ValueAnimator r110 = this.q;
        if (r110 == null) goto L96;
        r110.cancel();
    L96:
        j();
        this.o = r1;
    L97:
        if (r17 != 0) goto L116;
        if (r18 <= 0) goto L116;
        if (this.L == false) goto L102;
        this.v = null;
        this.J = null;
        this.L = false;
        this.u = r8;
        return;
    L102:
        MmAINoteSheetState r20 = this.J;
        if (r20 != null) goto L105;
        r20 = C();
    L105:
        int r21 = e.b[r20.ordinal()];
        if (r21 == 1) goto L114;
        if (r21 != 2) goto L109;
        k("ime_hide");
    L115:
        this.v = null;
        this.J = null;
        this.u = r8;
        return;
    L109:
        if (r21 == 3) goto L115;
        throw new NoWhenBranchMatchedException();
    L114:
        this.H = false;
        this.I = false;
        F(0);
        this.o = MmAINoteSheetState.FULL;
        h(s());
    L116:
        if (r17 <= 0) goto L118;
        h(Math.max(s(), a(MmAINoteSheetState.FULL) - r17));
    L118:
        this.u = r8;
        return;
    L72:
        if (this.u != 0) goto L88;
        if (this.x == false) goto L88;
        if (this.p != FullStateSource.INITIAL_SHOW) goto L88;
        if (this.g.getTranslationY() <= 0.0f) goto L88;
        if (n() != q()) goto L88;
        int r22 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "[finishInitialFullScreenOpenIfNeeded] reason=ime_started", null, null, 12);
        ValueAnimator r23 = this.q;
        if (r23 == null) goto L87;
        r23.cancel();
    L87:
        g(q(), 0.0f);
        goto L88
    L54:
        if (r14.isRunning() != true) goto L56;
        r15 = true;
        goto L58
    L13:
        if (this.H == false) goto L15;
        this.H = false;
        this.I = false;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmAINotePanelAnimator(mwb.b r5, Function0<Integer> r6, Function0<Unit> r7, Function0<Unit> r8, Function1<? super Boolean, Unit> r9) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "contentHeightProvider");
        Intrinsics.checkNotNullParameter(r7, "onCloseRequested");
        Intrinsics.checkNotNullParameter(r8, "onDismissed");
        Intrinsics.checkNotNullParameter(r9, "onVisibilityChanged");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r8;
        this.e = r9;
        FrameLayout r10 = r5.b;
        this.f = r10;
        FrameLayout r11 = r5.e;
        this.g = r11;
        View r12 = r5.g;
        this.h = r12;
        View r13 = r5.u;
        this.i = r13;
        this.j = r5.i;
        this.k = new DecelerateInterpolator();
        this.l = ViewConfiguration.get(r10.getContext()).getScaledTouchSlop();
        this.m = y9c.d.a(60);
        this.n = y9c.d.a(1200);
        this.o = MmAINoteSheetState.CLOSED;
        this.M = 285;
        this.N = new PathInterpolator(0.2f, 0.0f, 0.0f, 1.0f);
        this.P = new LinkedHashMap();
        r10.setClickable(true);
        r10.setFocusable(true);
        r10.setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT < 26) goto L5;
        r10.setDefaultFocusHighlightEnabled(false);
    L5:
        r10.setClipChildren(false);
        r10.setClipToPadding(false);
        r5.d.setClipChildren(false);
        r5.d.setClipToPadding(false);
        r11.setClipChildren(false);
        r11.setClipToPadding(false);
        r11.setClickable(true);
        r5.q.setClickable(true);
        r5.c.setOnClickListener(new a(this));
        r13.setOnClickListener(new b(this));
        r12.setClickable(true);
        r12.setOnClickListener(new l(this));
        r12.setOnTouchListener(new m(this));
        r5.h.setGestureListener(new com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.j(this));
        k r14 = new k(this);
        this.O = r14;
        r10.getViewTreeObserver().addOnGlobalFocusChangeListener(r14);
        r10.addOnLayoutChangeListener(new c(this));
    }

    public final void b(float r9, float r10, float r11, float r12, Function0<Unit> r13) {
        ValueAnimator r0 = this.r;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        float r1 = Math.abs(r10 - r9);
        float r2 = Math.abs(r12 - r11);
        if (r1 < 0.001f) goto L8;
    L11:
        this.C = r9;
        this.D = Float.valueOf(r9);
        this.E = r11;
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (r12 > r11) goto L14;
    L16:
        if (r12 <= r11) goto L18;
        long r4 = 260;
    L19:
        r3.setDuration(r4);
        r3.setInterpolator(new AccelerateDecelerateInterpolator());
        r3.addUpdateListener(new f(this, r9, r10, r11, r12));
        r3.addListener(new g(this, r13));
        r3.start();
        this.r = r3;
        return;
    L18:
        r4 = 180;
        goto L19
    L14:
        if (r9 <= 0.0f) goto L16;
        r4 = 300;
        goto L19
    L8:
        if (r2 >= 1.0f) goto L11;
        j();
        r13.invoke();
    }

    public static /* synthetic */ void d(MmAINotePanelAnimator r8, int r9, long r10, MmAINoteSheetState r12, FullStateSource r13, String r14) {
        r8.c(r9, r10, r12, r13, r14, null);
    }

    public final void c(int r7, long r8, MmAINoteSheetState r10, FullStateSource r11, String r12, Function0<Unit> r13) {
        int r0 = m();
        if (r0 != r7) goto L12;
        this.o = r10;
        this.p = r11;
        h(r7);
        j();
        if (r10 == MmAINoteSheetState.HALF) goto L7;
    L9:
        if (r13 == null) goto L20;
        r13.invoke();
        return;
    L20:
        return;
    L7:
        if (this.I == false) goto L9;
        this.I = false;
        this.H = false;
        F(0);
        goto L9
    L12:
        ValueAnimator r2 = this.q;
        if (r2 == null) goto L15;
        r2.cancel();
    L15:
        ValueAnimator r3 = this.r;
        if (r3 == null) goto L18;
        r3.cancel();
    L18:
        int r4 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "[animateSheetTo] reason=" + r12 + " from=" + r0 + " target=" + r7 + " state=" + r10, null, null, 12);
        ValueAnimator r14 = ValueAnimator.ofInt(new int[]{r0, r7});
        r14.setDuration(r8);
        r14.setInterpolator(this.k);
        r14.addUpdateListener(new h(this));
        r14.addListener(new i(this, r10, r11, r7, r13));
        r14.start();
        this.q = r14;
    }
}
