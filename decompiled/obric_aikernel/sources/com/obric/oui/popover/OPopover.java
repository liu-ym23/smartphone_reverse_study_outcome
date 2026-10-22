package com.obric.oui.popover;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.annotation.UiThread;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewGroupKt;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import o9.k;
import o9.p;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
public class OPopover extends PopupWindow {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static volatile int f7071q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static boolean f7072r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final b f7073s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OPopoverLayout f7075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ViewGroup f7076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AnimatorSet f7078e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Activity f7079f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d f7080g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private c f7081h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Animator f7082i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Animator f7083j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f7084k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f7085l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f7086m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f7087n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Runnable f7088o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final i9.c<View> f7089p;

    private static final class a {
        public a(float r10) {
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
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

    public interface c {
        void a();
    }

    public interface d {
        void a();
    }

    static final class e implements View.OnTouchListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OPopover f7090c;

        e(OPopover r10) {
            this.f7090c = r10;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r10, MotionEvent r11) {
            Intrinsics.checkNotNullExpressionValue(r11, NotificationCompat.CATEGORY_EVENT);
            if (r11.getAction() == 0) goto L5;
            return false;
        L5:
            if (da.f.f8522a.f(OPopover.b(this.f7090c), r11) == false) goto L10;
            this.f7090c.dismiss();
            return false;
        L10:
            return false;
        }
    }

    static final class f implements i9.b.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f7091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f7092b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f7093c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f7094d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f7095e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f7096f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ float f7097g;

        f(ViewGroup r10, float r11, float r12, float r13, float r14, float r15, float r16) {
            this.f7091a = r10;
            this.f7092b = r11;
            this.f7093c = r12;
            this.f7094d = r13;
            this.f7095e = r14;
            this.f7096f = r15;
            this.f7097g = r16;
        }

        @Override // i9.b.q
        public final void a(i9.b<?> r10, float r11, float r12) {
            da.c r13 = da.c.f8520a;
            Object r14 = this.f7091a.getTag(u8.f.o_popover_anim_p);
            if (r14 != null) goto L6;
        L4:
            r14 = null;
        L8:
            if (((a) r14) == null) goto L11;
            float r15 = da.b.f8519a.a(r11, this.f7092b, this.f7093c);
            float r16 = this.f7094d;
            float r17 = r16 + ((this.f7095e - r16) * r15);
            float r18 = this.f7096f;
            float r19 = r18 + ((this.f7097g - r18) * r15);
            this.f7091a.setScaleX(r17);
            this.f7091a.setScaleY(r17);
            this.f7091a.setTranslationY(r19);
            return;
        L11:
            return;
        L6:
            if ((r14 instanceof a) == false) goto L4;
            goto L4
        }
    }

    public static final class g extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OPopover f7098c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f7099g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ ViewGroup f7100h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f7101i;

        g(OPopover r10, boolean r11, ViewGroup r12, Ref.ObjectRef r13) {
            this.f7098c = r10;
            this.f7099g = r11;
            this.f7100h = r12;
            this.f7101i = r13;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            super.onAnimationCancel(r10);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            super.onAnimationEnd(r10);
            if (this.f7099g == true) goto L9;
            this.f7100h.setVisibility(8);
            c r11 = OPopover.a(this.f7098c);
            if (r11 == null) goto L7;
            r11.a();
        L7:
            this.f7098c.j();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            super.onAnimationStart(r10);
            ViewPropertySpringAnimator r11 = (ViewPropertySpringAnimator) this.f7101i.element;
            if (r11 == null) goto L6;
            r11.p();
        L6:
            if (this.f7099g == false) goto L12;
            d r12 = OPopover.c(this.f7098c);
            if (r12 == null) goto L10;
            r12.a();
        L10:
            this.f7100h.setVisibility(0);
            return;
        }
    }

    static {
        f7073s = new b(null);
    }

    public static final /* synthetic */ c a(OPopover r10) {
        return r10.f7081h;
    }

    public static final /* synthetic */ OPopoverLayout b(OPopover r10) {
        OPopoverLayout r11 = r10.f7075b;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L5:
        return r11;
    }

    public static final /* synthetic */ d c(OPopover r10) {
        return r10.f7080g;
    }

    public static final /* synthetic */ void d(OPopover r10, OPopoverLayout r11) {
        r10.f7075b = r11;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final Pair<Integer, Integer> e(int r19, int r20) {
        if (this.f7085l == true) goto L14;
        ViewGroup r10 = this.f7076c;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
    L8:
        if ((r10 instanceof SingleChildFrameLayout) == false) goto L14;
        ViewGroup r11 = this.f7076c;
        if (r11 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
    L12:
        r11.setVisibility(4);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        View r12 = getContentView();
        Intrinsics.checkNotNullExpressionValue(r12, "contentView");
        Context r13 = r12.getContext();
        Intrinsics.checkNotNullExpressionValue(r13, "contentView.context");
        setWidth(com.obric.oui.common.util.f.e(r13));
        return new Pair(Integer.valueOf(r19), Integer.valueOf(this.f7086m));
    L14:
        View r14 = LayoutInflater.from(this.f7079f).inflate(h.o_layout_popover_shadow_frame, null);
        Objects.requireNonNull(r14, "null cannot be cast to non-null type com.obric.oui.popover.SingleChildFrameLayout");
        SingleChildFrameLayout r15 = (SingleChildFrameLayout) r14;
        OPopoverLayout r16 = this.f7075b;
        if (r16 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L17:
        r15.addView(r16, new FrameLayout.LayoutParams(-2, -2));
        OPopoverLayout r17 = this.f7075b;
        if (r17 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L20:
        r15.setShadowCornerRadius(MathKt.roundToInt(r17.getCornerRadius()));
        OPopoverLayout r18 = this.f7075b;
        if (r18 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L23:
        int r21 = r18.getArrowHeight();
        OPopoverLayout r110 = this.f7075b;
        if (r110 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L26:
        r15.setShadowInsets(r21, r110.getArrowHeight());
        List<p> r22 = k.v(this.f7079f, u8.k.OUIShadow_3_2_low_elevation);
        Intrinsics.checkNotNullExpressionValue(r22, "shadows");
        Iterator<T> r23 = r22.iterator();
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
        int r114 = 0;
    L28:
        if (r23.hasNext() == false) goto L42;
        p r115 = (p) r23.next();
        if ((r115.f() - r115.c()) <= r113) goto L33;
        r113 = MathKt.roundToInt(r115.f() - r115.c());
    L33:
        if ((r115.f() + r115.c()) <= r114) goto L36;
        r114 = MathKt.roundToInt(r115.f() + r115.c());
    L36:
        if ((r115.f() - r115.d()) <= r111) goto L39;
        r111 = MathKt.roundToInt(r115.f() - r115.d());
    L39:
        if ((r115.f() + r115.d()) <= r112) goto L28;
        r112 = MathKt.roundToInt(r115.f() + r115.d());
        goto L28
    L42:
        SingleChildFrameLayout r24 = new SingleChildFrameLayout(this.f7079f, null, 2, null);
        View r25 = getContentView();
        Intrinsics.checkNotNullExpressionValue(r25, "contentView");
        Context r26 = r25.getContext();
        Intrinsics.checkNotNullExpressionValue(r26, "contentView.context");
        r24.setLayoutParams(new ViewGroup.MarginLayoutParams(com.obric.oui.common.util.f.e(r26), -2));
        r24.addView(r15, new FrameLayout.LayoutParams(-2, -2));
        r24.setClipChildren(false);
        r24.setClipToPadding(false);
        r24.setPadding(0, r111, 0, r112);
        r15.setX(r19);
        r24.setOnTouchListener(new e(this));
        this.f7086m = r111;
        this.f7076c = r24;
        r24.setVisibility(4);
        ViewGroup r27 = this.f7076c;
        if (r27 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
    L45:
        setContentView(r27);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        View r28 = getContentView();
        Intrinsics.checkNotNullExpressionValue(r28, "contentView");
        Context r29 = r28.getContext();
        Intrinsics.checkNotNullExpressionValue(r29, "contentView.context");
        setWidth(com.obric.oui.common.util.f.e(r29));
        return new Pair(Integer.valueOf(r19), Integer.valueOf(r111));
    }

    private final Pair<Integer, Integer> f(int r10, int r11) {
        return e(r10, r11);
    }

    /* JADX WARN: Type inference failed for: r12v2, types: [T, com.obric.oui.animation.easy.ViewPropertySpringAnimator] */
    @UiThread
    private final void g(boolean r22) {
        ViewGroup r10 = this.f7076c;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
    L5:
        int r11 = -1;
        if (r22 == true) goto L8;
        f7071q--;
        this.f7077d = true;
    L8:
        this.f7078e = new AnimatorSet();
        int r12 = i();
        if (r12 != 3) goto L11;
        float r13 = r10.getX() + r10.getMeasuredWidth();
        float r14 = r10.getY();
        OPopoverLayout r15 = this.f7075b;
        if (r15 != null) goto L30;
    L29:
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L30:
        float r16 = r15.getBubbleOffset();
    L31:
        float r17 = r14 + r16;
    L32:
        View r18 = r10.getChildAt(0);
        if (r18 == null) goto L35;
        float r19 = r18.getX();
    L36:
        r10.setPivotY(r17);
        r10.setPivotX(r13 + r19);
        float r110 = 1.0f;
        PathInterpolator r20 = new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f);
        PathInterpolator r21 = new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f);
        if (r22 == false) goto L39;
        float r23 = 0.0f;
    L40:
        if (r22 == false) goto L42;
        float r111 = 1.0f;
    L44:
        if (r10.getAlpha() != 0.0f) goto L46;
    L48:
        ObjectAnimator r24 = ObjectAnimator.ofFloat(r10, "alpha", new float[]{r23, r111});
        if (r22 == true) goto L52;
        r20 = r21;
    L52:
        r24.setInterpolator(r20);
        if (r22 == false) goto L55;
        int r25 = 300;
    L56:
        r24.setDuration(r25);
        r10.setVisibility(0);
        Ref.ObjectRef r112 = new Ref.ObjectRef();
        r112.element = null;
        if (r22 == false) goto L63;
        Animator r26 = this.f7082i;
        if (r26 == null) goto L63;
        AnimatorSet r27 = this.f7078e;
        if (r27 == null) goto L103;
    L62:
        r27.play(r26);
    L103:
        AnimatorSet r28 = this.f7078e;
        if (r28 == null) goto L106;
        r28.addListener(new g(this, r22, r10, r112));
    L106:
        AnimatorSet r29 = this.f7078e;
        if (r29 == null) goto L110;
        r29.start();
        return;
    L110:
        return;
    L63:
        if (r22 == true) goto L69;
        r26 = this.f7083j;
        if (r26 == null) goto L69;
        r27 = this.f7078e;
        if (r27 == null) goto L103;
    L69:
        AnimatorSet r30 = this.f7078e;
        if (r30 == null) goto L73;
        r30.play(r24);
    L73:
        if (r22 == false) goto L75;
        float r31 = 0.5f;
    L76:
        if (r22 == false) goto L78;
        float r32 = 1.0f;
    L80:
        if (i() == 48) goto L83;
        r11 = 1;
    L83:
        if (r22 == false) goto L85;
        Resources r113 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r113, "Resources.getSystem()");
        float r33 = -TypedValue.applyDimension(1, 10, r113.getDisplayMetrics());
    L86:
        float r34 = r11;
        float r114 = r33 * r34;
        if (r22 == false) goto L89;
        float r35 = 0.0f;
    L90:
        float r115 = r35 * r34;
        if (r22 == false) goto L93;
        float r36 = 0.0f;
    L94:
        if (r22 == false) goto L96;
        float r37 = 10000.0f;
    L98:
        if (com.obric.oui.animation.easy.b.a(r10).k() == true) goto L100;
        r10.setScaleX(r31);
        r10.setScaleY(r31);
        r10.setTranslationY(r114);
        r10.setTag(u8.f.o_popover_anim_p, new a(r36));
    L100:
        if (r22 == false) goto L102;
        r110 = 0.8f;
    L102:
        ?? r116 = ViewPropertySpringAnimator.f(com.obric.oui.animation.easy.b.a(r10).i(r110).j(439.0f), this.f7089p, r37, null, 4, null);
        r116.o(new f(r10, r36, r37, r31, r32, r114, r115));
        Unit r38 = Unit.INSTANCE;
        r112.element = r116;
        goto L103
    L96:
        r37 = 0.0f;
        goto L98
    L93:
        r36 = 10000.0f;
        goto L94
    L89:
        Resources r39 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r39, "Resources.getSystem()");
        r35 = -TypedValue.applyDimension(1, 10, r39.getDisplayMetrics());
        goto L90
    L85:
        r33 = 0.0f;
        goto L86
    L78:
        r32 = 0.5f;
        goto L80
    L75:
        r31 = 1.0f;
        goto L76
    L55:
        r25 = 100;
        goto L56
    L46:
        if (r10.getAlpha() == 1.0f) goto L48;
        r23 = r10.getAlpha();
        goto L48
    L42:
        r111 = 0.0f;
        goto L44
    L39:
        r23 = 1.0f;
        goto L40
    L35:
        r19 = 0.0f;
        goto L36
    L11:
        if (r12 == 5) goto L24;
        if (r12 != 48) goto L14;
        float r40 = r10.getX();
        OPopoverLayout r41 = this.f7075b;
        if (r41 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L23:
        r13 = r40 + r41.getBubbleOffset();
        r17 = (r10.getY() + r10.getMeasuredHeight()) - r10.getPaddingBottom();
        goto L32
    L14:
        if (r12 == 80) goto L16;
        r13 = 0.0f;
        r17 = 0.0f;
        goto L32
    L16:
        float r42 = r10.getX();
        OPopoverLayout r43 = this.f7075b;
        if (r43 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L19:
        r13 = r42 + r43.getBubbleOffset();
        r14 = r10.getY();
        r16 = r10.getPaddingTop();
        goto L31
    L24:
        r13 = r10.getX();
        r14 = r10.getY();
        r15 = this.f7075b;
        if (r15 != null) goto L30;
        goto L30
    }

    private final void h() {
        ViewGroup r10 = da.f.f8522a.d(this.f7079f);
        if (r10 == null) goto L12;
        Sequence<View> r11 = ViewGroupKt.getChildren(r10);
        if (r11 == null) goto L14;
        Sequence r12 = SequencesKt.filter(r11, OPopover$clearFakeAnchorViewIfNecessary$1.INSTANCE);
        if (r12 == null) goto L15;
        Iterator r13 = r12.iterator();
    L10:
        if (r13.hasNext() == false) goto L16;
        r10.removeView((View) r13.next());
        ea.b.a("OPopover", "remove fake anchor view");
        goto L10
    L16:
        return;
    L15:
        return;
    L14:
        return;
    }

    private final int i() {
        return f7073s.a(this.f7074a);
    }

    private final void k() {
        ViewGroup r10 = this.f7076c;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
    L5:
        r10.setVisibility(0);
        d r11 = this.f7080g;
        if (r11 == null) goto L9;
        r11.a();
        return;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.f7077d == true) goto L6;
        g(false);
        getContentView().removeCallbacks(this.f7088o);
        return;
    }

    public final void j() {
        AnimatorSet r10 = this.f7078e;
        if (r10 == null) goto L5;
        r10.removeAllListeners();
    L5:
        AnimatorSet r11 = this.f7078e;
        if (r11 == null) goto L8;
        r11.cancel();
    L8:
        this.f7078e = null;
        h();
        if (this.f7079f.isFinishing() == true) goto L13;
        if (isShowing() == false) goto L13;
    L18:
        super.dismiss();     // Catch: Exception -> L17
        return;
    L20:
        return;
    L13:
        if (f7072r == true) goto L18;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r10, int r11, int r12, int r13) {
        int r14 = f7073s.a(r13);
        Pair<Integer, Integer> r15 = f(r11, r12);     // Catch: Exception -> L8
        super.showAsDropDown(r10, r11 - r15.getFirst().intValue(), r12 - r15.getSecond().intValue(), r14);     // Catch: Exception -> L8
        this.f7077d = false;     // Catch: Exception -> L8
        if (this.f7084k == false) goto L6;
        g(true);     // Catch: Exception -> L8
    L11:
        return;
    L6:
        k();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ea.b.c("OPopover", "showAsDropDown, error", e);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "anchor");
        int r14 = f7073s.a(r11);
        Pair<Integer, Integer> r15 = f(r12, r13);     // Catch: Exception -> L19
        if (this.f7087n == false) goto L13;
        View r16 = r10.getRootView();     // Catch: Exception -> L19
        Context r17 = r10.getContext();     // Catch: Exception -> L19
        Intrinsics.checkNotNullExpressionValue(r17, "anchor.context");     // Catch: Exception -> L19
        int r18 = com.obric.oui.common.util.f.e(r17);     // Catch: Exception -> L19
        Context r19 = r10.getContext();     // Catch: Exception -> L19
        Intrinsics.checkNotNullExpressionValue(r19, "anchor.context");     // Catch: Exception -> L19
        int r20 = com.obric.oui.common.util.f.d(r19);     // Catch: Exception -> L19
        fa.a r21 = fa.a.f8880a;     // Catch: Exception -> L19
        int r22 = r21.c(r10.getContext());     // Catch: Exception -> L19
        int r23 = r21.b(r10.getContext());     // Catch: Exception -> L19
        Intrinsics.checkNotNullExpressionValue(r16, "anchorViewRoot");     // Catch: Exception -> L19
        if (r16.getWidth() >= r18) goto L8;
        float r24 = (r18 - r16.getWidth()) / 2.0f;     // Catch: Exception -> L19
    L9:
        int r25 = MathKt.roundToInt(r24);     // Catch: Exception -> L19
        if (r16.getHeight() >= r20) goto L12;
        int r26 = ((r20 - r16.getHeight()) + r22) + r23;     // Catch: Exception -> L19
    L14:
        super.showAtLocation(r10, r14, (r12 - r15.getFirst().intValue()) - r25, (r13 - r15.getSecond().intValue()) - r26);     // Catch: Exception -> L19
        this.f7077d = false;     // Catch: Exception -> L19
        if (this.f7084k == false) goto L17;
        g(true);     // Catch: Exception -> L19
        return;
    L17:
        k();     // Catch: Exception -> L19
        return;
    L12:
        r26 = 0;
        goto L14
    L8:
        r24 = 0.0f;
        goto L9
    L13:
        r26 = 0;
        r25 = 0;
    L19:
        e = move-exception;
        ea.b.c("OPopover", "showAtLocation, error", e);
    }
}
